package com.google.android.exoplayer2.e.f;

import com.google.android.exoplayer2.g.ag;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class f
  implements com.google.android.exoplayer2.e.e
{
  private final b a;
  private final long[] b;
  private final Map<String, e> c;
  private final Map<String, c> d;
  private final Map<String, String> e;

  public f(b paramb, Map<String, e> paramMap, Map<String, c> paramMap1, Map<String, String> paramMap2)
  {
    this.a = paramb;
    this.d = paramMap1;
    this.e = paramMap2;
    if (paramMap != null);
    for (Map localMap = Collections.unmodifiableMap(paramMap); ; localMap = Collections.emptyMap())
    {
      this.c = localMap;
      this.b = paramb.b();
      return;
    }
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
    return this.b[paramInt];
  }

  public int b()
  {
    return this.b.length;
  }

  public List<com.google.android.exoplayer2.e.b> b(long paramLong)
  {
    return this.a.a(paramLong, this.c, this.d, this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.f.f
 * JD-Core Version:    0.6.2
 */