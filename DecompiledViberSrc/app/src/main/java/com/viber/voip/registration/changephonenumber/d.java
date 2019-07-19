package com.viber.voip.registration.changephonenumber;

import android.os.Handler;
import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.i;
import com.viber.voip.contacts.c.d.j.c;
import com.viber.voip.contacts.c.f.b.g.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.controller.c.c;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.registration.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d
  implements g.i, bv.n, k
{
  private static final Logger a = ViberEnv.getLogger();
  private final PhoneController b;
  private final l c;
  private final ak d;
  private final dagger.a<bs> e;
  private final z f;
  private final com.viber.voip.contacts.c.d.m g;
  private final o h;
  private final i i;
  private final Handler j;

  public d(PhoneController paramPhoneController, i parami, l paraml, ak paramak, dagger.a<bs> parama, z paramz, com.viber.voip.contacts.c.d.m paramm, o paramo, Handler paramHandler)
  {
    this.b = paramPhoneController;
    this.d = paramak;
    this.c = paraml;
    this.e = parama;
    this.f = paramz;
    this.g = paramm;
    this.h = paramo;
    this.i = parami;
    this.j = paramHandler;
  }

  private void a(Member paramMember, String paramString, long paramLong)
  {
    MessageEntity localMessageEntity = c.a(this.b.generateSequence(), 0L, 0, System.currentTimeMillis(), paramMember.getId(), 520, 0L, com.viber.voip.messages.j.b(paramMember.getId(), paramMember.getPhoneNumber(), paramString), 0, 1000);
    localMessageEntity.addExtraFlag(31);
    localMessageEntity.setUnread(1);
    localMessageEntity.setMessageToken(paramLong);
    ((bs)this.e.get()).a(localMessageEntity);
  }

  private void a(List<com.viber.voip.model.entity.m> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localIterator.next();
      this.c.a(localm);
    }
  }

  private void a(List<com.viber.voip.model.entity.m> paramList, boolean paramBoolean)
  {
    int k = paramList.size();
    HashSet localHashSet1 = new HashSet(k);
    for (int m = 0; m < k; m++)
      localHashSet1.add(((com.viber.voip.model.entity.m)paramList.get(m)).a());
    List localList = this.f.a(localHashSet1);
    HashSet localHashSet2 = new HashSet(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (!localh.R())
        localHashSet2.add(Long.valueOf(localh.getId()));
    }
    if (localHashSet2.size() > 0)
      ((bs)this.e.get()).a(localHashSet2, paramBoolean);
  }

  private List<com.viber.voip.model.entity.m> b(Set<String> paramSet)
  {
    return this.d.b(paramSet);
  }

  private void b(Member paramMember, g.a parama, boolean paramBoolean)
  {
    com.viber.voip.model.entity.m localm = this.d.a(new Member(paramMember.getId(), parama.a), 1);
    if (localm.isOwner())
      return;
    this.d.a(localm.getId(), 0, paramBoolean);
    localm.a(paramBoolean);
    this.h.a(Collections.singletonList(localm), true);
    a(paramMember, localm.getContactName(), parama.c);
  }

  private ArrayMap<String, com.viber.voip.model.a> c(Set<Member> paramSet)
  {
    Set localSet = this.g.a(paramSet);
    ArrayMap localArrayMap = new ArrayMap(localSet.size());
    Iterator localIterator1 = localSet.iterator();
    while (localIterator1.hasNext())
    {
      com.viber.voip.model.a locala = (com.viber.voip.model.a)localIterator1.next();
      Iterator localIterator2 = locala.s().iterator();
      while (localIterator2.hasNext())
        localArrayMap.put(((com.viber.voip.model.j)localIterator2.next()).a(), locala);
    }
    return localArrayMap;
  }

  public i a()
  {
    return this.i;
  }

  public void a(g paramg, bv parambv)
  {
    paramg.a(this);
    this.c.a(paramg, this);
    parambv.a(this);
  }

  public void a(Map<Member, g.a> paramMap)
  {
    ArrayMap localArrayMap = c(paramMap.keySet());
    HashSet localHashSet = new HashSet(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Member localMember = (Member)localEntry.getKey();
      g.a locala = (g.a)localEntry.getValue();
      if (locala.a())
      {
        boolean bool = localArrayMap.containsKey(localMember.getId());
        if (!bool)
          localHashSet.add(localMember.getId());
        this.j.post(new e(this, localMember, locala, bool));
      }
    }
    if (localHashSet.size() == 0);
    while (ao.f())
      return;
    List localList = b(localHashSet);
    a(localList, true);
    a(localList);
  }

  public void a(Set<String> paramSet)
  {
    List localList = this.d.b(new ArrayList(paramSet));
    int k = localList.size();
    if (k > 0)
    {
      HashSet localHashSet = new HashSet(k);
      for (int m = 0; m < k; m++)
      {
        com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localList.get(m);
        localHashSet.add(Long.valueOf(localm.getId()));
        localm.a(false);
      }
      this.d.a(localHashSet, 0, false);
      this.h.a(localList, true);
      a(localList, false);
    }
  }

  public void a(Set<Member> paramSet1, Set<Member> paramSet2, Set<Member> paramSet3)
  {
  }

  public a b()
  {
    return this.c;
  }

  public void onChange(Set<Long> paramSet, Set<String> paramSet1, boolean paramBoolean)
  {
  }

  public void onContactStatusChanged(Map<Long, bv.n.a> paramMap)
  {
    HashSet localHashSet = new HashSet(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (bv.n.a.c == localEntry.getValue())
        localHashSet.add(localEntry.getKey());
    }
    if (localHashSet.size() > 0)
      this.c.b(localHashSet);
  }

  public void onInitCache()
  {
  }

  public void onNewInfo(List<com.viber.voip.model.entity.m> paramList, boolean paramBoolean)
  {
  }

  public void onParticipantDeleted(com.viber.voip.model.entity.m paramm)
  {
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong, com.viber.voip.contacts.c.d.m paramm, j.c paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.d
 * JD-Core Version:    0.6.2
 */