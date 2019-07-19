package com.google.firebase.d;

import com.google.firebase.components.b.a;
import com.google.firebase.components.n;
import java.util.Iterator;
import java.util.Set;

public class b
  implements g
{
  private final String a;
  private final d b;

  b(Set<e> paramSet, d paramd)
  {
    this.a = a(paramSet);
    this.b = paramd;
  }

  private static String a(Set<e> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      localStringBuilder.append(locale.a()).append('/').append(locale.b());
      if (localIterator.hasNext())
        localStringBuilder.append(' ');
    }
    return localStringBuilder.toString();
  }

  public static com.google.firebase.components.b<g> b()
  {
    return com.google.firebase.components.b.a(g.class).a(n.b(e.class)).a(c.a()).b();
  }

  public String a()
  {
    if (this.b.a().isEmpty())
      return this.a;
    return this.a + ' ' + a(this.b.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.d.b
 * JD-Core Version:    0.6.2
 */