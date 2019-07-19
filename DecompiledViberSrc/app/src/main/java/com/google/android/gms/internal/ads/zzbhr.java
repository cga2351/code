package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzbhr extends zzaaq
{
  private final Object lock = new Object();

  @GuardedBy("lock")
  private boolean zzaay;

  @GuardedBy("lock")
  private boolean zzaaz;

  @GuardedBy("lock")
  private int zzabv;

  @GuardedBy("lock")
  private zzaas zzdgb;
  private final zzbdg zzebv;
  private final boolean zzelx;
  private final boolean zzely;

  @GuardedBy("lock")
  private boolean zzelz;

  @GuardedBy("lock")
  private boolean zzema = true;

  @GuardedBy("lock")
  private float zzemb;

  @GuardedBy("lock")
  private float zzemc;

  @GuardedBy("lock")
  private float zzemd;

  public zzbhr(zzbdg paramzzbdg, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzebv = paramzzbdg;
    this.zzemb = paramFloat;
    this.zzelx = paramBoolean1;
    this.zzely = paramBoolean2;
  }

  private final void zza(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    zzbbn.zzeag.execute(new zzbht(this, paramInt1, paramInt2, paramBoolean1, paramBoolean2));
  }

  private final void zzf(String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null);
    for (HashMap localHashMap = new HashMap(); ; localHashMap = new HashMap(paramMap))
    {
      localHashMap.put("action", paramString);
      zzbbn.zzeag.execute(new zzbhs(this, localHashMap));
      return;
    }
  }

  public final float getAspectRatio()
  {
    synchronized (this.lock)
    {
      float f = this.zzemd;
      return f;
    }
  }

  public final int getPlaybackState()
  {
    synchronized (this.lock)
    {
      int i = this.zzabv;
      return i;
    }
  }

  public final boolean isClickToExpandEnabled()
  {
    boolean bool1 = isCustomControlsEnabled();
    Object localObject1 = this.lock;
    if (!bool1);
    while (true)
    {
      try
      {
        if ((this.zzaaz) && (this.zzely))
        {
          bool2 = true;
          return bool2;
        }
      }
      finally
      {
      }
      boolean bool2 = false;
    }
  }

  public final boolean isCustomControlsEnabled()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if ((this.zzelx) && (this.zzaay))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public final boolean isMuted()
  {
    synchronized (this.lock)
    {
      boolean bool = this.zzema;
      return bool;
    }
  }

  public final void mute(boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "mute"; ; str = "unmute")
    {
      zzf(str, null);
      return;
    }
  }

  public final void pause()
  {
    zzf("pause", null);
  }

  public final void play()
  {
    zzf("play", null);
  }

  public final void zza(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean, float paramFloat3)
  {
    synchronized (this.lock)
    {
      this.zzemb = paramFloat2;
      this.zzemc = paramFloat1;
      boolean bool = this.zzema;
      this.zzema = paramBoolean;
      int i = this.zzabv;
      this.zzabv = paramInt;
      float f = this.zzemd;
      this.zzemd = paramFloat3;
      if (Math.abs(this.zzemd - f) > 1.0E-004F)
        this.zzebv.getView().invalidate();
      zza(i, paramInt, bool, paramBoolean);
      return;
    }
  }

  public final void zza(zzaas paramzzaas)
  {
    synchronized (this.lock)
    {
      this.zzdgb = paramzzaas;
      return;
    }
  }

  public final void zzabs()
  {
    synchronized (this.lock)
    {
      boolean bool = this.zzema;
      int i = this.zzabv;
      this.zzabv = 3;
      zza(i, 3, bool, bool);
      return;
    }
  }

  public final void zzb(zzacc paramzzacc)
  {
    boolean bool1 = paramzzacc.zzaax;
    boolean bool2 = paramzzacc.zzaay;
    boolean bool3 = paramzzacc.zzaaz;
    while (true)
    {
      synchronized (this.lock)
      {
        this.zzaay = bool2;
        this.zzaaz = bool3;
        if (bool1)
        {
          str1 = "1";
          if (!bool2)
            break label101;
          str2 = "1";
          if (!bool3)
            break label108;
          str3 = "1";
          zzf("initialState", CollectionUtils.mapOf("muteStart", str1, "customControlsRequested", str2, "clickToExpandRequested", str3));
          return;
        }
      }
      String str1 = "0";
      continue;
      label101: String str2 = "0";
      continue;
      label108: String str3 = "0";
    }
  }

  public final void zze(float paramFloat)
  {
    synchronized (this.lock)
    {
      this.zzemc = paramFloat;
      return;
    }
  }

  public final float zzpv()
  {
    synchronized (this.lock)
    {
      float f = this.zzemb;
      return f;
    }
  }

  public final float zzpw()
  {
    synchronized (this.lock)
    {
      float f = this.zzemc;
      return f;
    }
  }

  public final zzaas zzpx()
    throws RemoteException
  {
    synchronized (this.lock)
    {
      zzaas localzzaas = this.zzdgb;
      return localzzaas;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbhr
 * JD-Core Version:    0.6.2
 */