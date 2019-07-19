package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.support.v4.util.LongSparseArray;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.ConversationSettings;
import com.viber.jni.ConversationToken;
import com.viber.jni.Engine;
import com.viber.jni.GroupToken;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.messenger.MessengerDelegate.DeleteMessages;
import com.viber.jni.messenger.MessengerDelegate.SyncReceiver;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.d.d;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ab.c;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.a.b;
import com.viber.voip.model.a.d;
import com.viber.voip.model.a.d.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.m;
import com.viber.voip.model.entity.r;
import com.viber.voip.notif.e.s;
import com.viber.voip.notif.g;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.dx;
import com.viber.voip.util.n;
import dagger.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class o extends l
  implements MessengerDelegate.DeleteMessages, MessengerDelegate.SyncReceiver
{
  private static final Logger d = ViberEnv.getLogger();
  private a<com.viber.voip.util.e.e> e;
  private com.viber.voip.messages.controller.manager.o f;
  private ab g;
  private a<bs> h;
  private CallHandler i;
  private final ai j;
  private UserData k;
  private Set<Long> l = new HashSet();
  private Set<Long> m = new HashSet();
  private a n = new a();
  private final bv.e o = new bv.d()
  {
    public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if ((paramAnonymousBoolean2) && (o.this.b != null) && (o.this.b.isReady()))
        o.b(o.this);
    }

    public void onDelete(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousBoolean) && (o.this.b != null) && (o.this.b.isReady()))
        o.a(o.this);
    }

    public void onRead(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousBoolean) && (o.this.b != null) && (o.this.b.isReady()))
        o.a(o.this, paramAnonymousSet);
    }
  };
  private bv.l p = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousBoolean) && (o.this.b != null) && (o.this.b.isReady()))
        o.c(o.this);
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if ((paramAnonymousBoolean2) && (o.this.b != null) && (o.this.b.isReady()))
        o.a(o.this, paramAnonymousSet);
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };
  private EventBus q;

  public o(Context paramContext, UserManager paramUserManager, com.viber.voip.messages.controller.manager.o paramo, ab paramab, a<bs> parama, CallHandler paramCallHandler, a<com.viber.voip.util.e.e> parama1, EventBus paramEventBus, ai paramai)
  {
    super(paramContext, paramUserManager.getRegistrationValues());
    this.e = parama1;
    this.f = paramo;
    this.g = paramab;
    this.k = paramUserManager.getUserData();
    this.h = parama;
    this.i = paramCallHandler;
    this.q = paramEventBus;
    this.j = paramai;
    this.f.a(this.o);
    this.f.a(this.p);
  }

  private void a()
  {
    if (!this.b.getPhoneController().isConnected());
    ArrayList localArrayList1;
    ArrayList localArrayList3;
    do
    {
      List localList;
      do
      {
        return;
        localList = this.g.h();
      }
      while (localList.size() == 0);
      localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        MessageEntity localMessageEntity = (MessageEntity)localIterator.next();
        if (localMessageEntity.isPublicGroupBehavior())
          this.b.getPhoneController().handleGlobalDeleteMessage(localMessageEntity.getGroupId(), localMessageEntity.getMessageToken(), localMessageEntity.getMessageGlobalId(), this.b.getPhoneController().generateSequence());
        else if (localMessageEntity.isSecretMessage())
          localArrayList2.add(Long.valueOf(localMessageEntity.getMessageToken()));
        else if (localMessageEntity.isGroupBehavior())
          localArrayList3.add(new GroupToken(localMessageEntity.getMessageToken(), localMessageEntity.getGroupId()));
        else
          localArrayList1.add(new ConversationToken(localMessageEntity.getMessageToken(), localMessageEntity.getMemberId()));
      }
      if (!localArrayList2.isEmpty())
        a(n.a(localArrayList2));
      ListIterator localListIterator1 = localArrayList3.listIterator();
      while (localListIterator1.hasNext())
        if (((GroupToken)localListIterator1.next()).token == 0L)
          localListIterator1.remove();
      ListIterator localListIterator2 = localArrayList1.listIterator();
      while (localListIterator2.hasNext())
        if (((ConversationToken)localListIterator2.next()).token == 0L)
          localListIterator2.remove();
    }
    while ((localArrayList3.isEmpty()) && (localArrayList1.isEmpty()));
    this.b.getPhoneController().handleSyncDeletedMessages((ConversationToken[])localArrayList1.toArray(new ConversationToken[localArrayList1.size()]), (GroupToken[])localArrayList3.toArray(new GroupToken[localArrayList3.size()]), this.b.getPhoneController().generateSequence());
  }

  private void a(long paramLong, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.l.contains(Long.valueOf(paramLong)))
      {
        this.l.remove(Long.valueOf(paramLong));
        this.g.H(paramLong);
      }
      while (!this.m.remove(Long.valueOf(paramLong)))
        return;
      this.n.a(paramLong);
      this.g.G(paramLong);
      this.g.F(paramLong);
      return;
    }
    this.m.remove(Long.valueOf(paramLong));
  }

  private void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    List localList = this.g.P(paramLong1);
    this.b.getPhoneController().handleSyncGroup(paramLong2, paramLong3, paramInt, 1, (String[])localList.toArray(new String[localList.size()]));
  }

  private void a(long paramLong, ab.c paramc1, ab.c paramc2)
  {
    if (!this.b.getPhoneController().isConnected());
    do
    {
      while (true)
      {
        return;
        if ((paramc1 == null) || (paramc2 == null))
          break;
        if (paramc1.b > paramc2.b);
        while (!this.m.contains(Long.valueOf(paramc1.b)))
        {
          this.m.add(Long.valueOf(paramc1.b));
          a(paramLong, paramc1.a, paramc1.b, paramc1.c);
          return;
          paramc1 = paramc2;
        }
      }
      if ((paramc2 != null) && (!this.m.contains(Long.valueOf(paramc2.b))))
      {
        this.m.add(Long.valueOf(paramc2.b));
        this.b.getPhoneController().handleSyncGroup(paramc2.a, paramc2.b, paramc2.c, 8, null);
        return;
      }
    }
    while ((paramc1 == null) || (this.m.contains(Long.valueOf(paramc1.b))));
    this.m.add(Long.valueOf(paramc1.b));
    switch (paramc1.e)
    {
    default:
      this.b.getPhoneController().handleSyncGroup(paramc1.a, paramc1.b, paramc1.c, 1, new String[0]);
      return;
    case 0:
      PhoneController localPhoneController = this.b.getPhoneController();
      String str = paramc1.d;
      long l1 = paramc1.b;
      int i1;
      if (paramc1.g)
        i1 = 1;
      while (true)
      {
        localPhoneController.handleSyncConversation(str, l1, 1, i1);
        if (!paramc1.f)
          break;
        Iterator localIterator = this.g.Q(paramLong).iterator();
        while (localIterator.hasNext())
        {
          MessageEntity localMessageEntity = (MessageEntity)localIterator.next();
          if (!this.m.contains(Long.valueOf(localMessageEntity.getMessageToken())))
          {
            this.m.add(Long.valueOf(localMessageEntity.getMessageToken()));
            this.b.getPhoneController().handleSyncConversation(localMessageEntity.getMemberId(), localMessageEntity.getMessageToken(), 1, 0);
          }
        }
        if (paramc1.h)
          i1 = 2;
        else
          i1 = 0;
      }
    case 1:
    }
    a(paramLong, paramc1.a, paramc1.b, paramc1.c);
  }

  private void a(h paramh, long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    long l1 = paramh.getId();
    long l2 = paramh.k();
    if ((paramInt1 == 2) && (paramh.I()))
      return;
    Set localSet = Collections.singleton(Long.valueOf(l1));
    int i2;
    if ((paramInt1 == 2) || (paramInt1 == 32))
      if (paramh.b())
      {
        if (this.g.g(l1) <= 0)
          break label431;
        this.q.post(new d.d(paramh.j()));
        i2 = 0;
      }
    while (true)
    {
      if (i2 == 0)
        ViberApplication.getInstance().getMessagesManager().a().a(localSet);
      if (i1 != 0)
      {
        this.g.h(localSet);
        label127: this.g.d(paramh.j());
        if (i2 == 0)
          break label254;
        this.f.a(localSet, false);
      }
      while (true)
      {
        g.a(this.a).a(l1);
        return;
        if (paramInt1 != 32)
          break label431;
        if ((ViberApplication.isTablet(this.a)) && (this.i.getCallInfo() != null));
        while (true)
        {
          i2 = i1;
          i1 = 0;
          break;
          i1 = 0;
        }
        this.g.d(l1, paramLong);
        this.g.e(localSet);
        this.g.f(l1, paramh.j());
        this.g.d(localSet);
        break label127;
        label254: this.f.b(localSet, paramh.j(), false);
      }
      if (paramInt1 == i1)
      {
        this.g.h(l1, paramLong);
        this.g.i(l1, paramLong);
        if (paramh.e())
          this.g.l(l2, paramInt2);
        this.g.d(paramh.j());
        this.f.a(localSet, paramh.j(), false);
        g.a(this.a).a(l1);
        return;
      }
      if (paramInt1 == 4)
      {
        this.g.a(l1, paramLong, false);
        this.g.f(l1, paramLong);
        this.f.a(l1, paramh.j(), false);
        return;
      }
      if (paramInt1 != 64)
        break;
      this.g.a(l1, paramLong, false);
      this.f.a(l1, paramh.j(), false);
      return;
      label431: i1 = 0;
      i2 = 0;
    }
  }

  private void a(Set<Long> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      long l1 = ((Long)localIterator.next()).longValue();
      ab.c localc1 = this.g.N(l1);
      ab.c localc2 = this.g.O(l1);
      this.n.a(l1, localc1, localc2);
      a(l1, localc1, localc2);
    }
  }

  private void a(long[] paramArrayOfLong)
  {
    int i1 = 1;
    Map localMap = this.g.i(paramArrayOfLong);
    int i2;
    if (this.g.e(paramArrayOfLong) > 0)
    {
      i2 = i1;
      if (this.g.f(paramArrayOfLong) <= 0)
        break label64;
    }
    while (true)
    {
      if ((i2 | i1) != 0)
        this.f.a(localMap.keySet(), false);
      return;
      i2 = 0;
      break;
      label64: i1 = 0;
    }
  }

  private void b()
  {
    if (!this.b.getPhoneController().isConnected());
    while (true)
    {
      return;
      Iterator localIterator = this.n.a().iterator();
      while (localIterator.hasNext())
      {
        o.a.a locala = (o.a.a)localIterator.next();
        a(locala.a, locala.b, locala.c);
      }
    }
  }

  private void b(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null);
    Set localSet;
    do
    {
      return;
      localSet = this.g.h(paramArrayOfLong);
    }
    while (localSet.size() <= 0);
    this.f.a(localSet);
  }

  private void c()
  {
    if (!this.b.getPhoneController().isConnected());
    while (true)
    {
      return;
      Iterator localIterator1 = b.c().a("not_sync_hide_group").iterator();
      while (localIterator1.hasNext())
      {
        String str2 = (String)localIterator1.next();
        ConversationSettings localConversationSettings2 = ConversationSettings.from(b.c().b("not_sync_hide_group", str2).intValue());
        this.b.getPhoneController().handleChangeGroupSettings(Long.valueOf(str2).longValue(), localConversationSettings2);
      }
      Iterator localIterator2 = b.c().a("not_sync_hide_1to1").iterator();
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        ConversationSettings localConversationSettings1 = ConversationSettings.from(b.c().b("not_sync_hide_1to1", str1).intValue());
        this.b.getPhoneController().handleChangeConversationSettings(str1, localConversationSettings1);
      }
    }
  }

  private void d()
  {
    if (!this.b.getPhoneController().isConnected());
    while (true)
    {
      return;
      List localList = this.g.d();
      if ((localList != null) && (localList.size() != 0))
      {
        Map localMap = ak.a().a((h[])localList.toArray(new h[localList.size()]));
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          h localh = (h)localIterator.next();
          if (localh.b())
          {
            if (localh.k() > 0L)
              if (localh.ar())
              {
                r localr = this.g.d(localh.k());
                if (localr != null)
                {
                  PublicAccount.ExtraInfo localExtraInfo = PublicAccount.ExtraInfo.fromExtraInfoJson(localr.R());
                  if ((localExtraInfo != null) && (localExtraInfo.getInvitationToken() != 0L))
                  {
                    this.b.getPhoneController().handleSyncGroup(localh.k(), localExtraInfo.getInvitationToken(), 0, 2, null);
                    this.g.h(localh.k());
                  }
                }
              }
              else
              {
                this.b.getPhoneController().handleGroupLeave(localh.k());
              }
          }
          else
          {
            m localm = (m)localMap.get(Long.valueOf(localh.getId()));
            this.l.add(Long.valueOf(localh.n()));
            this.b.getPhoneController().handleSyncConversation(localm.a(), localh.n(), 2, localh.ah());
          }
        }
      }
    }
  }

  public void onChangeConversationSettingsReply(String paramString, ConversationSettings paramConversationSettings, int paramInt)
  {
    if (paramInt == 0)
      b.c().a("not_sync_hide_1to1", new String[] { paramString });
  }

  public void onChangeGroupSettingsReply(long paramLong, ConversationSettings paramConversationSettings, int paramInt)
  {
    if (paramInt == 0)
    {
      d locald = b.c();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramLong);
      locald.a("not_sync_hide_group", arrayOfString);
    }
  }

  public void onDeleteMessageReply(long paramLong, int paramInt1, int paramInt2)
  {
    ai localai = this.j;
    if (paramInt2 == 2);
    for (boolean bool = true; localai.a(paramInt1, bool); bool = false)
      return;
    switch (paramInt2)
    {
    default:
      com.viber.voip.ui.dialogs.f.d().d();
      return;
    case 0:
    }
    ((bs)this.h.get()).a(paramLong, 0L, UserManager.from(this.a).getRegistrationValues().l(), true);
  }

  public boolean onDeletedGroupMessage(String paramString, long paramLong1, long paramLong2)
  {
    if (((bs)this.h.get()).a(paramLong2, paramLong1, paramString, false))
      this.b.getPhoneController().handleDeletedMessageAck(paramLong2);
    return true;
  }

  public boolean onDeletedMessage(String paramString, long paramLong)
  {
    if (((bs)this.h.get()).a(paramLong, 0L, paramString, false))
      this.b.getPhoneController().handleDeletedMessageAck(paramLong);
    return true;
  }

  public void onGlobalDeleteMessageReply(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 1:
    case 2:
    default:
    case 0:
    case 3:
    }
    h localh;
    do
    {
      do
      {
        do
        {
          return;
          MessageEntity localMessageEntity = this.g.k(paramLong2);
          localMessageEntity.setDeleted(0);
          localMessageEntity.setMimeType(1007);
          localMessageEntity.setExtraFlags(0L);
          localMessageEntity.setRawMessageInfo("");
          this.g.b(localMessageEntity);
          return;
        }
        while (this.g.E(paramLong2) <= 0);
        localh = this.g.b(paramLong1);
      }
      while (localh == null);
      com.viber.voip.ui.dialogs.k.y().d();
      this.f.a(localh.getId(), paramLong2, false);
    }
    while (!localh.e());
    ViberApplication.getInstance().getMessagesManager().d().a(this.b.getPhoneController().generateSequence(), localh.k(), null, 1, localh.j(), localh.p());
  }

  public void onGroupLeave(long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong2 != 0L)
    {
      this.l.add(Long.valueOf(paramLong2));
      this.g.g(paramLong1, paramLong2);
      this.b.getPhoneController().handleSyncGroup(paramLong1, paramLong2, 0, 2, null);
      return;
    }
    this.g.h(paramLong1);
  }

  public boolean onHandleSelfDetails(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    int i1 = 1;
    int i2;
    if ((paramInt & 0x1) != 0)
    {
      i2 = i1;
      if ((paramInt & 0x2) == 0)
        break label88;
      label21: if ((i2 == 0) || (i1 == 0))
        break label94;
      ((com.viber.voip.util.e.e)this.e.get()).b(this.k.getImage());
      this.k.setUserData(paramString1, dx.a(paramString2));
    }
    while (true)
    {
      this.b.getPhoneController().handleSendUpdateSelfUserDetailsAck(paramLong);
      return false;
      i2 = 0;
      break;
      label88: i1 = 0;
      break label21;
      label94: if (i1 != 0)
      {
        this.k.setName(paramString1);
        this.k.notifyOwnerChange();
      }
      else if (i2 != 0)
      {
        ((com.viber.voip.util.e.e)this.e.get()).b(this.k.getImage());
        this.k.setImage(dx.a(paramString2));
        this.k.notifyOwnerChange();
      }
    }
  }

  public void onServiceStateChanged(int paramInt)
  {
    if (paramInt == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal())
    {
      d();
      a();
      c();
      b();
    }
  }

  public boolean onSyncConversation(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    if (paramInt2 == i1);
    while (true)
    {
      h localh = this.g.a(paramString, i1);
      if (localh != null)
        a(localh, paramLong, paramInt1, 0);
      this.b.getPhoneController().handleSendSyncConversationAck(paramString, paramLong, paramInt1);
      return false;
      i1 = 0;
    }
  }

  public void onSyncConversationReply(String paramString, long paramLong, int paramInt)
  {
    a(paramLong, paramInt);
  }

  public boolean onSyncGroup(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    h localh = this.g.b(paramLong1);
    if (localh != null)
      a(localh, paramLong2, paramInt2, paramInt1);
    this.b.getPhoneController().handleSendSyncGroupAck(paramLong1, paramLong2, paramInt2);
    return false;
  }

  public void onSyncGroupReply(long paramLong1, long paramLong2, int paramInt)
  {
    int i1 = 1;
    if ((paramInt == 0) || ((paramInt == i1) && (this.l.contains(Long.valueOf(paramLong2)))));
    while (true)
    {
      a(paramLong2, paramInt);
      if (i1 != 0)
        this.g.h(paramLong1);
      return;
      i1 = 0;
    }
  }

  public boolean onSyncMessages(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i1;
    if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length > 0))
    {
      i1 = 1;
      if ((paramArrayOfLong1 == null) || (paramArrayOfLong1.length <= 0))
        break label175;
    }
    HashSet localHashSet;
    Map localMap2;
    label175: for (int i2 = 1; ; i2 = 0)
    {
      localHashSet = new HashSet();
      if (i1 == 0)
        break label213;
      localMap2 = this.g.i(paramArrayOfLong2);
      b(paramArrayOfLong2);
      this.g.c(paramArrayOfLong2);
      localHashSet.addAll(localMap2.values());
      Iterator localIterator2 = localMap2.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        this.g.f(((Long)localEntry2.getKey()).longValue(), ((Integer)localEntry2.getValue()).intValue());
        g.a(this.a).a(((Long)localEntry2.getKey()).longValue());
      }
      i1 = 0;
      break;
    }
    this.f.a(localMap2.keySet(), 1, false, false);
    this.f.a(localMap2.keySet(), false);
    label213: if (i2 != 0)
    {
      Map localMap1 = this.g.i(paramArrayOfLong1);
      this.g.g(paramArrayOfLong1);
      localHashSet.addAll(localMap1.values());
      Iterator localIterator1 = localMap1.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        g.a(this.a).d().b(((Long)localEntry1.getKey()).longValue());
      }
      boolean bool = localHashSet.contains(Integer.valueOf(2));
      this.f.a(localMap1.keySet(), bool, false);
    }
    this.g.b(localHashSet);
    this.b.getPhoneController().handleSendSyncMessagesAck(paramArrayOfLong1, paramArrayOfLong2);
    return false;
  }

  public void onSyncMessagesReply(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    if ((paramArrayOfLong != null) && ((paramInt2 == 0) || (paramInt2 == 1)))
    {
      a(paramArrayOfLong);
      a();
    }
  }

  static final class a
  {
    private final LongSparseSet a = new LongSparseSet();
    private final LongSparseArray<ab.c> b = new LongSparseArray();
    private final LongSparseArray<ab.c> c = new LongSparseArray();
    private com.google.d.f d;
    private boolean e = false;

    private ab.c a(long paramLong, ab.c paramc, LongSparseArray<ab.c> paramLongSparseArray)
    {
      if (paramc != null)
      {
        ab.c localc = (ab.c)paramLongSparseArray.get(paramLong);
        if ((localc != null) && (localc.b >= paramc.b))
          paramc = null;
      }
      return paramc;
    }

    private void a(LongSparseArray<ab.c> paramLongSparseArray, String paramString)
    {
      Iterator localIterator = com.viber.voip.model.e.b(paramString).iterator();
      while (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        try
        {
          long l = Long.parseLong(locala.b());
          paramLongSparseArray.put(l, b().a(locala.d(), ab.c.class));
          this.a.add(l);
        }
        catch (Exception localException)
        {
          String[] arrayOfString = new String[1];
          arrayOfString[0] = locala.b();
          com.viber.voip.model.e.a(paramString, arrayOfString);
        }
      }
    }

    private boolean a(long paramLong1, long paramLong2, LongSparseArray<ab.c> paramLongSparseArray, String paramString1, String paramString2)
    {
      ab.c localc = (ab.c)paramLongSparseArray.get(paramLong1);
      if ((localc != null) && (localc.b <= paramLong2))
      {
        paramLongSparseArray.remove(paramLong1);
        com.viber.voip.model.e.a(paramString1, new String[] { paramString2 });
        return true;
      }
      if (localc == null);
      for (boolean bool = true; ; bool = false)
        return bool;
    }

    private boolean a(long paramLong, ab.c paramc, LongSparseArray<ab.c> paramLongSparseArray, String paramString1, String paramString2)
    {
      if (paramc != null)
      {
        paramLongSparseArray.put(paramLong, paramc);
        com.viber.voip.model.e.a(paramString1, paramString2, b().b(paramc));
        return true;
      }
      return false;
    }

    private long b(long paramLong)
    {
      int i = this.a.size();
      for (int j = 0; j < i; j++)
      {
        long l = this.a.get(j);
        ab.c localc1 = (ab.c)this.b.get(l);
        if ((localc1 != null) && (paramLong == localc1.b))
          return l;
        ab.c localc2 = (ab.c)this.c.get(l);
        if ((localc2 != null) && (paramLong == localc2.b))
          return l;
      }
      return -1L;
    }

    private com.google.d.f b()
    {
      if (this.d == null)
        this.d = new com.google.d.f();
      return this.d;
    }

    private void b(long paramLong, ab.c paramc1, ab.c paramc2)
    {
      String str = Long.toString(paramLong);
      if ((a(paramLong, paramc1, this.b, "sync_read_message", str) | a(paramLong, paramc2, this.c, "sync_read_like", str)))
        this.a.add(paramLong);
    }

    private void c()
    {
      if (!this.e)
      {
        a(this.b, "sync_read_message");
        a(this.c, "sync_read_like");
        this.e = true;
        int i = 0;
        int j = this.a.size();
        while (i < j)
        {
          this.a.get(i);
          i++;
        }
      }
    }

    public List<a> a()
    {
      try
      {
        c();
        ArrayList localArrayList;
        if (this.a.size() > 0)
        {
          localArrayList = new ArrayList(this.a.size());
          int i = this.a.size();
          for (int j = 0; j < i; j++)
          {
            long l = this.a.get(j);
            localArrayList.add(new a(l, (ab.c)this.b.get(l), (ab.c)this.c.get(l)));
          }
        }
        List localList;
        for (Object localObject2 = localArrayList; ; localObject2 = localList)
        {
          return localObject2;
          localList = Collections.emptyList();
        }
      }
      finally
      {
      }
    }

    public void a(long paramLong)
    {
      try
      {
        c();
        long l = b(paramLong);
        if (l != -1L)
        {
          String str = Long.toString(l);
          if ((a(l, paramLong, this.b, "sync_read_message", str) | a(l, paramLong, this.c, "sync_read_like", str)))
            this.a.remove(l);
        }
        return;
      }
      finally
      {
      }
    }

    public void a(long paramLong, ab.c paramc1, ab.c paramc2)
    {
      if ((paramc1 == null) && (paramc2 == null));
      while (true)
      {
        return;
        try
        {
          c();
          ab.c localc1 = a(paramLong, paramc1, this.b);
          ab.c localc2 = a(paramLong, paramc2, this.c);
          if ((localc1 == null) && (localc2 == null))
            continue;
          b(paramLong, localc1, localc2);
        }
        finally
        {
        }
      }
    }

    public static final class a
    {
      public final long a;
      public final ab.c b;
      public final ab.c c;

      public a(long paramLong, ab.c paramc1, ab.c paramc2)
      {
        this.a = paramLong;
        this.b = paramc1;
        this.c = paramc2;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.o
 * JD-Core Version:    0.6.2
 */