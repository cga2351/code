package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class i extends e<a, com.viber.voip.messages.conversation.adapter.a.c.a.i>
{
  private final TextView a;

  public i(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  private void a(aa paramaa, com.viber.voip.messages.conversation.adapter.a.c.a.i parami)
  {
    if ((paramaa.bK()) && (paramaa.bL()))
    {
      if ("answ_another_dev_group".equals(paramaa.h()))
      {
        dj.b(this.a, false);
        return;
      }
      this.a.setText(parami.f(paramaa));
      dj.b(this.a, true);
      return;
    }
    dj.b(this.a, false);
  }

  public void a(a parama, com.viber.voip.messages.conversation.adapter.a.c.a.i parami)
  {
    super.a(parama, parami);
    a(parama.c(), parami);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.i
 * JD-Core Version:    0.6.2
 */