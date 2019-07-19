package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzare
@SafeParcelable.Class(creator="MediationConfigurationParcelCreator")
public final class zzaix extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaix> CREATOR = new zzaiy();

  @SafeParcelable.Field(id=2)
  public final Bundle extras;

  @SafeParcelable.Field(id=1)
  public final String zzdbf;

  @SafeParcelable.Constructor
  public zzaix(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) Bundle paramBundle)
  {
    this.zzdbf = paramString;
    this.extras = paramBundle;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzdbf, false);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.extras, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaix
 * JD-Core Version:    0.6.2
 */