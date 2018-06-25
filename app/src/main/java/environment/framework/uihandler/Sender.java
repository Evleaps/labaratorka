package environment.framework.uihandler;

import android.app.Activity;
import android.os.Message;

import myapp.moydom.ru.myhouse.HouseUIHandler;

/*********************************
 * Author: Novikov Artem
 * Date: 08.06.2018
 * Module name: Sender
 * Description: Implementation
 **********************************/
public class Sender implements ISender {
    private static final String LOG = "Sender";
    private UIHandler mUiHandler;

    public Sender(Activity activity) {
        build(activity);
    }

    @Override
    public void sendUI(int id) {
        Message msg = new Message();
        msg.what = id;
        mUiHandler.sendMessage(msg);
    }

    @Override
    public void build(Activity activity) {
        mUiHandler = new HouseUIHandler(activity);
    }

    @Override
    public void storeData(int id, String data) {
        mUiHandler.storeData(id, data);
    }
}
