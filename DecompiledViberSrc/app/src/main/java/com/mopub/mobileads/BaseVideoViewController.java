package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public abstract class BaseVideoViewController
{
  private final Context a;
  private final RelativeLayout b;
  private final BaseVideoViewControllerListener c;
  private Long d;

  protected BaseVideoViewController(Context paramContext, Long paramLong, BaseVideoViewControllerListener paramBaseVideoViewControllerListener)
  {
    Preconditions.checkNotNull(paramBaseVideoViewControllerListener);
    this.a = paramContext;
    this.d = paramLong;
    this.c = paramBaseVideoViewControllerListener;
    this.b = new RelativeLayout(this.a);
  }

  protected void a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.b.addView(b(), 0, localLayoutParams);
    this.c.onSetContentView(this.b);
  }

  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  protected abstract void a(Configuration paramConfiguration);

  protected abstract void a(Bundle paramBundle);

  void a(String paramString)
  {
    if (this.d != null)
    {
      BaseBroadcastReceiver.broadcastAction(this.a, this.d.longValue(), paramString);
      return;
    }
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Tried to broadcast a video event without a broadcast identifier to send to." });
  }

  protected void a(boolean paramBoolean)
  {
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Video cannot be played." });
    a("com.mopub.action.interstitial.fail");
    if (paramBoolean)
      this.c.onFinish();
  }

  protected abstract VideoView b();

  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
      this.c.onFinish();
  }

  public boolean backButtonEnabled()
  {
    return true;
  }

  protected abstract void c();

  protected abstract void d();

  protected abstract void e();

  protected abstract void f();

  protected BaseVideoViewControllerListener g()
  {
    return this.c;
  }

  public ViewGroup getLayout()
  {
    return this.b;
  }

  protected Context h()
  {
    return this.a;
  }

  public static abstract interface BaseVideoViewControllerListener
  {
    public abstract void onFinish();

    public abstract void onSetContentView(View paramView);

    public abstract void onSetRequestedOrientation(int paramInt);

    public abstract void onStartActivityForResult(Class<? extends Activity> paramClass, int paramInt, Bundle paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.BaseVideoViewController
 * JD-Core Version:    0.6.2
 */