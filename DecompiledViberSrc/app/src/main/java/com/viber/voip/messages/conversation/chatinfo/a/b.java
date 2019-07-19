package com.viber.voip.messages.conversation.chatinfo.a;

import android.content.res.Resources;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.chatinfo.presentation.n;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;

class b extends a
{
  b(Resources paramResources, com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb, ac paramac, ConferenceCallsRepository paramConferenceCallsRepository)
  {
    super(paramResources, paramb, paramac, paramConferenceCallsRepository);
  }

  private void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    a.a locala = a(paramn, true, true, paramn.a(), paramn.b(), paramConversationItemLoaderEntity.isGroupBehavior());
    b();
    a(c.k(this.a));
    if (locala.f() == 0)
      a(c.l(this.a));
    if (locala.d() > 0)
      b(locala.e());
    a(c.b(this.a, locala.a()));
    if (as.c(paramConversationItemLoaderEntity))
      a(c.t(this.a));
    if (locala.a() > 0)
    {
      c(locala.b());
      if (locala.b() < locala.a())
        a(c.r(this.a));
    }
    a(c.a());
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    a(c.a(paramConversationItemLoaderEntity));
    a(c.a());
    if (this.b.getCount() > 0)
    {
      a(c.a(this.b));
      a(c.a());
    }
    c(paramConversationItemLoaderEntity, paramn);
    a(c.g(this.a, paramConversationItemLoaderEntity));
    a(c.d(this.a, paramConversationItemLoaderEntity));
    c();
    b(paramConversationItemLoaderEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.a.b
 * JD-Core Version:    0.6.2
 */