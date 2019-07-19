package com.amazon.device.iap.internal.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.amazon.device.iap.internal.util.e;

public class c
{
  private static c a = new c();
  private static final String b = c.class.getSimpleName();
  private static final String c = c.class.getName() + "_PREFS_";

  public static c a()
  {
    return a;
  }

  public String a(String paramString1, String paramString2)
  {
    e.a(b, "enter getReceiptIdFromSku for sku [" + paramString2 + "], user [" + paramString1 + "]");
    try
    {
      com.amazon.device.iap.internal.util.d.a(paramString1, "userId");
      com.amazon.device.iap.internal.util.d.a(paramString2, "sku");
      Context localContext = com.amazon.device.iap.internal.d.d().b();
      com.amazon.device.iap.internal.util.d.a(localContext, "context");
      String str2 = localContext.getSharedPreferences(c + paramString1, 0).getString(paramString2, null);
      str1 = str2;
      e.a(b, "leaving saveEntitlementRecord for sku [" + paramString2 + "], user [" + paramString1 + "]");
      return str1;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        e.a(b, "error in saving v1 Entitlement:" + paramString2 + ":" + localThrowable.getMessage());
        String str1 = null;
      }
    }
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    e.a(b, "enter saveEntitlementRecord for v1 Entitlement [" + paramString2 + "/" + paramString3 + "], user [" + paramString1 + "]");
    try
    {
      com.amazon.device.iap.internal.util.d.a(paramString1, "userId");
      com.amazon.device.iap.internal.util.d.a(paramString2, "receiptId");
      com.amazon.device.iap.internal.util.d.a(paramString3, "sku");
      Context localContext = com.amazon.device.iap.internal.d.d().b();
      com.amazon.device.iap.internal.util.d.a(localContext, "context");
      SharedPreferences.Editor localEditor = localContext.getSharedPreferences(c + paramString1, 0).edit();
      localEditor.putString(paramString3, paramString2);
      localEditor.commit();
      e.a(b, "leaving saveEntitlementRecord for v1 Entitlement [" + paramString2 + "/" + paramString3 + "], user [" + paramString1 + "]");
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        e.a(b, "error in saving v1 Entitlement:" + paramString2 + "/" + paramString3 + ":" + localThrowable.getMessage());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.c.c
 * JD-Core Version:    0.6.2
 */