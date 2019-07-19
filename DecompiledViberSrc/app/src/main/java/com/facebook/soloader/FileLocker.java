package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import javax.annotation.Nullable;

public final class FileLocker
  implements Closeable
{

  @Nullable
  private final FileLock mLock;
  private final FileOutputStream mLockFileOutputStream;

  private FileLocker(File paramFile)
    throws IOException
  {
    this.mLockFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      FileLock localFileLock = this.mLockFileOutputStream.getChannel().lock();
      if (localFileLock == null)
        this.mLockFileOutputStream.close();
      this.mLock = localFileLock;
      return;
    }
    finally
    {
      if (0 == 0)
        this.mLockFileOutputStream.close();
    }
  }

  public static FileLocker lock(File paramFile)
    throws IOException
  {
    return new FileLocker(paramFile);
  }

  public void close()
    throws IOException
  {
    try
    {
      if (this.mLock != null)
        this.mLock.release();
      return;
    }
    finally
    {
      this.mLockFileOutputStream.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.FileLocker
 * JD-Core Version:    0.6.2
 */