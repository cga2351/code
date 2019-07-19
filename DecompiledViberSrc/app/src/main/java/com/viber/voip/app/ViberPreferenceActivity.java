package com.viber.voip.app;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.viber.common.b.h;
import com.viber.common.permission.c;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.analytics.story.o;
import com.viber.voip.banner.e;
import com.viber.voip.banner.f;
import com.viber.voip.g.b.b;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.util.bp;
import com.viber.voip.util.dc;

public class ViberPreferenceActivity extends PreferenceActivity
{
  private e a;
  private String b;

  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(bp.c(paramContext));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    dc.a(this);
    boolean bool = ViberApplication.isTablet(ViberApplication.getApplication());
    this.a = f.a(this, new b()
    {
      protected a a()
      {
        return g.a().c().c();
      }
    }
    , bool);
    this.a.m();
    this.b = d.ad.a.c.d();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.a.n();
  }

  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    c.a(this).a(this, paramInt, paramArrayOfString, paramArrayOfInt);
  }

  protected void onResume()
  {
    super.onResume();
    bp.a(this, this.b);
  }

  protected void onStart()
  {
    super.onStart();
    this.a.c();
  }

  protected void onStop()
  {
    super.onStop();
    this.a.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.app.ViberPreferenceActivity
 * JD-Core Version:    0.6.2
 */