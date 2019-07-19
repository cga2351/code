package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.b;

public class c
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public c(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.conversation.adapter.c.d locald = new com.viber.voip.messages.conversation.adapter.c.d(paramView);
    com.viber.voip.ui.g.d[] arrayOfd = new com.viber.voip.ui.g.d[3];
    arrayOfd[0] = this.a.c(locald.b);
    arrayOfd[1] = this.a.i(paramView);
    arrayOfd[2] = this.a.a(locald.c, locald.d);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), locald);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.c
 * JD-Core Version:    0.6.2
 */