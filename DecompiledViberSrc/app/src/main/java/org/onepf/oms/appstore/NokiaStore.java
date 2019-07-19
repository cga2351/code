package org.onepf.oms.appstore;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.DefaultAppstore;
import org.onepf.oms.appstore.nokiaUtils.NokiaSkuFormatException;
import org.onepf.oms.appstore.nokiaUtils.NokiaStoreHelper;

public class NokiaStore extends DefaultAppstore
{
  private static final String EXPECTED_SHA1_FINGERPRINT = "C476A7D71C4CB92641A699C1F1CAC93CA81E0396";
  private static final Logger L = ViberEnv.getLogger();
  public static final String NOKIA_BILLING_PERMISSION = "com.nokia.payment.BILLING";
  public static final String NOKIA_INSTALLER = "com.nokia.payment.iapenabler";
  public static final String VENDING_ACTION = "com.nokia.payment.iapenabler.InAppBillingService.BIND";
  private NokiaStoreHelper billingService = null;
  private final Context context;

  public NokiaStore(Context paramContext)
  {
    this.context = paramContext;
  }

  public static void checkSku(String paramString)
  {
    if (!TextUtils.isDigitsOnly(paramString))
      throw new NokiaSkuFormatException();
  }

  private static byte[] hexStringToByteArray(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i / 2];
    for (int j = 0; j < i; j += 2)
      arrayOfByte[(j / 2)] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16)));
    return arrayOfByte;
  }

  private boolean verifyFingreprint()
  {
    try
    {
      PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo("com.nokia.payment.iapenabler", 64);
      if (localPackageInfo.signatures.length == 1)
      {
        byte[] arrayOfByte = localPackageInfo.signatures[0].toByteArray();
        boolean bool = Arrays.equals(MessageDigest.getInstance("SHA1").digest(arrayOfByte), hexStringToByteArray("C476A7D71C4CB92641A699C1F1CAC93CA81E0396"));
        if (bool)
          return true;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        localNameNotFoundException.printStackTrace();
    }
  }

  public String getAppstoreName()
  {
    return "com.nokia.nstore";
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    if (this.billingService == null)
      this.billingService = new NokiaStoreHelper(this.context, this);
    return this.billingService;
  }

  public int getPackageVersion(String paramString)
  {
    return -1;
  }

  public boolean isBillingAvailable(String paramString)
  {
    Iterator localIterator = this.context.getPackageManager().getInstalledPackages(0).iterator();
    while (localIterator.hasNext())
      if ("com.nokia.payment.iapenabler".equals(((PackageInfo)localIterator.next()).packageName))
        return verifyFingreprint();
    return false;
  }

  public boolean isPackageInstaller(String paramString)
  {
    return "com.nokia.payment.iapenabler".equals(this.context.getPackageManager().getInstallerPackageName(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.NokiaStore
 * JD-Core Version:    0.6.2
 */