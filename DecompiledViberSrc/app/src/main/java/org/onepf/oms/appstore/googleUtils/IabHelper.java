package org.onepf.oms.appstore.googleUtils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.onepf.oms.Appstore;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.InAppUtils;
import org.onepf.oms.SkuManager;

public class IabHelper
  implements AppstoreInAppBillingService, InAppUtils
{
  private static final Logger L = ViberEnv.getLogger();
  public static final int QUERY_SKU_DETAILS_BATCH_SIZE = 20;
  private Appstore appstore;
  ComponentName componentName;
  boolean mAsyncInProgress = false;
  String mAsyncOperation = "";
  Context mContext;
  OnIabPurchaseFinishedListener mPurchaseListener;
  String mPurchasingItemType;
  int mRequestCode;
  IInAppBillingService mService;
  ServiceConnection mServiceConn;
  boolean mSetupDone = false;
  String mSignatureBase64 = null;
  boolean mSubscriptionsSupported = false;

  public IabHelper(Context paramContext, String paramString, Appstore paramAppstore)
  {
    this.mContext = paramContext;
    this.mSignatureBase64 = paramString;
    this.appstore = paramAppstore;
  }

  private String bundleToString(Bundle paramBundle)
  {
    Set localSet = paramBundle.keySet();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append('"');
      localStringBuilder.append(str);
      localStringBuilder.append("\"=\"");
      localStringBuilder.append(paramBundle.get(str));
      localStringBuilder.append("\", ");
    }
    return localStringBuilder.toString();
  }

  public static String getResponseDesc(int paramInt)
  {
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= -1000)
    {
      int i = -1000 - paramInt;
      if ((i >= 0) && (i < arrayOfString2.length))
        return arrayOfString2[i];
      return String.valueOf(paramInt) + ":Unknown IAB Helper Error";
    }
    if ((paramInt < 0) || (paramInt >= arrayOfString1.length))
      return String.valueOf(paramInt) + ":Unknown";
    return arrayOfString1[paramInt];
  }

  void checkSetupDone(String paramString)
  {
  }

  public void consume(Purchase paramPurchase)
    throws IabException
  {
    checkSetupDone("consume");
    if (!paramPurchase.mItemType.equals("inapp"))
      throw new IabException(-1010, "Items of type '" + paramPurchase.mItemType + "' can't be consumed.");
    String str1;
    String str2;
    try
    {
      str1 = paramPurchase.getToken();
      str2 = paramPurchase.getSku();
      if ((str1 == null) || (str1.equals("")))
        throw new IabException(-1007, "PurchaseInfo is missing token for sku: " + str2 + " " + paramPurchase);
    }
    catch (RemoteException localRemoteException)
    {
      throw new IabException(-1001, "Remote exception while consuming. PurchaseInfo: " + paramPurchase, localRemoteException);
    }
    if (this.mService == null)
      throw new IabException(6, "Error consuming sku " + str2);
    int i = this.mService.consumePurchase(3, getPackageName(), str1);
    if (i == 0)
      return;
    throw new IabException(i, "Error consuming sku " + str2);
  }

  public void consumeAsync(List<Purchase> paramList, OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    checkSetupDone("consume");
    consumeAsyncInternal(paramList, null, paramOnConsumeMultiFinishedListener);
  }

  public void consumeAsync(Purchase paramPurchase, OnConsumeFinishedListener paramOnConsumeFinishedListener)
  {
    checkSetupDone("consume");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPurchase);
    consumeAsyncInternal(localArrayList, paramOnConsumeFinishedListener, null);
  }

  void consumeAsyncInternal(final List<Purchase> paramList, final OnConsumeFinishedListener paramOnConsumeFinishedListener, final OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    final Handler localHandler = new Handler();
    flagStartAsync("consume");
    new Thread(new Runnable()
    {
      public void run()
      {
        final ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Purchase localPurchase = (Purchase)localIterator.next();
          try
          {
            IabHelper.this.consume(localPurchase);
            localArrayList.add(new IabResult(0, "Successful consume of sku " + localPurchase.getSku()));
          }
          catch (IabException localIabException)
          {
            localArrayList.add(localIabException.getResult());
          }
        }
        IabHelper.this.flagEndAsync();
        if (paramOnConsumeFinishedListener != null)
          localHandler.post(new Runnable()
          {
            public void run()
            {
              IabHelper.3.this.val$singleListener.onConsumeFinished((Purchase)IabHelper.3.this.val$purchases.get(0), (IabResult)localArrayList.get(0));
            }
          });
        if (paramOnConsumeMultiFinishedListener != null)
          localHandler.post(new Runnable()
          {
            public void run()
            {
              IabHelper.3.this.val$multiListener.onConsumeMultiFinished(IabHelper.3.this.val$purchases, localArrayList);
            }
          });
      }
    }).start();
  }

  public void dispose()
  {
    this.mSetupDone = false;
    if (this.mServiceConn != null);
    try
    {
      if (this.mContext != null)
        this.mContext.unbindService(this.mServiceConn);
      label30: this.mServiceConn = null;
      this.mService = null;
      this.mPurchaseListener = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label30;
    }
  }

  void flagEndAsync()
  {
    this.mAsyncOperation = "";
    this.mAsyncInProgress = false;
  }

  void flagStartAsync(String paramString)
  {
    if (this.mAsyncInProgress)
      throw new IllegalStateException("Can't start async operation (" + paramString + ") because another async operation(" + this.mAsyncOperation + ") is in progress.");
    this.mAsyncOperation = paramString;
    this.mAsyncInProgress = true;
  }

  public String getPackageName()
  {
    return this.mContext.getPackageName();
  }

  int getResponseCodeFromBundle(Bundle paramBundle)
  {
    Object localObject = paramBundle.get("RESPONSE_CODE");
    if (localObject == null)
      return 0;
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    if ((localObject instanceof Long))
      return (int)((Long)localObject).longValue();
    throw new RuntimeException("Unexpected type for bundle response code: " + localObject.getClass().getName());
  }

  int getResponseCodeFromIntent(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras().get("RESPONSE_CODE");
    if (localObject == null)
      return 0;
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    if ((localObject instanceof Long))
      return (int)((Long)localObject).longValue();
    throw new RuntimeException("Unexpected type for intent response code: " + localObject.getClass().getName());
  }

  protected IInAppBillingService getServiceFromBinder(IBinder paramIBinder)
  {
    return IInAppBillingService.Stub.asInterface(paramIBinder);
  }

  protected Intent getServiceIntent()
  {
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    return localIntent;
  }

  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != this.mRequestCode)
      return false;
    checkSetupDone("handleActivityResult");
    flagEndAsync();
    if (paramIntent == null)
    {
      IabResult localIabResult1 = new IabResult(-1002, "Null data in IAB result");
      if (this.mPurchaseListener != null)
        this.mPurchaseListener.onIabPurchaseFinished(localIabResult1, null);
      return true;
    }
    int i = getResponseCodeFromIntent(paramIntent);
    String str1 = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    String str2 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    if ((paramInt2 == -1) && (i == 0))
      processPurchaseSuccess(paramIntent, str1, str2);
    while (true)
    {
      return true;
      if (paramInt2 == -1)
      {
        processPurchaseFailResultOk(i);
      }
      else if (i == 7)
      {
        IabResult localIabResult2 = new IabResult(7, "User canceled.");
        if (this.mPurchaseListener != null)
          this.mPurchaseListener.onIabPurchaseFinished(localIabResult2, null);
      }
      else if (paramInt2 == 0)
      {
        if (i == 1);
        for (IabResult localIabResult4 = new IabResult(-1005, "User canceled."); ; localIabResult4 = new IabResult(-1006, "Unknown purchase response."))
        {
          if (this.mPurchaseListener == null)
            break label227;
          this.mPurchaseListener.onIabPurchaseFinished(localIabResult4, null);
          break;
        }
      }
      else
      {
        label227: IabResult localIabResult3 = new IabResult(-1006, "Unknown purchase response.");
        if (this.mPurchaseListener != null)
          this.mPurchaseListener.onIabPurchaseFinished(localIabResult3, null);
      }
    }
  }

  boolean isValidDataSignature(String paramString1, String paramString2, String paramString3)
  {
    boolean bool;
    if (paramString1 == null)
      bool = true;
    do
    {
      return bool;
      bool = Security.verifyPurchase(paramString1, paramString2, paramString3);
    }
    while (bool);
    return bool;
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchPurchaseFlow(paramActivity, paramString1, paramInt, paramString2, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
  {
    launchPurchaseFlow(paramActivity, paramString1, "inapp", paramInt, paramString2, paramOnIabPurchaseFinishedListener, paramString3);
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4)
  {
    checkSetupDone("launchPurchaseFlow");
    flagStartAsync("launchPurchaseFlow");
    if (!this.mSetupDone)
    {
      IabResult localIabResult1 = new IabResult(-1003, "Error in launchPurchaseFlow.  Possible error in account registration.");
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult1, null);
      flagEndAsync();
      return;
    }
    if ((paramString2.equals("subs")) && (!this.mSubscriptionsSupported))
    {
      IabResult localIabResult6 = new IabResult(-1009, "Subscriptions are not available.");
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult6, null);
      flagEndAsync();
      return;
    }
    try
    {
      if (this.mService == null)
      {
        IabResult localIabResult4 = new IabResult(6, "Unable to buy item");
        if (paramOnIabPurchaseFinishedListener != null)
          paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult4, null);
        flagEndAsync();
        return;
      }
    }
    catch (IntentSender.SendIntentException localSendIntentException)
    {
      IabResult localIabResult3 = new IabResult(-1004, "Failed to send intent.");
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult3, null);
      flagEndAsync();
      return;
      localBundle = this.mService.getBuyIntent(3, getPackageName(), paramString1, paramString2, paramString4);
      int i = getResponseCodeFromBundle(localBundle);
      if (i != 0)
      {
        IabResult localIabResult5 = new IabResult(i, "Unable to buy item");
        if (paramOnIabPurchaseFinishedListener != null)
          paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult5, null);
        flagEndAsync();
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        Bundle localBundle;
        IabResult localIabResult2 = new IabResult(-1001, "Remote exception while starting purchase flow");
        if (paramOnIabPurchaseFinishedListener != null)
        {
          paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult2, null);
          continue;
          PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("BUY_INTENT");
          this.mRequestCode = paramInt;
          this.mPurchaseListener = paramOnIabPurchaseFinishedListener;
          this.mPurchasingItemType = paramString2;
          paramActivity.startIntentSenderForResult(localPendingIntent.getIntentSender(), paramInt, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        }
      }
    }
  }

  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchSubscriptionPurchaseFlow(paramActivity, paramString1, paramInt, paramString2, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
  {
    launchPurchaseFlow(paramActivity, paramString1, "subs", paramInt, paramString2, paramOnIabPurchaseFinishedListener, paramString3);
  }

  public void processPurchaseFailResultOk(int paramInt)
  {
    if (this.mPurchaseListener != null)
    {
      IabResult localIabResult = new IabResult(paramInt, "Problem purchashing item.");
      this.mPurchaseListener.onIabPurchaseFinished(localIabResult, null);
    }
  }

  public void processPurchaseSuccess(Intent paramIntent, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      IabResult localIabResult1 = new IabResult(-1008, "IAB returned null purchaseData or dataSignature");
      if (this.mPurchaseListener != null)
        this.mPurchaseListener.onIabPurchaseFinished(localIabResult1, null);
    }
    Purchase localPurchase;
    label205: 
    do
    {
      IabResult localIabResult2;
      do
        while (true)
        {
          return;
          try
          {
            localPurchase = new Purchase(this.mPurchasingItemType, paramString1, paramString2, this.appstore.getAppstoreName());
            String str = localPurchase.getSku();
            localPurchase.setSku(SkuManager.getInstance().getSku(this.appstore.getAppstoreName(), str));
            if (isValidDataSignature(this.mSignatureBase64, paramString1, paramString2))
              break label205;
            IabResult localIabResult3 = new IabResult(-1003, "Signature verification failed for sku " + str);
            if (this.mPurchaseListener != null)
            {
              this.mPurchaseListener.onIabPurchaseFinished(localIabResult3, localPurchase);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            localIabResult2 = new IabResult(-1002, "Failed to parse purchase data.");
          }
        }
      while (this.mPurchaseListener == null);
      this.mPurchaseListener.onIabPurchaseFinished(localIabResult2, null);
      return;
    }
    while (this.mPurchaseListener == null);
    this.mPurchaseListener.onIabPurchaseFinished(new IabResult(0, "Success"), localPurchase);
  }

  public Inventory queryInventory(boolean paramBoolean, List<String> paramList)
    throws IabException
  {
    return queryInventory(paramBoolean, paramList, null);
  }

  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException
  {
    checkSetupDone("queryInventory");
    Inventory localInventory;
    try
    {
      if (!this.mSetupDone)
        throw new IabException(-1003, "Error refreshing inventory.  Possible error in account registration.");
    }
    catch (RemoteException localRemoteException)
    {
      throw new IabException(-1001, "Remote exception while refreshing inventory.", localRemoteException);
      localInventory = new Inventory();
      int i = queryPurchases(localInventory, "inapp");
      if (i != 0)
        throw new IabException(i, "Error refreshing inventory (querying owned items).");
    }
    catch (JSONException localJSONException)
    {
      throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", localJSONException);
      if (paramBoolean)
      {
        int m = querySkuDetails("inapp", localInventory, paramList1);
        if (m != 0)
          throw new IabException(m, "Error refreshing inventory (querying prices of items).");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new IabException(-1003, "Error refreshing inventory.  Possible error in account registration.", localIllegalArgumentException);
    }
    if (this.mSubscriptionsSupported)
    {
      int j = queryPurchases(localInventory, "subs");
      if (j != 0)
        throw new IabException(j, "Error refreshing inventory (querying owned subscriptions).");
      if (paramBoolean)
      {
        int k = querySkuDetails("subs", localInventory, paramList2);
        if (k != 0)
          throw new IabException(k, "Error refreshing inventory (querying prices of subscriptions).");
      }
    }
    return localInventory;
  }

  public void queryInventoryAsync(QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(true, null, paramQueryInventoryFinishedListener);
  }

  public void queryInventoryAsync(final boolean paramBoolean, final List<String> paramList, final QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    final Handler localHandler = new Handler();
    checkSetupDone("queryInventory");
    flagStartAsync("refresh inventory");
    new Thread(new Runnable()
    {
      public void run()
      {
        final IabResult localIabResult = new IabResult(0, "Inventory refresh successful.");
        try
        {
          Inventory localInventory2 = IabHelper.this.queryInventory(paramBoolean, paramList);
          localInventory1 = localInventory2;
          IabHelper.this.flagEndAsync();
          localHandler.post(new Runnable()
          {
            public void run()
            {
              IabHelper.2.this.val$listener.onQueryInventoryFinished(localIabResult, localInventory1);
            }
          });
          return;
        }
        catch (IabException localIabException)
        {
          while (true)
          {
            localIabResult = localIabException.getResult();
            final Inventory localInventory1 = null;
          }
        }
      }
    }).start();
  }

  public void queryInventoryAsync(boolean paramBoolean, QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(paramBoolean, null, paramQueryInventoryFinishedListener);
  }

  int queryPurchases(Inventory paramInventory, String paramString)
    throws JSONException, RemoteException
  {
    String str1 = null;
    int m;
    for (int i = 0; ; i = m)
    {
      int n;
      if (this.mService == null)
        n = 6;
      do
      {
        return n;
        Bundle localBundle = this.mService.getPurchases(3, getPackageName(), paramString, str1);
        int j = getResponseCodeFromBundle(localBundle);
        if (j != 0)
          return j;
        if ((!localBundle.containsKey("INAPP_PURCHASE_ITEM_LIST")) || (!localBundle.containsKey("INAPP_PURCHASE_DATA_LIST")) || (!localBundle.containsKey("INAPP_DATA_SIGNATURE_LIST")))
          return -1002;
        ArrayList localArrayList1 = localBundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList2 = localBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList3 = localBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        int k = 0;
        m = i;
        if (k < localArrayList2.size())
        {
          String str2 = (String)localArrayList2.get(k);
          String str3 = (String)localArrayList3.get(k);
          ((String)localArrayList1.get(k));
          if (isValidDataSignature(this.mSignatureBase64, str2, str3))
          {
            Purchase localPurchase = new Purchase(paramString, str2, str3, this.appstore.getAppstoreName());
            String str4 = localPurchase.getSku();
            localPurchase.setSku(SkuManager.getInstance().getSku(this.appstore.getAppstoreName(), str4));
            if (TextUtils.isEmpty(localPurchase.getToken()));
            paramInventory.addPurchase(localPurchase);
          }
          while (true)
          {
            k++;
            break;
            m = 1;
          }
        }
        str1 = localBundle.getString("INAPP_CONTINUATION_TOKEN");
        if (!TextUtils.isEmpty(str1))
          break;
        n = 0;
      }
      while (m == 0);
      return -1003;
    }
  }

  int querySkuDetails(String paramString, Inventory paramInventory, List<String> paramList)
    throws RemoteException, JSONException
  {
    SkuManager localSkuManager = SkuManager.getInstance();
    String str = this.appstore.getAppstoreName();
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = paramInventory.getAllOwnedSkus(paramString).iterator();
    while (localIterator1.hasNext())
      localHashSet.add(localSkuManager.getStoreSku(str, (String)localIterator1.next()));
    if (paramList != null)
    {
      Iterator localIterator5 = paramList.iterator();
      while (localIterator5.hasNext())
        localHashSet.add(localSkuManager.getStoreSku(str, (String)localIterator5.next()));
    }
    boolean bool1 = localHashSet.isEmpty();
    int i = 0;
    if (bool1)
      return i;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList(20);
    Iterator localIterator2 = localHashSet.iterator();
    int j = 0;
    Object localObject1 = localArrayList2;
    label181: int k;
    if (localIterator2.hasNext())
    {
      ((ArrayList)localObject1).add((String)localIterator2.next());
      k = j + 1;
      if ((((ArrayList)localObject1).size() != 20) && (k != localHashSet.size()))
        break label451;
      localArrayList1.add(localObject1);
    }
    label451: for (Object localObject2 = new ArrayList(20); ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      j = k;
      break label181;
      Iterator localIterator3 = localArrayList1.iterator();
      while (true)
      {
        boolean bool2 = localIterator3.hasNext();
        i = 0;
        if (!bool2)
          break;
        ArrayList localArrayList3 = (ArrayList)localIterator3.next();
        Bundle localBundle1 = new Bundle();
        localBundle1.putStringArrayList("ITEM_ID_LIST", localArrayList3);
        if (this.mService == null)
          return -1002;
        Bundle localBundle2 = this.mService.getSkuDetails(3, this.mContext.getPackageName(), paramString, localBundle1);
        if (!localBundle2.containsKey("DETAILS_LIST"))
        {
          i = getResponseCodeFromBundle(localBundle2);
          if (i != 0)
            break;
          return -1002;
        }
        Iterator localIterator4 = localBundle2.getStringArrayList("DETAILS_LIST").iterator();
        while (localIterator4.hasNext())
        {
          SkuDetails localSkuDetails = new SkuDetails(paramString, (String)localIterator4.next());
          localSkuDetails.setSku(SkuManager.getInstance().getSku(str, localSkuDetails.getSku()));
          paramInventory.addSkuDetails(localSkuDetails);
        }
      }
    }
  }

  public void setProductsData(List<String> paramList)
  {
  }

  public void setSetupDone(boolean paramBoolean)
  {
    this.mSetupDone = paramBoolean;
  }

  public void setSubscriptionsSupported(boolean paramBoolean)
  {
    this.mSubscriptionsSupported = paramBoolean;
  }

  public void startSetup(final OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    if (this.mSetupDone)
      throw new IllegalStateException("IAB helper is already set up.");
    this.mServiceConn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        IabHelper.this.mService = IabHelper.this.getServiceFromBinder(paramAnonymousIBinder);
        IabHelper.this.componentName = paramAnonymousComponentName;
        String str = IabHelper.this.mContext.getPackageName();
        try
        {
          int i = IabHelper.this.mService.isBillingSupported(3, str, "inapp");
          if (i != 0)
          {
            if (paramOnIabSetupFinishedListener != null)
              paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(i, "Error checking for billing v3 support."));
            IabHelper.this.mSubscriptionsSupported = false;
            return;
          }
          if (IabHelper.this.mService.isBillingSupported(3, str, "subs") == 0)
            IabHelper.this.mSubscriptionsSupported = true;
          IabHelper.this.mSetupDone = true;
          if (paramOnIabSetupFinishedListener != null)
          {
            paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful."));
            return;
          }
        }
        catch (RemoteException localRemoteException)
        {
          if (paramOnIabSetupFinishedListener != null)
          {
            paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(-1001, "RemoteException while setting up in-app billing."));
            return;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (paramOnIabSetupFinishedListener != null)
          {
            paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(-1003, "IllegalArgumentException while setting up in-app billing. Possible error in account registration"));
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          if (paramOnIabSetupFinishedListener != null)
            paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(-1003, "Exception while setting up in-app billing. Possible error in account registration"));
        }
      }

      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        IabHelper.this.mService = null;
      }
    };
    Intent localIntent = getServiceIntent();
    List localList = this.mContext.getPackageManager().queryIntentServices(localIntent, 0);
    if ((localList != null) && (!localList.isEmpty()))
      if (TextUtils.isEmpty(localIntent.getPackage()))
        localIntent = getServiceIntent();
    while (paramOnIabSetupFinishedListener == null)
      try
      {
        this.mContext.bindService(localIntent, this.mServiceConn, 1);
        return;
      }
      catch (Throwable localThrowable)
      {
        do
          L.a(localThrowable, "Exception while setting up in-app billing. Possible error in Service binding due to broken action");
        while (paramOnIabSetupFinishedListener == null);
        paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(-1004, "Exception while setting up in-app billing. Possible error in Service binding due to broken action"));
        return;
      }
    paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
  }

  public boolean subscriptionsSupported()
  {
    return this.mSubscriptionsSupported;
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
    public abstract void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleUtils.IabHelper
 * JD-Core Version:    0.6.2
 */