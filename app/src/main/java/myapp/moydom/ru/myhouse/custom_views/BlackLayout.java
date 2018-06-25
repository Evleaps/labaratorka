package myapp.moydom.ru.myhouse.custom_views;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/*********************************************
 * Author: Novikov Artem
 * Date: 25.05.2018
 * Module name: BlackLayout
 * Description: Black background LinearLayout
 *********************************************/
public class BlackLayout extends LinearLayout {
    public BlackLayout(Context context) {
        super(context);
        setStyles(context);
    }

    public BlackLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setStyles(context);
    }

    public BlackLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setStyles(context);
    }

    void setStyles(Context context) {
        setBackgroundColor(Color.BLACK);
    }
}
