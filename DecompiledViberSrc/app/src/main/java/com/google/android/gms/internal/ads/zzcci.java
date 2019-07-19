package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcci
{
  private final zzbhg zzbru;
  private final zzbaj zzdlf;
  private final zzdh zzekq;
  private final Executor zzffu;
  private final zza zzfrm;
  private final zzccp zzfsh;
  private final zzaht zzfsi;
  private zzbbi<zzbha> zzfsj;
  private final Context zzlj;

  public zzcci(Context paramContext, Executor paramExecutor, zzdh paramzzdh, zzbaj paramzzbaj, zza paramzza, zzbhg paramzzbhg)
  {
    this.zzlj = paramContext;
    this.zzffu = paramExecutor;
    this.zzekq = paramzzdh;
    this.zzdlf = paramzzbaj;
    this.zzfrm = paramzza;
    this.zzfsh = new zzccp(null);
    this.zzbru = paramzzbhg;
    this.zzfsi = new zzaht();
  }

  public final void destroy()
  {
    try
    {
      zzbbi localzzbbi = this.zzfsj;
      if (localzzbbi == null);
      while (true)
      {
        return;
        zzbas.zza(this.zzfsj, new zzccl(this), this.zzffu);
        this.zzfsj = null;
      }
    }
    finally
    {
    }
  }

  public final void zza(String paramString, zzahn<Object> paramzzahn)
  {
    try
    {
      zzbbi localzzbbi = this.zzfsj;
      if (localzzbbi == null);
      while (true)
      {
        return;
        zzbas.zza(this.zzfsj, new zzccm(this, paramString, paramzzahn), this.zzffu);
      }
    }
    finally
    {
    }
  }

  public final void zza(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      zzbbi localzzbbi = this.zzfsj;
      if (localzzbbi == null);
      while (true)
      {
        return;
        zzbas.zza(this.zzfsj, new zzcco(this, paramString, paramMap), this.zzffu);
      }
    }
    finally
    {
    }
  }

  public final <T> void zza(WeakReference<T> paramWeakReference, String paramString, zzahn<T> paramzzahn)
  {
    zza(paramString, new zzccs(this, paramWeakReference, paramString, paramzzahn, null));
  }

  public final void zzajj()
  {
    try
    {
      Context localContext = this.zzlj;
      zzbaj localzzbaj = this.zzdlf;
      zzaci localzzaci = zzact.zzcsb;
      this.zzfsj = zzbas.zza(zzbhg.zza(localContext, localzzbaj, (String)zzyr.zzpe().zzd(localzzaci), this.zzekq, this.zzfrm), new zzccj(this), this.zzffu);
      zzbap.zza(this.zzfsj, "NativeJavascriptExecutor.initializeEngine");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(String paramString, zzahn<Object> paramzzahn)
  {
    try
    {
      zzbbi localzzbbi = this.zzfsj;
      if (localzzbbi == null);
      while (true)
      {
        return;
        zzbas.zza(this.zzfsj, new zzccn(this, paramString, paramzzahn), this.zzffu);
      }
    }
    finally
    {
    }
  }

  public final zzbbi<JSONObject> zzc(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      zzbbh localzzbbh;
      if (this.zzfsj == null)
        localzzbbh = zzbas.zzm(null);
      zzbbi localzzbbi;
      for (Object localObject2 = localzzbbh; ; localObject2 = localzzbbi)
      {
        return localObject2;
        localzzbbi = zzbas.zza(this.zzfsj, new zzcck(this, paramString, paramJSONObject), this.zzffu);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcci
 * JD-Core Version:    0.6.2
 */