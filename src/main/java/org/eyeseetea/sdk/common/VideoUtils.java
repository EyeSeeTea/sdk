package org.eyeseetea.sdk.common;


import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.io.File;

public class VideoUtils {

    public static Bitmap getVideoPreview(String path, Context context) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        File mediaFile = new File(path);
        if (!mediaFile.exists()) {//load from raw
            AssetFileDescriptor afd = FileUtils.getAssetFileDescriptorFromRaw(
                    path, context);
            retriever.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        } else {
            retriever.setDataSource(mediaFile.getAbsolutePath());
        }
        try {
            return retriever.getFrameAtTime(10000000, MediaMetadataRetriever.OPTION_CLOSEST);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
