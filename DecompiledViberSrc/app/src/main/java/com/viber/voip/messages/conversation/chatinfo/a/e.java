package com.viber.voip.messages.conversation.chatinfo.a;

import android.content.res.Resources;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.chatinfo.presentation.n;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.settings.d.as;
import com.viber.voip.util.bi;

class e extends a
{
  e(Resources paramResources, com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb, ac paramac, ConferenceCallsRepository paramConferenceCallsRepository)
  {
    super(paramResources, paramb, paramac, paramConferenceCallsRepository);
  }

  private void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    a.a locala = a(paramn, true, true, paramn.a(), paramn.b(), paramConversationItemLoaderEntity.isGroupBehavior());
    b();
    a(c.a(this.a, paramConversationItemLoaderEntity, locala.d()));
    if (locala.f() == 0)
      a(c.l(this.a));
    if (locala.d() > 0)
    {
      b(locala.e());
      if (locala.e() < locala.d())
        a(c.p(this.a));
    }
    a(c.a(this.a, locala.a()));
    if (as.c(paramConversationItemLoaderEntity))
      a(c.s(this.a));
    if (locala.a() > 0)
    {
      c(locala.b());
      if (locala.b() < locala.a())
        a(c.q(this.a));
    }
    a(c.a());
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    a(c.a(paramConversationItemLoaderEntity));
    a(c.a());
    if ((!paramConversationItemLoaderEntity.isSecret()) && (this.b.getCount() > 0))
    {
      a(c.a(this.b));
      a(c.a());
    }
    a(c.b(this.a, paramConversationItemLoaderEntity));
    if ((d.as.a.d()) && (paramConversationItemLoaderEntity.isSecure()))
      a(c.d(this.a));
    a(c.a());
    if (bi.a(paramConversationItemLoaderEntity))
    {
      a(c.e(this.a));
      a(c.a());
    }
    c(paramConversationItemLoaderEntity, paramn);
    a(paramConversationItemLoaderEntity);
    a(c.g(this.a, paramConversationItemLoaderEntity));
    a(c.d(this.a, paramConversationItemLoaderEntity));
    if (!paramn.e())
      a(c.i(this.a, paramConversationItemLoaderEntity));
    a(c.e(this.a, paramConversationItemLoaderEntity));
    c();
    b(paramConversationItemLoaderEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.a.e
 * JD-Core Version:    0.6.2
 */