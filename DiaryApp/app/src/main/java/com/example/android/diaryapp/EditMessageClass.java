package com.example.android.diaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class EditMessageClass extends AppCompatActivity {
    String messageText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_layout);
        Intent intent=getIntent();
        messageText=intent.getStringExtra(IntentConstant.INTENT_MESSAGE_DATA);
        position=intent.getIntExtra(IntentConstant.INTENT_ITEM_POSITION,-1);
        EditText messageData=(EditText)findViewById(R.id.message);
        messageData.setText(messageText);
    }

    public void savedButtonClicked(View v){
        String  changedMessageText=((EditText)findViewById(R.id.message)).getText().toString();
        Intent intent=new Intent();
        intent.putExtra(IntentConstant.INTENT_CHANGED_MESSAGE,changedMessageText);
        intent.putExtra(IntentConstant.INTENT_ITEM_POSITION,position);
        setResult(IntentConstant.INTENT_REQUEST_CODE_TWO,intent);
        finish();

    }
}
