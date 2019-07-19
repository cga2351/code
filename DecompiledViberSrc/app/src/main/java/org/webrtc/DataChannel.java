package org.webrtc;

import java.nio.ByteBuffer;

public class DataChannel
{
  private final long nativeDataChannel;
  private long nativeObserver;

  @CalledByNative
  public DataChannel(long paramLong)
  {
    this.nativeDataChannel = paramLong;
  }

  private native long nativeBufferedAmount();

  private native void nativeClose();

  private native int nativeId();

  private native String nativeLabel();

  private native long nativeRegisterObserver(Observer paramObserver);

  private native boolean nativeSend(byte[] paramArrayOfByte, boolean paramBoolean);

  private native State nativeState();

  private native void nativeUnregisterObserver(long paramLong);

  public long bufferedAmount()
  {
    return nativeBufferedAmount();
  }

  public void close()
  {
    nativeClose();
  }

  public void dispose()
  {
    JniCommon.nativeReleaseRef(this.nativeDataChannel);
  }

  @CalledByNative
  long getNativeDataChannel()
  {
    return this.nativeDataChannel;
  }

  public int id()
  {
    return nativeId();
  }

  public String label()
  {
    return nativeLabel();
  }

  public void registerObserver(Observer paramObserver)
  {
    if (this.nativeObserver != 0L)
      nativeUnregisterObserver(this.nativeObserver);
    this.nativeObserver = nativeRegisterObserver(paramObserver);
  }

  public boolean send(Buffer paramBuffer)
  {
    byte[] arrayOfByte = new byte[paramBuffer.data.remaining()];
    paramBuffer.data.get(arrayOfByte);
    return nativeSend(arrayOfByte, paramBuffer.binary);
  }

  public State state()
  {
    return nativeState();
  }

  public void unregisterObserver()
  {
    nativeUnregisterObserver(this.nativeObserver);
  }

  public static class Buffer
  {
    public final boolean binary;
    public final ByteBuffer data;

    @CalledByNative("Buffer")
    public Buffer(ByteBuffer paramByteBuffer, boolean paramBoolean)
    {
      this.data = paramByteBuffer;
      this.binary = paramBoolean;
    }
  }

  public static class Init
  {
    public int id = -1;
    public int maxRetransmitTimeMs = -1;
    public int maxRetransmits = -1;
    public boolean negotiated = false;
    public boolean ordered = true;
    public String protocol = "";

    @CalledByNative("Init")
    int getId()
    {
      return this.id;
    }

    @CalledByNative("Init")
    int getMaxRetransmitTimeMs()
    {
      return this.maxRetransmitTimeMs;
    }

    @CalledByNative("Init")
    int getMaxRetransmits()
    {
      return this.maxRetransmits;
    }

    @CalledByNative("Init")
    boolean getNegotiated()
    {
      return this.negotiated;
    }

    @CalledByNative("Init")
    boolean getOrdered()
    {
      return this.ordered;
    }

    @CalledByNative("Init")
    String getProtocol()
    {
      return this.protocol;
    }
  }

  public static abstract interface Observer
  {
    @CalledByNative("Observer")
    public abstract void onBufferedAmountChange(long paramLong);

    @CalledByNative("Observer")
    public abstract void onMessage(DataChannel.Buffer paramBuffer);

    @CalledByNative("Observer")
    public abstract void onStateChange();
  }

  public static enum State
  {
    static
    {
      CLOSING = new State("CLOSING", 2);
      CLOSED = new State("CLOSED", 3);
      State[] arrayOfState = new State[4];
      arrayOfState[0] = CONNECTING;
      arrayOfState[1] = OPEN;
      arrayOfState[2] = CLOSING;
      arrayOfState[3] = CLOSED;
    }

    @CalledByNative("State")
    static State fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.DataChannel
 * JD-Core Version:    0.6.2
 */