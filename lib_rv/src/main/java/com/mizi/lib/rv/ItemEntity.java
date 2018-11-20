package com.mizi.lib.rv;

public class ItemEntity<Entity> extends ItemData {
    public Entity entity;
    public Object extra;

    public <T> T getExtra() {
        return (T) extra;
    }
}
