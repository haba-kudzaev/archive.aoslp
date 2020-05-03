package o1310.rx1310.aoslp;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

public class LauncherRootView extends InsettableFrameLayout {
    public LauncherRootView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        setInsets(insets);
        return true; // I'll take it from here
    }
}