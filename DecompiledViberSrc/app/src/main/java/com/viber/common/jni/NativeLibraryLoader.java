package com.viber.common.jni;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import com.viber.common.a.e;
import com.viber.common.d.i;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public final class NativeLibraryLoader
{
  private static final int BUFFER_SIZE = 8192;
  private static e L;
  private static final String LIB_NAME_LOCAL_SUFFIX = "local.so";
  private static final String LIB_NAME_PREFIX = "lib";
  private static final String LIB_NAME_SUFFIX = ".so";
  private static HashMap<String, Long> checksums = new HashMap();
  private static Boolean externalLibsActive;
  private static HashMap<String, Integer> libSizes;
  private static volatile Map<String, Boolean> mLoaded = new HashMap();
  private static String sApkSoFolder;
  private static Context sContext;
  private static String sFolderType;
  private static File sLibraryDir;

  private static String apkSoFolder()
  {
    return "lib/" + sFolderType + "/";
  }

  private static void closeSilently(Closeable[] paramArrayOfCloseable)
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

  private static void closeZipSilently(ZipFile[] paramArrayOfZipFile)
  {
    int i = paramArrayOfZipFile.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        ZipFile localZipFile = paramArrayOfZipFile[j];
        if (localZipFile != null);
        try
        {
          localZipFile.close();
          label22: j++;
        }
        catch (Exception localException)
        {
          break label22;
        }
      }
  }

  private static Context context()
  {
    return sContext;
  }

  public static HashMap<String, Integer> convertLibrarySizesFromSimpleArray(Object[] paramArrayOfObject)
  {
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramArrayOfObject.length; i += 3)
    {
      String str = (String)paramArrayOfObject[i];
      int j = ((Integer)paramArrayOfObject[(i + 1)]).intValue();
      long l = ((Long)paramArrayOfObject[(i + 2)]).longValue();
      localHashMap.put(str, Integer.valueOf(j));
      checksums.put(str, Long.valueOf(l));
    }
    return localHashMap;
  }

  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8192];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  private static void copyExternalLibs(File paramFile)
  {
    ZipInputStream localZipInputStream;
    File localFile1;
    Object localObject2;
    String str1;
    try
    {
      localZipInputStream = new ZipInputStream(new FileInputStream(paramFile));
      try
      {
        localFile1 = getLocalFilesDir();
        ZipEntry localZipEntry1 = localZipInputStream.getNextEntry();
        localObject2 = localZipEntry1;
        if (localObject2 == null)
          break label319;
        try
        {
          if (!((ZipEntry)localObject2).getName().endsWith(".so"))
            break label285;
          str1 = new File(((ZipEntry)localObject2).getName()).getName();
          if (!str1.equals(((ZipEntry)localObject2).getName()))
          {
            e locale3 = L;
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = ((ZipEntry)localObject2).getName();
            locale3.b("copyExternalLibs: zip is not supposed to have folders. Entry: ?", arrayOfObject3);
            throw new IOException("WTF");
          }
        }
        finally
        {
        }
      }
      finally
      {
        localZipInputStream.close();
      }
    }
    catch (IOException localIOException)
    {
      L.a(localIOException, "Failed copying external libs", new Object[0]);
      return;
    }
    String str2 = str1.substring("lib".length());
    File localFile2 = new File(localFile1, libSoLocalName(str2.substring(0, str2.length() - ".so".length())));
    e locale2 = L;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = ((ZipEntry)localObject2).getName();
    arrayOfObject2[1] = localFile2.getAbsolutePath();
    locale2.b("copyExternalLibs: copying ZIP:? to ?", arrayOfObject2);
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
    while (true)
    {
      label285: e locale1;
      try
      {
        copy(localZipInputStream, localFileOutputStream);
        localFileOutputStream.close();
        localZipInputStream.closeEntry();
        ZipEntry localZipEntry2 = localZipInputStream.getNextEntry();
        localObject2 = localZipEntry2;
      }
      finally
      {
        localFileOutputStream.close();
      }
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = ((ZipEntry)localObject2).getName();
      locale1.b("copyExternalLibs: garbage in archive: ?, ignoring", arrayOfObject1);
    }
    label319: localZipInputStream.close();
  }

  // ERROR //
  private static void copyFileFromZip(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 225	java/io/File:exists	()Z
    //   6: ifeq +34 -> 40
    //   9: getstatic 166	com/viber/common/jni/NativeLibraryLoader:L	Lcom/viber/common/a/e;
    //   12: astore 18
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: astore 19
    //   20: aload 19
    //   22: iconst_0
    //   23: aload_1
    //   24: invokevirtual 207	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: aastore
    //   28: aload 18
    //   30: ldc 227
    //   32: aload 19
    //   34: invokeinterface 229 3 0
    //   39: return
    //   40: new 78	java/util/zip/ZipFile
    //   43: dup
    //   44: invokestatic 231	com/viber/common/jni/NativeLibraryLoader:context	()Landroid/content/Context;
    //   47: invokevirtual 237	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   50: getfield 242	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   53: invokespecial 243	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: aload_3
    //   58: new 51	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   65: getstatic 245	com/viber/common/jni/NativeLibraryLoader:sApkSoFolder	Ljava/lang/String;
    //   68: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: invokestatic 248	com/viber/common/jni/NativeLibraryLoader:libSoName	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokevirtual 252	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   84: astore 7
    //   86: aload 7
    //   88: ifnonnull +26 -> 114
    //   91: iconst_1
    //   92: anewarray 71	java/io/Closeable
    //   95: dup
    //   96: iconst_0
    //   97: aconst_null
    //   98: aastore
    //   99: invokestatic 254	com/viber/common/jni/NativeLibraryLoader:closeSilently	([Ljava/io/Closeable;)V
    //   102: iconst_1
    //   103: anewarray 78	java/util/zip/ZipFile
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: aastore
    //   110: invokestatic 256	com/viber/common/jni/NativeLibraryLoader:closeZipSilently	([Ljava/util/zip/ZipFile;)V
    //   113: return
    //   114: getstatic 166	com/viber/common/jni/NativeLibraryLoader:L	Lcom/viber/common/a/e;
    //   117: astore 8
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: astore 9
    //   125: aload 9
    //   127: iconst_0
    //   128: aload_0
    //   129: aastore
    //   130: aload 9
    //   132: iconst_1
    //   133: aload_1
    //   134: invokevirtual 207	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   137: aastore
    //   138: aload 8
    //   140: ldc_w 258
    //   143: aload 9
    //   145: invokeinterface 174 3 0
    //   150: aload_3
    //   151: aload 7
    //   153: invokevirtual 262	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   156: astore 10
    //   158: aload_1
    //   159: iconst_1
    //   160: iconst_0
    //   161: invokevirtual 266	java/io/File:setReadable	(ZZ)Z
    //   164: pop
    //   165: aload_1
    //   166: iconst_1
    //   167: iconst_0
    //   168: invokevirtual 269	java/io/File:setExecutable	(ZZ)Z
    //   171: pop
    //   172: aload_1
    //   173: iconst_1
    //   174: invokevirtual 273	java/io/File:setWritable	(Z)Z
    //   177: pop
    //   178: sipush 4096
    //   181: newarray byte
    //   183: astore 16
    //   185: new 211	java/io/FileOutputStream
    //   188: dup
    //   189: aload_1
    //   190: invokespecial 212	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   193: astore 15
    //   195: aload 10
    //   197: aload 16
    //   199: invokevirtual 120	java/io/InputStream:read	([B)I
    //   202: istore 17
    //   204: iload 17
    //   206: ifle +74 -> 280
    //   209: invokestatic 278	java/lang/Thread:yield	()V
    //   212: aload 15
    //   214: aload 16
    //   216: iconst_0
    //   217: iload 17
    //   219: invokevirtual 126	java/io/OutputStream:write	([BII)V
    //   222: goto -27 -> 195
    //   225: astore 14
    //   227: iconst_1
    //   228: anewarray 71	java/io/Closeable
    //   231: dup
    //   232: iconst_0
    //   233: aload 15
    //   235: aastore
    //   236: invokestatic 254	com/viber/common/jni/NativeLibraryLoader:closeSilently	([Ljava/io/Closeable;)V
    //   239: aload 14
    //   241: athrow
    //   242: astore 4
    //   244: aload 10
    //   246: astore_2
    //   247: aload_3
    //   248: astore 5
    //   250: aload_0
    //   251: aload 4
    //   253: invokestatic 282	com/viber/common/jni/NativeLibraryLoader:logError	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: iconst_1
    //   257: anewarray 71	java/io/Closeable
    //   260: dup
    //   261: iconst_0
    //   262: aload_2
    //   263: aastore
    //   264: invokestatic 254	com/viber/common/jni/NativeLibraryLoader:closeSilently	([Ljava/io/Closeable;)V
    //   267: iconst_1
    //   268: anewarray 78	java/util/zip/ZipFile
    //   271: dup
    //   272: iconst_0
    //   273: aload 5
    //   275: aastore
    //   276: invokestatic 256	com/viber/common/jni/NativeLibraryLoader:closeZipSilently	([Ljava/util/zip/ZipFile;)V
    //   279: return
    //   280: iconst_1
    //   281: anewarray 71	java/io/Closeable
    //   284: dup
    //   285: iconst_0
    //   286: aload 15
    //   288: aastore
    //   289: invokestatic 254	com/viber/common/jni/NativeLibraryLoader:closeSilently	([Ljava/io/Closeable;)V
    //   292: iconst_1
    //   293: anewarray 71	java/io/Closeable
    //   296: dup
    //   297: iconst_0
    //   298: aload 10
    //   300: aastore
    //   301: invokestatic 254	com/viber/common/jni/NativeLibraryLoader:closeSilently	([Ljava/io/Closeable;)V
    //   304: iconst_1
    //   305: anewarray 78	java/util/zip/ZipFile
    //   308: dup
    //   309: iconst_0
    //   310: aload_3
    //   311: aastore
    //   312: invokestatic 256	com/viber/common/jni/NativeLibraryLoader:closeZipSilently	([Ljava/util/zip/ZipFile;)V
    //   315: return
    //   316: astore 6
    //   318: aconst_null
    //   319: astore_3
    //   320: iconst_1
    //   321: anewarray 71	java/io/Closeable
    //   324: dup
    //   325: iconst_0
    //   326: aload_2
    //   327: aastore
    //   328: invokestatic 254	com/viber/common/jni/NativeLibraryLoader:closeSilently	([Ljava/io/Closeable;)V
    //   331: iconst_1
    //   332: anewarray 78	java/util/zip/ZipFile
    //   335: dup
    //   336: iconst_0
    //   337: aload_3
    //   338: aastore
    //   339: invokestatic 256	com/viber/common/jni/NativeLibraryLoader:closeZipSilently	([Ljava/util/zip/ZipFile;)V
    //   342: aload 6
    //   344: athrow
    //   345: astore 6
    //   347: aconst_null
    //   348: astore_2
    //   349: goto -29 -> 320
    //   352: astore 6
    //   354: aload 10
    //   356: astore_2
    //   357: goto -37 -> 320
    //   360: astore 6
    //   362: aload 5
    //   364: astore_3
    //   365: goto -45 -> 320
    //   368: astore 4
    //   370: aconst_null
    //   371: astore 5
    //   373: aconst_null
    //   374: astore_2
    //   375: goto -125 -> 250
    //   378: astore 4
    //   380: aload_3
    //   381: astore 5
    //   383: aconst_null
    //   384: astore_2
    //   385: goto -135 -> 250
    //   388: astore 14
    //   390: aconst_null
    //   391: astore 15
    //   393: goto -166 -> 227
    //
    // Exception table:
    //   from	to	target	type
    //   195	204	225	finally
    //   209	222	225	finally
    //   158	178	242	java/lang/Throwable
    //   227	242	242	java/lang/Throwable
    //   280	292	242	java/lang/Throwable
    //   40	57	316	finally
    //   57	86	345	finally
    //   114	158	345	finally
    //   158	178	352	finally
    //   227	242	352	finally
    //   280	292	352	finally
    //   250	256	360	finally
    //   40	57	368	java/lang/Throwable
    //   57	86	378	java/lang/Throwable
    //   114	158	378	java/lang/Throwable
    //   178	195	388	finally
  }

  private static long getApkLibrarySize(String paramString)
  {
    String str = sApkSoFolder + libSoName(paramString);
    Integer localInteger = (Integer)libSizes.get(str);
    L.b("getApkLibrarySize(?) = ?", new Object[] { str, localInteger });
    if (localInteger == null)
      return 0L;
    return localInteger.intValue();
  }

  private static long getApkMtime()
  {
    return new File(context().getApplicationInfo().sourceDir).lastModified();
  }

  public static long getDefChecksum(String paramString)
  {
    long l = 0L;
    String str = apkSoFolder() + paramString;
    if (checksums.containsKey(str))
      l = ((Long)checksums.get(str)).longValue();
    return l;
  }

  private static File getLocalFile(String paramString)
  {
    return new File(getLocalFilesDir(), libSoLocalName(paramString));
  }

  private static File getLocalFilesDir()
  {
    return new File(context().getFilesDir(), "lib");
  }

  public static void init(Context paramContext, HashMap<String, Integer> paramHashMap, e parame)
  {
    sContext = paramContext;
    libSizes = paramHashMap;
    L = parame;
    sLibraryDir = libraryDir();
    sFolderType = libraryCpuType();
    sApkSoFolder = apkSoFolder();
  }

  private static boolean initLibrary(String paramString)
  {
    boolean bool1 = true;
    try
    {
      if (loadNormal(paramString))
        return bool1;
      if (!loadLocal(paramString, false))
      {
        boolean bool3 = loadZip(paramString);
        if (bool3);
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        while (true)
        {
          boolean bool2 = loadDefault(paramString);
          return bool2;
          localThrowable1 = localThrowable1;
          logError(paramString, localThrowable1);
        }
      }
      catch (Throwable localThrowable2)
      {
        logError(paramString, localThrowable2);
        bool1 = false;
      }
    }
    return bool1;
  }

  private static String libNameFromFile(String paramString)
  {
    return paramString.substring("lib".length(), paramString.length() - ".so".length());
  }

  private static String libSoLocalName(String paramString)
  {
    return "lib" + paramString + "local.so";
  }

  private static String libSoName(String paramString)
  {
    return "lib" + paramString + ".so";
  }

  private static String libraryCpuType()
  {
    String str1 = "armeabi";
    if (Build.CPU_ABI.equalsIgnoreCase("arm64-v8a"))
      str1 = "arm64-v8a";
    while (true)
    {
      String str2 = System.getProperty("os.arch");
      if ((str2 != null) && (str2.contains("686")))
        str1 = "x86";
      L.b("Library cpu type: ?", new Object[] { str1 });
      return str1;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a"))
        str1 = "armeabi-v7a";
      else if (Build.CPU_ABI.equalsIgnoreCase("x86_64"))
        str1 = "x86_64";
      else if (Build.CPU_ABI.equalsIgnoreCase("x86"))
        str1 = "x86";
      else if (Build.CPU_ABI.equalsIgnoreCase("mips"))
        str1 = "mips";
    }
  }

  private static File libraryDir()
  {
    try
    {
      localFile1 = new File((String)ApplicationInfo.class.getField("nativeLibraryDir").get(context().getApplicationInfo()));
      if (localFile1 != null);
    }
    catch (Throwable localThrowable2)
    {
      while (true)
      {
        File localFile1;
        try
        {
          localFile2 = new File(context().getApplicationInfo().nativeLibraryDir);
          if (localFile2 == null)
          {
            localFile2 = new File(context().getApplicationInfo().dataDir, "lib");
            if (!localFile2.isDirectory())
              localFile2 = null;
          }
          L.b("Native library dir: ?", new Object[] { localFile2 });
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

  private static boolean loadDefault(String paramString)
  {
    L.b("Load library ... library: ? via default way", new Object[] { paramString });
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable localThrowable)
    {
      logError(paramString, localThrowable);
    }
    return false;
  }

  private static boolean loadExternal(String paramString)
  {
    L.b("loadExternal, libraryName:?", new Object[] { paramString });
    File localFile1;
    if (externalLibsActive == null)
    {
      externalLibsActive = Boolean.valueOf(false);
      localFile1 = new File(Environment.getExternalStorageDirectory(), "viber-libs.mtime");
      File localFile2 = new File(Environment.getExternalStorageDirectory(), "viber-libs.zip");
      if (!localFile2.exists())
        break label258;
      L.b("loadExternal: copying libs from ?", new Object[] { localFile2 });
      copyExternalLibs(localFile2);
      L.b("loadExternal: deleting ?", new Object[] { localFile2 });
      localFile2.delete();
    }
    while (true)
    {
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile1);
        try
        {
          long l3 = getApkMtime();
          e locale5 = L;
          Object[] arrayOfObject5 = new Object[2];
          arrayOfObject5[0] = Long.valueOf(l3);
          arrayOfObject5[1] = localFile1;
          locale5.b("loadExternal: saving apk mtime ? to ?", arrayOfObject5);
          localFileOutputStream.write(Long.toString(l3).getBytes());
          externalLibsActive = Boolean.valueOf(true);
          localFileOutputStream.close();
          if (!externalLibsActive.booleanValue())
            break;
          return loadLocal(paramString, true);
        }
        finally
        {
          localFileOutputStream.close();
        }
      }
      catch (IOException localIOException2)
      {
        L.a(localIOException2, "loadExternal: failed writing " + localFile1.getAbsolutePath(), new Object[0]);
        continue;
      }
      label258: if (localFile1.exists())
      {
        long l1;
        long l2;
        try
        {
          l1 = readMtimeFile(localFile1);
          l2 = getApkMtime();
          if (l1 != l2)
            break label375;
          e locale1 = L;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Long.valueOf(l2);
          arrayOfObject1[1] = Long.valueOf(l1);
          locale1.b("loadExternal: apk mtime:? libs mtime:?, using local libs", arrayOfObject1);
          externalLibsActive = Boolean.valueOf(true);
        }
        catch (IOException localIOException1)
        {
          L.a(localIOException1, "loadExternal, failed reading " + localFile1.getAbsolutePath(), new Object[0]);
        }
        continue;
        label375: e locale2 = L;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Long.valueOf(l2);
        arrayOfObject2[1] = Long.valueOf(l1);
        locale2.b("loadExternal: apk mtime:? libs mtime:?, app reinstall, dropping local libs", arrayOfObject2);
        File localFile3 = getLocalFilesDir();
        if (localFile3.exists())
          for (File localFile4 : localFile3.listFiles())
          {
            e locale4 = L;
            Object[] arrayOfObject4 = new Object[1];
            arrayOfObject4[0] = localFile4.getAbsolutePath();
            locale4.b("loadExternal: deleting ?", arrayOfObject4);
            localFile4.delete();
          }
        e locale3 = L;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = localFile1.getAbsolutePath();
        locale3.b("loadExternal: deleting ?", arrayOfObject3);
        localFile1.delete();
      }
    }
    L.b("loadExternal, external libs inactive", new Object[0]);
    return false;
  }

  public static boolean loadLibrary(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      L.b("Load library ... library: ?", new Object[] { paramString });
      if (!paramString.equals("c++_shared"))
        loadLibrary("c++_shared", false);
      if (Boolean.TRUE.equals(mLoaded.get(paramString)))
        L.b("Load library ... library: ? is already loaded, skip!", new Object[] { paramString });
      do
      {
        return bool;
        i locali = i.a();
        bool = initLibrary(paramString);
        mLoaded.put(paramString, Boolean.valueOf(bool));
        e locale = L;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = Boolean.valueOf(bool);
        arrayOfObject[2] = Long.valueOf(locali.e());
        locale.b("Load library ... library: ?, load result: ?, exec time ms: ?", arrayOfObject);
      }
      while ((bool) || (!paramBoolean));
      throw new UnsatisfiedLinkError();
    }
    finally
    {
    }
  }

  private static boolean loadLocal(String paramString, boolean paramBoolean)
  {
    L.b("Load library ... library: ? via local way", new Object[] { paramString });
    File localFile1 = getLocalFilesDir();
    localFile1.mkdirs();
    e locale1 = L;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = localFile1.getAbsolutePath();
    locale1.b("Load library via local way, folder: ?", arrayOfObject1);
    File localFile2 = new File(localFile1, libSoLocalName(paramString));
    e locale2 = L;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = localFile2.getAbsolutePath();
    arrayOfObject2[1] = Boolean.valueOf(localFile2.exists());
    locale2.b("Load library via local way, local *.so file: ?, exists: ?", arrayOfObject2);
    if (localFile2.exists())
    {
      if ((!paramBoolean) && (localFile2.length() != getApkLibrarySize(paramString)))
        break label221;
      e locale3 = L;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = localFile2.getAbsolutePath();
      locale3.b("loadLocal, loading local library from ?", arrayOfObject3);
      try
      {
        System.load(localFile2.getAbsolutePath());
        L.a(new RuntimeException("loadLocal OK"), localFile2.getAbsolutePath());
        return true;
      }
      catch (Throwable localThrowable)
      {
        logError(localFile2.getAbsolutePath(), localThrowable);
      }
    }
    while (true)
    {
      return false;
      label221: boolean bool = localFile2.delete();
      e locale4 = L;
      Object[] arrayOfObject4 = new Object[2];
      arrayOfObject4[0] = localFile2.getAbsolutePath();
      arrayOfObject4[1] = Boolean.valueOf(bool);
      locale4.b("loadLocal, library sizes differ, deleted ?, result:?", arrayOfObject4);
    }
  }

  private static boolean loadNormal(String paramString)
  {
    L.b("Load library ... library: ? via normal way", new Object[] { paramString });
    File localFile1 = new File(sLibraryDir, libSoName(paramString));
    e locale1 = L;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = localFile1.getAbsolutePath();
    arrayOfObject1[1] = Boolean.valueOf(localFile1.exists());
    locale1.b("Load library via normal way, *.so file: ?, exists: ?", arrayOfObject1);
    if (localFile1.exists())
    {
      if (localFile1.length() != getApkLibrarySize(paramString))
        break label198;
      try
      {
        System.loadLibrary(paramString);
        e locale3 = L;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = localFile1.getAbsolutePath();
        locale3.b("Normal library loaded: ?", arrayOfObject3);
        File localFile2 = getLocalFile(paramString);
        if (localFile2.exists())
        {
          boolean bool = localFile2.delete();
          e locale4 = L;
          Object[] arrayOfObject4 = new Object[2];
          arrayOfObject4[0] = localFile2.getAbsolutePath();
          arrayOfObject4[1] = Boolean.valueOf(bool);
          locale4.b("Deleting local library file: ?, result: ?", arrayOfObject4);
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        logError(paramString, localThrowable);
      }
    }
    while (true)
    {
      return false;
      label198: e locale2 = L;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localFile1.getAbsolutePath();
      locale2.b("loadNormal, library size differs from archive ?", arrayOfObject2);
    }
  }

  private static boolean loadZip(String paramString)
  {
    L.b("Load library ... library: ? via zip", new Object[] { paramString });
    File localFile1 = getLocalFilesDir();
    localFile1.mkdirs();
    e locale1 = L;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = localFile1.getAbsolutePath();
    locale1.b("Load library via zip, folder: ?", arrayOfObject1);
    File localFile2 = new File(localFile1, libSoLocalName(paramString));
    e locale2 = L;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = localFile2.getAbsolutePath();
    arrayOfObject2[1] = Boolean.valueOf(localFile2.exists());
    locale2.b("Load library via zip, local *.so file: ?, exists: ?", arrayOfObject2);
    copyFileFromZip(paramString, localFile2);
    return loadLocal(paramString, false);
  }

  private static void logError(String paramString, Throwable paramThrowable)
  {
    L.a(paramThrowable, "Error while loading library ... library: " + paramString);
  }

  private static long readMtimeFile(File paramFile)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      byte[] arrayOfByte = new byte[(int)paramFile.length()];
      localFileInputStream.read(arrayOfByte);
      long l = Long.parseLong(new String(arrayOfByte));
      return l;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.jni.NativeLibraryLoader
 * JD-Core Version:    0.6.2
 */