package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;

public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder
{
  private static Method sGetFileDescriptorMethod;

  // ERROR //
  private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, @javax.annotation.Nullable byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: ifnonnull +111 -> 114
    //   6: iconst_0
    //   7: istore 4
    //   9: new 17	android/os/MemoryFile
    //   12: dup
    //   13: aconst_null
    //   14: iload 4
    //   16: iload_1
    //   17: iadd
    //   18: invokespecial 20	android/os/MemoryFile:<init>	(Ljava/lang/String;I)V
    //   21: astore 5
    //   23: aload 5
    //   25: iconst_0
    //   26: invokevirtual 24	android/os/MemoryFile:allowPurging	(Z)Z
    //   29: pop
    //   30: new 26	com/facebook/common/memory/PooledByteBufferInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 32	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   38: checkcast 34	com/facebook/common/memory/PooledByteBuffer
    //   41: invokespecial 37	com/facebook/common/memory/PooledByteBufferInputStream:<init>	(Lcom/facebook/common/memory/PooledByteBuffer;)V
    //   44: astore 7
    //   46: new 39	com/facebook/common/streams/LimitedInputStream
    //   49: dup
    //   50: aload 7
    //   52: iload_1
    //   53: invokespecial 42	com/facebook/common/streams/LimitedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   56: astore 8
    //   58: aload 5
    //   60: invokevirtual 46	android/os/MemoryFile:getOutputStream	()Ljava/io/OutputStream;
    //   63: astore 12
    //   65: aload 12
    //   67: astore 11
    //   69: aload 8
    //   71: aload 11
    //   73: invokestatic 52	com/facebook/common/internal/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   76: pop2
    //   77: aload_2
    //   78: ifnull +13 -> 91
    //   81: aload 5
    //   83: aload_2
    //   84: iconst_0
    //   85: iload_1
    //   86: aload_2
    //   87: arraylength
    //   88: invokevirtual 56	android/os/MemoryFile:writeBytes	([BIII)V
    //   91: aload_0
    //   92: invokestatic 60	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   95: aload 7
    //   97: invokestatic 66	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   100: aload 8
    //   102: invokestatic 66	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   105: aload 11
    //   107: iconst_1
    //   108: invokestatic 70	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   111: aload 5
    //   113: areturn
    //   114: aload_2
    //   115: arraylength
    //   116: istore 4
    //   118: goto -109 -> 9
    //   121: astore 9
    //   123: aconst_null
    //   124: astore 11
    //   126: aconst_null
    //   127: astore 10
    //   129: aload_0
    //   130: invokestatic 60	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   133: aload 10
    //   135: invokestatic 66	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   138: aload_3
    //   139: invokestatic 66	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   142: aload 11
    //   144: iconst_1
    //   145: invokestatic 70	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   148: aload 9
    //   150: athrow
    //   151: astore 9
    //   153: aload 7
    //   155: astore 10
    //   157: aconst_null
    //   158: astore 11
    //   160: aconst_null
    //   161: astore_3
    //   162: goto -33 -> 129
    //   165: astore 9
    //   167: aload 8
    //   169: astore_3
    //   170: aload 7
    //   172: astore 10
    //   174: aconst_null
    //   175: astore 11
    //   177: goto -48 -> 129
    //   180: astore 9
    //   182: aload 8
    //   184: astore_3
    //   185: aload 7
    //   187: astore 10
    //   189: goto -60 -> 129
    //
    // Exception table:
    //   from	to	target	type
    //   30	46	121	finally
    //   46	58	151	finally
    //   58	65	165	finally
    //   69	77	180	finally
    //   81	91	180	finally
  }

  private Method getFileDescriptorMethod()
  {
    try
    {
      Method localMethod1 = sGetFileDescriptorMethod;
      if (localMethod1 == null);
      try
      {
        sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
        Method localMethod2 = sGetFileDescriptorMethod;
        return localMethod2;
      }
      catch (Exception localException)
      {
        throw Throwables.propagate(localException);
      }
    }
    finally
    {
    }
  }

  private FileDescriptor getMemoryFileDescriptor(MemoryFile paramMemoryFile)
  {
    try
    {
      FileDescriptor localFileDescriptor = (FileDescriptor)getFileDescriptorMethod().invoke(paramMemoryFile, new Object[0]);
      return localFileDescriptor;
    }
    catch (Exception localException)
    {
      throw Throwables.propagate(localException);
    }
  }

  protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions)
  {
    return decodeFileDescriptorAsPurgeable(paramCloseableReference, ((PooledByteBuffer)paramCloseableReference.get()).size(), null, paramOptions);
  }

  protected Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    MemoryFile localMemoryFile = null;
    try
    {
      localMemoryFile = copyToMemoryFile(paramCloseableReference, paramInt, paramArrayOfByte);
      FileDescriptor localFileDescriptor = getMemoryFileDescriptor(localMemoryFile);
      Bitmap localBitmap = (Bitmap)Preconditions.checkNotNull(WebpSupportStatus.sWebpBitmapFactory.decodeFileDescriptor(localFileDescriptor, null, paramOptions), "BitmapFactory returned null");
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      throw Throwables.propagate(localIOException);
    }
    finally
    {
      if (localMemoryFile != null)
        localMemoryFile.close();
    }
  }

  protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions)
  {
    if (endsWithEOI(paramCloseableReference, paramInt));
    for (byte[] arrayOfByte = null; ; arrayOfByte = EOI)
      return decodeFileDescriptorAsPurgeable(paramCloseableReference, paramInt, arrayOfByte, paramOptions);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder
 * JD-Core Version:    0.6.2
 */