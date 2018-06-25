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

public class CountersFragment extends Screen {
    private static final String LOG = "CountersFragment";
    private Temp tmp;

    public CountersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_counters, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Счетчики");

        tmp = Env.i().getTemp();

        fragment.findViewById(R.id.counters_cold_water_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.mCounterType = Temp.Counter.COLD_WATER;
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_COUNTER);
            }
        });

        fragment.findViewById(R.id.counters_hot_water_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.mCounterType = Temp.Counter.HOT_WATER;
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_COUNTER);
            }
        });

        fragment.findViewById(R.id.counters_gas_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.mCounterType = Temp.Counter.GAS;
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_COUNTER);
            }
        });

        fragment.findViewById(R.id.counters_heating_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.mCounterType = Temp.Counter.HEATING;
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_COUNTER);
            }
        });

        fragment.findViewById(R.id.counters_power_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.mCounterType = Temp.Counter.POWER;
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_COUNTER);
            }
        });

        return fragment;
    }

}
