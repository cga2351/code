package org.onepf.oms.appstore.nokiaUtils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.f.a.a.a.a;
import com.f.a.a.a.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.onepf.oms.Appstore;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.SkuManager;
import org.onepf.oms.appstore.googleUtils.IabException;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.appstore.googleUtils.Purchase;
import org.onepf.oms.appstore.googleUtils.SkuDetails;
import org.onepf.oms.util.CollectionUtils;

public class NokiaStoreHelper
  implements AppstoreInAppBillingService
{
  private static final Logger L = ViberEnv.getLogger();
  public static final int RESULT_BAD_RESPONSE = -1002;
  public static final int RESULT_BILLING_UNAVAILABLE = 3;
  public static final int RESULT_DEVELOPER_ERROR = 5;
  public static final int RESULT_ERROR = 6;
  public static final int RESULT_ITEM_ALREADY_OWNED = 7;
  public static final int RESULT_ITEM_NOT_OWNED = 8;
  public static final int RESULT_ITEM_UNAVAILABLE = 4;
  public static final int RESULT_NO_SIM = 9;
  public static final int RESULT_OK = 0;
  public static final int RESULT_USER_CANCELED = 1;
  private final Context mContext;
  private IabHelper.OnIabPurchaseFinishedListener mPurchaseListener = null;
  int mRequestCode;
  private a mService = null;
  private ServiceConnection mServiceConn = null;

  public NokiaStoreHelper(Context paramContext, Appstore paramAppstore)
  {
    this.mContext = paramContext;
  }

  private Intent getServiceIntent()
  {
    Intent localIntent = new Intent("com.nokia.payment.iapenabler.InAppBillingService.BIND");
    localIntent.setPackage("com.nokia.payment.iapenabler");
    return localIntent;
  }

  private void processDetailsList(List<String> paramList, Inventory paramInventory)
    throws JSONException
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      JSONObject localJSONObject = new JSONObject((String)localIterator.next());
      paramInventory.addSkuDetails(new SkuDetails("inapp", SkuManager.getInstance().getSku("com.nokia.nstore", localJSONObject.getString("productId")), localJSONObject.getString("title"), localJSONObject.getString("price"), localJSONObject.getString("shortdescription")));
    }
  }

  private void processPurchaseSuccess(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str = SkuManager.getInstance().getSku("com.nokia.nstore", localJSONObject.getString("productId"));
      Purchase localPurchase = new Purchase("com.nokia.nstore");
      localPurchase.setItemType("inapp");
      localPurchase.setOrderId(localJSONObject.getString("orderId"));
      localPurchase.setPackageName(localJSONObject.getString("packageName"));
      localPurchase.setSku(str);
      localPurchase.setToken(localJSONObject.getString("purchaseToken"));
      localPurchase.setDeveloperPayload(localJSONObject.getString("developerPayload"));
      if (this.mPurchaseListener != null)
        this.mPurchaseListener.onIabPurchaseFinished(new NokiaResult(0, "Success"), localPurchase);
      return;
    }
    catch (JSONException localJSONException)
    {
      NokiaResult localNokiaResult;
      do
        localNokiaResult = new NokiaResult(-1002, "Failed to parse purchase data.");
      while (this.mPurchaseListener == null);
      this.mPurchaseListener.onIabPurchaseFinished(localNokiaResult, null);
    }
  }

  private void processPurchasedList(ArrayList<String> paramArrayList, Inventory paramInventory)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        Purchase localPurchase = new Purchase("com.nokia.nstore");
        localPurchase.setItemType("inapp");
        localPurchase.setSku(SkuManager.getInstance().getSku("com.nokia.nstore", localJSONObject.getString("productId")));
        localPurchase.setToken(localJSONObject.getString("purchaseToken"));
        localPurchase.setPackageName(getPackageName());
        localPurchase.setPurchaseState(0);
        localPurchase.setDeveloperPayload(localJSONObject.optString("developerPayload", ""));
        paramInventory.addPurchase(localPurchase);
      }
      catch (JSONException localJSONException)
      {
      }
    }
  }

  private void refreshItemDetails(List<String> paramList, Inventory paramInventory)
    throws IabException
  {
    Bundle localBundle1 = new Bundle(32);
    ArrayList localArrayList1 = new ArrayList(32);
    List localList = SkuManager.getInstance().getAllStoreSkus("com.nokia.nstore");
    if (!CollectionUtils.isEmpty(localList))
      localArrayList1.addAll(localList);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList1.add(SkuManager.getInstance().getStoreSku("com.nokia.nstore", str));
      }
    }
    localBundle1.putStringArrayList("ITEM_ID_LIST", localArrayList1);
    try
    {
      if (this.mService == null)
        throw new IabException(-1002, "Error refreshing item details.");
      Bundle localBundle2 = this.mService.a(3, getPackageName(), "inapp", localBundle1);
      int i = localBundle2.getInt("RESPONSE_CODE");
      ArrayList localArrayList2 = localBundle2.getStringArrayList("DETAILS_LIST");
      if (i != 0)
        throw new IabException(new NokiaResult(i, "Error refreshing inventory (querying prices of items)."));
      processDetailsList(localArrayList2, paramInventory);
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void refreshPurchasedItems(List<String> paramList, Inventory paramInventory)
    throws IabException
  {
    ArrayList localArrayList1 = new ArrayList(SkuManager.getInstance().getAllStoreSkus("com.nokia.nstore"));
    Bundle localBundle1 = new Bundle(32);
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localArrayList1.add((String)localIterator.next());
    }
    localBundle1.putStringArrayList("ITEM_ID_LIST", localArrayList1);
    try
    {
      if (this.mService == null)
        throw new IabException(-1002, "Error refreshing inventory (querying owned items).");
      Bundle localBundle2 = this.mService.a(3, getPackageName(), "inapp", localBundle1, null);
      int i = localBundle2.getInt("RESPONSE_CODE");
      localBundle2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      ArrayList localArrayList2 = localBundle2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      if (i != 0)
        throw new IabException(new NokiaResult(i, "Error refreshing inventory (querying owned items)."));
      processPurchasedList(localArrayList2, paramInventory);
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public void consume(Purchase paramPurchase)
    throws IabException
  {
    String str1 = paramPurchase.getToken();
    String str2 = paramPurchase.getSku();
    String str3 = paramPurchase.getPackageName();
    try
    {
      int j = this.mService.a(3, str3, str2, str1);
      i = j;
      if (i == 0)
        return;
      throw new IabException(new NokiaResult(i, "Error consuming productId " + str2));
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public void dispose()
  {
    if (this.mServiceConn != null)
    {
      if (this.mContext != null)
        this.mContext.unbindService(this.mServiceConn);
      this.mServiceConn = null;
      this.mService = null;
    }
  }

  public String getPackageName()
  {
    return this.mContext.getPackageName();
  }

  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != this.mRequestCode)
      return false;
    if (paramIntent == null)
    {
      NokiaResult localNokiaResult1 = new NokiaResult(-1002, "Null data in IAB result");
      if (this.mPurchaseListener != null)
        this.mPurchaseListener.onIabPurchaseFinished(localNokiaResult1, null);
      return true;
    }
    int i = paramIntent.getIntExtra("RESPONSE_CODE", 0);
    String str = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    if ((paramInt2 == -1) && (i == 0))
      processPurchaseSuccess(str);
    while (true)
    {
      return true;
      if (paramInt2 == -1)
      {
        processPurchaseFail(i);
      }
      else if (paramInt2 == 0)
      {
        NokiaResult localNokiaResult2 = new NokiaResult(-1005, "User canceled.");
        if (this.mPurchaseListener != null)
          this.mPurchaseListener.onIabPurchaseFinished(localNokiaResult2, null);
      }
      else
      {
        NokiaResult localNokiaResult3 = new NokiaResult(-1006, "Unknown purchase response.");
        if (this.mPurchaseListener != null)
          this.mPurchaseListener.onIabPurchaseFinished(localNokiaResult3, null);
      }
    }
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4)
  {
    if (paramString2.equals("subs"))
    {
      IabResult localIabResult = new IabResult(-1009, "Subscriptions are not available.");
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult, null);
    }
    int i;
    label223: 
    do
    {
      NokiaResult localNokiaResult1;
      do
        while (true)
        {
          return;
          try
          {
            if (this.mService == null)
            {
              if (paramOnIabPurchaseFinishedListener == null)
                continue;
              paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(new NokiaResult(6, "Unable to buy item"), null);
            }
          }
          catch (RemoteException localRemoteException)
          {
            NokiaResult localNokiaResult2 = new NokiaResult(-1004, "Failed to send intent.");
            if (paramOnIabPurchaseFinishedListener != null)
            {
              paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localNokiaResult2, null);
              return;
              Bundle localBundle = this.mService.a(3, getPackageName(), paramString1, "inapp", paramString4);
              i = localBundle.getInt("RESPONSE_CODE", 0);
              PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("BUY_INTENT");
              if (i != 0)
                break label223;
              this.mRequestCode = paramInt;
              this.mPurchaseListener = paramOnIabPurchaseFinishedListener;
              paramActivity.startIntentSenderForResult(localPendingIntent.getIntentSender(), paramInt, new Intent(), 0, 0, 0);
              return;
            }
          }
          catch (IntentSender.SendIntentException localSendIntentException)
          {
            localNokiaResult1 = new NokiaResult(-1001, "Remote exception while starting purchase flow");
          }
        }
      while (paramOnIabPurchaseFinishedListener == null);
      paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localNokiaResult1, null);
      return;
    }
    while (paramOnIabPurchaseFinishedListener == null);
    paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(new NokiaResult(i, "Failed to get buy intent."), null);
  }

  public void processPurchaseFail(int paramInt)
  {
    if (this.mPurchaseListener != null)
    {
      NokiaResult localNokiaResult = new NokiaResult(paramInt, "Problem purchashing item.");
      this.mPurchaseListener.onIabPurchaseFinished(localNokiaResult, null);
    }
  }

  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException
  {
    Inventory localInventory = new Inventory();
    if (paramBoolean)
      refreshItemDetails(paramList1, localInventory);
    refreshPurchasedItems(paramList1, localInventory);
    return localInventory;
  }

  public void setProductsData(List<String> paramList)
  {
  }

  public void startSetup(final IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    this.mServiceConn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        NokiaStoreHelper.access$002(NokiaStoreHelper.this, a.a.a(paramAnonymousIBinder));
        do
          try
          {
            int i = NokiaStoreHelper.this.mService.a(3, NokiaStoreHelper.this.getPackageName(), "inapp");
            if (i != 0)
            {
              if (paramOnIabSetupFinishedListener != null)
                paramOnIabSetupFinishedListener.onIabSetupFinished(new NokiaResult(i, "Error checking for billing support."));
              return;
            }
          }
          catch (RemoteException localRemoteException)
          {
            while (paramOnIabSetupFinishedListener == null);
            paramOnIabSetupFinishedListener.onIabSetupFinished(new NokiaResult(-1001, "RemoteException while setting up in-app billing."));
            return;
          }
        while (paramOnIabSetupFinishedListener == null);
        paramOnIabSetupFinishedListener.onIabSetupFinished(new NokiaResult(0, "Setup successful."));
      }

      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        NokiaStoreHelper.access$002(NokiaStoreHelper.this, null);
      }
    };
    Intent localIntent = getServiceIntent();
    List localList = this.mContext.getPackageManager().queryIntentServices(localIntent, 0);
    if ((localList == null) || (localList.isEmpty()))
      if (paramOnIabSetupFinishedListener != null)
        paramOnIabSetupFinishedListener.onIabSetupFinished(new NokiaResult(3, "Billing service unavailable on device."));
    do
    {
      return;
      try
      {
        this.mContext.bindService(localIntent, this.mServiceConn, 1);
        return;
      }
      catch (SecurityException localSecurityException)
      {
      }
    }
    while (paramOnIabSetupFinishedListener == null);
    paramOnIabSetupFinishedListener.onIabSetupFinished(new NokiaResult(3, "Billing service unavailable on device due to lack of the permission \"com.nokia.payment.BILLING\"."));
  }

  public boolean subscriptionsSupported()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.nokiaUtils.NokiaStoreHelper
 * JD-Core Version:    0.6.2
 */