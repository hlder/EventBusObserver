package com.hld.eventbusobserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hld.eventbusobserver.lib.EventBus;
import com.hld.eventbusobserver.lib.eventbus.EventBusListener;


public class MainActivity extends AppCompatActivity {
    private Button button;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);

        EventBus.register(new EventBusListener() {
            @Override
            public void onEvent(String action, final Object obj) {
                Log.d("dddd","收到========:"+obj);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("收到========:"+obj);
                    }
                });
            }
        },"actionTest");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.post("actionTest","aaaaa");


            }
        });



    }
}
