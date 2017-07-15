package com.example.admin.activitypassvaluedemo01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.activitypassvaluedemo01.model.NormalModel;
import com.example.admin.activitypassvaluedemo01.model.ParcelableModel;
import com.example.admin.activitypassvaluedemo01.model.SerializableModel;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
* 页面传递信息的方式总结：
 *  基本类型的不做总结，主要是对象传输、以及最主要的集合
* */
public class MainActivity extends AppCompatActivity {
    Intent intent ;
    ParcelableModel parcelableModel = new ParcelableModel("李四",30);
    SerializableModel serializableModel = new SerializableModel("张三", 20);
    NormalModel normalModel = new NormalModel("正常人",1);
    ArrayList<ParcelableModel> mListParcelableModel = new ArrayList<>();
    List<SerializableModel> mListSerializableModel = new ArrayList<>();
    ArrayList<NormalModel> mListNormalModel = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, ReceiveValueActivity.class);
        mListParcelableModel.add(parcelableModel);
        mListParcelableModel.add(new ParcelableModel("李武", 31));
        mListSerializableModel.add(serializableModel);
        mListSerializableModel.add(new SerializableModel("张4",21));
        mListNormalModel.add(normalModel);
        mListNormalModel.add(new NormalModel("正常人2号", 3));
    }

    public void btnPutData(View view) {
        puObject();
        putList();
    }

    /*
    * 传递对象方式：
    * 1：对象实现Pacelable接口（Android独有，更高效）
    * 2：对象实现Serializable接口
    * 3：把数据转成json格式的字符串传递，接收方再解析成对象
    * 4：把对象拆分基本数据属性传递，接收方再生成对象
    * 5：利用静态属性,或者把值存在两边都能取到的地方
    * 6：利用sharedPreferences
    * */
    public void puObject() {
        //方式1
        intent.putExtra("key1", parcelableModel);
        //方式2
        intent.putExtra("key2", serializableModel);
        //方式3
        String json = new Gson().toJson(normalModel);
        intent.putExtra("key3", json);
    }


    /*
    *  传递集合的方式（非String）
    *   1.对象实现Parcelable接口
    *   2.集合强转Serializable,接收端用getSerializableExtra()方法在强转
    * */
    public void putList() {
        //方式1
        intent.putParcelableArrayListExtra("key4", mListParcelableModel);
        //方式2
        intent.putExtra("key5", ((Serializable) mListSerializableModel));
        //方式3
        ParcelableModel[] a = new ParcelableModel[mListParcelableModel.size()];
        intent.putExtra("key6", mListParcelableModel.toArray(a));
        startActivity(intent);
    }

}
