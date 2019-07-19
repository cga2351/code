package org.webrtc;

public class MediaSource
{
  final long nativeSource;

  public MediaSource(long paramLong)
  {
    this.nativeSource = paramLong;
  }

  private static native State nativeGetState(long paramLong);

  public void dispose()
  {
    JniCommon.nativeReleaseRef(this.nativeSource);
  }

  public State state()
  {
    return nativeGetState(this.nativeSource);
  }

  public static enum State
  {
    static
    {
      ENDED = new State("ENDED", 2);
      MUTED = new State("MUTED", 3);
      State[] arrayOfState = new State[4];
      arrayOfState[0] = INITIALIZING;
      arrayOfState[1] = LIVE;
      arrayOfState[2] = ENDED;
      arrayOfState[3] = MUTED;
    }

    @CalledByNative("State")
    static State fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.MediaSource
 * JD-Core Version:    0.6.2
 */