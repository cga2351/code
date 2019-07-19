package com.google.a.a.f.a;

final class d
{
  private static final ThreadLocal<char[]> a = new ThreadLocal()
  {
    protected char[] a()
    {
      return new char[1024];
    }
  };

  static char[] a()
  {
    return (char[])a.get();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.a.d
 * JD-Core Version:    0.6.2
 */