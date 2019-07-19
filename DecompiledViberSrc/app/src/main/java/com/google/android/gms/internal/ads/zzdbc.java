package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="GassResponseParcelCreator")
public final class zzdbc extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdbc> CREATOR = new zzdbd();

  @SafeParcelable.VersionField(id=1)
  private final int versionCode;

  @SafeParcelable.Field(getter="getAfmaSignalsAsBytes", id=2, type="byte[]")
  private zzbp.zza zzgow;
  private byte[] zzgox;

  @SafeParcelable.Constructor
  zzdbc(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) byte[] paramArrayOfByte)
  {
    this.versionCode = paramInt;
    this.zzgow = null;
    this.zzgox = paramArrayOfByte;
    zzano();
  }

  private final void zzano()
  {
    if ((this.zzgow == null) && (this.zzgox != null));
    while ((this.zzgow != null) && (this.zzgox == null))
      return;
    if ((this.zzgow != null) && (this.zzgox != null))
      throw new IllegalStateException("Invalid internal representation - full");
    if ((this.zzgow == null) && (this.zzgox == null))
      throw new IllegalStateException("Invalid internal representation - empty");
    throw new IllegalStateException("Impossible");
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    if (this.zzgox != null);
    for (byte[] arrayOfByte = this.zzgox; ; arrayOfByte = this.zzgow.toByteArray())
    {
      SafeParcelWriter.writeByteArray(paramParcel, 2, arrayOfByte, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
    }
  }

  public final zzbp.zza zzann()
  {
    int i;
    if (this.zzgow != null)
      i = 1;
    while (true)
    {
      if (i == 0);
      try
      {
        this.zzgow = zzbp.zza.zzb(this.zzgox, zzdnn.zzaxe());
        this.zzgox = null;
        zzano();
        return this.zzgow;
        i = 0;
      }
      catch (zzdoj localzzdoj)
      {
        throw new IllegalStateException(localzzdoj);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbc
 * JD-Core Version:    0.6.2
 */