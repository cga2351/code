package com.google.android.gms.internal.gcm;

import android.os.Parcel;
import android.os.Parcelable;

public class zze
{
  private static final ClassLoader zzf = zze.class.getClassLoader();

  public static void zzd(Parcel paramParcel, Parcelable paramParcelable)
  {
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zze
 * JD-Core Version:    0.6.2
 */