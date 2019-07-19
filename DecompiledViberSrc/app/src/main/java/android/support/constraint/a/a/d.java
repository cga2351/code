package android.support.constraint.a.a;

import android.support.constraint.a.b;
import android.support.constraint.a.f;
import java.util.ArrayList;

public class d
{
  public static float N = 0.5F;
  protected a[] A;
  d B;
  int C;
  int D;
  protected float E;
  protected int F;
  protected int G;
  protected int H;
  protected int I;
  protected int J;
  int K;
  protected int L;
  protected int M;
  float O;
  float P;
  boolean Q;
  boolean R;
  int S;
  int T;
  boolean U;
  boolean V;
  float[] W;
  protected d[] X;
  protected d[] Y;
  d Z;
  public int a = -1;
  d aa;
  private int[] ab = { 2147483647, 2147483647 };
  private float ac = 0.0F;
  private int ad;
  private int ae;
  private int af;
  private int ag;
  private int ah;
  private int ai;
  private Object aj;
  private int ak;
  private int al;
  private String am;
  private String an;
  public int b = -1;
  k c;
  k d;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  float i = 1.0F;
  int j = 0;
  int k = 0;
  float l = 1.0F;
  boolean m;
  boolean n;
  int o = -1;
  float p = 1.0F;
  c q = new c(this, c.c.b);
  c r = new c(this, c.c.c);
  c s = new c(this, c.c.d);
  c t = new c(this, c.c.e);
  c u = new c(this, c.c.f);
  c v = new c(this, c.c.h);
  c w = new c(this, c.c.i);
  c x = new c(this, c.c.g);
  protected c[] y;
  protected ArrayList<c> z;

  public d()
  {
    c[] arrayOfc = new c[6];
    arrayOfc[0] = this.q;
    arrayOfc[1] = this.s;
    arrayOfc[2] = this.r;
    arrayOfc[3] = this.t;
    arrayOfc[4] = this.u;
    arrayOfc[5] = this.x;
    this.y = arrayOfc;
    this.z = new ArrayList();
    a[] arrayOfa = new a[2];
    arrayOfa[0] = a.a;
    arrayOfa[1] = a.a;
    this.A = arrayOfa;
    this.B = null;
    this.C = 0;
    this.D = 0;
    this.E = 0.0F;
    this.F = -1;
    this.G = 0;
    this.H = 0;
    this.ad = 0;
    this.ae = 0;
    this.af = 0;
    this.ag = 0;
    this.I = 0;
    this.J = 0;
    this.K = 0;
    this.O = N;
    this.P = N;
    this.ak = 0;
    this.al = 0;
    this.am = null;
    this.an = null;
    this.S = 0;
    this.T = 0;
    this.W = new float[] { 0.0F, 0.0F };
    this.X = new d[] { null, null };
    this.Y = new d[] { null, null };
    this.Z = null;
    this.aa = null;
    K();
  }

  private void K()
  {
    this.z.add(this.q);
    this.z.add(this.r);
    this.z.add(this.s);
    this.z.add(this.t);
    this.z.add(this.v);
    this.z.add(this.w);
    this.z.add(this.x);
    this.z.add(this.u);
  }

