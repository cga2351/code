package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
public final class zzajz
  implements zzajr, zzajx
{
  private final zzbha zzdbu;
  private final Context zzlj;

  public zzajz(Context paramContext, zzbaj paramzzbaj, zzdh paramzzdh, zza paramzza)
    throws zzbhk
  {
    this.zzlj = paramContext;
    zzk.zzlh();
    this.zzdbu = zzbhg.zza(paramContext, zzbio.zzabu(), "", false, false, paramzzdh, paramzzbaj, null, null, null, zzwh.zznl());
    this.zzdbu.getView().setWillNotDraw(true);
  }

  private static void runOnUiThread(Runnable paramRunnable)
  {
    zzyr.zzpa();
    if (zzazu.zzwy())
    {
      paramRunnable.run();
      return;
    }
    zzaxj.zzdvx.post(paramRunnable);
  }

  public final void destroy()
  {
    this.zzdbu.destroy();
  }

  public final boolean isDestroyed()
  {
    return this.zzdbu.isDestroyed();
  }

  public final void zza(zzajy paramzzajy)
  {
    zzbij localzzbij = this.zzdbu.zzaai();
    paramzzajy.getClass();
    localzzbij.zza(zzakc.zzb(paramzzajy));
  }

  public final void zza(String paramString, zzahn<? super zzalg> paramzzahn)
  {
    this.zzdbu.zza(paramString, new zzakg(this, paramzzahn));
  }

  public final void zza(String paramString, Map paramMap)
  {
    zzajs.zza(this, paramString, paramMap);
  }

  public final void zza(String paramString, JSONObject paramJSONObject)
  {
    zzajs.zzb(this, paramString, paramJSONObject);
  }

  public final void zzb(String paramString, zzahn<? super zzalg> paramzzahn)
  {
    this.zzdbu.zza(paramString, new zzakb(paramzzahn));
  }

  public final void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzajs.zza(this, paramString, paramJSONObject);
  }

  public final void zzcl(String paramString)
  {
    runOnUiThread(new zzakd(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[] { paramString })));
  }

  public final void zzcm(String paramString)
  {
    runOnUiThread(new zzake(this, paramString));
  }

  public final void zzcn(String paramString)
  {
    runOnUiThread(new zzakf(this, paramString));
  }

  public final void zzco(String paramString)
  {
    runOnUiThread(new zzaka(this, paramString));
  }

  public final void zzi(String paramString1, String paramString2)
  {
    zzajs.zza(this, paramString1, paramString2);
  }

  public final zzalh zzru()
  {
    return new zzali(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzajz
 * JD-Core Version:    0.6.2
 */