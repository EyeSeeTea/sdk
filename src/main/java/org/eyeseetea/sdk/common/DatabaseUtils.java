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
    public static File getDatabasesFolder() {
        String databasesPath = getAppPath() + DATABASE_FOLDER;
        File file = new File(databasesPath);
        return file;
    }

    public static File getAppDatabaseFile() {
        if (ExternalAppConstants.getAppDatabaseName() == null) {
            throw new IllegalArgumentException("You have to call ExternalAppConstants init() method first");
        }
        return new File(getDatabasesFolder(), ExternalAppConstants.getAppDatabaseName() + ".db");
    }
    /**
     * This method returns the app path
     */
    public static String getAppPath() {
        if (ExternalAppConstants.getPackageName() == null) {
            throw new IllegalArgumentException("You have to call ExternalAppConstants init() method first");
        }
        return "/data/data/" + ExternalAppConstants.getPackageName() + "/";

    }

}