  private void a(android.support.constraint.a.e parame, boolean paramBoolean1, android.support.constraint.a.h paramh1, android.support.constraint.a.h paramh2, a parama, boolean paramBoolean2, c paramc1, c paramc2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, float paramFloat2, boolean paramBoolean5)
  {
    android.support.constraint.a.h localh1 = parame.a(paramc1);
    android.support.constraint.a.h localh2 = parame.a(paramc2);
    android.support.constraint.a.h localh3 = parame.a(paramc1.g());
    android.support.constraint.a.h localh4 = parame.a(paramc2.g());
    if ((parame.c) && (paramc1.a().i == 1) && (paramc2.a().i == 1))
    {
      if (android.support.constraint.a.e.a() != null)
      {
        f localf2 = android.support.constraint.a.e.a();
        localf2.s = (1L + localf2.s);
      }
      paramc1.a().a(parame);
      paramc2.a().a(parame);
      if ((!paramBoolean4) && (paramBoolean1))
        parame.a(paramh2, localh2, 0, 6);
      return;
    }
    if (android.support.constraint.a.e.a() != null)
    {
      f localf1 = android.support.constraint.a.e.a();
      localf1.B = (1L + localf1.B);
    }
    boolean bool1 = paramc1.j();
    boolean bool2 = paramc2.j();
    boolean bool3 = this.x.j();
    int i1 = 0;
    if (bool1)
      i1 = 1;
    if (bool2)
      i1++;
    if (bool3);
    for (int i2 = i1 + 1; ; i2 = i1)
    {
      if (paramBoolean3)
        paramInt5 = 3;
      int i3 = 1.b[parama.ordinal()];
      int i4 = 0;
      label260: int i5;
      switch (i3)
      {
      default:
        if (this.al == 8)
        {
          i5 = 0;
          i4 = 0;
        }
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        if (paramBoolean5)
        {
          if ((!bool1) && (!bool2) && (!bool3))
            parame.a(localh1, paramInt1);
        }
        else
        {
          label303: if (i4 != 0)
            break label471;
          if (!paramBoolean2)
            break label455;
          parame.c(localh2, localh1, 0, 3);
          if (paramInt3 > 0)
            parame.a(localh2, localh1, paramInt3, 6);
          if (paramInt4 < 2147483647)
            parame.b(localh2, localh1, paramInt4, 6);
        }
        while (true)
        {
          if ((paramBoolean5) && (!paramBoolean4))
            break label820;
          if ((i2 >= 2) || (!paramBoolean1))
            break;
          parame.a(localh1, paramh1, 0, 6);
          parame.a(paramh2, localh2, 0, 6);
          return;
          i4 = 0;
          break label260;
          i4 = 0;
          break label260;
          i4 = 0;
          break label260;
          i4 = 1;
          break label260;
          if ((!bool1) || (bool2))
            break label303;
          parame.c(localh1, localh3, paramc1.e(), 6);
          break label303;
          label455: parame.c(localh2, localh1, i5, 6);
        }
        label471: if (paramInt6 == -2)
          paramInt6 = i5;
        if (paramInt7 == -2)
          paramInt7 = i5;
        if (paramInt6 > 0)
        {
          if (paramBoolean1)
          {
            parame.a(localh2, localh1, paramInt6, 6);
            label514: i5 = Math.max(i5, paramInt6);
          }
        }
        else
        {
          if (paramInt7 <= 0)
            break label1271;
          if (!paramBoolean1)
            break label648;
          parame.b(localh2, localh1, paramInt7, 1);
        }
        label543: label575: label849: label1135: label1265: label1271: for (int i6 = Math.min(i5, paramInt7); ; i6 = i5)
        {
          if (paramInt5 == 1)
            if (paramBoolean1)
              parame.c(localh2, localh1, i6, 6);
          android.support.constraint.a.h localh5;
          while (true)
            if ((i4 != 0) && (i2 != 2) && (!paramBoolean3))
            {
              int i7 = Math.max(paramInt6, i6);
              if (paramInt7 > 0)
                i7 = Math.min(paramInt7, i7);
              parame.c(localh2, localh1, i7, 6);
              i4 = 0;
              break;
              parame.a(localh2, localh1, paramInt6, 6);
              break label514;
              parame.b(localh2, localh1, paramInt7, 6);
              break label543;
              if (paramBoolean4)
              {
                parame.c(localh2, localh1, i6, 4);
              }
              else
              {
                parame.c(localh2, localh1, i6, 1);
                continue;
                if (paramInt5 == 2)
                {
                  if ((paramc1.d() != c.c.c) && (paramc1.d() != c.c.e))
                    break label785;
                  localh5 = parame.a(this.B.a(c.c.c));
                }
              }
            }
          for (android.support.constraint.a.h localh6 = parame.a(this.B.a(c.c.e)); ; localh6 = parame.a(this.B.a(c.c.d)))
          {
            parame.a(parame.c().a(localh2, localh1, localh6, localh5, paramFloat2));
            i4 = 0;
            break label575;
            break;
            localh5 = parame.a(this.B.a(c.c.b));
          }
          if ((!bool1) && (!bool2) && (!bool3))
            if (paramBoolean1)
              parame.a(paramh2, localh2, 0, 5);
          int i8;
          int i13;
          while (paramBoolean1)
          {
            parame.a(paramh2, localh2, 0, 6);
            return;
            if ((bool1) && (!bool2))
            {
              if (paramBoolean1)
                parame.a(paramh2, localh2, 0, 5);
            }
            else if ((!bool1) && (bool2))
            {
              parame.c(localh2, localh4, -paramc2.e(), 6);
              if (paramBoolean1)
                parame.a(localh1, paramh1, 0, 5);
            }
            else if ((bool1) && (bool2))
            {
              i8 = 5;
              if (i4 == 0)
                break label1214;
              if ((paramBoolean1) && (paramInt3 == 0))
                parame.a(localh2, localh1, 0, 6);
              if (paramInt5 != 0)
                break label1135;
              int i12 = 6;
              if (paramInt7 <= 0)
              {
                i13 = 0;
                if (paramInt6 <= 0);
              }
              else
              {
                i12 = 4;
                i13 = 1;
              }
              parame.c(localh1, localh3, paramc1.e(), i12);
              parame.c(localh2, localh4, -paramc2.e(), i12);
              if ((paramInt7 <= 0) && (paramInt6 <= 0))
                break label1265;
            }
          }
          for (int i9 = 1; ; i9 = 0)
          {
            int i10 = i13;
            while (true)
            {
              if (i9 != 0)
                parame.a(localh1, localh3, paramc1.e(), paramFloat1, localh4, localh2, paramc2.e(), i8);
              if (i10 != 0)
              {
                parame.a(localh1, localh3, paramc1.e(), 6);
                parame.b(localh2, localh4, -paramc2.e(), 6);
              }
              if (!paramBoolean1)
                break label849;
              parame.a(localh1, paramh1, 0, 6);
              break label849;
              break;
              if (paramInt5 == 1)
              {
                i9 = 1;
                i8 = 6;
                i10 = 1;
              }
              else if (paramInt5 == 3)
              {
                int i11 = 4;
                if (!paramBoolean3)
                  i11 = 6;
                parame.c(localh1, localh3, paramc1.e(), i11);
                parame.c(localh2, localh4, -paramc2.e(), i11);
                i9 = 1;
                i10 = 1;
                continue;
                i9 = 1;
                if (paramBoolean1)
                {
                  parame.a(localh1, localh3, paramc1.e(), 5);
                  parame.b(localh2, localh4, -paramc2.e(), 5);
                }
                i10 = 0;
              }
              else
              {
                i9 = 0;
                i10 = 0;
              }
            }
          }
        }
        label648: label785: label820: label1214: i5 = paramInt2;
      }
    }
  }

