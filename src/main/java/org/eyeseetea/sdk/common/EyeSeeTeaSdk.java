package org.eyeseetea.sdk.common;

public class EyeSeeTeaSdk {

    private static EyeSeeTeaSdk mInstance;
    private Transaltor mTransaltor;

    private EyeSeeTeaSdk() {
    }

    public static EyeSeeTeaSdk getInstance() {
        if (mInstance == null) {
            mInstance = new EyeSeeTeaSdk();
        }
        return mInstance;
    }

    public Transaltor getTranslator() {
        return mTransaltor;
    }

    public void init(Transaltor transaltor) {
        mTransaltor = transaltor;
    }
}
