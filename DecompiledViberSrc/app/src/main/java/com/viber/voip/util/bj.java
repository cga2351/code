package com.viber.voip.util;

import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.b.a;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class bj
{
  private static final Logger a = ViberEnv.getLogger();

  // ERROR //
  public static Uri a(String[] paramArrayOfString, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 21	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 29	java/io/File:createNewFile	()Z
    //   15: ifne +10 -> 25
    //   18: aload_3
    //   19: invokevirtual 32	java/io/File:exists	()Z
    //   22: ifeq +201 -> 223
    //   25: new 34	java/util/zip/ZipOutputStream
    //   28: dup
    //   29: new 36	java/io/BufferedOutputStream
    //   32: dup
    //   33: new 38	java/io/FileOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 39	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   41: invokespecial 42	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: invokespecial 43	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: astore 8
    //   49: sipush 4096
    //   52: invokestatic 48	com/viber/voip/b/b/a:a	(I)[B
    //   55: astore 9
    //   57: aload 9
    //   59: astore 5
    //   61: iload_2
    //   62: aload_0
    //   63: arraylength
    //   64: if_icmpge +105 -> 169
    //   67: new 50	java/io/BufferedInputStream
    //   70: dup
    //   71: new 52	java/io/FileInputStream
    //   74: dup
    //   75: aload_0
    //   76: iload_2
    //   77: aaload
    //   78: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   81: sipush 4096
    //   84: invokespecial 56	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   87: astore 11
    //   89: aload 8
    //   91: new 58	java/util/zip/ZipEntry
    //   94: dup
    //   95: aload_0
    //   96: iload_2
    //   97: aaload
    //   98: iconst_1
    //   99: aload_0
    //   100: iload_2
    //   101: aaload
    //   102: ldc 60
    //   104: invokevirtual 66	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   107: iadd
    //   108: invokevirtual 70	java/lang/String:substring	(I)Ljava/lang/String;
    //   111: invokespecial 71	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 75	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   117: aload 11
    //   119: aload 5
    //   121: iconst_0
    //   122: sipush 4096
    //   125: invokevirtual 79	java/io/BufferedInputStream:read	([BII)I
    //   128: istore 12
    //   130: iload 12
    //   132: iconst_m1
    //   133: if_icmpeq +25 -> 158
    //   136: aload 8
    //   138: aload 5
    //   140: iconst_0
    //   141: iload 12
    //   143: invokevirtual 83	java/util/zip/ZipOutputStream:write	([BII)V
    //   146: goto -29 -> 117
    //   149: astore 10
    //   151: aload 5
    //   153: invokestatic 86	com/viber/voip/b/b/a:a	([B)V
    //   156: aconst_null
    //   157: areturn
    //   158: aload 11
    //   160: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   163: iinc 2 1
    //   166: goto -105 -> 61
    //   169: aload 8
    //   171: invokevirtual 92	java/util/zip/ZipOutputStream:closeEntry	()V
    //   174: aload 8
    //   176: invokevirtual 93	java/util/zip/ZipOutputStream:close	()V
    //   179: aload_3
    //   180: invokestatic 99	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   183: astore 13
    //   185: aload 5
    //   187: invokestatic 86	com/viber/voip/b/b/a:a	([B)V
    //   190: aload 13
    //   192: areturn
    //   193: astore 6
    //   195: aconst_null
    //   196: astore 5
    //   198: aload 6
    //   200: astore 7
    //   202: aload 5
    //   204: invokestatic 86	com/viber/voip/b/b/a:a	([B)V
    //   207: aload 7
    //   209: athrow
    //   210: astore 7
    //   212: goto -10 -> 202
    //   215: astore 4
    //   217: aconst_null
    //   218: astore 5
    //   220: goto -69 -> 151
    //   223: aconst_null
    //   224: astore 5
    //   226: goto -47 -> 179
    //
    // Exception table:
    //   from	to	target	type
    //   61	117	149	java/lang/Exception
    //   117	130	149	java/lang/Exception
    //   136	146	149	java/lang/Exception
    //   158	163	149	java/lang/Exception
    //   169	179	149	java/lang/Exception
    //   179	185	149	java/lang/Exception
    //   2	25	193	finally
    //   25	57	193	finally
    //   61	117	210	finally
    //   117	130	210	finally
    //   136	146	210	finally
    //   158	163	210	finally
    //   169	179	210	finally
    //   179	185	210	finally
    //   2	25	215	java/lang/Exception
    //   25	57	215	java/lang/Exception
  }

  public static InputStream a(String paramString)
    throws IOException
  {
    OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
    Request.Builder localBuilder1 = new Request.Builder().url(paramString);
    return localBuilder.build().newCall(localBuilder1.build()).execute().body().byteStream();
  }

  public static String a(InputStream paramInputStream)
  {
    if (paramInputStream == null)
      return "";
    ByteArrayOutputStream localByteArrayOutputStream = null;
    byte[] arrayOfByte = a.a(4096);
    Object localObject1 = "";
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        if (localByteArrayOutputStream == null)
          localByteArrayOutputStream = new ByteArrayOutputStream(i);
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (IOException localIOException)
    {
      return localObject1;
      if (localByteArrayOutputStream != null)
      {
        String str = localByteArrayOutputStream.toString();
        localObject1 = str;
      }
      return localObject1;
    }
    finally
    {
      a(new Closeable[] { paramInputStream, localByteArrayOutputStream });
      a.a(arrayOfByte);
    }
  }

  public static void a(Closeable paramCloseable)
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

  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = a.a(4096);
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      a.a(arrayOfByte);
    }
    a.a(arrayOfByte);
  }

  public static void a(String paramString1, String paramString2)
    throws IOException
  {
    File localFile = new File(paramString1);
    if ((localFile.createNewFile()) || (localFile.exists()))
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString1);
      localFileOutputStream.write(239);
      localFileOutputStream.write(187);
      localFileOutputStream.write(191);
      PrintWriter localPrintWriter = new PrintWriter(new OutputStreamWriter(localFileOutputStream, "UTF-8"));
      localPrintWriter.print(paramString2);
      localPrintWriter.flush();
      localPrintWriter.close();
    }
  }

  public static void a(Closeable[] paramArrayOfCloseable)
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
        catch (IOException localIOException)
        {
          break label24;
        }
      }
  }

  public static void a(Flushable[] paramArrayOfFlushable)
  {
    int i = paramArrayOfFlushable.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        Flushable localFlushable = paramArrayOfFlushable[j];
        if (localFlushable != null);
        try
        {
          localFlushable.flush();
          label24: j++;
        }
        catch (IOException localIOException)
        {
          break label24;
        }
      }
  }

  public static void a(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      at.f(new File(paramArrayOfString[j]));
  }

  public static boolean a(Uri paramUri)
  {
    return (dk.b(paramUri)) && (new File(paramUri.getPath()).exists());
  }

  // ERROR //
  public static boolean a(File paramFile1, File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull +7 -> 10
    //   6: aload_0
    //   7: ifnonnull +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: new 52	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 228	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: invokevirtual 232	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   23: astore 5
    //   25: new 38	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: invokevirtual 234	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   36: astore 6
    //   38: aload 6
    //   40: aload 5
    //   42: lconst_0
    //   43: aload 5
    //   45: invokevirtual 240	java/nio/channels/FileChannel:size	()J
    //   48: invokevirtual 244	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   51: pop2
    //   52: iconst_2
    //   53: anewarray 169	java/io/Closeable
    //   56: dup
    //   57: iconst_0
    //   58: aload 5
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload 6
    //   65: aastore
    //   66: invokestatic 172	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_3
    //   72: aconst_null
    //   73: astore 4
    //   75: iconst_2
    //   76: anewarray 169	java/io/Closeable
    //   79: dup
    //   80: iconst_0
    //   81: aload_2
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: aload 4
    //   87: aastore
    //   88: invokestatic 172	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   91: aload_3
    //   92: athrow
    //   93: astore_3
    //   94: aload 5
    //   96: astore_2
    //   97: aconst_null
    //   98: astore 4
    //   100: goto -25 -> 75
    //   103: astore 7
    //   105: aload 5
    //   107: astore_2
    //   108: aload 6
    //   110: astore 4
    //   112: aload 7
    //   114: astore_3
    //   115: goto -40 -> 75
    //
    // Exception table:
    //   from	to	target	type
    //   12	25	71	finally
    //   25	38	93	finally
    //   38	52	103	finally
  }

  // ERROR //
  public static boolean a(java.io.FileDescriptor paramFileDescriptor, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnull +7 -> 10
    //   6: aload_1
    //   7: ifnonnull +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: new 52	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 248	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   20: invokevirtual 232	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   23: astore 9
    //   25: aload 9
    //   27: astore 8
    //   29: new 38	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: invokevirtual 234	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   40: astore 12
    //   42: aload 12
    //   44: astore_2
    //   45: aload_2
    //   46: aload 8
    //   48: lconst_0
    //   49: aload 8
    //   51: invokevirtual 240	java/nio/channels/FileChannel:size	()J
    //   54: invokevirtual 244	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   57: pop2
    //   58: iconst_2
    //   59: anewarray 169	java/io/Closeable
    //   62: dup
    //   63: iconst_0
    //   64: aload 8
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_2
    //   70: aastore
    //   71: invokestatic 172	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   74: iconst_1
    //   75: ireturn
    //   76: astore 7
    //   78: aconst_null
    //   79: astore 8
    //   81: iconst_2
    //   82: anewarray 169	java/io/Closeable
    //   85: dup
    //   86: iconst_0
    //   87: aload 8
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload_2
    //   93: aastore
    //   94: invokestatic 172	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_3
    //   100: aconst_null
    //   101: astore 4
    //   103: aload_3
    //   104: astore 5
    //   106: aconst_null
    //   107: astore 6
    //   109: iconst_2
    //   110: anewarray 169	java/io/Closeable
    //   113: dup
    //   114: iconst_0
    //   115: aload 4
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload 6
    //   122: aastore
    //   123: invokestatic 172	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   126: aload 5
    //   128: athrow
    //   129: astore 11
    //   131: aload 8
    //   133: astore 4
    //   135: aload 11
    //   137: astore 5
    //   139: aconst_null
    //   140: astore 6
    //   142: goto -33 -> 109
    //   145: astore 13
    //   147: aload 8
    //   149: astore 4
    //   151: aload_2
    //   152: astore 6
    //   154: aload 13
    //   156: astore 5
    //   158: goto -49 -> 109
    //   161: astore 10
    //   163: goto -82 -> 81
    //
    // Exception table:
    //   from	to	target	type
    //   12	25	76	java/lang/Exception
    //   12	25	99	finally
    //   29	42	129	finally
    //   45	58	145	finally
    //   29	42	161	java/lang/Exception
    //   45	58	161	java/lang/Exception
  }

  public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    byte[] arrayOfByte = a.a(4096);
    long l = 0L;
    int i;
    try
    {
      while (true)
      {
        i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        l += i;
        if (l >= paramLong)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      a.a(arrayOfByte);
    }
    a.a(arrayOfByte);
    return (i == -1) && (l <= paramLong);
  }

  public static byte[] a(InputStream paramInputStream, int paramInt)
  {
    return a(paramInputStream, new ByteArrayOutputStream(paramInt));
  }

  public static byte[] a(InputStream paramInputStream, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    try
    {
      a(paramInputStream, paramByteArrayOutputStream);
      byte[] arrayOfByte2 = paramByteArrayOutputStream.toByteArray();
      return arrayOfByte2;
    }
    catch (IOException localIOException)
    {
      byte[] arrayOfByte1 = new byte[0];
      return arrayOfByte1;
    }
    finally
    {
      a(new Closeable[] { paramInputStream, paramByteArrayOutputStream });
    }
  }

  public static void b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = a.a(4096);
    while (true)
    {
      int i;
      try
      {
        i = paramInputStream.read(arrayOfByte);
        break label51;
        paramOutputStream.write(arrayOfByte, 0, i);
        int j = paramInputStream.read(arrayOfByte);
        i = j;
        break label51;
        return;
      }
      finally
      {
        a.a(arrayOfByte);
      }
      label51: if (i != -1)
        if (i != 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bj
 * JD-Core Version:    0.6.2
 */