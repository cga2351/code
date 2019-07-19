package com.viber.voip.vln;

import com.facebook.react.bridge.Promise;
import com.viber.voip.billing.IabInventory;
import java.util.ArrayList;
import org.onepf.oms.InAppBillingHelper.QueryProductDetailsFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;

final class a
  implements InAppBillingHelper.QueryProductDetailsFinishedListener
{
  private final ArrayList a;
  private final Promise b;

  a(ArrayList arg1, Promise arg2)
  {
  }

  public void onQueryProductDetailsFinished(IabResult arg1, IabInventory arg2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.a
 * JD-Core Version:    0.6.2
 */