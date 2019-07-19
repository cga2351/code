package android.support.constraint.a.a;

import android.support.constraint.a.f;

public class h
{
  static boolean[] a = new boolean[3];

  static void a(int paramInt, d paramd)
  {
    paramd.g();
    j localj1 = paramd.q.a();
    j localj2 = paramd.r.a();
    j localj3 = paramd.s.a();
    j localj4 = paramd.t.a();
    int i;
    label202: if ((paramInt & 0x8) == 8)
    {
      i = 1;
      if ((localj1.g != 4) && (localj3.g != 4))
      {
        if (paramd.A[0] != d.a.a)
          break label502;
        if ((paramd.q.c != null) || (paramd.s.c != null))
          break label260;
        localj1.b(1);
        localj3.b(1);
        if (i == 0)
          break label247;
        localj3.a(localj1, 1, paramd.h());
      }
      label126: if ((localj2.g != 4) && (localj4.g != 4))
      {
        if (paramd.A[1] != d.a.a)
          break label1115;
        if ((paramd.r.c != null) || (paramd.t.c != null))
          break label821;
        localj2.b(1);
        localj4.b(1);
        if (i == 0)
          break label808;
        localj4.a(localj2, 1, paramd.i());
        if (paramd.u.c != null)
        {
          paramd.u.a().b(1);
          localj2.a(1, paramd.u.a(), -paramd.K);
        }
      }
    }
    label247: 
    do
    {
      int j;
      do
      {
        do
          while (true)
          {
            return;
            i = 0;
            break;
            localj3.a(localj1, paramd.o());
            break label126;
            if ((paramd.q.c != null) && (paramd.s.c == null))
            {
              localj1.b(1);
              localj3.b(1);
              if (i != 0)
              {
                localj3.a(localj1, 1, paramd.h());
                break label126;
              }
              localj3.a(localj1, paramd.o());
              break label126;
            }
            if ((paramd.q.c == null) && (paramd.s.c != null))
            {
              localj1.b(1);
              localj3.b(1);
              localj1.a(localj3, -paramd.o());
              if (i != 0)
              {
                localj1.a(localj3, -1, paramd.h());
                break label126;
              }
              localj1.a(localj3, -paramd.o());
              break label126;
            }
            if ((paramd.q.c == null) || (paramd.s.c == null))
              break label126;
            localj1.b(2);
            localj3.b(2);
            if (i != 0)
            {
              paramd.h().a(localj1);
              paramd.h().a(localj3);
              localj1.b(localj3, -1, paramd.h());
              localj3.b(localj1, 1, paramd.h());
              break label126;
            }
            localj1.b(localj3, -paramd.o());
            localj3.b(localj1, paramd.o());
            break label126;
            if ((paramd.A[0] != d.a.c) || (!a(paramd, 0)))
              break label126;
            int k = paramd.o();
            localj1.b(1);
            localj3.b(1);
            if ((paramd.q.c == null) && (paramd.s.c == null))
            {
              if (i != 0)
              {
                localj3.a(localj1, 1, paramd.h());
                break label126;
              }
              localj3.a(localj1, k);
              break label126;
            }
            if ((paramd.q.c != null) && (paramd.s.c == null))
            {
              if (i != 0)
              {
                localj3.a(localj1, 1, paramd.h());
                break label126;
              }
              localj3.a(localj1, k);
              break label126;
            }
            if ((paramd.q.c == null) && (paramd.s.c != null))
            {
              if (i != 0)
              {
                localj1.a(localj3, -1, paramd.h());
                break label126;
              }
              localj1.a(localj3, -k);
              break label126;
            }
            if ((paramd.q.c == null) || (paramd.s.c == null))
              break label126;
            if (i != 0)
            {
              paramd.h().a(localj1);
              paramd.h().a(localj3);
            }
            if (paramd.E == 0.0F)
            {
              localj1.b(3);
              localj3.b(3);
              localj1.b(localj3, 0.0F);
              localj3.b(localj1, 0.0F);
              break label126;
            }
            localj1.b(2);
            localj3.b(2);
            localj1.b(localj3, -k);
            localj3.b(localj1, k);
            paramd.h(k);
            break label126;
            localj4.a(localj2, paramd.q());
            break label202;
            if ((paramd.r.c != null) && (paramd.t.c == null))
            {
              localj2.b(1);
              localj4.b(1);
              if (i != 0)
                localj4.a(localj2, 1, paramd.i());
              while (paramd.K > 0)
              {
                paramd.u.a().a(1, localj2, paramd.K);
                return;
                localj4.a(localj2, paramd.q());
              }
            }
            else if ((paramd.r.c == null) && (paramd.t.c != null))
            {
              localj2.b(1);
              localj4.b(1);
              if (i != 0)
                localj2.a(localj4, -1, paramd.i());
              while (paramd.K > 0)
              {
                paramd.u.a().a(1, localj2, paramd.K);
                return;
                localj2.a(localj4, -paramd.q());
              }
            }
            else if ((paramd.r.c != null) && (paramd.t.c != null))
            {
              localj2.b(2);
              localj4.b(2);
              if (i != 0)
              {
                localj2.b(localj4, -1, paramd.i());
                localj4.b(localj2, 1, paramd.i());
                paramd.i().a(localj2);
                paramd.h().a(localj4);
              }
              while (paramd.K > 0)
              {
                paramd.u.a().a(1, localj2, paramd.K);
                return;
                localj2.b(localj4, -paramd.q());
                localj4.b(localj2, paramd.q());
              }
            }
          }
        while ((paramd.A[1] != d.a.c) || (!a(paramd, 1)));
        j = paramd.q();
        localj2.b(1);
        localj4.b(1);
        if ((paramd.r.c == null) && (paramd.t.c == null))
        {
          if (i != 0)
          {
            localj4.a(localj2, 1, paramd.i());
            return;
          }
          localj4.a(localj2, j);
          return;
        }
        if ((paramd.r.c != null) && (paramd.t.c == null))
        {
          if (i != 0)
          {
            localj4.a(localj2, 1, paramd.i());
            return;
          }
          localj4.a(localj2, j);
          return;
        }
        if ((paramd.r.c == null) && (paramd.t.c != null))
        {
          if (i != 0)
          {
            localj2.a(localj4, -1, paramd.i());
            return;
          }
          localj2.a(localj4, -j);
          return;
        }
      }
      while ((paramd.r.c == null) || (paramd.t.c == null));
      if (i != 0)
      {
        paramd.i().a(localj2);
        paramd.h().a(localj4);
      }
      if (paramd.E == 0.0F)
      {
        localj2.b(3);
        localj4.b(3);
        localj2.b(localj4, 0.0F);
        localj4.b(localj2, 0.0F);
        return;
      }
      localj2.b(2);
      localj4.b(2);
      localj2.b(localj4, -j);
      localj4.b(localj2, j);
      paramd.i(j);
    }
    while (paramd.K <= 0);
    label260: label502: paramd.u.a().a(1, localj2, paramd.K);
    label808: label821: label1115: return;
  }

