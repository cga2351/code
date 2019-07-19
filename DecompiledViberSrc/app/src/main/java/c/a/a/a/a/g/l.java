package c.a.a.a.a.g;

import c.a.a.a.a.b.a;
import c.a.a.a.a.e.d;
import c.a.a.a.a.e.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class l extends a
  implements x
{
  public l(c.a.a.a.i parami, String paramString1, String paramString2, e parame)
  {
    this(parami, paramString1, paramString2, parame, c.a.a.a.a.e.c.a);
  }

  l(c.a.a.a.i parami, String paramString1, String paramString2, e parame, c.a.a.a.a.e.c paramc)
  {
    super(parami, paramString1, paramString2, parame, paramc);
  }

  private d a(d paramd, w paramw)
  {
    a(paramd, "X-CRASHLYTICS-API-KEY", paramw.a);
    a(paramd, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
    a(paramd, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    a(paramd, "Accept", "application/json");
    a(paramd, "X-CRASHLYTICS-DEVICE-MODEL", paramw.b);
    a(paramd, "X-CRASHLYTICS-OS-BUILD-VERSION", paramw.c);
    a(paramd, "X-CRASHLYTICS-OS-DISPLAY-VERSION", paramw.d);
    a(paramd, "X-CRASHLYTICS-INSTALLATION-ID", paramw.e);
    return paramd;
  }

  private JSONObject a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      c.a.a.a.c.g().a("Fabric", "Failed to parse settings JSON from " + a(), localException);
      c.a.a.a.c.g().a("Fabric", "Settings response " + paramString);
    }
    return null;
  }

  private void a(d paramd, String paramString1, String paramString2)
  {
    if (paramString2 != null)
      paramd.a(paramString1, paramString2);
  }

  private Map<String, String> b(w paramw)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("build_version", paramw.h);
    localHashMap.put("display_version", paramw.g);
    localHashMap.put("source", Integer.toString(paramw.i));
    if (paramw.j != null)
      localHashMap.put("icon_hash", paramw.j);
    String str = paramw.f;
    if (!c.a.a.a.a.b.i.d(str))
      localHashMap.put("instance", str);
    return localHashMap;
  }

  JSONObject a(d paramd)
  {
    int i = paramd.b();
    c.a.a.a.c.g().a("Fabric", "Settings result was: " + i);
    if (a(i))
      return a(paramd.d());
    c.a.a.a.c.g().e("Fabric", "Failed to retrieve settings from " + a());
    return null;
  }

  // ERROR //
  public JSONObject a(w paramw)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 183	c/a/a/a/a/g/l:b	(Lc/a/a/a/a/g/w;)Ljava/util/Map;
    //   5: astore 7
    //   7: aload_0
    //   8: aload 7
    //   10: invokevirtual 186	c/a/a/a/a/g/l:a	(Ljava/util/Map;)Lc/a/a/a/a/e/d;
    //   13: astore 8
    //   15: aload 8
    //   17: astore_3
    //   18: aload_0
    //   19: aload_3
    //   20: aload_1
    //   21: invokespecial 188	c/a/a/a/a/g/l:a	(Lc/a/a/a/a/e/d;Lc/a/a/a/a/g/w;)Lc/a/a/a/a/e/d;
    //   24: astore_3
    //   25: invokestatic 81	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   28: ldc 83
    //   30: new 85	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   37: ldc 190
    //   39: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 95	c/a/a/a/a/g/l:a	()Ljava/lang/String;
    //   46: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokeinterface 108 3 0
    //   57: invokestatic 81	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   60: ldc 83
    //   62: new 85	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   69: ldc 192
    //   71: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 7
    //   76: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokeinterface 108 3 0
    //   87: aload_0
    //   88: aload_3
    //   89: invokevirtual 197	c/a/a/a/a/g/l:a	(Lc/a/a/a/a/e/d;)Lorg/json/JSONObject;
    //   92: astore 9
    //   94: aload 9
    //   96: astore 6
    //   98: aload_3
    //   99: ifnull +37 -> 136
    //   102: invokestatic 81	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   105: ldc 83
    //   107: new 85	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   114: ldc 199
    //   116: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_3
    //   120: ldc 201
    //   122: invokevirtual 204	c/a/a/a/a/e/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokeinterface 108 3 0
    //   136: aload 6
    //   138: areturn
    //   139: astore 5
    //   141: aconst_null
    //   142: astore_3
    //   143: invokestatic 81	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   146: ldc 83
    //   148: ldc 206
    //   150: aload 5
    //   152: invokeinterface 208 4 0
    //   157: aconst_null
    //   158: astore 6
    //   160: aload_3
    //   161: ifnull -25 -> 136
    //   164: invokestatic 81	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   167: ldc 83
    //   169: new 85	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   176: ldc 199
    //   178: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_3
    //   182: ldc 201
    //   184: invokevirtual 204	c/a/a/a/a/e/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokeinterface 108 3 0
    //   198: aconst_null
    //   199: areturn
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_2
    //   204: astore 4
    //   206: aload_3
    //   207: ifnull +37 -> 244
    //   210: invokestatic 81	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   213: ldc 83
    //   215: new 85	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   222: ldc 199
    //   224: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_3
    //   228: ldc 201
    //   230: invokevirtual 204	c/a/a/a/a/e/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   233: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokeinterface 108 3 0
    //   244: aload 4
    //   246: athrow
    //   247: astore 4
    //   249: goto -43 -> 206
    //   252: astore 5
    //   254: goto -111 -> 143
    //
    // Exception table:
    //   from	to	target	type
    //   0	15	139	c/a/a/a/a/e/d$c
    //   0	15	200	finally
    //   18	94	247	finally
    //   143	157	247	finally
    //   18	94	252	c/a/a/a/a/e/d$c
  }

  boolean a(int paramInt)
  {
    return (paramInt == 200) || (paramInt == 201) || (paramInt == 202) || (paramInt == 203);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.g.l
 * JD-Core Version:    0.6.2
 */