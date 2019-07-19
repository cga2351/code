package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.viber.voip.backgrounds.m;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.d;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;
import com.viber.voip.widget.VideoPttMessageLayout;

public class z extends e<a, i>
  implements View.OnClickListener
{
  private final VideoPttMessageLayout a;

  public z(VideoPttMessageLayout paramVideoPttMessageLayout, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, d paramd)
  {
    this.a = paramVideoPttMessageLayout;
    this.a.setOnClickListener(this);
    this.a.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
    this.a.setInstanMediaMessageClickListener(paramd);
  }

  public void a(a parama, i parami)
  {
    boolean bool1 = true;
    super.a(parama, parami);
    if (parami.w() != parama.c().x())
      this.a.a(parama.c(), bool1);
    boolean bool2;
    VideoPttMessageLayout localVideoPttMessageLayout;
    if (parama.c().ap())
    {
      if (parami.w() != parama.c().x())
        break label101;
      bool2 = bool1;
      localVideoPttMessageLayout = this.a;
      if (bool2)
        break label107;
    }
    while (true)
    {
      dj.c(localVideoPttMessageLayout, bool1);
      this.a.setSoundIconType(m.c(parami.l()));
      return;
      label101: bool2 = false;
      break;
      label107: bool1 = false;
    }
  }

  public void onClick(View paramView)
  {
    this.a.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.z
 * JD-Core Version:    0.6.2
 */