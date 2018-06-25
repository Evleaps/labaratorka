package environment;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import environment.framework.common.Common;
import environment.framework.fonts.Fonts;
import environment.framework.http.HttpConnect;
import environment.framework.logger.ILogger;
import environment.framework.logger.Logger;
import environment.framework.screen.Screens;
import environment.framework.sound.ISound;
import environment.framework.temp.Temp;
import environment.framework.uihandler.ISender;
import myapp.moydom.ru.myhouse.MyHouseScreens;
import myapp.moydom.ru.myhouse.R;

/*************************************************
 * Author: Novikov Artem
 * Date: 05.05.2018
 * Module name: PbaEnvBuilder
 * Description: Environment builder for MyHouse app
 *************************************************/
public class MyHouseBuilder implements EnvBuilder {
    private AppCompatActivity mActivity;

    public MyHouseBuilder(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public Screens buildScreens() {
        return new MyHouseScreens(mActivity.getSupportFragmentManager(), R.id.activity_main);
    }

    @Override
    public HttpConnect buildHttp() {
        return new HttpConnect();
    }

    @Override
    public Fonts buildFonts() {
        return null;//new CFonts(mActivity.getAssets());
    }

    @Override
    public Temp buildTemp(Context context) {
        return new Temp(context);
    }

    @Override
    public ISound buildSound() {
        return null;//new Sound(MainActivity.SOUND_CHANNELS, mActivity.getAssets());
    }

    @Override
    public Common buildCommon() {
        return new Common();
    }

    @Override
    public ILogger buildLogger() {
        return new Logger(mActivity);
    }

    @Override
    public ISender buildSender(Activity activity) {
        return null;
    }
}
