package com.viber.voip.messages.extensions.ui;

import com.viber.voip.messages.ui.aj;
import com.viber.voip.messages.ui.aj.a;
import com.viber.voip.util.da;

abstract class m
{
  private final aj a;

  protected m(aj paramaj)
  {
    this.a = paramaj;
  }

  public abstract int a();

  protected aj.a a(String paramString)
  {
    aj.a locala;
    if (da.a(paramString))
      locala = null;
    do
    {
      return locala;
      locala = this.a.a(paramString);
      if (locala == null)
        locala = this.a.b(paramString);
    }
    while ((locala != null) || (paramString.length() != 2) || (!Character.isHighSurrogate(paramString.charAt(0))));
    return this.a.a(paramString.codePointAt(0));
  }

  protected void a(b paramb, aj.a parama, String paramString, long paramLong)
  {
    if (parama != null)
      paramString = parama.b();
    paramb.a(paramString, paramLong);
  }

  public abstract void a(b paramb, String paramString);

  public abstract void b(b paramb, String paramString);

  public static class a extends m
  {
    protected a(aj paramaj)
    {
      super();
    }

    public int a()
    {
      return 2;
    }

    public void a(m.b paramb, String paramString)
    {
      aj.a locala = a(paramString);
      if (locala != null)
      {
        a(paramb, locala, paramString, 0L);
        return;
      }
      paramb.a();
    }

    public void b(m.b paramb, String paramString)
    {
      a(paramb, paramString);
    }
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(String paramString, long paramLong);
  }

  public static class c extends m
  {
    protected c(aj paramaj)
    {
      super();
    }

    public int a()
    {
      return 0;
    }

    public void a(m.b paramb, String paramString)
    {
      if ((paramString.length() >= 2) || (paramString.length() == 0))
        a(paramb, paramString, 500L);
    }

    protected void a(m.b paramb, String paramString, long paramLong)
    {
      a(paramb, null, paramString, paramLong);
    }

    public void b(m.b paramb, String paramString)
    {
      a(paramb, paramString, 0L);
    }
  }

  public static class d extends m.c
  {
    protected d(aj paramaj)
    {
      super();
    }

    public int a()
    {
      return 1;
    }

    protected void a(m.b paramb, String paramString, long paramLong)
    {
      a(paramb, a(paramString), paramString, paramLong);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.m
 * JD-Core Version:    0.6.2
 */