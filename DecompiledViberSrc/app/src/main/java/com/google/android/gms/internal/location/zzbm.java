package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbm
{
  public static Looper zza(Looper paramLooper)
  {
    if (paramLooper != null)
      return paramLooper;
    return zzc();
  }

  public static Looper zzc()
  {
    if (Looper.myLooper() != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Can't create handler inside thread that has not called Looper.prepare()");
      return Looper.myLooper();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzbm
 * JD-Core Version:    0.6.2
 */