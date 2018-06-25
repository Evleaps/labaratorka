package environment.framework.http;

import java.util.HashMap;
import java.util.Set;

import environment.Env;
import environment.framework.lib.HttpRequest;

/*******************************************
 * Created by Novikov Artem on 07.02.2018
 * Updated on 08.06.2018
 *******************************************/

public class Request {
    private static final String LOG = "Request";
    public static final int GET = 0;
    public static final int POST = 1;

    private String strParams;
    private String url;
    private HashMap<String, String> params;
    private String mAuth;
    private boolean mIsJson;
    private boolean mCustomParams;

    public Request(String url) {
        this.url = url;
        params = new HashMap<>();
        strParams = "";
    }

    public void setJson(boolean json) {
        mIsJson = json;
    }

    public void addParam(String key, String value) {
        params.put(key, value);
        updateParam();
    }

    // Set custom HashMap with parameters of responce
    public void setParams(HashMap<String, String> params) {
        this.params = params;
        mCustomParams = true;
    }

    public void removeCustomParams() {
        mCustomParams = false;
        removeAllParams();
        updateParam();
    }

    public void removeAllParams() {
        params.clear();
        updateParam();
    }

    public void removeParam(String key) {
        params.remove(key);
        updateParam();
    }

    //Using for update params after adding new
    private void updateParam() {
        StringBuilder builder = new StringBuilder("");
        boolean first = true;

        Set<String> keys = params.keySet();
        for(String key : keys) {
            if(first == false) {
                builder.append("&");
            }
            builder.append(key + "=" + params.get(key));
            first = false;
        }
        strParams = builder.toString();
    }

    public Result get() {
        Env.log().i(LOG, url + "?" + strParams);
        HttpRequest request;
        if(mCustomParams) {
            if (mAuth == null) {
                request = isJson(HttpRequest.get(url)).form(params);
            } else {
                request = isJson(HttpRequest.get(url)).authorization(mAuth).form(params);
            }

        } else {
            if (mAuth == null) {
                request = isJson(HttpRequest.get(url + "?" + strParams));
            } else {
                request = isJson(HttpRequest.get(url + "?" + strParams)).authorization(mAuth);
            }
        }
        return new Result(request.code(), request.message(), request.body(), request.ok());
    }

    // TODO: КОСТЫЛЬ!!! удалить!!!
    private HttpRequest isJson(HttpRequest request) {
        if(mIsJson) {
            request.contentType(HttpRequest.CONTENT_TYPE_JSON);
        }
        return request;
    }

    public Result post() {
        HttpRequest request;
        if(mCustomParams) {
            if (mAuth == null) {
                request = isJson(HttpRequest.post(url)).form(params);
            } else {
                request = isJson(HttpRequest.post(url)).authorization(mAuth).form(params);
            }
        } else {
            if (mAuth == null) {
                request = isJson(HttpRequest.post(url)).send(strParams);
            } else {
                request = isJson(HttpRequest.post(url)).authorization(mAuth).send(strParams);
            }
        }
        return new Result(request.code(), request.message(), request.body(), request.ok());
    }

    public void setAuth(String auth) {
        mAuth = auth;
    }

    public void authorization(String value) {
        mAuth = value;
    }

    public Result request(int method) {
        Result res = null;
        switch(method) {
            case GET:
                res = get();
                break;
            case POST:
                res = post();
                break;
        }
        return res;
    }

    public class Result {
        public int code;
        public String message;
        public String body;
        public boolean ok;

        public Result(int code, String message, String body, boolean ok) {
            this.code = code;
            this.message = message;
            this.body = body;
            this.ok = ok;
        }
    }
}