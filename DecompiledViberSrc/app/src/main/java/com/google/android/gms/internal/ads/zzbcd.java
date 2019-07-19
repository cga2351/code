package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzare
abstract class zzbcd
{
  private final WeakReference<View> zzeaw;

  public zzbcd(View paramView)
  {
    this.zzeaw = new WeakReference(paramView);
  }

  private final ViewTreeObserver getViewTreeObserver()
  {
    View localView = (View)this.zzeaw.get();
    ViewTreeObserver localViewTreeObserver;
    if (localView == null)
      localViewTreeObserver = null;
    do
    {
      return localViewTreeObserver;
      localViewTreeObserver = localView.getViewTreeObserver();
    }
    while ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()));
    return null;
  }

  public final void attach()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver != null)
      zza(localViewTreeObserver);
  }

  public final void detach()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver != null)
      zzb(localViewTreeObserver);
  }

  protected abstract void zza(ViewTreeObserver paramViewTreeObserver);

  protected abstract void zzb(ViewTreeObserver paramViewTreeObserver);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbcd
 * JD-Core Version:    0.6.2
 */