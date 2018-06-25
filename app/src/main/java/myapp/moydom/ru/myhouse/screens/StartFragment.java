package myapp.moydom.ru.myhouse.screens;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.Env;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;
import myapp.moydom.ru.myhouse.auth.AuthState;

public class StartFragment extends Screen {
    private static final String LOG = "StartFragment";

    public StartFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_start, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("");
        // Выход из ЛК при возвращении назад
        AuthState.getInstance().logOut();

        fragment.findViewById(R.id.start_auth_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().putCurrent();
                setScreen(ScreenID.AUTH);
            }
        });

        fragment.findViewById(R.id.start_register_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().putCurrent();
                setScreen(ScreenID.REGISTER);
            }
        });

        return fragment;
    }

}
