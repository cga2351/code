package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.SubscriptionInfo;

public final class nn
{
  private final Integer a;
  private final Integer b;
  private final boolean c;
  private final String d;
  private final String e;

  @TargetApi(23)
  public nn(SubscriptionInfo paramSubscriptionInfo)
  {
    this.a = Integer.valueOf(paramSubscriptionInfo.getMcc());
    this.b = Integer.valueOf(paramSubscriptionInfo.getMnc());
    if (paramSubscriptionInfo.getDataRoaming() == i);
    while (true)
    {
      this.c = i;
      this.d = paramSubscriptionInfo.getCarrierName().toString();
      this.e = paramSubscriptionInfo.getIccId();
      return;
      i = 0;
    }
  }

  public nn(Integer paramInteger1, Integer paramInteger2, boolean paramBoolean, String paramString1, String paramString2)
  {
    this.a = paramInteger1;
    this.b = paramInteger2;
    this.c = paramBoolean;
    this.d = paramString1;
    this.e = paramString2;
  }

  public Integer a()
  {
    return this.a;
  }

  public Integer b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.nn
 * JD-Core Version:    0.6.2
 */