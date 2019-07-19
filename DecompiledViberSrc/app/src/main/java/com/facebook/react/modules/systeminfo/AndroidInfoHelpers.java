package com.facebook.react.modules.systeminfo;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Locale;

public class AndroidInfoHelpers
{
  private static final int DEBUG_SERVER_HOST_PORT = 8081;
  public static final String DEVICE_LOCALHOST = "localhost";
  public static final String EMULATOR_LOCALHOST = "10.0.2.2";
  public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
  private static final int INSPECTOR_PROXY_PORT = 8082;
  public static final String METRO_HOST_PROP_NAME = "metro.host";
  private static final String TAG = AndroidInfoHelpers.class.getSimpleName();
  private static String metroHostPropValue = null;

  public static String getFriendlyDeviceName()
  {
    if (isRunningOnGenymotion())
      return Build.MODEL;
    return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
  }

  public static String getInspectorProxyHost()
  {
    return getServerIpAddress(8082);
  }

  // ERROR //
  private static String getMetroHostPropValue()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 36	com/facebook/react/modules/systeminfo/AndroidInfoHelpers:metroHostPropValue	Ljava/lang/String;
    //   8: ifnull +14 -> 22
    //   11: getstatic 36	com/facebook/react/modules/systeminfo/AndroidInfoHelpers:metroHostPropValue	Ljava/lang/String;
    //   14: astore 7
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload 7
    //   21: areturn
    //   22: invokestatic 88	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   25: iconst_2
    //   26: anewarray 90	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 92
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc 22
    //   38: aastore
    //   39: invokevirtual 96	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   42: astore 9
    //   44: aload 9
    //   46: astore_3
    //   47: new 98	java/io/BufferedReader
    //   50: dup
    //   51: new 100	java/io/InputStreamReader
    //   54: dup
    //   55: aload_3
    //   56: invokevirtual 106	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   59: ldc 108
    //   61: invokestatic 114	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   64: invokespecial 117	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   67: invokespecial 120	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   70: astore 6
    //   72: ldc 122
    //   74: astore 10
    //   76: aload 6
    //   78: invokevirtual 125	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore 11
    //   83: aload 11
    //   85: ifnull +10 -> 95
    //   88: aload 11
    //   90: astore 10
    //   92: goto -16 -> 76
    //   95: aload 10
    //   97: putstatic 36	com/facebook/react/modules/systeminfo/AndroidInfoHelpers:metroHostPropValue	Ljava/lang/String;
    //   100: aload 6
    //   102: ifnull +8 -> 110
    //   105: aload 6
    //   107: invokevirtual 128	java/io/BufferedReader:close	()V
    //   110: aload_3
    //   111: ifnull +7 -> 118
    //   114: aload_3
    //   115: invokevirtual 131	java/lang/Process:destroy	()V
    //   118: getstatic 36	com/facebook/react/modules/systeminfo/AndroidInfoHelpers:metroHostPropValue	Ljava/lang/String;
    //   121: astore 7
    //   123: goto -107 -> 16
    //   126: astore 5
    //   128: aconst_null
    //   129: astore 6
    //   131: getstatic 34	com/facebook/react/modules/systeminfo/AndroidInfoHelpers:TAG	Ljava/lang/String;
    //   134: ldc 133
    //   136: aload 5
    //   138: invokestatic 139	com/facebook/common/logging/FLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: ldc 122
    //   143: putstatic 36	com/facebook/react/modules/systeminfo/AndroidInfoHelpers:metroHostPropValue	Ljava/lang/String;
    //   146: aload 6
    //   148: ifnull +8 -> 156
    //   151: aload 6
    //   153: invokevirtual 128	java/io/BufferedReader:close	()V
    //   156: aload_0
    //   157: ifnull -39 -> 118
    //   160: aload_0
    //   161: invokevirtual 131	java/lang/Process:destroy	()V
    //   164: goto -46 -> 118
    //   167: astore_1
    //   168: ldc 2
    //   170: monitorexit
    //   171: aload_1
    //   172: athrow
    //   173: astore_2
    //   174: aconst_null
    //   175: astore_3
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 128	java/io/BufferedReader:close	()V
    //   184: aload_3
    //   185: ifnull +7 -> 192
    //   188: aload_3
    //   189: invokevirtual 131	java/lang/Process:destroy	()V
    //   192: aload_2
    //   193: athrow
    //   194: astore 12
    //   196: goto -86 -> 110
    //   199: astore 8
    //   201: goto -45 -> 156
    //   204: astore 4
    //   206: goto -22 -> 184
    //   209: astore_2
    //   210: aconst_null
    //   211: astore_0
    //   212: goto -36 -> 176
    //   215: astore_2
    //   216: aload 6
    //   218: astore_0
    //   219: goto -43 -> 176
    //   222: astore_2
    //   223: aload_0
    //   224: astore_3
    //   225: aload 6
    //   227: astore_0
    //   228: goto -52 -> 176
    //   231: astore 5
    //   233: aload_3
    //   234: astore_0
    //   235: aconst_null
    //   236: astore 6
    //   238: goto -107 -> 131
    //   241: astore 5
    //   243: aload_3
    //   244: astore_0
    //   245: goto -114 -> 131
    //
    // Exception table:
    //   from	to	target	type
    //   22	44	126	java/lang/Exception
    //   5	16	167	finally
    //   105	110	167	finally
    //   114	118	167	finally
    //   118	123	167	finally
    //   151	156	167	finally
    //   160	164	167	finally
    //   180	184	167	finally
    //   188	192	167	finally
    //   192	194	167	finally
    //   22	44	173	finally
    //   105	110	194	java/lang/Exception
    //   151	156	199	java/lang/Exception
    //   180	184	204	java/lang/Exception
    //   47	72	209	finally
    //   76	83	215	finally
    //   95	100	215	finally
    //   131	146	222	finally
    //   47	72	231	java/lang/Exception
    //   76	83	241	java/lang/Exception
    //   95	100	241	java/lang/Exception
  }

  public static String getServerHost()
  {
    return getServerIpAddress(8081);
  }

  private static String getServerIpAddress(int paramInt)
  {
    String str = getMetroHostPropValue();
    if (!str.equals(""));
    while (true)
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      return String.format(localLocale, "%s:%d", arrayOfObject);
      if (isRunningOnGenymotion())
        str = "10.0.3.2";
      else if (isRunningOnStockEmulator())
        str = "10.0.2.2";
      else
        str = "localhost";
    }
  }

  private static boolean isRunningOnGenymotion()
  {
    return Build.FINGERPRINT.contains("vbox");
  }

  private static boolean isRunningOnStockEmulator()
  {
    return Build.FINGERPRINT.contains("generic");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.systeminfo.AndroidInfoHelpers
 * JD-Core Version:    0.6.2
 */