package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.p.a;
import com.google.android.exoplayer2.g.p.b;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.g.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class l
  implements j
{
  private final y a;
  private final boolean b;
  private final boolean c;
  private final q d;
  private final q e;
  private final q f;
  private long g;
  private final boolean[] h;
  private String i;
  private com.google.android.exoplayer2.extractor.q j;
  private a k;
  private boolean l;
  private long m;
  private boolean n;
  private final r o;

  public l(y paramy, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramy;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.h = new boolean[3];
    this.d = new q(7, 128);
    this.e = new q(8, 128);
    this.f = new q(6, 128);
    this.o = new r();
  }

  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    if ((!this.l) || (this.k.a()))
    {
      this.d.b(paramInt2);
      this.e.b(paramInt2);
      if (this.l)
        break label353;
      if ((this.d.b()) && (this.e.b()))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Arrays.copyOf(this.d.a, this.d.b));
        localArrayList.add(Arrays.copyOf(this.e.a, this.e.b));
        p.b localb2 = p.a(this.d.a, 3, this.d.b);
        p.a locala2 = p.b(this.e.a, 3, this.e.b);
        this.j.a(Format.createVideoSampleFormat(this.i, "video/avc", c.b(localb2.a, localb2.b, localb2.c), -1, -1, localb2.e, localb2.f, -1.0F, localArrayList, -1, localb2.g, null));
        this.l = true;
        this.k.a(localb2);
        this.k.a(locala2);
        this.d.a();
        this.e.a();
      }
    }
    while (true)
    {
      if (this.f.b(paramInt2))
      {
        int i1 = p.a(this.f.a, this.f.b);
        this.o.a(this.f.a, i1);
        this.o.c(4);
        this.a.a(paramLong2, this.o);
      }
      if (this.k.a(paramLong1, paramInt1, this.l, this.n))
        this.n = false;
      return;
      label353: if (this.d.b())
      {
        p.b localb1 = p.a(this.d.a, 3, this.d.b);
        this.k.a(localb1);
        this.d.a();
      }
      else if (this.e.b())
      {
        p.a locala1 = p.b(this.e.a, 3, this.e.b);
        this.k.a(locala1);
        this.e.a();
      }
    }
  }

  private void a(long paramLong1, int paramInt, long paramLong2)
  {
    if ((!this.l) || (this.k.a()))
    {
      this.d.a(paramInt);
      this.e.a(paramInt);
    }
    this.f.a(paramInt);
    this.k.a(paramLong1, paramInt, paramLong2);
  }

  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!this.l) || (this.k.a()))
    {
      this.d.a(paramArrayOfByte, paramInt1, paramInt2);
      this.e.a(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.f.a(paramArrayOfByte, paramInt1, paramInt2);
    this.k.a(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void a()
  {
    p.a(this.h);
    this.d.a();
    this.e.a();
    this.f.a();
    this.k.b();
    this.g = 0L;
    this.n = false;
  }

  public void a(long paramLong, int paramInt)
  {
    this.m = paramLong;
    boolean bool1 = this.n;
    if ((paramInt & 0x2) != 0);
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.n = (bool2 | bool1);
      return;
    }
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.i = paramd.c();
    this.j = parami.a(paramd.b(), 2);
    this.k = new a(this.j, this.b, this.c);
    this.a.a(parami, paramd);
  }

  public void a(r paramr)
  {
    int i1 = paramr.d();
    int i2 = paramr.c();
    byte[] arrayOfByte = paramr.a;
    this.g += paramr.b();
    this.j.a(paramr, paramr.b());
    int i3 = p.a(arrayOfByte, i1, i2, this.h);
    if (i3 == i2)
    {
      a(arrayOfByte, i1, i2);
      return;
    }
    int i4 = p.b(arrayOfByte, i3);
    int i5 = i3 - i1;
    if (i5 > 0)
      a(arrayOfByte, i1, i3);
    int i6 = i2 - i3;
    long l1 = this.g - i6;
    if (i5 < 0);
    for (int i7 = -i5; ; i7 = 0)
    {
      a(l1, i6, i7, this.m);
      a(l1, i4, this.m);
      i1 = i3 + 3;
      break;
    }
  }

  public void b()
  {
  }

  private static final class a
  {
    private final com.google.android.exoplayer2.extractor.q a;
    private final boolean b;
    private final boolean c;
    private final SparseArray<p.b> d;
    private final SparseArray<p.a> e;
    private final s f;
    private byte[] g;
    private int h;
    private int i;
    private long j;
    private boolean k;
    private long l;
    private a m;
    private a n;
    private boolean o;
    private long p;
    private long q;
    private boolean r;

    public a(com.google.android.exoplayer2.extractor.q paramq, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramq;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = new SparseArray();
      this.e = new SparseArray();
      this.m = new a(null);
      this.n = new a(null);
      this.g = new byte[''];
      this.f = new s(this.g, 0, 0);
      b();
    }

    private void a(int paramInt)
    {
      if (this.r);
      for (int i1 = 1; ; i1 = 0)
      {
        int i2 = (int)(this.j - this.p);
        this.a.a(this.q, i1, i2, paramInt, null);
        return;
      }
    }

    public void a(long paramLong1, int paramInt, long paramLong2)
    {
      this.i = paramInt;
      this.l = paramLong2;
      this.j = paramLong1;
      if (((this.b) && (this.i == 1)) || ((this.c) && ((this.i == 5) || (this.i == 1) || (this.i == 2))))
      {
        a locala = this.m;
        this.m = this.n;
        this.n = locala;
        this.n.a();
        this.h = 0;
        this.k = true;
      }
    }

    public void a(p.a parama)
    {
      this.e.append(parama.a, parama);
    }

    public void a(p.b paramb)
    {
      this.d.append(paramb.d, paramb);
    }

    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!this.k);
      int i2;
      int i3;
      int i4;
      p.a locala;
      p.b localb;
      int i5;
      boolean bool2;
      boolean bool3;
      boolean bool4;
      boolean bool5;
      label396: int i6;
      int i8;
      int i10;
      int i11;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            int i1 = paramInt2 - paramInt1;
                            if (this.g.length < i1 + this.h)
                              this.g = Arrays.copyOf(this.g, 2 * (i1 + this.h));
                            System.arraycopy(paramArrayOfByte, paramInt1, this.g, this.h, i1);
                            this.h = (i1 + this.h);
                            this.f.a(this.g, 0, this.h);
                          }
                          while (!this.f.b(8));
                          this.f.a();
                          i2 = this.f.c(2);
                          this.f.a(5);
                        }
                        while (!this.f.c());
                        this.f.d();
                      }
                      while (!this.f.c());
                      i3 = this.f.d();
                      if (!this.c)
                      {
                        this.k = false;
                        this.n.a(i3);
                        return;
                      }
                    }
                    while (!this.f.c());
                    i4 = this.f.d();
                    if (this.e.indexOfKey(i4) < 0)
                    {
                      this.k = false;
                      return;
                    }
                    locala = (p.a)this.e.get(i4);
                    localb = (p.b)this.d.get(locala.b);
                    if (!localb.h)
                      break;
                  }
                  while (!this.f.b(2));
                  this.f.a(2);
                }
                while (!this.f.b(localb.j));
                i5 = this.f.c(localb.j);
                boolean bool1 = localb.i;
                bool2 = false;
                bool3 = false;
                bool4 = false;
                if (bool1)
                  break;
              }
              while (!this.f.b(1));
              bool2 = this.f.b();
              bool3 = false;
              bool4 = false;
              if (!bool2)
                break;
            }
            while (!this.f.b(1));
            bool4 = this.f.b();
            bool3 = true;
            if (this.i != 5)
              break label555;
            bool5 = true;
            i6 = 0;
            if (!bool5)
              break;
          }
          while (!this.f.c());
          i6 = this.f.d();
          if (localb.k != 0)
            break label561;
        }
        while (!this.f.b(localb.l));
        i8 = this.f.c(localb.l);
        boolean bool8 = locala.c;
        i9 = 0;
        i10 = 0;
        i11 = 0;
        if (!bool8)
          break;
        i9 = 0;
        i10 = 0;
        i11 = 0;
        if (bool2)
          break;
      }
      while (!this.f.c());
      int i9 = this.f.e();
      while (true)
      {
        this.n.a(localb, i2, i3, i5, i4, bool2, bool3, bool4, bool5, i6, i8, i9, i10, i11);
        this.k = false;
        return;
        label555: bool5 = false;
        break label396;
        label561: int i7 = localb.k;
        i8 = 0;
        i9 = 0;
        i10 = 0;
        i11 = 0;
        if (i7 == 1)
        {
          boolean bool6 = localb.m;
          i8 = 0;
          i9 = 0;
          i10 = 0;
          i11 = 0;
          if (!bool6)
          {
            if (!this.f.c())
              break;
            i10 = this.f.e();
            boolean bool7 = locala.c;
            i8 = 0;
            i9 = 0;
            i11 = 0;
            if (bool7)
            {
              i8 = 0;
              i9 = 0;
              i11 = 0;
              if (!bool2)
              {
                if (!this.f.c())
                  break;
                i11 = this.f.e();
                i8 = 0;
                i9 = 0;
              }
            }
          }
        }
      }
    }

    public boolean a()
    {
      return this.c;
    }

    public boolean a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.i == 9) || ((this.c) && (a.a(this.n, this.m))))
      {
        if ((paramBoolean1) && (this.o))
          a(paramInt + (int)(paramLong - this.j));
        this.p = this.j;
        this.q = this.l;
        this.r = false;
        this.o = true;
      }
      if (this.b)
        paramBoolean2 = this.n.b();
      boolean bool1 = this.r;
      boolean bool2;
      if (this.i != 5)
      {
        bool2 = false;
        if (paramBoolean2)
        {
          int i1 = this.i;
          bool2 = false;
          if (i1 != 1);
        }
      }
      else
      {
        bool2 = true;
      }
      this.r = (bool2 | bool1);
      return this.r;
    }

    public void b()
    {
      this.k = false;
      this.o = false;
      this.n.a();
    }

    private static final class a
    {
      private boolean a;
      private boolean b;
      private p.b c;
      private int d;
      private int e;
      private int f;
      private int g;
      private boolean h;
      private boolean i;
      private boolean j;
      private boolean k;
      private int l;
      private int m;
      private int n;
      private int o;
      private int p;

      private boolean a(a parama)
      {
        return (this.a) && ((!parama.a) || (this.f != parama.f) || (this.g != parama.g) || (this.h != parama.h) || ((this.i) && (parama.i) && (this.j != parama.j)) || ((this.d != parama.d) && ((this.d == 0) || (parama.d == 0))) || ((this.c.k == 0) && (parama.c.k == 0) && ((this.m != parama.m) || (this.n != parama.n))) || ((this.c.k == 1) && (parama.c.k == 1) && ((this.o != parama.o) || (this.p != parama.p))) || (this.k != parama.k) || ((this.k) && (parama.k) && (this.l != parama.l)));
      }

      public void a()
      {
        this.b = false;
        this.a = false;
      }

      public void a(int paramInt)
      {
        this.e = paramInt;
        this.b = true;
      }

      public void a(p.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
      {
        this.c = paramb;
        this.d = paramInt1;
        this.e = paramInt2;
        this.f = paramInt3;
        this.g = paramInt4;
        this.h = paramBoolean1;
        this.i = paramBoolean2;
        this.j = paramBoolean3;
        this.k = paramBoolean4;
        this.l = paramInt5;
        this.m = paramInt6;
        this.n = paramInt7;
        this.o = paramInt8;
        this.p = paramInt9;
        this.a = true;
        this.b = true;
      }

      public boolean b()
      {
        return (this.b) && ((this.e == 7) || (this.e == 2));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.l
 * JD-Core Version:    0.6.2
 */