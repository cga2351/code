package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class BillingClientImpl$1 extends ResultReceiver
{
  BillingClientImpl$1(c paramc, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    i locali = c.a(this.this$0).b();
    if (locali == null)
    {
      com.android.billingclient.a.a.b("BillingClient", "PurchasesUpdatedListener is null - no way to return the response.");
      return;
    }
    locali.onPurchasesUpdated(paramInt, com.android.billingclient.a.a.a(paramBundle));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.BillingClientImpl.1
 * JD-Core Version:    0.6.2
 */