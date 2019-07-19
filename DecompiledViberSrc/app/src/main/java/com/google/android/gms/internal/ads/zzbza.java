package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract interface zzbza
{
  public abstract void cancelUnconfirmedClick();

  public abstract void destroy();

  public abstract void setClickConfirmingView(View paramView);

  public abstract void zza(View paramView1, MotionEvent paramMotionEvent, View paramView2);

  public abstract void zza(View paramView1, View paramView2, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, boolean paramBoolean);

  public abstract void zza(View paramView, Map<String, WeakReference<View>> paramMap);

  public abstract void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2);

  public abstract void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, View.OnTouchListener paramOnTouchListener, View.OnClickListener paramOnClickListener);

  public abstract void zza(View paramView, Map<String, WeakReference<View>> paramMap1, Map<String, WeakReference<View>> paramMap2, boolean paramBoolean);

  public abstract void zza(zzaae paramzzaae);

  public abstract void zza(zzaai paramzzaai);

  public abstract void zza(zzagc paramzzagc);

  public abstract void zzahk();

  public abstract void zzahl();

  public abstract void zzahm();

  public abstract void zzf(Bundle paramBundle);

  public abstract void zzfi(String paramString);

  public abstract void zzg(Bundle paramBundle);

  public abstract boolean zzh(Bundle paramBundle);

  public abstract void zzro();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbza
 * JD-Core Version:    0.6.2
 */