package com.viber.voip.messages.conversation.ui.presenter;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.b;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.b.af;
import com.viber.voip.messages.conversation.ui.b.f;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.t;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.x;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.bt.a;
import com.viber.voip.mvp.core.State;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.cj;
import com.viber.voip.util.cq;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import org.greenrobot.eventbus.EventBus;

public class GeneralPublicGroupConversationPresenter extends GeneralConversationPresenter<com.viber.voip.messages.conversation.ui.view.h>
  implements bt.a
{
  private static final Logger f = ViberEnv.getLogger();
  private final GroupController g;
  private final o h;
  private final Handler i;
  private final com.viber.voip.messages.conversation.ui.view.m j;
  private PublicGroupConversationItemLoaderEntity k;
  private ac l;
  private boolean m;
  private String n;
  private int o;
  private int p;
  private long q;
  private com.viber.common.d.i r;
  private long s;
  private boolean t;
  private boolean u;
  private long v;
  private dagger.a<com.viber.voip.messages.controller.a> w;
  private final Runnable x = new d(this);
  private bv.t y = new bv.t()
  {
    public void onJoinToPublicGroup(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if ((paramAnonymousInt3 == 5) && (!com.viber.voip.messages.m.b(paramAnonymousInt2)))
        ((com.viber.voip.messages.conversation.ui.view.h)GeneralPublicGroupConversationPresenter.a(GeneralPublicGroupConversationPresenter.this)).f();
      do
      {
        return;
        if ((paramAnonymousInt3 == 7) && (com.viber.voip.messages.m.b(paramAnonymousInt2)))
        {
          ((com.viber.voip.messages.conversation.ui.view.h)GeneralPublicGroupConversationPresenter.b(GeneralPublicGroupConversationPresenter.this)).i();
          return;
        }
      }
      while ((paramAnonymousInt3 != 8) || (!com.viber.voip.messages.m.b(paramAnonymousInt2)));
      ((com.viber.voip.messages.conversation.ui.view.h)GeneralPublicGroupConversationPresenter.c(GeneralPublicGroupConversationPresenter.this)).j();
    }

    public void onPublicGroupSyncFinished(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
    {
      if (GeneralPublicGroupConversationPresenter.d(GeneralPublicGroupConversationPresenter.this) != paramAnonymousLong)
        return;
      if (paramAnonymousInt2 == 0)
      {
        GeneralPublicGroupConversationPresenter.a(GeneralPublicGroupConversationPresenter.this, true);
        GeneralPublicGroupConversationPresenter.this.a.n();
        return;
      }
      if ((GeneralPublicGroupConversationPresenter.g(GeneralPublicGroupConversationPresenter.this) != null) && (GeneralPublicGroupConversationPresenter.h(GeneralPublicGroupConversationPresenter.this)) && (!GeneralPublicGroupConversationPresenter.i(GeneralPublicGroupConversationPresenter.this).c(GeneralPublicGroupConversationPresenter.d(GeneralPublicGroupConversationPresenter.this), GeneralPublicGroupConversationPresenter.g(GeneralPublicGroupConversationPresenter.this).getLastLocalMsgId())))
        GeneralPublicGroupConversationPresenter.b(GeneralPublicGroupConversationPresenter.this, false);
      GeneralPublicGroupConversationPresenter.a(GeneralPublicGroupConversationPresenter.this, false);
      GeneralPublicGroupConversationPresenter.this.b.a(false);
      ((com.viber.voip.messages.conversation.ui.view.h)GeneralPublicGroupConversationPresenter.j(GeneralPublicGroupConversationPresenter.this)).g();
    }

    public void onPublicGroupSyncQueued(int paramAnonymousInt, long paramAnonymousLong)
    {
      if (GeneralPublicGroupConversationPresenter.d(GeneralPublicGroupConversationPresenter.this) == paramAnonymousLong)
        ((com.viber.voip.messages.conversation.ui.view.h)GeneralPublicGroupConversationPresenter.f(GeneralPublicGroupConversationPresenter.this)).g();
    }

    public void onPublicGroupSyncStarted(int paramAnonymousInt, long paramAnonymousLong)
    {
      if (GeneralPublicGroupConversationPresenter.d(GeneralPublicGroupConversationPresenter.this) == paramAnonymousLong)
      {
        GeneralPublicGroupConversationPresenter.a(GeneralPublicGroupConversationPresenter.this, true);
        ((com.viber.voip.messages.conversation.ui.view.h)GeneralPublicGroupConversationPresenter.e(GeneralPublicGroupConversationPresenter.this)).g();
      }
    }
  };

  public GeneralPublicGroupConversationPresenter(com.viber.voip.messages.conversation.ui.b.a parama, f paramf, u paramu, t paramt, com.viber.voip.messages.conversation.ui.b.i parami, cj paramcj, com.viber.voip.storage.c paramc, af paramaf, n paramn, GroupController paramGroupController, o paramo, com.viber.voip.messages.conversation.ui.view.m paramm, boolean paramBoolean, EventBus paramEventBus, x paramx, z paramz, ai paramai, b paramb, Handler paramHandler1, Handler paramHandler2, cq paramcq, com.viber.voip.analytics.story.e.c paramc1, com.viber.voip.messages.controller.publicaccount.d paramd, dagger.a<com.viber.voip.messages.controller.a> parama1)
  {
    super(parama, paramf, paramu, paramt, parami, paramcj, paramc, paramaf, paramn, paramBoolean, paramEventBus, paramx, paramz, paramai, paramb, paramHandler1, paramHandler2, paramcq, paramc1, paramd);
    this.g = paramGroupController;
    this.h = paramo;
    this.i = paramHandler2;
    this.j = paramm;
    this.w = parama1;
  }

  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == paramInt3);
    aa localaa2;
    do
    {
      return paramInt2;
      if (paramInt2 + 1 != paramInt3)
        break;
      localaa2 = this.a.b(paramInt2);
    }
    while ((localaa2 != null) && (localaa2.F() >= paramInt1));
    return paramInt3;
    int i1 = (paramInt2 + paramInt3) / 2;
    aa localaa1 = this.a.b(i1);
    if (localaa1 == null)
      return -1;
    if (localaa1.F() >= paramInt1)
      return b(paramInt1, paramInt2, i1);
    return b(paramInt1, i1, paramInt3);
  }

  private void c(int paramInt)
  {
    int i1 = this.a.c();
    if (i1 > 0)
    {
      int i2 = b(paramInt, 0, i1 - 1);
      if (i2 >= 0)
      {
        ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(i2, true, false);
        aa localaa = this.a.b(i2);
        if (localaa != null)
          ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(localaa.y());
      }
    }
  }

  private void d(int paramInt)
  {
    if ((paramInt == 0) && (this.o > 0))
      if ((!this.a.l()) && (!this.t))
        this.a.a(this.q, this.o, this.x, null);
    while ((this.o <= this.p) || (this.p <= 0))
      return;
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).b();
  }

  private void e(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }

  private boolean r()
  {
    return (this.k != null) && (this.v == this.k.getId()) && (this.k.getLastLocalMsgId() <= this.p);
  }

  public void a()
  {
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.c() == 0) || (this.t) || (this.a.l()) || (this.m));
    while (true)
    {
      return;
      int i1;
      if (paramInt1 <= 14)
      {
        i1 = this.a.k();
        if (!this.a.m())
          break label114;
        this.a.n();
        e(true);
      }
      while ((!this.t) && (paramInt3 - (paramInt1 + paramInt2) <= 14))
      {
        e(this.a.b(this.q, this.o, this.x, null));
        return;
        label114: if (i1 > 1)
          e(this.a.b(this.q, i1, this.o, this.x, null));
      }
    }
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    this.c.a(paramLong1, new e(this, paramLong2, paramInt, paramLong1));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    this.k = ((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity);
    this.o = this.k.getLastServerMsgId();
    this.q = this.k.getGroupId();
    boolean bool;
    if ((paramConversationItemLoaderEntity.isCommunityType()) && (paramConversationItemLoaderEntity.isDisabledConversation()))
    {
      bool = true;
      this.m = bool;
      if (paramBoolean)
      {
        this.n = null;
        if ((paramConversationItemLoaderEntity.isNotJoinedCommunity()) || (paramConversationItemLoaderEntity.isYouInvitedAsMemberCommunity()))
          ((com.viber.voip.messages.controller.a)this.w.get()).c((int)paramConversationItemLoaderEntity.getId());
      }
      if (!this.t)
        e(this.h.a(this.q));
      if (r())
        d(this.a.c());
      if (!com.viber.voip.messages.m.a(this.k.getConversationType()))
        break label173;
      b(da.c(this.k.getWatchersCount()));
    }
    label173: 
    while ((this.l == null) || (paramBoolean))
    {
      return;
      bool = false;
      break;
    }
    b(da.b(this.l, this.k));
  }

  protected void a(ac paramac)
  {
    if ((this.k != null) && (com.viber.voip.messages.m.b(this.k.getConversationType())))
      b(da.b(paramac, this.k));
  }

  public void a(ac paramac, boolean paramBoolean)
  {
    this.l = paramac;
    super.a(paramac, paramBoolean);
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    super.a(paramq, paramBoolean1, paramInt, paramBoolean2);
    if (paramBoolean1)
    {
      this.u = false;
      this.v = paramq.I();
      this.j.a(this);
    }
    this.p = paramq.w();
    d(paramq.getCount());
  }

  public void a(ConversationData paramConversationData)
  {
    this.e = paramConversationData;
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).c(dg.a(paramConversationData));
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramConversationData.portBackgroud, paramConversationData.landBackgroud, false);
    if ((paramConversationData instanceof PublicGroupConversationData))
      b(da.c(((PublicGroupConversationData)paramConversationData).publicGroupInfo.getWatchersCount()));
    this.j.a();
  }

  public void b()
  {
  }

  public void c()
  {
    aa localaa = this.a.e();
    if (localaa == null);
    do
    {
      int[] arrayOfInt;
      do
      {
        return;
        int i1 = localaa.F();
        if (this.o <= i1)
          break;
        arrayOfInt = com.viber.voip.messages.conversation.publicaccount.a.a.a(i1, this.o, this.o);
      }
      while (arrayOfInt == null);
      int i2 = -1 + arrayOfInt.length;
      boolean bool3;
      for (boolean bool1 = false; i2 >= 0; bool1 = bool3)
      {
        boolean bool2 = this.a.a(this.q, arrayOfInt[i2], this.x, null);
        bool3 = bool1 | bool2;
        if ((i2 == 0) && (bool2))
          this.u = true;
        i2--;
      }
      e(bool1);
    }
    while (!this.u);
    super.c();
    return;
    super.c();
  }

  protected void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if (paramConversationItemLoaderEntity == null);
    String str;
    do
    {
      return;
      super.c(paramConversationItemLoaderEntity, paramBoolean);
      str = ((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity).getBackgroundId();
    }
    while ((this.n != null) && (this.n.equals(str)));
    this.n = str;
    this.g.b(paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getBackgroundPortrait(), str);
  }

  public void c_(boolean paramBoolean)
  {
  }

  public void connectivityChanged(int paramInt1, int paramInt2)
  {
    super.connectivityChanged(paramInt1, paramInt2);
    if (-1 != paramInt2)
    {
      if ((this.a.b() != null) && (this.n != null))
      {
        this.n = null;
        c(this.a.b(), true);
      }
      if (r())
      {
        if (this.a.c() != 0)
          break label68;
        d(0);
      }
    }
    return;
    label68: ((com.viber.voip.messages.conversation.ui.view.h)this.mView).b();
  }

  protected State getSaveState()
  {
    return new GeneralPublicGroupConversationPresenterState(this.r, this.s);
  }

  public void j()
  {
    if (this.t)
    {
      p();
      if ((this.q <= 0L) || (!this.h.a(this.q)))
        break label42;
    }
    label42: for (boolean bool = true; ; bool = false)
    {
      e(bool);
      return;
    }
  }

  public void onPause(android.arch.lifecycle.h paramh)
  {
    super.onPause(paramh);
    this.r.c();
  }

  public void onResume(android.arch.lifecycle.h paramh)
  {
    super.onResume(paramh);
    this.r.d();
  }

  public void onStart(android.arch.lifecycle.h paramh)
  {
    super.onStart(paramh);
    this.h.a(this.y, this.i);
  }

  public void onStop(android.arch.lifecycle.h paramh)
  {
    super.onStop(paramh);
    this.h.b(this.y);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    if ((paramState instanceof GeneralPublicGroupConversationPresenterState))
    {
      GeneralPublicGroupConversationPresenterState localGeneralPublicGroupConversationPresenterState = (GeneralPublicGroupConversationPresenterState)paramState;
      this.r = localGeneralPublicGroupConversationPresenterState.getActiveScreenTimer();
      this.s = localGeneralPublicGroupConversationPresenterState.getTrackedGroupId();
      return;
    }
    this.r = com.viber.common.d.i.a();
  }

  protected void p()
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)this.d;
    if ((localPublicGroupConversationItemLoaderEntity != null) && (localPublicGroupConversationItemLoaderEntity.getUnreadMessagesCount() == 0));
    for (boolean bool = true; ; bool = false)
    {
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).b(bool);
      if ((this.u) && (this.k != null) && (!this.h.c(this.q, this.k.getLastLocalMsgId())))
      {
        this.u = false;
        ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(false);
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.GeneralPublicGroupConversationPresenter
 * JD-Core Version:    0.6.2
 */