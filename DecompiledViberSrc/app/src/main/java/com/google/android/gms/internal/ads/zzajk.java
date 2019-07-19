package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
public final class zzajk extends zzajv<zzalg>
  implements zzajr, zzajx
{
  private final zzbjc zzdbj;
  private zzajy zzdbk;

  public zzajk(Context paramContext, zzbaj paramzzbaj)
    throws zzbhk
  {
    try
    {
      this.zzdbj = new zzbjc(paramContext, new zzajq(this, null));
      this.zzdbj.setWillNotDraw(true);
      this.zzdbj.addJavascriptInterface(new zzajp(this, null), "GoogleJsInterface");
      zzk.zzlg().zza(paramContext, paramzzbaj.zzbsy, this.zzdbj.getSettings());
      super.zzg(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new zzbhk("Init failed.", localThrowable);
    }
  }

  public final void destroy()
  {
    this.zzdbj.destroy();
  }

  public final boolean isDestroyed()
  {
    return this.zzdbj.isDestroyed();
  }

  public final void zza(zzajy paramzzajy)
  {
    this.zzdbk = paramzzajy;
  }

  public final void zza(String paramString, Map paramMap)
  {
    zzajs.zza(this, paramString, paramMap);
  }

  public final void zza(String paramString, JSONObject paramJSONObject)
  {
    zzajs.zzb(this, paramString, paramJSONObject);
  }

  public final void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzajs.zza(this, paramString, paramJSONObject);
  }

  public final void zzcl(String paramString)
  {
    zzcm(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[] { paramString }));
  }

  public final void zzcm(String paramString)
  {
    zzbbn.zzeag.execute(new zzajl(this, paramString));
  }

  public final void zzcn(String paramString)
  {
    zzbbn.zzeag.execute(new zzajm(this, paramString));
  }

  public final void zzco(String paramString)
  {
    zzbbn.zzeag.execute(new zzajn(this, paramString));
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzajk
 * JD-Core Version:    0.6.2
 */