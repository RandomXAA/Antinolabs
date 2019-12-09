package com.example.antinolabs;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Activity mActivity;
    private Context context;
    private ArrayList<UserListData> list;

    public UserAdapter(Context context, ArrayList<UserListData> list, Activity activity){
        this.context = context;
        this.list =list;
        this.mActivity = activity;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view_layout, parent, false);
        return new  ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        UserListData userListData = list.get(position);
        holder.userName.setText(userListData.getUserName());
        holder.userAge.setText(userListData.getUserAge());
        holder.userLocation.setText(userListData.getUserLocation());

        Picasso.with(context).load(userListData.getUserImage()).into(holder.userImage);
        if (holder.userImage.getDrawable() == null)
        {
            holder.userImage.setImageResource(R.drawable.ic_launcher_foreground);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userName, userAge, userLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.imgUser_image);
            userName = itemView.findViewById(R.id.txtUser_name);
            userAge = itemView.findViewById(R.id.txtUser_age);
            userLocation = itemView.findViewById(R.id.txtUser_location);

        }
    }
}
