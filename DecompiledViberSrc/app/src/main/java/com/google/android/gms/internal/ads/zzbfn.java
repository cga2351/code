package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;

@zzare
public final class zzbfn
  implements zzbge
{
  public final zzbfu zza(zzbdg paramzzbdg, int paramInt, String paramString, zzbdf paramzzbdf)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (paramInt > 0))
    {
      List localList = Arrays.asList(paramzzbdf.zzeei.split(","));
      if (localList.contains("3"))
      {
        int j = zzbfb.zzyq();
        if (j < paramzzbdf.zzeel)
          return new zzbgq(paramzzbdg, paramzzbdf);
        if (j < paramzzbdf.zzeef)
          return new zzbgp(paramzzbdg, paramzzbdf);
        return new zzbgg(paramzzbdg);
      }
      if (localList.contains("1"))
      {
        int i = zzbdl.zzyq();
        if (i < paramzzbdf.zzeel)
        {
          if (paramInt == 1)
            return new zzbgl(paramzzbdg);
          if (paramInt == 2)
            return new zzbgi(paramzzbdg, null);
        }
        if (i < paramzzbdf.zzeef)
          return new zzbgh(paramzzbdg, paramzzbdf);
        return new zzbgg(paramzzbdg);
      }
    }
    return new zzbgf(paramzzbdg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfn
 * JD-Core Version:    0.6.2
 */