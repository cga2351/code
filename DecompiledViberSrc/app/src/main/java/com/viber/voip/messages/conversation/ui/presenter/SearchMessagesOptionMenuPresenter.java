package com.viber.voip.messages.conversation.ui.presenter;

import android.support.v4.util.Pair;
import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.j;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.conversation.ui.av;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.l;
import com.viber.voip.messages.conversation.ui.b.m;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.conversation.ui.b.w;
import com.viber.voip.messages.conversation.ui.view.n;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.ap.a;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.util.da;
import dagger.a;
import java.util.Collections;
import java.util.List;

public class SearchMessagesOptionMenuPresenter extends BaseMvpPresenter<n, State>
  implements ai.j, g, l, v, ap.a<at>
{
  private static final Logger a = ViberEnv.getLogger();
  private final i b;
  private final com.viber.voip.messages.conversation.ui.b.f c;
  private a<k> d;
  private u e;
  private List<Pair<MessageEntity, Integer>> f = Collections.emptyList();
  private c g;
  private final av h;
  private String i = "Chat menu";
  private String j = "";
  private int k = 0;
  private long l = -1L;
  private final boolean m;
  private boolean n;

  public SearchMessagesOptionMenuPresenter(u paramu, i parami, com.viber.voip.messages.conversation.ui.b.f paramf, a<k> parama, c paramc, av paramav, boolean paramBoolean)
  {
    this.e = paramu;
    this.b = parami;
    this.c = paramf;
    this.d = parama;
    this.g = paramc;
    this.h = paramav;
    this.m = paramBoolean;
  }

  private void f()
  {
    g();
    MessageEntity localMessageEntity = (MessageEntity)((Pair)this.f.get(this.k)).first;
    Integer localInteger = (Integer)((Pair)this.f.get(this.k)).second;
    long l1 = this.c.g();
    long l2 = ((MessageEntity)((Pair)this.f.get(-1 + this.f.size())).first).getOrderKey();
    if (l2 >= l1)
    {
      this.b.a(localMessageEntity, localInteger.intValue(), this.j);
      return;
    }
    this.n = true;
    this.c.a(localMessageEntity.getConversationId(), l2);
  }

  private void g()
  {
    int i1;
    int i2;
    label35: int i3;
    boolean bool1;
    if (!da.a(this.j))
    {
      i1 = 1;
      if (i1 == 0)
        break label123;
      if (this.f.size() <= 0)
        break label106;
      i2 = 1 + this.k;
      i3 = this.f.size();
      if (i2 >= i3)
        break label111;
      bool1 = true;
      label53: if (i2 <= 1)
        break label117;
    }
    label106: label111: label117: for (boolean bool2 = true; ; bool2 = false)
    {
      boolean bool3 = false;
      if (i3 > 0)
        bool3 = true;
      ((n)this.mView).a(Integer.toString(i2), Integer.toString(i3), " / ", true, bool3, bool1, bool2);
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label35;
      bool1 = false;
      break label53;
    }
    label123: ((n)this.mView).a("", "", "", true, false, false, false);
  }

  public void G_()
  {
    w.a(this);
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    m.a(this, paramLong1, paramInt, paramLong2);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.l = paramConversationItemLoaderEntity.getId();
  }

  public void a(aa paramaa)
  {
    com.viber.voip.messages.conversation.adapter.f.a(this, paramaa);
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    d();
    if ((paramBoolean1) && (this.n) && (!this.f.isEmpty()))
      f();
  }

  public void a(ConversationData paramConversationData)
  {
    if ((!this.m) && (paramConversationData != null) && (!da.a(paramConversationData.searchMessageText)))
    {
      this.l = paramConversationData.conversationId;
      this.i = "Search in messages";
      this.b.b(true, true);
      ((n)this.mView).a(paramConversationData.searchMessageText);
      b(paramConversationData.searchMessageText);
    }
  }

  public void a(at paramat)
  {
    ((n)this.mView).a(paramat);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt, String paramString)
  {
    m.a(this, paramMessageEntity, paramInt, paramString);
  }

  public void a(t.c paramc, t.b.a parama)
  {
    w.a(this, paramc, parama);
  }

  public void a(t.c paramc, t.b.a parama, long paramLong)
  {
    w.a(this, paramc, parama, paramLong);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    w.a(this, paramCharSequence, paramBoolean);
  }

  public void a(String paramString)
  {
    w.a(this, paramString);
  }

  public void a(List<Pair<MessageEntity, Integer>> paramList)
  {
    this.f = paramList;
    this.k = 0;
    if (!this.f.isEmpty())
    {
      f();
      return;
    }
    this.b.b(true, false);
    ((n)this.mView).a("0", "0", " / ", true, false, false, false);
    ((n)this.mView).d();
  }

  public void a(boolean paramBoolean)
  {
    w.a(this, paramBoolean);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    m.a(this, paramBoolean1, paramBoolean2);
  }

  public void b()
  {
    if (this.f.isEmpty())
      return;
    this.k = (1 + this.k);
    if (this.k >= this.f.size())
      this.k = 0;
    f();
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.b(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b(String paramString)
  {
    if (this.l > -1L)
    {
      this.j = paramString.trim();
      ((k)this.d.get()).c().a(this.l, this.c.d(), this.j, this);
    }
  }

  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    this.b.b(paramBoolean, bool);
    if (paramBoolean)
    {
      ((n)this.mView).c();
      ConversationItemLoaderEntity localConversationItemLoaderEntity = this.c.b();
      if (localConversationItemLoaderEntity != null)
        this.g.b(this.i, StoryConstants.g.a.a(localConversationItemLoaderEntity));
      ((n)this.mView).a("", "", "", paramBoolean, false, false, false);
      return;
    }
    this.i = "Chat menu";
    this.f = Collections.emptyList();
    this.j = "";
    n localn = (n)this.mView;
    if (this.c.c() > 0);
    while (true)
    {
      localn.a(bool);
      break;
      bool = false;
    }
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void c()
  {
    if (this.f.isEmpty())
      return;
    this.k = (-1 + this.k);
    if (this.k < 0)
      this.k = (-1 + this.f.size());
    f();
  }

  public void d()
  {
    if (this.b.a())
      g();
    long l1;
    long l2;
    label118: 
    do
    {
      return;
      ConversationItemLoaderEntity localConversationItemLoaderEntity = this.c.b();
      if ((!this.m) && (this.c.c() > 0) && (localConversationItemLoaderEntity != null) && (!localConversationItemLoaderEntity.isSystemConversation()));
      for (boolean bool = true; ; bool = false)
      {
        ((n)this.mView).a(bool);
        if (!bool)
          break;
        l1 = d.r.C.d();
        l2 = System.currentTimeMillis();
        if (l1 != 0L)
          break label118;
        ((n)this.mView).b();
        ((n)this.mView).a();
        return;
      }
    }
    while (l2 >= l1);
    ((n)this.mView).b();
  }

  public void e()
  {
    d.r.C.a(1814400000L + System.currentTimeMillis());
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void j()
  {
    m.a(this);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.c.b(this);
    this.e.b(this);
    this.b.b(this);
    this.h.b(this);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.c.a(this);
    this.e.a(this);
    this.b.a(this);
    this.h.a(this);
    ((n)this.mView).a((at)this.h.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.SearchMessagesOptionMenuPresenter
 * JD-Core Version:    0.6.2
 */