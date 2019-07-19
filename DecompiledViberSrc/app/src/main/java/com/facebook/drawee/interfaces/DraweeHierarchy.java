package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface DraweeHierarchy
{
  public abstract Drawable getTopLevelDrawable();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.interfaces.DraweeHierarchy
 * JD-Core Version:    0.6.2
 */