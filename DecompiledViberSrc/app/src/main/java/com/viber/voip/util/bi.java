package com.viber.voip.util;

import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.m;

public class bi
{
  public static boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (m.b(paramConversationItemLoaderEntity.getConversationType()))
      return m.d(paramConversationItemLoaderEntity);
    return (cd.c(paramConversationItemLoaderEntity.getGroupRole(), paramConversationItemLoaderEntity.getConversationType())) && (!paramConversationItemLoaderEntity.isSecret());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bi
 * JD-Core Version:    0.6.2
 */