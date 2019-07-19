package com.viber.voip.model.entity;

import android.text.TextUtils;
import com.viber.voip.contacts.b.a.c;
import com.viber.voip.contacts.c.f.b.a.a;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.messages.orm.entity.EntityUpdater;
import com.viber.voip.model.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class f extends e
{
  public static final CreatorHelper a = new c();
  protected Set<s> b;

  public f()
  {
  }

  public f(String paramString1, String paramString2, Set<a.a> paramSet)
  {
    super(paramString1, paramString2);
    s locals = new s();
    locals.a(new HashSet());
    this.b = new HashSet();
    this.b.add(locals);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      this.v = true;
      locals.b().add(new k(locala.b()));
    }
  }

  public f(Set<o> paramSet)
  {
    super((o)paramSet.iterator().next());
    this.b = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      s locals = e(localo.i());
      if (locals == null)
      {
        locals = new s(localo);
        locals.a(this);
        locals.a(new HashSet());
        this.b.add(locals);
      }
      k localk;
      if (("vnd.android.cursor.item/phone_v2".equals(localo.a())) && (!TextUtils.isEmpty(localo.b())))
      {
        localk = new k(localo);
        label142: if (localk != null)
        {
          localk.a(locals);
          localk.a(this);
          locals.b().add(localk);
        }
      }
      else
      {
        if ("vnd.android.cursor.item/name".equals(localo.a()))
          if (TextUtils.isEmpty(localo.b()))
            break label213;
        label213: for (boolean bool = true; ; bool = false)
        {
          this.w = bool;
          localk = null;
          break label142;
          break;
        }
      }
    }
  }

  public f a(Set<o> paramSet)
  {
    o localo1 = (o)paramSet.iterator().next();
    this.id = localo1.e();
    this.n = localo1.e();
    h(localo1.f());
    m(localo1.l());
    this.r = localo1.j();
    this.t = localo1.k();
    this.C = localo1.m();
    this.D = localo1.n();
    this.w = false;
    this.v = false;
    this.b = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      o localo2 = (o)localIterator.next();
      if (e(localo2.i()) == null)
      {
        s locals = new s(localo2);
        locals.a(this);
        locals.a(new HashSet());
        this.b.add(locals);
      }
    }
    return this;
  }

  public Set<s> a()
  {
    return this.b;
  }

  public void a(HashSet<s> paramHashSet)
  {
    this.b = paramHashSet;
  }

  public s b()
  {
    if ((this.b != null) && (this.b.size() > 0))
      return (s)this.b.iterator().next();
    return null;
  }

  public int c()
  {
    if (this.b == null)
      throw new RuntimeException("can't calculate hash cause accounts not initialized");
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      s locals = (s)localIterator1.next();
      if (locals.b() == null)
        throw new RuntimeException("can't calculate hash cause contacts data not initialized at accounts");
      Iterator localIterator3 = locals.b().iterator();
      while (localIterator3.hasNext())
      {
        t localt = (t)localIterator3.next();
        if ((localt instanceof k))
          localTreeSet.add(((k)localt).b());
      }
    }
    int i = this.o.hashCode();
    if (TextUtils.isEmpty(this.C));
    int m;
    for (int j = 1; ; j = this.C.hashCode() << 5)
    {
      int k = j + i;
      Iterator localIterator2 = localTreeSet.iterator();
      String str;
      for (m = k; localIterator2.hasNext(); m = m * 31 + str.hashCode())
        str = (String)localIterator2.next();
    }
    return m;
  }

  public Set<String> d()
  {
    HashSet localHashSet;
    if (this.b != null)
    {
      localHashSet = new HashSet();
      Iterator localIterator1 = this.b.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((s)localIterator1.next()).b().iterator();
        while (localIterator2.hasNext())
        {
          t localt = (t)localIterator2.next();
          if ((localt instanceof k))
            localHashSet.add(((k)localt).b());
        }
      }
    }
    throw new RuntimeException("Can't get all numbers while accounts not initialized");
    return localHashSet;
  }

  public s e(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      if (locals.getId() == paramLong)
        return locals;
    }
    return null;
  }

  public EntityUpdater<? extends d> f()
  {
    return new e.a(this, new String[] { "display_name", "phonetic_name", "contact_lookup_key", "starred", "has_name", "phone_label", "native_photo_id" });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.f
 * JD-Core Version:    0.6.2
 */