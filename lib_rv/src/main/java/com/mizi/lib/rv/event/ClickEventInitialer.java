package com.mizi.lib.rv.event;

import android.view.View;

public interface ClickEventInitialer extends EventInitialer {
    int[] getEventIds();
    View.OnClickListener getClickListener();
}
