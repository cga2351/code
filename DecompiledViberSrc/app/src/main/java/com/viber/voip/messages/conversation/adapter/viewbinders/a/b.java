package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class b
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public b(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.conversation.adapter.c.b localb = new com.viber.voip.messages.conversation.adapter.c.b(paramView);
    d[] arrayOfd = new d[6];
    arrayOfd[0] = this.a.a(localb.a);
    arrayOfd[1] = this.a.b(localb.b);
    arrayOfd[2] = this.a.c(localb.c);
    arrayOfd[3] = this.a.j(localb.h);
    arrayOfd[4] = this.a.a(localb.d, localb.e);
    arrayOfd[5] = this.a.a(paramView, localb.f, localb.g, (c)paramView);
    return new com.viber.voip.ui.g.a(new com.viber.voip.ui.g.b(arrayOfd), localb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.b
 * JD-Core Version:    0.6.2
 */