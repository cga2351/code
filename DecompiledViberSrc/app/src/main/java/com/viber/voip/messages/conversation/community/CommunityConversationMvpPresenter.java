package com.viber.voip.messages.conversation.community;

import android.view.Menu;
import android.view.MenuInflater;
import com.viber.voip.ViberApplication;
import com.viber.voip.invitelinks.f.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.l;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import java.util.Collections;

public class CommunityConversationMvpPresenter extends BaseMvpPresenter<c, State>
  implements f.a, com.viber.voip.messages.conversation.ui.b.g, l
{
  private com.viber.voip.invitelinks.f a;
  private com.viber.voip.invitelinks.linkscreen.f b;
  private final com.viber.voip.messages.conversation.community.b.a c;
  private final com.viber.voip.messages.conversation.ui.b.f d;
  private final i e;
  private final com.viber.voip.report.community.a f;
  private PublicGroupConversationItemLoaderEntity g;

  public CommunityConversationMvpPresenter(com.viber.voip.invitelinks.f paramf, com.viber.voip.invitelinks.linkscreen.f paramf1, com.viber.voip.messages.conversation.community.b.a parama, com.viber.voip.messages.conversation.ui.b.f paramf2, i parami, com.viber.voip.report.community.a parama1)
  {
    this.a = paramf;
    this.b = paramf1;
    this.c = parama;
    this.d = paramf2;
    this.e = parami;
    this.f = parama1;
  }

  public void a()
  {
    ((c)this.mView).a(false);
    ((c)this.mView).a();
  }

  public void a(int paramInt)
  {
    aa localaa = this.d.b(paramInt);
    if (localaa != null)
    {
      ab.b().I(localaa.a());
      o.a().a(Collections.singleton(Long.valueOf(localaa.b())), localaa.A(), false, false);
      o.a().a(Collections.singleton(Long.valueOf(localaa.b())), false);
      return;
    }
    ViberApplication.getInstance().showToast("No suitable message");
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramLong1, paramInt, paramLong2);
  }

  public void a(long paramLong, String paramString)
  {
    com.viber.voip.invitelinks.g.a(this, paramLong, paramString);
  }

  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    ((c)this.mView).a(paramMenu, paramMenuInflater);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.g = ((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity);
    f();
  }

  public void a(aa paramaa)
  {
    this.c.a(paramaa);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, String paramString)
  {
    this.b.c(paramPublicGroupConversationItemLoaderEntity.getId(), paramPublicGroupConversationItemLoaderEntity.getGroupName(), paramPublicGroupConversationItemLoaderEntity.getIconUri(), paramString);
    ((c)this.mView).a(false);
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramq, paramBoolean1, paramInt, paramBoolean2);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt, String paramString)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramMessageEntity, paramInt, paramString);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ((c)this.mView).a(new d(false, false, false, false));
      return;
    }
    f();
  }

  public void b()
  {
    ((c)this.mView).a(false);
    ((c)this.mView).b();
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.b(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void c()
  {
    ((c)this.mView).a(false);
    ((c)this.mView).c();
  }

  public void d()
  {
    ((c)this.mView).a(false);
    ((c)this.mView).d();
  }

  public void e()
  {
    ((c)this.mView).a(this.d.b());
  }

  public void f()
  {
    int i = 1;
    if (this.e.a())
      return;
    int j = com.viber.voip.messages.m.e(this.g);
    int k;
    int n;
    label54: int i2;
    if (this.g != null)
      if (!this.g.isDisabledConversation())
      {
        k = i;
        if (this.g.isCommunityBlocked())
          break label102;
        n = i;
        if (j != i)
          break label108;
        i2 = i;
        label62: if (j != 2)
          break label114;
      }
    label67: for (d locald = new d(i2, k, i, n); ; locald = new d(false, false, false, false))
    {
      ((c)this.mView).a(locald);
      return;
      int m = 0;
      break;
      label102: int i1 = 0;
      break label54;
      label108: int i3 = 0;
      break label62;
      label114: i = 0;
      break label67;
    }
  }

  public void g()
  {
    if (this.g != null)
    {
      ((c)this.mView).a(true);
      this.a.a(this.g, false, this);
    }
  }

  public void h()
  {
    if (this.g != null)
      this.f.a(this.g.getGroupId());
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void j()
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.d.b(this);
    this.e.b(this);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.d.a(this);
    this.e.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.CommunityConversationMvpPresenter
 * JD-Core Version:    0.6.2
 */