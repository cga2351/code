package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ap;
import com.yandex.metrica.impl.bt;

public class ar extends ab
{
  private final String a;
  private final bt b;

  public ar(Context paramContext, y paramy, ap paramap, t paramt, bt parambt)
  {
    super(paramContext, mo.a(), paramap, paramy, paramt, new aq(parambt), new na());
    this.a = paramy.a();
    this.b = parambt;
  }

  public void a(t paramt)
  {
    try
    {
      super.a(paramt);
      this.b.a(this.a, paramt.b().o());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ar
 * JD-Core Version:    0.6.2
 */