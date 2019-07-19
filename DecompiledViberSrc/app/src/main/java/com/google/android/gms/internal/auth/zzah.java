package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="UserChallengeRequestCreator")
public final class zzah extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzah> CREATOR = new zzai();

  @SafeParcelable.Field(id=2)
  private final String accountType;

  @SafeParcelable.Field(id=3)
  private final PendingIntent zzbx;

  @SafeParcelable.VersionField(id=1)
  private final int zzv = 1;

  @SafeParcelable.Constructor
  zzah(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) PendingIntent paramPendingIntent)
  {
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    this.zzbx = ((PendingIntent)Preconditions.checkNotNull(paramPendingIntent));
  }

  public zzah(String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramString, paramPendingIntent);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzv);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzbx, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzah
 * JD-Core Version:    0.6.2
 */