package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzk;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@zzare
public final class zzacw
{
  private String zzbsy = null;
  private String zzcwz;
  private Map<String, String> zzcxa;
  private Context zzlj = null;

  public zzacw(Context paramContext, String paramString)
  {
    this.zzlj = paramContext;
    this.zzbsy = paramString;
    zzaci localzzaci = zzact.zzcmz;
    this.zzcwz = ((String)zzyr.zzpe().zzd(localzzaci));
    this.zzcxa = new LinkedHashMap();
    this.zzcxa.put("s", "gmob_sdk");
    this.zzcxa.put("v", "3");
    this.zzcxa.put("os", Build.VERSION.RELEASE);
    this.zzcxa.put("sdk", Build.VERSION.SDK);
    Map localMap1 = this.zzcxa;
    zzk.zzlg();
    localMap1.put("device", zzaxj.zzwc());
    Map localMap2 = this.zzcxa;
    String str1;
    if (paramContext.getApplicationContext() != null)
      str1 = paramContext.getApplicationContext().getPackageName();
    while (true)
    {
      localMap2.put("app", str1);
      Map localMap3 = this.zzcxa;
      zzk.zzlg();
      String str2;
      Future localFuture;
      if (zzaxj.zzau(paramContext))
      {
        str2 = "1";
        localMap3.put("is_lite_sdk", str2);
        localFuture = zzk.zzlr().zzt(this.zzlj);
      }
      try
      {
        this.zzcxa.put("network_coarse", Integer.toString(((zzasf)localFuture.get()).zzdpu));
        this.zzcxa.put("network_fine", Integer.toString(((zzasf)localFuture.get()).zzdpv));
        return;
        str1 = paramContext.getPackageName();
        continue;
        str2 = "0";
      }
      catch (Exception localException)
      {
        zzk.zzlk().zza(localException, "CsiConfiguration.CsiConfiguration");
      }
    }
  }

  final Context getContext()
  {
    return this.zzlj;
  }

  final String zzmg()
  {
    return this.zzbsy;
  }

  final String zzqr()
  {
    return this.zzcwz;
  }

  final Map<String, String> zzqs()
  {
    return this.zzcxa;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzacw
 * JD-Core Version:    0.6.2
 */