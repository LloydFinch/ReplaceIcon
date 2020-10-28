package com.lloydfinch.mmkvdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.tencent.mmkv.MMKV;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // syncByMMKV();

        findViewById(R.id.btn_11).setOnClickListener(v -> {
            ReplaceIconUtils.replaceBy11(this);
        });

        findViewById(R.id.btn_22).setOnClickListener(v -> {
            ReplaceIconUtils.replaceBy22(this);
        });
    }

    private void syncBySp() {
        SharedPreferences sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", "sp_text");
        editor.apply();
    }

    private void syncByMMKV() {
        MMKV mmkv = MainApplication.get().getMMKV();

        String name1 = mmkv.decodeString("name");
        Log.e(MainApplication.APP_TAG, "decode name: " + name1);

        mmkv.encode("name", "mmkv_text_encode");

        String name = mmkv.getString("name", null);
        Log.e(MainApplication.APP_TAG, "getString name: " + name);

        mmkv.putString("name", "mmkv_text_put");
        Log.e(MainApplication.APP_TAG, "getString2 name: " + name);
    }
}