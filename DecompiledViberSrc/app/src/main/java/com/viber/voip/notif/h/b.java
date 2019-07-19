package com.viber.voip.notif.h;

import android.support.v4.util.CircularArray;
import android.support.v4.util.LongSparseArray;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.g.f;
import com.viber.voip.util.LongSparseSet;

public class b
  implements m
{
  private final CircularArray<m> a = new CircularArray();
  private int b = -1;
  private int c = -1;

  b(m paramm)
  {
    a(paramm);
  }

  public int a()
  {
    return this.a.size();
  }

  public com.viber.voip.notif.d.e a(f paramf, com.viber.voip.notif.g.e parame)
  {
    return paramf.b(this, parame);
  }

  public m a(int paramInt)
  {
    return (m)this.a.get(paramInt);
  }

  void a(m paramm)
  {
    this.a.addFirst(paramm);
  }

  public CircularArray<b> b()
  {
    int i = a();
    LongSparseArray localLongSparseArray = new LongSparseArray(i);
    CircularArray localCircularArray = new CircularArray(i);
    int j = i - 1;
    if (j >= 0)
    {
      m localm = a(j);
      b localb1 = (b)localLongSparseArray.get(localm.e().getId());
      if (localb1 == null)
      {
        b localb2 = new b(localm);
        localLongSparseArray.put(localm.e().getId(), localb2);
        localCircularArray.addFirst(localb2);
      }
      while (true)
      {
        j--;
        break;
        localb1.a(localm);
      }
    }
    return localCircularArray;
  }

  public MessageEntity c()
  {
    return ((m)this.a.getLast()).c();
  }

  public com.viber.voip.model.entity.m d()
  {
    return ((m)this.a.getLast()).d();
  }

  public h e()
  {
    return ((m)this.a.getLast()).e();
  }

  public n f()
  {
    return ((m)this.a.getLast()).f();
  }

  public LongSparseSet g()
  {
    LongSparseSet localLongSparseSet = new LongSparseSet(this.a.size());
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      localLongSparseSet.add(((m)this.a.get(j)).c().getId());
    return localLongSparseSet;
  }

  public boolean h()
  {
    return ((m)this.a.getLast()).h();
  }

  public int hashCode()
  {
    int i = 0;
    int j = a();
    int k = 0;
    while (i < j)
    {
      k = k * 31 + a(i).hashCode();
      i++;
    }
    return k;
  }

  public int i()
  {
    return ((m)this.a.getLast()).i();
  }

  public int j()
  {
    if (this.b < 0)
    {
      int i = this.a.size();
      int j = 0;
      int k = 0;
      while (j < i)
      {
        k += ((m)this.a.get(j)).j();
        j++;
      }
      this.b = k;
    }
    return this.b;
  }

  public int k()
  {
    if (this.c < 0)
    {
      LongSparseSet localLongSparseSet = new LongSparseSet(this.a.size());
      int i = this.a.size();
      for (int j = 0; j < i; j++)
        localLongSparseSet.add(((m)this.a.get(j)).e().getId());
      this.c = localLongSparseSet.size();
    }
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.b
 * JD-Core Version:    0.6.2
 */