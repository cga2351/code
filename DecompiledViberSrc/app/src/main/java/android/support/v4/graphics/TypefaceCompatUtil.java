package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class TypefaceCompatUtil
{
  private static final String CACHE_FILE_PREFIX = ".font";
  private static final String TAG = "TypefaceCompatUtil";

  public static void closeQuietly(Closeable paramCloseable)
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

  public static ByteBuffer copyToDirectBuffer(Context paramContext, Resources paramResources, int paramInt)
  {
    File localFile = getTempFile(paramContext);
    if (localFile == null)
      return null;
    try
    {
      boolean bool = copyToFile(localFile, paramResources, paramInt);
      if (!bool)
        return null;
      ByteBuffer localByteBuffer = mmap(localFile);
      return localByteBuffer;
    }
    finally
    {
      localFile.delete();
    }
  }

  public static boolean copyToFile(File paramFile, Resources paramResources, int paramInt)
  {
    InputStream localInputStream = null;
    try
    {
      localInputStream = paramResources.openRawResource(paramInt);
      boolean bool = copyToFile(paramFile, localInputStream);
      return bool;
    }
    finally
    {
      closeQuietly(localInputStream);
    }
  }

  // ERROR //
  public static boolean copyToFile(File paramFile, InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 61	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_2
    //   4: new 63	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: iconst_0
    //   10: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   13: astore_3
    //   14: sipush 1024
    //   17: newarray byte
    //   19: astore 7
    //   21: aload_1
    //   22: aload 7
    //   24: invokevirtual 72	java/io/InputStream:read	([B)I
    //   27: istore 8
    //   29: iload 8
    //   31: iconst_m1
    //   32: if_icmpeq +56 -> 88
    //   35: aload_3
    //   36: aload 7
    //   38: iconst_0
    //   39: iload 8
    //   41: invokevirtual 76	java/io/FileOutputStream:write	([BII)V
    //   44: goto -23 -> 21
    //   47: astore 5
    //   49: ldc 11
    //   51: new 78	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   58: ldc 81
    //   60: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 5
    //   65: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   68: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 98	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_3
    //   79: invokestatic 55	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   82: aload_2
    //   83: invokestatic 102	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   86: iconst_0
    //   87: ireturn
    //   88: aload_3
    //   89: invokestatic 55	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   92: aload_2
    //   93: invokestatic 102	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   96: iconst_1
    //   97: ireturn
    //   98: astore 4
    //   100: aconst_null
    //   101: astore_3
    //   102: aload_3
    //   103: invokestatic 55	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   106: aload_2
    //   107: invokestatic 102	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   110: aload 4
    //   112: athrow
    //   113: astore 4
    //   115: goto -13 -> 102
    //   118: astore 5
    //   120: aconst_null
    //   121: astore_3
    //   122: goto -73 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   14	21	47	java/io/IOException
    //   21	29	47	java/io/IOException
    //   35	44	47	java/io/IOException
    //   4	14	98	finally
    //   14	21	113	finally
    //   21	29	113	finally
    //   35	44	113	finally
    //   49	78	113	finally
    //   4	14	118	java/io/IOException
  }

  public static File getTempFile(Context paramContext)
  {
    String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
    int i = 0;
    while (i < 100)
    {
      File localFile = new File(paramContext.getCacheDir(), str + i);
      try
      {
        boolean bool = localFile.createNewFile();
        if (bool)
          return localFile;
      }
      catch (IOException localIOException)
      {
        i++;
      }
    }
    return null;
  }

  // ERROR //
  public static ByteBuffer mmap(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 135	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_3
    //   5: aload_3
    //   6: aload_2
    //   7: ldc 137
    //   9: aload_1
    //   10: invokevirtual 143	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore 5
    //   15: aload 5
    //   17: ifnonnull +42 -> 59
    //   20: aload 5
    //   22: ifnull +12 -> 34
    //   25: iconst_0
    //   26: ifeq +25 -> 51
    //   29: aload 5
    //   31: invokevirtual 146	android/os/ParcelFileDescriptor:close	()V
    //   34: aconst_null
    //   35: astore 21
    //   37: aload 21
    //   39: areturn
    //   40: astore 24
    //   42: aconst_null
    //   43: aload 24
    //   45: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   48: goto -14 -> 34
    //   51: aload 5
    //   53: invokevirtual 146	android/os/ParcelFileDescriptor:close	()V
    //   56: goto -22 -> 34
    //   59: new 152	java/io/FileInputStream
    //   62: dup
    //   63: aload 5
    //   65: invokevirtual 156	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   68: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   71: astore 6
    //   73: aload 6
    //   75: invokevirtual 163	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   78: astore 17
    //   80: aload 17
    //   82: invokevirtual 169	java/nio/channels/FileChannel:size	()J
    //   85: lstore 18
    //   87: aload 17
    //   89: getstatic 175	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   92: lconst_0
    //   93: lload 18
    //   95: invokevirtual 179	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   98: astore 20
    //   100: aload 20
    //   102: astore 21
    //   104: aload 6
    //   106: ifnull +12 -> 118
    //   109: iconst_0
    //   110: ifeq +80 -> 190
    //   113: aload 6
    //   115: invokevirtual 180	java/io/FileInputStream:close	()V
    //   118: aload 5
    //   120: ifnull -83 -> 37
    //   123: iconst_0
    //   124: ifeq +82 -> 206
    //   127: aload 5
    //   129: invokevirtual 146	android/os/ParcelFileDescriptor:close	()V
    //   132: aload 21
    //   134: areturn
    //   135: astore 22
    //   137: aconst_null
    //   138: aload 22
    //   140: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   143: aload 21
    //   145: areturn
    //   146: astore 23
    //   148: aconst_null
    //   149: aload 23
    //   151: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   154: goto -36 -> 118
    //   157: astore 12
    //   159: aload 12
    //   161: athrow
    //   162: astore 13
    //   164: aload 12
    //   166: astore 10
    //   168: aload 13
    //   170: astore 9
    //   172: aload 5
    //   174: ifnull +13 -> 187
    //   177: aload 10
    //   179: ifnull +100 -> 279
    //   182: aload 5
    //   184: invokevirtual 146	android/os/ParcelFileDescriptor:close	()V
    //   187: aload 9
    //   189: athrow
    //   190: aload 6
    //   192: invokevirtual 180	java/io/FileInputStream:close	()V
    //   195: goto -77 -> 118
    //   198: astore 9
    //   200: aconst_null
    //   201: astore 10
    //   203: goto -31 -> 172
    //   206: aload 5
    //   208: invokevirtual 146	android/os/ParcelFileDescriptor:close	()V
    //   211: aload 21
    //   213: areturn
    //   214: astore 15
    //   216: aload 15
    //   218: athrow
    //   219: astore 16
    //   221: aload 15
    //   223: astore 8
    //   225: aload 16
    //   227: astore 7
    //   229: aload 6
    //   231: ifnull +13 -> 244
    //   234: aload 8
    //   236: ifnull +23 -> 259
    //   239: aload 6
    //   241: invokevirtual 180	java/io/FileInputStream:close	()V
    //   244: aload 7
    //   246: athrow
    //   247: astore 14
    //   249: aload 8
    //   251: aload 14
    //   253: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   256: goto -12 -> 244
    //   259: aload 6
    //   261: invokevirtual 180	java/io/FileInputStream:close	()V
    //   264: goto -20 -> 244
    //   267: astore 11
    //   269: aload 10
    //   271: aload 11
    //   273: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   276: goto -89 -> 187
    //   279: aload 5
    //   281: invokevirtual 146	android/os/ParcelFileDescriptor:close	()V
    //   284: goto -97 -> 187
    //   287: astore 7
    //   289: aconst_null
    //   290: astore 8
    //   292: goto -63 -> 229
    //   295: astore 4
    //   297: aconst_null
    //   298: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   29	34	40	java/lang/Throwable
    //   127	132	135	java/lang/Throwable
    //   113	118	146	java/lang/Throwable
    //   59	73	157	java/lang/Throwable
    //   148	154	157	java/lang/Throwable
    //   190	195	157	java/lang/Throwable
    //   244	247	157	java/lang/Throwable
    //   249	256	157	java/lang/Throwable
    //   259	264	157	java/lang/Throwable
    //   159	162	162	finally
    //   59	73	198	finally
    //   113	118	198	finally
    //   148	154	198	finally
    //   190	195	198	finally
    //   239	244	198	finally
    //   244	247	198	finally
    //   249	256	198	finally
    //   259	264	198	finally
    //   73	100	214	java/lang/Throwable
    //   216	219	219	finally
    //   239	244	247	java/lang/Throwable
    //   182	187	267	java/lang/Throwable
    //   73	100	287	finally
    //   5	15	295	java/io/IOException
    //   29	34	295	java/io/IOException
    //   42	48	295	java/io/IOException
    //   51	56	295	java/io/IOException
    //   127	132	295	java/io/IOException
    //   137	143	295	java/io/IOException
    //   182	187	295	java/io/IOException
    //   187	190	295	java/io/IOException
    //   206	211	295	java/io/IOException
    //   269	276	295	java/io/IOException
    //   279	284	295	java/io/IOException
  }

  // ERROR //
  private static ByteBuffer mmap(File paramFile)
  {
    // Byte code:
    //   0: new 152	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 183	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 163	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore 8
    //   15: aload 8
    //   17: invokevirtual 169	java/nio/channels/FileChannel:size	()J
    //   20: lstore 9
    //   22: aload 8
    //   24: getstatic 175	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   27: lconst_0
    //   28: lload 9
    //   30: invokevirtual 179	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   33: astore 11
    //   35: aload_1
    //   36: ifnull +11 -> 47
    //   39: iconst_0
    //   40: ifeq +21 -> 61
    //   43: aload_1
    //   44: invokevirtual 180	java/io/FileInputStream:close	()V
    //   47: aload 11
    //   49: areturn
    //   50: astore 12
    //   52: aconst_null
    //   53: aload 12
    //   55: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   58: aload 11
    //   60: areturn
    //   61: aload_1
    //   62: invokevirtual 180	java/io/FileInputStream:close	()V
    //   65: aload 11
    //   67: areturn
    //   68: astore 6
    //   70: aload 6
    //   72: athrow
    //   73: astore 7
    //   75: aload 6
    //   77: astore_3
    //   78: aload 7
    //   80: astore_2
    //   81: aload_1
    //   82: ifnull +11 -> 93
    //   85: aload_3
    //   86: ifnull +20 -> 106
    //   89: aload_1
    //   90: invokevirtual 180	java/io/FileInputStream:close	()V
    //   93: aload_2
    //   94: athrow
    //   95: astore 5
    //   97: aload_3
    //   98: aload 5
    //   100: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   103: goto -10 -> 93
    //   106: aload_1
    //   107: invokevirtual 180	java/io/FileInputStream:close	()V
    //   110: goto -17 -> 93
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_3
    //   116: goto -35 -> 81
    //   119: astore 4
    //   121: aconst_null
    //   122: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/lang/Throwable
    //   9	35	68	java/lang/Throwable
    //   70	73	73	finally
    //   89	93	95	java/lang/Throwable
    //   9	35	113	finally
    //   0	9	119	java/io/IOException
    //   43	47	119	java/io/IOException
    //   52	58	119	java/io/IOException
    //   61	65	119	java/io/IOException
    //   89	93	119	java/io/IOException
    //   93	95	119	java/io/IOException
    //   97	103	119	java/io/IOException
    //   106	110	119	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatUtil
 * JD-Core Version:    0.6.2
 */