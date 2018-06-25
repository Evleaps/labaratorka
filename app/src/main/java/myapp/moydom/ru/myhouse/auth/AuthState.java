package myapp.moydom.ru.myhouse.auth;

/*********************************
 * Author: Novikov Artem
 * Date: 15.06.2018
 * Module name: AuthState
 * Description:
 **********************************/
public class AuthState {
    private static final AuthState ourInstance = new AuthState();

    public static AuthState getInstance() {
        return ourInstance;
    }

    public enum State {
        UNAUTH,
        AUTHORIZATED
    }

    public State state;
    private String mLogin;
    private String mPass;
    private String mToken;

    private AuthState() {
        state = State.UNAUTH;
    }

    public void auth(String login, String pass, String token) {
        mLogin = login;
        mPass = pass;
        mToken = token;
        state = State.AUTHORIZATED;
    }

    public void logOut() {
        state = State.UNAUTH;
        mLogin = null;
        mPass = null;
        mToken = null;
    }

}
