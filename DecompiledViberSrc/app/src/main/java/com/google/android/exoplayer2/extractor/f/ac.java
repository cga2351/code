package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ac
  implements com.google.android.exoplayer2.extractor.g
{
  public static final j a = ad.a;
  private static final long b = ag.g("AC-3");
  private static final long c = ag.g("EAC3");
  private static final long d = ag.g("HEVC");
  private final int e;
  private final List<com.google.android.exoplayer2.g.ad> f;
  private final r g;
  private final SparseIntArray h;
  private final ae.c i;
  private final SparseArray<ae> j;
  private final SparseBooleanArray k;
  private final SparseBooleanArray l;
  private final ab m;
  private aa n;
  private i o;
  private int p;
  private boolean q;
  private boolean r;
  private boolean s;
  private ae t;
  private int u;
  private int v;

  public ac()
  {
    this(0);
  }

  public ac(int paramInt)
  {
    this(1, paramInt);
  }

  public ac(int paramInt1, int paramInt2)
  {
    this(paramInt1, new com.google.android.exoplayer2.g.ad(0L), new g(paramInt2));
  }

  public ac(int paramInt, com.google.android.exoplayer2.g.ad paramad, ae.c paramc)
  {
    this.i = ((ae.c)a.a(paramc));
    this.e = paramInt;
    if ((paramInt == 1) || (paramInt == 2))
      this.f = Collections.singletonList(paramad);
    while (true)
    {
      this.g = new r(new byte[9400], 0);
      this.k = new SparseBooleanArray();
      this.l = new SparseBooleanArray();
      this.j = new SparseArray();
      this.h = new SparseIntArray();
      this.m = new ab();
      this.v = -1;
      g();
      return;
      this.f = new ArrayList();
      this.f.add(paramad);
    }
  }

  private void a(long paramLong)
  {
    if (!this.r)
    {
      this.r = true;
      if (this.m.b() != -9223372036854775807L)
      {
        this.n = new aa(this.m.c(), this.m.b(), paramLong, this.v);
        this.o.a(this.n.a());
      }
    }
    else
    {
      return;
    }
    this.o.a(new o.b(this.m.b()));
  }

  private boolean a(int paramInt)
  {
    boolean bool1;
    if ((this.e != 2) && (!this.q))
    {
      boolean bool2 = this.l.get(paramInt, false);
      bool1 = false;
      if (bool2);
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  private boolean b(h paramh)
    throws IOException, InterruptedException
  {
    byte[] arrayOfByte = this.g.a;
    if (9400 - this.g.d() < 188)
    {
      int i3 = this.g.b();
      if (i3 > 0)
        System.arraycopy(arrayOfByte, this.g.d(), arrayOfByte, 0, i3);
      this.g.a(arrayOfByte, i3);
    }
    while (this.g.b() < 188)
    {
      int i1 = this.g.c();
      int i2 = paramh.a(arrayOfByte, i1, 9400 - i1);
      if (i2 == -1)
        return false;
      this.g.b(i1 + i2);
    }
    return true;
  }

  private int f()
    throws com.google.android.exoplayer2.w
  {
    int i1 = this.g.d();
    int i2 = this.g.c();
    int i3 = af.a(this.g.a, i1, i2);
    this.g.c(i3);
    int i4 = i3 + 188;
    if (i4 > i2)
    {
      this.u += i3 - i1;
      if ((this.e == 2) && (this.u > 376))
        throw new com.google.android.exoplayer2.w("Cannot find sync byte. Most likely not a Transport Stream.");
    }
    else
    {
      this.u = 0;
    }
    return i4;
  }

  private void g()
  {
    this.k.clear();
    this.j.clear();
    SparseArray localSparseArray = this.i.a();
    int i1 = localSparseArray.size();
    for (int i2 = 0; i2 < i1; i2++)
      this.j.put(localSparseArray.keyAt(i2), localSparseArray.valueAt(i2));
    this.j.put(0, new x(new a()));
    this.t = null;
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    long l1 = paramh.d();
    if (this.q)
    {
      if ((l1 != -1L) && (this.e != 2));
      for (int i14 = 1; (i14 != 0) && (!this.m.a()); i14 = 0)
        return this.m.a(paramh, paramn, this.v);
      a(l1);
      if (this.s)
      {
        this.s = false;
        a(0L, 0L);
        if (paramh.c() != 0L)
        {
          paramn.a = 0L;
          return 1;
        }
      }
      if ((this.n != null) && (this.n.b()))
        return this.n.a(paramh, paramn, null);
    }
    if (!b(paramh))
      return -1;
    int i1 = f();
    int i2 = this.g.c();
    if (i1 > i2)
      return 0;
    int i3 = this.g.p();
    if ((0x800000 & i3) != 0)
    {
      this.g.c(i1);
      return 0;
    }
    int i4;
    int i5;
    int i6;
    int i7;
    label240: int i8;
    if ((0x400000 & i3) != 0)
    {
      i4 = 1;
      i5 = 0x0 | i4;
      i6 = (0x1FFF00 & i3) >> 8;
      if ((i3 & 0x20) == 0)
        break label292;
      i7 = 1;
      if ((i3 & 0x10) == 0)
        break label298;
      i8 = 1;
      label251: if (i8 == 0)
        break label304;
    }
    label292: label298: label304: for (ae localae = (ae)this.j.get(i6); ; localae = null)
    {
      if (localae != null)
        break label310;
      this.g.c(i1);
      return 0;
      i4 = 0;
      break;
      i7 = 0;
      break label240;
      i8 = 0;
      break label251;
    }
    label310: if (this.e != 2)
    {
      int i12 = i3 & 0xF;
      int i13 = this.h.get(i6, i12 - 1);
      this.h.put(i6, i12);
      if (i13 == i12)
      {
        this.g.c(i1);
        return 0;
      }
      if (i12 != (0xF & i13 + 1))
        localae.a();
    }
    int i11;
    int i9;
    if (i7 != 0)
    {
      int i10 = this.g.h();
      if ((0x40 & this.g.h()) != 0)
      {
        i11 = 2;
        i9 = i11 | i5;
        this.g.d(i10 - 1);
      }
    }
    while (true)
    {
      boolean bool = this.q;
      if (a(i6))
      {
        this.g.b(i1);
        localae.a(this.g, i9);
        this.g.b(i2);
      }
      if ((this.e != 2) && (!bool) && (this.q) && (l1 != -1L))
        this.s = true;
      this.g.c(i1);
      return 0;
      i11 = 0;
      break;
      i9 = i5;
    }
  }

  public void a(long paramLong1, long paramLong2)
  {
    boolean bool;
    int i2;
    label30: com.google.android.exoplayer2.g.ad localad;
    if (this.e != 2)
    {
      bool = true;
      a.b(bool);
      int i1 = this.f.size();
      i2 = 0;
      if (i2 >= i1)
        break label122;
      localad = (com.google.android.exoplayer2.g.ad)this.f.get(i2);
      if (localad.c() != -9223372036854775807L)
        break label116;
    }
    label116: for (int i4 = 1; ; i4 = 0)
    {
      if ((i4 != 0) || ((localad.c() != 0L) && (localad.a() != paramLong2)))
      {
        localad.d();
        localad.a(paramLong2);
      }
      i2++;
      break label30;
      bool = false;
      break;
    }
    label122: if ((paramLong2 != 0L) && (this.n != null))
      this.n.a(paramLong2);
    this.g.a();
    this.h.clear();
    for (int i3 = 0; i3 < this.j.size(); i3++)
      ((ae)this.j.valueAt(i3)).a();
    this.u = 0;
  }

  public void a(i parami)
  {
    this.o = parami;
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    byte[] arrayOfByte = this.g.a;
    paramh.c(arrayOfByte, 0, 940);
    int i1 = 0;
    int i2;
    if (i1 < 188)
    {
      i2 = 0;
      label31: if (i2 >= 5)
        break label83;
      if (arrayOfByte[(i1 + i2 * 188)] == 71);
    }
    label83: for (int i3 = 0; ; i3 = 1)
    {
      if (i3 != 0)
      {
        paramh.b(i1);
        return true;
        i2++;
        break label31;
      }
      i1++;
      break;
      return false;
    }
  }

  public void c()
  {
  }

  private class a
    implements w
  {
    private final q b = new q(new byte[4]);

    public a()
    {
    }

    public void a(com.google.android.exoplayer2.g.ad paramad, i parami, ae.d paramd)
    {
    }

    public void a(r paramr)
    {
      if (paramr.h() != 0);
      do
      {
        return;
        paramr.d(7);
        int i = paramr.b() / 4;
        int j = 0;
        if (j < i)
        {
          paramr.a(this.b, 4);
          int k = this.b.c(16);
          this.b.b(3);
          if (k == 0)
            this.b.b(13);
          while (true)
          {
            j++;
            break;
            int m = this.b.c(13);
            ac.a(ac.this).put(m, new x(new ac.b(ac.this, m)));
            ac.b(ac.this);
          }
        }
      }
      while (ac.c(ac.this) == 2);
      ac.a(ac.this).remove(0);
    }
  }

  private class b
    implements w
  {
    private final q b = new q(new byte[5]);
    private final SparseArray<ae> c = new SparseArray();
    private final SparseIntArray d = new SparseIntArray();
    private final int e;

    public b(int arg2)
    {
      int i;
      this.e = i;
    }

    private ae.b a(r paramr, int paramInt)
    {
      int i = paramr.d();
      int j = i + paramInt;
      int k = -1;
      String str1 = null;
      ArrayList localArrayList = null;
      if (paramr.d() < j)
      {
        int m = paramr.h();
        int n = paramr.h() + paramr.d();
        long l;
        if (m == 5)
        {
          l = paramr.n();
          if (l == ac.b())
            k = 129;
        }
        while (true)
        {
          paramr.d(n - paramr.d());
          break;
          if (l == ac.d())
          {
            k = 135;
          }
          else if (l == ac.e())
          {
            k = 36;
            continue;
            if (m == 106)
            {
              k = 129;
            }
            else if (m == 122)
            {
              k = 135;
            }
            else if (m == 123)
            {
              k = 138;
            }
            else if (m == 10)
            {
              str1 = paramr.e(3).trim();
            }
            else if (m == 89)
            {
              k = 89;
              localArrayList = new ArrayList();
              while (paramr.d() < n)
              {
                String str2 = paramr.e(3).trim();
                int i1 = paramr.h();
                byte[] arrayOfByte = new byte[4];
                paramr.a(arrayOfByte, 0, 4);
                localArrayList.add(new ae.a(str2, i1, arrayOfByte));
              }
            }
          }
        }
      }
      paramr.c(j);
      return new ae.b(k, str1, localArrayList, Arrays.copyOfRange(paramr.a, i, j));
    }

    public void a(com.google.android.exoplayer2.g.ad paramad, i parami, ae.d paramd)
    {
    }

    public void a(r paramr)
    {
      if (paramr.h() != 2);
      label252: 
      do
      {
        return;
        com.google.android.exoplayer2.g.ad localad;
        int i;
        int j;
        int i3;
        int i4;
        ae.b localb1;
        int i6;
        if ((ac.c(ac.this) == 1) || (ac.c(ac.this) == 2) || (ac.d(ac.this) == 1))
        {
          localad = (com.google.android.exoplayer2.g.ad)ac.e(ac.this).get(0);
          paramr.d(2);
          i = paramr.i();
          paramr.d(3);
          paramr.a(this.b, 2);
          this.b.b(3);
          ac.a(ac.this, this.b.c(13));
          paramr.a(this.b, 2);
          this.b.b(4);
          paramr.d(this.b.c(12));
          if ((ac.c(ac.this) == 2) && (ac.f(ac.this) == null))
          {
            ae.b localb2 = new ae.b(21, null, null, ag.f);
            ac.a(ac.this, ac.g(ac.this).a(21, localb2));
            ac.f(ac.this).a(localad, ac.h(ac.this), new ae.d(i, 21, 8192));
          }
          this.c.clear();
          this.d.clear();
          j = paramr.b();
          if (j <= 0)
            break label540;
          paramr.a(this.b, 5);
          i3 = this.b.c(8);
          this.b.b(3);
          i4 = this.b.c(13);
          this.b.b(4);
          int i5 = this.b.c(12);
          localb1 = a(paramr, i5);
          if (i3 == 6)
            i3 = localb1.a;
          i6 = j - (i5 + 5);
          if (ac.c(ac.this) != 2)
            break label428;
        }
        for (int i7 = i3; ; i7 = i4)
        {
          if (!ac.i(ac.this).get(i7))
            break label435;
          j = i6;
          break label252;
          localad = new com.google.android.exoplayer2.g.ad(((com.google.android.exoplayer2.g.ad)ac.e(ac.this).get(0)).a());
          ac.e(ac.this).add(localad);
          break;
        }
        if ((ac.c(ac.this) == 2) && (i3 == 21));
        for (ae localae2 = ac.f(ac.this); ; localae2 = ac.g(ac.this).a(i3, localb1))
        {
          if ((ac.c(ac.this) != 2) || (i4 < this.d.get(i7, 8192)))
          {
            this.d.put(i7, i4);
            this.c.put(i7, localae2);
          }
          j = i6;
          break;
        }
        int k = this.d.size();
        for (int m = 0; m < k; m++)
        {
          int i1 = this.d.keyAt(m);
          int i2 = this.d.valueAt(m);
          ac.i(ac.this).put(i1, true);
          ac.j(ac.this).put(i2, true);
          ae localae1 = (ae)this.c.valueAt(m);
          if (localae1 != null)
          {
            if (localae1 != ac.f(ac.this))
              localae1.a(localad, ac.h(ac.this), new ae.d(i, i1, 8192));
            ac.a(ac.this).put(i2, localae1);
          }
        }
        if (ac.c(ac.this) != 2)
          break;
      }
      while (ac.k(ac.this));
      label428: label435: ac.h(ac.this).a();
      label540: ac.b(ac.this, 0);
      ac.a(ac.this, true);
      return;
      ac.a(ac.this).remove(this.e);
      ac localac = ac.this;
      if (ac.c(ac.this) == 1);
      for (int n = 0; ; n = -1 + ac.d(ac.this))
      {
        ac.b(localac, n);
        if (ac.d(ac.this) != 0)
          break;
        ac.h(ac.this).a();
        ac.a(ac.this, true);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.ac
 * JD-Core Version:    0.6.2
 */