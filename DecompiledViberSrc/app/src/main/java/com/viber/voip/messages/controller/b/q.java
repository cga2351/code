package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Group2LatestParams;
import com.viber.jni.GroupUserInfo;
import com.viber.jni.LocationInfo;
import com.viber.jni.PGLatestParamsWithRole;
import com.viber.jni.PublicAccountAttributes;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGroupAttributesChanged;
import com.viber.jni.im2.CGroupChangedMsg;
import com.viber.jni.im2.CGroupRemoveMembersReplyMsg;
import com.viber.jni.im2.CGroupRemoveMembersReplyMsg.Receiver;
import com.viber.jni.im2.CMoreUserInfo;
import com.viber.jni.im2.CPGChangeReceivedMsg;
import com.viber.jni.im2.Group2UserChanged;
import com.viber.jni.im2.Group2UserInfo;
import com.viber.jni.im2.GroupMemberActionStatus;
import com.viber.jni.im2.Location;
import com.viber.jni.im2.interfaces.GroupChangeReceiver;
import com.viber.jni.publicgroup.PublicGroupController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.g;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.e;
import com.viber.voip.messages.controller.bs.e.a;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.notif.e.s;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.Background;
import com.viber.voip.settings.d.ap;
import com.viber.voip.settings.d.r;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import com.viber.voip.util.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.sqlite.database.sqlite.SQLiteDatabase;