  public float A()
  {
    return this.O;
  }

  public boolean B()
  {
    return this.K > 0;
  }

  public int C()
  {
    return this.K;
  }

  public Object D()
  {
    return this.aj;
  }

  public ArrayList<c> E()
  {
    return this.z;
  }

  public void F()
  {
    int i1 = this.G;
    int i2 = this.H;
    int i3 = this.G + this.C;
    int i4 = this.H + this.D;
    this.ad = i1;
    this.ae = i2;
    this.af = (i3 - i1);
    this.ag = (i4 - i2);
  }

  public void G()
  {
    H();
    b(N);
    a(N);
    if ((this instanceof e));
    label83: label104: 
    do
      while (true)
      {
        return;
        if (I() == a.c)
        {
          if (o() != p())
            break label83;
          a(a.b);
        }
        while (J() == a.c)
        {
          if (q() != r())
            break label104;
          b(a.b);
          return;
          if (o() > w())
            a(a.a);
        }
      }
    while (q() <= x());
    b(a.a);
  }

  public void H()
  {
    d locald = j();
    if ((locald != null) && ((locald instanceof e)) && (((e)j()).T()));
    while (true)
    {
      return;
      int i1 = this.z.size();
      for (int i2 = 0; i2 < i1; i2++)
        ((c)this.z.get(i2)).i();
    }
  }

  public a I()
  {
    return this.A[0];
  }

  public a J()
  {
    return this.A[1];
  }

  public c a(c.c paramc)
  {
    switch (1.a[paramc.ordinal()])
    {
    default:
      throw new AssertionError(paramc.name());
    case 1:
      return this.q;
    case 2:
      return this.r;
    case 3:
      return this.s;
    case 4:
      return this.t;
    case 5:
      return this.u;
    case 7:
      return this.v;
    case 8:
      return this.w;
    case 6:
      return this.x;
    case 9:
    }
    return null;
  }

  public void a(float paramFloat)
  {
    this.O = paramFloat;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.G = paramInt1;
    this.H = paramInt2;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.e = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramFloat;
    if ((paramFloat < 1.0F) && (this.e == 0))
      this.e = 2;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    this.G = paramInt1;
    this.H = paramInt2;
    if (this.al == 8)
    {
      this.C = 0;
      this.D = 0;
    }
    do
    {
      return;
      if ((this.A[0] == a.a) && (i1 < this.C))
        i1 = this.C;
      if ((this.A[1] == a.a) && (i2 < this.D))
        i2 = this.D;
      this.C = i1;
      this.D = i2;
      if (this.D < this.M)
        this.D = this.M;
    }
    while (this.C >= this.L);
    this.C = this.L;
  }

  public void a(c.c paramc1, d paramd, c.c paramc2)
  {
    a(paramc1, paramd, paramc2, 0, c.b.b);
  }

  public void a(c.c paramc1, d paramd, c.c paramc2, int paramInt)
  {
    a(paramc1, paramd, paramc2, paramInt, c.b.b);
  }

  public void a(c.c paramc1, d paramd, c.c paramc2, int paramInt1, int paramInt2)
  {
    a(paramc1).a(paramd.a(paramc2), paramInt1, paramInt2, c.b.b, 0, true);
  }

  public void a(c.c paramc1, d paramd, c.c paramc2, int paramInt, c.b paramb)
  {
    a(paramc1, paramd, paramc2, paramInt, paramb, 0);
  }

