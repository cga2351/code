package com.viber.voip.billing;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.af;
import com.viber.voip.util.da;

public class t
  implements s
{
  private static final Logger a = b.a(t.class);
  private static final String[] b = { "order_id", "type", "category", "package_name", "product_id", "purchase_time", "purchase_state", "dev_payload", "token", "json", "signature", "verified", "consumed", "pending", "productjson" };

  private Purchase[] a(Cursor paramCursor)
  {
    int i = 0;
    Purchase[] arrayOfPurchase2;
    if ((!af.b(paramCursor)) && (paramCursor.moveToFirst()))
      arrayOfPurchase2 = new Purchase[paramCursor.getCount()];
    while (true)
    {
      int j = i + 1;
      arrayOfPurchase2[i] = b(paramCursor);
      if (!paramCursor.moveToNext())
        for (Purchase[] arrayOfPurchase1 = arrayOfPurchase2; ; arrayOfPurchase1 = new Purchase[0])
        {
          af.a(paramCursor);
          return arrayOfPurchase1;
        }
      i = j;
    }
  }

  private com.viber.provider.b b()
  {
    return d.a(ViberApplication.getApplication());
  }

  private Purchase b(Cursor paramCursor)
  {
    String str1 = paramCursor.getString(0);
    String str2 = paramCursor.getString(3);
    String str3 = paramCursor.getString(14);
    if (da.a(str3))
      str3 = paramCursor.getString(4);
    IabProductId localIabProductId = IabProductId.fromString(str3);
    long l = paramCursor.getLong(5);
    int i = paramCursor.getInt(6);
    String str4 = paramCursor.getString(7);
    String str5 = paramCursor.getString(8);
    String str6 = paramCursor.getString(9);
    String str7 = paramCursor.getString(10);
    boolean bool1;
    boolean bool2;
    if (paramCursor.getInt(11) != 0)
    {
      bool1 = true;
      if (paramCursor.getInt(12) == 0)
        break label198;
      bool2 = true;
      label137: if (paramCursor.getInt(13) == 0)
        break label204;
    }
    label198: label204: for (boolean bool3 = true; ; bool3 = false)
    {
      Purchase localPurchase = new Purchase(str1, str2, localIabProductId, null, l, i, str4, str5, str6, str7, bool1, bool2, bool3);
      localPurchase.setFromDB(true);
      return localPurchase;
      bool1 = false;
      break;
      bool2 = false;
      break label137;
    }
  }

  public Purchase a(String paramString)
  {
    Cursor localCursor = b().a("purchase", b, "order_id = ?", new String[] { paramString }, null, null, null);
    boolean bool1 = af.b(localCursor);
    Purchase localPurchase = null;
    if (!bool1)
    {
      boolean bool2 = localCursor.moveToFirst();
      localPurchase = null;
      if (bool2)
        localPurchase = b(localCursor);
    }
    af.a(localCursor);
    return localPurchase;
  }

  public void a(Purchase paramPurchase)
  {
    ContentValues localContentValues = new ContentValues(15);
    localContentValues.put("order_id", paramPurchase.getOrderId());
    localContentValues.put("type", paramPurchase.getItemType());
    localContentValues.put("category", Integer.valueOf(paramPurchase.getProductId().getProductId().getCategory().order));
    localContentValues.put("package_name", paramPurchase.getPackageName());
    localContentValues.put("product_id", paramPurchase.getProductId().toString());
    localContentValues.put("purchase_time", Long.valueOf(paramPurchase.getPurchaseTime()));
    localContentValues.put("purchase_state", Integer.valueOf(paramPurchase.getPurchaseState()));
    localContentValues.put("dev_payload", paramPurchase.getDeveloperPayload());
    localContentValues.put("token", paramPurchase.getToken());
    localContentValues.put("json", paramPurchase.getOriginalJson());
    localContentValues.put("signature", paramPurchase.getSignature());
    int i;
    int j;
    if (paramPurchase.isVerified())
    {
      i = 1;
      localContentValues.put("verified", Integer.valueOf(i));
      if (!paramPurchase.isConsumed())
        break label263;
      j = 1;
      label170: localContentValues.put("consumed", Integer.valueOf(j));
      if (!paramPurchase.isPending())
        break label269;
    }
    label263: label269: for (int k = 1; ; k = 0)
    {
      localContentValues.put("pending", Integer.valueOf(k));
      localContentValues.put("productjson", paramPurchase.getProductId().getJson());
      if (!paramPurchase.isFromDB())
        break label275;
      com.viber.provider.b localb = b();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramPurchase.getOrderId();
      localb.a("purchase", localContentValues, "order_id = ?", arrayOfString);
      return;
      i = 0;
      break;
      j = 0;
      break label170;
    }
    label275: b().a("purchase", null, localContentValues);
    paramPurchase.setFromDB(true);
  }

  public Purchase[] a()
  {
    return a(b().a("purchase", b, "pending = ?", new String[] { "1" }, null, null, null));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.t
 * JD-Core Version:    0.6.2
 */