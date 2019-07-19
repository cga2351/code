package com.google.a.a.c;

import com.google.a.a.f.ad;
import com.google.a.a.f.z;
import java.io.IOException;

public class t extends IOException
{
  private final int a;
  private final String b;
  private final transient m c;
  private final String d;

  public t(s params)
  {
    this(new a(params));
  }

  protected t(a parama)
  {
    super(parama.e);
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
  }

  public static StringBuilder a(s params)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = params.d();
    if (i != 0)
      localStringBuilder.append(i);
    String str = params.e();
    if (str != null)
    {
      if (i != 0)
        localStringBuilder.append(' ');
      localStringBuilder.append(str);
    }
    return localStringBuilder;
  }

  public static class a
  {
    int a;
    String b;
    m c;
    String d;
    String e;

    public a(int paramInt, String paramString, m paramm)
    {
      a(paramInt);
      b(paramString);
      a(paramm);
    }

    public a(s params)
    {
      this(params.d(), params.e(), params.b());
      try
      {
        this.d = params.j();
        if (this.d.length() == 0)
          this.d = null;
        StringBuilder localStringBuilder = t.a(params);
        if (this.d != null)
          localStringBuilder.append(ad.a).append(this.d);
        this.e = localStringBuilder.toString();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
    }

    public a a(int paramInt)
    {
      if (paramInt >= 0);
      for (boolean bool = true; ; bool = false)
      {
        z.a(bool);
        this.a = paramInt;
        return this;
      }
    }

    public a a(m paramm)
    {
      this.c = ((m)z.a(paramm));
      return this;
    }

    public a a(String paramString)
    {
      this.e = paramString;
      return this;
    }

    public a b(String paramString)
    {
      this.b = paramString;
      return this;
    }

    public a c(String paramString)
    {
      this.d = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.t
 * JD-Core Version:    0.6.2
 */