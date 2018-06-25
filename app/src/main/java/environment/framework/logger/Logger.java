package environment.framework.logger;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*********************************
 * Author: Novikov Artem
 * Date: 11.04.2018
 * Module name: Logger
 * Description: Implements ILogger
 * Updated on 08.06.2018
 **********************************/
public class Logger implements ILogger {
    public static final String LOG = "Logger";

    // LOG TAGS
    private static final String INFO_TAG = "INF";
    private static final String DEBUG_TAG = "DBG";
    private static final String WARNING_TAG = "WRN";
    private static final String ERROR_TAG = "ERR";
    // For writing to file
    private static final String DATE_FORMAT = "[HH:mm:ss dd.MM.yyyy]";

    // Name of file on SD
    private static String LOG_FILENAME = "logs.txt";

    // Path to file
    private static final String LOG_FILEPATH = "Logger";

    private StringBuilder mBuilder;
    private Context mContext;

    // Create file with current time
    // to avoid the resaving files
    // and lost logs
    static {
        LOG_FILENAME = getCurTime() + LOG_FILENAME;
    }

    public Logger(Context context) {
        mContext = context;
        mBuilder = new StringBuilder();
        d(LOG, "Start logging");
    }

    @Override
    public void write(String message) {
        mBuilder.append(message).append('\n');
        saveFile(mContext);
    }

    @Override
    public void i(String place, String log) {
        Log.e(place, INFO_TAG + "| " + log);
        buildLog(place, INFO_TAG, log);
    }

    @Override
    public void d(String place, String log) {
        Log.e(place, DEBUG_TAG + "| " + log);
        buildLog(place, DEBUG_TAG, log);
    }

    @Override
    public void w(String place, String log) {
        Log.e(place, WARNING_TAG + "| " + log);
        buildLog(place, WARNING_TAG, log);
    }

    @Override
    public void e(String place, String log) {
        Log.e(place, ERROR_TAG + "| " + log);
        buildLog(place, ERROR_TAG, log);
    }

    private void buildLog(String place, String debugTag, String message) {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append(getCurTime()).append(" ").append(place).append(" |")
                .append(debugTag).append("| ").append(message);
        write(builder.toString());
    }

    /********************
    * Saves file on SD
    *********************/
    private void saveFile(Context context) {
        String storageState = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(storageState)) {
            File mFile = new File(context.getExternalFilesDir(LOG_FILEPATH), LOG_FILENAME);
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(mFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                fos.write(mBuilder.toString().getBytes());
                fos.close();
            } catch (IOException e) {
                Log.e(LOG, "IOException: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            Log.e(LOG, "External storage not available");
        }
    }

    private static String getCurTime() {
        return new SimpleDateFormat(DATE_FORMAT).format(Calendar.getInstance().getTime());
    }
}
