package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

@zzare
public final class zzahr<T extends zzbhy,  extends zzbhz,  extends zzbid,  extends zzbig,  extends zzbii>
  implements zzahn<T>
{
  private final zzb zzdan;
  private final zzaps zzdao;

  public zzahr(zzb paramzzb, zzaps paramzzaps)
  {
    this.zzdan = paramzzb;
    this.zzdao = paramzzaps;
  }

  @VisibleForTesting
  static String zza(Context paramContext, zzdh paramzzdh, String paramString, View paramView, Activity paramActivity)
  {
    if (paramzzdh == null)
      return paramString;
    try
    {
      Uri localUri = Uri.parse(paramString);
      if (paramzzdh.zzd(localUri))
        localUri = paramzzdh.zza(localUri, paramContext, paramView, paramActivity);
      String str = localUri.toString();
      return str;
    }
    catch (Exception localException)
    {
      zzk.zzlk().zza(localException, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
      return paramString;
    }
    catch (zzdi localzzdi)
    {
    }
    return paramString;
  }

  private static boolean zzc(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }

  private static int zzd(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("o");
    if (str != null)
    {
      if ("p".equalsIgnoreCase(str))
      {
        zzk.zzli();
        return 7;
      }
      if ("l".equalsIgnoreCase(str))
      {
        zzk.zzli();
        return 6;
      }
      if ("c".equalsIgnoreCase(str))
        return zzk.zzli().zzwf();
    }
    return -1;
  }

  private final void zzv(boolean paramBoolean)
  {
    if (this.zzdao != null)
      this.zzdao.zzw(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzahr
 * JD-Core Version:    0.6.2
 */