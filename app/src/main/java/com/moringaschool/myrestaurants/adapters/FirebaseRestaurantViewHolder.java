package com.moringaschool.myrestaurants.adapters;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.moringaschool.myrestaurants.R;
import com.moringaschool.myrestaurants.models.Business;
import com.moringaschool.myrestaurants.ui.RestaurantDetailActivity;
import com.moringaschool.myrestaurants.util.ItemTouchHelperViewHolder;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class FirebaseRestaurantViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;
    public ImageView mRestaurantImageView;

    public ImageView mRestaurantImageViews; //grants acces to the image view
    public FirebaseRestaurantViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
        mContext = itemView.getContext();


    }
    public void bindRestaurant(Business restaurant) {
        mRestaurantImageView = (ImageView) mView.findViewById(R.id.restaurantImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.restaurantNameTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categoryTextView);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingTextView);

        Picasso.get().load(restaurant.getImageUrl()).into(mRestaurantImageView);

        nameTextView.setText(restaurant.getName());
//        categoryTextView.setText(restaurant.getCategories().get(0).getTitle());
        ratingTextView.setText("Rating: " + restaurant.getRating() + "/5");
    }


//    @Override
//    public void onItemSelected() {
//        itemView.animate()
//                .alpha(0.7f)
//                .scaleX(0.9f)
//                .scaleY(0.9f)
//                .setDuration(500);
//    }
//
//    @Override
//    public void onItemClear() {
//        itemView.animate()
//                .alpha(1f)
//                .scaleX(1f)
//                .scaleY(1f);
//    }
@Override
public void onItemSelected() {
    AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
            R.animator.drag_scale_on);
    set.setTarget(itemView);
    set.start();
}

    @Override
    public void onItemClear() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_off);
        set.setTarget(itemView);
        set.start();
    }


}
