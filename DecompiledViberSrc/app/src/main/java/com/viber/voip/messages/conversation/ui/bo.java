package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.view.LayoutInflater;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.banner.x;
import com.viber.voip.messages.conversation.ui.banner.x.a;

public class bo
  implements x.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final ConversationAlertView c;
  private final a d;
  private x e;
  private long f = -1L;
  private LayoutInflater g;

  public bo(Context paramContext, ConversationAlertView paramConversationAlertView, a parama, LayoutInflater paramLayoutInflater)
  {
    this.b = paramContext;
    this.c = paramConversationAlertView;
    this.d = parama;
    this.g = paramLayoutInflater;
  }

  public void a()
  {
    this.c.a(ConversationAlertView.a.m, false);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((paramConversationItemLoaderEntity != null) && ((paramConversationItemLoaderEntity.showAdminPromotedBanner()) || (paramConversationItemLoaderEntity.showSuperadminPromotedBanner())))
    {
      this.f = paramConversationItemLoaderEntity.getId();
      if (this.e == null)
        this.e = new x(this.c, this, this.g);
      this.c.a(this.e, false);
      this.e.a(paramConversationItemLoaderEntity.showSuperadminPromotedBanner());
      return;
    }
    this.f = -1L;
    a();
  }

  public void b()
  {
    this.d.a(this.f);
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bo
 * JD-Core Version:    0.6.2
 */