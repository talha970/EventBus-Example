package com.example.tjaved.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
Button childbutton;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        childbutton=(Button) findViewById(R.id.button);
        tv=(TextView) findViewById(R.id.textView);
        EventBus.getDefault().register(this);
        childbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ChildActivity.class);
                startActivity(i);
            }
        });

    }
    @Subscribe
    public void onEvent(CustomMessage message){
        tv.setText(message.getMessage());
    }
}
