package com.viber.voip.messages.controller;

import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import com.google.d.p;
import com.viber.dexshared.Logger;
import com.viber.jni.LocationInfo;
import com.viber.jni.PgGeneralQueryReplyDelegate;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CCheckAllowsM2MChatMsg;
import com.viber.jni.im2.CCheckAllowsM2MChatReplyMsg;
import com.viber.jni.im2.CCheckAllowsM2MChatReplyMsg.Receiver;
import com.viber.jni.im2.CCheckGroup2InviteMsg;
import com.viber.jni.im2.CCheckGroup2InviteReplyMsg;
import com.viber.jni.im2.CCheckGroup2InviteReplyMsg.Receiver;
import com.viber.jni.im2.CDeleteAllUserMessagesReplyMsg;
import com.viber.jni.im2.CDeleteAllUserMessagesReplyMsg.Receiver;
import com.viber.jni.im2.CGetCommonCommunitiesMsg;
import com.viber.jni.im2.CGetCommonCommunitiesReplyMsg;
import com.viber.jni.im2.CGetCommonCommunitiesReplyMsg.Receiver;
import com.viber.jni.im2.CGetDownloadDetailsMsg;
import com.viber.jni.im2.CGetDownloadDetailsReplyMsg;
import com.viber.jni.im2.CGetDownloadDetailsReplyMsg.Receiver;
import com.viber.jni.im2.CGetInviteLinksMsg;
import com.viber.jni.im2.CGetInviteLinksReplyMsg;
import com.viber.jni.im2.CGetInviteLinksReplyMsg.Receiver;
import com.viber.jni.im2.CGetMyCommunitySettingsMsg;
import com.viber.jni.im2.CGetMyCommunitySettingsReplyMsg;
import com.viber.jni.im2.CGetMyCommunitySettingsReplyMsg.Receiver;
import com.viber.jni.im2.CGroupBanUserMsg;
import com.viber.jni.im2.CGroupBanUserReplyMsg;
import com.viber.jni.im2.CGroupBanUserReplyMsg.Receiver;
import com.viber.jni.im2.CSendMessageMsg;
import com.viber.jni.im2.CUpdateMyCommunitySettingsMsg;
import com.viber.jni.im2.CUpdateMyCommunitySettingsReplyMsg;
import com.viber.jni.im2.CUpdateMyCommunitySettingsReplyMsg.Receiver;
import com.viber.jni.im2.DownloadDetails;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Location;
import com.viber.jni.im2.MediaObjectDetails;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.InviteCommunityInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.publicaccount.MyCommunitySettings;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.a;
import com.viber.voip.messages.a.c.c;
import com.viber.voip.messages.a.c.d;
import com.viber.voip.messages.a.c.e;
import com.viber.voip.messages.a.c.f;
import com.viber.voip.messages.a.c.h;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.ak.a;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.r;
import com.viber.voip.registration.af;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.SparseSet;
import com.viber.voip.util.cd;
import com.viber.voip.util.dg;
import com.viber.voip.util.u;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class a
  implements PgGeneralQueryReplyDelegate, ConnectionDelegate, CCheckAllowsM2MChatReplyMsg.Receiver, CCheckGroup2InviteReplyMsg.Receiver, CDeleteAllUserMessagesReplyMsg.Receiver, CGetCommonCommunitiesReplyMsg.Receiver, CGetDownloadDetailsReplyMsg.Receiver, CGetInviteLinksReplyMsg.Receiver, CGetMyCommunitySettingsReplyMsg.Receiver, CGroupBanUserReplyMsg.Receiver, CUpdateMyCommunitySettingsReplyMsg.Receiver
{
  private static final Logger a = ViberEnv.getLogger();
  private final SparseArrayCompat<Long> A = new SparseArrayCompat();
  private final SparseArrayCompat<CCheckAllowsM2MChatMsg> B = new SparseArrayCompat();
  private final SparseArrayCompat<CGetCommonCommunitiesMsg> C = new SparseArrayCompat();
  private final AtomicBoolean D = new AtomicBoolean();
  private final SparseArrayCompat<CGetInviteLinksMsg> E = new SparseArrayCompat();
  private final com.viber.voip.memberid.a.a F;
  private final Set<Integer> G = new HashSet();
  private final Map<Integer, a> H = new HashMap();
  private final dagger.a<com.viber.voip.notif.e.m> I;
  private final com.viber.voip.analytics.story.e.c J;
  private final ai K;
  private final Im2Exchanger b;
  private final PhoneController c;
  private final com.viber.voip.messages.d.j d;
  private final com.viber.voip.messages.d.b e;
  private final com.viber.voip.messages.controller.manager.o f;
  private final ab g;
  private final ak h;
  private final al i;
  private final Handler j;
  private final af k;
  private final com.viber.voip.flatbuffers.b.b<MyCommunitySettings> l;
  private final com.viber.voip.flatbuffers.b.a<MyCommunitySettings> m;
  private final dagger.a<com.google.d.f> n;
  private final com.viber.common.b.b o;
  private final dagger.a<bs> p;
  private final EventBus q;
  private final com.viber.voip.analytics.story.g.a r;
  private final dagger.a<com.viber.voip.model.a.d> s;
  private final com.viber.voip.flatbuffers.b.b<MsgInfo> t;
  private final GroupController u;
  private final LongSparseArray<Long> v = new LongSparseArray();
  private final Map<Integer, CGroupBanUserMsg> w = new HashMap();
  private final LongSparseSet x = new LongSparseSet();
  private final SparseSet y = new SparseSet();
  private final LongSparseArray<c> z = new LongSparseArray();

  public a(Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, com.viber.voip.messages.d.j paramj, com.viber.voip.messages.d.b paramb, com.viber.voip.messages.controller.manager.o paramo, ab paramab, dagger.a<bs> parama, ak paramak, al paramal, af paramaf, com.viber.voip.flatbuffers.b.b<MyCommunitySettings> paramb1, com.viber.voip.flatbuffers.b.a<MyCommunitySettings> parama1, dagger.a<com.google.d.f> parama2, com.viber.common.b.b paramb2, EventBus paramEventBus, Handler paramHandler, com.viber.voip.analytics.story.g.a parama3, dagger.a<com.viber.voip.model.a.d> parama4, com.viber.voip.flatbuffers.b.b<MsgInfo> paramb3, GroupController paramGroupController, dagger.a<com.viber.voip.notif.e.m> parama5, com.viber.voip.analytics.story.e.c paramc, ai paramai)
  {
    this.f = paramo;
    this.g = paramab;
    this.h = paramak;
    this.i = paramal;
    this.b = paramIm2Exchanger;
    this.c = paramPhoneController;
    this.d = paramj;
    this.e = paramb;
    this.j = paramHandler;
    this.k = paramaf;
    this.l = paramb1;
    this.m = parama1;
    this.n = parama2;
    this.o = paramb2;
    this.p = parama;
    this.q = paramEventBus;
    this.r = parama3;
    this.s = parama4;
    this.t = paramb3;
    this.u = paramGroupController;
    this.I = parama5;
    this.J = paramc;
    this.K = paramai;
    this.F = new com.viber.voip.memberid.a.a(this.j, true)
    {
      public void a()
      {
        com.viber.voip.memberid.d.b(a.a(a.this));
        a.b(a.this);
        a.c(a.this);
        a.d(a.this);
        a.e(a.this);
      }
    };
  }

  private <T> T a(SparseArrayCompat<T> paramSparseArrayCompat, int paramInt)
  {
    int i1 = paramSparseArrayCompat.indexOfKey(paramInt);
    if (i1 >= 0)
    {
      Object localObject = paramSparseArrayCompat.valueAt(i1);
      paramSparseArrayCompat.removeAt(i1);
      return localObject;
    }
    return null;
  }

  private void a(long paramLong, MyCommunitySettings paramMyCommunitySettings, boolean paramBoolean)
  {
    synchronized (this.z)
    {
      c localc = (c)this.z.get(paramLong);
      if ((localc == null) || (!localc.a.equals(paramMyCommunitySettings)))
      {
        if (localc != null)
          this.A.remove(localc.b);
        int i1 = this.c.generateSequence();
        this.z.put(paramLong, new c(paramMyCommunitySettings, i1));
        com.viber.voip.model.e.a(String.valueOf(paramLong), "key_not_synced_my_community_settings", true);
        String str = this.l.a(paramMyCommunitySettings);
        if (paramBoolean)
        {
          this.g.i(paramLong, str);
          com.viber.voip.model.entity.h localh = this.g.b(paramLong);
          if (localh != null)
            this.f.a(Collections.singleton(Long.valueOf(localh.getId())), 5, false, false);
        }
        CUpdateMyCommunitySettingsMsg localCUpdateMyCommunitySettingsMsg = new CUpdateMyCommunitySettingsMsg(i1, paramLong, str);
        this.A.append(i1, Long.valueOf(paramLong));
        this.b.handleCUpdateMyCommunitySettingsMsg(localCUpdateMyCommunitySettingsMsg);
        return;
      }
      return;
    }
  }

  private void a(CGroupBanUserReplyMsg paramCGroupBanUserReplyMsg, CGroupBanUserMsg paramCGroupBanUserMsg)
  {
    MessageEntity localMessageEntity1 = this.g.v(paramCGroupBanUserMsg.groupID);
    String str = this.k.l();
    if (localMessageEntity1 != null);
    for (int i1 = localMessageEntity1.getMessageGlobalId(); ; i1 = 0)
    {
      long l1 = paramCGroupBanUserMsg.groupID;
      long l2 = System.currentTimeMillis();
      long l3 = paramCGroupBanUserReplyMsg.messageToken;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramCGroupBanUserMsg.emid;
      MessageEntity localMessageEntity2 = com.viber.voip.messages.controller.c.c.a(l1, 5, l2, str, 80, l3, com.viber.voip.messages.j.a(str, arrayOfString), i1);
      ((bs)this.p.get()).a(localMessageEntity2);
      return;
    }
  }

  private void a(a parama)
  {
    MsgInfo localMsgInfo = new MsgInfo();
    InviteCommunityInfo localInviteCommunityInfo = new InviteCommunityInfo();
    localInviteCommunityInfo.setHasPersonalLink(true);
    localInviteCommunityInfo.setGroupId(parama.f());
    localInviteCommunityInfo.setIconId(parama.d());
    localInviteCommunityInfo.setCommunityName(parama.b());
    localInviteCommunityInfo.setCommunityDescription(parama.a());
    localInviteCommunityInfo.setParticipantsCount(parama.c());
    Iterator localIterator = parama.e().entrySet().iterator();
    int i4;
    for (int i1 = 0; localIterator.hasNext(); i1 = i4)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int i2 = this.c.generateSequence();
      localInviteCommunityInfo.setInviteLink((String)localEntry.getValue());
      localMsgInfo.setInviteCommunityInfo(localInviteCommunityInfo);
      String str1 = this.t.a(localMsgInfo);
      String str2 = (String)localEntry.getValue();
      b localb = new b();
      Application localApplication = ViberApplication.getApplication();
      int i3 = R.string.join_community_on_viber;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = (dg.b(parama.b()) + " " + str2);
      localb.b = localApplication.getString(i3, arrayOfObject);
      localb.a = ((String)localEntry.getKey());
      localb.c = str1;
      ((com.viber.voip.model.a.d)this.s.get()).a("sent_members_invite_category", String.valueOf(i2), ((com.google.d.f)this.n.get()).b(localb));
      Handler localHandler = this.j;
      f localf = new f(this, i2, localb);
      i4 = i1 + 50;
      localHandler.postDelayed(localf, i4);
    }
  }

  private void a(com.viber.voip.model.entity.h paramh, Map<String, ak.a> paramMap, List<x.a.a> paramList)
  {
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      x.a.a locala = (x.a.a)localIterator1.next();
      Member localMember = Member.from(locala);
      ak.a locala2 = (ak.a)paramMap.remove(locala.b());
      if (locala2 == null)
        this.d.a(paramh, 0, localMember, true);
      else
        this.e.a(locala2.a(), localMember);
    }
    if (!u.a(paramMap))
    {
      Iterator localIterator2 = paramMap.values().iterator();
      while (localIterator2.hasNext())
      {
        ak.a locala1 = (ak.a)localIterator2.next();
        this.g.a("participants", locala1.b(), "active", Integer.valueOf(1));
      }
      this.f.c(Collections.singleton(Long.valueOf(paramh.getId())), false);
    }
  }

  private void a(String paramString)
  {
    int i1 = this.c.generateSequence();
    Uri localUri = Uri.parse(paramString);
    if (localUri != null);
    for (String str = localUri.getQueryParameter("g2"); ; str = null)
    {
      if (str != null)
      {
        CCheckGroup2InviteMsg localCCheckGroup2InviteMsg = new CCheckGroup2InviteMsg(str, i1);
        this.G.add(Integer.valueOf(i1));
        this.b.handleCCheckGroup2InviteMsg(localCCheckGroup2InviteMsg);
      }
      return;
    }
  }

  private void b(int paramInt, long paramLong, String paramString)
  {
    CCheckAllowsM2MChatMsg localCCheckAllowsM2MChatMsg = new CCheckAllowsM2MChatMsg(paramInt, paramLong, paramString);
    synchronized (this.B)
    {
      this.B.put(paramInt, localCCheckAllowsM2MChatMsg);
      this.b.handleCCheckAllowsM2MChatMsg(localCCheckAllowsM2MChatMsg);
      return;
    }
  }

  private void b(int paramInt, b paramb)
  {
    this.b.handleCSendMessageMsg(new CSendMessageMsg(paramb.a, paramb.b, paramInt, Location.fromLegacyLocation(new LocationInfo(0, 0)), 0, 0L, new byte[0], 0, new byte[0], 0, 0, paramb.c, "", "", 0, 0, 8L));
  }

  private void b(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    this.j.post(new b(this, paramInt1, paramString, paramLong, paramInt2));
  }

  private void b(CGroupBanUserReplyMsg paramCGroupBanUserReplyMsg, CGroupBanUserMsg paramCGroupBanUserMsg)
  {
    r localr = this.g.d(paramCGroupBanUserMsg.groupID);
    if (localr != null)
      this.g.a(localr.getTable(), localr.getId(), "revision", Integer.valueOf(paramCGroupBanUserReplyMsg.groupRevision));
  }

  private void c()
  {
    com.viber.voip.memberid.d.a(this.F);
  }

  private void d()
  {
    List localList = com.viber.voip.model.e.a("key_not_synced_banned_users_list", true);
    if (!u.a(localList))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        a(Long.valueOf((String)localIterator.next()).longValue());
    }
  }

  private void e()
  {
    List localList = com.viber.voip.model.e.a("key_not_synced_my_community_settings", true);
    if (!u.a(localList))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        long l1 = Long.valueOf((String)localIterator.next()).longValue();
        r localr = this.g.d(l1);
        String str;
        if (localr != null)
        {
          str = localr.W();
          label69: if (str == null)
            break label112;
        }
        label112: for (MyCommunitySettings localMyCommunitySettings = (MyCommunitySettings)this.m.a(str); ; localMyCommunitySettings = null)
        {
          if (localMyCommunitySettings == null)
            break label118;
          a(l1, localMyCommunitySettings, false);
          break;
          str = null;
          break label69;
        }
        label118: com.viber.voip.model.e.a(String.valueOf(l1), new String[] { "key_not_synced_my_community_settings" });
      }
    }
  }

  private void f()
  {
    if (this.o.d())
      a();
  }

  private void g()
  {
    com.viber.voip.model.a.d locald = (com.viber.voip.model.a.d)this.s.get();
    Set localSet = locald.a("sent_members_invite_category");
    if (!localSet.isEmpty())
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = locald.e(str1);
        b localb = (b)((com.google.d.f)this.n.get()).a(str2, b.class);
        if (localb != null)
          try
          {
            b(Integer.valueOf(str1).intValue(), localb);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            locald.a("sent_members_invite_category", new String[] { str1 });
          }
        else
          locald.a("sent_members_invite_category", new String[] { str1 });
      }
    }
  }

  public void a()
  {
    this.j.post(new m(this));
  }

  public void a(int paramInt, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    this.j.post(new c(this, paramLong2, paramString, paramBoolean, paramLong1, paramInt));
  }

  public void a(int paramInt, long paramLong, String paramString)
  {
    this.j.post(new k(this, paramString, paramInt, paramLong));
  }

  public void a(int paramInt, String paramString)
  {
    this.j.post(new l(this, paramInt, paramString));
  }

  public void a(int paramInt, String paramString, long paramLong)
  {
    b(paramInt, paramString, paramLong, 0);
  }

  public void a(long paramLong)
  {
    this.j.post(new i(this, paramLong));
  }

  public void a(long paramLong, MyCommunitySettings paramMyCommunitySettings)
  {
    this.j.post(new j(this, paramLong, paramMyCommunitySettings));
  }

  public void a(long paramLong, GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    this.j.post(new d(this, paramArrayOfGroupMember, paramLong));
  }

  public void a(String paramString, long paramLong)
  {
    this.j.post(new e(this, paramString, paramLong));
  }

  public void a(String paramString1, String paramString2, String[] paramArrayOfString, Map<Long, Integer> paramMap)
  {
    this.j.post(new h(this, paramString2, paramString1, paramMap, paramArrayOfString));
  }

  public boolean a(int paramInt)
  {
    synchronized (this.w)
    {
      boolean bool = this.w.containsKey(Integer.valueOf(paramInt));
      return bool;
    }
  }

  public void b()
  {
    if (this.D.compareAndSet(false, true))
    {
      this.o.a(true);
      CGetMyCommunitySettingsMsg localCGetMyCommunitySettingsMsg = new CGetMyCommunitySettingsMsg(this.c.generateSequence());
      this.b.handleCGetMyCommunitySettingsMsg(localCGetMyCommunitySettingsMsg);
    }
  }

  public void b(int paramInt, String paramString, long paramLong)
  {
    b(paramInt, paramString, paramLong, 1);
  }

  public void b(long paramLong)
  {
    this.j.post(new g(this, paramLong));
  }

  public boolean b(int paramInt)
  {
    while (true)
    {
      synchronized (this.C)
      {
        if (this.C.indexOfKey(paramInt) >= 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public void c(int paramInt)
  {
    ((com.viber.voip.notif.e.m)this.I.get()).e(paramInt);
  }

  public void onCCheckAllowsM2MChatReplyMsg(CCheckAllowsM2MChatReplyMsg paramCCheckAllowsM2MChatReplyMsg)
  {
    synchronized (this.B)
    {
      CCheckAllowsM2MChatMsg localCCheckAllowsM2MChatMsg = (CCheckAllowsM2MChatMsg)a(this.B, paramCCheckAllowsM2MChatReplyMsg.seq);
      if (localCCheckAllowsM2MChatMsg != null)
        this.q.post(new c.c(paramCCheckAllowsM2MChatReplyMsg.seq, paramCCheckAllowsM2MChatReplyMsg.status));
      return;
    }
  }

  public void onCCheckGroup2InviteReplyMsg(CCheckGroup2InviteReplyMsg paramCCheckGroup2InviteReplyMsg)
  {
    if ((this.G.remove(Integer.valueOf(paramCCheckGroup2InviteReplyMsg.seq))) && (paramCCheckGroup2InviteReplyMsg.status == 0))
    {
      int i1 = this.c.generateSequence();
      this.u.a(i1, paramCCheckGroup2InviteReplyMsg.groupID, paramCCheckGroup2InviteReplyMsg.groupName, Uri.parse(paramCCheckGroup2InviteReplyMsg.iconDownloadID), paramCCheckGroup2InviteReplyMsg.tagLine, paramCCheckGroup2InviteReplyMsg.inviteToken, "", 3);
    }
  }

  public void onCDeleteAllUserMessagesReplyMsg(CDeleteAllUserMessagesReplyMsg paramCDeleteAllUserMessagesReplyMsg)
  {
    switch (paramCDeleteAllUserMessagesReplyMsg.status)
    {
    default:
    case 0:
    }
    Long localLong;
    do
    {
      return;
      localLong = (Long)this.v.get(paramCDeleteAllUserMessagesReplyMsg.seq);
    }
    while (localLong == null);
    ((bs)this.p.get()).a(localLong.longValue(), paramCDeleteAllUserMessagesReplyMsg.token, paramCDeleteAllUserMessagesReplyMsg.seqInPG);
    this.v.remove(paramCDeleteAllUserMessagesReplyMsg.seq);
  }

  public void onCGetCommonCommunitiesReplyMsg(CGetCommonCommunitiesReplyMsg paramCGetCommonCommunitiesReplyMsg)
  {
    while (true)
    {
      synchronized (this.C)
      {
        CGetCommonCommunitiesMsg localCGetCommonCommunitiesMsg = (CGetCommonCommunitiesMsg)a(this.C, paramCGetCommonCommunitiesReplyMsg.seq);
        if (localCGetCommonCommunitiesMsg != null)
        {
          if (paramCGetCommonCommunitiesReplyMsg.status == 0)
          {
            localList = this.g.a(paramCGetCommonCommunitiesReplyMsg.groups);
            this.q.post(new c.d(paramCGetCommonCommunitiesReplyMsg.seq, paramCGetCommonCommunitiesReplyMsg.status, localList));
          }
        }
        else
          return;
      }
      List localList = Collections.emptyList();
    }
  }

  public void onCGetDownloadDetailsReplyMsg(CGetDownloadDetailsReplyMsg paramCGetDownloadDetailsReplyMsg)
  {
    a locala = (a)this.H.remove(Integer.valueOf(paramCGetDownloadDetailsReplyMsg.seq));
    if (locala != null)
    {
      if ((paramCGetDownloadDetailsReplyMsg.status != 0) || (paramCGetDownloadDetailsReplyMsg.downloadDetailsList.length <= 0))
        break label93;
      locala.a(paramCGetDownloadDetailsReplyMsg.downloadDetailsList[0].downloadID);
      a(locala);
    }
    label93: for (int i1 = 1; ; i1 = 0)
    {
      EventBus localEventBus = this.q;
      int i2 = 0;
      if (i1 != 0);
      while (true)
      {
        localEventBus.post(new c.f(i2));
        return;
        i2 = 1;
      }
    }
  }

  public void onCGetInviteLinksReplyMsg(CGetInviteLinksReplyMsg paramCGetInviteLinksReplyMsg)
  {
    CGetInviteLinksMsg localCGetInviteLinksMsg = (CGetInviteLinksMsg)a(this.E, paramCGetInviteLinksReplyMsg.seq);
    if (localCGetInviteLinksMsg == null)
      return;
    com.viber.voip.model.entity.h localh;
    r localr;
    int i6;
    HashMap localHashMap;
    label143: label192: label225: String str1;
    int i2;
    int i1;
    label317: EventBus localEventBus;
    if (paramCGetInviteLinksReplyMsg.status == 0)
    {
      localh = this.g.b(localCGetInviteLinksMsg.groupID);
      if (localh != null)
      {
        localr = this.g.d(localh.k());
        if (localr != null)
        {
          int i4 = this.i.d(localh.getId()) + localr.j();
          int i5;
          int i8;
          String str2;
          String str3;
          if (cd.f(localh.p()))
          {
            i5 = 1;
            i6 = i4 - i5;
            localHashMap = new HashMap(localCGetInviteLinksMsg.memberIDs.length);
            boolean bool = u.a(paramCGetInviteLinksReplyMsg.inviteLinks);
            String[] arrayOfString = localCGetInviteLinksMsg.memberIDs;
            int i7 = arrayOfString.length;
            i8 = 0;
            if (i8 >= i7)
              break label225;
            str2 = arrayOfString[i8];
            if (!bool)
              break label192;
            str3 = paramCGetInviteLinksReplyMsg.groupInviteLink;
          }
          while (true)
          {
            localHashMap.put(str2, str3);
            i8++;
            break label143;
            i5 = 0;
            break;
            str3 = (String)paramCGetInviteLinksReplyMsg.inviteLinks.get(str2);
            if (TextUtils.isEmpty(str3))
              str3 = paramCGetInviteLinksReplyMsg.groupInviteLink;
          }
          Uri localUri = localh.q();
          if ((localUri != null) && (localUri.getPathSegments().size() > 1))
          {
            str1 = (String)localUri.getPathSegments().get(1);
            if (!com.viber.voip.util.upload.i.b(str1))
            {
              a(new a(localr.u(), localh.k(), localh.o(), i6, str1, paramCGetInviteLinksReplyMsg.groupInviteLink, localHashMap));
              i2 = 0;
              i1 = 1;
              if (i1 == 0)
                break label523;
              localEventBus = this.q;
              if (i2 == 0)
                break label525;
            }
          }
        }
      }
    }
    label523: label525: for (int i3 = 1; ; i3 = paramCGetInviteLinksReplyMsg.status)
    {
      localEventBus.post(new c.f(i3));
      return;
      if (TextUtils.isDigitsOnly(str1))
      {
        long l1 = Long.parseLong(str1);
        int i9 = this.c.generateSequence();
        CGetDownloadDetailsMsg localCGetDownloadDetailsMsg = new CGetDownloadDetailsMsg(i9, new MediaObjectDetails[] { new MediaObjectDetails(l1, 1, 3) });
        this.H.put(Integer.valueOf(i9), new a(localr.u(), localh.k(), localh.o(), i6, "", paramCGetInviteLinksReplyMsg.groupInviteLink, localHashMap));
        this.b.handleCGetDownloadDetailsMsg(localCGetDownloadDetailsMsg);
        i2 = 0;
        i1 = 0;
        break label317;
      }
      i2 = 1;
      i1 = 1;
      break label317;
      a(new a(localr.u(), localh.k(), localh.o(), i6, "", paramCGetInviteLinksReplyMsg.groupInviteLink, localHashMap));
      i1 = 1;
      i2 = 0;
      break label317;
      break;
    }
  }

  public void onCGetMyCommunitySettingsReplyMsg(CGetMyCommunitySettingsReplyMsg paramCGetMyCommunitySettingsReplyMsg)
  {
    if (paramCGetMyCommunitySettingsReplyMsg.status == 0);
    try
    {
      Type localType = new com.google.d.c.a()
      {
      }
      .getType();
      localMap = (Map)((com.google.d.f)this.n.get()).a(paramCGetMyCommunitySettingsReplyMsg.settings, localType);
      if (!u.a(localMap))
      {
        HashSet localHashSet = new HashSet(com.viber.voip.model.e.a("key_not_synced_my_community_settings", true));
        Set localSet = localMap.entrySet();
        LongSparseSet localLongSparseSet = new LongSparseSet();
        this.g.a(new o(this, localSet, localHashSet, localLongSparseSet));
        if (!localLongSparseSet.isEmpty())
          this.f.a(this.g.b(localLongSparseSet), 5, false, false);
      }
      this.o.a(false);
      this.D.set(false);
      return;
    }
    catch (p localp)
    {
      while (true)
        Map localMap = null;
    }
  }

  public void onCGroupBanUserReplyMsg(CGroupBanUserReplyMsg paramCGroupBanUserReplyMsg)
  {
    while (true)
    {
      synchronized (this.w)
      {
        CGroupBanUserMsg localCGroupBanUserMsg = (CGroupBanUserMsg)this.w.remove(Integer.valueOf(paramCGroupBanUserReplyMsg.seq));
        if (localCGroupBanUserMsg != null)
        {
          if (paramCGroupBanUserReplyMsg.status == 0)
          {
            if (localCGroupBanUserMsg.type != 0)
              break label244;
            bool1 = true;
            com.viber.voip.model.entity.h localh = this.g.b(localCGroupBanUserMsg.groupID);
            Member localMember = new Member(localCGroupBanUserMsg.emid, null, null, null, null, null, localCGroupBanUserMsg.emid);
            boolean bool2 = this.d.a(localh, 0, localMember, bool1);
            b(paramCGroupBanUserReplyMsg, localCGroupBanUserMsg);
            if (bool1)
            {
              if (localh != null)
                this.d.a(localCGroupBanUserMsg.groupID, paramCGroupBanUserReplyMsg.numWatchers, localh.getId());
              if (bool2)
                a(paramCGroupBanUserReplyMsg, localCGroupBanUserMsg);
            }
          }
          this.q.post(new c.a(paramCGroupBanUserReplyMsg.seq, localCGroupBanUserMsg.type, paramCGroupBanUserReplyMsg.status));
          if ((paramCGroupBanUserReplyMsg.status == 0) && (localCGroupBanUserMsg.type == 0))
          {
            com.viber.voip.messages.controller.manager.o localo = this.f;
            long l1 = localCGroupBanUserMsg.groupID;
            String[] arrayOfString = new String[1];
            arrayOfString[0] = localCGroupBanUserMsg.emid;
            localo.a(l1, 0, arrayOfString, null);
          }
        }
        return;
      }
      label244: boolean bool1 = false;
    }
  }

  public void onCUpdateMyCommunitySettingsReplyMsg(CUpdateMyCommunitySettingsReplyMsg paramCUpdateMyCommunitySettingsReplyMsg)
  {
    int i1 = this.A.indexOfKey(paramCUpdateMyCommunitySettingsReplyMsg.seq);
    if (i1 < 0)
      return;
    long l1 = ((Long)this.A.valueAt(i1)).longValue();
    this.A.removeAt(i1);
    synchronized (this.z)
    {
      this.z.remove(l1);
      switch (paramCUpdateMyCommunitySettingsReplyMsg.status)
      {
      case 1:
      case 2:
      default:
        return;
      case 0:
      case 3:
      }
      com.viber.voip.model.e.a(String.valueOf(l1), new String[] { "key_not_synced_my_community_settings" });
      return;
    }
  }

  public void onConnect()
  {
    c();
  }

  public void onConnectionStateChange(int paramInt)
  {
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onGetInvitationMemberMessage(c.e parame)
  {
    int i1 = 1;
    if (parame.d);
    while (true)
    {
      if (i1 != 0)
      {
        a(parame.b);
        this.J.a(parame.a, "Added by Member");
      }
      return;
      if (parame.c <= 0L)
        if (!TextUtils.isEmpty(parame.e))
        {
          com.viber.voip.model.entity.h localh = this.g.a(parame.e, false);
          if ((localh == null) || (!localh.i(5)))
            i1 = 0;
        }
        else
        {
          i1 = 0;
        }
    }
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onMiddleStateCommunityCreated(c.h paramh)
  {
    com.viber.voip.model.entity.m localm = this.e.b(paramh.a);
    if (localm != null)
    {
      String str = dg.b(localm, 5, 3);
      ((com.viber.voip.notif.e.m)this.I.get()).a(com.viber.voip.notif.h.c.a(paramh.b), str);
    }
  }

  public void onPGGeneralQueryReply(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    if (!this.y.contains(paramInt1));
    do
    {
      return;
      this.y.remove(paramInt1);
      this.x.remove(paramLong);
    }
    while (paramInt2 != 0);
    try
    {
      localx = (x)((com.google.d.f)this.n.get()).a(paramString, x.class);
      if ((localx != null) && (localx.a() == 0) && (localx.b() != null))
      {
        localList = localx.b().a();
        if (!u.a(localList))
        {
          com.viber.voip.model.entity.h localh = this.g.b(paramLong);
          if (localh != null)
            this.g.a(new n(this, localh, localList));
        }
        com.viber.voip.model.e.a(String.valueOf(paramLong), new String[] { "key_not_synced_banned_users_list" });
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        x localx = null;
        continue;
        List localList = null;
      }
    }
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onRefreshData(com.viber.voip.messages.a.k paramk)
  {
    if (this.g.E() > 0L)
      b();
  }

  private class a
  {
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private Map<String, String> g;
    private long h;

    public a(long arg2, String paramInt, int paramString2, String paramString3, String paramMap, Map<String, String> arg8)
    {
      this.b = ???;
      this.h = paramString1;
      this.c = paramString2;
      this.d = paramString3;
      this.e = paramMap;
      Object localObject1;
      this.f = localObject1;
      Object localObject2;
      this.g = localObject2;
    }

    public String a()
    {
      return this.b;
    }

    public void a(String paramString)
    {
      this.e = paramString;
    }

    public String b()
    {
      return this.c;
    }

    public int c()
    {
      return this.d;
    }

    public String d()
    {
      return this.e;
    }

    public Map<String, String> e()
    {
      return this.g;
    }

    public long f()
    {
      return this.h;
    }
  }

  private class b
  {

    @com.google.d.a.c(a="memberId")
    public String a;

    @com.google.d.a.c(a="text")
    public String b;

    @com.google.d.a.c(a="rawMsgInfo")
    public String c;

    public b()
    {
    }
  }

  private class c
  {
    final MyCommunitySettings a;
    final int b;

    c(MyCommunitySettings paramInt, int arg3)
    {
      this.a = paramInt;
      int i;
      this.b = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.a
 * JD-Core Version:    0.6.2
 */