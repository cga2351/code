package android.arch.persistence.room;

import android.arch.persistence.a.d;
import android.arch.persistence.a.e;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.TreeMap;

public class h
  implements d, e
{
  static final TreeMap<Integer, h> g = new TreeMap();
  final long[] a;
  final double[] b;
  final String[] c;
  final byte[][] d;
  final int e;
  int f;
  private volatile String h;
  private final int[] i;

  private h(int paramInt)
  {
    this.e = paramInt;
    int j = paramInt + 1;
    this.i = new int[j];
    this.a = new long[j];
    this.b = new double[j];
    this.c = new String[j];
    this.d = new byte[j][];
  }

  public static h a(String paramString, int paramInt)
  {
    synchronized (g)
    {
      Map.Entry localEntry = g.ceilingEntry(Integer.valueOf(paramInt));
      if (localEntry != null)
      {
        g.remove(localEntry.getKey());
        h localh1 = (h)localEntry.getValue();
        localh1.b(paramString, paramInt);
        return localh1;
      }
      h localh2 = new h(paramInt);
      localh2.b(paramString, paramInt);
      return localh2;
    }
  }

  private static void c()
  {
    if (g.size() > 15)
    {
      int j = -10 + g.size();
      Iterator localIterator = g.descendingKeySet().iterator();
      while (true)
      {
        int k = j - 1;
        if (j <= 0)
          break;
        localIterator.next();
        localIterator.remove();
        j = k;
      }
    }
  }

  public String a()
  {
    return this.h;
  }

  public void a(int paramInt)
  {
    this.i[paramInt] = 1;
  }

  public void a(int paramInt, double paramDouble)
  {
    this.i[paramInt] = 3;
    this.b[paramInt] = paramDouble;
  }

  public void a(int paramInt, long paramLong)
  {
    this.i[paramInt] = 2;
    this.a[paramInt] = paramLong;
  }

  public void a(int paramInt, String paramString)
  {
    this.i[paramInt] = 4;
    this.c[paramInt] = paramString;
  }

  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.i[paramInt] = 5;
    this.d[paramInt] = paramArrayOfByte;
  }

  public void a(d paramd)
  {
    int j = 1;
    if (j <= this.f)
    {
      switch (this.i[j])
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      while (true)
      {
        j++;
        break;
        paramd.a(j);
        continue;
        paramd.a(j, this.a[j]);
        continue;
        paramd.a(j, this.b[j]);
        continue;
        paramd.a(j, this.c[j]);
        continue;
        paramd.a(j, this.d[j]);
      }
    }
  }

  public void b()
  {
    synchronized (g)
    {
      g.put(Integer.valueOf(this.e), this);
      c();
      return;
    }
  }

  void b(String paramString, int paramInt)
  {
    this.h = paramString;
    this.f = paramInt;
  }

  public void close()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.h
 * JD-Core Version:    0.6.2
 */