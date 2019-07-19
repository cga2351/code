package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class BillingClientImpl$3 extends ResultReceiver
{
  BillingClientImpl$3(c paramc, Handler paramHandler, g paramg)
  {
    super(paramHandler);
  }

  public void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    this.val$listener.a(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.BillingClientImpl.3
 * JD-Core Version:    0.6.2
 */