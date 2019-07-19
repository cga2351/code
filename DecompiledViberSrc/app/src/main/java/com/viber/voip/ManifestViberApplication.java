package com.viber.voip;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.Fragment;
import com.viber.common.app.a;
import com.viber.common.permission.c;
import com.viber.common.permission.d;
import dagger.android.e;
import dagger.android.f;

public class ManifestViberApplication extends MultiDexApplication
  implements d, e, f, dagger.android.support.b
{
  private ViberApplication a;

  public ManifestViberApplication()
  {
    d();
  }

  private void d()
  {
    y.a(HomeActivity.class, TabletHomeActivity.class, WelcomeActivity.class);
    this.a = ViberApplication.init(this);
  }

  public c a()
  {
    return this.a.getPermissionManager();
  }

  public dagger.android.b<Activity> b()
  {
    return this.a.activityInjector();
  }

  public dagger.android.b<Service> c()
  {
    return this.a.serviceInjector();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.onConfigurationChanged(paramConfiguration);
  }

  public void onCreate()
  {
    super.onCreate();
    this.a.onCreate();
  }

  public void onLowMemory()
  {
    this.a.onLowMemory();
    super.onLowMemory();
  }

  public void onTerminate()
  {
    this.a.onTerminate();
    super.onTerminate();
  }

  public void onTrimMemory(int paramInt)
  {
    this.a.onTrimMemory(paramInt);
    super.onTrimMemory(paramInt);
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new al(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new ak(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a.supportFragmentInjector();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ManifestViberApplication
 * JD-Core Version:    0.6.2
 */