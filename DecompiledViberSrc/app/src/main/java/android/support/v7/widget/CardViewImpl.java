package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;

abstract interface CardViewImpl
{
  public abstract ColorStateList getBackgroundColor(CardViewDelegate paramCardViewDelegate);

  public abstract float getElevation(CardViewDelegate paramCardViewDelegate);

  public abstract float getMaxElevation(CardViewDelegate paramCardViewDelegate);

  public abstract float getMinHeight(CardViewDelegate paramCardViewDelegate);

  public abstract float getMinWidth(CardViewDelegate paramCardViewDelegate);

  public abstract float getRadius(CardViewDelegate paramCardViewDelegate);

  public abstract void initStatic();

  public abstract void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3);

  public abstract void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate);

  public abstract void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate);

  public abstract void setBackgroundColor(CardViewDelegate paramCardViewDelegate, ColorStateList paramColorStateList);

  public abstract void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat);

  public abstract void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat);

  public abstract void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat);

  public abstract void updatePadding(CardViewDelegate paramCardViewDelegate);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.CardViewImpl
 * JD-Core Version:    0.6.2
 */