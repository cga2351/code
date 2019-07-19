package com.viber.voip.banner.notificationsoff;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.clock.FiniteClock;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.n.a;
import com.viber.voip.notif.g;
import com.viber.voip.settings.d.k;
import com.viber.voip.util.ViberActionRunner.q;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class GlobalNotificationSplashActivity extends ViberFragmentActivity
  implements View.OnClickListener
{
  private h a;
  private CheckBox b;

  private void a()
  {
    if (this.b == null);
    boolean bool;
    do
    {
      return;
      bool = b();
      d.k.h.a(bool);
    }
    while (!bool);
    finish();
  }

  private boolean b()
  {
    if (this.b == null)
      return false;
    return this.b.isChecked();
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    this.a.a();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.close)
    {
      a();
      onBackPressed();
    }
    while (i != R.id.enable_button)
      return;
    a();
    startActivity(ViberActionRunner.q.a(this));
  }

  protected void onCreate(Bundle paramBundle)
  {
    a.a(ViberApplication.isTablet(this), this, 1);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_global_notification_splash);
    setActionBarTitle(R.string.notification_banner_title);
    SvgImageView localSvgImageView = (SvgImageView)findViewById(R.id.icon);
    View localView = findViewById(R.id.close);
    localSvgImageView.loadFromAsset(this, "svg/global_notification.svg", "", 0);
    localSvgImageView.setClock(new FiniteClock(localSvgImageView.getDuration()));
    localSvgImageView.setSvgEnabled(true);
    localSvgImageView.setCurrentColor(dc.d(this, R.attr.notifSplashIconTint));
    dj.a(localView, getResources().getDimensionPixelSize(R.dimen.small_button_touch_area));
    localView.setOnClickListener(this);
    findViewById(R.id.enable_button).setOnClickListener(this);
    if (getIntent().getBooleanExtra("debug_mode_extra", false));
    for (Object localObject = new e(true); ; localObject = g.a(this).j())
    {
      this.a = ((h)localObject);
      if (d.k.g.g() >= 3)
      {
        this.b = ((CheckBox)findViewById(R.id.do_not_show_again_cb));
        dj.b(this.b, true);
      }
      return;
    }
  }

  protected void onStart()
  {
    super.onStart();
    if (!this.a.b())
      onBackPressed();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.notificationsoff.GlobalNotificationSplashActivity
 * JD-Core Version:    0.6.2
 */