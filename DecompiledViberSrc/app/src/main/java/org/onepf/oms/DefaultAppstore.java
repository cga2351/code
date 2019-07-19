package org.onepf.oms;

import android.content.Intent;

public abstract class DefaultAppstore
  implements Appstore
{
  public boolean areOutsideLinksAllowed()
  {
    return false;
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    return null;
  }

  public Intent getProductPageIntent(String paramString)
  {
    return null;
  }

  public Intent getRateItPageIntent(String paramString)
  {
    return null;
  }

  public Intent getSameDeveloperPageIntent(String paramString)
  {
    return null;
  }

  public String toString()
  {
    return "Store {name: " + getAppstoreName() + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.DefaultAppstore
 * JD-Core Version:    0.6.2
 */