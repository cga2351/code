package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.g.t;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface v extends h
{
  public static final t<String> a = x.a;

  public static abstract class a
    implements v.b
  {
    private final v.f a = new v.f();

    public final v b()
    {
      return b(this.a);
    }

    protected abstract v b(v.f paramf);
  }

  public static abstract interface b extends h.a
  {
  }

  public static class c extends IOException
  {
    public final int a;
    public final l b;

    public c(IOException paramIOException, l paraml, int paramInt)
    {
      super();
      this.b = paraml;
      this.a = paramInt;
    }

    public c(String paramString, l paraml, int paramInt)
    {
      super();
      this.b = paraml;
      this.a = paramInt;
    }

    public c(String paramString, IOException paramIOException, l paraml, int paramInt)
    {
      super(paramIOException);
      this.b = paraml;
      this.a = paramInt;
    }
  }

  public static final class d extends v.c
  {
    public final String c;

    public d(String paramString, l paraml)
    {
      super(paraml, 1);
      this.c = paramString;
    }
  }

  public static final class e extends v.c
  {
    public final int c;
    public final String d;
    public final Map<String, List<String>> e;

    public e(int paramInt, String paramString, Map<String, List<String>> paramMap, l paraml)
    {
      super(paraml, 1);
      this.c = paramInt;
      this.d = paramString;
      this.e = paramMap;
    }
  }

  public static final class f
  {
    private final Map<String, String> a = new HashMap();
    private Map<String, String> b;

    public Map<String, String> a()
    {
      try
      {
        if (this.b == null)
          this.b = Collections.unmodifiableMap(new HashMap(this.a));
        Map localMap = this.b;
        return localMap;
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.v
 * JD-Core Version:    0.6.2
 */