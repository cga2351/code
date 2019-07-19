package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.ResultReceiver;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.k;

public class az
  implements ax, mt
{
  private final Context a;
  private w b;
  private volatile ResultReceiver c;

  public az(Context paramContext, w paramw, t paramt)
  {
    this.a = paramContext;
    this.b = paramw;
    this.c = paramt.b().a();
    this.b.a(this);
  }

  public void a()
  {
    this.b.b(this);
  }

  public void a(i parami, t paramt)
  {
    if (!this.b.d())
    {
      this.b.a(paramt);
      this.c = paramt.b().a();
      this.b.a(parami, this);
    }
  }

  public void a(mq parammq)
  {
    k.a(this.c, parammq);
  }

  public void a(mw parammw)
  {
    k.a(this.c, parammw);
  }

  public w b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.az
 * JD-Core Version:    0.6.2
 */