package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public abstract interface TintableImageSourceView
{
  public abstract ColorStateList getSupportImageTintList();

  public abstract PorterDuff.Mode getSupportImageTintMode();

  public abstract void setSupportImageTintList(ColorStateList paramColorStateList);

  public abstract void setSupportImageTintMode(PorterDuff.Mode paramMode);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.TintableImageSourceView
 * JD-Core Version:    0.6.2
 */