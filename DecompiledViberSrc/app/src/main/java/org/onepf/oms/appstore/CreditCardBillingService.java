package org.onepf.oms.appstore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.onepf.oms.AppstoreInAppBillingService;
import org.onepf.oms.appstore.googleUtils.IabException;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabPurchaseFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabHelper.OnIabSetupFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;
import org.onepf.oms.appstore.googleUtils.Inventory;
import org.onepf.oms.appstore.googleUtils.Purchase;

public class CreditCardBillingService
  implements AppstoreInAppBillingService
{
  private static final Logger L = ViberEnv.getLogger();
  private static HashMap<String, String> inappsMap = new HashMap();
  private Context mContext;

  public CreditCardBillingService(Context paramContext)
  {
    this.mContext = paramContext;
  }

  // ERROR //
  private org.onepf.oms.appstore.googleUtils.SkuDetails jsonToSkuDetails(String paramString)
  {
    // Byte code:
    //   0: getstatic 22	org/onepf/oms/appstore/CreditCardBillingService:inappsMap	Ljava/util/HashMap;
    //   3: aload_1
    //   4: invokevirtual 42	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 44	java/lang/String
    //   10: astore_2
    //   11: new 46	org/json/JSONObject
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 49	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc 51
    //   23: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 8
    //   28: aload_3
    //   29: ldc 57
    //   31: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore 10
    //   36: aload 10
    //   38: astore 7
    //   40: aload 8
    //   42: astore 6
    //   44: new 62	org/onepf/oms/appstore/googleUtils/SkuDetails
    //   47: dup
    //   48: aload 6
    //   50: aload 7
    //   52: aconst_null
    //   53: invokespecial 65	org/onepf/oms/appstore/googleUtils/SkuDetails:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   56: areturn
    //   57: astore 4
    //   59: aload_1
    //   60: astore 5
    //   62: aload 5
    //   64: astore 6
    //   66: ldc 67
    //   68: astore 7
    //   70: goto -26 -> 44
    //   73: astore 9
    //   75: aload 8
    //   77: astore 5
    //   79: goto -17 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   11	28	57	org/json/JSONException
    //   28	36	73	org/json/JSONException
  }

  public void consume(Purchase paramPurchase)
    throws IabException
  {
    throw new IabException(-1006, "Unavailable in this version");
  }

  public void dispose()
  {
  }

  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }

  public void launchPurchaseFlow(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, IabHelper.OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString4)
  {
    paramOnIabPurchaseFinishedListener.onIabPurchaseFinished(new IabResult(3, "Purchasing unavailable in this version"), null);
  }

  public Inventory queryInventory(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
    throws IabException
  {
    Inventory localInventory = new Inventory();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
        localInventory.addSkuDetails(jsonToSkuDetails((String)localIterator.next()));
    }
    return localInventory;
  }

  public void setProductsData(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      try
      {
        JSONObject localJSONObject = new JSONObject(str1);
        String str2 = localJSONObject.getString("merchant_product_id");
        if ((TextUtils.equals(localJSONObject.optString("provider_id"), "credit_card")) && (!inappsMap.containsKey(str2)))
          inappsMap.put(str2, str1);
      }
      catch (JSONException localJSONException)
      {
      }
    }
  }

  public void startSetup(IabHelper.OnIabSetupFinishedListener paramOnIabSetupFinishedListener)
  {
    IabResult localIabResult = new IabResult(0, "CreditCardBillingService: successful setup.");
    if (paramOnIabSetupFinishedListener != null)
      paramOnIabSetupFinishedListener.onIabSetupFinished(localIabResult);
  }

  public boolean subscriptionsSupported()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.CreditCardBillingService
 * JD-Core Version:    0.6.2
 */