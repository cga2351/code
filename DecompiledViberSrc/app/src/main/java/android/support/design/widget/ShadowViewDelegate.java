package android.support.design.widget;

import android.graphics.drawable.Drawable;

public abstract interface ShadowViewDelegate
{
  public abstract float getRadius();

  public abstract boolean isCompatPaddingEnabled();

  public abstract void setBackgroundDrawable(Drawable paramDrawable);

  public abstract void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.ShadowViewDelegate
 * JD-Core Version:    0.6.2
 */