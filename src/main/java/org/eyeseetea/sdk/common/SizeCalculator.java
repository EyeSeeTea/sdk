package org.eyeseetea.sdk.common;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Created by ignac on 04/08/2017.
 */

public class SizeCalculator {

    public static String getSizeInMB(String filename) {
        String size = "0";
        try {
            File file = new File(filename);
            double fileSizeInBytes;
            if (file.exists()) {
                fileSizeInBytes = file.length();
            } else {
                fileSizeInBytes = FileUtils.getAssetFileDescriptorFromRaw(filename).getLength();
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

    private String removePathFromName(String filename) {
        return filename.substring(filename.lastIndexOf("/") + 1);
    }
}
