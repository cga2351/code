package com.viber.voip.billing;

import org.onepf.oms.InAppBillingHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Purchase;

final class k
  implements IabHelper.OnIabPurchaseFinishedListener
{
  private final OpenIabHelperWrapper.3 a;
  private final InAppBillingHelper.OnIabPurchaseFinishedListener b;
  private final IabProductId c;
  private final Runnable d;

  k(OpenIabHelperWrapper.3 arg1, InAppBillingHelper.OnIabPurchaseFinishedListener arg2, IabProductId arg3, Runnable arg4)
  {
  }

  public void onIabPurchaseFinished(IabResult arg1, Purchase arg2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.k
 * JD-Core Version:    0.6.2
 */