package com.yandex.metrica.impl;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Base64;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.impl.ob.mi;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public final class w
{
  public static int a(Reader paramReader, Writer paramWriter)
    throws IOException
  {
    char[] arrayOfChar = new char[4096];
    int i = 0;
    while (true)
    {
      int j = paramReader.read(arrayOfChar, 0, 4096);
      if (-1 == j)
        break;
      paramWriter.write(arrayOfChar, 0, j);
      i += j;
    }
    return i;
  }

  public static String a(Context paramContext, File paramFile)
  {
    byte[] arrayOfByte = b(paramContext, paramFile);
    try
    {
      String str1 = new String(arrayOfByte, "UTF-8");
      return str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str2 = new String(arrayOfByte);
      mi.a(paramContext).reportError("read_share_file_with_unsupported_encoding", localUnsupportedEncodingException);
      return str2;
    }
  }

  public static String a(InputStream paramInputStream)
    throws IOException
  {
    InputStreamReader localInputStreamReader = new InputStreamReader(paramInputStream, "UTF-8");
    StringWriter localStringWriter = new StringWriter();
    a(localInputStreamReader, localStringWriter);
    return localStringWriter.toString();
  }

  // ERROR //
  public static String a(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: new 71	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokestatic 76	com/yandex/metrica/impl/w:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   13: astore_3
    //   14: aload_1
    //   15: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   18: aload_3
    //   19: areturn
    //   20: astore_2
    //   21: aconst_null
    //   22: astore_1
    //   23: aload_1
    //   24: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   27: aload_2
    //   28: athrow
    //   29: astore_2
    //   30: goto -7 -> 23
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	20	finally
    //   9	14	29	finally
  }

  @SuppressLint({"WorldReadableFiles"})
  public static void a(Context paramContext, String paramString)
  {
    if (bw.a(24));
    try
    {
      File localFile2 = new File(paramContext.getNoBackupFilesDir(), paramString);
      if ((localFile2.exists()) && (localFile2.canWrite()))
        localFile2.delete();
      try
      {
        label44: File localFile1 = new File(paramContext.getFileStreamPath(paramString).getAbsolutePath());
        if ((localFile1.exists()) && (localFile1.canWrite()))
          localFile1.delete();
        return;
      }
      catch (Exception localException1)
      {
      }
    }
    catch (Exception localException2)
    {
      break label44;
    }
  }

  @SuppressLint({"WorldReadableFiles"})
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (bw.a(24))
      {
        a(paramString2, paramContext.openFileOutput(paramString1, 0));
        c(paramContext, paramContext.getFileStreamPath(paramString1));
        return;
      }
      a(paramString2, paramContext.openFileOutput(paramString1, 1));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
  }

  // ERROR //
  private static void a(String paramString, FileOutputStream paramFileOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 139	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   6: astore 7
    //   8: aload 7
    //   10: invokevirtual 145	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   13: astore 8
    //   15: aload 8
    //   17: astore_2
    //   18: aload_0
    //   19: ldc 31
    //   21: invokevirtual 149	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   24: astore 10
    //   26: aload 10
    //   28: arraylength
    //   29: invokestatic 155	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   32: astore 11
    //   34: aload 11
    //   36: aload 10
    //   38: invokevirtual 159	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   41: pop
    //   42: aload 11
    //   44: invokevirtual 163	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   47: pop
    //   48: aload 7
    //   50: aload 11
    //   52: invokevirtual 166	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   55: pop
    //   56: aload 7
    //   58: iconst_1
    //   59: invokevirtual 170	java/nio/channels/FileChannel:force	(Z)V
    //   62: aload_2
    //   63: invokestatic 173	com/yandex/metrica/impl/w:a	(Ljava/nio/channels/FileLock;)V
    //   66: aload_1
    //   67: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   70: return
    //   71: astore 6
    //   73: aload_2
    //   74: invokestatic 173	com/yandex/metrica/impl/w:a	(Ljava/nio/channels/FileLock;)V
    //   77: aload_1
    //   78: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   81: return
    //   82: astore_3
    //   83: aconst_null
    //   84: astore 4
    //   86: aload_3
    //   87: astore 5
    //   89: aload 4
    //   91: invokestatic 173	com/yandex/metrica/impl/w:a	(Ljava/nio/channels/FileLock;)V
    //   94: aload_1
    //   95: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   98: aload 5
    //   100: athrow
    //   101: astore 9
    //   103: aload_2
    //   104: astore 4
    //   106: aload 9
    //   108: astore 5
    //   110: goto -21 -> 89
    //
    // Exception table:
    //   from	to	target	type
    //   2	15	71	java/io/IOException
    //   18	62	71	java/io/IOException
    //   2	15	82	finally
    //   18	62	101	finally
  }

  public static void a(FileLock paramFileLock)
  {
    if ((paramFileLock != null) && (paramFileLock.isValid()));
    try
    {
      paramFileLock.release();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static byte[] a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int i = 0;
    if (paramInputStream == null)
      return null;
    byte[] arrayOfByte1 = new byte[8192];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      while (true)
      {
        int j = paramInputStream.read(arrayOfByte1);
        if ((-1 == j) || (i > paramInt))
        {
          byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          return arrayOfByte2;
        }
        if (j > 0)
        {
          localByteArrayOutputStream.write(arrayOfByte1, 0, j);
          i += j;
        }
      }
    }
    finally
    {
      bw.a(localByteArrayOutputStream);
    }
  }

  // ERROR //
  public static byte[] a(byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 184	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 185	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore_2
    //   10: new 200	java/util/zip/GZIPOutputStream
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 203	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: invokevirtual 205	java/util/zip/GZIPOutputStream:write	([B)V
    //   24: aload_3
    //   25: invokevirtual 208	java/util/zip/GZIPOutputStream:finish	()V
    //   28: aload_2
    //   29: invokevirtual 194	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   32: astore 5
    //   34: aload_3
    //   35: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   38: aload_2
    //   39: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   42: aload 5
    //   44: areturn
    //   45: astore 4
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_3
    //   50: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   53: aload_1
    //   54: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   57: aload 4
    //   59: athrow
    //   60: astore 4
    //   62: aload_2
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_3
    //   66: goto -17 -> 49
    //   69: astore 4
    //   71: aload_2
    //   72: astore_1
    //   73: goto -24 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   2	10	45	finally
    //   10	19	60	finally
    //   19	34	69	finally
  }

  public static String b(String paramString)
  {
    try
    {
      String str = Base64.encodeToString(a(paramString.getBytes("UTF-8")), 0);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  @TargetApi(21)
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = new File(paramContext.getNoBackupFilesDir(), paramString1);
    try
    {
      a(paramString2, new FileOutputStream(localFile));
      c(paramContext, localFile);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
  }

  // ERROR //
  public static byte[] b(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: new 227	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_1
    //   5: ldc 229
    //   7: invokespecial 230	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 231	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: astore 15
    //   17: aload 15
    //   19: lconst_0
    //   20: ldc2_w 232
    //   23: iconst_1
    //   24: invokevirtual 236	java/nio/channels/FileChannel:lock	(JJZ)Ljava/nio/channels/FileLock;
    //   27: astore 16
    //   29: aload 16
    //   31: astore 8
    //   33: aload_1
    //   34: invokevirtual 240	java/io/File:length	()J
    //   37: l2i
    //   38: invokestatic 155	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   41: astore 19
    //   43: aload 15
    //   45: aload 19
    //   47: invokevirtual 242	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   50: pop
    //   51: aload 19
    //   53: invokevirtual 163	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   56: pop
    //   57: aload 19
    //   59: invokevirtual 245	java/nio/ByteBuffer:array	()[B
    //   62: astore 22
    //   64: aload_1
    //   65: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: pop
    //   69: aload 8
    //   71: invokestatic 173	com/yandex/metrica/impl/w:a	(Ljava/nio/channels/FileLock;)V
    //   74: aload_2
    //   75: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   78: aload 22
    //   80: areturn
    //   81: astore 26
    //   83: aconst_null
    //   84: astore 5
    //   86: aconst_null
    //   87: astore 4
    //   89: aload_1
    //   90: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   93: pop
    //   94: aload 5
    //   96: invokestatic 173	com/yandex/metrica/impl/w:a	(Ljava/nio/channels/FileLock;)V
    //   99: aload 4
    //   101: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   104: aconst_null
    //   105: areturn
    //   106: astore 25
    //   108: aconst_null
    //   109: astore 8
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_1
    //   114: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   117: pop
    //   118: aload 8
    //   120: invokestatic 173	com/yandex/metrica/impl/w:a	(Ljava/nio/channels/FileLock;)V
    //   123: aload_2
    //   124: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore 10
    //   131: aconst_null
    //   132: astore 8
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_0
    //   137: invokestatic 43	com/yandex/metrica/impl/ob/mi:a	(Landroid/content/Context;)Lcom/yandex/metrica/c;
    //   140: ldc 247
    //   142: aload 10
    //   144: invokeinterface 250 3 0
    //   149: aload_1
    //   150: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   153: pop
    //   154: aload 8
    //   156: invokestatic 173	com/yandex/metrica/impl/w:a	(Ljava/nio/channels/FileLock;)V
    //   159: aload_2
    //   160: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore 24
    //   167: aconst_null
    //   168: astore 8
    //   170: aconst_null
    //   171: astore_2
    //   172: aload 24
    //   174: astore 11
    //   176: aload_1
    //   177: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: pop
    //   181: aload 8
    //   183: invokestatic 173	com/yandex/metrica/impl/w:a	(Ljava/nio/channels/FileLock;)V
    //   186: aload_2
    //   187: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   190: aload 11
    //   192: athrow
    //   193: astore 14
    //   195: aload 14
    //   197: astore 11
    //   199: aconst_null
    //   200: astore 8
    //   202: goto -26 -> 176
    //   205: astore 11
    //   207: goto -31 -> 176
    //   210: astore 10
    //   212: aconst_null
    //   213: astore 8
    //   215: goto -79 -> 136
    //   218: astore 10
    //   220: goto -84 -> 136
    //   223: astore 7
    //   225: aconst_null
    //   226: astore 8
    //   228: goto -115 -> 113
    //   231: astore 18
    //   233: goto -120 -> 113
    //   236: astore_3
    //   237: aload_2
    //   238: astore 4
    //   240: aconst_null
    //   241: astore 5
    //   243: goto -154 -> 89
    //   246: astore 17
    //   248: aload 8
    //   250: astore 5
    //   252: aload_2
    //   253: astore 4
    //   255: goto -166 -> 89
    //
    // Exception table:
    //   from	to	target	type
    //   0	11	81	java/io/IOException
    //   0	11	106	java/lang/SecurityException
    //   0	11	129	java/lang/Throwable
    //   0	11	165	finally
    //   11	29	193	finally
    //   33	64	205	finally
    //   136	149	205	finally
    //   11	29	210	java/lang/Throwable
    //   33	64	218	java/lang/Throwable
    //   11	29	223	java/lang/SecurityException
    //   33	64	231	java/lang/SecurityException
    //   11	29	236	java/io/IOException
    //   33	64	246	java/io/IOException
  }

  // ERROR //
  public static byte[] b(byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 252	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 253	java/io/ByteArrayInputStream:<init>	([B)V
    //   10: astore_2
    //   11: new 255	java/util/zip/GZIPInputStream
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 258	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 259
    //   24: invokestatic 261	com/yandex/metrica/impl/w:a	(Ljava/io/InputStream;I)[B
    //   27: astore 5
    //   29: aload_3
    //   30: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   33: aload_2
    //   34: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   37: aload 5
    //   39: areturn
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_3
    //   44: aload_3
    //   45: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   48: aload_1
    //   49: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   52: aload 4
    //   54: athrow
    //   55: astore 4
    //   57: aload_2
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_3
    //   61: goto -17 -> 44
    //   64: astore 4
    //   66: aload_2
    //   67: astore_1
    //   68: goto -24 -> 44
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	40	finally
    //   11	20	55	finally
    //   20	29	64	finally
  }

  // ERROR //
  public static String c(String paramString)
  {
    // Byte code:
    //   0: new 252	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: iconst_0
    //   6: invokestatic 265	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   9: invokespecial 253	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: astore_1
    //   13: new 255	java/util/zip/GZIPInputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 258	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 76	com/yandex/metrica/impl/w:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore 5
    //   28: aload_2
    //   29: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   32: aload_1
    //   33: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   36: aload 5
    //   38: areturn
    //   39: astore 9
    //   41: aconst_null
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_1
    //   45: aload_2
    //   46: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   53: aconst_null
    //   54: areturn
    //   55: astore 8
    //   57: aconst_null
    //   58: astore_1
    //   59: aload 8
    //   61: astore 4
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   69: aload_1
    //   70: invokestatic 81	com/yandex/metrica/impl/bw:a	(Ljava/io/Closeable;)V
    //   73: aload 4
    //   75: athrow
    //   76: astore 7
    //   78: aload 7
    //   80: astore 4
    //   82: aconst_null
    //   83: astore_2
    //   84: goto -19 -> 65
    //   87: astore 4
    //   89: goto -24 -> 65
    //   92: astore 6
    //   94: aconst_null
    //   95: astore_2
    //   96: goto -51 -> 45
    //   99: astore_3
    //   100: goto -55 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   0	13	39	java/lang/Exception
    //   0	13	55	finally
    //   13	22	76	finally
    //   22	28	87	finally
    //   13	22	92	java/lang/Exception
    //   22	28	99	java/lang/Exception
  }

  @SuppressLint({"SetWorldReadable"})
  @TargetApi(9)
  public static void c(final Context paramContext, File paramFile)
  {
    if (paramFile.exists())
    {
      paramFile.setReadable(true, false);
      if (bw.a(24))
        new File(paramContext.getApplicationInfo().dataDir).setExecutable(true, false);
      return;
    }
    mi.a(paramContext).reportEvent("make_non_existed_world_readable", new HashMap()
    {
    });
  }

  public static byte[] c(byte[] paramArrayOfByte)
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramArrayOfByte);
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return new byte[0];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.w
 * JD-Core Version:    0.6.2
 */