package com.viber.voip.messages.conversation.adapter.e;

import android.support.v4.util.Pair;
import android.view.View;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.aj;
import com.viber.voip.messages.d.l;
import com.viber.voip.stickers.b;
import com.viber.voip.widget.u;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class p
  implements q
{
  final Map<l, aa> a = new LinkedHashMap();
  final List<Pair<aa, Boolean>> b = new ArrayList();
  private final b c;
  private final aj d;
  private final i e;
  private final u f;

  public p(b paramb, aj paramaj, i parami, u paramu)
  {
    this.c = paramb;
    this.d = paramaj;
    this.e = parami;
    this.f = paramu;
  }

  public void a()
  {
    this.a.clear();
    this.b.clear();
  }

  public boolean a(View paramView, l paraml, aa paramaa)
  {
    if (!paramaa.ax())
      return false;
    if (this.f.a(0.05F, paramView))
    {
      this.b.add(Pair.create(paramaa, Boolean.valueOf(true)));
      this.a.put(paraml, paramaa);
    }
    while (true)
    {
      return true;
      this.b.add(Pair.create(paramaa, Boolean.valueOf(false)));
    }
  }

  public void b()
  {
    if (this.e.d())
      this.d.a(this.b);
    this.c.a(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.p
 * JD-Core Version:    0.6.2
 */