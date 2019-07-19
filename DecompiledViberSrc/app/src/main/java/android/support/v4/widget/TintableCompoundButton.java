package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public abstract interface TintableCompoundButton
{
  public abstract ColorStateList getSupportButtonTintList();

  public abstract PorterDuff.Mode getSupportButtonTintMode();

  public abstract void setSupportButtonTintList(ColorStateList paramColorStateList);

  public abstract void setSupportButtonTintMode(PorterDuff.Mode paramMode);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.TintableCompoundButton
 * JD-Core Version:    0.6.2
 */