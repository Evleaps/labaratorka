package environment.framework.temp;

import android.content.Context;
import android.os.Bundle;

import myapp.moydom.ru.myhouse.ApiRequests;

/****************************************************
 * Author: Novikov Artem
 * Date: 24.03.2018
 * Module name: Temp
 * Desciprion: Класс для хранения временных данных
 ****************************************************/

public class Temp {
    private static final String LOG = "Temp";

    // Для различения текущих настроек, в зависимости от того
    // что настраиваем: пароль, телефон или e-mail
    public enum SettingType {
        PASSWORD,
        PHONE,
        EMAIL,
        REGISTRATION,
        REESTABLISH_PASS
    }

    // Для различения типа счетчиков
    public enum Counter {
        COLD_WATER,
        HOT_WATER,
        GAS,
        HEATING,
        POWER
    }

    // Для различения вида услуг (Экран "OtherFragment")
    public enum Service {
        WATER,
        POWER,
        SERVICE
    }

    public SettingType mSetType;
    public Counter mCounterType;
    public Service serviceType;
    public ApiRequests mApi;

    // Контейнеры с информацией
    public Bundle registerUser;
    public Bundle registerObject;

    public Temp(Context context) {
        registerUser = new Bundle();
        registerObject = new Bundle();
        mApi = new ApiRequests(context);
    }
}
