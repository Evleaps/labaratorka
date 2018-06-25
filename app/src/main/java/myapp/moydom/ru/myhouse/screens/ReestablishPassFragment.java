package myapp.moydom.ru.myhouse.screens;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class ReestablishPassFragment extends Screen {
    private static final String LOG = "ReestablishPassFragment";

    public ReestablishPassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_reestablish_pass, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Вход / Восстановление пароля");

        fragment.findViewById(R.id.reestab_pass_enter_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setScreen(ScreenID.PHONE_CODE);
            }
        });
        return fragment;
    }

}
