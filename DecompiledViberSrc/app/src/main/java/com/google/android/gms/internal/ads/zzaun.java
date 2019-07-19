package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator="ServerSideVerificationOptionsParcelCreator")
public final class zzaun extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaun> CREATOR = new zzauo();

  @SafeParcelable.Field(id=1)
  public final String zzdqu;

  @SafeParcelable.Field(id=2)
  public final String zzdqv;

  public zzaun(ServerSideVerificationOptions paramServerSideVerificationOptions)
  {
    this(paramServerSideVerificationOptions.getUserId(), paramServerSideVerificationOptions.getCustomData());
  }

  @SafeParcelable.Constructor
  public zzaun(@SafeParcelable.Param(id=1) String paramString1, @SafeParcelable.Param(id=2) String paramString2)
  {
    this.zzdqu = paramString1;
    this.zzdqv = paramString2;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzdqu, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzdqv, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaun
 * JD-Core Version:    0.6.2
 */