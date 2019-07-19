package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.f.c;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public class dg
  implements da
{
  private static final String a = c.a(dg.class);
  private final SharedPreferences b;

  public dg(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext.getSharedPreferences("com.appboy.storage.session_storage" + i.a(paramContext, paramString1, paramString2), 0);
  }

  private void a(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("end_time"));
    try
    {
      paramJSONObject.put("end_time", di.b());
      return;
    }
    catch (JSONException localJSONException)
    {
      c.e(a, "Failed to set end time to now for session json data");
    }
  }

  // ERROR //
  public bh a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	a/a/dg:b	Landroid/content/SharedPreferences;
    //   4: ldc 78
    //   6: invokeinterface 83 2 0
    //   11: ifne +14 -> 25
    //   14: getstatic 19	a/a/dg:a	Ljava/lang/String;
    //   17: ldc 85
    //   19: invokestatic 87	com/appboy/f/c:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: getfield 49	a/a/dg:b	Landroid/content/SharedPreferences;
    //   29: ldc 78
    //   31: ldc 89
    //   33: invokeinterface 93 3 0
    //   38: astore 5
    //   40: aload 5
    //   42: astore_3
    //   43: new 56	org/json/JSONObject
    //   46: dup
    //   47: aload_0
    //   48: getfield 49	a/a/dg:b	Landroid/content/SharedPreferences;
    //   51: aload_3
    //   52: ldc 89
    //   54: invokeinterface 93 3 0
    //   59: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   62: astore_2
    //   63: new 98	a/a/bh
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 100	a/a/bh:<init>	(Lorg/json/JSONObject;)V
    //   71: astore 6
    //   73: aload 6
    //   75: areturn
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_3
    //   81: getstatic 19	a/a/dg:a	Ljava/lang/String;
    //   84: new 25	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   91: ldc 102
    //   93: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_3
    //   97: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 104
    //   102: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_2
    //   106: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aload_1
    //   113: invokestatic 111	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   116: pop
    //   117: aconst_null
    //   118: areturn
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_2
    //   122: goto -41 -> 81
    //   125: astore_1
    //   126: goto -45 -> 81
    //
    // Exception table:
    //   from	to	target	type
    //   25	40	76	org/json/JSONException
    //   43	63	119	org/json/JSONException
    //   63	73	125	org/json/JSONException
  }

  public void a(bh parambh)
  {
    String str = parambh.a().toString();
    JSONObject localJSONObject = parambh.g();
    SharedPreferences.Editor localEditor = this.b.edit();
    a(localJSONObject);
    localEditor.putString(str, localJSONObject.toString());
    if (!parambh.d())
      localEditor.putString("current_open_session", str);
    while (true)
    {
      localEditor.apply();
      return;
      if (this.b.getString("current_open_session", "").equals(str))
        localEditor.remove("current_open_session");
    }
  }

  public void b(bh parambh)
  {
    String str1 = this.b.getString("current_open_session", null);
    String str2 = parambh.a().toString();
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.remove(str2);
    if (str2.equals(str1))
      localEditor.remove("current_open_session");
    localEditor.apply();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dg
 * JD-Core Version:    0.6.2
 */