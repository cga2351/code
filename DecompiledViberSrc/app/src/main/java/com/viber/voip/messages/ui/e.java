package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.viber.common.ui.c;
import com.viber.voip.util.dj;

public abstract class e
  implements ViewTreeObserver.OnPreDrawListener
{
  protected final Context a;
  protected final ViewGroup b;
  protected final View c;
  protected c d;

  public e(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    this.a = paramContext;
    this.b = paramViewGroup;
    this.c = paramView;
  }

  private void a(c paramc)
  {
    paramc.a();
    ViewTreeObserver localViewTreeObserver = this.b.getViewTreeObserver();
    localViewTreeObserver.removeOnPreDrawListener(this);
    localViewTreeObserver.addOnPreDrawListener(this);
  }

  private c e()
  {
    if (this.d == null)
      this.d = a(this.a.getResources());
    return this.d;
  }

  protected abstract c a(Resources paramResources);

  public void a()
  {
    if (this.d != null)
    {
      this.d.b();
      this.b.getViewTreeObserver().removeOnPreDrawListener(this);
    }
  }

  public void b()
  {
    final c localc = e();
    if (!localc.d())
    {
      if ((ViewCompat.isAttachedToWindow(this.c)) && (this.c.getWidth() > 0) && (this.c.getHeight() > 0))
        a(localc);
    }
    else
      return;
    dj.a(this.b, new Runnable()
    {
      public void run()
      {
        e.a(e.this, localc);
      }
    });
  }

  public final boolean c()
  {
    return (this.d != null) && (this.d.d());
  }

  public void d()
  {
    a();
    this.d = null;
  }

  public boolean onPreDraw()
  {
    if (this.d != null)
      this.d.c();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.e
 * JD-Core Version:    0.6.2
 */