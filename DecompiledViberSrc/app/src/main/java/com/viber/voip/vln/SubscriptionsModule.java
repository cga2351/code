package com.viber.voip.vln;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.d.a.c;
import com.google.d.f;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.ProductCategory;
import com.viber.voip.billing.Purchase;
import com.viber.voip.billing.aa;
import com.viber.voip.billing.b;
import com.viber.voip.billing.b.d;
import com.viber.voip.billing.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.onepf.oms.InAppBillingHelper;

public class SubscriptionsModule extends ReactContextBaseJavaModule
{
  private static final String ERROR_CANCELED = "PURCHASE_CANCELED";
  private static final String ERROR_FAILED = "PURCHASE_FAILED";
  private static final Logger L = ViberEnv.getLogger();
  private static final String MODULE_NAME = "Subscriptions";
  private static final String VERIFICATION_FAILED = "VO_NOTIFY_FAILED";

  public SubscriptionsModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private String base64(String paramString)
  {
    try
    {
      String str = new String(Base64.encode(paramString.getBytes("utf-8"), 2), "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      L.a(localUnsupportedEncodingException, "utf-8 not found");
    }
    return "";
  }

  private String getMessageForIabError(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "Purchase failed";
    case 1:
    }
    return "Purchase canceled by user";
  }

  private String getStringErrorForIabError(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "PURCHASE_FAILED";
    case 1:
    }
    return "PURCHASE_CANCELED";
  }

  public String getName()
  {
    return "Subscriptions";
  }

  @ReactMethod
  public void loadProducts(ReadableArray paramReadableArray, Promise paramPromise)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramReadableArray.size(); i++)
    {
      a locala = new a(paramReadableArray.getString(i));
      localArrayList.add(IabProductId.fromString(new f().b(locala)));
    }
    l.a().c().queryProductDetailsAsync(localArrayList, new a(localArrayList, paramPromise));
  }

  @ReactMethod
  public void purchase(ReadableMap paramReadableMap, final Promise paramPromise)
  {
    a locala = new a(paramReadableMap.getString("merchant_product_id"));
    final IabProductId localIabProductId = IabProductId.fromString(new f().b(locala), ProductCategory.VLN);
    BroadcastReceiver[] arrayOfBroadcastReceiver = new BroadcastReceiver[1];
    arrayOfBroadcastReceiver[0] = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        LocalBroadcastManager.getInstance(SubscriptionsModule.this.getCurrentActivity()).unregisterReceiver(this);
        if ("purchase_verification".equals(paramAnonymousIntent.getAction()))
        {
          str = paramAnonymousIntent.getStringExtra("purchase_order_id");
          localWritableNativeMap = new WritableNativeMap();
          if (str == null)
          {
            localPurchase = null;
            if (localPurchase == null)
              break label216;
            localPurchase.getOriginalJson();
            localWritableNativeMap.putDouble("transaction_date", localPurchase.getPurchaseTime());
            localWritableNativeMap.putString("transaction_id", str);
            localWritableNativeMap.putString("product_id", localPurchase.getProductId().toString());
            localWritableNativeMap.putString("transaction_receipt", SubscriptionsModule.this.base64(localPurchase.getOriginalJson()));
            localWritableNativeMap.putString("purchase_token", SubscriptionsModule.this.base64(localPurchase.getToken()));
            localWritableNativeMap.putString("receipt_signature", localPurchase.getSignature());
            if (aa.values()[paramAnonymousIntent.getIntExtra("purchase_verification_result", aa.c.ordinal())] != aa.a)
              break label204;
            localWritableNativeMap.putString("error", null);
            paramPromise.resolve(localWritableNativeMap);
          }
        }
        label204: label216: 
        while (!"purchase_failure".equals(paramAnonymousIntent.getAction()))
        {
          while (true)
          {
            String str;
            WritableNativeMap localWritableNativeMap;
            return;
            Purchase localPurchase = l.a().a(str);
            continue;
            localWritableNativeMap.putString("error", "VO_NOTIFY_FAILED");
          }
          if (b.d())
          {
            paramPromise.reject("PURCHASE_FAILED", "Purchase failed, purchase object missing");
            return;
          }
          paramPromise.reject("NETWORK_ERROR", "No connectivity, purchase object missing");
          return;
        }
        int i = paramAnonymousIntent.getIntExtra("purchase_iab_error", 6);
        if (b.d())
        {
          paramPromise.reject(SubscriptionsModule.this.getStringErrorForIabError(i), SubscriptionsModule.this.getMessageForIabError(i));
          return;
        }
        paramPromise.reject("NETWORK_ERROR", "No connectivity");
      }
    };
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("attached activity is null!");
      L.a(localIllegalStateException, "can't purchase VLN!");
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("purchase_verification");
    localIntentFilter.addAction("purchase_failure");
    LocalBroadcastManager.getInstance(localActivity).registerReceiver(arrayOfBroadcastReceiver[0], localIntentFilter);
    final Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("is_vln_context", true);
    b.a().a(new b.d()
    {
      public void onBillingHealthIssues(int paramAnonymousInt)
      {
        paramPromise.reject("PURCHASE_FAILED", "Purchase failed, billing health check failed");
      }

      public void onBillingHealthOk()
      {
        l.a().a(localIabProductId, ViberApplication.getLocalizedResources().getString(R.string.purchase_processing), localBundle);
      }
    });
  }

  private static class a
  {

    @c(a="product_id")
    public String a;

    @c(a="merchant_product_id")
    public String b;

    @c(a="provider_id")
    public String c;

    @c(a="is_subscription")
    public boolean d;

    public a(String paramString)
    {
      this.b = paramString;
      this.a = paramString;
      this.c = "google_play";
      this.d = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.SubscriptionsModule
 * JD-Core Version:    0.6.2
 */