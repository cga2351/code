package com.viber.voip.contacts.c.c.a;

import com.viber.voip.contacts.c.c.c.a;
import com.viber.voip.memberid.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b
  implements com.viber.voip.contacts.c.c.b
{
  protected final List<c.a> a = Collections.synchronizedList(new ArrayList());

  @Deprecated
  public static b a()
  {
    return b.a();
  }

  private void a(a parama)
  {
    synchronized (this.a)
    {
      ArrayList localArrayList = new ArrayList(this.a);
      Iterator localIterator = localArrayList.iterator();
      if (localIterator.hasNext())
        parama.a((c.a)localIterator.next());
    }
  }

  public void a(c.a parama)
  {
    synchronized (this.a)
    {
      this.a.add(parama);
      return;
    }
  }

  public void a(final Set<Member> paramSet, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(c.a paramAnonymousa)
      {
        paramAnonymousa.a(paramSet, paramBoolean);
      }
    });
  }

  public void b(c.a parama)
  {
    synchronized (this.a)
    {
      this.a.remove(parama);
      return;
    }
  }

  public void b(final Set<Member> paramSet, final boolean paramBoolean)
  {
    a(new a()
    {
      public void a(c.a paramAnonymousa)
      {
        paramAnonymousa.b(paramSet, paramBoolean);
      }
    });
  }

  private static abstract interface a
  {
    public abstract void a(c.a parama);
  }

  private static class b
  {
    private static b a = new b(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.c.a.b
 * JD-Core Version:    0.6.2
 */