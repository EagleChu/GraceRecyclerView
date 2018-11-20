package com.mizi.lib.rv.event;

import android.view.View;

public interface ClickEvent extends Event {
    int[] getEventIds();
    View.OnClickListener getClickListener();
}
