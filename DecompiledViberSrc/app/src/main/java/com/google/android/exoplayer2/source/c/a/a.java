package com.google.android.exoplayer2.source.c.a;

import com.google.android.exoplayer2.f.aa.a;
import com.google.android.exoplayer2.offline.b;
import com.google.android.exoplayer2.offline.c;
import java.util.Collections;
import java.util.List;

public final class a
  implements h
{
  private final List<c> a;

  public a()
  {
    this(Collections.emptyList());
  }

  public a(List<c> paramList)
  {
    this.a = paramList;
  }

  public aa.a<f> a()
  {
    return new b(new g(), this.a);
  }

  public aa.a<f> a(d paramd)
  {
    return new b(new g(paramd), this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.a
 * JD-Core Version:    0.6.2
 */