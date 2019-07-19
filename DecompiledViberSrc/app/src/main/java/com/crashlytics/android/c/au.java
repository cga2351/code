package com.crashlytics.android.c;

import java.io.File;
import java.io.IOException;

class au
  implements c.a
{
  // ERROR //
  private static String a(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: new 16	java/io/BufferedInputStream
    //   3: dup
    //   4: new 18	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 21	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 24	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic 30	c/a/a/a/a/b/i:b	(Ljava/io/InputStream;)Ljava/lang/String;
    //   20: astore_3
    //   21: aload_1
    //   22: invokestatic 33	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   25: aload_3
    //   26: areturn
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 33	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;)V
    //   34: aload_2
    //   35: athrow
    //   36: astore_2
    //   37: goto -7 -> 30
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	27	finally
    //   16	21	36	finally
  }

  public String a(File paramFile)
    throws IOException
  {
    return a(paramFile.getPath());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.au
 * JD-Core Version:    0.6.2
 */