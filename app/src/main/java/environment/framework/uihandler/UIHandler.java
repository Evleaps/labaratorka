package environment.framework.uihandler;


import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.util.HashMap;

import environment.Env;

/*********************************
 * Author: Novikov Artem
 * Date: 08.06.2018
 * Module name: UIHandler
 * Description: Implementation
 **********************************/
public abstract class UIHandler extends Handler implements IUIHandler {
    private static final String LOG = "UIHandler";

    // UI activity
    protected Activity mActivity;
    protected HashMap<Integer, String> mStore;

    public UIHandler(Activity activity) {
        mActivity = activity;
        mStore = new HashMap<>();
    }

    public abstract boolean handle(int id);

    @Override
    public void storeData(int id, String data) {
        mStore.put(id, data);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        int id = msg.what;

        if(handle(id) == false) {
            Env.log().e(LOG, "No handle case in UIHandler for id = " + id);
        }
    }
}
