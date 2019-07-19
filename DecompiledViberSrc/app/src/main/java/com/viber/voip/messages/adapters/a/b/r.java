package com.viber.voip.messages.adapters.a.b;

import android.view.View;
import com.viber.voip.messages.adapters.a.c.a.a;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class r extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private final View a;

  public r(View paramView)
  {
    this.a = paramView;
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    if ((parama.a().isFavouriteConversation()) && (parama1.c() == a.a.a) && (!parama1.x()));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(this.a, bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.r
 * JD-Core Version:    0.6.2
 */