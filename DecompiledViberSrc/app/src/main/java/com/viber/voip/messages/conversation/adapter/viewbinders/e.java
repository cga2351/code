package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.util.dj;

public class e extends com.viber.voip.ui.g.e<a, i>
{
  private final ImageView a;

  public e(ImageView paramImageView)
  {
    this.a = paramImageView;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    boolean bool = localaa.R();
    dj.b(this.a, bool);
    Drawable localDrawable = null;
    if (parama.n())
      this.a.setImageDrawable(parami.Q());
    while (true)
    {
      if (localDrawable != null)
        this.a.setImageDrawable(localDrawable);
      return;
      if (parama.o())
      {
        if (parama.p())
          localDrawable = parami.R();
        else
          localDrawable = parami.S();
      }
      else if (localaa.aE())
      {
        FormattedMessage localFormattedMessage = localaa.L();
        if ((localFormattedMessage != null) && (localFormattedMessage.hasLastMedia()))
          localDrawable = parami.S();
        else
          localDrawable = parami.R();
      }
      else
      {
        localDrawable = null;
        if (bool)
          localDrawable = parami.R();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.e
 * JD-Core Version:    0.6.2
 */