package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.ag;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class af
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public af(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    ag localag = new ag(paramView);
    d[] arrayOfd = new d[9];
    arrayOfd[0] = this.a.a(localag.g);
    arrayOfd[1] = this.a.b(localag.h);
    arrayOfd[2] = this.a.c(localag.i);
    arrayOfd[3] = this.a.a(localag.j, localag.k);
    arrayOfd[4] = this.a.e(localag.f);
    arrayOfd[5] = this.a.p(localag.e);
    arrayOfd[6] = this.a.c(localag.l);
    arrayOfd[7] = this.a.a(localag.d, localag.m);
    arrayOfd[8] = this.a.a(paramView, localag.a, localag.b, (c)paramView, localag.d);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localag);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.af
 * JD-Core Version:    0.6.2
 */