package com.viber.voip.backgrounds.c;

import android.net.Uri;
import android.os.Handler;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backgrounds.b;
import com.viber.voip.backgrounds.p;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.h;
import dagger.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f
  implements d.a, e
{
  a<k> a = ViberApplication.getInstance().getLazyMessagesManager();
  Map<Integer, d> b = new HashMap();
  Map<Long, Integer> c = new HashMap();
  Set<e.a> d = new HashSet();
  private boolean e = false;
  private Handler f = av.a(av.e.f);

  private void a()
  {
    try
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (b(((Integer)localEntry.getKey()).intValue()).size() == 0)
        {
          ((d)localEntry.getValue()).a();
          localIterator.remove();
        }
      }
    }
    finally
    {
    }
  }

  private Set<Long> b(int paramInt)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (((Integer)this.c.get(localLong)).intValue() == paramInt)
        localHashSet.add(localLong);
    }
    return localHashSet;
  }

  public void a(int paramInt)
  {
    this.e = false;
    this.b.remove(Integer.valueOf(paramInt));
    Iterator localIterator1 = b(paramInt).iterator();
    while (localIterator1.hasNext())
    {
      Long localLong = (Long)localIterator1.next();
      Iterator localIterator2 = this.d.iterator();
      while (localIterator2.hasNext())
      {
        e.a locala = (e.a)localIterator2.next();
        if (locala.a() == localLong.longValue())
          locala.b(paramInt);
      }
      this.c.remove(localLong);
    }
  }

  public void a(int paramInt, Uri[] paramArrayOfUri)
  {
    if ((paramArrayOfUri == null) || (paramArrayOfUri.length < 2));
    while (true)
    {
      return;
      Uri localUri1 = paramArrayOfUri[0];
      Uri localUri2 = paramArrayOfUri[1];
      ab localab = ab.b();
      this.b.remove(Integer.valueOf(paramInt));
      Iterator localIterator1 = b(paramInt).iterator();
      while (localIterator1.hasNext())
      {
        Long localLong = (Long)localIterator1.next();
        if ((localUri1 != null) && (localUri2 != null))
        {
          if (localLong.longValue() != -1L)
            break label182;
          b.a().a(paramInt, localUri1.toString(), localUri2.toString());
          this.e = false;
          b.a().d();
        }
        while (true)
        {
          Iterator localIterator2 = this.d.iterator();
          while (localIterator2.hasNext())
          {
            e.a locala = (e.a)localIterator2.next();
            if (locala.a() == localLong.longValue())
              locala.a(paramInt, paramArrayOfUri);
          }
          label182: h localh = localab.f(localLong.longValue());
          if ((localh != null) && ((!localUri1.toString().equals(localh.t())) || (!localUri2.toString().equals(localh.s()))))
            ((k)this.a.get()).d().a(localLong.longValue(), localh.j(), localUri1.toString(), localUri2.toString());
        }
        this.c.remove(localLong);
      }
    }
  }

  public void a(long paramLong, p paramp, boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (paramLong == 0L);
    int i;
    do
    {
      return;
      i = paramp.a;
      this.c.put(Long.valueOf(paramLong), Integer.valueOf(i));
    }
    while (this.b.containsKey(Integer.valueOf(i)));
    d locald = new d(paramp, this);
    this.f.post(locald);
    this.b.put(Integer.valueOf(i), locald);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      e.a locala = (e.a)localIterator.next();
      if (locala.a() == paramLong)
        locala.a(i);
    }
    a();
  }

  public void a(e.a parama)
  {
    this.d.add(parama);
    if (this.c.containsKey(Long.valueOf(parama.a())))
      parama.a(((Integer)this.c.get(Long.valueOf(parama.a()))).intValue());
  }

  public void a(p paramp)
  {
    a(-1L, paramp, false);
  }

  public void b(e.a parama)
  {
    this.d.remove(parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.c.f
 * JD-Core Version:    0.6.2
 */