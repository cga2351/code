package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.Closeable;

@DoNotStrip
public class NativeMemoryChunk
  implements Closeable
{
  private static final String TAG = "NativeMemoryChunk";
  private boolean mClosed;
  private final long mNativePtr;
  private final int mSize;

  static
  {
    ImagePipelineNativeLoader.load();
  }

  @VisibleForTesting
  public NativeMemoryChunk()
  {
    this.mSize = 0;
    this.mNativePtr = 0L;
    this.mClosed = true;
  }

  public NativeMemoryChunk(int paramInt)
  {
    if (paramInt > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mSize = paramInt;
      this.mNativePtr = nativeAllocate(this.mSize);
      this.mClosed = false;
      return;
    }
  }

  private int adjustByteCount(int paramInt1, int paramInt2)
  {
    return Math.min(Math.max(0, this.mSize - paramInt1), paramInt2);
  }

  private void checkBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label25: boolean bool4;
    label38: boolean bool5;
    if (paramInt4 >= 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt1 < 0)
        break label83;
      bool3 = bool1;
      Preconditions.checkArgument(bool3);
      if (paramInt3 < 0)
        break label89;
      bool4 = bool1;
      Preconditions.checkArgument(bool4);
      if (paramInt1 + paramInt4 > this.mSize)
        break label95;
      bool5 = bool1;
      label58: Preconditions.checkArgument(bool5);
      if (paramInt3 + paramInt4 > paramInt2)
        break label101;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      return;
      bool2 = false;
      break;
      label83: bool3 = false;
      break label25;
      label89: bool4 = false;
      break label38;
      label95: bool5 = false;
      break label58;
      label101: bool1 = false;
    }
  }

  private void doCopy(int paramInt1, NativeMemoryChunk paramNativeMemoryChunk, int paramInt2, int paramInt3)
  {
    boolean bool1 = true;
    boolean bool2;
    if (!isClosed())
    {
      bool2 = bool1;
      Preconditions.checkState(bool2);
      if (paramNativeMemoryChunk.isClosed())
        break label69;
    }
    while (true)
    {
      Preconditions.checkState(bool1);
      checkBounds(paramInt1, paramNativeMemoryChunk.mSize, paramInt2, paramInt3);
      nativeMemcpy(paramNativeMemoryChunk.mNativePtr + paramInt2, this.mNativePtr + paramInt1, paramInt3);
      return;
      bool2 = false;
      break;
      label69: bool1 = false;
    }
  }

  @DoNotStrip
  private static native long nativeAllocate(int paramInt);

  @DoNotStrip
  private static native void nativeCopyFromByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  @DoNotStrip
  private static native void nativeCopyToByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  @DoNotStrip
  private static native void nativeFree(long paramLong);

  @DoNotStrip
  private static native void nativeMemcpy(long paramLong1, long paramLong2, int paramInt);

  @DoNotStrip
  private static native byte nativeReadByte(long paramLong);

  public void close()
  {
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        nativeFree(this.mNativePtr);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  public void copy(int paramInt1, NativeMemoryChunk paramNativeMemoryChunk, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 87	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   9: aload_0
    //   10: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   13: lcmp
    //   14: ifne +68 -> 82
    //   17: ldc 11
    //   19: new 89	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   26: ldc 92
    //   28: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: invokestatic 102	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   35: invokestatic 108	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   38: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 110
    //   43: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokestatic 102	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   50: invokestatic 108	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   53: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 112
    //   58: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   65: invokestatic 117	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   68: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 127	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: iconst_0
    //   79: invokestatic 41	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   82: aload_2
    //   83: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   86: aload_0
    //   87: getfield 32	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   90: lcmp
    //   91: ifge +35 -> 126
    //   94: aload_2
    //   95: monitorenter
    //   96: aload_0
    //   97: monitorenter
    //   98: aload_0
    //   99: iload_1
    //   100: aload_2
    //   101: iload_3
    //   102: iload 4
    //   104: invokespecial 129	com/facebook/imagepipeline/memory/NativeMemoryChunk:doCopy	(ILcom/facebook/imagepipeline/memory/NativeMemoryChunk;II)V
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: monitorexit
    //   111: return
    //   112: astore 9
    //   114: aload_0
    //   115: monitorexit
    //   116: aload 9
    //   118: athrow
    //   119: astore 8
    //   121: aload_2
    //   122: monitorexit
    //   123: aload 8
    //   125: athrow
    //   126: aload_0
    //   127: monitorenter
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iload_1
    //   132: aload_2
    //   133: iload_3
    //   134: iload 4
    //   136: invokespecial 129	com/facebook/imagepipeline/memory/NativeMemoryChunk:doCopy	(ILcom/facebook/imagepipeline/memory/NativeMemoryChunk;II)V
    //   139: aload_2
    //   140: monitorexit
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: astore 6
    //   146: aload_0
    //   147: monitorexit
    //   148: aload 6
    //   150: athrow
    //   151: astore 7
    //   153: aload_2
    //   154: monitorexit
    //   155: aload 7
    //   157: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   98	109	112	finally
    //   114	116	112	finally
    //   96	98	119	finally
    //   109	111	119	finally
    //   116	119	119	finally
    //   121	123	119	finally
    //   128	130	144	finally
    //   141	143	144	finally
    //   146	148	144	finally
    //   155	158	144	finally
    //   130	141	151	finally
    //   153	155	151	finally
  }

  protected void finalize()
    throws Throwable
  {
    if (isClosed())
      return;
    Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.mNativePtr));
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  public long getNativePtr()
  {
    return this.mNativePtr;
  }

  public int getSize()
  {
    return this.mSize;
  }

  public boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public byte read(int paramInt)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2;
      boolean bool3;
      if (!isClosed())
      {
        bool2 = bool1;
        Preconditions.checkState(bool2);
        if (paramInt < 0)
          break label66;
        bool3 = bool1;
        label26: Preconditions.checkArgument(bool3);
        if (paramInt >= this.mSize)
          break label72;
      }
      while (true)
      {
        Preconditions.checkArgument(bool1);
        byte b = nativeReadByte(this.mNativePtr + paramInt);
        return b;
        bool2 = false;
        break;
        label66: bool3 = false;
        break label26;
        label72: bool1 = false;
      }
    }
    finally
    {
    }
  }

  public int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    try
    {
      Preconditions.checkNotNull(paramArrayOfByte);
      if (!isClosed());
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        int i = adjustByteCount(paramInt1, paramInt3);
        checkBounds(paramInt1, paramArrayOfByte.length, paramInt2, i);
        nativeCopyToByteArray(this.mNativePtr + paramInt1, paramArrayOfByte, paramInt2, i);
        return i;
      }
    }
    finally
    {
    }
  }

  public int write(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    try
    {
      Preconditions.checkNotNull(paramArrayOfByte);
      if (!isClosed());
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        int i = adjustByteCount(paramInt1, paramInt3);
        checkBounds(paramInt1, paramArrayOfByte.length, paramInt2, i);
        nativeCopyFromByteArray(this.mNativePtr + paramInt1, paramArrayOfByte, paramInt2, i);
        return i;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.NativeMemoryChunk
 * JD-Core Version:    0.6.2
 */