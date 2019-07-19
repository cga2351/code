package com.viber.voip.engagement;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.viber.common.b.b;
import com.viber.common.permission.c;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.engagement.carousel.f.e;
import com.viber.voip.engagement.carousel.h;
import com.viber.voip.settings.d.at;
import com.viber.voip.settings.d.t;
import com.viber.voip.ui.ao;
import com.viber.voip.ui.q;
import com.viber.voip.ui.q.a;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.widget.TouchInterceptorFrameLayout;

public class SayHiToFriendsActivity extends ViberFragmentActivity
  implements f.e, h, com.viber.voip.ui.c.a
{
  private f a;
  private a b;
  private e c;
  private h d;

  private void c()
  {
    boolean bool = ViberApplication.isTablet(this);
    if ((!bool) || ((bool) && (!com.viber.common.d.a.m())))
      com.viber.voip.n.a.d(this);
  }

  public com.viber.voip.engagement.data.d a()
  {
    return this.d.a();
  }

  public void b()
  {
    this.a.a();
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("default_media_type", d.t.a.d());
    boolean bool1 = localIntent.getBooleanExtra("suggested_section", d.t.b.d());
    String str = localIntent.getStringExtra("campaign");
    boolean bool2;
    int k;
    if (!da.a(str))
    {
      bool2 = true;
      boolean bool3 = localIntent.getBooleanExtra("show_groups", false);
      int j = localIntent.getIntExtra("min_last_seen_days", 30);
      if (!bool1)
        break label348;
      if (bool2)
        break label316;
      k = 2;
      super.onCreate(paramBundle);
      c();
      this.a = new f(this);
      setContentView(R.layout.activity_say_hi_to_friends);
      if (this.mIsTablet)
        dj.a(this, 0.65F, 0.75F, 0.65F, 0.75F, true);
      Toolbar localToolbar = (Toolbar)findViewById(R.id.toolbar);
      setSupportActionBar(localToolbar);
      android.support.v7.app.a locala = getSupportActionBar();
      if (locala != null)
      {
        locala.b(true);
        locala.d(R.drawable.close_internal_browser_icon);
        new ao(localToolbar).a();
      }
      setActionBarTitle(R.string.say_hi);
      if (paramBundle != null)
        break label372;
      com.viber.voip.engagement.carousel.f localf = com.viber.voip.engagement.carousel.f.a(i, str, bool2);
      this.d = localf;
      com.viber.voip.engagement.contacts.e locale = com.viber.voip.engagement.contacts.e.a(k, bool3, j);
      getSupportFragmentManager().beginTransaction().add(R.id.select_media_fragment_container, localf).add(R.id.contacts_fragment_container, locale).commit();
    }
    while (true)
    {
      this.b = new a(this, findViewById(R.id.root), ViberApplication.isTablet(this));
      this.c = new e(cj.a(this), c.a(this), this.a);
      this.c.a(this.b);
      return;
      bool2 = false;
      break;
      label316: switch (localIntent.getIntExtra("suggestion_type", 0))
      {
      default:
        k = -1;
        break;
      case 0:
        k = 0;
        break;
      case 1:
        k = 1;
        break;
      case 2:
        label348: k = 2;
        break;
        label372: this.d = ((h)getSupportFragmentManager().findFragmentById(R.id.select_media_fragment_container));
      }
    }
  }

  protected void onDestroy()
  {
    this.c.c();
    this.b.b();
    super.onDestroy();
  }

  public boolean onSupportNavigateUp()
  {
    com.viber.common.b.d locald;
    if (!super.onSupportNavigateUp())
    {
      boolean bool = getIntent().getBooleanExtra("from_url_scheme", false);
      locald = d.at.c;
      if (!bool)
        break label40;
    }
    label40: for (int i = 1; ; i = 2)
    {
      locald.a(i);
      onBackPressed();
      return true;
    }
  }

  private class a
    implements g
  {
    private final Activity b;
    private final View c;
    private final ViewGroup d;
    private final TouchInterceptorFrameLayout e;
    private final View.OnTouchListener f = new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0)
          SayHiToFriendsActivity.a(SayHiToFriendsActivity.this).b();
        return false;
      }
    };
    private final q g;
    private final q.a h = new q.a()
    {
      private int b;

      private int c()
      {
        if (this.b == 0)
        {
          this.b = SayHiToFriendsActivity.a.a(SayHiToFriendsActivity.a.this).getHeight();
          dj.a(SayHiToFriendsActivity.a.a(SayHiToFriendsActivity.a.this).getHeight(), SayHiToFriendsActivity.a.a(SayHiToFriendsActivity.a.this));
        }
        return this.b;
      }

      public void a()
      {
        int i = c() / 2;
        SayHiToFriendsActivity.a.a(SayHiToFriendsActivity.a.this).setTranslationY(-i);
        dj.a(i, SayHiToFriendsActivity.a.b(SayHiToFriendsActivity.a.this));
        SayHiToFriendsActivity.a(SayHiToFriendsActivity.this).a(true);
      }

      public void b()
      {
        dj.a(c(), SayHiToFriendsActivity.a.b(SayHiToFriendsActivity.a.this));
        SayHiToFriendsActivity.a.a(SayHiToFriendsActivity.a.this).setTranslationY(0.0F);
        SayHiToFriendsActivity.a(SayHiToFriendsActivity.this).a(false);
      }
    };

    a(Activity paramView, View paramBoolean, boolean arg4)
    {
      this.b = paramView;
      this.e = ((TouchInterceptorFrameLayout)paramBoolean.findViewById(R.id.select_media_fragment_parent_container));
      this.e.setOnInterceptTouchListener(this.f);
      this.d = ((ViewGroup)paramBoolean.findViewById(R.id.select_media_fragment_container));
      this.c = paramBoolean.findViewById(R.id.no_connectivity_banner);
      int i;
      if (i != 0);
      for (float f1 = 0.75F; ; f1 = 1.0F)
      {
        this.g = new q(paramBoolean, f1, this.h);
        this.g.a();
        return;
      }
    }

    public void a()
    {
      dj.d(this.b);
    }

    public void a(boolean paramBoolean)
    {
      dj.b(this.c, paramBoolean);
    }

    public void b()
    {
      this.g.b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.SayHiToFriendsActivity
 * JD-Core Version:    0.6.2
 */