package myapp.moydom.ru.myhouse.screens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import environment.Env;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.R;
import myapp.moydom.ru.myhouse.auth.AuthState;

import static myapp.moydom.ru.myhouse.auth.AuthState.State.AUTHORIZATED;

public class MenuFragment extends Fragment {
    private static final String LOG = "MenuFragment";
    private Temp tmp;
    private TextView mNameText;
    private TextView mAdressText;
    //private TextView mCityText;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_menu, container, false);

        mNameText = fragment.findViewById(R.id.menu_user_name);
        //mCityText = fragment.findViewById(R.id.menu_user_city);
        mAdressText = fragment.findViewById(R.id.menu_user_address);
        tmp = Env.i().getTemp();

        mNameText = fragment.findViewById(R.id.menu_user_name);
        //mCityText = fragment.findViewById(R.id.menu_user_city);
        mAdressText = fragment.findViewById(R.id.menu_user_address);

        if(AuthState.getInstance().state == AUTHORIZATED) {
            mNameText.setText("Андрей Павлович\nАстафьев");
            //mCityText.setText("Краснодар");
            mAdressText.setText("г. Москва\nул. Тверская, дом 1, кв. 12");
        } else {
            mNameText.setText("Вход не выполнен");
            //mCityText.setText("");
            mAdressText.setText("");
        }

        fragment.findViewById(R.id.menu_item1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AuthState.getInstance().state == AUTHORIZATED) {
                    Env.i().getScreens().clearStack();
                    Env.i().getScreens().putOnStack(ScreenID.START);
                    Env.i().getScreens().setScreen(ScreenID.CHOICE_OBJECT);
                    ((DrawerLayout) getActivity().findViewById(R.id.drawer_layout_main)).closeDrawers();
                } else {
                    sayInfo();
                }
            }
        });

        fragment.findViewById(R.id.menu_item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AuthState.getInstance().state == AUTHORIZATED) {
                    Env.i().getScreens().clearStack();
                    Env.i().getScreens().putOnStack(ScreenID.START);
                    Env.i().getScreens().putOnStack(ScreenID.CHOICE_OBJECT);
                    Env.i().getScreens().setScreen(ScreenID.INVOICE);
                    ((DrawerLayout) getActivity().findViewById(R.id.drawer_layout_main)).closeDrawers();
                } else {
                    sayInfo();
                }
            }
        });

        fragment.findViewById(R.id.menu_item3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AuthState.getInstance().state == AUTHORIZATED) {
                    Env.i().getScreens().clearStack();
                    Env.i().getScreens().putOnStack(ScreenID.START);
                    Env.i().getScreens().putOnStack(ScreenID.CHOICE_OBJECT);
                    Env.i().getScreens().setScreen(ScreenID.PAYMENTS);
                    ((DrawerLayout) getActivity().findViewById(R.id.drawer_layout_main)).closeDrawers();
                } else {
                    sayInfo();
                }
            }
        });

        fragment.findViewById(R.id.menu_item4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AuthState.getInstance().state == AUTHORIZATED) {
                    Env.i().getScreens().clearStack();
                    Env.i().getScreens().putOnStack(ScreenID.START);
                    Env.i().getScreens().putOnStack(ScreenID.CHOICE_OBJECT);
                    Env.i().getScreens().setScreen(ScreenID.COUNTERS);
                    ((DrawerLayout) getActivity().findViewById(R.id.drawer_layout_main)).closeDrawers();
                } else {
                    sayInfo();
                }
            }
        });

        fragment.findViewById(R.id.menu_item6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AuthState.getInstance().state == AUTHORIZATED) {
                    Env.i().getScreens().clearStack();
                    Env.i().getScreens().putOnStack(ScreenID.START);
                    Env.i().getScreens().putOnStack(ScreenID.CHOICE_OBJECT);
                    Env.i().getScreens().setScreen(ScreenID.OTHER);
                    ((DrawerLayout) getActivity().findViewById(R.id.drawer_layout_main)).closeDrawers();
                } else {
                    sayInfo();
                }
            }
        });

        fragment.findViewById(R.id.menu_item7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AuthState.getInstance().state == AUTHORIZATED) {
                    Env.i().getScreens().clearStack();
                    Env.i().getScreens().putOnStack(ScreenID.START);
                    Env.i().getScreens().putOnStack(ScreenID.CHOICE_OBJECT);
                    Env.i().getScreens().setScreen(ScreenID.SETTINGS);
                    ((DrawerLayout) getActivity().findViewById(R.id.drawer_layout_main)).closeDrawers();
                } else {
                    sayInfo();
                }
            }
        });

        return fragment;
    }

    private void sayInfo() {
        Env.alert("Сначала нужно авторизироваться", getContext());
    }

}
