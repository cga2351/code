package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabo;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzaqr;
import com.google.android.gms.internal.ads.zzasx;
import com.google.android.gms.internal.ads.zzatu;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbzh;
import com.google.android.gms.internal.ads.zzbzi;
import com.google.android.gms.internal.ads.zzcpn;
import com.google.android.gms.internal.ads.zzcps;
import com.google.android.gms.internal.ads.zzcqc;
import com.google.android.gms.internal.ads.zzcqe;
import com.google.android.gms.internal.ads.zzcqi;
import com.google.android.gms.internal.ads.zzyb;
import com.google.android.gms.internal.ads.zzzd;
import com.google.android.gms.internal.ads.zzzi;
import com.google.android.gms.internal.ads.zzzu;
import com.google.android.gms.internal.ads.zzzz;
import java.util.HashMap;

public class ClientApi2 extends zzzu
{
  public final zzaeq zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
  {
    return new zzbzh((View)ObjectWrapper.unwrap(paramIObjectWrapper1), (HashMap)ObjectWrapper.unwrap(paramIObjectWrapper2), (HashMap)ObjectWrapper.unwrap(paramIObjectWrapper3));
  }

  public final zzasx zza(IObjectWrapper paramIObjectWrapper, zzamq paramzzamq, int paramInt)
  {
    Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    return new zzcqi(zzbjn.zza(localContext, paramzzamq, paramInt), localContext);
  }

  public final zzzd zza(IObjectWrapper paramIObjectWrapper, String paramString, zzamq paramzzamq, int paramInt)
  {
    Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    return new zzcpn(zzbjn.zza(localContext, paramzzamq, paramInt), localContext, paramString);
  }

  public final zzzi zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, String paramString, int paramInt)
  {
    return new zzabo();
  }

  public final zzzi zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, String paramString, zzamq paramzzamq, int paramInt)
  {
    Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    return new zzcps(zzbjn.zza(localContext, paramzzamq, paramInt), localContext, paramzzyb, paramString);
  }

  public final zzzz zza(IObjectWrapper paramIObjectWrapper, int paramInt)
  {
    return zzbjn.zzd((Context)ObjectWrapper.unwrap(paramIObjectWrapper), paramInt).zzaci();
  }

  public final zzatu zzb(IObjectWrapper paramIObjectWrapper, String paramString, zzamq paramzzamq, int paramInt)
  {
    Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    return new zzcqe(zzbjn.zza(localContext, paramzzamq, paramInt), localContext, paramString);
  }

  public final zzzi zzb(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, String paramString, zzamq paramzzamq, int paramInt)
  {
    Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    return new zzcqc(zzbjn.zza(localContext, paramzzamq, paramInt), localContext, paramzzyb, paramString);
  }

  public final zzael zzc(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2)
  {
    return new zzbzi((FrameLayout)ObjectWrapper.unwrap(paramIObjectWrapper1), (FrameLayout)ObjectWrapper.unwrap(paramIObjectWrapper2));
  }

  public final zzaqh zzf(IObjectWrapper paramIObjectWrapper)
  {
    Activity localActivity = (Activity)ObjectWrapper.unwrap(paramIObjectWrapper);
    AdOverlayInfoParcel localAdOverlayInfoParcel = AdOverlayInfoParcel.zzc(localActivity.getIntent());
    if (localAdOverlayInfoParcel == null)
      return new zzs(localActivity);
    switch (localAdOverlayInfoParcel.zzdkt)
    {
    default:
      return new zzs(localActivity);
    case 1:
      return new zzr(localActivity);
    case 4:
      return new zzt(localActivity, localAdOverlayInfoParcel);
    case 2:
      return new zzy(localActivity);
    case 3:
    }
    return new zzz(localActivity);
  }

  public final zzzz zzg(IObjectWrapper paramIObjectWrapper)
  {
    return null;
  }

  public final zzaqr zzh(IObjectWrapper paramIObjectWrapper)
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.ClientApi2
 * JD-Core Version:    0.6.2
 */