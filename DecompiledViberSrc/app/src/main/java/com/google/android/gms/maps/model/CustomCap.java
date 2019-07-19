package com.google.android.gms.maps.model;

public final class CustomCap extends Cap
{
  public final BitmapDescriptor bitmapDescriptor;
  public final float refWidth;

  public CustomCap(BitmapDescriptor paramBitmapDescriptor)
  {
    this(paramBitmapDescriptor, 10.0F);
  }

  public CustomCap(BitmapDescriptor paramBitmapDescriptor, float paramFloat)
  {
    super(localBitmapDescriptor, paramFloat);
    this.bitmapDescriptor = paramBitmapDescriptor;
    this.refWidth = paramFloat;
  }

  public final String toString()
  {
    String str = String.valueOf(this.bitmapDescriptor);
    float f = this.refWidth;
    return 55 + String.valueOf(str).length() + "[CustomCap: bitmapDescriptor=" + str + " refWidth=" + f + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CustomCap
 * JD-Core Version:    0.6.2
 */