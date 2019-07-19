package com.viber.jni;

public class LocationEx
{
  public int altitude;
  public int horizontal_accuracy;
  public int latitude;
  public int longitude;
  public int speed;
  public int vertical_accuracy;

  public LocationEx(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.longitude = paramInt1;
    this.latitude = paramInt2;
    this.altitude = paramInt3;
    this.horizontal_accuracy = paramInt4;
    this.vertical_accuracy = paramInt5;
    this.speed = paramInt6;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.LocationEx
 * JD-Core Version:    0.6.2
 */