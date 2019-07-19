package com.viber.voip.messages.adapters;

import android.net.Uri;
import com.viber.voip.messages.adapters.a.b;
import com.viber.voip.messages.adapters.a.c;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ConversationWithPublicAccountLoaderEntity;
import com.viber.voip.messages.m;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;

public class h
  implements c
{
  private final ConversationWithPublicAccountLoaderEntity a;
  private final boolean b;
  private final boolean c;

  public h(ConversationWithPublicAccountLoaderEntity paramConversationWithPublicAccountLoaderEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramConversationWithPublicAccountLoaderEntity;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
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
    return 0;
  }

  public int c()
  {
    return this.a.getUnreadMessagesCount();
  }

  public int d()
  {
    return 0;
  }

  public int e()
  {
    return 0;
  }

  public boolean f()
  {
    return this.b;
  }

  public boolean g()
  {
    return (3 == this.a.getGroupRole()) || (av.c(this.a.getFlags(), 6));
  }

  public OngoingConferenceCallModel h()
  {
    return null;
  }

  public long i()
  {
    return this.a.getId();
  }

  public boolean j()
  {
    boolean bool1 = cd.g(this.a.getGroupRole());
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = av.c(this.a.getExtraFlags(), 0);
      bool2 = false;
      if (!bool3)
        bool2 = true;
    }
    return bool2;
  }

  public boolean k()
  {
    return b.a(this);
  }

  public int l()
  {
    return b.b(this);
  }

  public boolean m()
  {
    return this.a.hasPublicChat();
  }

  public int n()
  {
    return this.a.getWatchersCount();
  }

  public Uri o()
  {
    return this.a.getIconUri();
  }

  public long p()
  {
    return this.a.getGroupId();
  }

  public String q()
  {
    return this.a.getGroupUri();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.h
 * JD-Core Version:    0.6.2
 */