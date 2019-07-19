package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.s;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class av extends e<a, i>
  implements View.OnClickListener
{
  private final ImageView a;
  private final s b;

  public av(ImageView paramImageView, s params)
  {
    this.a = paramImageView;
    this.b = params;
    this.a.setOnClickListener(this);
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if ((localaa.f() == -1) && ((0x10 & localaa.E()) == 0));
    for (boolean bool = true; ; bool = false)
    {
      dj.c(this.a, bool);
      this.a.setClickable(bool);
      return;
    }
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if (locala != null)
      this.b.i(locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.av
 * JD-Core Version:    0.6.2
 */