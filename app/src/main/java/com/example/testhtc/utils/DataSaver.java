package com.example.testhtc.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class DataSaver implements LifecycleEventObserver {

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void saveData() {

    }

}
