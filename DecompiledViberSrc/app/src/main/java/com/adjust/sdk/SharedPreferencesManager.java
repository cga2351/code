package com.adjust.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;

public class SharedPreferencesManager
{
  private static final int INDEX_CLICK_TIME = 1;
  private static final int INDEX_IS_SENDING = 2;
  private static final int INDEX_RAW_REFERRER = 0;
  private static final String PREFS_KEY_DEEPLINK_CLICK_TIME = "deeplink_click_time";
  private static final String PREFS_KEY_DEEPLINK_URL = "deeplink_url";
  private static final String PREFS_KEY_GDPR_FORGET_ME = "gdpr_forget_me";
  private static final String PREFS_KEY_INSTALL_TRACKED = "install_tracked";
  private static final String PREFS_KEY_PUSH_TOKEN = "push_token";
  private static final String PREFS_KEY_RAW_REFERRERS = "raw_referrers";
  private static final String PREFS_NAME = "adjust_preferences";
  private static final int REFERRERS_COUNT = 10;
  private final SharedPreferences sharedPreferences;

  public SharedPreferencesManager(Context paramContext)
  {
    this.sharedPreferences = paramContext.getSharedPreferences("adjust_preferences", 0);
  }

  // ERROR //
  private boolean getBoolean(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/adjust/sdk/SharedPreferencesManager:sharedPreferences	Landroid/content/SharedPreferences;
    //   6: aload_1
    //   7: iload_2
    //   8: invokeinterface 58 3 0
    //   13: istore 5
    //   15: iload 5
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: astore 4
    //   24: aload_0
    //   25: monitorexit
    //   26: aload 4
    //   28: athrow
    //   29: astore_3
    //   30: goto -12 -> 18
    //
    // Exception table:
    //   from	to	target	type
    //   2	15	22	finally
    //   2	15	29	java/lang/ClassCastException
  }

  // ERROR //
  private long getLong(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/adjust/sdk/SharedPreferencesManager:sharedPreferences	Landroid/content/SharedPreferences;
    //   6: aload_1
    //   7: lload_2
    //   8: invokeinterface 62 4 0
    //   13: lstore 6
    //   15: lload 6
    //   17: lstore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: lload_2
    //   21: lreturn
    //   22: astore 5
    //   24: aload_0
    //   25: monitorexit
    //   26: aload 5
    //   28: athrow
    //   29: astore 4
    //   31: goto -13 -> 18
    //
    // Exception table:
    //   from	to	target	type
    //   2	15	22	finally
    //   2	15	29	java/lang/ClassCastException
  }

  private int getRawReferrerIndex(String paramString, long paramLong)
  {
    int i = 0;
    while (true)
    {
      try
      {
        JSONArray localJSONArray1 = getRawReferrerArray();
        if (i < localJSONArray1.length())
        {
          JSONArray localJSONArray2 = localJSONArray1.getJSONArray(i);
          String str = localJSONArray2.optString(0, null);
          if ((str == null) || (!str.equals(paramString)))
            break label94;
          long l = localJSONArray2.optLong(1, -1L);
          if (l != paramLong)
            break label94;
          return i;
        }
      }
      catch (JSONException localJSONException)
      {
        i = -1;
        continue;
      }
      finally
      {
      }
      label94: i++;
    }
  }

  // ERROR //
  private String getString(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/adjust/sdk/SharedPreferencesManager:sharedPreferences	Landroid/content/SharedPreferences;
    //   6: aload_1
    //   7: aconst_null
    //   8: invokeinterface 103 3 0
    //   13: astore 7
    //   15: aload 7
    //   17: astore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_3
    //   21: areturn
    //   22: astore 5
    //   24: aload_1
    //   25: ldc 30
    //   27: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: istore 6
    //   32: aconst_null
    //   33: astore_3
    //   34: iload 6
    //   36: ifeq -18 -> 18
    //   39: aload_0
    //   40: ldc 30
    //   42: invokespecial 107	com/adjust/sdk/SharedPreferencesManager:remove	(Ljava/lang/String;)V
    //   45: aconst_null
    //   46: astore_3
    //   47: goto -29 -> 18
    //   50: astore 4
    //   52: aload_0
    //   53: monitorexit
    //   54: aload 4
    //   56: athrow
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_3
    //   60: goto -42 -> 18
    //
    // Exception table:
    //   from	to	target	type
    //   2	15	22	java/lang/Throwable
    //   2	15	50	finally
    //   24	32	50	finally
    //   39	45	50	finally
    //   2	15	57	java/lang/ClassCastException
  }

