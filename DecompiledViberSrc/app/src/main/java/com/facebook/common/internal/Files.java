package com.facebook.common.internal;

import java.io.IOException;
import java.io.InputStream;

public class Files
{
  static byte[] readFile(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L)
      throw new OutOfMemoryError("file is too large to fit in a byte array: " + paramLong + " bytes");
    if (paramLong == 0L)
      return ByteStreams.toByteArray(paramInputStream);
    return ByteStreams.toByteArray(paramInputStream, (int)paramLong);
  }

  // ERROR //
  public static byte[] toByteArray(java.io.File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: new 49	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: aload_1
    //   11: invokevirtual 56	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   14: invokevirtual 62	java/nio/channels/FileChannel:size	()J
    //   17: invokestatic 64	com/facebook/common/internal/Files:readFile	(Ljava/io/InputStream;J)[B
    //   20: astore_3
    //   21: aload_1
    //   22: ifnull +7 -> 29
    //   25: aload_1
    //   26: invokevirtual 67	java/io/FileInputStream:close	()V
    //   29: aload_3
    //   30: areturn
    //   31: astore_2
    //   32: aconst_null
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +7 -> 42
    //   38: aload_1
    //   39: invokevirtual 67	java/io/FileInputStream:close	()V
    //   42: aload_2
    //   43: athrow
    //   44: astore_2
    //   45: goto -11 -> 34
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	31	finally
    //   9	21	44	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.Files
 * JD-Core Version:    0.6.2
 */