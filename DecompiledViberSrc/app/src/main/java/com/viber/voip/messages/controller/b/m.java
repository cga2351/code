package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.GroupUserChanged;
import com.viber.jni.GroupUserInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.group.GroupControllerDelegate.GroupDelegate;
import com.viber.jni.im2.CRecoverGroupChatsReplyMsg;
import com.viber.jni.im2.CRecoverGroupChatsReplyMsg.Receiver;
import com.viber.jni.im2.ChatUserInfo;
import com.viber.jni.im2.GroupUserInfoShort;
import com.viber.jni.im2.RecoveredGroupChatInfo;
import com.viber.jni.secure.SecureMessagesController;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.memberid.a.a;
import com.viber.voip.memberid.d;
import com.viber.voip.messages.a.d.d;
import com.viber.voip.messages.controller.GroupController.GroupBaseDescription;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.a;
import com.viber.voip.messages.controller.bs.e;
import com.viber.voip.messages.controller.bs.e.a;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.bs.g;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.al.a;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.d.j.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.r;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.GlobalPermissions;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.b;
import com.viber.voip.settings.d.r;
import com.viber.voip.util.ae;
import com.viber.voip.util.cd;
import com.viber.voip.util.dx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class m extends l
  implements GroupControllerDelegate.GroupDelegate, CRecoverGroupChatsReplyMsg.Receiver
{
  private static final Logger n = ViberEnv.getLogger();
  protected com.viber.voip.messages.d.j d;
  protected com.viber.voip.messages.controller.manager.o e;
  protected dagger.a<bs> f;
  protected ab g;
  protected ak h;
  protected al i;
  protected bn j;
  protected com.viber.voip.messages.controller.af k;
  protected Map<Long, Runnable> l = new HashMap();
  protected EventBus m;
  private Map<String, ChatUserInfo> o = new HashMap();
  private a.a p = new a.a(com.viber.voip.av.a(av.e.d), true)
  {
    public void a()
    {
      d.b(m.a(m.this));
      m.b(m.this);
    }
  };

  public m(Context paramContext, com.viber.voip.messages.controller.af paramaf, com.viber.voip.registration.af paramaf1, dagger.a<bs> parama, bn parambn)
  {
    super(paramContext, paramaf1);
    this.f = parama;
    this.g = ab.b();
    this.h = ak.a();
    this.i = al.a();
    this.e = com.viber.voip.messages.controller.manager.o.a();
    this.m = com.viber.voip.h.a.b();
    this.j = parambn;
    this.k = paramaf;
    this.d = new com.viber.voip.messages.d.j(this.e, this.f, this.g, paramaf1);
  }

  private void a(final int paramInt, long paramLong, final Map<String, Integer> paramMap)
  {
    final com.viber.voip.model.entity.h localh = ((bs)this.f.get()).a(paramLong, true, "", 2, null, System.currentTimeMillis(), true, false, false).f;
    this.l.put(Long.valueOf(paramLong), new Runnable()
    {
      public void run()
      {
        m.this.e.a(paramInt, localh.k(), localh.getId(), paramMap, false);
        m.this.e.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), false, true);
      }
    });
  }

  private void a(int paramInt1, com.viber.voip.model.entity.h paramh, long paramLong, int paramInt2, GroupController.GroupBaseDescription paramGroupBaseDescription)
  {
    if (paramInt2 == 1)
    {
      String str = this.c.l();
      bs.g localg = ((bs)this.f.get()).a(paramh, paramGroupBaseDescription.name);
      MessageEntity localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramh.k(), 1, System.currentTimeMillis(), str, 16, paramLong, com.viber.voip.messages.j.a(str, localg.b, localg.c));
      ((bs)this.f.get()).a(localMessageEntity);
    }
    this.e.a(paramInt1, paramh.k(), paramInt2);
  }

  private void a(CRecoverGroupChatsReplyMsg paramCRecoverGroupChatsReplyMsg)
  {
    for (RecoveredGroupChatInfo localRecoveredGroupChatInfo : paramCRecoverGroupChatsReplyMsg.groupChats)
      if (this.g.b(localRecoveredGroupChatInfo.groupID) == null)
      {
        bs.f localf = ((bs)this.f.get()).a(localRecoveredGroupChatInfo.groupID, false, localRecoveredGroupChatInfo.groupName, localRecoveredGroupChatInfo.groupRole, dx.h(localRecoveredGroupChatInfo.iconDownloadID), ae.a(), true, false, false);
        if (localf.c)
        {
          j.a[] arrayOfa = new j.a[localRecoveredGroupChatInfo.members.length];
          for (int i3 = 0; i3 < localRecoveredGroupChatInfo.members.length; i3++)
          {
            String str = localRecoveredGroupChatInfo.members[i3].mid;
            int i4 = localRecoveredGroupChatInfo.members[i3].groupRole;
            ChatUserInfo localChatUserInfo = (ChatUserInfo)this.o.get(str);
            if (localChatUserInfo != null)
              arrayOfa[i3] = new j.a(Member.from(localChatUserInfo, localf.f.j()), i4);
          }
          this.d.a(localf.f.getId(), localf.f.j(), localRecoveredGroupChatInfo.groupRole, arrayOfa);
        }
      }
  }

  private void b()
  {
    if (d.r.h.d())
      this.b.getGroupController().handleRecoverGroupChats();
    if (d.r.i.d())
      this.b.getGroupController().handleRecoverPublicAccounts();
  }

  private void b(int paramInt1, com.viber.voip.model.entity.h paramh, long paramLong, int paramInt2, GroupController.GroupBaseDescription paramGroupBaseDescription)
  {
    if (1 == paramInt2)
    {
      String str = this.c.l();
      Uri localUri = dx.b(paramGroupBaseDescription.iconId);
      this.g.a(paramh.getId(), localUri);
      MessageEntity localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramh.k(), 1, System.currentTimeMillis(), str, 16, paramLong, com.viber.voip.messages.j.a(str, localUri));
      ((bs)this.f.get()).a(localMessageEntity);
    }
    this.e.b(paramInt1, paramh.k(), paramInt2);
  }

  private void b(com.viber.voip.model.entity.h paramh, int paramInt)
  {
    this.i.a(paramh.getId(), paramInt);
    this.e.c(Collections.singleton(Long.valueOf(paramh.getId())), false);
  }

  private void c()
  {
    d.a(this.p);
  }

  private void d()
  {
    Iterator localIterator1 = com.viber.voip.model.e.a("key_not_synced_group", true).iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      int i2 = this.b.getPhoneController().generateSequence();
      this.b.getGroupController().handleGetGroupInfo(i2, Long.valueOf(str2).longValue());
    }
    Iterator localIterator2 = com.viber.voip.model.e.a("key_not_synced_public_group", true).iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      long l1 = Long.valueOf(str1).longValue();
      int i1 = this.b.getPhoneController().generateSequence();
      com.viber.voip.model.entity.h localh = this.g.b(l1);
      com.viber.voip.model.e.a(str1, new String[] { "key_not_synced_public_group" });
      if (localh != null)
        this.k.a(i1, l1, null, 0, localh.j(), localh.p());
    }
  }

  private void e()
  {
    if (!this.b.getPhoneController().isConnected());
    List localList;
    do
    {
      return;
      localList = this.i.b();
    }
    while (localList.size() == 0);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    long l1 = -1L;
    int i1 = -1;
    label56: al.a locala;
    long l2;
    int i2;
    if (localIterator.hasNext())
    {
      locala = (al.a)localIterator.next();
      if ((locala.a() == l1) && (locala.b() == i1))
        break label217;
      if (localArrayList.size() != 0)
      {
        this.k.a(l1, (String[])localArrayList.toArray(new String[localArrayList.size()]), i1);
        localArrayList.clear();
      }
      l2 = locala.a();
      i2 = locala.b();
    }
    while (true)
    {
      localArrayList.add(locala.c());
      l1 = l2;
      i1 = i2;
      break label56;
      if (localArrayList.size() == 0)
        break;
      this.k.a(l1, (String[])localArrayList.toArray(new String[localArrayList.size()]), i1);
      return;
      label217: i2 = i1;
      l2 = l1;
    }
  }

  private void f()
  {
    if (!this.b.getPhoneController().isConnected());
    while (true)
    {
      return;
      List localList = this.g.a(3);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)localIterator.next();
          this.k.a(localPublicGroupConversationItemLoaderEntity.getGroupId(), new PublicAccount.GlobalPermissions(localPublicGroupConversationItemLoaderEntity.getCommunityPrivileges()));
        }
      }
    }
  }

  protected bs.f a(MessageEntity paramMessageEntity, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramMessageEntity, paramString, paramBoolean1, paramBoolean2, false);
  }

  protected bs.f a(MessageEntity paramMessageEntity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    bs.f localf = ((bs)this.f.get()).a(paramMessageEntity, paramString, paramBoolean3);
    if ((localf.b) && (!paramBoolean1) && ((!paramMessageEntity.isRoleFollower()) || (paramBoolean2)) && (!paramMessageEntity.isRead()) && (!paramMessageEntity.isSilentMessage()) && (1007 != paramMessageEntity.getMimeType()))
      this.j.a(localf.f, localf.g, localf.h);
    return localf;
  }

  protected MessageEntity a(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, long paramLong2, long paramLong3, String paramString2, Map<Member, Integer> paramMap, com.viber.voip.model.entity.h paramh, int paramInt4)
  {
    int i1;
    boolean bool1;
    PublicAccount localPublicAccount;
    int i2;
    label72: int i3;
    label108: boolean bool3;
    label132: boolean bool4;
    label149: bs.e.a locala3;
    if ((paramInt3 & 0x1) != 0)
    {
      i1 = 1;
      bool1 = a(paramInt3, paramInt1, paramMap);
      boolean bool2 = com.viber.voip.messages.m.e(paramInt1);
      if ((i1 == 0) && ((!bool1) || (!bool2)))
        break label457;
      if (!bool2)
        break label381;
      localPublicAccount = new PublicAccount();
      if ((!localPublicAccount.hasPublicChat()) || (bool1))
        break label328;
      i2 = 1;
      localPublicAccount.setGroupID(paramLong1);
      localPublicAccount.setGroupRole(i2);
      localPublicAccount.setRevision(paramInt2);
      localPublicAccount.setName(paramString2);
      if (!bool1)
        break label334;
      i3 = paramInt4;
      localPublicAccount.setLastMessageId(i3);
      bs.e.a locala1 = bs.e.a().a(true);
      if (bool1)
        break label343;
      bool3 = true;
      bs.e.a locala2 = locala1.b(bool3);
      if (bool1)
        break label349;
      bool4 = true;
      locala3 = locala2.c(bool4);
      if (bool1)
        break label355;
    }
    String str1;
    label328: label334: label343: label349: label355: for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = null)
    {
      bs.e locale = locala3.a(localBoolean).a();
      bs.f localf = ((bs)this.f.get()).a(this.b.getPhoneController().generateSequence(), paramLong1, paramInt1, Pair.create(paramString1, Long.valueOf(paramLong3)), localPublicAccount, paramLong2, locale);
      if (com.viber.voip.messages.m.b(paramInt1))
      {
        this.m.post(new d.d(paramInt1));
        int i4 = paramInt4 - 1;
        if ((localf.c) && (!bool1) && (i4 > 0))
          a(paramLong1, com.viber.voip.messages.conversation.publicaccount.a.a.a(0, i4, i4));
      }
      if (bool1)
        break label912;
      str1 = this.c.l();
      if (!com.viber.voip.messages.m.b(paramInt1))
        break label361;
      return com.viber.voip.messages.controller.c.c.a(paramLong1, paramInt1, str1, paramLong2, 0, paramLong3, paramInt4);
      i1 = 0;
      break;
      i2 = 2;
      break label72;
      i3 = paramInt4 - 1;
      break label108;
      bool3 = false;
      break label132;
      bool4 = false;
      break label149;
    }
    label361: return com.viber.voip.messages.controller.c.c.a(paramLong1, paramInt1, paramLong2, str1, 0, paramLong3, com.viber.voip.messages.j.b(str1), paramInt4);
    label381: if (paramMap.isEmpty());
    for (int i5 = 1; ; i5 = ((Integer)paramMap.values().iterator().next()).intValue())
    {
      a(paramh, i5);
      return com.viber.voip.messages.controller.c.c.a(paramLong1, paramInt1, paramLong2, paramString1, paramInt3 & 0xFFFFFFEF, paramLong3, com.viber.voip.messages.j.b(this.c.l()));
    }
    label457: String[] arrayOfString;
    String str2;
    if ((paramh != null) && (!paramMap.isEmpty()))
    {
      arrayOfString = new String[paramMap.size()];
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramMap.entrySet().iterator();
      int i6 = 0;
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Member localMember = (Member)localEntry.getKey();
        com.viber.voip.model.entity.m localm = this.h.a(localMember, cd.j(paramInt1));
        com.viber.voip.messages.d.c.c().a(localm, localMember);
        if ((paramh.d()) && (TextUtils.isEmpty(localm.d())))
          localHashSet.add(localm.a());
        while (true)
        {
          int i8 = i6 + 1;
          arrayOfString[i6] = localm.a();
          this.i.a(paramh.getId(), 0, ((Integer)localEntry.getValue()).intValue(), localm.getId());
          i6 = i8;
          break;
          if ((localm.i() == 0L) && (localm.s()))
            localHashSet.add(localm.a());
        }
      }
      if ((localHashSet.size() > 0) && (paramh.p() != 3))
        ViberApplication.getInstance().getMessagesManager().e().a(localHashSet, null, false);
      if (paramInt4 == -1L)
      {
        this.e.c(Collections.singleton(Long.valueOf(paramh.getId())), false);
        return null;
      }
      if (arrayOfString.length == 1)
      {
        str2 = arrayOfString[0];
        if (!com.viber.voip.util.av.d(paramInt3, 16))
          break label914;
      }
    }
    label912: label914: for (int i7 = com.viber.voip.util.av.e(com.viber.voip.util.av.f(paramInt3, 16), 64); ; i7 = paramInt3)
    {
      MessageEntity localMessageEntity;
      if (com.viber.voip.messages.m.b(paramInt1))
      {
        localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramLong1, paramInt1, str2, paramLong2, i7, paramLong3, paramInt4);
        this.g.f(paramh.getId(), paramh.j());
        this.e.c(Collections.singleton(Long.valueOf(paramh.getId())), false);
        return localMessageEntity;
        str2 = paramString1;
        break;
      }
      if (arrayOfString.length == 1);
      for (String str3 = com.viber.voip.messages.j.b(arrayOfString[0]); ; str3 = com.viber.voip.messages.j.a(arrayOfString))
      {
        localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramLong1, paramInt1, paramLong2, str2, i7, paramLong3, str3, paramInt4);
        break;
      }
      return null;
    }
  }

  public EventBus a()
  {
    return a.a();
  }

  protected final void a(long paramLong, int paramInt)
  {
    int i1 = this.b.getPhoneController().generateSequence();
    ViberApplication.getInstance().getMessagesManager().d().a(i1, paramLong, paramInt, true);
  }

  protected void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  protected void a(long paramLong, int paramInt1, int paramInt2, String paramString, bs.f paramf)
  {
    int i1;
    int i2;
    label23: int i3;
    if ((paramInt1 == 4) || (paramInt1 == 1))
    {
      i1 = 1;
      if ((paramInt2 & 0x1) == 0)
        break label202;
      i2 = 1;
      if ((paramf == null) || (!paramf.b))
        break label208;
      i3 = 1;
      label39: bool1 = false;
      if (i3 != 0)
      {
        bool1 = false;
        if (i1 != 0)
        {
          bool1 = false;
          if (i2 != 0)
          {
            boolean bool2 = com.viber.voip.messages.m.a(this.c, paramString);
            bool1 = false;
            if (!bool2)
            {
              com.viber.voip.model.entity.m localm = paramf.g;
              bool1 = false;
              if (localm != null)
              {
                if (localm.i() > 0L)
                  break label214;
                bool1 = true;
                label110: if ((bool1) && (paramf.f != null))
                {
                  ak localak = this.h;
                  long l1 = localm.getId();
                  com.viber.voip.registration.af localaf = this.c;
                  Long[] arrayOfLong = new Long[1];
                  arrayOfLong[0] = Long.valueOf(paramf.f.getId());
                  if (localak.a(l1, localaf, arrayOfLong))
                    break label220;
                }
              }
            }
          }
        }
      }
    }
    label202: label208: label214: label220: for (boolean bool1 = true; ; bool1 = false)
    {
      this.b.getPhoneController().handleSendGroupChangedAck(paramLong, bool1);
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label23;
      i3 = 0;
      break label39;
      bool1 = false;
      break label110;
    }
  }

  protected final void a(long paramLong, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0));
    while (true)
    {
      return;
      int i1 = paramArrayOfInt.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        int i3 = paramArrayOfInt[i2];
        if (i3 > 0)
          a(paramLong, i3);
      }
    }
  }

  protected void a(com.viber.voip.model.entity.h paramh, int paramInt)
  {
    if ((paramh != null) && (paramh.K()))
    {
      paramh.c(paramInt);
      paramh.h(6);
      this.g.b(paramh);
      this.m.post(new d.d(paramh.j()));
    }
  }

  protected void a(com.viber.voip.model.entity.h paramh, GroupUserChanged[] paramArrayOfGroupUserChanged)
  {
    int i1 = paramArrayOfGroupUserChanged.length;
    int i2 = 0;
    if (i2 < i1)
    {
      GroupUserChanged localGroupUserChanged = paramArrayOfGroupUserChanged[i2];
      if (com.viber.voip.messages.m.a(this.c, localGroupUserChanged.getUser().memberId))
      {
        this.d.a(paramh.getId(), paramh.j(), localGroupUserChanged.getRole());
        if (com.viber.voip.messages.m.b(paramh.j()))
        {
          com.viber.voip.messages.m.a(paramh, paramh.p(), localGroupUserChanged.getRole());
          paramh.a(28, false);
        }
        int i3 = paramh.p();
        paramh.c(localGroupUserChanged.getRole());
        this.g.b(paramh);
        a(paramh.k(), paramh.j(), i3, localGroupUserChanged.getRole());
        this.m.post(new d.d(paramh.j()));
        this.e.a(Collections.singleton(Long.valueOf(paramh.getId())), paramh.j(), false, false);
      }
      while (true)
      {
        this.e.c(Collections.singleton(Long.valueOf(paramh.getId())), false);
        i2++;
        break;
        Member localMember = Member.from(localGroupUserChanged.getUser(), paramh.j(), paramh.p());
        com.viber.voip.model.entity.m localm = this.h.a(localMember, cd.j(paramh.j()));
        this.i.a(paramh.getId(), 0, localGroupUserChanged.getRole(), localm.getId());
        cd.a(localGroupUserChanged.getUser().downloadID, localm.b(), "MessageGroupDelegateImpl [assignGroupMemberRole] role=" + localGroupUserChanged.getRole(), localMember.getPhotoUri());
      }
    }
  }

  protected boolean a(int paramInt1, int paramInt2, Map<Member, Integer> paramMap)
  {
    return ((paramInt1 & 0x10) != 0) && ((!com.viber.voip.messages.m.b(paramInt2)) || (paramMap.size() == 0));
  }

  public void onCRecoverGroupChatsReplyMsg(CRecoverGroupChatsReplyMsg paramCRecoverGroupChatsReplyMsg)
  {
    com.viber.provider.b localb;
    if (paramCRecoverGroupChatsReplyMsg.status == 0)
    {
      if (paramCRecoverGroupChatsReplyMsg.chunkSeq == 0)
        this.o.clear();
      this.o.putAll(paramCRecoverGroupChatsReplyMsg.users);
      if ((paramCRecoverGroupChatsReplyMsg.groupChats != null) && (paramCRecoverGroupChatsReplyMsg.groupChats.length > 0))
      {
        localb = ab.f();
        localb.a();
      }
    }
    do
    {
      do
        try
        {
          a(paramCRecoverGroupChatsReplyMsg);
          localb.c();
          localb.b();
          if (paramCRecoverGroupChatsReplyMsg.last)
          {
            this.o.clear();
            d.r.h.a(false);
            if (((paramCRecoverGroupChatsReplyMsg.groupChats != null) && (paramCRecoverGroupChatsReplyMsg.groupChats.length != 0)) || ((paramCRecoverGroupChatsReplyMsg.secureGroupChats != null) && (paramCRecoverGroupChatsReplyMsg.secureGroupChats.length != 0)))
              continue;
            com.viber.voip.analytics.story.k.a(2);
            if ((com.viber.voip.registration.c.e.d.a().equals(d.b.d.d())) && (!ao.f()))
              com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.b(new Date()));
          }
          return;
        }
        finally
        {
          localb.b();
        }
      while (ao.f());
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.b(new Date()));
      return;
      if (paramCRecoverGroupChatsReplyMsg.status == 1)
      {
        com.viber.voip.analytics.story.k.a(2);
        return;
      }
    }
    while (paramCRecoverGroupChatsReplyMsg.status != 2);
    d.r.h.a(false);
    com.viber.voip.analytics.story.k.a(2);
  }

  public void onChangeGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.viber.voip.model.entity.h localh = this.g.b(paramLong1);
    if (localh == null)
    {
      this.k.f(paramInt1);
      return;
    }
    GroupController.GroupBaseDescription localGroupBaseDescription;
    if (localh.j() == 1)
    {
      localGroupBaseDescription = this.k.e(paramInt1);
      if (localGroupBaseDescription != null)
        break label70;
      this.e.b(paramLong1, paramInt4);
    }
    while (true)
    {
      this.k.f(paramInt1);
      return;
      label70: if (localGroupBaseDescription.isNameModified())
        a(paramInt1, localh, paramLong2, paramInt4, localGroupBaseDescription);
      if (localGroupBaseDescription.isIconModified())
        b(paramInt1, localh, paramLong2, paramInt4, localGroupBaseDescription);
    }
  }

  public void onCreateGroupReply(int paramInt1, int paramInt2, long paramLong, Map<String, Integer> paramMap)
  {
    if (this.k.i(paramInt2) != null)
      return;
    if (paramInt1 == 0)
    {
      a(paramInt2, paramLong, paramMap);
      return;
    }
    this.e.a(paramInt2, paramInt1, paramMap);
  }

  public void onGroupAddMembers(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String[] paramArrayOfString, Map<String, Integer> paramMap, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList;
    String[] arrayOfString;
    com.viber.voip.model.entity.h localh;
    if (paramInt3 == 0)
    {
      localArrayList = new ArrayList(Arrays.asList(paramArrayOfString));
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (3 == ((Integer)localEntry.getValue()).intValue())
            localArrayList.add(localEntry.getKey());
        }
      }
      int i1 = localArrayList.size();
      arrayOfString = new String[i1];
      HashSet localHashSet = new HashSet(i1);
      localh = this.g.b(paramLong1);
      if ((localArrayList.isEmpty()) || (localh.g()))
      {
        this.e.a(paramInt1, paramLong1, paramInt3, paramMap);
        return;
      }
      r localr = this.g.d(paramLong1);
      int i4;
      int i2;
      label204: int i3;
      label207: bs.a locala;
      if (localr != null)
        if (localr.S())
        {
          i4 = 1;
          i2 = i4;
          i3 = 0;
          if (i3 >= i1)
            break label347;
          locala = ((bs)this.f.get()).a(localh, (String)localArrayList.get(i3), 0, i2);
          arrayOfString[i3] = locala.c.a();
          if (locala.c.i() != 0L)
            break label307;
          localHashSet.add(localArrayList.get(i3));
        }
      while (true)
      {
        i3++;
        break label207;
        i4 = 2;
        break;
        i2 = 1;
        break label204;
        label307: if ((localh.d()) && (TextUtils.isEmpty(locala.c.d())))
          localHashSet.add(localArrayList.get(i3));
      }
      label347: if (!localHashSet.isEmpty())
        ViberApplication.getInstance().getMessagesManager().e().a(localHashSet, null, false);
      if (i1 != 1)
        break label477;
    }
    label477: for (String str = com.viber.voip.messages.j.b((String)localArrayList.get(0)); ; str = com.viber.voip.messages.j.a(arrayOfString))
    {
      ((bs)this.f.get()).a(com.viber.voip.messages.controller.c.c.a(paramLong1, localh.j(), System.currentTimeMillis(), (String)localArrayList.get(0), 64, paramLong2, str, paramInt2));
      this.e.c(Collections.singleton(Long.valueOf(localh.getId())), false);
      this.e.a(paramInt1, paramLong1, paramInt3, paramMap);
      return;
    }
  }

  public void onGroupAssignRole(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, String[] paramArrayOfString, Map<String, Integer> paramMap, int paramInt4, int paramInt5)
  {
    com.viber.voip.model.entity.h localh = this.g.b(paramLong1);
    if (localh == null)
      return;
    if (paramInt4 == 0)
    {
      ArrayList localArrayList = new ArrayList();
      for (int i1 = 0; i1 < paramArrayOfString.length; i1++)
        localArrayList.add(new GroupUserChanged(new GroupUserInfo(paramArrayOfString[i1], "", ""), paramInt3));
      Iterator localIterator = paramMap.entrySet().iterator();
      int i2 = 0;
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Integer)localEntry.getValue()).intValue() == 3)
          localArrayList.add(new GroupUserChanged(new GroupUserInfo((String)localEntry.getKey(), "", ""), paramInt3));
        for (int i3 = i2; ; i3 = 1)
        {
          i2 = i3;
          break;
        }
      }
      a(localh, (GroupUserChanged[])localArrayList.toArray(new GroupUserChanged[localArrayList.size()]));
      if (i2 != 0)
        b(localh, paramInt3);
    }
    while (true)
    {
      this.e.a(paramInt4, paramArrayOfString, paramInt3, paramMap);
      return;
      if (paramInt4 != 6)
      {
        b(localh, paramInt3);
        if (paramInt4 == 2)
        {
          int i4 = this.b.getPhoneController().generateSequence();
          if (localh.e())
            this.k.a(i4, paramLong1, "", paramInt5, localh.j(), localh.p());
          else
            this.k.a(i4, paramLong1);
        }
      }
    }
  }

  public boolean onGroupChanged(long paramLong1, String paramString1, long paramLong2, int paramInt1, long paramLong3, String paramString2, String paramString3, int paramInt2, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt3, String paramString4)
  {
    com.viber.voip.model.entity.h localh = this.g.b(paramLong1);
    boolean bool1;
    int i1;
    label31: int i2;
    label45: int i3;
    label65: int i4;
    label78: Object localObject;
    if ((paramInt1 & 0x10) != 0)
    {
      bool1 = true;
      if ((paramInt1 & 0x1) == 0)
        break label190;
      i1 = 1;
      if ((paramInt2 != 1) || (i1 == 0))
        break label196;
      i2 = 1;
      if ((paramInt2 != 1) || (!com.viber.voip.util.av.d(paramInt1, 65536)))
        break label202;
      i3 = 1;
      if ((i2 == 0) || (i3 == 0))
        break label208;
      i4 = 1;
      localObject = null;
    }
    label190: label196: label202: label208: MessageEntity localMessageEntity;
    switch (paramInt2)
    {
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    default:
    case 4:
      while (true)
      {
        bs.f localf = null;
        if (localObject != null)
          localf = a((MessageEntity)localObject, paramString1, bool1, false);
        a(paramLong2, paramInt2, paramInt1, paramString2, localf);
        return false;
        bool1 = false;
        break;
        i1 = 0;
        break label31;
        i2 = 0;
        break label45;
        i3 = 0;
        break label65;
        i4 = 0;
        break label78;
        HashMap localHashMap = new HashMap(paramArrayOfGroupUserChanged.length);
        for (int i11 = 0; i11 < paramArrayOfGroupUserChanged.length; i11++)
        {
          GroupUserChanged localGroupUserChanged = paramArrayOfGroupUserChanged[i11];
          Member localMember2 = Member.from(localGroupUserChanged.getUser(), 1, 1);
          localHashMap.put(localMember2, Integer.valueOf(localGroupUserChanged.getRole()));
          cd.a(localGroupUserChanged.getUser().downloadID, localMember2.getEncryptedMemberId(), "MessageGroupDelegateImpl [onGroupChanged] GROUP_MEMBER_ADDED_MEMBERS ", localMember2.getPhotoUri());
        }
        localObject = a(1, paramLong1, 0, paramString2, paramInt1, paramLong3, paramLong2, paramString1, localHashMap, localh, 0);
      }
    case 3:
      if ((paramInt3 & 0x1) > 0)
      {
        String str4 = "";
        if (localh != null)
          str4 = ((bs)this.f.get()).a(localh, paramString1).b;
        localObject = com.viber.voip.messages.controller.c.c.a(paramLong1, 1, paramLong3, paramString2, paramInt1, paramLong2, com.viber.voip.messages.j.a(paramString2, str4, paramString1));
      }
      while (localObject != null)
      {
        break;
        int i10 = paramInt3 & 0x2;
        localObject = null;
        if (i10 > 0)
        {
          Uri localUri4 = dx.h(paramString4);
          localObject = com.viber.voip.messages.controller.c.c.a(paramLong1, 1, paramLong3, paramString2, paramInt1, paramLong2, com.viber.voip.messages.j.a(paramString2, localUri4));
          if (localh != null)
            ((bs)this.f.get()).a(localh, localUri4);
        }
      }
    case 1:
      if (i4 != 0)
      {
        if (localh != null)
          break label1341;
        Uri localUri3 = dx.h(paramString4);
        ((bs)this.f.get()).a(paramLong1, false, paramString1, 1, localUri3, paramLong3, true, false, false);
        int i9 = this.b.getPhoneController().generateSequence();
        a().post(new b(paramLong1, i9));
        this.k.a(i9, paramLong1);
        localMessageEntity = null;
      }
      break;
    case 2:
    case 10:
    case 11:
    case 13:
    case 12:
    }
    while (true)
    {
      label558: if (d.c());
      com.viber.voip.model.entity.m localm;
      for (String str3 = null; ; str3 = paramString2)
      {
        Member localMember1 = new Member(paramString2, str3, null, paramString3, null);
        localm = this.h.a(localMember1, 1);
        if (i2 != 0)
          break label837;
        if (localh != null)
          this.i.a(localh.getId(), 0, 1, localm.getId());
        if ((localm.i() != 0L) || (!localm.s()))
          break label806;
        ViberApplication.getInstance().getMessagesManager().e().a(paramString2, null, false);
        localObject = localMessageEntity;
        break;
        if ((i2 != 0) && (paramString2.equals(this.c.l())))
        {
          Uri localUri2 = dx.h(paramString4);
          ((bs)this.f.get()).a(paramLong1, true, paramString1, 2, localUri2, paramLong3, true, false);
          localMessageEntity = null;
          break label558;
        }
        int i7 = paramInt1 & 0xFFFFFFEF;
        String str2;
        if (i2 != 0)
          str2 = com.viber.voip.messages.j.b(this.c.l());
        while (true)
        {
          localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramLong1, 1, paramLong3, paramString2, i7, paramLong2, str2);
          break;
          if (i3 != 0)
            str2 = com.viber.voip.messages.j.e(paramString2);
          else
            str2 = com.viber.voip.messages.j.b(paramString2);
        }
      }
      label806: if (localh != null)
      {
        this.e.c(Collections.singleton(Long.valueOf(localh.getId())), false);
        localObject = localMessageEntity;
        break;
        if (localh != null)
        {
          localh.b(paramString1);
          localh.j(localm.getId());
          localh.h(6);
          this.g.b(localh);
          this.e.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), false, false);
          int i8 = this.b.getPhoneController().generateSequence();
          if (i4 != 0)
            a().post(new b(paramLong1, i8));
          this.k.a(i8, paramLong1);
          localObject = localMessageEntity;
          break;
          this.d.a(localh, paramInt1, paramString2);
          localObject = null;
          break;
          int i6 = paramArrayOfGroupUserChanged.length;
          localObject = null;
          if (i6 <= 0)
            break;
          localObject = null;
          if (i1 != 0)
          {
            if (localh == null)
            {
              Uri localUri1 = dx.g(paramString4);
              ((bs)this.f.get()).a(paramLong1, true, paramString1, paramArrayOfGroupUserChanged[0].getRole(), localUri1, paramLong3, false, false);
            }
            localObject = com.viber.voip.messages.controller.c.c.a(paramLong1, 1, paramLong3, paramArrayOfGroupUserChanged[0].getUser().memberId, paramInt1, paramLong2, com.viber.voip.messages.j.a(this.c.l(), paramArrayOfGroupUserChanged[0]));
          }
          if (localh == null)
            break;
          a(localh, paramArrayOfGroupUserChanged);
          break;
          ArrayList localArrayList = new ArrayList(paramArrayOfGroupUserChanged.length);
          for (int i5 = 0; i5 < paramArrayOfGroupUserChanged.length; i5++)
          {
            String str1 = paramArrayOfGroupUserChanged[i5].getUser().memberId;
            if (this.d.a(localh, paramInt1, str1))
              localArrayList.add(str1);
          }
          boolean bool3 = localArrayList.isEmpty();
          localObject = null;
          if (bool3)
            break;
          localObject = com.viber.voip.messages.controller.c.c.a(paramLong1, 1, System.currentTimeMillis(), paramString2, paramInt1, paramLong2, com.viber.voip.messages.j.a(paramString2, (String[])localArrayList.toArray(new String[localArrayList.size()])));
          break;
          if (localh != null)
          {
            this.g.f(localh.getId(), paramString1);
            localh.b(paramString1);
          }
          if (localh != null)
          {
            boolean bool2 = ViberApplication.getInstance().getEngine(true).getSecureMessagesController().isGroupSecure(localh.k());
            ((bs)this.f.get()).b(localh.getId(), 14, bool2);
            localObject = null;
            break;
          }
          ((bs)this.f.get()).a(paramLong1, true, paramString1, 1, null, ae.a(), true, false);
          localObject = null;
          break;
        }
      }
      label837: localObject = localMessageEntity;
      break;
      label1341: localMessageEntity = null;
    }
  }

  public void onGroupInfo(int paramInt1, long paramLong, String paramString1, String paramString2, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3)
  {
    switch (paramInt4)
    {
    default:
      return;
    case 0:
      com.viber.voip.model.entity.h localh = this.g.b(paramLong);
      if (localh != null)
      {
        localh.b(paramString2);
        localh.a(dx.h(paramString1));
        localh.c(paramInt3);
        localh.l(paramInt5);
        boolean bool1 = com.viber.voip.util.av.d(paramInt2, 4);
        boolean bool2 = com.viber.voip.util.av.d(paramInt2, 2);
        localh.a(24, bool1);
        localh.a(14, bool2);
        ak localak = this.h;
        long l1 = localh.Z();
        com.viber.voip.registration.af localaf = this.c;
        Long[] arrayOfLong = new Long[1];
        arrayOfLong[0] = Long.valueOf(localh.getId());
        if (localak.a(l1, localaf, arrayOfLong))
        {
          localh.a(9, true);
          localh.a(10, false);
        }
        this.g.b(localh);
        this.m.post(new d.d(localh.j()));
        j.a[] arrayOfa = new j.a[paramArrayOfGroupUserChanged.length];
        for (int i1 = 0; i1 < paramArrayOfGroupUserChanged.length; i1++)
        {
          Member localMember = Member.from(paramArrayOfGroupUserChanged[i1].getUser(), localh.j(), paramInt3);
          arrayOfa[i1] = new j.a(localMember, paramArrayOfGroupUserChanged[i1].getRole());
          cd.a(paramArrayOfGroupUserChanged[i1].getUser().downloadID, null, "ParticipantManagerImpl [recoverParticipantPhoto]", localMember.getPhotoUri());
        }
        this.d.a(localh.getId(), localh.j(), paramInt3, arrayOfa);
        Runnable localRunnable = (Runnable)this.l.remove(Long.valueOf(paramLong));
        if (localRunnable == null)
          break label387;
        com.viber.voip.analytics.g.a().c().g().a(String.valueOf(paramLong), "Create Chat Icon", 1 + arrayOfa.length);
        localRunnable.run();
      }
      while (true)
      {
        com.viber.voip.model.e.a(String.valueOf(paramLong), new String[] { "key_not_synced_group" });
        return;
        label387: this.e.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), true, true);
      }
    case 1:
    }
    this.d.a(this.g.b(paramLong), paramInt2, this.c.l());
    com.viber.voip.model.e.a(String.valueOf(paramLong), new String[] { "key_not_synced_group" });
  }

  public void onServiceStateChanged(int paramInt)
  {
    if (paramInt == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal())
    {
      b();
      c();
      e();
      f();
    }
  }

  private static class a
  {
    private static final EventBus a = com.viber.voip.h.a.d();
  }

  public static class b
  {
    public final long a;
    public final int b;

    public b(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.m
 * JD-Core Version:    0.6.2
 */