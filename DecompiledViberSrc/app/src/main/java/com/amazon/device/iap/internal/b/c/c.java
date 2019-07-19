package com.amazon.device.iap.internal.b.c;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import java.util.Set;

abstract class c extends i
{
  protected final Set<String> a;

  c(e parame, String paramString, Set<String> paramSet)
  {
    super(parame, "getItem_data", paramString);
    this.a = paramSet;
    a("skus", paramSet);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.c.c
 * JD-Core Version:    0.6.2
 */