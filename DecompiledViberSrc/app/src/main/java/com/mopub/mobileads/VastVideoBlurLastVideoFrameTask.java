package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.ImageUtils;

public class VastVideoBlurLastVideoFrameTask extends AsyncTask<String, Void, Boolean>
{
  private final MediaMetadataRetriever a;
  private final ImageView b;
  private int c;
  private Bitmap d;
  private Bitmap e;

  public VastVideoBlurLastVideoFrameTask(MediaMetadataRetriever paramMediaMetadataRetriever, ImageView paramImageView, int paramInt)
  {
    this.a = paramMediaMetadataRetriever;
    this.b = paramImageView;
    this.c = paramInt;
  }

  protected Boolean a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfString[0] == null))
      return Boolean.valueOf(false);
    try
    {
      String str = paramArrayOfString[0];
      this.a.setDataSource(str);
      this.d = this.a.getFrameAtTime(1000 * this.c - 200000, 3);
      if (this.d == null)
        return Boolean.valueOf(false);
      this.e = ImageUtils.applyFastGaussianBlurToBitmap(this.d, 4);
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to blur last video frame", localException });
    }
    return Boolean.valueOf(false);
  }

  protected void a(Boolean paramBoolean)
  {
    if (isCancelled())
      onCancelled();
    while ((paramBoolean == null) || (!paramBoolean.booleanValue()))
      return;
    this.b.setImageBitmap(this.e);
    this.b.setImageAlpha(100);
  }

  protected void onCancelled()
  {
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "VastVideoBlurLastVideoFrameTask was cancelled." });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoBlurLastVideoFrameTask
 * JD-Core Version:    0.6.2
 */