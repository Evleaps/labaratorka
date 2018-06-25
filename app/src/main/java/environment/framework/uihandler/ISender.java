package environment.framework.uihandler;

import android.app.Activity;

/*******************************************
 * Author: Novikov Artem
 * Date: 08.06.2018
 * Module name: ISender
 * Description: Sends messages to UIHandler
 *******************************************/
public interface ISender {

    // Send message with specified id
    void sendUI(int id);

    // Build new UIHandler
    void build(Activity activity);

    // Translate data in store in UIHandler
    void storeData(int id, String data);
}