  public void a(c.c paramc1, d paramd, c.c paramc2, int paramInt1, c.b paramb, int paramInt2)
  {
    c localc18;
    c localc19;
    int i1;
    if (paramc1 == c.c.g)
      if (paramc2 == c.c.g)
      {
        c localc16 = a(c.c.b);
        c localc17 = a(c.c.d);
        localc18 = a(c.c.c);
        localc19 = a(c.c.e);
        if ((localc16 != null) && (localc16.j()))
          break label989;
        if ((localc17 != null) && (localc17.j()))
          i1 = 0;
      }
    while (true)
    {
      int i2;
      if ((localc18 == null) || (!localc18.j()))
        if ((localc19 != null) && (localc19.j()))
          i2 = 0;
      while (true)
      {
        label108: if ((i1 != 0) && (i2 != 0))
          a(c.c.g).a(paramd.a(c.c.g), 0, paramInt2);
        c localc1;
        c localc2;
        do
        {
          do
          {
            do
            {
              return;
              a(c.c.b, paramd, c.c.b, 0, paramb, paramInt2);
              a(c.c.d, paramd, c.c.d, 0, paramb, paramInt2);
              i1 = 1;
              break;
              a(c.c.c, paramd, c.c.c, 0, paramb, paramInt2);
              a(c.c.e, paramd, c.c.e, 0, paramb, paramInt2);
              i2 = 1;
              break label108;
              if (i1 != 0)
              {
                a(c.c.h).a(paramd.a(c.c.h), 0, paramInt2);
                return;
              }
            }
            while (i2 == 0);
            a(c.c.i).a(paramd.a(c.c.i), 0, paramInt2);
            return;
            if ((paramc2 == c.c.b) || (paramc2 == c.c.d))
            {
              a(c.c.b, paramd, paramc2, 0, paramb, paramInt2);
              a(c.c.d, paramd, paramc2, 0, paramb, paramInt2);
              a(c.c.g).a(paramd.a(paramc2), 0, paramInt2);
              return;
            }
          }
          while ((paramc2 != c.c.c) && (paramc2 != c.c.e));
          a(c.c.c, paramd, paramc2, 0, paramb, paramInt2);
          a(c.c.e, paramd, paramc2, 0, paramb, paramInt2);
          a(c.c.g).a(paramd.a(paramc2), 0, paramInt2);
          return;
          if ((paramc1 == c.c.h) && ((paramc2 == c.c.b) || (paramc2 == c.c.d)))
          {
            c localc13 = a(c.c.b);
            c localc14 = paramd.a(paramc2);
            c localc15 = a(c.c.d);
            localc13.a(localc14, 0, paramInt2);
            localc15.a(localc14, 0, paramInt2);
            a(c.c.h).a(localc14, 0, paramInt2);
            return;
          }
          if ((paramc1 == c.c.i) && ((paramc2 == c.c.c) || (paramc2 == c.c.e)))
          {
            c localc12 = paramd.a(paramc2);
            a(c.c.c).a(localc12, 0, paramInt2);
            a(c.c.e).a(localc12, 0, paramInt2);
            a(c.c.i).a(localc12, 0, paramInt2);
            return;
          }
          if ((paramc1 == c.c.h) && (paramc2 == c.c.h))
          {
            a(c.c.b).a(paramd.a(c.c.b), 0, paramInt2);
            a(c.c.d).a(paramd.a(c.c.d), 0, paramInt2);
            a(c.c.h).a(paramd.a(paramc2), 0, paramInt2);
            return;
          }
          if ((paramc1 == c.c.i) && (paramc2 == c.c.i))
          {
            a(c.c.c).a(paramd.a(c.c.c), 0, paramInt2);
            a(c.c.e).a(paramd.a(c.c.e), 0, paramInt2);
            a(c.c.i).a(paramd.a(paramc2), 0, paramInt2);
            return;
          }
          localc1 = a(paramc1);
          localc2 = paramd.a(paramc2);
        }
        while (!localc1.a(localc2));
        if (paramc1 == c.c.f)
        {
          c localc10 = a(c.c.c);
          c localc11 = a(c.c.e);
          if (localc10 != null)
            localc10.i();
          if (localc11 != null)
            localc11.i();
          paramInt1 = 0;
        }
        while (true)
        {
          localc1.a(localc2, paramInt1, paramb, paramInt2);
          localc2.c().b(localc1.c());
          return;
          if ((paramc1 == c.c.c) || (paramc1 == c.c.e))
          {
            c localc3 = a(c.c.f);
            if (localc3 != null)
              localc3.i();
            c localc4 = a(c.c.g);
            if (localc4.g() != localc2)
              localc4.i();
            c localc5 = a(paramc1).k();
            c localc6 = a(c.c.i);
            if (localc6.j())
            {
              localc5.i();
              localc6.i();
            }
          }
          else if ((paramc1 == c.c.b) || (paramc1 == c.c.d))
          {
            c localc7 = a(c.c.g);
            if (localc7.g() != localc2)
              localc7.i();
            c localc8 = a(paramc1).k();
            c localc9 = a(c.c.h);
            if (localc9.j())
            {
              localc8.i();
              localc9.i();
            }
          }
        }
        i2 = 0;
      }
      label989: i1 = 0;
    }
  }

