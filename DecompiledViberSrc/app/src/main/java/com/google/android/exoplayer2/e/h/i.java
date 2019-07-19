package com.google.android.exoplayer2.e.h;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i
  implements com.google.android.exoplayer2.e.e
{
  private final List<e> a;
  private final int b;
  private final long[] c;
  private final long[] d;

  public i(List<e> paramList)
  {
    this.a = paramList;
    this.b = paramList.size();
    this.c = new long[2 * this.b];
    for (int i = 0; i < this.b; i++)
    {
      e locale = (e)paramList.get(i);
      int j = i * 2;
      this.c[j] = locale.o;
      this.c[(j + 1)] = locale.p;
    }
    this.d = Arrays.copyOf(this.c, this.c.length);
    Arrays.sort(this.d);
  }

  public int a(long paramLong)
  {
    int i = ag.b(this.d, paramLong, false, false);
    if (i < this.d.length)
      return i;
    return -1;
  }

  public long a(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt >= 0)
    {
      bool2 = bool1;
      a.a(bool2);
      if (paramInt >= this.d.length)
        break label37;
    }
    while (true)
    {
      a.a(bool1);
      return this.d[paramInt];
      bool2 = false;
      break;
      label37: bool1 = false;
    }
  }

  public int b()
  {
    return this.d.length;
  }

  public List<b> b(long paramLong)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject9;
    label64: e locale;
    Object localObject6;
    Object localObject7;
    Object localObject5;
    if (i < this.b)
    {
      if ((this.c[(i * 2)] > paramLong) || (paramLong >= this.c[(1 + i * 2)]))
        break label281;
      if (localObject3 != null)
        break label274;
      localObject9 = new ArrayList();
      locale = (e)this.a.get(i);
      if (locale.a())
        if (localObject2 == null)
        {
          localObject6 = localObject9;
          localObject7 = localObject1;
          localObject5 = locale;
        }
    }
    while (true)
    {
      i++;
      Object localObject8 = localObject7;
      localObject3 = localObject6;
      localObject2 = localObject5;
      localObject1 = localObject8;
      break;
      if (localObject1 == null)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(localObject2.a).append("\n").append(locale.a);
        localObject7 = localSpannableStringBuilder;
        localObject5 = localObject2;
        localObject6 = localObject9;
      }
      else
      {
        localObject1.append("\n").append(locale.a);
        localObject7 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject9;
        continue;
        ((ArrayList)localObject9).add(locale);
        localObject7 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject9;
        continue;
        if (localObject1 != null)
          localObject3.add(new e(localObject1));
        while (localObject3 != null)
        {
          return localObject3;
          if (localObject2 != null)
            localObject3.add(localObject2);
        }
        return Collections.emptyList();
        label274: localObject9 = localObject3;
        break label64;
        label281: Object localObject4 = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject3;
        localObject7 = localObject4;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h.i
 * JD-Core Version:    0.6.2
 */