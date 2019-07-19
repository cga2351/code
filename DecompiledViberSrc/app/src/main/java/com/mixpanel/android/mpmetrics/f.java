package com.mixpanel.android.mpmetrics;

import android.content.Context;
import com.mixpanel.android.c.l;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

class f
{
  private static final Set<Integer> h = new HashSet();
  private String a;
  private final String b;
  private final Set<Integer> c;
  private final List<InAppNotification> d;
  private final a e;
  private final l f;
  private JSONArray g;
  private Boolean i;
  private Context j;
  private Set<String> k;

  public f(Context paramContext, String paramString, a parama, l paraml, HashSet<Integer> paramHashSet)
  {
    this.j = paramContext;
    this.b = paramString;
    this.e = parama;
    this.f = paraml;
    this.a = null;
    this.d = new LinkedList();
    this.c = new HashSet(paramHashSet);
    this.g = null;
    this.k = new HashSet();
  }

  public InAppNotification a(boolean paramBoolean)
  {
    while (true)
    {
      InAppNotification localInAppNotification;
      try
      {
        if (this.d.isEmpty())
        {
          com.mixpanel.android.b.f.a("MixpanelAPI.DecideUpdts", "No unseen notifications exist, none will be returned.");
          localInAppNotification = null;
          return localInAppNotification;
        }
        localInAppNotification = (InAppNotification)this.d.remove(0);
        if (paramBoolean)
        {
          this.d.add(localInAppNotification);
          continue;
        }
      }
      finally
      {
      }
      com.mixpanel.android.b.f.a("MixpanelAPI.DecideUpdts", "Recording notification " + localInAppNotification + " as seen.");
    }
  }

  public String a()
  {
    return this.b;
  }

