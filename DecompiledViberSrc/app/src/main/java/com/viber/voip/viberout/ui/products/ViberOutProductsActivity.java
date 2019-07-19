package com.viber.voip.viberout.ui.products;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.design.widget.TabLayout.ViewPagerOnTabSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.analytics.g.a.a;
import com.viber.voip.analytics.story.StoryConstants.aa.a;
import com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable;
import com.viber.voip.mvp.core.DefaultMvpActivity;
import com.viber.voip.util.ViberActionRunner.bk;
import com.viber.voip.util.bp;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import com.viber.voip.viberout.ui.products.plans.i;
import com.viber.voip.viberout.ui.products.search.country.ViberOutCountrySearchPresenter;
import javax.inject.Inject;

public class ViberOutProductsActivity extends DefaultMvpActivity<com.viber.voip.mvp.core.d>
  implements dagger.android.support.b
{

  @Inject
  dagger.android.c<Fragment> a;

  @Inject
  ViberOutProductsPresenter b;

  @Inject
  ViberOutCountrySearchPresenter c;

  @Inject
  com.viber.voip.analytics.g d;

  @Inject
  com.viber.voip.app.b e;
  private g f;
  private ViewPagerWithPagingEnable g;

  public static void a(Toolbar paramToolbar)
  {
    if (com.viber.common.d.c.a())
    {
      EditText localEditText = (EditText)paramToolbar.findViewById(R.id.search_edit);
      localEditText.setCompoundDrawables(null, null, localEditText.getCompoundDrawables()[0], null);
      ((ViewGroup.MarginLayoutParams)localEditText.getLayoutParams()).rightMargin = ((int)paramToolbar.getResources().getDimension(R.dimen.my_account_padding));
    }
  }

  protected void a(Bundle paramBundle)
  {
    Toolbar localToolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(localToolbar);
    getSupportActionBar().b(true);
    a(localToolbar);
    a locala = new a(getSupportFragmentManager());
    this.g = ((ViewPagerWithPagingEnable)findViewById(R.id.container));
    this.g.setPagingEnabled(false);
    this.g.setAdapter(locala);
    TabLayout localTabLayout = (TabLayout)findViewById(R.id.tabs);
    this.g.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(localTabLayout));
    localTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(this.g));
    this.g.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt)
      {
      }

      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
      }

      public void onPageSelected(int paramAnonymousInt)
      {
        ViberOutProductsActivity.this.b.a(paramAnonymousInt);
      }
    });
  }

  protected void b(Bundle paramBundle)
  {
    Toolbar localToolbar = (Toolbar)findViewById(R.id.toolbar);
    this.f = new g(this, this.b, findViewById(16908290), localToolbar, this.e.a(this));
    a(this.f, this.b, paramBundle);
    a(new com.viber.voip.viberout.ui.products.search.country.c(this.c, localToolbar, null, getLayoutInflater())
    {
      public void a(CountryModel paramAnonymousCountryModel)
      {
        ViberActionRunner.bk.a(ViberOutProductsActivity.this, paramAnonymousCountryModel, StoryConstants.aa.a.a(ViberOutProductsActivity.a(ViberOutProductsActivity.this).getCurrentItem()));
      }
    }
    , this.c, paramBundle);
    if (bp.a(this))
      this.b.d(this.d.a(a.a.d, true));
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_viber_out_subscriptions);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    finish();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }

  public class a extends FragmentPagerAdapter
  {
    public a(FragmentManager arg2)
    {
      super();
    }

    public int getCount()
    {
      return 2;
    }

    public Fragment getItem(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 0:
        return new i();
      case 1:
      }
      return new com.viber.voip.viberout.ui.products.credits.d();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.ViberOutProductsActivity
 * JD-Core Version:    0.6.2
 */