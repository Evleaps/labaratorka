package environment;

/***************************************************
 * Author: Novikov Artem
 * Date: 17.03.2018
 * Module name: Constants
 * Description: Stores all constants in application
 ***************************************************/
public class Constants {

    // Ключи для контейнеров хранения временных данных
    public static final String NAME = "NAME";
    public static final String NUMBER = "NUMBER";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";

    // Set program or prototype
    public static final boolean PROGRAM = true;

    // Константы для отображения результатов работы
    // других потоков в UI (класс Sender)
    public static final int UI_REGISTER_SUCCESS = 0;
    public static final int UI_AUTH_SUCCESS = 1;
    public static final int UI_OBJECTS_SUCCESS = 2;
    public static final int UI_OBJECT_INFO_SUCCESS = 3;
    public static final int UI_INVOICE_SUCCESS = 4;

    // Ключи для работы с JSON
    public static final String JSON_ERROR = "Error";
}
