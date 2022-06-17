package com.moringaschool.myrestaurants.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.moringaschool.myrestaurants.Constants;
import com.moringaschool.myrestaurants.R;
import com.moringaschool.myrestaurants.adapters.FirebaseRestaurantListAdapter;
import com.moringaschool.myrestaurants.adapters.FirebaseRestaurantViewHolder;
import com.moringaschool.myrestaurants.models.Business;
import com.moringaschool.myrestaurants.util.ItemTouchHelperAdapter;
import com.moringaschool.myrestaurants.util.OnStartDragListener;
import com.moringaschool.myrestaurants.util.SimpleItemTouchHelperCallback;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedRestaurantListActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_restaurant_list);
    }

}
//    private static final String TAG = SavedRestaurantListActivity.class.getSimpleName();
//
//    private DatabaseReference mRestaurantReference;
//    private FirebaseRecyclerAdapter<Business, FirebaseRestaurantViewHolder> mFirebaseAdapter;
//    private ItemTouchHelper mItemTouchHelper; //We add the ItemTouchHelper as a member variable so that we can use it in the OnStartDragListener's onStartDrag() method.
//
//
//
//
//
//    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
//    @BindView(R.id.errorTextView) TextView mErrorTextView;
//    @BindView(R.id.progressBar) ProgressBar mProgressBar;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_restaurants);
//        ButterKnife.bind(this);
//
//        //Retrieving User-Specific Data
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//
//        mRestaurantReference = FirebaseDatabase
//                .getInstance()
//                .getReference(Constants.FIREBASE_CHILD_RESTAURANTS)
//                .child(uid);
//
//        setUpFirebaseAdapter();
//        shoRestaurants();
//        hideProgressBar();
//    }
//
//
//
//
//    @Override
//    protected void onStart(){
//        super.onStart();
//        mFirebaseAdapter.startListening();
//    }
//    @Override
//    protected void onStop(){
//        super.onStop();
//        if(mFirebaseAdapter!= null){
//            mFirebaseAdapter.stopListening();
//        }
//
//    }
//    private void shoRestaurants(){
//        mRecyclerView.setVisibility(View.VISIBLE);
//    }
//    private void hideProgressBar(){
//        mProgressBar.setVisibility(View.GONE);
//    }
//
//
//    @Override
//    public void onStratDrag(RecyclerView.ViewHolder viewHolder) {
//        mItemTouchHelper.startDrag(viewHolder);
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mFirebaseAdapter.stopListening();
//    }
//}