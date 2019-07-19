package com.viber.common.a;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class f
{
  private static final String a = "release-tag";
  private static final a b = new b();
  private static final Pattern c = null;
  private static a d;
  private static final ReentrantLock e = new ReentrantLock();
  private static volatile Context f;
  private static volatile a g;

  public static e a()
  {
    try
    {
      e locale = (e)Class.forName("com.viber.voip.ViberEnv").getMethod("getLogger", new Class[0]).invoke(null, new Object[0]);
      return locale;
    }
    catch (Throwable localThrowable)
    {
    }
    return b();
  }

  public static e a(String paramString)
  {
    return new b(d(), paramString);
  }

  public static void a(Context paramContext, a parama)
  {
    f = paramContext.getApplicationContext();
    g = parama;
  }

  public static e b()
  {
    return a(e());
  }

  public static a c()
  {
    return g;
  }

  private static a d()
  {
    if (d == null)
      d = b;
    return d;
  }

  private static String e()
  {
    return "release-tag";
  }

  static abstract interface a
  {
    public abstract void a(e.a parama, String paramString1, String paramString2, Throwable paramThrowable);

    public abstract boolean a(e.a parama);
  }

  private static class b
    implements e
  {
    private final String a;
    private final f.a b;

    public b(f.a parama, String paramString)
    {
      this.b = parama;
      this.a = paramString;
    }

    public String a()
    {
      return this.a;
    }

    public void a(String paramString, Object[] paramArrayOfObject)
    {
      if (this.b.a(e.a.a))
        this.b.a(e.a.a, this.a, c.a(paramString, paramArrayOfObject), null);
    }

    public void a(Throwable paramThrowable, String paramString)
    {
      if (this.b.a(e.a.e))
        this.b.a(e.a.e, this.a, paramString, paramThrowable);
    }

    public void a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
      if (this.b.a(e.a.d))
        this.b.a(e.a.d, this.a, c.a(paramString, paramArrayOfObject), paramThrowable);
    }

    public void b(String paramString, Object[] paramArrayOfObject)
    {
      if (this.b.a(e.a.b))
        this.b.a(e.a.b, this.a, c.a(paramString, paramArrayOfObject), null);
    }

    public void b(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
      if (this.b.a(e.a.e))
        this.b.a(e.a.e, this.a, c.a(paramString, paramArrayOfObject), paramThrowable);
    }

    public void c(String paramString, Object[] paramArrayOfObject)
    {
      if (this.b.a(e.a.c))
        this.b.a(e.a.c, this.a, c.a(paramString, paramArrayOfObject), null);
    }

    public void d(String paramString, Object[] paramArrayOfObject)
    {
      if (this.b.a(e.a.d))
        this.b.a(e.a.d, this.a, c.a(paramString, paramArrayOfObject), null);
    }

    public void e(String paramString, Object[] paramArrayOfObject)
    {
      if (this.b.a(e.a.e))
        this.b.a(e.a.e, this.a, c.a(paramString, paramArrayOfObject), null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.a.f
 * JD-Core Version:    0.6.2
 */