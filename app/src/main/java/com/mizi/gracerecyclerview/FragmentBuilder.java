package com.mizi.gracerecyclerview;

public class FragmentBuilder<FB extends FragmentBuilder> {
    private int layoutResId;

    public int getLayoutResId() {
        return layoutResId;
    }

    public FB setLayoutResId(int layoutResId) {
        this.layoutResId = layoutResId;
        return (FB) this;
    }

    public <F extends BaseFragment> F build(Class<F> kind) {
        F fragment = null;
        try {
            fragment = kind.newInstance();
            fragment.setBuilder(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
        return fragment;
    }
}
