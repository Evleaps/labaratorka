package environment.framework.tools;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

/*********************************************************
 * Author: Novikov Artem
 * Date: 10.06.2018
 * Module name: TextContainer
 * Description: TextWatcher. Срабатывает
 *              при смене поля и срзау сохраняет значение
 *              в указанный контейнер с указанным id
 *********************************************************/
public class TextContainer implements TextWatcher {
    private static final String LOG = "TextContainer";
    private Bundle mContainer;
    private String mKey;

    public TextContainer(Bundle container, String key) {
        mContainer = container;
        mKey = key;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(s.length() != 0) {
            mContainer.remove(mKey);
            mContainer.putString(mKey, s.toString());
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
