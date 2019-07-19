package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.b.ab;
import com.viber.voip.messages.adapters.a.b.g;
import com.viber.voip.messages.adapters.a.b.t;
import com.viber.voip.messages.adapters.a.b.u;
import com.viber.voip.messages.adapters.a.b.v;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.e.e;

public class j
  implements a.a
{
  private final e a;

  public j(e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    paramView.getContext();
    com.viber.voip.messages.adapters.b.j localj = new com.viber.voip.messages.adapters.b.j(paramView);
    d[] arrayOfd = new d[6];
    arrayOfd[0] = new v(localj.e, this.a);
    arrayOfd[1] = new ab(localj.d);
    arrayOfd[2] = new g(localj.d);
    arrayOfd[3] = new u(localj.a);
    arrayOfd[4] = new t(localj.c);
    arrayOfd[5] = new com.viber.voip.messages.adapters.a.b.b(paramView);
    return new a(new com.viber.voip.ui.g.b(arrayOfd), localj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.j
 * JD-Core Version:    0.6.2
 */