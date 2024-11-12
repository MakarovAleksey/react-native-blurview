package com.reactnativeblurview;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Objects;


public class BlurViewManager extends SimpleViewManager<BlurView> {

    public static final String REACT_CLASS = "BlurView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected BlurView createViewInstance(ThemedReactContext reactContext) {
        return new BlurView(reactContext);
    }

    @ReactProp(name = "blurType")
    public void setBlurType(BlurView view, String blurType) {
        view.setBlurType(blurType);
    }
}