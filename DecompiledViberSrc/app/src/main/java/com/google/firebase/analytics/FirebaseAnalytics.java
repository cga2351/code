package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzbw;
import com.google.android.gms.measurement.internal.zzdy;
import com.google.android.gms.measurement.internal.zzn;
import com.google.firebase.iid.FirebaseInstanceId;

public final class FirebaseAnalytics
{
  private static volatile FirebaseAnalytics a;
  private final zzbw b;
  private final Object c;

  private FirebaseAnalytics(zzbw paramzzbw)
  {
    Preconditions.checkNotNull(paramzzbw);
    this.b = paramzzbw;
    this.c = new Object();
  }

  @Keep
  public static FirebaseAnalytics getInstance(Context paramContext)
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new FirebaseAnalytics(zzbw.zza(paramContext, null));
      return a;
    }
    finally
    {
    }
  }

  @Keep
  public final String getFirebaseInstanceId()
  {
    return FirebaseInstanceId.getInstance().getId();
  }

  @Keep
  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!zzn.isMainThread())
    {
      this.b.zzgt().zzjj().zzby("setCurrentScreen must be called from the main thread");
      return;
    }
    this.b.zzgm().setCurrentScreen(paramActivity, paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.analytics.FirebaseAnalytics
 * JD-Core Version:    0.6.2
 */