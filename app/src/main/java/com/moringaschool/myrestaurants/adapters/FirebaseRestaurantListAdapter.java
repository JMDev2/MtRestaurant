package com.moringaschool.myrestaurants.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.moringaschool.myrestaurants.R;
import com.moringaschool.myrestaurants.models.Business;
import com.moringaschool.myrestaurants.util.ItemTouchHelperAdapter;
import com.moringaschool.myrestaurants.util.OnStartDragListener;

public class FirebaseRestaurantListAdapter extends FirebaseRecyclerAdapter<Business, FirebaseRestaurantViewHolder> implements ItemTouchHelperAdapter {
    private OnStartDragListener mOnStartDragListener; //drag member variable
    private DatabaseReference mRef;
//    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseRestaurantListAdapter(@NonNull FirebaseRecyclerOptions<Business> options, DatabaseReference mRef, OnStartDragListener mOnStartDragListener, Context mContext) {
        super(options);
        this.mRef = mRef.getRef();
        this.mOnStartDragListener = mOnStartDragListener;
        this.mContext = mContext;
    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseRestaurantViewHolder firebaseRestaurantViewHolder, int position, @NonNull Business restaurant) {
        firebaseRestaurantViewHolder.bindRestaurant(restaurant);
        firebaseRestaurantViewHolder.mRestaurantImageViews.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getActionMasked() == MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStratDrag(firebaseRestaurantViewHolder);
                }
                return false;
            }
        });

    }

    @NonNull
    @Override
    public FirebaseRestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item_drag, parent,false);
        return new FirebaseRestaurantViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }
}
