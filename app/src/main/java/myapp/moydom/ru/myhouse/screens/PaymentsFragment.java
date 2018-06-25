package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import myapp.moydom.ru.myhouse.R;

public class PaymentsFragment extends Screen {
    private static final String LOG = "PaymentsFragment";

    private ScrollView mScroll;

    public PaymentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragment = inflater.inflate(R.layout.fragment_payments, container, false);

        ((TextView)fragment.findViewById(R.id.header_destination)).setText("Оплаты");
        mScroll = fragment.findViewById(R.id.payments_scroll);

        View.OnClickListener showExplan = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View infoContainer = fragment.findViewById(R.id.payments_explan_wrapper);
                infoContainer.setVisibility(View.VISIBLE);
                int x = (int)infoContainer.getX();
                int y = (int)infoContainer.getY();
                mScroll.scrollBy(x, y);
            }
        };

        fragment.findViewById(R.id.payments_calendar_january).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_february).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_march).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_april).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_may).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_june).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_july).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_august).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_september).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_october).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_november).setOnClickListener(showExplan);
        fragment.findViewById(R.id.payments_calendar_december).setOnClickListener(showExplan);

        View.OnClickListener toExplan = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreens().putCurrent();
                setScreen(ScreenID.EXPLANATION);
            }
        };
        fragment.findViewById(R.id.payments_all_info_invoice_container).setOnClickListener(toExplan);
        fragment.findViewById(R.id.payments_to_service_btn).setOnClickListener(toExplan);

        return fragment;
    }

}
