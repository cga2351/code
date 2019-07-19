package com.viber.voip.messages.conversation.chatinfo.a;

import android.content.res.Resources;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.chatinfo.d.d;
import com.viber.voip.messages.conversation.chatinfo.presentation.n;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.publicaccount.ui.holders.recentmedia.b;

public class g extends a
{
  g(Resources paramResources, b paramb, ac paramac, ConferenceCallsRepository paramConferenceCallsRepository)
  {
    super(paramResources, paramb, paramac, paramConferenceCallsRepository);
  }

  private d c(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity.hasPublicAccountSubscription())
      return c.v(this.a);
    return c.u(this.a);
  }

  private void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    a.a locala = a(paramn, true, false, paramn.a(), false, paramConversationItemLoaderEntity.isGroupBehavior());
    b();
    a(c.a(this.a, locala.a()));
    if (as.c(paramConversationItemLoaderEntity))
      a(c.s(this.a));
    if (locala.a() > 0)
      c(locala.b());
  }

  void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    a(c.b(this.a, paramConversationItemLoaderEntity));
    a(c.a());
    c(paramConversationItemLoaderEntity, paramn);
    a(c.a());
    a(c(paramConversationItemLoaderEntity));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.a.g
 * JD-Core Version:    0.6.2
 */