package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbmx
  implements zzuc
{
  private final Clock zzbsb;
  private boolean zzbxn = false;
  private zzbha zzdbu;
  private final zzbmk zzffr;
  private final Executor zzffu;
  private zzbmo zzffw = new zzbmo();
  private boolean zzfgr = false;

  public zzbmx(Executor paramExecutor, zzbmk paramzzbmk, Clock paramClock)
  {
    this.zzffu = paramExecutor;
    this.zzffr = paramzzbmk;
    this.zzbsb = paramClock;
  }

  private final void zzafg()
  {
    try
    {
      JSONObject localJSONObject = this.zzffr.zza(this.zzffw);
      if (this.zzdbu != null)
        this.zzffu.execute(new zzbmy(this, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zza("Failed to call video active view js", localJSONException);
    }
  }

  public final void disable()
  {
    this.zzbxn = false;
  }

  public final void enable()
  {
    this.zzbxn = true;
    zzafg();
  }

  public final void zza(zzub paramzzub)
  {
    zzbmo localzzbmo = this.zzffw;
    if (this.zzfgr);
    for (boolean bool = false; ; bool = paramzzub.zzbtl)
    {
      localzzbmo.zzbtl = bool;
      this.zzffw.timestamp = this.zzbsb.elapsedRealtime();
      this.zzffw.zzfgd = paramzzub;
      if (this.zzbxn)
        zzafg();
      return;
    }
  }

  public final void zzax(boolean paramBoolean)
  {
    this.zzfgr = paramBoolean;
  }

  public final void zzg(zzbha paramzzbha)
  {
    this.zzdbu = paramzzbha;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbmx
 * JD-Core Version:    0.6.2
 */