package com.mizi.lib.rv.builder;


import com.mizi.lib.rv.event.EventAdapter;

public abstract class AdapterBuilder {

    public <EA extends EventAdapter> EA build(Class<EA> kind){
        EA adapter = null;
        Class[] arg = new Class[1];
        try {
            adapter = kind.newInstance();
            adapter.setBuilder(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return adapter;
    }

}

