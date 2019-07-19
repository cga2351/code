package org.onepf.oms;

import android.content.Intent;

public abstract interface Appstore
{
  public static final int PACKAGE_VERSION_UNDEFINED = -1;

  public abstract boolean areOutsideLinksAllowed();

  public abstract String getAppstoreName();

  public abstract AppstoreInAppBillingService getInAppBillingService();

  public abstract int getPackageVersion(String paramString);

  public abstract Intent getProductPageIntent(String paramString);

  public abstract Intent getRateItPageIntent(String paramString);

  public abstract Intent getSameDeveloperPageIntent(String paramString);

  public abstract boolean isBillingAvailable(String paramString);

  public abstract boolean isPackageInstaller(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.Appstore
 * JD-Core Version:    0.6.2
 */