  private void remove(String paramString)
  {
    try
    {
      this.sharedPreferences.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void saveBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      this.sharedPreferences.edit().putBoolean(paramString, paramBoolean).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void saveLong(String paramString, long paramLong)
  {
    try
    {
      this.sharedPreferences.edit().putLong(paramString, paramLong).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void saveString(String paramString1, String paramString2)
  {
    try
    {
      this.sharedPreferences.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void clear()
  {
    try
    {
      this.sharedPreferences.edit().clear().apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long getDeeplinkClickTime()
  {
    try
    {
      long l = getLong("deeplink_click_time", -1L);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getDeeplinkUrl()
  {
    try
    {
      String str = getString("deeplink_url");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean getGdprForgetMe()
  {
    try
    {
      boolean bool = getBoolean("gdpr_forget_me", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean getInstallTracked()
  {
    try
    {
      boolean bool = getBoolean("install_tracked", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getPushToken()
  {
    try
    {
      String str = getString("push_token");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public JSONArray getRawReferrer(String paramString, long paramLong)
  {
    try
    {
      int i = getRawReferrerIndex(paramString, paramLong);
      if (i >= 0);
      while (true)
      {
        try
        {
          JSONArray localJSONArray2 = getRawReferrerArray().getJSONArray(i);
          localJSONArray1 = localJSONArray2;
          return localJSONArray1;
        }
        catch (JSONException localJSONException)
        {
        }
        JSONArray localJSONArray1 = null;
      }
    }
    finally
    {
    }
  }

  // ERROR //
  public JSONArray getRawReferrerArray()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 30
    //   5: invokespecial 147	com/adjust/sdk/SharedPreferencesManager:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +82 -> 92
    //   13: new 72	org/json/JSONArray
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 158	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 76	org/json/JSONArray:length	()I
    //   28: bipush 10
    //   30: if_icmple +48 -> 78
    //   33: new 72	org/json/JSONArray
    //   36: dup
    //   37: invokespecial 159	org/json/JSONArray:<init>	()V
    //   40: astore_3
    //   41: iconst_0
    //   42: istore 7
    //   44: iload 7
    //   46: bipush 10
    //   48: if_icmpge +21 -> 69
    //   51: aload_3
    //   52: aload 4
    //   54: iload 7
    //   56: invokevirtual 163	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   59: invokevirtual 167	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   62: pop
    //   63: iinc 7 1
    //   66: goto -22 -> 44
    //   69: aload_0
    //   70: aload_3
    //   71: invokevirtual 171	com/adjust/sdk/SharedPreferencesManager:saveRawReferrerArray	(Lorg/json/JSONArray;)V
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_3
    //   77: areturn
    //   78: new 72	org/json/JSONArray
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 158	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   86: astore_3
    //   87: goto -13 -> 74
    //   90: astore 6
    //   92: new 72	org/json/JSONArray
    //   95: dup
    //   96: invokespecial 159	org/json/JSONArray:<init>	()V
    //   99: astore_3
    //   100: goto -26 -> 74
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore 5
    //   110: goto -18 -> 92
    //
    // Exception table:
    //   from	to	target	type
    //   13	41	90	org/json/JSONException
    //   51	63	90	org/json/JSONException
    //   69	74	90	org/json/JSONException
    //   78	87	90	org/json/JSONException
    //   2	9	103	finally
    //   13	41	103	finally
    //   51	63	103	finally
    //   69	74	103	finally
    //   78	87	103	finally
    //   92	100	103	finally
    //   13	41	108	java/lang/Throwable
    //   51	63	108	java/lang/Throwable
    //   69	74	108	java/lang/Throwable
    //   78	87	108	java/lang/Throwable
  }

  public void removeDeeplink()
  {
    try
    {
      remove("deeplink_url");
      remove("deeplink_click_time");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void removeGdprForgetMe()
  {
    try
    {
      remove("gdpr_forget_me");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void removePushToken()
  {
    try
    {
      remove("push_token");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void removeRawReferrer(String paramString, long paramLong)
  {
    if (paramString != null);
    try
    {
      int i = paramString.length();
      if (i == 0);
      while (true)
      {
        return;
        int j = getRawReferrerIndex(paramString, paramLong);
        if (j >= 0)
        {
          JSONArray localJSONArray1 = getRawReferrerArray();
          JSONArray localJSONArray2 = new JSONArray();
          int k = 0;
          int m = localJSONArray1.length();
          if (k < m)
          {
            if (k == j);
            while (true)
            {
              k++;
              break;
              try
              {
                localJSONArray2.put(localJSONArray1.getJSONArray(k));
              }
              catch (JSONException localJSONException)
              {
              }
            }
          }
          saveString("raw_referrers", localJSONArray2.toString());
        }
      }
    }
    finally
    {
    }
  }

  public void saveDeeplink(Uri paramUri, long paramLong)
  {
    if (paramUri == null);
    while (true)
    {
      return;
      try
      {
        saveString("deeplink_url", paramUri.toString());
        saveLong("deeplink_click_time", paramLong);
      }
      finally
      {
      }
    }
  }

  public void savePushToken(String paramString)
  {
    try
    {
      saveString("push_token", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void saveRawReferrer(String paramString, long paramLong)
  {
    try
    {
      JSONArray localJSONArray1 = getRawReferrer(paramString, paramLong);
      if (localJSONArray1 != null);
      while (true)
      {
        label15: return;
        JSONArray localJSONArray2 = getRawReferrerArray();
        if (localJSONArray2.length() != 10)
        {
          JSONArray localJSONArray3 = new JSONArray();
          localJSONArray3.put(0, paramString);
          localJSONArray3.put(1, paramLong);
          localJSONArray3.put(2, 0);
          localJSONArray2.put(localJSONArray3);
          saveRawReferrerArray(localJSONArray2);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      break label15;
    }
    finally
    {
    }
  }

  public void saveRawReferrerArray(JSONArray paramJSONArray)
  {
    try
    {
      saveString("raw_referrers", paramJSONArray.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        remove("raw_referrers");
    }
    finally
    {
    }
  }

  public void setGdprForgetMe()
  {
    try
    {
      saveBoolean("gdpr_forget_me", true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setInstallTracked()
  {
    try
    {
      saveBoolean("install_tracked", true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  public void setSendingReferrersAsNotSent()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 70	com/adjust/sdk/SharedPreferencesManager:getRawReferrerArray	()Lorg/json/JSONArray;
    //   8: astore 4
    //   10: iconst_0
    //   11: istore 5
    //   13: iload 5
    //   15: aload 4
    //   17: invokevirtual 76	org/json/JSONArray:length	()I
    //   20: if_icmpge +36 -> 56
    //   23: aload 4
    //   25: iload 5
    //   27: invokevirtual 80	org/json/JSONArray:getJSONArray	(I)Lorg/json/JSONArray;
    //   30: astore 6
    //   32: aload 6
    //   34: iconst_2
    //   35: iconst_m1
    //   36: invokevirtual 210	org/json/JSONArray:optInt	(II)I
    //   39: iconst_1
    //   40: if_icmpne +38 -> 78
    //   43: aload 6
    //   45: iconst_2
    //   46: iconst_0
    //   47: invokevirtual 201	org/json/JSONArray:put	(II)Lorg/json/JSONArray;
    //   50: pop
    //   51: iconst_1
    //   52: istore_1
    //   53: goto +25 -> 78
    //   56: iload_1
    //   57: ifeq +9 -> 66
    //   60: aload_0
    //   61: aload 4
    //   63: invokevirtual 171	com/adjust/sdk/SharedPreferencesManager:saveRawReferrerArray	(Lorg/json/JSONArray;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    //   74: astore_2
    //   75: goto -9 -> 66
    //   78: iinc 5 1
    //   81: goto -68 -> 13
    //
    // Exception table:
    //   from	to	target	type
    //   4	10	69	finally
    //   13	51	69	finally
    //   60	66	69	finally
    //   4	10	74	org/json/JSONException
    //   13	51	74	org/json/JSONException
    //   60	66	74	org/json/JSONException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.SharedPreferencesManager
 * JD-Core Version:    0.6.2
 */