  static void a(e parame, android.support.constraint.a.e parame1, d paramd)
  {
    if ((parame.A[0] != d.a.b) && (paramd.A[0] == d.a.d))
    {
      int k = paramd.q.d;
      int m = parame.o() - paramd.s.d;
      paramd.q.f = parame1.a(paramd.q);
      paramd.s.f = parame1.a(paramd.s);
      parame1.a(paramd.q.f, k);
      parame1.a(paramd.s.f, m);
      paramd.a = 2;
      paramd.c(k, m);
    }
    if ((parame.A[1] != d.a.b) && (paramd.A[1] == d.a.d))
    {
      int i = paramd.r.d;
      int j = parame.q() - paramd.t.d;
      paramd.r.f = parame1.a(paramd.r);
      paramd.t.f = parame1.a(paramd.t);
      parame1.a(paramd.r.f, i);
      parame1.a(paramd.t.f, j);
      if ((paramd.K > 0) || (paramd.k() == 8))
      {
        paramd.u.f = parame1.a(paramd.u);
        parame1.a(paramd.u.f, i + paramd.K);
      }
      paramd.b = 2;
      paramd.d(i, j);
    }
  }

  private static boolean a(d paramd, int paramInt)
  {
    boolean bool = true;
    if (paramd.A[paramInt] != d.a.c);
    do
    {
      while (true)
      {
        return false;
        if (paramd.E == 0.0F)
          break;
        d.a[] arrayOfa = paramd.A;
        if (paramInt == 0);
        while (arrayOfa[bool] == d.a.c)
        {
          return false;
          bool = false;
        }
      }
      if (paramInt != 0)
        break;
    }
    while ((paramd.e != 0) || (paramd.g != 0) || (paramd.h != 0));
    do
    {
      return bool;
      if ((paramd.f != 0) || (paramd.j != 0))
        break;
    }
    while (paramd.k == 0);
    return false;
  }

