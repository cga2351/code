package org.webrtc;

import java.nio.ByteBuffer;

public class JniCommon
{
  public static native void nativeAddRef(long paramLong);

  public static native ByteBuffer nativeAllocateByteBuffer(int paramInt);

  public static native void nativeFreeByteBuffer(ByteBuffer paramByteBuffer);

  public static native void nativeReleaseRef(long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.JniCommon
 * JD-Core Version:    0.6.2
 */