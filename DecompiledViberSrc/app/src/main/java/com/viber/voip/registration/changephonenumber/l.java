package com.viber.voip.registration.changephonenumber;

import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.d;
import com.viber.voip.contacts.c.d.j.c;
import com.viber.voip.model.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class l
  implements g.d, d.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b;
  private k c;
  private LongSparseArray<Long> d;

  public l(Handler paramHandler)
  {
    this.b = paramHandler;
  }

  private long a(long paramLong)
  {
    Long localLong = (Long)a().get(paramLong);
    if (localLong == null)
      return 0L;
    return localLong.longValue();
  }

  private LongSparseArray<Long> a()
  {
    if (this.d == null)
    {
      Set localSet = e.b("participant_info_previous_contact_id");
      this.d = new LongSparseArray(localSet.size());
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        com.viber.voip.model.a.d.a locala = (com.viber.voip.model.a.d.a)localIterator.next();
        Long localLong1 = Long.valueOf(Long.parseLong(locala.b()));
        Long localLong2 = (Long)locala.c();
        this.d.put(localLong1.longValue(), localLong2);
      }
    }
    return this.d;
  }

  private void a(long paramLong1, long paramLong2)
  {
    a().put(paramLong1, Long.valueOf(paramLong2));
    e.b("participant_info_previous_contact_id", String.valueOf(paramLong1), paramLong2);
  }

  private void a(Map<Long, Long> paramMap)
  {
    int i = a().size();
    ArrayList localArrayList = new ArrayList(i);
    HashSet localHashSet = new HashSet(i);
    int j = 0;
    if (j < i)
    {
      long l1 = a().keyAt(j);
      long l2 = ((Long)a().get(l1)).longValue();
      if (paramMap.containsKey(Long.valueOf(l2)))
      {
        long l3 = ((Long)paramMap.get(Long.valueOf(l2))).longValue();
        if (l3 <= 0L)
          break label146;
        a().put(l1, Long.valueOf(l3));
        localArrayList.add(com.viber.voip.model.a.d.a.a("participant_info_previous_contact_id", String.valueOf(l1), Long.valueOf(l3)));
      }
      while (true)
      {
        j++;
        break;
        label146: localHashSet.add(Long.valueOf(l1));
      }
    }
    if (localArrayList.size() > 0)
      e.a(localArrayList);
    if (localHashSet.size() > 0)
      d(localHashSet);
  }

  private void c(Set<Long> paramSet)
  {
    int i = a().size();
    HashSet localHashSet = new HashSet(i);
    for (int j = 0; j < i; j++)
    {
      long l = a().keyAt(j);
      if (paramSet.contains(Long.valueOf(((Long)a().get(l)).longValue())))
        localHashSet.add(Long.valueOf(l));
    }
    if (localHashSet.size() > 0)
      b(localHashSet);
  }

  private void d(Set<Long> paramSet)
  {
    int i = paramSet.size();
    if (paramSet.size() > 0)
    {
      HashSet localHashSet = new HashSet(i);
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (a().get(localLong.longValue()) != null)
        {
          a().remove(localLong.longValue());
          localHashSet.add(String.valueOf(localLong));
        }
      }
      if (localHashSet.size() > 0)
      {
        e.a("participant_info_previous_contact_id", (String[])localHashSet.toArray(new String[localHashSet.size()]));
        if (this.c != null)
          this.c.a(localHashSet);
      }
    }
  }

  public void a(final long paramLong, com.viber.voip.contacts.c.d.m paramm, final j.c paramc)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        long l = l.a(l.this, paramLong);
        paramc.a(l, null, this.c);
      }
    });
  }

  void a(g paramg, final k paramk)
  {
    paramg.a(this);
    this.b.post(new Runnable()
    {
      public void run()
      {
        l.a(l.this, paramk);
      }
    });
  }

  void a(com.viber.voip.model.entity.m paramm)
  {
    final long l1 = paramm.getId();
    long l2 = paramm.i();
    if (l2 > 0L)
      this.b.post(new Runnable()
      {
        public void run()
        {
          l.a(l.this, l1, this.b);
        }
      });
  }

  public void a(final Map<Long, Long> paramMap, Set<Long> paramSet)
  {
    if (paramMap.size() == 0)
      return;
    this.b.post(new Runnable()
    {
      public void run()
      {
        l.a(l.this, paramMap);
      }
    });
  }

  public void a(final Set<Long> paramSet)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        l.b(l.this, paramSet);
      }
    });
  }

  void b(final Set<Long> paramSet)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        l.a(l.this, paramSet);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.l
 * JD-Core Version:    0.6.2
 */