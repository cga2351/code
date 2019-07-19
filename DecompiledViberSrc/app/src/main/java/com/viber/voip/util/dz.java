package com.viber.voip.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.viber.common.b.h;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.p;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.pixie.PixieController.PixieReadyListener;
import com.viber.voip.pixie.WebViewProxy;
import com.viber.voip.settings.d.ad;
import com.viber.voip.widget.ViberWebView;

public class dz
{
  private static final Logger a = ViberEnv.getLogger();

  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("Dalvik/1.6.0 (Linux; U; Android ");
    String str1 = Build.VERSION.RELEASE;
    if (str1.length() > 0);
    while (true)
    {
      localStringBuilder.append(str1);
      localStringBuilder.append("/Viber " + p.d() + " ");
      if ("REL".equals(Build.VERSION.CODENAME))
      {
        String str3 = Build.MODEL;
        if (str3.length() > 0)
        {
          localStringBuilder.append("; ");
          localStringBuilder.append(str3);
        }
      }
      String str2 = Build.ID;
      if (str2.length() > 0)
        localStringBuilder.append(str2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      str1 = "1.0";
    }
  }

  public static String a(Context paramContext)
  {
    String str = d.ad.a.d();
    if (da.a(str))
    {
      str = b(paramContext);
      if (!da.a(str))
        d.ad.a.a(str);
    }
    return str;
  }

  public static void a(Activity paramActivity, final Intent paramIntent, final int paramInt)
  {
    a(paramActivity, new Intent[] { paramIntent }, new Runnable()
    {
      public void run()
      {
        this.a.startActivityForResult(paramIntent, paramInt);
      }
    });
  }

  public static void a(Activity paramActivity, Fragment paramFragment, final Intent paramIntent, final int paramInt)
  {
    a(paramActivity, new Intent[] { paramIntent }, new Runnable()
    {
      public void run()
      {
        this.a.startActivityForResult(paramIntent, paramInt);
      }
    });
  }

  public static void a(Context paramContext, final Intent paramIntent)
  {
    a(paramContext, new Intent[] { paramIntent }, new Runnable()
    {
      public void run()
      {
        this.a.startActivity(paramIntent);
      }
    });
  }

