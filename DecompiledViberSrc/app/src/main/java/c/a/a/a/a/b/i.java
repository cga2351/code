package c.a.a.a.a.b;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import c.a.a.a.c;
import c.a.a.a.l;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class i
{
  public static final Comparator<File> a = new Comparator()
  {
    public int a(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      return (int)(paramAnonymousFile1.lastModified() - paramAnonymousFile2.lastModified());
    }
  };
  private static Boolean b = null;
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static long d = -1L;

  public static int a()
  {
    return a.a().ordinal();
  }

  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, j(paramContext));
  }

  public static int a(Context paramContext, boolean paramBoolean)
  {
    Float localFloat = c(paramContext);
    if ((!paramBoolean) || (localFloat == null))
      return 1;
    if (localFloat.floatValue() >= 99.0D)
      return 3;
    if (localFloat.floatValue() < 99.0D)
      return 2;
    return 0;
  }

  static long a(String paramString1, String paramString2, int paramInt)
  {
    return Long.parseLong(paramString1.split(paramString2)[0].trim()) * paramInt;
  }

  public static ActivityManager.RunningAppProcessInfo a(String paramString, Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.processName.equals(paramString))
          return localRunningAppProcessInfo;
      }
    }
    return null;
  }

  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.crashlytics.prefs", 0);
  }

  public static String a(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("value must be zero or greater");
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return String.format(localLocale, "%1$10s", arrayOfObject).replace(' ', '0');
  }

  // ERROR //
  public static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 185	java/io/File:exists	()Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: iload_2
    //   8: ifeq +80 -> 88
    //   11: new 187	java/io/BufferedReader
    //   14: dup
    //   15: new 189	java/io/FileReader
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 192	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   23: sipush 1024
    //   26: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 198	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore 7
    //   38: aconst_null
    //   39: astore_3
    //   40: aload 7
    //   42: ifnull +39 -> 81
    //   45: ldc 200
    //   47: invokestatic 206	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   50: aload 7
    //   52: iconst_2
    //   53: invokevirtual 209	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;I)[Ljava/lang/String;
    //   56: astore 8
    //   58: aload 8
    //   60: arraylength
    //   61: iconst_1
    //   62: if_icmple -31 -> 31
    //   65: aload 8
    //   67: iconst_0
    //   68: aaload
    //   69: aload_1
    //   70: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifeq -42 -> 31
    //   76: aload 8
    //   78: iconst_1
    //   79: aaload
    //   80: astore_3
    //   81: aload 4
    //   83: ldc 211
    //   85: invokestatic 214	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   88: aload_3
    //   89: areturn
    //   90: astore 5
    //   92: aconst_null
    //   93: astore 4
    //   95: invokestatic 220	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   98: ldc 222
    //   100: new 224	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   107: ldc 227
    //   109: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: aload 5
    //   121: invokeinterface 243 4 0
    //   126: aload 4
    //   128: ldc 211
    //   130: invokestatic 214	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   133: aconst_null
    //   134: areturn
    //   135: astore 9
    //   137: aconst_null
    //   138: astore 4
    //   140: aload 9
    //   142: astore 6
    //   144: aload 4
    //   146: ldc 211
    //   148: invokestatic 214	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   151: aload 6
    //   153: athrow
    //   154: astore 6
    //   156: goto -12 -> 144
    //   159: astore 5
    //   161: goto -66 -> 95
    //
    // Exception table:
    //   from	to	target	type
    //   11	31	90	java/lang/Exception
    //   11	31	135	finally
    //   31	38	154	finally
    //   45	81	154	finally
    //   95	126	154	finally
    //   31	38	159	java/lang/Exception
    //   45	81	159	java/lang/Exception
  }

  public static String a(InputStream paramInputStream)
    throws IOException
  {
    Scanner localScanner = new Scanner(paramInputStream).useDelimiter("\\A");
    if (localScanner.hasNext())
      return localScanner.next();
    return "";
  }

  private static String a(InputStream paramInputStream, String paramString)
  {
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance(paramString);
      byte[] arrayOfByte = new byte[1024];
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        localMessageDigest.update(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      c.g().e("Fabric", "Could not calculate hash for app icon.", localException);
      return "";
    }
    String str = a(localMessageDigest.digest());
    return str;
  }

  public static String a(String paramString)
  {
    return a(paramString, "SHA-1");
  }

  private static String a(String paramString1, String paramString2)
  {
    return a(paramString1.getBytes(), paramString2);
  }

  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = 0xFF & paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = c[(j >>> 4)];
      arrayOfChar[(1 + i * 2)] = c[(j & 0xF)];
    }
    return new String(arrayOfChar);
  }

  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      localMessageDigest.update(paramArrayOfByte);
      return a(localMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      c.g().e("Fabric", "Could not create hashing algorithm: " + paramString + ", returning empty string.", localNoSuchAlgorithmException);
    }
    return "";
  }

  public static String a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return null;
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str2 = paramArrayOfString[j];
      if (str2 != null)
        localArrayList.add(str2.replace("-", "").toLowerCase(Locale.US));
    }
    Collections.sort(localArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
      localStringBuilder.append((String)localIterator.next());
    String str1 = localStringBuilder.toString();
    if (str1.length() > 0)
      return a(str1);
    return null;
  }

  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (e(paramContext))
      c.g().a(paramInt, "Fabric", paramString2);
  }

  public static void a(Context paramContext, String paramString)
  {
    if (e(paramContext))
      c.g().a("Fabric", paramString);
  }

  public static void a(Context paramContext, String paramString, Throwable paramThrowable)
  {
    if (e(paramContext))
      c.g().e("Fabric", paramString);
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(Closeable paramCloseable, String paramString)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      c.g().e("Fabric", paramString, localIOException);
    }
  }

  public static void a(Flushable paramFlushable, String paramString)
  {
    if (paramFlushable != null);
    try
    {
      paramFlushable.flush();
      return;
    }
    catch (IOException localIOException)
    {
      c.g().e("Fabric", paramString, localIOException);
    }
  }

  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    while (true)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i == -1)
        break;
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }

  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      Resources localResources = paramContext.getResources();
      if (localResources != null)
      {
        int i = a(paramContext, paramString, "bool");
        if (i <= 0)
          break label37;
        paramBoolean = localResources.getBoolean(i);
      }
    }
    label37: int j;
    do
    {
      return paramBoolean;
      j = a(paramContext, paramString, "string");
    }
    while (j <= 0);
    return Boolean.parseBoolean(paramContext.getString(j));
  }

  public static long b()
  {
    try
    {
      long l1;
      String str2;
      if (d == -1L)
      {
        l1 = 0L;
        String str1 = a(new File("/proc/meminfo"), "MemTotal");
        if (!TextUtils.isEmpty(str1))
          str2 = str1.toUpperCase(Locale.US);
      }
      try
      {
        if (str2.endsWith("KB"))
        {
          long l3 = a(str2, "KB", 1024);
          l1 = l3;
        }
        while (true)
        {
          d = l1;
          long l2 = d;
          return l2;
          if (str2.endsWith("MB"))
            l1 = a(str2, "MB", 1048576);
          else if (str2.endsWith("GB"))
            l1 = a(str2, "GB", 1073741824);
          else
            c.g().a("Fabric", "Unexpected meminfo format while computing RAM: " + str2);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          c.g().e("Fabric", "Unexpected meminfo format while computing RAM: " + str2, localNumberFormatException);
      }
    }
    finally
    {
    }
  }

  public static long b(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }

  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "?";
    case 7:
      return "A";
    case 3:
      return "D";
    case 6:
      return "E";
    case 4:
      return "I";
    case 2:
      return "V";
    case 5:
    }
    return "W";
  }

  public static String b(Context paramContext, String paramString)
  {
    int i = a(paramContext, paramString, "string");
    if (i > 0)
      return paramContext.getString(i);
    return "";
  }

  public static String b(InputStream paramInputStream)
  {
    return a(paramInputStream, "SHA-1");
  }

  public static String b(String paramString)
  {
    return a(paramString, "SHA-256");
  }

  public static long c(String paramString)
  {
    StatFs localStatFs = new StatFs(paramString);
    long l = localStatFs.getBlockSize();
    return l * localStatFs.getBlockCount() - l * localStatFs.getAvailableBlocks();
  }

  public static Float c(Context paramContext)
  {
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (localIntent == null)
      return null;
    int i = localIntent.getIntExtra("level", -1);
    int j = localIntent.getIntExtra("scale", -1);
    return Float.valueOf(i / j);
  }

  public static boolean c()
  {
    return (Debug.isDebuggerConnected()) || (Debug.waitingForDebugger());
  }

  public static boolean c(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }

  public static boolean d(Context paramContext)
  {
    if (f(paramContext))
      return false;
    if (((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(8) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static boolean d(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  public static boolean e(Context paramContext)
  {
    if (b == null)
      b = Boolean.valueOf(a(paramContext, "com.crashlytics.Trace", false));
    return b.booleanValue();
  }

  public static boolean f(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    return ("sdk".equals(Build.PRODUCT)) || ("google_sdk".equals(Build.PRODUCT)) || (str == null);
  }

  public static boolean g(Context paramContext)
  {
    boolean bool = f(paramContext);
    String str = Build.TAGS;
    if ((!bool) && (str != null) && (str.contains("test-keys")));
    File localFile;
    do
    {
      do
        return true;
      while (new File("/system/app/Superuser.apk").exists());
      localFile = new File("/system/xbin/su");
    }
    while ((!bool) && (localFile.exists()));
    return false;
  }

  public static int h(Context paramContext)
  {
    boolean bool = f(paramContext);
    int i = 0;
    if (bool)
      i = 1;
    if (g(paramContext))
      i |= 2;
    if (c())
      i |= 4;
    return i;
  }

  public static boolean i(Context paramContext)
  {
    return (0x2 & paramContext.getApplicationInfo().flags) != 0;
  }

  public static String j(Context paramContext)
  {
    int i = paramContext.getApplicationContext().getApplicationInfo().icon;
    if (i > 0)
      try
      {
        String str = paramContext.getResources().getResourcePackageName(i);
        return str;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        return paramContext.getPackageName();
      }
    return paramContext.getPackageName();
  }

  // ERROR //
  public static String k(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: aload_0
    //   5: invokestatic 592	c/a/a/a/a/b/i:l	(Landroid/content/Context;)I
    //   8: invokevirtual 596	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   11: astore 5
    //   13: aload 5
    //   15: astore_2
    //   16: aload_2
    //   17: invokestatic 598	c/a/a/a/a/b/i:b	(Ljava/io/InputStream;)Ljava/lang/String;
    //   20: astore 6
    //   22: aload 6
    //   24: invokestatic 600	c/a/a/a/a/b/i:d	(Ljava/lang/String;)Z
    //   27: istore 7
    //   29: aconst_null
    //   30: astore 8
    //   32: iload 7
    //   34: ifeq +13 -> 47
    //   37: aload_2
    //   38: ldc_w 602
    //   41: invokestatic 214	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   44: aload 8
    //   46: areturn
    //   47: aload 6
    //   49: astore 8
    //   51: goto -14 -> 37
    //   54: astore 4
    //   56: aconst_null
    //   57: astore_2
    //   58: invokestatic 220	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   61: ldc 222
    //   63: new 224	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 604
    //   73: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 4
    //   78: invokevirtual 607	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   81: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokeinterface 609 3 0
    //   92: aload_2
    //   93: ldc_w 602
    //   96: invokestatic 214	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_1
    //   105: astore_3
    //   106: aload_2
    //   107: ldc_w 602
    //   110: invokestatic 214	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   113: aload_3
    //   114: athrow
    //   115: astore_3
    //   116: goto -10 -> 106
    //   119: astore 4
    //   121: goto -63 -> 58
    //
    // Exception table:
    //   from	to	target	type
    //   0	13	54	java/lang/Exception
    //   0	13	101	finally
    //   16	29	115	finally
    //   58	92	115	finally
    //   16	29	119	java/lang/Exception
  }

  public static int l(Context paramContext)
  {
    return paramContext.getApplicationContext().getApplicationInfo().icon;
  }

  public static String m(Context paramContext)
  {
    int i = a(paramContext, "io.fabric.android.build_id", "string");
    if (i == 0)
      i = a(paramContext, "com.crashlytics.android.build_id", "string");
    String str = null;
    if (i != 0)
    {
      str = paramContext.getResources().getString(i);
      c.g().a("Fabric", "Build ID is: " + str);
    }
    return str;
  }

  public static String n(Context paramContext)
  {
    int i = a(paramContext, "com.google.firebase.crashlytics.unity_version", "string");
    String str = null;
    if (i != 0)
    {
      str = paramContext.getResources().getString(i);
      c.g().a("Fabric", "Unity Editor version is: " + str);
    }
    return str;
  }

  @SuppressLint({"MissingPermission"})
  public static boolean o(Context paramContext)
  {
    if (c(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
    }
    return true;
  }

  static enum a
  {
    private static final Map<String, a> k;

    static
    {
      a[] arrayOfa = new a[10];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      l = arrayOfa;
      k = new HashMap(4);
      k.put("armeabi-v7a", g);
      k.put("armeabi", f);
      k.put("arm64-v8a", j);
      k.put("x86", a);
    }

    static a a()
    {
      String str1 = Build.CPU_ABI;
      a locala;
      if (TextUtils.isEmpty(str1))
      {
        c.g().a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
        locala = h;
      }
      do
      {
        return locala;
        String str2 = str1.toLowerCase(Locale.US);
        locala = (a)k.get(str2);
      }
      while (locala != null);
      return h;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.i
 * JD-Core Version:    0.6.2
 */