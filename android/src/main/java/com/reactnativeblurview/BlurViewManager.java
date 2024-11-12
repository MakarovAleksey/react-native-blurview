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
  private ImageView imageView;
  private String blurType = "light";

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
      addView(blurView);
      applyBlurEffect();
      return blurView;
    }

    @ReactProp(name = "color")
    public void setColor(View view, String color) {
        view.setBackgroundColor(Color.parseColor(color));
    }

    @ReactProp(name = "blurType")
    public void setBlurType(BlurView view, String blurType) {
        view.setBlurType(blurType);
    }


  private void applyBlurEffect() {
    int blurRadius;
    int overlayColor;
    switch (blurType) {
      case "dark":
        blurRadius = 25;
        overlayColor = Color.parseColor("#AA000000");
        break;
      case "extraLight":
        blurRadius = 10;
        overlayColor = Color.parseColor("#66FFFFFF");
        break;
      default:
        blurRadius = 15;
        overlayColor = Color.parseColor("#88FFFFFF");
        break;
    }

    Blurry.with(getContext())
      .radius(blurRadius)
      .color(overlayColor)
      .capture(this)
      .into(imageView);
  }

  public void setBlurType(@Nullable String blurType) {
    this.blurType = blurType;
    applyBlurEffect();
  }
}
