package com.viber.voip.messages.controller.b;

import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.j;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.da;
import com.viber.voip.util.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.onepf.oms.util.CollectionUtils;

public class f
{
  final LongSparseSet a = new LongSparseSet();
  private m b;
  private LruCache<String, h> c;
  private LruCache<d, Long> d;
  private LruCache<c, Long> e;
  private LruCache<c, m> f;

  public f(boolean paramBoolean)
  {
    int k;
    int m;
    if (paramBoolean)
    {
      k = 128;
      this.c = new LruCache(k);
      if (!paramBoolean)
        break label108;
      m = i;
      label51: this.d = new LruCache(m);
      if (!paramBoolean)
        break label114;
    }
    while (true)
    {
      this.e = new LruCache(i);
      if (paramBoolean)
        j = 256;
      this.f = new LruCache(j);
      return;
      k = 32;
      break;
      label108: m = j;
      break label51;
      label114: i = j;
    }
  }

  public static a a(long paramLong, int paramInt, String paramString)
  {
    return new a(paramLong, paramInt, paramString);
  }

  public static a a(Member paramMember, int paramInt, boolean paramBoolean, String paramString)
  {
    return new a(paramMember, paramInt, 0, paramBoolean, paramString);
  }

  public static String a(long paramLong)
  {
    return String.valueOf(paramLong);
  }

  public static String a(MessageEntity paramMessageEntity, String paramString)
  {
    if (paramMessageEntity.isGroupBehavior())
      return a(paramMessageEntity.getGroupId());
    return b(paramMessageEntity, paramString);
  }

