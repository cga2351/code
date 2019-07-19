package com.crashlytics.android.c;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

final class ah
{
  private static File a(File paramFile, String paramString)
  {
    for (File localFile : paramFile.listFiles())
      if (localFile.getName().endsWith(paramString))
        return localFile;
    return null;
  }

  private static byte[] a(Context paramContext, String paramString)
    throws IOException
  {
    return new c(paramContext, new au()).a(paramString);
  }

  // ERROR //
  static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: new 44	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokestatic 50	com/crashlytics/android/c/ah:a	(Ljava/io/InputStream;)[B
    //   13: astore 5
    //   15: aload_1
    //   16: invokestatic 55	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   19: aload 5
    //   21: areturn
    //   22: astore 8
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_1
    //   27: invokestatic 55	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   30: aconst_null
    //   31: areturn
    //   32: astore 7
    //   34: aconst_null
    //   35: astore_1
    //   36: aload_1
    //   37: invokestatic 55	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   40: aconst_null
    //   41: areturn
    //   42: astore 6
    //   44: aconst_null
    //   45: astore_1
    //   46: aload 6
    //   48: astore 4
    //   50: aload_1
    //   51: invokestatic 55	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   54: aload 4
    //   56: athrow
    //   57: astore 4
    //   59: goto -9 -> 50
    //   62: astore_3
    //   63: goto -27 -> 36
    //   66: astore_2
    //   67: goto -41 -> 26
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	22	java/io/FileNotFoundException
    //   0	9	32	java/io/IOException
    //   0	9	42	finally
    //   9	15	57	finally
    //   9	15	62	java/io/IOException
    //   9	15	66	java/io/FileNotFoundException
  }

  static byte[] a(File paramFile, Context paramContext)
    throws IOException
  {
    File localFile1 = a(paramFile, ".maps");
    if (localFile1 != null)
      return c(localFile1, paramContext);
    File localFile2 = a(paramFile, ".binary_libs");
    if (localFile2 != null)
      return b(localFile2, paramContext);
    return null;
  }

  private static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }

  static byte[] b(File paramFile)
  {
    File localFile = a(paramFile, ".dmp");
    if (localFile == null)
      return new byte[0];
    return d(localFile);
  }

  private static byte[] b(File paramFile, Context paramContext)
    throws IOException
  {
    byte[] arrayOfByte = a(paramFile);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      return null;
    return a(paramContext, new String(arrayOfByte));
  }

  static byte[] c(File paramFile)
  {
    File localFile = a(paramFile, ".device_info");
    if (localFile == null)
      return null;
    return a(localFile);
  }

  // ERROR //
  private static byte[] c(File paramFile, Context paramContext)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 103	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 105	java/io/BufferedReader
    //   12: dup
    //   13: new 107	java/io/FileReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 108	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   21: invokespecial 111	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: new 27	com/crashlytics/android/c/c
    //   28: dup
    //   29: aload_1
    //   30: new 29	com/crashlytics/android/c/au
    //   33: dup
    //   34: invokespecial 33	com/crashlytics/android/c/au:<init>	()V
    //   37: invokespecial 36	com/crashlytics/android/c/c:<init>	(Landroid/content/Context;Lcom/crashlytics/android/c/c$a;)V
    //   40: aload_2
    //   41: invokevirtual 114	com/crashlytics/android/c/c:a	(Ljava/io/BufferedReader;)[B
    //   44: astore 4
    //   46: aload_2
    //   47: invokestatic 55	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   50: aload 4
    //   52: areturn
    //   53: astore 5
    //   55: aconst_null
    //   56: astore_2
    //   57: aload 5
    //   59: astore_3
    //   60: aload_2
    //   61: invokestatic 55	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   64: aload_3
    //   65: athrow
    //   66: astore_3
    //   67: goto -7 -> 60
    //
    // Exception table:
    //   from	to	target	type
    //   9	25	53	finally
    //   25	46	66	finally
  }

  private static byte[] d(File paramFile)
  {
    return a(paramFile);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ah
 * JD-Core Version:    0.6.2
 */