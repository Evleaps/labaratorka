package environment.framework.screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import environment.Environment;

/******************************************************
 * Author: Novikov Artem
 * Date: 10.02.2018
 * Module name: Screen
 * Desciprion: Class describes screen functionality
 ******************************************************/

//TODO: Always make a empty constructor in screen like here
public abstract class Screen extends Fragment {

    public Screen() {
    }

    @Override
    public abstract View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState);

    protected Environment getEnv() {
        return Environment.getInstance();
    }

    /***********************************
    * Just short calling of Environment
    ************************************/
    protected Environment env() {
        return getEnv();
    }

    protected Screens getScreens() {
        return Environment.getInstance().getScreens();
    }

    protected void setScreen(ScreenID screen) {
        Environment.getInstance().getScreens().setScreen(screen);
    }
}
