package com.viber.voip.util.g.a;

public final class f
{
  private static final g a = new g();
  private static h b;
  private static c c;
  private static b d;

  public static e a(int paramInt)
  {
    return c(paramInt);
  }

  public static e a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2:
    case 4:
    case 5:
    case 6:
    default:
      return a;
    case 0:
      return new h(paramInt2);
    case 1:
    case 3:
      return new c(paramInt2);
    case 7:
    case 8:
    }
    return new b(paramInt2);
  }

  public static e b(int paramInt)
  {
    return new d(paramInt);
  }

  private static e c(int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    case 4:
    case 5:
    case 6:
    default:
      return a;
    case 0:
      if (b == null)
        b = new h(11);
      return b;
    case 1:
    case 3:
      if (c == null)
        c = new c(11);
      return c;
    case 7:
    case 8:
    }
    if (d == null)
      d = new b(11);
    return d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.g.a.f
 * JD-Core Version:    0.6.2
 */