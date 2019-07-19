package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.a.c.a.i.a;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.ui.g.e;

public class bi extends e<a, i>
{
  private TextView a;

  public bi(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    this.a.setText(localaa.H());
    i.a locala;
    if (parama.n())
      locala = parami.I();
    while (true)
    {
      if (!localaa.bg())
      {
        this.a.setTextColor(locala.a);
        this.a.setShadowLayer(locala.b, locala.c, locala.d, locala.e);
      }
      return;
      if ((parama.o()) && (!parama.r()))
      {
        if (parama.p())
          locala = parami.K();
        else
          locala = parami.L();
      }
      else if (localaa.aE())
      {
        FormattedMessage localFormattedMessage = localaa.L();
        if ((localFormattedMessage != null) && (localFormattedMessage.hasLastMedia()))
          locala = parami.L();
        else
          locala = parami.K();
      }
      else
      {
        locala = parami.K();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bi
 * JD-Core Version:    0.6.2
 */