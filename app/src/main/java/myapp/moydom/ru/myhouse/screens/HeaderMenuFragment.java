package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import environment.Env;
import myapp.moydom.ru.myhouse.R;

public class HeaderMenuFragment extends Fragment {

    public HeaderMenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragment = inflater.inflate(R.layout.fragment_header_menu, container, false);

        // Нажатие на стрелку - переход назад
        fragment.findViewById(R.id.header_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Env.i().getScreens().setFromStack();
            }
        });

        // Кнопка меню
        fragment.findViewById(R.id.header_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerLayout)getActivity().findViewById(R.id.drawer_layout_main)).openDrawer(Gravity.LEFT);
            }
        });

        return fragment;
    }

}
