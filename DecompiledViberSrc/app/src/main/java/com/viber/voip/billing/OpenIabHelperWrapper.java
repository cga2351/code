package com.viber.voip.billing;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.viber.dexshared.BillingHost;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.ActivityListener;
import org.onepf.oms.InAppBillingHelper.OnConsumeFinishedListener;
import org.onepf.oms.InAppBillingHelper.OnConsumeMultiFinishedListener;
import org.onepf.oms.InAppBillingHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.InAppBillingHelper.OnIabSetupFinishedListener;
import org.onepf.oms.InAppBillingHelper.QueryInventoryFinishedListener;
import org.onepf.oms.InAppBillingHelper.QueryProductDetailsFinishedListener;
import org.onepf.oms.InAppUtils;
import org.onepf.oms.OpenIabHelper;
import org.onepf.oms.OpenIabHelper.Options.Builder;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnConsumeFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnConsumeMultiFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.QueryInventoryFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.appstore.googleUtils.SkuDetails;

public class OpenIabHelperWrapper
  implements InAppBillingHelper, InAppUtils
{
  private static final int AMAZON_PURCHASE_TIMEOUT = 3000;
  private static final Logger L = ViberEnv.getLogger("OpenIabHelperWrapper");
  static ProductDetailsCache mProductDetailsCache = new ProductDetailsCache();
  private static HashMap<String, IabProductId> productMap = new HashMap();
  private static final Map<String, String> storeToProviderMap = new HashMap();
  private volatile boolean isIABHelperSetup;
  private InAppBillingHelper.ActivityListener mActivityListener;
  private Context mContext;
  private a mExecutor = new a();
  private OpenIabHelper mOpenIabHelper;

  static
  {
    useBillingClientLib();
    storeToProviderMap.put("amazon", "amazon");
    storeToProviderMap.put("android", "google_play");
  }

  public OpenIabHelperWrapper(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public static void dumpIntent(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
          ((String)localIterator.next());
      }
    }
  }

  public static void dumpMap(Map<?, ?> paramMap)
  {
  }

  private IabProductId findIabProductbyId(String paramString, List<IabProductId> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IabProductId localIabProductId = (IabProductId)localIterator.next();
      if (paramString.equals(localIabProductId.toString()))
        return localIabProductId;
    }
    return null;
  }

  public static String getPreferredProvider()
  {
    return (String)storeToProviderMap.get(getPreferredStore());
  }

  public static String getPreferredStore()
  {
    int i = 1;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "android";
    arrayOfString[i] = "amazon";
    try
    {
      boolean bool = "com.amazon.venezia".equals(ViberEnv.getBillingHost().getInstallerPackageName());
      if (bool)
        return arrayOfString[i];
    }
    catch (Exception localException)
    {
      while (true)
      {
        i = 0;
        continue;
        i = 0;
      }
    }
  }

  private String getProviderByInstaller()
  {
    try
    {
      String str = this.mContext.getPackageManager().getInstallerPackageName(this.mContext.getPackageName());
      if ("com.amazon.venezia".equals(str))
        return "amazon";
      if ("com.android.vending".equals(str))
        return "google_play";
      return "amazon";
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  static boolean isAmazonAvailable()
  {
    try
    {
      OpenIabHelperWrapper.class.getClassLoader().loadClass("com.amazon.device.iap.PurchasingService");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  private boolean isCacheEnable()
  {
    return true;
  }

  private void notifyActivityListener()
  {
    if (this.mActivityListener != null)
      this.mActivityListener.onIabActivity();
  }

  private Map<String, ArrayList<String>>[] productListToProviderMap(List<IabProductId> paramList)
  {
    HashMap[] arrayOfHashMap = new HashMap[2];
    arrayOfHashMap[0] = new HashMap();
    arrayOfHashMap[1] = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IabProductId localIabProductId = (IabProductId)localIterator.next();
      if (localIabProductId.getItemType() == "inapp")
      {
        if (!arrayOfHashMap[0].keySet().contains(localIabProductId.getProviderId()))
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localIabProductId.toString());
          arrayOfHashMap[0].put(localIabProductId.getProviderId(), localArrayList2);
        }
        else
        {
          ((ArrayList)arrayOfHashMap[0].get(localIabProductId.getProviderId())).add(localIabProductId.toString());
        }
      }
      else if (!arrayOfHashMap[1].keySet().contains(localIabProductId.getProviderId()))
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(localIabProductId.toString());
        arrayOfHashMap[1].put(localIabProductId.getProviderId(), localArrayList1);
      }
      else
      {
        ((ArrayList)arrayOfHashMap[1].get(localIabProductId.getProviderId())).add(localIabProductId.toString());
      }
    }
    return arrayOfHashMap;
  }

  private void queryInventoryAsyncNoProduct(final boolean paramBoolean, final InAppBillingHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    this.mExecutor.a(new Runnable()
    {
      public void run()
      {
        if (!OpenIabHelperWrapper.this.isIABHelperSetup)
        {
          IabResult localIabResult = new IabResult(-1008, "OpenIab not initialized");
          if (paramQueryInventoryFinishedListener != null)
            paramQueryInventoryFinishedListener.onQueryInventoryFinished(localIabResult, null);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        OpenIabHelperWrapper.this.mOpenIabHelper.setProvider(OpenIabHelperWrapper.getPreferredProvider());
        OpenIabHelperWrapper.this.mOpenIabHelper.queryInventoryAsync(paramBoolean, null, new IabHelper.QueryInventoryFinishedListener()
        {
          public void onQueryInventoryFinished(IabResult paramAnonymous2IabResult, Inventory paramAnonymous2Inventory)
          {
            if (OpenIabHelperWrapper.5.this.a != null)
            {
              IabInventory localIabInventory = new IabInventory();
              if (paramAnonymous2IabResult.isSuccess())
              {
                Iterator localIterator = paramAnonymous2Inventory.getPurchaseMap().values().iterator();
                while (localIterator.hasNext())
                {
                  org.onepf.oms.appstore.googleUtils.Purchase localPurchase = (org.onepf.oms.appstore.googleUtils.Purchase)localIterator.next();
                  localIabInventory.addPurchase(OpenIabHelperWrapper.this.toBillingPurchase(localPurchase, IabProductId.fromString(localPurchase.getSku())));
                }
              }
              OpenIabHelperWrapper.5.this.a.onQueryInventoryFinished(paramAnonymous2IabResult, localIabInventory);
            }
            OpenIabHelperWrapper.this.notifyActivityListener();
          }
        });
      }
    });
  }

  private ProductDetails scuToProductDetails(SkuDetails paramSkuDetails, IabProductId paramIabProductId)
  {
    if (paramIabProductId == null);
    for (IabProductId localIabProductId = IabProductId.fromString(paramSkuDetails.getSku()); ; localIabProductId = paramIabProductId)
      try
      {
        ProductDetails localProductDetails = new ProductDetails(paramSkuDetails.getItemType(), paramSkuDetails.getJson());
        return localProductDetails;
      }
      catch (Exception localException)
      {
        return new ProductDetails(paramSkuDetails.getItemType(), localIabProductId, paramSkuDetails.getTitle(), paramSkuDetails.getPrice(), paramSkuDetails.getDescription(), paramSkuDetails.getPriceAmountMicros(), paramSkuDetails.getPriceCurrencyCode());
      }
  }

  private Purchase toBillingPurchase(org.onepf.oms.appstore.googleUtils.Purchase paramPurchase, IabProductId paramIabProductId)
  {
    Purchase localPurchase = null;
    if (paramPurchase != null)
      if (paramIabProductId != null)
        break label70;
    label70: for (IabProductId localIabProductId = IabProductId.fromString(paramPurchase.getSku()); ; localIabProductId = paramIabProductId)
    {
      localPurchase = new Purchase(paramPurchase.getOrderId(), paramPurchase.getPackageName(), localIabProductId, paramPurchase.getItemType(), paramPurchase.getPurchaseTime(), paramPurchase.getPurchaseState(), paramPurchase.getDeveloperPayload(), paramPurchase.getToken(), paramPurchase.getOriginalJson(), paramPurchase.getSignature(), false, false, false);
      return localPurchase;
    }
  }

  private org.onepf.oms.appstore.googleUtils.Purchase toOiabPurchase(Purchase paramPurchase)
  {
    org.onepf.oms.appstore.googleUtils.Purchase localPurchase = null;
    if (paramPurchase != null);
    try
    {
      localPurchase = new org.onepf.oms.appstore.googleUtils.Purchase(paramPurchase.getItemType(), paramPurchase.getOriginalJson(), paramPurchase.getSignature(), this.mOpenIabHelper.getConnectedAppstoreName());
      return localPurchase;
    }
    catch (Exception localException)
    {
    }
    return new org.onepf.oms.appstore.googleUtils.Purchase(paramPurchase.getOrderId(), paramPurchase.getPackageName(), paramPurchase.getProductId().toString(), paramPurchase.getPurchaseTime(), paramPurchase.getPurchaseState(), paramPurchase.getDeveloperPayload(), paramPurchase.getToken(), paramPurchase.getOriginalJson(), paramPurchase.getSignature());
  }

  private static boolean useBillingClientLib()
  {
    return true;
  }

  public void consumeAsync(final Purchase paramPurchase, final InAppBillingHelper.OnConsumeFinishedListener paramOnConsumeFinishedListener)
  {
    this.mExecutor.a(new Runnable()
    {
      public void run()
      {
        if (!OpenIabHelperWrapper.this.isIABHelperSetup)
        {
          IabResult localIabResult = new IabResult(-1008, "OpenIab not initialized");
          if (paramOnConsumeFinishedListener != null)
            paramOnConsumeFinishedListener.onConsumeFinished(null, localIabResult);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        OpenIabHelperWrapper.this.mOpenIabHelper.setProvider(paramPurchase.getProductId().getProviderId());
        org.onepf.oms.appstore.googleUtils.Purchase localPurchase = OpenIabHelperWrapper.this.toOiabPurchase(paramPurchase);
        OpenIabHelperWrapper.this.mOpenIabHelper.consumeAsync(localPurchase, new IabHelper.OnConsumeFinishedListener()
        {
          public void onConsumeFinished(org.onepf.oms.appstore.googleUtils.Purchase paramAnonymous2Purchase, IabResult paramAnonymous2IabResult)
          {
            if (OpenIabHelperWrapper.7.this.a != null)
              OpenIabHelperWrapper.7.this.a.onConsumeFinished(OpenIabHelperWrapper.7.this.b, paramAnonymous2IabResult);
            OpenIabHelperWrapper.this.notifyActivityListener();
          }
        });
      }
    });
  }

  public void consumeAsync(final List<Purchase> paramList, final InAppBillingHelper.OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener)
  {
    this.mExecutor.a(new Runnable()
    {
      public void run()
      {
        if (!OpenIabHelperWrapper.this.isIABHelperSetup)
        {
          IabResult[] arrayOfIabResult = new IabResult[1];
          arrayOfIabResult[0] = new IabResult(-1008, "OpenIab not initialized");
          if (paramOnConsumeMultiFinishedListener != null)
            paramOnConsumeMultiFinishedListener.onConsumeMultiFinished(null, Arrays.asList(arrayOfIabResult));
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        ArrayList localArrayList = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Purchase localPurchase = (Purchase)localIterator.next();
          localArrayList.add(OpenIabHelperWrapper.this.toOiabPurchase(localPurchase));
        }
        OpenIabHelperWrapper.this.mOpenIabHelper.consumeAsync(localArrayList, new IabHelper.OnConsumeMultiFinishedListener()
        {
          public void onConsumeMultiFinished(List<org.onepf.oms.appstore.googleUtils.Purchase> paramAnonymous2List, List<IabResult> paramAnonymous2List1)
          {
            if (OpenIabHelperWrapper.8.this.a != null)
              OpenIabHelperWrapper.8.this.a.onConsumeMultiFinished(OpenIabHelperWrapper.8.this.b, paramAnonymous2List1);
            OpenIabHelperWrapper.this.notifyActivityListener();
          }
        });
      }
    });
  }

  public void dispose()
  {
    this.isIABHelperSetup = false;
    this.mOpenIabHelper.dispose();
    this.mExecutor.b();
  }

  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    dumpIntent(paramIntent);
    notifyActivityListener();
    return this.mOpenIabHelper.handleActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void launchPurchaseFlow(Activity paramActivity, IabProductId paramIabProductId, int paramInt, String paramString, InAppBillingHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchPurchaseFlow(paramActivity, paramIabProductId, paramInt, paramString, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchPurchaseFlow(Activity paramActivity, IabProductId paramIabProductId, int paramInt, String paramString1, InAppBillingHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString2)
  {
    launchPurchaseFlow(paramActivity, paramIabProductId, "inapp", paramInt, paramString1, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchPurchaseFlow(final Activity paramActivity, final IabProductId paramIabProductId, final String paramString1, final int paramInt, final String paramString2, final InAppBillingHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, final String paramString3)
  {
    this.mExecutor.a(new Runnable()
    {
      public void run()
      {
        if (!OpenIabHelperWrapper.this.isIABHelperSetup)
        {
          IabResult localIabResult1 = new IabResult(-1008, "OpenIab not initialized");
          if (paramOnIabPurchaseFinishedListener != null)
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult1, null);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        OpenIabHelperWrapper.dumpMap(OpenIabHelperWrapper.productMap);
        if ((TextUtils.isEmpty(paramIabProductId.getJson())) && (OpenIabHelperWrapper.productMap.containsKey(paramIabProductId.toString())));
        String str1;
        for (IabProductId localIabProductId = (IabProductId)OpenIabHelperWrapper.productMap.get(paramIabProductId.toString()); ; localIabProductId = paramIabProductId)
        {
          str1 = localIabProductId.getProviderId();
          if (("google_play".equals(str1)) && (localIabProductId.toString().contains("stickers")))
            str1 = OpenIabHelperWrapper.getPreferredProvider();
          if (OpenIabHelperWrapper.this.mOpenIabHelper.setProvider(str1))
            break;
          IabResult localIabResult2 = new IabResult(-1008, "Provider not found");
          if (paramOnIabPurchaseFinishedListener != null)
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult2, null);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        final Runnable local1 = new Runnable()
        {
          public void run()
          {
            OpenIabHelperWrapper.3.this.a.onIabPurchaseFinished(new IabResult(6, "Purchase failed"), null);
          }
        };
        if ("amazon".equals(str1))
        {
          BroadcastReceiver local2 = new BroadcastReceiver()
          {
            public void onReceive(Context paramAnonymous2Context, Intent paramAnonymous2Intent)
            {
              if (paramAnonymous2Intent != null)
              {
                paramAnonymous2Intent.getStringExtra("purchaseOutput");
                OpenIabHelperWrapper.this.mExecutor.a(local1, 3000L);
              }
              OpenIabHelperWrapper.this.mContext.unregisterReceiver(this);
            }
          };
          if (paramOnIabPurchaseFinishedListener != null)
            OpenIabHelperWrapper.this.mContext.registerReceiver(local2, new IntentFilter("com.amazon.inapp.purchasing.NOTIFY"));
        }
        String str2 = localIabProductId.toString();
        OpenIabHelperWrapper.this.mOpenIabHelper.launchPurchaseFlow(paramActivity, str2, paramString1, paramInt, paramString2, new k(this, paramOnIabPurchaseFinishedListener, localIabProductId, local1), paramString3);
      }
    });
  }

  public void launchSubscriptionPurchaseFlow(Activity paramActivity, IabProductId paramIabProductId, int paramInt, String paramString, InAppBillingHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener)
  {
    launchSubscriptionPurchaseFlow(paramActivity, paramIabProductId, paramInt, paramString, paramOnIabPurchaseFinishedListener, "");
  }

  public void launchSubscriptionPurchaseFlow(final Activity paramActivity, final IabProductId paramIabProductId, final int paramInt, final String paramString1, final InAppBillingHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, final String paramString2)
  {
    this.mExecutor.a(new Runnable()
    {
      public void run()
      {
        if (!OpenIabHelperWrapper.this.isIABHelperSetup)
        {
          IabResult localIabResult1 = new IabResult(-1008, "OpenIab not initialized");
          if (paramOnIabPurchaseFinishedListener != null)
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult1, null);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        OpenIabHelperWrapper.dumpMap(OpenIabHelperWrapper.productMap);
        if ((TextUtils.isEmpty(paramIabProductId.getJson())) && (OpenIabHelperWrapper.productMap.containsKey(paramIabProductId.toString())));
        for (IabProductId localIabProductId = (IabProductId)OpenIabHelperWrapper.productMap.get(paramIabProductId.toString()); ; localIabProductId = paramIabProductId)
        {
          String str1 = localIabProductId.getProviderId();
          if (("google_play".equals(str1)) && (localIabProductId.toString().contains("stickers")))
            str1 = OpenIabHelperWrapper.getPreferredProvider();
          if (OpenIabHelperWrapper.this.mOpenIabHelper.setProvider(str1))
            break;
          IabResult localIabResult2 = new IabResult(-1008, "Provider not found");
          if (paramOnIabPurchaseFinishedListener != null)
            paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult2, null);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        String str2 = localIabProductId.toString();
        OpenIabHelperWrapper.this.mOpenIabHelper.launchSubscriptionPurchaseFlow(paramActivity, str2, paramInt, paramString1, new j(this, paramOnIabPurchaseFinishedListener, localIabProductId), paramString2);
      }
    });
  }

  public void parentActivityResumed()
  {
  }

  public void queryInventoryAsync(InAppBillingHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(true, null, paramQueryInventoryFinishedListener);
  }

  public void queryInventoryAsync(final boolean paramBoolean, final List<IabProductId> paramList, final InAppBillingHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    this.mExecutor.a(new Runnable()
    {
      public void run()
      {
        if (!OpenIabHelperWrapper.this.isIABHelperSetup)
        {
          IabResult localIabResult1 = new IabResult(-1008, "OpenIab not initialized");
          if (paramQueryInventoryFinishedListener != null)
            paramQueryInventoryFinishedListener.onQueryInventoryFinished(localIabResult1, null);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        if (!OpenIabHelperWrapper.this.mOpenIabHelper.setupSuccessful())
        {
          IabResult localIabResult2 = new IabResult(-1008, "OpenIab in invalid state");
          if (paramQueryInventoryFinishedListener != null)
            paramQueryInventoryFinishedListener.onQueryInventoryFinished(localIabResult2, null);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        if ((paramList == null) || (paramList.size() == 0))
        {
          OpenIabHelperWrapper.this.queryInventoryAsyncNoProduct(paramBoolean, paramQueryInventoryFinishedListener);
          return;
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        if (paramList != null)
        {
          Iterator localIterator8 = paramList.iterator();
          while (localIterator8.hasNext())
          {
            IabProductId localIabProductId2 = (IabProductId)localIterator8.next();
            if (!TextUtils.isEmpty(localIabProductId2.getJson()))
            {
              if (localIabProductId2.getItemType() == "subs")
                localArrayList2.add(localIabProductId2.getJson());
              while (true)
              {
                OpenIabHelperWrapper.productMap.put(localIabProductId2.getMerchantProductId(), localIabProductId2);
                break;
                localArrayList1.add(localIabProductId2.getJson());
              }
            }
          }
          if (localArrayList1.size() > 0)
            OpenIabHelperWrapper.this.mOpenIabHelper.setProductsData(localArrayList1);
          if (localArrayList2.size() > 0)
            OpenIabHelperWrapper.this.mOpenIabHelper.setProductsData(localArrayList2);
        }
        ArrayList localArrayList3 = new ArrayList();
        ArrayList localArrayList4 = new ArrayList();
        IabInventory localIabInventory = new IabInventory();
        if ((paramList != null) && (paramList.size() > 0))
        {
          Iterator localIterator7 = paramList.iterator();
          while (localIterator7.hasNext())
          {
            IabProductId localIabProductId1 = (IabProductId)localIterator7.next();
            if (OpenIabHelperWrapper.this.isCacheEnable())
            {
              ProductDetails localProductDetails2 = OpenIabHelperWrapper.mProductDetailsCache.get(localIabProductId1);
              if (localProductDetails2 != null)
              {
                localIabInventory.addProductDetails(localProductDetails2);
                localArrayList4.add(localIabProductId1.toString());
              }
              else
              {
                localArrayList3.add(localIabProductId1.toString());
              }
            }
            else
            {
              localArrayList3.add(localIabProductId1.toString());
            }
          }
        }
        if (localArrayList3.size() == 0)
        {
          IabResult localIabResult3 = new IabResult(0, "Nothing to query");
          if (paramQueryInventoryFinishedListener != null)
            paramQueryInventoryFinishedListener.onQueryInventoryFinished(localIabResult3, localIabInventory);
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
        }
        Map[] arrayOfMap = OpenIabHelperWrapper.this.productListToProviderMap(paramList);
        Map localMap1 = arrayOfMap[0];
        Map localMap2 = arrayOfMap[1];
        HashSet localHashSet = new HashSet();
        localHashSet.addAll(localMap1.keySet());
        localHashSet.addAll(localMap2.keySet());
        if (!localArrayList4.isEmpty())
        {
          Iterator localIterator4 = localArrayList4.iterator();
          while (localIterator4.hasNext())
          {
            String str3 = (String)localIterator4.next();
            Iterator localIterator5 = localMap1.values().iterator();
            while (localIterator5.hasNext())
              ((ArrayList)localIterator5.next()).remove(str3);
            Iterator localIterator6 = localMap2.values().iterator();
            while (localIterator6.hasNext())
              ((ArrayList)localIterator6.next()).remove(str3);
          }
        }
        Iterator localIterator1 = localHashSet.iterator();
        final Inventory localInventory = new Inventory();
        final IabResult[] arrayOfIabResult = new IabResult[localHashSet.size()];
        final Semaphore localSemaphore = new Semaphore(1);
        final int[] arrayOfInt = { 0 };
        OpenIabHelperWrapper.dumpMap(localMap1);
        OpenIabHelperWrapper.dumpMap(localMap2);
        String str1;
        ArrayList localArrayList5;
        ArrayList localArrayList6;
        String str2;
        if (localIterator1.hasNext())
        {
          str1 = (String)localIterator1.next();
          localArrayList5 = (ArrayList)localMap1.get(str1);
          localArrayList6 = (ArrayList)localMap2.get(str1);
          if ((localArrayList5 != null) && (localArrayList5.size() > 0))
            str2 = (String)localArrayList5.get(0);
        }
        while (true)
        {
          if (("google_play".equals(str1)) && (str2 != null) && (str2.contains("stickers")))
            str1 = OpenIabHelperWrapper.getPreferredProvider();
          localSemaphore.acquireUninterruptibly();
          if (!OpenIabHelperWrapper.this.mOpenIabHelper.setProvider(str1))
          {
            arrayOfIabResult[arrayOfInt[0]] = new IabResult(-1008, "Store not found");
            arrayOfInt[0] = (1 + arrayOfInt[0]);
            localSemaphore.release();
            break;
            if ((localArrayList6 == null) || (localArrayList6.size() <= 0))
              break label1293;
            str2 = (String)localArrayList6.get(0);
            continue;
          }
          OpenIabHelperWrapper.this.mOpenIabHelper.queryInventoryAsync(paramBoolean, localArrayList5, localArrayList6, new IabHelper.QueryInventoryFinishedListener()
          {
            public void onQueryInventoryFinished(IabResult paramAnonymous2IabResult, Inventory paramAnonymous2Inventory)
            {
              if (paramAnonymous2IabResult.isSuccess())
                localInventory.addInventory(paramAnonymous2Inventory);
              arrayOfIabResult[arrayOfInt[0]] = paramAnonymous2IabResult;
              int[] arrayOfInt = arrayOfInt;
              arrayOfInt[0] = (1 + arrayOfInt[0]);
              localSemaphore.release();
            }
          });
          break;
          localSemaphore.acquireUninterruptibly();
          localSemaphore.release();
          int i = 0;
          Object localObject1 = null;
          Object localObject2 = null;
          int j = arrayOfIabResult.length;
          int k = 0;
          if (k < j)
          {
            Object localObject3 = arrayOfIabResult[k];
            int m;
            Object localObject5;
            if ((localObject3 == null) || (((IabResult)localObject3).isFailure()))
            {
              m = i + 1;
              Object localObject4 = localObject2;
              localObject5 = localObject3;
              localObject3 = localObject4;
            }
            while (true)
            {
              k++;
              i = m;
              localObject1 = localObject5;
              localObject2 = localObject3;
              break;
              localObject5 = localObject1;
              m = i;
            }
          }
          if (i == arrayOfIabResult.length);
          while (paramQueryInventoryFinishedListener != null)
          {
            if (localObject1.isSuccess())
            {
              Map localMap3 = localInventory.getSkuMap();
              Map localMap4 = localInventory.getPurchaseMap();
              Iterator localIterator2 = localMap3.values().iterator();
              while (true)
                if (localIterator2.hasNext())
                {
                  SkuDetails localSkuDetails = (SkuDetails)localIterator2.next();
                  ProductDetails localProductDetails1 = OpenIabHelperWrapper.this.scuToProductDetails(localSkuDetails, OpenIabHelperWrapper.access$1000(OpenIabHelperWrapper.this, localSkuDetails.getSku(), paramList));
                  localIabInventory.addProductDetails(localProductDetails1);
                  OpenIabHelperWrapper.mProductDetailsCache.put(localProductDetails1);
                  continue;
                  localObject1 = localObject2;
                  break;
                }
              Iterator localIterator3 = localMap4.values().iterator();
              while (localIterator3.hasNext())
              {
                org.onepf.oms.appstore.googleUtils.Purchase localPurchase = (org.onepf.oms.appstore.googleUtils.Purchase)localIterator3.next();
                localIabInventory.addPurchase(OpenIabHelperWrapper.this.toBillingPurchase(localPurchase, OpenIabHelperWrapper.access$1000(OpenIabHelperWrapper.this, localPurchase.getSku(), paramList)));
              }
            }
            paramQueryInventoryFinishedListener.onQueryInventoryFinished(localObject1, localIabInventory);
          }
          OpenIabHelperWrapper.this.notifyActivityListener();
          return;
          label1293: str2 = "";
        }
      }
    });
  }

  public void queryInventoryAsync(boolean paramBoolean, InAppBillingHelper.QueryInventoryFinishedListener paramQueryInventoryFinishedListener)
  {
    queryInventoryAsync(paramBoolean, null, paramQueryInventoryFinishedListener);
  }

  public void queryProductDetailsAsync(IabProductId paramIabProductId, InAppBillingHelper.QueryProductDetailsFinishedListener paramQueryProductDetailsFinishedListener)
  {
    queryProductDetailsAsync(Arrays.asList(new IabProductId[] { paramIabProductId }), paramQueryProductDetailsFinishedListener);
  }

  public void queryProductDetailsAsync(List<IabProductId> paramList, final InAppBillingHelper.QueryProductDetailsFinishedListener paramQueryProductDetailsFinishedListener)
  {
    queryInventoryAsync(true, paramList, new InAppBillingHelper.QueryInventoryFinishedListener()
    {
      public void onQueryInventoryFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        if (paramQueryProductDetailsFinishedListener != null)
          paramQueryProductDetailsFinishedListener.onQueryProductDetailsFinished(paramAnonymousIabResult, paramAnonymousIabInventory);
      }
    });
  }

  public void setActivityListener(InAppBillingHelper.ActivityListener paramActivityListener)
  {
    this.mActivityListener = paramActivityListener;
  }

  public void startSetup(final InAppBillingHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    this.mExecutor.a(true);
    boolean bool = useBillingClientLib();
    OpenIabHelper.Options.Builder localBuilder1 = new OpenIabHelper.Options.Builder().setCheckInventory(false).setStoreSearchStrategy(1);
    String[] arrayOfString = new String[1];
    if (bool);
    for (String str = "com.google.play.client"; ; str = "com.google.play")
    {
      arrayOfString[0] = str;
      OpenIabHelper.Options.Builder localBuilder2 = localBuilder1.addPreferredStoreName(arrayOfString).setVerifyMode(1);
      this.mOpenIabHelper = new OpenIabHelper(this.mContext, localBuilder2.build());
      this.mOpenIabHelper.startSetup(new IabHelper.OnIabSetupFinishedListener()
      {
        public void onIabSetupFinished(IabResult paramAnonymousIabResult)
        {
          OpenIabHelperWrapper.access$002(OpenIabHelperWrapper.this, paramAnonymousIabResult.isSuccess());
          if (OpenIabHelperWrapper.this.isIABHelperSetup)
            OpenIabHelperWrapper.this.mExecutor.a(false);
          if (paramOnIabSetupFinishedListener != null)
            paramOnIabSetupFinishedListener.onIabSetupFinished(paramAnonymousIabResult);
        }
      });
      return;
    }
  }

  public boolean subscriptionsSupported()
  {
    return this.mOpenIabHelper.subscriptionsSupported();
  }

  private class a
  {
    private ArrayList<Runnable> b = new ArrayList();
    private boolean c;
    private Handler d;

    public a()
    {
      HandlerThread localHandlerThread = new HandlerThread("OpenIabHelperWrapperThread");
      localHandlerThread.start();
      this.d = new Handler(localHandlerThread.getLooper());
    }

    void a()
    {
      this.b.clear();
    }

    void a(Runnable paramRunnable)
    {
      if (this.c)
      {
        this.b.add(paramRunnable);
        return;
      }
      this.d.post(paramRunnable);
    }

    void a(Runnable paramRunnable, long paramLong)
    {
      this.d.postDelayed(paramRunnable, paramLong);
    }

    void a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      if (!paramBoolean)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          Runnable localRunnable = (Runnable)localIterator.next();
          this.d.post(localRunnable);
        }
        this.b.clear();
      }
    }

    void b()
    {
      a();
      this.d.removeCallbacksAndMessages(null);
      this.d.getLooper().quit();
    }

    void b(Runnable paramRunnable)
    {
      this.d.removeCallbacks(paramRunnable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.OpenIabHelperWrapper
 * JD-Core Version:    0.6.2
 */