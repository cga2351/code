package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@zzare
@SafeParcelable.Class(creator="VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzacc extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzacc> CREATOR = new zzacd();

  @SafeParcelable.Field(id=2)
  public final boolean zzaax;

  @SafeParcelable.Field(id=3)
  public final boolean zzaay;

  @SafeParcelable.Field(id=4)
  public final boolean zzaaz;

  public zzacc(VideoOptions paramVideoOptions)
  {
    this(paramVideoOptions.getStartMuted(), paramVideoOptions.getCustomControlsRequested(), paramVideoOptions.getClickToExpandRequested());
  }

  @SafeParcelable.Constructor
  public zzacc(@SafeParcelable.Param(id=2) boolean paramBoolean1, @SafeParcelable.Param(id=3) boolean paramBoolean2, @SafeParcelable.Param(id=4) boolean paramBoolean3)
  {
    this.zzaax = paramBoolean1;
    this.zzaay = paramBoolean2;
    this.zzaaz = paramBoolean3;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzaax);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzaay);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzaaz);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzacc
 * JD-Core Version:    0.6.2
 */