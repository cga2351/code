package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

@zzare
public final class zzaaz
{
  private final zzya zzaaj;
  private VideoOptions zzbqg;
  private boolean zzbqn;
  private AppEventListener zzbqp;
  private zzxp zzcgj;
  private AdListener zzcgm;
  private AdSize[] zzchk;
  private String zzchl;
  private final zzamp zzcjd = new zzamp();
  private final AtomicBoolean zzcje;
  private final VideoController zzcjf = new VideoController();

  @VisibleForTesting
  private final zzyt zzcjg = new zzaba(this);
  private Correlator zzcjh;
  private zzzi zzcji;
  private OnCustomRenderedAdLoadedListener zzcjj;
  private ViewGroup zzcjk;
  private int zzcjl;

  public zzaaz(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, zzya.zzchf, 0);
  }

  public zzaaz(ViewGroup paramViewGroup, int paramInt)
  {
    this(paramViewGroup, null, false, zzya.zzchf, paramInt);
  }

  public zzaaz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, zzya.zzchf, 0);
  }

  public zzaaz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, int paramInt)
  {
    this(paramViewGroup, paramAttributeSet, false, zzya.zzchf, paramInt);
  }

  @VisibleForTesting
  private zzaaz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, zzya paramzzya, int paramInt)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, paramzzya, null, paramInt);
  }

  @VisibleForTesting
  private zzaaz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, zzya paramzzya, zzzi paramzzzi, int paramInt)
  {
    this.zzcjk = paramViewGroup;
    this.zzaaj = paramzzya;
    this.zzcji = null;
    this.zzcje = new AtomicBoolean(false);
    this.zzcjl = paramInt;
    Context localContext;
    if (paramAttributeSet != null)
      localContext = paramViewGroup.getContext();
    try
    {
      zzye localzzye = new zzye(localContext, paramAttributeSet);
      this.zzchk = localzzye.zzs(paramBoolean);
      this.zzchl = localzzye.getAdUnitId();
      if (paramViewGroup.isInEditMode())
      {
        zzazu localzzazu = zzyr.zzpa();
        AdSize localAdSize = this.zzchk[0];
        int i = this.zzcjl;
        zzyb localzzyb = new zzyb(localContext, localAdSize);
        localzzyb.zzchj = zzcp(i);
        localzzazu.zza(paramViewGroup, localzzyb, "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzyr.zzpa().zza(paramViewGroup, new zzyb(localContext, AdSize.BANNER), localIllegalArgumentException.getMessage(), localIllegalArgumentException.getMessage());
    }
  }

  private static zzyb zza(Context paramContext, AdSize[] paramArrayOfAdSize, int paramInt)
  {
    zzyb localzzyb = new zzyb(paramContext, paramArrayOfAdSize);
    localzzyb.zzchj = zzcp(paramInt);
    return localzzyb;
  }

  private static boolean zzcp(int paramInt)
  {
    return paramInt == 1;
  }

  public final void destroy()
  {
    try
    {
      if (this.zzcji != null)
        this.zzcji.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final AdListener getAdListener()
  {
    return this.zzcgm;
  }

  public final AdSize getAdSize()
  {
    try
    {
      if (this.zzcji != null)
      {
        zzyb localzzyb = this.zzcji.zzpn();
        if (localzzyb != null)
        {
          AdSize localAdSize = zzb.zza(localzzyb.width, localzzyb.height, localzzyb.zzaap);
          return localAdSize;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      if (this.zzchk != null)
        return this.zzchk[0];
    }
    return null;
  }

  public final AdSize[] getAdSizes()
  {
    return this.zzchk;
  }

  public final String getAdUnitId()
  {
    if ((this.zzchl == null) && (this.zzcji != null));
    try
    {
      this.zzchl = this.zzcji.getAdUnitId();
      return this.zzchl;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final AppEventListener getAppEventListener()
  {
    return this.zzbqp;
  }

  public final String getMediationAdapterClassName()
  {
    try
    {
      if (this.zzcji != null)
      {
        String str = this.zzcji.zzpj();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return null;
  }

  public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzcjj;
  }

  public final VideoController getVideoController()
  {
    return this.zzcjf;
  }

  public final VideoOptions getVideoOptions()
  {
    return this.zzbqg;
  }

  public final boolean isLoading()
  {
    try
    {
      if (this.zzcji != null)
      {
        boolean bool = this.zzcji.isLoading();
        return bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return false;
  }

  public final void pause()
  {
    try
    {
      if (this.zzcji != null)
        this.zzcji.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void recordManualImpression()
  {
    if (this.zzcje.getAndSet(true));
    while (true)
    {
      return;
      try
      {
        if (this.zzcji != null)
        {
          this.zzcji.zzpm();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }

  public final void resume()
  {
    try
    {
      if (this.zzcji != null)
        this.zzcji.resume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void setAdListener(AdListener paramAdListener)
  {
    this.zzcgm = paramAdListener;
    this.zzcjg.zza(paramAdListener);
  }

  public final void setAdSizes(AdSize[] paramArrayOfAdSize)
  {
    if (this.zzchk != null)
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    zza(paramArrayOfAdSize);
  }

  public final void setAdUnitId(String paramString)
  {
    if (this.zzchl != null)
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    this.zzchl = paramString;
  }

  public final void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.zzbqp = paramAppEventListener;
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramAppEventListener == null)
          break label40;
      }
      label40: for (zzyd localzzyd = new zzyd(paramAppEventListener); ; localzzyd = null)
      {
        localzzzi.zza(localzzyd);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void setCorrelator(Correlator paramCorrelator)
  {
    this.zzcjh = paramCorrelator;
    try
    {
      if (this.zzcji != null)
      {
        zzzi localzzzi = this.zzcji;
        if (this.zzcjh == null);
        zzys localzzys;
        for (Object localObject = null; ; localObject = localzzys)
        {
          localzzzi.zzb((zzzw)localObject);
          return;
          localzzys = this.zzcjh.zzdf();
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.zzbqn = paramBoolean;
    try
    {
      if (this.zzcji != null)
        this.zzcji.setManualImpressionsEnabled(this.zzbqn);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzcjj = paramOnCustomRenderedAdLoadedListener;
    try
    {
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramOnCustomRenderedAdLoadedListener == null)
          break label40;
      }
      label40: for (zzadq localzzadq = new zzadq(paramOnCustomRenderedAdLoadedListener); ; localzzadq = null)
      {
        localzzzi.zza(localzzadq);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void setVideoOptions(VideoOptions paramVideoOptions)
  {
    this.zzbqg = paramVideoOptions;
    try
    {
      if (this.zzcji != null)
      {
        zzzi localzzzi = this.zzcji;
        if (paramVideoOptions == null);
        for (zzacc localzzacc = null; ; localzzacc = new zzacc(paramVideoOptions))
        {
          localzzzi.zza(localzzacc);
          return;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void zza(zzaax paramzzaax)
  {
    try
    {
      if (this.zzcji == null)
        if (((this.zzchk == null) || (this.zzchl == null)) && (this.zzcji == null))
          throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    catch (RemoteException localRemoteException1)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException1);
    }
    while (true)
    {
      return;
      Context localContext = this.zzcjk.getContext();
      zzyb localzzyb = zza(localContext, this.zzchk, this.zzcjl);
      zzzi localzzzi;
      if ("search_v2".equals(localzzyb.zzaap))
      {
        localzzzi = (zzzi)new zzyi(zzyr.zzpb(), localContext, localzzyb, this.zzchl).zzd(localContext, false);
        label110: this.zzcji = localzzzi;
        this.zzcji.zzb(new zzxt(this.zzcjg));
        if (this.zzcgj != null)
          this.zzcji.zza(new zzxq(this.zzcgj));
        if (this.zzbqp != null)
          this.zzcji.zza(new zzyd(this.zzbqp));
        if (this.zzcjj != null)
          this.zzcji.zza(new zzadq(this.zzcjj));
        if (this.zzcjh != null)
          this.zzcji.zzb(this.zzcjh.zzdf());
        if (this.zzbqg != null)
          this.zzcji.zza(new zzacc(this.zzbqg));
        this.zzcji.setManualImpressionsEnabled(this.zzbqn);
      }
      try
      {
        IObjectWrapper localIObjectWrapper = this.zzcji.zzpl();
        if (localIObjectWrapper == null);
        while (this.zzcji.zzb(zzya.zza(this.zzcjk.getContext(), paramzzaax)))
        {
          this.zzcjd.zzf(paramzzaax.zzqa());
          return;
          localzzzi = (zzzi)new zzyg(zzyr.zzpb(), localContext, localzzyb, this.zzchl, this.zzcjd).zzd(localContext, false);
          break label110;
          this.zzcjk.addView((View)ObjectWrapper.unwrap(localIObjectWrapper));
        }
      }
      catch (RemoteException localRemoteException2)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException2);
      }
    }
  }

  public final void zza(zzxp paramzzxp)
  {
    try
    {
      this.zzcgj = paramzzxp;
      zzzi localzzzi;
      if (this.zzcji != null)
      {
        localzzzi = this.zzcji;
        if (paramzzxp == null)
          break label40;
      }
      label40: for (zzxq localzzxq = new zzxq(paramzzxp); ; localzzxq = null)
      {
        localzzzi.zza(localzzxq);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void zza(AdSize[] paramArrayOfAdSize)
  {
    this.zzchk = paramArrayOfAdSize;
    try
    {
      if (this.zzcji != null)
        this.zzcji.zza(zza(this.zzcjk.getContext(), this.zzchk, this.zzcjl));
      this.zzcjk.requestLayout();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final boolean zza(zzzi paramzzzi)
  {
    if (paramzzzi == null)
      return false;
    IObjectWrapper localIObjectWrapper;
    try
    {
      localIObjectWrapper = paramzzzi.zzpl();
      if (localIObjectWrapper == null)
        return false;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      return false;
    }
    if (((View)ObjectWrapper.unwrap(localIObjectWrapper)).getParent() != null)
      return false;
    this.zzcjk.addView((View)ObjectWrapper.unwrap(localIObjectWrapper));
    this.zzcji = paramzzzi;
    return true;
  }

  public final zzaap zzdh()
  {
    if (this.zzcji == null)
      return null;
    try
    {
      zzaap localzzaap = this.zzcji.getVideoController();
      return localzzaap;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaaz
 * JD-Core Version:    0.6.2
 */