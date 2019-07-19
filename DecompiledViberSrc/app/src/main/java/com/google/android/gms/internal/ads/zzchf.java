package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public final class zzchf
  implements zzdth<PackageInfo>
{
  private final zzdtt<Context> zzeol;
  private final zzdtt<ApplicationInfo> zzfws;

  private zzchf(zzdtt<Context> paramzzdtt, zzdtt<ApplicationInfo> paramzzdtt1)
  {
    this.zzeol = paramzzdtt;
    this.zzfws = paramzzdtt1;
  }

  public static zzchf zzad(zzdtt<Context> paramzzdtt, zzdtt<ApplicationInfo> paramzzdtt1)
  {
    return new zzchf(paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzchf
 * JD-Core Version:    0.6.2
 */