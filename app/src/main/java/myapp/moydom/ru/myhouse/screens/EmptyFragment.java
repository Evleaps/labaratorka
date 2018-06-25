package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;

import environment.Env;
import environment.Environment;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class EmptyFragment extends Screen {
    private static final String LOG = "EmptyFragment";

    private static final long START_DELAY = 3000;

    private Timer mTimer;

    public EmptyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_empty, container, false);

        mTimer = new Timer(true);
        mTimer.scheduleAtFixedRate(new NextTask(), START_DELAY, 1);

        return fragment;
    }

    // TimerTask - код, который выполняется после срабатывания таймера
    private class NextTask extends TimerTask {

        @Override
        public void run() {
            Env.log().i(LOG, "timer");
            mTimer.cancel();
            setScreen(ScreenID.LEARN_SECOND);
        }
    }
}
