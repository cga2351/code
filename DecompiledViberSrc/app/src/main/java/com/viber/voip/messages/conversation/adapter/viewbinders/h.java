package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class h extends e<a, i>
  implements View.OnClickListener
{
  private final com.viber.voip.messages.conversation.adapter.d.h a;
  private ImageView b;

  public h(ImageView paramImageView, com.viber.voip.messages.conversation.adapter.d.h paramh)
  {
    this.b = paramImageView;
    this.a = paramh;
    this.b.setOnClickListener(this);
    dj.a(this.b, this.b.getPaddingTop());
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    if (parama.c().aw())
    {
      this.b.setImageDrawable(parami.ae());
      return;
    }
    this.b.setImageDrawable(parami.af());
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if (locala != null)
      this.a.c(locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.h
 * JD-Core Version:    0.6.2
 */