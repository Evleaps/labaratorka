package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import environment.Env;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import environment.framework.tools.TextContainer;
import myapp.moydom.ru.myhouse.R;

import static environment.Constants.EMAIL;
import static environment.Constants.NAME;
import static environment.Constants.NUMBER;
import static environment.Constants.PASSWORD;
import static environment.Constants.PROGRAM;

public class RegisterFragment extends Screen {
    private static final String LOG = "RegisterFragment";

    private Temp tmp;
    private EditText mNameEdit;
    private EditText mNumberEdit;
    private EditText mEmailEdit;
    private EditText mPassEdit;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_register, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Регистрация");

        tmp = Env.i().getTemp();

        mNameEdit = fragment.findViewById(R.id.register_fio_edit);
        mNumberEdit = fragment.findViewById(R.id.register_number_edit);
        mEmailEdit = fragment.findViewById(R.id.register_email_edit);
        mPassEdit = fragment.findViewById(R.id.register_password_edit);

        mNameEdit.addTextChangedListener(new TextContainer(tmp.registerUser, NAME));
        mNumberEdit.addTextChangedListener(new TextContainer(tmp.registerUser, NUMBER));
        mEmailEdit.addTextChangedListener(new TextContainer(tmp.registerUser, EMAIL));
        mPassEdit.addTextChangedListener(new TextContainer(tmp.registerUser, PASSWORD));

        fragment.findViewById(R.id.register_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.i().getTemp().mSetType = Temp.SettingType.REGISTRATION;
                if(PROGRAM && checkData()) {
                    tmp.mApi.register();
                    //setScreen(ScreenID.PHONE_CODE);
                } else if(PROGRAM == false) {
                    setScreen(ScreenID.PHONE_CODE);
                }
            }
        });

        return fragment;
    }

    private boolean checkData() {
        boolean res = true;
        Bundle data = tmp.registerUser;

        String name = data.getString(NAME);
        String number = data.getString(NUMBER);
        String password = data.getString(PASSWORD);

        do {
            if(name == null) {
                Env.alert("Введите ФИО", getContext());
                res = false;
                break;
            } else if(name.length() < 3) {
                Env.alert("Слишком короткое имя", getContext());
                res = false;
                break;
            }
            if (number != null) {
                int len = number.length();
                char[] charArray = number.toCharArray();
                switch (len) {
                    case 10:
                        break;
                    case 11:
                        if (number.toCharArray()[0] != '8') {
                            res = false;
                        }
                        break;
                    case 12:
                        if (charArray[0] != '+' || charArray[1] != '7') {
                            res = false;
                        }
                        break;
                    default:
                        res = false;
                }
                if (!res) {
                    Env.alert("Введите правильный номер телефона", getContext());
                    break;
                } else {
                    if(!Env.i().getCommon().isDigits(charArray)) {
                        Env.alert("Введите правильный номер телефона", getContext());
                        break;
                    }
                }
            } else {
                Env.alert("Введите номер телефона", getContext());
                break;
            }

            if (password != null) {
                if (res) {
                    int passLen = password.length();
                    if (passLen < 6) {
                        res = false;
                        Env.alert("Слишком короткий пароль", getContext());
                        break;
                    }
                    if(passLen > 30) {
                        res = false;
                        Env.alert("Слишком длинный пароль", getContext());
                        break;
                    }
                }
            } else {
                Env.alert("Введите пароль", getContext());
            }
        } while(false);

        return res;
    }

}
