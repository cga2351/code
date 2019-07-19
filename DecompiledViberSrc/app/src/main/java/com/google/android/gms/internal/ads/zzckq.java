package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzckq
  implements zzcju<zzbvw>
{
  private final zzcxj zzfez;
  private final Executor zzffu;
  private final zzbwr zzfzy;
  private final Context zzlj;

  public zzckq(Context paramContext, Executor paramExecutor, zzbwr paramzzbwr, zzcxj paramzzcxj)
  {
    this.zzlj = paramContext;
    this.zzfzy = paramzzbwr;
    this.zzffu = paramExecutor;
    this.zzfez = paramzzcxj;
  }

  private static String zzc(zzcxl paramzzcxl)
  {
    try
    {
      String str = paramzzcxl.zzgkh.getString("tab_url");
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return ((this.zzlj instanceof Activity)) && (PlatformVersion.isAtLeastIceCreamSandwichMR1()) && (zzadr.zzj(this.zzlj)) && (!TextUtils.isEmpty(zzc(paramzzcxl)));
  }

  public final zzbbi<zzbvw> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    String str = zzc(paramzzcxl);
    if (str != null);
    for (Uri localUri = Uri.parse(str); ; localUri = null)
      return zzbas.zza(zzbas.zzm(null), new zzckr(this, localUri, paramzzcxt, paramzzcxl), this.zzffu);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzckq
 * JD-Core Version:    0.6.2
 */