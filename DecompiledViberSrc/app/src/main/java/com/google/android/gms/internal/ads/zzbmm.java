package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzbmm
  implements zzo, zzbrv, zzbrw, zzuc
{
  private final Clock zzbsb;
  private final zzbmh zzffq;
  private final zzbmk zzffr;
  private final Set<zzbha> zzffs = new HashSet();
  private final zzame<JSONObject, JSONObject> zzfft;
  private final Executor zzffu;
  private final AtomicBoolean zzffv = new AtomicBoolean(false);

  @GuardedBy("this")
  private final zzbmo zzffw = new zzbmo();
  private boolean zzffx = false;
  private WeakReference<Object> zzffy = new WeakReference(this);

  public zzbmm(zzalz paramzzalz, zzbmk paramzzbmk, Executor paramExecutor, zzbmh paramzzbmh, Clock paramClock)
  {
    this.zzffq = paramzzbmh;
    this.zzfft = paramzzalz.zzb("google.afma.activeView.handleUpdate", zzalp.zzddk, zzalp.zzddk);
    this.zzffr = paramzzbmk;
    this.zzffu = paramExecutor;
    this.zzbsb = paramClock;
  }

  private final void zzafe()
  {
    Iterator localIterator = this.zzffs.iterator();
    while (localIterator.hasNext())
    {
      zzbha localzzbha = (zzbha)localIterator.next();
      this.zzffq.zze(localzzbha);
    }
    this.zzffq.zzafc();
  }

  public final void onAdImpression()
  {
    try
    {
      if (this.zzffv.compareAndSet(false, true))
      {
        this.zzffq.zza(this);
        zzafd();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onPause()
  {
    try
    {
      this.zzffw.zzfga = true;
      zzafd();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onResume()
  {
    try
    {
      this.zzffw.zzfga = false;
      zzafd();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzub paramzzub)
  {
    try
    {
      this.zzffw.zzbtl = paramzzub.zzbtl;
      this.zzffw.zzfgd = paramzzub;
      zzafd();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzafd()
  {
    while (true)
    {
      JSONObject localJSONObject;
      try
      {
        int i;
        if (this.zzffy.get() != null)
        {
          i = 1;
          if (i == 0)
            zzaff();
        }
        else
        {
          i = 0;
          continue;
        }
        if (this.zzffx)
          continue;
        boolean bool = this.zzffv.get();
        if (!bool)
          continue;
        try
        {
          this.zzffw.timestamp = this.zzbsb.elapsedRealtime();
          localJSONObject = this.zzffr.zza(this.zzffw);
          Iterator localIterator = this.zzffs.iterator();
          if (!localIterator.hasNext())
            break label151;
          zzbha localzzbha = (zzbha)localIterator.next();
          this.zzffu.execute(new zzbmn(localzzbha, localJSONObject));
          continue;
        }
        catch (Exception localException)
        {
          zzaxa.zza("Failed to call ActiveViewJS", localException);
        }
        continue;
      }
      finally
      {
      }
      label151: zzbap.zzb(this.zzfft.zzf(localJSONObject), "ActiveViewListener.callActiveViewJs");
    }
  }

  public final void zzaff()
  {
    try
    {
      zzafe();
      this.zzffx = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzbp(Context paramContext)
  {
    try
    {
      this.zzffw.zzfga = true;
      zzafd();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzbq(Context paramContext)
  {
    try
    {
      this.zzffw.zzfga = false;
      zzafd();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzbr(Context paramContext)
  {
    try
    {
      this.zzffw.zzfgc = "u";
      zzafd();
      zzafe();
      this.zzffx = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzf(zzbha paramzzbha)
  {
    try
    {
      this.zzffs.add(paramzzbha);
      this.zzffq.zzd(paramzzbha);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzq(Object paramObject)
  {
    this.zzffy = new WeakReference(paramObject);
  }

  public final void zzsz()
  {
  }

  public final void zzta()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbmm
 * JD-Core Version:    0.6.2
 */