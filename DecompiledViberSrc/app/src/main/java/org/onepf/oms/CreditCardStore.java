package org.onepf.oms;

import android.content.Context;
import org.onepf.oms.appstore.CreditCardBillingService;

public class CreditCardStore extends DefaultAppstore
{
  private Context context;
  private volatile boolean mBillingAvailable = true;
  private AppstoreInAppBillingService mBillingService;

  public CreditCardStore(Context paramContext)
  {
    this.context = paramContext;
    this.mBillingService = new CreditCardBillingService(paramContext);
  }

  public String getAppstoreName()
  {
    return "credit.card";
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    return this.mBillingService;
  }

  public int getPackageVersion(String paramString)
  {
    return 0;
  }

  public boolean isBillingAvailable(String paramString)
  {
    return this.mBillingAvailable;
  }

  public boolean isPackageInstaller(String paramString)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.CreditCardStore
 * JD-Core Version:    0.6.2
 */