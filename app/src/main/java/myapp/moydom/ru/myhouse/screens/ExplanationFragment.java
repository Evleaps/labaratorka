package myapp.moydom.ru.myhouse.screens;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.Env;
import environment.Environment;
import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class ExplanationFragment extends Screen {
    private static final String LOG = "ExplanationFragment";

    public ExplanationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_explanation, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Начисления / Месяц");

        fragment.findViewById(R.id.explan_pay_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.alert("Переход по ссылке на оплату", getContext());
            }
        });

        View.OnClickListener showPush = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.alert("Услуга детализации начислений на данный момент недоступна", getContext());
            }
        };

        fragment.findViewById(R.id.explan_row1).setOnClickListener(showPush);
        fragment.findViewById(R.id.explan_row2).setOnClickListener(showPush);
        fragment.findViewById(R.id.explan_row3).setOnClickListener(showPush);

        fragment.findViewById(R.id.explan_debt_block).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Удаляем экран Invoice с вершины
                //getScreens().popFromStack();
                getScreens().putCurrent();
                getScreens().setScreen(ScreenID.PAYMENTS);
            }
        });

        return fragment;
    }

}
