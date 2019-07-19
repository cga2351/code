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
@SafeParcelable.Class(creator="ExceptionParcelCreator")
public final class zzayn extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzayn> CREATOR = new zzayp();

  @SafeParcelable.Field(id=2)
  public final int errorCode;

  @SafeParcelable.Field(id=1)
  public final String zzdwx;

  @SafeParcelable.Constructor
  zzayn(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) int paramInt)
  {
    if (paramString == null)
      paramString = "";
    this.zzdwx = paramString;
    this.errorCode = paramInt;
  }

  public static zzayn zza(Throwable paramThrowable, int paramInt)
  {
    return new zzayn(paramThrowable.getMessage(), paramInt);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzdwx, false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.errorCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayn
 * JD-Core Version:    0.6.2
 */