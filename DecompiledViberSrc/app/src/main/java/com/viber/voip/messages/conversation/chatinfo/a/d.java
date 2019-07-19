package com.viber.voip.messages.conversation.chatinfo.a;

import android.content.res.Resources;
import android.text.TextUtils;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.chatinfo.presentation.n;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.m;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.publicaccount.ui.holders.recentmedia.b;
import com.viber.voip.util.cd;

class d extends a
{
  d(Resources paramResources, b paramb, ac paramac, ConferenceCallsRepository paramConferenceCallsRepository)
  {
    super(paramResources, paramb, paramac, paramConferenceCallsRepository);
  }

  private void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn, int paramInt, boolean paramBoolean)
  {
    a.a locala = a(paramn, false, true, paramn.a(), paramn.b(), paramConversationItemLoaderEntity.isGroupBehavior());
    b();
    a(c.b(this.a, paramConversationItemLoaderEntity, locala.d()));
    if ((locala.f() == 0) && ((cd.a(paramInt)) || ((cd.f(paramInt)) && (locala.c() == 1))))
      a(c.k(this.a, paramConversationItemLoaderEntity));
    if ((!paramBoolean) && (cd.b(paramInt)))
      a(c.n(this.a));
    int i;
    if (locala.d() > 0)
    {
      b(locala.e());
      if (!(paramConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity))
        break label202;
      i = ((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity).getWatchersCount();
      if ((cd.f(paramConversationItemLoaderEntity.getGroupRole())) && (!paramConversationItemLoaderEntity.isDisabledConversation()))
        i--;
    }
    while (true)
    {
      int j;
      if (locala.e() >= locala.d())
      {
        j = 0;
        if (i <= 0);
      }
      else
      {
        j = 1;
      }
      if (j != 0)
        a(c.o(this.a));
      return;
      label202: i = 0;
    }
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    boolean bool1 = true;
    int i = paramConversationItemLoaderEntity.getGroupRole();
    int j = paramConversationItemLoaderEntity.getConversationType();
    boolean bool2 = paramConversationItemLoaderEntity.isCommunityBlocked();
    boolean bool3;
    if ((paramConversationItemLoaderEntity.isAdministratorRole()) && (!bool2))
    {
      bool3 = bool1;
      a(c.a(paramConversationItemLoaderEntity));
      if (cd.b(i, j, bool2))
        a(c.a(this.a));
      a(c.a());
      if ((!bool3) && (TextUtils.isEmpty(paramConversationItemLoaderEntity.getPublicAccountTagsLine())))
        break label484;
      a(c.a(this.a, paramConversationItemLoaderEntity));
    }
    label171: label222: label479: label484: for (boolean bool4 = bool1; ; bool4 = false)
    {
      if (paramConversationItemLoaderEntity.isVerified())
      {
        a(c.a(this.a, bool3));
        bool4 = bool1;
      }
      if (bool3)
      {
        a(c.g(this.a, paramConversationItemLoaderEntity));
        bool4 = bool1;
      }
      if (bool4)
        a(c.a());
      boolean bool5;
      boolean bool6;
      boolean bool7;
      boolean bool8;
      if (this.b.getCount() > 0)
      {
        bool5 = bool1;
        if (bool5)
          a(c.a(this.b));
        if ((bool3) && (bool5))
          a(c.a());
        if ((bool2) || (!cd.e(i, j)))
          break label461;
        bool6 = bool1;
        if (bool6)
          a(c.b(this.a));
        if ((!cd.i(i, j)) || (paramn.h() <= 0))
          break label467;
        bool7 = bool1;
        if (bool7)
          a(c.c(this.a));
        if ((bool6) || (bool7))
          a(c.a());
        a(c.b(this.a, paramConversationItemLoaderEntity));
        a(c.a());
        if (m.d(paramConversationItemLoaderEntity))
        {
          a(c.m(this.a));
          a(c.a());
        }
        a(paramConversationItemLoaderEntity, paramn, i, bool2);
        a(c.f(this.a, paramConversationItemLoaderEntity));
        a(c.a());
        a(paramConversationItemLoaderEntity);
        if (cd.b(paramConversationItemLoaderEntity.getGroupRole()))
          a(c.i(this.a));
        a(c.e(this.a, paramConversationItemLoaderEntity));
        c();
        if (bool2)
          break label473;
        bool8 = bool1;
        if (bool8)
        {
          a(c.a());
          a(c.j(this.a));
        }
        if (bool8)
          break label479;
      }
      while (true)
      {
        a(paramConversationItemLoaderEntity, bool1);
        return;
        bool3 = false;
        break;
        bool5 = false;
        break label171;
        bool6 = false;
        break label222;
        bool7 = false;
        break label258;
        bool8 = false;
        break label414;
        bool1 = false;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.a.d
 * JD-Core Version:    0.6.2
 */