  private static void a(Context paramContext, Intent[] paramArrayOfIntent, final Runnable paramRunnable)
  {
    ViberEnv.getPixieController().addReadyListener(new PixieController.PixieReadyListener()
    {
      public void onReady()
      {
        int i = 0;
        boolean bool = ViberEnv.getPixieController().useLocalProxy();
        if (bool);
        for (int j = ViberEnv.getPixieController().getLocalProxyPort(); ; j = 0)
        {
          Intent[] arrayOfIntent = this.a;
          int k = arrayOfIntent.length;
          while (i < k)
          {
            Intent localIntent = arrayOfIntent[i];
            localIntent.putExtra("use_local_proxy", bool);
            if (bool)
              localIntent.putExtra("local_proxy_port", j);
            i++;
          }
          paramRunnable.run();
          return;
        }
      }
    });
  }

  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("in_place_proxy_config", true);
  }

  public static void a(Intent paramIntent, final ViberWebView paramViberWebView)
  {
    final boolean[] arrayOfBoolean = new boolean[1];
    ViberEnv.getPixieController().addReadyListener(new PixieController.PixieReadyListener()
    {
      public void onReady()
      {
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            boolean bool = ViberEnv.getPixieController().useLocalProxy();
            dz.5.this.a.putExtra("use_local_proxy", bool);
            if (bool)
            {
              int i = ViberEnv.getPixieController().getLocalProxyPort();
              dz.5.this.a.putExtra("local_proxy_port", i);
            }
            dz.b(dz.5.this.a, dz.5.this.b);
            dz.5.this.c[0] = true;
          }
        });
      }
    });
    c(paramViberWebView);
    if ((paramIntent.hasExtra("use_local_proxy")) && (arrayOfBoolean[0] == 0))
      c(paramIntent, paramViberWebView);
  }

  public static boolean a(WebView paramWebView)
  {
    return (paramWebView != null) && (paramWebView.canGoBack()) && (a(paramWebView.getUrl()));
  }

  public static boolean a(String paramString)
  {
    return (!da.a(paramString)) && (!"about:blank".equals(paramString));
  }

  private static String b(Context paramContext)
  {
    if (a.b())
      return d(paramContext);
    if (a.a())
      return e(paramContext);
    return c(paramContext);
  }

  public static String b(WebView paramWebView)
  {
    return paramWebView.getSettings().getUserAgentString() + " " + "Viber" + "/" + p.d();
  }

  // ERROR //
  private static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 193
    //   2: iconst_2
    //   3: anewarray 204	java/lang/Class
    //   6: dup
    //   7: iconst_0
    //   8: ldc 206
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: ldc 162
    //   15: aastore
    //   16: invokevirtual 210	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   19: astore_2
    //   20: aload_2
    //   21: iconst_1
    //   22: invokevirtual 216	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   25: aload_2
    //   26: iconst_2
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aconst_null
    //   37: aastore
    //   38: invokevirtual 220	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   41: checkcast 193	android/webkit/WebSettings
    //   44: invokevirtual 196	android/webkit/WebSettings:getUserAgentString	()Ljava/lang/String;
    //   47: astore 4
    //   49: aload_2
    //   50: iconst_0
    //   51: invokevirtual 216	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   54: aload 4
    //   56: areturn
    //   57: astore_3
    //   58: aload_2
    //   59: iconst_0
    //   60: invokevirtual 216	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   63: aload_3
    //   64: athrow
    //   65: astore_1
    //   66: ldc 222
    //   68: areturn
    //   69: astore 5
    //   71: aload 4
    //   73: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   25	49	57	finally
    //   0	25	65	java/lang/Exception
    //   58	65	65	java/lang/Exception
    //   49	54	69	java/lang/Exception
  }

  private static void c(Intent paramIntent, ViberWebView paramViberWebView)
  {
    if (paramIntent.getBooleanExtra("use_local_proxy", false))
    {
      WebViewProxy.setProxy(paramViberWebView, "127.0.0.1", paramIntent.getIntExtra("local_proxy_port", 0));
      paramViberWebView.a();
    }
    while (!paramIntent.hasExtra("use_local_proxy"))
      return;
    paramViberWebView.a();
  }

  private static void c(WebView paramWebView)
  {
    if (da.a(d.ad.a.d()))
    {
      String str = paramWebView.getSettings().getUserAgentString();
      if (!da.a(str))
        d.ad.a.a(str);
    }
  }

  @TargetApi(17)
  private static String d(Context paramContext)
  {
    try
    {
      String str = WebSettings.getDefaultUserAgent(paramContext);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  // ERROR //
  private static String e(Context paramContext)
  {
    // Byte code:
    //   0: ldc 254
    //   2: invokestatic 258	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: iconst_2
    //   6: anewarray 204	java/lang/Class
    //   9: dup
    //   10: iconst_0
    //   11: ldc 206
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: ldc_w 260
    //   19: invokestatic 258	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: aastore
    //   23: invokevirtual 210	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   26: astore_2
    //   27: aload_2
    //   28: iconst_1
    //   29: invokevirtual 216	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   32: aload_2
    //   33: iconst_2
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aconst_null
    //   44: aastore
    //   45: invokevirtual 220	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 193	android/webkit/WebSettings
    //   51: invokevirtual 196	android/webkit/WebSettings:getUserAgentString	()Ljava/lang/String;
    //   54: astore 4
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 216	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   61: aload 4
    //   63: areturn
    //   64: astore_3
    //   65: aload_2
    //   66: iconst_0
    //   67: invokevirtual 216	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   70: aload_3
    //   71: athrow
    //   72: astore_1
    //   73: ldc 222
    //   75: areturn
    //   76: astore 5
    //   78: aload 4
    //   80: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   32	56	64	finally
    //   0	32	72	java/lang/Exception
    //   65	72	72	java/lang/Exception
    //   56	61	76	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dz
 * JD-Core Version:    0.6.2
 */