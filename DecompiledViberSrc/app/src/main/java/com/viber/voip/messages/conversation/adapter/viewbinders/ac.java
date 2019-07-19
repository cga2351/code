package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class ac extends e<a, i>
{
  private final View a;
  private final View b;
  private boolean c;

  public ac(View paramView1, View paramView2)
  {
    this.a = paramView1;
    this.b = paramView2;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    if (parama.b())
    {
      if (!this.c)
      {
        this.c = true;
        this.a.setBackground(parami.ax());
      }
      dj.b(this.a, true);
      dj.b(this.b, true);
      return;
    }
    dj.b(this.a, false);
    dj.b(this.b, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ac
 * JD-Core Version:    0.6.2
 */