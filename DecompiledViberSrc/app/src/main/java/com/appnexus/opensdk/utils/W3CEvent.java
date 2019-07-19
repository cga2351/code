package com.appnexus.opensdk.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.CalendarContract.Events;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class W3CEvent
{
  private static SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
  private static SimpleDateFormat l = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", Locale.US);
  public static boolean useMIME = false;
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private W3CRepeatRule j;

  private long a(String paramString)
  {
    try
    {
      long l3 = k.parse(paramString).getTime();
      return l3;
    }
    catch (ParseException localParseException1)
    {
      try
      {
        long l2 = l.parse(paramString).getTime();
        return l2;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          long l1 = Long.parseLong(paramString);
          return l1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
        }
      }
    }
    return -1L;
  }

  // ERROR //
  public static W3CEvent createFromJSON(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 2	com/appnexus/opensdk/utils/W3CEvent
    //   5: dup
    //   6: invokespecial 74	com/appnexus/opensdk/utils/W3CEvent:<init>	()V
    //   9: astore_2
    //   10: new 76	org/json/JSONObject
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 79	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc 81
    //   22: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   25: ifne +13 -> 38
    //   28: aload_2
    //   29: aload_3
    //   30: ldc 81
    //   32: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 92	com/appnexus/opensdk/utils/W3CEvent:setId	(Ljava/lang/String;)V
    //   38: aload_3
    //   39: ldc 94
    //   41: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   44: ifne +13 -> 57
    //   47: aload_2
    //   48: aload_3
    //   49: ldc 94
    //   51: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 97	com/appnexus/opensdk/utils/W3CEvent:setDescription	(Ljava/lang/String;)V
    //   57: aload_3
    //   58: ldc 99
    //   60: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   63: ifne +13 -> 76
    //   66: aload_2
    //   67: aload_3
    //   68: ldc 99
    //   70: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokevirtual 102	com/appnexus/opensdk/utils/W3CEvent:setLocation	(Ljava/lang/String;)V
    //   76: aload_3
    //   77: ldc 104
    //   79: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   82: ifne +13 -> 95
    //   85: aload_2
    //   86: aload_3
    //   87: ldc 104
    //   89: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual 107	com/appnexus/opensdk/utils/W3CEvent:setSummary	(Ljava/lang/String;)V
    //   95: aload_3
    //   96: ldc 109
    //   98: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   101: ifne +13 -> 114
    //   104: aload_2
    //   105: aload_3
    //   106: ldc 109
    //   108: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: invokevirtual 112	com/appnexus/opensdk/utils/W3CEvent:setStart	(Ljava/lang/String;)V
    //   114: aload_3
    //   115: ldc 114
    //   117: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   120: ifne +32 -> 152
    //   123: aload_3
    //   124: ldc 109
    //   126: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   129: ifeq +13 -> 142
    //   132: aload_2
    //   133: aload_3
    //   134: ldc 114
    //   136: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokevirtual 112	com/appnexus/opensdk/utils/W3CEvent:setStart	(Ljava/lang/String;)V
    //   142: aload_2
    //   143: aload_3
    //   144: ldc 114
    //   146: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokevirtual 117	com/appnexus/opensdk/utils/W3CEvent:setEnd	(Ljava/lang/String;)V
    //   152: aload_3
    //   153: ldc 119
    //   155: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   158: ifne +13 -> 171
    //   161: aload_2
    //   162: aload_3
    //   163: ldc 119
    //   165: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: invokevirtual 122	com/appnexus/opensdk/utils/W3CEvent:setStatus	(Ljava/lang/String;)V
    //   171: aload_3
    //   172: ldc 124
    //   174: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   177: ifne +13 -> 190
    //   180: aload_2
    //   181: aload_3
    //   182: ldc 124
    //   184: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual 127	com/appnexus/opensdk/utils/W3CEvent:setTransparency	(Ljava/lang/String;)V
    //   190: aload_3
    //   191: ldc 129
    //   193: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   196: ifne +13 -> 209
    //   199: aload_2
    //   200: aload_3
    //   201: ldc 129
    //   203: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokevirtual 132	com/appnexus/opensdk/utils/W3CEvent:setReminder	(Ljava/lang/String;)V
    //   209: aload_3
    //   210: ldc 134
    //   212: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   215: ifne +511 -> 726
    //   218: aload_2
    //   219: new 136	com/appnexus/opensdk/utils/W3CRepeatRule
    //   222: dup
    //   223: invokespecial 137	com/appnexus/opensdk/utils/W3CRepeatRule:<init>	()V
    //   226: invokevirtual 141	com/appnexus/opensdk/utils/W3CEvent:setRecurrence	(Lcom/appnexus/opensdk/utils/W3CRepeatRule;)V
    //   229: aload_3
    //   230: ldc 134
    //   232: invokevirtual 145	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   235: astore 6
    //   237: aload 6
    //   239: ldc 147
    //   241: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   244: ifne +17 -> 261
    //   247: aload_2
    //   248: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   251: aload 6
    //   253: ldc 147
    //   255: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   258: invokevirtual 154	com/appnexus/opensdk/utils/W3CRepeatRule:setFrequency	(Ljava/lang/String;)V
    //   261: aload 6
    //   263: ldc 156
    //   265: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   268: ifne +17 -> 285
    //   271: aload_2
    //   272: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   275: aload 6
    //   277: ldc 156
    //   279: invokevirtual 160	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   282: invokevirtual 164	com/appnexus/opensdk/utils/W3CRepeatRule:setInterval	(I)V
    //   285: aload 6
    //   287: ldc 166
    //   289: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   292: ifne +17 -> 309
    //   295: aload_2
    //   296: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   299: aload 6
    //   301: ldc 166
    //   303: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 169	com/appnexus/opensdk/utils/W3CRepeatRule:setExpires	(Ljava/lang/String;)V
    //   309: aload 6
    //   311: ldc 171
    //   313: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   316: ifne +64 -> 380
    //   319: aload 6
    //   321: ldc 171
    //   323: invokevirtual 175	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   326: astore 21
    //   328: aload 21
    //   330: invokevirtual 181	org/json/JSONArray:length	()I
    //   333: istore 22
    //   335: aload_2
    //   336: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   339: iload 22
    //   341: anewarray 183	java/lang/String
    //   344: invokevirtual 187	com/appnexus/opensdk/utils/W3CRepeatRule:setExceptionDates	([Ljava/lang/String;)V
    //   347: iconst_0
    //   348: istore 23
    //   350: iload 23
    //   352: iload 22
    //   354: if_icmpge +26 -> 380
    //   357: aload_2
    //   358: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   361: invokevirtual 191	com/appnexus/opensdk/utils/W3CRepeatRule:getExceptionDates	()[Ljava/lang/String;
    //   364: iload 23
    //   366: aload 21
    //   368: iload 23
    //   370: invokevirtual 194	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   373: aastore
    //   374: iinc 23 1
    //   377: goto -27 -> 350
    //   380: aload 6
    //   382: ldc 196
    //   384: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   387: ifne +63 -> 450
    //   390: aload 6
    //   392: ldc 196
    //   394: invokevirtual 175	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   397: astore 18
    //   399: aload 18
    //   401: invokevirtual 181	org/json/JSONArray:length	()I
    //   404: istore 19
    //   406: aload_2
    //   407: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   410: iload 19
    //   412: newarray int
    //   414: invokevirtual 200	com/appnexus/opensdk/utils/W3CRepeatRule:setDaysInWeek	([I)V
    //   417: iconst_0
    //   418: istore 20
    //   420: iload 20
    //   422: iload 19
    //   424: if_icmpge +26 -> 450
    //   427: aload_2
    //   428: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   431: invokevirtual 204	com/appnexus/opensdk/utils/W3CRepeatRule:getDaysInWeek	()[I
    //   434: iload 20
    //   436: aload 18
    //   438: iload 20
    //   440: invokevirtual 207	org/json/JSONArray:getInt	(I)I
    //   443: iastore
    //   444: iinc 20 1
    //   447: goto -27 -> 420
    //   450: aload 6
    //   452: ldc 209
    //   454: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   457: ifne +63 -> 520
    //   460: aload 6
    //   462: ldc 209
    //   464: invokevirtual 175	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   467: astore 15
    //   469: aload 15
    //   471: invokevirtual 181	org/json/JSONArray:length	()I
    //   474: istore 16
    //   476: aload_2
    //   477: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   480: iload 16
    //   482: newarray int
    //   484: invokevirtual 212	com/appnexus/opensdk/utils/W3CRepeatRule:setDaysInMonth	([I)V
    //   487: iconst_0
    //   488: istore 17
    //   490: iload 17
    //   492: iload 16
    //   494: if_icmpge +26 -> 520
    //   497: aload_2
    //   498: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   501: invokevirtual 215	com/appnexus/opensdk/utils/W3CRepeatRule:getDaysInMonth	()[I
    //   504: iload 17
    //   506: aload 15
    //   508: iload 17
    //   510: invokevirtual 207	org/json/JSONArray:getInt	(I)I
    //   513: iastore
    //   514: iinc 17 1
    //   517: goto -27 -> 490
    //   520: aload 6
    //   522: ldc 217
    //   524: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   527: ifne +63 -> 590
    //   530: aload 6
    //   532: ldc 217
    //   534: invokevirtual 175	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   537: astore 12
    //   539: aload 12
    //   541: invokevirtual 181	org/json/JSONArray:length	()I
    //   544: istore 13
    //   546: aload_2
    //   547: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   550: iload 13
    //   552: newarray int
    //   554: invokevirtual 220	com/appnexus/opensdk/utils/W3CRepeatRule:setDaysInYear	([I)V
    //   557: iconst_0
    //   558: istore 14
    //   560: iload 14
    //   562: iload 13
    //   564: if_icmpge +26 -> 590
    //   567: aload_2
    //   568: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   571: invokevirtual 223	com/appnexus/opensdk/utils/W3CRepeatRule:getDaysInYear	()[I
    //   574: iload 14
    //   576: aload 12
    //   578: iload 14
    //   580: invokevirtual 207	org/json/JSONArray:getInt	(I)I
    //   583: iastore
    //   584: iinc 14 1
    //   587: goto -27 -> 560
    //   590: aload 6
    //   592: ldc 225
    //   594: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   597: ifne +63 -> 660
    //   600: aload 6
    //   602: ldc 225
    //   604: invokevirtual 175	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   607: astore 9
    //   609: aload 9
    //   611: invokevirtual 181	org/json/JSONArray:length	()I
    //   614: istore 10
    //   616: aload_2
    //   617: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   620: iload 10
    //   622: newarray int
    //   624: invokevirtual 228	com/appnexus/opensdk/utils/W3CRepeatRule:setWeeksInMonth	([I)V
    //   627: iconst_0
    //   628: istore 11
    //   630: iload 11
    //   632: iload 10
    //   634: if_icmpge +26 -> 660
    //   637: aload_2
    //   638: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   641: invokevirtual 231	com/appnexus/opensdk/utils/W3CRepeatRule:getWeeksInMonth	()[I
    //   644: iload 11
    //   646: aload 9
    //   648: iload 11
    //   650: invokevirtual 207	org/json/JSONArray:getInt	(I)I
    //   653: iastore
    //   654: iinc 11 1
    //   657: goto -27 -> 630
    //   660: aload 6
    //   662: ldc 233
    //   664: invokevirtual 85	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   667: ifne +59 -> 726
    //   670: aload 6
    //   672: ldc 233
    //   674: invokevirtual 175	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   677: astore 7
    //   679: aload 7
    //   681: invokevirtual 181	org/json/JSONArray:length	()I
    //   684: istore 8
    //   686: aload_2
    //   687: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   690: iload 8
    //   692: newarray int
    //   694: invokevirtual 236	com/appnexus/opensdk/utils/W3CRepeatRule:setMonthsInYear	([I)V
    //   697: iload_1
    //   698: iload 8
    //   700: if_icmpge +26 -> 726
    //   703: aload_2
    //   704: invokevirtual 151	com/appnexus/opensdk/utils/W3CEvent:getRecurrence	()Lcom/appnexus/opensdk/utils/W3CRepeatRule;
    //   707: invokevirtual 239	com/appnexus/opensdk/utils/W3CRepeatRule:getMonthsInYear	()[I
    //   710: iload_1
    //   711: aload 7
    //   713: iload_1
    //   714: invokevirtual 207	org/json/JSONArray:getInt	(I)I
    //   717: iastore
    //   718: iinc 1 1
    //   721: goto -24 -> 697
    //   724: astore 4
    //   726: aload_2
    //   727: areturn
    //   728: astore 5
    //   730: aload_2
    //   731: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   10	38	724	org/json/JSONException
    //   38	57	724	org/json/JSONException
    //   57	76	724	org/json/JSONException
    //   76	95	724	org/json/JSONException
    //   95	114	724	org/json/JSONException
    //   114	142	724	org/json/JSONException
    //   142	152	724	org/json/JSONException
    //   152	171	724	org/json/JSONException
    //   171	190	724	org/json/JSONException
    //   190	209	724	org/json/JSONException
    //   209	229	724	org/json/JSONException
    //   229	261	728	org/json/JSONException
    //   261	285	728	org/json/JSONException
    //   285	309	728	org/json/JSONException
    //   309	347	728	org/json/JSONException
    //   357	374	728	org/json/JSONException
    //   380	417	728	org/json/JSONException
    //   427	444	728	org/json/JSONException
    //   450	487	728	org/json/JSONException
    //   497	514	728	org/json/JSONException
    //   520	557	728	org/json/JSONException
    //   567	584	728	org/json/JSONException
    //   590	627	728	org/json/JSONException
    //   637	654	728	org/json/JSONException
    //   660	697	728	org/json/JSONException
    //   703	718	728	org/json/JSONException
  }

  public String getDescription()
  {
    return this.b;
  }

  public String getEnd()
  {
    return this.f;
  }

  public String getId()
  {
    return this.a;
  }

  @SuppressLint({"NewApi", "InlinedApi"})
  public Intent getInsertIntent()
  {
    int m;
    Intent localIntent;
    label37: label63: label89: label114: long l4;
    label155: long l3;
    label196: boolean bool;
    label252: long l1;
    label310: StringBuilder localStringBuilder;
    String str;
    label364: int i11;
    if ((!useMIME) && (Build.VERSION.SDK_INT >= 14))
    {
      m = 1;
      if (m == 0)
        break label523;
      localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
      if (!StringUtil.isEmpty(getDescription()))
      {
        if (m == 0)
          break label543;
        localIntent.putExtra("title", getDescription());
      }
      if (!StringUtil.isEmpty(getLocation()))
      {
        if (m == 0)
          break label558;
        localIntent.putExtra("eventLocation", getLocation());
      }
      if (!StringUtil.isEmpty(getSummary()))
      {
        if (m == 0)
          break label573;
        localIntent.putExtra("description", getSummary());
      }
      if (!StringUtil.isEmpty(getStart()))
      {
        l4 = a(getStart());
        if (l4 > 0L)
        {
          if (m == 0)
            break label587;
          localIntent.putExtra("beginTime", l4);
        }
      }
      if (!StringUtil.isEmpty(getEnd()))
      {
        l3 = a(getEnd());
        if (l3 > 0L)
        {
          if (m == 0)
            break label600;
          localIntent.putExtra("endTime", l3);
        }
      }
      if ((!StringUtil.isEmpty(getStatus())) && (m != 0))
        localIntent.putExtra("eventStatus", getStatus());
      if ((!StringUtil.isEmpty(getTransparency())) && (m != 0))
      {
        if (getTransparency().equals("opaque"))
          break label613;
        bool = true;
        localIntent.putExtra("visible", bool);
      }
      if (!StringUtil.isEmpty(getReminder()))
      {
        l1 = a(getReminder());
        if (l1 >= 0L)
          break label619;
        if (m != 0)
          localIntent.putExtra("minutes", Math.abs(l1 / 60000L));
      }
      localStringBuilder = new StringBuilder("");
      if (getRecurrence() == null)
        break label1390;
      str = getRecurrence().getFrequency();
      if (StringUtil.isEmpty(str))
        break label747;
      if (!"daily".equals(str))
        break label673;
      localStringBuilder.append("FREQ=DAILY;");
      if (getRecurrence().getInterval() > 0)
      {
        localStringBuilder.append("INTERVAL=");
        localStringBuilder.append(getRecurrence().getInterval());
        localStringBuilder.append(";");
      }
      if ((!"weekly".equals(str)) || (getRecurrence().getDaysInWeek() == null) || (getRecurrence().getDaysInWeek().length <= 0))
        break label844;
      localStringBuilder.append("BYDAY=");
      int[] arrayOfInt5 = getRecurrence().getDaysInWeek();
      int i10 = arrayOfInt5.length;
      i11 = 0;
      label459: if (i11 >= i10)
        break label832;
      switch (arrayOfInt5[i11])
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    }
    while (true)
    {
      i11++;
      break label459;
      m = 0;
      break;
      label523: localIntent = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event");
      break label37;
      label543: localIntent.putExtra("title", getDescription());
      break label63;
      label558: localIntent.putExtra("eventLocation", getLocation());
      break label89;
      label573: localIntent.putExtra("description", getSummary());
      break label114;
      label587: localIntent.putExtra("beginTime", l4);
      break label155;
      label600: localIntent.putExtra("endTime", l3);
      break label196;
      label613: bool = false;
      break label252;
      label619: if ((StringUtil.isEmpty(getStart())) || (m == 0))
        break label310;
      long l2 = a(getStart());
      if (l2 <= 0L)
        break label310;
      localIntent.putExtra("minutes", Math.abs((l2 - l1) / 60000L));
      break label310;
      label673: if ("weekly".equals(str))
      {
        localStringBuilder.append("FREQ=WEEKLY;");
        break label364;
      }
      if ("monthly".equals(str))
      {
        localStringBuilder.append("FREQ=MONTHLY;");
        break label364;
      }
      if ("yearly".equals(str))
      {
        localStringBuilder.append("FREQ=YEARLY;");
        break label364;
      }
      str = "";
      break label364;
      label747: str = "";
      break label364;
      localStringBuilder.append("SU,");
      continue;
      localStringBuilder.append("MO,");
      continue;
      localStringBuilder.append("TU,");
      continue;
      localStringBuilder.append("WE,");
      continue;
      localStringBuilder.append("TH,");
      continue;
      localStringBuilder.append("FR,");
      continue;
      localStringBuilder.append("SA,");
    }
    label832: localStringBuilder.setCharAt(-1 + localStringBuilder.length(), ';');
    label844: if (("monthly".equals(str)) && (getRecurrence().getDaysInMonth() != null) && (getRecurrence().getDaysInMonth().length > 0))
    {
      localStringBuilder.append("BYMONTHDAY=");
      int[] arrayOfInt4 = getRecurrence().getDaysInMonth();
      int i8 = arrayOfInt4.length;
      for (int i9 = 0; i9 < i8; i9++)
      {
        localStringBuilder.append(arrayOfInt4[i9]);
        localStringBuilder.append(",");
      }
      localStringBuilder.setCharAt(-1 + localStringBuilder.length(), ';');
    }
    if (("yearly".equals(str)) && (getRecurrence().getDaysInYear() != null) && (getRecurrence().getDaysInYear().length > 0))
    {
      localStringBuilder.append("BYYEARDAY=");
      int[] arrayOfInt3 = getRecurrence().getDaysInYear();
      int i6 = arrayOfInt3.length;
      for (int i7 = 0; i7 < i6; i7++)
      {
        localStringBuilder.append(arrayOfInt3[i7]);
        localStringBuilder.append(",");
      }
      localStringBuilder.setCharAt(-1 + localStringBuilder.length(), ';');
    }
    if (("yearly".equals(str)) && (getRecurrence().getMonthsInYear() != null) && (getRecurrence().getMonthsInYear().length > 0))
    {
      localStringBuilder.append("BYMONTH=");
      int[] arrayOfInt2 = getRecurrence().getMonthsInYear();
      int i4 = arrayOfInt2.length;
      for (int i5 = 0; i5 < i4; i5++)
      {
        localStringBuilder.append(arrayOfInt2[i5]);
        localStringBuilder.append(",");
      }
      localStringBuilder.setCharAt(-1 + localStringBuilder.length(), ';');
    }
    if (("monthly".equals(str)) && (getRecurrence().getWeeksInMonth() != null) && (getRecurrence().getWeeksInMonth().length > 0))
    {
      localStringBuilder.append("BYWEEKNO=");
      int[] arrayOfInt1 = getRecurrence().getWeeksInMonth();
      int i2 = arrayOfInt1.length;
      for (int i3 = 0; i3 < i2; i3++)
      {
        localStringBuilder.append(arrayOfInt1[i3]);
        localStringBuilder.append(",");
      }
      localStringBuilder.setCharAt(-1 + localStringBuilder.length(), ';');
    }
    if (!StringUtil.isEmpty(getRecurrence().getExpires()))
    {
      localStringBuilder.append("UNTIL=");
      localStringBuilder.append(getRecurrence().getExpires());
      localStringBuilder.append(";");
    }
    if ((getRecurrence().getExceptionDates() != null) && (getRecurrence().getExceptionDates().length > 0))
    {
      localStringBuilder.append("EXDATE=");
      String[] arrayOfString = getRecurrence().getExceptionDates();
      int n = arrayOfString.length;
      for (int i1 = 0; i1 < n; i1++)
      {
        localStringBuilder.append(arrayOfString[i1]);
        localStringBuilder.append(",");
      }
      localStringBuilder.setCharAt(-1 + localStringBuilder.length(), ';');
    }
    if (m != 0)
    {
      localIntent.putExtra("rrule", localStringBuilder.toString());
      label1390: return localIntent;
    }
    localIntent.putExtra("rrule", localStringBuilder.toString());
    return localIntent;
  }

  public String getLocation()
  {
    return this.c;
  }

  public W3CRepeatRule getRecurrence()
  {
    return this.j;
  }

  public String getReminder()
  {
    return this.i;
  }

  public String getStart()
  {
    return this.e;
  }

  public String getStatus()
  {
    return this.g;
  }

  public String getSummary()
  {
    return this.d;
  }

  public String getTransparency()
  {
    return this.h;
  }

  public void setDescription(String paramString)
  {
    this.b = paramString;
  }

  public void setEnd(String paramString)
  {
    this.f = paramString;
  }

  public void setId(String paramString)
  {
    this.a = paramString;
  }

  public void setLocation(String paramString)
  {
    this.c = paramString;
  }

  public void setRecurrence(W3CRepeatRule paramW3CRepeatRule)
  {
    this.j = paramW3CRepeatRule;
  }

  public void setReminder(String paramString)
  {
    this.i = paramString;
  }

  public void setStart(String paramString)
  {
    this.e = paramString;
  }

  public void setStatus(String paramString)
  {
    this.g = paramString;
  }

  public void setSummary(String paramString)
  {
    this.d = paramString;
  }

  public void setTransparency(String paramString)
  {
    this.h = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.W3CEvent
 * JD-Core Version:    0.6.2
 */