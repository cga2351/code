package com.yandex.metrica.impl;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.e;
import com.yandex.metrica.impl.ob.u;

class ae extends c
{
  ae(Context paramContext, u paramu, e parame, bj parambj)
  {
    super(paramContext, parambj, new bg(paramu, new CounterConfiguration(parame)));
    this.b.b().h(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ae
 * JD-Core Version:    0.6.2
 */