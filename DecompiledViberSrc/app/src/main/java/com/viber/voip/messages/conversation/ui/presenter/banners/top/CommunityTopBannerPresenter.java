package com.viber.voip.messages.conversation.ui.presenter.banners.top;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.s;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.af;
import com.viber.voip.messages.conversation.ui.b.aj;
import com.viber.voip.messages.conversation.ui.b.e;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.bo.a;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.notif.g;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import java.util.Collections;

public class CommunityTopBannerPresenter extends PublicGroupBehaviorTopBannerPresenter<com.viber.voip.messages.conversation.ui.view.a.c.a>
  implements bo.a
{
  private final ai f;
  private final dagger.a<com.viber.voip.messages.controller.a> g;
  private final z h;
  private final UserManager i;

  public CommunityTopBannerPresenter(f paramf, n paramn, i parami, u paramu, af paramaf, s params, j paramj, o paramo, Handler paramHandler, cj paramcj, Engine paramEngine, com.viber.voip.contacts.c.c.a.b paramb, com.viber.voip.block.b paramb1, ai paramai, aj paramaj, SpamController paramSpamController, com.viber.voip.analytics.story.d.c paramc, com.viber.voip.analytics.story.b.c paramc1, dagger.a<ConferenceCallsRepository> parama, CallHandler paramCallHandler, e parame, dagger.a<g> parama1, dagger.a<com.viber.voip.messages.controller.a> parama2, z paramz, UserManager paramUserManager, bv parambv)
  {
    super(paramf, paramn, parami, paramu, paramaf, params, paramj, paramo, paramHandler, paramcj, paramEngine, paramb, paramb1, paramc, paramc1, paramaj, paramSpamController, parama, paramCallHandler, parame, paramai, parama1, parambv);
    this.f = paramai;
    this.g = parama2;
    this.h = paramz;
    this.i = paramUserManager;
  }

  public void a(long paramLong)
  {
    this.f.a(paramLong, 5, new a(this));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ((com.viber.voip.messages.controller.a)this.g.get()).b(paramConversationItemLoaderEntity.getId());
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    if ((paramBoolean) && (paramConversationItemLoaderEntity.getId() != this.d))
      ((com.viber.voip.messages.conversation.ui.view.a.c.a)this.mView).a();
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    if (!cj.a(true));
    while (paramPublicGroupConversationItemLoaderEntity == null)
      return;
    if (!da.a(this.i.getUserData().getViberName()))
    {
      ((com.viber.voip.messages.controller.a)this.g.get()).a(paramPublicGroupConversationItemLoaderEntity.getExtraInfo(), paramPublicGroupConversationItemLoaderEntity.getGroupId());
      return;
    }
    this.h.b();
  }

  public void c(long paramLong)
  {
    this.f.a(Collections.singleton(Long.valueOf(paramLong)), 5);
  }

  protected void k()
  {
    super.k();
    ((com.viber.voip.messages.conversation.ui.view.a.c.a)this.mView).b(this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.top.CommunityTopBannerPresenter
 * JD-Core Version:    0.6.2
 */