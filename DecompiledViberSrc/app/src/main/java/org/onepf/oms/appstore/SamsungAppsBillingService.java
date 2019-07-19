package org.onepf.oms.appstore;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.sec.android.a.a;
import com.sec.android.a.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.OpenIabHelper.Options;
import org.onepf.oms.SkuManager;
import org.onepf.oms.appstore.googleUtils.IabException;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.appstore.googleUtils.Purchase;
import org.onepf.oms.appstore.googleUtils.SkuDetails;
import org.onepf.oms.util.CollectionUtils;

public class SamsungAppsBillingService
  implements AppstoreInAppBillingService
{
  public static final String ACCOUNT_ACTIVITY_NAME = "com.sec.android.iap.activity.AccountActivity";
  private static final int CURRENT_MODE = 0;
  public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 32;
  public static final int IAP_ERROR_ALREADY_PURCHASED = -1003;
  public static final int IAP_ERROR_COMMON = -1002;
  public static final int IAP_ERROR_CONFIRM_INBOX = -1006;
  public static final int IAP_ERROR_INITIALIZATION = -1000;
  public static final int IAP_ERROR_NEED_APP_UPGRADE = -1001;
  public static final int IAP_ERROR_NONE = 0;
  public static final int IAP_ERROR_PRODUCT_DOES_NOT_EXIST = -1005;
  public static final int IAP_ERROR_WHILE_RUNNING = -1004;
  public static final int IAP_MODE_COMMERCIAL = 0;
  public static final int IAP_MODE_TEST_FAIL = -1;
  public static final int IAP_MODE_TEST_SUCCESS = 1;
  public static final int IAP_PAYMENT_IS_CANCELED = 1;
  public static final int IAP_RESPONSE_RESULT_OK = 0;
  public static final int IAP_RESPONSE_RESULT_UNAVAILABLE = 2;
  public static final String IAP_SERVICE_NAME = "com.sec.android.iap.service.iapService";
  private static final int ITEM_RESPONSE_COUNT = 100;
  public static final String ITEM_TYPE_ALL = "10";
  public static final String ITEM_TYPE_CONSUMABLE = "00";
  public static final String ITEM_TYPE_NON_CONSUMABLE = "01";
  public static final String ITEM_TYPE_SUBSCRIPTION = "02";
  public static final String JSON_KEY_CURRENCY_UNIT = "mCurrencyUnit";
  public static final String JSON_KEY_ITEM_DESC = "mItemDesc";
  public static final String JSON_KEY_ITEM_DOWNLOAD_URL = "mItemDownloadUrl";
  public static final String JSON_KEY_ITEM_ID = "mItemId";
  public static final String JSON_KEY_ITEM_IMAGE_URL = "mItemImageUrl";
  public static final String JSON_KEY_ITEM_NAME = "mItemName";
  public static final String JSON_KEY_ITEM_PRICE = "mItemPrice";
  public static final String JSON_KEY_ITEM_PRICE_STRING = "mItemPriceString";
  public static final String JSON_KEY_PAYMENT_ID = "mPaymentId";
  public static final String JSON_KEY_PURCHASE_DATE = "mPurchaseDate";
  public static final String JSON_KEY_PURCHASE_ID = "mPurchaseId";
  public static final String JSON_KEY_TYPE = "mType";
  public static final String KEY_NAME_ERROR_STRING = "ERROR_STRING";
  public static final String KEY_NAME_IAP_UPGRADE_URL = "IAP_UPGRADE_URL";
  public static final String KEY_NAME_ITEM_GROUP_ID = "ITEM_GROUP_ID";
  public static final String KEY_NAME_ITEM_ID = "ITEM_ID";
  public static final String KEY_NAME_RESULT_LIST = "RESULT_LIST";
  public static final String KEY_NAME_RESULT_OBJECT = "RESULT_OBJECT";
  public static final String KEY_NAME_STATUS_CODE = "STATUS_CODE";
  public static final String KEY_NAME_THIRD_PARTY_NAME = "THIRD_PARTY_NAME";
  private static final Logger L = ViberEnv.getLogger();
  public static final String PAYMENT_ACTIVITY_NAME = "com.sec.android.iap.activity.PaymentMethodListActivity";
  public static final int REQUEST_CODE_IS_ACCOUNT_CERTIFICATION = 899;
  public static final int REQUEST_CODE_IS_IAP_PAYMENT = 1;
  private Activity activity;
  private volatile boolean isBound;
  private String mExtraData;
  private a mIapConnector;
  private String mItemGroupId;
  private IabHelper.OnIabPurchaseFinishedListener mPurchaseListener = null;
  private int mRequestCode;
  private OpenIabHelper.Options options;
  private String purchasingItemType;
  private ServiceConnection serviceConnection;
  private IabHelper.OnIabSetupFinishedListener setupListener = null;

  static
  {
    if (SamsungApps.isSamsungTestMode);
    for (int i = 1; ; i = 0)
    {
      CURRENT_MODE = i;
      return;
    }
  }

  public SamsungAppsBillingService(Activity paramActivity, OpenIabHelper.Options paramOptions)
  {
    this.activity = paramActivity;
    this.options = paramOptions;
  }

  private void bindIapService()
  {
    this.serviceConnection = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        SamsungAppsBillingService.access$002(SamsungAppsBillingService.this, a.a.a(paramAnonymousIBinder));
        if (SamsungAppsBillingService.this.mIapConnector != null)
        {
          SamsungAppsBillingService.this.initIap();
          return;
        }
        SamsungAppsBillingService.this.setupListener.onIabSetupFinished(new IabResult(6, "IAP service bind failed"));
      }

      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
      }
    };
    Intent localIntent = new Intent("com.sec.android.iap.service.iapService");
    this.isBound = this.activity.getApplicationContext().bindService(localIntent, this.serviceConnection, 1);
  }

  private String getItemGroupId(String paramString)
  {
    SamsungApps.checkSku(paramString);
    return paramString.split("/")[0];
  }

  private String getItemId(String paramString)
  {
    SamsungApps.checkSku(paramString);
    return paramString.split("/")[1];
  }

  private void initIap()
  {
    int i = 6;
    Object localObject = "Init IAP service failed";
    try
    {
      Bundle localBundle = this.mIapConnector.a(CURRENT_MODE);
      if (localBundle != null)
      {
        int j = localBundle.getInt("STATUS_CODE");
        String str = localBundle.getString("ERROR_STRING");
        localObject = str;
        if (j == 0)
          i = 0;
      }
      label53: this.setupListener.onIabSetupFinished(new IabResult(i, (String)localObject));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label53;
    }
  }

  private boolean processItemsBundle(Bundle paramBundle, String paramString, Inventory paramInventory, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Set<String> paramSet)
  {
    if ((paramBundle == null) || (paramBundle.getInt("STATUS_CODE") != 0))
      return false;
    ArrayList localArrayList = paramBundle.getStringArrayList("RESULT_LIST");
    Iterator localIterator = localArrayList.iterator();
    while (true)
    {
      String str1;
      if (localIterator.hasNext())
        str1 = (String)localIterator.next();
      try
      {
        JSONObject localJSONObject = new JSONObject(str1);
        String str2 = localJSONObject.getString("mItemId");
        if ((paramSet == null) || (paramSet.contains(str2)))
        {
          String str3 = localJSONObject.getString("mType");
          if ((!str3.equals("00")) || (paramBoolean3))
          {
            String str4;
            if (str3.equals("02"))
            {
              str4 = "subs";
              label128: if (!paramBoolean2)
                break label368;
              Purchase localPurchase = new Purchase("com.samsung.apps");
              localPurchase.setItemType(str4);
              localPurchase.setSku(SkuManager.getInstance().getSku("com.samsung.apps", paramString + '/' + str2));
              localPurchase.setPackageName(this.activity.getPackageName());
              localPurchase.setPurchaseState(0);
              localPurchase.setDeveloperPayload("");
              localPurchase.setOrderId(localJSONObject.getString("mPaymentId"));
              localPurchase.setPurchaseTime(Long.parseLong(localJSONObject.getString("mPurchaseDate")));
              localPurchase.setToken(localJSONObject.getString("mPurchaseId"));
              paramInventory.addPurchase(localPurchase);
            }
            while (true)
            {
              String str5 = localJSONObject.getString("mItemName");
              String str6 = localJSONObject.getString("mItemPriceString");
              String str7 = localJSONObject.getString("mItemDesc");
              paramInventory.addSkuDetails(new SkuDetails(str4, SkuManager.getInstance().getSku("com.samsung.apps", paramString + '/' + str2), str5, str6, str7));
              break;
              str4 = "inapp";
              break label128;
              return localArrayList.size() == 100;
              label368: if (paramBoolean2)
                if (!paramBoolean1)
                  break;
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
      }
    }
  }

  public void consume(Purchase paramPurchase)
    throws IabException
  {
  }

  public void dispose()
  {
    if ((this.serviceConnection != null) && (this.isBound))
    {
      this.activity.getApplicationContext().unbindService(this.serviceConnection);
      this.isBound = false;
    }
    this.serviceConnection = null;
    this.mIapConnector = null;
  }

  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 6;
    if (paramInt1 == this.options.getSamsungCertificationRequestCode())
    {
      if (paramInt2 == -1)
      {
        bindIapService();
        return true;
      }
      if (paramInt2 == 0)
      {
        this.setupListener.onIabSetupFinished(new IabResult(1, "Account certification canceled"));
        return true;
      }
      this.setupListener.onIabSetupFinished(new IabResult(i, "Unknown error. Result code: " + paramInt2));
      return true;
    }
    if (paramInt1 != this.mRequestCode)
      return false;
    String str1 = "Unknown error";
    Purchase localPurchase = new Purchase("com.samsung.apps");
    Bundle localBundle;
    int k;
    String str3;
    if (paramIntent != null)
    {
      localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        k = localBundle.getInt("STATUS_CODE");
        str1 = localBundle.getString("ERROR_STRING");
        str3 = localBundle.getString("ITEM_ID");
        switch (paramInt2)
        {
        default:
        case -1:
        case 0:
        }
      }
    }
    while (true)
    {
      String str4 = localBundle.getString("RESULT_OBJECT");
      try
      {
        JSONObject localJSONObject = new JSONObject(str4);
        localPurchase.setOriginalJson(str4);
        localPurchase.setOrderId(localJSONObject.getString("mPaymentId"));
        localPurchase.setPurchaseTime(Long.parseLong(localJSONObject.getString("mPurchaseDate")));
        localPurchase.setToken(localJSONObject.getString("mPurchaseId"));
        label250: localPurchase.setItemType(this.purchasingItemType);
        localPurchase.setSku(SkuManager.getInstance().getSku("com.samsung.apps", this.mItemGroupId + '/' + str3));
        localPurchase.setPackageName(this.activity.getPackageName());
        localPurchase.setPurchaseState(0);
        localPurchase.setDeveloperPayload(this.mExtraData);
        int j = i;
        String str2 = str1;
        this.mPurchaseListener.onIabPurchaseFinished(new IabResult(j, str2), localPurchase);
        return true;
        switch (k)
        {
        default:
          break;
        case -1005:
          i = 4;
          break;
        case 0:
          i = 0;
          break;
        case -1003:
          i = 7;
          continue;
          i = 1;
        }
      }
      catch (JSONException localJSONException)
      {
        break label250;
      }
    }
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4)
  {
    String str1 = getItemGroupId(paramString1);
    String str2 = getItemId(paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putString("THIRD_PARTY_NAME", paramActivity.getPackageName());
    localBundle.putString("ITEM_GROUP_ID", str1);
    localBundle.putString("ITEM_ID", str2);
    ComponentName localComponentName = new ComponentName("com.sec.android.iap", "com.sec.android.iap.activity.PaymentMethodListActivity");
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setComponent(localComponentName);
    localIntent.putExtras(localBundle);
    this.mRequestCode = paramInt;
    this.mPurchaseListener = paramOnIabPurchaseFinishedListener;
    this.purchasingItemType = paramString2;
    this.mItemGroupId = str1;
    this.mExtraData = paramString4;
    paramActivity.startActivityForResult(localIntent, paramInt);
  }

  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException
  {
    Inventory localInventory = new Inventory();
    Date localDate = new Date();
    String str1 = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(localDate);
    HashSet localHashSet1 = new HashSet();
    List localList = SkuManager.getInstance().getAllStoreSkus("com.samsung.apps");
    if (!CollectionUtils.isEmpty(localList))
    {
      Iterator localIterator5 = localList.iterator();
      while (localIterator5.hasNext())
        localHashSet1.add(getItemGroupId((String)localIterator5.next()));
    }
    Iterator localIterator1 = localHashSet1.iterator();
    while (true)
    {
      String str5;
      int n;
      int i1;
      if (localIterator1.hasNext())
      {
        str5 = (String)localIterator1.next();
        n = 1;
        i1 = 100;
      }
      try
      {
        do
        {
          Bundle localBundle4 = this.mIapConnector.a(this.activity.getPackageName(), str5, n, i1, "19700101", str1);
          localBundle3 = localBundle4;
          n += 100;
          i1 += 100;
        }
        while (processItemsBundle(localBundle3, str5, localInventory, paramBoolean, true, false, null));
        continue;
        if (paramBoolean)
        {
          HashSet localHashSet2 = new HashSet();
          HashSet localHashSet3 = new HashSet();
          if (paramList1 != null)
          {
            Iterator localIterator4 = paramList1.iterator();
            while (localIterator4.hasNext())
            {
              String str4 = (String)localIterator4.next();
              localHashSet2.add(getItemGroupId(str4));
              localHashSet3.add(getItemId(str4));
            }
          }
          if (paramList2 != null)
          {
            Iterator localIterator3 = paramList2.iterator();
            while (localIterator3.hasNext())
            {
              String str3 = (String)localIterator3.next();
              localHashSet2.add(getItemGroupId(str3));
              localHashSet3.add(getItemId(str3));
            }
          }
          if (!localHashSet3.isEmpty())
          {
            Iterator localIterator2 = localHashSet2.iterator();
            while (true)
              if (localIterator2.hasNext())
              {
                String str2 = (String)localIterator2.next();
                int i = 1;
                int j = 100;
                try
                {
                  while (true)
                  {
                    Bundle localBundle2 = this.mIapConnector.a(CURRENT_MODE, this.activity.getPackageName(), str2, i, j, "10");
                    localBundle1 = localBundle2;
                    int k = i + 100;
                    int m = j + 100;
                    if (!processItemsBundle(localBundle1, str2, localInventory, paramBoolean, false, true, localHashSet3))
                      break;
                    j = m;
                    i = k;
                  }
                }
                catch (RemoteException localRemoteException1)
                {
                  while (true)
                    Bundle localBundle1 = null;
                }
              }
          }
        }
        return localInventory;
      }
      catch (RemoteException localRemoteException2)
      {
        while (true)
          Bundle localBundle3 = null;
      }
    }
  }

  public void setProductsData(List<String> paramList)
  {
  }

  public void startSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    this.setupListener = paramOnIabSetupFinishedListener;
    ComponentName localComponentName = new ComponentName("com.sec.android.iap", "com.sec.android.iap.activity.AccountActivity");
    Intent localIntent = new Intent();
    localIntent.setComponent(localComponentName);
    this.activity.startActivityForResult(localIntent, this.options.getSamsungCertificationRequestCode());
  }

  public boolean subscriptionsSupported()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.SamsungAppsBillingService
 * JD-Core Version:    0.6.2
 */