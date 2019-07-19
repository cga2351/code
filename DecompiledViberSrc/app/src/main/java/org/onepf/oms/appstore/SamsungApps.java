package org.onepf.oms.appstore;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.concurrent.CountDownLatch;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.DefaultAppstore;
import org.onepf.oms.OpenIabHelper.Options;
import org.onepf.oms.SkuManager;
import org.onepf.oms.appstore.googleUtils.IabException;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.util.CollectionUtils;
import org.onepf.oms.util.Utils;

public class SamsungApps extends DefaultAppstore
{
  public static final String IAP_PACKAGE_NAME = "com.sec.android.iap";
  public static final String IAP_SERVICE_NAME = "com.sec.android.iap.service.iapService";
  private static final int IAP_SIGNATURE_HASHCODE = 2055122763;
  private static final Logger L = ViberEnv.getLogger();
  public static final String SAMSUNG_INSTALLER = "com.sec.android.app.samsungapps";
  public static boolean isSamsungTestMode;
  private Activity activity;
  private AppstoreInAppBillingService billingService;
  private Boolean isBillingAvailable;
  private OpenIabHelper.Options options;

  public SamsungApps(Activity paramActivity, OpenIabHelper.Options paramOptions)
  {
    this.activity = paramActivity;
    this.options = paramOptions;
  }

  public static void checkSku(String paramString)
  {
    String[] arrayOfString = paramString.split("/");
    if (arrayOfString.length != 2)
      throw new SamsungSkuFormatException("Samsung SKU must contain ITEM_GROUP_ID and ITEM_ID.");
    String str1 = arrayOfString[0];
    String str2 = arrayOfString[1];
    if ((TextUtils.isEmpty(str1)) || (!TextUtils.isDigitsOnly(str1)))
      throw new SamsungSkuFormatException("Samsung SKU must contain numeric ITEM_GROUP_ID.");
    if (TextUtils.isEmpty(str2))
      throw new SamsungSkuFormatException("Samsung SKU must contain ITEM_ID.");
  }

  public String getAppstoreName()
  {
    return "com.samsung.apps";
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    if (this.billingService == null)
      this.billingService = new SamsungAppsBillingService(this.activity, this.options);
    return this.billingService;
  }

  public int getPackageVersion(String paramString)
  {
    return -1;
  }

  public boolean isBillingAvailable(String paramString)
  {
    boolean bool;
    if (this.isBillingAvailable != null)
      bool = this.isBillingAvailable.booleanValue();
    while (true)
    {
      return bool;
      if (Utils.uiThread())
        throw new IllegalStateException("Must no be called from UI thread.");
      try
      {
        this.activity.getPackageManager().getApplicationInfo("com.sec.android.iap", 128);
        int j = this.activity.getPackageManager().getPackageInfo("com.sec.android.iap", 64).signatures[0].hashCode();
        if (j == 2055122763)
        {
          i = 1;
          bool = false;
          if (i == 0)
            continue;
          if (isSamsungTestMode)
          {
            this.isBillingAvailable = Boolean.valueOf(true);
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          int i = 0;
          continue;
          this.isBillingAvailable = Boolean.valueOf(false);
          final CountDownLatch localCountDownLatch = new CountDownLatch(1);
          getInAppBillingService().startSetup(new IabHelper.OnIabSetupFinishedListener()
          {
            public void onIabSetupFinished(IabResult paramAnonymousIabResult)
            {
              if (paramAnonymousIabResult.isSuccess())
              {
                new Thread(new Runnable()
                {
                  public void run()
                  {
                    try
                    {
                      Inventory localInventory = SamsungApps.this.getInAppBillingService().queryInventory(true, SkuManager.getInstance().getAllStoreSkus("com.samsung.apps"), null);
                      if ((localInventory != null) && (!CollectionUtils.isEmpty(localInventory.getAllOwnedSkus())))
                        SamsungApps.access$002(SamsungApps.this, Boolean.valueOf(true));
                      return;
                    }
                    catch (IabException localIabException)
                    {
                    }
                    finally
                    {
                      SamsungApps.this.getInAppBillingService().dispose();
                      SamsungApps.1.this.val$mainLatch.countDown();
                    }
                  }
                }).start();
                return;
              }
              SamsungApps.this.getInAppBillingService().dispose();
              localCountDownLatch.countDown();
            }
          });
          try
          {
            localCountDownLatch.await();
            label155: return this.isBillingAvailable.booleanValue();
          }
          catch (InterruptedException localInterruptedException)
          {
            break label155;
          }
          i = 0;
        }
      }
    }
  }

  public boolean isPackageInstaller(String paramString)
  {
    return (Utils.isPackageInstaller(this.activity, "com.sec.android.app.samsungapps")) || (isSamsungTestMode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.SamsungApps
 * JD-Core Version:    0.6.2
 */