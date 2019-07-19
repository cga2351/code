package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;
import java.util.List;

@zzare
public final class zzbcy extends zzbcq
{
  public final zzbcp zza(Context paramContext, zzbdg paramzzbdg, int paramInt, boolean paramBoolean, zzadh paramzzadh, zzbdf paramzzbdf)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    if ((PlatformVersion.isAtLeastIceCreamSandwich()) && ((localApplicationInfo == null) || (localApplicationInfo.targetSdkVersion >= 11)));
    for (int i = 1; i == 0; i = 0)
      return null;
    zzbdh localzzbdh = new zzbdh(paramContext, paramzzbdg.zzyh(), paramzzbdg.zzyf(), paramzzadh, paramzzbdg.zzyc());
    int j;
    if ((Build.VERSION.SDK_INT >= 16) && (paramInt == 2))
      j = 1;
    while (j != 0)
    {
      List localList = Arrays.asList(paramzzbdf.zzeei.split(","));
      if (localList.contains("3"))
      {
        return new zzbel(paramContext, localzzbdh, paramzzbdg, paramBoolean, zza(paramzzbdg), paramzzbdf);
        j = 0;
      }
      else if (localList.contains("1"))
      {
        return new zzbdr(paramContext, localzzbdh, paramzzbdg, paramInt, paramBoolean, zza(paramzzbdg), paramzzbdf);
      }
    }
    zzbce localzzbce = new zzbce(paramContext, paramBoolean, zza(paramzzbdg), paramzzbdf, new zzbdh(paramContext, paramzzbdg.zzyh(), paramzzbdg.zzyf(), paramzzadh, paramzzbdg.zzyc()));
    return localzzbce;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbcy
 * JD-Core Version:    0.6.2
 */