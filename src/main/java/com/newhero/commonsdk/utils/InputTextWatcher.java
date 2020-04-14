package com.newhero.commonsdk.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.jess.arms.utils.ArmsUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.newhero.commonsdk.core.Constants.INPUT_MAX_LONG_LENGTH;
import static com.newhero.commonsdk.core.Constants.INPUT_MAX_MIDDLE_LENGTH;
import static com.newhero.commonsdk.core.Constants.INPUT_MAX_SHORT_LENGTH;

public class InputTextWatcher implements TextWatcher {

    private Context context;
    private EditText editText;
    private int lengthType;

    public InputTextWatcher(Context context, EditText editText,int lengthType){
        this.context=context;
        this.editText=editText;
        this.lengthType=lengthType;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String destStr;
        if (lengthType==0) {
            if (s.length() > INPUT_MAX_SHORT_LENGTH) {
//            destStr = stringFilter(s.toString());
                destStr = s.toString();
                String limitStr = destStr.subSequence(0, INPUT_MAX_SHORT_LENGTH).toString();
                if (!editText.getText().toString().equals(limitStr)) {
                    editText.setText(limitStr);
                    editText.setSelection(editText.getText().toString().length()); // 缺少该语句, 光标会定位到文本框开始位置
                    ArmsUtils.makeText(context, "超过最大长度限制");
                }
            }
        }
        else if (lengthType==1){
            if (s.length() > INPUT_MAX_MIDDLE_LENGTH) {
//            destStr = stringFilter(s.toString());
                destStr = s.toString();
                String limitStr = destStr.subSequence(0, INPUT_MAX_MIDDLE_LENGTH).toString();
                if (!editText.getText().toString().equals(limitStr)) {
                    editText.setText(limitStr);
                    editText.setSelection(editText.getText().toString().length()); // 缺少该语句, 光标会定位到文本框开始位置
                    ArmsUtils.makeText(context, "超过最大长度限制");
                }
            }
        }
        else if (lengthType==2){
            if (s.length() > INPUT_MAX_LONG_LENGTH) {
//            destStr = stringFilter(s.toString());
                destStr = s.toString();
                String limitStr = destStr.subSequence(0, INPUT_MAX_LONG_LENGTH).toString();
                if (!editText.getText().toString().equals(limitStr)) {
                    editText.setText(limitStr);
                    editText.setSelection(editText.getText().toString().length()); // 缺少该语句, 光标会定位到文本框开始位置
                    ArmsUtils.makeText(context, "超过最大长度限制");
                }
            }
        }
    }

    public static String stringFilter(String str) {
        String regEx = "[/:*?<>|\"\n\t]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

}