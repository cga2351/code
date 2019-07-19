package com.viber.voip.messages.conversation.chatinfo.b;

import android.content.res.Resources;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.chatinfo.a.h;
import com.viber.voip.messages.conversation.chatinfo.d.d;
import com.viber.voip.messages.conversation.chatinfo.presentation.n;
import com.viber.voip.util.cl;

public class b
  implements a
{
  private volatile a.a a = (a.a)cl.b(a.a.class);
  private final h<d> b;

  public b(h<d> paramh)
  {
    this.b = paramh;
  }

  public void a()
  {
    this.a = ((a.a)cl.b(a.a.class));
  }

  public void a(Resources paramResources, com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb, ac paramac, ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    com.viber.voip.messages.conversation.chatinfo.c.a locala = this.b.a(paramResources, paramb, paramac, paramConversationItemLoaderEntity, paramn);
    this.a.a(locala);
  }

  public void a(a.a parama)
  {
    this.a = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.b.b
 * JD-Core Version:    0.6.2
 */