  public void a(c paramc)
  {
    if ((j() != null) && ((j() instanceof e)) && (((e)j()).T()))
      return;
    c localc1 = a(c.c.b);
    c localc2 = a(c.c.d);
    c localc3 = a(c.c.c);
    c localc4 = a(c.c.e);
    c localc5 = a(c.c.g);
    c localc6 = a(c.c.h);
    c localc7 = a(c.c.i);
    if (paramc == localc5)
    {
      if ((localc1.j()) && (localc2.j()) && (localc1.g() == localc2.g()))
      {
        localc1.i();
        localc2.i();
      }
      if ((localc3.j()) && (localc4.j()) && (localc3.g() == localc4.g()))
      {
        localc3.i();
        localc4.i();
      }
      this.O = 0.5F;
      this.P = 0.5F;
    }
    while (true)
    {
      paramc.i();
      return;
      if (paramc == localc6)
      {
        if ((localc1.j()) && (localc2.j()) && (localc1.g().c() == localc2.g().c()))
        {
          localc1.i();
          localc2.i();
        }
        this.O = 0.5F;
      }
      else if (paramc == localc7)
      {
        if ((localc3.j()) && (localc4.j()) && (localc3.g().c() == localc4.g().c()))
        {
          localc3.i();
          localc4.i();
        }
        this.P = 0.5F;
      }
      else if ((paramc == localc1) || (paramc == localc2))
      {
        if ((localc1.j()) && (localc1.g() == localc2.g()))
          localc5.i();
      }
      else if (((paramc == localc3) || (paramc == localc4)) && (localc3.j()) && (localc3.g() == localc4.g()))
      {
        localc5.i();
      }
    }
  }

  public void a(a parama)
  {
    this.A[0] = parama;
    if (parama == a.b)
      h(this.ah);
  }

  public void a(d paramd)
  {
    this.B = paramd;
  }

  public void a(d paramd, float paramFloat, int paramInt)
  {
    a(c.c.g, paramd, c.c.g, paramInt, 0);
    this.ac = paramFloat;
  }

  public void a(android.support.constraint.a.c paramc)
  {
    this.q.a(paramc);
    this.r.a(paramc);
    this.s.a(paramc);
    this.t.a(paramc);
    this.u.a(paramc);
    this.x.a(paramc);
    this.v.a(paramc);
    this.w.a(paramc);
  }

