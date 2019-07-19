package com.microsoft.codepush.react;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o
{
  private SharedPreferences a;

  public JSONArray a()
  {
    String str = this.a.getString("CODE_PUSH_FAILED_UPDATES", null);
    if (str == null)
      return new JSONArray();
    try
    {
      JSONArray localJSONArray1 = new JSONArray(str);
      return localJSONArray1;
    }
    catch (JSONException localJSONException)
    {
      JSONArray localJSONArray2 = new JSONArray();
      this.a.edit().putString("CODE_PUSH_FAILED_UPDATES", localJSONArray2.toString()).commit();
      return localJSONArray2;
    }
  }

  public void a(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("hash", paramString);
      localJSONObject.put("isLoading", paramBoolean);
      this.a.edit().putString("CODE_PUSH_PENDING_UPDATE", localJSONObject.toString()).commit();
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new f("Unable to save pending update.", localJSONException);
    }
  }

  public void a(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = a(paramJSONObject.getString("packageHash"));
      if (bool)
        return;
    }
    catch (JSONException localJSONException1)
    {
      throw new f("Unable to read package hash from package.", localJSONException1);
    }
    String str = this.a.getString("CODE_PUSH_FAILED_UPDATES", null);
    JSONArray localJSONArray;
    if (str == null)
      localJSONArray = new JSONArray();
    while (true)
    {
      localJSONArray.put(paramJSONObject);
      this.a.edit().putString("CODE_PUSH_FAILED_UPDATES", localJSONArray.toString()).commit();
      return;
      try
      {
        localJSONArray = new JSONArray(str);
      }
      catch (JSONException localJSONException2)
      {
        throw new d("Unable to parse failed updates information " + str + " stored in SharedPreferences", localJSONException2);
      }
    }
  }

  public boolean a(String paramString)
  {
    JSONArray localJSONArray = a();
    boolean bool1 = false;
    if (paramString != null);
    for (int i = 0; ; i++)
    {
      int j = localJSONArray.length();
      bool1 = false;
      if (i < j);
      try
      {
        boolean bool2 = paramString.equals(localJSONArray.getJSONObject(i).getString("packageHash"));
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new f("Unable to read failedUpdates data stored in SharedPreferences.", localJSONException);
      }
    }
  }

  public JSONObject b()
  {
    String str = this.a.getString("CODE_PUSH_PENDING_UPDATE", null);
    if (str == null)
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      j.b("Unable to parse pending update metadata " + str + " stored in SharedPreferences");
    }
    return null;
  }

  public boolean b(String paramString)
  {
    JSONObject localJSONObject = b();
    if (localJSONObject != null);
    try
    {
      if (!localJSONObject.getBoolean("isLoading"))
        if (paramString != null)
        {
          boolean bool = localJSONObject.getString("hash").equals(paramString);
          if (!bool);
        }
        else
        {
          return true;
        }
      return false;
    }
    catch (JSONException localJSONException)
    {
      throw new f("Unable to read pending update metadata in isPendingUpdate.", localJSONException);
    }
  }

  public void c()
  {
    this.a.edit().remove("CODE_PUSH_FAILED_UPDATES").commit();
  }

  // ERROR //
  public void c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 142	com/microsoft/codepush/react/o:e	()Lorg/json/JSONObject;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +100 -> 106
    //   9: aload_2
    //   10: ldc 74
    //   12: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: aload_1
    //   16: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: istore 10
    //   21: iconst_0
    //   22: istore_3
    //   23: iload 10
    //   25: ifeq +14 -> 39
    //   28: aload_2
    //   29: ldc 144
    //   31: invokevirtual 148	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   34: istore 11
    //   36: iload 11
    //   38: istore_3
    //   39: aload_2
    //   40: ldc 74
    //   42: aload_1
    //   43: invokevirtual 56	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_2
    //   48: ldc 150
    //   50: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   53: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   56: pop
    //   57: aload_2
    //   58: ldc 144
    //   60: iload_3
    //   61: iconst_1
    //   62: iadd
    //   63: invokevirtual 162	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload_0
    //   68: getfield 11	com/microsoft/codepush/react/o:a	Landroid/content/SharedPreferences;
    //   71: invokeinterface 32 1 0
    //   76: ldc 164
    //   78: aload_2
    //   79: invokevirtual 64	org/json/JSONObject:toString	()Ljava/lang/String;
    //   82: invokeinterface 42 3 0
    //   87: invokeinterface 46 1 0
    //   92: pop
    //   93: return
    //   94: astore 9
    //   96: ldc 166
    //   98: invokestatic 127	com/microsoft/codepush/react/j:b	(Ljava/lang/String;)V
    //   101: iconst_0
    //   102: istore_3
    //   103: goto -64 -> 39
    //   106: new 49	org/json/JSONObject
    //   109: dup
    //   110: invokespecial 50	org/json/JSONObject:<init>	()V
    //   113: astore_2
    //   114: iconst_0
    //   115: istore_3
    //   116: goto -77 -> 39
    //   119: astore 4
    //   121: new 66	com/microsoft/codepush/react/f
    //   124: dup
    //   125: ldc 168
    //   127: aload 4
    //   129: invokespecial 71	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	21	94	org/json/JSONException
    //   28	36	94	org/json/JSONException
    //   39	93	119	org/json/JSONException
  }

  public void d()
  {
    this.a.edit().remove("CODE_PUSH_PENDING_UPDATE").commit();
  }

  public JSONObject e()
  {
    String str = this.a.getString("LATEST_ROLLBACK_INFO", null);
    if (str == null)
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      j.b("Unable to parse latest rollback metadata " + str + " stored in SharedPreferences");
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.o
 * JD-Core Version:    0.6.2
 */