  public static String b(MessageEntity paramMessageEntity, String paramString)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramMessageEntity.getMemberId();
    arrayOfString[1] = da.h(paramString);
    StringBuilder localStringBuilder = new StringBuilder().append("secret=");
    if (paramMessageEntity.isSecretMessage());
    for (String str = "1"; ; str = "0")
    {
      arrayOfString[2] = str;
      return TextUtils.join(":", arrayOfString);
    }
  }

  public h a(String paramString)
  {
    return (h)this.c.get(paramString);
  }

  public m a()
  {
    return this.b;
  }

  public m a(c paramc)
  {
    return (m)this.f.get(paramc);
  }

  public Long a(d paramd)
  {
    return (Long)this.d.get(paramd);
  }

  public void a(c paramc, m paramm)
  {
    this.f.put(paramc, paramm);
  }

  public void a(c paramc, Long paramLong)
  {
    this.e.put(paramc, paramLong);
  }

  public void a(d paramd, Long paramLong)
  {
    this.d.put(paramd, paramLong);
  }

  public void a(m paramm)
  {
    this.b = paramm;
  }

  public void a(LongSparseSet paramLongSparseSet)
  {
    if (!u.a(paramLongSparseSet))
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator1 = this.f.snapshot().entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
        if (paramLongSparseSet.contains(((m)localEntry2.getValue()).getId()))
          localHashSet.add(localEntry2.getKey());
      }
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
      {
        c localc2 = (c)localIterator2.next();
        this.f.remove(localc2);
      }
      localHashSet.clear();
      Iterator localIterator3 = this.e.snapshot().entrySet().iterator();
      while (localIterator3.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator3.next();
        if (paramLongSparseSet.contains(((Long)localEntry1.getValue()).longValue()))
          localHashSet.add(localEntry1.getKey());
      }
      Iterator localIterator4 = localHashSet.iterator();
      while (localIterator4.hasNext())
      {
        c localc1 = (c)localIterator4.next();
        this.e.remove(localc1);
      }
    }
  }

  public void a(String paramString, h paramh)
  {
    this.c.put(paramString, paramh);
  }

  public void a(Set<Long> paramSet)
  {
    if (!CollectionUtils.isEmpty(paramSet))
    {
      HashSet localHashSet = new HashSet(paramSet.size());
      Iterator localIterator1 = this.c.snapshot().entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        if (paramSet.contains(Long.valueOf(((h)localEntry.getValue()).getId())))
          localHashSet.add(localEntry.getKey());
      }
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        this.c.remove(str);
      }
    }
  }

  public Long b(c paramc)
  {
    return (Long)this.e.get(paramc);
  }

  public void b(LongSparseSet paramLongSparseSet)
  {
    if (!u.a(paramLongSparseSet))
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator1 = this.d.snapshot().entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        if (paramLongSparseSet.contains(((Long)localEntry.getValue()).longValue()))
          localHashSet.add(localEntry.getKey());
      }
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
      {
        d locald = (d)localIterator2.next();
        this.d.remove(locald);
      }
    }
  }

  public static class a
  {
    private long a;
    private Member b;
    private int c;
    private LongSparseArray<Member> d = new LongSparseArray();
    private final ArrayList<MessageEntity> e = new ArrayList();
    private final LongSparseSet f = new LongSparseSet();
    private Map<Pair<Long, String>, f.b> g;
    private int h;
    private boolean i;
    private final String j;
    private volatile int k;

    public a(long paramLong, int paramInt, String paramString)
    {
      this.a = paramLong;
      this.h = paramInt;
      this.j = paramString;
    }

    public a(Member paramMember, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
    {
      this.b = paramMember;
      this.c = paramInt1;
      this.h = paramInt2;
      this.i = paramBoolean;
      this.j = paramString;
    }

    private Map<Pair<Long, String>, f.b> k()
    {
      if (this.g == null)
        this.g = new HashMap();
      return this.g;
    }

    public Member a(MessageEntity paramMessageEntity)
    {
      synchronized (this.e)
      {
        Member localMember = (Member)this.d.get(paramMessageEntity.getMessageToken());
        return localMember;
      }
    }

    public String a()
    {
      return this.j;
    }

    public ArrayList<MessageEntity> a(ArrayList<MessageEntity> paramArrayList)
    {
      synchronized (this.e)
      {
        paramArrayList.addAll(this.e);
        return paramArrayList;
      }
    }

    public void a(int paramInt)
    {
      this.k = paramInt;
    }

    public void a(f.b paramb)
    {
      j localj = paramb.a;
      this.f.add(localj.b());
      Pair localPair = new Pair(Long.valueOf(localj.a()), localj.d());
      f.b localb = (f.b)k().get(localPair);
      if ((localb == null) || (localb.a.e() < localj.e()))
        k().put(localPair, paramb);
    }

    public void a(MessageEntity paramMessageEntity, Member paramMember)
    {
      paramMessageEntity.addExtraFlag(10);
      ArrayList localArrayList = this.e;
      if (paramMember != null);
      try
      {
        this.d.put(paramMessageEntity.getMessageToken(), paramMember);
        this.e.add(paramMessageEntity);
        return;
      }
      finally
      {
      }
    }

    public boolean b()
    {
      return this.i;
    }

    public long c()
    {
      return this.a;
    }

    public Member d()
    {
      return this.b;
    }

    public int e()
    {
      return this.c;
    }

    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a))
      {
        a locala = (a)paramObject;
        return ((h()) && (this.a == locala.a)) || ((this.b != null) && (this.b.equals(locala.b)) && (da.a(this.j, locala.j)) && (this.i == locala.b()));
      }
      return super.equals(paramObject);
    }

    public Collection<f.b> f()
    {
      return Collections.unmodifiableCollection(k().values());
    }

    public long[] g()
    {
      return this.f.toArray();
    }

    public boolean h()
    {
      return this.a > 0L;
    }

    public int hashCode()
    {
      if (this.b == null)
        return (int)this.a;
      int m = 31 * this.b.hashCode();
      if (this.j == null);
      for (int n = 0; ; n = this.j.hashCode())
      {
        int i1 = 31 * (n + m);
        boolean bool = this.i;
        int i2 = 0;
        if (bool)
          i2 = 1;
        return i1 + i2;
      }
    }

    public int i()
    {
      return this.h;
    }

    public int j()
    {
      return this.k;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Conversation [mGroupId=").append(this.a).append(", mConversationType=").append(this.h).append(", mToVln=").append(this.j).append(", mIsSecret=").append(this.i).append(", mLastReadIncreaseDelta=").append(this.k).append(", mMember=").append(this.b).append(", mLikes=").append(this.g).append(", mEntitesBuffer.size=");
      if (this.e != null);
      for (int m = this.e.size(); ; m = 0)
        return m + "]";
    }
  }

  public static class b
  {
    final j a;
    final int b;
    final boolean c;

    public b(int paramInt, boolean paramBoolean, j paramj)
    {
      this.a = paramj;
      this.b = paramInt;
      this.c = paramBoolean;
    }

    public j a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }

    public boolean c()
    {
      return this.c;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (this == paramObject)
        bool2 = true;
      b localb;
      boolean bool3;
      boolean bool4;
      do
      {
        int i;
        int j;
        do
        {
          boolean bool1;
          do
          {
            return bool2;
            bool1 = paramObject instanceof b;
            bool2 = false;
          }
          while (!bool1);
          localb = (b)paramObject;
          i = this.b;
          j = localb.b;
          bool2 = false;
        }
        while (i != j);
        bool3 = this.c;
        bool4 = localb.c;
        bool2 = false;
      }
      while (bool3 != bool4);
      return this.a.equals(localb.a);
    }

    public int hashCode()
    {
      int i = 31 * (31 * this.a.hashCode() + this.b);
      if (this.c);
      for (int j = 1; ; j = 0)
        return j + i;
    }
  }

  public static class c
  {
    private final String a;
    private final int b;

    public c(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      c localc;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localc = (c)paramObject;
        if (this.b != localc.b)
          return false;
        if (this.a != null)
          return this.a.equals(localc.a);
      }
      while (localc.a == null);
      return false;
    }

    public int hashCode()
    {
      if (this.a != null);
      for (int i = this.a.hashCode(); ; i = 0)
        return i * 31 + this.b;
    }
  }

  public static class d
  {
    private final long a;
    private final long b;

    public d(long paramLong1, long paramLong2)
    {
      this.a = paramLong1;
      this.b = paramLong2;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      d locald;
      do
      {
        return true;
        if (!(paramObject instanceof d))
          break;
        locald = (d)paramObject;
      }
      while ((this.a == locald.a) && (this.b == locald.b));
      return false;
      return false;
    }

    public int hashCode()
    {
      return 31 * (int)(this.a ^ this.a >>> 32) + (int)(this.b ^ this.b >>> 32);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.f
 * JD-Core Version:    0.6.2
 */