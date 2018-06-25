package environment;

import android.content.Context;
import android.widget.Toast;

import environment.framework.logger.ILogger;

/**************************************************
 * Author: Novikov Artem
 * Date: 24.03.2018
 * Module name: Env
 * Desciprion: Class for fast getting Environment
 **************************************************/

public class Env {
    public static final String LOG = "Env";

    public static ILogger log() {
        return Env.i().getLogger();
    }

    // Returns instance of Environment object
    public static Environment i() {
        return Environment.getInstance();
    }

    // Make toast message
    public static void alert(String info, Context context) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
    }

}
