package com.viber.voip.messages.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.jni.CGroupMessageData;
import com.viber.jni.CGroupMessageStatus;
import com.viber.jni.CGroupMessageStatus.CReadData;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.group.GroupAssignRoleListener;
import com.viber.jni.im2.CGroupAddWatchersMsg;
import com.viber.jni.im2.CUpdateCommunityPrivilegesMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.like.LikeController;
import com.viber.jni.messenger.GroupMessageStatusListener;
import com.viber.jni.publicgroup.PublicGroupController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.d.n;
import com.viber.voip.av.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.d.j.a;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.model.e;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.Background;
import com.viber.voip.settings.d.af;
import com.viber.voip.settings.d.ap;
import com.viber.voip.settings.d.i;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.ar;
import com.viber.voip.util.at;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.util.upload.t;
import com.viber.voip.util.upload.t.c;
import com.viber.voip.util.upload.t.d;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class af
  implements GroupController
{
  private static final Logger a = ViberEnv.getLogger();
  private bv.t A;
  private GroupAssignRoleListener B;
  private GroupMessageStatusListener C;
  private final com.viber.voip.analytics.story.g.a D;
  private final com.viber.voip.analytics.story.e.c E;
  private final Context b;
  private ab c;
  private dagger.a<bs> d;
  private final al e;
  private final SparseArray<PublicAccount> f = new SparseArray();
  private final SparseArray<Pair<Integer, PublicAccount>> g = new SparseArray();
  private final SparseArray<b> h = new SparseArray();
  private final LongSparseSet i = new LongSparseSet();
  private Map<Long, String> j = new ar();
  private final SparseArray<GroupController.GroupBaseDescription> k = new SparseArray();
  private final Set<Integer> l = Collections.synchronizedSet(new HashSet());
  private o m;
  private final EventBus n;
  private final com.viber.voip.messages.d.j o;
  private final PublicGroupController p;
  private final com.viber.jni.group.GroupController q;
  private final LikeController r;
  private final PhoneController s;
  private final Im2Exchanger t;
  private com.viber.voip.messages.controller.publicaccount.d u;
  private Map<Integer, cf> v = new HashMap();
  private Map<Integer, cf> w = new LinkedHashMap();
  private Set<Long> x = new HashSet();
  private Map<Integer, CGroupMessageData> y = new HashMap();
  private Map<Integer, String> z = new HashMap();

  public af(Context paramContext, EventBus paramEventBus, com.viber.voip.messages.d.j paramj, al paramal, dagger.a<bs> parama, ab paramab, o paramo, Engine paramEngine, com.viber.voip.analytics.story.g.a parama1, com.viber.voip.analytics.story.e.c paramc)
  {
    this.b = paramContext;
    this.d = parama;
    this.e = paramal;
    this.c = paramab;
    this.m = paramo;
    this.n = paramEventBus;
    this.o = paramj;
    this.p = paramEngine.getPublicGroupController();
    this.r = paramEngine.getLikeController();
    this.q = paramEngine.getGroupController();
    this.s = paramEngine.getPhoneController();
    this.t = paramEngine.getExchanger();
    this.m.a(new bv.d()
    {
      public void onOpenPublicGroup(long paramAnonymousLong, Set<Long> paramAnonymousSet)
      {
        if (paramAnonymousLong > 0L)
        {
          com.viber.voip.model.entity.r localr = af.a(af.this).d(paramAnonymousLong);
          if (localr != null)
          {
            af.a(af.this, localr);
            af.this.a(localr);
          }
        }
      }
    });
    this.D = parama1;
    this.E = paramc;
  }

  private void a()
  {
    com.viber.voip.publicaccount.a.a locala = ViberApplication.getInstance().getMessagesManager().r();
    n localn = locala.d();
    if ((localn != null) && (!locala.b(localn.b(), 3)))
    {
      com.viber.voip.banner.a.a.g localg = new com.viber.voip.banner.a.a.g(0);
      String str1 = localn.d();
      String str2 = localg.c().toString();
      String str3 = localg.a(str1).toString();
      locala.e().a(new String[] { str2, str3 });
      locala.a(localn.b(), 3);
    }
  }

  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, PublicAccount paramPublicAccount)
  {
    if ((0x4 & paramPublicAccount.getFlags()) != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.q.handleChangePublicAccount(paramPublicAccount.getGroupID(), paramPublicAccount.getName(), paramLong1, paramLong2, paramPublicAccount.getTagLines(), paramPublicAccount.getTags(), paramPublicAccount.getLocation(), paramPublicAccount.getCountryCode(), paramInt2, paramPublicAccount.getRevision(), paramInt1, bool, paramPublicAccount.getCategoryId(), paramPublicAccount.getSubCategoryId(), paramPublicAccount.getWebsite(), paramPublicAccount.getEmail(), 0);
      return;
    }
  }

  private void a(int paramInt1, long paramLong, GroupController.GroupMember[] paramArrayOfGroupMember, int paramInt2, int paramInt3)
  {
    String[] arrayOfString = a(paramArrayOfGroupMember);
    this.q.handleGroupAddMembers(paramLong, paramInt1, arrayOfString, paramInt2, paramInt3);
  }

  private void a(int paramInt, b paramb)
  {
    synchronized (this.h)
    {
      this.h.put(paramInt, paramb);
      return;
    }
  }

  private void a(int paramInt, cf paramcf)
  {
    boolean bool = this.v.containsValue(paramcf);
    if ((!bool) && (!this.x.contains(Long.valueOf(paramcf.a))))
    {
      this.x.add(Long.valueOf(paramcf.a));
      this.v.put(Integer.valueOf(paramInt), paramcf);
      this.p.handleGetPublicGroupMessages(paramInt, paramcf.a, paramcf.b);
      return;
    }
    if ((!bool) && (!this.w.containsValue(paramcf)))
    {
      this.w.put(Integer.valueOf(paramInt), paramcf);
      o.a().d(paramInt, paramcf.a, paramcf.b);
      return;
    }
    o.a().b(paramInt);
  }

  private void a(int paramInt, String paramString1, long paramLong1, String paramString2, Uri paramUri, String paramString3, long paramLong2, com.viber.voip.messages.controller.publicaccount.ae paramae, String paramString4)
  {
    PublicAccount localPublicAccount = new PublicAccount();
    localPublicAccount.setName(paramString1);
    localPublicAccount.setGroupID(paramLong1);
    localPublicAccount.setGroupRole(3);
    localPublicAccount.setGroupUri(paramString2);
    localPublicAccount.setIcon(paramUri);
    localPublicAccount.setPublicAccountId(paramString4);
    bs.e locale = bs.e.a().a();
    bs.f localf = ((bs)this.d.get()).a(paramInt, paramLong1, 3, Pair.create(paramString3, Long.valueOf(paramLong2)), localPublicAccount, System.currentTimeMillis(), locale);
    localf.f.g(3);
    this.c.b(localf.f);
    a(paramLong1, paramInt, paramString3, paramLong2, 0);
    com.viber.voip.analytics.g localg = com.viber.voip.analytics.g.a();
    localg.a(com.viber.voip.analytics.a.i.f(paramString2));
    localg.a(com.viber.voip.analytics.a.i.g(paramString2));
    if (com.viber.voip.messages.controller.publicaccount.ae.f.equals(paramae))
      a();
  }

  private boolean a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.s.handleGetPublicAccountInfoChatId(paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
  }

  private boolean a(int paramInt, String paramString)
  {
    return this.s.handleGetPublicAccountInfoChatUri(paramInt, paramString);
  }

  private boolean a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.s.handleGetPublicAccountInfoAccountId(paramInt1, paramString, 3, paramInt3, paramInt4);
  }

  private boolean a(long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2)
  {
    this.t.handleCGroupAddWatchersMsg(new CGroupAddWatchersMsg(paramLong1, paramInt1, true, new String[0], paramString, paramLong2, paramInt2));
    return true;
  }

  private String[] a(GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    String[] arrayOfString = new String[paramArrayOfGroupMember.length];
    for (int i1 = 0; i1 < paramArrayOfGroupMember.length; i1++)
      arrayOfString[i1] = paramArrayOfGroupMember[i1].mMID;
    return arrayOfString;
  }

  private com.viber.voip.messages.controller.publicaccount.d b()
  {
    if (this.u == null)
      this.u = ViberApplication.getInstance().getMessagesManager().h();
    return this.u;
  }

  private void b(com.viber.voip.model.entity.r paramr)
  {
    com.viber.voip.model.entity.h localh;
    if (TextUtils.isEmpty(paramr.b()))
    {
      localh = this.c.b(paramr.a());
      if (localh != null);
    }
    else
    {
      return;
    }
    a(this.s.generateSequence(), localh.k(), null, paramr.e(), localh.j(), localh.p());
  }

  private void e(long paramLong)
  {
    synchronized (this.i)
    {
      this.i.add(paramLong);
      return;
    }
  }

  private void f(long paramLong)
  {
    Iterator localIterator = this.w.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((cf)localEntry.getValue()).a == paramLong)
      {
        this.w.remove(localEntry.getKey());
        a(((Integer)localEntry.getKey()).intValue(), (cf)localEntry.getValue());
      }
    }
  }

  public void a(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2)
  {
    ViberApplication.getInstance().getLocationManager().a(1, paramDouble1, paramDouble2, true, false, new ag(this, paramLong1, paramLong2));
  }

  public void a(final int paramInt1, final int paramInt2, final PublicAccount paramPublicAccount)
  {
    this.m.a(paramInt1);
    while (true)
    {
      final long[] arrayOfLong;
      synchronized (this.g)
      {
        this.g.put(paramInt1, new Pair(Integer.valueOf(paramInt2), paramPublicAccount));
        final HashSet localHashSet = new HashSet();
        arrayOfLong = new long[2];
        com.viber.voip.util.upload.q local3 = new com.viber.voip.util.upload.q()
        {
          public void a(Uri paramAnonymousUri, com.viber.voip.util.upload.r paramAnonymousr)
          {
            if (localHashSet.remove(paramAnonymousUri))
            {
              if (paramAnonymousUri != paramPublicAccount.getIcon())
                break label92;
              arrayOfLong[0] = paramAnonymousr.a.toLong();
              paramPublicAccount.setIconObjectId(paramAnonymousr.a);
            }
            while (true)
            {
              if (localHashSet.isEmpty())
                af.a(af.this, paramInt1, paramInt2, arrayOfLong[0], arrayOfLong[1], paramPublicAccount);
              return;
              label92: paramPublicAccount.getBackground().setObjectId(paramAnonymousr.a);
              at.a(paramAnonymousUri, paramAnonymousr.a, af.b(af.this));
              arrayOfLong[1] = paramAnonymousr.a.toLong();
            }
          }

          public void a(Uri paramAnonymousUri, t.c paramAnonymousc)
          {
            af.c(af.this).a(paramInt1, paramPublicAccount.getGroupID(), 7, paramInt2);
            af.this.h(paramInt1);
          }
        };
        if ((paramInt2 & 0x2) != 0)
        {
          if (paramPublicAccount.getIcon() != null)
          {
            localHashSet.add(paramPublicAccount.getIcon());
            t.a(t.d.d, paramPublicAccount.getIcon(), false, local3);
          }
        }
        else
        {
          if ((paramInt2 & 0x4) != 0)
          {
            if (!paramPublicAccount.getBackground().needUploadToServer())
              break label208;
            Uri localUri = Uri.parse(paramPublicAccount.getBackground().getUri());
            localHashSet.add(localUri);
            t.a(t.d.f, localUri, false, local3);
          }
          if (localHashSet.isEmpty())
            a(paramInt1, paramInt2, arrayOfLong[0], arrayOfLong[1], paramPublicAccount);
          return;
        }
      }
      if (5 == paramPublicAccount.getPublicGroupType())
      {
        arrayOfLong[0] = 0L;
        continue;
        label208: arrayOfLong[1] = paramPublicAccount.getBackground().getObjectId().toLong();
      }
    }
  }

  public void a(int paramInt, long paramLong)
  {
    e.a(String.valueOf(paramLong), "key_not_synced_group", true);
    this.q.handleGetGroupInfo(paramInt, paramLong);
  }

  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (cj.b(ViberApplication.getApplication()))
    {
      if (this.A == null)
      {
        this.A = new bv.t()
        {
          public void onPublicGroupSyncFinished(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
          {
            cf localcf = (cf)af.h(af.this).remove(Integer.valueOf(paramAnonymousInt1));
            if (localcf != null)
            {
              af.i(af.this).remove(Long.valueOf(localcf.a));
              af.a(af.this, localcf.a);
            }
          }
        };
        o.a().a(this.A);
      }
      if ((!paramBoolean) || (!d.af.c.d()) || (cj.a(ViberApplication.getApplication()).a() == 1))
        a(paramInt1, new cf(paramLong, paramInt2));
    }
  }

  public void a(final int paramInt, final long paramLong, Uri paramUri)
  {
    c(paramInt);
    if (paramUri == null)
    {
      this.k.put(paramInt, GroupController.GroupBaseDescription.fromIcon(ObjectId.EMPTY));
      ViberApplication.getInstance().getEngine(true).getPhoneController().handleChangeGroup(paramLong, "", 0L, 2, paramInt);
      return;
    }
    t.a(t.d.e, paramUri, false, new com.viber.voip.util.upload.q()
    {
      private void a()
      {
        o.a().b(paramInt, paramLong, 7);
        af.g(af.this).remove(Integer.valueOf(paramInt));
      }

      private void b(Uri paramAnonymousUri, com.viber.voip.util.upload.r paramAnonymousr)
      {
        at.a(paramAnonymousUri, paramAnonymousr.a, af.b(af.this), false);
        Engine localEngine = ViberApplication.getInstance().getEngine(true);
        af.f(af.this).put(paramInt, GroupController.GroupBaseDescription.fromIcon(paramAnonymousr.a));
        localEngine.getPhoneController().handleChangeGroup(paramLong, "", paramAnonymousr.a.toLong(), 2, paramInt);
      }

      public void a(Uri paramAnonymousUri, com.viber.voip.util.upload.r paramAnonymousr)
      {
        if (paramAnonymousUri != null)
        {
          b(paramAnonymousUri, paramAnonymousr);
          return;
        }
        a();
      }

      public void a(Uri paramAnonymousUri, t.c paramAnonymousc)
      {
        a();
      }
    });
  }

  public void a(int paramInt, long paramLong, String paramString)
  {
    this.m.a(paramInt);
    c(paramInt);
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    this.k.put(paramInt, GroupController.GroupBaseDescription.fromName(paramString));
    localEngine.getPhoneController().handleChangeGroup(paramLong, paramString, 0L, 1, paramInt);
  }

  public void a(int paramInt1, long paramLong, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramLong <= 0L) && (TextUtils.isEmpty(paramString)));
    com.viber.voip.model.entity.r localr;
    do
    {
      return;
      boolean bool = paramLong < 0L;
      localr = null;
      if (bool)
      {
        e.a(String.valueOf(paramLong), "key_not_synced_public_group", true);
        localr = this.c.d(paramLong);
      }
      if ((localr == null) && (!TextUtils.isEmpty(paramString)))
        localr = this.c.a(paramString);
    }
    while (localr == null);
    int i1 = Math.max(paramInt2, localr.e());
    if (m.b(paramInt3))
    {
      a(paramInt1, paramLong, paramInt4, i1, 3);
      return;
    }
    if ((paramLong > 0L) && ((paramInt3 == 2) || ((paramInt3 == 3) && (i1 > localr.e()))))
    {
      a(paramInt1, paramLong, paramInt4, i1, 1);
      return;
    }
    if ((!TextUtils.isEmpty(localr.d())) && (paramInt4 == 3))
    {
      a(paramInt1, localr.d());
      return;
    }
    a(paramInt1, paramString, paramInt4, i1, 1);
  }

  public void a(int paramInt1, long paramLong1, String paramString1, Uri paramUri, String paramString2, long paramLong2, String paramString3, int paramInt2)
  {
    a(paramInt1, paramLong1, paramString1, paramUri, paramString2, paramLong2, paramString3, false, paramInt2);
  }

  public void a(int paramInt1, long paramLong1, String paramString1, Uri paramUri, String paramString2, long paramLong2, String paramString3, boolean paramBoolean, int paramInt2)
  {
    com.viber.voip.model.entity.h localh = this.c.b(paramLong1);
    if ((localh == null) || (localh.K()))
    {
      PublicAccount localPublicAccount = new PublicAccount();
      localPublicAccount.setGroupID(paramLong1);
      localPublicAccount.setGroupRole(3);
      localPublicAccount.setIcon(paramUri);
      localPublicAccount.setName(paramString1);
      localPublicAccount.setTagLines(paramString2);
      a(paramInt1, new b(localPublicAccount, paramLong2, paramString3));
      if (paramBoolean)
        e(paramLong1);
      a(paramLong1, paramInt1, paramString3, paramLong2, paramInt2);
      return;
    }
    this.m.b(paramInt1, paramLong1, localh.j(), 2);
  }

  public void a(int paramInt, long paramLong1, String paramString1, String paramString2, Uri paramUri, long paramLong2, String paramString3, boolean paramBoolean, com.viber.voip.messages.controller.publicaccount.ae paramae)
  {
    if (paramBoolean)
    {
      ViberApplication localViberApplication = ViberApplication.getInstance();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = TermsAndConditionsActivity.class.getName();
      if (!localViberApplication.isActivityOnForeground(arrayOfString))
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putSerializable("follow_source", paramae);
        com.viber.voip.ui.dialogs.r.b(paramInt, -1L, paramLong1, null, paramString1, paramString2, paramLong2, paramString3, TermsAndConditionsActivity.a.d, null).a(localBundle2).d();
        return;
      }
    }
    com.viber.voip.model.entity.h localh = this.c.b(paramLong1);
    if ((d.ap.b.d()) && ((localh == null) || (localh.p() != 2)))
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putSerializable("follow_source", paramae);
      com.viber.voip.ui.dialogs.r.a(paramInt, -1L, paramLong1, null, paramString1, paramString2, paramLong2, paramString3, TermsAndConditionsActivity.a.c, null).a(localBundle1).d();
      return;
    }
    if ((localh == null) || (localh.j() == 3) || (localh.K()))
    {
      a(paramInt, paramString2, paramLong1, paramString1, paramUri, paramString3, paramLong2, paramae, null);
      return;
    }
    this.m.b(paramInt, paramLong1, localh.j(), 2);
  }

  public void a(int paramInt, long paramLong1, String paramString1, String paramString2, Uri paramUri, String paramString3, long paramLong2, String paramString4, boolean paramBoolean, com.viber.voip.messages.controller.publicaccount.ae paramae)
  {
    String str = com.viber.voip.api.scheme.i.a(paramString3);
    if (paramBoolean)
    {
      ViberApplication localViberApplication = ViberApplication.getInstance();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = TermsAndConditionsActivity.class.getName();
      if (localViberApplication.isActivityOnForeground(arrayOfString));
    }
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putSerializable("follow_source", paramae);
      com.viber.voip.ui.dialogs.r.b(paramInt, -1L, paramLong1, paramString3, paramString1, paramString2, paramLong2, paramString4, TermsAndConditionsActivity.a.g, str).a(localBundle1).d();
      return;
    }
    com.viber.voip.model.entity.h localh = this.c.b(paramLong1);
    if ((d.ap.b.d()) && ((localh == null) || (localh.p() != 2)))
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putSerializable("follow_source", paramae);
      com.viber.voip.ui.dialogs.r.a(paramInt, -1L, paramLong1, paramString3, paramString1, paramString2, paramLong2, paramString4, TermsAndConditionsActivity.a.g, str).a(localBundle2).d();
      return;
    }
    if ((localh == null) || (localh.j() == 3) || (localh.K()))
    {
      a(paramInt, paramString2, paramLong1, paramString1, paramUri, paramString4, paramLong2, paramae, paramString3);
      b().a(paramString3, true);
      return;
    }
    this.m.b(paramInt, paramLong1, localh.j(), 2);
  }

  public void a(int paramInt, long paramLong, GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    a(paramInt, paramLong, paramArrayOfGroupMember, 1);
  }

  public void a(int paramInt1, long paramLong, GroupController.GroupMember[] paramArrayOfGroupMember, int paramInt2)
  {
    com.viber.voip.model.entity.h localh = this.c.b(paramLong);
    if (localh == null)
      this.m.a(paramInt1, paramLong, 0, null);
    do
    {
      return;
      int i1 = this.e.d(localh.getId());
      if (!cd.j(localh.j(), i1))
        break;
      a(paramInt1, paramLong, paramArrayOfGroupMember, localh.ah(), paramInt2);
    }
    while (!localh.c());
    com.viber.voip.analytics.story.g.a locala = this.D;
    String str1 = com.viber.voip.util.ae.b();
    int i2 = paramArrayOfGroupMember.length;
    long l1 = localh.k();
    String str2 = localh.o();
    if (localh.q() != null);
    for (boolean bool = true; ; bool = false)
    {
      locala.a(str1, i2, l1, str2, bool, null, null);
      return;
    }
    this.m.a(paramInt1, paramLong, 3, null);
  }

  public void a(int paramInt, PublicAccount paramPublicAccount)
  {
    synchronized (this.f)
    {
      this.f.put(paramInt, paramPublicAccount);
      return;
    }
  }

  public void a(final int paramInt, final PublicAccount paramPublicAccount, final String[] paramArrayOfString)
  {
    a(paramInt, paramPublicAccount);
    Uri localUri = paramPublicAccount.getIcon();
    if (localUri != null)
    {
      t.a(t.d.d, localUri, false, new a(paramInt, paramInt)
      {
        public void a(Uri paramAnonymousUri, com.viber.voip.util.upload.r paramAnonymousr)
        {
          String str = d.i.g.d().replace("c", "");
          long[] arrayOfLong = new long[1];
          af.d(af.this).shortenStandardBackgroundID(str, arrayOfLong);
          af.e(af.this).handleCreatePublicAccount(paramInt, paramPublicAccount.getGroupUri(), paramPublicAccount.getLocation(), paramPublicAccount.getCountryCode(), paramPublicAccount.getName(), paramAnonymousr.a.toLong(), paramPublicAccount.getTags(), paramArrayOfString, paramPublicAccount.getTagLines(), arrayOfLong[0], paramPublicAccount.isAgeRestricted(), paramPublicAccount.getCategoryId(), paramPublicAccount.getSubCategoryId(), paramPublicAccount.getWebsite(), paramPublicAccount.getEmail());
        }
      });
      return;
    }
    j(paramInt);
    this.m.b(paramInt, 1);
  }

  public void a(int paramInt, String paramString, GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(a(paramArrayOfGroupMember)));
    String str1 = ViberApplication.getInstance().getUserManager().getRegistrationValues().l();
    localArrayList.add(str1);
    long l1 = this.c.a(localArrayList);
    if (l1 > 0L)
    {
      this.n.post(new com.viber.voip.messages.a.a.a(paramInt, l1));
      return;
    }
    com.viber.provider.b localb = ab.f();
    localb.a();
    try
    {
      bs.f localf = ((bs)this.d.get()).a(paramString, System.currentTimeMillis());
      long l2 = localf.f.getId();
      j.a[] arrayOfa = new j.a[paramArrayOfGroupMember.length];
      for (int i1 = 0; i1 < paramArrayOfGroupMember.length; i1++)
        arrayOfa[i1] = new j.a(Member.from(paramArrayOfGroupMember[i1]), 1);
      this.o.a(l2, arrayOfa);
      MessageEntity localMessageEntity = com.viber.voip.messages.controller.c.c.a(0L, 4, System.currentTimeMillis(), str1, 16, 0L, com.viber.voip.messages.j.f(str1), 0);
      localMessageEntity.setConversationId(l2);
      ((bs)this.d.get()).a(localMessageEntity);
      localb.c();
      localb.b();
      if (localf.f != null)
      {
        String str2 = String.valueOf(localf.f.getId());
        this.E.a(str2, "Create Chat Icon", 1 + paramArrayOfGroupMember.length);
        this.E.b(str2, localf.f, com.viber.voip.util.ae.b());
      }
      this.n.post(new com.viber.voip.messages.a.a.a(paramInt, l2));
      this.m.a(Collections.singleton(Long.valueOf(l2)), 4, false, true);
      return;
    }
    finally
    {
      localb.b();
    }
  }

  public void a(final int paramInt, final String paramString1, final GroupController.GroupMember[] paramArrayOfGroupMember, final String paramString2, Uri paramUri)
  {
    PublicAccount localPublicAccount = new PublicAccount();
    localPublicAccount.setIcon(paramUri);
    localPublicAccount.setName(paramString1);
    localPublicAccount.setTagLines(paramString2);
    localPublicAccount.setDisplayInvitationLink(true);
    a(paramInt, localPublicAccount);
    if (paramUri != null)
    {
      t.a(t.d.d, paramUri, false, new a(paramInt, paramInt)
      {
        public void a(Uri paramAnonymousUri, com.viber.voip.util.upload.r paramAnonymousr)
        {
          af.d(af.this).handleCreateGroup2(paramInt, af.a(af.this, paramArrayOfGroupMember), paramString1, paramAnonymousr.a.toLong(), paramString2);
        }
      });
      return;
    }
    this.s.handleCreateGroup2(paramInt, a(paramArrayOfGroupMember), paramString1, 0L, paramString2);
  }

  public void a(int paramInt, boolean paramBoolean, String paramString, Uri paramUri, GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    String[] arrayOfString = a(paramArrayOfGroupMember);
    ArrayList localArrayList = new ArrayList(Arrays.asList(arrayOfString));
    localArrayList.add(ViberApplication.getInstance().getUserManager().getRegistrationValues().l());
    long l1 = this.c.a(localArrayList, paramBoolean);
    int i1;
    if (paramBoolean)
    {
      i1 = 1;
      if (l1 <= 0L)
        break label116;
      this.m.a(paramInt, l1, 0L, null, true);
    }
    while (true)
    {
      if (com.viber.voip.analytics.a.j.a(paramBoolean))
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.a(localArrayList.size()));
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.a.a());
      return;
      i1 = 0;
      break;
      label116: this.s.handleCreateGroup(paramInt, arrayOfString, paramString, 0L, i1, 60);
    }
  }

  public void a(long paramLong)
  {
    ((bs)this.d.get()).b(paramLong);
  }

  public void a(long paramLong, int paramInt)
  {
    this.c.b(paramLong, paramInt);
  }

  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 - paramInt1 > 300);
    for (int i1 = paramInt1 + 300; ; i1 = paramInt2)
    {
      String str1 = (String)this.j.get(Long.valueOf(paramLong));
      String str2 = paramInt1 + "/" + i1;
      if ((paramBoolean) || (str1 == null) || (!str1.equals(str2)))
      {
        int i2 = ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence();
        this.j.put(Long.valueOf(paramLong), str2);
        this.r.handleGetPublicGroupLikes(i2, paramLong, paramInt1, i1);
      }
      return;
    }
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    com.viber.voip.model.entity.r localr = this.c.d(paramLong1);
    if (localr != null)
    {
      localr.f(paramInt);
      localr.b(paramLong2);
      this.c.b(localr);
    }
  }

  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    ((bs)this.d.get()).a(paramLong, paramInt, paramString1, paramString2);
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    ((bs)this.d.get()).c(paramLong, paramInt, paramBoolean);
  }

  public void a(final long paramLong1, long paramLong2, final int paramInt, long paramLong3, long paramLong4, String paramString)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    if (this.C == null)
    {
      this.C = new GroupMessageStatusListener()
      {
        public boolean onGetGroupMessageStatusReply(long paramAnonymousLong, int paramAnonymousInt1, int paramAnonymousInt2, CGroupMessageStatus[] paramAnonymousArrayOfCGroupMessageStatus)
        {
          CGroupMessageData localCGroupMessageData = (CGroupMessageData)af.j(af.this).remove(Integer.valueOf(paramAnonymousInt1));
          if (localCGroupMessageData == null)
            return false;
          switch (paramAnonymousInt2)
          {
          default:
            af.c(af.this).a(paramAnonymousInt2, 0, localCGroupMessageData.getToken(), new ArrayList(), new HashSet());
          case 0:
          }
          while (true)
          {
            return false;
            HashMap localHashMap = new HashMap();
            int i = 0;
            if (paramAnonymousArrayOfCGroupMessageStatus != null)
            {
              int j = paramAnonymousArrayOfCGroupMessageStatus.length;
              i = 0;
              if (j > 0)
              {
                i = paramAnonymousArrayOfCGroupMessageStatus[0].status;
                if (paramAnonymousArrayOfCGroupMessageStatus[0].users != null)
                  for (CGroupMessageStatus.CReadData localCReadData : paramAnonymousArrayOfCGroupMessageStatus[0].users)
                    localHashMap.put(localCReadData.phoneNumber, Long.valueOf(localCReadData.timeSeen));
              }
            }
            HashSet localHashSet = new HashSet();
            List localList = af.a(af.this).a(localHashMap, localCGroupMessageData.getToken(), cd.j(paramInt), localHashSet, paramLong1);
            af.c(af.this).a(paramAnonymousInt2, i, localCGroupMessageData.getToken(), localList, localHashSet);
          }
        }
      };
      localEngine.getDelegatesManager().getGroupMessageStatusListener().registerDelegate(this.C, com.viber.voip.av.a(av.e.f));
    }
    int i1 = localEngine.getPhoneController().generateSequence();
    CGroupMessageData localCGroupMessageData = new CGroupMessageData(paramLong3, paramLong4, paramString);
    this.y.put(Integer.valueOf(i1), localCGroupMessageData);
    if (m.b(paramInt))
    {
      this.C.onGetGroupMessageStatusReply(paramLong2, i1, 0, null);
      return;
    }
    localEngine.getPhoneController().handleGetGroupMessageStatus(paramLong2, i1, new CGroupMessageData[] { localCGroupMessageData });
  }

  public void a(long paramLong, com.viber.voip.group.participants.settings.b paramb)
  {
    long l1 = 0L;
    if (paramb.canWrite())
      l1 = 9223372036854775807L;
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    int i1 = localEngine.getPhoneController().generateSequence();
    com.viber.voip.model.entity.r localr = this.c.d(paramLong);
    if (localr == null)
      return;
    localr.l(com.viber.voip.util.av.a(localr.A(), 3));
    localr.d(l1);
    this.c.b(localr);
    PublicAccount localPublicAccount = new PublicAccount();
    localPublicAccount.setGroupID(paramLong);
    localPublicAccount.setGlobalPermissions(l1);
    a(i1, localPublicAccount);
    CUpdateCommunityPrivilegesMsg localCUpdateCommunityPrivilegesMsg = new CUpdateCommunityPrivilegesMsg(i1, paramLong, l1);
    localEngine.getExchanger().handleCUpdateCommunityPrivilegesMsg(localCUpdateCommunityPrivilegesMsg);
  }

  public void a(long paramLong, String paramString)
  {
    com.viber.voip.model.entity.h localh = this.c.f(paramLong);
    String str = ViberApplication.getInstance().getUserManager().getRegistrationValues().l();
    bs.g localg = ((bs)this.d.get()).a(localh, paramString);
    MessageEntity localMessageEntity = com.viber.voip.messages.controller.c.c.a(0L, 4, System.currentTimeMillis(), str, 16, 0L, com.viber.voip.messages.j.a(str, localg.b, localg.c));
    localMessageEntity.setConversationId(paramLong);
    ((bs)this.d.get()).a(localMessageEntity);
  }

  public void a(long paramLong, Set<Long> paramSet1, Set<Long> paramSet2, final GroupController.a parama)
  {
    final int i1 = this.e.e(paramLong);
    final int i2 = this.e.a(paramLong, paramSet1, paramSet2);
    com.viber.voip.av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        parama.a(i1, i2);
      }
    });
  }

  public void a(long paramLong, GroupController.GroupMember[] paramArrayOfGroupMember)
  {
    com.viber.voip.model.entity.h localh = this.c.f(paramLong);
    String[] arrayOfString = new String[paramArrayOfGroupMember.length];
    for (int i1 = 0; i1 < paramArrayOfGroupMember.length; i1++)
    {
      arrayOfString[i1] = paramArrayOfGroupMember[i1].mMID;
      ((bs)this.d.get()).a(localh, paramArrayOfGroupMember[i1].mMID, 0, 1);
    }
    long l1 = System.currentTimeMillis();
    String str1 = arrayOfString[0];
    if (arrayOfString.length > 1);
    for (String str2 = com.viber.voip.messages.j.b(arrayOfString); ; str2 = com.viber.voip.messages.j.c(arrayOfString[0]))
    {
      MessageEntity localMessageEntity = com.viber.voip.messages.controller.c.c.a(0L, 4, l1, str1, 64, 0L, str2);
      localMessageEntity.setConversationId(paramLong);
      ((bs)this.d.get()).a(localMessageEntity);
      this.m.c(Collections.singleton(Long.valueOf(paramLong)), false);
      return;
    }
  }

  public void a(long paramLong, String[] paramArrayOfString)
  {
    int i1 = this.s.generateSequence();
    this.q.handleGroupRemoveMembers(paramLong, i1, paramArrayOfString);
  }

  public void a(long paramLong, String[] paramArrayOfString, int paramInt)
  {
    com.viber.voip.model.entity.h localh = this.c.b(paramLong);
    if (localh != null)
    {
      this.e.a(localh.getId(), paramArrayOfString, paramInt);
      this.m.c(Collections.singleton(Long.valueOf(localh.getId())), false);
    }
    int i1 = this.s.generateSequence();
    if (this.B == null)
    {
      this.B = new GroupAssignRoleListener()
      {
        public void onGroupAssignRole(long paramAnonymousLong1, int paramAnonymousInt1, long paramAnonymousLong2, int paramAnonymousInt2, int paramAnonymousInt3, String[] paramAnonymousArrayOfString, Map<String, Integer> paramAnonymousMap, int paramAnonymousInt4, int paramAnonymousInt5)
        {
          af.k(af.this).remove(Integer.valueOf(paramAnonymousInt1));
        }
      };
      ViberApplication.getInstance().getEngine(true).getDelegatesManager().getGroupAssignRoleListener().registerDelegate(this.B, com.viber.voip.av.a(av.e.f));
    }
    String str = Arrays.toString(paramArrayOfString);
    if (this.z.containsValue(str))
      return;
    this.z.put(Integer.valueOf(i1), str);
    this.q.handleGroupAssignRole(paramLong, i1, paramArrayOfString, paramInt);
  }

  public void a(com.viber.voip.model.entity.r paramr)
  {
    final long l1 = paramr.a();
    boolean bool = paramr.y();
    String str1 = Long.toString(paramr.E());
    String str2 = paramr.D();
    MessageEntity localMessageEntity = this.c.v(l1);
    if (localMessageEntity != null)
    {
      this.p.handleReportPublicGroupStatistics(localMessageEntity.getMessageToken(), l1, paramr.g(), bool, str1, str2);
      return;
    }
    if ((o.a().a(l1)) || (TextUtils.isEmpty(paramr.g())))
    {
      o.a().a(new bv.t()
      {
        public void onPublicGroupSyncFinished(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
        {
          if (l1 == paramAnonymousLong)
          {
            o.a().b(this);
            com.viber.voip.model.entity.r localr = af.a(af.this).d(l1);
            if (localr != null)
              af.this.a(localr);
          }
        }
      });
      return;
    }
    this.p.handleReportPublicGroupStatistics(0L, l1, paramr.g(), bool, str1, str2);
  }

  public boolean a(int paramInt)
  {
    while (true)
    {
      synchronized (this.f)
      {
        if (this.f.indexOfKey(paramInt) >= 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public void b(long paramLong)
  {
    this.c.b(paramLong, 28, true);
  }

  public void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    int i1 = 1;
    while (true)
    {
      try
      {
        boolean bool1 = TextUtils.isEmpty(paramString1);
        boolean bool2 = TextUtils.isEmpty(paramString2);
        if ((bool1) && (bool2))
        {
          if (i1 == 0)
          {
            Uri[] arrayOfUri = com.viber.voip.backgrounds.b.a().a(paramString2);
            if (arrayOfUri[0] != null)
              a(paramLong, paramInt, arrayOfUri[0].toString(), arrayOfUri[1].toString());
          }
          return;
        }
        if (bool1)
        {
          i1 = 0;
          continue;
        }
        Object localObject2;
        if (this.s.isShortStandardBackgroundID(paramString2))
        {
          int i3 = com.viber.voip.backgrounds.b.c(paramString2);
          int i4 = d.i.a.d();
          localObject2 = new com.viber.voip.backgrounds.s(i3, i4, false, null);
          Uri localUri3 = ((com.viber.voip.backgrounds.q)localObject2).a(false);
          if ((localUri3 != null) && (!localUri3.toString().contains(paramString1)))
            localObject2 = new com.viber.voip.backgrounds.s(i3, i4, true, null);
          Uri localUri2 = ((com.viber.voip.backgrounds.q)localObject2).a(false);
          if ((localUri2 != null) && (localUri2.toString().contains(paramString1)) && (at.d(ViberApplication.getApplication(), paramString1)))
          {
            i2 = i1;
            break label278;
          }
        }
        else
        {
          File localFile = dv.n.b(this.b, dx.f(paramString2).toString(), false);
          Uri localUri1 = null;
          if (localFile != null)
            localUri1 = Uri.fromFile(localFile);
          localObject2 = new com.viber.voip.backgrounds.r(localUri1);
          continue;
        }
      }
      finally
      {
      }
      int i2 = 0;
      label278: i1 = i2;
    }
  }

  public void b(long paramLong, String paramString)
  {
    com.viber.voip.model.entity.h localh = this.c.f(paramLong);
    if (this.o.a(localh, 0, paramString))
    {
      MessageEntity localMessageEntity = com.viber.voip.messages.controller.c.c.a(0L, 4, System.currentTimeMillis(), paramString, 64, 0L, com.viber.voip.messages.j.d(paramString));
      localMessageEntity.setConversationId(paramLong);
      ((bs)this.d.get()).a(localMessageEntity);
    }
  }

  public boolean b(int paramInt)
  {
    return this.l.contains(Integer.valueOf(paramInt));
  }

  public void c(int paramInt)
  {
    this.l.add(Integer.valueOf(paramInt));
  }

  public boolean c(long paramLong)
  {
    synchronized (this.i)
    {
      boolean bool = this.i.contains(paramLong);
      return bool;
    }
  }

  public void d(long paramLong)
  {
    synchronized (this.i)
    {
      this.i.remove(paramLong);
      return;
    }
  }

  public boolean d(int paramInt)
  {
    while (true)
    {
      synchronized (this.g)
      {
        if (this.g.indexOfKey(paramInt) >= 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public GroupController.GroupBaseDescription e(int paramInt)
  {
    GroupController.GroupBaseDescription localGroupBaseDescription = (GroupController.GroupBaseDescription)this.k.get(paramInt);
    this.k.remove(paramInt);
    return localGroupBaseDescription;
  }

  public void f(int paramInt)
  {
    this.l.remove(Integer.valueOf(paramInt));
  }

  public Pair<Integer, PublicAccount> g(int paramInt)
  {
    synchronized (this.g)
    {
      Pair localPair = (Pair)this.g.get(paramInt);
      return localPair;
    }
  }

  public void h(int paramInt)
  {
    synchronized (this.g)
    {
      this.g.remove(paramInt);
      return;
    }
  }

  public PublicAccount i(int paramInt)
  {
    synchronized (this.f)
    {
      PublicAccount localPublicAccount = (PublicAccount)this.f.get(paramInt);
      return localPublicAccount;
    }
  }

  public void j(int paramInt)
  {
    synchronized (this.f)
    {
      this.f.remove(paramInt);
      return;
    }
  }

  public boolean k(int paramInt)
  {
    while (true)
    {
      synchronized (this.h)
      {
        if (this.h.indexOfKey(paramInt) >= 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public b l(int paramInt)
  {
    synchronized (this.h)
    {
      b localb = (b)this.h.get(paramInt);
      return localb;
    }
  }

  public void m(int paramInt)
  {
    synchronized (this.h)
    {
      this.h.remove(paramInt);
      return;
    }
  }

  private abstract class a
    implements com.viber.voip.util.upload.q
  {
    private int a;

    public a(int arg2)
    {
      int i;
      this.a = i;
    }

    public void a(Uri paramUri, t.c paramc)
    {
      af.this.j(this.a);
      af.c(af.this).b(this.a, 1);
    }
  }

  public static class b
  {
    public final PublicAccount a;
    public long b;
    public String c;

    b(PublicAccount paramPublicAccount, long paramLong, String paramString)
    {
      this.a = paramPublicAccount;
      this.b = paramLong;
      this.c = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.af
 * JD-Core Version:    0.6.2
 */