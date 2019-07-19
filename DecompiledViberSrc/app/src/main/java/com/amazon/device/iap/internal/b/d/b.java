package com.amazon.device.iap.internal.b.d;

import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.b.i;

abstract class b extends i
{
  protected final boolean a;

  b(e parame, String paramString, boolean paramBoolean)
  {
    super(parame, "purchase_updates", paramString);
    this.a = paramBoolean;
  }

  protected void preExecution()
    throws KiwiException
  {
    super.preExecution();
    String str = (String)b().d().a("userId");
    if (this.a);
    for (Object localObject = null; ; localObject = com.amazon.device.iap.internal.util.b.a(str))
    {
      a("cursor", localObject);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.d.b
 * JD-Core Version:    0.6.2
 */