  static boolean a(e parame, android.support.constraint.a.e parame1, int paramInt1, int paramInt2, d paramd)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    int j = 0;
    float f1 = 0.0F;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5;
    if ((parame.A[paramInt1] != d.a.b) || ((paramInt1 == 0) && (parame.N())))
    {
      int i3 = 0;
      localObject5 = paramd;
      if (i3 == 0)
      {
        c localc2 = localObject5.y[(paramInt2 + 1)].c;
        Object localObject15;
        if (localc2 != null)
        {
          localObject15 = localc2.a;
          if ((localObject15.y[paramInt2].c == null) || (localObject15.y[paramInt2].c.a != localObject5))
            localObject15 = null;
          label116: if (localObject15 == null)
            break label134;
        }
        while (true)
        {
          localObject5 = localObject15;
          break;
          localObject15 = null;
          break label116;
          label134: i3 = 1;
          localObject15 = localObject5;
        }
      }
      i = 0;
    }
    for (Object localObject6 = paramd; ; localObject6 = paramd)
    {
      int k;
      int m;
      label178: int n;
      label190: float f2;
      float f3;
      int i1;
      int i2;
      float f25;
      label266: Object localObject7;
      Object localObject8;
      if (paramInt1 == 0)
        if (((d)localObject5).S == 0)
        {
          k = 1;
          if (((d)localObject5).S != 1)
            break label393;
          m = 1;
          if (((d)localObject5).S != 2)
            break label399;
          n = 1;
          f2 = 0.0F;
          f3 = 0.0F;
          i1 = 0;
          if (i != 0)
            break label678;
          ((d)localObject6).Y[paramInt1] = null;
          if (((d)localObject6).k() == 8)
            break label1901;
          if (localObject2 != null)
            localObject2.Y[paramInt1] = localObject6;
          if (localObject1 == null)
            localObject1 = localObject6;
          i2 = i1 + 1;
          if (paramInt1 != 0)
            break label461;
          f25 = f2 + ((d)localObject6).o();
          if (localObject6 != localObject1)
            f25 += localObject6.y[paramInt2].e();
          f3 = f3 + localObject6.y[paramInt2].e() + localObject6.y[(paramInt2 + 1)].e();
          f2 = f25;
          localObject7 = localObject1;
          localObject8 = localObject6;
        }
      while (true)
      {
        localObject6.y[paramInt2];
        ((d)localObject6).X[paramInt1] = null;
        label393: label399: label416: label449: label455: label461: Object localObject14;
        label521: label542: Object localObject11;
        Object localObject10;
        if ((((d)localObject6).k() != 8) && (localObject6.A[paramInt1] == d.a.c))
        {
          j++;
          if (paramInt1 == 0)
          {
            if (((d)localObject6).e != 0)
            {
              return false;
              k = 0;
              break;
              m = 0;
              break label178;
              n = 0;
              break label190;
              if (((d)localObject5).T == 0)
              {
                k = 1;
                if (((d)localObject5).T != 1)
                  break label449;
              }
              for (m = 1; ; m = 0)
              {
                if (((d)localObject5).T != 2)
                  break label455;
                n = 1;
                break;
                k = 0;
                break label416;
              }
              n = 0;
              break label190;
              f25 = f2 + ((d)localObject6).q();
              break label266;
            }
            if ((((d)localObject6).g == 0) && (((d)localObject6).h == 0))
              break label521;
            return false;
          }
          if (((d)localObject6).f != 0)
            return false;
          if ((((d)localObject6).j != 0) || (((d)localObject6).k != 0))
            return false;
          f1 += localObject6.W[paramInt1];
          if (localObject3 == null)
          {
            localObject14 = localObject6;
            localObject11 = localObject6;
            localObject10 = localObject14;
          }
        }
        while (true)
        {
          c localc1 = localObject6.y[(paramInt2 + 1)].c;
          Object localObject12;
          if (localc1 != null)
          {
            localObject12 = localc1.a;
            if ((localObject12.y[paramInt2].c == null) || (localObject12.y[paramInt2].c.a != localObject6))
              localObject12 = null;
            label610: if (localObject12 == null)
              break label668;
          }
          while (true)
          {
            localObject6 = localObject12;
            i1 = i2;
            localObject2 = localObject8;
            localObject1 = localObject7;
            Object localObject13 = localObject10;
            localObject4 = localObject11;
            localObject3 = localObject13;
            break;
            localObject4.X[paramInt1] = localObject6;
            localObject14 = localObject3;
            break label542;
            localObject12 = null;
            break label610;
            label668: i = 1;
            localObject12 = localObject6;
          }
          label678: j localj1 = paramd.y[paramInt2].a();
          j localj2 = localObject6.y[(paramInt2 + 1)].a();
          if ((localj1.c == null) || (localj2.c == null))
            return false;
          if ((localj1.c.i != 1) && (localj2.c.i != 1))
            return false;
          if ((j > 0) && (j != i1))
            return false;
          float f4;
          if ((n == 0) && (k == 0))
          {
            f4 = 0.0F;
            if (m == 0);
          }
          else
          {
            f4 = 0.0F;
            if (localObject1 != null)
              f4 = localObject1.y[paramInt2].e();
            if (localObject2 != null)
              f4 += localObject2.y[(paramInt2 + 1)].e();
          }
          float f5 = localj1.c.f;
          float f6 = localj2.c.f;
          float f7;
          if (f5 < f6)
            f7 = f6 - f5 - f2;
          float f19;
          while ((j > 0) && (j == i1))
            if ((((d)localObject6).j() != null) && (localObject6.j().A[paramInt1] == d.a.b))
            {
              return false;
              f7 = f5 - f6 - f2;
            }
            else
            {
              f19 = f7 + f2 - f3;
              if (k == 0)
                break label1879;
            }
          label1355: label1879: for (float f20 = f19 - (f3 - f4); ; f20 = f19)
          {
            float f21;
            if (k != 0)
            {
              f21 = f5 + localObject1.y[(paramInt2 + 1)].e();
              d locald4 = localObject1.Y[paramInt1];
              if (locald4 != null)
                f21 += locald4.y[paramInt2].e();
            }
            while (true)
            {
              d locald3;
              float f22;
              float f23;
              if (localObject1 != null)
              {
                if (android.support.constraint.a.e.g != null)
                {
                  f localf7 = android.support.constraint.a.e.g;
                  localf7.B -= 1L;
                  f localf8 = android.support.constraint.a.e.g;
                  localf8.s = (1L + localf8.s);
                  f localf9 = android.support.constraint.a.e.g;
                  localf9.y = (1L + localf9.y);
                }
                locald3 = localObject1.Y[paramInt1];
                if ((locald3 == null) && (localObject1 != localObject2))
                  break label1865;
                f22 = f20 / j;
                if (f1 > 0.0F)
                  f22 = f20 * localObject1.W[paramInt1] / f1;
                f23 = f21 + localObject1.y[paramInt2].e();
                localObject1.y[paramInt2].a().a(localj1.e, f23);
                localObject1.y[(paramInt2 + 1)].a().a(localj1.e, f23 + f22);
                localObject1.y[paramInt2].a().a(parame1);
                localObject1.y[(paramInt2 + 1)].a().a(parame1);
              }
              for (float f24 = f22 + f23 + localObject1.y[(paramInt2 + 1)].e(); ; f24 = f21)
              {
                f21 = f24;
                localObject1 = locald3;
                break;
                return true;
                if (f7 < f2)
                  return false;
                float f15;
                d locald2;
                float f16;
                float f17;
                if (n != 0)
                {
                  f15 = f5 + (f7 - f4) * paramd.A();
                  if (localObject1 == null)
                    break label1828;
                  if (android.support.constraint.a.e.g != null)
                  {
                    f localf4 = android.support.constraint.a.e.g;
                    localf4.B -= 1L;
                    f localf5 = android.support.constraint.a.e.g;
                    localf5.s = (1L + localf5.s);
                    f localf6 = android.support.constraint.a.e.g;
                    localf6.y = (1L + localf6.y);
                  }
                  locald2 = localObject1.Y[paramInt1];
                  if ((locald2 == null) && (localObject1 != localObject2))
                    break label1858;
                  if (paramInt1 == 0)
                  {
                    f16 = localObject1.o();
                    f17 = f15 + localObject1.y[paramInt2].e();
                    localObject1.y[paramInt2].a().a(localj1.e, f17);
                    localObject1.y[(paramInt2 + 1)].a().a(localj1.e, f17 + f16);
                    localObject1.y[paramInt2].a().a(parame1);
                    localObject1.y[(paramInt2 + 1)].a().a(parame1);
                  }
                }
                for (float f18 = f16 + f17 + localObject1.y[(paramInt2 + 1)].e(); ; f18 = f15)
                {
                  f15 = f18;
                  localObject1 = locald2;
                  break;
                  f16 = localObject1.q();
                  break label1355;
                  float f8;
                  if ((k != 0) || (m != 0))
                    if (k != 0)
                      f8 = f7 - f4;
                  while (true)
                  {
                    float f9 = f8 / (i1 + 1);
                    float f10;
                    if (m != 0)
                      if (i1 > 1)
                        f10 = f8 / (i1 - 1);
                    while (true)
                    {
                      float f11 = f5 + f10;
                      if ((m != 0) && (i1 > 1));
                      for (float f12 = f5 + localObject1.y[paramInt2].e(); ; f12 = f11)
                      {
                        if ((k != 0) && (localObject1 != null))
                          f12 += localObject1.y[paramInt2].e();
                        d locald1;
                        float f13;
                        if (localObject1 != null)
                        {
                          if (android.support.constraint.a.e.g != null)
                          {
                            f localf1 = android.support.constraint.a.e.g;
                            localf1.B -= 1L;
                            f localf2 = android.support.constraint.a.e.g;
                            localf2.s = (1L + localf2.s);
                            f localf3 = android.support.constraint.a.e.g;
                            localf3.y = (1L + localf3.y);
                          }
                          locald1 = localObject1.Y[paramInt1];
                          if ((locald1 == null) && (localObject1 != localObject2))
                            break label1830;
                          if (paramInt1 == 0)
                          {
                            f13 = localObject1.o();
                            localObject1.y[paramInt2].a().a(localj1.e, f12);
                            localObject1.y[(paramInt2 + 1)].a().a(localj1.e, f12 + f13);
                            localObject1.y[paramInt2].a().a(parame1);
                            localObject1.y[(paramInt2 + 1)].a().a(parame1);
                          }
                        }
                        for (float f14 = f12 + (f13 + f10); ; f14 = f12)
                        {
                          f12 = f14;
                          localObject1 = locald1;
                          break label1602;
                          if (m == 0)
                            break label1851;
                          f8 = f7 - f4;
                          break;
                          f10 = f8 / 2.0F;
                          break label1542;
                          f13 = localObject1.q();
                          break label1697;
                          return true;
                        }
                      }
                      f10 = f9;
                    }
                    f8 = f7;
                  }
                }
              }
              f21 = f5;
            }
          }
          label1542: label1602: label1865: Object localObject9 = localObject4;
          label1697: label1828: label1830: label1851: label1858: localObject10 = localObject3;
          localObject11 = localObject9;
        }
        label1901: localObject7 = localObject1;
        localObject8 = localObject2;
        i2 = i1;
      }
      localObject5 = paramd;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.h
 * JD-Core Version:    0.6.2
 */