package org.eyeseetea.sdk.common;

public class EyeSeeTeaSdkInstance {

    private static EyeSeeTeaSdkInstance mInstance;
    private Transaltor mTransaltor;

    private EyeSeeTeaSdkInstance() {
    }

    public static EyeSeeTeaSdkInstance getInstance() {
        if (mInstance == null) {
            mInstance = new EyeSeeTeaSdkInstance();
        }
        return mInstance;
    }

    public Transaltor getTranslator() {
        return mTransaltor;
    }

    public void initTranslator(Transaltor transaltor) {
        mTransaltor = transaltor;
    }
}
