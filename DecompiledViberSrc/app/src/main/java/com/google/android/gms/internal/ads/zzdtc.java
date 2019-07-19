package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzdtc
{
  public static final zzdtc zzhuc = new zzdtc(1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  private static final zzdtc zzhud = new zzdtc(0.0D, 1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  private static final zzdtc zzhue = new zzdtc(-1.0D, 0.0D, 0.0D, -1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  private static final zzdtc zzhuf = new zzdtc(0.0D, -1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
  private final double a;
  private final double b;
  private final double c;
  private final double d;
  private final double w;
  private final double zzhty;
  private final double zzhtz;
  private final double zzhua;
  private final double zzhub;

  private zzdtc(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
  {
    this.zzhty = paramDouble5;
    this.zzhtz = paramDouble6;
    this.w = paramDouble7;
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.c = paramDouble3;
    this.d = paramDouble4;
    this.zzhua = paramDouble8;
    this.zzhub = paramDouble9;
  }

  public static zzdtc zzp(ByteBuffer paramByteBuffer)
  {
    double d1 = zzbc.zzd(paramByteBuffer);
    double d2 = zzbc.zzd(paramByteBuffer);
    double d3 = zzbc.zze(paramByteBuffer);
    double d4 = zzbc.zzd(paramByteBuffer);
    double d5 = zzbc.zzd(paramByteBuffer);
    double d6 = zzbc.zze(paramByteBuffer);
    double d7 = zzbc.zzd(paramByteBuffer);
    double d8 = zzbc.zzd(paramByteBuffer);
    return new zzdtc(d1, d2, d4, d5, d3, d6, zzbc.zze(paramByteBuffer), d7, d8);
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzdtc localzzdtc;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzdtc = (zzdtc)paramObject;
      if (Double.compare(localzzdtc.a, this.a) != 0)
        return false;
      if (Double.compare(localzzdtc.b, this.b) != 0)
        return false;
      if (Double.compare(localzzdtc.c, this.c) != 0)
        return false;
      if (Double.compare(localzzdtc.d, this.d) != 0)
        return false;
      if (Double.compare(localzzdtc.zzhua, this.zzhua) != 0)
        return false;
      if (Double.compare(localzzdtc.zzhub, this.zzhub) != 0)
        return false;
      if (Double.compare(localzzdtc.zzhty, this.zzhty) != 0)
        return false;
      if (Double.compare(localzzdtc.zzhtz, this.zzhtz) != 0)
        return false;
    }
    while (Double.compare(localzzdtc.w, this.w) == 0);
    return false;
  }

  public final int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.zzhty);
    int i = (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.zzhtz);
    int j = i * 31 + (int)(l2 ^ l2 >>> 32);
    long l3 = Double.doubleToLongBits(this.w);
    int k = j * 31 + (int)(l3 ^ l3 >>> 32);
    long l4 = Double.doubleToLongBits(this.a);
    int m = k * 31 + (int)(l4 ^ l4 >>> 32);
    long l5 = Double.doubleToLongBits(this.b);
    int n = m * 31 + (int)(l5 ^ l5 >>> 32);
    long l6 = Double.doubleToLongBits(this.c);
    int i1 = n * 31 + (int)(l6 ^ l6 >>> 32);
    long l7 = Double.doubleToLongBits(this.d);
    int i2 = i1 * 31 + (int)(l7 ^ l7 >>> 32);
    long l8 = Double.doubleToLongBits(this.zzhua);
    int i3 = i2 * 31 + (int)(l8 ^ l8 >>> 32);
    long l9 = Double.doubleToLongBits(this.zzhub);
    return i3 * 31 + (int)(l9 ^ l9 >>> 32);
  }

  public final String toString()
  {
    if (equals(zzhuc))
      return "Rotate 0°";
    if (equals(zzhud))
      return "Rotate 90°";
    if (equals(zzhue))
      return "Rotate 180°";
    if (equals(zzhuf))
      return "Rotate 270°";
    double d1 = this.zzhty;
    double d2 = this.zzhtz;
    double d3 = this.w;
    double d4 = this.a;
    double d5 = this.b;
    double d6 = this.c;
    double d7 = this.d;
    double d8 = this.zzhua;
    double d9 = this.zzhub;
    StringBuilder localStringBuilder = new StringBuilder(260);
    return "Matrix{u=" + d1 + ", v=" + d2 + ", w=" + d3 + ", a=" + d4 + ", b=" + d5 + ", c=" + d6 + ", d=" + d7 + ", tx=" + d8 + ", ty=" + d9 + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtc
 * JD-Core Version:    0.6.2
 */