package com.my.target;

import android.os.Parcelable;
import android.view.View;

public abstract interface cc
{
  public abstract void a();

  public abstract void a(Parcelable paramParcelable);

  public abstract Parcelable getState();

  public abstract int[] getVisibleCardNumbers();

  public abstract void setPromoCardSliderListener(a parama);

  public static abstract interface a
  {
    public abstract void a(View paramView, int paramInt);

    public abstract void a(View paramView, int[] paramArrayOfInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cc
 * JD-Core Version:    0.6.2
 */