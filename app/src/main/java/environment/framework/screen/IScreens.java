package environment.framework.screen;

/*******************************
 * Author: Novikov Artem
 * Date: 10.02.2018
 * Module name: IScreens
 * Last updated: 08.06.2018
 ******************************/

public interface IScreens {
    void setScreen(ScreenID screen);

    boolean setFromStack();

    void putOnStack(ScreenID screen);

    void putCurrent();

    ScreenID getCurrent();

    ScreenID popFromStack();

    void clearStack();
}
