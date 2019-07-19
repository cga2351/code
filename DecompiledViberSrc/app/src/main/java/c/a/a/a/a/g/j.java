package c.a.a.a.a.g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import c.a.a.a.a.b.k;
import c.a.a.a.a.f.d;
import org.json.JSONException;
import org.json.JSONObject;

class j
  implements s
{
  private final w a;
  private final v b;
  private final k c;
  private final g d;
  private final x e;
  private final c.a.a.a.i f;
  private final c.a.a.a.a.f.c g;
  private final c.a.a.a.a.b.l h;

  public j(c.a.a.a.i parami, w paramw, k paramk, v paramv, g paramg, x paramx, c.a.a.a.a.b.l paraml)
  {
    this.f = parami;
    this.a = paramw;
    this.c = paramk;
    this.b = paramv;
    this.d = paramg;
    this.e = paramx;
    this.h = paraml;
    this.g = new d(this.f);
  }

  private void a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    c.a.a.a.c.g().a("Fabric", paramString + paramJSONObject.toString());
  }

  // ERROR //
  private t b(r paramr)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 85	c/a/a/a/a/g/r:b	Lc/a/a/a/a/g/r;
    //   5: aload_1
    //   6: invokevirtual 89	c/a/a/a/a/g/r:equals	(Ljava/lang/Object;)Z
    //   9: istore 4
    //   11: aconst_null
    //   12: astore_2
    //   13: iload 4
    //   15: ifne +99 -> 114
    //   18: aload_0
    //   19: getfield 37	c/a/a/a/a/g/j:d	Lc/a/a/a/a/g/g;
    //   22: invokeinterface 94 1 0
    //   27: astore 5
    //   29: aload 5
    //   31: ifnull +130 -> 161
    //   34: aload_0
    //   35: getfield 35	c/a/a/a/a/g/j:b	Lc/a/a/a/a/g/v;
    //   38: aload_0
    //   39: getfield 33	c/a/a/a/a/g/j:c	Lc/a/a/a/a/b/k;
    //   42: aload 5
    //   44: invokeinterface 99 3 0
    //   49: astore 6
    //   51: aload 6
    //   53: ifnull +93 -> 146
    //   56: aload_0
    //   57: aload 5
    //   59: ldc 101
    //   61: invokespecial 103	c/a/a/a/a/g/j:a	(Lorg/json/JSONObject;Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 33	c/a/a/a/a/g/j:c	Lc/a/a/a/a/b/k;
    //   68: invokeinterface 108 1 0
    //   73: lstore 7
    //   75: getstatic 110	c/a/a/a/a/g/r:c	Lc/a/a/a/a/g/r;
    //   78: aload_1
    //   79: invokevirtual 89	c/a/a/a/a/g/r:equals	(Ljava/lang/Object;)Z
    //   82: ifne +17 -> 99
    //   85: aload 6
    //   87: lload 7
    //   89: invokevirtual 115	c/a/a/a/a/g/t:a	(J)Z
    //   92: istore 10
    //   94: iload 10
    //   96: ifne +20 -> 116
    //   99: invokestatic 56	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   102: ldc 58
    //   104: ldc 117
    //   106: invokeinterface 77 3 0
    //   111: aload 6
    //   113: astore_2
    //   114: aload_2
    //   115: areturn
    //   116: invokestatic 56	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   119: ldc 58
    //   121: ldc 119
    //   123: invokeinterface 77 3 0
    //   128: aconst_null
    //   129: areturn
    //   130: astore_3
    //   131: invokestatic 56	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   134: ldc 58
    //   136: ldc 121
    //   138: aload_3
    //   139: invokeinterface 124 4 0
    //   144: aload_2
    //   145: areturn
    //   146: invokestatic 56	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   149: ldc 58
    //   151: ldc 126
    //   153: aconst_null
    //   154: invokeinterface 124 4 0
    //   159: aconst_null
    //   160: areturn
    //   161: invokestatic 56	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   164: ldc 58
    //   166: ldc 128
    //   168: invokeinterface 77 3 0
    //   173: aconst_null
    //   174: areturn
    //   175: astore 9
    //   177: aload 6
    //   179: astore_2
    //   180: aload 9
    //   182: astore_3
    //   183: goto -52 -> 131
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	130	java/lang/Exception
    //   18	29	130	java/lang/Exception
    //   34	51	130	java/lang/Exception
    //   56	94	130	java/lang/Exception
    //   116	128	130	java/lang/Exception
    //   146	159	130	java/lang/Exception
    //   161	173	130	java/lang/Exception
    //   99	111	175	java/lang/Exception
  }

  public t a()
  {
    return a(r.a);
  }

  // ERROR //
  public t a(r paramr)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 41	c/a/a/a/a/g/j:h	Lc/a/a/a/a/b/l;
    //   6: invokevirtual 138	c/a/a/a/a/b/l:a	()Z
    //   9: ifne +17 -> 26
    //   12: invokestatic 56	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   15: ldc 58
    //   17: ldc 140
    //   19: invokeinterface 77 3 0
    //   24: aload_2
    //   25: areturn
    //   26: invokestatic 142	c/a/a/a/c:h	()Z
    //   29: istore 4
    //   31: aconst_null
    //   32: astore_2
    //   33: iload 4
    //   35: ifne +148 -> 183
    //   38: aload_0
    //   39: invokevirtual 144	c/a/a/a/a/g/j:d	()Z
    //   42: istore 5
    //   44: aconst_null
    //   45: astore_2
    //   46: iload 5
    //   48: ifne +135 -> 183
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 146	c/a/a/a/a/g/j:b	(Lc/a/a/a/a/g/r;)Lc/a/a/a/a/g/t;
    //   56: astore 6
    //   58: aload 6
    //   60: astore 7
    //   62: aload 7
    //   64: ifnonnull +73 -> 137
    //   67: aload_0
    //   68: getfield 39	c/a/a/a/a/g/j:e	Lc/a/a/a/a/g/x;
    //   71: aload_0
    //   72: getfield 31	c/a/a/a/a/g/j:a	Lc/a/a/a/a/g/w;
    //   75: invokeinterface 151 2 0
    //   80: astore 10
    //   82: aload 10
    //   84: ifnull +53 -> 137
    //   87: aload_0
    //   88: getfield 35	c/a/a/a/a/g/j:b	Lc/a/a/a/a/g/v;
    //   91: aload_0
    //   92: getfield 33	c/a/a/a/a/g/j:c	Lc/a/a/a/a/b/k;
    //   95: aload 10
    //   97: invokeinterface 99 3 0
    //   102: astore 7
    //   104: aload_0
    //   105: getfield 37	c/a/a/a/a/g/j:d	Lc/a/a/a/a/g/g;
    //   108: aload 7
    //   110: getfield 154	c/a/a/a/a/g/t:g	J
    //   113: aload 10
    //   115: invokeinterface 157 4 0
    //   120: aload_0
    //   121: aload 10
    //   123: ldc 159
    //   125: invokespecial 103	c/a/a/a/a/g/j:a	(Lorg/json/JSONObject;Ljava/lang/String;)V
    //   128: aload_0
    //   129: aload_0
    //   130: invokevirtual 161	c/a/a/a/a/g/j:b	()Ljava/lang/String;
    //   133: invokevirtual 164	c/a/a/a/a/g/j:a	(Ljava/lang/String;)Z
    //   136: pop
    //   137: aload 7
    //   139: astore_2
    //   140: aload_2
    //   141: ifnonnull -117 -> 24
    //   144: aload_0
    //   145: getstatic 110	c/a/a/a/a/g/r:c	Lc/a/a/a/a/g/r;
    //   148: invokespecial 146	c/a/a/a/a/g/j:b	(Lc/a/a/a/a/g/r;)Lc/a/a/a/a/g/t;
    //   151: astore 8
    //   153: aload 8
    //   155: areturn
    //   156: astore_3
    //   157: invokestatic 56	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   160: ldc 58
    //   162: ldc 166
    //   164: aload_3
    //   165: invokeinterface 124 4 0
    //   170: aload_2
    //   171: areturn
    //   172: astore 9
    //   174: aload 7
    //   176: astore_2
    //   177: aload 9
    //   179: astore_3
    //   180: goto -23 -> 157
    //   183: aconst_null
    //   184: astore 7
    //   186: goto -124 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   26	31	156	java/lang/Exception
    //   38	44	156	java/lang/Exception
    //   51	58	156	java/lang/Exception
    //   144	153	156	java/lang/Exception
    //   67	82	172	java/lang/Exception
    //   87	137	172	java/lang/Exception
  }

  @SuppressLint({"CommitPrefEdits"})
  boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.g.b();
    localEditor.putString("existing_instance_identifier", paramString);
    return this.g.a(localEditor);
  }

  String b()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = c.a.a.a.a.b.i.m(this.f.r());
    return c.a.a.a.a.b.i.a(arrayOfString);
  }

  String c()
  {
    return this.g.a().getString("existing_instance_identifier", "");
  }

  boolean d()
  {
    return !c().equals(b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.g.j
 * JD-Core Version:    0.6.2
 */