package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.bw;

public class dw
{
  private final du a;
  private final dv b;
  private final fe c;
  private final String d;

  public dw(Context paramContext, y paramy)
  {
    this(new dv(), new du(), fj.a(paramContext).c(paramy), "event_hashes");
  }

  dw(dv paramdv, du paramdu, fe paramfe, String paramString)
  {
    this.b = paramdv;
    this.a = paramdu;
    this.c = paramfe;
    this.d = paramString;
  }

  public dt a()
  {
    try
    {
      byte[] arrayOfByte = this.c.a(this.d);
      if (bw.a(arrayOfByte))
        return this.a.a(this.b.a());
      dt localdt = this.a.a(this.b.a(arrayOfByte));
      return localdt;
    }
    catch (Exception localException)
    {
    }
    return this.a.a(this.b.a());
  }

  public void a(dt paramdt)
  {
    this.c.a(this.d, this.b.a(this.a.a(paramdt)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.dw
 * JD-Core Version:    0.6.2
 */