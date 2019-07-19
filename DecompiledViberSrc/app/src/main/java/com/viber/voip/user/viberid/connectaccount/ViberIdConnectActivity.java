package com.viber.voip.user.viberid.connectaccount;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.j;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av.e;
import com.viber.voip.stickers.f;
import com.viber.voip.stickers.i;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdPromoStickerPackHelper;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepViewController;
import com.viber.voip.user.viberid.connectaccount.connectsteps.animation.StepsAnimator;
import com.viber.voip.user.viberid.connectaccount.freestickers.StickersViewContainer;
import com.viber.voip.user.viberid.connectaccount.freestickers.ViberIdStickerController;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;

public class ViberIdConnectActivity extends ViberFragmentActivity
  implements View.OnClickListener, m.c, m.j
{
  private static final Logger L = ViberEnv.getLogger();
  private StepsAnimator mStepsAnimator;
  private StickersViewContainer mStickersViewContainer;
  private ViberIdStepViewController mViberIdStepViewController;
  private ViberIdStickerController mViberIdStickerController;

  private CharSequence createFreeStickersTitle()
  {
    String str = getString(R.string.viber_id_connect_free_stickers_title);
    int i = str.indexOf("${rakuten_logo}");
    if (i == -1)
    {
      str = str + " " + "${rakuten_logo}";
      i = str.indexOf("${rakuten_logo}");
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.append(" ");
    Drawable localDrawable = ContextCompat.getDrawable(this, R.drawable.viber_id_rakuten_logo);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    localSpannableStringBuilder.setSpan(new ImageSpan(localDrawable, 0), i, i + "${rakuten_logo}".length(), 33);
    return localSpannableStringBuilder;
  }

  private CharSequence createTermsAndPrivacyText()
  {
    Spanned localSpanned = Html.fromHtml(getString(R.string.viber_id_connect_policy_policy));
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpanned);
    URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, localSpanned.length(), URLSpan.class);
    if (arrayOfURLSpan.length > 0)
    {
      URLSpan localURLSpan = arrayOfURLSpan[0];
      int i = localSpannableStringBuilder.getSpanStart(localURLSpan);
      int j = localSpannableStringBuilder.getSpanEnd(localURLSpan);
      localSpannableStringBuilder.removeSpan(localURLSpan);
      localSpannableStringBuilder.setSpan(new ClickableSpan()
      {
        public void onClick(View paramAnonymousView)
        {
          ViberIdConnectActivity.this.mViberIdStepViewController.onTermsAndPrivacyClicked();
        }
      }
      , i, j, 33);
    }
    return localSpannableStringBuilder;
  }

  private void setupActionBar()
  {
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
    {
      locala.e(true);
      locala.b(true);
    }
  }

  private void setupContent()
  {
    ((TextView)findViewById(R.id.free_sticker_pack_title)).setText(createFreeStickersTitle());
    TextView localTextView1 = (TextView)findViewById(R.id.learn_more_text);
    localTextView1.setOnClickListener(this);
    dj.a(localTextView1, true);
    TextView localTextView2 = (TextView)findViewById(R.id.footer_text);
    localTextView2.setText(createTermsAndPrivacyText(), TextView.BufferType.SPANNABLE);
    localTextView2.setLinkTextColor(ContextCompat.getColor(this, R.color.sub_text));
    localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
    findViewById(R.id.root_layout).setOnClickListener(this);
  }

  public void onBackPressed()
  {
    if (!this.mViberIdStepViewController.onBackPressed())
      super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.learn_more_text)
      this.mViberIdStepViewController.onLearnMoreLinkPressed();
    while (paramView.getId() != R.id.root_layout)
      return;
    this.mViberIdStepViewController.onBackgroundPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    com.viber.voip.n.a.a(ViberApplication.isTablet(this), this, 1);
    super.onCreate(paramBundle);
    setContentView(R.layout.viber_id_connect_layout);
    setupContent();
    setupActionBar();
    setActionBarTitle(R.string.viber_id_connect_title);
    ViberIdController localViberIdController = ViberApplication.getInstance().getViberIdController();
    ViberIdConnectRouter localViberIdConnectRouter = new ViberIdConnectRouter(this);
    View localView1 = findViewById(R.id.stickers_layout);
    f localf = i.a().e();
    boolean bool;
    ViberIdStepViewController localViberIdStepViewController;
    ViewGroup localViewGroup;
    View localView2;
    if (paramBundle == null)
    {
      bool = true;
      this.mStickersViewContainer = new StickersViewContainer(localView1, localf, bool, 1);
      this.mStepsAnimator = new StepsAnimator(this, this.mStickersViewContainer);
      this.mViberIdStepViewController = new ViberIdStepViewController(this, localViberIdConnectRouter, localViberIdController, this.mStepsAnimator, cj.a(this), g.a());
      localViberIdStepViewController = this.mViberIdStepViewController;
      localViewGroup = (ViewGroup)findViewById(R.id.steps_content);
      localView2 = findViewById(R.id.continue_button);
      if (paramBundle == null)
        break label258;
    }
    label258: for (Parcelable localParcelable = paramBundle.getParcelable("STEPS_STATE"); ; localParcelable = null)
    {
      localViberIdStepViewController.attach(localViewGroup, localView2, localParcelable);
      this.mViberIdStickerController = new ViberIdStickerController(i.a(), av.e.f.a());
      this.mViberIdStickerController.attach(new ViberIdPromoStickerPackHelper().getViberIdPromoStickerPackInfo(), this.mStickersViewContainer);
      if (ViberApplication.isTablet(this))
        findViewById(R.id.scroll_view).setBackgroundColor(ContextCompat.getColor(this, R.color.main_background));
      return;
      bool = false;
      break;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.mViberIdStepViewController.detach();
    this.mViberIdStickerController.detach();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    this.mViberIdStepViewController.onDialogAction(paramm, paramInt);
  }

  public void onDialogShow(m paramm)
  {
    this.mViberIdStepViewController.onDialogShow(paramm);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("STEPS_STATE", this.mViberIdStepViewController.getSavedState());
  }

  protected void onStart()
  {
    super.onStart();
    if (!this.mStepsAnimator.isAnimating())
      this.mStickersViewContainer.resumeAnimation();
  }

  protected void onStop()
  {
    super.onStop();
    this.mStickersViewContainer.pauseAnimation();
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return false;
  }

  static abstract interface SavedStateKey
  {
    public static final String STEPS_STATE = "STEPS_STATE";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.ViberIdConnectActivity
 * JD-Core Version:    0.6.2
 */