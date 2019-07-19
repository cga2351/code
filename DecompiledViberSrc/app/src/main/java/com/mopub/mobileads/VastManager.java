package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;

public class VastManager
  implements VastXmlManagerAggregator.b
{
  private VastManagerListener a;
  private VastXmlManagerAggregator b;
  private String c;
  private double d;
  private int e;
  private final boolean f;

  public VastManager(Context paramContext, boolean paramBoolean)
  {
    a(paramContext);
    this.f = paramBoolean;
  }

  private void a(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    if (f1 <= 0.0F)
      f1 = 1.0F;
    int k = Math.max(i, j);
    int m = Math.min(i, j);
    this.d = (k / m);
    this.e = ((int)(k / f1 * (m / f1)));
  }

  private boolean a(VastVideoConfig paramVastVideoConfig)
  {
    Preconditions.checkNotNull(paramVastVideoConfig, "vastVideoConfig cannot be null");
    String str = paramVastVideoConfig.getNetworkMediaFileUrl();
    if (CacheService.containsKeyDiskCache(str))
    {
      paramVastVideoConfig.setDiskMediaFileUrl(CacheService.getFilePathDiskCache(str));
      return true;
    }
    return false;
  }

  public void cancel()
  {
    if (this.b != null)
    {
      this.b.cancel(true);
      this.b = null;
    }
  }

  public void onAggregationComplete(final VastVideoConfig paramVastVideoConfig)
  {
    if (this.a == null)
      throw new IllegalStateException("mVastManagerListener cannot be null here. Did you call prepareVastVideoConfiguration()?");
    if (paramVastVideoConfig == null)
    {
      this.a.onVastVideoConfigurationPrepared(null);
      return;
    }
    if (!TextUtils.isEmpty(this.c))
      paramVastVideoConfig.setDspCreativeId(this.c);
    if ((!this.f) || (a(paramVastVideoConfig)))
    {
      this.a.onVastVideoConfigurationPrepared(paramVastVideoConfig);
      return;
    }
    VideoDownloader.a local1 = new VideoDownloader.a()
    {
      public void onComplete(boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousBoolean) && (VastManager.a(VastManager.this, paramVastVideoConfig)))
        {
          VastManager.a(VastManager.this).onVastVideoConfigurationPrepared(paramVastVideoConfig);
          return;
        }
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Failed to download VAST video." });
        VastManager.a(VastManager.this).onVastVideoConfigurationPrepared(null);
      }
    };
    VideoDownloader.cache(paramVastVideoConfig.getNetworkMediaFileUrl(), local1);
  }

  public void prepareVastVideoConfiguration(String paramString1, VastManagerListener paramVastManagerListener, String paramString2, Context paramContext)
  {
    Preconditions.checkNotNull(paramVastManagerListener, "vastManagerListener cannot be null");
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    if (this.b == null)
    {
      this.a = paramVastManagerListener;
      this.b = new VastXmlManagerAggregator(this, this.d, this.e, paramContext.getApplicationContext());
      this.c = paramString2;
    }
    try
    {
      AsyncTasks.safeExecuteOnExecutor(this.b, new String[] { paramString1 });
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to aggregate vast xml", localException });
      this.a.onVastVideoConfigurationPrepared(null);
    }
  }

  public static abstract interface VastManagerListener
  {
    public abstract void onVastVideoConfigurationPrepared(VastVideoConfig paramVastVideoConfig);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastManager
 * JD-Core Version:    0.6.2
 */