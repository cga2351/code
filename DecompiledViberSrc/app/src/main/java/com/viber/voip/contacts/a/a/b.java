package com.viber.voip.contacts.a.a;

import com.viber.voip.contacts.model.a.a.a;
import com.viber.voip.contacts.model.a.a.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b extends a<a.b, a.a>
{
  private final List<a> a = new LinkedList();
  private final b b = new b(0L, null);

  public int a(a.b paramb)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (a.b(locala) == paramb)
        return a.a(locala).size();
    }
    return 0;
  }

  public int a(String paramString)
  {
    for (int i = 0; i < b(); i++)
    {
      String str = d(i).g();
      if (((paramString == null) && (str == null)) || ((paramString != null) && (paramString.equals(str))))
        return i;
    }
    return -1;
  }

  public void a(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    ((a)this.a.get(paramInt1)).a(paramInt2, paramArrayOfObject);
  }

  public int b()
  {
    return this.a.size();
  }

  public int b(int paramInt)
  {
    return a.a((a)this.a.get(paramInt)).size();
  }

  public a.a b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= b()))
      throw new IndexOutOfBoundsException("groupPosition = " + paramInt1);
    List localList = a.a((a)this.a.get(paramInt1));
    if ((paramInt2 < 0) || (paramInt2 >= localList.size()))
      throw new IndexOutOfBoundsException("childPosition = " + paramInt2);
    return (a.a)localList.get(paramInt2);
  }

  public void b(int paramInt, Object[] paramArrayOfObject)
  {
    a.b localb = new a.b(this.b.a(), (String)paramArrayOfObject[0], paramArrayOfObject[1]);
    this.a.add(paramInt, new a(localb));
  }

  public a.b d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= b()))
      throw new IndexOutOfBoundsException("groupPosition = " + paramInt);
    return a.b((a)this.a.get(paramInt));
  }

  private static class a
  {
    private final a.b a;
    private final List<a.a> b;
    private final b.b c;

    public a(a.b paramb)
    {
      this.a = paramb;
      this.b = new LinkedList();
      this.c = new b.b(4294967296L, null);
    }

    public void a(int paramInt, Object[] paramArrayOfObject)
    {
      a.a locala = new a.a(this.c.a(), paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue());
      this.b.add(paramInt, locala);
    }
  }

  private static class b
  {
    private long a;

    private b()
    {
      this.a = 0L;
    }

    private b(long paramLong)
    {
      this.a = paramLong;
    }

    public long a()
    {
      long l = this.a;
      this.a = (1L + l);
      return l;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.a.a.b
 * JD-Core Version:    0.6.2
 */