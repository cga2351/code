package com.viber.voip.messages.adapters.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.a;
import com.viber.voip.ui.g.d;

public class b
  implements a.a
{
  private final e a;

  public b(e parame)
  {
    this.a = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.b.b localb = new com.viber.voip.messages.adapters.b.b(paramView);
    d[] arrayOfd = new d[7];
    arrayOfd[0] = this.a.a(localb.g);
    arrayOfd[1] = this.a.a(localb.f);
    arrayOfd[2] = this.a.b(localb.f);
    arrayOfd[3] = this.a.a(localb.a);
    arrayOfd[4] = this.a.d(localb.e);
    arrayOfd[5] = this.a.a(localb.b, localb.c);
    arrayOfd[6] = this.a.c(paramView);
    return new a(new com.viber.voip.ui.g.b(arrayOfd), localb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.a.b
 * JD-Core Version:    0.6.2
 */