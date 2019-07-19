package org.webrtc;

import javax.annotation.Nullable;

public class MediaStreamTrack
{
  public static final String AUDIO_TRACK_KIND = "audio";
  public static final String VIDEO_TRACK_KIND = "video";
  final long nativeTrack;

  public MediaStreamTrack(long paramLong)
  {
    this.nativeTrack = paramLong;
  }

  @Nullable
  static MediaStreamTrack createMediaStreamTrack(long paramLong)
  {
    if (paramLong == 0L);
    String str;
    do
    {
      return null;
      str = nativeGetKind(paramLong);
      if (str.equals("audio"))
        return new AudioTrack(paramLong);
    }
    while (!str.equals("video"));
    return new VideoTrack(paramLong);
  }

  private static native boolean nativeGetEnabled(long paramLong);

  private static native String nativeGetId(long paramLong);

  private static native String nativeGetKind(long paramLong);

  private static native State nativeGetState(long paramLong);

  private static native boolean nativeSetEnabled(long paramLong, boolean paramBoolean);

  public void dispose()
  {
    JniCommon.nativeReleaseRef(this.nativeTrack);
  }

  public boolean enabled()
  {
    return nativeGetEnabled(this.nativeTrack);
  }

  public String id()
  {
    return nativeGetId(this.nativeTrack);
  }

  public String kind()
  {
    return nativeGetKind(this.nativeTrack);
  }

  public boolean setEnabled(boolean paramBoolean)
  {
    return nativeSetEnabled(this.nativeTrack, paramBoolean);
  }

  public State state()
  {
    return nativeGetState(this.nativeTrack);
  }

  public static enum MediaType
  {
    private final int nativeIndex;

    static
    {
      MediaType[] arrayOfMediaType = new MediaType[2];
      arrayOfMediaType[0] = MEDIA_TYPE_AUDIO;
      arrayOfMediaType[1] = MEDIA_TYPE_VIDEO;
    }

    private MediaType(int paramInt)
    {
      this.nativeIndex = paramInt;
    }

    @CalledByNative("MediaType")
    static MediaType fromNativeIndex(int paramInt)
    {
      for (MediaType localMediaType : values())
        if (localMediaType.getNative() == paramInt)
          return localMediaType;
      throw new IllegalArgumentException("Unknown native media type: " + paramInt);
    }

    @CalledByNative("MediaType")
    int getNative()
    {
      return this.nativeIndex;
    }
  }

  public static enum State
  {
    static
    {
      ENDED = new State("ENDED", 1);
      State[] arrayOfState = new State[2];
      arrayOfState[0] = LIVE;
      arrayOfState[1] = ENDED;
    }

    @CalledByNative("State")
    static State fromNativeIndex(int paramInt)
    {
      return values()[paramInt];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.MediaStreamTrack
 * JD-Core Version:    0.6.2
 */