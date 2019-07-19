package com.yandex.metrica.impl;

import com.yandex.metrica.impl.ob.bi;
import com.yandex.metrica.impl.ob.bk;
import com.yandex.metrica.impl.ob.bn;
import com.yandex.metrica.impl.ob.bo;
import com.yandex.metrica.impl.ob.nc;

public class q<C extends bi> extends bv<C>
{
  private final bo d;
  private boolean e = false;

  public q(C paramC, nc paramnc, ap paramap, bo parambo)
  {
    super(paramC, paramnc, paramap);
    this.d = parambo;
  }

  public void a(i parami)
  {
    if (!this.e)
    {
      super.e();
      bk localbk = new bk((bn)f(), parami, this.d);
      this.b.a(localbk);
    }
  }

  public void close()
  {
    this.e = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.q
 * JD-Core Version:    0.6.2
 */