package com.viber.voip.messages.controller;

import android.os.Handler;
import android.os.Looper;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.g.i;
import com.viber.voip.contacts.c.f.b.g.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.aa;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.d.c;
import com.viber.voip.model.e;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import dagger.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class u
  implements g.i
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b;
  private final ab c;
  private final o d;
  private final HashMap<Long, Long> e = new HashMap();

  u(Handler paramHandler, ab paramab, o paramo, a<com.viber.voip.contacts.c.d.g> parama)
  {
    this.b = paramHandler;
    this.c = paramab;
    this.d = paramo;
    ((com.viber.voip.contacts.c.d.g)parama.get()).a(this);
    this.d.a(new bv.d()
    {
      public void onDelete(final Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (!com.viber.voip.messages.m.a(paramAnonymousInt))
          u.a(u.this).post(new Runnable()
          {
            public void run()
            {
              u.a(u.this, paramAnonymousSet);
            }
          });
      }
    });
  }

  private void a(long paramLong)
  {
    long l = 86400000L + System.currentTimeMillis();
    e.b(String.valueOf(paramLong), "key_tablet_invite_banner_checking_time", l);
    this.e.put(Long.valueOf(paramLong), Long.valueOf(l));
  }

  private void a(h paramh)
  {
    this.c.a(paramh.getTable(), paramh.getId(), "flags", Long.valueOf(paramh.z()));
    this.d.a(Collections.singleton(Long.valueOf(paramh.getId())), paramh.j(), false, true);
  }

  private void a(Set<Long> paramSet)
  {
    e.a("key_tablet_invite_banner_checking_time", (Long[])paramSet.toArray(new Long[paramSet.size()]));
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      this.e.remove(Long.valueOf(l));
    }
  }

  static boolean a(h paramh, com.viber.voip.model.entity.m paramm)
  {
    int i = paramh.j();
    boolean bool1 = false;
    if (i == 0)
    {
      bool1 = false;
      if (paramm != null)
      {
        boolean bool2 = paramm.i() < 0L;
        bool1 = false;
        if (bool2)
        {
          com.viber.voip.model.entity.g localg = ViberApplication.getInstance().getContactManager().c().a(paramm.getNumber());
          bool1 = false;
          if (localg != null)
          {
            boolean bool3 = localg.p();
            bool1 = false;
            if (!bool3)
              bool1 = true;
          }
        }
      }
    }
    return bool1;
  }

  private void b(long paramLong)
  {
    e.a(String.valueOf(paramLong), new String[] { "key_tablet_invite_banner_checking_time" });
    this.e.remove(Long.valueOf(paramLong));
  }

  private void b(String paramString)
  {
    dr.a(paramString, new dr.a()
    {
      public void onCheckStatus(final boolean paramAnonymousBoolean, final int paramAnonymousInt, final ParticipantSelector.Participant paramAnonymousParticipant, com.viber.voip.model.entity.g paramAnonymousg)
      {
        Runnable local1 = new Runnable()
        {
          public void run()
          {
            int i = 1;
            h localh = u.b(u.this).a(paramAnonymousParticipant.getNumber(), false);
            if (localh == null)
              break label28;
            label28: 
            while (2 == paramAnonymousInt)
              return;
            if (((i == paramAnonymousInt) || (7 == paramAnonymousInt)) && (!localh.i(12)))
              localh.g(12);
            while (true)
            {
              if (!paramAnonymousBoolean)
                u.b(u.this, localh.getId());
              if (i == 0)
                break;
              u.a(u.this, localh);
              return;
              if ((paramAnonymousInt == 0) && (localh.i(12)))
                localh.h(12);
              else
                i = 0;
            }
          }
        };
        if (Looper.myLooper() == u.a(u.this).getLooper())
        {
          local1.run();
          return;
        }
        u.a(u.this).post(local1);
      }
    });
  }

  public void a(final ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((paramConversationItemLoaderEntity.getConversationType() != 0) || (paramConversationItemLoaderEntity.isAnonymous()))
      return;
    this.b.post(new Runnable()
    {
      public void run()
      {
        if (!u.this.a(paramConversationItemLoaderEntity.getParticipantMemberId()))
        {
          u.a(u.this, paramConversationItemLoaderEntity.getId());
          return;
        }
        Long localLong;
        if (u.d(u.this).containsKey(Long.valueOf(paramConversationItemLoaderEntity.getId())))
          localLong = (Long)u.d(u.this).get(Long.valueOf(paramConversationItemLoaderEntity.getId()));
        while (true)
        {
          long l = System.currentTimeMillis();
          if ((localLong != null) && (localLong.longValue() > l))
            break;
          u.a(u.this, paramConversationItemLoaderEntity.getNumber());
          return;
          localLong = e.b(String.valueOf(paramConversationItemLoaderEntity.getId()), "key_tablet_invite_banner_checking_time");
          if (localLong != null)
            u.d(u.this).put(Long.valueOf(paramConversationItemLoaderEntity.getId()), localLong);
        }
      }
    });
  }

  void a(final h paramh, final com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isCall()) && ("vo".equals(paramMessageEntity.getBody())));
    for (int i = 1; ; i = 0)
    {
      if ((paramh.j() == 0) && (paramh.N()) && (i == 0))
        this.b.post(new Runnable()
        {
          public void run()
          {
            if (paramm.i() == 0L)
              u.b(u.this, paramh.getId());
            while (true)
            {
              paramh.h(12);
              u.a(u.this, paramh);
              return;
              u.a(u.this, paramh.getId());
            }
          }
        });
      return;
    }
  }

  public void a(Map<Member, g.a> paramMap)
  {
  }

  public void a(final Set<Member> paramSet1, Set<Member> paramSet2, final Set<Member> paramSet3)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        HashSet localHashSet1 = new HashSet(2 * (paramSet1.size() + paramSet3.size()));
        HashSet localHashSet2 = new HashSet(2 * paramSet1.size());
        HashSet localHashSet3 = new HashSet(2 * paramSet3.size());
        Iterator localIterator1 = paramSet1.iterator();
        while (localIterator1.hasNext())
        {
          Member localMember2 = (Member)localIterator1.next();
          localHashSet2.add(localMember2.getId());
          localHashSet2.add(localMember2.getPhoneNumber());
        }
        Iterator localIterator2 = paramSet3.iterator();
        while (localIterator2.hasNext())
        {
          Member localMember1 = (Member)localIterator2.next();
          localHashSet3.add(localMember1.getId());
          localHashSet3.add(localMember1.getPhoneNumber());
        }
        localHashSet1.addAll(localHashSet2);
        localHashSet1.addAll(localHashSet3);
        List localList = u.b(u.this).a(localHashSet1);
        Map localMap = ak.a().a((h[])localList.toArray(new h[localList.size()]));
        HashSet localHashSet4 = new HashSet(localList.size());
        com.viber.provider.b localb = aa.f();
        localb.a();
        while (true)
        {
          h localh;
          com.viber.voip.model.entity.m localm;
          int i;
          try
          {
            Iterator localIterator3 = localList.iterator();
            if (!localIterator3.hasNext())
              break label449;
            localh = (h)localIterator3.next();
            localm = (com.viber.voip.model.entity.m)localMap.get(Long.valueOf(localh.getId()));
            localHashSet4.add(Long.valueOf(localh.getId()));
            if ((localHashSet2.contains(localm.a())) && (localh.N()))
            {
              localh.h(12);
              i = 1;
              if (i == 0)
                continue;
              u.b(u.this).a(localh.getTable(), localh.getId(), "flags", Long.valueOf(localh.z()));
              continue;
            }
          }
          finally
          {
            localb.b();
          }
          if ((localHashSet3.contains(localm.a())) && (!localh.N()))
          {
            if (localm.i() > 0L)
            {
              localh.g(12);
              i = 1;
              continue;
              label449: localb.c();
              localb.b();
              u.a(u.this, localHashSet4);
              u.c(u.this).a(localHashSet4, 0, false, true);
            }
          }
          else
          {
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    });
  }

  public boolean a(String paramString)
  {
    com.viber.voip.model.entity.m localm = c.c().c(paramString, 1);
    return (localm == null) || (localm.i() == 0L);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.u
 * JD-Core Version:    0.6.2
 */