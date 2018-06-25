package myapp.moydom.ru.myhouse;

import android.content.Context;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import environment.Env;
import environment.framework.http.HttpConnect;
import environment.framework.http.Request;

import static environment.Constants.EMAIL;
import static environment.Constants.JSON_ERROR;
import static environment.Constants.NAME;
import static environment.Constants.NUMBER;
import static environment.Constants.PASSWORD;
import static environment.Constants.UI_AUTH_SUCCESS;
import static environment.Constants.UI_INVOICE_SUCCESS;
import static environment.Constants.UI_OBJECTS_SUCCESS;
import static environment.Constants.UI_OBJECT_INFO_SUCCESS;
import static environment.Constants.UI_REGISTER_SUCCESS;

/*********************************
 * Author: Novikov Artem
 * Date: 11.06.2018
 * Module name: ApiRequests
 * Description: Запросы к API
 **********************************/
public class ApiRequests {
    private static final String LOG = "ApiRequests";
    private static final String BASE_LINK = "http://mobile.erconline.ru/";

    private HttpConnect mConnect;
    private Context mContext;
    // Запросы
    private Request mRegisterRequest;
    private Request mAuthRequest;
    private Request mObjectsRequest;
    private Request mObjectInfoRequest;
    private Request mInvoiceRequest;
    private Request mExplanRequest;

    public ApiRequests(Context context) {
        mContext = context;
        mConnect = Env.i().lockConnect();
        if(mConnect == null) {
            Env.log().e(LOG, "Failed get HttpConnect object");
        }

        mRegisterRequest = new Request(BASE_LINK + "v2/auth/setreg/");
        mAuthRequest = new Request(BASE_LINK + "auth");
        mObjectsRequest = new Request(BASE_LINK + "account");
        mObjectInfoRequest = new Request(BASE_LINK + "accinfo");
        mInvoiceRequest = new Request(BASE_LINK + "accruals");
        mExplanRequest = new Request(BASE_LINK + "explanation");
    }

    // Создает коллбэк для конкретного id
    private HttpConnect.Callback createCallback(final int id) {
        return new HttpConnect.Callback() {
            @Override
            public void call(Request.Result res) {
                Env.log().i(LOG, res.ok + "");
                Env.log().i(LOG, res.code + "");
                Env.log().i(LOG, res.message);
                Env.log().i(LOG, res.body);

                if(res.ok) {
                    Env.i().getSender().storeData(id, res.body);
                    Env.i().getSender().sendUI(id);
                    Env.log().i(LOG, "Success request");
                } else {
                    Env.log().e(LOG, "Error request");
                    try {
                        JSONObject json = new JSONObject(res.body);
                        String message = json.optString(JSON_ERROR);

                        if(message != null) {
                            Env.log().e(LOG, "Error message:" + message);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Env.log().e(LOG, "Error while parsing JSON object");
                    }
                }
            }
        };
    }

    // POST /v2/auth/setreg/
    public void register() {
        mRegisterRequest.removeAllParams();

        Bundle data = Env.i().getTemp().registerUser;
        mRegisterRequest.addParam("name", data.getString(NAME));
        mRegisterRequest.addParam("email", data.getString(EMAIL));
        mRegisterRequest.addParam("phone", data.getString(NUMBER));
        mRegisterRequest.addParam("password", data.getString(PASSWORD));

        mRegisterRequest.addParam("site", "false");
        mRegisterRequest.addParam("is_person_data", "true");
        mConnect.asyncRequest(mContext, mRegisterRequest, createCallback(UI_REGISTER_SUCCESS), Request.POST);
    }

    // GET auth
    public void auth(String login, String pass) {
        mAuthRequest.removeAllParams();
        mAuthRequest.addParam("Login", login);
        mAuthRequest.addParam("Password", pass);

        mConnect.asyncRequest(mContext, mAuthRequest, createCallback(UI_AUTH_SUCCESS), Request.GET);
    }

    // GET accounts
    public void objects(String token) {
        mObjectsRequest.removeAllParams();
        mObjectsRequest.setAuth("Bearer " + token);
        mConnect.asyncRequest(mContext, mObjectsRequest, createCallback(UI_OBJECTS_SUCCESS), Request.GET);
    }

    // GET accinfo
    public void objectInfo(String token, String userId) {
        mObjectInfoRequest.removeAllParams();
        mObjectInfoRequest.setAuth("Bearer " + token);
        mObjectInfoRequest.addParam("UserId", userId);
        mConnect.asyncRequest(mContext, mObjectInfoRequest, createCallback(UI_OBJECT_INFO_SUCCESS), Request.GET);
    }

    // GET accruals
    public void invoices(String token, String userId) {
        mInvoiceRequest.removeAllParams();
        mInvoiceRequest.setAuth("Bearer " + token);
        mInvoiceRequest.addParam("UserId", userId);
        mConnect.asyncRequest(mContext, mInvoiceRequest, createCallback(UI_INVOICE_SUCCESS), Request.GET);
    }

    // GET explanation
    public void explanation(String token, String userId, HashMap<String, String> params) {
        mExplanRequest.removeAllParams();
        mExplanRequest.setAuth("Bearer " + token);
        mExplanRequest.addParam("UserId", userId);
        mConnect.asyncRequest(mContext, mExplanRequest, createCallback(UI_INVOICE_SUCCESS), Request.GET);
    }

    // GET payments
    public void payments() {

    }

    // GET meters
    public void counterInfo() {

    }

    // POST setmeter
    public void sendCounterInfo() {

    }

    // POST accsetpsw
    public void changePassword() {

    }

    // POST setemail
    public void changeEmail() {

    }

    // POST sendmailcode
    public void lostPassword() {

    }

    // POST setnewpsw
    public void setNewPassword() {

    }

    // GET accpay
    public void getMarkets() {

    }

    // POST sendpay
    public void pay() {

    }

    // GET accpaycheck

    // GET services
    public void getServiceList() {

    }

    // POST getservice
    public void orderService() {

    }

    // GET orders

    // POST sendtelcode
    public void getCode() {

    }

    // POST setnewtel
    public void changeNumber() {

    }

    // POST logout
    public void logOut() {

    }
}
