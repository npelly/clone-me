package com.npelly.cloneme;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends android.app.Activity implements TextOutput.Callback {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Base.logd("MainActivity onCreate()");

        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.activity_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Base.logd("MainActivity onResume()");

        Base.get().getTextOutput().setCallback(this);
        textView.setText(Base.get().getTextOutput().getText());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Base.logd("MainActivity onPause()");

        Base.get().getTextOutput().setCallback(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Base.logd("MainActivity onDestroy()");
    }

    @Override
    public void updateText(StringBuilder text) {
        if (textView != null) {
            textView.setText(text);
        }
    }
}
