package com.yandex.metrica.impl;

import android.os.SystemClock;

class u
{
  private long a = SystemClock.elapsedRealtime() - 2000000L;
  private boolean b = true;

  boolean a()
  {
    boolean bool1 = this.b;
    this.b = false;
    long l = SystemClock.elapsedRealtime() - this.a;
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = l < 1000L;
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    return bool2;
  }

  void b()
  {
    this.b = true;
    this.a = SystemClock.elapsedRealtime();
  }

  boolean c()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.u
 * JD-Core Version:    0.6.2
 */