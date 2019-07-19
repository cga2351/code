package com.viber.voip.messages.conversation.adapter.e;

import android.view.View;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.d.l;
import com.viber.voip.u.d;
import com.viber.voip.widget.u;
import java.util.LinkedHashMap;
import java.util.Map;

public class g
  implements q
{
  final Map<l, aa> a = new LinkedHashMap();
  private final d b;
  private final u c;

  public g(d paramd, u paramu)
  {
    this.b = paramd;
    this.c = paramu;
  }

  public void a()
  {
    this.a.clear();
  }

  public boolean a(View paramView, l paraml, aa paramaa)
  {
    if (!paramaa.aK())
      return false;
    if (this.c.a(0.4F, paramView))
      this.a.put(paraml, paramaa);
    return true;
  }

  public void b()
  {
    this.b.a(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.g
 * JD-Core Version:    0.6.2
 */