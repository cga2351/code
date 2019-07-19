package com.viber.voip.messages.adapters.a.b;

import android.view.View;
import com.viber.voip.messages.adapters.b;
import com.viber.voip.messages.conversation.publicaccount.h;
import com.viber.voip.ui.g.e;
import com.viber.voip.widget.PublicAccountAdView.a;

public class s extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private h a;

  public s(View paramView, PublicAccountAdView.a parama)
  {
    this.a = new h(paramView, parama);
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    b localb = (b)parama;
    boolean bool = parama1.q();
    this.a.a(localb.j(), bool);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.s
 * JD-Core Version:    0.6.2
 */