package com.vk.sdk.payments;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.vk.sdk.VKUIHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class VKIInAppBillingService
{
  private static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
  private static final String PARAMS_ARE_NOT_VALID_ERROR = "params of constructor don't implement com.android.vending.billing.IInAppBillingService";
  private static final String PRODUCT_ID = "productId";
  private static final String PURCHASE_DETAIL_PURCHASE_TOKEN = "purchaseToken";
  private static final String PURCHASE_DETAIL_TOKEN = "token";
  private static final String RECEIPT_CURRENCY = "currency";
  private static final String RECEIPT_DATA = "receipt_data";
  private static final String RECEIPT_QUANTITY = "quantity";
  private static final String RECEIPT_VALUE = "price_value";
  private static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
  private static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
  private static final String SKU_DETAIL_AMOUNT_MICROS = "price_amount_micros";
  private static final String SKU_DETAIL_PRICE_CURRENCY_CODE = "price_currency_code";
  private static final Method sMethodConsumePurchase;
  private static final Method sMethodGetBuyIntent;
  private static final Method sMethodGetPurchases;
  private static final Method sMethodGetSkuDetails;
  private static final Method sMethodIsBillingSupported;
  private final Object mIInAppBillingService;

  static
  {
    try
    {
      Class localClass = Class.forName("com.android.vending.billing.IInAppBillingService");
      Class[] arrayOfClass1 = new Class[3];
      arrayOfClass1[0] = Integer.TYPE;
      arrayOfClass1[1] = String.class;
      arrayOfClass1[2] = String.class;
      sMethodIsBillingSupported = localClass.getMethod("isBillingSupported", arrayOfClass1);
      Class[] arrayOfClass2 = new Class[4];
      arrayOfClass2[0] = Integer.TYPE;
      arrayOfClass2[1] = String.class;
      arrayOfClass2[2] = String.class;
      arrayOfClass2[3] = Bundle.class;
      sMethodGetSkuDetails = localClass.getMethod("getSkuDetails", arrayOfClass2);
      Class[] arrayOfClass3 = new Class[5];
      arrayOfClass3[0] = Integer.TYPE;
      arrayOfClass3[1] = String.class;
      arrayOfClass3[2] = String.class;
      arrayOfClass3[3] = String.class;
      arrayOfClass3[4] = String.class;
      sMethodGetBuyIntent = localClass.getMethod("getBuyIntent", arrayOfClass3);
      Class[] arrayOfClass4 = new Class[4];
      arrayOfClass4[0] = Integer.TYPE;
      arrayOfClass4[1] = String.class;
      arrayOfClass4[2] = String.class;
      arrayOfClass4[3] = String.class;
      sMethodGetPurchases = localClass.getMethod("getPurchases", arrayOfClass4);
      Class[] arrayOfClass5 = new Class[3];
      arrayOfClass5[0] = Integer.TYPE;
      arrayOfClass5[1] = String.class;
      arrayOfClass5[2] = String.class;
      sMethodConsumePurchase = localClass.getMethod("consumePurchase", arrayOfClass5);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("params of constructor don't implement com.android.vending.billing.IInAppBillingService");
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException(localNoSuchMethodException);
    }
  }

  public VKIInAppBillingService(Object paramObject)
  {
    this.mIInAppBillingService = paramObject;
    try
    {
      Class.forName("com.android.vending.billing.IInAppBillingService").cast(this.mIInAppBillingService);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    throw new RuntimeException("params of constructor don't implement com.android.vending.billing.IInAppBillingService");
  }

  public static boolean consumePurchaseToVk(final int paramInt, final String paramString)
    throws RemoteException
  {
    if (Looper.getMainLooper().equals(Looper.myLooper()))
      throw new RuntimeException("Network on main thread");
    final Context localContext = VKUIHelper.getApplicationContext();
    if (localContext == null);
    PurchaseData localPurchaseData;
    do
    {
      SyncServiceConnection local1;
      Intent localIntent;
      do
      {
        return false;
        localPurchaseData = new PurchaseData(null);
        if (VKPaymentsServerSender.isNotVkUser())
          break;
        local1 = new SyncServiceConnection(localPurchaseData)
        {
          // ERROR //
          public void onServiceConnectedImpl(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
          {
            // Byte code:
            //   0: ldc 38
            //   2: invokestatic 44	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
            //   5: astore 5
            //   7: aload 5
            //   9: ldc 46
            //   11: iconst_1
            //   12: anewarray 40	java/lang/Class
            //   15: dup
            //   16: iconst_0
            //   17: ldc 48
            //   19: aastore
            //   20: invokevirtual 52	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
            //   23: aload 5
            //   25: iconst_1
            //   26: anewarray 54	java/lang/Object
            //   29: dup
            //   30: iconst_0
            //   31: aload_2
            //   32: aastore
            //   33: invokevirtual 60	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
            //   36: astore 6
            //   38: aload_0
            //   39: getfield 21	com/vk/sdk/payments/VKIInAppBillingService$1:val$purchaseData	Lcom/vk/sdk/payments/VKIInAppBillingService$PurchaseData;
            //   42: aload 6
            //   44: aload_0
            //   45: getfield 23	com/vk/sdk/payments/VKIInAppBillingService$1:val$apiVersion	I
            //   48: aload_0
            //   49: getfield 25	com/vk/sdk/payments/VKIInAppBillingService$1:val$ctx	Landroid/content/Context;
            //   52: invokevirtual 66	android/content/Context:getPackageName	()Ljava/lang/String;
            //   55: aload_0
            //   56: getfield 27	com/vk/sdk/payments/VKIInAppBillingService$1:val$purchaseToken	Ljava/lang/String;
            //   59: invokestatic 70	com/vk/sdk/payments/VKIInAppBillingService:access$200	(Ljava/lang/Object;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   62: putfield 75	com/vk/sdk/payments/VKIInAppBillingService$PurchaseData:purchaseData	Ljava/lang/String;
            //   65: return
            //   66: astore 4
            //   68: new 77	java/lang/RuntimeException
            //   71: dup
            //   72: ldc 79
            //   74: invokespecial 82	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
            //   77: athrow
            //   78: astore_3
            //   79: new 77	java/lang/RuntimeException
            //   82: dup
            //   83: aload_3
            //   84: invokespecial 85	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
            //   87: athrow
            //   88: astore 7
            //   90: ldc 87
            //   92: ldc 89
            //   94: aload 7
            //   96: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   99: pop
            //   100: aload_0
            //   101: getfield 21	com/vk/sdk/payments/VKIInAppBillingService$1:val$purchaseData	Lcom/vk/sdk/payments/VKIInAppBillingService$PurchaseData;
            //   104: iconst_1
            //   105: putfield 99	com/vk/sdk/payments/VKIInAppBillingService$PurchaseData:hasError	Z
            //   108: return
            //
            // Exception table:
            //   from	to	target	type
            //   0	38	66	java/lang/ClassNotFoundException
            //   0	38	78	java/lang/Exception
            //   38	65	88	java/lang/Exception
          }

          public void onServiceDisconnectedImpl(ComponentName paramAnonymousComponentName)
          {
          }
        };
        localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        localIntent.setPackage("com.android.vending");
      }
      while (localContext.getPackageManager().queryIntentServices(localIntent, 0).isEmpty());
      localContext.bindService(localIntent, local1, 1);
      synchronized (local1.syncObj)
      {
        while (true)
        {
          boolean bool = local1.isFinish;
          if (!bool)
            try
            {
              local1.syncObj.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
        }
      }
      localContext.unbindService(local1);
    }
    while (localPurchaseData.hasError);
    if (!TextUtils.isEmpty(localPurchaseData.purchaseData))
      VKPaymentsServerSender.getInstance(localContext).saveTransaction(localPurchaseData.purchaseData);
    return true;
    return true;
  }

  private static String getPurchaseData(Object paramObject, int paramInt, String paramString1, String paramString2)
    throws RemoteException
  {
    ArrayList localArrayList = getPurchases(paramObject, paramInt, paramString1, "inapp", paramString2).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        String str1 = (String)localArrayList.get(i);
        try
        {
          JSONObject localJSONObject = new JSONObject(str1);
          if (TextUtils.equals(paramString2, localJSONObject.optString("token", localJSONObject.optString("purchaseToken"))))
          {
            String str2 = getReceipt(paramObject, paramInt, paramString1, str1).toJson();
            return str2;
          }
        }
        catch (JSONException localJSONException)
        {
          i++;
        }
      }
    }
    return null;
  }

  private static Bundle getPurchases(Object paramObject, int paramInt, String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    try
    {
      Method localMethod = sMethodGetPurchases;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = paramString3;
      Bundle localBundle = (Bundle)localMethod.invoke(paramObject, arrayOfObject);
      return localBundle;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  private static Receipt getReceipt(Object paramObject, int paramInt, String paramString1, String paramString2)
    throws JSONException, RemoteException
  {
    JSONObject localJSONObject1 = new JSONObject(paramString2);
    Receipt localReceipt = new Receipt(null);
    localReceipt.receiptData = paramString2;
    localReceipt.quantity = 1;
    String str = localJSONObject1.getString("productId");
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(str);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("ITEM_ID_LIST", localArrayList1);
    ArrayList localArrayList2 = getSkuDetails(paramObject, paramInt, paramString1, "inapp", localBundle).getStringArrayList("DETAILS_LIST");
    if ((localArrayList2 != null) && (!localArrayList2.isEmpty()));
    try
    {
      JSONObject localJSONObject2 = new JSONObject((String)localArrayList2.get(0));
      localReceipt.priceValue = (Float.parseFloat(localJSONObject2.optString("price_amount_micros")) / 1000000.0F);
      localReceipt.currency = localJSONObject2.optString("price_currency_code");
      return localReceipt;
    }
    catch (JSONException localJSONException)
    {
    }
    return localReceipt;
  }

  private static Bundle getSkuDetails(Object paramObject, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    try
    {
      Method localMethod = sMethodGetSkuDetails;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = paramBundle;
      Bundle localBundle = (Bundle)localMethod.invoke(paramObject, arrayOfObject);
      return localBundle;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public int consumePurchase(int paramInt, String paramString1, String paramString2)
    throws RemoteException
  {
    String str;
    if (!VKPaymentsServerSender.isNotVkUser())
      str = getPurchaseData(this.mIInAppBillingService, paramInt, paramString1, paramString2);
    try
    {
      while (true)
      {
        Method localMethod = sMethodConsumePurchase;
        Object localObject = this.mIInAppBillingService;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        arrayOfObject[1] = paramString1;
        arrayOfObject[2] = paramString2;
        int i = ((Integer)localMethod.invoke(localObject, arrayOfObject)).intValue();
        Context localContext = VKUIHelper.getApplicationContext();
        if ((!TextUtils.isEmpty(str)) && (localContext != null))
          VKPaymentsServerSender.getInstance(localContext).saveTransaction(str);
        return i;
        str = null;
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public Bundle getBuyIntent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws RemoteException
  {
    try
    {
      Method localMethod = sMethodGetBuyIntent;
      Object localObject = this.mIInAppBillingService;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = paramString3;
      arrayOfObject[4] = paramString4;
      Bundle localBundle = (Bundle)localMethod.invoke(localObject, arrayOfObject);
      return localBundle;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public Bundle getPurchases(int paramInt, String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    return getPurchases(this.mIInAppBillingService, paramInt, paramString1, paramString2, paramString3);
  }

  public Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    return getSkuDetails(this.mIInAppBillingService, paramInt, paramString1, paramString2, paramBundle);
  }

  public int isBillingSupported(int paramInt, String paramString1, String paramString2)
    throws RemoteException
  {
    try
    {
      Method localMethod = sMethodIsBillingSupported;
      Object localObject = this.mIInAppBillingService;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      int i = ((Integer)localMethod.invoke(localObject, arrayOfObject)).intValue();
      return i;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  private static class PurchaseData
  {
    boolean hasError = false;
    String purchaseData = null;
  }

  private static class Receipt
  {
    String currency;
    float priceValue;
    int quantity;
    String receiptData;

    String toJson()
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(this.receiptData))
        localJSONObject.put("receipt_data", this.receiptData);
      localJSONObject.put("price_value", this.priceValue);
      if (!TextUtils.isEmpty(this.currency))
        localJSONObject.put("currency", this.currency);
      localJSONObject.put("quantity", this.quantity);
      return localJSONObject.toString();
    }
  }

  private static class SyncServiceConnection
    implements ServiceConnection
  {
    volatile boolean isFinish = false;
    final Object syncObj = new Object();

    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        synchronized (this.syncObj)
        {
          onServiceConnectedImpl(paramComponentName, paramIBinder);
          label13: this.isFinish = true;
          this.syncObj.notifyAll();
          return;
        }
      }
      catch (Exception localException)
      {
        break label13;
      }
    }

    public void onServiceConnectedImpl(ComponentName paramComponentName, IBinder paramIBinder)
    {
    }

    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      try
      {
        synchronized (this.syncObj)
        {
          onServiceDisconnectedImpl(paramComponentName);
          label12: this.isFinish = true;
          this.syncObj.notifyAll();
          return;
        }
      }
      catch (Exception localException)
      {
        break label12;
      }
    }

    public void onServiceDisconnectedImpl(ComponentName paramComponentName)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.payments.VKIInAppBillingService
 * JD-Core Version:    0.6.2
 */