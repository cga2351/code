package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.b.d;
import com.mixpanel.android.b.d.a;
import com.mixpanel.android.b.i.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

class e
{
  private static final JSONArray f = new JSONArray();
  private final i a;
  private final Context b;
  private final Map<String, f> c;
  private final d d;
  private final t e;

  public e(Context paramContext, i parami)
  {
    this.b = paramContext;
    this.a = parami;
    this.c = new HashMap();
    this.d = a(paramContext);
    this.e = t.a(paramContext);
  }

  @SuppressLint({"NewApi"})
  private static int a(Display paramDisplay)
  {
    if (Build.VERSION.SDK_INT < 13)
      return paramDisplay.getWidth();
    Point localPoint = new Point();
    paramDisplay.getSize(localPoint);
    return localPoint.x;
  }

  private Bitmap a(InAppNotification paramInAppNotification, Context paramContext)
    throws i.a
  {
    int i = 0;
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = paramInAppNotification.getImage2xUrl();
    arrayOfString1[1] = paramInAppNotification.getImageUrl();
    int j = a(((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay());
    String[] arrayOfString2;
    if ((paramInAppNotification.getType() == InAppNotification.a.c) && (j >= 720))
    {
      arrayOfString2 = new String[3];
      arrayOfString2[0] = paramInAppNotification.getImage4xUrl();
      arrayOfString2[1] = paramInAppNotification.getImage2xUrl();
      arrayOfString2[2] = paramInAppNotification.getImageUrl();
    }
    while (true)
    {
      int k = arrayOfString2.length;
      while (i < k)
      {
        String str = arrayOfString2[i];
        try
        {
          Bitmap localBitmap = this.d.b(str);
          return localBitmap;
        }
        catch (d.a locala)
        {
          com.mixpanel.android.b.f.a("MixpanelAPI.DChecker", "Can't load image " + str + " for a notification", locala);
          i++;
        }
      }
      return null;
      arrayOfString2 = arrayOfString1;
    }
  }

  // ERROR //
  static a a(String paramString)
    throws e.b
  {
    // Byte code:
    //   0: new 156	com/mixpanel/android/mpmetrics/e$a
    //   3: dup
    //   4: invokespecial 157	com/mixpanel/android/mpmetrics/e$a:<init>	()V
    //   7: astore_1
    //   8: new 159	org/json/JSONObject
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 162	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: ldc 164
    //   20: invokevirtual 168	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   23: ifeq +151 -> 174
    //   26: aload_2
    //   27: ldc 164
    //   29: invokevirtual 172	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   32: astore 20
    //   34: aload 20
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +279 -> 317
    //   41: aload_3
    //   42: invokevirtual 175	org/json/JSONArray:length	()I
    //   45: iconst_2
    //   46: invokestatic 181	java/lang/Math:min	(II)I
    //   49: istore 8
    //   51: iconst_0
    //   52: istore 9
    //   54: iload 9
    //   56: iload 8
    //   58: if_icmpge +259 -> 317
    //   61: aload_3
    //   62: iload 9
    //   64: invokevirtual 185	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   67: astore 13
    //   69: aload 13
    //   71: ldc 187
    //   73: invokevirtual 191	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 14
    //   78: aload 14
    //   80: ldc 193
    //   82: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   85: ifeq +94 -> 179
    //   88: new 198	com/mixpanel/android/mpmetrics/TakeoverInAppNotification
    //   91: dup
    //   92: aload 13
    //   94: invokespecial 201	com/mixpanel/android/mpmetrics/TakeoverInAppNotification:<init>	(Lorg/json/JSONObject;)V
    //   97: astore 15
    //   99: aload_1
    //   100: getfield 204	com/mixpanel/android/mpmetrics/e$a:a	Ljava/util/List;
    //   103: aload 15
    //   105: invokeinterface 210 2 0
    //   110: pop
    //   111: iinc 9 1
    //   114: goto -60 -> 54
    //   117: astore 21
    //   119: new 148	com/mixpanel/android/mpmetrics/e$b
    //   122: dup
    //   123: new 128	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   130: ldc 212
    //   132: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aload 21
    //   144: invokespecial 215	com/mixpanel/android/mpmetrics/e$b:<init>	(Ljava/lang/String;Lorg/json/JSONException;)V
    //   147: athrow
    //   148: astore 19
    //   150: ldc 126
    //   152: new 128	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   159: ldc 217
    //   161: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_2
    //   165: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 223	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aconst_null
    //   175: astore_3
    //   176: goto -139 -> 37
    //   179: aload 14
    //   181: ldc 225
    //   183: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   186: ifeq -75 -> 111
    //   189: new 227	com/mixpanel/android/mpmetrics/MiniInAppNotification
    //   192: dup
    //   193: aload 13
    //   195: invokespecial 228	com/mixpanel/android/mpmetrics/MiniInAppNotification:<init>	(Lorg/json/JSONObject;)V
    //   198: astore 17
    //   200: aload_1
    //   201: getfield 204	com/mixpanel/android/mpmetrics/e$a:a	Ljava/util/List;
    //   204: aload 17
    //   206: invokeinterface 210 2 0
    //   211: pop
    //   212: goto -101 -> 111
    //   215: astore 12
    //   217: ldc 126
    //   219: new 128	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   226: ldc 230
    //   228: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_3
    //   232: invokevirtual 231	org/json/JSONArray:toString	()Ljava/lang/String;
    //   235: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload 12
    //   243: invokestatic 233	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: goto -135 -> 111
    //   249: astore 11
    //   251: ldc 126
    //   253: new 128	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   260: ldc 230
    //   262: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_3
    //   266: invokevirtual 231	org/json/JSONArray:toString	()Ljava/lang/String;
    //   269: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: aload 11
    //   277: invokestatic 233	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   280: goto -169 -> 111
    //   283: astore 10
    //   285: ldc 126
    //   287: new 128	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   294: ldc 235
    //   296: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_3
    //   300: invokevirtual 231	org/json/JSONArray:toString	()Ljava/lang/String;
    //   303: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: aload 10
    //   311: invokestatic 233	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   314: goto -203 -> 111
    //   317: aload_2
    //   318: ldc 237
    //   320: invokevirtual 168	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   323: ifeq +13 -> 336
    //   326: aload_1
    //   327: aload_2
    //   328: ldc 237
    //   330: invokevirtual 172	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   333: putfield 239	com/mixpanel/android/mpmetrics/e$a:b	Lorg/json/JSONArray;
    //   336: aload_2
    //   337: ldc 241
    //   339: invokevirtual 168	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   342: ifeq +13 -> 355
    //   345: aload_1
    //   346: aload_2
    //   347: ldc 241
    //   349: invokevirtual 172	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   352: putfield 243	com/mixpanel/android/mpmetrics/e$a:c	Lorg/json/JSONArray;
    //   355: aload_2
    //   356: ldc 245
    //   358: invokevirtual 168	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   361: ifeq +13 -> 374
    //   364: aload_1
    //   365: aload_2
    //   366: ldc 245
    //   368: invokevirtual 248	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   371: putfield 251	com/mixpanel/android/mpmetrics/e$a:d	Z
    //   374: aload_2
    //   375: ldc 253
    //   377: invokevirtual 168	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   380: ifeq +13 -> 393
    //   383: aload_1
    //   384: aload_2
    //   385: ldc 253
    //   387: invokevirtual 172	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   390: putfield 255	com/mixpanel/android/mpmetrics/e$a:e	Lorg/json/JSONArray;
    //   393: aload_1
    //   394: areturn
    //   395: astore 7
    //   397: ldc 126
    //   399: new 128	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 257
    //   409: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_2
    //   413: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 223	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: goto -86 -> 336
    //   425: astore 6
    //   427: ldc 126
    //   429: new 128	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 259
    //   439: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_2
    //   443: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 223	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: goto -97 -> 355
    //   455: astore 5
    //   457: ldc 126
    //   459: new 128	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   466: ldc_w 261
    //   469: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_2
    //   473: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 223	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -108 -> 374
    //   485: astore 4
    //   487: ldc 126
    //   489: new 128	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 263
    //   499: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_2
    //   503: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 223	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_1
    //   513: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   8	17	117	org/json/JSONException
    //   26	34	148	org/json/JSONException
    //   61	111	215	org/json/JSONException
    //   179	212	215	org/json/JSONException
    //   61	111	249	com/mixpanel/android/mpmetrics/b
    //   179	212	249	com/mixpanel/android/mpmetrics/b
    //   61	111	283	java/lang/OutOfMemoryError
    //   179	212	283	java/lang/OutOfMemoryError
    //   326	336	395	org/json/JSONException
    //   345	355	425	org/json/JSONException
    //   364	374	455	org/json/JSONException
    //   383	393	485	org/json/JSONException
  }

  private a a(String paramString1, String paramString2, com.mixpanel.android.b.i parami)
    throws i.a, e.b
  {
    String str = b(paramString1, paramString2, parami);
    com.mixpanel.android.b.f.a("MixpanelAPI.DChecker", "Mixpanel decide server response was:\n" + str);
    Object localObject = null;
    if (str != null)
    {
      a locala = a(str);
      Iterator localIterator = locala.a.iterator();
      while (localIterator.hasNext())
      {
        InAppNotification localInAppNotification = (InAppNotification)localIterator.next();
        Bitmap localBitmap = a(localInAppNotification, this.b);
        if (localBitmap == null)
        {
          com.mixpanel.android.b.f.c("MixpanelAPI.DChecker", "Could not retrieve image for notification " + localInAppNotification.getId() + ", will not show the notification.");
          localIterator.remove();
        }
        else
        {
          localInAppNotification.setImage(localBitmap);
        }
      }
      localObject = locala;
    }
    return localObject;
  }

  private static byte[] a(com.mixpanel.android.b.i parami, Context paramContext, String paramString)
    throws i.a
  {
    i locali = i.a(paramContext);
    if (!parami.a(paramContext, locali.D()))
      return null;
    try
    {
      byte[] arrayOfByte = parami.a(paramString, null, locali.C());
      return arrayOfByte;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      com.mixpanel.android.b.f.e("MixpanelAPI.DChecker", "Cannot interpret " + paramString + " as a URL.", localMalformedURLException);
      return null;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      com.mixpanel.android.b.f.a("MixpanelAPI.DChecker", "Cannot get " + paramString + ", file not found.", localFileNotFoundException);
      return null;
    }
    catch (IOException localIOException)
    {
      com.mixpanel.android.b.f.a("MixpanelAPI.DChecker", "Cannot get " + paramString + ".", localIOException);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      com.mixpanel.android.b.f.e("MixpanelAPI.DChecker", "Out of memory when getting to " + paramString + ".", localOutOfMemoryError);
    }
    return null;
  }

  // ERROR //
  private String b(String paramString1, String paramString2, com.mixpanel.android.b.i parami)
    throws i.a
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 355
    //   4: invokestatic 361	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 5
    //   9: aload_2
    //   10: ifnull +237 -> 247
    //   13: aload_2
    //   14: ldc_w 355
    //   17: invokestatic 361	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 6
    //   22: aload 6
    //   24: astore 7
    //   26: new 128	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 363
    //   36: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 5
    //   41: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: astore 8
    //   46: aload 7
    //   48: ifnull +17 -> 65
    //   51: aload 8
    //   53: ldc_w 365
    //   56: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload 7
    //   61: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 8
    //   67: ldc_w 367
    //   70: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: new 159	org/json/JSONObject
    //   77: dup
    //   78: invokespecial 368	org/json/JSONObject:<init>	()V
    //   81: astore 10
    //   83: aload 10
    //   85: ldc_w 370
    //   88: ldc_w 372
    //   91: invokevirtual 376	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload 10
    //   97: ldc_w 378
    //   100: aload_0
    //   101: getfield 49	com/mixpanel/android/mpmetrics/e:e	Lcom/mixpanel/android/mpmetrics/t;
    //   104: invokevirtual 380	com/mixpanel/android/mpmetrics/t:a	()Ljava/lang/String;
    //   107: invokevirtual 376	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload 10
    //   113: ldc_w 382
    //   116: getstatic 386	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   119: invokevirtual 376	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload 10
    //   125: ldc_w 388
    //   128: aload_0
    //   129: getfield 49	com/mixpanel/android/mpmetrics/e:e	Lcom/mixpanel/android/mpmetrics/t;
    //   132: invokevirtual 391	com/mixpanel/android/mpmetrics/t:b	()Ljava/lang/Integer;
    //   135: invokevirtual 376	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 10
    //   141: ldc_w 393
    //   144: getstatic 398	android/os/Build:MODEL	Ljava/lang/String;
    //   147: invokevirtual 376	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload 8
    //   153: aload 10
    //   155: invokevirtual 399	org/json/JSONObject:toString	()Ljava/lang/String;
    //   158: ldc_w 355
    //   161: invokestatic 361	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 8
    //   170: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 12
    //   175: new 128	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   182: aload_0
    //   183: getfield 32	com/mixpanel/android/mpmetrics/e:a	Lcom/mixpanel/android/mpmetrics/i;
    //   186: invokevirtual 402	com/mixpanel/android/mpmetrics/i:o	()Ljava/lang/String;
    //   189: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 12
    //   194: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore 13
    //   202: ldc 126
    //   204: new 128	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 404
    //   214: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 13
    //   219: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 271	com/mixpanel/android/b/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload_3
    //   229: aload_0
    //   230: getfield 30	com/mixpanel/android/mpmetrics/e:b	Landroid/content/Context;
    //   233: aload 13
    //   235: invokestatic 406	com/mixpanel/android/mpmetrics/e:a	(Lcom/mixpanel/android/b/i;Landroid/content/Context;Ljava/lang/String;)[B
    //   238: astore 14
    //   240: aload 14
    //   242: ifnonnull +44 -> 286
    //   245: aconst_null
    //   246: areturn
    //   247: aconst_null
    //   248: astore 7
    //   250: goto -224 -> 26
    //   253: astore 4
    //   255: new 408	java/lang/RuntimeException
    //   258: dup
    //   259: ldc_w 410
    //   262: aload 4
    //   264: invokespecial 413	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   267: athrow
    //   268: astore 11
    //   270: ldc 126
    //   272: ldc_w 415
    //   275: aload 11
    //   277: invokevirtual 419	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   280: invokestatic 233	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   283: goto -115 -> 168
    //   286: new 82	java/lang/String
    //   289: dup
    //   290: aload 14
    //   292: ldc_w 421
    //   295: invokespecial 424	java/lang/String:<init>	([BLjava/lang/String;)V
    //   298: astore 15
    //   300: aload 15
    //   302: areturn
    //   303: astore 16
    //   305: new 408	java/lang/RuntimeException
    //   308: dup
    //   309: ldc_w 426
    //   312: aload 16
    //   314: invokespecial 413	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   317: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	253	java/io/UnsupportedEncodingException
    //   13	22	253	java/io/UnsupportedEncodingException
    //   83	168	268	java/lang/Exception
    //   286	300	303	java/io/UnsupportedEncodingException
  }

  protected d a(Context paramContext)
  {
    return new d(paramContext, "DecideChecker");
  }

  public void a(f paramf)
  {
    this.c.put(paramf.a(), paramf);
  }

  public void a(String paramString, com.mixpanel.android.b.i parami)
    throws i.a
  {
    f localf = (f)this.c.get(paramString);
    String str;
    if (localf != null)
      str = localf.b();
    try
    {
      a locala = a(localf.a(), str, parami);
      if (locala != null)
        localf.a(locala.a, locala.b, locala.c, locala.d, locala.e);
      return;
    }
    catch (b localb)
    {
      com.mixpanel.android.b.f.e("MixpanelAPI.DChecker", localb.getMessage(), localb);
    }
  }

  public f b(String paramString)
  {
    return (f)this.c.get(paramString);
  }

  static class a
  {
    public final List<InAppNotification> a = new ArrayList();
    public JSONArray b = e.a();
    public JSONArray c = e.a();
    public boolean d = false;
    public JSONArray e;
  }

  static class b extends Exception
  {
    public b(String paramString, JSONException paramJSONException)
    {
      super(paramJSONException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.e
 * JD-Core Version:    0.6.2
 */