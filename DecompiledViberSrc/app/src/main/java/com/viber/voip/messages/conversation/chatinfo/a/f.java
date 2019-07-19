package com.viber.voip.messages.conversation.chatinfo.a;

import android.content.res.Resources;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.messages.controller.manager.an;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.chatinfo.presentation.n;
import com.viber.voip.messages.conversation.chatinfo.presentation.n.b;
import com.viber.voip.messages.m;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.settings.d.as;

class f extends a
{
  f(Resources paramResources, com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb, ac paramac, ConferenceCallsRepository paramConferenceCallsRepository)
  {
    super(paramResources, paramb, paramac, paramConferenceCallsRepository);
  }

  private void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    int i = 1;
    n.b localb = paramn.g();
    PeerTrustState.PeerTrustEnum localPeerTrustEnum1 = PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED;
    c.a locala1 = c.a.a;
    PeerTrustState.PeerTrustEnum localPeerTrustEnum3;
    int j;
    label91: c.a locala2;
    label105: PeerTrustState.PeerTrustEnum localPeerTrustEnum2;
    if ((localb != null) && (paramConversationItemLoaderEntity.getParticipantMemberId().equals(localb.a())))
    {
      localPeerTrustEnum3 = localb.b();
      if ((!paramConversationItemLoaderEntity.isSecure()) && (PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED != localPeerTrustEnum3))
      {
        j = i;
        if ((!d.as.a.d()) || ((!paramConversationItemLoaderEntity.isSecure()) && (j == 0)) || (paramConversationItemLoaderEntity.isAnonymous()))
          break label140;
        if (i == 0)
          break label155;
        if (j == 0)
          break label145;
        locala2 = c.a.d;
        localPeerTrustEnum2 = localPeerTrustEnum3;
      }
    }
    while (true)
    {
      a(c.a(this.a, paramConversationItemLoaderEntity, locala2, localPeerTrustEnum2, paramn));
      a(c.a());
      return;
      j = 0;
      break;
      label140: i = 0;
      break label91;
      label145: locala2 = c.a.a(localPeerTrustEnum3);
      break label105;
      label155: locala2 = locala1;
      localPeerTrustEnum2 = localPeerTrustEnum3;
      continue;
      localPeerTrustEnum2 = localPeerTrustEnum1;
      locala2 = locala1;
    }
  }

  private void d(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    a.a locala = a(paramn, true, false, paramn.a(), false, paramConversationItemLoaderEntity.isGroupBehavior());
    b();
    a(c.a(this.a, locala.a()));
    if (as.c(paramConversationItemLoaderEntity))
      a(c.s(this.a));
    if (locala.a() > 0)
      c(locala.b());
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    if ((!paramConversationItemLoaderEntity.isSecret()) && (this.b.getCount() > 0))
    {
      a(c.a(this.b));
      a(c.a());
    }
    c(paramConversationItemLoaderEntity, paramn);
    d(paramConversationItemLoaderEntity, paramn);
    if (paramConversationItemLoaderEntity.isAnonymous())
      a(c.l(this.a, paramConversationItemLoaderEntity));
    a(c.a());
    a(paramConversationItemLoaderEntity);
    a(c.g(this.a, paramConversationItemLoaderEntity));
    a(c.d(this.a, paramConversationItemLoaderEntity));
    if (!paramn.e())
      a(c.h(this.a, paramConversationItemLoaderEntity));
    int i;
    if ((an.a(paramn.d())) && (!paramConversationItemLoaderEntity.isSystemConversation()) && (!paramConversationItemLoaderEntity.isAnonymous()))
    {
      i = 1;
      if (i != 0)
      {
        if (!paramConversationItemLoaderEntity.isSecret())
          break label230;
        a(c.g(this.a));
      }
    }
    while (true)
    {
      if (!paramn.e())
        a(c.i(this.a, paramConversationItemLoaderEntity));
      if ((m.a(paramConversationItemLoaderEntity)) && (paramn.f() > 0L))
        a(c.h(this.a));
      c();
      b(paramConversationItemLoaderEntity);
      return;
      i = 0;
      break;
      label230: a(c.f(this.a));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.a.f
 * JD-Core Version:    0.6.2
 */