package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s.a;

public class cr extends ci
{
  private fu a;

  public cr(ab paramab)
  {
    this(paramab, paramab.B());
  }

  cr(ab paramab, fu paramfu)
  {
    super(paramab);
    this.a = paramfu;
  }

  public boolean a(i parami)
  {
    ab localab = a();
    if (!this.a.c())
      if (!localab.l().L())
        break label71;
    label71: for (i locali = i.a(parami, s.a.F); ; locali = i.a(parami, s.a.b))
    {
      localab.d(locali.c(this.a.d("")));
      localab.a(true);
      this.a.a();
      this.a.e();
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.cr
 * JD-Core Version:    0.6.2
 */