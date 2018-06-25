package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import environment.Env;
import environment.Environment;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.R;
import myapp.moydom.ru.myhouse.auth.AuthState;

public class PhoneCodeFragment extends Screen {
    private static final String LOG = "PhoneCodeFragment";
    private static final int START_DELAY = 7000;

    private Timer mTimer;
    private Temp tmp;
    private TextView mDestText;
    private Button mAcceptCode;

    // Для блокирования повторной отправки
    // запроса на регистрацию при повторном нажатии
    // кнопки
    private boolean mRegisterSend;

    public PhoneCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_phone_code, container, false);

        tmp = Env.i().getTemp();

        mAcceptCode = fragment.findViewById(R.id.phone_code_enter_btn);
        mDestText = fragment.findViewById(R.id.header_destination);

        switch (tmp.mSetType) {
            case REGISTRATION:
                mDestText.setText("Регистрация / Подтверждение телефона");

                mAcceptCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Env.alert("Пожалуйста, подождите...", getContext());
                        if(mRegisterSend == false) {
                            mTimer = new Timer(true);
                            mTimer.scheduleAtFixedRate(new NextTask(), START_DELAY, 1);
                            mRegisterSend = true;
                        }
                    }
                });
                break;
            case EMAIL:
                mDestText.setText("Настройки / Смена e-mail");

                mAcceptCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setScreen(ScreenID.SETTINGS_SECOND);
                    }
                });
                break;
            case REESTABLISH_PASS:
                mDestText.setText("Настройки / Восстановление пароля");

                mAcceptCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getScreens().setFromStack();//setScreen(ScreenID.START);
                    }
                });
                break;
            default:
                Env.log().e(LOG, "Error state on PhoneCode Screen");
        }

        fragment.findViewById(R.id.phone_code_send_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.alert("Повторная отправка", getContext());
            }
        });

        return fragment;
    }

    // Таймер
    private class NextTask extends TimerTask {

        @Override
        public void run() {
            mTimer.cancel();
            AuthState.getInstance().auth(null, null, null);
            Env.i().getScreens().setScreen(ScreenID.REGISTER_OBJECT);
        }
    }
}
