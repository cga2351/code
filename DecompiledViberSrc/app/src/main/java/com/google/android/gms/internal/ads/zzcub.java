package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public final class zzcub
  implements zzdth<zzcua>
{
  private final zzdtt<PackageInfo> zzfwk;
  private final zzdtt<ApplicationInfo> zzfws;

  private zzcub(zzdtt<ApplicationInfo> paramzzdtt, zzdtt<PackageInfo> paramzzdtt1)
  {
    this.zzfws = paramzzdtt;
    this.zzfwk = paramzzdtt1;
  }

  public static zzcub zzaq(zzdtt<ApplicationInfo> paramzzdtt, zzdtt<PackageInfo> paramzzdtt1)
  {
    return new zzcub(paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcub
 * JD-Core Version:    0.6.2
 */