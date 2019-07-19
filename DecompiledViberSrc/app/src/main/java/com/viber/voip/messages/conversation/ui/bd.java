package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.d.b;
import com.viber.voip.messages.a.f.b;
import com.viber.voip.messages.conversation.ui.banner.AlertView;
import com.viber.voip.messages.conversation.ui.banner.AlertView.b;
import com.viber.voip.messages.conversation.ui.banner.AlertView.c;
import com.viber.voip.messages.conversation.ui.banner.b.b;
import com.viber.voip.messages.conversation.ui.banner.o;
import com.viber.voip.messages.conversation.ui.banner.o.a;
import com.viber.voip.messages.conversation.ui.banner.o.b;
import com.viber.voip.util.ViberActionRunner.m;
import com.viber.voip.util.av;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class bd
  implements o.b
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private AlertView c;
  private final AlertView.b d;
  private final o.a e;
  private b.b f;
  private o.b g;
  private final Handler h;
  private final Runnable i;
  private final EventBus j;
  private final int k;
  private o l;
  private LayoutInflater m;

  public bd(Context paramContext, AlertView.b paramb, Handler paramHandler, EventBus paramEventBus, int paramInt, o.a parama, LayoutInflater paramLayoutInflater)
  {
    this.b = paramContext;
    this.h = paramHandler;
    this.j = paramEventBus;
    this.k = paramInt;
    this.d = paramb;
    this.e = parama;
    this.i = new a(this);
    this.m = paramLayoutInflater;
  }

  private void d()
  {
    g().a(f(), true);
    this.h.removeCallbacks(this.i);
    this.h.postDelayed(this.i, 2400L);
  }

  private void e()
  {
    if (this.c != null)
      this.c.a(AlertView.c.a, true);
  }

  private o f()
  {
    if (this.l == null)
      this.l = new o(g(), this, this.e, this.f, this.m);
    return this.l;
  }

  private AlertView g()
  {
    if (this.c == null)
      this.c = this.d.M_();
    return this.c;
  }

  public void a()
  {
    this.j.register(this);
  }

  public void a(o.b paramb)
  {
    this.g = paramb;
  }

  public void b()
  {
    this.j.unregister(this);
  }

  public void c()
  {
    if (this.g != null)
      this.g.c();
    ViberActionRunner.m.a(this.b);
    this.h.removeCallbacks(this.i);
    this.i.run();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onEvent(f.b paramb)
  {
    if (av.d(paramb.a, this.k))
      d();
  }

  private static final class a extends b<bd>
  {
    public a(bd parambd)
    {
      super();
    }

    public void a(bd parambd)
    {
      bd.a(parambd);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bd
 * JD-Core Version:    0.6.2
 */