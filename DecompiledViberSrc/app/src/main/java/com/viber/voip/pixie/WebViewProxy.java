package com.viber.voip.pixie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.webkit.WebView;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WebViewProxy
{
  private static final Logger L = ViberEnv.getLogger();

  private static Object getFieldValueSafely(Field paramField, Object paramObject)
    throws IllegalArgumentException, IllegalAccessException
  {
    boolean bool = paramField.isAccessible();
    paramField.setAccessible(true);
    Object localObject = paramField.get(paramObject);
    paramField.setAccessible(bool);
    return localObject;
  }

  public static boolean setProxy(WebView paramWebView, String paramString, int paramInt)
  {
    if (a.g())
      return setProxyL(ViberApplication.getApplication(), paramString, paramInt);
    if (a.d())
      return setProxyKK(paramWebView, paramString, paramInt, "com.viber.voip.ViberApplication");
    if (a.a())
      return setProxyJB(paramWebView, paramString, paramInt);
    return setProxyICS(paramWebView, paramString, paramInt);
  }

  private static boolean setProxyICS(WebView paramWebView, String paramString, int paramInt)
  {
    try
    {
      Class localClass1 = Class.forName("android.webkit.JWebCoreJavaBridge");
      Class[] arrayOfClass1 = new Class[1];
      arrayOfClass1[0] = Class.forName("android.net.ProxyProperties");
      Method localMethod = localClass1.getDeclaredMethod("updateProxy", arrayOfClass1);
      Object localObject1 = getFieldValueSafely(Class.forName("android.webkit.WebView").getDeclaredField("mWebViewCore"), paramWebView);
      Object localObject2 = getFieldValueSafely(Class.forName("android.webkit.WebViewCore").getDeclaredField("mBrowserFrame"), localObject1);
      Object localObject3 = getFieldValueSafely(Class.forName("android.webkit.BrowserFrame").getDeclaredField("sJavaBridge"), localObject2);
      Class localClass2 = Class.forName("android.net.ProxyProperties");
      Class[] arrayOfClass2 = new Class[3];
      arrayOfClass2[0] = String.class;
      arrayOfClass2[1] = Integer.TYPE;
      arrayOfClass2[2] = String.class;
      Constructor localConstructor = localClass2.getConstructor(arrayOfClass2);
      Object[] arrayOfObject1 = new Object[1];
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(paramInt);
      arrayOfObject2[2] = null;
      arrayOfObject1[0] = localConstructor.newInstance(arrayOfObject2);
      localMethod.invoke(localObject3, arrayOfObject1);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private static boolean setProxyJB(WebView paramWebView, String paramString, int paramInt)
  {
    try
    {
      Class localClass1 = Class.forName("android.webkit.WebViewClassic");
      Class[] arrayOfClass1 = new Class[1];
      arrayOfClass1[0] = Class.forName("android.webkit.WebView");
      Object localObject1 = localClass1.getDeclaredMethod("fromWebView", arrayOfClass1).invoke(null, new Object[] { paramWebView });
      Object localObject2 = getFieldValueSafely(Class.forName("android.webkit.WebViewClassic").getDeclaredField("mWebViewCore"), localObject1);
      Object localObject3 = getFieldValueSafely(Class.forName("android.webkit.WebViewCore").getDeclaredField("mBrowserFrame"), localObject2);
      Object localObject4 = getFieldValueSafely(Class.forName("android.webkit.BrowserFrame").getDeclaredField("sJavaBridge"), localObject3);
      Class localClass2 = Class.forName("android.net.ProxyProperties");
      Class[] arrayOfClass2 = new Class[3];
      arrayOfClass2[0] = String.class;
      arrayOfClass2[1] = Integer.TYPE;
      arrayOfClass2[2] = String.class;
      Constructor localConstructor = localClass2.getConstructor(arrayOfClass2);
      Class localClass3 = Class.forName("android.webkit.JWebCoreJavaBridge");
      Class[] arrayOfClass3 = new Class[1];
      arrayOfClass3[0] = Class.forName("android.net.ProxyProperties");
      Method localMethod = localClass3.getDeclaredMethod("updateProxy", arrayOfClass3);
      Object[] arrayOfObject1 = new Object[1];
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(paramInt);
      arrayOfObject2[2] = null;
      arrayOfObject1[0] = localConstructor.newInstance(arrayOfObject2);
      localMethod.invoke(localObject4, arrayOfObject1);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  @SuppressLint({"NewApi"})
  private static boolean setProxyKK(WebView paramWebView, String paramString1, int paramInt, String paramString2)
  {
    Context localContext = paramWebView.getContext().getApplicationContext();
    System.setProperty("http.proxyHost", paramString1);
    System.setProperty("http.proxyPort", paramInt + "");
    System.setProperty("https.proxyHost", paramString1);
    System.setProperty("https.proxyPort", paramInt + "");
    try
    {
      Field localField1 = Class.forName(paramString2).getField("mLoadedApk");
      localField1.setAccessible(true);
      Object localObject1 = localField1.get(localContext);
      Field localField2 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
      localField2.setAccessible(true);
      Iterator localIterator1 = ((Map)localField2.get(localObject1)).values().iterator();
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((Map)localIterator1.next()).keySet().iterator();
        label171: Object localObject2;
        Method localMethod;
        Intent localIntent;
        while (localIterator2.hasNext())
        {
          localObject2 = localIterator2.next();
          Class localClass1 = localObject2.getClass();
          if (localClass1.getName().contains("ProxyChangeListener"))
          {
            localMethod = localClass1.getDeclaredMethod("onReceive", new Class[] { Context.class, Intent.class });
            localIntent = new Intent("android.intent.action.PROXY_CHANGE");
            if (!a.f())
              break label370;
          }
        }
        label370: for (String str = "android.net.ProxyInfo"; ; str = "android.net.ProxyProperties")
        {
          Class localClass2 = Class.forName(str);
          Class[] arrayOfClass = new Class[3];
          arrayOfClass[0] = String.class;
          arrayOfClass[1] = Integer.TYPE;
          arrayOfClass[2] = String.class;
          Constructor localConstructor = localClass2.getConstructor(arrayOfClass);
          localConstructor.setAccessible(true);
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = paramString1;
          arrayOfObject[1] = Integer.valueOf(paramInt);
          arrayOfObject[2] = null;
          localIntent.putExtra("proxy", (Parcelable)localConstructor.newInstance(arrayOfObject));
          localMethod.invoke(localObject2, new Object[] { localContext, localIntent });
          break label171;
          break;
        }
      }
      return true;
    }
    catch (InstantiationException localInstantiationException)
    {
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  public static boolean setProxyL(Context paramContext, String paramString, int paramInt)
  {
    System.setProperty("http.proxyHost", paramString);
    System.setProperty("http.proxyPort", paramInt + "");
    System.setProperty("https.proxyHost", paramString);
    System.setProperty("https.proxyPort", paramInt + "");
    while (true)
    {
      try
      {
        Context localContext = paramContext.getApplicationContext();
        Field localField1 = Class.forName("android.app.Application").getDeclaredField("mLoadedApk");
        localField1.setAccessible(true);
        Object localObject1 = localField1.get(localContext);
        Field localField2 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
        localField2.setAccessible(true);
        Iterator localIterator1 = ((Map)localField2.get(localObject1)).values().iterator();
        if (!localIterator1.hasNext())
          break;
        Iterator localIterator2 = ((Map)localIterator1.next()).keySet().iterator();
        if (localIterator2.hasNext())
        {
          Object localObject2 = localIterator2.next();
          Class localClass1 = localObject2.getClass();
          if (!localClass1.getName().contains("ProxyChangeListener"))
            continue;
          Method localMethod = localClass1.getDeclaredMethod("onReceive", new Class[] { Context.class, Intent.class });
          Intent localIntent = new Intent("android.intent.action.PROXY_CHANGE");
          if (a.g())
            break label381;
          str1 = "android.net.ProxyProperties";
          str2 = "proxy";
          Class localClass2 = Class.forName(str1);
          Class[] arrayOfClass = new Class[3];
          arrayOfClass[0] = String.class;
          arrayOfClass[1] = Integer.TYPE;
          arrayOfClass[2] = String.class;
          Constructor localConstructor = localClass2.getConstructor(arrayOfClass);
          localConstructor.setAccessible(true);
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = Integer.valueOf(paramInt);
          arrayOfObject[2] = null;
          localIntent.putExtra(str2, (Parcelable)localConstructor.newInstance(arrayOfObject));
          localMethod.invoke(localObject2, new Object[] { localContext, localIntent });
          continue;
        }
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      label381: String str1 = "android.net.ProxyInfo";
      String str2 = "android.intent.extra.PROXY_INFO";
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.WebViewProxy
 * JD-Core Version:    0.6.2
 */