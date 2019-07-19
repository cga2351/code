package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.g.a;
import java.util.Collections;
import java.util.List;

final class b
  implements e
{
  public static final b a = new b();
  private final List<com.google.android.exoplayer2.e.b> b;

  private b()
  {
    this.b = Collections.emptyList();
  }

  public b(com.google.android.exoplayer2.e.b paramb)
  {
    this.b = Collections.singletonList(paramb);
  }

  public int a(long paramLong)
  {
    if (paramLong < 0L)
      return 0;
    return -1;
  }

  public long a(int paramInt)
  {
    if (paramInt == 0);
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      return 0L;
    }
  }

  public int b()
  {
    return 1;
  }

  public List<com.google.android.exoplayer2.e.b> b(long paramLong)
  {
    if (paramLong >= 0L)
      return this.b;
    return Collections.emptyList();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.g.b
 * JD-Core Version:    0.6.2
 */