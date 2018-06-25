package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.Env;
import environment.Environment;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.R;

public class EmailCodeFragment extends Screen {
    private static final String LOG = "EmailCodeFragment";
    private Temp tmp;
    private TextView mTextDesc;

    public EmailCodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_email_code, container, false);

        tmp = Env.i().getTemp();
        mTextDesc = fragment.findViewById(R.id.email_code_desc);
        switch (tmp.mSetType) {
            case PHONE:
                mTextDesc.setText(getContext().getResources().getString(R.string.change_phone));
                break;
            case PASSWORD:
                mTextDesc.setText(getContext().getResources().getString(R.string.change_password));
                break;
        }

        fragment.findViewById(R.id.email_code_enter_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setScreen(ScreenID.SETTINGS_SECOND);
            }
        });

        fragment.findViewById(R.id.email_code_send_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.alert("Повторная отправка", getContext());
            }
        });

        return fragment;
    }

}
