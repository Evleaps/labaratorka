package environment;

import android.app.Activity;
import android.content.Context;

import environment.framework.common.Common;
import environment.framework.fonts.Fonts;
import environment.framework.http.HttpConnect;
import environment.framework.logger.ILogger;
import environment.framework.screen.Screens;
import environment.framework.sound.ISound;
import environment.framework.temp.Temp;
import environment.framework.uihandler.ISender;

/****************************************
 * Author: Novikov Artem
 * Date: 05.05.2018
 * Module name: EnvBuilder
 * Description: Builder for Environment
 ****************************************/
public interface EnvBuilder {
    /****************************************************
    * In concrete builder each function must return new
    * object or null for using in Environment
    *****************************************************/

    Screens buildScreens();

    HttpConnect buildHttp();

    Fonts buildFonts();

    Temp buildTemp(Context context);

    ISound buildSound();

    Common buildCommon();

    ILogger buildLogger();

    ISender buildSender(Activity activity);
}
