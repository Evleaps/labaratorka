package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.Env;
import environment.framework.screen.Screen;
import myapp.moydom.ru.myhouse.R;

public class CounterInfoFragment extends Screen {
    private static final String LOG = "CounterInfoFragment";

    public CounterInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_counter_info, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Счетчики / Здесь что-то конкретное");

        fragment.findViewById(R.id.counter_info_send_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.alert("Данные отправлены", getContext());
            }
        });

        return fragment;
    }

}
