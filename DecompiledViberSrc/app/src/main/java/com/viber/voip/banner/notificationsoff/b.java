package com.viber.voip.banner.notificationsoff;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.d.c;
import com.viber.voip.settings.d.k;
import com.viber.voip.util.ViberActionRunner.q;
import dagger.a;

public class b
  implements View.OnClickListener, f
{
  private static final Logger a = ViberEnv.getLogger();
  private final f.b b;
  private final g c;
  private View d;
  private f.c e;

  public b(f.b paramb, f.a parama, a<com.viber.voip.notif.f> parama1)
  {
    this.b = paramb;
    this.c = new g(parama, parama1);
  }

  private View a()
  {
    if (this.d == null)
    {
      this.d = this.b.a(R.layout.notifications_off_baner_layout);
      this.d.findViewById(R.id.close_btn).setOnClickListener(this);
      this.d.findViewById(R.id.enable_btn).setOnClickListener(this);
    }
    return this.d;
  }

  private void a(boolean paramBoolean)
  {
    if (this.e != null)
      this.e.a(paramBoolean, c.b);
  }

  private void b()
  {
    if (this.d == null);
    do
    {
      return;
      if (this.c.f())
        this.c.d();
    }
    while (!this.b.b(a()));
    a(false);
  }

  private boolean c()
  {
    return this.c.a();
  }

  public void a(f.c paramc)
  {
    this.e = paramc;
  }

  public void f()
  {
    h();
  }

  public void g()
  {
    b();
  }

  public void h()
  {
    if (c())
    {
      if (this.b.a(a()))
        a(true);
      return;
    }
    b();
  }

  public void i()
  {
    this.c.c();
    h();
  }

  public int j()
  {
    return a().getLayoutParams().height;
  }

  public boolean l()
  {
    return false;
  }

  public void onClick(View paramView)
  {
    if (R.id.close_btn == paramView.getId())
    {
      d.k.a.a(172800000L + System.currentTimeMillis());
      this.c.d();
      h();
    }
    while (R.id.enable_btn != paramView.getId())
      return;
    Context localContext = paramView.getContext();
    localContext.startActivity(ViberActionRunner.q.a(localContext));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.notificationsoff.b
 * JD-Core Version:    0.6.2
 */