  public void a(InAppNotification paramInAppNotification)
  {
    try
    {
      if (!i.a)
        this.d.add(paramInAppNotification);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString)
  {
    try
    {
      if ((this.a == null) || (!this.a.equals(paramString)))
        this.d.clear();
      this.a = paramString;
      return;
    }
    finally
    {
    }
  }

  // ERROR //
  public void a(List<InAppNotification> paramList, JSONArray paramJSONArray1, JSONArray paramJSONArray2, boolean paramBoolean, JSONArray paramJSONArray3)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_3
    //   6: invokevirtual 129	org/json/JSONArray:length	()I
    //   9: istore 8
    //   11: aload_0
    //   12: getfield 45	com/mixpanel/android/mpmetrics/f:f	Lcom/mixpanel/android/c/l;
    //   15: aload_2
    //   16: invokeinterface 134 2 0
    //   21: aload_1
    //   22: invokeinterface 138 1 0
    //   27: astore 9
    //   29: iconst_0
    //   30: istore 10
    //   32: aload 9
    //   34: invokeinterface 143 1 0
    //   39: ifeq +73 -> 112
    //   42: aload 9
    //   44: invokeinterface 147 1 0
    //   49: checkcast 83	com/mixpanel/android/mpmetrics/InAppNotification
    //   52: astore 25
    //   54: aload 25
    //   56: invokevirtual 150	com/mixpanel/android/mpmetrics/InAppNotification:getId	()I
    //   59: istore 26
    //   61: aload_0
    //   62: getfield 57	com/mixpanel/android/mpmetrics/f:c	Ljava/util/Set;
    //   65: iload 26
    //   67: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokeinterface 161 2 0
    //   75: ifne +527 -> 602
    //   78: aload_0
    //   79: getfield 57	com/mixpanel/android/mpmetrics/f:c	Ljava/util/Set;
    //   82: iload 26
    //   84: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokeinterface 162 2 0
    //   92: pop
    //   93: aload_0
    //   94: getfield 52	com/mixpanel/android/mpmetrics/f:d	Ljava/util/List;
    //   97: aload 25
    //   99: invokeinterface 87 2 0
    //   104: pop
    //   105: iload 6
    //   107: istore 27
    //   109: goto +497 -> 606
    //   112: aload_0
    //   113: aload_3
    //   114: putfield 59	com/mixpanel/android/mpmetrics/f:g	Lorg/json/JSONArray;
    //   117: iconst_0
    //   118: istore 11
    //   120: iload 11
    //   122: iload 8
    //   124: if_icmpge +472 -> 596
    //   127: aload_3
    //   128: iload 11
    //   130: invokevirtual 166	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   133: astore 23
    //   135: getstatic 35	com/mixpanel/android/mpmetrics/f:h	Ljava/util/Set;
    //   138: aload 23
    //   140: ldc 168
    //   142: invokevirtual 174	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   145: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: invokeinterface 161 2 0
    //   153: istore 24
    //   155: iload 24
    //   157: ifne +456 -> 613
    //   160: iload 6
    //   162: istore 12
    //   164: iload 6
    //   166: istore 10
    //   168: iload 12
    //   170: ifeq +145 -> 315
    //   173: aload_0
    //   174: getfield 59	com/mixpanel/android/mpmetrics/f:g	Lorg/json/JSONArray;
    //   177: ifnull +138 -> 315
    //   180: getstatic 35	com/mixpanel/android/mpmetrics/f:h	Ljava/util/Set;
    //   183: invokeinterface 175 1 0
    //   188: iconst_0
    //   189: istore 18
    //   191: iload 18
    //   193: iload 8
    //   195: if_icmpge +120 -> 315
    //   198: aload_0
    //   199: getfield 59	com/mixpanel/android/mpmetrics/f:g	Lorg/json/JSONArray;
    //   202: iload 18
    //   204: invokevirtual 166	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   207: astore 20
    //   209: getstatic 35	com/mixpanel/android/mpmetrics/f:h	Ljava/util/Set;
    //   212: aload 20
    //   214: ldc 168
    //   216: invokevirtual 174	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   219: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: invokeinterface 162 2 0
    //   227: pop
    //   228: iinc 18 1
    //   231: goto -40 -> 191
    //   234: astore 22
    //   236: ldc 70
    //   238: new 89	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   245: ldc 177
    //   247: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 11
    //   252: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc 182
    //   257: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: aload 22
    //   265: invokestatic 185	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   268: goto +345 -> 613
    //   271: astore 19
    //   273: ldc 70
    //   275: new 89	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   282: ldc 177
    //   284: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 18
    //   289: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc 187
    //   294: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: aload 19
    //   302: invokestatic 185	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   305: goto -77 -> 228
    //   308: astore 7
    //   310: aload_0
    //   311: monitorexit
    //   312: aload 7
    //   314: athrow
    //   315: iload 8
    //   317: ifne +272 -> 589
    //   320: aload_0
    //   321: new 125	org/json/JSONArray
    //   324: dup
    //   325: invokespecial 188	org/json/JSONArray:<init>	()V
    //   328: putfield 59	com/mixpanel/android/mpmetrics/f:g	Lorg/json/JSONArray;
    //   331: getstatic 35	com/mixpanel/android/mpmetrics/f:h	Ljava/util/Set;
    //   334: invokeinterface 191 1 0
    //   339: ifle +250 -> 589
    //   342: getstatic 35	com/mixpanel/android/mpmetrics/f:h	Ljava/util/Set;
    //   345: invokeinterface 175 1 0
    //   350: iload 6
    //   352: istore 13
    //   354: aload_0
    //   355: getfield 45	com/mixpanel/android/mpmetrics/f:f	Lcom/mixpanel/android/c/l;
    //   358: aload_0
    //   359: getfield 59	com/mixpanel/android/mpmetrics/f:g	Lorg/json/JSONArray;
    //   362: invokeinterface 193 2 0
    //   367: aload_0
    //   368: getfield 195	com/mixpanel/android/mpmetrics/f:i	Ljava/lang/Boolean;
    //   371: ifnonnull +22 -> 393
    //   374: iload 4
    //   376: ifne +17 -> 393
    //   379: aload_0
    //   380: getfield 39	com/mixpanel/android/mpmetrics/f:j	Landroid/content/Context;
    //   383: invokestatic 200	com/mixpanel/android/mpmetrics/j:a	(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/j;
    //   386: aload_0
    //   387: getfield 41	com/mixpanel/android/mpmetrics/f:b	Ljava/lang/String;
    //   390: invokevirtual 202	com/mixpanel/android/mpmetrics/j:a	(Ljava/lang/String;)V
    //   393: aload_0
    //   394: iload 4
    //   396: invokestatic 207	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   399: putfield 195	com/mixpanel/android/mpmetrics/f:i	Ljava/lang/Boolean;
    //   402: aload 5
    //   404: ifnull +68 -> 472
    //   407: new 30	java/util/HashSet
    //   410: dup
    //   411: invokespecial 33	java/util/HashSet:<init>	()V
    //   414: astore 14
    //   416: iconst_0
    //   417: istore 15
    //   419: iload 15
    //   421: aload 5
    //   423: invokevirtual 129	org/json/JSONArray:length	()I
    //   426: if_icmpge +22 -> 448
    //   429: aload 14
    //   431: aload 5
    //   433: iload 15
    //   435: invokevirtual 211	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   438: invokevirtual 212	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   441: pop
    //   442: iinc 15 1
    //   445: goto -26 -> 419
    //   448: aload_0
    //   449: getfield 61	com/mixpanel/android/mpmetrics/f:k	Ljava/util/Set;
    //   452: aload 14
    //   454: invokeinterface 213 2 0
    //   459: ifne +123 -> 582
    //   462: aload_0
    //   463: aload 14
    //   465: putfield 61	com/mixpanel/android/mpmetrics/f:k	Ljava/util/Set;
    //   468: iload 6
    //   470: istore 13
    //   472: ldc 70
    //   474: new 89	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   481: ldc 215
    //   483: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload_1
    //   487: invokeinterface 216 1 0
    //   492: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: ldc 218
    //   497: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_3
    //   501: invokevirtual 129	org/json/JSONArray:length	()I
    //   504: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: ldc 220
    //   509: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 77	com/mixpanel/android/b/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: iload 13
    //   520: ifeq +19 -> 539
    //   523: aload_0
    //   524: getfield 43	com/mixpanel/android/mpmetrics/f:e	Lcom/mixpanel/android/mpmetrics/f$a;
    //   527: ifnull +12 -> 539
    //   530: aload_0
    //   531: getfield 43	com/mixpanel/android/mpmetrics/f:e	Lcom/mixpanel/android/mpmetrics/f$a;
    //   534: invokeinterface 224 1 0
    //   539: aload_0
    //   540: monitorexit
    //   541: return
    //   542: astore 16
    //   544: ldc 70
    //   546: new 89	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   553: ldc 226
    //   555: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload 5
    //   560: invokevirtual 227	org/json/JSONArray:toString	()Ljava/lang/String;
    //   563: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: ldc 229
    //   568: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: aload 16
    //   576: invokestatic 185	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   579: goto -107 -> 472
    //   582: iload 13
    //   584: istore 6
    //   586: goto -118 -> 468
    //   589: iload 10
    //   591: istore 13
    //   593: goto -239 -> 354
    //   596: iconst_0
    //   597: istore 12
    //   599: goto -431 -> 168
    //   602: iload 10
    //   604: istore 27
    //   606: iload 27
    //   608: istore 10
    //   610: goto -578 -> 32
    //   613: iinc 11 1
    //   616: goto -496 -> 120
    //
    // Exception table:
    //   from	to	target	type
    //   127	155	234	org/json/JSONException
    //   198	228	271	org/json/JSONException
    //   5	29	308	finally
    //   32	105	308	finally
    //   112	117	308	finally
    //   127	155	308	finally
    //   173	188	308	finally
    //   198	228	308	finally
    //   236	268	308	finally
    //   273	305	308	finally
    //   320	350	308	finally
    //   354	374	308	finally
    //   379	393	308	finally
    //   393	402	308	finally
    //   407	416	308	finally
    //   419	442	308	finally
    //   448	468	308	finally
    //   472	518	308	finally
    //   523	539	308	finally
    //   544	579	308	finally
    //   407	416	542	org/json/JSONException
    //   419	442	542	org/json/JSONException
    //   448	468	542	org/json/JSONException
  }

  public String b()
  {
    try
    {
      String str = this.a;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public JSONArray c()
  {
    try
    {
      JSONArray localJSONArray = this.g;
      return localJSONArray;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Set<String> d()
  {
    try
    {
      Set localSet = this.k;
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Boolean e()
  {
    return this.i;
  }

  public boolean f()
  {
    if (e() == null)
      return true;
    return e().booleanValue();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.f
 * JD-Core Version:    0.6.2
 */