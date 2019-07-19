package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask.Status;
import android.widget.ImageView;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;

public class VastVideoView extends VideoView
{
  private VastVideoBlurLastVideoFrameTask a;
  private MediaMetadataRetriever b;

  public VastVideoView(Context paramContext)
  {
    super(paramContext);
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    this.b = new MediaMetadataRetriever();
  }

  @Deprecated
  @VisibleForTesting
  VastVideoBlurLastVideoFrameTask getBlurLastVideoFrameTask()
  {
    return this.a;
  }

  public void onDestroy()
  {
    if ((this.a != null) && (this.a.getStatus() != AsyncTask.Status.FINISHED))
      this.a.cancel(true);
  }

  public void prepareBlurredLastVideoFrame(ImageView paramImageView, String paramString)
  {
    if (this.b != null)
      this.a = new VastVideoBlurLastVideoFrameTask(this.b, paramImageView, getDuration());
    try
    {
      AsyncTasks.safeExecuteOnExecutor(this.a, new String[] { paramString });
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to blur last video frame", localException });
    }
  }

  @Deprecated
  @VisibleForTesting
  void setBlurLastVideoFrameTask(VastVideoBlurLastVideoFrameTask paramVastVideoBlurLastVideoFrameTask)
  {
    this.a = paramVastVideoBlurLastVideoFrameTask;
  }

  @Deprecated
  @VisibleForTesting
  void setMediaMetadataRetriever(MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    this.b = paramMediaMetadataRetriever;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoView
 * JD-Core Version:    0.6.2
 */