package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcpl extends zzzj
{
  private final ViewGroup zzfgt;
  private final zzcxu zzfjp;
  private final zzyx zzfme;
  private final zzbne zzgdo;
  private final Context zzlj;

  public zzcpl(Context paramContext, zzyx paramzzyx, zzcxu paramzzcxu, zzbne paramzzbne)
  {
    this.zzlj = paramContext;
    this.zzfme = paramzzyx;
    this.zzfjp = paramzzcxu;
    this.zzgdo = paramzzbne;
    FrameLayout localFrameLayout = new FrameLayout(this.zzlj);
    localFrameLayout.removeAllViews();
    localFrameLayout.addView(this.zzgdo.zzafi(), zzk.zzli().zzwg());
    localFrameLayout.setMinimumHeight(zzpn().heightPixels);
    localFrameLayout.setMinimumWidth(zzpn().widthPixels);
    this.zzfgt = localFrameLayout;
  }

  public final void destroy()
    throws RemoteException
  {
    Preconditions.checkMainThread("destroy must be called on the main UI thread.");
    this.zzgdo.destroy();
  }

  public final Bundle getAdMetadata()
    throws RemoteException
  {
    zzaxa.zzeo("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
    return new Bundle();
  }

  public final String getAdUnitId()
    throws RemoteException
  {
    return this.zzfjp.zzglb;
  }

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    return this.zzgdo.getMediationAdapterClassName();
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    return this.zzgdo.getVideoController();
  }

  public final boolean isLoading()
    throws RemoteException
  {
    return false;
  }

  public final boolean isReady()
    throws RemoteException
  {
    return false;
  }

  public final void pause()
    throws RemoteException
  {
    Preconditions.checkMainThread("destroy must be called on the main UI thread.");
    this.zzgdo.zzafy().zzbp(null);
  }

  public final void resume()
    throws RemoteException
  {
    Preconditions.checkMainThread("destroy must be called on the main UI thread.");
    this.zzgdo.zzafy().zzbq(null);
  }

  public final void setImmersiveMode(boolean paramBoolean)
    throws RemoteException
  {
  }

  public final void setManualImpressionsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    zzaxa.zzeo("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
  }

  public final void setUserId(String paramString)
    throws RemoteException
  {
  }

  public final void showInterstitial()
    throws RemoteException
  {
  }

  public final void stopLoading()
    throws RemoteException
  {
  }

  public final void zza(zzaav paramzzaav)
    throws RemoteException
  {
  }

  public final void zza(zzacc paramzzacc)
    throws RemoteException
  {
    zzaxa.zzeo("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
  }

  public final void zza(zzadn paramzzadn)
    throws RemoteException
  {
    zzaxa.zzeo("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
  }

  public final void zza(zzaqo paramzzaqo)
    throws RemoteException
  {
  }

  public final void zza(zzaqu paramzzaqu, String paramString)
    throws RemoteException
  {
  }

  public final void zza(zzatc paramzzatc)
    throws RemoteException
  {
  }

  public final void zza(zzyb paramzzyb)
    throws RemoteException
  {
    if (this.zzgdo != null)
      this.zzgdo.zza(this.zzfgt, paramzzyb);
  }

  public final void zza(zzyu paramzzyu)
    throws RemoteException
  {
    zzaxa.zzeo("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
  }

  public final void zza(zzzn paramzzzn)
    throws RemoteException
  {
    zzaxa.zzeo("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
  }

  public final void zza(zzzq paramzzzq)
    throws RemoteException
  {
    zzaxa.zzeo("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
  }

  public final void zzb(zzyx paramzzyx)
    throws RemoteException
  {
    zzaxa.zzeo("setAdListener is not supported in Publisher AdView returned by AdLoader.");
  }

  public final void zzb(zzzw paramzzzw)
    throws RemoteException
  {
    zzaxa.zzeo("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
  }

  public final boolean zzb(zzxx paramzzxx)
    throws RemoteException
  {
    zzaxa.zzeo("loadAd is not supported for a Publisher AdView returned from AdLoader.");
    return false;
  }

  public final void zzbt(String paramString)
    throws RemoteException
  {
  }

  public final String zzpj()
    throws RemoteException
  {
    return this.zzgdo.zzpj();
  }

  public final IObjectWrapper zzpl()
    throws RemoteException
  {
    return ObjectWrapper.wrap(this.zzfgt);
  }

  public final void zzpm()
    throws RemoteException
  {
    this.zzgdo.zzpm();
  }

  public final zzyb zzpn()
  {
    return zzcxx.zza(this.zzlj, Collections.singletonList(this.zzgdo.zzafj()));
  }

  public final zzzq zzpo()
    throws RemoteException
  {
    return this.zzfjp.zzgli;
  }

  public final zzyx zzpp()
    throws RemoteException
  {
    return this.zzfme;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpl
 * JD-Core Version:    0.6.2
 */