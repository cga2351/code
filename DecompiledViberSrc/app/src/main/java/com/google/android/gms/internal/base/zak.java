package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

public final class zak extends LruCache<Object, Drawable>
{
  public zak()
  {
    super(10);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.base.zak
 * JD-Core Version:    0.6.2
 */