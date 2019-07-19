package com.viber.voip.messages.ui;

import android.content.Context;
import android.widget.ListAdapter;
import com.viber.voip.ads.b.b.b.c;
import com.viber.voip.ads.b.c.a.b;
import com.viber.voip.ads.b.c.a.i;
import com.viber.voip.messages.adapters.a.c.a.a;
import com.viber.voip.messages.adapters.u;

public class q extends a
{
  private final u d;
  private boolean e;

  public q(Context paramContext, ListAdapter paramListAdapter, u paramu, com.viber.voip.messages.adapters.a.c.a parama, i parami, c paramc, b paramb, int paramInt)
  {
    super(paramContext, paramListAdapter, parama, parami, paramc, paramb, paramInt);
    this.c = -1;
    this.d = paramu;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  protected boolean a()
  {
    return (this.c != -1) && (!this.e) && (this.b != null) && (this.b.c() == a.a.a) && (this.d.getCount() >= this.c);
  }

  protected void b()
  {
    this.e = true;
    super.b();
  }

  protected void c()
  {
    this.e = true;
    super.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.q
 * JD-Core Version:    0.6.2
 */