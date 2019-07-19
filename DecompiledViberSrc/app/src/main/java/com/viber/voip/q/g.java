package com.viber.voip.q;

public class g
{
  final String a;
  final int b;
  final int c;
  final long d;

  private g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong;
  }

  public static g a(String paramString, int paramInt)
  {
    return new g(paramString, 0, paramInt, 0L);
  }

  public static g a(String paramString, long paramLong)
  {
    return new g(paramString, 1, 0, paramLong);
  }

  public static g b(String paramString, long paramLong)
  {
    return new g(paramString, 2, 0, paramLong);
  }

  public static g c(String paramString, long paramLong)
  {
    return new g(paramString, 3, 0, paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.g
 * JD-Core Version:    0.6.2
 */