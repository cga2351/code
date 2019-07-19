package com.viber.voip.videoconvert.gpu.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.viber.voip.videoconvert.VideoConverterService;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private static volatile Map<String, Boolean> a = new HashMap();
  private static final File b = c();
  private static final String c = d();
  private static final String d = a();

  private static String a()
  {
    return "lib/" + c + "/";
  }

  public static String a(String paramString)
  {
    return new File(new File(b().getFilesDir(), "lib"), c(paramString)).getAbsolutePath();
  }

  private static void a(String paramString1, String paramString2)
  {
    String[] arrayOfString = { "chmod", paramString2, paramString1 };
    try
    {
      e.a(arrayOfString, "PermissionChanger", true).waitFor();
      return;
    }
    catch (IOException localIOException)
    {
      com.viber.voip.videoconvert.e.a().a(String.format("Cannot change permissions, file: %s, permissions: %s", new Object[] { paramString1, paramString2 }));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      com.viber.voip.videoconvert.e.a().a(String.format("Cannot change permissions: interrupted", new Object[0]));
    }
  }

  private static void a(String paramString, Throwable paramThrowable)
  {
    com.viber.voip.videoconvert.e.a().a("Error copying library: " + paramString);
    com.viber.voip.videoconvert.e.a().a(paramThrowable);
  }

  private static void a(Closeable[] paramArrayOfCloseable)
  {
    int i = paramArrayOfCloseable.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        Closeable localCloseable = paramArrayOfCloseable[j];
        if (localCloseable != null);
        try
        {
          localCloseable.close();
          label24: j++;
        }
        catch (Exception localException)
        {
          break label24;
        }
      }
  }

  // ERROR //
  private static boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 129	java/io/File:exists	()Z
    //   6: ifeq +36 -> 42
    //   9: invokestatic 97	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   12: astore 20
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: astore 21
    //   20: aload 21
    //   22: iconst_0
    //   23: aload_1
    //   24: invokevirtual 70	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: aastore
    //   28: aload 20
    //   30: ldc 131
    //   32: aload 21
    //   34: invokestatic 103	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 106	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   40: iconst_1
    //   41: ireturn
    //   42: new 133	java/util/zip/ZipFile
    //   45: dup
    //   46: invokestatic 55	com/viber/voip/videoconvert/gpu/a/d:b	()Landroid/content/Context;
    //   49: invokevirtual 137	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   52: getfield 142	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   55: invokespecial 144	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_3
    //   60: new 37	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   67: getstatic 35	com/viber/voip/videoconvert/gpu/a/d:d	Ljava/lang/String;
    //   70: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: invokestatic 146	com/viber/voip/videoconvert/gpu/a/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokevirtual 150	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   86: astore 9
    //   88: aload 9
    //   90: ifnonnull +24 -> 114
    //   93: iconst_1
    //   94: anewarray 119	java/io/Closeable
    //   97: dup
    //   98: iconst_0
    //   99: aconst_null
    //   100: aastore
    //   101: invokestatic 152	com/viber/voip/videoconvert/gpu/a/d:a	([Ljava/io/Closeable;)V
    //   104: aload_3
    //   105: ifnull +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 153	java/util/zip/ZipFile:close	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: invokestatic 97	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   117: astore 10
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: astore 11
    //   125: aload 11
    //   127: iconst_0
    //   128: aload_0
    //   129: aastore
    //   130: aload 11
    //   132: iconst_1
    //   133: aload_1
    //   134: invokevirtual 70	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   137: aastore
    //   138: aload 10
    //   140: ldc 155
    //   142: aload 11
    //   144: invokestatic 103	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   147: invokevirtual 106	com/viber/voip/videoconvert/e:a	(Ljava/lang/String;)V
    //   150: aload_3
    //   151: aload 9
    //   153: invokevirtual 159	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   156: astore 12
    //   158: aload_1
    //   159: invokevirtual 162	java/io/File:createNewFile	()Z
    //   162: pop
    //   163: aload_1
    //   164: invokevirtual 70	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   167: ldc 164
    //   169: invokestatic 166	com/viber/voip/videoconvert/gpu/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: sipush 4096
    //   175: newarray byte
    //   177: astore 16
    //   179: new 168	java/io/FileOutputStream
    //   182: dup
    //   183: aload_1
    //   184: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   187: astore 15
    //   189: aload 12
    //   191: aload 16
    //   193: invokevirtual 177	java/io/InputStream:read	([B)I
    //   196: istore 17
    //   198: iload 17
    //   200: ifle +73 -> 273
    //   203: invokestatic 182	java/lang/Thread:yield	()V
    //   206: aload 15
    //   208: aload 16
    //   210: iconst_0
    //   211: iload 17
    //   213: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   216: goto -27 -> 189
    //   219: astore 14
    //   221: iconst_1
    //   222: anewarray 119	java/io/Closeable
    //   225: dup
    //   226: iconst_0
    //   227: aload 15
    //   229: aastore
    //   230: invokestatic 152	com/viber/voip/videoconvert/gpu/a/d:a	([Ljava/io/Closeable;)V
    //   233: aload 14
    //   235: athrow
    //   236: astore 4
    //   238: aload 12
    //   240: astore_2
    //   241: aload_3
    //   242: astore 5
    //   244: aload_0
    //   245: aload 4
    //   247: invokestatic 190	com/viber/voip/videoconvert/gpu/a/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: iconst_1
    //   251: anewarray 119	java/io/Closeable
    //   254: dup
    //   255: iconst_0
    //   256: aload_2
    //   257: aastore
    //   258: invokestatic 152	com/viber/voip/videoconvert/gpu/a/d:a	([Ljava/io/Closeable;)V
    //   261: aload 5
    //   263: ifnull +8 -> 271
    //   266: aload 5
    //   268: invokevirtual 153	java/util/zip/ZipFile:close	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: iconst_1
    //   274: anewarray 119	java/io/Closeable
    //   277: dup
    //   278: iconst_0
    //   279: aload 15
    //   281: aastore
    //   282: invokestatic 152	com/viber/voip/videoconvert/gpu/a/d:a	([Ljava/io/Closeable;)V
    //   285: iconst_1
    //   286: anewarray 119	java/io/Closeable
    //   289: dup
    //   290: iconst_0
    //   291: aload 12
    //   293: aastore
    //   294: invokestatic 152	com/viber/voip/videoconvert/gpu/a/d:a	([Ljava/io/Closeable;)V
    //   297: aload_3
    //   298: ifnull -258 -> 40
    //   301: aload_3
    //   302: invokevirtual 153	java/util/zip/ZipFile:close	()V
    //   305: iconst_1
    //   306: ireturn
    //   307: astore 18
    //   309: iconst_1
    //   310: ireturn
    //   311: astore 6
    //   313: aconst_null
    //   314: astore_3
    //   315: iconst_1
    //   316: anewarray 119	java/io/Closeable
    //   319: dup
    //   320: iconst_0
    //   321: aload_2
    //   322: aastore
    //   323: invokestatic 152	com/viber/voip/videoconvert/gpu/a/d:a	([Ljava/io/Closeable;)V
    //   326: aload_3
    //   327: ifnull +7 -> 334
    //   330: aload_3
    //   331: invokevirtual 153	java/util/zip/ZipFile:close	()V
    //   334: aload 6
    //   336: athrow
    //   337: astore 19
    //   339: goto -227 -> 112
    //   342: astore 8
    //   344: goto -73 -> 271
    //   347: astore 7
    //   349: goto -15 -> 334
    //   352: astore 6
    //   354: aconst_null
    //   355: astore_2
    //   356: goto -41 -> 315
    //   359: astore 6
    //   361: aload 12
    //   363: astore_2
    //   364: goto -49 -> 315
    //   367: astore 6
    //   369: aload 5
    //   371: astore_3
    //   372: goto -57 -> 315
    //   375: astore 4
    //   377: aconst_null
    //   378: astore 5
    //   380: aconst_null
    //   381: astore_2
    //   382: goto -138 -> 244
    //   385: astore 4
    //   387: aload_3
    //   388: astore 5
    //   390: aconst_null
    //   391: astore_2
    //   392: goto -148 -> 244
    //   395: astore 14
    //   397: aconst_null
    //   398: astore 15
    //   400: goto -179 -> 221
    //
    // Exception table:
    //   from	to	target	type
    //   189	198	219	finally
    //   203	216	219	finally
    //   158	172	236	java/lang/Throwable
    //   221	236	236	java/lang/Throwable
    //   273	285	236	java/lang/Throwable
    //   301	305	307	java/lang/Exception
    //   42	59	311	finally
    //   108	112	337	java/lang/Exception
    //   266	271	342	java/lang/Exception
    //   330	334	347	java/lang/Exception
    //   59	88	352	finally
    //   114	158	352	finally
    //   158	172	359	finally
    //   221	236	359	finally
    //   273	285	359	finally
    //   244	250	367	finally
    //   42	59	375	java/lang/Throwable
    //   59	88	385	java/lang/Throwable
    //   114	158	385	java/lang/Throwable
    //   172	189	395	finally
  }

  public static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      com.viber.voip.videoconvert.e.a().a(String.format("Copy library ... library: %s", new Object[] { paramString }));
      if (Boolean.TRUE.equals(a.get(paramString)))
        com.viber.voip.videoconvert.e.a().a(String.format("Copy library ... library: %s is already loaded, skip!", new Object[] { paramString }));
      do
      {
        return bool;
        bool = d(paramString);
        a.put(paramString, Boolean.valueOf(bool));
        com.viber.voip.videoconvert.e locale = com.viber.voip.videoconvert.e.a();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = Boolean.valueOf(bool);
        locale.a(String.format("Copy library ... library: %s, load result: %b", arrayOfObject));
      }
      while ((bool) || (!paramBoolean));
      throw new UnsatisfiedLinkError();
    }
    finally
    {
    }
  }

  private static Context b()
  {
    return VideoConverterService.b();
  }

  private static String b(String paramString)
  {
    return "lib" + paramString + ".so";
  }

  private static File c()
  {
    try
    {
      localFile1 = new File((String)ApplicationInfo.class.getField("nativeLibraryDir").get(b().getApplicationInfo()));
      if (localFile1 != null);
    }
    catch (Throwable localThrowable2)
    {
      while (true)
      {
        File localFile1;
        try
        {
          localFile2 = new File(b().getApplicationInfo().nativeLibraryDir);
          if (localFile2 == null)
          {
            localFile2 = new File(b().getApplicationInfo().dataDir, "lib");
            if (!localFile2.isDirectory())
              localFile2 = null;
          }
          com.viber.voip.videoconvert.e.a().a(String.format("Native library dir: %s", new Object[] { localFile2 }));
          return localFile2;
          localThrowable2 = localThrowable2;
          localFile1 = null;
        }
        catch (Throwable localThrowable1)
        {
          localFile2 = localFile1;
          continue;
        }
        File localFile2 = localFile1;
      }
    }
  }

  private static String c(String paramString)
  {
    return "lib" + paramString + "local.so";
  }

  private static String d()
  {
    String str1 = "armeabi";
    if (Build.CPU_ABI.equalsIgnoreCase("arm64-v8a"))
      str1 = "arm64-v8a";
    while (true)
    {
      String str2 = System.getProperty("os.arch");
      if ((str2 != null) && (str2.contains("686")))
        str1 = "x86";
      com.viber.voip.videoconvert.e.a().a(String.format("Library cpu type: %s", new Object[] { str1 }));
      return str1;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a"))
        str1 = "armeabi-v7a";
      else if (Build.CPU_ABI.equalsIgnoreCase("armeabi"))
        str1 = "armeabi";
      else if (Build.CPU_ABI.equalsIgnoreCase("x86_64"))
        str1 = "x86_64";
      else if (Build.CPU_ABI.equalsIgnoreCase("x86"))
        str1 = "x86";
      else if (Build.CPU_ABI.equalsIgnoreCase("mips"))
        str1 = "mips";
    }
  }

  private static boolean d(String paramString)
  {
    com.viber.voip.videoconvert.e.a().a(String.format("Copy library ... library: %s from zip", new Object[] { paramString }));
    File localFile1 = new File(b().getFilesDir(), "lib");
    localFile1.mkdirs();
    com.viber.voip.videoconvert.e locale1 = com.viber.voip.videoconvert.e.a();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = localFile1.getAbsolutePath();
    locale1.a(String.format("Copy library via zip, folder: %s", arrayOfObject1));
    File localFile2 = new File(localFile1, c(paramString));
    com.viber.voip.videoconvert.e locale2 = com.viber.voip.videoconvert.e.a();
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = localFile2.getAbsolutePath();
    arrayOfObject2[1] = Boolean.valueOf(localFile2.exists());
    locale2.a(String.format("Copy library via zip, local *.so file: %s, exists: %s", arrayOfObject2));
    return a(paramString, localFile2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.a.d
 * JD-Core Version:    0.6.2
 */