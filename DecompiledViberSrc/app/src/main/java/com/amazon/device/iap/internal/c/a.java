package com.amazon.device.iap.internal.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.amazon.device.iap.model.Receipt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static final String b = a.class.getName() + "_PREFS";
  private static final String c = a.class.getName() + "_CLEANER_PREFS";
  private static int d = 604800000;
  private static final a e = new a();

  public static a a()
  {
    return e;
  }

  private void a(long paramLong)
  {
    Context localContext = com.amazon.device.iap.internal.d.d().b();
    com.amazon.device.iap.internal.util.d.a(localContext, "context");
    SharedPreferences.Editor localEditor = localContext.getSharedPreferences(c, 0).edit();
    localEditor.putLong("LAST_CLEANING_TIME", paramLong);
    localEditor.commit();
  }

  private void e()
  {
    com.amazon.device.iap.internal.util.e.a(a, "enter old receipts cleanup! ");
    final Context localContext = com.amazon.device.iap.internal.d.d().b();
    com.amazon.device.iap.internal.util.d.a(localContext, "context");
    a(System.currentTimeMillis());
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        try
        {
          com.amazon.device.iap.internal.util.e.a(a.b(), "perform house keeping! ");
          SharedPreferences localSharedPreferences = localContext.getSharedPreferences(a.c(), 0);
          Iterator localIterator = localSharedPreferences.getAll().keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            try
            {
              d locald = d.a(localSharedPreferences.getString(str, null));
              if (System.currentTimeMillis() - locald.c() > a.d())
              {
                com.amazon.device.iap.internal.util.e.a(a.b(), "house keeping - try remove Receipt:" + str + " since it's too old");
                a.this.a(str);
              }
            }
            catch (e locale)
            {
              com.amazon.device.iap.internal.util.e.a(a.b(), "house keeping - try remove Receipt:" + str + " since it's invalid ");
              a.this.a(str);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          com.amazon.device.iap.internal.util.e.a(a.b(), "Error in running cleaning job:" + localThrowable);
        }
      }
    };
    new Handler().post(local1);
  }

  private long f()
  {
    Context localContext = com.amazon.device.iap.internal.d.d().b();
    com.amazon.device.iap.internal.util.d.a(localContext, "context");
    long l1 = System.currentTimeMillis();
    long l2 = localContext.getSharedPreferences(c, 0).getLong("LAST_CLEANING_TIME", 0L);
    if (l2 == 0L)
    {
      a(l1);
      return l1;
    }
    return l2;
  }

  public void a(String paramString)
  {
    com.amazon.device.iap.internal.util.e.a(a, "enter removeReceipt for receipt[" + paramString + "]");
    Context localContext = com.amazon.device.iap.internal.d.d().b();
    com.amazon.device.iap.internal.util.d.a(localContext, "context");
    SharedPreferences.Editor localEditor = localContext.getSharedPreferences(b, 0).edit();
    localEditor.remove(paramString);
    localEditor.commit();
    com.amazon.device.iap.internal.util.e.a(a, "leave removeReceipt for receipt[" + paramString + "]");
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.amazon.device.iap.internal.util.e.a(a, "enter saveReceipt for receipt [" + paramString4 + "]");
    try
    {
      com.amazon.device.iap.internal.util.d.a(paramString2, "userId");
      com.amazon.device.iap.internal.util.d.a(paramString3, "receiptId");
      com.amazon.device.iap.internal.util.d.a(paramString4, "receiptString");
      Context localContext = com.amazon.device.iap.internal.d.d().b();
      com.amazon.device.iap.internal.util.d.a(localContext, "context");
      d locald = new d(paramString2, paramString4, paramString1, System.currentTimeMillis());
      SharedPreferences.Editor localEditor = localContext.getSharedPreferences(b, 0).edit();
      localEditor.putString(paramString3, locald.d());
      localEditor.commit();
      com.amazon.device.iap.internal.util.e.a(a, "leaving saveReceipt for receipt id [" + paramString3 + "]");
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        com.amazon.device.iap.internal.util.e.a(a, "error in saving pending receipt:" + paramString1 + "/" + paramString4 + ":" + localThrowable.getMessage());
    }
  }

  public Set<Receipt> b(String paramString)
  {
    Context localContext = com.amazon.device.iap.internal.d.d().b();
    com.amazon.device.iap.internal.util.d.a(localContext, "context");
    com.amazon.device.iap.internal.util.e.a(a, "enter getLocalReceipts for user[" + paramString + "]");
    HashSet localHashSet = new HashSet();
    if (com.amazon.device.iap.internal.util.d.a(paramString))
    {
      com.amazon.device.iap.internal.util.e.b(a, "empty UserId: " + paramString);
      throw new RuntimeException("Invalid UserId:" + paramString);
    }
    Map localMap = localContext.getSharedPreferences(b, 0).getAll();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)localMap.get(str1);
      try
      {
        d locald1 = d.a(str2);
        localHashSet.add(com.amazon.device.iap.internal.util.a.a(new JSONObject(locald1.b()), paramString, locald1.a()));
      }
      catch (com.amazon.device.iap.internal.b.d locald)
      {
        a(str1);
        com.amazon.device.iap.internal.util.e.b(a, "failed to verify signature:[" + str2 + "]");
      }
      catch (JSONException localJSONException)
      {
        a(str1);
        com.amazon.device.iap.internal.util.e.b(a, "failed to convert string to JSON object:[" + str2 + "]");
      }
      catch (Throwable localThrowable)
      {
        com.amazon.device.iap.internal.util.e.b(a, "failed to load the receipt from SharedPreference:[" + str2 + "]");
      }
    }
    com.amazon.device.iap.internal.util.e.a(a, "leaving getLocalReceipts for user[" + paramString + "], " + localHashSet.size() + " local receipts found.");
    if (System.currentTimeMillis() - f() > d)
      e();
    return localHashSet;
  }

  public String c(String paramString)
  {
    Context localContext = com.amazon.device.iap.internal.d.d().b();
    com.amazon.device.iap.internal.util.d.a(localContext, "context");
    if (com.amazon.device.iap.internal.util.d.a(paramString))
    {
      com.amazon.device.iap.internal.util.e.b(a, "empty receiptId: " + paramString);
      throw new RuntimeException("Invalid ReceiptId:" + paramString);
    }
    String str1 = localContext.getSharedPreferences(b, 0).getString(paramString, null);
    Object localObject = null;
    if (str1 != null);
    try
    {
      String str2 = d.a(str1).a();
      localObject = str2;
      return localObject;
    }
    catch (e locale)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.c.a
 * JD-Core Version:    0.6.2
 */