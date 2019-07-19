package com.viber.voip.wallet.wu;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.viber.common.b.b;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.clock.FiniteClock;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.d;
import com.viber.voip.ui.c.j;
import com.viber.voip.util.da;
import dagger.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class WesternUnionWelcomeActivity extends ViberFragmentActivity
{
  private static final long d = TimeUnit.SECONDS.toMillis(10L);
  private Handler a;
  private ViewPager b;
  private List<ImageView> c;
  private final View.OnClickListener e = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      WesternUnionWelcomeActivity.b(WesternUnionWelcomeActivity.this).setCurrentItem(WesternUnionWelcomeActivity.a(WesternUnionWelcomeActivity.this).indexOf(paramAnonymousView), true);
    }
  };
  private final Runnable f = new Runnable()
  {
    public void run()
    {
      WesternUnionWelcomeActivity.b(WesternUnionWelcomeActivity.this).setCurrentItem(1 + WesternUnionWelcomeActivity.b(WesternUnionWelcomeActivity.this).getCurrentItem(), true);
    }
  };

  private static List<View> a(ViewGroup paramViewGroup)
  {
    LinkedList localLinkedList = new LinkedList();
    for (int i = 0; i < paramViewGroup.getChildCount(); i++)
      localLinkedList.add(paramViewGroup.getChildAt(i));
    return localLinkedList;
  }

  private void a()
  {
    this.c = new ArrayList();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(R.id.pager_dots);
    int i = (int)getResources().getDimension(R.dimen.dots_scroller_item_margin);
    for (int j = 0; j < 3; j++)
    {
      ImageView localImageView = new ImageView(this);
      localImageView.setImageResource(R.drawable.purple_circle_swipe_small);
      localImageView.setOnClickListener(this.e);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      localImageView.setPadding(i, i, i, i);
      localLinearLayout.addView(localImageView, localLayoutParams);
      this.c.add(localImageView);
    }
  }

  private boolean b()
  {
    return this.b.getCurrentItem() < 2;
  }

  private void c()
  {
    if (b())
      this.a.postDelayed(this.f, d);
  }

  private void d()
  {
    this.a.removeCallbacks(this.f);
  }

  public void a(int paramInt)
  {
    int i = 0;
    if (i < 3)
    {
      if (i == paramInt);
      for (int j = R.drawable.purple_circle_swipe; ; j = R.drawable.purple_circle_swipe_small)
      {
        ((ImageView)this.c.get(i)).setImageResource(j);
        i++;
        break;
      }
    }
  }

  protected c createActivityDecorator()
  {
    return new d(new j(), this, (com.viber.voip.ui.j.av)ViberApplication.getInstance().getThemeController().get());
  }

  public void onBackPressed()
  {
    if (this.b.getCurrentItem() > 0)
    {
      this.b.setCurrentItem(-1 + this.b.getCurrentItem());
      return;
    }
    super.onBackPressed();
    d.bm.a.a.a(false);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_wallet_wu_welcome);
    this.a = com.viber.voip.av.a(av.e.a);
    this.b = ((ViewPager)findViewById(R.id.pager));
    this.b.setAdapter(new a(a(this.b)));
    this.b.addOnPageChangeListener(new f(null));
    findViewById(R.id.close).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        d.bm.a.a.a(false);
        WesternUnionWelcomeActivity.this.finish();
      }
    });
    a();
    a(0);
    ((b)a.a((a)this.b.getAdapter()).get(0)).a();
    ((b)a.a((a)this.b.getAdapter()).get(1)).b();
    ((b)a.a((a)this.b.getAdapter()).get(2)).b();
  }

  protected void onPause()
  {
    super.onPause();
    d();
  }

  protected void onResume()
  {
    super.onResume();
    c();
  }

  private class a extends PagerAdapter
  {
    private List<WesternUnionWelcomeActivity.b> b = new LinkedList();

    public a()
    {
      Object localObject;
      this.b.add(new WesternUnionWelcomeActivity.c(WesternUnionWelcomeActivity.this, (View)localObject.get(0)));
      this.b.add(new WesternUnionWelcomeActivity.d(WesternUnionWelcomeActivity.this, (View)localObject.get(1)));
      this.b.add(new WesternUnionWelcomeActivity.e(WesternUnionWelcomeActivity.this, (View)localObject.get(2)));
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView(((WesternUnionWelcomeActivity.b)this.b.get(paramInt)).c());
    }

    public int getCount()
    {
      return this.b.size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = ((WesternUnionWelcomeActivity.b)this.b.get(paramInt)).c();
      ViewParent localViewParent = localView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
        ((ViewGroup)localViewParent).removeView(localView);
      paramViewGroup.addView(localView);
      return this.b.get(paramInt);
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == ((WesternUnionWelcomeActivity.b)paramObject).c();
    }
  }

  private static abstract interface b
  {
    public abstract void a();

    public abstract void b();

    public abstract View c();
  }

  private class c
    implements Animator.AnimatorListener, WesternUnionWelcomeActivity.b
  {
    SvgImageView a;
    TextView b;
    TextView c;
    private View e;
    private ImageView f;

    public c(View arg2)
    {
      View localView;
      this.e = localView;
      this.a = ((SvgImageView)localView.findViewById(R.id.wu_welcome_page_svg));
      this.a.loadFromAsset(WesternUnionWelcomeActivity.this, f(), "", 0);
      this.b = ((TextView)localView.findViewById(R.id.wu_welcome_page_title));
      this.c = ((TextView)localView.findViewById(R.id.wu_welcome_page_text));
      a(localView);
    }

    public void a()
    {
      this.a.setSvgEnabled(true);
      this.a.setClock(new FiniteClock(2.7D));
      this.b.setAlpha(0.0F);
      this.c.setAlpha(0.0F);
      this.b.animate().alpha(1.0F).setDuration(500L).setListener(this).start();
      d();
    }

    void a(View paramView)
    {
      this.f = ((ImageView)paramView.findViewById(R.id.wu_welcome_page1_logo));
    }

    public void b()
    {
      this.b.setAlpha(0.0F);
      this.c.setAlpha(0.0F);
      this.a.setClock(null);
      this.a.setSvgEnabled(false);
      this.b.animate().cancel();
      this.c.animate().cancel();
      e();
    }

    public View c()
    {
      return this.e;
    }

    void d()
    {
    }

    void e()
    {
    }

    public String f()
    {
      return "svg/wallet-wallet.svg";
    }

    public void onAnimationCancel(Animator paramAnimator)
    {
    }

    public void onAnimationEnd(Animator paramAnimator)
    {
      this.c.setAlpha(0.0F);
      this.c.animate().alpha(1.0F).setDuration(500L).start();
    }

    public void onAnimationRepeat(Animator paramAnimator)
    {
    }

    public void onAnimationStart(Animator paramAnimator)
    {
    }
  }

  private class d extends WesternUnionWelcomeActivity.c
  {
    public d(View arg2)
    {
      super(localView);
    }

    public String f()
    {
      return "svg/wallet-timer.svg";
    }
  }

  private class e extends WesternUnionWelcomeActivity.c
    implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
  {
    private CheckBox f = (CheckBox)WesternUnionWelcomeActivity.this.findViewById(R.id.cb_wu_agree_terms);
    private Button g = (Button)WesternUnionWelcomeActivity.this.findViewById(R.id.btn_wu_welcome_start);
    private TextView h = (TextView)WesternUnionWelcomeActivity.this.findViewById(R.id.txt_wu_agree_terms);

    public e(View arg2)
    {
      super(localView);
      String str = Locale.getDefault().getLanguage();
      da.a(this.h, WesternUnionWelcomeActivity.this.getString(R.string.wu_welcome_page3_opt_agree_wu_terms, new Object[] { str, str, str }), true, true);
      this.h.setMovementMethod(LinkMovementMethod.getInstance());
      this.f.setOnCheckedChangeListener(this);
      this.g.setOnClickListener(this);
    }

    public String f()
    {
      return "svg/wallet-shield.svg";
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      this.g.setEnabled(paramBoolean);
    }

    public void onClick(View paramView)
    {
      d.bm.a.c.a(true);
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportWesternUnionStatistics();
      if (WesternUnionWelcomeActivity.this.getIntent().hasExtra("extra_forward"))
        WesternUnionWelcomeActivity.this.startActivity((Intent)WesternUnionWelcomeActivity.this.getIntent().getParcelableExtra("extra_forward"));
      d.bm.a.a.a(false);
      WesternUnionWelcomeActivity.this.finish();
    }
  }

  private class f
    implements ViewPager.OnPageChangeListener
  {
    private int b;

    private f()
    {
    }

    public void onPageScrollStateChanged(int paramInt)
    {
      if (paramInt == 0)
      {
        WesternUnionWelcomeActivity.c(WesternUnionWelcomeActivity.this);
        return;
      }
      WesternUnionWelcomeActivity.d(WesternUnionWelcomeActivity.this);
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
      ((WesternUnionWelcomeActivity.b)WesternUnionWelcomeActivity.a.a((WesternUnionWelcomeActivity.a)WesternUnionWelcomeActivity.b(WesternUnionWelcomeActivity.this).getAdapter()).get(this.b)).b();
      this.b = paramInt;
      ((WesternUnionWelcomeActivity.b)WesternUnionWelcomeActivity.a.a((WesternUnionWelcomeActivity.a)WesternUnionWelcomeActivity.b(WesternUnionWelcomeActivity.this).getAdapter()).get(paramInt)).a();
      WesternUnionWelcomeActivity.this.a(paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.wallet.wu.WesternUnionWelcomeActivity
 * JD-Core Version:    0.6.2
 */