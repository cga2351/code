package android.support.constraint.a.a;

class b
{
  static void a(e parame, android.support.constraint.a.e parame1, int paramInt)
  {
    int i = 0;
    int k;
    d[] arrayOfd;
    int j;
    d locald;
    if (paramInt == 0)
    {
      k = parame.ag;
      arrayOfd = parame.aj;
      j = 0;
      if (i >= k)
        return;
      locald = arrayOfd[i];
      if (!parame.q(4))
        break label90;
      if (!h.a(parame, parame1, paramInt, j, locald))
        a(parame, parame1, paramInt, j, locald);
    }
    while (true)
    {
      i++;
      break;
      j = 2;
      k = parame.ah;
      arrayOfd = parame.ai;
      i = 0;
      break;
      label90: a(parame, parame1, paramInt, j, locald);
    }
  }

  static void a(e parame, android.support.constraint.a.e parame1, int paramInt1, int paramInt2, d paramd)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    Object localObject3 = null;
    Object localObject4 = null;
    int j;
    int i22;
    Object localObject24;
    label48: Object localObject25;
    if (parame.A[paramInt1] == d.a.b)
    {
      j = 1;
      if ((paramInt1 != 0) || (!parame.N()))
        break label2466;
      i22 = 0;
      localObject24 = paramd;
      if (i22 != 0)
        break label147;
      c localc21 = localObject24.y[(paramInt2 + 1)].c;
      if (localc21 == null)
        break label131;
      localObject25 = localc21.a;
      if ((localObject25.y[paramInt2].c == null) || (localObject25.y[paramInt2].c.a != localObject24))
        localObject25 = null;
      label113: if (localObject25 == null)
        break label137;
    }
    while (true)
    {
      localObject24 = localObject25;
      break label48;
      j = 0;
      break;
      label131: localObject25 = null;
      break label113;
      label137: i22 = 1;
      localObject25 = localObject24;
    }
    label147: Object localObject5 = localObject24;
    for (Object localObject6 = paramd; ; localObject6 = paramd)
    {
      int i19;
      int i20;
      label182: int i21;
      label194: int i1;
      int i2;
      int i3;
      float f1;
      int i4;
      label212: Object localObject23;
      label258: Object localObject18;
      if (paramInt1 == 0)
        if (((d)localObject5).S == 0)
        {
          i19 = 1;
          if (((d)localObject5).S != 1)
            break label624;
          i20 = 1;
          if (((d)localObject5).S != 2)
            break label630;
          i21 = 1;
          i1 = i21;
          i2 = i20;
          i3 = i19;
          f1 = 0.0F;
          i4 = 0;
          if (i4 != 0)
            break label777;
          ((d)localObject6).Y[paramInt1] = null;
          if (((d)localObject6).k() == 8)
            break label2459;
          if (localObject2 != null)
            localObject2.Y[paramInt1] = localObject6;
          if (localObject1 != null)
            break label2452;
          localObject23 = localObject6;
          localObject18 = localObject6;
          localObject1 = localObject23;
        }
      while (true)
      {
        c localc19 = localObject6.y[paramInt2];
        int i16 = 1;
        int i17 = localc19.e();
        if ((localc19.c != null) && (localObject6 != paramd) && (((d)localObject6).k() != 8))
          i17 += localc19.c.e();
        if ((i1 != 0) && (localObject6 != paramd) && (localObject6 != localObject1))
          i16 = 6;
        label373: float f5;
        if (localObject6 == localObject1)
        {
          parame1.a(localc19.f, localc19.c.f, i17, 5);
          parame1.c(localc19.f, localc19.c.f, i17, i16);
          ((d)localObject6).X[paramInt1] = null;
          if ((((d)localObject6).k() == 8) || (localObject6.A[paramInt1] != d.a.c))
            break label2437;
          int i18 = i + 1;
          float f6 = f1 + localObject6.W[paramInt1];
          if (localObject3 != null)
            break label749;
          localObject3 = localObject6;
          label453: if (j != 0)
            parame1.a(localObject6.y[(paramInt2 + 1)].f, localObject6.y[paramInt2].f, 0, 6);
          f5 = f6;
          i = i18;
        }
        label590: label624: label630: label767: Object localObject19;
        for (Object localObject20 = localObject6; ; localObject20 = localObject19)
        {
          if (j != 0)
            parame1.a(localObject6.y[paramInt2].f, parame.y[paramInt2].f, 0, 6);
          c localc20 = localObject6.y[(paramInt2 + 1)].c;
          Object localObject21;
          if (localc20 != null)
          {
            localObject21 = localc20.a;
            if ((localObject21.y[paramInt2].c == null) || (localObject21.y[paramInt2].c.a != localObject6))
              localObject21 = null;
            if (localObject21 == null)
              break label767;
          }
          while (true)
          {
            localObject2 = localObject18;
            localObject6 = localObject21;
            Object localObject22 = localObject20;
            f1 = f5;
            localObject4 = localObject22;
            break label212;
            i19 = 0;
            break;
            i20 = 0;
            break label182;
            i21 = 0;
            break label194;
            int k;
            label647: int m;
            if (((d)localObject5).T == 0)
            {
              k = 1;
              if (((d)localObject5).T != 1)
                break label713;
              m = 1;
              label659: if (((d)localObject5).T != 2)
                break label719;
            }
            label713: label719: for (int n = 1; ; n = 0)
            {
              i1 = n;
              i2 = m;
              i3 = k;
              i4 = 0;
              f1 = 0.0F;
              localObject3 = null;
              localObject4 = null;
              i = 0;
              localObject1 = null;
              localObject2 = null;
              break;
              k = 0;
              break label647;
              m = 0;
              break label659;
            }
            parame1.a(localc19.f, localc19.c.f, i17, 6);
            break label373;
            label749: localObject4.X[paramInt1] = localObject6;
            break label453;
            localObject21 = null;
            break label590;
            i4 = 1;
            localObject21 = localObject6;
          }
          label777: if ((localObject2 != null) && (localObject6.y[(paramInt2 + 1)].c != null))
          {
            c localc18 = localObject2.y[(paramInt2 + 1)];
            parame1.b(localc18.f, localObject6.y[(paramInt2 + 1)].c.f, -localc18.e(), 5);
          }
          if (j != 0)
            parame1.a(parame.y[(paramInt2 + 1)].f, localObject6.y[(paramInt2 + 1)].f, localObject6.y[(paramInt2 + 1)].e(), 6);
          if (i > 0)
          {
            Object localObject17 = localObject3;
            if (localObject17 != null)
            {
              d locald4 = localObject17.X[paramInt1];
              float f3;
              float f4;
              android.support.constraint.a.h localh15;
              android.support.constraint.a.h localh16;
              android.support.constraint.a.h localh17;
              android.support.constraint.a.h localh18;
              int i13;
              int i14;
              if (locald4 != null)
              {
                f3 = localObject17.W[paramInt1];
                f4 = locald4.W[paramInt1];
                localh15 = localObject17.y[paramInt2].f;
                localh16 = localObject17.y[(paramInt2 + 1)].f;
                localh17 = locald4.y[paramInt2].f;
                localh18 = locald4.y[(paramInt2 + 1)].f;
                if (paramInt1 != 0)
                  break label1070;
                i13 = localObject17.e;
                i14 = locald4.e;
                label1001: if (((i13 != 0) && (i13 != 3)) || ((i14 != 0) && (i14 != 3)))
                  break label1087;
              }
              label1070: label1087: for (int i15 = 1; ; i15 = 0)
              {
                if (i15 != 0)
                {
                  android.support.constraint.a.b localb = parame1.c();
                  localb.a(f3, f1, f4, localh15, localh16, localh17, localh18);
                  parame1.a(localb);
                }
                localObject17 = locald4;
                break;
                i13 = localObject17.f;
                i14 = locald4.f;
                break label1001;
              }
            }
          }
          android.support.constraint.a.h localh13;
          android.support.constraint.a.h localh14;
          label1190: float f2;
          if ((localObject1 != null) && ((localObject1 == localObject2) || (i1 != 0)))
          {
            c localc16 = paramd.y[paramInt2];
            c localc17 = localObject6.y[(paramInt2 + 1)];
            if (paramd.y[paramInt2].c != null)
            {
              localh13 = paramd.y[paramInt2].c.f;
              if (localObject6.y[(paramInt2 + 1)].c == null)
                break label1467;
              localh14 = localObject6.y[(paramInt2 + 1)].c.f;
              if (localObject1 == localObject2)
              {
                localc16 = localObject1.y[paramInt2];
                localc17 = localObject1.y[(paramInt2 + 1)];
              }
              if ((localh13 != null) && (localh14 != null))
              {
                if (paramInt1 != 0)
                  break label1473;
                f2 = ((d)localObject5).O;
                label1238: int i11 = localc16.e();
                if (localObject2 == null)
                  localObject2 = localObject6;
                int i12 = localObject2.y[(paramInt2 + 1)].e();
                parame1.a(localc16.f, localh13, i11, f2, localh14, localc17.f, i12, 5);
              }
            }
          }
          c localc1;
          c localc2;
          android.support.constraint.a.h localh1;
          label1350: android.support.constraint.a.h localh2;
          label1368: c localc3;
          c localc4;
          for (Object localObject7 = localObject2; ; localObject7 = localObject2)
          {
            label1421: if (((i3 != 0) || (i2 != 0)) && (localObject1 != null))
            {
              localc1 = localObject1.y[paramInt2];
              localc2 = localObject7.y[(paramInt2 + 1)];
              if (localc1.c == null)
                break label2393;
              localh1 = localc1.c.f;
              if (localc2.c == null)
                break label2399;
              localh2 = localc2.c.f;
              if (localObject1 != localObject7)
                break label2412;
              c localc5 = localObject1.y[paramInt2];
              localc3 = localObject1.y[(paramInt2 + 1)];
              localc4 = localc5;
              label1399: if ((localh1 != null) && (localh2 != null))
              {
                int i5 = localc4.e();
                if (localObject7 != null)
                  break label2405;
                int i6 = localObject6.y[(paramInt2 + 1)].e();
                parame1.a(localc4.f, localh1, i5, 0.5F, localh2, localc3.f, i6, 5);
              }
            }
            return;
            localh13 = null;
            break;
            label1467: localh14 = null;
            break label1190;
            label1473: f2 = ((d)localObject5).P;
            break label1238;
            if ((i3 == 0) || (localObject1 == null))
              break label1905;
            Object localObject12 = localObject1;
            Object localObject13 = localObject1;
            if (localObject13 != null)
            {
              d locald3 = localObject13.Y[paramInt1];
              android.support.constraint.a.h localh8;
              Object localObject14;
              label1561: label1582: int i9;
              int i10;
              c localc15;
              Object localObject15;
              android.support.constraint.a.h localh12;
              label1642: android.support.constraint.a.h localh11;
              if ((locald3 != null) || (localObject13 == localObject2))
              {
                c localc13 = localObject13.y[paramInt2];
                localh8 = localc13.f;
                if (localc13.c == null)
                  break label1777;
                localObject14 = localc13.c.f;
                if (localObject12 == localObject13)
                  break label1783;
                localObject14 = localObject12.y[(paramInt2 + 1)].f;
                i9 = localc13.e();
                i10 = localObject13.y[(paramInt2 + 1)].e();
                if (locald3 == null)
                  break label1844;
                localc15 = locald3.y[paramInt2];
                localObject15 = localc15.f;
                if (localc15.c == null)
                  break label1838;
                localh12 = localc15.c.f;
                localh11 = localh12;
              }
              label1777: label1783: c localc14;
              for (Object localObject16 = localc15; ; localObject16 = localc14)
              {
                if (localObject16 != null)
                  i10 += ((c)localObject16).e();
                if (localObject12 != null)
                  i9 += localObject12.y[(paramInt2 + 1)].e();
                if ((localh8 != null) && (localObject14 != null) && (localObject15 != null) && (localh11 != null))
                {
                  if (localObject13 == localObject1)
                    i9 = localObject1.y[paramInt2].e();
                  if (localObject13 == localObject2)
                    i10 = localObject2.y[(paramInt2 + 1)].e();
                  parame1.a(localh8, (android.support.constraint.a.h)localObject14, i9, 0.5F, (android.support.constraint.a.h)localObject15, localh11, i10, 4);
                }
                localObject12 = localObject13;
                localObject13 = locald3;
                break;
                localObject14 = null;
                break label1561;
                if ((localObject13 != localObject1) || (localObject12 != localObject13))
                  break label1582;
                if (paramd.y[paramInt2].c != null);
                for (android.support.constraint.a.h localh9 = paramd.y[paramInt2].c.f; ; localh9 = null)
                {
                  localObject14 = localh9;
                  break;
                }
                label1838: localh12 = null;
                break label1642;
                label1844: localc14 = localObject6.y[(paramInt2 + 1)].c;
                android.support.constraint.a.h localh10 = null;
                if (localc14 != null)
                  localh10 = localc14.f;
                localh11 = localObject13.y[(paramInt2 + 1)].f;
                localObject15 = localh10;
              }
            }
          }
          label1905: Object localObject8;
          Object localObject9;
          label1923: d locald1;
          d locald2;
          label1966: Object localObject10;
          android.support.constraint.a.h localh7;
          label2073: android.support.constraint.a.h localh6;
          Object localObject11;
          if ((i2 != 0) && (localObject1 != null))
          {
            localObject8 = localObject1;
            localObject9 = localObject1;
            if (localObject9 != null)
            {
              locald1 = localObject9.Y[paramInt1];
              if ((localObject9 == localObject1) || (localObject9 == localObject2) || (locald1 == null))
                break label2430;
              if (locald1 != localObject2)
                break label2423;
              locald2 = null;
              c localc10 = localObject9.y[paramInt2];
              android.support.constraint.a.h localh3 = localc10.f;
              if (localc10.c != null);
              android.support.constraint.a.h localh4 = localObject8.y[(paramInt2 + 1)].f;
              int i7 = localc10.e();
              int i8 = localObject9.y[(paramInt2 + 1)].e();
              if (locald2 != null)
              {
                c localc12 = locald2.y[paramInt2];
                localObject10 = localc12.f;
                if (localc12.c != null)
                {
                  localh7 = localc12.c.f;
                  localh6 = localh7;
                  localObject11 = localc12;
                  label2081: if (localObject11 != null)
                    i8 += ((c)localObject11).e();
                  if (localObject8 != null)
                    i7 += localObject8.y[(paramInt2 + 1)].e();
                  if ((localh3 != null) && (localh4 != null) && (localObject10 != null) && (localh6 != null))
                    parame1.a(localh3, localh4, i7, 0.5F, (android.support.constraint.a.h)localObject10, localh6, i8, 4);
                }
              }
            }
          }
          while (true)
          {
            localObject8 = localObject9;
            localObject9 = locald2;
            break label1923;
            localh7 = null;
            break label2073;
            c localc11 = localObject9.y[(paramInt2 + 1)].c;
            android.support.constraint.a.h localh5 = null;
            if (localc11 != null)
              localh5 = localc11.f;
            localh6 = localObject9.y[(paramInt2 + 1)].f;
            localObject10 = localh5;
            localObject11 = localc11;
            break label2081;
            c localc6 = localObject1.y[paramInt2];
            c localc7 = paramd.y[paramInt2].c;
            c localc8 = localObject2.y[(paramInt2 + 1)];
            c localc9 = localObject6.y[(paramInt2 + 1)].c;
            if (localc7 != null)
            {
              if (localObject1 == localObject2)
                break label2348;
              parame1.c(localc6.f, localc7.f, localc6.e(), 5);
            }
            while (true)
            {
              if ((localc9 != null) && (localObject1 != localObject2))
                parame1.c(localc8.f, localc9.f, -localc8.e(), 5);
              localObject7 = localObject2;
              break;
              label2348: if (localc9 != null)
                parame1.a(localc6.f, localc7.f, localc6.e(), 0.5F, localc8.f, localc9.f, localc8.e(), 5);
            }
            label2393: localh1 = null;
            break label1350;
            label2399: localh2 = null;
            break label1368;
            label2405: localObject6 = localObject7;
            break label1421;
            label2412: localc3 = localc2;
            localc4 = localc1;
            break label1399;
            label2423: locald2 = locald1;
            break label1966;
            label2430: locald2 = locald1;
          }
          label2437: localObject19 = localObject4;
          f5 = f1;
        }
        label2452: localObject23 = localObject1;
        break label258;
        label2459: localObject18 = localObject2;
      }
      label2466: localObject5 = paramd;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.b
 * JD-Core Version:    0.6.2
 */