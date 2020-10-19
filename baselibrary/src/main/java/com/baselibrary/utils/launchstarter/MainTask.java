package com.baselibrary.utils.launchstarter;

public abstract class MainTask extends Task {

    @Override
    public boolean runOnMainThread() {
        return true;
    }

}
