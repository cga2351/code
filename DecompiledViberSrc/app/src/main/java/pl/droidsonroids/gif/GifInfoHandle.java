package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class GifInfoHandle
{
  private volatile long a;

  static
  {
    j.a(null);
  }

  GifInfoHandle()
  {
  }

  // ERROR //
  GifInfoHandle(android.content.res.AssetFileDescriptor paramAssetFileDescriptor)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 16	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 25	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   9: aload_1
    //   10: invokevirtual 29	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   13: invokestatic 33	pl/droidsonroids/gif/GifInfoHandle:openFd	(Ljava/io/FileDescriptor;J)J
    //   16: putfield 35	pl/droidsonroids/gif/GifInfoHandle:a	J
    //   19: aload_1
    //   20: invokevirtual 38	android/content/res/AssetFileDescriptor:close	()V
    //   23: return
    //   24: astore_2
    //   25: aload_1
    //   26: invokevirtual 38	android/content/res/AssetFileDescriptor:close	()V
    //   29: aload_2
    //   30: athrow
    //   31: astore 4
    //   33: return
    //   34: astore_3
    //   35: goto -6 -> 29
    //
    // Exception table:
    //   from	to	target	type
    //   4	19	24	finally
    //   19	23	31	java/io/IOException
    //   25	29	34	java/io/IOException
  }

  GifInfoHandle(FileDescriptor paramFileDescriptor)
    throws GifIOException
  {
    this.a = openFd(paramFileDescriptor, 0L);
  }

  GifInfoHandle(InputStream paramInputStream)
    throws GifIOException
  {
    if (!paramInputStream.markSupported())
      throw new IllegalArgumentException("InputStream does not support marking");
    this.a = openStream(paramInputStream);
  }

  GifInfoHandle(String paramString)
    throws GifIOException
  {
    this.a = openFile(paramString);
  }

  GifInfoHandle(ByteBuffer paramByteBuffer)
    throws GifIOException
  {
    this.a = openDirectByteBuffer(paramByteBuffer);
  }

  GifInfoHandle(byte[] paramArrayOfByte)
    throws GifIOException
  {
    this.a = openByteArray(paramArrayOfByte);
  }

  static GifInfoHandle a(ContentResolver paramContentResolver, Uri paramUri)
    throws IOException
  {
    if ("file".equals(paramUri.getScheme()))
      return new GifInfoHandle(paramUri.getPath());
    return new GifInfoHandle(paramContentResolver.openAssetFileDescriptor(paramUri, "r"));
  }

  private static native void bindSurface(long paramLong, Surface paramSurface, long[] paramArrayOfLong);

  private static native void free(long paramLong);

  private static native long getAllocationByteCount(long paramLong);

  private static native String getComment(long paramLong);

  private static native int getCurrentFrameIndex(long paramLong);

  private static native int getCurrentLoop(long paramLong);

  private static native int getCurrentPosition(long paramLong);

  private static native int getDuration(long paramLong);

  private static native int getFrameDuration(long paramLong, int paramInt);

  private static native int getHeight(long paramLong);

  private static native int getLoopCount(long paramLong);

  private static native long getMetadataByteCount(long paramLong);

  private static native int getNativeErrorCode(long paramLong);

  private static native int getNumberOfFrames(long paramLong);

  private static native long[] getSavedState(long paramLong);

  private static native long getSourceLength(long paramLong);

  private static native int getWidth(long paramLong);

  private static native void glTexImage2D(long paramLong, int paramInt1, int paramInt2);

  private static native void glTexSubImage2D(long paramLong, int paramInt1, int paramInt2);

  private static native void initTexImageDescriptor(long paramLong);

  private static native boolean isAnimationCompleted(long paramLong);

  private static native boolean isOpaque(long paramLong);

  static native long openByteArray(byte[] paramArrayOfByte)
    throws GifIOException;

  static native long openDirectByteBuffer(ByteBuffer paramByteBuffer)
    throws GifIOException;

  static native long openFd(FileDescriptor paramFileDescriptor, long paramLong)
    throws GifIOException;

  static native long openFile(String paramString)
    throws GifIOException;

  static native long openStream(InputStream paramInputStream)
    throws GifIOException;

  private static native void postUnbindSurface(long paramLong);

  private static native long renderFrame(long paramLong, Bitmap paramBitmap);

  private static native boolean reset(long paramLong);

  private static native long restoreRemainder(long paramLong);

  private static native int restoreSavedState(long paramLong, long[] paramArrayOfLong, Bitmap paramBitmap);

  private static native void saveRemainder(long paramLong);

  private static native void seekToFrame(long paramLong, int paramInt, Bitmap paramBitmap);

  private static native void seekToFrameGL(long paramLong, int paramInt);

  private static native void seekToTime(long paramLong, int paramInt, Bitmap paramBitmap);

  private static native void setLoopCount(long paramLong, char paramChar);

  private static native void setOptions(long paramLong, char paramChar, boolean paramBoolean);

  private static native void setSpeedFactor(long paramLong, float paramFloat);

  private static native void startDecoderThread(long paramLong);

  private static native void stopDecoderThread(long paramLong);

  int a(long[] paramArrayOfLong, Bitmap paramBitmap)
  {
    try
    {
      int i = restoreSavedState(this.a, paramArrayOfLong, paramBitmap);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long a(Bitmap paramBitmap)
  {
    try
    {
      long l = renderFrame(this.a, paramBitmap);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a()
  {
    try
    {
      free(this.a);
      this.a = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(char paramChar, boolean paramBoolean)
  {
    setOptions(this.a, paramChar, paramBoolean);
  }

  void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535))
      throw new IllegalArgumentException("Loop count of range <0, 65535>");
    try
    {
      setLoopCount(this.a, (char)paramInt);
      return;
    }
    finally
    {
    }
  }

  void a(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      seekToTime(this.a, paramInt, paramBitmap);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long b()
  {
    try
    {
      long l = restoreRemainder(this.a);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void b(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      seekToFrame(this.a, paramInt, paramBitmap);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean c()
  {
    try
    {
      boolean bool = reset(this.a);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void d()
  {
    try
    {
      saveRemainder(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int e()
  {
    try
    {
      int i = getLoopCount(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int f()
  {
    try
    {
      int i = getNativeErrorCode(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      a();
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  int g()
  {
    try
    {
      int i = getDuration(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int h()
  {
    try
    {
      int i = getCurrentPosition(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int i()
  {
    try
    {
      int i = getCurrentFrameIndex(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int j()
  {
    try
    {
      int i = getCurrentLoop(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long k()
  {
    try
    {
      long l = getAllocationByteCount(this.a);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  long l()
  {
    try
    {
      long l = getMetadataByteCount(this.a);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean m()
  {
    try
    {
      long l = this.a;
      if (l == 0L)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  long[] n()
  {
    try
    {
      long[] arrayOfLong = getSavedState(this.a);
      return arrayOfLong;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int o()
  {
    try
    {
      int i = getWidth(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int p()
  {
    try
    {
      int i = getHeight(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  int q()
  {
    try
    {
      int i = getNumberOfFrames(this.a);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean r()
  {
    try
    {
      boolean bool = isOpaque(this.a);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.GifInfoHandle
 * JD-Core Version:    0.6.2
 */