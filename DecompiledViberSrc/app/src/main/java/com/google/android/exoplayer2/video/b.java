package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.Collections;
import java.util.List;

public final class b
{
  public final List<byte[]> a;
  public final int b;

  private b(List<byte[]> paramList, int paramInt)
  {
    this.a = paramList;
    this.b = paramInt;
  }

  public static b a(r paramr)
    throws w
  {
    while (true)
    {
      int m;
      int i3;
      int i5;
      int i8;
      Object localObject;
      try
      {
        paramr.d(21);
        int i = 0x3 & paramr.h();
        int j = paramr.h();
        int k = paramr.d();
        m = 0;
        n = 0;
        if (m < j)
        {
          paramr.d(1);
          int i1 = paramr.i();
          int i2 = 0;
          i3 = n;
          if (i2 < i1)
          {
            int i4 = paramr.i();
            i3 += i4 + 4;
            paramr.d(i4);
            i2++;
            continue;
          }
        }
        else
        {
          paramr.c(k);
          byte[] arrayOfByte = new byte[n];
          i5 = 0;
          i6 = 0;
          if (i5 >= j)
            break label262;
          paramr.d(1);
          int i7 = paramr.i();
          i8 = i6;
          int i9 = 0;
          if (i9 >= i7)
            break label252;
          int i10 = paramr.i();
          System.arraycopy(p.a, 0, arrayOfByte, i8, p.a.length);
          int i11 = i8 + p.a.length;
          System.arraycopy(paramr.a, paramr.d(), arrayOfByte, i11, i10);
          i8 = i11 + i10;
          paramr.d(i10);
          i9++;
          continue;
          return new b((List)localObject, i + 1);
          List localList = Collections.singletonList(arrayOfByte);
          localObject = localList;
          continue;
        }
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new w("Error parsing HEVC config", localArrayIndexOutOfBoundsException);
      }
      m++;
      int n = i3;
      continue;
      label252: i5++;
      int i6 = i8;
      continue;
      label262: if (n == 0)
        localObject = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.b
 * JD-Core Version:    0.6.2
 */