package com.crashlytics.android.a;

import c.a.a.a.a.c.a.b;
import c.a.a.a.a.c.a.c;
import c.a.a.a.a.c.a.e;
import c.a.a.a.a.d.f;
import java.io.File;
import java.util.List;

class j
  implements f
{
  private final aa a;
  private final x b;

  j(aa paramaa, x paramx)
  {
    this.a = paramaa;
    this.b = paramx;
  }

  public static j a(aa paramaa)
  {
    return new j(paramaa, new x(new e(new w(new c(1000L, 8), 0.1D), new b(5))));
  }

  public boolean a(List<File> paramList)
  {
    long l = System.nanoTime();
    boolean bool1 = this.b.a(l);
    boolean bool2 = false;
    if (bool1)
    {
      if (this.a.a(paramList))
      {
        this.b.a();
        bool2 = true;
      }
    }
    else
      return bool2;
    this.b.b(l);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.j
 * JD-Core Version:    0.6.2
 */