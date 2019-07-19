package com.viber.voip;

public class y
{
  private static Class<?> a;
  private static Class<?> b;
  private static Class<?> c;

  public static Class<?> a()
  {
    if (a == null)
      throw new IllegalStateException("HomeActivityClass not set");
    return a;
  }

  public static void a(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    a = paramClass1;
    b = paramClass2;
    c = paramClass3;
  }

  public static Class<?> b()
  {
    if (!c())
      throw new IllegalStateException("TabletHomeActivityClass not set");
    return b;
  }

  public static boolean c()
  {
    return b != null;
  }

  public static Class<?> d()
  {
    if (!e())
      throw new IllegalStateException("WelcomeActivityClass not set");
    return c;
  }

  public static boolean e()
  {
    return c != null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.y
 * JD-Core Version:    0.6.2
 */