package org.onepf.oms.appstore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.DefaultAppstore;
import org.onepf.oms.appstore.googleBillingUtils.BillingClientHelper;
import org.onepf.oms.util.CollectionUtils;
import org.onepf.oms.util.Utils;

public class GooglePlayClient extends DefaultAppstore
{
  private static final Logger L = ViberEnv.getLogger();
  private volatile Boolean billingAvailable = null;
  private Context context;
  private final boolean isDebugMode = false;
  private AppstoreInAppBillingService mBillingService;
  private String publicKey;

  public GooglePlayClient(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.publicKey = paramString;
  }

  private AppstoreInAppBillingService createBillingService()
  {
    return BillingClientHelper.getInstance(this.context, this.publicKey, this);
  }

  private boolean packageExists(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public String getAppstoreName()
  {
    return "com.google.play.client";
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    if (this.mBillingService == null)
      this.mBillingService = createBillingService();
    return this.mBillingService;
  }

  public int getPackageVersion(String paramString)
  {
    return -1;
  }

  public boolean isBillingAvailable(String paramString)
  {
    if (this.billingAvailable != null)
      return this.billingAvailable.booleanValue();
    if (Utils.uiThread())
      throw new IllegalStateException("Must no be called from UI thread.");
    this.billingAvailable = Boolean.valueOf(false);
    if ((packageExists(this.context, "com.android.vending")) || (packageExists(this.context, "com.google.vending")))
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      if (!CollectionUtils.isEmpty(this.context.getPackageManager().queryIntentServices(localIntent, 0)))
        this.billingAvailable = Boolean.valueOf(true);
    }
    return this.billingAvailable.booleanValue();
  }

  public boolean isPackageInstaller(String paramString)
  {
    return Utils.isPackageInstaller(this.context, "com.android.vending");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.GooglePlayClient
 * JD-Core Version:    0.6.2
 */