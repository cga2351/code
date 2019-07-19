package com.viber.voip.messages.conversation.adapter.e;

import android.view.View;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.l.a;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.d.l;

public class e
  implements q
{
  private final g a;

  public e(g paramg)
  {
    this.a = paramg;
  }

  public void a()
  {
  }

  public boolean a(View paramView, l paraml, aa paramaa)
  {
    if (!paramaa.aE())
      return false;
    if ("Viber".equals(paramaa.d()))
      this.a.a(a.b(String.valueOf(paramaa.y())));
    return true;
  }

  public void b()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.e
 * JD-Core Version:    0.6.2
 */