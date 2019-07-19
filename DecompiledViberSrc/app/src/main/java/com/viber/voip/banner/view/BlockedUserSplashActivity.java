package com.viber.voip.banner.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.common.b.a;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.al;

public class BlockedUserSplashActivity extends ViberFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private d b;
  private d.al c;
  private e d;
  private a e;
  private boolean f;

  private void a()
  {
    if ((ao.f()) || (!d.ad.K.d()))
      finish();
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    if (!this.f)
      ViberApplication.exit(null, false);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = getIntent().getBooleanExtra("com.viber.voip.IS_FOR_DEBUG", false);
    a();
    setContentView(R.layout.blocked_user_splash);
    this.d = new e(this);
    this.e = new a(findViewById(R.id.root));
    this.b = new d(getIntent().getStringExtra("com.viber.voip.CAPTCHA_URL_EXTRA"));
    a[] arrayOfa = new a[1];
    arrayOfa[0] = d.ad.K;
    this.c = new d.al(arrayOfa)
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        BlockedUserSplashActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            BlockedUserSplashActivity.a(BlockedUserSplashActivity.this);
          }
        });
      }
    };
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.f = false;
    a();
  }

  protected void onStart()
  {
    super.onStart();
    this.b.a(this.e);
    this.b.a(this.d);
    com.viber.voip.settings.d.a(this.c);
    a();
  }

  protected void onStop()
  {
    super.onStop();
    this.b.a();
    this.b.b();
    com.viber.voip.settings.d.b(this.c);
  }

  private class a
    implements View.OnClickListener, h
  {
    a(View arg2)
    {
      Object localObject;
      localObject.findViewById(R.id.btn_unblock).setOnClickListener(this);
    }

    public void onClick(View paramView)
    {
      BlockedUserSplashActivity.b(BlockedUserSplashActivity.this).c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.BlockedUserSplashActivity
 * JD-Core Version:    0.6.2
 */