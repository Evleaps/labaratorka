package environment;

import android.app.Activity;

import environment.framework.common.Common;
import environment.framework.fonts.Fonts;
import environment.framework.http.HttpConnect;
import environment.framework.logger.ILogger;
import environment.framework.screen.Screens;
import environment.framework.temp.Temp;
import environment.framework.uihandler.ISender;

/**********************************************************
 * Author: Novikov Artem
 * Date: 18.02.2018
 * Module name: Environment
 * Desciprion: Singleton for storing and getting all major
 *             modules of application.
 **********************************************************/

public class Environment {
    private static final String LOG = "Environment";
    private static final Environment ourInstance = new Environment();

    private Screens mScreens;
    private HttpConnect mConnect;
    private Fonts mFonts;
    private Common mCommon;
    private ILogger mLogger;
    private Temp mTemp;
    private ISender mSender;

    public static Environment getInstance() {
        return ourInstance;
    }

    private Environment() {
    }

    // Getters of modules
    public Screens getScreens() {
        return mScreens;
    }

    public HttpConnect lockConnect() {
        if(mConnect != null) {
            HttpConnect res = mConnect;
            mConnect = null;
            return res;
        } else {
            Env.log().e(LOG, "Try to get locking HttpConnect object.");
            return null;
        }
    }

    public void unlockConnect(HttpConnect connect) {
        if(connect == null) {
            Env.log().e(LOG, "Try unlock HttpConnect object by null.");
        } else if(mConnect != null) {
            Env.log().e(LOG, "On unlock try set new HttpConnect object.");
        } else {
            mConnect = connect;
        }
    }

    public Temp getTemp() {
        return mTemp;
    }

    public Common getCommon() {
        return mCommon;
    }

    public ILogger getLogger() {
        return mLogger;
    }

    public Fonts getFonts() {
        return mFonts;
    }

    public ISender getSender() {
        return mSender;
    }

    public void build(EnvBuilder builder, Activity activity) {
        mScreens = builder.buildScreens();
        mConnect = builder.buildHttp();
        mFonts = builder.buildFonts();
        mTemp = builder.buildTemp(activity);
        mCommon = builder.buildCommon();
        mLogger = builder.buildLogger();
        mSender = builder.buildSender(activity);
    }
}
