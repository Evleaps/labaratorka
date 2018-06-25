package environment.framework.screen;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

import environment.Env;

/********************************************
 * Created by Novikov Artem on 10.02.2018.
 * Updated on 08.06.2018 at 12:04.
 ********************************************/

public abstract class Screens implements IScreens {
    private static final String LOG = "Screens";
    private FragmentManager manager;
    private int container;

    private ScreenID mCurrentScreen;
    private Stack<ScreenID> mStack;

    public Screens(FragmentManager manager, int container) {
        this.manager = manager;
        this.container = container;

        mStack = new Stack<>();
    }

    @Override
    public void setScreen(ScreenID screen) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, parseScreen(screen));
        transaction.commitAllowingStateLoss();
        mCurrentScreen = screen;
        Env.log().i(LOG, "Set screen: " + screen.toString());
    }

    @Override
    public boolean setFromStack() {
        boolean res = false;

        if(!mStack.isEmpty()) {
            setScreen(mStack.pop());
            res = true;
        }
        return res;
    }

    @Override
    public void putOnStack(ScreenID screen) {
        mStack.push(screen);
    }

    @Override
    public void putCurrent() {
        mStack.push(mCurrentScreen);
    }

    @Override
    public ScreenID getCurrent() {
        return mCurrentScreen;
    }

    @Override
    public void clearStack() {
        mStack.clear();
    }

    @Override
    public ScreenID popFromStack() {
        if(mStack.isEmpty()) {
            return null;
        } else {
            return mStack.pop();
        }
    }

    protected abstract Screen parseScreen(ScreenID screen);
}
