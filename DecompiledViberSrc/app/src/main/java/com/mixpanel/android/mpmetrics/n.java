package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.mixpanel.android.b.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"CommitPrefEdits"})
class n
{
  private static Integer o;
  private static Boolean p;
  private static boolean q = true;
  private static final Object r = new Object();
  private final Future<SharedPreferences> a;
  private final Future<SharedPreferences> b;
  private final Future<SharedPreferences> c;
  private final Future<SharedPreferences> d;
  private final SharedPreferences.OnSharedPreferenceChangeListener e;
  private JSONObject f;
  private Map<String, String> g;
  private boolean h;
  private String i;
  private boolean j;
  private String k;
  private String l;
  private JSONArray m;
  private Boolean n;

  public n(Future<SharedPreferences> paramFuture1, Future<SharedPreferences> paramFuture2, Future<SharedPreferences> paramFuture3, Future<SharedPreferences> paramFuture4)
  {
    this.b = paramFuture1;
    this.a = paramFuture2;
    this.c = paramFuture3;
    this.d = paramFuture4;
    this.f = null;
    this.g = null;
    this.h = false;
    this.e = new SharedPreferences.OnSharedPreferenceChangeListener()
    {
      public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
      {
        synchronized (n.p())
        {
          n.a(n.this);
          n.b(false);
          return;
        }
      }
    };
  }

