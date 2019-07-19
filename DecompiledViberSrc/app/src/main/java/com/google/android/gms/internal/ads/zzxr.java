package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzare
@SafeParcelable.Class(creator="AdDataParcelCreator")
public final class zzxr extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzxr> CREATOR = new zzxs();

  @SafeParcelable.Field(id=1)
  public final String zzcgk;

  @SafeParcelable.Field(id=2)
  public final String zzcgl;

  @SafeParcelable.Constructor
  public zzxr(@SafeParcelable.Param(id=1) String paramString1, @SafeParcelable.Param(id=2) String paramString2)
  {
    this.zzcgk = paramString1;
    this.zzcgl = paramString2;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzcgk, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzcgl, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxr
 * JD-Core Version:    0.6.2
 */