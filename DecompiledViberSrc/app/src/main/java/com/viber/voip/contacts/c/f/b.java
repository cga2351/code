package com.viber.voip.contacts.c.f;

import android.content.Context;
import com.viber.voip.contacts.c.d.g.e;
import com.viber.voip.contacts.c.f.b.f;
import com.viber.voip.contacts.c.f.b.f.a;
import com.viber.voip.model.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b
{
  private static volatile b a;
  private f b;
  private int c;
  private Set<g.e> d = new HashSet();

  private b(Context paramContext)
  {
    this.b = f.a(paramContext);
    c(null);
  }

  public static b a(Context paramContext)
  {
    if (a == null)
      a = new b(paramContext);
    return a;
  }

  private void b(Set<i> paramSet)
  {
    try
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
        ((g.e)localIterator.next()).a(this.c, paramSet);
    }
    finally
    {
    }
  }

  private void c(final Set<i> paramSet)
  {
    this.b.a(new f.a()
    {
      public void a(int paramAnonymousInt)
      {
        if ((paramAnonymousInt != b.a(b.this)) || ((paramSet != null) && (paramSet.size() > 0)))
        {
          b.a(b.this, paramAnonymousInt);
          b.a(b.this, paramSet);
        }
      }
    });
  }

  public void a()
  {
    c(null);
  }

  public void a(g.e parame)
  {
    try
    {
      this.d.add(parame);
      parame.a(this.c, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Set<i> paramSet)
  {
    c(paramSet);
  }

  public void b(g.e parame)
  {
    try
    {
      this.d.remove(parame);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b
 * JD-Core Version:    0.6.2
 */