package com.facebook.react.uimanager;

import android.graphics.Rect;

public abstract interface ReactClippingViewGroup
{
  public abstract void getClippingRect(Rect paramRect);

  public abstract boolean getRemoveClippedSubviews();

  public abstract void setRemoveClippedSubviews(boolean paramBoolean);

  public abstract void updateClippingRect();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactClippingViewGroup
 * JD-Core Version:    0.6.2
 */