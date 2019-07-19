package com.viber.voip.invitelinks.linkscreen;

import com.viber.dexshared.Logger;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.l;
import com.viber.voip.messages.conversation.l.a;
import com.viber.voip.messages.conversation.m;
import com.viber.voip.util.cl;

public class g
  implements d.a, l.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final l b;
  private a c = (a)cl.b(a.class);

  public g(long paramLong, m paramm)
  {
    this.b = paramm.a(this, this);
    this.b.a(paramLong);
    this.b.p();
    this.b.i();
  }

  public void a()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.e(0);
    if (localConversationItemLoaderEntity != null)
      this.c.onConversationReceived(localConversationItemLoaderEntity);
    while (!this.b.b())
      return;
    this.b.c();
  }

  public void a(a parama)
  {
    this.c = parama;
    if (this.b.b())
      this.b.c();
  }

  public ConversationItemLoaderEntity b()
  {
    return this.b.e(0);
  }

  public void c()
  {
    this.c = ((a)cl.b(a.class));
    this.b.y_();
  }

  public void c_(long paramLong)
  {
    this.c.onConversationDeleted();
  }

  public void d()
  {
    c();
    this.b.q();
    this.b.j();
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.e(0);
    if (localConversationItemLoaderEntity != null)
    {
      this.c.onConversationReceived(localConversationItemLoaderEntity);
      return;
    }
    this.c.onConversationDeleted();
  }

  public void onLoaderReset(d paramd)
  {
  }

  public static abstract interface a
  {
    public abstract void onConversationDeleted();

    public abstract void onConversationReceived(ConversationItemLoaderEntity paramConversationItemLoaderEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.g
 * JD-Core Version:    0.6.2
 */