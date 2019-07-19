package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.a.c.a.i.a;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class ai extends e<a, i>
{
  private final TextView a;

  public ai(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    i.a locala;
    int i;
    if (parama.f())
    {
      dj.b(this.a, true);
      locala = parami.I();
      if (locala.f)
      {
        i = parami.G();
        this.a.setTextColor(i);
        this.a.setBackground(parami.f(i));
      }
    }
    while (true)
    {
      dj.i(this.a);
      return;
      i = locala.a;
      break;
      dj.b(this.a, false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ai
 * JD-Core Version:    0.6.2
 */