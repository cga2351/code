package org.onepf.oms;

import android.app.Activity;
import android.content.Intent;
import java.util.List;
import org.onepf.oms.appstore.googleUtils.IabException;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.appstore.googleUtils.Purchase;

public abstract interface AppstoreInAppBillingService
{
  public abstract void consume(Purchase paramPurchase)
    throws IabException;

  public abstract void dispose();

  public abstract boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent);

  public abstract void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4);

  public abstract Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException;

  public abstract void setProductsData(List<String> paramList);

  public abstract void startSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener);

  public abstract boolean subscriptionsSupported();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.AppstoreInAppBillingService
 * JD-Core Version:    0.6.2
 */