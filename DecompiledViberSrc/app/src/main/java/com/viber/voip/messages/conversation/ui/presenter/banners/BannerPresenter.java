package com.viber.voip.messages.conversation.ui.presenter.banners;

import android.os.Handler;
import com.viber.voip.block.k;
import com.viber.voip.block.k.a;
import com.viber.voip.contacts.c.c.c.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.mvp.core.j;
import java.util.Set;

public abstract class BannerPresenter<VIEW extends j, STATE extends State> extends BaseMvpPresenter<VIEW, STATE>
  implements k.a, c.a, g
{
  protected final Handler a;
  protected ConversationItemLoaderEntity b;
  private final f c;
  private final com.viber.voip.contacts.c.c.a.b d;
  private final k e;

  public BannerPresenter(f paramf, Handler paramHandler, com.viber.voip.contacts.c.c.a.b paramb, k paramk)
  {
    this.c = paramf;
    this.a = paramHandler;
    this.d = paramb;
    this.e = paramk;
  }

  public void a(int paramInt, String paramString)
  {
    this.a.post(new a(this));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.b = paramConversationItemLoaderEntity;
    if (paramBoolean)
    {
      this.d.a(this);
      this.e.a(this);
    }
    k();
  }

  public void a(Set<Member> paramSet, boolean paramBoolean)
  {
    this.a.post(new c(this));
  }

  public void b(int paramInt, String paramString)
  {
    this.a.post(new b(this));
  }

  public void b(long paramLong)
  {
    this.d.b(this);
    this.e.b(this);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b(Set<Member> paramSet, boolean paramBoolean)
  {
    this.a.post(new d(this));
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  protected boolean h()
  {
    if (this.b == null)
      return false;
    k();
    return true;
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  protected abstract void k();

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.c.b(this);
    this.d.b(this);
    this.e.b(this);
  }

  protected void onViewAttached(STATE paramSTATE)
  {
    super.onViewAttached(paramSTATE);
    this.c.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.banners.BannerPresenter
 * JD-Core Version:    0.6.2
 */