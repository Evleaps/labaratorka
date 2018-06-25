package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import environment.Env;
import environment.Environment;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.R;

public class SettingsSecondFragment extends Screen {
    private static final String LOG = "SettingsSecondFragment";
    private Temp tmp;
    private TextView mTextHead;
    private Button mAcceptBtn;

    public SettingsSecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_settings_second, container, false);

        tmp = Env.i().getTemp();
        mTextHead = fragment.findViewById(R.id.settings_second_change_head);
        mAcceptBtn = fragment.findViewById(R.id.settings_second_change_btn);

        switch (tmp.mSetType) {
            case PASSWORD:
                mTextHead.setText(getResources().getString(R.string.change_pass_head));
                mAcceptBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Env.alert("Пароль сменен", getContext());
                        getScreens().clearStack();
                        setScreen(ScreenID.START);
                    }
                });
                break;
            case PHONE:
                mTextHead.setText(getResources().getString(R.string.change_phone_head));
                mAcceptBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Env.alert("Телефон сменен", getContext());
                        getScreens().clearStack();
                        setScreen(ScreenID.START);
                    }
                });
                break;
            case EMAIL:
                mTextHead.setText(getResources().getString(R.string.change_email_head));
                mAcceptBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Env.alert("E-mail сменен", getContext());
                        getScreens().clearStack();
                        setScreen(ScreenID.START);
                    }
                });
                break;
        }


        return fragment;
    }

}
