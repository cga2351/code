package com.viber.voip.messages.conversation.ui.presenter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.messages.a.l.b;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.b.af;
import com.viber.voip.messages.conversation.ui.b.ag;
import com.viber.voip.messages.conversation.ui.b.ah;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.l;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.p;
import com.viber.voip.messages.conversation.ui.b.t;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.conversation.ui.b.w;
import com.viber.voip.messages.conversation.ui.b.x;
import com.viber.voip.messages.conversation.ui.b.y;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.c;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.settings.d.i;
import com.viber.voip.settings.d.r;
import com.viber.voip.storage.c.a;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.b;
import com.viber.voip.util.cq;
import com.viber.voip.util.cq.a;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

public class GeneralConversationPresenter<VIEW extends com.viber.voip.messages.conversation.ui.view.h> extends BaseMvpPresenter<VIEW, State>
  implements ag, g, l, com.viber.voip.messages.conversation.ui.b.o, v, y, ExpandablePanelLayout.c, c.a, cj.b, cq.a
{
  private static final Logger f = ViberEnv.getLogger();
  private boolean A = false;
  private boolean B = false;
  private boolean C;
  private Runnable D = new a(this);
  protected final com.viber.voip.messages.conversation.ui.b.f a;
  protected final u b;
  protected final i c;
  protected ConversationItemLoaderEntity d;
  protected ConversationData e;
  private final com.viber.voip.messages.conversation.ui.b.a g;
  private final t h;
  private final af i;
  private final n j;
  private final z k;
  private final ai l;
  private final com.viber.voip.app.b m;
  private final Handler n;
  private final Handler o;
  private final cq p;
  private final EventBus q;
  private com.viber.voip.messages.controller.publicaccount.d r;
  private boolean s = true;
  private cj t;
  private com.viber.voip.storage.c u;
  private boolean v;
  private x w;
  private final com.viber.voip.analytics.story.e.c x;
  private Pair<Long, ac> y;
  private Pair<Long, Integer> z;

  public GeneralConversationPresenter(com.viber.voip.messages.conversation.ui.b.a parama, com.viber.voip.messages.conversation.ui.b.f paramf, u paramu, t paramt, i parami, cj paramcj, com.viber.voip.storage.c paramc, af paramaf, n paramn, boolean paramBoolean, EventBus paramEventBus, x paramx, z paramz, ai paramai, com.viber.voip.app.b paramb, Handler paramHandler1, Handler paramHandler2, cq paramcq, com.viber.voip.analytics.story.e.c paramc1, com.viber.voip.messages.controller.publicaccount.d paramd)
  {
    this.v = paramBoolean;
    this.g = parama;
    this.a = paramf;
    this.b = paramu;
    this.c = parami;
    this.i = paramaf;
    this.j = paramn;
    this.h = paramt;
    this.t = paramcj;
    this.u = paramc;
    this.q = paramEventBus;
    this.w = paramx;
    this.k = paramz;
    this.l = paramai;
    this.m = paramb;
    this.n = paramHandler1;
    this.o = paramHandler2;
    this.p = paramcq;
    this.x = paramc1;
    this.r = paramd;
  }

  private ScreenshotConversationData a(Uri paramUri, String paramString, int paramInt1, int paramInt2)
  {
    ScreenshotConversationData localScreenshotConversationData;
    if (this.d == null)
      localScreenshotConversationData = null;
    while (true)
    {
      return localScreenshotConversationData;
      localScreenshotConversationData = new ScreenshotConversationData(paramUri, paramString, paramInt1, paramInt2, StoryConstants.g.a.a(this.d));
      if (this.d.isCommunityType())
      {
        if ((!this.d.isDisabledConversation()) && (!this.d.isCommunityBlocked()) && ((cd.b(this.d.getGroupRole())) || (((PublicGroupConversationItemLoaderEntity)this.d).isDisplayInvitationLinkToAll())));
        for (int i1 = 1; i1 != 0; i1 = 0)
        {
          localScreenshotConversationData.setGroupRole(this.d.getGroupRole());
          localScreenshotConversationData.setGroupId(this.d.getGroupId());
          localScreenshotConversationData.setCommunityName(this.d.getGroupName());
          localScreenshotConversationData.setCommunity(true);
          return localScreenshotConversationData;
        }
      }
    }
  }

  private void b()
  {
    if (this.e == null)
      return;
    int i1 = c(this.e.foundMessageToken);
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(this.e.foundMessageToken, this.e.searchMessageText, this.e.foundMessageHightlitingTime);
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(i1, false, false);
  }

  private void b(Uri paramUri, Pair<String, File> paramPair, Bitmap paramBitmap)
  {
    ScreenshotConversationData localScreenshotConversationData = a(paramUri, (String)paramPair.first, paramBitmap.getWidth(), paramBitmap.getHeight());
    if (localScreenshotConversationData == null)
      return;
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(localScreenshotConversationData);
    this.C = false;
  }

  private void b(MessageEntity paramMessageEntity, long paramLong)
  {
    long l1 = this.a.f();
    if ((paramMessageEntity.getMessageToken() > 0L) && (l1 > 0L) && (paramMessageEntity.getMessageToken() >= l1))
    {
      int i1 = c(paramMessageEntity.getMessageToken());
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramMessageEntity.getMessageToken(), "", i1, paramLong, true);
      return;
    }
    this.B = true;
    this.a.a(paramMessageEntity.getConversationId(), paramMessageEntity.getOrderKey());
  }

  private int c(long paramLong)
  {
    int i1 = 0;
    int i2 = this.a.c();
    while (i1 < i2)
    {
      if (paramLong == this.a.a(i1))
        return i1;
      i1++;
    }
    return -1;
  }

  private boolean p()
  {
    boolean bool1 = true;
    if (this.d == null)
      return false;
    boolean bool2 = d.r.E.d();
    boolean bool3 = this.k.x();
    boolean bool4;
    boolean bool5;
    if (!this.m.a())
    {
      bool4 = bool1;
      int i1 = this.d.getConversationType();
      if ((!com.viber.voip.messages.m.g(i1)) && (!com.viber.voip.messages.m.b(i1)) && (!com.viber.voip.messages.m.f(i1)))
        break label108;
      bool5 = bool1;
      label75: if ((!bool2) || (!bool4) || (bool3) || (this.C) || (!bool5))
        break label114;
    }
    while (true)
    {
      return bool1;
      bool4 = false;
      break;
      label108: bool5 = false;
      break label75;
      label114: bool1 = false;
    }
  }

  private void q()
  {
    if (this.d == null)
      break label7;
    label7: 
    while ((this.z == null) || (this.z.first == null) || (this.z.second == null) || (this.d.getId() != ((Long)this.z.first).longValue()) || (this.y == null) || (this.y.first == null) || (this.d.getId() != ((Long)this.y.first).longValue()))
      return;
    int i1;
    if (this.y.second != null)
      if ((this.d.isCommunityType()) && ((this.d instanceof PublicGroupConversationItemLoaderEntity)))
        i1 = da.a((ac)this.y.second, (PublicGroupConversationItemLoaderEntity)this.d);
    while (true)
    {
      this.x.a(this.d, i1, ((Integer)this.z.second).intValue(), ae.b());
      if ((!this.A) || (!this.d.isSupportEnterConversationEvent()))
        break;
      this.r.a(8, this.d.getId(), "", this.d.getPublicAccountId());
      return;
      i1 = ((ac)this.y.second).getCount();
      continue;
      i1 = 0;
    }
  }

  public void G_()
  {
    b(null);
  }

  public void J()
  {
    a(t.c.a, t.b.a.b);
  }

  public void K()
  {
    ah.b(this);
  }

  public void a(int paramInt)
  {
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramInt1);
    int i1;
    if (paramInt1 == 3)
    {
      i1 = 1;
      if ((i1 != 0) && (this.s))
        this.h.a(this.v);
      if (i1 != 0)
        break label65;
    }
    label65: for (boolean bool = true; ; bool = false)
    {
      this.s = bool;
      return;
      i1 = 0;
      break;
    }
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this, paramLong1, paramInt, paramLong2);
  }

  public void a(Pair<String, File> paramPair, Bitmap paramBitmap)
  {
    if ((paramPair != null) && (paramBitmap != null))
    {
      this.n.post(new b(this, paramBitmap, paramPair));
      return;
    }
    this.C = false;
  }

  public void a(View paramView)
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramView, this.d);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((this.v) && (!this.m.a()) && (paramConversationItemLoaderEntity != null) && (paramConversationItemLoaderEntity.isMarkedAsUnreadConversation()))
      this.l.a(paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getConversationType(), false);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.d = paramConversationItemLoaderEntity;
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).c(dg.b(paramConversationItemLoaderEntity));
    if (paramConversationItemLoaderEntity.isOneToOneWithPublicAccount())
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).b(R.string.public_account_subtitle);
    if (!paramBoolean);
    for (boolean bool1 = true; ; bool1 = false)
    {
      c(paramConversationItemLoaderEntity, bool1);
      a(t.c.a, t.b.a.b);
      if ((this.d != null) && (paramBoolean))
      {
        boolean bool2;
        if (!paramConversationItemLoaderEntity.isSecret())
        {
          boolean bool3 = paramConversationItemLoaderEntity.isHiddenConversation();
          bool2 = false;
          if (!bool3);
        }
        else
        {
          bool2 = true;
        }
        c(bool2);
      }
      if (paramBoolean)
      {
        if ((com.viber.voip.messages.m.a(this.d.getConversationType())) || ((!this.d.isGroupType()) && (!this.d.isBroadcastListType()) && (!this.d.isCommunityType())))
          this.y = Pair.create(Long.valueOf(this.d.getId()), null);
        q();
      }
      return;
    }
  }

  public void a(aa paramaa)
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a();
  }

  protected void a(ac paramac)
  {
    b(da.a(paramac));
  }

  public void a(ac paramac, boolean paramBoolean)
  {
    a(paramac);
    if (paramBoolean)
    {
      this.y = Pair.create(Long.valueOf(paramac.s()), paramac);
      q();
    }
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.b.f paramf, boolean paramBoolean)
  {
    ah.a(this, paramf, paramBoolean);
  }

  public void a(com.viber.voip.messages.conversation.q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.z = Pair.create(Long.valueOf(paramq.I()), Integer.valueOf(paramq.z()));
      q();
      if (this.a.c() == 0)
        ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a();
      if (!this.B)
        b(paramInt);
    }
    if (this.B)
    {
      b();
      this.B = false;
    }
  }

  public void a(ConversationData paramConversationData)
  {
    this.e = paramConversationData;
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).c(dg.a(paramConversationData));
    if (paramConversationData.groupId > 0L);
    for (String str = " "; ; str = null)
    {
      b(str);
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramConversationData.portBackgroud, paramConversationData.landBackgroud, false);
      return;
    }
  }

  public void a(com.viber.voip.messages.conversation.ui.view.d paramd)
  {
    this.B = paramd.a();
    this.A = paramd.b();
  }

  public void a(MessageEntity paramMessageEntity, int paramInt, String paramString)
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramMessageEntity.getMessageToken(), paramString, paramInt, -1L, true);
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramMessageEntity.getMessageToken());
  }

  public void a(MessageEntity paramMessageEntity, long paramLong)
  {
    ConversationData localConversationData = this.a.h();
    if ((localConversationData == null) || (localConversationData.conversationId != paramMessageEntity.getConversationId()))
      return;
    localConversationData.foundMessageToken = paramMessageEntity.getMessageToken();
    localConversationData.foundMessageOrderKey = paramMessageEntity.getOrderKey();
    localConversationData.foundMessageHightlitingTime = paramLong;
    localConversationData.searchMessageText = "";
    b(paramMessageEntity, paramLong);
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramMessageEntity.getMessageToken());
  }

  public void a(t.c paramc, t.b.a parama)
  {
    if (paramc == t.c.a)
    {
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(parama);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).b(parama);
  }

  public void a(t.c paramc, t.b.a parama, long paramLong)
  {
    if ((paramLong == 0L) || (parama == t.b.a.b))
    {
      a(paramc, parama);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramc, paramLong);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramCharSequence, paramBoolean);
  }

  public void a(String paramString)
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramString);
  }

  public void a(boolean paramBoolean)
  {
    w.a(this, paramBoolean);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (!paramBoolean2))
    {
      ConversationData localConversationData = this.a.h();
      if ((localConversationData != null) && (localConversationData.foundMessageToken > -1L))
      {
        localConversationData.foundMessageToken = -1L;
        localConversationData.foundMessageOrderKey = -1L;
        localConversationData.searchMessageText = "";
      }
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).d();
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(-1L, "", -1L);
    }
  }

  protected void b(int paramInt)
  {
    if (paramInt != -1)
    {
      if ((paramInt == 0) && (this.a.c() > 1))
      {
        aa localaa = this.a.b(0);
        if ((localaa != null) && (localaa.w()) && (!localaa.aR()))
          paramInt = -1;
      }
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(paramInt, false, false);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(false);
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.b(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b(com.viber.voip.model.h paramh)
  {
    p.a(this, paramh);
  }

  public void b(String paramString)
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).b(paramString);
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p.a();
      return;
    }
    this.p.b();
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void backgroundDataChanged(boolean paramBoolean)
  {
  }

  public void c()
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(false);
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).e();
  }

  protected void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    String str1;
    String str2;
    String str4;
    String str3;
    if (paramConversationItemLoaderEntity != null)
    {
      str1 = paramConversationItemLoaderEntity.getBackgroundPortrait();
      str2 = paramConversationItemLoaderEntity.getBackgroundLandscape();
      if ((!at.b(str1)) || (!at.b(str2)))
      {
        str1 = d.i.d.d();
        str2 = d.i.e.d();
      }
      if ((paramConversationItemLoaderEntity.isPublicGroupType()) || (!com.viber.voip.backgrounds.m.d(str1)))
        break label103;
      String str5 = new com.viber.voip.backgrounds.o().a(false).toString();
      str4 = str5;
      str3 = str5;
    }
    while (true)
    {
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(str3, str4, paramBoolean);
      return;
      label103: str3 = str1;
      str4 = str2;
    }
  }

  public void c(boolean paramBoolean)
  {
    if (d.r.u.d());
    while (!com.viber.common.d.a.j())
      return;
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).c(paramBoolean);
  }

  public void connectivityChanged(int paramInt1, int paramInt2)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.a.b();
    if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isOneToOneWithPublicAccount()))
      this.r.a(localConversationItemLoaderEntity.getId());
  }

  public void d()
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a();
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(false);
  }

  public void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.d != null))
      this.x.b(this.d, null);
  }

  public void e()
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).c();
  }

  public boolean f()
  {
    return false;
  }

  public void g()
  {
    c(this.d, true);
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).g();
  }

  public void h()
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(this.d.getPublicAccountGroupUri(), this.d.getParticipantMemberId(), this.d.getConversationType());
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void j()
  {
    com.viber.voip.messages.conversation.ui.b.m.a(this);
  }

  public void k()
  {
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).d(this.d.getPublicAccountGroupUri());
  }

  public void l()
  {
    if (this.d != null)
    {
      if (!this.d.isSecret())
        break label60;
      this.q.post(new l.b(this.d.getId(), this.d.getParticipantMemberId(), this.d.getGroupId(), this.d.getTimebombTime()));
    }
    label60: 
    while (!p())
      return;
    this.C = true;
    if (com.viber.common.d.a.m())
    {
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(this.n);
      return;
    }
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).h();
  }

  public void m()
  {
    aa localaa = this.a.e();
    if (localaa != null)
    {
      this.o.removeCallbacks(this.D);
      if (!localaa.bk())
        break label46;
      this.o.postDelayed(this.D, 1000L);
    }
    label46: 
    while (!localaa.b(new int[] { 10 }))
      return;
    this.o.postDelayed(this.D, 3000L);
  }

  public void o()
  {
    com.viber.voip.storage.d.a(this);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.g.b(this);
    this.a.b(this);
    this.b.b(this);
    this.c.b(this);
    this.t.b(this);
    this.u.b(this);
    this.i.b(this);
    this.j.b(this);
    this.w.b(this);
    this.p.b();
    this.o.removeCallbacks(this.D);
  }

  public void onStop(android.arch.lifecycle.h paramh)
  {
    super.onStop(paramh);
    this.p.b();
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.t.a(this);
    this.u.a(this);
    this.a.a(this);
    this.g.a(this);
    this.b.a(this);
    this.c.a(this);
    this.i.a(this);
    this.j.a(this);
    this.w.a(this);
    this.p.a(this);
    this.p.a();
    ((com.viber.voip.messages.conversation.ui.view.h)this.mView).a(t.c.a, 1000L);
  }

  public void onViewConfigurationChanged()
  {
    if (this.a.b() != null)
    {
      c(this.a.b(), false);
      ((com.viber.voip.messages.conversation.ui.view.h)this.mView).c();
    }
  }

  public void wifiConnectivityChanged()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.GeneralConversationPresenter
 * JD-Core Version:    0.6.2
 */