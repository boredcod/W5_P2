package com.example.w6_p2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends FragmentActivity implements TopFragment.OnDataPass{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public void onDataPass(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("animal", data);
        System.out.println(data);
        BottomFragment b = new BottomFragment();
        b.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.BottomFragment, b).commit();
    }
}