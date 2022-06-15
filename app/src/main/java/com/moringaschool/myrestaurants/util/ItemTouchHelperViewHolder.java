package com.moringaschool.myrestaurants.util;

public interface ItemTouchHelperViewHolder {
    void onItemSelected(); //will handle updating the appearance of a selected item while the user is dragging-and-dropping it.
    void onItemClear(); //will remove the 'selected' state (and therefore the corresponding changes in appearance) from an item.
}
