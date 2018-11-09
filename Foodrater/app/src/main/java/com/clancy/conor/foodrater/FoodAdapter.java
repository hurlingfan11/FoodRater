package com.clancy.conor.foodrater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>
{

    private List<Food> mFoods = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Random mRandom = new Random();


    public void addFood()
    {
        //Food food = new Food();
        //notifyDataSetChanged(); // Works fine but no animation
        notifyItemInserted(0);
        notifyItemRangeChanged(0, mFoods.size());
        mRecyclerView.scrollToPosition(0);
    }

    public void removeName(int index)
    {
        mFoods.remove(index);
        notifyItemRemoved(index);
        notifyItemRangeChanged(0, mFoods.size());
    }

    private String getRandomName()
    {
        String[] names = new String[]{
                "Banana", "Broccoli", "Homemade Bread", "Chicken", "Chocolate", "Ice Cream",
                "Lima Beans", "Steak"
        };
        return names[mRandom.nextInt(names.length)];

    }
        @NonNull
        @Override
        public FoodViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int i)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_view_item,
                    parent, false);

            return new FoodViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder (@NonNull FoodViewHolder foodViewHolder,int index)
        {
            final Food food = mFoods.get(index);
            foodViewHolder.mName.setText(food.getName());
            foodViewHolder.mImageView.setImageResource(food.getImageResourceId());
            foodViewHolder.mRatingBar.setRating(food.getRating());
        }

        @Override
        public int getItemCount ()
        {

            return mFoods.size();
        }

        class FoodViewHolder extends RecyclerView.ViewHolder
        {

            private ImageView mImageView;
            private TextView mName;
            private RatingBar mRatingBar;

            public FoodViewHolder(@NonNull View itemView)
            {
                super(itemView);

                mImageView = itemView.findViewById(R.id.food_pic);
                mName = itemView.findViewById(R.id.name);
                mRatingBar = itemView.findViewById(R.id.rating_bar);

                // Delete this food on Long Press
                itemView.setOnLongClickListener(new View.OnLongClickListener()
                {
                    @Override
                    public boolean onLongClick(View v)
                    {
                        removeName(getAdapterPosition());
                        return true;
                    }
                });
            }
        }
    }