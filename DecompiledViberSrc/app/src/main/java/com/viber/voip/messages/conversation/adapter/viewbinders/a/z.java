package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.aa;
import com.viber.voip.messages.conversation.adapter.viewbinders.r;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class z
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public z(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    aa localaa = new aa(paramView);
    r localr = this.a.a(localaa.q);
    d[] arrayOfd = new d[15];
    arrayOfd[0] = localr;
    arrayOfd[1] = this.a.a(localaa.f, localr.b());
    arrayOfd[2] = this.a.a(localaa.g);
    arrayOfd[3] = this.a.b(localaa.h);
    arrayOfd[4] = this.a.c(localaa.i);
    arrayOfd[5] = this.a.a(paramView);
    arrayOfd[6] = this.a.a(localaa.a);
    arrayOfd[7] = this.a.e(localaa.b);
    arrayOfd[8] = this.a.a(localaa.c, (c)paramView);
    arrayOfd[9] = this.a.c(localaa.e);
    arrayOfd[10] = this.a.b(localaa.d);
    arrayOfd[11] = this.a.a(localaa.o, localaa.p);
    arrayOfd[12] = this.a.a(localaa.j, localaa.k);
    arrayOfd[13] = this.a.a(paramView, localaa.l, localaa.m, (c)paramView);
    arrayOfd[14] = this.a.r(localaa.n);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localaa);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.z
 * JD-Core Version:    0.6.2
 */