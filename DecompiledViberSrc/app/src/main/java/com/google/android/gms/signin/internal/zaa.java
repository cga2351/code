package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="AuthAccountResultCreator")
public final class zaa extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<zaa> CREATOR = new zab();

  @SafeParcelable.VersionField(id=1)
  private final int zale;

  @SafeParcelable.Field(getter="getConnectionResultCode", id=2)
  private int zarw;

  @SafeParcelable.Field(getter="getRawAuthResolutionIntent", id=3)
  private Intent zarx;

  public zaa()
  {
    this(0, null);
  }

  @SafeParcelable.Constructor
  zaa(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) Intent paramIntent)
  {
    this.zale = paramInt1;
    this.zarw = paramInt2;
    this.zarx = paramIntent;
  }

  private zaa(int paramInt, Intent paramIntent)
  {
    this(2, 0, null);
  }

  public final Status getStatus()
  {
    if (this.zarw == 0)
      return Status.RESULT_SUCCESS;
    return Status.RESULT_CANCELED;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zarw);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zarx, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.zaa
 * JD-Core Version:    0.6.2
 */