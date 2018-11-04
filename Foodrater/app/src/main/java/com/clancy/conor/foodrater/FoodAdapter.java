package com.clancy.conor.foodrater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    private List<Food>
    public void addFood(){

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_view_item,
                parent, false);

        return new FoodViewHolder(itemView)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
    final Food food =mFoods.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;
        private TextView mName;
        private RatingBar mRatingBar;

     public FoodViewHolder(@NonNull View itemView) {
         super(itemView);

         mImageView = itemView.findViewById(R.id.food_pic);
         mName = itemView.findViewById(R.id.name);
         mRatingBar = itemView.findViewById(R.id.rating_bar);
     }
 }
}
