package com.google.android.gms.internal.firebase_messaging;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzk
{
  private static final Logger logger = Logger.getLogger(zzk.class.getName());

  public static void zza(@NullableDecl InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException localIOException1)
    {
      try
      {
        logger.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", localIOException1);
        return;
      }
      catch (IOException localIOException2)
      {
        throw new AssertionError(localIOException2);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzk
 * JD-Core Version:    0.6.2
 */