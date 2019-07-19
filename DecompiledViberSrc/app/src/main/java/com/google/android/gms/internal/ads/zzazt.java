package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import com.google.android.gms.ads.internal.zzk;

@zzare
public final class zzazt
{
  private final View view;
  private boolean zzbtq;
  private boolean zzbxn;
  private Activity zzdym;
  private boolean zzdyn;
  private ViewTreeObserver.OnGlobalLayoutListener zzdyo;
  private ViewTreeObserver.OnScrollChangedListener zzdyp;

  public zzazt(Activity paramActivity, View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.zzdym = paramActivity;
    this.view = paramView;
    this.zzdyo = paramOnGlobalLayoutListener;
    this.zzdyp = null;
  }

  private static ViewTreeObserver zzi(Activity paramActivity)
  {
    if (paramActivity == null);
    View localView;
    do
    {
      Window localWindow;
      do
      {
        return null;
        localWindow = paramActivity.getWindow();
      }
      while (localWindow == null);
      localView = localWindow.getDecorView();
    }
    while (localView == null);
    return localView.getViewTreeObserver();
  }

  private final void zzwv()
  {
    if (!this.zzdyn)
    {
      if (this.zzdyo != null)
      {
        if (this.zzdym != null)
        {
          Activity localActivity = this.zzdym;
          ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = this.zzdyo;
          ViewTreeObserver localViewTreeObserver = zzi(localActivity);
          if (localViewTreeObserver != null)
            localViewTreeObserver.addOnGlobalLayoutListener(localOnGlobalLayoutListener);
        }
        zzk.zzmd();
        zzbca.zza(this.view, this.zzdyo);
      }
      this.zzdyn = true;
    }
  }

  private final void zzww()
  {
    if (this.zzdym == null);
    while (!this.zzdyn)
      return;
    if (this.zzdyo != null)
    {
      Activity localActivity = this.zzdym;
      ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = this.zzdyo;
      ViewTreeObserver localViewTreeObserver = zzi(localActivity);
      if (localViewTreeObserver != null)
        zzk.zzli().zza(localViewTreeObserver, localOnGlobalLayoutListener);
    }
    this.zzdyn = false;
  }

  public final void onAttachedToWindow()
  {
    this.zzbtq = true;
    if (this.zzbxn)
      zzwv();
  }

  public final void onDetachedFromWindow()
  {
    this.zzbtq = false;
    zzww();
  }

  public final void zzh(Activity paramActivity)
  {
    this.zzdym = paramActivity;
  }

  public final void zzwt()
  {
    this.zzbxn = true;
    if (this.zzbtq)
      zzwv();
  }

  public final void zzwu()
  {
    this.zzbxn = false;
    zzww();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazt
 * JD-Core Version:    0.6.2
 */