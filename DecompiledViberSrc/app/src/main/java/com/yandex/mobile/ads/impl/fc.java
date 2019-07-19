package com.yandex.mobile.ads.impl;

import com.yandex.metrica.IReporter;

final class fc
  implements ah.a
{
  private IReporter a;

  public fc(ah paramah)
  {
    paramah.a(this);
  }

  final void a(IReporter paramIReporter)
  {
    this.a = paramIReporter;
  }

  public final void a(et paramet)
  {
    if (this.a != null)
    {
      boolean bool = paramet.c();
      this.a.setStatisticsSending(bool);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fc
 * JD-Core Version:    0.6.2
 */