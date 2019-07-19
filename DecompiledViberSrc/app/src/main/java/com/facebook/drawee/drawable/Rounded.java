package com.facebook.drawee.drawable;

public abstract interface Rounded
{
  public abstract int getBorderColor();

  public abstract float getBorderWidth();

  public abstract float getPadding();

  public abstract float[] getRadii();

  public abstract boolean getScaleDownInsideBorders();

  public abstract boolean isCircle();

  public abstract void setBorder(int paramInt, float paramFloat);

  public abstract void setCircle(boolean paramBoolean);

  public abstract void setPadding(float paramFloat);

  public abstract void setRadii(float[] paramArrayOfFloat);

  public abstract void setRadius(float paramFloat);

  public abstract void setScaleDownInsideBorders(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.Rounded
 * JD-Core Version:    0.6.2
 */