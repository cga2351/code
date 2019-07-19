package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzbym extends zzbpb
{
  private final zzbaj zzbtd;
  private final zzdh zzekq;
  private final Executor zzffu;
  private final zzbzb zzfgy;
  private final zzavg zzfin;
  private final zzbys zzfmq;
  private final zzbza zzfno;
  private final zzbzk zzfnp;
  private final zzbyw zzfnq;
  private final zzdtd<zzcca> zzfnr;
  private final zzdtd<zzcby> zzfns;
  private final zzdtd<zzccf> zzfnt;
  private final zzdtd<zzcbv> zzfnu;
  private final zzdtd<zzccc> zzfnv;
  private zzcaa zzfnw;
  private boolean zzfnx;
  private final Context zzlj;

  public zzbym(Executor paramExecutor, zzbys paramzzbys, zzbza paramzzbza, zzbzk paramzzbzk, zzbyw paramzzbyw, zzbzb paramzzbzb, zzdtd<zzcca> paramzzdtd, zzdtd<zzcby> paramzzdtd1, zzdtd<zzccf> paramzzdtd2, zzdtd<zzcbv> paramzzdtd3, zzdtd<zzccc> paramzzdtd4, zzavg paramzzavg, zzdh paramzzdh, zzbaj paramzzbaj, Context paramContext)
  {
    this.zzffu = paramExecutor;
    this.zzfmq = paramzzbys;
    this.zzfno = paramzzbza;
    this.zzfnp = paramzzbzk;
    this.zzfnq = paramzzbyw;
    this.zzfgy = paramzzbzb;
    this.zzfnr = paramzzdtd;
    this.zzfns = paramzzdtd1;
    this.zzfnt = paramzzdtd2;
    this.zzfnu = paramzzdtd3;
    this.zzfnv = paramzzdtd4;
    this.zzfin = paramzzavg;
    this.zzekq = paramzzdh;
    this.zzbtd = paramzzbaj;
    this.zzlj = paramContext;
  }

  private final void zzfk(String paramString)
  {
    String str1 = null;
    if (!this.zzfnq.zzaih());
    label46: label54: label222: label228: label249: 
    while (true)
    {
      return;
      zzbha localzzbha1 = this.zzfmq.zzaia();
      zzbha localzzbha2 = this.zzfmq.zzahz();
      if ((localzzbha1 != null) || (localzzbha2 != null))
      {
        int i;
        int j;
        zzbha localzzbha3;
        if (localzzbha1 != null)
        {
          i = 1;
          if (localzzbha2 == null)
            break label222;
          j = 1;
          if (i == 0)
            break label228;
          localzzbha3 = localzzbha1;
        }
        while (true)
        {
          if ((localzzbha3.getWebView() == null) || (!zzk.zzlv().zzl(this.zzlj)))
            break label249;
          int k = this.zzbtd.zzdze;
          int m = this.zzbtd.zzdzf;
          String str2 = 23 + k + "." + m;
          IObjectWrapper localIObjectWrapper = zzk.zzlv().zza(str2, localzzbha3.getWebView(), "", "javascript", str1, paramString);
          if (localIObjectWrapper == null)
            break;
          this.zzfmq.zzan(localIObjectWrapper);
          localzzbha3.zzam(localIObjectWrapper);
          if (j != 0)
          {
            View localView = localzzbha2.getView();
            if (localView != null)
              zzk.zzlv().zza(localIObjectWrapper, localView);
          }
          zzk.zzlv().zzaa(localIObjectWrapper);
          return;
          i = 0;
          break label46;
          j = 0;
          break label54;
          if (j != 0)
          {
            str1 = "javascript";
            localzzbha3 = localzzbha2;
          }
          else
          {
            str1 = null;
            localzzbha3 = null;
          }
        }
      }
    }
  }

  public static boolean zzx(View paramView)
  {
    return (paramView.isShown()) && (paramView.getGlobalVisibleRect(new Rect(), null));
  }

  public final void cancelUnconfirmedClick()
  {
    try
    {
      this.zzfno.cancelUnconfirmedClick();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void destroy()
  {
    try
    {
      this.zzffu.execute(new zzbyp(this));
      super.destroy();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void recordCustomClickGesture()
  {
    try
    {
      if (this.zzfnw == null)
        zzaxa.zzdp("Ad should be associated with an ad view before calling recordCustomClickGesture()");
      while (true)
      {
        return;
        boolean bool = this.zzfnw instanceof zzbzh;
        this.zzffu.execute(new zzbyq(this, bool));
      }
    }
    finally
    {
    }
  }

  public final void setClickConfirmingView(View paramView)
  {
    try
    {
      this.zzfno.setClickConfirmingView(paramView);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(View paramView1, MotionEvent paramMotionEvent, View paramView2)
  {
    try
    {
      this.zzfno.zza(paramView1, paramMotionEvent, paramView2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(View paramView1, View paramView2, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, boolean paramBoolean)
  {
    try
    {
      zzaci localzzaci = zzact.zzcwq;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        this.zzfnp.zzd(this.zzfnw);
      this.zzfno.zza(paramView1, paramView2, paramMap1, paramMap2, paramBoolean);
      return;
    }
    finally
    {
    }
  }

  public final void zza(zzaae paramzzaae)
  {
    try
    {
      this.zzfno.zza(paramzzaae);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzaai paramzzaai)
  {
    try
    {
      this.zzfno.zza(paramzzaai);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzagc paramzzagc)
  {
    try
    {
      this.zzfno.zza(paramzzagc);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzcaa paramzzcaa)
  {
    try
    {
      this.zzfnw = paramzzcaa;
      this.zzfnp.zzc(paramzzcaa);
      this.zzfno.zza(paramzzcaa.zzafi(), paramzzcaa.zzaiu(), paramzzcaa.zzaiv(), paramzzcaa, paramzzcaa);
      zzaci localzzaci = zzact.zzcrh;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      {
        zzdc localzzdc = this.zzekq.zzcg();
        if (localzzdc != null)
          localzzdc.zzb(paramzzcaa.zzafi());
      }
      if (paramzzcaa.zzais() != null)
        paramzzcaa.zzais().zza(this.zzfin);
      return;
    }
    finally
    {
    }
  }

  public final void zzafl()
  {
    this.zzffu.execute(new zzbyn(this));
    if (this.zzfmq.zzahv() != 7)
    {
      Executor localExecutor = this.zzffu;
      zzbza localzzbza = this.zzfno;
      localzzbza.getClass();
      localExecutor.execute(zzbyo.zza(localzzbza));
    }
    super.zzafl();
  }

  public final void zzahk()
  {
    try
    {
      boolean bool = this.zzfnx;
      if (bool);
      while (true)
      {
        return;
        this.zzfno.zzahk();
      }
    }
    finally
    {
    }
  }

  public final boolean zzahs()
  {
    return this.zzfnq.zzaif();
  }

  public final void zzb(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, boolean paramBoolean)
  {
    boolean bool;
    while (true)
    {
      try
      {
        bool = this.zzfnx;
        if (bool)
          return;
        if (paramBoolean)
        {
          this.zzfno.zza(paramView, paramMap1, paramMap2);
          this.zzfnx = true;
          continue;
        }
      }
      finally
      {
      }
      if (!paramBoolean)
      {
        zzaci localzzaci = zzact.zzcsm;
        if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (paramMap1 != null))
        {
          Iterator localIterator = paramMap1.entrySet().iterator();
          if (localIterator.hasNext())
          {
            View localView = (View)((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
            if ((localView == null) || (!zzx(localView)))
              break;
            this.zzfno.zza(paramView, paramMap1, paramMap2);
            this.zzfnx = true;
          }
        }
      }
    }
  }

  public final void zzb(zzcaa paramzzcaa)
  {
    try
    {
      this.zzfno.zza(paramzzcaa.zzafi(), paramzzcaa.zzait());
      if (paramzzcaa.zzair() != null)
      {
        paramzzcaa.zzair().setClickable(false);
        paramzzcaa.zzair().removeAllViews();
      }
      if (paramzzcaa.zzais() != null)
        paramzzcaa.zzais().zzb(this.zzfin);
      this.zzfnw = null;
      return;
    }
    finally
    {
    }
  }

  public final void zzf(Bundle paramBundle)
  {
    try
    {
      this.zzfno.zzf(paramBundle);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzfi(String paramString)
  {
    try
    {
      this.zzfno.zzfi(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzg(Bundle paramBundle)
  {
    try
    {
      this.zzfno.zzg(paramBundle);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean zzh(Bundle paramBundle)
  {
    try
    {
      boolean bool1 = this.zzfnx;
      boolean bool2;
      if (bool1)
        bool2 = true;
      while (true)
      {
        return bool2;
        bool2 = this.zzfno.zzh(paramBundle);
        this.zzfnx = bool2;
      }
    }
    finally
    {
    }
  }

  public final void zzro()
  {
    try
    {
      this.zzfno.zzro();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzaed zzrp()
  {
    return new zzbyl(this.zzfmq);
  }

  public final void zzy(View paramView)
  {
    IObjectWrapper localIObjectWrapper = this.zzfmq.zzaib();
    if (this.zzfmq.zzaia() != null);
    for (int i = 1; ; i = 0)
    {
      if ((this.zzfnq.zzaih()) && (localIObjectWrapper != null) && (i != 0) && (paramView != null))
        zzk.zzlv().zza(localIObjectWrapper, paramView);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbym
 * JD-Core Version:    0.6.2
 */