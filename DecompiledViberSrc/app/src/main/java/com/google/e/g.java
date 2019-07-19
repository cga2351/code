package com.google.e;

public final class g extends m
{
  private static final g c = new g();

  static
  {
    c.setStackTrace(b);
  }

  private g()
  {
  }

  private g(Throwable paramThrowable)
  {
    super(paramThrowable);
  }

  public static g a()
  {
    if (a)
      return new g();
    return c;
  }

  public static g a(Throwable paramThrowable)
  {
    if (a)
      return new g(paramThrowable);
    return c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g
 * JD-Core Version:    0.6.2
 */