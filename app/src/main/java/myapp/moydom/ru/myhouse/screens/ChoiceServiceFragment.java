package myapp.moydom.ru.myhouse.screens;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.Env;
import environment.framework.screen.Screen;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.R;

public class ChoiceServiceFragment extends Screen {
    private static final String LOG = "ChoiceServiceFragment";
    private Temp tmp;
    private TextView mDescText;

    public ChoiceServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_choice_service, container, false);

        tmp = Env.i().getTemp();

        mDescText = fragment.findViewById(R.id.choice_service_type);
        String type = null;
        switch (tmp.serviceType) {
            case WATER:
                type = getResources().getString(R.string.service_water);
                break;
            case POWER:
                type = getResources().getString(R.string.service_power);
                break;
            case SERVICE:
                type = getResources().getString(R.string.service_service);
                break;
            default:
                Env.log().e(LOG, "Error state of service");
        }
        mDescText.setText(type);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Выбор услуг / " + type);

        fragment.findViewById(R.id.choice_service_add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().setFromStack();
            }
        });

        return fragment;
    }

}
