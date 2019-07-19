package com.yandex.metrica.impl.ob;

import com.yandex.metrica.Revenue;
import java.util.Arrays;
import java.util.List;

public class qb
  implements px<Revenue>
{
  private final px<List<pv>> a = new pw();

  public pv a(Revenue paramRevenue)
  {
    px localpx = this.a;
    pv[] arrayOfpv = new pv[1];
    arrayOfpv[0] = new qa().a(paramRevenue.quantity);
    return localpx.a(Arrays.asList(arrayOfpv));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.qb
 * JD-Core Version:    0.6.2
 */