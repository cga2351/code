package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ap;
import com.yandex.metrica.impl.bs;

public class nb<C extends ag>
  implements nc
{
  private final mo a;
  private final C b;

  public nb(C paramC, mo parammo)
  {
    this.b = paramC;
    this.a = parammo;
  }

  public void a(ap paramap)
  {
    bs localbs = this.a.a(this.b, this.b.a());
    if (localbs != null)
      paramap.a(localbs);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.nb
 * JD-Core Version:    0.6.2
 */