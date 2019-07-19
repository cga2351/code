package com.google.android.exoplayer2.e.d;

import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import java.util.Collections;
import java.util.List;

final class b
  implements e
{
  private final com.google.android.exoplayer2.e.b[] a;
  private final long[] b;

  public b(com.google.android.exoplayer2.e.b[] paramArrayOfb, long[] paramArrayOfLong)
  {
    this.a = paramArrayOfb;
    this.b = paramArrayOfLong;
  }

  public int a(long paramLong)
  {
    int i = ag.b(this.b, paramLong, false, false);
    if (i < this.b.length)
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
      if (paramInt >= this.b.length)
        break label37;
    }
    while (true)
    {
      a.a(bool1);
      return this.b[paramInt];
      bool2 = false;
      break;
      label37: bool1 = false;
    }
  }

  public int b()
  {
    return this.b.length;
  }

  public List<com.google.android.exoplayer2.e.b> b(long paramLong)
  {
    int i = ag.a(this.b, paramLong, true, false);
    if ((i == -1) || (this.a[i] == null))
      return Collections.emptyList();
    return Collections.singletonList(this.a[i]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d.b
 * JD-Core Version:    0.6.2
 */