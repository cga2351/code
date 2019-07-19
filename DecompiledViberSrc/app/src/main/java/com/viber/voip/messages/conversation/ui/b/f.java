package com.viber.voip.messages.conversation.ui.b;

import android.os.Bundle;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.k;
import com.viber.voip.messages.conversation.publicaccount.a.a;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.MessageEntity;
import java.util.ArrayList;
import java.util.List;

public class f
  implements g
{
  private final g a;
  private s b;
  private ConversationData c;
  private b d;
  private final List<g> e = new ArrayList();

  public f(g paramg, b paramb)
  {
    this.a = paramg;
    this.d = paramb;
  }

  private k o()
  {
    if (this.b == null);
    ConversationItemLoaderEntity localConversationItemLoaderEntity;
    do
    {
      return null;
      localConversationItemLoaderEntity = this.b.j();
    }
    while ((localConversationItemLoaderEntity == null) || (!localConversationItemLoaderEntity.isPublicGroupBehavior()));
    return (k)this.b.g();
  }

  public long a(int paramInt)
  {
    if (this.b == null)
      return -1L;
    return this.b.g().d_(paramInt);
  }

  public s a()
  {
    return this.b;
  }

  public void a(long paramLong1, long paramLong2)
  {
    if (this.b == null)
      return;
    this.b.a(paramLong1, paramLong2);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.a.a(paramConversationItemLoaderEntity, paramBoolean);
    if (paramConversationItemLoaderEntity == null)
      return;
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((g)this.e.get(j)).a(paramConversationItemLoaderEntity, paramBoolean);
    this.a.b(paramConversationItemLoaderEntity, paramBoolean);
  }

  public void a(s params)
  {
    this.b = params;
  }

  public void a(ConversationData paramConversationData)
  {
    this.c = paramConversationData;
  }

  public void a(g paramg)
  {
    this.e.add(paramg);
  }

  public void a(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    if (this.b != null)
      this.b.a(paramArrayOfMessageEntity, paramBundle);
  }

  public boolean a(long paramLong, int paramInt1, int paramInt2, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    k localk = o();
    if (localk == null)
      return false;
    return localk.a(paramLong, a.c(paramInt1, Math.max(localk.w(), paramInt2)), paramRunnable1, paramRunnable2);
  }

  public boolean a(long paramLong, int paramInt, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    k localk = o();
    if (localk == null)
      return false;
    return localk.a(paramLong, paramInt, paramRunnable1, paramRunnable2);
  }

  public ConversationItemLoaderEntity b()
  {
    if (this.b != null)
      return this.b.j();
    return null;
  }

  public aa b(int paramInt)
  {
    if (this.b == null)
      return null;
    return this.b.g().f(paramInt);
  }

  public void b(long paramLong)
  {
    this.a.b(paramLong);
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((g)this.e.get(j)).b(paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b(g paramg)
  {
    this.e.remove(paramg);
  }

  public boolean b(long paramLong, int paramInt1, int paramInt2, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    k localk = o();
    if (localk == null)
      return false;
    return localk.a(paramLong, a.b(paramInt1, Math.max(localk.w(), paramInt2)), paramRunnable1, paramRunnable2);
  }

  public boolean b(long paramLong, int paramInt, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    k localk = o();
    if (localk == null);
    int i;
    do
    {
      do
        return false;
      while (localk.E());
      i = localk.w();
    }
    while ((paramInt <= i) || (i <= 0));
    return localk.a(paramLong, a.a(i, paramInt), paramRunnable1, paramRunnable2);
  }

  public void b_(long paramLong)
  {
    this.a.b_(paramLong);
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((g)this.e.get(j)).b_(paramLong);
  }

  public int c()
  {
    if (this.b == null)
      return 0;
    return this.b.g().getCount();
  }

  public int d()
  {
    if ((this.b == null) || (this.b.g().getCount() == 0))
      return 50;
    return this.b.g().getCount();
  }

  public aa e()
  {
    if ((this.b == null) || (c() == 0))
      return null;
    return this.b.g().f(-1 + c());
  }

  public long f()
  {
    if (this.b == null)
      return -1L;
    return this.b.p();
  }

  public long g()
  {
    if (this.b == null)
      return -1L;
    return this.b.q();
  }

  public ConversationData h()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = b();
    if ((localConversationItemLoaderEntity != null) && (this.c != null))
    {
      this.c.conversationId = localConversationItemLoaderEntity.getId();
      this.c.groupName = localConversationItemLoaderEntity.getGroupName();
      this.c.contactName = localConversationItemLoaderEntity.getContactName();
      this.c.viberName = localConversationItemLoaderEntity.getViberName();
      this.c.canSendTimeBomb = localConversationItemLoaderEntity.canSendTimeBomb();
    }
    return this.c;
  }

  public void i()
  {
    this.a.i();
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((g)this.e.get(j)).i();
  }

  public boolean j()
  {
    return (b() != null) && (b().isSecret());
  }

  public int k()
  {
    k localk = o();
    if (localk == null)
      return -1;
    return localk.y();
  }

  public boolean l()
  {
    k localk = o();
    if (localk == null)
      return false;
    return localk.s();
  }

  public boolean m()
  {
    return (this.b != null) && (this.b.o());
  }

  public void n()
  {
    if (this.b == null)
      return;
    this.b.n();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.f
 * JD-Core Version:    0.6.2
 */