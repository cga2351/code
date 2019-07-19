package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator="AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzarl extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzarl> CREATOR = new zzarm();

  @SafeParcelable.Field(id=2)
  public final boolean zzdoo;

  @SafeParcelable.Field(id=3)
  public final List<String> zzdop;

  public zzarl()
  {
    this(false, Collections.emptyList());
  }

  @SafeParcelable.Constructor
  public zzarl(@SafeParcelable.Param(id=2) boolean paramBoolean, @SafeParcelable.Param(id=3) List<String> paramList)
  {
    this.zzdoo = paramBoolean;
    this.zzdop = paramList;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzdoo);
    SafeParcelWriter.writeStringList(paramParcel, 3, this.zzdop, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzarl
 * JD-Core Version:    0.6.2
 */