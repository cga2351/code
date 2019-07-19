package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="InitializationParamsCreator")
public final class zzdy extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdy> CREATOR = new zzdz();

  @SafeParcelable.Field(id=5)
  public final String origin;

  @SafeParcelable.Field(id=1)
  public final long zzade;

  @SafeParcelable.Field(id=2)
  public final long zzadf;

  @SafeParcelable.Field(id=3)
  public final boolean zzadg;

  @SafeParcelable.Field(id=4)
  public final String zzadh;

  @SafeParcelable.Field(id=6)
  public final String zzadi;

  @SafeParcelable.Field(id=7)
  public final Bundle zzadj;

  @SafeParcelable.Constructor
  zzdy(@SafeParcelable.Param(id=1) long paramLong1, @SafeParcelable.Param(id=2) long paramLong2, @SafeParcelable.Param(id=3) boolean paramBoolean, @SafeParcelable.Param(id=4) String paramString1, @SafeParcelable.Param(id=5) String paramString2, @SafeParcelable.Param(id=6) String paramString3, @SafeParcelable.Param(id=7) Bundle paramBundle)
  {
    this.zzade = paramLong1;
    this.zzadf = paramLong2;
    this.zzadg = paramBoolean;
    this.zzadh = paramString1;
    this.origin = paramString2;
    this.zzadi = paramString3;
    this.zzadj = paramBundle;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, this.zzade);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzadf);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzadg);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzadh, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.origin, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzadi, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzadj, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdy
 * JD-Core Version:    0.6.2
 */