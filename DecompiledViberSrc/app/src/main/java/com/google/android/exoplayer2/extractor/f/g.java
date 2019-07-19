package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class g
  implements ae.c
{
  private final int a;
  private final List<Format> b;

  public g()
  {
    this(0);
  }

  public g(int paramInt)
  {
    this(paramInt, Collections.singletonList(Format.createTextSampleFormat(null, "application/cea-608", 0, null)));
  }

  public g(int paramInt, List<Format> paramList)
  {
    this.a = paramInt;
    this.b = paramList;
  }

  private y a(ae.b paramb)
  {
    return new y(c(paramb));
  }

  private boolean a(int paramInt)
  {
    return (paramInt & this.a) != 0;
  }

  private ag b(ae.b paramb)
  {
    return new ag(c(paramb));
  }

  private List<Format> c(ae.b paramb)
  {
    Object localObject;
    if (a(32))
      localObject = this.b;
    while (true)
    {
      return localObject;
      com.google.android.exoplayer2.g.r localr = new com.google.android.exoplayer2.g.r(paramb.d);
      localObject = this.b;
      while (localr.b() > 0)
      {
        int i = localr.h();
        int j = localr.h() + localr.d();
        if (i == 134)
        {
          ArrayList localArrayList = new ArrayList();
          int k = 0x1F & localr.h();
          int m = 0;
          if (m < k)
          {
            String str1 = localr.e(3);
            int n = localr.h();
            int i1;
            label118: String str2;
            int i2;
            label134: List localList;
            if ((n & 0x80) != 0)
            {
              i1 = 1;
              if (i1 == 0)
                break label211;
              str2 = "application/cea-708";
              i2 = n & 0x3F;
              int i3 = (byte)localr.h();
              localr.d(1);
              localList = null;
              if (i1 != 0)
                if ((i3 & 0x40) == 0)
                  break label221;
            }
            label211: label221: for (boolean bool = true; ; bool = false)
            {
              localList = d.a(bool);
              localArrayList.add(Format.createTextSampleFormat(null, str2, null, -1, 0, str1, i2, null, 9223372036854775807L, localList));
              m++;
              break;
              i1 = 0;
              break label118;
              str2 = "application/cea-608";
              i2 = 1;
              break label134;
            }
          }
          localObject = localArrayList;
        }
        localr.c(j);
      }
    }
  }

  public SparseArray<ae> a()
  {
    return new SparseArray();
  }

  public ae a(int paramInt, ae.b paramb)
  {
    switch (paramInt)
    {
    default:
    case 3:
    case 4:
    case 15:
    case 17:
    case 129:
    case 135:
    case 130:
    case 138:
    case 2:
    case 27:
    case 36:
    case 134:
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              return new r(new p(paramb.b));
            }
            while (a(2));
            return new r(new f(false, paramb.b));
          }
          while (a(2));
          return new r(new o(paramb.b));
          return new r(new c(paramb.b));
          return new r(new h(paramb.b));
          return new r(new k(b(paramb)));
        }
        while (a(4));
        return new r(new l(a(paramb), a(1), a(8)));
        return new r(new m(a(paramb)));
      }
      while (a(16));
      return new x(new z());
    case 21:
      return new r(new n());
    case 89:
    }
    return new r(new i(paramb.c));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.g
 * JD-Core Version:    0.6.2
 */