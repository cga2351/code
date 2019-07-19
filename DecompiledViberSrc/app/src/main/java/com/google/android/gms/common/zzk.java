package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="GoogleCertificatesQueryCreator")
public final class zzk extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzk> CREATOR = new zzl();

  @SafeParcelable.Field(getter="getAllowTestKeys", id=3)
  private final boolean zzaa;

  @SafeParcelable.Field(getter="getCallingPackage", id=1)
  private final String zzy;

  @Nullable
  @SafeParcelable.Field(getter="getCallingCertificateBinder", id=2, type="android.os.IBinder")
  private final zze zzz;

  @SafeParcelable.Constructor
  zzk(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) @Nullable IBinder paramIBinder, @SafeParcelable.Param(id=3) boolean paramBoolean)
  {
    this.zzy = paramString;
    this.zzz = zza(paramIBinder);
    this.zzaa = paramBoolean;
  }

  zzk(String paramString, @Nullable zze paramzze, boolean paramBoolean)
  {
    this.zzy = paramString;
    this.zzz = paramzze;
    this.zzaa = paramBoolean;
  }

  @Nullable
  private static zze zza(@Nullable IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    while (true)
    {
      IObjectWrapper localIObjectWrapper;
      try
      {
        localIObjectWrapper = zzj.zzb(paramIBinder).zzb();
        if (localIObjectWrapper == null)
        {
          arrayOfByte = null;
          if (arrayOfByte == null)
            break label66;
          localzzf = new zzf(arrayOfByte);
          return localzzf;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", localRemoteException);
        return null;
      }
      byte[] arrayOfByte = (byte[])ObjectWrapper.unwrap(localIObjectWrapper);
      continue;
      label66: Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
      zzf localzzf = null;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzy, false);
    if (this.zzz == null)
      Log.w("GoogleCertificatesQuery", "certificate binder is null");
    for (IBinder localIBinder = null; ; localIBinder = this.zzz.asBinder())
    {
      SafeParcelWriter.writeIBinder(paramParcel, 2, localIBinder, false);
      SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzaa);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zzk
 * JD-Core Version:    0.6.2
 */