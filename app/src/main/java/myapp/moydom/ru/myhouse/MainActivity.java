package myapp.moydom.ru.myhouse;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import environment.Env;
import environment.MyHouseBuilder;
import environment.framework.screen.ScreenID;
import environment.framework.temp.Temp;
import myapp.moydom.ru.myhouse.auth.AuthState;

import static myapp.moydom.ru.myhouse.auth.AuthState.State.AUTHORIZATED;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = "MainActivity";

    // Боковая шторка меню
    private DrawerLayout mMenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Сначала создание окружения (Environment)
        MyHouseBuilder builder = new MyHouseBuilder(this);
        Env.i().build(builder, this);

        // Затем установка UI
        setContentView(R.layout.activity_main);
        mMenuView = findViewById(R.id.drawer_layout_main);
        mMenuView.addDrawerListener(mDrawerListener);

        Env.log().i(LOG, "onCreate()");
        Env.i().getScreens().setScreen(ScreenID.EMPTY_START);
    }

    // Listener для прослушивания закрытия-открытия меню
    private DrawerLayout.DrawerListener mDrawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
            TextView mNameText = drawerView.findViewById(R.id.menu_user_name);
            //TextView mCityText = drawerView.findViewById(R.id.menu_user_city);
            TextView mAdressText = drawerView.findViewById(R.id.menu_user_address);

            if(AuthState.getInstance().state == AUTHORIZATED) {
                mNameText.setText("Андрей Павлович\nАстафьев");
                //mCityText.setText("Краснодар");
                mAdressText.setText("г. Москва\nул. Тверская, дом 1, кв. 12");
            } else {
                mNameText.setText("Вход не выполнен");
                //mCityText.setText("");
                mAdressText.setText("");
            }
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    @Override
    // Нажатие кнопки назад
    public void onBackPressed() {
        Env.log().i(LOG, "onBackPressed()");
        if(!Env.i().getScreens().setFromStack()) {
            // Выход
            super.onBackPressed();
        }
    }
}
