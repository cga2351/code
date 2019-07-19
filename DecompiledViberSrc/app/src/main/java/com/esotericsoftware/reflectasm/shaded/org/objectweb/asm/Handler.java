package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

class Handler
{
  Label a;
  Label b;
  Label c;
  String d;
  int e;
  Handler f;

  static Handler a(Handler paramHandler, Label paramLabel1, Label paramLabel2)
  {
    if (paramHandler == null)
      paramHandler = null;
    int j;
    int m;
    while (true)
    {
      return paramHandler;
      paramHandler.f = a(paramHandler.f, paramLabel1, paramLabel2);
      int i = paramHandler.a.c;
      j = paramHandler.b.c;
      int k = paramLabel1.c;
      if (paramLabel2 == null);
      for (m = 2147483647; (k < j) && (m > i); m = paramLabel2.c)
      {
        if (k > i)
          break label99;
        if (m < j)
          break label92;
        return paramHandler.f;
      }
    }
    label92: paramHandler.a = paramLabel2;
    return paramHandler;
    label99: if (m >= j)
    {
      paramHandler.b = paramLabel1;
      return paramHandler;
    }
    Handler localHandler = new Handler();
    localHandler.a = paramLabel2;
    localHandler.b = paramHandler.b;
    localHandler.c = paramHandler.c;
    localHandler.d = paramHandler.d;
    localHandler.e = paramHandler.e;
    localHandler.f = paramHandler.f;
    paramHandler.b = paramLabel1;
    paramHandler.f = localHandler;
    return paramHandler;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Handler
 * JD-Core Version:    0.6.2
 */