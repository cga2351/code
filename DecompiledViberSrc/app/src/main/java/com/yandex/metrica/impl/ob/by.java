package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.i;

public class by<T extends bx, C extends w> extends bp<T, C>
{
  public by(bv<T> parambv, C paramC)
  {
    super(parambv, paramC);
  }

  public boolean a(i parami, final az paramaz)
  {
    return a(parami, new bp.a()
    {
      public boolean a(T paramAnonymousT, i paramAnonymousi)
      {
        return paramAnonymousT.a(paramAnonymousi, paramaz);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.by
 * JD-Core Version:    0.6.2
 */