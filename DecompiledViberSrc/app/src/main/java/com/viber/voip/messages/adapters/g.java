package com.viber.voip.messages.adapters;

import com.viber.voip.messages.adapters.a.a;
import com.viber.voip.messages.adapters.a.b;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.m;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;

public class g
  implements a
{
  private final RegularConversationLoaderEntity a;
  private final boolean b;
  private final boolean c;
  private final int d;
  private OngoingConferenceCallModel e;

  public g(RegularConversationLoaderEntity paramRegularConversationLoaderEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramRegularConversationLoaderEntity, paramBoolean1, paramBoolean2, null);
  }

  public g(RegularConversationLoaderEntity paramRegularConversationLoaderEntity, boolean paramBoolean1, boolean paramBoolean2, OngoingConferenceCallModel paramOngoingConferenceCallModel)
  {
    this.a = paramRegularConversationLoaderEntity;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    if (paramRegularConversationLoaderEntity.isRakutenSystemConversation())
      this.d = 2;
    while (true)
    {
      this.e = paramOngoingConferenceCallModel;
      return;
      if (paramRegularConversationLoaderEntity.isNonreplyableConversation())
        this.d = 3;
      else if (paramRegularConversationLoaderEntity.isSystemConversation())
        this.d = 1;
      else
        this.d = 4;
    }
  }

  public ConversationLoaderEntity a()
  {
    return this.a;
  }

  public String a(int paramInt)
  {
    return m.h(paramInt);
  }

  public int b()
  {
    return this.a.getUnreadCallsCount();
  }

  public int c()
  {
    return this.a.getUnreadMessagesCount();
  }

  public int d()
  {
    return this.a.getMessageCount();
  }

  public int e()
  {
    return this.d;
  }

  public boolean f()
  {
    return this.b;
  }

  public boolean g()
  {
    return !this.a.isGroupBehavior();
  }

  public OngoingConferenceCallModel h()
  {
    return this.e;
  }

  public long i()
  {
    return this.a.getId();
  }

  public boolean k()
  {
    return b.a(this);
  }

  public int l()
  {
    return b.b(this);
  }

  public String toString()
  {
    return "ConversationsAdapterItem{conversation=" + this.a + ", isSelectedConversation=" + this.b + ", isChosenConversation=" + this.c + ", hasNewEvents=" + k() + ", mConvType=" + this.d + ", mConference=" + this.e + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.g
 * JD-Core Version:    0.6.2
 */