package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Reflection;
import com.mopub.mraid.MraidVideoViewController;

public class MraidVideoPlayerActivity extends BaseVideoPlayerActivity
  implements BaseVideoViewController.BaseVideoViewControllerListener
{
  private BaseVideoViewController a;
  private long b;

  protected static long a(Intent paramIntent)
  {
    return paramIntent.getLongExtra("broadcastIdentifier", -1L);
  }

  private BaseVideoViewController a(Bundle paramBundle)
    throws IllegalStateException
  {
    String str = getIntent().getStringExtra("video_view_class_name");
    if ("vast".equals(str))
      return new VastVideoViewController(this, getIntent().getExtras(), paramBundle, this.b, this);
    if ("mraid".equals(str))
      return new MraidVideoViewController(this, getIntent().getExtras(), paramBundle, this);
    if ("native".equals(str))
    {
      Class[] arrayOfClass = { Context.class, Bundle.class, Bundle.class, BaseVideoViewController.BaseVideoViewControllerListener.class };
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = this;
      arrayOfObject[1] = getIntent().getExtras();
      arrayOfObject[2] = paramBundle;
      arrayOfObject[3] = this;
      if (!Reflection.classFound("com.mopub.nativeads.NativeVideoViewController"))
        throw new IllegalStateException("Missing native video module");
      try
      {
        BaseVideoViewController localBaseVideoViewController = (BaseVideoViewController)Reflection.instantiateClassWithConstructor("com.mopub.nativeads.NativeVideoViewController", BaseVideoViewController.class, arrayOfClass, arrayOfObject);
        return localBaseVideoViewController;
      }
      catch (Exception localException)
      {
        throw new IllegalStateException("Missing native video module");
      }
    }
    throw new IllegalStateException("Unsupported video type: " + str);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null)
      this.a.a(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if ((this.a != null) && (this.a.backButtonEnabled()))
    {
      super.onBackPressed();
      this.a.f();
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.a != null)
      this.a.a(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().addFlags(1024);
    this.b = a(getIntent());
    try
    {
      this.a = a(paramBundle);
      this.a.a();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      BaseBroadcastReceiver.broadcastAction(this, this.b, "com.mopub.action.interstitial.fail");
      finish();
    }
  }

  protected void onDestroy()
  {
    if (this.a != null)
      this.a.e();
    super.onDestroy();
  }

  public void onFinish()
  {
    finish();
  }

  protected void onPause()
  {
    if (this.a != null)
      this.a.c();
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    if (this.a != null)
      this.a.d();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.a != null)
      this.a.a(paramBundle);
  }

  public void onSetContentView(View paramView)
  {
    setContentView(paramView);
  }

  public void onSetRequestedOrientation(int paramInt)
  {
    setRequestedOrientation(paramInt);
  }

  public void onStartActivityForResult(Class<? extends Activity> paramClass, int paramInt, Bundle paramBundle)
  {
    if (paramClass == null)
      return;
    Intent localIntent = Intents.getStartActivityIntent(this, paramClass, paramBundle);
    try
    {
      startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Activity " + paramClass.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.MraidVideoPlayerActivity
 * JD-Core Version:    0.6.2
 */