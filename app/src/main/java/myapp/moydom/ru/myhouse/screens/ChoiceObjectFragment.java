package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class ChoiceObjectFragment extends Screen {
    private static final String LOG = "ChoiceObjectFragment";

    public ChoiceObjectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_choice_object, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText(" Вход / Личный кабинет");

        fragment.findViewById(R.id.object_row2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().putCurrent();
                setScreen(ScreenID.INVOICE);
            }
        });

        fragment.findViewById(R.id.object_add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().putCurrent();
                setScreen(ScreenID.REGISTER_OBJECT);
            }
        });

        return fragment;
    }

}
