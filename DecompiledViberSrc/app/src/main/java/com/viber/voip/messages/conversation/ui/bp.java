package com.viber.voip.messages.conversation.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.market.MarketPublicGroupInfo;
import com.viber.voip.market.b.a;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.t;
import com.viber.voip.messages.conversation.ui.banner.t.a;
import com.viber.voip.messages.conversation.ui.banner.y;
import com.viber.voip.messages.conversation.ui.banner.y.a;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.publicaccount.entity.PublicAccount;

public class bp
  implements t.a, y.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.messages.k b = ViberApplication.getInstance().getMessagesManager();
  private final ai c = this.b.c();
  private final View d;
  private final ConversationAlertView e;
  private final LayoutInflater f;
  private ConversationItemLoaderEntity g;
  private y h;
  private bq i;
  private t j;
  private PublicAccount k;
  private bv.t l = new bv.t()
  {
    public void onJoinToPublicGroup(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if ((5 == paramAnonymousInt3) && (paramAnonymousInt2 != 5))
        ViberApplication.getInstance().showToast(ViberApplication.getLocalizedResources().getString(R.string.pg_follow_error));
    }
  };

  public bp(View paramView, ConversationAlertView paramConversationAlertView, LayoutInflater paramLayoutInflater)
  {
    this.d = paramView;
    this.e = paramConversationAlertView;
    this.f = paramLayoutInflater;
  }

  private void a(com.viber.voip.messages.conversation.adapter.k paramk)
  {
    boolean bool1 = this.g instanceof PublicGroupConversationItemLoaderEntity;
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.g.isPublicGroupType();
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = e.c();
        bool2 = false;
        if (bool4)
          bool2 = ((PublicGroupConversationItemLoaderEntity)this.g).shouldShowNotPublishedPublicAccountBanner();
      }
    }
    if (bool2)
    {
      b(paramk);
      return;
    }
    g();
  }

  private void a(com.viber.voip.messages.conversation.adapter.k paramk, boolean paramBoolean)
  {
    if (this.h == null)
      this.h = new y(this.e, paramBoolean, this, f());
    this.h.a(this.g);
    this.e.a(this.h, false);
  }

  private void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.messages.conversation.adapter.k paramk)
  {
    if (!paramConversationItemLoaderEntity.showPublicAccountBanner())
    {
      e();
      return;
    }
    if (((paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isPublicAccountGroupExists())) || ((paramConversationItemLoaderEntity.isPublicGroupType()) && (!e.b(paramConversationItemLoaderEntity))));
    for (int m = 1; m != 0; m = 0)
    {
      a(paramk, this.k.hasPublicChat());
      return;
    }
    e();
  }

  private void b(com.viber.voip.messages.conversation.adapter.k paramk)
  {
    if (this.h == null)
      this.j = new t(this.e, this, f());
    if (this.i == null)
      this.i = new bq(o.a(), this.b.d(), ViberApplication.getInstance().getEngine(true).getPhoneController(), this.d);
    this.e.a(this.j, false);
  }

  private void e()
  {
    if (this.h != null)
      this.e.a(this.h.a(), false);
  }

  private LayoutInflater f()
  {
    return this.f;
  }

  private void g()
  {
    if (this.j != null)
      this.e.a(this.j.a(), false);
  }

  public void a()
  {
    if (this.g != null)
      this.i.a(new PublicAccount((PublicGroupConversationItemLoaderEntity)this.g));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, com.viber.voip.messages.conversation.adapter.k paramk)
  {
    this.g = paramConversationItemLoaderEntity;
    this.k = new PublicAccount(this.g);
    b(paramConversationItemLoaderEntity, paramk);
    a(paramk);
  }

  public void b()
  {
    o.a().b(this.l);
  }

  public void c()
  {
    this.c.c(this.g.getId(), false, null);
  }

  public void d()
  {
    o.a().a(this.l);
    PublicGroupConversationData localPublicGroupConversationData = new PublicGroupConversationData(this.g.getPublicAccountGroupId(), this.g.getPublicAccountGroupUri());
    if (this.g.isOneToOneWithPublicAccount());
    for (ae localae = ae.c; ; localae = ae.a)
    {
      new a().a(new MarketPublicGroupInfo(localPublicGroupConversationData), true, true, localae);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bp
 * JD-Core Version:    0.6.2
 */