package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class zzpo
  implements Parcelable
{
  public static final Parcelable.Creator<zzpo> CREATOR = new zzpp();
  private final zza[] zzbhv;

  zzpo(Parcel paramParcel)
  {
    this.zzbhv = new zza[paramParcel.readInt()];
    for (int i = 0; i < this.zzbhv.length; i++)
      this.zzbhv[i] = ((zza)paramParcel.readParcelable(zza.class.getClassLoader()));
  }

  public zzpo(List<? extends zza> paramList)
  {
    this.zzbhv = new zza[paramList.size()];
    paramList.toArray(this.zzbhv);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    zzpo localzzpo = (zzpo)paramObject;
    return Arrays.equals(this.zzbhv, localzzpo.zzbhv);
  }

  public final int hashCode()
  {
    return Arrays.hashCode(this.zzbhv);
  }

  public final int length()
  {
    return this.zzbhv.length;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.zzbhv.length);
    zza[] arrayOfzza = this.zzbhv;
    int i = arrayOfzza.length;
    for (int j = 0; j < i; j++)
      paramParcel.writeParcelable(arrayOfzza[j], 0);
  }

  public final zza zzbc(int paramInt)
  {
    return this.zzbhv[paramInt];
  }

  public static abstract interface zza extends Parcelable
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpo
 * JD-Core Version:    0.6.2
 */