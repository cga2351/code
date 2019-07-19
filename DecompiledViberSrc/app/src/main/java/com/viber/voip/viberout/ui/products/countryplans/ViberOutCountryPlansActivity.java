package com.viber.voip.viberout.ui.products.countryplans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.mvp.core.DefaultMvpActivity;
import com.viber.voip.mvp.core.d;
import com.viber.voip.viberout.ui.products.ViberOutProductsActivity;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import com.viber.voip.viberout.ui.products.search.country.ViberOutCountrySearchPresenter;
import javax.inject.Inject;

public class ViberOutCountryPlansActivity extends DefaultMvpActivity<d>
  implements dagger.android.support.b
{

  @Inject
  dagger.android.c<Fragment> a;

  @Inject
  ViberOutCountrySearchPresenter b;

  private void a(c paramc)
  {
    getSupportFragmentManager().beginTransaction().replace(R.id.root_container, paramc, "vo_country_plans").commit();
  }

  protected void a(Bundle paramBundle)
  {
    if (paramBundle == null)
      a(c.a((CountryModel)getIntent().getParcelableExtra("country_model"), getIntent().getStringExtra("selected_tab")));
  }

  protected void b(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    boolean bool = localIntent.hasExtra("country_model");
    String str1 = null;
    if (bool)
      str1 = ((CountryModel)localIntent.getParcelableExtra("country_model")).getName();
    final String str2 = localIntent.getStringExtra("selected_tab");
    a(new com.viber.voip.viberout.ui.products.search.country.c(this.b, findViewById(R.id.toolbar), str1, getLayoutInflater())
    {
      public void a(CountryModel paramAnonymousCountryModel)
      {
        ViberOutCountryPlansActivity.a(ViberOutCountryPlansActivity.this, c.a(paramAnonymousCountryModel, str2));
      }
    }
    , this.b, paramBundle);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_viber_out_country_plans);
    Toolbar localToolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(localToolbar);
    ViberOutProductsActivity.a(localToolbar);
    if (getSupportActionBar() != null)
      getSupportActionBar().b(true);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    finish();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.countryplans.ViberOutCountryPlansActivity
 * JD-Core Version:    0.6.2
 */