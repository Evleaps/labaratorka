package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import environment.Env;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.R;

public class OtherFragment extends Screen {
    private static final String LOG = "OtherFragment";
    private Temp tmp;
    public OtherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_other, container, false);

        tmp = Env.i().getTemp();

        fragment.findViewById(R.id.other_water_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.serviceType = Temp.Service.WATER;
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_SERVICE);
            }
        });

        fragment.findViewById(R.id.other_power_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.serviceType = Temp.Service.POWER;
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_SERVICE);
            }
        });

        fragment.findViewById(R.id.other_service_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp.serviceType = Temp.Service.SERVICE;
                getScreens().putCurrent();
                setScreen(ScreenID.CHOICE_SERVICE);
            }
        });

        fragment.findViewById(R.id.other_send_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.alert("Заявка на обслуживание отправлена", getContext());
                getScreens().setFromStack();
            }
        });

        return fragment;
    }

}
