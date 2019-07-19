package com.my.target.b.d;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout.LayoutParams;
import com.my.target.a;
import com.my.target.a.b;
import com.my.target.au;
import com.my.target.au.a;
import com.my.target.aw;
import com.my.target.b.c.a.g;
import com.my.target.bj;
import com.my.target.c;
import com.my.target.d;
import com.my.target.dp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class i
  implements a.b, l
{
  private final au a;
  private final d b;
  private final a c;
  private final WeakReference<Activity> d;
  private final Context e;
  private String f;
  private Integer g;
  private boolean h = true;
  private c i = c.a();
  private aw j;
  private boolean k;
  private l.a l;
  private boolean m;
  private g n;

  private i(Context paramContext)
  {
    this(a.a("interstitial"), paramContext);
  }

  private i(a parama, Context paramContext)
  {
    this.c = parama;
    this.e = paramContext.getApplicationContext();
    if ((paramContext instanceof Activity));
    for (this.d = new WeakReference((Activity)paramContext); ; this.d = new WeakReference(null))
    {
      this.f = "loading";
      this.b = d.a(paramContext);
      this.a = new au(paramContext);
      this.a.setOnCloseListener(new au.a()
      {
        public final void a()
        {
          i.this.g();
        }
      });
      parama.a(this);
      return;
    }
  }

  public static i a(Context paramContext)
  {
    return new i(paramContext);
  }

  private boolean a(int paramInt)
  {
    Activity localActivity = (Activity)this.d.get();
    if ((localActivity == null) || (!a(this.i)))
    {
      this.c.a("setOrientationProperties", "Attempted to lock orientation to unsupported value: " + this.i.toString());
      return false;
    }
    if (this.g == null)
      this.g = Integer.valueOf(localActivity.getRequestedOrientation());
    localActivity.setRequestedOrientation(paramInt);
    return true;
  }

  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }

  private boolean a(c paramc)
  {
    if ("none".equals(paramc.toString()))
      return true;
    Activity localActivity = (Activity)this.d.get();
    if (localActivity == null)
      return false;
    ActivityInfo localActivityInfo;
    try
    {
      localActivityInfo = localActivity.getPackageManager().getActivityInfo(new ComponentName(localActivity, localActivity.getClass()), 0);
      int i1 = localActivityInfo.screenOrientation;
      if (i1 == -1)
        break label82;
      if (i1 == paramc.b())
        return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      return false;
    }
    return false;
    label82: return (a(localActivityInfo.configChanges, 128)) && (a(localActivityInfo.configChanges, 1024));
  }

  private void b(String paramString)
  {
    dp.a("MRAID state set to " + paramString);
    this.f = paramString;
    this.c.d(paramString);
    if ("hidden".equals(paramString))
    {
      dp.a("InterstitialMraidPresenter: Mraid on close");
      if (this.l != null)
        this.l.b();
    }
  }

  private void h()
  {
    Activity localActivity = (Activity)this.d.get();
    if ((localActivity != null) && (this.g != null))
      localActivity.setRequestedOrientation(this.g.intValue());
    this.g = null;
  }

  private void i()
  {
    DisplayMetrics localDisplayMetrics = this.e.getResources().getDisplayMetrics();
    this.b.a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    this.b.a(0, 0, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    this.b.b(0, 0, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    this.b.c(0, 0, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }

  public final void a()
  {
    g();
  }

  public final void a(Uri paramUri)
  {
    if (this.l != null)
      this.l.a(this.n, paramUri.toString(), this.a.getContext());
  }

  public final void a(a parama)
  {
    this.f = "default";
    i();
    ArrayList localArrayList = new ArrayList();
    Activity localActivity = (Activity)this.d.get();
    if ((localActivity == null) || (this.j == null));
    for (boolean bool = false; ; bool = bj.a(localActivity, this.j))
    {
      if (bool)
        localArrayList.add("'inlineVideo'");
      localArrayList.add("'vpaid'");
      parama.a(localArrayList);
      parama.c("interstitial");
      parama.a(parama.c());
      b("default");
      parama.b();
      parama.a(this.b);
      if ((this.l != null) && (this.n != null))
        this.l.a(this.n, this.e);
      return;
    }
  }

  public final void a(g paramg)
  {
    this.n = paramg;
    String str = paramg.I();
    if (str != null)
    {
      this.j = new aw(this.e);
      this.c.a(this.j);
      this.a.addView(this.j, new FrameLayout.LayoutParams(-1, -1));
      this.c.b(str);
    }
  }

  public final void a(l.a parama)
  {
    this.l = parama;
  }

  public final void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }

  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if (!this.m)
    {
      this.c.a("playheadEvent", "Calling VPAID command before VPAID init");
      return false;
    }
    if ((paramFloat1 >= 0.0F) && (paramFloat2 >= 0.0F) && (this.l != null) && (this.n != null))
      this.l.a(paramFloat1, paramFloat2, this.e);
    return true;
  }

  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    dp.a("setResizeProperties method not used with interstitials");
    return false;
  }

  public final boolean a(ConsoleMessage paramConsoleMessage, a parama)
  {
    dp.a("Console message: " + paramConsoleMessage.message());
    return true;
  }

  public final boolean a(String paramString)
  {
    if (!this.m)
    {
      this.c.a("vpaidEvent", "Calling VPAID command before VPAID init");
      return false;
    }
    if (this.l != null);
    for (int i1 = 1; ; i1 = 0)
    {
      g localg = this.n;
      int i2 = 0;
      if (localg != null)
        i2 = 1;
      if ((i1 & i2) != 0)
        this.l.b(this.n, paramString, this.e);
      return true;
    }
  }

  public final boolean a(String paramString, JsResult paramJsResult)
  {
    dp.a("JS Alert: " + paramString);
    paramJsResult.confirm();
    return true;
  }

  public final boolean a(boolean paramBoolean, c paramc)
  {
    if (!a(paramc))
    {
      this.c.a("setOrientationProperties", "Unable to force orientation to " + paramc);
      return false;
    }
    this.h = paramBoolean;
    this.i = paramc;
    if ("none".equals(this.i.toString()))
    {
      if (this.h)
      {
        h();
        return true;
      }
      Activity localActivity = (Activity)this.d.get();
      if (localActivity == null)
      {
        this.c.a("setOrientationProperties", "Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
        return false;
      }
      return a(bj.a(localActivity));
    }
    return a(this.i.b());
  }

  public final void b()
  {
    i();
  }

  public final void b(boolean paramBoolean)
  {
    boolean bool1 = true;
    if (!this.a.a());
    for (boolean bool2 = bool1; paramBoolean == bool2; bool2 = false)
      return;
    au localau = this.a;
    if (!paramBoolean);
    while (true)
    {
      localau.setCloseVisible(bool1);
      return;
      bool1 = false;
    }
  }

  public final boolean b(Uri paramUri)
  {
    dp.a("Expand method not used with interstitials");
    return false;
  }

  public final void c()
  {
    this.k = true;
    if (this.j != null)
      this.j.a(false);
  }

  public final boolean d()
  {
    dp.a("resize method not used with interstitials");
    return false;
  }

  public final void e()
  {
    if (!this.k)
    {
      this.k = true;
      if (this.j != null)
        this.j.a(true);
    }
    ViewParent localViewParent = this.a.getParent();
    if ((localViewParent instanceof ViewGroup))
      ((ViewGroup)localViewParent).removeView(this.a);
    this.c.a();
    if (this.j != null)
    {
      this.j.destroy();
      this.j = null;
    }
    this.a.removeAllViews();
  }

  public final View f()
  {
    return this.a;
  }

  final void g()
  {
    if (this.j == null);
    do
    {
      do
        return;
      while (("loading".equals(this.f)) || ("hidden".equals(this.f)));
      h();
    }
    while (!"default".equals(this.f));
    this.a.setVisibility(4);
    b("hidden");
  }

  public final void l_()
  {
    this.k = true;
    if (this.j != null)
      this.j.a(false);
  }

  public final void m_()
  {
    this.k = false;
    if (this.j != null)
      this.j.onResume();
  }

  public final void n_()
  {
    this.m = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.i
 * JD-Core Version:    0.6.2
 */