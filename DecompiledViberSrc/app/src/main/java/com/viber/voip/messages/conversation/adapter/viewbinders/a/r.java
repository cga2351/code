package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.s;
import com.viber.voip.messages.conversation.adapter.viewbinders.bl;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class r
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public r(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    s locals = new s(paramView);
    bl localbl = this.a.a(locals.o, locals.p, locals.q, locals.r, locals.s, locals.f);
    d[] arrayOfd = new d[13];
    arrayOfd[0] = localbl;
    arrayOfd[1] = this.a.a(locals.f, localbl);
    arrayOfd[2] = this.a.a(locals.g);
    arrayOfd[3] = this.a.b(locals.h);
    arrayOfd[4] = this.a.c(locals.i);
    arrayOfd[5] = this.a.a(locals.a, locals.m);
    arrayOfd[6] = this.a.d(locals.b);
    arrayOfd[7] = this.a.a(locals.c);
    arrayOfd[8] = this.a.e(locals.d);
    arrayOfd[9] = this.a.a(locals.e, (c)paramView);
    arrayOfd[10] = this.a.a(locals.j, locals.k);
    arrayOfd[11] = this.a.a(paramView, locals.l, locals.t, (c)paramView);
    arrayOfd[12] = this.a.r(locals.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), locals);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.r
 * JD-Core Version:    0.6.2
 */