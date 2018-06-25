package environment.framework.uihandler;

/****************************************
 * Author: Novikov Artem
 * Date: 08.06.2018
 * Module name: IUIHandler
 * Description: Handles messages for UI
 *              from other threads
 ****************************************/
public interface IUIHandler {

    // Starts functionality for specified id
    // Returns true in case of success
    // and false else
    boolean handle(int id);

    void storeData(int id, String data);
}
