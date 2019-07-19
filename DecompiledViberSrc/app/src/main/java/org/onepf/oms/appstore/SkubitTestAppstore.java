package org.onepf.oms.appstore;

import android.content.Context;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.appstore.skubitUtils.SkubitTestIabHelper;
import org.onepf.oms.util.Utils;

public class SkubitTestAppstore extends SkubitAppstore
{
  public static final String SKUBIT_INSTALLER = "net.skubit.android";
  public static final String VENDING_ACTION = "net.skubit.android.billing.IBillingService.BIND";

  public SkubitTestAppstore(Context paramContext)
  {
    super(paramContext);
  }

  public String getAction()
  {
    return "net.skubit.android.billing.IBillingService.BIND";
  }

  public String getAppstoreName()
  {
    return "net.skubit.android";
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    try
    {
      if (this.mBillingService == null)
        this.mBillingService = new SkubitTestIabHelper(this.context, null, this);
      AppstoreInAppBillingService localAppstoreInAppBillingService = this.mBillingService;
      return localAppstoreInAppBillingService;
    }
    finally
    {
    }
  }

  public String getInstaller()
  {
    return "net.skubit.android";
  }

  public boolean isPackageInstaller(String paramString)
  {
    return Utils.isPackageInstaller(this.context, "net.skubit.android");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.SkubitTestAppstore
 * JD-Core Version:    0.6.2
 */