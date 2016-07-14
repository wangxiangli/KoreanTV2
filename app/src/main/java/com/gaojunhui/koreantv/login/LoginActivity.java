package com.gaojunhui.koreantv.login;

import android.os.Bundle;

import com.gaojunhui.koreantv.BaseActivity;
import com.gaojunhui.koreantv.R;

/**
 * Created by Youchao on 2016/7/14.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
