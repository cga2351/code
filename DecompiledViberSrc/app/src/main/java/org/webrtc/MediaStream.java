package org.webrtc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaStream
{
  private static final String TAG = "MediaStream";
  public final List<AudioTrack> audioTracks = new ArrayList();
  final long nativeStream;
  public final List<VideoTrack> preservedVideoTracks = new ArrayList();
  public final List<VideoTrack> videoTracks = new ArrayList();

  @CalledByNative
  public MediaStream(long paramLong)
  {
    this.nativeStream = paramLong;
  }

  private static native boolean nativeAddAudioTrackToNativeStream(long paramLong1, long paramLong2);

  private static native boolean nativeAddVideoTrackToNativeStream(long paramLong1, long paramLong2);

  private static native String nativeGetId(long paramLong);

  private static native boolean nativeRemoveAudioTrack(long paramLong1, long paramLong2);

  private static native boolean nativeRemoveVideoTrack(long paramLong1, long paramLong2);

  private static void removeMediaStreamTrack(List<? extends MediaStreamTrack> paramList, long paramLong)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MediaStreamTrack localMediaStreamTrack = (MediaStreamTrack)localIterator.next();
      if (localMediaStreamTrack.nativeTrack == paramLong)
      {
        localMediaStreamTrack.dispose();
        localIterator.remove();
        return;
      }
    }
    Logging.e("MediaStream", "Couldn't not find track");
  }

  @CalledByNative
  void addNativeAudioTrack(long paramLong)
  {
    this.audioTracks.add(new AudioTrack(paramLong));
  }

  @CalledByNative
  void addNativeVideoTrack(long paramLong)
  {
    this.videoTracks.add(new VideoTrack(paramLong));
  }

  public boolean addPreservedTrack(VideoTrack paramVideoTrack)
  {
    if (nativeAddVideoTrackToNativeStream(this.nativeStream, paramVideoTrack.nativeTrack))
    {
      this.preservedVideoTracks.add(paramVideoTrack);
      return true;
    }
    return false;
  }

  public boolean addTrack(AudioTrack paramAudioTrack)
  {
    if (nativeAddAudioTrackToNativeStream(this.nativeStream, paramAudioTrack.nativeTrack))
    {
      this.audioTracks.add(paramAudioTrack);
      return true;
    }
    return false;
  }

  public boolean addTrack(VideoTrack paramVideoTrack)
  {
    if (nativeAddVideoTrackToNativeStream(this.nativeStream, paramVideoTrack.nativeTrack))
    {
      this.videoTracks.add(paramVideoTrack);
      return true;
    }
    return false;
  }

  @CalledByNative
  public void dispose()
  {
    while (!this.audioTracks.isEmpty())
    {
      AudioTrack localAudioTrack = (AudioTrack)this.audioTracks.get(0);
      removeTrack(localAudioTrack);
      localAudioTrack.dispose();
    }
    while (!this.videoTracks.isEmpty())
    {
      VideoTrack localVideoTrack = (VideoTrack)this.videoTracks.get(0);
      removeTrack(localVideoTrack);
      localVideoTrack.dispose();
    }
    while (!this.preservedVideoTracks.isEmpty())
      removeTrack((VideoTrack)this.preservedVideoTracks.get(0));
    JniCommon.nativeReleaseRef(this.nativeStream);
  }

  public String getId()
  {
    return nativeGetId(this.nativeStream);
  }

  @CalledByNative
  void removeAudioTrack(long paramLong)
  {
    removeMediaStreamTrack(this.audioTracks, paramLong);
  }

  public boolean removeTrack(AudioTrack paramAudioTrack)
  {
    this.audioTracks.remove(paramAudioTrack);
    return nativeRemoveAudioTrack(this.nativeStream, paramAudioTrack.nativeTrack);
  }

  public boolean removeTrack(VideoTrack paramVideoTrack)
  {
    this.videoTracks.remove(paramVideoTrack);
    this.preservedVideoTracks.remove(paramVideoTrack);
    return nativeRemoveVideoTrack(this.nativeStream, paramVideoTrack.nativeTrack);
  }

  @CalledByNative
  void removeVideoTrack(long paramLong)
  {
    removeMediaStreamTrack(this.videoTracks, paramLong);
  }

  public String toString()
  {
    return "[" + getId() + ":A=" + this.audioTracks.size() + ":V=" + this.videoTracks.size() + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.MediaStream
 * JD-Core Version:    0.6.2
 */