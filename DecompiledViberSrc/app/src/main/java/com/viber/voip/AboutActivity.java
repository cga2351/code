package com.viber.voip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.api.scheme.g;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.app.b;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.bl;
import com.viber.voip.util.dj;
import d.d.b.h;
import d.d.b.l;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AboutActivity extends ViberFragmentActivity
  implements View.OnClickListener
{

  @Inject
  @NotNull
  public b b;

  @Inject
  @NotNull
  public UserManager c;

  @Inject
  @NotNull
  public PixieController d;
  private final d.d e = d.e.a(d.i.c, (d.d.a.a)a.a);
  private final int f;
  private final d.d g = d.e.a(d.i.c, (d.d.a.a)b.a);
  private TextView h;

  static
  {
    d.f.e[] arrayOfe = new d.f.e[2];
    arrayOfe[0] = ((d.f.e)d.d.b.m.a(new l(d.d.b.m.a(AboutActivity.class), "L", "getL()Lcom/viber/dexshared/Logger;")));
    arrayOfe[1] = ((d.f.e)d.d.b.m.a(new l(d.d.b.m.a(AboutActivity.class), "SOCIAL_BUTTONS", "getSOCIAL_BUTTONS()Landroid/util/SparseIntArray;")));
  }

  private final SparseIntArray a()
  {
    d.d locald = this.g;
    a[1];
    return (SparseIntArray)locald.a();
  }

  private final void a(String paramString)
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
  }

  private final boolean a(int paramInt)
  {
    if (a().get(paramInt, this.f) != this.f)
    {
      a(b(a().get(paramInt)));
      return true;
    }
    return false;
  }

  private final String b(int paramInt)
  {
    String str1 = getString(paramInt);
    UserManager localUserManager = this.c;
    if (localUserManager == null)
      h.b("userManager");
    af localaf = localUserManager.getRegistrationValues();
    h.a(localaf, "userManager.registrationValues");
    String str2 = localaf.b();
    String str3 = str1 + str2;
    int i = getResources().getIdentifier(str3, "string", getPackageName());
    if (i != 0)
    {
      String str5 = getString(i);
      h.a(str5, "getString(socialResIdentifier)");
      return str5;
    }
    String str4 = getString(getResources().getIdentifier(str1, "string", getPackageName()));
    h.a(str4, "getString(resources.getI…, \"string\", packageName))");
    return str4;
  }

  private final void b()
  {
    int i = a().size();
    int j = 0;
    if (j < i)
    {
      View localView2 = findViewById(a().keyAt(j));
      if (localView2 != null)
      {
        if (!TextUtils.isEmpty((CharSequence)b(a().valueAt(j))))
          break label68;
        localView2.setVisibility(8);
      }
      while (true)
      {
        j++;
        break;
        label68: localView2.setOnClickListener((View.OnClickListener)this);
      }
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(R.id.ll_social);
    int k;
    if (localLinearLayout != null)
      k = localLinearLayout.getChildCount();
    for (int m = 0; ; m++)
      if (m < k)
      {
        View localView1 = localLinearLayout.getChildAt(m);
        if ((localView1 != null) && (localView1.getVisibility() == 0))
        {
          ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
          if (localLayoutParams == null)
            throw new d.m("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = 0;
          localView1.requestLayout();
        }
      }
      else
      {
        return;
      }
  }

  private final void c()
  {
    String str = p.g();
    TextView localTextView = this.h;
    if (localTextView == null)
      h.b("viberVersion");
    localTextView.setText((CharSequence)str);
  }

  public void onBackPressed()
  {
    if (isTaskRoot())
    {
      startActivity(new Intent("com.viber.voip.action.MORE"));
      finish();
      return;
    }
    super.onBackPressed();
  }

  public void onClick(@NotNull View paramView)
  {
    h.b(paramView, "view");
    if (a(paramView.getId()));
    int i;
    do
    {
      return;
      i = paramView.getId();
      if (i == R.id.policy)
      {
        ViberActionRunner.bl.b((Context)this);
        return;
      }
      if (i == R.id.link_to_viber)
      {
        g localg2 = (g)com.viber.voip.api.scheme.d.B;
        Pair[] arrayOfPair2 = new Pair[1];
        arrayOfPair2[0] = new Pair("link", getString(R.string.viber_url));
        startActivity(new Intent("android.intent.action.VIEW", com.viber.voip.api.scheme.i.a(localg2, arrayOfPair2)));
        return;
      }
    }
    while (i != R.id.link_to_faq);
    g localg1 = (g)com.viber.voip.api.scheme.d.B;
    Pair[] arrayOfPair1 = new Pair[1];
    arrayOfPair1[0] = new Pair("link", getString(R.string.viber_support_url));
    startActivity(new Intent("android.intent.action.VIEW", com.viber.voip.api.scheme.i.a(localg1, arrayOfPair1)));
  }

  public void onCreate(@Nullable Bundle paramBundle)
  {
    dagger.android.a.a((Activity)this);
    super.onCreate(paramBundle);
    b localb = this.b;
    if (localb == null)
      h.b("deviceConfiguration");
    if (localb.a((Context)this))
    {
      setTheme(R.style.Theme_Viber);
      android.support.v7.app.a locala = getSupportActionBar();
      if (locala != null)
      {
        locala.a(false);
        locala.b(true);
        locala.b(R.string.pref_more_tab_about_title);
        locala.a(17170445);
      }
    }
    setContentView(R.layout.about);
    View localView = findViewById(R.id.viber_version);
    h.a(localView, "findViewById(R.id.viber_version)");
    this.h = ((TextView)localView);
    c();
    findViewById(R.id.policy).setOnClickListener((View.OnClickListener)this);
    findViewById(R.id.link_to_viber).setOnClickListener((View.OnClickListener)this);
    findViewById(R.id.link_to_faq).setOnClickListener((View.OnClickListener)this);
    final ImageView localImageView = (ImageView)findViewById(R.id.about);
    dj.a((View)localImageView, (ViewTreeObserver.OnGlobalLayoutListener)new c(this, localImageView));
    b();
  }

  public boolean onOptionsItemSelected(@NotNull MenuItem paramMenuItem)
  {
    h.b(paramMenuItem, "item");
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    onBackPressed();
    return true;
  }

  static final class a extends d.d.b.i
    implements d.d.a.a<Logger>
  {
    public static final a a = new a();

    a()
    {
      super();
    }

    @NotNull
    public final Logger b()
    {
      Logger localLogger = ViberEnv.getLogger();
      if (localLogger == null)
        h.a();
      return localLogger;
    }
  }

  static final class b extends d.d.b.i
    implements d.d.a.a<SparseIntArray>
  {
    public static final b a = new b();

    b()
    {
      super();
    }

    @NotNull
    public final SparseIntArray b()
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      localSparseIntArray.append(R.id.facebook_btn, R.string.about_viber_facebook_url_prefix_res_key);
      localSparseIntArray.append(R.id.instagram_btn, R.string.about_viber_instagram_url_prefix_res_key);
      localSparseIntArray.append(R.id.twitter_btn, R.string.about_viber_twitter_url_prefix_res_key);
      localSparseIntArray.append(R.id.vk_btn, R.string.about_viber_vk_url_prefix_res_key);
      return localSparseIntArray;
    }
  }

  static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(AboutActivity paramAboutActivity, ImageView paramImageView)
    {
    }

    public final void onGlobalLayout()
    {
      ImageView localImageView = localImageView;
      h.a(localImageView, "backgroundImage");
      localImageView.getImageMatrix().postTranslate(0.0F, this.a.getResources().getDimensionPixelOffset(R.dimen.bg_about_image_translation_y));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.AboutActivity
 * JD-Core Version:    0.6.2
 */