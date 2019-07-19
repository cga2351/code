package com.viber.voip.storage.repository;

import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import java.util.Set;

class d extends j
  implements bv.e
{
  d(com.viber.provider.d<?> paramd)
  {
    super(paramd);
  }

  public void onChange(Set<Long> paramSet, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(paramSet))
      this.b.l();
  }

  public void onConversationClosed(boolean paramBoolean, long paramLong)
  {
  }

  public void onDelete(Set<Long> paramSet, int paramInt, boolean paramBoolean)
  {
    if (a(paramSet))
      this.b.l();
  }

  public void onOpen1to1(Set<Long> paramSet, boolean paramBoolean)
  {
  }

  public void onOpenConversation(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
  }

  public void onOpenPublicGroup(long paramLong, Set<Long> paramSet)
  {
  }

  public void onRead(Set<Long> paramSet, int paramInt, boolean paramBoolean)
  {
  }

  public void onReadOutgoing(long paramLong, int paramInt, boolean paramBoolean)
  {
  }

  public void onWatchersCountChange(long paramLong, int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.d
 * JD-Core Version:    0.6.2
 */