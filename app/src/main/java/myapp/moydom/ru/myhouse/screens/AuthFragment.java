package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.Env;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.R;
import myapp.moydom.ru.myhouse.auth.AuthState;

public class AuthFragment extends Screen {
    private static final String LOG = "AuthFragment";

    public AuthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_auth, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Вход");

        fragment.findViewById(R.id.auth_enter_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthState.getInstance().auth(null, null, null);
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_OBJECT);
            }
        });

        fragment.findViewById(R.id.auth_reestablish_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.i().getTemp().mSetType = Temp.SettingType.REESTABLISH_PASS;
                setScreen(ScreenID.REESTABLISH_PASSWORD);
            }
        });

        return fragment;
    }

}