public class q extends m
  implements CGroupRemoveMembersReplyMsg.Receiver, GroupChangeReceiver
{
  private static final Logger n = ViberEnv.getLogger();
  private ai o;
  private d p;
  private bn q;
  private com.viber.voip.messages.controller.a r;
  private boolean s;

  public q(Context paramContext, com.viber.voip.messages.controller.af paramaf, com.viber.voip.registration.af paramaf1, ai paramai, d paramd, bn parambn1, com.viber.voip.messages.controller.a parama, dagger.a<bs> parama1, bn parambn2)
  {
    super(paramContext, paramaf, paramaf1, parama1, parambn2);
    this.o = paramai;
    this.p = paramd;
    this.q = parambn1;
    this.r = parama;
    d.c(new d.b()
    {
      public void onAppStopped()
      {
        i.c(this);
      }

      public void onBackground()
      {
        com.viber.voip.messages.conversation.publicaccount.k.a(true);
      }

      public void onForeground()
      {
        i.b(this);
      }

      public void onForegroundStateChanged(boolean paramAnonymousBoolean)
      {
        i.a(this, paramAnonymousBoolean);
      }
    });
    d.a(new com.viber.voip.util.d.d()
    {
      public void a()
      {
        q.a(q.this);
      }

      public void a(int paramAnonymousInt)
      {
      }
    }
    , av.e.d.a());
  }

  private MessageEntity a(long paramLong1, String paramString, int paramInt1, long paramLong2, long paramLong3, int paramInt2, Integer paramInteger, Group2UserChanged[] paramArrayOfGroup2UserChanged, h paramh)
  {
    if (paramArrayOfGroup2UserChanged == null)
      return null;
    if (paramInteger != null)
      this.d.a(paramLong1, paramInteger.intValue(), paramh.getId());
    ArrayList localArrayList = new ArrayList(paramArrayOfGroup2UserChanged.length);
    int i = paramArrayOfGroup2UserChanged.length;
    for (int j = 0; j < i; j++)
    {
      Group2UserInfo localGroup2UserInfo = paramArrayOfGroup2UserChanged[j].user;
      Member localMember = new Member(localGroup2UserInfo.encryptedPhoneNumber, null, null, null, null, null, localGroup2UserInfo.encryptedPhoneNumber);
      boolean bool = localGroup2UserInfo.moreUserInfo.isBanned();
      if ((this.d.a(paramh, paramInt1, localMember, bool)) && (bool))
        localArrayList.add(localGroup2UserInfo.encryptedPhoneNumber);
    }
    if (!localArrayList.isEmpty())
    {
      this.e.a(paramLong1, 0, (String[])localArrayList.toArray(new String[localArrayList.size()]), null);
      return com.viber.voip.messages.controller.c.c.a(paramLong1, paramh.j(), paramLong2, paramString, paramInt1, paramLong3, com.viber.voip.messages.j.a(paramString, (String[])localArrayList.toArray(new String[localArrayList.size()])), paramInt2);
    }
    return null;
  }

  private List<com.viber.voip.model.entity.q> a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString5, String paramString6, int paramInt4, Integer paramInteger, PublicAccountAttributes paramPublicAccountAttributes, r paramr, h paramh)
  {
    if (paramr == null)
      return null;
    boolean bool1 = av.d(paramr.x(), 16384);
    boolean bool2 = av.d(paramInt4, 16384);
    int i;
    PublicAccount localPublicAccount;
    if (bool1 != bool2)
    {
      i = 1;
      localPublicAccount = new PublicAccount(paramLong1, paramPublicAccountAttributes);
      if ((!da.a(paramString1)) || (paramh == null))
        break label275;
      localPublicAccount.setName(paramh.o());
    }
    while (true)
    {
      localPublicAccount.setRevision(paramInt1);
      localPublicAccount.setIcon(dx.g(paramString2));
      localPublicAccount.setBackground(new PublicAccount.Background(paramString3, null));
      localPublicAccount.setTagLines(paramString4);
      localPublicAccount.setTags(paramArrayOfString);
      localPublicAccount.setLocation(paramLocationInfo);
      localPublicAccount.setCountryCode(paramString5);
      localPublicAccount.setFlags(paramInt4);
      if (paramInteger != null)
        localPublicAccount.setWatchersCount(paramInteger.intValue());
      localPublicAccount.setGroupUri(paramString6);
      List localList = r.a(paramr, localPublicAccount, paramInt3);
      this.g.b(paramr);
      if ((i != 0) && (!bool2) && (paramh != null))
        a(paramh, paramLong2, paramInt2);
      h localh = this.g.c(paramLong1);
      if (localh != null)
      {
        com.viber.voip.publicaccount.d.e.a(paramr.b(), dx.g(paramString2), paramString1, paramInt3);
        this.e.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), true, false);
      }
      return localList;
      i = 0;
      break;
      label275: localPublicAccount.setName(paramString1);
    }
  }

  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramInt2 < paramInt1) && (this.p.b()))
      a(paramLong, paramInt1);
  }

  private void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4, Integer paramInteger, int paramInt5)
  {
    if ((paramInt1 & 0x10) != 0);
    for (int i = 1; i == 0; i = 0)
      return;
    int j = this.b.getPhoneController().generateSequence();
    PublicAccount localPublicAccount = new PublicAccount();
    localPublicAccount.setGroupID(paramLong1);
    localPublicAccount.setGroupRole(3);
    localPublicAccount.setRevision(paramInt4);
    if (paramInteger != null)
      localPublicAccount.setWatchersCount(paramInteger.intValue());
    localPublicAccount.setLastMessageId(paramInt2);
    if ((com.viber.voip.messages.m.b(paramInt3)) && (paramInt2 > 0))
      a(paramLong1, com.viber.voip.messages.conversation.publicaccount.a.a.a(paramInt5, paramInt2, paramInt2));
    bs.e locale = bs.e.a().a(true).d(false).a();
    ((bs)this.f.get()).a(j, paramLong1, paramInt3, localPublicAccount, locale);
  }

  private void a(long paramLong1, int paramInt1, String paramString1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, int paramInt4, String paramString2, com.viber.jni.GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt5, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString6, String paramString7, int paramInt6, Integer paramInteger, PublicAccountAttributes paramPublicAccountAttributes, int paramInt7, Group2UserChanged[] paramArrayOfGroup2UserChanged, int paramInt8, long paramLong4, String paramString8, int paramInt9)
  {
    if (paramInt2 == 21)
    {
      this.r.b();
      this.b.getPhoneController().handleSendGroupChangedAck(paramLong3, false);
    }
    int i;
    r localr;
    h localh1;
    List localList;
    label151: label471: boolean bool1;
    boolean bool3;
    label567: 
    do
    {
      return;
      i = h.a(paramLong1, paramInt7);
      localr = this.g.d(paramLong1);
      localh1 = this.g.b(paramLong1);
      localObject = null;
      switch (paramInt2)
      {
      case 7:
      case 8:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 16:
      case 17:
      case 19:
      default:
      case 3:
      case 15:
      case 9:
      case 18:
      case 4:
      case 5:
      case 6:
      case 20:
      }
      while (true)
      {
        localList = null;
        while (true)
        {
          if (localh1 != null)
            break label471;
          a(paramLong3, paramInt2, paramInt3, paramString1, null);
          return;
          localList = a(paramLong1, paramInt1, paramLong3, paramInt4, paramString2, paramInt5, paramString3, paramString4, paramString5, paramArrayOfString, paramLocationInfo, paramString6, paramString7, paramInt6, paramInteger, paramPublicAccountAttributes, localr, localh1);
          continue;
          ((bs)this.f.get()).j(paramLong1, paramPublicAccountAttributes.hasSubscription());
          localList = null;
          continue;
          a(localr, localh1, paramInt4, i);
          ((bs)this.f.get()).a(paramLong3, false);
          localList = null;
          continue;
          if (localr == null)
            break;
          localr.d(paramLong4);
          this.g.b(localr);
          localList = null;
          continue;
          a(paramLong1, paramInt1, paramString1, paramInt3, paramLong2, paramLong3, paramInt4, paramString2, paramArrayOfGroupUserChanged, paramInteger, paramArrayOfGroup2UserChanged, i, localh1);
          localList = null;
        }
        if (localr == null);
        for (int i7 = 0; ; i7 = localr.v())
        {
          a(paramLong1, paramInt3, paramLong2, paramLong3, paramInt4, i, paramInt1, paramInteger, i7);
          if ((localh1 == null) || (paramInteger == null))
            break;
          this.d.a(paramLong1, paramInteger.intValue(), localh1.getId());
          localList = null;
          break label151;
        }
        if ((av.d(paramInt9, 1)) && (localr != null))
        {
          localr.v(paramString8);
          this.g.b(localr);
          h localh2 = this.g.c(paramLong1);
          if (localh2 != null)
            this.e.b(localh2.getId());
        }
      }
      bool1 = false;
      switch (paramInt2)
      {
      case 4:
      case 5:
      case 6:
      case 9:
      case 12:
      case 13:
      case 14:
      case 15:
      default:
        bool3 = false;
        if ((localr != null) && (paramInt1 > localr.e()))
          this.g.a(localr.getTable(), localr.getId(), "revision", Integer.valueOf(paramInt1));
        bs.f localf = null;
        if (localObject != null)
        {
          boolean bool4 = ((MessageEntity)localObject).isOutgoing();
          localf = a((MessageEntity)localObject, paramString2, bool4, bool3, bool1);
        }
        a(paramLong3, paramInt2, paramInt3, paramString1, localf);
      case 3:
      case 2:
      case 11:
      case 19:
      case 7:
      case 8:
      case 10:
      case 16:
      case 18:
      case 17:
      }
    }
    while (!cd.c(localh1.p()));
    com.viber.voip.notif.g.a(this.a).a().a(localList);
    return;
    String str = localh1.o();
    h.a(localh1, dx.g(paramString3), paramString2, paramInt5);
    this.g.b(localh1);
    this.e.a(Collections.singleton(Long.valueOf(localh1.getId())), localh1.j(), true, false);
    Object localObject = com.viber.voip.messages.controller.c.c.a(this.a, paramInt5, localh1, paramString1, paramInt3, paramLong2, paramLong3, paramString2, str, paramInt4);
    if ((localObject != null) && (((MessageEntity)localObject).isEmpty()) && (localh1.g()));
    for (boolean bool6 = true; ; bool6 = false)
    {
      com.viber.voip.publicaccount.d.e.a(localh1, paramString4, paramInt5);
      if (((paramInt5 & 0x80) != 0) && (cd.b(localh1.p())) && (localh1.g()))
      {
        this.r.b();
        bool1 = bool6;
        bool3 = false;
        break label567;
        this.d.a(localh1, paramInt3, paramString1);
        bool3 = false;
        bool1 = false;
        localObject = null;
        break label567;
        if (paramInteger != null)
          this.d.a(paramLong1, paramInteger.intValue(), localh1.getId());
        int i5 = localh1.p();
        String[] arrayOfString = new String[paramArrayOfGroupUserChanged.length];
        for (int i6 = 0; i6 < paramArrayOfGroupUserChanged.length; i6++)
        {
          arrayOfString[i6] = paramArrayOfGroupUserChanged[i6].getUser().memberId;
          this.d.a(localh1, paramInt3, arrayOfString[i6]);
        }
        if (i5 == 3)
          break;
        localObject = com.viber.voip.messages.controller.c.c.a(paramLong1, localh1.j(), paramLong2, paramString1, paramInt3, paramLong3, com.viber.voip.messages.j.a(paramString1, arrayOfString), paramInt4);
        bool3 = true;
        bool1 = false;
        break label567;
        localObject = a(paramLong1, paramString1, paramInt3, paramLong2, paramLong3, paramInt4, paramInteger, paramArrayOfGroup2UserChanged, localh1);
        bool3 = false;
        bool1 = false;
        break label567;
        ((bs)this.f.get()).a(Collections.singleton(Long.valueOf(localh1.getId())), localh1.j());
        bool3 = false;
        bool1 = false;
        localObject = null;
        break label567;
        int i3 = paramArrayOfGroupUserChanged.length;
        for (int i4 = 0; i4 < i3; i4++)
        {
          com.viber.jni.GroupUserChanged localGroupUserChanged = paramArrayOfGroupUserChanged[i4];
          Member localMember1 = Member.from(localGroupUserChanged.getUser(), i, localh1.p());
          com.viber.voip.model.entity.m localm = this.h.c(localMember1, cd.j(i));
          if (localm != null)
          {
            localm.a(dx.a(localGroupUserChanged.getUser().downloadID));
            Member localMember2 = Member.from(localm);
            com.viber.voip.messages.d.c.c().a(Collections.singletonMap(localm, localMember2));
            cd.a(localGroupUserChanged.getUser().downloadID, localMember1.getEncryptedMemberId(), "MessagePublicGroupDelegateImpl [handleGroupChange] GROUP_MEMBER_UPDATE_PHOTO", localMember2.getPhotoUri());
          }
        }
        bool3 = false;
        bool1 = false;
        localObject = null;
        break label567;
        int m;
        label1222: int i2;
        if ((paramInt3 & 0x1) != 0)
        {
          m = 1;
          int i1 = paramArrayOfGroupUserChanged.length;
          localObject = null;
          if (i1 > 0)
          {
            i2 = paramArrayOfGroupUserChanged[0].getRole();
            localObject = null;
            if (m != 0)
              if (!cd.c(i2))
              {
                boolean bool5 = cd.c(localh1.p());
                localObject = null;
                if (!bool5);
              }
              else
              {
                if (!com.viber.voip.messages.m.b(i))
                  break label1403;
                this.o.a(localh1.getId(), true, i);
              }
          }
        }
        label1403: for (MessageEntity localMessageEntity = null; ; localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramLong1, localh1.j(), paramLong2, this.c.l(), paramInt3, paramLong3, com.viber.voip.messages.j.a(this.c.l(), paramArrayOfGroupUserChanged[0]), paramInt4))
        {
          if (cd.c(i2))
            this.k.a(this.b.getPhoneController().generateSequence(), paramLong1, "", paramInt1, localh1.j(), 2);
          localObject = localMessageEntity;
          if ((cd.c(i2)) || (cd.a(i2)))
            this.m.post(new com.viber.voip.messages.a.d.d(i));
          a(localh1, paramArrayOfGroupUserChanged);
          bool3 = false;
          bool1 = false;
          break;
          m = 0;
          break label1222;
        }
        if (paramArrayOfGroup2UserChanged == null)
        {
          bool3 = false;
          bool1 = false;
          localObject = null;
          break label567;
        }
        bool1 = true;
        HashSet localHashSet = new HashSet(paramArrayOfGroup2UserChanged.length);
        int j = paramArrayOfGroup2UserChanged.length;
        for (int k = 0; k < j; k++)
        {
          Group2UserInfo localGroup2UserInfo = paramArrayOfGroup2UserChanged[k].user;
          localHashSet.add(new com.viber.voip.publicaccount.entity.a(paramLong3, localGroup2UserInfo.encryptedPhoneNumber, da.a(this.c.k(), localGroup2UserInfo.encryptedPhoneNumber)));
        }
        ((bs)this.f.get()).a(paramLong3, localh1.k(), localh1.getId(), localHashSet);
        localObject = com.viber.voip.messages.controller.c.c.a(paramLong1, localh1.j(), paramString1, paramLong2, paramInt3, paramLong3, paramInt4);
        bool3 = false;
        break label567;
        this.g.b(localh1.getId(), 28, false);
        this.e.a(Collections.singleton(Long.valueOf(localh1.getId())), localh1.j(), true, false);
        bool3 = false;
        bool1 = false;
        localObject = null;
        break label567;
        if (localr == null)
          break;
        if (1 == paramInt8);
        for (boolean bool2 = true; ; bool2 = false)
        {
          this.g.a(localr.getTable(), localr.getId(), "pg_extra_flags", Integer.valueOf(av.a(localr.A(), 1, bool2)));
          this.e.a(Collections.singleton(Long.valueOf(localh1.getId())), localh1.j(), true, false);
          break;
        }
      }
      bool1 = bool6;
      bool3 = false;
      break label567;
    }
  }

  private void a(long paramLong1, int paramInt1, String paramString1, int paramInt2, long paramLong2, long paramLong3, int paramInt3, String paramString2, com.viber.jni.GroupUserChanged[] paramArrayOfGroupUserChanged, Integer paramInteger, Group2UserChanged[] paramArrayOfGroup2UserChanged, int paramInt4, h paramh)
  {
    if (com.viber.voip.messages.m.a(paramInt4))
      if (com.viber.voip.publicaccount.d.a.a().e())
        this.b.getPhoneController().handleGroupLeave(paramLong1);
    while (this.g.a(paramLong3))
    {
      return;
      com.viber.voip.publicaccount.d.a.a().b();
    }
    HashMap localHashMap = new HashMap(paramArrayOfGroupUserChanged.length);
    if (paramh != null);
    for (int i = paramh.p(); (paramArrayOfGroup2UserChanged != null) && (paramArrayOfGroup2UserChanged.length > 0); i = 3)
      for (int m = 0; m < paramArrayOfGroup2UserChanged.length; m++)
      {
        Group2UserChanged localGroup2UserChanged = paramArrayOfGroup2UserChanged[m];
        Member localMember2 = Member.from(localGroup2UserChanged.user, i);
        localHashMap.put(localMember2, Integer.valueOf(localGroup2UserChanged.role));
        cd.a(localGroup2UserChanged.user.downloadID, localMember2.getEncryptedMemberId(), "MessagePublicGroupDelegateImpl [handleGroupAddedMembersEvent] role=" + localGroup2UserChanged.role, localMember2.getPhotoUri());
      }
    for (int j = 0; j < paramArrayOfGroupUserChanged.length; j++)
    {
      com.viber.jni.GroupUserChanged localGroupUserChanged = paramArrayOfGroupUserChanged[j];
      Member localMember1 = Member.from(localGroupUserChanged.getUser(), paramInt4, i);
      localHashMap.put(localMember1, Integer.valueOf(localGroupUserChanged.getRole()));
      cd.a(localGroupUserChanged.getUser().downloadID, localMember1.getEncryptedMemberId(), "MessagePublicGroupDelegateImpl [handleGroupAddedMembersEvent] role=" + i, localMember1.getPhotoUri());
    }
    if ((com.viber.voip.messages.m.b(paramInt4)) && ((paramInt2 & 0x10) == 0) && (paramh == null))
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.a.a(paramString2, "admin", String.valueOf(paramLong1)));
    MessageEntity localMessageEntity = a(paramInt4, paramLong1, paramInt1, paramString1, paramInt2, paramLong2, paramLong3, paramString2, localHashMap, paramh, paramInt3);
    if ((paramInt2 & 0x1) != 0);
    for (int k = 1; ; k = 0)
    {
      boolean bool = a(paramInt2, paramInt4, localHashMap);
      if ((k != 0) && (!bool) && (com.viber.voip.messages.m.b(paramInt4)))
        this.r.a(paramLong1);
      if (((k != 0) || (bool)) && (com.viber.voip.messages.m.b(paramInt4)))
        this.r.b();
      if ((paramh != null) && (paramInteger != null) && (paramInteger.intValue() > 0))
        this.d.a(paramLong1, paramInteger.intValue(), paramh.getId());
      if (localMessageEntity == null)
        break;
      a(localMessageEntity, "", localMessageEntity.isOutgoing(), false, com.viber.voip.messages.m.b(paramInt4));
      return;
    }
  }

  private void a(h paramh, long paramLong, int paramInt)
  {
    if (((bs)this.f.get()).a(paramh.getId(), paramh.j(), paramLong, paramInt, paramh.k()))
      com.viber.voip.notif.g.a(this.a).d().b(paramh.getId());
  }

  private void a(r paramr, h paramh, int paramInt1, int paramInt2)
  {
    if (paramr != null)
    {
      int i = paramr.K();
      int j = Math.max(paramr.v(), paramr.n());
      if ((paramInt1 > i) && (paramInt1 <= j))
      {
        int k = Math.min(i + 1, j);
        if (i != k)
        {
          this.g.a(paramr.getTable(), paramr.getId(), "last_read_message_id", Integer.valueOf(k));
          if (paramh != null)
            this.e.a(Collections.singleton(Long.valueOf(paramh.getId())), paramInt2, false, false);
        }
      }
    }
  }

  private void b()
  {
    if (!this.s)
    {
      this.s = true;
      this.g.s();
    }
    HashSet localHashSet = ViberApplication.getInstance().getMessagesManager().a().i();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = com.viber.voip.s.a.e(localHashSet);
    String str = String.format("conversation_type=? AND _id NOT IN (%s)", arrayOfObject);
    ab localab = this.g;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(3);
    Set localSet = localab.i(str, arrayOfString);
    if (localSet.size() > 0)
      ((bs)this.f.get()).a(localSet, 2);
    this.g.z();
    SQLiteDatabase.releaseMemory();
  }

  protected void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramLong, paramInt1, paramInt2, paramInt3);
    if ((com.viber.voip.messages.m.b(paramInt1)) && (!cd.b(paramInt2)) && (cd.b(paramInt3)))
      this.r.a(paramLong);
  }

  public void onCGroupChangedMsg(CGroupChangedMsg paramCGroupChangedMsg)
  {
    PublicAccountAttributes localPublicAccountAttributes = paramCGroupChangedMsg.toLegacyPublicAccountAttributes();
    LocationInfo localLocationInfo = paramCGroupChangedMsg.changedAttributes.location.toLegacyLocation();
    com.viber.jni.GroupUserChanged[] arrayOfGroupUserChanged = new com.viber.jni.GroupUserChanged[paramCGroupChangedMsg.members.length];
    for (int i = 0; i < paramCGroupChangedMsg.members.length; i++)
      arrayOfGroupUserChanged[i] = paramCGroupChangedMsg.members[i].toLegacyGroupUserChanged();
    int j = paramCGroupChangedMsg.messageType;
    if (j == 6)
      j = 2;
    if ((j == 11) || (j == 19));
    for (Integer localInteger = paramCGroupChangedMsg.numWatchers; ; localInteger = null)
    {
      a(paramCGroupChangedMsg.groupID, paramCGroupChangedMsg.changedAttributes.revision, paramCGroupChangedMsg.originPhoneNumber, j, paramCGroupChangedMsg.flags, paramCGroupChangedMsg.timeChanged, paramCGroupChangedMsg.messageToken, paramCGroupChangedMsg.seqInPG.intValue(), paramCGroupChangedMsg.groupName, arrayOfGroupUserChanged, paramCGroupChangedMsg.changedAttributes.flags, paramCGroupChangedMsg.changedAttributes.iconDownloadID, paramCGroupChangedMsg.changedAttributes.backgroundDownloadID, paramCGroupChangedMsg.changedAttributes.tagLine, paramCGroupChangedMsg.changedAttributes.tags, localLocationInfo, paramCGroupChangedMsg.changedAttributes.country, paramCGroupChangedMsg.changedAttributes.groupUri, paramCGroupChangedMsg.pgAndSearchFlags.intValue(), localInteger, localPublicAccountAttributes, paramCGroupChangedMsg.groupType.intValue(), paramCGroupChangedMsg.group2Members, paramCGroupChangedMsg.displayInvitationLink.intValue(), 0L, paramCGroupChangedMsg.chatBackground, paramCGroupChangedMsg.attributeChangeType.intValue());
      return;
    }
  }

  public void onCGroupRemoveMembersReplyMsg(CGroupRemoveMembersReplyMsg paramCGroupRemoveMembersReplyMsg)
  {
    ArrayList localArrayList = new ArrayList(paramCGroupRemoveMembersReplyMsg.members.length);
    HashMap localHashMap = new HashMap();
    if (paramCGroupRemoveMembersReplyMsg.status == 0)
    {
      h localh = this.g.b(paramCGroupRemoveMembersReplyMsg.groupID);
      if (localh != null)
      {
        this.d.a(paramCGroupRemoveMembersReplyMsg.groupID, paramCGroupRemoveMembersReplyMsg.numWatchers.intValue(), localh.getId());
        String str = this.c.l();
        GroupMemberActionStatus[] arrayOfGroupMemberActionStatus = paramCGroupRemoveMembersReplyMsg.members;
        int i = arrayOfGroupMemberActionStatus.length;
        int j = 0;
        if (j < i)
        {
          GroupMemberActionStatus localGroupMemberActionStatus = arrayOfGroupMemberActionStatus[j];
          if (localGroupMemberActionStatus.status == 1)
          {
            this.d.a(localh, 0, localGroupMemberActionStatus.phoneNumber);
            localArrayList.add(localGroupMemberActionStatus.phoneNumber);
          }
          while (true)
          {
            j++;
            break;
            localHashMap.put(localGroupMemberActionStatus.phoneNumber, Integer.valueOf(localGroupMemberActionStatus.status));
            if (localGroupMemberActionStatus.status == 8)
              this.d.a(localh, 0, localGroupMemberActionStatus.phoneNumber);
          }
        }
        if (paramCGroupRemoveMembersReplyMsg.members.length > 0)
          a(com.viber.voip.messages.controller.c.c.a(paramCGroupRemoveMembersReplyMsg.groupID, localh.j(), System.currentTimeMillis(), str, 80, paramCGroupRemoveMembersReplyMsg.messageToken, com.viber.voip.messages.j.a(str, (String[])localArrayList.toArray(new String[0])), paramCGroupRemoveMembersReplyMsg.seqInPG), localh.o(), true, false);
      }
    }
    this.e.a(paramCGroupRemoveMembersReplyMsg.groupID, paramCGroupRemoveMembersReplyMsg.status, (String[])localArrayList.toArray(new String[0]), localHashMap);
  }

  public void onCPGChangeReceivedMsg(CPGChangeReceivedMsg paramCPGChangeReceivedMsg)
  {
    PublicAccountAttributes localPublicAccountAttributes = paramCPGChangeReceivedMsg.toLegacyPublicAccountAttributes();
    LocationInfo localLocationInfo = paramCPGChangeReceivedMsg.attributes.location.toLegacyLocation();
    com.viber.jni.GroupUserChanged[] arrayOfGroupUserChanged = new com.viber.jni.GroupUserChanged[paramCPGChangeReceivedMsg.members.length];
    for (int i = 0; i < paramCPGChangeReceivedMsg.members.length; i++)
      arrayOfGroupUserChanged[i] = paramCPGChangeReceivedMsg.members[i].toLegacyGroupUserChanged();
    int j = paramCPGChangeReceivedMsg.convertMsgType();
    a(paramCPGChangeReceivedMsg.groupID, paramCPGChangeReceivedMsg.revision, paramCPGChangeReceivedMsg.encryptedPhone, j, paramCPGChangeReceivedMsg.flags, paramCPGChangeReceivedMsg.timesent, paramCPGChangeReceivedMsg.token, paramCPGChangeReceivedMsg.seqInPG, paramCPGChangeReceivedMsg.groupName, arrayOfGroupUserChanged, paramCPGChangeReceivedMsg.attributes.flags, paramCPGChangeReceivedMsg.attributes.iconDownloadID, paramCPGChangeReceivedMsg.attributes.backgroundDownloadID, paramCPGChangeReceivedMsg.attributes.tagLine, paramCPGChangeReceivedMsg.attributes.tags, localLocationInfo, paramCPGChangeReceivedMsg.attributes.country, paramCPGChangeReceivedMsg.attributes.groupUri, paramCPGChangeReceivedMsg.pgAndSearchFlags.intValue(), Integer.valueOf(paramCPGChangeReceivedMsg.numWatchers), localPublicAccountAttributes, paramCPGChangeReceivedMsg.groupType.intValue(), paramCPGChangeReceivedMsg.group2Members, paramCPGChangeReceivedMsg.displayInvitationLink.intValue(), paramCPGChangeReceivedMsg.communityPrivileges.longValue(), paramCPGChangeReceivedMsg.chatBackground, paramCPGChangeReceivedMsg.attributeChangeType.intValue());
  }

  public void onPublicGroupsUpdated(PGLatestParamsWithRole[] paramArrayOfPGLatestParamsWithRole, long paramLong, Group2LatestParams[] paramArrayOfGroup2LatestParams)
  {
    if (d.r.i.d())
      return;
    int i = paramArrayOfPGLatestParamsWithRole.length + paramArrayOfGroup2LatestParams.length;
    if ((i == 0) || (d.ap.e.d() == paramLong))
    {
      this.b.getPublicGroupController().handleSendPublicGroupsUpdatedAck(paramLong);
      return;
    }
    ArrayList localArrayList = new ArrayList(i);
    int j = 0;
    int k = paramArrayOfPGLatestParamsWithRole.length;
    while (j < k)
    {
      localArrayList.add(new com.viber.voip.publicaccount.entity.c(paramArrayOfPGLatestParamsWithRole[j]));
      j++;
    }
    int m = 0;
    int i1 = paramArrayOfGroup2LatestParams.length;
    while (m < i1)
    {
      localArrayList.add(new com.viber.voip.publicaccount.entity.c(paramArrayOfGroup2LatestParams[m]));
      m++;
    }
    HashSet localHashSet = new HashSet(2);
    LongSparseArray localLongSparseArray = new LongSparseArray(i);
    ArrayMap localArrayMap = new ArrayMap(i);
    LongSparseSet localLongSparseSet = new LongSparseSet();
    int i2 = 0;
    int i3 = localArrayList.size();
    int i4 = 0;
    com.viber.voip.publicaccount.entity.c localc;
    r localr3;
    h localh2;
    label343: int i14;
    while (true)
      if (i4 < i3)
      {
        localc = (com.viber.voip.publicaccount.entity.c)localArrayList.get(i4);
        localr3 = this.g.d(localc.a());
        if (localc.l() == 1)
        {
          if ((localr3 != null) && (localr3.e() < localc.b()))
            this.k.a(this.b.getPhoneController().generateSequence(), localc.a(), localr3.b(), localc.b(), 3, 3);
          i4++;
        }
        else
        {
          localh2 = this.g.b(localc.a());
          if ((localr3 != null) && (localh2 != null))
            if ((localh2.i(3)) || (localh2.f()))
            {
              i11 = 1;
              if (i11 != 0)
              {
                if (localh2.f())
                  localh2.a(2);
                localr3.n(localc.d());
                localh2.h(3);
                if (localh2.g())
                  com.viber.voip.analytics.g.a().c().g().b(localh2.k(), localc.c());
              }
              if (localh2.K())
              {
                localh2.h(6);
                if (!localh2.g())
                  break label1465;
                if (!cd.b(localc.k()))
                  break label1458;
                i14 = 1;
                label447: localr3.x("");
                com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.a.a(localh2.o(), "admin", String.valueOf(localh2.k())));
                i2 = i14;
              }
            }
        }
      }
    label824: label1465: for (int i11 = 1; ; i11 = 1)
    {
      if (localh2.ar())
        localh2.a(36, false);
      localr3.e(localc.c());
      long l2 = localc.a();
      int i12 = 0;
      if (i11 != 0)
      {
        boolean bool = this.k.c(l2);
        i12 = 0;
        if (bool)
        {
          i12 = 1;
          this.k.d(l2);
          localLongSparseSet.add(l2);
        }
      }
      int i13;
      if (localc.d() > localr3.v())
      {
        localr3.h(localc.d());
        localr3.l(localc.f());
        localr3.m(localc.g());
        localr3.n(localc.h());
        localr3.o(localc.i());
        localr3.m(localc.e());
        if (localh2.A() < localc.j())
          localh2.e(localc.j());
        if ((localh2.g()) && (i12 == 0))
        {
          i13 = localr3.v();
          if (i11 == 0)
            break label824;
          a(localc.a(), com.viber.voip.messages.conversation.publicaccount.a.a.a(i13, localc.d(), localc.d()));
        }
      }
      while (true)
      {
        localLongSparseArray.put(localr3.a(), localr3);
        localArrayMap.put(Long.valueOf(localh2.getId()), localh2);
        localHashSet.add(Integer.valueOf(localh2.j()));
        if (localr3.e() >= localc.b())
          break;
        this.k.a(this.b.getPhoneController().generateSequence(), localc.a(), localr3.b(), localc.b(), localh2.j(), localh2.p());
        break;
        i11 = 0;
        break label343;
        a(localc.a(), com.viber.voip.messages.conversation.publicaccount.a.a.a(i13, localr3.K(), localc.d()));
      }
      int i9 = this.b.getPhoneController().generateSequence();
      int i10 = h.a(localc.a(), localc.m());
      PublicAccount localPublicAccount = new PublicAccount();
      localPublicAccount.setGroupID(localc.a());
      localPublicAccount.setGroupRole(localc.k());
      localPublicAccount.setRevision(localc.b());
      localPublicAccount.setWatchersCount(localc.c());
      localPublicAccount.setLastMessageId(localc.d());
      bs.e locale = bs.e.a().a(true).a();
      bs.f localf = ((bs)this.f.get()).a(i9, localc.a(), i10, localPublicAccount, locale);
      if ((com.viber.voip.messages.m.b(i10)) && (cd.b(localc.k())))
        i2 = 1;
      this.e.a(Collections.singleton(Long.valueOf(localf.f.getId())), i10, false, false);
      if (localf.f.g())
      {
        a(localc.a(), com.viber.voip.messages.conversation.publicaccount.a.a.a(0, localc.d(), localc.d()));
        break;
      }
      a(localc.a(), localc.d(), 0);
      break;
      com.viber.provider.b localb = ab.f();
      localb.a();
      try
      {
        int i5 = localLongSparseArray.size();
        for (int i6 = 0; i6 < i5; i6++)
        {
          r localr1 = (r)localLongSparseArray.get(localLongSparseArray.keyAt(i6));
          this.g.b(localr1);
        }
        Iterator localIterator1 = localArrayMap.entrySet().iterator();
        while (localIterator1.hasNext())
        {
          h localh1 = (h)((Map.Entry)localIterator1.next()).getValue();
          this.g.b(localh1);
          if (com.viber.voip.messages.m.b(localh1.j()))
          {
            r localr2 = (r)localLongSparseArray.get(localh1.k());
            Member localMember = new Member(localr2.G(), localr2.G(), dx.a(localr2.I()), localr2.H(), null, null, localr2.G());
            this.q.a(localh1, localMember, localr2.n(), false);
          }
        }
      }
      finally
      {
        localb.b();
      }
      localb.c();
      localb.b();
      if (i2 != 0)
        this.r.b();
      int i7 = 0;
      int i8 = localLongSparseSet.size();
      while (i7 < i8)
      {
        long l1 = localLongSparseSet.get(i7);
        this.m.post(new c.g(l1));
        i7++;
      }
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
      {
        Integer localInteger = (Integer)localIterator2.next();
        this.g.d(localInteger.intValue());
        this.e.a(localArrayMap.keySet(), localInteger.intValue(), false, false);
      }
      this.b.getPublicGroupController().handleSendPublicGroupsUpdatedAck(paramLong);
      d.ap.e.a(paramLong);
      return;
      i14 = i2;
      break label447;
    }
  }

  public void onValidatePublicGroupUri(String paramString, int paramInt1, int paramInt2)
  {
    this.e.a(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.q
 * JD-Core Version:    0.6.2
 */