package com.google.android.gms.maps.model;

public final class Gap extends PatternItem
{
  public final float length;

  public Gap(float paramFloat)
  {
    super(2, Float.valueOf(Math.max(paramFloat, 0.0F)));
    this.length = Math.max(paramFloat, 0.0F);
  }

  public final String toString()
  {
    float f = this.length;
    return 29 + "[Gap: length=" + f + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Gap
 * JD-Core Version:    0.6.2
 */