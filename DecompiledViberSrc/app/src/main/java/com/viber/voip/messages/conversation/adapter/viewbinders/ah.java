package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.a.c.a.i.a;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class ah extends e<a, i>
{
  private final TextView a;

  public ah(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    if (parama.q())
    {
      dj.b(this.a, true);
      i.a locala;
      TextView localTextView;
      if ((parama.n()) && (!parama.c().bD()))
      {
        locala = parami.I();
        localTextView = this.a;
        if (!locala.f)
          break label119;
      }
      label119: for (int i = parami.t(); ; i = locala.a)
      {
        localTextView.setTextColor(i);
        this.a.setShadowLayer(locala.b, locala.c, locala.d, locala.e);
        this.a.setText(parama.e().a(parami.h()));
        return;
      }
    }
    dj.b(this.a, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ah
 * JD-Core Version:    0.6.2
 */