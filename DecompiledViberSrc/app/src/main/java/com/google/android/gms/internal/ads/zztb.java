package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class zztb
  implements Parcelable
{
  public static final Parcelable.Creator<zztb> CREATOR = new zztc();
  private int zzafx;
  public final int zzbbo;
  public final int zzbbp;
  public final int zzbbq;
  public final byte[] zzbnt;

  public zztb(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.zzbbo = paramInt1;
    this.zzbbq = paramInt2;
    this.zzbbp = paramInt3;
    this.zzbnt = paramArrayOfByte;
  }

  zztb(Parcel paramParcel)
  {
    this.zzbbo = paramParcel.readInt();
    this.zzbbq = paramParcel.readInt();
    this.zzbbp = paramParcel.readInt();
    int i;
    if (paramParcel.readInt() != 0)
    {
      i = 1;
      if (i == 0)
        break label57;
    }
    label57: for (byte[] arrayOfByte = paramParcel.createByteArray(); ; arrayOfByte = null)
    {
      this.zzbnt = arrayOfByte;
      return;
      i = 0;
      break;
    }
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zztb localzztb;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzztb = (zztb)paramObject;
    }
    while ((this.zzbbo == localzztb.zzbbo) && (this.zzbbq == localzztb.zzbbq) && (this.zzbbp == localzztb.zzbbp) && (Arrays.equals(this.zzbnt, localzztb.zzbnt)));
    return false;
  }

  public final int hashCode()
  {
    if (this.zzafx == 0)
      this.zzafx = (31 * (31 * (31 * (527 + this.zzbbo) + this.zzbbq) + this.zzbbp) + Arrays.hashCode(this.zzbnt));
    return this.zzafx;
  }

  public final String toString()
  {
    int i = this.zzbbo;
    int j = this.zzbbq;
    int k = this.zzbbp;
    if (this.zzbnt != null);
    for (boolean bool = true; ; bool = false)
      return 55 + "ColorInfo(" + i + ", " + j + ", " + k + ", " + bool + ")";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.zzbbo);
    paramParcel.writeInt(this.zzbbq);
    paramParcel.writeInt(this.zzbbp);
    if (this.zzbnt != null);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.zzbnt != null)
        paramParcel.writeByteArray(this.zzbnt);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zztb
 * JD-Core Version:    0.6.2
 */