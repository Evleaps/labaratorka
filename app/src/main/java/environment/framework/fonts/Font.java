package environment.framework.fonts;

import android.content.res.AssetManager;
import android.graphics.Typeface;

/*****************************************
 * Created by Novikov Artem on 03.02.2018
 * Updated on 08.06.2018
 *****************************************/

public abstract class Font {
    // Weight
    public final static int NORMAL = 0;
    public final static int LIGHT = 1;
    public final static int BOLD = 2;

    // Array for specified type of fonts
    // 0 - normal
    // 1 - light
    // 2 - bold
    protected Typeface mFont[];
    // For indicating having types
    // of font
    // 0 - light
    // 1 - bold
    protected boolean mHave[];

    public Font(AssetManager manager) {
        mHave = new boolean[2];
        mFont = new Typeface[3];
        load(manager);
    }

    public Typeface getFont(int type) {
        //return regular. Regular font must have!
        if(type == NORMAL) {
            return mFont[0];
        }

        //return type of font or regular, if it not having for this font
        if(mHave[type - 1]) {
            return mFont[type];
        } else {
            return mFont[0];
        }

    }

    protected abstract void load(AssetManager manager);

    protected Typeface loadTypeface(String name, AssetManager manager) {
        return Typeface.createFromAsset(manager, name);
    }
}
