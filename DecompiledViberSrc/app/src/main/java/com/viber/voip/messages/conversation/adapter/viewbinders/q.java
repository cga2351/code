package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;

public class q extends e<com.viber.voip.messages.conversation.adapter.a.a, i>
{
  private final View a;

  public q(View paramView)
  {
    this.a = paramView;
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    super.a(parama, parami);
    if ((parama.b()) || (parama.a()));
    for (boolean bool = true; ; bool = false)
    {
      int i = parami.F().c(bool);
      int j = parami.F().d(bool);
      if ((this.a.getPaddingTop() != i) || (this.a.getPaddingBottom() != j))
        this.a.setPadding(this.a.getPaddingLeft(), i, this.a.getPaddingRight(), j);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.q
 * JD-Core Version:    0.6.2
 */