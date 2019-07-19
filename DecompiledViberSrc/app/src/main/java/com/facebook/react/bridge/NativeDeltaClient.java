package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import java.nio.channels.ReadableByteChannel;

public class NativeDeltaClient
{
  private final HybridData mHybridData = initHybrid();

  static
  {
    ReactBridge.staticInit();
  }

  private static native HybridData initHybrid();

  public native void processDelta(ReadableByteChannel paramReadableByteChannel);

  public native void reset();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.NativeDeltaClient
 * JD-Core Version:    0.6.2
 */