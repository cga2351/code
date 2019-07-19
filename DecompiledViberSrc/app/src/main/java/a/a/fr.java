package a.a;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class fr
{
  private final PriorityQueue<dy> a = new PriorityQueue(16, b());

  public fr(List<dy> paramList)
  {
    this.a.addAll(paramList);
  }

  private static Comparator<dy> b()
  {
    return new Comparator()
    {
      public int a(dy paramAnonymousdy1, dy paramAnonymousdy2)
      {
        int i = paramAnonymousdy1.c().c();
        int j = paramAnonymousdy2.c().c();
        if (i > j)
          return -1;
        if (i < j)
          return 1;
        return paramAnonymousdy1.b().compareTo(paramAnonymousdy2.b());
      }
    };
  }

  public dy a()
  {
    return (dy)this.a.poll();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fr
 * JD-Core Version:    0.6.2
 */