  public void a(android.support.constraint.a.e parame)
  {
    android.support.constraint.a.h localh1 = parame.a(this.q);
    android.support.constraint.a.h localh2 = parame.a(this.s);
    android.support.constraint.a.h localh3 = parame.a(this.r);
    android.support.constraint.a.h localh4 = parame.a(this.t);
    android.support.constraint.a.h localh5 = parame.a(this.u);
    boolean bool13;
    boolean bool14;
    label105: boolean bool16;
    label261: boolean bool3;
    boolean bool4;
    boolean bool2;
    boolean bool1;
    if (this.B != null)
      if (this.B != null)
        if (this.B.A[0] == a.b)
        {
          bool13 = true;
          if (this.B == null)
            break label765;
          if (this.B.A[1] != a.b)
            break label759;
          bool14 = true;
          boolean bool15;
          if ((this.q.c == null) || (this.q.c.c != this.q))
          {
            c localc3 = this.s.c;
            bool15 = false;
            if (localc3 != null)
            {
              c localc4 = this.s.c.c;
              c localc5 = this.s;
              bool15 = false;
              if (localc4 != localc5);
            }
          }
          else
          {
            ((e)this.B).a(this, 0);
            bool15 = true;
          }
          if (((this.r.c == null) || (this.r.c.c != this.r)) && ((this.t.c == null) || (this.t.c.c != this.t)))
            break label1331;
          ((e)this.B).a(this, 1);
          bool16 = true;
          if ((bool13) && (this.al != 8) && (this.q.c == null) && (this.s.c == null))
            parame.a(parame.a(this.B.s), localh2, 0, 1);
          if ((bool14) && (this.al != 8) && (this.r.c == null) && (this.t.c == null) && (this.u == null))
            parame.a(parame.a(this.B.t), localh4, 0, 1);
          bool3 = bool14;
          bool4 = bool16;
          bool2 = bool15;
          bool1 = bool13;
        }
    while (true)
    {
      int i1 = this.C;
      if (i1 < this.L)
        i1 = this.L;
      int i2 = this.D;
      if (i2 < this.M)
        i2 = this.M;
      boolean bool5;
      label446: boolean bool6;
      label461: int i3;
      int i4;
      int i5;
      int i6;
      if (this.A[0] != a.c)
      {
        bool5 = true;
        if (this.A[1] == a.c)
          break label777;
        bool6 = true;
        this.o = this.F;
        this.p = this.E;
        boolean bool7 = this.E < 0.0F;
        i3 = 0;
        if (!bool7)
          break label1316;
        int i13 = this.al;
        i3 = 0;
        if (i13 == 8)
          break label1316;
        i3 = 1;
        if ((this.A[0] != a.c) || (this.A[1] != a.c))
          break label783;
        a(bool1, bool3, bool5, bool6);
        i4 = i3;
        i5 = i2;
        i6 = i1;
      }
      while (true)
      {
        label560: boolean bool8;
        label583: boolean bool9;
        label605: boolean bool10;
        android.support.constraint.a.h localh8;
        label649: android.support.constraint.a.h localh9;
        if ((i4 != 0) && ((this.o == 0) || (this.o == -1)))
        {
          bool8 = true;
          if ((this.A[0] != a.b) || (!(this instanceof e)))
            break label897;
          bool9 = true;
          bool10 = true;
          if (this.x.j())
            bool10 = false;
          if (this.a != 2)
          {
            if (this.B == null)
              break label903;
            localh8 = parame.a(this.B.s);
            if (this.B == null)
              break label909;
            localh9 = parame.a(this.B.q);
            label669: a(parame, bool1, localh9, localh8, this.A[0], bool9, this.q, this.s, this.G, i6, this.L, this.ab[0], this.O, bool8, bool2, this.e, this.g, this.h, this.i, bool10);
          }
          if (this.b != 2)
            break label915;
        }
        label777: label783: label915: label1314: 
        while (true)
        {
          return;
          bool13 = false;
          break;
          bool13 = false;
          break;
          label759: bool14 = false;
          break label105;
          label765: bool14 = false;
          break label105;
          bool5 = false;
          break label446;
          bool6 = false;
          break label461;
          if (this.A[0] == a.c)
          {
            this.o = 0;
            int i15 = (int)(this.p * this.D);
            i4 = i3;
            i5 = i2;
            i6 = i15;
            break label560;
          }
          if (this.A[1] != a.c)
            break label1316;
          this.o = 1;
          if (this.F == -1)
            this.p = (1.0F / this.p);
          int i14 = (int)(this.p * this.C);
          i4 = i3;
          i5 = i14;
          i6 = i1;
          break label560;
          bool8 = false;
          break label583;
          bool9 = false;
          break label605;
          localh8 = null;
          break label649;
          localh9 = null;
          break label669;
          boolean bool11;
          boolean bool12;
          label961: label993: android.support.constraint.a.h localh6;
          label1013: android.support.constraint.a.h localh7;
          if ((this.A[1] == a.b) && ((this instanceof e)))
          {
            bool11 = true;
            if ((i4 == 0) || ((this.o != 1) && (this.o != -1)))
              break label1227;
            bool12 = true;
            if (this.K > 0)
            {
              if (this.u.a().i != 1)
                break label1233;
              this.u.a().a(parame);
            }
            if (this.B == null)
              break label1285;
            localh6 = parame.a(this.B.t);
            if (this.B == null)
              break label1291;
            localh7 = parame.a(this.B.r);
            a locala = this.A[1];
            c localc1 = this.r;
            c localc2 = this.t;
            int i7 = this.H;
            int i8 = this.M;
            int i9 = this.ab[1];
            float f1 = this.P;
            int i10 = this.f;
            int i11 = this.j;
            int i12 = this.k;
            float f2 = this.l;
            a(parame, bool3, localh7, localh6, locala, bool11, localc1, localc2, i7, i5, i8, i9, f1, bool12, bool4, i10, i11, i12, f2, bool10);
            if (i4 != 0)
            {
              if (this.o != 1)
                break label1297;
              parame.a(localh4, localh3, localh2, localh1, this.p, 6);
            }
          }
          while (true)
          {
            if (!this.x.j())
              break label1314;
            parame.a(this, this.x.g().c(), (float)Math.toRadians(90.0F + this.ac), this.x.e());
            return;
            bool11 = false;
            break;
            label1227: bool12 = false;
            break label961;
            label1233: parame.c(localh5, localh3, C(), 6);
            if (this.u.c == null)
              break label993;
            parame.c(localh5, parame.a(this.u.c), 0, 6);
            bool10 = false;
            break label993;
            localh6 = null;
            break label1013;
            localh7 = null;
            break label1033;
            parame.a(localh2, localh1, localh4, localh3, this.p, 6);
          }
        }
        label897: label903: label909: label1297: label1316: i4 = i3;
        label1033: label1291: i5 = i2;
        label1285: i6 = i1;
      }
      label1331: bool16 = false;
      break label261;
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }

  public void a(Object paramObject)
  {
    this.aj = paramObject;
  }

  public void a(String paramString)
  {
    this.am = paramString;
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this.e == 0)
      this.e = 3;
    if (this.f == 0)
      this.f = 3;
    if (this.o == -1)
    {
      if ((paramBoolean3) && (!paramBoolean4))
        this.o = 0;
    }
    else
    {
      if ((this.o != 0) || ((this.r.j()) && (this.t.j())))
        break label235;
      this.o = 1;
      label78: if ((this.o == -1) && ((!this.r.j()) || (!this.t.j()) || (!this.q.j()) || (!this.s.j())))
      {
        if ((!this.r.j()) || (!this.t.j()))
          break label271;
        this.o = 0;
      }
      label151: if (this.o == -1)
        if ((!paramBoolean1) || (paramBoolean2))
          break label309;
    }
    for (this.o = 0; ; this.o = 1)
    {
      label235: 
      do
      {
        if (this.o == -1)
        {
          if ((this.g <= 0) || (this.j != 0))
            break label335;
          this.o = 0;
        }
        return;
        if ((paramBoolean3) || (!paramBoolean4))
          break;
        this.o = 1;
        if (this.F != -1)
          break;
        this.p = (1.0F / this.p);
        break;
        if ((this.o != 1) || ((this.q.j()) && (this.s.j())))
          break label78;
        this.o = 0;
        break label78;
        if ((!this.q.j()) || (!this.s.j()))
          break label151;
        this.p = (1.0F / this.p);
        this.o = 1;
        break label151;
      }
      while ((paramBoolean1) || (!paramBoolean2));
      label271: label309: this.p = (1.0F / this.p);
    }
    label335: if ((this.g == 0) && (this.j > 0))
    {
      this.p = (1.0F / this.p);
      this.o = 1;
      return;
    }
    this.p = (1.0F / this.p);
    this.o = 1;
  }

