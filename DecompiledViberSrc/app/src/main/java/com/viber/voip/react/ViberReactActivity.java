package com.viber.voip.react;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import dagger.android.a;
import java.util.Map;
import javax.inject.Inject;

public abstract class ViberReactActivity extends ViberFragmentActivity
  implements DefaultHardwareBackBtnHandler
{
  private static final Logger d = ViberEnv.getLogger();
  protected ReactRootView a;

  @Inject
  Map<String, d> b;
  protected ReactInstanceManager c;

  public void invokeDefaultOnBackPressed()
  {
    super.onBackPressed();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 333) && (Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(this)));
  }

  public void onBackPressed()
  {
    if (this.c != null)
    {
      this.c.onBackPressed();
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    a.a(this);
    super.onCreate(paramBundle);
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("com.viber.voip.ReactContextFactoryParams")))
    {
      ReactContextManager.Params localParams = (ReactContextManager.Params)localBundle.getParcelable("com.viber.voip.ReactContextFactoryParams");
      if (localParams != null)
        this.c = ((d)this.b.get(localParams.getReactContextKey())).a(getApplication(), localParams).a();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
      this.c.onHostDestroy(this);
    if (this.a != null)
      this.a.unmountReactApplication();
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onPause()
  {
    super.onPause();
    if (this.c != null)
      this.c.onHostPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    if (this.c != null)
      this.c.onHostResume(this, this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.react.ViberReactActivity
 * JD-Core Version:    0.6.2
 */