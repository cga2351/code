package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;

public final class zzeh
  implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private static final Handler zzyr = new Handler(Looper.getMainLooper());
  private final zzdy zzvd;
  private Application zzww;
  private final Context zzys;
  private final PowerManager zzyt;
  private final KeyguardManager zzyu;
  private BroadcastReceiver zzyv;
  private WeakReference<ViewTreeObserver> zzyw;
  private WeakReference<View> zzyx;
  private zzdm zzyy;
  private byte zzyz = -1;
  private int zzza = -1;
  private long zzzb = -3L;

  public zzeh(zzdy paramzzdy, View paramView)
  {
    this.zzvd = paramzzdy;
    this.zzys = paramzzdy.zzlj;
    this.zzyt = ((PowerManager)this.zzys.getSystemService("power"));
    this.zzyu = ((KeyguardManager)this.zzys.getSystemService("keyguard"));
    if ((this.zzys instanceof Application))
    {
      this.zzww = ((Application)this.zzys);
      this.zzyy = new zzdm((Application)this.zzys, this);
    }
    zzd(paramView);
  }

  private final void zza(Activity paramActivity, int paramInt)
  {
    if (this.zzyx == null);
    View localView1;
    View localView2;
    do
    {
      Window localWindow;
      do
      {
        return;
        localWindow = paramActivity.getWindow();
      }
      while (localWindow == null);
      localView1 = localWindow.peekDecorView();
      localView2 = (View)this.zzyx.get();
    }
    while ((localView2 == null) || (localView1 == null) || (localView2.getRootView() != localView1.getRootView()));
    this.zzza = paramInt;
  }

  private final void zzcu()
  {
    zzyr.post(new zzei(this));
  }

  private final void zzcw()
  {
    if (this.zzyx == null)
      return;
    View localView = (View)this.zzyx.get();
    if (localView == null)
    {
      this.zzzb = -3L;
      this.zzyz = -1;
      return;
    }
    if (localView.getVisibility() != 0);
    for (byte b = 1; ; b = 0)
    {
      if (!localView.isShown())
        b = (byte)(b | 0x2);
      if ((this.zzyt != null) && (!this.zzyt.isScreenOn()))
        b = (byte)(b | 0x4);
      int i;
      Window localWindow;
      WindowManager.LayoutParams localLayoutParams;
      int k;
      if (!this.zzvd.zzco())
      {
        KeyguardManager localKeyguardManager = this.zzyu;
        i = 0;
        if (localKeyguardManager != null)
        {
          boolean bool = this.zzyu.inKeyguardRestrictedInputMode();
          i = 0;
          if (bool)
          {
            Activity localActivity = zzef.zzc(localView);
            if (localActivity == null)
              break label295;
            localWindow = localActivity.getWindow();
            if (localWindow != null)
              break label285;
            localLayoutParams = null;
            if ((localLayoutParams == null) || ((0x80000 & localLayoutParams.flags) == 0))
              break label295;
            k = 1;
            label163: i = 0;
            if (k == 0);
          }
        }
      }
      else
      {
        i = 1;
      }
      if (i == 0)
        b = (byte)(b | 0x8);
      if (!localView.getGlobalVisibleRect(new Rect()))
        b = (byte)(b | 0x10);
      if (!localView.getLocalVisibleRect(new Rect()))
        b = (byte)(b | 0x20);
      int j = localView.getWindowVisibility();
      if (this.zzza != -1)
        j = this.zzza;
      if (j != 0)
        b = (byte)(b | 0x40);
      if (this.zzyz == b)
        break;
      this.zzyz = b;
      if (this.zzyz == 0);
      for (long l = SystemClock.elapsedRealtime(); ; l = -3L - this.zzyz)
      {
        this.zzzb = l;
        return;
        label285: localLayoutParams = localWindow.getAttributes();
        break;
        label295: k = 0;
        break label163;
      }
    }
  }

  private final void zze(View paramView)
  {
    ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
    if (localViewTreeObserver.isAlive())
    {
      this.zzyw = new WeakReference(localViewTreeObserver);
      localViewTreeObserver.addOnScrollChangedListener(this);
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    if (this.zzyv == null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      this.zzyv = new zzej(this);
      this.zzys.registerReceiver(this.zzyv, localIntentFilter);
    }
    if (this.zzww != null);
    try
    {
      this.zzww.registerActivityLifecycleCallbacks(this.zzyy);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private final void zzf(View paramView)
  {
    try
    {
      if (this.zzyw != null)
      {
        ViewTreeObserver localViewTreeObserver2 = (ViewTreeObserver)this.zzyw.get();
        if ((localViewTreeObserver2 != null) && (localViewTreeObserver2.isAlive()))
        {
          localViewTreeObserver2.removeOnScrollChangedListener(this);
          localViewTreeObserver2.removeGlobalOnLayoutListener(this);
        }
        this.zzyw = null;
      }
      try
      {
        label49: ViewTreeObserver localViewTreeObserver1 = paramView.getViewTreeObserver();
        if (localViewTreeObserver1.isAlive())
        {
          localViewTreeObserver1.removeOnScrollChangedListener(this);
          localViewTreeObserver1.removeGlobalOnLayoutListener(this);
        }
        label75: if (this.zzyv != null);
        try
        {
          this.zzys.unregisterReceiver(this.zzyv);
          label93: this.zzyv = null;
          if (this.zzww != null);
          try
          {
            this.zzww.unregisterActivityLifecycleCallbacks(this.zzyy);
            return;
          }
          catch (Exception localException3)
          {
          }
        }
        catch (Exception localException4)
        {
          break label93;
        }
      }
      catch (Exception localException2)
      {
        break label75;
      }
    }
    catch (Exception localException1)
    {
      break label49;
    }
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    zza(paramActivity, 0);
    zzcw();
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
    zzcw();
  }

  public final void onActivityPaused(Activity paramActivity)
  {
    zza(paramActivity, 4);
    zzcw();
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    zza(paramActivity, 0);
    zzcw();
    zzcu();
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    zzcw();
  }

  public final void onActivityStarted(Activity paramActivity)
  {
    zza(paramActivity, 0);
    zzcw();
  }

  public final void onActivityStopped(Activity paramActivity)
  {
    zzcw();
  }

  public final void onGlobalLayout()
  {
    zzcw();
  }

  public final void onScrollChanged()
  {
    zzcw();
  }

  public final void onViewAttachedToWindow(View paramView)
  {
    this.zzza = -1;
    zze(paramView);
    zzcw();
  }

  public final void onViewDetachedFromWindow(View paramView)
  {
    this.zzza = -1;
    zzcw();
    zzcu();
    zzf(paramView);
  }

  public final long zzcv()
  {
    if ((this.zzzb <= -2L) && (this.zzyx.get() == null))
      this.zzzb = -3L;
    return this.zzzb;
  }

  final void zzd(View paramView)
  {
    View localView;
    if (this.zzyx != null)
    {
      localView = (View)this.zzyx.get();
      if (localView != null)
      {
        localView.removeOnAttachStateChangeListener(this);
        zzf(localView);
      }
      this.zzyx = new WeakReference(paramView);
      if (paramView == null)
        break label98;
      if ((paramView.getWindowToken() == null) && (paramView.getWindowVisibility() == 8))
        break label93;
    }
    label93: for (int i = 1; ; i = 0)
    {
      if (i != 0)
        zze(paramView);
      paramView.addOnAttachStateChangeListener(this);
      this.zzzb = -2L;
      return;
      localView = null;
      break;
    }
    label98: this.zzzb = -3L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzeh
 * JD-Core Version:    0.6.2
 */