package com.viber.voip.messages.adapters.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.b.ab;
import com.viber.voip.messages.adapters.a.b.f;
import com.viber.voip.messages.adapters.a.b.g;
import com.viber.voip.messages.adapters.a.b.n;
import com.viber.voip.messages.adapters.a.b.o;
import com.viber.voip.messages.adapters.a.b.y;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.j;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.e.e;

public class i
  implements a.a
{
  private final j a;
  private final ai b;
  private final e c;
  private final com.viber.voip.messages.d.b d;

  public i(j paramj, ai paramai, e parame, com.viber.voip.messages.d.b paramb)
  {
    this.a = paramj;
    this.b = paramai;
    this.c = parame;
    this.d = paramb;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    Context localContext = paramView.getContext();
    com.viber.voip.messages.adapters.b.i locali = new com.viber.voip.messages.adapters.b.i(paramView);
    d[] arrayOfd = new d[8];
    arrayOfd[0] = new f(localContext, locali.e, this.c);
    arrayOfd[1] = new ab(locali.d);
    arrayOfd[2] = new com.viber.voip.messages.adapters.a.b.i(localContext, locali.b);
    arrayOfd[3] = new y(localContext, locali.c, this.d, this.a, this.b);
    arrayOfd[4] = new n(locali.a);
    arrayOfd[5] = new com.viber.voip.messages.adapters.a.b.b(paramView);
    arrayOfd[6] = new o(locali.f);
    arrayOfd[7] = new g(locali.d);
    return new a(new com.viber.voip.ui.g.b(arrayOfd), locali);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.i
 * JD-Core Version:    0.6.2
 */