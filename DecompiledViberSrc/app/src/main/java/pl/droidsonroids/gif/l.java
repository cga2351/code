package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class l
{
  private static final String a = System.mapLibraryName("pl_droidsonroids_gif");

  private static ZipEntry a(ZipFile paramZipFile)
  {
    String[] arrayOfString = b();
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      ZipEntry localZipEntry = a(paramZipFile, arrayOfString[j]);
      if (localZipEntry != null)
        return localZipEntry;
    }
    return null;
  }

  private static ZipEntry a(ZipFile paramZipFile, String paramString)
  {
    return paramZipFile.getEntry("lib/" + paramString + "/" + a);
  }

  private static ZipFile a(File paramFile)
  {
    int i = 0;
    int j = i + 1;
    if (i < 5);
    while (true)
    {
      try
      {
        localZipFile = new ZipFile(paramFile, 1);
        if (localZipFile != null)
          break label62;
        throw new IllegalStateException("Could not open APK file: " + paramFile.getAbsolutePath());
      }
      catch (IOException localIOException)
      {
        i = j;
      }
      break;
      label62: return localZipFile;
      ZipFile localZipFile = null;
    }
  }

  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  static void a(Context paramContext)
  {
    try
    {
      System.load(b(paramContext).getAbsolutePath());
      return;
    }
    finally
    {
    }
  }

  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  private static void a(File paramFile, FilenameFilter paramFilenameFilter)
  {
    File[] arrayOfFile = paramFile.getParentFile().listFiles(paramFilenameFilter);
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
        arrayOfFile[j].delete();
    }
  }

  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8192];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  // ERROR //
  private static File b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 32	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   9: getstatic 18	pl/droidsonroids/gif/l:a	Ljava/lang/String;
    //   12: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 112
    //   17: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_2
    //   24: new 62	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: ldc 114
    //   31: iconst_0
    //   32: invokevirtual 120	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   35: aload_2
    //   36: invokespecial 123	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_3
    //   40: aload_3
    //   41: invokevirtual 126	java/io/File:isFile	()Z
    //   44: ifeq +5 -> 49
    //   47: aload_3
    //   48: areturn
    //   49: new 62	java/io/File
    //   52: dup
    //   53: aload_0
    //   54: invokevirtual 129	android/content/Context:getCacheDir	()Ljava/io/File;
    //   57: aload_2
    //   58: invokespecial 123	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore 4
    //   63: aload 4
    //   65: invokevirtual 126	java/io/File:isFile	()Z
    //   68: ifeq +6 -> 74
    //   71: aload 4
    //   73: areturn
    //   74: new 131	pl/droidsonroids/gif/l$1
    //   77: dup
    //   78: ldc 133
    //   80: invokestatic 16	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokespecial 134	pl/droidsonroids/gif/l$1:<init>	(Ljava/lang/String;)V
    //   86: astore 5
    //   88: aload_3
    //   89: aload 5
    //   91: invokestatic 136	pl/droidsonroids/gif/l:a	(Ljava/io/File;Ljava/io/FilenameFilter;)V
    //   94: aload 4
    //   96: aload 5
    //   98: invokestatic 136	pl/droidsonroids/gif/l:a	(Ljava/io/File;Ljava/io/FilenameFilter;)V
    //   101: new 62	java/io/File
    //   104: dup
    //   105: aload_0
    //   106: invokevirtual 140	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   109: getfield 145	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   112: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore 6
    //   117: aload 6
    //   119: invokestatic 148	pl/droidsonroids/gif/l:a	(Ljava/io/File;)Ljava/util/zip/ZipFile;
    //   122: astore 10
    //   124: iload_1
    //   125: iconst_1
    //   126: iadd
    //   127: istore 11
    //   129: iload_1
    //   130: iconst_5
    //   131: if_icmpge +112 -> 243
    //   134: aload 10
    //   136: invokestatic 150	pl/droidsonroids/gif/l:a	(Ljava/util/zip/ZipFile;)Ljava/util/zip/ZipEntry;
    //   139: astore 13
    //   141: aload 13
    //   143: ifnonnull +56 -> 199
    //   146: new 58	java/lang/IllegalStateException
    //   149: dup
    //   150: new 32	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   157: ldc 152
    //   159: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: getstatic 18	pl/droidsonroids/gif/l:a	Ljava/lang/String;
    //   165: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 154
    //   170: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 68	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: astore 7
    //   182: aload 10
    //   184: astore 8
    //   186: aload 8
    //   188: ifnull +8 -> 196
    //   191: aload 8
    //   193: invokevirtual 155	java/util/zip/ZipFile:close	()V
    //   196: aload 7
    //   198: athrow
    //   199: aload 10
    //   201: aload 13
    //   203: invokevirtual 159	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   206: astore 19
    //   208: aload 19
    //   210: astore 16
    //   212: new 161	java/io/FileOutputStream
    //   215: dup
    //   216: aload_3
    //   217: invokespecial 164	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   220: astore 18
    //   222: aload 16
    //   224: aload 18
    //   226: invokestatic 166	pl/droidsonroids/gif/l:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   229: aload 16
    //   231: invokestatic 168	pl/droidsonroids/gif/l:a	(Ljava/io/Closeable;)V
    //   234: aload 18
    //   236: invokestatic 168	pl/droidsonroids/gif/l:a	(Ljava/io/Closeable;)V
    //   239: aload_3
    //   240: invokestatic 170	pl/droidsonroids/gif/l:b	(Ljava/io/File;)V
    //   243: aload 10
    //   245: ifnull -198 -> 47
    //   248: aload 10
    //   250: invokevirtual 155	java/util/zip/ZipFile:close	()V
    //   253: aload_3
    //   254: areturn
    //   255: astore 12
    //   257: aload_3
    //   258: areturn
    //   259: astore 17
    //   261: aconst_null
    //   262: astore 18
    //   264: aconst_null
    //   265: astore 16
    //   267: iload 11
    //   269: iconst_2
    //   270: if_icmple +6 -> 276
    //   273: aload 4
    //   275: astore_3
    //   276: aload 16
    //   278: invokestatic 168	pl/droidsonroids/gif/l:a	(Ljava/io/Closeable;)V
    //   281: aload 18
    //   283: invokestatic 168	pl/droidsonroids/gif/l:a	(Ljava/io/Closeable;)V
    //   286: iload 11
    //   288: istore_1
    //   289: goto -165 -> 124
    //   292: aload 16
    //   294: invokestatic 168	pl/droidsonroids/gif/l:a	(Ljava/io/Closeable;)V
    //   297: aload 15
    //   299: invokestatic 168	pl/droidsonroids/gif/l:a	(Ljava/io/Closeable;)V
    //   302: aload 14
    //   304: athrow
    //   305: astore 9
    //   307: goto -111 -> 196
    //   310: astore 7
    //   312: aconst_null
    //   313: astore 8
    //   315: goto -129 -> 186
    //   318: astore 14
    //   320: aconst_null
    //   321: astore 15
    //   323: goto -31 -> 292
    //   326: astore 14
    //   328: aload 18
    //   330: astore 15
    //   332: goto -40 -> 292
    //   335: astore 21
    //   337: aconst_null
    //   338: astore 18
    //   340: goto -73 -> 267
    //   343: astore 20
    //   345: goto -78 -> 267
    //   348: astore 14
    //   350: aconst_null
    //   351: astore 15
    //   353: aconst_null
    //   354: astore 16
    //   356: goto -64 -> 292
    //
    // Exception table:
    //   from	to	target	type
    //   134	141	180	finally
    //   146	180	180	finally
    //   229	243	180	finally
    //   276	286	180	finally
    //   292	305	180	finally
    //   248	253	255	java/io/IOException
    //   199	208	259	java/io/IOException
    //   191	196	305	java/io/IOException
    //   117	124	310	finally
    //   212	222	318	finally
    //   222	229	326	finally
    //   212	222	335	java/io/IOException
    //   222	229	343	java/io/IOException
    //   199	208	348	finally
  }

  @SuppressLint({"SetWorldReadable"})
  private static void b(File paramFile)
  {
    paramFile.setReadable(true, false);
    paramFile.setExecutable(true, false);
    paramFile.setWritable(true);
  }

  private static String[] b()
  {
    if (Build.VERSION.SDK_INT >= 21)
      return Build.SUPPORTED_ABIS;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = Build.CPU_ABI;
    arrayOfString[1] = Build.CPU_ABI2;
    return arrayOfString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.l
 * JD-Core Version:    0.6.2
 */