package environment.framework.fonts;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import environment.Env;

/******************************************
 * Created by Novikov Artem on 03.02.2018
 * Updated on 08.06.2018
 ******************************************/
// Example
public class CFonts extends Fonts {
    private static final String LOG = "CFonts";
    //Count of fonts
    public static final int COUNT = 1;
    //Fonts
    //public static final int LATO = 0;
    public static final int HELVETICA = 0;
    // static final int ROBOTO = 2;

    public CFonts(AssetManager manager) {
        super(manager);
    }

    @Override
    protected void init(AssetManager manager) {
        mFonts = new Font[COUNT];

        //mFonts[LATO] = new Lato(manager);
        mFonts[HELVETICA] = new Helvetica(manager);
        //mFonts[ROBOTO] = new Roboto(manager);
    }

    @Override
    public Typeface getFont(int id, int type) {
        if(id < 0 || id >= COUNT) {
            Env.log().e(LOG, "Unexpected id of font (id: " + id + ", type: " + type + ")");
        }
        return mFonts[id].getFont(type);
    }
}
