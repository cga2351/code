package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class BaseVideoPlayerActivity extends Activity
{
  public static final String VIDEO_CLASS_EXTRAS_KEY = "video_view_class_name";
  public static final String VIDEO_URL = "video_url";

  static Intent a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MraidVideoPlayerActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("video_view_class_name", "mraid");
    localIntent.putExtra("video_url", paramString);
    return localIntent;
  }

  public static Intent createIntentNativeVideo(Context paramContext, long paramLong, VastVideoConfig paramVastVideoConfig)
  {
    Intent localIntent = new Intent(paramContext, MraidVideoPlayerActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("video_view_class_name", "native");
    localIntent.putExtra("native_video_id", paramLong);
    localIntent.putExtra("native_vast_video_config", paramVastVideoConfig);
    return localIntent;
  }

  public static void startMraid(Context paramContext, String paramString)
  {
    Intent localIntent = a(paramContext, paramString);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?" });
    }
  }

  public static void startNativeVideo(Context paramContext, long paramLong, VastVideoConfig paramVastVideoConfig)
  {
    Intent localIntent = createIntentNativeVideo(paramContext, paramLong, paramVastVideoConfig);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?" });
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    AudioManager localAudioManager = (AudioManager)getSystemService("audio");
    if (localAudioManager != null)
      localAudioManager.abandonAudioFocus(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.BaseVideoPlayerActivity
 * JD-Core Version:    0.6.2
 */