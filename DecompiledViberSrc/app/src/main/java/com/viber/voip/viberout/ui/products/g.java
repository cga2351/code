package com.viber.voip.viberout.ui.products;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.mvp.core.d;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.dj;
import com.viber.voip.viberout.ui.CallingPlansSuggestionWebActivity;
import com.viber.voip.viberout.ui.ViberOutReferralActivity;

public class g extends d<ViberOutProductsPresenter>
  implements View.OnClickListener, i
{
  private final ViewPager a;
  private final TabLayout b;
  private final AppCompatActivity c;
  private AppBarLayout d;
  private View e;
  private ViewStub f;
  private ViewStub g;
  private final boolean h;
  private View i;
  private View j;

  protected g(AppCompatActivity paramAppCompatActivity, ViberOutProductsPresenter paramViberOutProductsPresenter, View paramView, Toolbar paramToolbar, boolean paramBoolean)
  {
    super(paramViberOutProductsPresenter, paramView);
    this.c = paramAppCompatActivity;
    this.d = ((AppBarLayout)paramView.findViewById(R.id.appbar));
    this.e = paramToolbar.findViewById(R.id.search_container);
    this.a = ((ViewPager)paramView.findViewById(R.id.container));
    this.b = ((TabLayout)paramView.findViewById(R.id.tabs));
    this.f = ((ViewStub)paramView.findViewById(R.id.user_blocked_stub));
    this.g = ((ViewStub)paramView.findViewById(R.id.no_connection_stub));
    this.h = paramBoolean;
    Intent localIntent = paramAppCompatActivity.getIntent();
    ((ViberOutProductsPresenter)this.mPresenter).a(localIntent.getStringExtra("referral"));
    ((ViberOutProductsPresenter)this.mPresenter).b(localIntent.getStringExtra("analytics_entry_point"));
  }

  private View f()
  {
    if (this.i != null)
      return this.i;
    this.i = this.g.inflate();
    this.i.findViewById(R.id.try_again_button).setOnClickListener(this);
    return this.i;
  }

  private View g()
  {
    if (this.j != null)
      return this.j;
    this.j = this.f.inflate();
    this.j.findViewById(R.id.contact_support_button).setOnClickListener(this);
    return this.j;
  }

  public void a()
  {
    dj.a(this.d, new h(this));
  }

  public void a(int paramInt)
  {
    TabLayout.Tab localTab = this.b.getTabAt(paramInt);
    if (localTab != null)
      localTab.select();
  }

  public void a(String paramString)
  {
    TabLayout.Tab localTab = this.b.getTabAt(1);
    if (localTab != null)
      localTab.setText(paramString);
  }

  public void a(boolean paramBoolean)
  {
    dj.b(f(), paramBoolean);
    TabLayout localTabLayout = this.b;
    boolean bool1;
    boolean bool2;
    label37: a locala;
    if (!paramBoolean)
    {
      bool1 = true;
      dj.b(localTabLayout, bool1);
      View localView = this.e;
      if (paramBoolean)
        break label113;
      bool2 = true;
      dj.b(localView, bool2);
      ViewPager localViewPager = this.a;
      boolean bool3 = false;
      if (!paramBoolean)
        bool3 = true;
      dj.b(localViewPager, bool3);
      locala = this.c.getSupportActionBar();
      if (!paramBoolean)
        break label119;
    }
    label113: label119: for (String str = this.c.getString(R.string.viber_out); ; str = "")
    {
      locala.a(str);
      this.d.setExpanded(true);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label37;
    }
  }

  public void b()
  {
    dj.b(g(), true);
    dj.b(this.b, false);
    dj.b(this.e, false);
    dj.b(this.a, false);
    this.c.getSupportActionBar().b(R.string.viber_out);
    this.d.setExpanded(true);
  }

  public void b(String paramString)
  {
    CallingPlansSuggestionWebActivity.a(true, paramString, "url_scheme");
  }

  public void c()
  {
    GenericWebViewActivity.a(this.c, this.c.getString(R.string.contact_support_link), "");
  }

  public void d()
  {
    ViberOutReferralActivity.a(this.c);
  }

  public void onClick(View paramView)
  {
    if (paramView == null);
    int k;
    do
    {
      return;
      k = paramView.getId();
      if (k == R.id.contact_support_button)
      {
        ((ViberOutProductsPresenter)this.mPresenter).h();
        return;
      }
    }
    while (k != R.id.try_again_button);
    ((ViberOutProductsPresenter)this.mPresenter).i();
  }

  public void onPause()
  {
    if (this.c.isFinishing())
      ((ViberOutProductsPresenter)this.mPresenter).f();
  }

  public void onStart()
  {
    Intent localIntent = this.c.getIntent();
    if ((((ViberOutProductsPresenter)this.mPresenter).g() == null) || (!((ViberOutProductsPresenter)this.mPresenter).g().isRequestHandled))
    {
      if (localIntent.getBooleanExtra("more_plans", false))
      {
        localIntent.removeExtra("more_plans");
        String str = localIntent.getStringExtra("plan_id");
        localIntent.removeExtra("plan_id");
        ((ViberOutProductsPresenter)this.mPresenter).c(str);
      }
      if (localIntent.getBooleanExtra("show_invite_page", false))
      {
        localIntent.removeExtra("show_invite_page");
        ((ViberOutProductsPresenter)this.mPresenter).j();
      }
    }
    if (localIntent.hasExtra("show_tab"))
      a(ViberOutProductsPresenter.a.a.a(localIntent.getStringExtra("show_tab")));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.g
 * JD-Core Version:    0.6.2
 */