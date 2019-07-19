package com.appboy.ui.activities;

import android.support.v4.app.FragmentActivity;
import com.appboy.a;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;

public class AppboyBaseFragmentActivity extends FragmentActivity
{
  public void onPause()
  {
    super.onPause();
    AppboyInAppMessageManager.getInstance().unregisterInAppMessageManager(this);
  }

  public void onResume()
  {
    super.onResume();
    AppboyInAppMessageManager.getInstance().registerInAppMessageManager(this);
  }

  public void onStart()
  {
    super.onStart();
    a.a(this).a(this);
  }

  public void onStop()
  {
    super.onStop();
    a.a(this).b(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.activities.AppboyBaseFragmentActivity
 * JD-Core Version:    0.6.2
 */