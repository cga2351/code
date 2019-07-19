package org.onepf.oms.appstore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductDataResponse.RequestStatus;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseResponse.RequestStatus;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.amazon.device.iap.model.UserDataResponse.RequestStatus;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.appstore.googleUtils.IabException;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.appstore.googleUtils.Purchase;
import org.onepf.oms.appstore.googleUtils.SkuDetails;

public class AmazonAppstoreBillingService
  implements PurchasingListener, AppstoreInAppBillingService
{
  public static final int AMAZON_TIMEOUT_BILLING_SUPPORTED = 5000;
  public static final String JSON_KEY_ORDER_ID = "orderId";
  public static final String JSON_KEY_PRODUCT_ID = "productId";
  public static final String JSON_KEY_PURCHASE_STATUS = "purchaseStatus";
  public static final String JSON_KEY_RECEIPT_ITEM_TYPE = "itemType";
  public static final String JSON_KEY_RECEIPT_PURCHASE_TOKEN = "purchaseToken";
  public static final String JSON_KEY_STORE = "store";
  public static final String JSON_KEY_USER_ID = "userId";
  private static final Logger L = ViberEnv.getLogger();
  private final Context context;
  private String currentUserId;
  private final Inventory inventory = new Inventory();
  private final Queue<CountDownLatch> inventoryLatchQueue = new ConcurrentLinkedQueue();
  private volatile boolean isSetupSuccessfullyComplete;
  CountDownLatch latch;
  private final Map<RequestId, IabHelper.OnIabPurchaseFinishedListener> requestListeners = new HashMap();
  private final Map<RequestId, String> requestSkuMap = new HashMap();
  private IabHelper.OnIabSetupFinishedListener setupListener;

  public AmazonAppstoreBillingService(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
  }

  public static void dumpMap(Map<?, ?> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
        localIterator.next();
    }
  }

  private String generateOriginalJson(PurchaseResponse paramPurchaseResponse)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Receipt localReceipt = paramPurchaseResponse.getReceipt();
      localJSONObject.put("orderId", paramPurchaseResponse.getRequestId());
      localJSONObject.put("productId", localReceipt.getSku());
      PurchaseResponse.RequestStatus localRequestStatus = paramPurchaseResponse.getRequestStatus();
      if (localRequestStatus != null)
        localJSONObject.put("purchaseStatus", localRequestStatus.name());
      UserData localUserData = paramPurchaseResponse.getUserData();
      if (localUserData != null)
        localJSONObject.put("userId", localUserData.getUserId());
      ProductType localProductType = localReceipt.getProductType();
      if (localProductType != null)
        localJSONObject.put("itemType", localProductType.name());
      localJSONObject.put("purchaseToken", localReceipt.getReceiptId());
      localJSONObject.put("store", "amazon");
      label128: return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label128;
    }
  }

  private Purchase getPurchase(Receipt paramReceipt)
  {
    Purchase localPurchase = new Purchase("com.amazon.apps");
    if (paramReceipt == null)
      return localPurchase;
    String str = paramReceipt.getSku();
    localPurchase.setSku(str);
    localPurchase.setToken(paramReceipt.getReceiptId());
    switch (1.$SwitchMap$com$amazon$device$iap$model$ProductType[paramReceipt.getProductType().ordinal()])
    {
    default:
      return localPurchase;
    case 1:
    case 2:
      localPurchase.setItemType("inapp");
      return localPurchase;
    case 3:
    }
    localPurchase.setItemType("subs");
    localPurchase.setSku(str);
    return localPurchase;
  }

  private SkuDetails getSkuDetails(Product paramProduct)
  {
    String str1 = paramProduct.getSku();
    String str2 = paramProduct.getPrice().toString();
    String str3 = paramProduct.getTitle();
    String str4 = paramProduct.getDescription();
    if (paramProduct.getProductType() == ProductType.SUBSCRIPTION);
    for (String str5 = "subs"; ; str5 = "inapp")
      return new SkuDetails(str5, str1, str3, str2, str4);
  }

  public void consume(Purchase paramPurchase)
  {
    PurchasingService.notifyFulfillment(paramPurchase.getToken(), FulfillmentResult.FULFILLED);
  }

  public void dispose()
  {
    this.setupListener = null;
  }

  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4)
  {
    if (!this.isSetupSuccessfullyComplete)
    {
      if (paramOnIabPurchaseFinishedListener != null)
        paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(new IabResult(6, "Amazon setup failed or not complete"), null);
      return;
    }
    RequestId localRequestId = PurchasingService.purchase(paramString1);
    this.requestSkuMap.put(localRequestId, paramString1);
    this.requestListeners.put(localRequestId, paramOnIabPurchaseFinishedListener);
  }

  public void onProductDataResponse(ProductDataResponse paramProductDataResponse)
  {
    ProductDataResponse.RequestStatus localRequestStatus = paramProductDataResponse.getRequestStatus();
    paramProductDataResponse.getRequestId();
    switch (1.$SwitchMap$com$amazon$device$iap$model$ProductDataResponse$RequestStatus[localRequestStatus.ordinal()])
    {
    default:
    case 1:
    }
    while (true)
    {
      CountDownLatch localCountDownLatch = (CountDownLatch)this.inventoryLatchQueue.poll();
      if (localCountDownLatch != null)
        localCountDownLatch.countDown();
      return;
      Map localMap = paramProductDataResponse.getProductData();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Product localProduct = (Product)localMap.get((String)localIterator.next());
        this.inventory.addSkuDetails(getSkuDetails(localProduct));
      }
    }
  }

  public void onPurchaseResponse(PurchaseResponse paramPurchaseResponse)
  {
    PurchaseResponse.RequestStatus localRequestStatus = paramPurchaseResponse.getRequestStatus();
    RequestId localRequestId = paramPurchaseResponse.getRequestId();
    ((String)this.requestSkuMap.remove(localRequestId));
    Receipt localReceipt = paramPurchaseResponse.getReceipt();
    Purchase localPurchase = getPurchase(localReceipt);
    IabResult localIabResult;
    switch (1.$SwitchMap$com$amazon$device$iap$model$PurchaseResponse$RequestStatus[localRequestStatus.ordinal()])
    {
    default:
      localIabResult = null;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      IabHelper.OnIabPurchaseFinishedListener localOnIabPurchaseFinishedListener = (IabHelper.OnIabPurchaseFinishedListener)this.requestListeners.remove(localRequestId);
      if (localOnIabPurchaseFinishedListener != null)
        localOnIabPurchaseFinishedListener.onIabPurchaseFinished(localIabResult, localPurchase);
      return;
      if (!paramPurchaseResponse.getUserData().getUserId().equals(this.currentUserId))
      {
        localIabResult = new IabResult(6, "Current UserId doesn't match purchase UserId");
      }
      else
      {
        localPurchase.setOriginalJson(generateOriginalJson(paramPurchaseResponse));
        localPurchase.setOrderId(localRequestId.toString());
        ProductType localProductType = localReceipt.getProductType();
        localPurchase.setSku(localReceipt.getSku());
        if (localProductType == ProductType.SUBSCRIPTION);
        for (String str = "subs"; ; str = "inapp")
        {
          localPurchase.setItemType(str);
          localIabResult = new IabResult(0, "Success");
          break;
        }
        localIabResult = new IabResult(4, "Invalid SKU");
        continue;
        localIabResult = new IabResult(7, "Item is already purchased");
        continue;
        localIabResult = new IabResult(6, "Purchase failed");
        continue;
        localIabResult = new IabResult(3, "This call is not supported");
      }
    }
  }

  public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse paramPurchaseUpdatesResponse)
  {
    PurchaseUpdatesResponse.RequestStatus localRequestStatus = paramPurchaseUpdatesResponse.getRequestStatus();
    paramPurchaseUpdatesResponse.getRequestId();
    switch (1.$SwitchMap$com$amazon$device$iap$model$PurchaseUpdatesResponse$RequestStatus[localRequestStatus.ordinal()])
    {
    default:
    case 1:
    }
    do
    {
      do
      {
        CountDownLatch localCountDownLatch = (CountDownLatch)this.inventoryLatchQueue.poll();
        if (localCountDownLatch != null)
          localCountDownLatch.countDown();
        return;
        Iterator localIterator1 = this.inventory.getAllOwnedSkus().iterator();
        while (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          this.inventory.erasePurchase(str);
        }
      }
      while (!paramPurchaseUpdatesResponse.getUserData().getUserId().equals(this.currentUserId));
      Iterator localIterator2 = paramPurchaseUpdatesResponse.getReceipts().iterator();
      while (localIterator2.hasNext())
      {
        Receipt localReceipt = (Receipt)localIterator2.next();
        this.inventory.addPurchase(getPurchase(localReceipt));
      }
    }
    while (!paramPurchaseUpdatesResponse.hasMore());
    PurchasingService.getPurchaseUpdates(false);
  }

  public void onUserDataResponse(UserDataResponse paramUserDataResponse)
  {
    IabResult localIabResult;
    switch (1.$SwitchMap$com$amazon$device$iap$model$UserDataResponse$RequestStatus[paramUserDataResponse.getRequestStatus().ordinal()])
    {
    default:
      localIabResult = new IabResult(3, "Unknown response code");
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if (this.setupListener != null)
      {
        this.setupListener.onIabSetupFinished(localIabResult);
        this.setupListener = null;
      }
      this.latch.countDown();
      return;
      this.currentUserId = paramUserDataResponse.getUserData().getUserId();
      localIabResult = new IabResult(0, "Setup successful.");
      this.isSetupSuccessfullyComplete = true;
      continue;
      localIabResult = new IabResult(6, "Unable to get userId");
    }
  }

  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException
  {
    if (!this.isSetupSuccessfullyComplete)
      throw new IabException(-1, "Amazon setup failed or not complete");
    CountDownLatch localCountDownLatch1 = new CountDownLatch(1);
    this.inventoryLatchQueue.offer(localCountDownLatch1);
    PurchasingService.getPurchaseUpdates(true);
    HashSet localHashSet2;
    try
    {
      localCountDownLatch1.await();
      if (!paramBoolean)
        break label198;
      HashSet localHashSet1 = new HashSet(this.inventory.getAllOwnedSkus());
      if (paramList1 != null)
        localHashSet1.addAll(paramList1);
      if (paramList2 != null)
        localHashSet1.addAll(paramList2);
      if (localHashSet1.isEmpty())
        break label198;
      localHashSet2 = new HashSet(localHashSet1.size());
      Iterator localIterator = localHashSet1.iterator();
      while (localIterator.hasNext())
        localHashSet2.add((String)localIterator.next());
    }
    catch (InterruptedException localInterruptedException1)
    {
      return null;
    }
    CountDownLatch localCountDownLatch2 = new CountDownLatch(1);
    this.inventoryLatchQueue.offer(localCountDownLatch2);
    PurchasingService.getProductData(localHashSet2);
    try
    {
      localCountDownLatch2.await();
      label198: dumpMap(this.inventory.getSkuMap());
      return this.inventory;
    }
    catch (InterruptedException localInterruptedException2)
    {
    }
    return null;
  }

  public void setProductsData(List<String> paramList)
  {
  }

  public void startSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    this.setupListener = paramOnIabSetupFinishedListener;
    PurchasingService.registerListener(this.context, this);
    this.latch = new CountDownLatch(1);
    PurchasingService.getUserData();
    try
    {
      if (!this.latch.await(5000L, TimeUnit.MILLISECONDS))
      {
        IabResult localIabResult = new IabResult(6, "No response from service");
        this.setupListener.onIabSetupFinished(localIabResult);
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public boolean subscriptionsSupported()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.AmazonAppstoreBillingService
 * JD-Core Version:    0.6.2
 */