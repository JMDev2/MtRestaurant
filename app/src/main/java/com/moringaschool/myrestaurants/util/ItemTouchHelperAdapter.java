package com.moringaschool.myrestaurants.util;

public interface ItemTouchHelperAdapter {

    //will be called each time the user moves an item by dragging it acrossthe touch screen ie
    // fromPosition  > toPosition
    boolean  onItemMove(int fromPosition, int toPosition);

    //Called when an item has been dismissed with a swipe motion
    void onItemDismiss(int position);
}
