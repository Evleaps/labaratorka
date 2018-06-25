package myapp.moydom.ru.myhouse.screens;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class AgreeFragment extends Screen {
    private static final String LOG = "AgreeFragment";

    public AgreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_agree, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("");

        fragment.findViewById(R.id.agree_accept_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().setFromStack();
            }
        });

        return fragment;
    }

}
