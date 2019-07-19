package com.viber.voip.messages.conversation.adapter.viewbinders.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.c.z;
import com.viber.voip.ui.g.b;
import com.viber.voip.ui.g.d;
import com.viber.voip.widget.b.c;

public class y
  implements a.a
{
  private final com.viber.voip.messages.conversation.adapter.e.a a;

  public y(com.viber.voip.messages.conversation.adapter.e.a parama)
  {
    this.a = parama;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    z localz = new z(paramView);
    d[] arrayOfd = new d[7];
    arrayOfd[0] = this.a.b(localz.i);
    arrayOfd[1] = this.a.a(localz.b);
    arrayOfd[2] = this.a.b(localz.c);
    arrayOfd[3] = this.a.c(localz.d);
    arrayOfd[4] = this.a.e(localz.a);
    arrayOfd[5] = this.a.a(localz.e, localz.f);
    arrayOfd[6] = this.a.a(paramView, localz.g, localz.h, (c)paramView);
    return new com.viber.voip.ui.g.a(new b(arrayOfd), localz);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a.y
 * JD-Core Version:    0.6.2
 */