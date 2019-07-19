package com.amazon.device.iap.internal.b.f;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.h;

public final class c extends a
{
  public c(e parame, boolean paramBoolean)
  {
    super(parame, "2.0");
    a("receiptDelivered", Boolean.valueOf(paramBoolean));
  }

  public void a_()
  {
    Object localObject = b().d().a("notifyListenerResult");
    if ((localObject != null) && (Boolean.TRUE.equals(localObject)))
      a("notifyListenerSucceeded", Boolean.valueOf(true));
    while (true)
    {
      super.a_();
      return;
      a("notifyListenerSucceeded", Boolean.valueOf(false));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.f.c
 * JD-Core Version:    0.6.2
 */