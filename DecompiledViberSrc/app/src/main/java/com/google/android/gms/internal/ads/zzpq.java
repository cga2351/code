package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class zzpq extends zzpv
{
  public static final Parcelable.Creator<zzpq> CREATOR = new zzpr();
  private final String description;
  private final String mimeType;
  private final int zzbhw;
  private final byte[] zzbhx;

  zzpq(Parcel paramParcel)
  {
    super("APIC");
    this.mimeType = paramParcel.readString();
    this.description = paramParcel.readString();
    this.zzbhw = paramParcel.readInt();
    this.zzbhx = paramParcel.createByteArray();
  }

  public zzpq(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    super("APIC");
    this.mimeType = paramString1;
    this.description = null;
    this.zzbhw = 3;
    this.zzbhx = paramArrayOfByte;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzpq localzzpq;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzpq = (zzpq)paramObject;
    }
    while ((this.zzbhw == localzzpq.zzbhw) && (zzsy.zza(this.mimeType, localzzpq.mimeType)) && (zzsy.zza(this.description, localzzpq.description)) && (Arrays.equals(this.zzbhx, localzzpq.zzbhx)));
    return false;
  }

  public final int hashCode()
  {
    int i = 31 * (527 + this.zzbhw);
    if (this.mimeType != null);
    for (int j = this.mimeType.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      String str = this.description;
      int m = 0;
      if (str != null)
        m = this.description.hashCode();
      return 31 * (k + m) + Arrays.hashCode(this.zzbhx);
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.zzbhw);
    paramParcel.writeByteArray(this.zzbhx);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpq
 * JD-Core Version:    0.6.2
 */