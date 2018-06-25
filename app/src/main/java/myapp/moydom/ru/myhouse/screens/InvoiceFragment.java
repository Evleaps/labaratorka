package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class InvoiceFragment extends Screen {
    private static final String LOG = "InvoiceFragment";

    public InvoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_invoice, container, false);
        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Начисления за год");

        fragment.findViewById(R.id.invoice_calendar_january).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_february).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_march).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_april).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_may).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_june).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_july).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_august).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_september).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_october).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_november).setOnClickListener(showExplan);
        fragment.findViewById(R.id.invoice_calendar_december).setOnClickListener(showExplan);

        return fragment;
    }

    private View.OnClickListener showExplan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getScreens().putCurrent();
            setScreen(ScreenID.EXPLANATION);
        }
    };
}
