package environment.framework.http;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

/************************************************
 * Created by Novikov Artem on 05.02.2018
 * Module name: HttpConnect
 * Description: Class for sending HTTP requests
 * Updated on 08.06.2018
 ************************************************/
public class HttpConnect {
    // Make async request
    public boolean asyncRequest(Context context, Request request, Callback callback, int method) {
        boolean res;
        res = hasConnection(context);
        if(res) {
            new AsyncRequest(request, callback, method).execute();
        }
        return res;
    }

    // Make request on current thread
    public boolean simpleRequest(Context context, Request request, Callback callback, int method) {
        boolean res;
        res = hasConnection(context);
        if(res) {
            Request.Result reqRes = request.request(method);
            callback.call(reqRes);
        }
        return res;
    }

    // Make request on UI thread
    public void onUi(final Request request, final Callback callback, final int method, Activity activity) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Request.Result res = request.request(method);
                callback.call(res);
            }
        });
    }

    /*****************************
     * Checks Internet connection
     *****************************/
    public boolean hasConnection(Context context) {
        boolean res = false;

        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (wifiInfo != null && wifiInfo.isConnected()) {
            res = true;
        } else {
            wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifiInfo != null && wifiInfo.isConnected()) {
                res = true;
            } else {
                wifiInfo = cm.getActiveNetworkInfo();
                if (wifiInfo != null && wifiInfo.isConnected()) {
                    res = true;
                }
            }
        }

        return res;
    }

    private class AsyncRequest extends AsyncTask<String, Integer, Request.Result> {
        private Request request;
        private Callback callback;
        private int method;

        public AsyncRequest(Request request, Callback callback, int method) {
            this.request = request;
            this.callback = callback;
            this.method = method;
        }

        @Override
        protected Request.Result doInBackground(String... urls) {
            Request.Result result = null;
            switch (method) {
                case Request.GET:
                    result = request.get();
                    break;
                case Request.POST:
                    result = request.post();
                    break;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Request.Result res) {
            callback.call(res);
        }
    }

    public interface Callback {
        void call(Request.Result res);
    }
}
