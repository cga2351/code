package f;

import javax.annotation.Nullable;

final class q
{

  @Nullable
  static p a;
  static long b;

  static p a()
  {
    try
    {
      if (a != null)
      {
        p localp = a;
        a = localp.f;
        localp.f = null;
        b -= 8192L;
        return localp;
      }
      return new p();
    }
    finally
    {
    }
  }

  static void a(p paramp)
  {
    if ((paramp.f != null) || (paramp.g != null))
      throw new IllegalArgumentException();
    if (paramp.d)
      return;
    try
    {
      if (8192L + b > 65536L)
        return;
    }
    finally
    {
    }
    b = 8192L + b;
    paramp.f = a;
    paramp.c = 0;
    paramp.b = 0;
    a = paramp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.q
 * JD-Core Version:    0.6.2
 */