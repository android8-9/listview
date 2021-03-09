package com.cheekupeeku.testcustomlistview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cheekupeeku.testcustomlistview.databinding.ItemListBinding;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter {
  Context context;
  ArrayList<User>al;
  public UserAdapter(Context context, ArrayList<User>al){
      super(context,R.layout.item_list,al);
      this.context = context;
      this.al = al;
  }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      User user = al.get(position);
      ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(context));
      binding.iv.setImageResource(user.getImageId());
      binding.tvName.setText(user.getName());
      binding.tvMobile.setText(user.getMobile());
      binding.iv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent in = new Intent(context,ShowImage.class);
          in.putExtra("user",user);
          context.startActivity(in);
        }
      });
      return binding.getRoot();
    }


    @Override
    public int getCount() {
        return al.size();
    }
}
