package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzcad
  implements zzbza
{
  private final zzbaj zzbtd;
  private final zzcxl zzfif;
  private final zzcxu zzfjp;
  private final zzbrs zzfmr;
  private final zzbrh zzfms;
  private boolean zzfmw = false;
  private boolean zzfmz = false;
  private final zzanb zzfqm;
  private final zzane zzfqn;
  private final zzanh zzfqo;
  private final Context zzlj;

  public zzcad(zzanb paramzzanb, zzane paramzzane, zzanh paramzzanh, zzbrs paramzzbrs, zzbrh paramzzbrh, Context paramContext, zzcxl paramzzcxl, zzbaj paramzzbaj, zzcxu paramzzcxu)
  {
    this.zzfqm = paramzzanb;
    this.zzfqn = paramzzane;
    this.zzfqo = paramzzanh;
    this.zzfmr = paramzzbrs;
    this.zzfms = paramzzbrh;
    this.zzlj = paramContext;
    this.zzfif = paramzzcxl;
    this.zzbtd = paramzzbaj;
    this.zzfjp = paramzzcxu;
  }

  private final void zzaa(View paramView)
  {
    try
    {
      if ((this.zzfqo != null) && (!this.zzfqo.getOverrideClickHandling()))
      {
        this.zzfqo.zzt(ObjectWrapper.wrap(paramView));
        this.zzfms.onAdClicked();
        return;
      }
      if ((this.zzfqm != null) && (!this.zzfqm.getOverrideClickHandling()))
      {
        this.zzfqm.zzt(ObjectWrapper.wrap(paramView));
        this.zzfms.onAdClicked();
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to call handleClick", localRemoteException);
      return;
    }
    if ((this.zzfqn != null) && (!this.zzfqn.getOverrideClickHandling()))
    {
      this.zzfqn.zzt(ObjectWrapper.wrap(paramView));
      this.zzfms.onAdClicked();
    }
  }

  private static HashMap<String, View> zzb(Map<String, WeakReference<View>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap == null)
      return localHashMap;
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        View localView = (View)((WeakReference)localEntry.getValue()).get();
        if (localView != null)
          localHashMap.put((String)localEntry.getKey(), localView);
      }
    }
    finally
    {
    }
    return localHashMap;
  }

  public final void cancelUnconfirmedClick()
  {
  }

  public final void destroy()
  {
  }

  public final void setClickConfirmingView(View paramView)
  {
  }

  public final void zza(View paramView1, MotionEvent paramMotionEvent, View paramView2)
  {
  }

  public final void zza(View paramView1, View paramView2, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, boolean paramBoolean)
  {
    if ((this.zzfmz) && (this.zzfif.zzdfv))
      return;
    zzaa(paramView1);
  }

  public final void zza(View paramView, Map<String, WeakReference<View>> paramMap)
  {
    IObjectWrapper localIObjectWrapper;
    try
    {
      localIObjectWrapper = ObjectWrapper.wrap(paramView);
      if (this.zzfqo != null)
      {
        this.zzfqo.zzv(localIObjectWrapper);
        return;
      }
      if (this.zzfqm != null)
      {
        this.zzfqm.zzv(localIObjectWrapper);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to call untrackView", localRemoteException);
      return;
    }
    if (this.zzfqn != null)
      this.zzfqn.zzv(localIObjectWrapper);
  }

  public final void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2)
  {
    try
    {
      if ((!this.zzfmw) && (this.zzfif.zzgkj != null))
        this.zzfmw |= zzk.zzlq().zzb(this.zzlj, this.zzbtd.zzbsy, this.zzfif.zzgkj.toString(), this.zzfjp.zzglb);
      if ((this.zzfqo != null) && (!this.zzfqo.getOverrideImpressionRecording()))
      {
        this.zzfqo.recordImpression();
        this.zzfmr.onAdImpression();
        return;
      }
      if ((this.zzfqm != null) && (!this.zzfqm.getOverrideImpressionRecording()))
      {
        this.zzfqm.recordImpression();
        this.zzfmr.onAdImpression();
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to call recordImpression", localRemoteException);
      return;
    }
    if ((this.zzfqn != null) && (!this.zzfqn.getOverrideImpressionRecording()))
    {
      this.zzfqn.recordImpression();
      this.zzfmr.onAdImpression();
    }
  }

  public final void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, View.OnTouchListener paramOnTouchListener, View.OnClickListener paramOnClickListener)
  {
    IObjectWrapper localIObjectWrapper;
    HashMap localHashMap1;
    HashMap localHashMap2;
    try
    {
      localIObjectWrapper = ObjectWrapper.wrap(paramView);
      localHashMap1 = zzb(paramMap1);
      localHashMap2 = zzb(paramMap2);
      if (this.zzfqo != null)
      {
        this.zzfqo.zzc(localIObjectWrapper, ObjectWrapper.wrap(localHashMap1), ObjectWrapper.wrap(localHashMap2));
        return;
      }
      if (this.zzfqm != null)
      {
        this.zzfqm.zzc(localIObjectWrapper, ObjectWrapper.wrap(localHashMap1), ObjectWrapper.wrap(localHashMap2));
        this.zzfqm.zzu(localIObjectWrapper);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to call trackView", localRemoteException);
      return;
    }
    if (this.zzfqn != null)
    {
      this.zzfqn.zzc(localIObjectWrapper, ObjectWrapper.wrap(localHashMap1), ObjectWrapper.wrap(localHashMap2));
      this.zzfqn.zzu(localIObjectWrapper);
    }
  }

  public final void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, boolean paramBoolean)
  {
    if (!this.zzfmz)
    {
      zzaxa.zzep("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
      return;
    }
    if (!this.zzfif.zzdfv)
    {
      zzaxa.zzep("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
      return;
    }
    zzaa(paramView);
  }

  public final void zza(zzaae paramzzaae)
  {
    zzaxa.zzep("Mute This Ad is not supported for 3rd party ads");
  }

  public final void zza(zzaai paramzzaai)
  {
    zzaxa.zzep("Mute This Ad is not supported for 3rd party ads");
  }

  public final void zza(zzagc paramzzagc)
  {
  }

  public final void zzahk()
  {
  }

  public final void zzahl()
  {
    zzaxa.zzep("Mute This Ad is not supported for 3rd party ads");
  }

  public final void zzahm()
  {
  }

  public final void zzf(Bundle paramBundle)
  {
  }

  public final void zzfi(String paramString)
  {
  }

  public final void zzg(Bundle paramBundle)
  {
  }

  public final boolean zzh(Bundle paramBundle)
  {
    return false;
  }

  public final void zzro()
  {
    this.zzfmz = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcad
 * JD-Core Version:    0.6.2
 */