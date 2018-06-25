package environment.framework.logger;

/*****************************************************
 * Author: Novikov Artem
 * Date: 11.04.2018
 * Module name: ILogger
 * Description: System of application's logging on SD
 *****************************************************/
public interface ILogger {

    // Write string in file on SD
    void write(String message);

    // Information log
    void i(String place, String log);
    // Debug
    void d(String place, String log);
    // Warning
    void w(String place, String log);
    // Error
    void e(String place, String log);

}
