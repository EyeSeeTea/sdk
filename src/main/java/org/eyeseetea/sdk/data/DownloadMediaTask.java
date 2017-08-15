package org.eyeseetea.sdk.data;

import android.os.AsyncTask;
import android.util.Log;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/**
 * AsyncTask that downloads media files
 * Created by arrizabalaga on 28/05/16.
 */
public class DownloadMediaTask extends AsyncTask<List<String>, Void, HashMap<String, String>> {

    public interface Callback {
        void onError(Exception error);

        void onCancelled(Exception mLastError);

        void onSuccess(HashMap<String, String> numSyncedFiles);

        void removeIllegalFile(String uid);
    }

    public static final String QUICKTIME_NON_SUPPORTED_FORMAT = "mov";
    private final String TAG = "DownloadMediaTask";
    private List<String> mUids;
    private Drive mGoogleService;
    private Exception mLastError = null;
    private Callback mCallback;
    private final java.io.File mFilesDir;

    /**
     * Builds a task that requires service credentials
     */
    public DownloadMediaTask(java.io.File filesDir, Drive googleService, List<String> uids, Callback callback) {
        mGoogleService = googleService;
        mUids = uids;
        mCallback = callback;
        mFilesDir = filesDir;
    }

    @Override
    protected HashMap<String, String> doInBackground(List<String>... params) {
        Log.d(TAG, String.format("DownloadMediaTask starts"));
        HashMap<String, String> syncedFiles = new HashMap<>();
        List<String> uidList = params[0];
        //Nothing to sync -> 0
        if (uidList == null || uidList.isEmpty()) {
            Log.d(TAG, String.format("DownloadMediaTask nothing to sync"));
            return null;
        }

        for (String uid : uidList) {
            try {
                String resourcePath = downloadFile(uid);
                syncedFiles.put(uid, resourcePath);
                Log.d(TAG, String.format("DownloadMediaTask file synced"));
            } catch (Exception e) {
                if(e instanceof IllegalStateException){
                    mCallback.removeIllegalFile(uid);
                }
                e.printStackTrace();
                mLastError = e;
                cancel(true);
            }
        }
        return syncedFiles;
    }

    @Override
    protected void onPostExecute(HashMap<String, String>  syncedFiles) {
        mCallback.onSuccess(syncedFiles);
    }

    @Override
    protected void onCancelled() {
        mCallback.onCancelled(mLastError);
    }


    private String downloadFile(String resourceId) throws Exception {
        Log.d(TAG, String.format("Downloading resource: %s ...", resourceId));

        Drive.Files.Get getFile = mGoogleService.files().get(resourceId);
        File fileDrive = getFile.execute();
        Log.d(TAG, "\tfilename: " + fileDrive.getName());

        if (fileDrive.getName().endsWith(QUICKTIME_NON_SUPPORTED_FORMAT)) {
            throw new IllegalStateException(
                    String.format("%s format not supported in Android", fileDrive.getName()));
        }

        java.io.File localFile = new java.io.File(mFilesDir,
                fileDrive.getName());
        FileOutputStream fileOutputStream = new FileOutputStream(localFile);
        getFile.executeMediaAndDownloadTo(fileOutputStream);
        fileOutputStream.close();
        return localFile.getAbsolutePath();
    }
}
