package org.eyeseetea.sdk.common;


import java.io.File;

public class DatabaseUtils {

    /**
     * Databases folder
     */
    private final static String DATABASE_FOLDER = "databases/";


    /**
     * This method returns the databases app folder
     */
    public static File getDatabasesFolder(String packageName) {
        String databasesPath = getAppPath(packageName) + DATABASE_FOLDER;
        File file = new File(databasesPath);
        return file;
    }

    public static File getAppDatabaseFile(String appDatabaseName, String packageName) {
        return new File(getDatabasesFolder(packageName), appDatabaseName + ".db");
    }
    /**
     * This method returns the app path
     */
    public static String getAppPath(String packageName) {
        return "/data/data/" + packageName + "/";

    }

}
