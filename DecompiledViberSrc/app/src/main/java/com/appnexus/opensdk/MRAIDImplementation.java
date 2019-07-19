package com.appnexus.opensdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.CalendarContract.Events;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.StringUtil;
import com.appnexus.opensdk.utils.ViewUtil;
import com.appnexus.opensdk.utils.W3CEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"InlinedApi"})
class MRAIDImplementation
{
  protected static final String[] a = { "default", "expanded" };
  protected final f b;
  boolean c = false;
  boolean d = false;
  int e;
  int f;
  int g;
  boolean h = false;
  boolean i = false;
  boolean j;
  protected boolean k = false;
  private boolean l = false;
  private int m;
  private int n;
  private Activity o;
  private ViewGroup p;
  private String q = "";
  private int[] r = new int[4];
  private int s;
  private o t = null;

  public MRAIDImplementation(f paramf)
  {
    this.b = paramf;
  }

  private AdActivity.b a(String paramString)
  {
    AdActivity.b localb = AdActivity.b.c;
    if (paramString.equals("landscape"))
      localb = AdActivity.b.b;
    while (!paramString.equals("portrait"))
      return localb;
    return AdActivity.b.a;
  }

  @SuppressLint({"NewApi"})
  private void a(f paramf)
  {
    if (a(new Intent("android.intent.action.VIEW", Uri.parse("sms:5555555555"))))
      a(paramf, "sms", true);
    if (a(new Intent("android.intent.action.VIEW", Uri.parse("tel:5555555555"))))
      a(paramf, "tel", true);
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (!a(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI)))
        break label159;
      a(paramf, "calendar", true);
      this.i = true;
    }
    while (true)
    {
      if ((this.b.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.b.getContext().getPackageName()) == 0) && (Build.VERSION.SDK_INT >= 11))
      {
        a(paramf, "storePicture", true);
        this.h = true;
      }
      a(paramf, "inlineVideo", true);
      return;
      label159: if (a(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event")))
      {
        a(paramf, "calendar", true);
        this.i = true;
        W3CEvent.useMIME = true;
      }
    }
  }

  private void a(f paramf, String paramString, boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = String.valueOf(paramBoolean);
    paramf.e(String.format("javascript:window.mraid.util.setSupports('%s', %s)", arrayOfObject));
  }

  private void c(ArrayList<Pair<String, String>> paramArrayList)
  {
    Object localObject1 = null;
    Iterator localIterator = paramArrayList.iterator();
    Pair localPair;
    if (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if (!((String)localPair.first).equals("uri"))
        break label78;
    }
    label78: for (Object localObject2 = Uri.decode((String)localPair.second); ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if (!StringUtil.isEmpty(localObject1))
        this.b.c(localObject1);
      return;
    }
  }

  private void d(ArrayList<Pair<String, String>> paramArrayList)
  {
    Object localObject1 = null;
    Iterator localIterator = paramArrayList.iterator();
    Pair localPair;
    if (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if (!((String)localPair.first).equals("uri"))
        break label161;
    }
    label161: for (Object localObject2 = (String)localPair.second; ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if (localObject1 == null)
      {
        Clog.d(Clog.mraidLogTag, Clog.getString(R.string.store_picture_error));
        return;
      }
      final String str = Uri.decode(localObject1);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(ViewUtil.getTopContext(this.b));
      localBuilder.setTitle(R.string.store_picture_title);
      localBuilder.setMessage(R.string.store_picture_message);
      localBuilder.setPositiveButton(R.string.store_picture_accept, new DialogInterface.OnClickListener()
      {
        // ERROR //
        @SuppressLint({"NewApi"})
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          // Byte code:
          //   0: iconst_1
          //   1: istore_3
          //   2: aload_0
          //   3: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   6: ldc 39
          //   8: invokevirtual 45	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   11: ifeq +471 -> 482
          //   14: ldc 47
          //   16: astore 11
          //   18: aload_0
          //   19: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   22: ldc 49
          //   24: invokevirtual 53	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   27: ifeq +139 -> 166
          //   30: ldc 55
          //   32: astore 11
          //   34: aload_0
          //   35: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   38: ldc 57
          //   40: invokevirtual 53	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   43: ifeq +623 -> 666
          //   46: new 59	java/io/File
          //   49: dup
          //   50: getstatic 64	android/os/Environment:DIRECTORY_PICTURES	Ljava/lang/String;
          //   53: invokestatic 68	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
          //   56: new 70	java/lang/StringBuilder
          //   59: dup
          //   60: invokespecial 71	java/lang/StringBuilder:<init>	()V
          //   63: invokestatic 77	java/lang/System:currentTimeMillis	()J
          //   66: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   69: aload 11
          //   71: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   74: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   77: invokespecial 91	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
          //   80: astore 12
          //   82: aconst_null
          //   83: astore 13
          //   85: new 93	java/io/FileOutputStream
          //   88: dup
          //   89: aload 12
          //   91: invokespecial 96	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
          //   94: astore 14
          //   96: aload 12
          //   98: invokevirtual 100	java/io/File:canWrite	()Z
          //   101: ifeq +44 -> 145
          //   104: iload_3
          //   105: ifne +149 -> 254
          //   108: aload_0
          //   109: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   112: iconst_1
          //   113: aload_0
          //   114: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   117: ldc 102
          //   119: invokevirtual 106	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
          //   122: iadd
          //   123: aload_0
          //   124: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   127: invokevirtual 110	java/lang/String:length	()I
          //   130: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
          //   133: invokestatic 120	com/appnexus/opensdk/utils/Hex:hexStringToByteArray	(Ljava/lang/String;)[B
          //   136: astore 24
          //   138: aload 14
          //   140: aload 24
          //   142: invokevirtual 124	java/io/FileOutputStream:write	([B)V
          //   145: aload 14
          //   147: ifnull +8 -> 155
          //   150: aload 14
          //   152: invokevirtual 127	java/io/FileOutputStream:close	()V
          //   155: aload_0
          //   156: getfield 19	com/appnexus/opensdk/MRAIDImplementation$2:b	Lcom/appnexus/opensdk/MRAIDImplementation;
          //   159: getfield 130	com/appnexus/opensdk/MRAIDImplementation:b	Lcom/appnexus/opensdk/f;
          //   162: invokevirtual 135	com/appnexus/opensdk/f:e	()V
          //   165: return
          //   166: aload_0
          //   167: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   170: ldc 137
          //   172: invokevirtual 53	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   175: ifne +15 -> 190
          //   178: aload_0
          //   179: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   182: ldc 139
          //   184: invokevirtual 53	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   187: ifeq +10 -> 197
          //   190: ldc 141
          //   192: astore 11
          //   194: goto -160 -> 34
          //   197: aload_0
          //   198: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   201: ldc 143
          //   203: invokevirtual 53	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   206: ifeq +10 -> 216
          //   209: ldc 47
          //   211: astore 11
          //   213: goto -179 -> 34
          //   216: aload_0
          //   217: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   220: ldc 145
          //   222: invokevirtual 53	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   225: ifeq +10 -> 235
          //   228: ldc 147
          //   230: astore 11
          //   232: goto -198 -> 34
          //   235: aload_0
          //   236: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   239: ldc 149
          //   241: invokevirtual 53	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   244: ifeq -210 -> 34
          //   247: ldc 151
          //   249: astore 11
          //   251: goto -217 -> 34
          //   254: aload_0
          //   255: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   258: iconst_1
          //   259: aload_0
          //   260: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   263: ldc 102
          //   265: invokevirtual 106	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
          //   268: iadd
          //   269: aload_0
          //   270: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   273: invokevirtual 110	java/lang/String:length	()I
          //   276: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
          //   279: iconst_0
          //   280: invokestatic 157	android/util/Base64:decode	(Ljava/lang/String;I)[B
          //   283: astore 26
          //   285: aload 26
          //   287: astore 24
          //   289: goto -151 -> 138
          //   292: astore 25
          //   294: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   297: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   300: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   303: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   306: goto -151 -> 155
          //   309: astore 29
          //   311: aconst_null
          //   312: astore 14
          //   314: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   317: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   320: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   323: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   326: aload 14
          //   328: ifnull -173 -> 155
          //   331: aload 14
          //   333: invokevirtual 127	java/io/FileOutputStream:close	()V
          //   336: goto -181 -> 155
          //   339: astore 19
          //   341: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   344: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   347: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   350: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   353: goto -198 -> 155
          //   356: astore 28
          //   358: aconst_null
          //   359: astore 14
          //   361: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   364: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   367: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   370: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   373: aload 14
          //   375: ifnull -220 -> 155
          //   378: aload 14
          //   380: invokevirtual 127	java/io/FileOutputStream:close	()V
          //   383: goto -228 -> 155
          //   386: astore 21
          //   388: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   391: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   394: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   397: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   400: goto -245 -> 155
          //   403: astore 27
          //   405: aconst_null
          //   406: astore 14
          //   408: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   411: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   414: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   417: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   420: aload 14
          //   422: ifnull -267 -> 155
          //   425: aload 14
          //   427: invokevirtual 127	java/io/FileOutputStream:close	()V
          //   430: goto -275 -> 155
          //   433: astore 23
          //   435: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   438: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   441: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   444: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   447: goto -292 -> 155
          //   450: astore 17
          //   452: aload 13
          //   454: ifnull +8 -> 462
          //   457: aload 13
          //   459: invokevirtual 127	java/io/FileOutputStream:close	()V
          //   462: aload 17
          //   464: athrow
          //   465: astore 18
          //   467: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   470: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   473: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   476: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   479: goto -17 -> 462
          //   482: aload_0
          //   483: getfield 19	com/appnexus/opensdk/MRAIDImplementation$2:b	Lcom/appnexus/opensdk/MRAIDImplementation;
          //   486: getfield 130	com/appnexus/opensdk/MRAIDImplementation:b	Lcom/appnexus/opensdk/f;
          //   489: invokevirtual 179	com/appnexus/opensdk/f:getContext	()Landroid/content/Context;
          //   492: ldc 181
          //   494: invokevirtual 187	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   497: checkcast 189	android/app/DownloadManager
          //   500: astore 4
          //   502: new 191	android/app/DownloadManager$Request
          //   505: dup
          //   506: aload_0
          //   507: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   510: invokestatic 197	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   513: invokespecial 200	android/app/DownloadManager$Request:<init>	(Landroid/net/Uri;)V
          //   516: astore 5
          //   518: aload_0
          //   519: getfield 19	com/appnexus/opensdk/MRAIDImplementation$2:b	Lcom/appnexus/opensdk/MRAIDImplementation;
          //   522: getfield 130	com/appnexus/opensdk/MRAIDImplementation:b	Lcom/appnexus/opensdk/f;
          //   525: invokevirtual 179	com/appnexus/opensdk/f:getContext	()Landroid/content/Context;
          //   528: invokevirtual 204	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
          //   531: ldc 206
          //   533: aload_0
          //   534: getfield 19	com/appnexus/opensdk/MRAIDImplementation$2:b	Lcom/appnexus/opensdk/MRAIDImplementation;
          //   537: getfield 130	com/appnexus/opensdk/MRAIDImplementation:b	Lcom/appnexus/opensdk/f;
          //   540: invokevirtual 179	com/appnexus/opensdk/f:getContext	()Landroid/content/Context;
          //   543: invokevirtual 209	android/content/Context:getPackageName	()Ljava/lang/String;
          //   546: invokevirtual 215	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
          //   549: ifne +74 -> 623
          //   552: aload 5
          //   554: getstatic 64	android/os/Environment:DIRECTORY_PICTURES	Ljava/lang/String;
          //   557: aload_0
          //   558: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   561: ldc 217
          //   563: invokevirtual 221	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
          //   566: iconst_m1
          //   567: aload_0
          //   568: getfield 21	com/appnexus/opensdk/MRAIDImplementation$2:a	Ljava/lang/String;
          //   571: ldc 217
          //   573: invokevirtual 221	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
          //   576: arraylength
          //   577: iadd
          //   578: aaload
          //   579: invokevirtual 225	android/app/DownloadManager$Request:setDestinationInExternalPublicDir	(Ljava/lang/String;Ljava/lang/String;)Landroid/app/DownloadManager$Request;
          //   582: pop
          //   583: aload 5
          //   585: invokevirtual 228	android/app/DownloadManager$Request:allowScanningByMediaScanner	()V
          //   588: aload 5
          //   590: iconst_1
          //   591: invokevirtual 232	android/app/DownloadManager$Request:setNotificationVisibility	(I)Landroid/app/DownloadManager$Request;
          //   594: pop
          //   595: aload 4
          //   597: aload 5
          //   599: invokevirtual 236	android/app/DownloadManager:enqueue	(Landroid/app/DownloadManager$Request;)J
          //   602: pop2
          //   603: goto -448 -> 155
          //   606: astore 7
          //   608: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   611: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   614: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   617: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   620: goto -465 -> 155
          //   623: getstatic 162	com/appnexus/opensdk/utils/Clog:mraidLogTag	Ljava/lang/String;
          //   626: getstatic 168	com/appnexus/opensdk/R$string:store_picture_error	I
          //   629: invokestatic 172	com/appnexus/opensdk/utils/Clog:getString	(I)Ljava/lang/String;
          //   632: invokestatic 175	com/appnexus/opensdk/utils/Clog:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   635: goto -480 -> 155
          //   638: astore 16
          //   640: aload 14
          //   642: astore 13
          //   644: aload 16
          //   646: astore 17
          //   648: goto -196 -> 452
          //   651: astore 22
          //   653: goto -245 -> 408
          //   656: astore 20
          //   658: goto -297 -> 361
          //   661: astore 15
          //   663: goto -349 -> 314
          //   666: iconst_0
          //   667: istore_3
          //   668: goto -622 -> 46
          //
          // Exception table:
          //   from	to	target	type
          //   150	155	292	java/io/IOException
          //   85	96	309	java/io/FileNotFoundException
          //   331	336	339	java/io/IOException
          //   85	96	356	java/io/IOException
          //   378	383	386	java/io/IOException
          //   85	96	403	java/lang/IllegalArgumentException
          //   425	430	433	java/io/IOException
          //   85	96	450	finally
          //   457	462	465	java/io/IOException
          //   583	603	606	java/lang/IllegalStateException
          //   96	104	638	finally
          //   108	138	638	finally
          //   138	145	638	finally
          //   254	285	638	finally
          //   314	326	638	finally
          //   361	373	638	finally
          //   408	420	638	finally
          //   96	104	651	java/lang/IllegalArgumentException
          //   108	138	651	java/lang/IllegalArgumentException
          //   138	145	651	java/lang/IllegalArgumentException
          //   254	285	651	java/lang/IllegalArgumentException
          //   96	104	656	java/io/IOException
          //   108	138	656	java/io/IOException
          //   138	145	656	java/io/IOException
          //   254	285	656	java/io/IOException
          //   96	104	661	java/io/FileNotFoundException
          //   108	138	661	java/io/FileNotFoundException
          //   138	145	661	java/io/FileNotFoundException
          //   254	285	661	java/io/FileNotFoundException
        }
      });
      localBuilder.setNegativeButton(R.string.store_picture_decline, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
        }
      });
      localBuilder.create().show();
      return;
    }
  }

  private void e(ArrayList<Pair<String, String>> paramArrayList)
  {
    Object localObject1 = null;
    Iterator localIterator = paramArrayList.iterator();
    Pair localPair;
    if (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if (!((String)localPair.first).equals("uri"))
        break label153;
    }
    label153: for (Object localObject2 = (String)localPair.second; ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if (localObject1 == null)
      {
        Clog.d(Clog.mraidLogTag, Clog.getString(R.string.play_vide_no_uri));
        return;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setFlags(268435456);
      try
      {
        localIntent.setDataAndType(Uri.parse(URLDecoder.decode(localObject1, "UTF-8")), "video/mp4");
        try
        {
          this.b.getContext().startActivity(localIntent);
          this.b.e();
          return;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Clog.d(Clog.mraidLogTag, Clog.getString(R.string.unsupported_encoding));
        return;
      }
    }
  }

  private void f()
  {
    Activity localActivity = (Activity)this.b.v();
    int[] arrayOfInt1 = new int[2];
    this.b.getLocationOnScreen(arrayOfInt1);
    int i1 = localActivity.getWindow().findViewById(16908290).getTop();
    arrayOfInt1[1] -= i1;
    this.b.measure(0, 0);
    int[] arrayOfInt2 = { this.b.getMeasuredWidth(), this.b.getMeasuredHeight() };
    ViewUtil.convertFromPixelsToDP(localActivity, arrayOfInt2);
    f localf = this.b;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(arrayOfInt1[0]);
    arrayOfObject[1] = Integer.valueOf(arrayOfInt1[1]);
    arrayOfObject[2] = Integer.valueOf(arrayOfInt2[0]);
    arrayOfObject[3] = Integer.valueOf(arrayOfInt2[1]);
    localf.e(String.format("javascript:window.mraid.util.setDefaultPosition(%d, %d, %d, %d)", arrayOfObject));
  }

  private void f(ArrayList<Pair<String, String>> paramArrayList)
  {
    Object localObject = null;
    if (paramArrayList != null);
    try
    {
      int i1 = paramArrayList.size();
      localObject = null;
      if (i1 > 0)
      {
        W3CEvent localW3CEvent = W3CEvent.createFromJSON(URLDecoder.decode((String)((Pair)paramArrayList.get(0)).second, "UTF-8"));
        localObject = localW3CEvent;
      }
      if (localObject != null);
      try
      {
        Intent localIntent = localObject.getInsertIntent();
        localIntent.setFlags(268435456);
        this.b.getContext().startActivity(localIntent);
        this.b.e();
        Clog.d(Clog.mraidLogTag, Clog.getString(R.string.create_calendar_event));
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
  }

  private void g()
  {
    if ((this.b.v() instanceof Activity))
    {
      Activity localActivity = (Activity)this.b.v();
      int[] arrayOfInt = ViewUtil.getScreenSizeAsPixels(localActivity);
      int i1 = arrayOfInt[0];
      int i2 = arrayOfInt[1] - localActivity.getWindow().findViewById(16908290).getTop();
      float f1 = localActivity.getResources().getDisplayMetrics().density;
      int i3 = (int)(0.5F + i2 / f1);
      int i4 = (int)(0.5F + i1 / f1);
      this.b.e("javascript:window.mraid.util.setMaxSize(" + i4 + ", " + i3 + ")");
    }
  }

  private void g(ArrayList<Pair<String, String>> paramArrayList)
  {
    int i1 = 1;
    AdActivity.b localb = AdActivity.b.c;
    Iterator localIterator = paramArrayList.iterator();
    Object localObject1 = localb;
    int i2 = i1;
    Pair localPair;
    Object localObject2;
    int i3;
    if (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if (((String)localPair.first).equals("allow_orientation_change"))
      {
        int i4 = Boolean.parseBoolean((String)localPair.second);
        localObject2 = localObject1;
        i3 = i4;
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      i2 = i3;
      break;
      if (((String)localPair.first).equals("force_orientation"))
      {
        localObject2 = a((String)localPair.second);
        i3 = i2;
        continue;
        if ((this.c) || (this.b.a.e()))
          if (!this.b.b)
            break label174;
        label174: for (Activity localActivity = d(); i2 != 0; localActivity = (Activity)this.b.v())
        {
          AdActivity.b(localActivity);
          return;
        }
        switch (4.a[localObject1.ordinal()])
        {
        default:
        case 2:
        case 1:
        }
        for (i1 = 0; ; i1 = 2)
        {
          AdActivity.a(localActivity, i1);
          return;
        }
      }
      else
      {
        localObject2 = localObject1;
        i3 = i2;
      }
    }
  }

  private void h()
  {
    if ((this.b.v() instanceof Activity))
    {
      int[] arrayOfInt = ViewUtil.getScreenSizeAsDP((Activity)this.b.v());
      this.m = arrayOfInt[0];
      this.n = arrayOfInt[1];
      this.b.e("javascript:window.mraid.util.setScreenSize(" + this.m + ", " + this.n + ")");
    }
  }

  private void h(ArrayList<Pair<String, String>> paramArrayList)
  {
    String str1 = "top-right";
    Iterator localIterator = paramArrayList.iterator();
    boolean bool1 = true;
    int i1 = 0;
    int i2 = 0;
    int i3 = -1;
    int i4 = -1;
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      String str2;
      try
      {
        str2 = (String)localPair.first;
        switch (str2.hashCode())
        {
        case 119:
          Clog.e(Clog.mraidLogTag, "resize Invalid parameter::" + (String)localPair.first);
        case 104:
        case -755984436:
        case -755984435:
        case 1387370014:
        case -1281936091:
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Clog.d(Clog.mraidLogTag, Clog.getString(R.string.number_format));
        return;
      }
      if (!str2.equals("w"))
        break label490;
      i5 = 0;
      break label493;
      if (!str2.equals("h"))
        break label490;
      i5 = 1;
      break label493;
      if (!str2.equals("offset_x"))
        break label490;
      i5 = 2;
      break label493;
      if (!str2.equals("offset_y"))
        break label490;
      i5 = 3;
      break label493;
      if (!str2.equals("custom_close_position"))
        break label490;
      i5 = 4;
      break label493;
      if (!str2.equals("allow_offscreen"))
        break label490;
      i5 = 5;
      break label493;
      i4 = Integer.parseInt((String)localPair.second);
      continue;
      i3 = Integer.parseInt((String)localPair.second);
      continue;
      i2 = Integer.parseInt((String)localPair.second);
      continue;
      i1 = Integer.parseInt((String)localPair.second);
      continue;
      str1 = (String)localPair.second;
      continue;
      boolean bool2 = Boolean.parseBoolean((String)localPair.second);
      bool1 = bool2;
    }
    if ((i4 > this.m) && (i3 > this.n))
    {
      this.b.e("javascript:mraid.util.errorEvent('Resize called with resizeProperties larger than the screen.', 'mraid.resize()')");
      return;
    }
    CUSTOM_CLOSE_POSITION localCUSTOM_CLOSE_POSITION1 = CUSTOM_CLOSE_POSITION.top_right;
    try
    {
      CUSTOM_CLOSE_POSITION localCUSTOM_CLOSE_POSITION3 = CUSTOM_CLOSE_POSITION.valueOf(str1.replace('-', '_'));
      localCUSTOM_CLOSE_POSITION2 = localCUSTOM_CLOSE_POSITION3;
      Clog.d(Clog.mraidLogTag, Clog.getString(R.string.resize, i4, i3, i2, i1, str1, bool1));
      this.b.a(i4, i3, i2, i1, localCUSTOM_CLOSE_POSITION2, bool1);
      this.b.e();
      this.b.e("javascript:window.mraid.util.stateChangeEvent('resized');");
      this.d = true;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        CUSTOM_CLOSE_POSITION localCUSTOM_CLOSE_POSITION2 = localCUSTOM_CLOSE_POSITION1;
    }
    label490: int i5 = -1;
    label493: switch (i5)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
  }

  void a()
  {
    if (!this.l)
      return;
    f localf = this.b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.q;
    localf.e(String.format("javascript:window.mraid.util.exposureChangeEvent(%s)", arrayOfObject));
  }

  void a(double paramDouble, Rect paramRect)
  {
    Object[] arrayOfObject2;
    if (paramRect != null)
    {
      Activity localActivity = (Activity)this.b.v();
      int[] arrayOfInt = new int[4];
      arrayOfInt[0] = paramRect.left;
      arrayOfInt[1] = paramRect.top;
      arrayOfInt[2] = paramRect.width();
      arrayOfInt[3] = paramRect.height();
      ViewUtil.convertFromPixelsToDP(localActivity, arrayOfInt);
      arrayOfObject2 = new Object[5];
      arrayOfObject2[0] = Double.valueOf(paramDouble);
      arrayOfObject2[1] = Integer.valueOf(arrayOfInt[0]);
      arrayOfObject2[2] = Integer.valueOf(arrayOfInt[1]);
      arrayOfObject2[3] = Integer.valueOf(arrayOfInt[2]);
      arrayOfObject2[4] = Integer.valueOf(arrayOfInt[3]);
    }
    Object[] arrayOfObject1;
    for (String str = String.format("{\"exposedPercentage\":%.1f,\"visibleRectangle\":{\"x\":%d,\"y\":%d,\"width\":%d,\"height\":%d},\"occlusionRectangles\":null}", arrayOfObject2); ; str = String.format("{\"exposedPercentage\":%.1f,\"visibleRectangle\":null,\"occlusionRectangles\":null}", arrayOfObject1))
    {
      if (!this.q.equals(str))
      {
        this.q = str;
        a();
      }
      return;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Double.valueOf(paramDouble);
    }
  }

  void a(int paramInt)
  {
    if (this.s != paramInt)
    {
      this.s = paramInt;
      g();
      h();
    }
  }

  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.r[0] == paramInt1) && (this.r[1] == paramInt2) && (this.r[2] == paramInt3) && (this.r[3] == paramInt4))
      return;
    this.r[0] = paramInt1;
    this.r[1] = paramInt2;
    this.r[2] = paramInt3;
    this.r[3] = paramInt4;
    Activity localActivity = (Activity)this.b.v();
    int[] arrayOfInt = { paramInt1, paramInt2 - localActivity.getWindow().findViewById(16908290).getTop(), paramInt3, paramInt4 };
    ViewUtil.convertFromPixelsToDP(localActivity, arrayOfInt);
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    int i3 = arrayOfInt[2];
    int i4 = arrayOfInt[3];
    f localf1 = this.b;
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = Integer.valueOf(i1);
    arrayOfObject1[1] = Integer.valueOf(i2);
    arrayOfObject1[2] = Integer.valueOf(i3);
    arrayOfObject1[3] = Integer.valueOf(i4);
    localf1.e(String.format("javascript:window.mraid.util.setCurrentPosition(%d, %d, %d, %d)", arrayOfObject1));
    f localf2 = this.b;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(i3);
    arrayOfObject2[1] = Integer.valueOf(i4);
    localf2.e(String.format("javascript:window.mraid.util.sizeChangeEvent(%d, %d)", arrayOfObject2));
  }

  void a(Activity paramActivity)
  {
    this.o = paramActivity;
  }

  void a(ViewGroup paramViewGroup)
  {
    this.p = paramViewGroup;
  }

  void a(f paramf, String paramString)
  {
    if (!this.l)
      if (!this.b.a.d())
        break label232;
    label232: for (String str = "inline"; ; str = "interstitial")
    {
      this.k = paramString.equals(a[MRAID_INIT_STATE.STARTING_EXPANDED.ordinal()]);
      this.b.b = this.k;
      paramf.e("javascript:window.mraid.util.setPlacementType('" + str + "')");
      if (!this.k)
      {
        a(paramf);
        h();
        g();
        f();
      }
      this.b.s();
      paramf.e("javascript:window.mraid.util.stateChangeEvent('" + paramString + "')");
      paramf.e("javascript:window.mraid.util.readyEvent();");
      this.e = this.b.getLayoutParams().width;
      this.f = this.b.getLayoutParams().height;
      if (this.b.a.getMediaType().equals(MediaType.BANNER))
        this.g = ((FrameLayout.LayoutParams)this.b.getLayoutParams()).gravity;
      this.l = true;
      a(this.b.t());
      return;
    }
  }

  void a(String paramString, boolean paramBoolean)
  {
    String str1 = paramString.replaceFirst("mraid://", "");
    String[] arrayOfString1 = str1.split("\\?");
    String str2 = arrayOfString1[0].replaceAll("/", "");
    ArrayList localArrayList = new ArrayList();
    if (arrayOfString1.length > 1)
    {
      String[] arrayOfString2 = str1.substring(1 + str1.indexOf("?")).split("&");
      int i1 = arrayOfString2.length;
      int i2 = 0;
      if (i2 < i1)
      {
        String[] arrayOfString3 = arrayOfString2[i2].split("=");
        if (arrayOfString3.length < 2);
        while (true)
        {
          i2++;
          break;
          if ((!StringUtil.isEmpty(arrayOfString3[1])) && (!"undefined".equals(arrayOfString3[1])))
            localArrayList.add(new Pair(arrayOfString3[0], arrayOfString3[1]));
        }
      }
    }
    if (str2.equals("expand"))
      if (paramBoolean)
        b(localArrayList);
    do
    {
      return;
      Clog.w(Clog.mraidLogTag, Clog.getString(R.string.no_user_interaction, str1));
      return;
      if (str2.equals("close"))
      {
        b();
        return;
      }
      if (str2.equals("resize"))
      {
        if (paramBoolean)
        {
          h(localArrayList);
          return;
        }
        Clog.w(Clog.mraidLogTag, Clog.getString(R.string.no_user_interaction, str1));
        return;
      }
      if (str2.equals("setOrientationProperties"))
      {
        g(localArrayList);
        return;
      }
      if ((this.i) && (str2.equals("createCalendarEvent")))
      {
        if (paramBoolean)
        {
          f(localArrayList);
          return;
        }
        Clog.w(Clog.mraidLogTag, Clog.getString(R.string.no_user_interaction, str1));
        return;
      }
      if (str2.equals("playVideo"))
      {
        if (paramBoolean)
        {
          e(localArrayList);
          return;
        }
        Clog.w(Clog.mraidLogTag, Clog.getString(R.string.no_user_interaction, str1));
        return;
      }
      if ((this.h) && (str2.equals("storePicture")))
      {
        if (paramBoolean)
        {
          d(localArrayList);
          return;
        }
        Clog.w(Clog.mraidLogTag, Clog.getString(R.string.no_user_interaction, str1));
        return;
      }
      if (str2.equals("open"))
      {
        if (paramBoolean)
        {
          c(localArrayList);
          return;
        }
        Clog.w(Clog.mraidLogTag, Clog.getString(R.string.no_user_interaction, str1));
        return;
      }
      if (str2.equals("setUseCustomClose"))
      {
        a(localArrayList);
        return;
      }
    }
    while (str2.equals("enable"));
    Clog.d(Clog.mraidLogTag, Clog.getString(R.string.unsupported_mraid, str2));
  }

  void a(ArrayList<Pair<String, String>> paramArrayList)
  {
    this.b.a(Boolean.parseBoolean((String)((Pair)paramArrayList.get(0)).second));
  }

  void a(boolean paramBoolean)
  {
    if (!this.l)
      return;
    this.j = paramBoolean;
    this.b.e("javascript:window.mraid.util.setIsViewable(" + paramBoolean + ")");
  }

  boolean a(Intent paramIntent)
  {
    int i1 = this.b.getContext().getPackageManager().queryIntentActivities(paramIntent, 0).size();
    boolean bool = false;
    if (i1 > 0)
      bool = true;
    return bool;
  }

  void b()
  {
    FrameLayout.LayoutParams localLayoutParams;
    if ((this.c) || (this.d) || (this.k))
    {
      localLayoutParams = new FrameLayout.LayoutParams(this.b.getLayoutParams());
      localLayoutParams.height = this.f;
      localLayoutParams.width = this.e;
      if (this.b.a.getMediaType().equals(MediaType.BANNER))
      {
        localLayoutParams.gravity = this.g;
        this.b.setLayoutParams(localLayoutParams);
        this.b.r();
        this.b.e("javascript:window.mraid.util.stateChangeEvent('default');");
        if ((!this.b.a.e()) && (!this.k))
          this.b.a.getAdDispatcher().b();
        Activity localActivity1 = (Activity)this.b.v();
        if (localActivity1 != null)
          localActivity1.setRequestedOrientation(-1);
        this.c = false;
        this.d = false;
        this.t = null;
      }
    }
    Activity localActivity2;
    do
    {
      return;
      localLayoutParams.gravity = 17;
      break;
      if (!this.b.a.e())
        break label239;
      this.b.a.getAdDispatcher().b();
      localActivity2 = (Activity)this.b.v();
    }
    while ((localActivity2 == null) || (localActivity2.isFinishing()));
    localActivity2.finish();
    return;
    label239: this.b.q();
  }

  void b(ArrayList<Pair<String, String>> paramArrayList)
  {
    Object localObject1 = null;
    final AdActivity.b localb = AdActivity.b.c;
    Iterator localIterator = paramArrayList.iterator();
    final boolean bool1 = true;
    boolean bool2 = false;
    int i1 = -1;
    int i2 = -1;
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      String str = (String)localPair.first;
      label120: int i3;
      label123: Object localObject2;
      switch (str.hashCode())
      {
      default:
        i3 = -1;
        switch (i3)
        {
        default:
          Clog.e(Clog.mraidLogTag, "expand Invalid parameter::" + (String)localPair.first);
          localObject2 = localObject1;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        break;
      case 119:
      case 104:
      case 1614272768:
      case 116079:
      case 259052981:
      case -315042180:
      }
      while (true)
      {
        localObject1 = localObject2;
        break;
        if (!str.equals("w"))
          break label120;
        i3 = 0;
        break label123;
        if (!str.equals("h"))
          break label120;
        i3 = 1;
        break label123;
        if (!str.equals("useCustomClose"))
          break label120;
        i3 = 2;
        break label123;
        if (!str.equals("url"))
          break label120;
        i3 = 3;
        break label123;
        if (!str.equals("allow_orientation_change"))
          break label120;
        i3 = 4;
        break label123;
        if (!str.equals("force_orientation"))
          break label120;
        i3 = 5;
        break label123;
        try
        {
          int i5 = Integer.parseInt((String)localPair.second);
          i2 = i5;
          localObject2 = localObject1;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localObject2 = localObject1;
        }
        continue;
        try
        {
          int i4 = Integer.parseInt((String)localPair.second);
          i1 = i4;
          localObject2 = localObject1;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localObject2 = localObject1;
        }
        continue;
        bool2 = Boolean.parseBoolean((String)localPair.second);
        localObject2 = localObject1;
        continue;
        localObject2 = Uri.decode((String)localPair.second);
        continue;
        bool1 = Boolean.parseBoolean((String)localPair.second);
        localObject2 = localObject1;
        continue;
        localb = a((String)localPair.second);
        localObject2 = localObject1;
      }
    }
    if (!StringUtil.isEmpty(localObject1));
    while (true)
    {
      try
      {
        this.t = new o(this.b.a, this);
        this.t.a(localObject1);
        this.b.a.a(this.t.c(), bool2, new f.b()
        {
          public void a()
          {
            if (MRAIDImplementation.this.d() != null)
            {
              MRAIDImplementation.a(MRAIDImplementation.this).a(MRAIDImplementation.this.d(), bool1, localb);
              AdView.q = null;
            }
          }
        });
        this.b.e("javascript:window.mraid.util.stateChangeEvent('expanded');");
        this.c = true;
        if (!this.b.a.e())
          this.b.a.getAdDispatcher().a();
        return;
      }
      catch (Exception localException)
      {
        Clog.e(Clog.baseLogTag, "Exception initializing the redirect webview: " + localException.getMessage());
        continue;
      }
      this.b.a(i2, i1, bool2, this, bool1, localb);
    }
  }

  void c()
  {
    boolean bool = this.b.t();
    if (this.j != bool)
      a(bool);
  }

  Activity d()
  {
    return this.o;
  }

  ViewGroup e()
  {
    return this.p;
  }

  public static enum CUSTOM_CLOSE_POSITION
  {
    static
    {
      center = new CUSTOM_CLOSE_POSITION("center", 2);
      bottom_left = new CUSTOM_CLOSE_POSITION("bottom_left", 3);
      bottom_right = new CUSTOM_CLOSE_POSITION("bottom_right", 4);
      top_center = new CUSTOM_CLOSE_POSITION("top_center", 5);
      bottom_center = new CUSTOM_CLOSE_POSITION("bottom_center", 6);
      CUSTOM_CLOSE_POSITION[] arrayOfCUSTOM_CLOSE_POSITION = new CUSTOM_CLOSE_POSITION[7];
      arrayOfCUSTOM_CLOSE_POSITION[0] = top_left;
      arrayOfCUSTOM_CLOSE_POSITION[1] = top_right;
      arrayOfCUSTOM_CLOSE_POSITION[2] = center;
      arrayOfCUSTOM_CLOSE_POSITION[3] = bottom_left;
      arrayOfCUSTOM_CLOSE_POSITION[4] = bottom_right;
      arrayOfCUSTOM_CLOSE_POSITION[5] = top_center;
      arrayOfCUSTOM_CLOSE_POSITION[6] = bottom_center;
    }
  }

  protected static enum MRAID_INIT_STATE
  {
    static
    {
      MRAID_INIT_STATE[] arrayOfMRAID_INIT_STATE = new MRAID_INIT_STATE[2];
      arrayOfMRAID_INIT_STATE[0] = STARTING_DEFAULT;
      arrayOfMRAID_INIT_STATE[1] = STARTING_EXPANDED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.MRAIDImplementation
 * JD-Core Version:    0.6.2
 */