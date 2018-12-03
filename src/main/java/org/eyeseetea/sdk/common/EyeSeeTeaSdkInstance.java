package org.eyeseetea.sdk.common;

public class EyeSeeTeaSdkInstance {

    private static EyeSeeTeaSdkInstance mInstance;
    private Transaltor mTransaltor;


    public static EyeSeeTeaSdkInstance getInstance() {
        if (mInstance == null) {
            mInstance = new EyeSeeTeaSdkInstance();
        }
        return mInstance;
    }

    public Transaltor getTransaltor() {
        return mTransaltor;
    }

    public void setTransaltor(Transaltor transaltor) {
        mTransaltor = transaltor;
    }
}
