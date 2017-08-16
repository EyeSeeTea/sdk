/*
 * Copyright (c) 2017.
 *
 * This file is part of QA App.
 *
 *  Health Network QIS App is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Health Network QIS App is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.eyeseetea.sdk.common;


import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;

public class FileUtils {

    /**
     * This method copy a file in other file
     */
    public static void copyFile(File current, File backup) throws IOException {
        if (current.exists()) {
            FileChannel src = new FileInputStream(current)
                    .getChannel();
            FileChannel dst = new FileOutputStream(backup)
                    .getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
        }
    }

    public static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {
        FileOutputStream outputStream = new FileOutputStream(file);
        try {
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, len);
            }
        } finally {
            outputStream.close();
            inputStream.close();
        }
    }

    private static String getRawPath(String filename, String packageName) {
        return String.format("android.resource://%s/raw/%s",
                removeExtension(packageName), filename);
    }

    public static Uri getRawUri(String filename, String packageName) {
        Uri url = Uri.parse(String.format("android.resource://%s/raw/%s",
                packageName, removeExtension(filename)));
        return url;
    }

    public static AssetFileDescriptor getAssetFileDescriptorFromRaw(String filename,
            Context context) {
        AssetFileDescriptor afd = context.getResources().openRawResourceFd(
                getRawIdentifier(filename, context));
        return afd;
    }

    private static int getRawIdentifier(String filename, Context context) {
        if (filename.contains(".")) {
            filename = FileUtils.removeExtension(filename);
        }
        return context.getResources().getIdentifier(filename, "raw",
                context.getPackageName());
    }

    private static String removeExtension(String filename) {
        return filename.substring(0, filename.lastIndexOf("."));
    }

    public static void removeFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
            System.out.println("File removed " + path);
        }
    }

    public static String getSizeInMB(String filename, Context context) {
        String size = "0";
        try {
            File file = new File(filename);
            double fileSizeInBytes;
            if (file.exists()) {
                fileSizeInBytes = file.length();
            } else {
                fileSizeInBytes = FileUtils.getAssetFileDescriptorFromRaw(filename,
                        context).getLength();
            }
            // Get length of file in bytes
            // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
            double fileSizeInKB = fileSizeInBytes / 1024.0;
            // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
            double fileSizeInMB = fileSizeInKB / 1024.0;
            if (fileSizeInKB < 1024.0) {
                size = fixDecimals(fileSizeInMB, "0.000");
            } else {
                size = fixDecimals(fileSizeInMB, "#.0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return size + " MB";
    }

    private static String fixDecimals(double fileSizeInMB, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(fileSizeInMB);
    }

    public static String removePathFromName(String filename) {
        return filename.substring(filename.lastIndexOf("/") + 1);
    }
}