  public boolean a()
  {
    return this.al != 8;
  }

  public void b()
  {
    for (int i1 = 0; i1 < 6; i1++)
      this.y[i1].a().b();
  }

  public void b(float paramFloat)
  {
    this.P = paramFloat;
  }

  public void b(int paramInt)
  {
    h.a(paramInt, this);
  }

  public void b(int paramInt1, int paramInt2)
  {
    this.I = paramInt1;
    this.J = paramInt2;
  }

  public void b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.f = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramFloat;
    if ((paramFloat < 1.0F) && (this.f == 0))
      this.f = 2;
  }

  public void b(a parama)
  {
    this.A[1] = parama;
    if (parama == a.b)
      i(this.ai);
  }

  public void b(d paramd)
  {
  }

  public void b(android.support.constraint.a.e parame)
  {
    a(parame.b(this.q), parame.b(this.r), parame.b(this.s), parame.b(this.t));
  }

  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      this.E = 0.0F;
      return;
    }
    int i1 = -1;
    int i2 = paramString.length();
    int i3 = paramString.indexOf(',');
    int i4 = 0;
    String str4;
    int i7;
    if (i3 > 0)
    {
      int i6 = i2 - 1;
      i4 = 0;
      if (i3 < i6)
      {
        str4 = paramString.substring(0, i3);
        boolean bool = str4.equalsIgnoreCase("W");
        i7 = 0;
        if (!bool)
          break label218;
      }
    }
    while (true)
    {
      label82: int i8 = i3 + 1;
      i1 = i7;
      i4 = i8;
      int i5 = paramString.indexOf(':');
      String str2;
      String str3;
      if ((i5 >= 0) && (i5 < i2 - 1))
      {
        str2 = paramString.substring(i4, i5);
        str3 = paramString.substring(i5 + 1);
        if ((str2.length() <= 0) || (str3.length() <= 0))
          break label302;
      }
      while (true)
      {
        float f1;
        try
        {
          float f3 = Float.parseFloat(str2);
          float f4 = Float.parseFloat(str3);
          if ((f3 <= 0.0F) || (f4 <= 0.0F))
            break label302;
          if (i1 == 1)
          {
            float f5 = Math.abs(f4 / f3);
            f1 = f5;
            if (f1 <= 0.0F)
              break;
            this.E = f1;
            this.F = i1;
            return;
            label218: if (!str4.equalsIgnoreCase("H"))
              break label308;
            i7 = 1;
            break label82;
          }
          float f6 = f3 / f4;
          float f7 = Math.abs(f6);
          f1 = f7;
          continue;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          f1 = 0.0F;
          continue;
        }
        String str1 = paramString.substring(i4);
        if (str1.length() > 0)
          try
          {
            float f2 = Float.parseFloat(str1);
            f1 = f2;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            f1 = 0.0F;
          }
        else
          label302: f1 = 0.0F;
      }
      label308: i7 = i1;
    }
  }

  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public void c()
  {
  }

  public void c(float paramFloat)
  {
    this.W[0] = paramFloat;
  }

  public void c(int paramInt)
  {
    this.ab[0] = paramInt;
  }

  public void c(int paramInt1, int paramInt2)
  {
    this.G = paramInt1;
    this.C = (paramInt2 - paramInt1);
    if (this.C < this.L)
      this.C = this.L;
  }

  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  public void d(float paramFloat)
  {
    this.W[1] = paramFloat;
  }

  public void d(int paramInt)
  {
    this.ab[1] = paramInt;
  }

  public void d(int paramInt1, int paramInt2)
  {
    this.H = paramInt1;
    this.D = (paramInt2 - paramInt1);
    if (this.D < this.M)
      this.D = this.M;
  }

  public boolean d()
  {
    int i1 = this.e;
    boolean bool1 = false;
    if (i1 == 0)
    {
      boolean bool2 = this.E < 0.0F;
      bool1 = false;
      if (!bool2)
      {
        int i2 = this.g;
        bool1 = false;
        if (i2 == 0)
        {
          int i3 = this.h;
          bool1 = false;
          if (i3 == 0)
          {
            a locala1 = this.A[0];
            a locala2 = a.c;
            bool1 = false;
            if (locala1 == locala2)
              bool1 = true;
          }
        }
      }
    }
    return bool1;
  }

  public void e(int paramInt)
  {
    this.al = paramInt;
  }

  public boolean e()
  {
    return (this.f == 0) && (this.E == 0.0F) && (this.j == 0) && (this.k == 0) && (this.A[1] == a.c);
  }

  public void f()
  {
    this.q.i();
    this.r.i();
    this.s.i();
    this.t.i();
    this.u.i();
    this.v.i();
    this.w.i();
    this.x.i();
    this.B = null;
    this.ac = 0.0F;
    this.C = 0;
    this.D = 0;
    this.E = 0.0F;
    this.F = -1;
    this.G = 0;
    this.H = 0;
    this.ad = 0;
    this.ae = 0;
    this.af = 0;
    this.ag = 0;
    this.I = 0;
    this.J = 0;
    this.K = 0;
    this.L = 0;
    this.M = 0;
    this.ah = 0;
    this.ai = 0;
    this.O = N;
    this.P = N;
    this.A[0] = a.a;
    this.A[1] = a.a;
    this.aj = null;
    this.ak = 0;
    this.al = 0;
    this.an = null;
    this.Q = false;
    this.R = false;
    this.S = 0;
    this.T = 0;
    this.U = false;
    this.V = false;
    this.W[0] = 0.0F;
    this.W[1] = 0.0F;
    this.a = -1;
    this.b = -1;
    this.ab[0] = 2147483647;
    this.ab[1] = 2147483647;
    this.e = 0;
    this.f = 0;
    this.i = 1.0F;
    this.l = 1.0F;
    this.h = 2147483647;
    this.k = 2147483647;
    this.g = 0;
    this.j = 0;
    this.o = -1;
    this.p = 1.0F;
    if (this.c != null)
      this.c.b();
    if (this.d != null)
      this.d.b();
  }

  public void f(int paramInt)
  {
    this.G = paramInt;
  }

  public void g()
  {
    for (int i1 = 0; i1 < 6; i1++)
      this.y[i1].a().c();
  }

  public void g(int paramInt)
  {
    this.H = paramInt;
  }

  public k h()
  {
    if (this.c == null)
      this.c = new k();
    return this.c;
  }

  public void h(int paramInt)
  {
    this.C = paramInt;
    if (this.C < this.L)
      this.C = this.L;
  }

  public k i()
  {
    if (this.d == null)
      this.d = new k();
    return this.d;
  }

  public void i(int paramInt)
  {
    this.D = paramInt;
    if (this.D < this.M)
      this.D = this.M;
  }

  public d j()
  {
    return this.B;
  }

  public void j(int paramInt)
  {
    if (paramInt < 0)
    {
      this.L = 0;
      return;
    }
    this.L = paramInt;
  }

  public int k()
  {
    return this.al;
  }

  public void k(int paramInt)
  {
    if (paramInt < 0)
    {
      this.M = 0;
      return;
    }
    this.M = paramInt;
  }

  public String l()
  {
    return this.am;
  }

  public void l(int paramInt)
  {
    this.ah = paramInt;
  }

  public int m()
  {
    return this.G;
  }

  public void m(int paramInt)
  {
    this.ai = paramInt;
  }

  public int n()
  {
    return this.H;
  }

  public void n(int paramInt)
  {
    this.K = paramInt;
  }

  public int o()
  {
    if (this.al == 8)
      return 0;
    return this.C;
  }

  public void o(int paramInt)
  {
    this.S = paramInt;
  }

  public int p()
  {
    return this.ah;
  }

  public void p(int paramInt)
  {
    this.T = paramInt;
  }

  public int q()
  {
    if (this.al == 8)
      return 0;
    return this.D;
  }

  public int r()
  {
    return this.ai;
  }

  public int s()
  {
    return this.ad + this.I;
  }

  public int t()
  {
    return this.ae + this.J;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1;
    StringBuilder localStringBuilder2;
    if (this.an != null)
    {
      str1 = "type: " + this.an + " ";
      localStringBuilder2 = localStringBuilder1.append(str1);
      if (this.am == null)
        break label190;
    }
    label190: for (String str2 = "id: " + this.am + " "; ; str2 = "")
    {
      return str2 + "(" + this.G + ", " + this.H + ") - (" + this.C + " x " + this.D + ") wrap: (" + this.ah + " x " + this.ai + ")";
      str1 = "";
      break;
    }
  }

  protected int u()
  {
    return this.G + this.I;
  }

  protected int v()
  {
    return this.H + this.J;
  }

  public int w()
  {
    return this.L;
  }

  public int x()
  {
    return this.M;
  }

  public int y()
  {
    return m() + this.C;
  }

  public int z()
  {
    return n() + this.D;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.d
 * JD-Core Version:    0.6.2
 */