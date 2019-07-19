package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
public class LibraryVersion
{
  private static final GmsLogger zzel = new GmsLogger("LibraryVersion", "");
  private static LibraryVersion zzem = new LibraryVersion();
  private ConcurrentHashMap<String, String> zzen = new ConcurrentHashMap();

  @KeepForSdk
  public static LibraryVersion getInstance()
  {
    return zzem;
  }

  // ERROR //
  @KeepForSdk
  public String getVersion(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 45
    //   3: invokestatic 51	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   6: pop
    //   7: aload_0
    //   8: getfield 37	com/google/android/gms/common/internal/LibraryVersion:zzen	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: aload_1
    //   12: invokevirtual 55	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   15: ifeq +15 -> 30
    //   18: aload_0
    //   19: getfield 37	com/google/android/gms/common/internal/LibraryVersion:zzen	Ljava/util/concurrent/ConcurrentHashMap;
    //   22: aload_1
    //   23: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 61	java/lang/String
    //   29: areturn
    //   30: new 63	java/util/Properties
    //   33: dup
    //   34: invokespecial 64	java/util/Properties:<init>	()V
    //   37: astore_3
    //   38: ldc 2
    //   40: ldc 66
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: aastore
    //   50: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   53: invokevirtual 76	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   56: astore 12
    //   58: aload 12
    //   60: ifnull +106 -> 166
    //   63: aload_3
    //   64: aload 12
    //   66: invokevirtual 80	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload_3
    //   70: ldc 82
    //   72: aconst_null
    //   73: invokevirtual 86	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 13
    //   78: getstatic 26	com/google/android/gms/common/internal/LibraryVersion:zzel	Lcom/google/android/gms/common/internal/GmsLogger;
    //   81: ldc 18
    //   83: new 88	java/lang/StringBuilder
    //   86: dup
    //   87: bipush 12
    //   89: aload_1
    //   90: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 96	java/lang/String:length	()I
    //   96: iadd
    //   97: aload 13
    //   99: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokevirtual 96	java/lang/String:length	()I
    //   105: iadd
    //   106: invokespecial 99	java/lang/StringBuilder:<init>	(I)V
    //   109: aload_1
    //   110: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 105
    //   115: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 13
    //   120: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 112	com/google/android/gms/common/internal/GmsLogger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload 13
    //   131: astore 10
    //   133: aload 10
    //   135: ifnonnull +17 -> 152
    //   138: ldc 114
    //   140: astore 10
    //   142: getstatic 26	com/google/android/gms/common/internal/LibraryVersion:zzel	Lcom/google/android/gms/common/internal/GmsLogger;
    //   145: ldc 18
    //   147: ldc 116
    //   149: invokevirtual 119	com/google/android/gms/common/internal/GmsLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_0
    //   153: getfield 37	com/google/android/gms/common/internal/LibraryVersion:zzen	Ljava/util/concurrent/ConcurrentHashMap;
    //   156: aload_1
    //   157: aload 10
    //   159: invokevirtual 123	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: aload 10
    //   165: areturn
    //   166: getstatic 26	com/google/android/gms/common/internal/LibraryVersion:zzel	Lcom/google/android/gms/common/internal/GmsLogger;
    //   169: astore 15
    //   171: aload_1
    //   172: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   175: astore 16
    //   177: aload 16
    //   179: invokevirtual 96	java/lang/String:length	()I
    //   182: ifeq +27 -> 209
    //   185: ldc 125
    //   187: aload 16
    //   189: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 17
    //   194: aload 15
    //   196: ldc 18
    //   198: aload 17
    //   200: invokevirtual 131	com/google/android/gms/common/internal/GmsLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aconst_null
    //   204: astore 10
    //   206: goto -73 -> 133
    //   209: new 61	java/lang/String
    //   212: dup
    //   213: ldc 125
    //   215: invokespecial 134	java/lang/String:<init>	(Ljava/lang/String;)V
    //   218: astore 17
    //   220: goto -26 -> 194
    //   223: astore 4
    //   225: aconst_null
    //   226: astore 5
    //   228: aload 4
    //   230: astore 6
    //   232: getstatic 26	com/google/android/gms/common/internal/LibraryVersion:zzel	Lcom/google/android/gms/common/internal/GmsLogger;
    //   235: astore 7
    //   237: aload_1
    //   238: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   241: astore 8
    //   243: aload 8
    //   245: invokevirtual 96	java/lang/String:length	()I
    //   248: ifeq +30 -> 278
    //   251: ldc 125
    //   253: aload 8
    //   255: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore 9
    //   260: aload 7
    //   262: ldc 18
    //   264: aload 9
    //   266: aload 6
    //   268: invokevirtual 137	com/google/android/gms/common/internal/GmsLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: aload 5
    //   273: astore 10
    //   275: goto -142 -> 133
    //   278: new 61	java/lang/String
    //   281: dup
    //   282: ldc 125
    //   284: invokespecial 134	java/lang/String:<init>	(Ljava/lang/String;)V
    //   287: astore 9
    //   289: goto -29 -> 260
    //   292: astore 14
    //   294: aload 13
    //   296: astore 5
    //   298: aload 14
    //   300: astore 6
    //   302: goto -70 -> 232
    //
    // Exception table:
    //   from	to	target	type
    //   38	58	223	java/io/IOException
    //   63	78	223	java/io/IOException
    //   166	194	223	java/io/IOException
    //   194	203	223	java/io/IOException
    //   209	220	223	java/io/IOException
    //   78	129	292	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.LibraryVersion
 * JD-Core Version:    0.6.2
 */