package myapp.moydom.ru.myhouse.screens;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import environment.Env;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.R;

public class SettingsFragment extends Screen {
    private static final String LOG = "SettingsFragment";

    private Temp tmp;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_settings, container, false);

        tmp = Env.i().getTemp();

        fragment.findViewById(R.id.settings_change_email_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.mSetType = Temp.SettingType.EMAIL;
                getScreens().putCurrent();
                setScreen(ScreenID.PHONE_CODE);
            }
        });

        fragment.findViewById(R.id.settings_change_pswd_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.mSetType = Temp.SettingType.PASSWORD;
                getScreens().putCurrent();
                setScreen(ScreenID.EMAIL_CODE);
            }
        });

        fragment.findViewById(R.id.settings_change_phone_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.mSetType = Temp.SettingType.PHONE;
                getScreens().putCurrent();
                setScreen(ScreenID.EMAIL_CODE);
            }
        });

        return fragment;
    }

}
