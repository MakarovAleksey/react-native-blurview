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

import jp.wasabeef.blurry.Blurry;

public class BlurViewManager extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "BlurView";

    @Override
    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    @NonNull
    public View createViewInstance(ThemedReactContext reactContext) {
      ImageView blurView = new ImageView(reactContext);
      View decorView = Objects.requireNonNull(reactContext.getCurrentActivity()).getWindow().getDecorView();
      ViewGroup rootView = decorView.findViewById(android.R.id.content);
      Blurry.with(reactContext).radius(12).sampling(8).color(Color.argb(178,0,0,0)).capture(rootView).into(blurView);
      return blurView;
    }

    @ReactProp(name = "backgroundColor")
    public void setColor(View view, String color) {
        view.setBackgroundColor(Color.parseColor(color));
    }
}
