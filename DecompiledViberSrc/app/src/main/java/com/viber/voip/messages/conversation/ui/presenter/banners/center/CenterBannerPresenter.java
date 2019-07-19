package com.viber.voip.messages.conversation.ui.presenter.banners.center;

import android.arch.lifecycle.h;
import android.os.Handler;
import com.viber.voip.block.k;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.b.c;
import com.viber.voip.messages.conversation.ui.b.d;
import com.viber.voip.messages.conversation.ui.b.e;
import com.viber.voip.messages.conversation.ui.b.e.a;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.l;
import com.viber.voip.messages.conversation.ui.presenter.banners.BannerPresenter;
import com.viber.voip.messages.conversation.ui.view.a.b.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.State;

public class CenterBannerPresenter extends BannerPresenter<a, State>
  implements c, e.a, com.viber.voip.messages.conversation.ui.b.g, l
{
  private final i c;
  private final com.viber.voip.messages.conversation.ui.b.b d;
  private final e e;

  public CenterBannerPresenter(f paramf, i parami, com.viber.voip.contacts.c.c.a.b paramb, k paramk, Handler paramHandler, com.viber.voip.messages.conversation.ui.b.b paramb1, e parame)
  {
    super(paramf, paramHandler, paramb, paramk);
    this.c = parami;
    this.d = paramb1;
    this.e = parame;
  }

  public void a()
  {
    d.a(this);
  }

  public void a(int paramInt)
  {
    ((a)this.mView).a(paramInt);
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramLong1, paramInt, paramLong2);
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    a locala = (a)this.mView;
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b;
    if (paramq.getCount() == 0);
    for (boolean bool = true; ; bool = false)
    {
      locala.a(localConversationItemLoaderEntity, bool);
      if ((paramBoolean1) && (paramq.t()))
        ((a)this.mView).f();
      return;
    }
  }

  public void a(MessageEntity paramMessageEntity, int paramInt, String paramString)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramMessageEntity, paramInt, paramString);
  }

  public void a(boolean paramBoolean)
  {
    ((a)this.mView).e();
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramBoolean1, paramBoolean2);
  }

  public void b()
  {
    ((a)this.mView).a(this.b, false);
  }

  protected boolean h()
  {
    if (super.h())
    {
      ((a)this.mView).a();
      return true;
    }
    return false;
  }

  public void j()
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this);
  }

  protected void k()
  {
    ((a)this.mView).e();
    com.viber.voip.model.entity.m localm = SpamController.a(this.b.isGroupBehavior(), this.b.getCreatorParticipantInfoId(), this.b.getParticipantMemberId());
    if ((localm != null) && (com.viber.voip.block.g.a(new Member(localm.a()))));
    for (boolean bool = true; ; bool = false)
    {
      ((a)this.mView).b(this.b, bool);
      return;
    }
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.c.b(this);
    this.d.b(this);
    this.e.b(this);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.c.a(this);
    this.d.a(this);
    this.e.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.center.CenterBannerPresenter
 * JD-Core Version:    0.6.2
 */