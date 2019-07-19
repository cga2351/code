package org.onepf.oms;

import android.app.Activity;
import android.content.Intent;
import com.viber.voip.billing.IabInventory;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.Purchase;
import java.util.List;
import org.onepf.oms.appstore.googleUtils.IabResult;

public abstract interface InAppBillingHelper
{
  public abstract void consumeAsync(Purchase paramPurchase, OnConsumeFinishedListener paramOnConsumeFinishedListener);

  public abstract void consumeAsync(List<Purchase> paramList, OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener);

  public abstract void dispose();

  public abstract boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent);

  public abstract void launchPurchaseFlow(Activity paramActivity, IabProductId paramIabProductId, int paramInt, String paramString, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener);

  public abstract void launchPurchaseFlow(Activity paramActivity, IabProductId paramIabProductId, int paramInt, String paramString1, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2);

  public abstract void launchPurchaseFlow(Activity paramActivity, IabProductId paramIabProductId, String paramString1, int paramInt, String paramString2, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3);

  public abstract void launchSubscriptionPurchaseFlow(Activity paramActivity, IabProductId paramIabProductId, int paramInt, String paramString, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener);

  public abstract void launchSubscriptionPurchaseFlow(Activity paramActivity, IabProductId paramIabProductId, int paramInt, String paramString1, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2);

  public abstract void parentActivityResumed();

  public abstract void queryInventoryAsync(QueryInventoryFinishedListener paramQueryInventoryFinishedListener);

  public abstract void queryInventoryAsync(boolean paramBoolean, List<IabProductId> paramList, QueryInventoryFinishedListener paramQueryInventoryFinishedListener);

  public abstract void queryInventoryAsync(boolean paramBoolean, QueryInventoryFinishedListener paramQueryInventoryFinishedListener);

  public abstract void queryProductDetailsAsync(IabProductId paramIabProductId, QueryProductDetailsFinishedListener paramQueryProductDetailsFinishedListener);

  public abstract void queryProductDetailsAsync(List<IabProductId> paramList, QueryProductDetailsFinishedListener paramQueryProductDetailsFinishedListener);

  public abstract void setActivityListener(ActivityListener paramActivityListener);

  public abstract void startSetup(OnIabSetupFinishedListener paramOnIabSetupFinishedListener);

  public abstract boolean subscriptionsSupported();

  public static abstract interface ActivityListener
  {
    public abstract void onIabActivity();
  }

  public static abstract interface OnConsumeFinishedListener
  {
    public abstract void onConsumeFinished(Purchase paramPurchase, IabResult paramIabResult);
  }

  public static abstract interface OnConsumeMultiFinishedListener
  {
    public abstract void onConsumeMultiFinished(List<Purchase> paramList, List<IabResult> paramList1);
  }

  public static abstract interface OnIabPurchaseFinishedListener
  {
    public abstract void onIabPurchaseFinished(IabResult paramIabResult, Purchase paramPurchase);
  }

  public static abstract interface OnIabSetupFinishedListener
  {
    public abstract void onIabSetupFinished(IabResult paramIabResult);
  }

  public static abstract interface QueryInventoryFinishedListener
  {
    public abstract void onQueryInventoryFinished(IabResult paramIabResult, IabInventory paramIabInventory);
  }

  public static abstract interface QueryProductDetailsFinishedListener
  {
    public abstract void onQueryProductDetailsFinished(IabResult paramIabResult, IabInventory paramIabInventory);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.InAppBillingHelper
 * JD-Core Version:    0.6.2
 */