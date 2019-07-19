package org.onepf.oms.appstore.googleBillingUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.billingclient.api.b;
import com.android.billingclient.api.b.a;
import com.android.billingclient.api.d;
import com.android.billingclient.api.e.a;
import com.android.billingclient.api.f;
import com.android.billingclient.api.h;
import com.android.billingclient.api.h.a;
import com.android.billingclient.api.i;
import com.android.billingclient.api.j;
import com.android.billingclient.api.k;
import com.android.billingclient.api.k.a;
import com.android.billingclient.api.l;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.onepf.oms.Appstore;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.InAppUtils;
import org.onepf.oms.SkuManager;
import org.onepf.oms.appstore.googleUtils.IabException;
import org.onepf.oms.appstore.googleUtils.IabHelper;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnConsumeFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.QueryInventoryFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.appstore.googleUtils.Purchase;
import org.onepf.oms.appstore.googleUtils.Security;
import org.onepf.oms.appstore.googleUtils.SkuDetails;

public class BillingClientHelper
  implements i, AppstoreInAppBillingService, InAppUtils
{
  private static final com.viber.common.a.e L = ViberEnv.getLogger();
  public static final int TIMEOUT_SKU_DETAILS = 3000;
  private static BillingClientHelper sInstance = null;
  private Appstore appstore;
  private b mBillingClient;
  private Context mContext;
  private boolean mIsServiceConnected;
  private IabHelper.OnIabPurchaseFinishedListener mPurchaseListener;
  String mPurchasingItemType;
  int mRequestCode;
  boolean mSetupDone = false;
  String mSignatureBase64 = null;

  private BillingClientHelper(Context paramContext, String paramString, Appstore paramAppstore)
  {
    this.mContext = paramContext;
    this.mSignatureBase64 = paramString;
    this.appstore = paramAppstore;
  }

  private b buildBillingClient()
  {
    return b.a(this.mContext).a(this).a();
  }

  private void executeServiceRequest(Runnable paramRunnable)
  {
    if (this.mIsServiceConnected)
    {
      paramRunnable.run();
      return;
    }
    startServiceConnection(null, paramRunnable);
  }

  private int getBillingResponseCode(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
    case 3:
    case 4:
    case 5:
    case 6:
    default:
      return -1008;
    case -2:
      return -1006;
    case -1:
    case 2:
      return -1001;
    case 1:
      return -1005;
    case 7:
    }
    return 7;
  }

  public static BillingClientHelper getInstance(Context paramContext, String paramString, Appstore paramAppstore)
  {
    if (sInstance == null);
    try
    {
      if (sInstance == null)
        sInstance = new BillingClientHelper(paramContext, paramString, paramAppstore);
      return sInstance;
    }
    finally
    {
    }
  }

  private SkuDetails jsonSkuToSkuDetails(j paramj)
  {
    return new SkuDetails(paramj.b(), paramj.a(), paramj.f(), paramj.c(), paramj.g(), paramj.e(), paramj.d(), paramj.toString());
  }

  private void startInnerSetup(final IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    if (this.mSetupDone)
    {
      if (paramOnIabSetupFinishedListener != null)
        paramOnIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful."));
      return;
    }
    new Thread()
    {
      public void run()
      {
        BillingClientHelper.this.startServiceConnection(new BillingClientHelper.ServiceConnectedListener()
        {
          public void onServiceConnected(int paramAnonymous2Int)
          {
            if (paramAnonymous2Int != 0);
            try
            {
              if (BillingClientHelper.2.this.val$listener != null)
              {
                BillingClientHelper.2.this.val$listener.onIabSetupFinished(new IabResult(paramAnonymous2Int, "Error checking for billing v3 support."));
                return;
                int i = BillingClientHelper.this.mBillingClient.a("inAppItemsOnVr");
                if (i != 0)
                {
                  if (BillingClientHelper.2.this.val$listener == null)
                    return;
                  BillingClientHelper.2.this.val$listener.onIabSetupFinished(new IabResult(i, "Error checking for billing support."));
                }
              }
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              if (BillingClientHelper.2.this.val$listener != null)
              {
                BillingClientHelper.2.this.val$listener.onIabSetupFinished(new IabResult(-1003, "IllegalArgumentException while setting up in-app billing. Possible error in account registration"));
                return;
                int j = BillingClientHelper.this.mBillingClient.a("subscriptions");
                if (j == 0);
                BillingClientHelper.this.mSetupDone = true;
                if (BillingClientHelper.2.this.val$listener != null)
                {
                  BillingClientHelper.2.this.val$listener.onIabSetupFinished(new IabResult(0, "Setup successful."));
                  return;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              if (BillingClientHelper.2.this.val$listener != null)
                BillingClientHelper.2.this.val$listener.onIabSetupFinished(new IabResult(-1003, "Exception while setting up in-app billing. Possible error in account registration"));
            }
          }

          public void onServiceDisconnected()
          {
          }
        }
        , null);
      }
    }
    .start();
  }

  private void startServiceConnection(final ServiceConnectedListener paramServiceConnectedListener, final Runnable paramRunnable)
  {
    this.mBillingClient.a(new d()
    {
      public void onBillingServiceDisconnected()
      {
        BillingClientHelper.access$602(BillingClientHelper.this, false);
        if (paramServiceConnectedListener != null)
          paramServiceConnectedListener.onServiceDisconnected();
      }

      public void onBillingSetupFinished(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          BillingClientHelper.access$602(BillingClientHelper.this, true);
          if (paramRunnable != null)
            paramRunnable.run();
        }
        if (paramServiceConnectedListener != null)
          paramServiceConnectedListener.onServiceConnected(paramAnonymousInt);
      }
    });
  }

  public void consume(Purchase paramPurchase)
    throws IabException
  {
    if (!paramPurchase.getItemType().equals("inapp"))
      throw new IabException(-1010, "Items of type '" + paramPurchase.getItemType() + "' can't be consumed.");
    String str1;
    try
    {
      str1 = paramPurchase.getToken();
      String str2 = paramPurchase.getSku();
      if ((str1 == null) || (str1.equals("")))
        throw new IabException(-1007, "PurchaseInfo is missing token for sku: " + str2 + " " + paramPurchase);
    }
    catch (Exception localException)
    {
      throw new IabException(-1001, "Remote exception while consuming. PurchaseInfo: " + paramPurchase, localException);
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    f local4 = new f()
    {
      public void onConsumeResponse(int paramAnonymousInt, String paramAnonymousString)
      {
        if (paramAnonymousInt == 0);
        localCountDownLatch.countDown();
      }
    };
    this.mBillingClient.a(str1, local4);
    try
    {
      localCountDownLatch.await(3000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public void consumeAsync(Purchase paramPurchase, IabHelper.OnConsumeFinishedListener paramOnConsumeFinishedListener)
  {
    consumeAsyncInternal(paramPurchase, paramOnConsumeFinishedListener);
  }

  void consumeAsyncInternal(final Purchase paramPurchase, final IabHelper.OnConsumeFinishedListener paramOnConsumeFinishedListener)
  {
    executeServiceRequest(new Runnable()
    {
      public void run()
      {
        BillingClientHelper.this.mBillingClient.a(this.val$purchaseToken, this.val$onConsumeListener);
      }
    });
  }

  public void dispose()
  {
    this.mSetupDone = false;
    if ((this.mBillingClient != null) && (this.mBillingClient.a()))
      this.mBillingClient.b();
    this.mPurchaseListener = null;
  }

  public Context getContext()
  {
    return this.mContext;
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

  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != this.mRequestCode)
      return false;
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
      processPurchaseSuccess(str1, str2);
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
            break label215;
          this.mPurchaseListener.onIabPurchaseFinished(localIabResult4, null);
          break;
        }
      }
      else
      {
        label215: IabResult localIabResult3 = new IabResult(-1006, "Unknown purchase response.");
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

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchPurchaseFlow(paramActivity, paramString1, paramString2, paramInt, paramString2, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
  {
    launchPurchaseFlow(paramActivity, paramString1, "inapp", paramInt, paramString2, paramOnIabPurchaseFinishedListener, paramString3);
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4)
  {
    launchPurchaseFlow(paramActivity, paramString1, paramString2, paramInt, paramString3, paramOnIabPurchaseFinishedListener, paramString4, null);
  }

  public void launchPurchaseFlow(final Activity paramActivity, final String paramString1, final String paramString2, int paramInt, final String paramString3, final IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4, final ArrayList<String> paramArrayList)
  {
    if (!this.mSetupDone)
    {
      IabResult localIabResult1 = new IabResult(-1003, "Error in launchPurchaseFlow.  Possible error in account registration.");
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult1, null);
    }
    IabResult localIabResult2;
    do
    {
      return;
      if ((!paramString2.equals("subs")) || (subscriptionsSupported()))
        break;
      localIabResult2 = new IabResult(-1009, "Subscriptions are not available.");
    }
    while (paramOnIabPurchaseFinishedListener == null);
    paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult2, null);
    return;
    this.mRequestCode = paramInt;
    this.mPurchasingItemType = paramString2;
    this.mPurchaseListener = paramOnIabPurchaseFinishedListener;
    executeServiceRequest(new Runnable()
    {
      public void run()
      {
        com.android.billingclient.api.e locale = com.android.billingclient.api.e.i().a(paramString1).b(paramString2).a(paramArrayList).c(paramString3).a();
        int i = BillingClientHelper.this.mBillingClient.a(paramActivity, locale);
        if (i != 0)
        {
          IabResult localIabResult = new IabResult(i, "Unable to buy item");
          if (paramOnIabPurchaseFinishedListener != null)
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult, null);
        }
      }
    });
  }

  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchSubscriptionPurchaseFlow(paramActivity, paramString1, paramInt, paramString2, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchSubscriptionPurchaseFlow(Activity paramActivity, String paramString1, int paramInt, String paramString2, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3)
  {
    launchPurchaseFlow(paramActivity, paramString1, "subs", paramInt, paramString2, paramOnIabPurchaseFinishedListener, paramString3);
  }

  public void onPurchasesUpdated(int paramInt, List<h> paramList)
  {
    if (paramInt == 0)
    {
      Iterator localIterator;
      if ((paramList != null) && (!paramList.isEmpty()))
        localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        processPurchaseSuccess(localh.c(), localh.d());
        continue;
        processPurchaseSuccess(null, null);
      }
    }
    IabResult localIabResult;
    do
    {
      return;
      localIabResult = new IabResult(getBillingResponseCode(paramInt), IabHelper.getResponseDesc(paramInt));
    }
    while (this.mPurchaseListener == null);
    this.mPurchaseListener.onIabPurchaseFinished(localIabResult, null);
  }

  public void processPurchaseFailResultOk(int paramInt)
  {
    if (this.mPurchaseListener != null)
    {
      IabResult localIabResult = new IabResult(paramInt, "Problem purchashing item.");
      this.mPurchaseListener.onIabPurchaseFinished(localIabResult, null);
    }
  }

  public void processPurchaseSuccess(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      IabResult localIabResult1 = new IabResult(-1008, "IAB returned null purchaseData or dataSignature");
      if (this.mPurchaseListener != null)
        this.mPurchaseListener.onIabPurchaseFinished(localIabResult1, null);
    }
    Purchase localPurchase;
    label198: 
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
              break label198;
            IabResult localIabResult3 = new IabResult(-1003, "Signature verification failed for sku " + str);
            if (this.mPurchaseListener != null)
            {
              this.mPurchaseListener.onIabPurchaseFinished(localIabResult3, localPurchase);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
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
    try
    {
      if (!this.mSetupDone)
        throw new IabException(-1003, "Error refreshing inventory.  Possible error in account registration.");
    }
    catch (RemoteException localRemoteException)
    {
      throw new IabException(-1001, "Remote exception while refreshing inventory.", localRemoteException);
      if (!this.mIsServiceConnected)
      {
        localCountDownLatch = new CountDownLatch(1);
        startServiceConnection(new ServiceConnectedListener()
        {
          public void onServiceConnected(int paramAnonymousInt)
          {
            localCountDownLatch.countDown();
          }

          public void onServiceDisconnected()
          {
          }
        }
        , null);
      }
    }
    catch (JSONException localJSONException)
    {
      try
      {
        final CountDownLatch localCountDownLatch;
        localCountDownLatch.await(3000L, TimeUnit.MILLISECONDS);
        if (!this.mIsServiceConnected)
        {
          throw new IabException(-1003, "Error refreshing inventory.  Can not start service connection");
          localJSONException = localJSONException;
          throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", localJSONException);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new IabException(-1003, "Error refreshing inventory.  Can not start service connection");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new IabException(-1003, "Error refreshing inventory.  Possible error in account registration.", localIllegalArgumentException);
    }
    Inventory localInventory = new Inventory();
    int i = queryPurchases(localInventory, "inapp");
    if (i != 0)
      throw new IabException(i, "Error refreshing inventory (querying owned items).");
    if (paramBoolean)
    {
      int j = querySkuDetails("inapp", localInventory, paramList1);
      if (j != 0)
        throw new IabException(j, "Error refreshing inventory (querying prices of items).");
    }
    if (subscriptionsSupported())
    {
      int k = queryPurchases(localInventory, "subs");
      if (k != 0)
        throw new IabException(k, "Error refreshing inventory (querying owned subscriptions).");
      if (paramBoolean)
      {
        int m = querySkuDetails("subs", localInventory, paramList2);
        if (m != 0)
          throw new IabException(m, "Error refreshing inventory (querying prices of subscriptions).");
      }
    }
    return localInventory;
  }

  public void queryInventoryAsync(IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(true, null, null, paramQueryInventoryFinishedListener);
  }

  public void queryInventoryAsync(final boolean paramBoolean, final List<String> paramList1, final List<String> paramList2, final IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    if (!this.mSetupDone)
    {
      paramQueryInventoryFinishedListener.onQueryInventoryFinished(new IabResult(-1003, "Error refreshing inventory.  Possible error in account registration."), null);
      return;
    }
    executeServiceRequest(new Runnable()
    {
      public void run()
      {
        Inventory localInventory;
        try
        {
          localInventory = new Inventory();
          int i = BillingClientHelper.this.queryPurchases(localInventory, "inapp");
          if (i != 0)
          {
            paramQueryInventoryFinishedListener.onQueryInventoryFinished(new IabResult(i, "Error refreshing inventory (querying owned items)."), localInventory);
            return;
          }
          if (paramBoolean)
          {
            int m = BillingClientHelper.this.querySkuDetails("inapp", localInventory, paramList1);
            if (m != 0)
            {
              paramQueryInventoryFinishedListener.onQueryInventoryFinished(new IabResult(m, "Error refreshing inventory (querying prices of items)."), localInventory);
              return;
            }
          }
        }
        catch (RemoteException localRemoteException)
        {
          paramQueryInventoryFinishedListener.onQueryInventoryFinished(new IabResult(-1001, "Remote exception while refreshing inventory."), null);
          return;
          if (BillingClientHelper.this.subscriptionsSupported())
          {
            int j = BillingClientHelper.this.queryPurchases(localInventory, "subs");
            if (j != 0)
            {
              paramQueryInventoryFinishedListener.onQueryInventoryFinished(new IabResult(j, "Error refreshing inventory (querying owned subscriptions)."), null);
              return;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          paramQueryInventoryFinishedListener.onQueryInventoryFinished(new IabResult(-1002, "Error parsing JSON response while refreshing inventory."), null);
          return;
          if (paramBoolean)
          {
            int k = BillingClientHelper.this.querySkuDetails("subs", localInventory, paramList2);
            if (k != 0)
            {
              paramQueryInventoryFinishedListener.onQueryInventoryFinished(new IabResult(k, "Error refreshing inventory (querying prices of subscriptions)."), localInventory);
              return;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          paramQueryInventoryFinishedListener.onQueryInventoryFinished(new IabResult(-1003, "Error refreshing inventory.  Possible error in account registration."), null);
          return;
        }
        IabResult localIabResult = new IabResult(0, "Inventory refresh successful.");
        paramQueryInventoryFinishedListener.onQueryInventoryFinished(localIabResult, localInventory);
      }
    });
  }

  public void queryInventoryAsync(boolean paramBoolean, IabHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(paramBoolean, null, null, paramQueryInventoryFinishedListener);
  }

  int queryPurchases(Inventory paramInventory, String paramString)
    throws JSONException, RemoteException
  {
    h.a locala = this.mBillingClient.b(paramString);
    int k;
    if (locala.a() != 0)
      k = locala.a();
    int j;
    do
    {
      return k;
      List localList = locala.b();
      int i = 0;
      j = 0;
      if (i < localList.size())
      {
        h localh = (h)localList.get(i);
        String str1 = localh.d();
        localh.a();
        if (isValidDataSignature(this.mSignatureBase64, localh.c(), str1))
        {
          Purchase localPurchase = new Purchase(paramString, localh.c(), str1, this.appstore.getAppstoreName());
          String str2 = localPurchase.getSku();
          localPurchase.setSku(SkuManager.getInstance().getSku(this.appstore.getAppstoreName(), str2));
          if (TextUtils.isEmpty(localPurchase.getToken()));
          paramInventory.addPurchase(localPurchase);
        }
        while (true)
        {
          i++;
          break;
          j = 1;
        }
      }
      k = 0;
    }
    while (j == 0);
    return -1003;
  }

  int querySkuDetails(final String paramString, final Inventory paramInventory, final List<String> paramList)
    throws RemoteException, JSONException
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    querySkuDetailsAsync(paramString, paramList, new l()
    {
      public void onSkuDetailsResponse(int paramAnonymousInt, List<j> paramAnonymousList)
      {
        SkuManager localSkuManager = SkuManager.getInstance();
        String str = BillingClientHelper.this.appstore.getAppstoreName();
        HashSet localHashSet = new HashSet();
        Iterator localIterator1 = paramInventory.getAllOwnedSkus(paramString).iterator();
        while (localIterator1.hasNext())
          localHashSet.add(localSkuManager.getStoreSku(str, (String)localIterator1.next()));
        if (paramList != null)
        {
          Iterator localIterator3 = paramList.iterator();
          while (localIterator3.hasNext())
            localHashSet.add(localSkuManager.getStoreSku(str, (String)localIterator3.next()));
        }
        if ((paramAnonymousInt == 0) && (paramAnonymousList != null) && (!paramAnonymousList.isEmpty()))
        {
          Iterator localIterator2 = paramAnonymousList.iterator();
          while (localIterator2.hasNext())
          {
            j localj = (j)localIterator2.next();
            SkuDetails localSkuDetails = BillingClientHelper.this.jsonSkuToSkuDetails(localj);
            localSkuDetails.setSku(SkuManager.getInstance().getSku(str, localSkuDetails.getSku()));
            paramInventory.addSkuDetails(localSkuDetails);
          }
        }
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await(3000L, TimeUnit.MILLISECONDS);
      return 0;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    return 6;
  }

  public void querySkuDetailsAsync(final String paramString, final List<String> paramList, final l paraml)
  {
    executeServiceRequest(new Runnable()
    {
      public void run()
      {
        k.a locala = k.c();
        if (paramList == null);
        for (Object localObject = new ArrayList(); ; localObject = paramList)
        {
          locala.a((List)localObject).a(paramString);
          BillingClientHelper.this.mBillingClient.a(locala.a(), new l()
          {
            public void onSkuDetailsResponse(int paramAnonymous2Int, List<j> paramAnonymous2List)
            {
              BillingClientHelper.7.this.val$listener.onSkuDetailsResponse(paramAnonymous2Int, paramAnonymous2List);
            }
          });
          return;
        }
      }
    });
  }

  public void setProductsData(List<String> paramList)
  {
  }

  public void startSetup(final IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    if (this.mSetupDone)
    {
      startInnerSetup(paramOnIabSetupFinishedListener);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        BillingClientHelper.access$002(BillingClientHelper.this, BillingClientHelper.this.buildBillingClient());
        BillingClientHelper.this.startInnerSetup(paramOnIabSetupFinishedListener);
      }
    });
  }

  public boolean subscriptionsSupported()
  {
    int i = this.mBillingClient.a("subscriptions");
    return (i == 0) || (i == 0);
  }

  public static abstract interface ServiceConnectedListener
  {
    public abstract void onServiceConnected(int paramInt);

    public abstract void onServiceDisconnected();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.googleBillingUtils.BillingClientHelper
 * JD-Core Version:    0.6.2
 */