package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ScrollView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@zzare
@TargetApi(14)
public final class zzty
  implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private static final long zzbtf = ((Long)zzyr.zzpe().zzd(localzzaci)).longValue();
  private final WindowManager zzbtg;

  @VisibleForTesting
  private BroadcastReceiver zzbth;
  private WeakReference<View> zzbti;
  private zzud zzbtj;
  private zzazk zzbtk = new zzazk(zzbtf);
  private boolean zzbtl = false;
  private final HashSet<zzuc> zzbtm = new HashSet();
  private final Rect zzbtn;
  private final DisplayMetrics zzwb;
  private Application zzww;
  private final Context zzys;
  private final PowerManager zzyt;
  private final KeyguardManager zzyu;
  private WeakReference<ViewTreeObserver> zzyw;
  private int zzza = -1;

  static
  {
    zzaci localzzaci = zzact.zzcqj;
  }

  public zzty(Context paramContext, View paramView)
  {
    this.zzys = paramContext.getApplicationContext();
    this.zzbtg = ((WindowManager)paramContext.getSystemService("window"));
    this.zzyt = ((PowerManager)this.zzys.getSystemService("power"));
    this.zzyu = ((KeyguardManager)paramContext.getSystemService("keyguard"));
    if ((this.zzys instanceof Application))
    {
      this.zzww = ((Application)this.zzys);
      this.zzbtj = new zzud((Application)this.zzys, this);
    }
    this.zzwb = paramContext.getResources().getDisplayMetrics();
    this.zzbtn = new Rect();
    this.zzbtn.right = this.zzbtg.getDefaultDisplay().getWidth();
    this.zzbtn.bottom = this.zzbtg.getDefaultDisplay().getHeight();
    if (this.zzbti != null);
    for (View localView = (View)this.zzbti.get(); ; localView = null)
    {
      if (localView != null)
      {
        localView.removeOnAttachStateChangeListener(this);
        zzf(localView);
      }
      this.zzbti = new WeakReference(paramView);
      if (paramView != null)
      {
        if (zzk.zzli().isAttachedToWindow(paramView))
          zze(paramView);
        paramView.addOnAttachStateChangeListener(this);
      }
      return;
    }
  }

  private final Rect zza(Rect paramRect)
  {
    return new Rect(zzbv(paramRect.left), zzbv(paramRect.top), zzbv(paramRect.right), zzbv(paramRect.bottom));
  }

  private final void zza(Activity paramActivity, int paramInt)
  {
    if (this.zzbti == null);
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
      localView2 = (View)this.zzbti.get();
    }
    while ((localView2 == null) || (localView1 == null) || (localView2.getRootView() != localView1.getRootView()));
    this.zzza = paramInt;
  }

  private final void zzbu(int paramInt)
  {
    if (this.zzbtm.size() == 0);
    while (true)
    {
      return;
      if (this.zzbti != null)
      {
        View localView = (View)this.zzbti.get();
        int i;
        int j;
        Rect localRect1;
        Rect localRect2;
        Rect localRect3;
        Rect localRect4;
        int[] arrayOfInt1;
        int[] arrayOfInt2;
        boolean bool1;
        boolean bool2;
        if (paramInt == 1)
        {
          i = 1;
          if (localView != null)
            break label477;
          j = 1;
          localRect1 = new Rect();
          localRect2 = new Rect();
          localRect3 = new Rect();
          localRect4 = new Rect();
          arrayOfInt1 = new int[2];
          arrayOfInt2 = new int[2];
          bool1 = false;
          bool2 = false;
          if (localView != null)
          {
            bool1 = localView.getGlobalVisibleRect(localRect2);
            bool2 = localView.getLocalVisibleRect(localRect3);
            localView.getHitRect(localRect4);
          }
        }
        try
        {
          localView.getLocationOnScreen(arrayOfInt1);
          localView.getLocationInWindow(arrayOfInt2);
          localRect1.left = arrayOfInt1[0];
          localRect1.top = arrayOfInt1[1];
          localRect1.right = (localRect1.left + localView.getWidth());
          localRect1.bottom = (localRect1.top + localView.getHeight());
          zzaci localzzaci = zzact.zzcqm;
          if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (localView != null))
          {
            localList = zzh(localView);
            if (localView == null)
              break label504;
            k = localView.getWindowVisibility();
            if (this.zzza != -1)
              k = this.zzza;
            if ((j != 0) || (!zzk.zzlg().zza(localView, this.zzyt, this.zzyu)) || (!bool1) || (!bool2) || (k != 0))
              break label511;
            bool3 = true;
            if ((i != 0) && (!this.zzbtk.tryAcquire()))
            {
              boolean bool6 = this.zzbtl;
              if (bool3 == bool6)
                continue;
            }
            if ((!bool3) && (!this.zzbtl) && (paramInt == 1))
              continue;
            long l = zzk.zzln().elapsedRealtime();
            boolean bool4 = this.zzyt.isScreenOn();
            if ((localView == null) || (!zzk.zzli().isAttachedToWindow(localView)))
              break label517;
            bool5 = true;
            if (localView == null)
              break label523;
            m = localView.getWindowVisibility();
            zzub localzzub = new zzub(l, bool4, bool5, m, zza(this.zzbtn), zza(localRect1), zza(localRect2), bool1, zza(localRect3), bool2, zza(localRect4), this.zzwb.density, bool3, localList);
            Iterator localIterator = this.zzbtm.iterator();
            while (true)
              if (localIterator.hasNext())
              {
                ((zzuc)localIterator.next()).zza(localzzub);
                continue;
                i = 0;
                break;
                label477: j = 0;
              }
          }
        }
        catch (Exception localException)
        {
          boolean bool3;
          while (true)
          {
            zzaxa.zzc("Failure getting view location.", localException);
            continue;
            List localList = Collections.emptyList();
            continue;
            label504: int k = 8;
            continue;
            label511: bool3 = false;
            continue;
            label517: boolean bool5 = false;
            continue;
            label523: int m = 8;
          }
          this.zzbtl = bool3;
        }
      }
    }
  }

  private final int zzbv(int paramInt)
  {
    float f = this.zzwb.density;
    return (int)(paramInt / f);
  }

  private final void zzcu()
  {
    zzk.zzlg();
    zzaxj.zzdvx.post(new zztz(this));
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
    if (this.zzbth == null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      this.zzbth = new zzua(this);
      zzk.zzmb().zza(this.zzys, this.zzbth, localIntentFilter);
    }
    if (this.zzww != null);
    try
    {
      this.zzww.registerActivityLifecycleCallbacks(this.zzbtj);
      return;
    }
    catch (Exception localException)
    {
      zzaxa.zzc("Error registering activity lifecycle callbacks.", localException);
    }
  }

  // ERROR //
  private final void zzf(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 387	com/google/android/gms/internal/ads/zzty:zzyw	Ljava/lang/ref/WeakReference;
    //   4: ifnull +45 -> 49
    //   7: aload_0
    //   8: getfield 387	com/google/android/gms/internal/ads/zzty:zzyw	Ljava/lang/ref/WeakReference;
    //   11: invokevirtual 184	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   14: checkcast 382	android/view/ViewTreeObserver
    //   17: astore 8
    //   19: aload 8
    //   21: ifnull +23 -> 44
    //   24: aload 8
    //   26: invokevirtual 385	android/view/ViewTreeObserver:isAlive	()Z
    //   29: ifeq +15 -> 44
    //   32: aload 8
    //   34: aload_0
    //   35: invokevirtual 433	android/view/ViewTreeObserver:removeOnScrollChangedListener	(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V
    //   38: aload 8
    //   40: aload_0
    //   41: invokevirtual 436	android/view/ViewTreeObserver:removeGlobalOnLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 387	com/google/android/gms/internal/ads/zzty:zzyw	Ljava/lang/ref/WeakReference;
    //   49: aload_1
    //   50: invokevirtual 380	android/view/View:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   53: astore 7
    //   55: aload 7
    //   57: invokevirtual 385	android/view/ViewTreeObserver:isAlive	()Z
    //   60: ifeq +15 -> 75
    //   63: aload 7
    //   65: aload_0
    //   66: invokevirtual 433	android/view/ViewTreeObserver:removeOnScrollChangedListener	(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V
    //   69: aload 7
    //   71: aload_0
    //   72: invokevirtual 436	android/view/ViewTreeObserver:removeGlobalOnLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   75: aload_0
    //   76: getfield 397	com/google/android/gms/internal/ads/zzty:zzbth	Landroid/content/BroadcastReceiver;
    //   79: ifnull +22 -> 101
    //   82: invokestatic 417	com/google/android/gms/ads/internal/zzk:zzmb	()Lcom/google/android/gms/internal/ads/zzazq;
    //   85: aload_0
    //   86: getfield 107	com/google/android/gms/internal/ads/zzty:zzys	Landroid/content/Context;
    //   89: aload_0
    //   90: getfield 397	com/google/android/gms/internal/ads/zzty:zzbth	Landroid/content/BroadcastReceiver;
    //   93: invokevirtual 439	com/google/android/gms/internal/ads/zzazq:zza	(Landroid/content/Context;Landroid/content/BroadcastReceiver;)V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 397	com/google/android/gms/internal/ads/zzty:zzbth	Landroid/content/BroadcastReceiver;
    //   101: aload_0
    //   102: getfield 133	com/google/android/gms/internal/ads/zzty:zzww	Landroid/app/Application;
    //   105: ifnull +14 -> 119
    //   108: aload_0
    //   109: getfield 133	com/google/android/gms/internal/ads/zzty:zzww	Landroid/app/Application;
    //   112: aload_0
    //   113: getfield 140	com/google/android/gms/internal/ads/zzty:zzbtj	Lcom/google/android/gms/internal/ads/zzud;
    //   116: invokevirtual 442	android/app/Application:unregisterActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   119: return
    //   120: astore_2
    //   121: ldc_w 444
    //   124: aload_2
    //   125: invokestatic 354	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: goto -79 -> 49
    //   131: astore_3
    //   132: ldc_w 446
    //   135: aload_3
    //   136: invokestatic 354	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: goto -64 -> 75
    //   142: astore 6
    //   144: ldc_w 448
    //   147: aload 6
    //   149: invokestatic 354	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: goto -56 -> 96
    //   155: astore 5
    //   157: invokestatic 452	com/google/android/gms/ads/internal/zzk:zzlk	()Lcom/google/android/gms/internal/ads/zzawn;
    //   160: aload 5
    //   162: ldc_w 454
    //   165: invokevirtual 459	com/google/android/gms/internal/ads/zzawn:zza	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   168: goto -72 -> 96
    //   171: astore 4
    //   173: ldc_w 428
    //   176: aload 4
    //   178: invokestatic 354	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	19	120	java/lang/Exception
    //   24	44	120	java/lang/Exception
    //   44	49	120	java/lang/Exception
    //   49	75	131	java/lang/Exception
    //   82	96	142	java/lang/IllegalStateException
    //   82	96	155	java/lang/Exception
    //   108	119	171	java/lang/Exception
  }

  private final List<Rect> zzh(View paramView)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        Rect localRect = new Rect();
        boolean bool1;
        if (Build.VERSION.SDK_INT >= 16)
          bool1 = localView.isScrollContainer();
        while (true)
        {
          if ((bool1) && (localView.getGlobalVisibleRect(localRect)))
            localArrayList.add(zza(localRect));
          localViewParent = localViewParent.getParent();
          break;
          if (!(localView instanceof ScrollView))
          {
            boolean bool2 = localView instanceof ListView;
            if (!bool2);
          }
          else
          {
            bool1 = true;
            continue;
          }
          bool1 = false;
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      zzk.zzlk().zza(localException, "PositionWatcher.getParentScrollViewRects");
    }
    return Collections.emptyList();
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    zza(paramActivity, 0);
    zzbu(3);
    zzcu();
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
    zzbu(3);
    zzcu();
  }

  public final void onActivityPaused(Activity paramActivity)
  {
    zza(paramActivity, 4);
    zzbu(3);
    zzcu();
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    zza(paramActivity, 0);
    zzbu(3);
    zzcu();
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    zzbu(3);
    zzcu();
  }

  public final void onActivityStarted(Activity paramActivity)
  {
    zza(paramActivity, 0);
    zzbu(3);
    zzcu();
  }

  public final void onActivityStopped(Activity paramActivity)
  {
    zzbu(3);
    zzcu();
  }

  public final void onGlobalLayout()
  {
    zzbu(2);
    zzcu();
  }

  public final void onScrollChanged()
  {
    zzbu(1);
  }

  public final void onViewAttachedToWindow(View paramView)
  {
    this.zzza = -1;
    zze(paramView);
    zzbu(3);
  }

  public final void onViewDetachedFromWindow(View paramView)
  {
    this.zzza = -1;
    zzbu(3);
    zzcu();
    zzf(paramView);
  }

  public final void zza(zzuc paramzzuc)
  {
    this.zzbtm.add(paramzzuc);
    zzbu(3);
  }

  public final void zzb(zzuc paramzzuc)
  {
    this.zzbtm.remove(paramzzuc);
  }

  public final void zzes(long paramLong)
  {
    this.zzbtk.zzfe(paramLong);
  }

  public final void zzmk()
  {
    this.zzbtk.zzfe(zzbtf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzty
 * JD-Core Version:    0.6.2
 */