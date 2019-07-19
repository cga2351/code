package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.impl.R.string;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzaxj
{
  public static final Handler zzdvx = new zzaxb(Looper.getMainLooper());

  @GuardedBy("userAgentLock")
  private String zzapq;
  private AtomicReference<Pattern> zzdvv = new AtomicReference(null);
  private AtomicReference<Pattern> zzdvw = new AtomicReference(null);
  private final Object zzdvy = new Object();
  private boolean zzdvz = false;
  private boolean zzdwa = false;
  private boolean zzxt = true;

  private static int zza(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
      return paramChar - '0';
    if ((paramChar >= 'A') && (paramChar <= 'F'))
      return 10 + (paramChar - 'A');
    if ((paramChar >= 'a') && (paramChar <= 'f'))
      return 10 + (paramChar - 'a');
    throw new IllegalArgumentException("Invalid Hex.");
  }

  public static DisplayMetrics zza(WindowManager paramWindowManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  public static PopupWindow zza(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new PopupWindow(paramView, paramInt1, paramInt2, false);
  }

  public static String zza(InputStreamReader paramInputStreamReader)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(8192);
    char[] arrayOfChar = new char[2048];
    while (true)
    {
      int i = paramInputStreamReader.read(arrayOfChar);
      if (i == -1)
        break;
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }

  private final JSONArray zza(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      zza(localJSONArray, localIterator.next());
    return localJSONArray;
  }

  public static void zza(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }
  }

  @TargetApi(18)
  public static void zza(Context paramContext, Uri paramUri)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
      Bundle localBundle = new Bundle();
      localIntent.putExtras(localBundle);
      zzb(paramContext, localIntent);
      localBundle.putString("com.android.browser.application_id", paramContext.getPackageName());
      paramContext.startActivity(localIntent);
      String str = paramUri.toString();
      zzaxa.zzdp(26 + String.valueOf(str).length() + "Opening " + str + " in a new browser.");
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      zzaxa.zzc("No browser is found.", localActivityNotFoundException);
    }
  }

  public static void zza(Context paramContext, Throwable paramThrowable)
  {
    if (paramContext == null);
    while (true)
    {
      return;
      try
      {
        zzaci localzzaci = zzact.zzclg;
        boolean bool2 = ((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue();
        bool1 = bool2;
        if (!bool1)
          continue;
        CrashUtils.addDynamiteErrorToDropBox(paramContext, paramThrowable);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        while (true)
          boolean bool1 = false;
      }
    }
  }

  private final void zza(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(zzd((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(zzi((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(zza((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      JSONArray localJSONArray = new JSONArray();
      int i = arrayOfObject.length;
      for (int j = 0; j < i; j++)
        zza(localJSONArray, arrayOfObject[j]);
      paramJSONArray.put(localJSONArray);
      return;
    }
    paramJSONArray.put(paramObject);
  }

  private final void zza(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, zzd((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, zzi((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null);
      while (true)
      {
        paramJSONObject.put(paramString, zza((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, zza(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }

  private static boolean zza(String paramString1, AtomicReference<Pattern> paramAtomicReference, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return false;
    try
    {
      Pattern localPattern = (Pattern)paramAtomicReference.get();
      if ((localPattern == null) || (!paramString2.equals(localPattern.pattern())))
      {
        localPattern = Pattern.compile(paramString2);
        paramAtomicReference.set(localPattern);
      }
      boolean bool = localPattern.matcher(paramString1).matches();
      return bool;
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
    }
    return false;
  }

  @VisibleForTesting
  protected static String zzam(Context paramContext)
  {
    try
    {
      String str = new WebView(paramContext).getSettings().getUserAgentString();
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return zzwa();
  }

  public static AlertDialog.Builder zzan(Context paramContext)
  {
    return new AlertDialog.Builder(paramContext);
  }

  public static zzace zzao(Context paramContext)
  {
    return new zzace(paramContext);
  }

  public static String zzap(Context paramContext)
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (localActivityManager == null)
        return null;
      List localList = localActivityManager.getRunningTasks(1);
      if ((localList != null) && (!localList.isEmpty()))
      {
        ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localList.get(0);
        if ((localRunningTaskInfo != null) && (localRunningTaskInfo.topActivity != null))
        {
          String str = localRunningTaskInfo.topActivity.getClassName();
          return str;
        }
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static boolean zzaq(Context paramContext)
  {
    int i;
    label149: 
    do
    {
      try
      {
        ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
        if ((localActivityManager != null) && (localKeyguardManager != null))
        {
          List localList = localActivityManager.getRunningAppProcesses();
          if (localList == null)
            return false;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
            if (Process.myPid() == localRunningAppProcessInfo.pid)
              if ((localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
              {
                PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
                if (localPowerManager == null)
                {
                  i = 0;
                  break label149;
                }
                boolean bool = localPowerManager.isScreenOn();
                i = bool;
                break label149;
              }
          }
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
      return false;
    }
    while (i == 0);
    return false;
  }

  public static int zzar(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    if (localApplicationInfo == null)
      return 0;
    return localApplicationInfo.targetSdkVersion;
  }

  private static KeyguardManager zzas(Context paramContext)
  {
    Object localObject = paramContext.getSystemService("keyguard");
    if ((localObject != null) && ((localObject instanceof KeyguardManager)))
      return (KeyguardManager)localObject;
    return null;
  }

  @TargetApi(16)
  public static boolean zzat(Context paramContext)
  {
    if ((paramContext == null) || (!PlatformVersion.isAtLeastJellyBean()));
    KeyguardManager localKeyguardManager;
    do
    {
      return false;
      localKeyguardManager = zzas(paramContext);
    }
    while ((localKeyguardManager == null) || (!localKeyguardManager.isKeyguardLocked()));
    return true;
  }

  public static boolean zzau(Context paramContext)
  {
    try
    {
      paramContext.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2");
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return true;
    }
    catch (Throwable localThrowable)
    {
      zzaxa.zzc("Error loading class.", localThrowable);
      zzk.zzlk().zza(localThrowable, "AdUtil.isLiteSdk");
    }
    return false;
  }

  public static String zzav(Context paramContext)
  {
    zzaci localzzaci = zzact.zzcwm;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return "";
    return paramContext.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
  }

  public static Bundle zzaw(Context paramContext)
  {
    int i = 0;
    zzaci localzzaci = zzact.zzcwn;
    Bundle localBundle;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      localBundle = null;
    while (true)
    {
      return localBundle;
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
      localBundle = new Bundle();
      if (localSharedPreferences.contains("IABConsent_CMPPresent"))
        localBundle.putBoolean("IABConsent_CMPPresent", localSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
      String[] arrayOfString = { "IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents" };
      while (i < 4)
      {
        String str = arrayOfString[i];
        if (localSharedPreferences.contains(str))
          localBundle.putString(str, localSharedPreferences.getString(str, null));
        i++;
      }
    }
  }

  public static boolean zzax(Context paramContext)
  {
    if (!(paramContext instanceof Activity));
    Rect localRect1;
    Rect localRect2;
    do
    {
      Window localWindow;
      do
      {
        return false;
        localWindow = ((Activity)paramContext).getWindow();
      }
      while ((localWindow == null) || (localWindow.getDecorView() == null));
      localRect1 = new Rect();
      localRect2 = new Rect();
      localWindow.getDecorView().getGlobalVisibleRect(localRect1, null);
      localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
    }
    while ((localRect1.bottom == 0) || (localRect2.bottom == 0) || (localRect1.top != localRect2.top));
    return true;
  }

  @TargetApi(18)
  public static void zzb(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null);
    while (!PlatformVersion.isAtLeastJellyBeanMR2())
      return;
    if (paramIntent.getExtras() != null);
    for (Bundle localBundle = paramIntent.getExtras(); ; localBundle = new Bundle())
    {
      localBundle.putBinder("android.support.customtabs.extra.SESSION", null);
      localBundle.putString("com.android.browser.application_id", paramContext.getPackageName());
      paramIntent.putExtras(localBundle);
      return;
    }
  }

  public static void zzb(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(paramString2);
    ArrayList localArrayList2 = (ArrayList)localArrayList1;
    int i = localArrayList2.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList2.get(j);
      j++;
      new zzazj(paramContext, paramString1, (String)localObject).zzvi();
    }
  }

  public static void zzc(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(paramString1, 0);
      localFileOutputStream.write(paramString2.getBytes("UTF-8"));
      localFileOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      zzaxa.zzc("Error writing to file in internal storage.", localException);
    }
  }

  public static WebResourceResponse zzd(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("User-Agent", zzk.zzlg().zzq(paramContext, paramString1));
      localHashMap.put("Cache-Control", "max-stale=3600");
      String str = (String)new zzayv(paramContext).zzc(paramString2, localHashMap).get(60L, TimeUnit.SECONDS);
      if (str != null)
      {
        WebResourceResponse localWebResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str.getBytes("UTF-8")));
        return localWebResourceResponse;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      zzaxa.zzd("Could not fetch MRAID JS.", localInterruptedException);
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      break label108;
    }
    catch (IOException localIOException)
    {
      break label108;
    }
    catch (TimeoutException localTimeoutException)
    {
      label108: break label108;
    }
  }

  public static WebResourceResponse zzd(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    zzk.zzlg();
    String str1 = paramHttpURLConnection.getContentType();
    String str2;
    int i;
    label58: String[] arrayOfString2;
    if (TextUtils.isEmpty(str1))
    {
      str2 = "";
      zzk.zzlg();
      String str3 = paramHttpURLConnection.getContentType();
      if (TextUtils.isEmpty(str3))
        break label273;
      String[] arrayOfString1 = str3.split(";");
      if (arrayOfString1.length == 1)
        break label273;
      i = 1;
      if (i >= arrayOfString1.length)
        break label273;
      if (!arrayOfString1[i].trim().startsWith("charset"))
        break label267;
      arrayOfString2 = arrayOfString1[i].trim().split("=");
      if (arrayOfString2.length <= 1)
        break label267;
    }
    HashMap localHashMap;
    label267: label273: for (String str4 = arrayOfString2[1].trim(); ; str4 = "")
    {
      Map localMap = paramHttpURLConnection.getHeaderFields();
      localHashMap = new HashMap(localMap.size());
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getKey() != null) && (localEntry.getValue() != null) && (((List)localEntry.getValue()).size() > 0))
          localHashMap.put((String)localEntry.getKey(), (String)((List)localEntry.getValue()).get(0));
      }
      str2 = str1.split(";")[0].trim();
      break;
      i++;
      break label58;
    }
    return zzk.zzli().zza(str2, str4, paramHttpURLConnection.getResponseCode(), paramHttpURLConnection.getResponseMessage(), localHashMap, paramHttpURLConnection.getInputStream());
  }

  public static void zzd(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    zzaxh.zzc(paramRunnable);
  }

  public static int[] zzd(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    if (localWindow != null)
    {
      View localView = localWindow.findViewById(16908290);
      if (localView != null)
      {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = localView.getWidth();
        arrayOfInt[1] = localView.getHeight();
        return arrayOfInt;
      }
    }
    return zzwd();
  }

  public static int zzdy(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str = String.valueOf(localNumberFormatException);
      zzaxa.zzep(22 + String.valueOf(str).length() + "Could not parse value:" + str);
    }
    return 0;
  }

  public static boolean zzdz(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
  }

  public static boolean zzec(String paramString)
  {
    if (!zzazy.isEnabled())
      return false;
    zzaci localzzaci1 = zzact.zzcup;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      return false;
    zzaci localzzaci2 = zzact.zzcur;
    String str1 = (String)zzyr.zzpe().zzd(localzzaci2);
    if (!str1.isEmpty())
    {
      String[] arrayOfString2 = str1.split(";");
      int k = arrayOfString2.length;
      for (int m = 0; m < k; m++)
        if (arrayOfString2[m].equals(paramString))
          return false;
    }
    zzaci localzzaci3 = zzact.zzcuq;
    String str2 = (String)zzyr.zzpe().zzd(localzzaci3);
    if (str2.isEmpty())
      return true;
    String[] arrayOfString1 = str2.split(";");
    int i = arrayOfString1.length;
    for (int j = 0; j < i; j++)
      if (arrayOfString1[j].equals(paramString))
        return true;
    return false;
  }

  public static Map<String, String> zzi(Uri paramUri)
  {
    zzaci localzzaci = zzact.zzcwv;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
    {
      if (paramUri == null)
        return null;
      HashMap localHashMap2 = new HashMap();
      zzk.zzli();
      Iterator localIterator = paramUri.getQueryParameterNames().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localHashMap2.put(str2, paramUri.getQueryParameter(str2));
      }
      return localHashMap2;
    }
    if (paramUri == null)
      return null;
    HashMap localHashMap1 = new HashMap(20);
    String str1 = paramUri.getEncodedQuery();
    if (str1 == null)
      return localHashMap1;
    int i = str1.length();
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    StringBuilder localStringBuilder2 = new StringBuilder(i);
    StringBuilder localStringBuilder3 = localStringBuilder1;
    int j = 0;
    label220: byte[] arrayOfByte;
    char c2;
    int k;
    if (j < i)
    {
      char c1 = str1.charAt(j);
      switch (c1)
      {
      default:
        localStringBuilder3.append(c1);
      case '+':
      case '=':
      case '&':
        while (true)
        {
          j++;
          break;
          localStringBuilder3.append(' ');
          continue;
          if (localStringBuilder3 != localStringBuilder2)
          {
            localStringBuilder3 = localStringBuilder2;
          }
          else
          {
            localStringBuilder3.append(c1);
            continue;
            if ((localStringBuilder1.length() > 0) && (localStringBuilder3 != localStringBuilder1))
            {
              localHashMap1.put(localStringBuilder1.toString(), localStringBuilder2.toString());
              localStringBuilder1.setLength(0);
              localStringBuilder2.setLength(0);
            }
            localStringBuilder3 = localStringBuilder1;
          }
        }
      case '%':
      }
      arrayOfByte = new byte[(i - j) / 3];
      c2 = c1;
      k = 0;
    }
    while (true)
      while (true)
      {
        label329: int m;
        if ((j < i - 2) && (c2 == '%'))
          m = j + 1;
        try
        {
          while (true)
          {
            arrayOfByte[k] = ((byte)((zza(str1.charAt(m)) << 4) + zza(str1.charAt(j + 2))));
            k++;
            label383: n = j + 3;
            if (n < i)
            {
              c2 = str1.charAt(n);
              j = n;
              break label329;
              try
              {
                localStringBuilder3.append(new String(arrayOfByte, 0, k, "UTF-8"));
                label432: if (c2 == '%')
                  break label220;
                break;
                if ((localStringBuilder1.length() > 0) && (localStringBuilder3 != localStringBuilder1))
                  localHashMap1.put(localStringBuilder1.toString(), localStringBuilder2.toString());
                return localHashMap1;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                break label432;
              }
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          int n;
          break label383;
          j = n;
        }
      }
  }

  public static Bitmap zzk(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }

  public static Bitmap zzl(View paramView)
  {
    Bitmap localBitmap;
    if (paramView == null)
      localBitmap = null;
    do
    {
      return localBitmap;
      localBitmap = zzn(paramView);
    }
    while (localBitmap != null);
    return zzm(paramView);
  }

  private static Bitmap zzm(View paramView)
  {
    try
    {
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      if ((i == 0) || (j == 0))
      {
        zzaxa.zzep("Width or height of view is zero");
        return null;
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
      Canvas localCanvas = new Canvas(localBitmap);
      paramView.layout(0, 0, i, j);
      paramView.draw(localCanvas);
      return localBitmap;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzaxa.zzc("Fail to capture the webview", localRuntimeException);
    }
    return null;
  }

  // ERROR //
  private static Bitmap zzn(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 891	android/view/View:isDrawingCacheEnabled	()Z
    //   4: istore 4
    //   6: aload_0
    //   7: iconst_1
    //   8: invokevirtual 843	android/view/View:setDrawingCacheEnabled	(Z)V
    //   11: aload_0
    //   12: invokevirtual 847	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnull +39 -> 58
    //   22: aload 5
    //   24: invokestatic 853	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   27: astore 6
    //   29: aload 6
    //   31: astore_2
    //   32: aload_0
    //   33: iload 4
    //   35: invokevirtual 843	android/view/View:setDrawingCacheEnabled	(Z)V
    //   38: aload_2
    //   39: areturn
    //   40: astore_1
    //   41: aconst_null
    //   42: astore_2
    //   43: aload_1
    //   44: astore_3
    //   45: ldc_w 893
    //   48: aload_3
    //   49: invokestatic 215	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   52: aload_2
    //   53: areturn
    //   54: astore_3
    //   55: goto -10 -> 45
    //   58: aconst_null
    //   59: astore_2
    //   60: goto -28 -> 32
    //
    // Exception table:
    //   from	to	target	type
    //   0	17	40	java/lang/RuntimeException
    //   22	29	40	java/lang/RuntimeException
    //   32	38	54	java/lang/RuntimeException
  }

  public static boolean zzo(View paramView)
  {
    View localView = paramView.getRootView();
    Context localContext;
    if (localView != null)
    {
      localContext = localView.getContext();
      if (!(localContext instanceof Activity));
    }
    for (Activity localActivity = (Activity)localContext; localActivity == null; localActivity = null)
      return false;
    Window localWindow = localActivity.getWindow();
    if (localWindow == null);
    for (WindowManager.LayoutParams localLayoutParams = null; (localLayoutParams != null) && ((0x80000 & localLayoutParams.flags) != 0); localLayoutParams = localWindow.getAttributes())
      return true;
    return false;
  }

  public static int zzp(View paramView)
  {
    if (paramView == null)
      return -1;
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (!(localViewParent instanceof AdapterView)); localViewParent = localViewParent.getParent());
    if (localViewParent == null)
      return -1;
    return ((AdapterView)localViewParent).getPositionForView(paramView);
  }

  public static boolean zzp(Context paramContext, String paramString)
  {
    Context localContext = zzasr.zzw(paramContext);
    String str = localContext.getPackageName();
    return Wrappers.packageManager(localContext).checkPermission(paramString, str) == 0;
  }

  public static String zzr(Context paramContext, String paramString)
  {
    try
    {
      String str = new String(IOUtils.readInputStreamFully(paramContext.openFileInput(paramString), true), "UTF-8");
      return str;
    }
    catch (IOException localIOException)
    {
      zzaxa.zzdp("Error reading from internal storage.");
    }
    return "";
  }

  private static String zzwa()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null)
      localStringBuilder.append(" ").append(Build.VERSION.RELEASE);
    localStringBuilder.append("; ").append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuilder.append("; ").append(Build.DEVICE);
      if (Build.DISPLAY != null)
        localStringBuilder.append(" Build/").append(Build.DISPLAY);
    }
    localStringBuilder.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuilder.toString();
  }

  public static String zzwb()
  {
    return UUID.randomUUID().toString();
  }

  public static String zzwc()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1))
      return str2;
    return 1 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " " + str2;
  }

  private static int[] zzwd()
  {
    return new int[] { 0, 0 };
  }

  public static String zzwe()
  {
    Resources localResources = zzk.zzlk().getResources();
    if (localResources != null)
      return localResources.getString(R.string.s7);
    return "Test Ad";
  }

  public final JSONObject zza(Bundle paramBundle, JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramBundle != null);
    try
    {
      JSONObject localJSONObject = zzd(paramBundle);
      localObject = localJSONObject;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzc("Error converting Bundle to JSON", localJSONException);
    }
    return null;
  }

  public final void zza(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(zzq(paramContext, paramString));
  }

  public final void zza(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    zzk.zzlg();
    paramBundle.putString("device", zzwc());
    paramBundle.putString("eids", TextUtils.join(",", zzact.zzqn()));
    zzyr.zzpa();
    zzazu.zza(paramContext, paramString1, paramString2, paramBundle, true, new zzaxm(this, paramContext, paramString1));
  }

  public final void zza(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(false);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", zzq(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(false);
  }

  public final boolean zza(View paramView, Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    PowerManager localPowerManager = null;
    if (localContext != null)
      localPowerManager = (PowerManager)localContext.getSystemService("power");
    return zza(paramView, localPowerManager, zzas(paramContext));
  }

  public final boolean zza(View paramView, PowerManager paramPowerManager, KeyguardManager paramKeyguardManager)
  {
    boolean bool;
    int i;
    if (!zzk.zzlg().zzxt)
    {
      if (paramKeyguardManager == null)
      {
        bool = false;
        if ((bool) && (!zzo(paramView)))
          break label130;
      }
    }
    else
    {
      i = 1;
      label31: if ((paramView.getVisibility() != 0) || (!paramView.isShown()))
        break label142;
      if ((paramPowerManager != null) && (!paramPowerManager.isScreenOn()))
        break label136;
    }
    label130: label136: for (int j = 1; ; j = 0)
    {
      if ((j == 0) || (i == 0))
        break label142;
      zzaci localzzaci = zzact.zzcqi;
      if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (!paramView.getLocalVisibleRect(new Rect())) && (!paramView.getGlobalVisibleRect(new Rect())))
        break label142;
      return true;
      bool = paramKeyguardManager.inKeyguardRestrictedInputMode();
      break;
      i = 0;
      break label31;
    }
    label142: return false;
  }

  public final boolean zzak(Context paramContext)
  {
    if (this.zzdvz)
      return false;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.getApplicationContext().registerReceiver(new zzaxo(this, null), localIntentFilter);
    this.zzdvz = true;
    return true;
  }

  public final boolean zzal(Context paramContext)
  {
    if (this.zzdwa)
      return false;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
    paramContext.getApplicationContext().registerReceiver(new zzaxn(this, null), localIntentFilter);
    this.zzdwa = true;
    return true;
  }

  public final JSONObject zzd(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }

  public final int[] zze(Activity paramActivity)
  {
    int[] arrayOfInt1 = zzd(paramActivity);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = zzyr.zzpa().zzb(paramActivity, arrayOfInt1[0]);
    arrayOfInt2[1] = zzyr.zzpa().zzb(paramActivity, arrayOfInt1[1]);
    return arrayOfInt2;
  }

  public final boolean zzea(String paramString)
  {
    AtomicReference localAtomicReference = this.zzdvv;
    zzaci localzzaci = zzact.zzcnu;
    return zza(paramString, localAtomicReference, (String)zzyr.zzpe().zzd(localzzaci));
  }

  public final boolean zzeb(String paramString)
  {
    AtomicReference localAtomicReference = this.zzdvw;
    zzaci localzzaci = zzact.zzcnv;
    return zza(paramString, localAtomicReference, (String)zzyr.zzpe().zzd(localzzaci));
  }

  public final int[] zzf(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    int[] arrayOfInt1;
    if (localWindow != null)
    {
      View localView = localWindow.findViewById(16908290);
      if (localView != null)
      {
        arrayOfInt1 = new int[2];
        arrayOfInt1[0] = localView.getTop();
        arrayOfInt1[1] = localView.getBottom();
      }
    }
    while (true)
    {
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = zzyr.zzpa().zzb(paramActivity, arrayOfInt1[0]);
      arrayOfInt2[1] = zzyr.zzpa().zzb(paramActivity, arrayOfInt1[1]);
      return arrayOfInt2;
      arrayOfInt1 = zzwd();
    }
  }

  public final JSONObject zzi(Map<String, ?> paramMap)
    throws JSONException
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        zza(localJSONObject, str3, paramMap.get(str3));
      }
    }
    catch (ClassCastException localClassCastException)
    {
      String str1 = String.valueOf(localClassCastException.getMessage());
      if (str1.length() != 0);
      for (String str2 = "Could not convert map to JSON: ".concat(str1); ; str2 = new String("Could not convert map to JSON: "))
        throw new JSONException(str2);
    }
    return localJSONObject;
  }

  public final String zzq(Context paramContext, String paramString)
  {
    synchronized (this.zzdvy)
    {
      if (this.zzapq != null)
      {
        String str7 = this.zzapq;
        return str7;
      }
      if (paramString == null)
      {
        String str1 = zzwa();
        return str1;
      }
    }
    try
    {
      this.zzapq = zzk.zzli().getDefaultUserAgent(paramContext);
      label57: if (TextUtils.isEmpty(this.zzapq))
      {
        zzyr.zzpa();
        if (!zzazu.zzwy())
        {
          this.zzapq = null;
          zzdvx.post(new zzaxl(this, paramContext));
          String str5;
          while (true)
          {
            String str4 = this.zzapq;
            if (str4 != null)
              break label186;
            try
            {
              this.zzdvy.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              this.zzapq = zzwa();
              str5 = String.valueOf(this.zzapq);
              if (str5.length() == 0);
            }
          }
          for (String str6 = "Interrupted, use default user agent: ".concat(str5); ; str6 = new String("Interrupted, use default user agent: "))
          {
            zzaxa.zzep(str6);
            break;
          }
        }
        this.zzapq = zzam(paramContext);
      }
      label186: String str2 = String.valueOf(this.zzapq);
      this.zzapq = (10 + String.valueOf(str2).length() + String.valueOf(paramString).length() + str2 + " (Mobile; " + paramString);
      try
      {
        if (Wrappers.packageManager(paramContext).isCallerInstantApp())
          this.zzapq = String.valueOf(this.zzapq).concat(";aia");
        this.zzapq = String.valueOf(this.zzapq).concat(")");
        String str3 = this.zzapq;
        return str3;
      }
      catch (Exception localException2)
      {
        while (true)
          zzk.zzlk().zza(localException2, "AdUtil.getUserAgent");
      }
    }
    catch (Exception localException1)
    {
      break label57;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxj
 * JD-Core Version:    0.6.2
 */