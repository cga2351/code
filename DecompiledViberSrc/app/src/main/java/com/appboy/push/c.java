package com.appboy.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.DecoratedCustomViewStyle;
import android.support.v4.app.NotificationCompat.Style;
import android.widget.RemoteViews;
import com.appboy.a.b;
import com.appboy.f.f;
import com.appboy.f.i;
import com.appboy.g;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import java.util.HashMap;
import java.util.Map;

public class c
{
  private static final String a = com.appboy.f.c.a(c.class);
  private static final Integer[] b;
  private static final Map<String, Integer> c = localHashMap;

  static
  {
    Integer[] arrayOfInteger = new Integer[6];
    arrayOfInteger[0] = Integer.valueOf(R.id.com_appboy_story_text_view);
    arrayOfInteger[1] = Integer.valueOf(R.id.com_appboy_story_text_view_container);
    arrayOfInteger[2] = Integer.valueOf(R.id.com_appboy_story_text_view_small);
    arrayOfInteger[3] = Integer.valueOf(R.id.com_appboy_story_text_view_small_container);
    arrayOfInteger[4] = Integer.valueOf(R.id.com_appboy_story_image_view);
    arrayOfInteger[5] = Integer.valueOf(R.id.com_appboy_story_relative_layout);
    b = arrayOfInteger;
    HashMap localHashMap = new HashMap();
    localHashMap.put("start", Integer.valueOf(8388611));
    localHashMap.put("center", Integer.valueOf(17));
    localHashMap.put("end", Integer.valueOf(8388613));
  }

  static int a(Bundle paramBundle)
  {
    for (int i = 0; a(paramBundle, i); i++);
    return i;
  }

