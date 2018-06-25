package environment.framework.fonts;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

/******************************************
 * Created by Novikov Artem on 03.02.2018.
 ******************************************/

// Class for creating fonts assets
public abstract class Fonts {
    protected Font mFonts[];

    public Fonts(AssetManager manager) {
        init(manager);
    }

    protected abstract void init(AssetManager manager);

    public abstract Typeface getFont(int id, int type);

    // Set font for view with specified ID
    // type - type of font:
    //      0 - normal
    //      1 - light
    //      2 - bold
    public void setFont(View view, int viewId, int fontId, int type) {
        ((TextView)view.findViewById(viewId)).setTypeface(getFont(fontId, type));
    }

    // Set font for several views with specified ID
    public void setFont(View view, int[] viewId, int fontId, int type) {
        for(int i : viewId) {
            setFont(view, i, fontId, type);
        }
    }
}
