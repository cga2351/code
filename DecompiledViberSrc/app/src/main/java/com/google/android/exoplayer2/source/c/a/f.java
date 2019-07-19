package com.google.android.exoplayer2.source.c.a;

import com.google.android.exoplayer2.offline.a;
import java.util.Collections;
import java.util.List;

public abstract class f
  implements a<f>
{
  public final String n;
  public final List<String> o;
  public final boolean p;

  protected f(String paramString, List<String> paramList, boolean paramBoolean)
  {
    this.n = paramString;
    this.o = Collections.unmodifiableList(paramList);
    this.p = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.f
 * JD-Core Version:    0.6.2
 */