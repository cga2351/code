package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public abstract interface TintAwareDrawable
{
  public abstract void setTint(int paramInt);

  public abstract void setTintList(ColorStateList paramColorStateList);

  public abstract void setTintMode(PorterDuff.Mode paramMode);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.TintAwareDrawable
 * JD-Core Version:    0.6.2
 */