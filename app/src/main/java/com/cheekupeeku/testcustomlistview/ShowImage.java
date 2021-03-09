package com.cheekupeeku.testcustomlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cheekupeeku.testcustomlistview.databinding.ShowImageBinding;

public class ShowImage extends AppCompatActivity {
    ShowImageBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ShowImageBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        Intent in = getIntent();
        User user =(User) in.getSerializableExtra("user");
        binding.iv.setImageResource(user.getImageId());
    }
}
