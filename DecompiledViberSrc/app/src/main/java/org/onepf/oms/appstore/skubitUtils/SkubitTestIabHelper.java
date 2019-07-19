package org.onepf.oms.appstore.skubitUtils;

import android.content.Context;
import android.content.Intent;
import org.onepf.oms.Appstore;

public class SkubitTestIabHelper extends SkubitIabHelper
{
  public SkubitTestIabHelper(Context paramContext, String paramString, Appstore paramAppstore)
  {
    super(paramContext, paramString, paramAppstore);
  }

  protected Intent getServiceIntent()
  {
    Intent localIntent = new Intent("net.skubit.android.billing.IBillingService.BIND");
    localIntent.setPackage("net.skubit.android");
    return localIntent;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.skubitUtils.SkubitTestIabHelper
 * JD-Core Version:    0.6.2
 */