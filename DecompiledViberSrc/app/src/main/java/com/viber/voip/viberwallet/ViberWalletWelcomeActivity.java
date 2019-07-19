package com.viber.voip.viberwallet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.viber.common.b.b;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.clock.FiniteClock;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.market.MarketApi.c;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.j;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.dz;
import dagger.a;
import java.util.ArrayList;
import java.util.List;

public class ViberWalletWelcomeActivity extends ViberFragmentActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private b a;
  private List<String> b;
  private List<String> c;
  private List<String> d;
  private LinearLayout e;
  private ImageView[] f;
  private ViewPager g;
  private String h;

  private void a()
  {
    final Engine localEngine = ViberApplication.getInstance().getEngine(false);
    if (this.h != null)
    {
      localEngine.getCdrController().handleReportWalletOptIn(this.h, localEngine.getPhoneController().generateSequence());
      return;
    }
    new com.viber.voip.market.b.d().a(new MarketApi.c()
    {
      public void a(String paramAnonymousString)
      {
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        ViberWalletWelcomeActivity.a(ViberWalletWelcomeActivity.this, paramAnonymousString2);
        localEngine.getCdrController().handleReportWalletOptIn(ViberWalletWelcomeActivity.a(ViberWalletWelcomeActivity.this), localEngine.getPhoneController().generateSequence());
      }
    }
    , true);
  }

  private void b()
  {
    this.f = new ImageView[this.b.size()];
    for (int i = 0; i < this.f.length; i++)
    {
      this.f[i] = new ImageView(this);
      this.f[i].setImageResource(R.drawable.dot);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      int j = getResources().getDimensionPixelOffset(R.dimen.viber_wallet_dots_padding);
      localLayoutParams.setMargins(j, 0, j, 0);
      this.e.addView(this.f[i], localLayoutParams);
    }
    this.f[0].setSelected(true);
  }

  private void c()
  {
    this.b = new ArrayList();
    this.b.add(getString(R.string.viber_wallet_welcome_future_title));
    this.b.add(getString(R.string.viber_wallet_welcome_quick_title));
    this.b.add(getString(R.string.viber_wallet_welcome_secure_title));
    this.c = new ArrayList();
    this.c.add(getString(R.string.viber_wallet_welcome_future_body));
    this.c.add(getString(R.string.viber_wallet_welcome_quick_body));
    this.c.add(getString(R.string.viber_wallet_welcome_secure_body));
    this.d = new ArrayList();
    this.d.add("svg/wallet.svg");
    this.d.add("svg/phone.svg");
    this.d.add("svg/shield_star.svg");
  }

  protected c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.d(new j(), this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    d.bm.a.a.a(false);
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.btn_welcome_start)
    {
      a();
      d.bm.a.c.a(true);
      if (getIntent().hasExtra("extra_forward"))
        dz.a(ViberApplication.getApplication(), (Intent)getIntent().getParcelableExtra("extra_forward"));
      d.bm.a.a.a(false);
      finish();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_viber_wallet_welcome);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    c();
    this.a = new b(null);
    this.g = ((ViewPager)findViewById(R.id.welcome_pager));
    this.g.setAdapter(this.a);
    this.g.addOnPageChangeListener(this);
    this.g.setCurrentItem(0);
    final View localView = findViewById(R.id.btn_welcome_start);
    CheckBox localCheckBox = (CheckBox)findViewById(R.id.viber_wallet_agree);
    TextView localTextView = (TextView)findViewById(R.id.viber_wallet_agree_text);
    localView.setOnClickListener(this);
    localView.setEnabled(localCheckBox.isChecked());
    localTextView.setText(Html.fromHtml(getString(R.string.viber_wallet_agreement_link)));
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        localView.setEnabled(paramAnonymousBoolean);
      }
    });
    this.e = ((LinearLayout)findViewById(R.id.pager_dots));
    b();
    setTitle(getString(R.string.viber_wallet_title));
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      d.bm.a.a.a(false);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onPageScrollStateChanged(int paramInt)
  {
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int paramInt)
  {
    ImageView[] arrayOfImageView = this.f;
    int i = arrayOfImageView.length;
    for (int j = 0; j < i; j++)
      arrayOfImageView[j].setSelected(false);
    this.f[paramInt].setSelected(true);
    this.a.a(paramInt).a();
  }

  private class a extends ScrollView
  {
    private SvgImageView b;
    private int c;

    public a(Context paramInt, int arg3)
    {
      super();
      int i;
      this.c = i;
      c();
    }

    private void c()
    {
      ViberWalletWelcomeActivity.this.getLayoutInflater().inflate(R.layout.viber_wallet_welcome_item, this, true);
      ((TextView)findViewById(R.id.page_title)).setText((CharSequence)ViberWalletWelcomeActivity.b(ViberWalletWelcomeActivity.this).get(this.c));
      ((TextView)findViewById(R.id.page_body)).setText((CharSequence)ViberWalletWelcomeActivity.c(ViberWalletWelcomeActivity.this).get(this.c));
      this.b = ((SvgImageView)findViewById(R.id.page_image));
      this.b.loadFromAsset(ViberWalletWelcomeActivity.this, (String)ViberWalletWelcomeActivity.d(ViberWalletWelcomeActivity.this).get(this.c), "", 0);
    }

    public void a()
    {
      this.b.setSvgEnabled(true);
      this.b.setClock(new FiniteClock(500.0D));
    }

    public void b()
    {
      this.b.setClock(null);
      this.b.setSvgEnabled(false);
    }
  }

  private class b extends PagerAdapter
  {
    private SparseArrayCompat<ViberWalletWelcomeActivity.a> b = new SparseArrayCompat();

    private b()
    {
    }

    ViberWalletWelcomeActivity.a a(int paramInt)
    {
      return (ViberWalletWelcomeActivity.a)this.b.get(paramInt);
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      ((ViberWalletWelcomeActivity.a)this.b.get(paramInt)).b();
      this.b.remove(paramInt);
      paramViewGroup.removeView((ViberWalletWelcomeActivity.a)paramObject);
    }

    public int getCount()
    {
      return ViberWalletWelcomeActivity.b(ViberWalletWelcomeActivity.this).size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      ViberWalletWelcomeActivity.a locala = new ViberWalletWelcomeActivity.a(ViberWalletWelcomeActivity.this, ViberWalletWelcomeActivity.this, paramInt);
      this.b.put(paramInt, locala);
      paramViewGroup.addView(locala);
      locala.a();
      return locala;
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == (ViberWalletWelcomeActivity.a)paramObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberwallet.ViberWalletWelcomeActivity
 * JD-Core Version:    0.6.2
 */