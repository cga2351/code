package com.viber.voip.messages.conversation.chatinfo.presentation;

import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.util.ObjectsCompat;
import com.viber.jni.Engine;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.jni.secure.TrustPeerController;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.flatbuffers.model.publicaccount.MyCommunitySettings;
import com.viber.voip.invitelinks.f.a;
import com.viber.voip.invitelinks.g;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.b.a;
import com.viber.voip.messages.conversation.chatinfo.e.d;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.messages.conversation.i;
import com.viber.voip.messages.conversation.i.a;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.settings.d.as;
import com.viber.voip.ui.ap;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.OnlineUserActivityHelper.UiOnlineUserInfoDelegate;
import com.viber.voip.util.cd;
import com.viber.voip.util.cl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class x
  implements f.a, b.a, w, i.a
{
  private static final ae a = (ae)cl.b(ae.class);
  private ae b;
  private final ai c;
  private final GroupController d;
  private final com.viber.voip.messages.controller.a e;
  private final OnlineUserActivityHelper f;
  private final com.viber.voip.invitelinks.f g;
  private final com.viber.voip.invitelinks.linkscreen.f h;
  private final Engine i;
  private final Handler j;
  private final Handler k;
  private final c l;
  private final Resources m;
  private final com.viber.voip.publicaccount.ui.holders.recentmedia.b n;
  private final com.viber.voip.messages.conversation.chatinfo.b.a o;
  private final com.viber.voip.publicaccount.ui.holders.recentmedia.b p;
  private final com.viber.voip.messages.conversation.ac q;
  private ConversationItemLoaderEntity r;
  private final i s;
  private final com.viber.voip.messages.conversation.b t;
  private n u;
  private final e v;
  private final OnlineUserActivityHelper.UiOnlineUserInfoDelegate w = new OnlineUserActivityHelper.UiOnlineUserInfoDelegate()
  {
    public void onOnlineStatusActivityReady(int paramAnonymousInt, OnlineContactInfo[] paramAnonymousArrayOfOnlineContactInfo)
    {
      if (x.a(x.this).isAnonymous())
        return;
      HashMap localHashMap = new HashMap();
      if ((paramAnonymousArrayOfOnlineContactInfo != null) && (paramAnonymousArrayOfOnlineContactInfo.length > 0))
      {
        int i = paramAnonymousArrayOfOnlineContactInfo.length;
        for (int j = 0; j < i; j++)
        {
          OnlineContactInfo localOnlineContactInfo = paramAnonymousArrayOfOnlineContactInfo[j];
          localHashMap.put(localOnlineContactInfo.memberId, localOnlineContactInfo);
        }
      }
      x.b(x.this).post(new ad(this, localHashMap));
    }
  };

  x(ae paramae, k paramk, OnlineUserActivityHelper paramOnlineUserActivityHelper, com.viber.voip.invitelinks.f paramf, com.viber.voip.invitelinks.linkscreen.f paramf1, Engine paramEngine, Handler paramHandler1, Handler paramHandler2, com.viber.voip.messages.conversation.chatinfo.b.a parama, com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb1, e parame, c paramc, Resources paramResources, com.viber.voip.publicaccount.ui.holders.recentmedia.b paramb2, int paramInt, com.viber.voip.messages.conversation.ac paramac, i parami, com.viber.voip.messages.conversation.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramae;
    this.c = paramk.c();
    this.d = paramk.d();
    this.e = paramk.z();
    this.f = paramOnlineUserActivityHelper;
    this.g = paramf;
    this.h = paramf1;
    this.i = paramEngine;
    this.j = paramHandler1;
    this.k = paramHandler2;
    this.o = parama;
    this.v = parame;
    this.m = paramResources;
    this.n = paramb2;
    this.q = paramac;
    com.viber.voip.messages.conversation.chatinfo.b.a locala = this.o;
    ae localae = this.b;
    localae.getClass();
    locala.a(y.a(localae));
    this.p = paramb1;
    this.s = parami;
    this.t = paramb;
    this.u = new n.a().a(paramInt).c(paramBoolean1).d(paramBoolean2).a();
    this.l = paramc;
  }

  private void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, n paramn)
  {
    if (!paramConversationItemLoaderEntity.isPublicGroupType())
      this.o.a(this.m, this.n, this.q, paramConversationItemLoaderEntity, paramn);
  }

  private void b(int paramInt)
  {
    this.u = n.a.a(this.u).b(paramInt).a();
  }

  private void b(long paramLong)
  {
    this.u = n.a.a(this.u).a(paramLong).a();
  }

  private void c(String paramString)
  {
    PeerTrustState.PeerTrustEnum localPeerTrustEnum = this.i.getTrustPeerController().isPeerTrusted(paramString).toEnum();
    n.b localb = new n.b(paramString, localPeerTrustEnum);
    this.j.post(new ac(this, localb, paramString, localPeerTrustEnum));
  }

  private void o()
  {
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    int i2 = this.q.getCount();
    while (i1 < i2)
    {
      com.viber.voip.messages.conversation.ae localae = this.q.e(i1);
      if ((localae != null) && (!localae.isOwner()))
      {
        PeerTrustState.PeerTrustEnum localPeerTrustEnum = this.i.getTrustPeerController().isPeerTrusted(localae.h()).toEnum();
        localHashMap.put(localae.h(), localPeerTrustEnum);
      }
      i1++;
    }
    this.j.post(new ab(this, localHashMap));
  }

  public void a()
  {
    this.b.d(false);
    this.b.B();
  }

  public void a(int paramInt)
  {
    if (this.u.h() != paramInt)
    {
      b(paramInt);
      l();
    }
  }

  public void a(int paramInt, String paramString)
  {
    int i1 = this.q.getCount();
    if (i1 > 0)
      this.b.a(this.r, i1, paramInt, paramString);
  }

  public void a(long paramLong)
  {
    if (this.u.f() != paramLong)
    {
      b(paramLong);
      l();
    }
  }

  public void a(long paramLong, String paramString)
  {
    g.a(this, paramLong, paramString);
  }

  public void a(long paramLong, String[] paramArrayOfString)
  {
    this.d.a(paramLong, paramArrayOfString, 2);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2, String paramString)
  {
    this.b.a(paramConversationItemLoaderEntity, paramInt1, paramInt2);
    if (paramString != null)
      this.l.b(paramString, this.r);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, String paramString)
  {
    this.l.b(paramString, this.r);
    this.b.a(paramConversationItemLoaderEntity, paramInt);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    int i1 = 1;
    int i2;
    int i3;
    if ((this.r != null) && (this.r.isHiddenConversation() != paramConversationItemLoaderEntity.isHiddenConversation()))
    {
      i2 = i1;
      if ((this.r == null) || (!cd.i(this.r.getGroupRole(), this.r.getConversationType())))
        break label334;
      i3 = i1;
      label56: this.r = paramConversationItemLoaderEntity;
      long l1 = paramConversationItemLoaderEntity.getId();
      int i4 = paramConversationItemLoaderEntity.getConversationType();
      int i5 = paramConversationItemLoaderEntity.getGroupRole();
      int i6 = cd.i(i5, i4);
      ap localap = this.v.a();
      if (!paramConversationItemLoaderEntity.isSecret())
        break label340;
      label104: localap.d(i1);
      this.v.a(i5, i4, paramConversationItemLoaderEntity.getGroupId());
      Map localMap = this.v.c().g();
      if ((paramConversationItemLoaderEntity.isConversation1on1()) && (localMap != null))
      {
        PeerTrustState.PeerTrustEnum localPeerTrustEnum = (PeerTrustState.PeerTrustEnum)localMap.get(paramConversationItemLoaderEntity.getParticipantMemberId());
        if (localPeerTrustEnum != null)
        {
          n.b localb = new n.b(paramConversationItemLoaderEntity.getParticipantMemberId(), localPeerTrustEnum);
          this.u = n.a.a(this.u).a(localb).a();
        }
      }
      if (this.p.I() != l1)
      {
        this.p.a(l1);
        this.p.i();
        this.p.p();
      }
      if ((paramBoolean) || (i2 != 0))
      {
        b(0L);
        if (!m.a(paramConversationItemLoaderEntity))
          break label345;
        this.s.a(this);
        this.s.a(paramConversationItemLoaderEntity.getParticipantMemberId());
      }
      label280: if ((paramBoolean) || (i6 != i3))
      {
        b(0);
        if (i6 == 0)
          break label355;
        this.t.a(this);
        this.t.a(l1);
      }
    }
    while (true)
    {
      a(paramConversationItemLoaderEntity, this.u);
      return;
      i2 = 0;
      break;
      label334: i3 = 0;
      break label56;
      label340: i1 = 0;
      break label104;
      label345: this.s.a();
      break label280;
      label355: this.t.a();
    }
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, String paramString)
  {
    if ((this.r.isCommunityType()) && (!cd.c(paramPublicGroupConversationItemLoaderEntity.getGroupRole())) && (m.b()))
      this.h.a(paramPublicGroupConversationItemLoaderEntity.getId(), paramPublicGroupConversationItemLoaderEntity.getGroupName(), paramPublicGroupConversationItemLoaderEntity.getIconUri(), paramString);
    while (true)
    {
      this.b.d(false);
      return;
      this.h.c(paramPublicGroupConversationItemLoaderEntity.getId(), paramPublicGroupConversationItemLoaderEntity.getGroupName(), paramPublicGroupConversationItemLoaderEntity.getIconUri(), paramString);
    }
  }

  public void a(String paramString)
  {
    if (this.q != null);
    for (int i1 = this.q.getCount(); ; i1 = 1)
    {
      if (i1 > 0)
        this.b.a(this.r, i1, paramString);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.e.a(this.r.getGroupId(), new MyCommunitySettings(paramBoolean));
    this.l.a(paramBoolean);
  }

  public void b()
  {
    this.b.d(false);
    this.b.C();
  }

  public void b(boolean paramBoolean)
  {
    this.u = n.a.a(this.u).b(paramBoolean).a();
  }

  public void c()
  {
    this.b.d(false);
    this.b.D();
  }

  public void c(boolean paramBoolean)
  {
    this.u = n.a.a(this.u).a(paramBoolean).a();
  }

  public void d()
  {
    this.b.d(false);
    this.b.E();
  }

  public void e()
  {
    if (this.q.getCount() > 1)
    {
      this.b.e(this.r);
      return;
    }
    this.b.z();
  }

  public void f()
  {
    if (this.r.isMuteConversation())
      return;
    if (!this.r.isSmartNotificationOn());
    for (boolean bool = true; ; bool = false)
    {
      this.d.a(this.r.getId(), this.r.getConversationType(), bool);
      if (!bool)
        break;
      this.l.a(this.r, com.viber.voip.util.ae.b());
      return;
    }
  }

  public void g()
  {
    if (this.r == null);
    ArrayList localArrayList;
    int i2;
    do
    {
      do
        return;
      while ((!OnlineUserActivityHelper.canFetchOnlineInfo(this.r)) || (this.q.getCount() <= 0));
      localArrayList = new ArrayList(this.q.getCount());
      for (int i1 = 0; i1 < this.q.getCount(); i1++)
      {
        String str = this.q.f(i1);
        if (str != null)
          localArrayList.add(str);
      }
      i2 = (int)(System.currentTimeMillis() / 1000L);
    }
    while (this.r.isAnonymous());
    if ((!this.r.isGroupBehavior()) && (!localArrayList.isEmpty()))
    {
      this.f.obtainInfo((String)localArrayList.get(0), i2, this.w);
      return;
    }
    this.f.obtainInfo((String[])localArrayList.toArray(new String[0]), i2, this.w);
  }

  public void h()
  {
    if ((this.r != null) && (this.i.isInitialized()) && (d.as.a.d()) && (!this.u.e()))
    {
      if (!this.r.isConversation1on1())
        break label95;
      localb = this.u.g();
      str = this.r.getParticipantMemberId();
      if ((localb == null) || (!ObjectsCompat.equals(localb.a(), str)))
        this.k.post(new z(this, str));
    }
    label95: 
    while ((!this.r.isGroupType()) || (!this.r.isSecure()))
    {
      n.b localb;
      String str;
      return;
    }
    this.k.post(new aa(this));
  }

  public void i()
  {
    this.b.y();
  }

  public void j()
  {
    this.b = a;
    this.f.removeListener(this.w);
    this.o.a();
    this.p.q();
    this.s.a();
    this.t.a();
  }

  public void k()
  {
    this.b.d(true);
    this.g.a((PublicGroupConversationItemLoaderEntity)this.r, false, this);
  }

  public void l()
  {
    if (this.r != null)
      a(this.r, this.u);
  }

  public void m()
  {
    if ((this.r != null) && (this.r.isAnonymous()))
      this.c.a(this.r.getId());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.x
 * JD-Core Version:    0.6.2
 */