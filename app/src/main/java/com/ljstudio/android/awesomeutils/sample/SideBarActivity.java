package com.ljstudio.android.awesomeutils.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ljstudio.android.awesomeutils.sidebarview.SideBarView;

/**
 * Created by tianguorui on 2016/7/22.
 */
public class SideBarActivity extends AppCompatActivity {

    private SideBarView sideBarView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidebar);

        sideBarView = (SideBarView) findViewById(R.id.id_side_bar);
        textView = (TextView) findViewById(R.id.id_text_view);

        sideBarView.setOnTouchingLetterChangedListener(new SideBarView.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                textView.setText("select " + s);
            }
        });
    }
}
