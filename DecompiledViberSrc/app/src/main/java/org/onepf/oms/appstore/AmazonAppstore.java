package org.onepf.oms.appstore;

import android.content.Context;
import com.amazon.device.iap.PurchasingService;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.DefaultAppstore;
import org.onepf.oms.util.Utils;

public class AmazonAppstore extends DefaultAppstore
{
  public static final String AMAZON_INSTALLER = "com.amazon.venezia";
  private static final Logger L = ViberEnv.getLogger();
  private final Context context;
  private AmazonAppstoreBillingService mBillingService;

  public AmazonAppstore(Context paramContext)
  {
    this.context = paramContext;
  }

  // ERROR //
  public static boolean hasAmazonClasses()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 2
    //   5: invokevirtual 40	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   8: ldc 42
    //   10: invokevirtual 48	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: pop
    //   14: iconst_1
    //   15: istore_2
    //   16: ldc 2
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: athrow
    //   27: astore_1
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -14 -> 16
    //
    // Exception table:
    //   from	to	target	type
    //   3	14	21	finally
    //   16	19	21	finally
    //   22	25	21	finally
    //   3	14	27	java/lang/Throwable
  }

  public String getAppstoreName()
  {
    return "com.amazon.apps";
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    if (this.mBillingService == null)
      this.mBillingService = new AmazonAppstoreBillingService(this.context);
    return this.mBillingService;
  }

  public int getPackageVersion(String paramString)
  {
    return -1;
  }

  public boolean isBillingAvailable(String paramString)
  {
    boolean bool = isPackageInstaller(paramString);
    if (bool);
    return bool;
  }

  public boolean isPackageInstaller(String paramString)
  {
    if ((Utils.isPackageInstaller(this.context, "com.amazon.venezia")) || (hasAmazonClasses()));
    for (int i = 1; ; i = 0)
    {
      boolean bool;
      if (!PurchasingService.IS_SANDBOX_MODE)
      {
        bool = false;
        if (i == 0);
      }
      else
      {
        bool = true;
      }
      return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.AmazonAppstore
 * JD-Core Version:    0.6.2
 */