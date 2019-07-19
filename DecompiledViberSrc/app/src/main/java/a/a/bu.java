package a.a;

import com.appboy.e.a;
import com.appboy.e.b;
import com.appboy.f.c;
import java.util.List;
import org.json.JSONArray;

public class bu
{
  private static final String a = c.a(bu.class);
  private final JSONArray b;
  private final bv c;
  private final b d;
  private final List<dy> e;
  private final by f;
  private final List<a> g;
  private final bw h;

  // ERROR //
  public bu(org.json.JSONObject paramJSONObject, ch paramch, au paramau)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	java/lang/Object:<init>	()V
    //   4: aload_1
    //   5: ldc 40
    //   7: aconst_null
    //   8: invokevirtual 46	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +144 -> 159
    //   18: aload_0
    //   19: new 48	a/a/bt
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 51	a/a/bt:<init>	(Ljava/lang/String;)V
    //   28: putfield 53	a/a/bu:h	La/a/bw;
    //   31: aload_1
    //   32: ldc 55
    //   34: invokevirtual 59	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +126 -> 167
    //   44: aload_0
    //   45: aload 5
    //   47: putfield 61	a/a/bu:b	Lorg/json/JSONArray;
    //   50: aload_0
    //   51: getfield 53	a/a/bu:h	La/a/bw;
    //   54: ifnonnull +199 -> 253
    //   57: aload_2
    //   58: instanceof 63
    //   61: ifeq +192 -> 253
    //   64: new 65	a/a/bv
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 68	a/a/bv:<init>	(Lorg/json/JSONObject;)V
    //   72: astore 13
    //   74: aload_0
    //   75: aload 13
    //   77: putfield 70	a/a/bu:c	La/a/bv;
    //   80: aload_0
    //   81: aload_1
    //   82: ldc 72
    //   84: invokevirtual 59	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   87: aload_3
    //   88: invokestatic 77	a/a/fs:a	(Lorg/json/JSONArray;La/a/au;)Ljava/util/List;
    //   91: putfield 79	a/a/bu:e	Ljava/util/List;
    //   94: aload_1
    //   95: ldc 81
    //   97: invokevirtual 85	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   100: astore 6
    //   102: aconst_null
    //   103: astore 7
    //   105: aload 6
    //   107: ifnull +18 -> 125
    //   110: new 87	a/a/by
    //   113: dup
    //   114: aload 6
    //   116: invokespecial 88	a/a/by:<init>	(Lorg/json/JSONObject;)V
    //   119: astore 8
    //   121: aload 8
    //   123: astore 7
    //   125: aload_0
    //   126: aload 7
    //   128: putfield 90	a/a/bu:f	La/a/by;
    //   131: aload_0
    //   132: aload_1
    //   133: ldc 92
    //   135: invokevirtual 85	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   138: aload_3
    //   139: invokestatic 95	a/a/fs:a	(Lorg/json/JSONObject;La/a/au;)Lcom/appboy/e/b;
    //   142: putfield 97	a/a/bu:d	Lcom/appboy/e/b;
    //   145: aload_0
    //   146: aload_1
    //   147: ldc 99
    //   149: invokevirtual 59	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   152: invokestatic 104	a/a/dk:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   155: putfield 106	a/a/bu:g	Ljava/util/List;
    //   158: return
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield 53	a/a/bu:h	La/a/bw;
    //   164: goto -133 -> 31
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 61	a/a/bu:b	Lorg/json/JSONArray;
    //   172: goto -122 -> 50
    //   175: astore 16
    //   177: getstatic 30	a/a/bu:a	Ljava/lang/String;
    //   180: new 108	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   187: ldc 111
    //   189: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   196: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload 16
    //   204: invokestatic 123	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   207: pop
    //   208: aconst_null
    //   209: astore 13
    //   211: goto -137 -> 74
    //   214: astore 14
    //   216: getstatic 30	a/a/bu:a	Ljava/lang/String;
    //   219: new 108	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   226: ldc 125
    //   228: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   235: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload 14
    //   243: invokestatic 123	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   246: pop
    //   247: aconst_null
    //   248: astore 13
    //   250: goto -176 -> 74
    //   253: aload_0
    //   254: aconst_null
    //   255: putfield 70	a/a/bu:c	La/a/bv;
    //   258: goto -178 -> 80
    //   261: astore 11
    //   263: getstatic 30	a/a/bu:a	Ljava/lang/String;
    //   266: new 108	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   273: ldc 127
    //   275: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 6
    //   280: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   283: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: aload 11
    //   291: invokestatic 123	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   294: pop
    //   295: aconst_null
    //   296: astore 7
    //   298: goto -173 -> 125
    //   301: astore 9
    //   303: getstatic 30	a/a/bu:a	Ljava/lang/String;
    //   306: new 108	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   313: ldc 129
    //   315: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload 6
    //   320: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   323: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: aload 9
    //   331: invokestatic 123	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   334: pop
    //   335: aconst_null
    //   336: astore 7
    //   338: goto -213 -> 125
    //
    // Exception table:
    //   from	to	target	type
    //   64	74	175	org/json/JSONException
    //   64	74	214	java/lang/Exception
    //   110	121	261	org/json/JSONException
    //   110	121	301	java/lang/Exception
  }

  public boolean a()
  {
    return this.b != null;
  }

  public boolean b()
  {
    return this.d != null;
  }

  public boolean c()
  {
    return this.f != null;
  }

  public boolean d()
  {
    return this.e != null;
  }

  public boolean e()
  {
    return this.h != null;
  }

  public boolean f()
  {
    return this.g != null;
  }

  public boolean g()
  {
    return this.c != null;
  }

  public JSONArray h()
  {
    return this.b;
  }

  public b i()
  {
    return this.d;
  }

  public by j()
  {
    return this.f;
  }

  public List<dy> k()
  {
    return this.e;
  }

  public List<a> l()
  {
    return this.g;
  }

  public bv m()
  {
    return this.c;
  }

  public bw n()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bu
 * JD-Core Version:    0.6.2
 */