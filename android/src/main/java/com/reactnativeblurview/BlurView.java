import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

import jp.wasabeef.blurry.Blurry;

public class BlurView extends ReactViewGroup {
    
    private ImageView imageView;
    private String blurType = "light";

    public BlurView(ThemedReactContext context) {
        super(context);

        imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        addView(imageView);
        
        applyBlurEffect();
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