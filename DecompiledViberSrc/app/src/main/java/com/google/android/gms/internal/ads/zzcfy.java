package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzcfy
  implements AppEventListener, zzbrk, zzbrn, zzbrv, zzbrw, zzbsq, zzbtj, zzczy, zzxp
{
  private long startTime;
  private final List<Object> zzdyz;
  private final zzcfm zzfuy;

  public zzcfy(zzcfm paramzzcfm, zzbjn paramzzbjn)
  {
    this.zzfuy = paramzzcfm;
    this.zzdyz = Collections.singletonList(paramzzbjn);
  }

  private final void zza(Class paramClass, String paramString, Object[] paramArrayOfObject)
  {
    zzcfm localzzcfm = this.zzfuy;
    List localList = this.zzdyz;
    String str1 = String.valueOf(paramClass.getSimpleName());
    if (str1.length() != 0);
    for (String str2 = "Event-".concat(str1); ; str2 = new String("Event-"))
    {
      localzzcfm.zza(localList, str2, paramString, paramArrayOfObject);
      return;
    }
  }

  public final void onAdClicked()
  {
    zza(zzxp.class, "onAdClicked", new Object[0]);
  }

  public final void onAdClosed()
  {
    zza(zzbrk.class, "onAdClosed", new Object[0]);
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    zza(zzbrn.class, "onAdFailedToLoad", arrayOfObject);
  }

  public final void onAdImpression()
  {
    zza(zzbrv.class, "onAdImpression", new Object[0]);
  }

  public final void onAdLeftApplication()
  {
    zza(zzbrk.class, "onAdLeftApplication", new Object[0]);
  }

  public final void onAdLoaded()
  {
    long l = zzk.zzln().elapsedRealtime() - this.startTime;
    zzaxa.zzds(41 + "Ad Request Latency : " + l);
    zza(zzbsq.class, "onAdLoaded", new Object[0]);
  }

  public final void onAdOpened()
  {
    zza(zzbrk.class, "onAdOpened", new Object[0]);
  }

  public final void onAppEvent(String paramString1, String paramString2)
  {
    zza(zzxp.class, "onAppEvent", new Object[] { paramString1, paramString2 });
  }

  public final void onRewardedVideoCompleted()
  {
    zza(zzbrk.class, "onRewardedVideoCompleted", new Object[0]);
  }

  public final void onRewardedVideoStarted()
  {
    zza(zzbrk.class, "onRewardedVideoStarted", new Object[0]);
  }

  public final void zza(zzcxt paramzzcxt)
  {
  }

  public final void zza(zzczr paramzzczr, String paramString)
  {
    zza(zzczq.class, "onTaskCreated", new Object[] { paramString });
  }

  public final void zza(zzczr paramzzczr, String paramString, Throwable paramThrowable)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = paramThrowable.getClass().getSimpleName();
    zza(zzczq.class, "onTaskFailed", arrayOfObject);
  }

  public final void zzb(zzary paramzzary)
  {
    this.startTime = zzk.zzln().elapsedRealtime();
    zza(zzbtj.class, "onAdRequest", new Object[0]);
  }

  @ParametersAreNonnullByDefault
  public final void zzb(zzass paramzzass, String paramString1, String paramString2)
  {
    zza(zzbrk.class, "onRewarded", new Object[] { paramzzass, paramString1, paramString2 });
  }

  public final void zzb(zzczr paramzzczr, String paramString)
  {
    zza(zzczq.class, "onTaskStarted", new Object[] { paramString });
  }

  public final void zzbp(Context paramContext)
  {
    zza(zzbrw.class, "onPause", new Object[] { paramContext });
  }

  public final void zzbq(Context paramContext)
  {
    zza(zzbrw.class, "onResume", new Object[] { paramContext });
  }

  public final void zzbr(Context paramContext)
  {
    zza(zzbrw.class, "onDestroy", new Object[] { paramContext });
  }

  public final void zzc(zzczr paramzzczr, String paramString)
  {
    zza(zzczq.class, "onTaskSucceeded", new Object[] { paramString });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcfy
 * JD-Core Version:    0.6.2
 */