  private static PendingIntent a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent("com.appboy.action.STORY_TRAVERSE").setClass(paramContext, d.b());
    if (paramBundle != null)
    {
      paramBundle.putInt("appboy_story_index", paramInt);
      localIntent.putExtras(paramBundle);
    }
    return PendingIntent.getBroadcast(paramContext, f.a(), localIntent, 1073741824);
  }

  private static PendingIntent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent("com.appboy.action.APPBOY_STORY_CLICKED").setClass(paramContext, AppboyNotificationRoutingActivity.class);
    localIntent.putExtra("appboy_action_uri", paramString1);
    localIntent.putExtra("appboy_action_use_webview", paramString2);
    localIntent.putExtra("appboy_story_page_id", paramString3);
    localIntent.putExtra("appboy_campaign_id", paramString4);
    return PendingIntent.getActivity(paramContext, f.a(), localIntent, 1073741824);
  }

  // ERROR //
  public static NotificationCompat.BigPictureStyle a(Context paramContext, Bundle paramBundle1, Bundle paramBundle2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +12 -> 13
    //   4: aload_2
    //   5: ldc 141
    //   7: invokevirtual 145	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_2
    //   16: ldc 141
    //   18: invokevirtual 149	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_3
    //   22: aload_3
    //   23: invokestatic 153	com/appboy/f/i:c	(Ljava/lang/String;)Z
    //   26: ifne -13 -> 13
    //   29: aload_0
    //   30: aload_3
    //   31: invokestatic 159	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   34: getstatic 164	com/appboy/b/a:a	Lcom/appboy/b/a;
    //   37: invokestatic 169	com/appboy/f/b:a	(Landroid/content/Context;Landroid/net/Uri;Lcom/appboy/b/a;)Landroid/graphics/Bitmap;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull -31 -> 13
    //   47: aload 4
    //   49: invokevirtual 174	android/graphics/Bitmap:getWidth	()I
    //   52: aload 4
    //   54: invokevirtual 177	android/graphics/Bitmap:getHeight	()I
    //   57: if_icmple +142 -> 199
    //   60: aload_0
    //   61: invokestatic 180	com/appboy/f/b:a	(Landroid/content/Context;)Landroid/util/DisplayMetrics;
    //   64: astore 11
    //   66: aload 11
    //   68: getfield 185	android/util/DisplayMetrics:densityDpi	I
    //   71: sipush 192
    //   74: invokestatic 188	com/appboy/f/b:a	(II)I
    //   77: istore 12
    //   79: iload 12
    //   81: iconst_2
    //   82: imul
    //   83: istore 13
    //   85: iload 13
    //   87: aload 11
    //   89: getfield 191	android/util/DisplayMetrics:widthPixels	I
    //   92: if_icmple +10 -> 102
    //   95: aload 11
    //   97: getfield 191	android/util/DisplayMetrics:widthPixels	I
    //   100: istore 13
    //   102: aload 4
    //   104: iload 13
    //   106: iload 12
    //   108: iconst_1
    //   109: invokestatic 195	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   112: astore 16
    //   114: aload 16
    //   116: astore 7
    //   118: aload 7
    //   120: ifnonnull +45 -> 165
    //   123: getstatic 20	com/appboy/push/c:a	Ljava/lang/String;
    //   126: ldc 197
    //   128: invokestatic 200	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aconst_null
    //   133: areturn
    //   134: astore 5
    //   136: getstatic 20	com/appboy/push/c:a	Ljava/lang/String;
    //   139: ldc 202
    //   141: aload 5
    //   143: invokestatic 206	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   146: pop
    //   147: aconst_null
    //   148: areturn
    //   149: astore 14
    //   151: getstatic 20	com/appboy/push/c:a	Ljava/lang/String;
    //   154: ldc 208
    //   156: aload 14
    //   158: invokestatic 206	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   161: pop
    //   162: goto +37 -> 199
    //   165: new 210	android/support/v4/app/NotificationCompat$BigPictureStyle
    //   168: dup
    //   169: invokespecial 211	android/support/v4/app/NotificationCompat$BigPictureStyle:<init>	()V
    //   172: astore 8
    //   174: aload 8
    //   176: aload 7
    //   178: invokevirtual 215	android/support/v4/app/NotificationCompat$BigPictureStyle:bigPicture	(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$BigPictureStyle;
    //   181: pop
    //   182: new 217	com/appboy/a/b
    //   185: dup
    //   186: aload_0
    //   187: invokespecial 220	com/appboy/a/b:<init>	(Landroid/content/Context;)V
    //   190: aload 8
    //   192: aload_1
    //   193: invokestatic 223	com/appboy/push/c:a	(Lcom/appboy/a/b;Landroid/support/v4/app/NotificationCompat$BigPictureStyle;Landroid/os/Bundle;)V
    //   196: aload 8
    //   198: areturn
    //   199: aload 4
    //   201: astore 7
    //   203: goto -85 -> 118
    //
    // Exception table:
    //   from	to	target	type
    //   47	79	134	java/lang/Exception
    //   85	102	134	java/lang/Exception
    //   123	132	134	java/lang/Exception
    //   151	162	134	java/lang/Exception
    //   165	196	134	java/lang/Exception
    //   102	114	149	java/lang/Exception
  }

  public static NotificationCompat.BigTextStyle a(b paramb, Bundle paramBundle)
  {
    Object localObject = null;
    NotificationCompat.BigTextStyle localBigTextStyle;
    if (paramBundle != null)
    {
      localBigTextStyle = new NotificationCompat.BigTextStyle();
      localBigTextStyle.bigText(com.appboy.push.a.a.a(paramb, paramBundle.getString("a")));
      if (!paramBundle.containsKey("ab_bs"))
        break label106;
    }
    label106: for (String str1 = paramBundle.getString("ab_bs"); ; str1 = null)
    {
      boolean bool = paramBundle.containsKey("ab_bt");
      String str2 = null;
      if (bool)
        str2 = paramBundle.getString("ab_bt");
      if (str1 != null)
        localBigTextStyle.setSummaryText(com.appboy.push.a.a.a(paramb, str1));
      if (str2 != null)
        localBigTextStyle.setBigContentTitle(com.appboy.push.a.a.a(paramb, str2));
      localObject = localBigTextStyle;
      return localObject;
    }
  }

  public static NotificationCompat.DecoratedCustomViewStyle a(Context paramContext, Bundle paramBundle, NotificationCompat.Builder paramBuilder)
  {
    NotificationCompat.DecoratedCustomViewStyle localDecoratedCustomViewStyle = new NotificationCompat.DecoratedCustomViewStyle();
    int i = a(paramBundle);
    int j = b(paramBundle);
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.com_appboy_notification_story_one_image);
    if (!a(localRemoteViews, paramContext, paramBundle, j))
    {
      com.appboy.f.c.d(a, "Push story page was not populated correctly. Not using DecoratedCustomViewStyle.");
      return null;
    }
    PendingIntent localPendingIntent1 = a(paramContext, paramBundle, (i + (j - 1)) % i);
    localRemoteViews.setOnClickPendingIntent(R.id.com_appboy_story_button_previous, localPendingIntent1);
    PendingIntent localPendingIntent2 = a(paramContext, paramBundle, (j + 1) % i);
    localRemoteViews.setOnClickPendingIntent(R.id.com_appboy_story_button_next, localPendingIntent2);
    paramBuilder.setCustomBigContentView(localRemoteViews);
    paramBuilder.setOnlyAlertOnce(true);
    return localDecoratedCustomViewStyle;
  }

  public static NotificationCompat.Style a(Context paramContext, Bundle paramBundle1, Bundle paramBundle2, NotificationCompat.Builder paramBuilder)
  {
    Object localObject;
    if (paramBundle1.containsKey("ab_c"))
    {
      com.appboy.f.c.b(a, "Rendering push notification with DecoratedCustomViewStyle (Story)");
      localObject = a(paramContext, paramBundle1, paramBuilder);
    }
    while (true)
    {
      if (localObject == null)
      {
        com.appboy.f.c.b(a, "Rendering push notification with BigTextStyle");
        localObject = a(new b(paramContext), paramBundle1);
      }
      return localObject;
      localObject = null;
      if (paramBundle2 != null)
      {
        boolean bool = paramBundle2.containsKey("appboy_image_url");
        localObject = null;
        if (bool)
        {
          com.appboy.f.c.b(a, "Rendering push notification with BigPictureStyle");
          localObject = a(paramContext, paramBundle1, paramBundle2);
        }
      }
    }
  }

  static void a(b paramb, NotificationCompat.BigPictureStyle paramBigPictureStyle, Bundle paramBundle)
  {
    if (paramBundle.containsKey("ab_bs"));
    for (String str1 = paramBundle.getString("ab_bs"); ; str1 = null)
    {
      boolean bool = paramBundle.containsKey("ab_bt");
      String str2 = null;
      if (bool)
        str2 = paramBundle.getString("ab_bt");
      if (str1 != null)
        paramBigPictureStyle.setSummaryText(com.appboy.push.a.a.a(paramb, str1));
      if (str2 != null)
        paramBigPictureStyle.setBigContentTitle(com.appboy.push.a.a.a(paramb, str2));
      if ((paramBundle.getString("s") == null) && (str1 == null))
        paramBigPictureStyle.setSummaryText(com.appboy.push.a.a.a(paramb, paramBundle.getString("a")));
      return;
    }
  }

  static boolean a(Bundle paramBundle, int paramInt)
  {
    return a.a(paramInt, paramBundle, "ab_c*_i", null) != null;
  }

  private static boolean a(RemoteViews paramRemoteViews, Context paramContext, Bundle paramBundle, int paramInt)
  {
    b localb = new b(paramContext);
    String str1 = paramBundle.getString("cid");
    String str2 = a.a(paramInt, paramBundle, "ab_c*_t");
    if (!i.c(str2))
    {
      paramRemoteViews.setTextViewText(b[0].intValue(), com.appboy.push.a.a.a(localb, str2));
      String str7 = a.a(paramInt, paramBundle, "ab_c*_t_j", "center");
      int j = ((Integer)c.get(str7)).intValue();
      paramRemoteViews.setInt(b[1].intValue(), "setGravity", j);
      String str3 = a.a(paramInt, paramBundle, "ab_c*_st");
      if (i.c(str3))
        break label244;
      paramRemoteViews.setTextViewText(b[2].intValue(), com.appboy.push.a.a.a(localb, str3));
      String str6 = a.a(paramInt, paramBundle, "ab_c*_st_j", "center");
      int i = ((Integer)c.get(str6)).intValue();
      paramRemoteViews.setInt(b[3].intValue(), "setGravity", i);
    }
    Bitmap localBitmap;
    while (true)
    {
      String str4 = a.a(paramInt, paramBundle, "ab_c*_i");
      localBitmap = com.appboy.a.a(paramContext).h().a(paramContext, str4, com.appboy.b.a.c);
      if (localBitmap != null)
        break label264;
      return false;
      paramRemoteViews.setInt(b[1].intValue(), "setVisibility", 8);
      break;
      label244: paramRemoteViews.setInt(b[3].intValue(), "setVisibility", 8);
    }
    label264: paramRemoteViews.setImageViewBitmap(b[4].intValue(), localBitmap);
    String str5 = a.a(paramInt, paramBundle, "ab_c*_id", "");
    PendingIntent localPendingIntent = a(paramContext, a.a(paramInt, paramBundle, "ab_c*_uri"), a.a(paramInt, paramBundle, "ab_c*_use_webview"), str5, str1);
    paramRemoteViews.setOnClickPendingIntent(b[5].intValue(), localPendingIntent);
    return true;
  }

  static int b(Bundle paramBundle)
  {
    if (!paramBundle.containsKey("appboy_story_index"))
      return 0;
    return paramBundle.getInt("appboy_story_index");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.push.c
 * JD-Core Version:    0.6.2
 */