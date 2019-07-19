package org.webrtc;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;

public class VideoTrack extends MediaStreamTrack
{
  private final IdentityHashMap<VideoSink, Long> sinks = new IdentityHashMap();

  public VideoTrack(long paramLong)
  {
    super(paramLong);
  }

  private static native void nativeAddSink(long paramLong1, long paramLong2);

  private static native void nativeFreeSink(long paramLong);

  private static native void nativeRemoveSink(long paramLong1, long paramLong2);

  private static native long nativeWrapSink(VideoSink paramVideoSink);

  public void addSink(VideoSink paramVideoSink)
  {
    if (paramVideoSink == null)
      throw new IllegalArgumentException("The VideoSink is not allowed to be null");
    if (!this.sinks.containsKey(paramVideoSink))
    {
      long l = nativeWrapSink(paramVideoSink);
      this.sinks.put(paramVideoSink, Long.valueOf(l));
      nativeAddSink(this.nativeTrack, l);
    }
  }

  public void dispose()
  {
    Iterator localIterator = this.sinks.values().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      nativeRemoveSink(this.nativeTrack, l);
      nativeFreeSink(l);
    }
    this.sinks.clear();
    super.dispose();
  }

  public void removeSink(VideoSink paramVideoSink)
  {
    Long localLong = (Long)this.sinks.remove(paramVideoSink);
    if (localLong != null)
    {
      nativeRemoveSink(this.nativeTrack, localLong.longValue());
      nativeFreeSink(localLong.longValue());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoTrack
 * JD-Core Version:    0.6.2
 */