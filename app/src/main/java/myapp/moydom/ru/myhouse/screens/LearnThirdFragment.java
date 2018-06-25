package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class LearnThirdFragment extends Screen {
    private static final String LOG = "LearnThirdFragment";

    public LearnThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_learn_third, container, false);
        //((TextView)fragment.findViewById(R.id.header_destination)).setText("Вход / Личный кабинет");

        fragment.findViewById(R.id.learn_third_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().clearStack();
                setScreen(ScreenID.START);
            }
        });
        return fragment;
    }

}
