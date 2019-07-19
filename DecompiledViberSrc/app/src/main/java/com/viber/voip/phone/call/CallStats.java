package com.viber.voip.phone.call;

import android.os.SystemClock;

public class CallStats
  implements Cloneable
{
  private static final long END_CALL_DURATION_MAX = 86400000L;
  private long mCallDuration;
  private long mDataInterruptedMax;
  private long mDataInterruptedStart;
  private long mElapsedRealtimeBase;
  private long mLocalVideoDuration;
  private long mLocalVideoStart;
  private long mRemoteVideoDuration;
  private long mRemoveVideoStart;
  private long mTransferDuration;
  private long mTransferStart;

  private long getDuration(long paramLong)
  {
    return SystemClock.elapsedRealtime() - paramLong;
  }

  private long getTimerBase()
  {
    return SystemClock.elapsedRealtime();
  }

  public long getCallDuration()
  {
    if (this.mElapsedRealtimeBase > 0L)
      return this.mCallDuration + getDuration(this.mElapsedRealtimeBase);
    return this.mCallDuration;
  }

  public long getDataInterruptedMax()
  {
    if (this.mDataInterruptedStart > 0L)
    {
      long l = getDuration(this.mDataInterruptedStart);
      if (l > this.mDataInterruptedMax)
        this.mDataInterruptedMax = l;
    }
    return this.mDataInterruptedMax;
  }

  public long getLocalVideoDuration()
  {
    if (this.mLocalVideoStart > 0L)
      return this.mLocalVideoDuration + getDuration(this.mLocalVideoStart);
    return this.mLocalVideoDuration;
  }

  public long getRemoteVideoDuration()
  {
    if (this.mRemoveVideoStart > 0L)
      return this.mRemoteVideoDuration + getDuration(this.mRemoveVideoStart);
    return this.mRemoteVideoDuration;
  }

  public long getTransferDuration()
  {
    if (this.mTransferStart > 0L)
      return getDuration(this.mTransferStart);
    return this.mTransferDuration;
  }

  public CallStats pauseCall()
  {
    this.mCallDuration = getCallDuration();
    return this;
  }

  public CallStats startCall()
  {
    this.mElapsedRealtimeBase = getTimerBase();
    return this;
  }

  public CallStats startCallTransfer()
  {
    this.mTransferStart = getTimerBase();
    return this;
  }

  public CallStats startDataInterruption()
  {
    this.mDataInterruptedStart = getTimerBase();
    return this;
  }

  public CallStats startLocalVideo()
  {
    this.mLocalVideoStart = getTimerBase();
    return this;
  }

  public CallStats startRemoteVideo()
  {
    this.mRemoveVideoStart = getTimerBase();
    return this;
  }

  public CallStats stopCall()
  {
    this.mCallDuration += getCallDuration();
    this.mElapsedRealtimeBase = 0L;
    stopDataInterruption();
    stopCallTransfer();
    stopRemoteVideo();
    stopLocalVideo();
    return this;
  }

  public CallStats stopCallTransfer()
  {
    if (this.mTransferStart > 0L)
    {
      this.mTransferDuration = getDuration(this.mTransferStart);
      this.mTransferStart = 0L;
    }
    return this;
  }

  public CallStats stopDataInterruption()
  {
    if (this.mDataInterruptedStart > 0L)
    {
      long l = getDuration(this.mDataInterruptedStart);
      if (l > this.mDataInterruptedMax)
        this.mDataInterruptedMax = l;
      this.mDataInterruptedStart = 0L;
    }
    return this;
  }

  public CallStats stopLocalVideo()
  {
    if (this.mLocalVideoStart > 0L)
    {
      this.mLocalVideoDuration += getDuration(this.mLocalVideoStart);
      this.mLocalVideoStart = 0L;
    }
    return this;
  }

  public CallStats stopRemoteVideo()
  {
    if (this.mRemoveVideoStart > 0L)
    {
      this.mRemoteVideoDuration += getDuration(this.mRemoveVideoStart);
      this.mRemoveVideoStart = 0L;
    }
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.CallStats
 * JD-Core Version:    0.6.2
 */