package com.yandex.metrica.impl;

import android.database.Cursor;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter.b;
import com.yandex.metrica.impl.ob.ab;
import com.yandex.metrica.impl.ob.b;
import com.yandex.metrica.impl.ob.e;
import com.yandex.metrica.impl.ob.eb;
import com.yandex.metrica.impl.ob.eg;
import com.yandex.metrica.impl.ob.ek;
import com.yandex.metrica.impl.ob.fh;
import com.yandex.metrica.impl.ob.kk.c;
import com.yandex.metrica.impl.ob.kk.c.a;
import com.yandex.metrica.impl.ob.kk.c.c;
import com.yandex.metrica.impl.ob.kk.c.d;
import com.yandex.metrica.impl.ob.kk.c.e;
import com.yandex.metrica.impl.ob.kk.c.e.b;
import com.yandex.metrica.impl.ob.kk.c.f;
import com.yandex.metrica.impl.ob.lq;
import com.yandex.metrica.impl.ob.lr;
import com.yandex.metrica.impl.ob.nn;
import com.yandex.metrica.impl.ob.np;
import com.yandex.metrica.impl.ob.nr;
import com.yandex.metrica.impl.ob.ns;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.oq;
import com.yandex.metrica.impl.ob.pg;
import com.yandex.metrica.impl.ob.pp;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class bd extends m
{
  kk.c l;
  fh m;
  List<Long> n;
  int o = 0;
  int p = -1;
  private final ab q;
  private c r;
  private final pp<byte[]> s;
  private final of t;
  private lr u;

  public bd(ab paramab)
  {
    this(paramab, paramab.m(), paramab.l());
  }

  bd(ab paramab, fh paramfh, lr paramlr)
  {
    this.q = paramab;
    this.m = paramfh;
    this.u = paramlr;
    this.t = paramab.o();
    this.s = new pg(245760, "event value in ReportTask", this.t);
  }

  public static a N()
  {
    return new a();
  }

  private static int a(b.a parama)
  {
    int i;
    try
    {
      kk.c.a[] arrayOfa = a(new JSONObject(parama.a));
      if (arrayOfa == null)
        break label66;
      int j = arrayOfa.length;
      int k = 0;
      int i2;
      for (i = 0; k < j; i = i2)
      {
        int i1 = b.b(7, arrayOfa[k]);
        i2 = i1 + i;
        k++;
      }
    }
    catch (JSONException localJSONException)
    {
      i = 0;
    }
    return i;
    label66: return 0;
  }

  private static void a(Uri.Builder paramBuilder, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
      paramBuilder.appendQueryParameter(paramString1, paramString2);
  }

  private static void a(Uri.Builder paramBuilder, String paramString1, String paramString2, String paramString3)
  {
    paramBuilder.appendQueryParameter(paramString1, bu.c(paramString2, paramString3));
  }

  private static kk.c.a[] a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.length();
    kk.c.a[] arrayOfa;
    Iterator localIterator;
    int j;
    if (i > 0)
    {
      arrayOfa = new kk.c.a[i];
      localIterator = paramJSONObject.keys();
      j = 0;
    }
    while (true)
    {
      String str;
      if (localIterator.hasNext())
        str = (String)localIterator.next();
      try
      {
        kk.c.a locala = new kk.c.a();
        locala.b = str;
        locala.c = paramJSONObject.getString(str);
        arrayOfa[j] = locala;
        label75: j++;
        continue;
        return arrayOfa;
        return null;
      }
      catch (JSONException localJSONException)
      {
        break label75;
      }
    }
  }

  protected String E()
  {
    return "report";
  }

  protected void G()
  {
    kk.c.e[] arrayOfe = this.l.b;
    for (int i = 0; i < arrayOfe.length; i++)
    {
      kk.c.e locale = arrayOfe[i];
      long l1 = ((Long)this.n.get(i)).longValue();
      ek localek = az.a(locale.c.d);
      this.m.a(l1, localek.a(), locale.d.length);
      az.a();
    }
    eb localeb = this.q.d().a();
    long[] arrayOfLong;
    if (localeb == null)
      arrayOfLong = new long[0];
    while (true)
    {
      this.m.a(arrayOfLong);
      return;
      arrayOfLong = new long[1];
      arrayOfLong[0] = localeb.c();
    }
  }

  kk.c.c[] K()
  {
    kk.c.c[] arrayOfc = az.a(this.q.c());
    if (arrayOfc != null)
    {
      int i = arrayOfc.length;
      for (int j = 0; j < i; j++)
      {
        kk.c.c localc = arrayOfc[j];
        this.o += b.b(localc);
      }
    }
    return arrayOfc;
  }

  // ERROR //
  protected c L()
  {
    // Byte code:
    //   0: new 232	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 233	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: new 232	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 233	java/util/ArrayList:<init>	()V
    //   15: astore_2
    //   16: new 77	org/json/JSONObject
    //   19: dup
    //   20: invokespecial 234	org/json/JSONObject:<init>	()V
    //   23: astore_3
    //   24: aload_0
    //   25: invokevirtual 238	com/yandex/metrica/impl/bd:M	()Landroid/database/Cursor;
    //   28: astore 10
    //   30: aload 10
    //   32: astore 5
    //   34: aconst_null
    //   35: astore 11
    //   37: aload_3
    //   38: astore 8
    //   40: aload 5
    //   42: invokeinterface 243 1 0
    //   47: ifeq +208 -> 255
    //   50: new 245	android/content/ContentValues
    //   53: dup
    //   54: invokespecial 246	android/content/ContentValues:<init>	()V
    //   57: astore 13
    //   59: aload 5
    //   61: aload 13
    //   63: invokestatic 251	com/yandex/metrica/impl/ob/nw:a	(Landroid/database/Cursor;Landroid/content/ContentValues;)V
    //   66: aload 13
    //   68: ldc 253
    //   70: invokevirtual 257	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   73: invokevirtual 171	java/lang/Long:longValue	()J
    //   76: lstore 14
    //   78: aload 13
    //   80: ldc_w 259
    //   83: invokevirtual 263	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   86: invokestatic 266	com/yandex/metrica/impl/ob/ek:a	(Ljava/lang/Integer;)Lcom/yandex/metrica/impl/ob/ek;
    //   89: astore 16
    //   91: aload_0
    //   92: lload 14
    //   94: invokevirtual 269	com/yandex/metrica/impl/bd:a	(J)Z
    //   97: ifne -57 -> 40
    //   100: aload 13
    //   102: invokestatic 272	com/yandex/metrica/impl/az:a	(Landroid/content/ContentValues;)Lcom/yandex/metrica/impl/ob/kk$c$g;
    //   105: astore 17
    //   107: aload 16
    //   109: invokestatic 275	com/yandex/metrica/impl/az:a	(Lcom/yandex/metrica/impl/ob/ek;)I
    //   112: istore 18
    //   114: aload_0
    //   115: getfield 51	com/yandex/metrica/impl/bd:u	Lcom/yandex/metrica/impl/ob/lr;
    //   118: invokevirtual 280	com/yandex/metrica/impl/ob/lr:y	()Ljava/lang/String;
    //   121: iload 18
    //   123: aload 17
    //   125: invokestatic 283	com/yandex/metrica/impl/az:a	(Ljava/lang/String;ILcom/yandex/metrica/impl/ob/kk$c$g;)Lcom/yandex/metrica/impl/ob/kk$c$e$b;
    //   128: astore 19
    //   130: aload_0
    //   131: aload_0
    //   132: getfield 43	com/yandex/metrica/impl/bd:o	I
    //   135: iconst_1
    //   136: ldc2_w 284
    //   139: invokestatic 288	com/yandex/metrica/impl/ob/b:c	(IJ)I
    //   142: iadd
    //   143: putfield 43	com/yandex/metrica/impl/bd:o	I
    //   146: aload_0
    //   147: aload_0
    //   148: getfield 43	com/yandex/metrica/impl/bd:o	I
    //   151: iconst_2
    //   152: aload 19
    //   154: invokestatic 94	com/yandex/metrica/impl/ob/b:b	(ILcom/yandex/metrica/impl/ob/e;)I
    //   157: iadd
    //   158: putfield 43	com/yandex/metrica/impl/bd:o	I
    //   161: aload_0
    //   162: getfield 43	com/yandex/metrica/impl/bd:o	I
    //   165: ldc_w 289
    //   168: if_icmpge +87 -> 255
    //   171: aload_0
    //   172: lload 14
    //   174: aload 19
    //   176: invokevirtual 292	com/yandex/metrica/impl/bd:a	(JLcom/yandex/metrica/impl/ob/kk$c$e$b;)Lcom/yandex/metrica/impl/bd$b;
    //   179: astore 20
    //   181: aload 20
    //   183: ifnull -143 -> 40
    //   186: aload 11
    //   188: ifnonnull +84 -> 272
    //   191: aload 20
    //   193: getfield 297	com/yandex/metrica/impl/bd$b:b	Lcom/yandex/metrica/impl/b$a;
    //   196: astore 11
    //   198: aload_2
    //   199: lload 14
    //   201: invokestatic 301	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   204: invokeinterface 305 2 0
    //   209: pop
    //   210: aload_1
    //   211: aload 20
    //   213: getfield 308	com/yandex/metrica/impl/bd$b:a	Lcom/yandex/metrica/impl/ob/kk$c$e;
    //   216: invokeinterface 305 2 0
    //   221: pop
    //   222: new 77	org/json/JSONObject
    //   225: dup
    //   226: aload 20
    //   228: getfield 297	com/yandex/metrica/impl/bd$b:b	Lcom/yandex/metrica/impl/b$a;
    //   231: getfield 82	com/yandex/metrica/impl/b$a:a	Ljava/lang/String;
    //   234: invokespecial 85	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 23
    //   239: aload 23
    //   241: astore 8
    //   243: aload 20
    //   245: getfield 311	com/yandex/metrica/impl/bd$b:c	Z
    //   248: istore 24
    //   250: iload 24
    //   252: ifeq -212 -> 40
    //   255: aload 5
    //   257: invokestatic 316	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   260: new 318	com/yandex/metrica/impl/bd$c
    //   263: dup
    //   264: aload_1
    //   265: aload_2
    //   266: aload 8
    //   268: invokespecial 321	com/yandex/metrica/impl/bd$c:<init>	(Ljava/util/List;Ljava/util/List;Lorg/json/JSONObject;)V
    //   271: areturn
    //   272: aload 11
    //   274: aload 20
    //   276: getfield 297	com/yandex/metrica/impl/bd$b:b	Lcom/yandex/metrica/impl/b$a;
    //   279: invokevirtual 324	com/yandex/metrica/impl/b$a:equals	(Ljava/lang/Object;)Z
    //   282: istore 26
    //   284: iload 26
    //   286: ifeq -31 -> 255
    //   289: goto -91 -> 198
    //   292: astore 7
    //   294: aload_3
    //   295: astore 8
    //   297: aconst_null
    //   298: astore 9
    //   300: aload 9
    //   302: invokestatic 316	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   305: goto -45 -> 260
    //   308: astore 4
    //   310: aconst_null
    //   311: astore 5
    //   313: aload 4
    //   315: astore 6
    //   317: aload 5
    //   319: invokestatic 316	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   322: aload 6
    //   324: athrow
    //   325: astore 6
    //   327: goto -10 -> 317
    //   330: astore 12
    //   332: aload 5
    //   334: astore 9
    //   336: goto -36 -> 300
    //   339: astore 25
    //   341: goto -98 -> 243
    //
    // Exception table:
    //   from	to	target	type
    //   24	30	292	java/lang/Exception
    //   24	30	308	finally
    //   40	181	325	finally
    //   191	198	325	finally
    //   198	222	325	finally
    //   222	239	325	finally
    //   243	250	325	finally
    //   272	284	325	finally
    //   40	181	330	java/lang/Exception
    //   191	198	330	java/lang/Exception
    //   198	222	330	java/lang/Exception
    //   222	239	330	java/lang/Exception
    //   243	250	330	java/lang/Exception
    //   272	284	330	java/lang/Exception
    //   222	239	339	org/json/JSONException
  }

  protected Cursor M()
  {
    return this.m.a(this.b);
  }

  protected Cursor a(long paramLong, ek paramek)
  {
    return this.m.a(paramLong, paramek);
  }

  // ERROR //
  protected b a(long paramLong, kk.c.e.b paramb)
  {
    // Byte code:
    //   0: new 173	com/yandex/metrica/impl/ob/kk$c$e
    //   3: dup
    //   4: invokespecial 334	com/yandex/metrica/impl/ob/kk$c$e:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: lload_1
    //   12: putfield 337	com/yandex/metrica/impl/ob/kk$c$e:b	J
    //   15: aload 4
    //   17: aload_3
    //   18: putfield 176	com/yandex/metrica/impl/ob/kk$c$e:c	Lcom/yandex/metrica/impl/ob/kk$c$e$b;
    //   21: aload_3
    //   22: getfield 181	com/yandex/metrica/impl/ob/kk$c$e$b:d	I
    //   25: invokestatic 186	com/yandex/metrica/impl/az:a	(I)Lcom/yandex/metrica/impl/ob/ek;
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 6
    //   33: aload_0
    //   34: lload_1
    //   35: aload 5
    //   37: invokevirtual 338	com/yandex/metrica/impl/bd:a	(JLcom/yandex/metrica/impl/ob/ek;)Landroid/database/Cursor;
    //   40: astore 13
    //   42: aload 13
    //   44: astore 8
    //   46: new 232	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 233	java/util/ArrayList:<init>	()V
    //   53: astore 14
    //   55: aload 8
    //   57: invokeinterface 243 1 0
    //   62: ifeq +634 -> 696
    //   65: new 245	android/content/ContentValues
    //   68: dup
    //   69: invokespecial 246	android/content/ContentValues:<init>	()V
    //   72: astore 16
    //   74: aload 8
    //   76: aload 16
    //   78: invokestatic 251	com/yandex/metrica/impl/ob/nw:a	(Landroid/database/Cursor;Landroid/content/ContentValues;)V
    //   81: aload 16
    //   83: ldc_w 259
    //   86: invokevirtual 263	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   89: invokevirtual 343	java/lang/Integer:intValue	()I
    //   92: aload_0
    //   93: getfield 51	com/yandex/metrica/impl/bd:u	Lcom/yandex/metrica/impl/ob/lr;
    //   96: invokevirtual 345	com/yandex/metrica/impl/ob/lr:I	()Z
    //   99: invokestatic 350	com/yandex/metrica/impl/az$c:a	(IZ)Lcom/yandex/metrica/impl/az$c;
    //   102: aload 16
    //   104: ldc_w 352
    //   107: invokevirtual 263	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   110: invokevirtual 355	com/yandex/metrica/impl/az$c:b	(Ljava/lang/Integer;)Lcom/yandex/metrica/impl/az$c;
    //   113: aload 16
    //   115: ldc_w 357
    //   118: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokevirtual 363	com/yandex/metrica/impl/az$c:a	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   124: aload 16
    //   126: ldc_w 365
    //   129: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokevirtual 367	com/yandex/metrica/impl/az$c:b	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   135: aload 16
    //   137: ldc_w 369
    //   140: invokevirtual 257	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   143: invokevirtual 171	java/lang/Long:longValue	()J
    //   146: invokevirtual 372	com/yandex/metrica/impl/az$c:a	(J)Lcom/yandex/metrica/impl/az$c;
    //   149: aload 16
    //   151: ldc_w 374
    //   154: invokevirtual 263	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   157: invokevirtual 343	java/lang/Integer:intValue	()I
    //   160: invokevirtual 377	com/yandex/metrica/impl/az$c:a	(I)Lcom/yandex/metrica/impl/az$c;
    //   163: aload 16
    //   165: ldc_w 379
    //   168: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokevirtual 382	com/yandex/metrica/impl/az$c:e	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   174: aload 16
    //   176: ldc_w 384
    //   179: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: invokevirtual 386	com/yandex/metrica/impl/az$c:c	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   185: aload 16
    //   187: ldc_w 388
    //   190: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   193: invokevirtual 390	com/yandex/metrica/impl/az$c:d	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   196: aload 16
    //   198: ldc_w 392
    //   201: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: invokevirtual 395	com/yandex/metrica/impl/az$c:g	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   207: aload 16
    //   209: ldc_w 397
    //   212: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 400	com/yandex/metrica/impl/az$c:h	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   218: aload 16
    //   220: ldc_w 402
    //   223: invokevirtual 263	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   226: invokevirtual 343	java/lang/Integer:intValue	()I
    //   229: invokevirtual 404	com/yandex/metrica/impl/az$c:b	(I)Lcom/yandex/metrica/impl/az$c;
    //   232: aload 16
    //   234: ldc_w 406
    //   237: invokevirtual 263	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   240: invokevirtual 343	java/lang/Integer:intValue	()I
    //   243: invokevirtual 408	com/yandex/metrica/impl/az$c:c	(I)Lcom/yandex/metrica/impl/az$c;
    //   246: aload 16
    //   248: ldc_w 410
    //   251: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   254: invokevirtual 413	com/yandex/metrica/impl/az$c:i	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   257: aload 16
    //   259: ldc_w 415
    //   262: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   265: invokevirtual 418	com/yandex/metrica/impl/az$c:f	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   268: aload 16
    //   270: ldc_w 420
    //   273: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   276: invokevirtual 423	com/yandex/metrica/impl/az$c:j	(Ljava/lang/String;)Lcom/yandex/metrica/impl/az$c;
    //   279: aload 16
    //   281: ldc_w 425
    //   284: invokevirtual 263	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   287: invokevirtual 343	java/lang/Integer:intValue	()I
    //   290: invokestatic 430	com/yandex/metrica/impl/ob/pb:a	(I)Lcom/yandex/metrica/impl/ob/pb;
    //   293: invokevirtual 433	com/yandex/metrica/impl/az$c:a	(Lcom/yandex/metrica/impl/ob/pb;)Lcom/yandex/metrica/impl/az$c;
    //   296: aload 16
    //   298: ldc_w 435
    //   301: invokevirtual 263	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   304: invokestatic 440	com/yandex/metrica/impl/t:a	(Ljava/lang/Integer;)Lcom/yandex/metrica/impl/t;
    //   307: invokevirtual 443	com/yandex/metrica/impl/az$c:a	(Lcom/yandex/metrica/impl/t;)Lcom/yandex/metrica/impl/az$c;
    //   310: astore 17
    //   312: aload 17
    //   314: invokevirtual 446	com/yandex/metrica/impl/az$c:c	()Ljava/lang/Integer;
    //   317: ifnull +373 -> 690
    //   320: aload 17
    //   322: invokevirtual 449	com/yandex/metrica/impl/az$c:e	()Lcom/yandex/metrica/impl/ob/kk$c$e$a;
    //   325: astore 18
    //   327: aload 18
    //   329: ifnull -274 -> 55
    //   332: new 79	com/yandex/metrica/impl/b$a
    //   335: dup
    //   336: aload 16
    //   338: ldc_w 451
    //   341: invokevirtual 360	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   344: aload 16
    //   346: ldc_w 453
    //   349: invokevirtual 257	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   352: invokevirtual 171	java/lang/Long:longValue	()J
    //   355: invokespecial 456	com/yandex/metrica/impl/b$a:<init>	(Ljava/lang/String;J)V
    //   358: astore 11
    //   360: aload 6
    //   362: ifnonnull +134 -> 496
    //   365: aload_0
    //   366: getfield 45	com/yandex/metrica/impl/bd:p	I
    //   369: ifge +25 -> 394
    //   372: aload_0
    //   373: aload 11
    //   375: invokestatic 458	com/yandex/metrica/impl/bd:a	(Lcom/yandex/metrica/impl/b$a;)I
    //   378: putfield 45	com/yandex/metrica/impl/bd:p	I
    //   381: aload_0
    //   382: aload_0
    //   383: getfield 43	com/yandex/metrica/impl/bd:o	I
    //   386: aload_0
    //   387: getfield 45	com/yandex/metrica/impl/bd:p	I
    //   390: iadd
    //   391: putfield 43	com/yandex/metrica/impl/bd:o	I
    //   394: aload_0
    //   395: getfield 66	com/yandex/metrica/impl/bd:s	Lcom/yandex/metrica/impl/ob/pp;
    //   398: aload 18
    //   400: getfield 463	com/yandex/metrica/impl/ob/kk$c$e$a:f	[B
    //   403: invokeinterface 468 2 0
    //   408: checkcast 469	[B
    //   411: astore 21
    //   413: aload 18
    //   415: getfield 463	com/yandex/metrica/impl/ob/kk$c$e$a:f	[B
    //   418: aload 21
    //   420: invokevirtual 472	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   423: ifne +31 -> 454
    //   426: aload 18
    //   428: aload 21
    //   430: putfield 463	com/yandex/metrica/impl/ob/kk$c$e$a:f	[B
    //   433: aload 18
    //   435: aload 18
    //   437: getfield 475	com/yandex/metrica/impl/ob/kk$c$e$a:k	I
    //   440: aload 18
    //   442: getfield 463	com/yandex/metrica/impl/ob/kk$c$e$a:f	[B
    //   445: arraylength
    //   446: aload 21
    //   448: arraylength
    //   449: isub
    //   450: iadd
    //   451: putfield 475	com/yandex/metrica/impl/ob/kk$c$e$a:k	I
    //   454: aload_0
    //   455: aload_0
    //   456: getfield 43	com/yandex/metrica/impl/bd:o	I
    //   459: iconst_3
    //   460: aload 18
    //   462: invokestatic 94	com/yandex/metrica/impl/ob/b:b	(ILcom/yandex/metrica/impl/ob/e;)I
    //   465: iadd
    //   466: putfield 43	com/yandex/metrica/impl/bd:o	I
    //   469: aload_0
    //   470: getfield 43	com/yandex/metrica/impl/bd:o	I
    //   473: ldc_w 289
    //   476: if_icmpge +230 -> 706
    //   479: aload 14
    //   481: aload 18
    //   483: invokeinterface 305 2 0
    //   488: pop
    //   489: aload 11
    //   491: astore 6
    //   493: goto -438 -> 55
    //   496: aload 6
    //   498: aload 11
    //   500: invokevirtual 324	com/yandex/metrica/impl/b$a:equals	(Ljava/lang/Object;)Z
    //   503: istore 19
    //   505: iload 19
    //   507: ifne +176 -> 683
    //   510: iconst_1
    //   511: istore 23
    //   513: aload 6
    //   515: astore 22
    //   517: aload 14
    //   519: invokeinterface 478 1 0
    //   524: ifle +55 -> 579
    //   527: aload 4
    //   529: aload 14
    //   531: aload 14
    //   533: invokeinterface 478 1 0
    //   538: anewarray 460	com/yandex/metrica/impl/ob/kk$c$e$a
    //   541: invokeinterface 482 2 0
    //   546: checkcast 483	[Lcom/yandex/metrica/impl/ob/kk$c$e$a;
    //   549: putfield 193	com/yandex/metrica/impl/ob/kk$c$e:d	[Lcom/yandex/metrica/impl/ob/kk$c$e$a;
    //   552: aload 8
    //   554: invokestatic 316	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   557: iload 23
    //   559: istore 12
    //   561: aload 22
    //   563: astore 11
    //   565: new 294	com/yandex/metrica/impl/bd$b
    //   568: dup
    //   569: aload 4
    //   571: aload 11
    //   573: iload 12
    //   575: invokespecial 486	com/yandex/metrica/impl/bd$b:<init>	(Lcom/yandex/metrica/impl/ob/kk$c$e;Lcom/yandex/metrica/impl/b$a;Z)V
    //   578: areturn
    //   579: aload 8
    //   581: invokestatic 316	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   584: aconst_null
    //   585: areturn
    //   586: astore 9
    //   588: aconst_null
    //   589: astore 10
    //   591: aconst_null
    //   592: astore 11
    //   594: iconst_0
    //   595: istore 12
    //   597: aload 10
    //   599: invokestatic 316	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   602: goto -37 -> 565
    //   605: astore 7
    //   607: aconst_null
    //   608: astore 8
    //   610: aload 8
    //   612: invokestatic 316	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   615: aload 7
    //   617: athrow
    //   618: astore 7
    //   620: goto -10 -> 610
    //   623: astore 26
    //   625: aload 8
    //   627: astore 10
    //   629: iconst_0
    //   630: istore 12
    //   632: aconst_null
    //   633: astore 11
    //   635: goto -38 -> 597
    //   638: astore 20
    //   640: aload 8
    //   642: astore 10
    //   644: iconst_0
    //   645: istore 12
    //   647: goto -50 -> 597
    //   650: astore 15
    //   652: aload 6
    //   654: astore 11
    //   656: aload 8
    //   658: astore 10
    //   660: iconst_0
    //   661: istore 12
    //   663: goto -66 -> 597
    //   666: astore 24
    //   668: iload 23
    //   670: istore 12
    //   672: aload 22
    //   674: astore 11
    //   676: aload 8
    //   678: astore 10
    //   680: goto -83 -> 597
    //   683: aload 6
    //   685: astore 11
    //   687: goto -293 -> 394
    //   690: aconst_null
    //   691: astore 18
    //   693: goto -366 -> 327
    //   696: aload 6
    //   698: astore 22
    //   700: iconst_0
    //   701: istore 23
    //   703: goto -186 -> 517
    //   706: aload 11
    //   708: astore 22
    //   710: iconst_0
    //   711: istore 23
    //   713: goto -196 -> 517
    //
    // Exception table:
    //   from	to	target	type
    //   33	42	586	java/lang/Exception
    //   33	42	605	finally
    //   46	55	618	finally
    //   55	327	618	finally
    //   332	360	618	finally
    //   365	394	618	finally
    //   394	454	618	finally
    //   454	489	618	finally
    //   496	505	618	finally
    //   517	552	618	finally
    //   46	55	623	java/lang/Exception
    //   365	394	638	java/lang/Exception
    //   394	454	638	java/lang/Exception
    //   454	489	638	java/lang/Exception
    //   55	327	650	java/lang/Exception
    //   332	360	650	java/lang/Exception
    //   496	505	650	java/lang/Exception
    //   517	552	666	java/lang/Exception
  }

  kk.c a(c paramc, kk.c.c[] paramArrayOfc)
  {
    kk.c localc = new kk.c();
    kk.c.d locald = new kk.c.d();
    locald.b = oq.a(this.c.b, this.u.r());
    locald.c = oq.a(this.c.a, this.u.q());
    this.o += b.b(4, locald);
    localc.c = locald;
    a(localc);
    localc.b = ((kk.c.e[])paramc.a.toArray(new kk.c.e[paramc.a.size()]));
    localc.d = a(paramc.c);
    localc.e = paramArrayOfc;
    this.o += b.i(8);
    return localc;
  }

  protected void a(Uri.Builder paramBuilder)
  {
    super.a(paramBuilder);
    paramBuilder.path("report");
    a(paramBuilder, "deviceid", this.c.a, this.u.q());
    a(paramBuilder, "uuid", this.c.b, this.u.r());
    a(paramBuilder, "analytics_sdk_version", this.c.c);
    a(paramBuilder, "analytics_sdk_version_name", this.c.d);
    a(paramBuilder, "app_version_name", this.c.g, this.u.p());
    a(paramBuilder, "app_build_number", this.c.i, this.u.o());
    a(paramBuilder, "os_version", this.c.j, this.u.m());
    a(paramBuilder, "os_api_level", this.c.k);
    a(paramBuilder, "analytics_sdk_build_number", this.c.e);
    a(paramBuilder, "analytics_sdk_build_type", this.c.f);
    a(paramBuilder, "app_debuggable", this.c.h);
    a(paramBuilder, "locale", this.c.l, this.u.y());
    a(paramBuilder, "is_rooted", this.c.m, this.u.s());
    a(paramBuilder, "app_framework", this.c.n, this.u.t());
    a(paramBuilder, "attribution_id", this.c.o);
    paramBuilder.appendQueryParameter("api_key_128", this.u.D());
    paramBuilder.appendQueryParameter("app_id", this.u.c());
    paramBuilder.appendQueryParameter("app_platform", this.u.k());
    paramBuilder.appendQueryParameter("model", this.u.l());
    paramBuilder.appendQueryParameter("manufacturer", this.u.f());
    paramBuilder.appendQueryParameter("screen_width", String.valueOf(this.u.u()));
    paramBuilder.appendQueryParameter("screen_height", String.valueOf(this.u.v()));
    paramBuilder.appendQueryParameter("screen_dpi", String.valueOf(this.u.w()));
    paramBuilder.appendQueryParameter("scalefactor", String.valueOf(this.u.x()));
    paramBuilder.appendQueryParameter("device_type", this.u.A());
    paramBuilder.appendQueryParameter("android_id", this.u.z());
    a(paramBuilder, "clids_set", this.u.a());
    GoogleAdvertisingIdGetter.b localb = this.u.B();
    String str1;
    if (localb == null)
    {
      str1 = "";
      if (str1 == null)
        str1 = "";
      paramBuilder.appendQueryParameter("adv_id", str1);
      if (localb != null)
        break label539;
    }
    label539: for (String str2 = ""; ; str2 = a(localb.b))
    {
      paramBuilder.appendQueryParameter("limit_ad_tracking", str2);
      return;
      str1 = localb.a;
      break;
    }
  }

  void a(final kk.c paramc)
  {
    np.a(this.q.c()).a(new ns()
    {
      public void a(nr paramAnonymousnr)
      {
        int i = 0;
        kk.c localc1 = paramc;
        List localList1 = paramAnonymousnr.c();
        if (!bw.a(localList1))
        {
          localc1.f = new String[localList1.size()];
          for (int j = 0; j < localList1.size(); j++)
          {
            String str = (String)localList1.get(j);
            if (!TextUtils.isEmpty(str))
            {
              localc1.f[j] = str;
              bd localbd3 = bd.this;
              localbd3.o += b.b(localc1.f[j]);
              bd localbd4 = bd.this;
              localbd4.o += b.i(9);
            }
          }
        }
        kk.c localc2 = paramc;
        List localList2 = paramAnonymousnr.a();
        if (!bw.a(localList2))
        {
          localc2.g = new kk.c.f[localList2.size()];
          while (i < localList2.size())
          {
            nn localnn = (nn)localList2.get(i);
            localc2.g[i] = az.a(localnn);
            bd localbd1 = bd.this;
            localbd1.o += b.b(localc2.g[i]);
            bd localbd2 = bd.this;
            localbd2.o += b.i(10);
            i++;
          }
        }
      }
    });
  }

  protected boolean a(long paramLong)
  {
    return -2L == paramLong;
  }

  public boolean b()
  {
    this.u = this.q.l();
    a(this.u.b());
    if ((!this.u.e()) || (bw.a(v())));
    kk.c.c[] arrayOfc;
    do
    {
      return false;
      this.n = null;
      arrayOfc = K();
      this.r = L();
    }
    while (this.r.a.isEmpty());
    this.l = a(this.r, arrayOfc);
    this.n = this.r.b;
    c(e.a(this.l));
    return true;
  }

  public void h()
  {
    if ((A()) && (this.t.c()))
      for (int i = 0; i < this.r.a.size(); i++)
        this.t.a((kk.c.e)this.r.a.get(i), "Event sent");
    this.r = null;
  }

  public boolean w()
  {
    boolean bool1 = super.w();
    if (400 != n());
    for (boolean bool2 = true; ; bool2 = false)
      return bool2 & bool1;
  }

  static class a
  {
    bd a(ab paramab)
    {
      return new bd(paramab);
    }
  }

  static final class b
  {
    final kk.c.e a;
    final b.a b;
    final boolean c;

    b(kk.c.e parame, b.a parama, boolean paramBoolean)
    {
      this.a = parame;
      this.b = parama;
      this.c = paramBoolean;
    }
  }

  static final class c
  {
    final List<kk.c.e> a;
    final List<Long> b;
    final JSONObject c;

    c(List<kk.c.e> paramList, List<Long> paramList1, JSONObject paramJSONObject)
    {
      this.a = paramList;
      this.b = paramList1;
      this.c = paramJSONObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bd
 * JD-Core Version:    0.6.2
 */