package myapp.moydom.ru.myhouse;

import android.support.v4.app.FragmentManager;

import environment.framework.screen.Screen;
import environment.framework.screen.ScreenID;
import environment.framework.screen.Screens;
import myapp.moydom.ru.myhouse.screens.AgreeFragment;
import myapp.moydom.ru.myhouse.screens.AuthFragment;
import myapp.moydom.ru.myhouse.screens.ChoiceCounterFragment;
import myapp.moydom.ru.myhouse.screens.ChoiceObjectFragment;
import myapp.moydom.ru.myhouse.screens.ChoiceServiceFragment;
import myapp.moydom.ru.myhouse.screens.CounterInfoFragment;
import myapp.moydom.ru.myhouse.screens.CountersFragment;
import myapp.moydom.ru.myhouse.screens.EmailCodeFragment;
import myapp.moydom.ru.myhouse.screens.EmptyFragment;
import myapp.moydom.ru.myhouse.screens.ExplanationFragment;
import myapp.moydom.ru.myhouse.screens.InvoiceFragment;
import myapp.moydom.ru.myhouse.screens.LearnFirstFragment;
import myapp.moydom.ru.myhouse.screens.LearnSecondFragment;
import myapp.moydom.ru.myhouse.screens.LearnThirdFragment;
import myapp.moydom.ru.myhouse.screens.OtherFragment;
import myapp.moydom.ru.myhouse.screens.PaymentsFragment;
import myapp.moydom.ru.myhouse.screens.PhoneCodeFragment;
import myapp.moydom.ru.myhouse.screens.ReestablishPassFragment;
import myapp.moydom.ru.myhouse.screens.RegisterFragment;
import myapp.moydom.ru.myhouse.screens.RegisterObjectFragment;
import myapp.moydom.ru.myhouse.screens.SettingsFragment;
import myapp.moydom.ru.myhouse.screens.SettingsSecondFragment;
import myapp.moydom.ru.myhouse.screens.StartFragment;
import myapp.moydom.ru.myhouse.screens.SuccessObjectFragment;

/****************************************************
 * Author: Novikov Artem
 * Date: 25.05.2018
 * Module name: MyHouseScreens
 * Description: Класс для парсинга нужных экранов.
 *              Возвращает новые объекты экранов
 *              (фрагментов)
 ***************************************************/
public class MyHouseScreens extends Screens {
    public MyHouseScreens(FragmentManager manager, int container) {
        super(manager, container);
    }

    @Override
    protected Screen parseScreen(ScreenID screen) {
        switch(screen) {
            case EMPTY_START:
                return new EmptyFragment();
            case START:
                return new StartFragment();
            case AUTH:
                return new AuthFragment();
            case REESTABLISH_PASSWORD:
                return new ReestablishPassFragment();
            case PHONE_CODE:
                return new PhoneCodeFragment();
            case REGISTER:
                return new RegisterFragment();
            case LEARN_FIRST:
                return new LearnFirstFragment();
            case LEARN_SECOND:
                return new LearnSecondFragment();
            case LEARN_THIRD:
                return new LearnThirdFragment();
            case CHOICE_OBJECT:
                return new ChoiceObjectFragment();
            case INVOICE:
                return new InvoiceFragment();
            case EXPLANATION:
                return new ExplanationFragment();
            case REGISTER_OBJECT:
                return new RegisterObjectFragment();
            case REGISTER_OBJECT_SUCCESS:
                return new SuccessObjectFragment();
            case AGREEMENT:
                return new AgreeFragment();
            case PAYMENTS:
                return new PaymentsFragment();
            case SETTINGS:
                return new SettingsFragment();
            case EMAIL_CODE:
                return new EmailCodeFragment();
            case SETTINGS_SECOND:
                return new SettingsSecondFragment();
            case COUNTERS:
                return new CountersFragment();
            case CHOICE_COUNTER:
                return new ChoiceCounterFragment();
            case COUNTER_INFO:
                return new CounterInfoFragment();
            case OTHER:
                return new OtherFragment();
            case CHOICE_SERVICE:
                return new ChoiceServiceFragment();
            default:
                return null;
        }
    }
}
