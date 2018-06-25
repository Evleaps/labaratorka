package myapp.moydom.ru.myhouse;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

import environment.Env;
import environment.framework.screen.ScreenID;
import environment.framework.uihandler.UIHandler;

import static environment.Constants.UI_AUTH_SUCCESS;
import static environment.Constants.UI_REGISTER_SUCCESS;

/******************************************************
 * Author: Novikov Artem
 * Date: 08.06.2018
 * Module name: HouseUIHandler
 * Description: Обработчик результатов запросов на UI
 ******************************************************/
public class HouseUIHandler extends UIHandler {
    private static final String LOG = "HouseUIHandler";

    public HouseUIHandler(Activity activity) {
        super(activity);
    }

    @Override
    public boolean handle(int id) {
        boolean res = true;
        String data = null;
        JSONObject json = null;
        switch (id) {
            case UI_REGISTER_SUCCESS:
                data = mStore.get(id);
                try {
                    json = new JSONObject(data);
                } catch (JSONException e) {
                    Env.log().e(LOG, "Error while parsing JSON result of REGISTER request (data: " + data + ")");
                    e.printStackTrace();
                }
                if(json != null) {
                    Env.log().i(LOG, "Success register request");
                    Env.i().getScreens().setScreen(ScreenID.PHONE_CODE);
                }
                break;
            default:
                res = false;
        }
        return res;
    }
}
