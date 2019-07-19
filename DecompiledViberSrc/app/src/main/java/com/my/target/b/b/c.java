package com.my.target.b.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import com.my.target.a.a;
import com.my.target.a.a.a;
import com.my.target.aq;
import com.my.target.aq.a;
import com.my.target.b.c.a.g;
import com.my.target.b.c.a.h;
import com.my.target.b.c.a.i;
import com.my.target.common.MyTargetActivity;
import com.my.target.common.MyTargetActivity.a;
import com.my.target.dp;
import java.lang.ref.WeakReference;

public abstract class c
  implements aq.a, MyTargetActivity.a
{
  final a a;
  private WeakReference<MyTargetActivity> b;
  private WeakReference<aq> c;
  private boolean d;

  c(a parama)
  {
    this.a = parama;
  }

  public static c a(a parama, com.my.target.b.c.a.e parame, com.my.target.b.c.b.c paramc)
  {
    if ((parame instanceof i))
      return f.a(parama, (i)parame, paramc);
    if ((parame instanceof g))
      return d.a(parama, (g)parame, paramc);
    if ((parame instanceof h))
      return e.a(parama, (h)parame);
    return null;
  }

  public void a()
  {
    this.d = false;
    this.c = null;
    a.a locala = this.a.c();
    if (locala != null)
      locala.onDismiss(this.a);
  }

  public final void a(Context paramContext)
  {
    if (this.d)
    {
      dp.a("Unable to open Interstitial Ad twice, please dismiss currently showing ad first");
      return;
    }
    this.d = true;
    MyTargetActivity.a = this;
    Intent localIntent = new Intent(paramContext, MyTargetActivity.class);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  public void a(aq paramaq, FrameLayout paramFrameLayout)
  {
    this.c = new WeakReference(paramaq);
    if (this.a.b())
      paramaq.a();
    a.a locala = this.a.c();
    if (locala != null)
      locala.onDisplay(this.a);
  }

  public void a(MyTargetActivity paramMyTargetActivity, Intent paramIntent, FrameLayout paramFrameLayout)
  {
    this.b = new WeakReference(paramMyTargetActivity);
    paramMyTargetActivity.setTheme(16973830);
    paramMyTargetActivity.getWindow().setFlags(1024, 1024);
    a.a locala = this.a.c();
    if (locala != null)
      locala.onDisplay(this.a);
  }

  public void a(boolean paramBoolean)
  {
  }

  public boolean a(MenuItem paramMenuItem)
  {
    return false;
  }

  public void b()
  {
  }

  public void c()
  {
  }

  public void d()
  {
  }

  public void e()
  {
    this.d = false;
    this.b = null;
    a.a locala = this.a.c();
    if (locala != null)
      locala.onDismiss(this.a);
  }

  public boolean f()
  {
    return true;
  }

  public final void g()
  {
    this.d = false;
    MyTargetActivity localMyTargetActivity;
    if (this.b == null)
    {
      localMyTargetActivity = null;
      if (localMyTargetActivity == null)
        break label37;
      localMyTargetActivity.finish();
    }
    while (true)
    {
      return;
      localMyTargetActivity = (MyTargetActivity)this.b.get();
      break;
      label37: if (this.c == null);
      for (aq localaq = null; (localaq != null) && (localaq.isShowing()); localaq = (aq)this.c.get())
      {
        localaq.dismiss();
        return;
      }
    }
  }

  public void k_()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.b.c
 * JD-Core Version:    0.6.2
 */