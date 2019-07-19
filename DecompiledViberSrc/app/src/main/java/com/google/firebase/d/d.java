package com.google.firebase.d;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class d
{
  private static volatile d b;
  private final Set<e> a = new HashSet();

  public static d b()
  {
    d locald1 = b;
    if (locald1 == null)
      try
      {
        d locald2 = b;
        if (locald2 == null)
        {
          locald2 = new d();
          b = locald2;
        }
        return locald2;
      }
      finally
      {
      }
    return locald1;
  }

  Set<e> a()
  {
    synchronized (this.a)
    {
      Set localSet2 = Collections.unmodifiableSet(this.a);
      return localSet2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.d.d
 * JD-Core Version:    0.6.2
 */