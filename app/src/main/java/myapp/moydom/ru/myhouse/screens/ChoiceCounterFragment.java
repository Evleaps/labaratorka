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

public class ChoiceCounterFragment extends Screen {
    private static final String LOG = "ChoiceCounterFragment";
    private Temp tmp;

    public ChoiceCounterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_choice_counter, container, false);

        tmp = Env.i().getTemp();

        switch (tmp.mCounterType) {
            case COLD_WATER:
                ((TextView)fragment.findViewById(R.id.header_destination)).setText("Счетчики / Холодная вода");
                break;
            case HOT_WATER:
                ((TextView)fragment.findViewById(R.id.header_destination)).setText("Счетчики / Горячая вода");
                break;
            case GAS:
                ((TextView)fragment.findViewById(R.id.header_destination)).setText("Счетчики / Газ");
                break;
            case HEATING:
                ((TextView)fragment.findViewById(R.id.header_destination)).setText("Счетчики / Отопление");
                break;
            case POWER:
                ((TextView)fragment.findViewById(R.id.header_destination)).setText("Счетчики / Электроэнергия");
                break;
            default:
                Env.log().e(LOG, "Error state in counters");
        }

        View.OnClickListener nextScreen = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().putCurrent();
                setScreen(ScreenID.COUNTER_INFO);
            }
        };

        fragment.findViewById(R.id.choice_counter_row1).setOnClickListener(nextScreen);
        fragment.findViewById(R.id.choice_counter_row2).setOnClickListener(nextScreen);
        fragment.findViewById(R.id.choice_counter_row3).setOnClickListener(nextScreen);
        fragment.findViewById(R.id.choice_counter_row4).setOnClickListener(nextScreen);

        return fragment;
    }

}
