package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util
{
  private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
  public static final DecimalFormat SecondsDisplayFormat = newLocalDecimalFormat();
  public static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z", Locale.US);
  private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";

  public static boolean checkPermission(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }

  public static String convertToHex(byte[] paramArrayOfByte)
  {
    BigInteger localBigInteger = new BigInteger(1, paramArrayOfByte);
    return formatString("%0" + (paramArrayOfByte.length << 1) + "x", new Object[] { localBigInteger });
  }

  protected static String createUuid()
  {
    return UUID.randomUUID().toString();
  }

  public static boolean equalBoolean(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    return equalObject(paramBoolean1, paramBoolean2);
  }

  public static boolean equalEnum(Enum paramEnum1, Enum paramEnum2)
  {
    return equalObject(paramEnum1, paramEnum2);
  }

  public static boolean equalInt(Integer paramInteger1, Integer paramInteger2)
  {
    return equalObject(paramInteger1, paramInteger2);
  }

  public static boolean equalLong(Long paramLong1, Long paramLong2)
  {
    return equalObject(paramLong1, paramLong2);
  }

  public static boolean equalObject(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null))
      return (paramObject1 == null) && (paramObject2 == null);
    return paramObject1.equals(paramObject2);
  }

  public static boolean equalString(String paramString1, String paramString2)
  {
    return equalObject(paramString1, paramString2);
  }

  public static boolean equalsDouble(Double paramDouble1, Double paramDouble2)
  {
    if ((paramDouble1 == null) || (paramDouble2 == null))
      if ((paramDouble1 != null) || (paramDouble2 != null));
    while (Double.doubleToLongBits(paramDouble1.doubleValue()) == Double.doubleToLongBits(paramDouble2.doubleValue()))
    {
      return true;
      return false;
    }
    return false;
  }

  public static String formatString(String paramString, Object[] paramArrayOfObject)
  {
    return String.format(Locale.US, paramString, paramArrayOfObject);
  }

  public static String getAndroidId(Context paramContext)
  {
    return AndroidIdUtil.getAndroidId(paramContext);
  }

  public static int getConnectivityType(Context paramContext)
  {
    try
    {
      int i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType();
      return i;
    }
    catch (Exception localException)
    {
      ILogger localILogger = getLogger();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localException.getMessage();
      localILogger.warn("Couldn't read connectivity type (%s)", arrayOfObject);
    }
    return -1;
  }

  public static String getCpuAbi()
  {
    if (Build.VERSION.SDK_INT < 21)
      return Build.CPU_ABI;
    return null;
  }

  public static String getFireAdvertisingId(ContentResolver paramContentResolver)
  {
    if (paramContentResolver == null)
      return null;
    try
    {
      String str = Settings.Secure.getString(paramContentResolver, "advertising_id");
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Boolean getFireTrackingEnabled(ContentResolver paramContentResolver)
  {
    try
    {
      if (Settings.Secure.getInt(paramContentResolver, "limit_ad_tracking") == 0);
      for (boolean bool = true; ; bool = false)
      {
        Boolean localBoolean = Boolean.valueOf(bool);
        return localBoolean;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static void getGoogleAdId(Context paramContext, OnDeviceIdsRead paramOnDeviceIdsRead)
  {
    ILogger localILogger = AdjustFactory.getLogger();
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      localILogger.debug("GoogleAdId being read in the background", new Object[0]);
      String str = getPlayAdId(paramContext);
      localILogger.debug("GoogleAdId read " + str, new Object[0]);
      paramOnDeviceIdsRead.onGoogleAdIdRead(str);
      return;
    }
    localILogger.debug("GoogleAdId being read in the foreground", new Object[0]);
    new AsyncTask()
    {
      protected String a(Context[] paramAnonymousArrayOfContext)
      {
        ILogger localILogger = AdjustFactory.getLogger();
        String str = Util.getPlayAdId(paramAnonymousArrayOfContext[0]);
        localILogger.debug("GoogleAdId read " + str, new Object[0]);
        return str;
      }

      protected void a(String paramAnonymousString)
      {
        AdjustFactory.getLogger();
        this.a.onGoogleAdIdRead(paramAnonymousString);
      }
    }
    .execute(new Context[] { paramContext });
  }

  public static Locale getLocale(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = paramConfiguration.getLocales();
      if ((localLocaleList != null) && (!localLocaleList.isEmpty()))
        return localLocaleList.get(0);
    }
    if (Build.VERSION.SDK_INT < 24)
      return paramConfiguration.locale;
    return null;
  }

  private static ILogger getLogger()
  {
    return AdjustFactory.getLogger();
  }

  public static String getMacAddress(Context paramContext)
  {
    return MacAddressUtil.getMacAddress(paramContext);
  }

  public static String getMcc(Context paramContext)
  {
    try
    {
      String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
      if (TextUtils.isEmpty(str1))
      {
        AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MCC", new Object[0]);
        return null;
      }
      String str2 = str1.substring(0, 3);
      return str2;
    }
    catch (Exception localException)
    {
      AdjustFactory.getLogger().warn("Couldn't return mcc", new Object[0]);
    }
    return null;
  }

  public static String getMnc(Context paramContext)
  {
    try
    {
      String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
      if (TextUtils.isEmpty(str1))
      {
        AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MNC", new Object[0]);
        return null;
      }
      String str2 = str1.substring(3);
      return str2;
    }
    catch (Exception localException)
    {
      AdjustFactory.getLogger().warn("Couldn't return mnc", new Object[0]);
    }
    return null;
  }

  public static int getNetworkType(Context paramContext)
  {
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
      return i;
    }
    catch (Exception localException)
    {
      ILogger localILogger = getLogger();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localException.getMessage();
      localILogger.warn("Couldn't read network type (%s)", arrayOfObject);
    }
    return -1;
  }

  public static String getPlayAdId(Context paramContext)
  {
    return Reflection.getPlayAdId(paramContext);
  }

  public static String getReasonString(String paramString, Throwable paramThrowable)
  {
    if (paramThrowable != null)
      return formatString("%s: %s", new Object[] { paramString, paramThrowable });
    return formatString("%s", new Object[] { paramString });
  }

  public static String getRootCause(Exception paramException)
  {
    if (!hasRootCause(paramException))
      return null;
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    String str = localStringWriter.toString();
    int i = str.indexOf("Caused by:");
    return str.substring(i, str.indexOf("\n", i));
  }

  private static String getSdkPrefix(String paramString)
  {
    if (paramString == null);
    String[] arrayOfString;
    do
    {
      do
        return null;
      while (!paramString.contains("@"));
      arrayOfString = paramString.split("@");
    }
    while ((arrayOfString == null) || (arrayOfString.length != 2));
    return arrayOfString[0];
  }

  public static String getSdkPrefixPlatform(String paramString)
  {
    String str = getSdkPrefix(paramString);
    if (str == null);
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = str.split("\\d+", 2);
    }
    while ((arrayOfString == null) || (arrayOfString.length == 0));
    return arrayOfString[0];
  }

  public static String[] getSupportedAbis()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return Build.SUPPORTED_ABIS;
    return null;
  }

  public static long getWaitingTime(int paramInt, BackoffStrategy paramBackoffStrategy)
  {
    if (paramInt < paramBackoffStrategy.minRetries)
      return 0L;
    long l = Math.min(()Math.pow(2.0D, paramInt - paramBackoffStrategy.minRetries) * paramBackoffStrategy.milliSecondMultiplier, paramBackoffStrategy.maxWait);
    return ()(randomInRange(paramBackoffStrategy.minRange, paramBackoffStrategy.maxRange) * l);
  }

  public static boolean hasRootCause(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString().contains("Caused by:");
  }

  public static String hash(String paramString1, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = paramString1.getBytes("UTF-8");
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString2);
      localMessageDigest.update(arrayOfByte, 0, arrayOfByte.length);
      String str = convertToHex(localMessageDigest.digest());
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static int hashBoolean(Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return 0;
    return paramBoolean.hashCode();
  }

  public static int hashEnum(Enum paramEnum)
  {
    if (paramEnum == null)
      return 0;
    return paramEnum.hashCode();
  }

  public static int hashLong(Long paramLong)
  {
    if (paramLong == null)
      return 0;
    return paramLong.hashCode();
  }

  public static int hashObject(Object paramObject)
  {
    if (paramObject == null)
      return 0;
    return paramObject.hashCode();
  }

  public static int hashString(String paramString)
  {
    if (paramString == null)
      return 0;
    return paramString.hashCode();
  }

  public static Boolean isPlayTrackingEnabled(Context paramContext)
  {
    return Reflection.isPlayTrackingEnabled(paramContext);
  }

  public static boolean isValidParameter(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      getLogger().error("%s parameter %s is missing", new Object[] { paramString3, paramString2 });
      return false;
    }
    if (paramString1.equals(""))
    {
      getLogger().error("%s parameter %s is empty", new Object[] { paramString3, paramString2 });
      return false;
    }
    return true;
  }

  public static String md5(String paramString)
  {
    return hash(paramString, "MD5");
  }

  public static Map<String, String> mergeParameters(Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString)
  {
    if (paramMap1 == null)
      return paramMap2;
    if (paramMap2 == null)
      return paramMap1;
    HashMap localHashMap = new HashMap(paramMap1);
    ILogger localILogger = getLogger();
    Iterator localIterator = paramMap2.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localHashMap.put(localEntry.getKey(), localEntry.getValue());
      if (str != null)
      {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = localEntry.getKey();
        arrayOfObject[1] = str;
        arrayOfObject[2] = paramString;
        arrayOfObject[3] = localEntry.getValue();
        localILogger.warn("Key %s with value %s from %s parameter was replaced by value %s", arrayOfObject);
      }
    }
    return localHashMap;
  }

  private static DecimalFormat newLocalDecimalFormat()
  {
    return new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US));
  }

  public static String quote(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (!Pattern.compile("\\s").matcher(paramString).find())
      return paramString;
    return formatString("'%s'", new Object[] { paramString });
  }

  private static double randomInRange(double paramDouble1, double paramDouble2)
  {
    Random localRandom = new Random();
    return paramDouble1 + (paramDouble2 - paramDouble1) * localRandom.nextDouble();
  }

  public static boolean readBooleanField(ObjectInputStream.GetField paramGetField, String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = paramGetField.get(paramString, paramBoolean);
      return bool;
    }
    catch (Exception localException)
    {
      ILogger localILogger = getLogger();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = localException.getMessage();
      localILogger.debug("Unable to read '%s' field in migration device with message (%s)", arrayOfObject);
    }
    return paramBoolean;
  }

  public static int readIntField(ObjectInputStream.GetField paramGetField, String paramString, int paramInt)
  {
    try
    {
      int i = paramGetField.get(paramString, paramInt);
      return i;
    }
    catch (Exception localException)
    {
      ILogger localILogger = getLogger();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = localException.getMessage();
      localILogger.debug("Unable to read '%s' field in migration device with message (%s)", arrayOfObject);
    }
    return paramInt;
  }

  public static long readLongField(ObjectInputStream.GetField paramGetField, String paramString, long paramLong)
  {
    try
    {
      long l = paramGetField.get(paramString, paramLong);
      return l;
    }
    catch (Exception localException)
    {
      ILogger localILogger = getLogger();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = localException.getMessage();
      localILogger.debug("Unable to read '%s' field in migration device with message (%s)", arrayOfObject);
    }
    return paramLong;
  }

  // ERROR //
  public static <T> T readObject(Context paramContext, String paramString1, String paramString2, java.lang.Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 572	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   5: astore 11
    //   7: aload 11
    //   9: astore 7
    //   11: new 574	java/io/BufferedInputStream
    //   14: dup
    //   15: aload 7
    //   17: invokespecial 577	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 12
    //   22: new 579	java/io/ObjectInputStream
    //   25: dup
    //   26: aload 12
    //   28: invokespecial 580	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore 7
    //   33: aload_3
    //   34: aload 7
    //   36: invokevirtual 582	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   39: invokevirtual 588	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: astore 28
    //   44: aload 28
    //   46: astore 5
    //   48: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   51: ldc_w 590
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_2
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload 5
    //   66: aastore
    //   67: invokeinterface 218 3 0
    //   72: aload 7
    //   74: ifnull +10 -> 84
    //   77: aload 7
    //   79: invokeinterface 595 1 0
    //   84: aload 5
    //   86: areturn
    //   87: astore 24
    //   89: aconst_null
    //   90: astore 5
    //   92: aload 24
    //   94: astore 25
    //   96: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   99: astore 26
    //   101: iconst_2
    //   102: anewarray 4	java/lang/Object
    //   105: astore 27
    //   107: aload 27
    //   109: iconst_0
    //   110: aload_2
    //   111: aastore
    //   112: aload 27
    //   114: iconst_1
    //   115: aload 25
    //   117: invokevirtual 596	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   120: aastore
    //   121: aload 26
    //   123: ldc_w 598
    //   126: aload 27
    //   128: invokeinterface 454 3 0
    //   133: goto -61 -> 72
    //   136: astore 19
    //   138: aload 7
    //   140: astore 6
    //   142: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   145: ldc_w 600
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload_2
    //   155: aastore
    //   156: invokeinterface 218 3 0
    //   161: aload 6
    //   163: astore 7
    //   165: goto -93 -> 72
    //   168: astore 20
    //   170: aconst_null
    //   171: astore 5
    //   173: aload 20
    //   175: astore 21
    //   177: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   180: astore 22
    //   182: iconst_2
    //   183: anewarray 4	java/lang/Object
    //   186: astore 23
    //   188: aload 23
    //   190: iconst_0
    //   191: aload_2
    //   192: aastore
    //   193: aload 23
    //   195: iconst_1
    //   196: aload 21
    //   198: invokevirtual 601	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   201: aastore
    //   202: aload 22
    //   204: ldc_w 603
    //   207: aload 23
    //   209: invokeinterface 454 3 0
    //   214: goto -142 -> 72
    //   217: astore 18
    //   219: aload 5
    //   221: astore 10
    //   223: aload 18
    //   225: astore 9
    //   227: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   230: ldc_w 605
    //   233: iconst_2
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_2
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: aload 9
    //   245: aastore
    //   246: invokeinterface 454 3 0
    //   251: aload 10
    //   253: astore 5
    //   255: goto -183 -> 72
    //   258: astore 14
    //   260: aconst_null
    //   261: astore 5
    //   263: aload 14
    //   265: astore 15
    //   267: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   270: astore 16
    //   272: iconst_2
    //   273: anewarray 4	java/lang/Object
    //   276: astore 17
    //   278: aload 17
    //   280: iconst_0
    //   281: aload_2
    //   282: aastore
    //   283: aload 17
    //   285: iconst_1
    //   286: aload 15
    //   288: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: aastore
    //   292: aload 16
    //   294: ldc_w 607
    //   297: aload 17
    //   299: invokeinterface 454 3 0
    //   304: goto -232 -> 72
    //   307: astore 8
    //   309: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   312: ldc_w 609
    //   315: iconst_2
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: aload_2
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: aload 8
    //   327: aastore
    //   328: invokeinterface 454 3 0
    //   333: aload 5
    //   335: areturn
    //   336: astore 9
    //   338: aconst_null
    //   339: astore 10
    //   341: aconst_null
    //   342: astore 7
    //   344: goto -117 -> 227
    //   347: astore 9
    //   349: aconst_null
    //   350: astore 10
    //   352: goto -125 -> 227
    //   355: astore 30
    //   357: aload 12
    //   359: astore 7
    //   361: aload 30
    //   363: astore 9
    //   365: aconst_null
    //   366: astore 10
    //   368: goto -141 -> 227
    //   371: astore 4
    //   373: aconst_null
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 6
    //   379: goto -237 -> 142
    //   382: astore 31
    //   384: aload 7
    //   386: astore 6
    //   388: aconst_null
    //   389: astore 5
    //   391: goto -249 -> 142
    //   394: astore 29
    //   396: aload 12
    //   398: astore 6
    //   400: aconst_null
    //   401: astore 5
    //   403: goto -261 -> 142
    //   406: astore 13
    //   408: aload 7
    //   410: astore 6
    //   412: aconst_null
    //   413: astore 5
    //   415: goto -273 -> 142
    //   418: astore 15
    //   420: goto -153 -> 267
    //   423: astore 21
    //   425: goto -248 -> 177
    //   428: astore 25
    //   430: goto -334 -> 96
    //
    // Exception table:
    //   from	to	target	type
    //   33	44	87	java/lang/ClassNotFoundException
    //   48	72	136	java/io/FileNotFoundException
    //   96	133	136	java/io/FileNotFoundException
    //   177	214	136	java/io/FileNotFoundException
    //   267	304	136	java/io/FileNotFoundException
    //   33	44	168	java/lang/ClassCastException
    //   96	133	217	java/lang/Exception
    //   177	214	217	java/lang/Exception
    //   267	304	217	java/lang/Exception
    //   33	44	258	java/lang/Exception
    //   77	84	307	java/lang/Exception
    //   0	7	336	java/lang/Exception
    //   11	22	347	java/lang/Exception
    //   22	33	355	java/lang/Exception
    //   0	7	371	java/io/FileNotFoundException
    //   11	22	382	java/io/FileNotFoundException
    //   22	33	394	java/io/FileNotFoundException
    //   33	44	406	java/io/FileNotFoundException
    //   48	72	418	java/lang/Exception
    //   48	72	423	java/lang/ClassCastException
    //   48	72	428	java/lang/ClassNotFoundException
  }

  public static <T> T readObjectField(ObjectInputStream.GetField paramGetField, String paramString, T paramT)
  {
    try
    {
      Object localObject = paramGetField.get(paramString, paramT);
      return localObject;
    }
    catch (Exception localException)
    {
      ILogger localILogger = getLogger();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = localException.getMessage();
      localILogger.debug("Unable to read '%s' field in migration device with message (%s)", arrayOfObject);
    }
    return paramT;
  }

  public static String readStringField(ObjectInputStream.GetField paramGetField, String paramString1, String paramString2)
  {
    return (String)readObjectField(paramGetField, paramString1, paramString2);
  }

  public static void runInBackground(Runnable paramRunnable)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    new AsyncTask()
    {
      protected Void a(Object[] paramAnonymousArrayOfObject)
      {
        ((Runnable)paramAnonymousArrayOfObject[0]).run();
        return null;
      }
    }
    .execute(new Object[] { paramRunnable });
  }

  public static String sha1(String paramString)
  {
    return hash(paramString, "SHA-1");
  }

  public static String sha256(String paramString)
  {
    return hash(paramString, "SHA-256");
  }

  // ERROR //
  public static <T> void writeObject(T paramT, Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: aload_2
    //   5: iconst_0
    //   6: invokevirtual 643	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   9: astore 4
    //   11: new 645	java/io/BufferedOutputStream
    //   14: dup
    //   15: aload 4
    //   17: invokespecial 648	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore 7
    //   22: new 650	java/io/ObjectOutputStream
    //   25: dup
    //   26: aload 7
    //   28: invokespecial 651	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 4
    //   33: aload 4
    //   35: aload_0
    //   36: invokevirtual 654	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   39: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   42: ldc_w 656
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_3
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: aload_0
    //   56: aastore
    //   57: invokeinterface 218 3 0
    //   62: aload 4
    //   64: ifnull +10 -> 74
    //   67: aload 4
    //   69: invokeinterface 595 1 0
    //   74: return
    //   75: astore 8
    //   77: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   80: ldc_w 658
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_3
    //   90: aastore
    //   91: invokeinterface 454 3 0
    //   96: goto -34 -> 62
    //   99: astore 5
    //   101: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   104: ldc_w 660
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_3
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload 5
    //   119: aastore
    //   120: invokeinterface 454 3 0
    //   125: goto -63 -> 62
    //   128: astore 6
    //   130: invokestatic 152	com/adjust/sdk/Util:getLogger	()Lcom/adjust/sdk/ILogger;
    //   133: ldc_w 662
    //   136: iconst_2
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_3
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload 6
    //   148: aastore
    //   149: invokeinterface 454 3 0
    //   154: return
    //   155: astore 5
    //   157: aload 7
    //   159: astore 4
    //   161: goto -60 -> 101
    //
    // Exception table:
    //   from	to	target	type
    //   33	62	75	java/io/NotSerializableException
    //   3	22	99	java/lang/Exception
    //   33	62	99	java/lang/Exception
    //   77	96	99	java/lang/Exception
    //   67	74	128	java/lang/Exception
    //   22	33	155	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Util
 * JD-Core Version:    0.6.2
 */