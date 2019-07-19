package com.viber.voip.messages.conversation.chatinfo.a;

import android.content.res.Resources;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.chatinfo.presentation.n;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;

public class i
  implements h<com.viber.voip.messages.conversation.chatinfo.d.d>
{
  private final dagger.a<ConferenceCallsRepository> a;

  public i(dagger.a<ConferenceCallsRepository> parama)
  {
    this.a = parama;
  }

  public com.viber.voip.messages.conversation.chatinfo.c.a<com.viber.voip.messages.conversation.chatinfo.d.d> a(Resources paramResources, com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb, ac paramac, ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    Object localObject;
    if (paramConversationItemLoaderEntity.isBroadcastListType())
      localObject = new b(paramResources, paramb, paramac, (ConferenceCallsRepository)this.a.get());
    while (true)
    {
      ((a)localObject).a(paramConversationItemLoaderEntity, paramn);
      return localObject;
      if (paramConversationItemLoaderEntity.isCommunityType())
        localObject = new d(paramResources, paramb, paramac, (ConferenceCallsRepository)this.a.get());
      else if (paramConversationItemLoaderEntity.isGroupType())
        localObject = new e(paramResources, paramb, paramac, (ConferenceCallsRepository)this.a.get());
      else if (paramConversationItemLoaderEntity.isOneToOneWithPublicAccount())
        localObject = new g(paramResources, paramb, paramac, (ConferenceCallsRepository)this.a.get());
      else
        localObject = new f(paramResources, paramb, paramac, (ConferenceCallsRepository)this.a.get());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.a.i
 * JD-Core Version:    0.6.2
 */