package com.yandex.metrica.impl.ob;

import java.util.Locale;

public class lv
  implements lx
{
  int a = 0;
  private final int b;
  private boolean c;
  private final String d;

  public lv(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.d = String.format(Locale.US, "[NoSleepRetryPolicy][%s]", new Object[] { paramString });
  }

  void a()
  {
    this.a = (1 + this.a);
    this.c = false;
  }

  public boolean b()
  {
    if ((this.c) && (this.a < this.b));
    for (int i = 1; i != 0; i = 0)
    {
      a();
      return true;
    }
    return false;
  }

  public void c()
  {
    this.c = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lv
 * JD-Core Version:    0.6.2
 */