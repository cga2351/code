package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class DrawableProperties
{
  private static final int UNSET = -1;
  private int mAlpha = -1;
  private ColorFilter mColorFilter = null;
  private int mDither = -1;
  private int mFilterBitmap = -1;
  private boolean mIsSetColorFilter = false;

  @SuppressLint({"Range"})
  public void applyTo(Drawable paramDrawable)
  {
    boolean bool1 = true;
    if (paramDrawable == null);
    boolean bool2;
    do
    {
      return;
      if (this.mAlpha != -1)
        paramDrawable.setAlpha(this.mAlpha);
      if (this.mIsSetColorFilter)
        paramDrawable.setColorFilter(this.mColorFilter);
      if (this.mDither != -1)
      {
        if (this.mDither == 0)
          break;
        bool2 = bool1;
        paramDrawable.setDither(bool2);
      }
    }
    while (this.mFilterBitmap == -1);
    if (this.mFilterBitmap != 0);
    while (true)
    {
      paramDrawable.setFilterBitmap(bool1);
      return;
      bool2 = false;
      break;
      bool1 = false;
    }
  }

  public void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mColorFilter = paramColorFilter;
    this.mIsSetColorFilter = true;
  }

  public void setDither(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      this.mDither = i;
      return;
    }
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      this.mFilterBitmap = i;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.DrawableProperties
 * JD-Core Version:    0.6.2
 */