package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzacz
{
  public static void zza(zzacx paramzzacx, zzacw paramzzacw)
  {
    if (paramzzacw.getContext() == null)
      throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
    if (TextUtils.isEmpty(paramzzacw.zzmg()))
      throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
    paramzzacx.zza(paramzzacw.getContext(), paramzzacw.zzmg(), paramzzacw.zzqr(), paramzzacw.zzqs());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzacz
 * JD-Core Version:    0.6.2
 */