package environment.framework.fonts;

import android.content.res.AssetManager;

/*****************************************
 * Created by Novikov Artem on 03.02.2018
 *****************************************/
public class Helvetica extends Font {
    // Path from folder ...app/assets
    private static final String PATH1 = "fonts/HelveticaNeueCyr-Roman.otf";
    private static final String PATH2 = "fonts/HelveticaNeueCyr-Light.otf";
    private static final String PATH3 = "fonts/HelveticaBold.ttf";

    public Helvetica(AssetManager manager) {
        super(manager);
    }

    @Override
    protected void load(AssetManager manager) {
        mHave[0] = true;
        mHave[1] = true;

        mFont[0] = loadTypeface(PATH1, manager);
        mFont[1] = loadTypeface(PATH2, manager);
        mFont[2] = loadTypeface(PATH3, manager);
    }
}
