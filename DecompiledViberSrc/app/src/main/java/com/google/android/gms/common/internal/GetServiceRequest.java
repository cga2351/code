package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@SafeParcelable.Class(creator="GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();

  @SafeParcelable.VersionField(id=1)
  private final int version;

  @SafeParcelable.Field(id=2)
  private final int zzdf;

  @SafeParcelable.Field(id=3)
  private int zzdg;

  @SafeParcelable.Field(id=4)
  String zzdh;

  @SafeParcelable.Field(id=5)
  IBinder zzdi;

  @SafeParcelable.Field(id=6)
  Scope[] zzdj;

  @SafeParcelable.Field(id=7)
  Bundle zzdk;

  @SafeParcelable.Field(id=8)
  Account zzdl;

  @SafeParcelable.Field(id=10)
  Feature[] zzdm;

  @SafeParcelable.Field(id=11)
  Feature[] zzdn;

  @SafeParcelable.Field(id=12)
  private boolean zzdo;

  public GetServiceRequest(int paramInt)
  {
    this.version = 4;
    this.zzdg = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzdf = paramInt;
    this.zzdo = true;
  }

  @SafeParcelable.Constructor
  GetServiceRequest(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) int paramInt3, @SafeParcelable.Param(id=4) String paramString, @SafeParcelable.Param(id=5) IBinder paramIBinder, @SafeParcelable.Param(id=6) Scope[] paramArrayOfScope, @SafeParcelable.Param(id=7) Bundle paramBundle, @SafeParcelable.Param(id=8) Account paramAccount, @SafeParcelable.Param(id=10) Feature[] paramArrayOfFeature1, @SafeParcelable.Param(id=11) Feature[] paramArrayOfFeature2, @SafeParcelable.Param(id=12) boolean paramBoolean)
  {
    this.version = paramInt1;
    this.zzdf = paramInt2;
    this.zzdg = paramInt3;
    Account localAccount;
    if ("com.google.android.gms".equals(paramString))
    {
      this.zzdh = "com.google.android.gms";
      if (paramInt1 >= 2)
        break label104;
      localAccount = null;
      if (paramIBinder != null)
        localAccount = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(paramIBinder));
    }
    for (this.zzdl = localAccount; ; this.zzdl = paramAccount)
    {
      this.zzdj = paramArrayOfScope;
      this.zzdk = paramBundle;
      this.zzdm = paramArrayOfFeature1;
      this.zzdn = paramArrayOfFeature2;
      this.zzdo = paramBoolean;
      return;
      this.zzdh = paramString;
      break;
      label104: this.zzdi = paramIBinder;
    }
  }

  @KeepForSdk
  public Bundle getExtraArgs()
  {
    return this.zzdk;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.version);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzdf);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzdg);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzdh, false);
    SafeParcelWriter.writeIBinder(paramParcel, 5, this.zzdi, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 6, this.zzdj, paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzdk, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzdl, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 10, this.zzdm, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 11, this.zzdn, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 12, this.zzdo);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.GetServiceRequest
 * JD-Core Version:    0.6.2
 */