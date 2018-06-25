package myapp.moydom.ru.myhouse.screens;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class RegisterObjectFragment extends Screen {
    private final static String LOG = "RegisterObjectFragment";

    public RegisterObjectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_register_object, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Добавление нового объекта");

        fragment.findViewById(R.id.register_object_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setScreen(ScreenID.REGISTER_OBJECT_SUCCESS);
            }
        });

        fragment.findViewById(R.id.register_object_user_agree_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().putCurrent();
                setScreen(ScreenID.AGREEMENT);
            }
        });

        return fragment;
    }

}