  // ERROR //
  public static JSONArray a(SharedPreferences paramSharedPreferences)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 73
    //   3: aconst_null
    //   4: invokeinterface 79 3 0
    //   9: astore_1
    //   10: aload_0
    //   11: ldc 81
    //   13: aconst_null
    //   14: invokeinterface 79 3 0
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +77 -> 98
    //   24: aload_1
    //   25: ifnull +73 -> 98
    //   28: new 83	org/json/JSONArray
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 86	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   36: astore_3
    //   37: new 83	org/json/JSONArray
    //   40: dup
    //   41: invokespecial 87	org/json/JSONArray:<init>	()V
    //   44: astore 4
    //   46: iconst_0
    //   47: istore 5
    //   49: iload 5
    //   51: aload_3
    //   52: invokevirtual 91	org/json/JSONArray:length	()I
    //   55: if_icmpge +59 -> 114
    //   58: aload_3
    //   59: iload 5
    //   61: invokevirtual 95	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   64: astore 9
    //   66: aload 9
    //   68: ldc 97
    //   70: aload_1
    //   71: invokevirtual 103	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 4
    //   77: aload 9
    //   79: invokevirtual 106	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   82: pop
    //   83: iinc 5 1
    //   86: goto -37 -> 49
    //   89: astore 12
    //   91: ldc 108
    //   93: ldc 110
    //   95: invokestatic 115	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore 8
    //   102: ldc 108
    //   104: ldc 117
    //   106: aload 8
    //   108: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: goto -28 -> 83
    //   114: aload_0
    //   115: invokeinterface 124 1 0
    //   120: astore 6
    //   122: aload 6
    //   124: ldc 81
    //   126: invokeinterface 130 2 0
    //   131: pop
    //   132: aload 6
    //   134: invokestatic 133	com/mixpanel/android/mpmetrics/n:a	(Landroid/content/SharedPreferences$Editor;)V
    //   137: aload 4
    //   139: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   28	37	89	org/json/JSONException
    //   58	83	100	org/json/JSONException
  }

  public static void a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    SharedPreferences.Editor localEditor;
    synchronized (r)
    {
      localEditor = paramContext.getSharedPreferences(paramString, 0).edit();
      localEditor.clear();
      Iterator localIterator = paramMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localEditor.putString((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    a(localEditor);
    q = true;
  }

  private static void a(SharedPreferences.Editor paramEditor)
  {
    paramEditor.apply();
  }

  private void j(String paramString)
  {
    try
    {
      localSharedPreferences = (SharedPreferences)this.d.get();
      if (localSharedPreferences == null)
        return;
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
      {
        f.e("MixpanelAPI.PIdentity", "Cannot read opt out flag from sharedPreferences.", localExecutionException.getCause());
        localSharedPreferences = null;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      SharedPreferences localSharedPreferences;
      while (true)
      {
        f.e("MixpanelAPI.PIdentity", "Cannot read opt out flag from sharedPreferences.", localInterruptedException);
        localSharedPreferences = null;
      }
      this.n = Boolean.valueOf(localSharedPreferences.getBoolean("opt_out_" + paramString, false));
    }
  }

  private void k(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)this.d.get()).edit();
      localEditor.putBoolean("opt_out_" + paramString, this.n.booleanValue());
      a(localEditor);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      f.e("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", localExecutionException.getCause());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      f.e("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", localInterruptedException);
    }
  }

  private JSONObject q()
  {
    if (this.f == null)
      r();
    return this.f;
  }

  private void r()
  {
    try
    {
      String str = ((SharedPreferences)this.a.get()).getString("super_properties", "{}");
      f.a("MixpanelAPI.PIdentity", "Loading Super Properties " + str);
      this.f = new JSONObject(str);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      f.e("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", localExecutionException.getCause());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      f.e("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", localInterruptedException);
      return;
    }
    catch (JSONException localJSONException)
    {
      f.e("MixpanelAPI.PIdentity", "Cannot parse stored superProperties");
      t();
      return;
    }
    finally
    {
      if (this.f == null)
        this.f = new JSONObject();
    }
  }

  private void s()
  {
    this.g = new HashMap();
    try
    {
      SharedPreferences localSharedPreferences = (SharedPreferences)this.b.get();
      localSharedPreferences.unregisterOnSharedPreferenceChangeListener(this.e);
      localSharedPreferences.registerOnSharedPreferenceChangeListener(this.e);
      Iterator localIterator = localSharedPreferences.getAll().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        Object localObject = localEntry.getValue();
        this.g.put(str, localObject.toString());
      }
    }
    catch (ExecutionException localExecutionException)
    {
      f.e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", localExecutionException.getCause());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      f.e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", localInterruptedException);
    }
  }

  private void t()
  {
    if (this.f == null)
    {
      f.e("MixpanelAPI.PIdentity", "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
      return;
    }
    String str = this.f.toString();
    f.a("MixpanelAPI.PIdentity", "Storing Super Properties " + str);
    try
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)this.a.get()).edit();
      localEditor.putString("super_properties", str);
      a(localEditor);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      f.e("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", localExecutionException.getCause());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      f.e("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", localInterruptedException);
    }
  }

  private void u()
  {
    String str;
    try
    {
      localSharedPreferences = (SharedPreferences)this.a.get();
      if (localSharedPreferences == null)
        return;
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
      {
        f.e("MixpanelAPI.PIdentity", "Cannot read distinct ids from sharedPreferences.", localExecutionException.getCause());
        localSharedPreferences = null;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      SharedPreferences localSharedPreferences;
      while (true)
      {
        f.e("MixpanelAPI.PIdentity", "Cannot read distinct ids from sharedPreferences.", localInterruptedException);
        localSharedPreferences = null;
      }
      this.i = localSharedPreferences.getString("events_distinct_id", null);
      this.j = localSharedPreferences.getBoolean("events_user_id_present", false);
      this.k = localSharedPreferences.getString("people_distinct_id", null);
      this.l = localSharedPreferences.getString("anonymous_id", null);
      this.m = null;
      str = localSharedPreferences.getString("waiting_array", null);
      if (str == null);
    }
    try
    {
      this.m = new JSONArray(str);
      if (this.i == null)
      {
        this.l = UUID.randomUUID().toString();
        this.i = this.l;
        this.j = false;
        v();
      }
      this.h = true;
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        f.e("MixpanelAPI.PIdentity", "Could not interpret waiting people JSON record " + str);
    }
  }

  private void v()
  {
    try
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)this.a.get()).edit();
      localEditor.putString("events_distinct_id", this.i);
      localEditor.putBoolean("events_user_id_present", this.j);
      localEditor.putString("people_distinct_id", this.k);
      localEditor.putString("anonymous_id", this.l);
      if (this.m == null)
        localEditor.remove("waiting_array");
      while (true)
      {
        a(localEditor);
        return;
        localEditor.putString("waiting_array", this.m.toString());
      }
    }
    catch (ExecutionException localExecutionException)
    {
      f.e("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", localExecutionException.getCause());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      f.e("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", localInterruptedException);
    }
  }

  public Map<String, String> a()
  {
    synchronized (r)
    {
      if ((q) || (this.g == null))
      {
        s();
        q = false;
      }
      return this.g;
    }
  }

  public void a(s params)
  {
    while (true)
    {
      JSONObject localJSONObject3;
      try
      {
        JSONObject localJSONObject1 = q();
        JSONObject localJSONObject2 = new JSONObject();
        try
        {
          Iterator localIterator = localJSONObject1.keys();
          if (!localIterator.hasNext())
            continue;
          String str = (String)localIterator.next();
          localJSONObject2.put(str, localJSONObject1.get(str));
          continue;
        }
        catch (JSONException localJSONException)
        {
          f.e("MixpanelAPI.PIdentity", "Can't copy from one JSONObject to another", localJSONException);
        }
        return;
        localJSONObject3 = params.a(localJSONObject2);
        if (localJSONObject3 == null)
        {
          f.d("MixpanelAPI.PIdentity", "An update to Mixpanel's super properties returned null, and will have no effect.");
          continue;
        }
      }
      finally
      {
      }
      this.f = localJSONObject3;
      t();
    }
  }

  // ERROR //
  public void a(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/mixpanel/android/mpmetrics/n:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 195 1 0
    //   11: checkcast 75	android/content/SharedPreferences
    //   14: astore 5
    //   16: aload 5
    //   18: invokeinterface 124 1 0
    //   23: astore 6
    //   25: aload 5
    //   27: ldc_w 339
    //   30: ldc_w 341
    //   33: invokeinterface 79 3 0
    //   38: astore 7
    //   40: aload 6
    //   42: ldc_w 339
    //   45: new 203	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   52: aload 7
    //   54: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: ldc_w 346
    //   64: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokeinterface 179 3 0
    //   75: pop
    //   76: aload 6
    //   78: invokestatic 133	com/mixpanel/android/mpmetrics/n:a	(Landroid/content/SharedPreferences$Editor;)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore 4
    //   86: ldc 108
    //   88: ldc_w 348
    //   91: aload 4
    //   93: invokevirtual 201	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   96: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: goto -18 -> 81
    //   102: astore_3
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_3
    //   106: athrow
    //   107: astore_2
    //   108: ldc 108
    //   110: ldc_w 350
    //   113: aload_2
    //   114: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: goto -36 -> 81
    //
    // Exception table:
    //   from	to	target	type
    //   2	81	84	java/util/concurrent/ExecutionException
    //   2	81	102	finally
    //   86	99	102	finally
    //   108	117	102	finally
    //   2	81	107	java/lang/InterruptedException
  }

  public void a(String paramString)
  {
    try
    {
      if (!this.h)
        u();
      this.i = paramString;
      v();
      return;
    }
    finally
    {
    }
  }

  public void a(String paramString, Long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)this.c.get()).edit();
      localEditor.putLong(paramString, paramLong.longValue());
      a(localEditor);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      localExecutionException.printStackTrace();
    }
  }

  public void a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = q();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          paramJSONObject.put(str, localJSONObject.get(str));
        }
        catch (JSONException localJSONException)
        {
          f.e("MixpanelAPI.PIdentity", "Object read from one JSON Object cannot be written to another", localJSONException);
        }
      }
    }
    finally
    {
    }
  }

  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      this.n = Boolean.valueOf(paramBoolean);
      k(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 375	com/mixpanel/android/mpmetrics/n:p	Ljava/lang/Boolean;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnonnull +34 -> 41
    //   10: aload_0
    //   11: getfield 55	com/mixpanel/android/mpmetrics/n:d	Ljava/util/concurrent/Future;
    //   14: invokeinterface 195 1 0
    //   19: checkcast 75	android/content/SharedPreferences
    //   22: ldc_w 377
    //   25: iconst_0
    //   26: invokeinterface 218 3 0
    //   31: ifeq +23 -> 54
    //   34: iconst_0
    //   35: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: putstatic 375	com/mixpanel/android/mpmetrics/n:p	Ljava/lang/Boolean;
    //   41: getstatic 375	com/mixpanel/android/mpmetrics/n:p	Ljava/lang/Boolean;
    //   44: invokevirtual 229	java/lang/Boolean:booleanValue	()Z
    //   47: istore 4
    //   49: aload_0
    //   50: monitorexit
    //   51: iload 4
    //   53: ireturn
    //   54: iload_1
    //   55: ifne +34 -> 89
    //   58: iconst_1
    //   59: istore 7
    //   61: iload 7
    //   63: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: putstatic 375	com/mixpanel/android/mpmetrics/n:p	Ljava/lang/Boolean;
    //   69: goto -28 -> 41
    //   72: astore 6
    //   74: iconst_0
    //   75: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   78: putstatic 375	com/mixpanel/android/mpmetrics/n:p	Ljava/lang/Boolean;
    //   81: goto -40 -> 41
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    //   89: iconst_0
    //   90: istore 7
    //   92: goto -31 -> 61
    //   95: astore 5
    //   97: iconst_0
    //   98: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   101: putstatic 375	com/mixpanel/android/mpmetrics/n:p	Ljava/lang/Boolean;
    //   104: goto -63 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   10	41	72	java/util/concurrent/ExecutionException
    //   61	69	72	java/util/concurrent/ExecutionException
    //   2	6	84	finally
    //   10	41	84	finally
    //   41	49	84	finally
    //   61	69	84	finally
    //   74	81	84	finally
    //   97	104	84	finally
    //   10	41	95	java/lang/InterruptedException
    //   61	69	95	java/lang/InterruptedException
  }

  public void b()
  {
    try
    {
      synchronized (r)
      {
        try
        {
          SharedPreferences.Editor localEditor = ((SharedPreferences)this.b.get()).edit();
          localEditor.clear();
          a(localEditor);
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          while (true)
            f.e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", localExecutionException.getCause());
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        f.e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", localInterruptedException);
    }
  }

  public void b(String paramString)
  {
    try
    {
      if (!this.h)
        u();
      this.k = paramString;
      v();
      return;
    }
    finally
    {
    }
  }

  public void b(JSONObject paramJSONObject)
  {
    try
    {
      if (!this.h)
        u();
      if (this.m == null)
        this.m = new JSONArray();
      this.m.put(paramJSONObject);
      v();
      return;
    }
    finally
    {
    }
  }

  public String c()
  {
    try
    {
      if (!this.h)
        u();
      String str = this.l;
      return str;
    }
    finally
    {
    }
  }

  // ERROR //
  public void c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/mixpanel/android/mpmetrics/n:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 195 1 0
    //   11: checkcast 75	android/content/SharedPreferences
    //   14: invokeinterface 124 1 0
    //   19: astore 5
    //   21: aload 5
    //   23: ldc_w 379
    //   26: aload_1
    //   27: invokeinterface 179 3 0
    //   32: pop
    //   33: aload 5
    //   35: invokestatic 133	com/mixpanel/android/mpmetrics/n:a	(Landroid/content/SharedPreferences$Editor;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore 4
    //   43: ldc 108
    //   45: ldc_w 381
    //   48: aload 4
    //   50: invokevirtual 201	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   53: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: goto -18 -> 38
    //   59: astore_3
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_3
    //   63: athrow
    //   64: astore_2
    //   65: ldc 108
    //   67: ldc_w 381
    //   70: aload_2
    //   71: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: goto -36 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   2	38	41	java/util/concurrent/ExecutionException
    //   2	38	59	finally
    //   43	56	59	finally
    //   65	74	59	finally
    //   2	38	64	java/lang/InterruptedException
  }

  public void c(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = q();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          localJSONObject.put(str, paramJSONObject.get(str));
        }
        catch (JSONException localJSONException)
        {
          f.e("MixpanelAPI.PIdentity", "Exception registering super property.", localJSONException);
        }
      }
    }
    finally
    {
    }
    t();
  }

  public String d()
  {
    try
    {
      if (!this.h)
        u();
      String str = this.i;
      return str;
    }
    finally
    {
    }
  }

  public void d(String paramString)
  {
    try
    {
      q().remove(paramString);
      t();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = q();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        boolean bool = localJSONObject.has(str);
        if (!bool)
          try
          {
            localJSONObject.put(str, paramJSONObject.get(str));
          }
          catch (JSONException localJSONException)
          {
            f.e("MixpanelAPI.PIdentity", "Exception registering super property.", localJSONException);
          }
      }
    }
    finally
    {
    }
    t();
  }

  public String e()
  {
    try
    {
      if (!this.h)
        u();
      if (this.j);
      for (String str = this.i; ; str = null)
        return str;
    }
    finally
    {
    }
  }

  public void e(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)this.c.get()).edit();
      localEditor.remove(paramString);
      a(localEditor);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      localExecutionException.printStackTrace();
    }
  }

  public void f()
  {
    try
    {
      if (!this.h)
        u();
      this.j = true;
      v();
      return;
    }
    finally
    {
    }
  }

  public boolean f(String paramString)
  {
    try
    {
      boolean bool2 = ((SharedPreferences)this.d.get()).getBoolean(paramString, false);
      bool1 = bool2;
      return bool1;
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
      {
        f.e("MixpanelAPI.PIdentity", "Couldn't read internal Mixpanel shared preferences.", localExecutionException.getCause());
        bool1 = false;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        f.e("MixpanelAPI.PIdentity", "Couldn't read internal Mixpanel from shared preferences.", localInterruptedException);
        boolean bool1 = false;
      }
    }
    finally
    {
    }
  }

  public String g()
  {
    try
    {
      if (!this.h)
        u();
      String str = this.k;
      return str;
    }
    finally
    {
    }
  }

  // ERROR //
  public void g(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/mixpanel/android/mpmetrics/n:d	Ljava/util/concurrent/Future;
    //   6: invokeinterface 195 1 0
    //   11: checkcast 75	android/content/SharedPreferences
    //   14: invokeinterface 124 1 0
    //   19: astore 5
    //   21: aload 5
    //   23: aload_1
    //   24: iconst_1
    //   25: invokeinterface 233 3 0
    //   30: pop
    //   31: aload 5
    //   33: invokestatic 133	com/mixpanel/android/mpmetrics/n:a	(Landroid/content/SharedPreferences$Editor;)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore 4
    //   41: ldc 108
    //   43: ldc_w 395
    //   46: aload 4
    //   48: invokevirtual 201	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   51: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: goto -18 -> 36
    //   57: astore_3
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_3
    //   61: athrow
    //   62: astore_2
    //   63: ldc 108
    //   65: ldc_w 397
    //   68: aload_2
    //   69: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: goto -36 -> 36
    //
    // Exception table:
    //   from	to	target	type
    //   2	36	39	java/util/concurrent/ExecutionException
    //   2	36	57	finally
    //   41	54	57	finally
    //   63	72	57	finally
    //   2	36	62	java/lang/InterruptedException
  }

  // ERROR //
  public JSONArray h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/mixpanel/android/mpmetrics/n:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 195 1 0
    //   11: checkcast 75	android/content/SharedPreferences
    //   14: invokestatic 400	com/mixpanel/android/mpmetrics/n:a	(Landroid/content/SharedPreferences;)Lorg/json/JSONArray;
    //   17: astore 7
    //   19: aload 7
    //   21: astore_2
    //   22: aload_0
    //   23: invokespecial 352	com/mixpanel/android/mpmetrics/n:u	()V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: astore 5
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 5
    //   36: astore 6
    //   38: ldc 108
    //   40: ldc_w 402
    //   43: aload 6
    //   45: invokevirtual 201	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   48: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   51: goto -25 -> 26
    //   54: astore 4
    //   56: aload_0
    //   57: monitorexit
    //   58: aload 4
    //   60: athrow
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_1
    //   65: astore_3
    //   66: ldc 108
    //   68: ldc_w 402
    //   71: aload_3
    //   72: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: goto -49 -> 26
    //   78: astore_3
    //   79: goto -13 -> 66
    //   82: astore 6
    //   84: goto -46 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	30	java/util/concurrent/ExecutionException
    //   2	19	54	finally
    //   22	26	54	finally
    //   38	51	54	finally
    //   66	75	54	finally
    //   2	19	61	java/lang/InterruptedException
    //   22	26	78	java/lang/InterruptedException
    //   22	26	82	java/util/concurrent/ExecutionException
  }

  public boolean h(String paramString)
  {
    if (paramString == null);
    for (boolean bool = false; ; bool = false)
      while (true)
      {
        return bool;
        try
        {
          Integer localInteger = Integer.valueOf(paramString);
          try
          {
            if (o == null)
            {
              o = Integer.valueOf(((SharedPreferences)this.d.get()).getInt("latest_version_code", -1));
              if (o.intValue() == -1)
              {
                o = localInteger;
                SharedPreferences.Editor localEditor2 = ((SharedPreferences)this.d.get()).edit();
                localEditor2.putInt("latest_version_code", localInteger.intValue());
                a(localEditor2);
              }
            }
            if (o.intValue() < localInteger.intValue())
            {
              SharedPreferences.Editor localEditor1 = ((SharedPreferences)this.d.get()).edit();
              localEditor1.putInt("latest_version_code", localInteger.intValue());
              a(localEditor1);
              bool = true;
            }
          }
          catch (ExecutionException localExecutionException)
          {
            f.e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", localExecutionException.getCause());
          }
          catch (InterruptedException localInterruptedException)
          {
            f.e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel from shared preferences.", localInterruptedException);
          }
        }
        finally
        {
        }
      }
  }

  // ERROR //
  public void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/mixpanel/android/mpmetrics/n:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 195 1 0
    //   11: checkcast 75	android/content/SharedPreferences
    //   14: invokeinterface 124 1 0
    //   19: astore 4
    //   21: aload 4
    //   23: invokeinterface 143 1 0
    //   28: pop
    //   29: aload 4
    //   31: invokestatic 133	com/mixpanel/android/mpmetrics/n:a	(Landroid/content/SharedPreferences$Editor;)V
    //   34: aload_0
    //   35: invokespecial 238	com/mixpanel/android/mpmetrics/n:r	()V
    //   38: aload_0
    //   39: invokespecial 352	com/mixpanel/android/mpmetrics/n:u	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_3
    //   46: new 427	java/lang/RuntimeException
    //   49: dup
    //   50: aload_3
    //   51: invokevirtual 201	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   54: invokespecial 430	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   57: athrow
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    //   63: astore_1
    //   64: new 427	java/lang/RuntimeException
    //   67: dup
    //   68: aload_1
    //   69: invokevirtual 431	java/lang/InterruptedException:getCause	()Ljava/lang/Throwable;
    //   72: invokespecial 430	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   75: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	42	45	java/util/concurrent/ExecutionException
    //   2	42	58	finally
    //   46	58	58	finally
    //   64	76	58	finally
    //   2	42	63	java/lang/InterruptedException
  }

  public boolean i(String paramString)
  {
    try
    {
      if (this.n == null)
        j(paramString);
      boolean bool = this.n.booleanValue();
      return bool;
    }
    finally
    {
    }
  }

  public void j()
  {
    try
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)this.c.get()).edit();
      localEditor.clear();
      a(localEditor);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      localExecutionException.printStackTrace();
    }
  }

  // ERROR //
  public void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/mixpanel/android/mpmetrics/n:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 195 1 0
    //   11: checkcast 75	android/content/SharedPreferences
    //   14: invokeinterface 124 1 0
    //   19: astore 4
    //   21: aload 4
    //   23: ldc_w 379
    //   26: invokeinterface 130 2 0
    //   31: pop
    //   32: aload 4
    //   34: invokestatic 133	com/mixpanel/android/mpmetrics/n:a	(Landroid/content/SharedPreferences$Editor;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_3
    //   41: ldc 108
    //   43: ldc_w 381
    //   46: aload_3
    //   47: invokevirtual 201	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   50: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: goto -16 -> 37
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: astore_1
    //   62: ldc 108
    //   64: ldc_w 381
    //   67: aload_1
    //   68: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: goto -34 -> 37
    //
    // Exception table:
    //   from	to	target	type
    //   2	37	40	java/util/concurrent/ExecutionException
    //   2	37	56	finally
    //   41	53	56	finally
    //   62	71	56	finally
    //   2	37	61	java/lang/InterruptedException
  }

  public Map<String, Long> l()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      Iterator localIterator = ((SharedPreferences)this.c.get()).getAll().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(localEntry.getKey(), Long.valueOf(localEntry.getValue().toString()));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return localHashMap;
    }
    catch (ExecutionException localExecutionException)
    {
      localExecutionException.printStackTrace();
    }
    return localHashMap;
  }

  public void m()
  {
    try
    {
      this.f = new JSONObject();
      t();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  public void n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/mixpanel/android/mpmetrics/n:d	Ljava/util/concurrent/Future;
    //   6: invokeinterface 195 1 0
    //   11: checkcast 75	android/content/SharedPreferences
    //   14: invokeinterface 124 1 0
    //   19: astore 4
    //   21: aload 4
    //   23: ldc_w 377
    //   26: iconst_1
    //   27: invokeinterface 233 3 0
    //   32: pop
    //   33: aload 4
    //   35: invokestatic 133	com/mixpanel/android/mpmetrics/n:a	(Landroid/content/SharedPreferences$Editor;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_3
    //   42: ldc 108
    //   44: ldc_w 395
    //   47: aload_3
    //   48: invokevirtual 201	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   51: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: goto -16 -> 38
    //   57: astore_2
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    //   62: astore_1
    //   63: ldc 108
    //   65: ldc_w 395
    //   68: aload_1
    //   69: invokestatic 120	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: goto -34 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   2	38	41	java/util/concurrent/ExecutionException
    //   2	38	57	finally
    //   42	54	57	finally
    //   63	72	57	finally
    //   2	38	62	java/lang/InterruptedException
  }

  public HashSet<Integer> o()
  {
    try
    {
      HashSet localHashSet = new HashSet();
      try
      {
        StringTokenizer localStringTokenizer = new StringTokenizer(((SharedPreferences)this.a.get()).getString("seen_campaign_ids", ""), ",");
        while (localStringTokenizer.hasMoreTokens())
          localHashSet.add(Integer.valueOf(localStringTokenizer.nextToken()));
      }
      catch (ExecutionException localExecutionException)
      {
        f.e("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", localExecutionException.getCause());
        return localHashSet;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          f.e("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", localInterruptedException);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.n
 * JD-Core Version:    0.6.2
 */