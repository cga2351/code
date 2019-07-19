package com.viber.voip.b.a.a;

import com.viber.voip.b.a;
import com.viber.voip.b.a.c;
import com.viber.voip.b.e;
import com.viber.voip.util.e.j;

public class b<K>
  implements c<K>
{
  private e<K, a> a;
  private final String b;

  public b(a parama)
  {
    this.b = parama.toString();
    this.a = new e(parama)
    {
      protected int a(K paramAnonymousK, b.a paramAnonymousa)
      {
        return b.a.a(paramAnonymousa);
      }
    };
  }

  public pl.droidsonroids.gif.b a(K paramK)
  {
    a locala = (a)this.a.get(paramK);
    if (locala == null)
      return null;
    return a.b(locala);
  }

  public pl.droidsonroids.gif.b a(K paramK, pl.droidsonroids.gif.b paramb)
  {
    this.a.put(paramK, new a(paramb));
    return paramb;
  }

  public pl.droidsonroids.gif.b b(K paramK)
  {
    a locala = (a)this.a.remove(paramK);
    if (locala == null)
      return null;
    return a.b(locala);
  }

  public void evictAll()
  {
    this.a.evictAll();
  }

  public int size()
  {
    return this.a.size();
  }

  public void trimToSize(int paramInt)
  {
    this.a.trimToSize(paramInt);
  }

  private static class a
  {
    private final pl.droidsonroids.gif.b a;
    private final int b;

    public a(pl.droidsonroids.gif.b paramb)
    {
      this.a = paramb;
      this.b = j.a(paramb);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
        if (this.a == null)
          break;
      }
      while (this.a.equals(locala.a));
      while (locala.a != null)
        return false;
      return true;
    }

    public int hashCode()
    {
      if (this.a != null)
        return this.a.hashCode();
      return 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a.b
 * JD-Core Version:    0.6.2
 */