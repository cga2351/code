package com.android.billingclient.a;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public final class a
{
  public static int a = Runtime.getRuntime().availableProcessors();

  public static int a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null)
    {
      b("BillingHelper", "Got null intent!");
      return 6;
    }
    return a(paramIntent.getExtras(), paramString);
  }

  public static int a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
    {
      b(paramString, "Unexpected null bundle received!");
      return 6;
    }
    Object localObject = paramBundle.get("RESPONSE_CODE");
    if (localObject == null)
    {
      a(paramString, "getResponseCodeFromBundle() got null response code, assuming OK");
      return 0;
    }
    if ((localObject instanceof Integer))
      return ((Integer)localObject).intValue();
    b(paramString, "Unexpected type for bundle response code: " + localObject.getClass().getName());
    return 6;
  }

  public static List<h> a(Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    ArrayList localArrayList1 = paramBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
    ArrayList localArrayList3 = new ArrayList();
    if ((localArrayList1 == null) || (localArrayList2 == null))
    {
      b("BillingHelper", "Couldn't find purchase lists, trying to find single data.");
      h localh1 = c(paramBundle.getString("INAPP_PURCHASE_DATA"), paramBundle.getString("INAPP_DATA_SIGNATURE"));
      if (localh1 == null)
      {
        b("BillingHelper", "Couldn't find single purchase data as well.");
        return null;
      }
      localArrayList3.add(localh1);
    }
    while (true)
    {
      return localArrayList3;
      for (int i = 0; (i < localArrayList1.size()) && (i < localArrayList2.size()); i++)
      {
        h localh2 = c((String)localArrayList1.get(i), (String)localArrayList2.get(i));
        if (localh2 != null)
          localArrayList3.add(localh2);
      }
    }
  }

  public static void a(String paramString1, String paramString2)
  {
    if (Log.isLoggable(paramString1, 2))
      Log.v(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2)
  {
    if (Log.isLoggable(paramString1, 5))
      Log.w(paramString1, paramString2);
  }

  private static h c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      b("BillingHelper", "Received a bad purchase data.");
      return null;
    }
    try
    {
      h localh = new h(paramString1, paramString2);
      return localh;
    }
    catch (JSONException localJSONException)
    {
      b("BillingHelper", "Got JSONException while parsing purchase data: " + localJSONException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.a.a
 * JD-Core Version:    0.6.2
 */