package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;

public class fp
{
  public static final class a
  {
    private final List<a> a;
    private boolean b;

    protected final void finalize()
      throws Throwable
    {
      if (!this.b)
      {
        this.b = true;
        if (this.a.size() == 0);
        long l1;
        for (long l2 = 0L; l2 > 0L; l2 = ((a)this.a.get(-1 + this.a.size())).c - l1)
        {
          long l3 = ((a)this.a.get(0)).c;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Long.valueOf(l2);
          arrayOfObject1[1] = "Request on the loose";
          Iterator localIterator = this.a.iterator();
          long l5;
          for (long l4 = l3; localIterator.hasNext(); l4 = l5)
          {
            a locala = (a)localIterator.next();
            l5 = locala.c;
            Object[] arrayOfObject2 = new Object[3];
            arrayOfObject2[0] = Long.valueOf(l5 - l4);
            arrayOfObject2[1] = Long.valueOf(locala.b);
            arrayOfObject2[2] = locala.a;
          }
          l1 = ((a)this.a.get(0)).c;
        }
      }
      super.finalize();
    }

    private static final class a
    {
      public final String a;
      public final long b;
      public final long c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fp
 * JD-Core Version:    0.6.2
 */