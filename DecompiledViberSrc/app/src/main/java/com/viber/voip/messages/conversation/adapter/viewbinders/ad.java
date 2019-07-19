package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.q;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class ad extends e<a, i>
  implements View.OnClickListener
{
  private final ImageView a;
  private final q b;

  public ad(ImageView paramImageView, q paramq)
  {
    this.a = paramImageView;
    this.b = paramq;
    this.a.setOnClickListener(this);
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    boolean bool;
    Drawable localDrawable;
    if (((localaa.l()) && (!localaa.ay())) || (localaa.z() == 0))
    {
      bool = true;
      dj.b(this.a, bool);
      this.a.setClickable(bool);
      if (!parama.n())
        break label91;
      localDrawable = parami.M();
    }
    while (true)
    {
      if (localDrawable != null)
        this.a.setImageDrawable(localDrawable);
      return;
      bool = false;
      break;
      label91: if ((parama.o()) && (!parama.r()))
      {
        if (parama.p())
          localDrawable = parami.N();
        else
          localDrawable = parami.P();
      }
      else if (localaa.aE())
      {
        FormattedMessage localFormattedMessage = localaa.L();
        if ((localFormattedMessage != null) && (localFormattedMessage.hasLastMedia()))
          localDrawable = parami.P();
        else
          localDrawable = parami.N();
      }
      else if (bool)
      {
        localDrawable = parami.N();
      }
      else
      {
        localDrawable = null;
      }
    }
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    i locali = (i)e();
    if ((locala != null) && (locali != null))
      this.b.a(locala.c(), locali.A());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ad
 * JD-Core Version:    0.6.2
 */