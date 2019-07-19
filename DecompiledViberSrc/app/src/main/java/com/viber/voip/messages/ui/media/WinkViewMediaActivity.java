package com.viber.voip.messages.ui.media;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.an.c;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ak;
import com.viber.voip.messages.conversation.v;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.messages.k;
import com.viber.voip.util.da;

public class WinkViewMediaActivity extends ViewMediaActivity
  implements p.a
{
  private static final Logger r = ViberEnv.getLogger();
  private long s;
  private boolean t;
  private p u;
  private WinkDescription v;

  private void w()
  {
    this.u = new p(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(10, -1);
    ((ViewGroup)findViewById(R.id.rootView)).addView(this.u, localLayoutParams);
    this.u.getCloseButton().setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WinkViewMediaActivity.this.finish();
      }
    });
    if (this.a != null)
      this.u.setTitleText(this.a.b().toString());
  }

  private void x()
  {
    if (this.v == null)
      this.v = WinkDescription.from(this.f.f(0));
    if (this.u == null)
    {
      w();
      if (this.v != null)
        this.u.a(this.v.getBombTimeMillis(), this, this.v.isWinkImage());
    }
  }

  public void P_()
  {
    finish();
  }

  public void a(int paramInt, an.c paramc)
  {
    super.a(paramInt, paramc);
    x();
    a(true, false);
  }

  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    if ((paramLong1 > 0L) && (paramLong2 >= 0L))
      this.u.setBombCountDownText(paramLong1 - paramLong2);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.t) || (paramBoolean2))
    {
      this.t = true;
      ViberApplication.getInstance().getMessagesManager().c().c(this.s, paramBoolean1);
    }
  }

  protected boolean a(Intent paramIntent)
  {
    boolean bool = super.a(paramIntent);
    if (bool)
    {
      this.s = paramIntent.getExtras().getLong("msg_id", -1L);
      if (this.a != null)
        this.a.g();
    }
    return bool;
  }

  protected void b(int paramInt)
  {
    super.b(paramInt);
    if ((this.b != null) && (!da.a(this.b.getText())))
      this.b.setVisibility(0);
  }

  public void c()
  {
    super.c();
    x();
    this.u.setWinkTimerCallback(this);
    a(true, false);
  }

  protected void m()
  {
    super.m();
    this.e.a();
    this.e.t();
    this.d.setVisibility(0);
    this.d.findViewById(R.id.seekBar).setEnabled(false);
  }

  protected ViewMediaActivity.b n()
  {
    return new ViewMediaActivity.b()
    {
      public void a()
      {
      }

      public void a(int paramAnonymousInt)
      {
      }

      public void b()
      {
      }

      public void b(int paramAnonymousInt)
      {
      }

      public void c()
      {
      }
    };
  }

  protected v o()
  {
    return new ak(this, getSupportLoaderManager(), ViberApplication.getInstance().getLazyMessagesManager(), this, com.viber.voip.h.a.b(), this.s);
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.t = paramBundle.getBoolean("marked_as_winked_extra", false);
      if (paramBundle.containsKey("com.viber.voip.wink.WINK_DESCRIPTION"))
        this.v = ((WinkDescription)paramBundle.getParcelable("com.viber.voip.wink.WINK_DESCRIPTION"));
    }
    getWindow().setFlags(8192, 8192);
    super.onCreate(paramBundle);
    findViewById(R.id.gradient_top).setVisibility(0);
    findViewById(R.id.gradient_bottom).setVisibility(0);
  }

  protected void onPause()
  {
    super.onPause();
    overridePendingTransition(0, R.anim.view_media_swipe_down);
    if (!isFinishing())
    {
      a(false, true);
      finish();
    }
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return false;
  }

  protected void onResume()
  {
    super.onResume();
    if ((this.g) && (this.e != null))
      this.e.i();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("marked_as_winked_extra", this.t);
    if ((this.u != null) && (this.v != null) && (this.u.getTimeUntilFinish() > 0L))
      paramBundle.putParcelable("com.viber.voip.wink.WINK_DESCRIPTION", this.v.fixBombTime((int)(this.u.getTimeUntilFinish() / 1000L)));
    super.onSaveInstanceState(paramBundle);
  }

  protected ViewMediaActivity.e p()
  {
    return new a(null);
  }

  private static class a extends ViewMediaActivity.d
  {
    public o b(Bundle paramBundle)
    {
      paramBundle.putBoolean("show_splash", false);
      return super.b(paramBundle);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.WinkViewMediaActivity
 * JD-Core Version:    0.6.2
 */