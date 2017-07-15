package com.example.admin.activitypassvaluedemo01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.activitypassvaluedemo01.model.NormalModel;
import com.example.admin.activitypassvaluedemo01.model.ParcelableModel;
import com.example.admin.activitypassvaluedemo01.model.SerializableModel;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ReceiveValueActivity extends AppCompatActivity {

    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_value);
        mTvShow = ((TextView) findViewById(R.id.tv_show));
        Intent intent = getIntent();
        //对象
        ParcelableModel key1 = (ParcelableModel) intent.getParcelableExtra("key1");
        SerializableModel key2 = (SerializableModel) intent.getSerializableExtra("key2");
        String key3 = intent.getStringExtra("key3");
        NormalModel normalModel = new Gson().fromJson(key3, NormalModel.class);
        //集合
        ArrayList<Parcelable> parcelableArrayList =  intent.getParcelableArrayListExtra("key4");
        ArrayList<SerializableModel> modelArrayList = (ArrayList<SerializableModel>) intent.getSerializableExtra("key5");
        Parcelable[] key6s = intent.getParcelableArrayExtra("key6");
        mTvShow.setText(key1.getName()+key2.getName()+normalModel.getName()+"*集合*"+
                ((ParcelableModel) parcelableArrayList.get(1)).getName()
                +modelArrayList.get(1).getName()+ ((ParcelableModel) key6s[1]).getName());
    }

}
