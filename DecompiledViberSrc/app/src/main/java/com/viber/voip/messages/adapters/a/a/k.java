package com.viber.voip.messages.adapters.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.b.ab;
import com.viber.voip.messages.adapters.a.b.g;
import com.viber.voip.messages.adapters.a.b.i;
import com.viber.voip.messages.adapters.a.b.n;
import com.viber.voip.messages.adapters.a.b.u;
import com.viber.voip.messages.adapters.a.b.v;
import com.viber.voip.messages.adapters.a.b.w;
import com.viber.voip.messages.adapters.a.b.y;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.j;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.e.e;

public class k
  implements a.a
{
  private final j a;
  private final ai b;
  private final e c;
  private final com.viber.voip.messages.d.b d;

  public k(j paramj, ai paramai, e parame, com.viber.voip.messages.d.b paramb)
  {
    this.a = paramj;
    this.b = paramai;
    this.c = parame;
    this.d = paramb;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    Context localContext = paramView.getContext();
    com.viber.voip.messages.adapters.b.k localk = new com.viber.voip.messages.adapters.b.k(paramView);
    d[] arrayOfd = new d[9];
    arrayOfd[0] = new v(localk.i, this.c);
    arrayOfd[1] = new ab(localk.h);
    arrayOfd[2] = new w(localContext, localk.b);
    arrayOfd[3] = new u(localk.c);
    arrayOfd[4] = new i(localContext, localk.f);
    arrayOfd[5] = new g(localk.h);
    arrayOfd[6] = new y(localContext, localk.g, this.d, this.a, this.b);
    arrayOfd[7] = new n(localk.a);
    arrayOfd[8] = new com.viber.voip.messages.adapters.a.b.b(paramView);
    return new a(new com.viber.voip.ui.g.b(arrayOfd), localk);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.k
 * JD-Core Version:    0.6.2
 */