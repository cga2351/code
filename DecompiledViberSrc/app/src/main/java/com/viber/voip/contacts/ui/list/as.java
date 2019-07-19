package com.viber.voip.contacts.ui.list;

import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.util.cd;

public class as
{
  public static boolean a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity != null) && (cd.c(paramConversationItemLoaderEntity.getGroupRole())) && ((!paramConversationItemLoaderEntity.isPublicGroupType()) || (!((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity).isPendingRole()));
  }

  public static boolean b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity != null) && ((!paramConversationItemLoaderEntity.isPublicGroupType()) || (((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity).hasPublicChat()));
  }

  public static boolean c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((paramConversationItemLoaderEntity == null) || (paramConversationItemLoaderEntity.isAnonymous()));
    do
    {
      return false;
      if (paramConversationItemLoaderEntity.isPublicGroupType())
        break;
    }
    while ((paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) || ((paramConversationItemLoaderEntity.isCommunityType()) && (!paramConversationItemLoaderEntity.isAdministratorRole())));
    return true;
    return a(paramConversationItemLoaderEntity);
  }

  public static boolean d(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity != null) && (paramConversationItemLoaderEntity.isCommunityType()) && (!paramConversationItemLoaderEntity.isDisabledConversation());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.as
 * JD-Core Version:    0.6.2
 */