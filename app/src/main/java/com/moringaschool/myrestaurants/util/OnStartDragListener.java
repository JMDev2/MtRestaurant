package com.moringaschool.myrestaurants.util;

import androidx.recyclerview.widget.RecyclerView;

public interface OnStartDragListener {

    //will be called when the user begins a drag and drop interaction with the touch screen
    //implimented in the saved restaurant List activity
    void onStratDrag(RecyclerView.ViewHolder viewHolder);
}
