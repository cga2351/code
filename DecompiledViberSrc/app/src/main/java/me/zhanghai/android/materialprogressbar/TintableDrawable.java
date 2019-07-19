package me.zhanghai.android.materialprogressbar;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public abstract interface TintableDrawable
{
  public abstract void setTint(int paramInt);

  public abstract void setTintList(ColorStateList paramColorStateList);

  public abstract void setTintMode(PorterDuff.Mode paramMode);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.TintableDrawable
 * JD-Core Version:    0.6.2
 */