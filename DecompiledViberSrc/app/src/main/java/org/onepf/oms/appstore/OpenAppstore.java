package org.onepf.oms.appstore;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.List;
import org.onepf.oms.Appstore;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.DefaultAppstore;
import org.onepf.oms.IOpenAppstore;
import org.onepf.oms.IOpenInAppBillingService;
import org.onepf.oms.IOpenInAppBillingService.Stub;
import org.onepf.oms.appstore.googleBillingUtils.BillingClientHelper;
import org.onepf.oms.appstore.googleUtils.IabHelper;

public class OpenAppstore extends DefaultAppstore
{
  private static final Logger L = ViberEnv.getLogger();
  private final String appstoreName;
  public ComponentName componentName;
  private Context context;
  private AppstoreInAppBillingService mBillingService;
  private IOpenAppstore openAppstoreService;
  private ServiceConnection serviceConn;

  public OpenAppstore(Context paramContext, String paramString1, IOpenAppstore paramIOpenAppstore, Intent paramIntent, String paramString2, ServiceConnection paramServiceConnection)
  {
    this.context = paramContext;
    this.appstoreName = paramString1;
    this.openAppstoreService = paramIOpenAppstore;
    this.serviceConn = paramServiceConnection;
    if (paramIntent != null)
      this.mBillingService = createBillingService(paramString2, paramIntent);
  }

  private AppstoreInAppBillingService createBillingService(String paramString, final Intent paramIntent)
  {
    if ("com.google.play.client".equalsIgnoreCase(this.appstoreName))
      return BillingClientHelper.getInstance(this.context, paramString, this);
    return new IabHelper(this.context, paramString, this)
    {
      public void dispose()
      {
        super.dispose();
        OpenAppstore.this.context.unbindService(OpenAppstore.this.serviceConn);
      }

      protected IInAppBillingService getServiceFromBinder(IBinder paramAnonymousIBinder)
      {
        return new OpenAppstore.IOpenInAppBillingWrapper(IOpenInAppBillingService.Stub.asInterface(paramAnonymousIBinder), null);
      }

      protected Intent getServiceIntent()
      {
        return paramIntent;
      }
    };
  }

  public boolean areOutsideLinksAllowed()
  {
    try
    {
      boolean bool = this.openAppstoreService.areOutsideLinksAllowed();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return false;
  }

  public String getAppstoreName()
  {
    return this.appstoreName;
  }

  public AppstoreInAppBillingService getInAppBillingService()
  {
    return this.mBillingService;
  }

  public int getPackageVersion(String paramString)
  {
    try
    {
      int i = this.openAppstoreService.getPackageVersion(paramString);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return -1;
  }

  public Intent getProductPageIntent(String paramString)
  {
    try
    {
      Intent localIntent = this.openAppstoreService.getProductPageIntent(paramString);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return null;
  }

  public Intent getRateItPageIntent(String paramString)
  {
    try
    {
      Intent localIntent = this.openAppstoreService.getRateItPageIntent(paramString);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return null;
  }

  public Intent getSameDeveloperPageIntent(String paramString)
  {
    try
    {
      Intent localIntent = this.openAppstoreService.getSameDeveloperPageIntent(paramString);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return null;
  }

  public boolean isBillingAvailable(String paramString)
  {
    try
    {
      boolean bool = this.openAppstoreService.isBillingAvailable(paramString);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return false;
  }

  public boolean isPackageInstaller(String paramString)
  {
    try
    {
      boolean bool = this.openAppstoreService.isPackageInstaller(paramString);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return false;
  }

  public String toString()
  {
    return "OpenStore {name: " + this.appstoreName + ", component: " + this.componentName + "}";
  }

  private static final class IOpenInAppBillingWrapper
    implements IInAppBillingService
  {
    private final IOpenInAppBillingService openStoreBilling;

    private IOpenInAppBillingWrapper(IOpenInAppBillingService paramIOpenInAppBillingService)
    {
      this.openStoreBilling = paramIOpenInAppBillingService;
    }

    public IBinder asBinder()
    {
      return this.openStoreBilling.asBinder();
    }

    public int consumePurchase(int paramInt, String paramString1, String paramString2)
      throws RemoteException
    {
      return this.openStoreBilling.consumePurchase(paramInt, paramString1, paramString2);
    }

    public Bundle getBuyIntent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
      throws RemoteException
    {
      return this.openStoreBilling.getBuyIntent(paramInt, paramString1, paramString2, paramString3, paramString4);
    }

    public Bundle getBuyIntentExtraParams(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
      throws RemoteException
    {
      return null;
    }

    public Bundle getBuyIntentToReplaceSkus(int paramInt, String paramString1, List<String> paramList, String paramString2, String paramString3, String paramString4)
      throws RemoteException
    {
      return null;
    }

    public Bundle getPurchaseHistory(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
      throws RemoteException
    {
      return null;
    }

    public Bundle getPurchases(int paramInt, String paramString1, String paramString2, String paramString3)
      throws RemoteException
    {
      return this.openStoreBilling.getPurchases(paramInt, paramString1, paramString2, paramString3);
    }

    public Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
      throws RemoteException
    {
      return this.openStoreBilling.getSkuDetails(paramInt, paramString1, paramString2, paramBundle);
    }

    public Bundle getSubscriptionManagementIntent(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
      throws RemoteException
    {
      return null;
    }

    public int isBillingSupported(int paramInt, String paramString1, String paramString2)
      throws RemoteException
    {
      return this.openStoreBilling.isBillingSupported(paramInt, paramString1, paramString2);
    }

    public int isBillingSupportedExtraParams(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
      throws RemoteException
    {
      return 0;
    }

    public int stub(int paramInt, String paramString1, String paramString2)
      throws RemoteException
    {
      return 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.OpenAppstore
 * JD-Core Version:    0.6.2
 */