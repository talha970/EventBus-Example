package com.example.tjaved.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {
EditText msgtxt;
    Button triggerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
    msgtxt=(EditText) findViewById(R.id.editText);
    triggerbtn=(Button) findViewById(R.id.button2);
    }

    public void sendMessage(View v){
        CustomMessage msg=new CustomMessage();
        msg.setMessage(String.valueOf(msgtxt.getText()));
        EventBus.getDefault().post(msg);
    }
}
