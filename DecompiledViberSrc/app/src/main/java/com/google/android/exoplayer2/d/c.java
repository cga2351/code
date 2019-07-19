package com.google.android.exoplayer2.d;

import java.util.Collections;
import java.util.List;

public abstract interface c
{
  public static final c a = new c()
  {
    public a a()
      throws d.b
    {
      return d.a();
    }

    public List<a> a(String paramAnonymousString, boolean paramAnonymousBoolean)
      throws d.b
    {
      List localList = d.b(paramAnonymousString, paramAnonymousBoolean);
      if (localList.isEmpty())
        return Collections.emptyList();
      return Collections.singletonList(localList.get(0));
    }
  };
  public static final c b = new c()
  {
    public a a()
      throws d.b
    {
      return d.a();
    }

    public List<a> a(String paramAnonymousString, boolean paramAnonymousBoolean)
      throws d.b
    {
      return d.b(paramAnonymousString, paramAnonymousBoolean);
    }
  };

  public abstract a a()
    throws d.b;

  public abstract List<a> a(String paramString, boolean paramBoolean)
    throws d.b;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.d.c
 * JD-Core Version:    0.6.2
 */