package android.support.v7.d;

import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static final Comparator<f> a = new Comparator()
  {
    public int a(c.f paramAnonymousf1, c.f paramAnonymousf2)
    {
      int i = paramAnonymousf1.a - paramAnonymousf2.a;
      if (i == 0)
        i = paramAnonymousf1.b - paramAnonymousf2.b;
      return i;
    }
  };

  public static b a(a parama)
  {
    return a(parama, true);
  }

  public static b a(a parama, boolean paramBoolean)
  {
    int i = parama.getOldListSize();
    int j = parama.getNewListSize();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new e(0, i, 0, j));
    int k = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[k * 2];
    int[] arrayOfInt2 = new int[k * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      e locale1 = (e)localArrayList2.remove(-1 + localArrayList2.size());
      f localf = a(parama, locale1.a, locale1.b, locale1.c, locale1.d, arrayOfInt1, arrayOfInt2, k);
      if (localf != null)
      {
        if (localf.c > 0)
          localArrayList1.add(localf);
        localf.a += locale1.a;
        localf.b += locale1.c;
        e locale2;
        if (localArrayList3.isEmpty())
        {
          locale2 = new e();
          label221: locale2.a = locale1.a;
          locale2.c = locale1.c;
          if (!localf.e)
            break label366;
          locale2.b = localf.a;
          locale2.d = localf.b;
          label269: localArrayList2.add(locale2);
          if (!localf.e)
            break label461;
          if (!localf.d)
            break label424;
          locale1.a = (1 + (localf.a + localf.c));
          locale1.c = (localf.b + localf.c);
        }
        while (true)
        {
          localArrayList2.add(locale1);
          break;
          locale2 = (e)localArrayList3.remove(-1 + localArrayList3.size());
          break label221;
          label366: if (localf.d)
          {
            locale2.b = (-1 + localf.a);
            locale2.d = localf.b;
            break label269;
          }
          locale2.b = localf.a;
          locale2.d = (-1 + localf.b);
          break label269;
          label424: locale1.a = (localf.a + localf.c);
          locale1.c = (1 + (localf.b + localf.c));
          continue;
          label461: locale1.a = (localf.a + localf.c);
          locale1.c = (localf.b + localf.c);
        }
      }
      localArrayList3.add(locale1);
    }
    Collections.sort(localArrayList1, a);
    return new b(parama, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }

  private static f a(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int i = paramInt2 - paramInt1;
    int j = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 < 1) || (paramInt4 - paramInt3 < 1))
      return null;
    int k = i - j;
    int m = (1 + (i + j)) / 2;
    Arrays.fill(paramArrayOfInt1, -1 + (paramInt5 - m), 1 + (paramInt5 + m), 0);
    Arrays.fill(paramArrayOfInt2, k + (-1 + (paramInt5 - m)), k + (1 + (paramInt5 + m)), i);
    int n;
    if (k % 2 != 0)
      n = 1;
    for (int i1 = 0; ; i1++)
    {
      if (i1 > m)
        break label685;
      for (int i2 = -i1; ; i2 += 2)
      {
        if (i2 > i1)
          break label394;
        int i9;
        if ((i2 == -i1) || ((i2 != i1) && (paramArrayOfInt1[(-1 + (paramInt5 + i2))] < paramArrayOfInt1[(1 + (paramInt5 + i2))])))
          i9 = paramArrayOfInt1[(1 + (paramInt5 + i2))];
        int i11;
        for (boolean bool2 = false; ; bool2 = true)
        {
          int i10 = i9 - i2;
          i11 = i9;
          for (int i12 = i10; (i11 < i) && (i12 < j) && (parama.areItemsTheSame(paramInt1 + i11, paramInt3 + i12)); i12++)
            i11++;
          n = 0;
          break;
          i9 = 1 + paramArrayOfInt1[(-1 + (paramInt5 + i2))];
        }
        paramArrayOfInt1[(paramInt5 + i2)] = i11;
        if ((n != 0) && (i2 >= 1 + (k - i1)) && (i2 <= -1 + (k + i1)) && (paramArrayOfInt1[(paramInt5 + i2)] >= paramArrayOfInt2[(paramInt5 + i2)]))
        {
          f localf2 = new f();
          localf2.a = paramArrayOfInt2[(paramInt5 + i2)];
          localf2.b = (localf2.a - i2);
          localf2.c = (paramArrayOfInt1[(paramInt5 + i2)] - paramArrayOfInt2[(paramInt5 + i2)]);
          localf2.d = bool2;
          localf2.e = false;
          return localf2;
        }
      }
      label394: for (int i3 = -i1; i3 <= i1; i3 += 2)
      {
        int i4 = i3 + k;
        int i5;
        if ((i4 == i1 + k) || ((i4 != k + -i1) && (paramArrayOfInt2[(-1 + (paramInt5 + i4))] < paramArrayOfInt2[(1 + (paramInt5 + i4))])))
          i5 = paramArrayOfInt2[(-1 + (paramInt5 + i4))];
        int i7;
        for (boolean bool1 = false; ; bool1 = true)
        {
          int i6 = i5 - i4;
          i7 = i5;
          for (int i8 = i6; (i7 > 0) && (i8 > 0) && (parama.areItemsTheSame(-1 + (paramInt1 + i7), -1 + (paramInt3 + i8))); i8--)
            i7--;
          i5 = -1 + paramArrayOfInt2[(1 + (paramInt5 + i4))];
        }
        paramArrayOfInt2[(paramInt5 + i4)] = i7;
        if ((n == 0) && (i3 + k >= -i1) && (i3 + k <= i1) && (paramArrayOfInt1[(paramInt5 + i4)] >= paramArrayOfInt2[(paramInt5 + i4)]))
        {
          f localf1 = new f();
          localf1.a = paramArrayOfInt2[(paramInt5 + i4)];
          localf1.b = (localf1.a - i4);
          localf1.c = (paramArrayOfInt1[(paramInt5 + i4)] - paramArrayOfInt2[(paramInt5 + i4)]);
          localf1.d = bool1;
          localf1.e = true;
          return localf1;
        }
      }
    }
    label685: throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }

  public static abstract class a
  {
    public abstract boolean areContentsTheSame(int paramInt1, int paramInt2);

    public abstract boolean areItemsTheSame(int paramInt1, int paramInt2);

    public Object getChangePayload(int paramInt1, int paramInt2)
    {
      return null;
    }

    public abstract int getNewListSize();

    public abstract int getOldListSize();
  }

  public static class b
  {
    private final List<c.f> a;
    private final int[] b;
    private final int[] c;
    private final c.a d;
    private final int e;
    private final int f;
    private final boolean g;

    b(c.a parama, List<c.f> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      this.a = paramList;
      this.b = paramArrayOfInt1;
      this.c = paramArrayOfInt2;
      Arrays.fill(this.b, 0);
      Arrays.fill(this.c, 0);
      this.d = parama;
      this.e = parama.getOldListSize();
      this.f = parama.getNewListSize();
      this.g = paramBoolean;
      a();
      b();
    }

    private static c.d a(List<c.d> paramList, int paramInt, boolean paramBoolean)
    {
      for (int i = -1 + paramList.size(); i >= 0; i--)
      {
        locald1 = (c.d)paramList.get(i);
        if ((locald1.a == paramInt) && (locald1.c == paramBoolean))
        {
          paramList.remove(i);
          int j = i;
          if (j >= paramList.size())
            break label123;
          c.d locald2 = (c.d)paramList.get(j);
          int k = locald2.b;
          if (paramBoolean);
          for (int m = 1; ; m = -1)
          {
            locald2.b = (m + k);
            j++;
            break;
          }
        }
      }
      c.d locald1 = null;
      label123: return locald1;
    }

    private void a()
    {
      if (this.a.isEmpty());
      for (c.f localf1 = null; ; localf1 = (c.f)this.a.get(0))
      {
        if ((localf1 == null) || (localf1.a != 0) || (localf1.b != 0))
        {
          c.f localf2 = new c.f();
          localf2.a = 0;
          localf2.b = 0;
          localf2.d = false;
          localf2.c = 0;
          localf2.e = false;
          this.a.add(0, localf2);
        }
        return;
      }
    }

    private void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.b[(paramInt1 - 1)] != 0)
        return;
      a(paramInt1, paramInt2, paramInt3, false);
    }

    private void a(List<c.d> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.g)
        paramd.onInserted(paramInt1, paramInt2);
      int i;
      do
      {
        return;
        i = paramInt2 - 1;
      }
      while (i < 0);
      int j = 0x1F & this.c[(paramInt3 + i)];
      Iterator localIterator;
      switch (j)
      {
      default:
        throw new IllegalStateException("unknown flag for pos " + (i + paramInt3) + " " + Long.toBinaryString(j));
      case 0:
        paramd.onInserted(paramInt1, 1);
        localIterator = paramList.iterator();
      case 4:
      case 8:
        while (localIterator.hasNext())
        {
          c.d locald = (c.d)localIterator.next();
          locald.b = (1 + locald.b);
          continue;
          int k = this.c[(paramInt3 + i)] >> 5;
          paramd.onMoved(a(paramList, k, true).b, paramInt1);
          if (j == 4)
            paramd.onChanged(paramInt1, 1, this.d.getChangePayload(k, paramInt3 + i));
        }
      case 16:
      }
      while (true)
      {
        i--;
        break;
        paramList.add(new c.d(paramInt3 + i, paramInt1, false));
      }
    }

    private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int i = 8;
      int j;
      int k;
      int m;
      if (paramBoolean)
      {
        int i5 = paramInt2 - 1;
        paramInt2--;
        j = i5;
        k = paramInt1;
        m = k;
      }
      while (true)
      {
        if (paramInt3 < 0)
          break label281;
        c.f localf = (c.f)this.a.get(paramInt3);
        int n = localf.a + localf.c;
        int i1 = localf.b + localf.c;
        if (paramBoolean)
          for (int i3 = m - 1; ; i3--)
          {
            if (i3 < n)
              break label262;
            if (this.d.areItemsTheSame(i3, j))
            {
              if (this.d.areContentsTheSame(i3, j));
              for (int i4 = i; ; i4 = 4)
              {
                this.c[j] = (0x10 | i3 << 5);
                this.b[i3] = (i4 | j << 5);
                return true;
                j = paramInt1 - 1;
                k = paramInt1 - 1;
                break;
              }
            }
          }
        for (int i2 = paramInt2 - 1; i2 >= i1; i2--)
          if (this.d.areItemsTheSame(j, i2))
          {
            if (this.d.areContentsTheSame(j, i2));
            while (true)
            {
              this.b[(paramInt1 - 1)] = (0x10 | i2 << 5);
              this.c[i2] = (i | paramInt1 - 1 << 5);
              return true;
              i = 4;
            }
          }
        label262: m = localf.a;
        paramInt2 = localf.b;
        paramInt3--;
      }
      label281: return false;
    }

    private void b()
    {
      int i = this.e;
      int j = this.f;
      for (int k = -1 + this.a.size(); k >= 0; k--)
      {
        c.f localf = (c.f)this.a.get(k);
        int m = localf.a + localf.c;
        int n = localf.b + localf.c;
        if (this.g)
        {
          while (i > m)
          {
            a(i, j, k);
            i--;
          }
          while (j > n)
          {
            b(i, j, k);
            j--;
          }
        }
        int i1 = 0;
        if (i1 < localf.c)
        {
          int i2 = i1 + localf.a;
          int i3 = i1 + localf.b;
          if (this.d.areContentsTheSame(i2, i3));
          for (int i4 = 1; ; i4 = 2)
          {
            this.b[i2] = (i4 | i3 << 5);
            this.c[i3] = (i4 | i2 << 5);
            i1++;
            break;
          }
        }
        i = localf.a;
        j = localf.b;
      }
    }

    private void b(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.c[(paramInt2 - 1)] != 0)
        return;
      a(paramInt1, paramInt2, paramInt3, true);
    }

    private void b(List<c.d> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.g)
        paramd.onRemoved(paramInt1, paramInt2);
      int i;
      do
      {
        return;
        i = paramInt2 - 1;
      }
      while (i < 0);
      int j = 0x1F & this.b[(paramInt3 + i)];
      Iterator localIterator;
      switch (j)
      {
      default:
        throw new IllegalStateException("unknown flag for pos " + (i + paramInt3) + " " + Long.toBinaryString(j));
      case 0:
        paramd.onRemoved(paramInt1 + i, 1);
        localIterator = paramList.iterator();
      case 4:
      case 8:
        while (localIterator.hasNext())
        {
          c.d locald2 = (c.d)localIterator.next();
          locald2.b = (-1 + locald2.b);
          continue;
          int k = this.b[(paramInt3 + i)] >> 5;
          c.d locald1 = a(paramList, k, false);
          paramd.onMoved(paramInt1 + i, -1 + locald1.b);
          if (j == 4)
            paramd.onChanged(-1 + locald1.b, 1, this.d.getChangePayload(paramInt3 + i, k));
        }
      case 16:
      }
      while (true)
      {
        i--;
        break;
        paramList.add(new c.d(paramInt3 + i, paramInt1 + i, true));
      }
    }

    public void a(d paramd)
    {
      b localb;
      ArrayList localArrayList;
      int i;
      int j;
      int k;
      if ((paramd instanceof b))
      {
        localb = (b)paramd;
        localArrayList = new ArrayList();
        i = this.e;
        j = this.f;
        k = -1 + this.a.size();
      }
      int i4;
      for (int m = j; ; m = i4)
      {
        if (k < 0)
          break label250;
        c.f localf = (c.f)this.a.get(k);
        int n = localf.c;
        int i1 = n + localf.a;
        int i2 = n + localf.b;
        if (i1 < i)
          b(localArrayList, localb, i1, i - i1, i1);
        if (i2 < m)
          a(localArrayList, localb, i1, m - i2, i2);
        int i3 = n - 1;
        while (true)
          if (i3 >= 0)
          {
            if ((0x1F & this.b[(i3 + localf.a)]) == 2)
              localb.onChanged(i3 + localf.a, 1, this.d.getChangePayload(i3 + localf.a, i3 + localf.b));
            i3--;
            continue;
            localb = new b(paramd);
            break;
          }
        i = localf.a;
        i4 = localf.b;
        k--;
      }
      label250: localb.a();
    }

    public void a(RecyclerView.Adapter paramAdapter)
    {
      a(new a(paramAdapter));
    }
  }

  public static abstract class c<T>
  {
    public abstract boolean a(T paramT1, T paramT2);

    public abstract boolean b(T paramT1, T paramT2);

    public Object c(T paramT1, T paramT2)
    {
      return null;
    }
  }

  private static class d
  {
    int a;
    int b;
    boolean c;

    public d(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramBoolean;
    }
  }

  static class e
  {
    int a;
    int b;
    int c;
    int d;

    public e()
    {
    }

    public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
  }

  static class f
  {
    int a;
    int b;
    int c;
    boolean d;
    boolean e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.d.c
 * JD-Core Version:    0.6.2
 */