package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.h;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.j;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class x extends e<a, i>
  implements View.OnClickListener
{
  private final ImageView a;
  private final j b;

  public x(ImageView paramImageView, j paramj)
  {
    this.a = paramImageView;
    this.b = paramj;
    this.a.setOnClickListener(this);
  }

  private boolean a(aa paramaa, i parami)
  {
    return (parami.A()) && (!parami.n()) && (paramaa.bi());
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    if (a(parama.c(), parami))
    {
      dj.c(this.a, true);
      this.a.setClickable(true);
      this.a.setImageDrawable(parami.ag().b());
      return;
    }
    dj.c(this.a, false);
    this.a.setClickable(false);
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if (locala != null)
      this.b.e(locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.x
 * JD-Core Version:    0.6.2
 */