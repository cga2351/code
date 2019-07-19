package com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.common.ui.c.a;
import com.viber.common.ui.c.b;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ae;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper;
import com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper.TextChangeListener;
import com.viber.voip.user.viberid.connectaccount.connectsteps.StepViewHolderBase;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdConnectStep;
import com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters.ViberIdPasswordStepRouter;
import com.viber.voip.util.dj;
import com.viber.voip.util.dj.a;
import com.viber.voip.util.e.j;

public abstract class ViberIdPasswordViewHolder<V extends ViberIdPasswordStepView, P extends ViberIdPasswordStepPresenter<V>> extends StepViewHolderBase<V, ViberIdStepRouters.ViberIdPasswordStepRouter, P>
  implements ViberIdPasswordStepView
{
  private final Logger L = ViberEnv.getLogger(getClass());
  protected View mCheckboxContent;
  protected View mPasswordTitle;
  protected ViewWithErrorStatusWrapper mPasswordWrapper;
  private com.viber.common.ui.c mPromotionsAgreedTooltip;
  private CheckBox mPromotionsCheckbox;
  private Runnable mShowTooltipRunnable = new Runnable()
  {
    public void run()
    {
      if (ViberIdPasswordViewHolder.this.mPromotionsAgreedTooltip != null)
        ViberIdPasswordViewHolder.this.mPromotionsAgreedTooltip.a();
    }
  };
  private View mTooltipAnchor;

  protected ViberIdPasswordViewHolder(ViberFragmentActivity paramViberFragmentActivity)
  {
    super(paramViberFragmentActivity);
  }

  private com.viber.common.ui.c createTooltip()
  {
    Resources localResources = this.mActivity.getResources();
    return new c.b().a(c.a.a).c(R.string.viber_id_set_password_promotion_checkbox_tooltip_text).d(ContextCompat.getColor(this.mActivity, R.color.viber_id_tooltip_bg_color)).i(localResources.getDimensionPixelSize(R.dimen.viber_id_tooltip_width)).e(-localResources.getDimensionPixelOffset(R.dimen.viber_id_edit_tooltip_shift_x)).h(localResources.getDimensionPixelOffset(R.dimen.viber_id_tooltip_padding)).g(localResources.getDimensionPixelOffset(R.dimen.viber_id_tooltip_padding)).a(1).a(true).a(this.mTooltipAnchor).a(this.mActivity);
  }

  private void showTooltip()
  {
    this.mTooltipAnchor.postDelayed(this.mShowTooltipRunnable, 200L);
  }

  public void attach(ViewGroup paramViewGroup, View paramView, Parcelable paramParcelable)
  {
    this.mPasswordTitle = paramViewGroup.findViewById(R.id.password_title);
    this.mPasswordWrapper = new ViewWithErrorStatusWrapper((TextInputLayout)paramViewGroup.findViewById(R.id.password_layout), false);
    this.mPasswordWrapper.setTextChangeListener(new ViewWithErrorStatusWrapper.TextChangeListener()
    {
      public void onTextChanged(String paramAnonymousString)
      {
        ((ViberIdPasswordStepPresenter)ViberIdPasswordViewHolder.this.getPresenter()).onPasswordTextChanged(paramAnonymousString);
      }
    });
    this.mPromotionsCheckbox = ((CheckBox)paramViewGroup.findViewById(R.id.promotions_checkbox));
    this.mPromotionsCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        ((ViberIdPasswordStepPresenter)ViberIdPasswordViewHolder.this.getPresenter()).onPromotionCheckboxStateChanged(paramAnonymousBoolean);
      }
    });
    if (com.viber.common.d.c.a())
      this.mPromotionsCheckbox.setPadding(0, 0, j.a(10.0F), 0);
    while (true)
    {
      this.mCheckboxContent = paramViewGroup.findViewById(R.id.promotions_checkbox_content);
      this.mTooltipAnchor = paramViewGroup.findViewById(R.id.promotions_checkbox);
      super.attach(paramViewGroup, paramView, paramParcelable);
      return;
      this.mPromotionsCheckbox.setPadding(j.a(10.0F), 0, 0, 0);
    }
  }

  public void detach()
  {
    super.detach();
    if (this.mPasswordWrapper != null)
    {
      this.mPasswordWrapper.setError(null);
      this.mPasswordWrapper.setTextChangeListener(null);
      this.mPasswordWrapper = null;
    }
    if (this.mPromotionsCheckbox != null)
    {
      this.mPromotionsCheckbox.setOnCheckedChangeListener(null);
      this.mPromotionsCheckbox.setChecked(false);
      this.mPromotionsCheckbox.setEnabled(true);
      this.mPromotionsCheckbox = null;
    }
    if (this.mPromotionsAgreedTooltip != null)
    {
      this.mPromotionsAgreedTooltip.b();
      this.mPromotionsAgreedTooltip = null;
    }
    this.mCheckboxContent = null;
    if (this.mTooltipAnchor != null)
    {
      this.mTooltipAnchor.removeCallbacks(this.mShowTooltipRunnable);
      this.mTooltipAnchor = null;
    }
  }

  protected String getContinueButtonText()
  {
    return this.mActivity.getString(R.string.viber_id_btn_connect);
  }

  public void hideProgress()
  {
    super.hideProgress();
    this.mPromotionsCheckbox.setEnabled(true);
    this.mPasswordWrapper.hideLoadding();
  }

  protected void initBaseViewState(String paramString, boolean paramBoolean)
  {
    this.mPasswordWrapper.getEditText().setText(paramString);
    this.mPasswordWrapper.getEditText().setSelection(this.mPasswordWrapper.getEditText().getText().length());
    this.mPromotionsCheckbox.setChecked(paramBoolean);
  }

  public boolean onBackPressed()
  {
    return ((ViberIdPasswordStepPresenter)getPresenter()).onBackPressed();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D4001))
      ((ViberIdPasswordStepPresenter)getPresenter()).onDialog4001Action(paramInt);
    do
    {
      return;
      if ((paramm.a(DialogCode.D4002)) && (-1 == paramInt))
      {
        ((ViberIdPasswordStepPresenter)getPresenter()).onContinueButtonClick();
        return;
      }
    }
    while (!paramm.a(DialogCode.D4005));
    ((ViberIdPasswordStepPresenter)getPresenter()).onDialog4005Action(paramInt);
  }

  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
    boolean bool = paramBundle.getBoolean(ViberIdConnectStep.PROMOTIONS_AGREED_EXTRA);
    String str = paramBundle.getString(ViberIdConnectStep.PASSWORD_EXTRA);
    ((ViberIdPasswordStepPresenter)getPresenter()).setPromotionsAgreed(bool);
    if (str != null)
      ((ViberIdPasswordStepPresenter)getPresenter()).setPassword(str);
  }

  public void showCreateAccountErrorDialog()
  {
    ae.c().a(this.mActivity).b(this.mActivity);
  }

  public void showCreateAccountSuccessDialog()
  {
    ae.b().a(this.mActivity).b(this.mActivity);
  }

  public void showEmailWasSentDialog()
  {
    ae.a().a(this.mActivity).b(this.mActivity);
  }

  public void showProgress()
  {
    super.showProgress();
    this.mPromotionsCheckbox.setEnabled(false);
    this.mPasswordWrapper.showLoading();
  }

  public void showPromotionsAgreedTooltip()
  {
    if (this.mPromotionsAgreedTooltip == null)
      this.mPromotionsAgreedTooltip = createTooltip();
    if (this.mPromotionsAgreedTooltip.d())
      return;
    if (this.mTooltipAnchor.getWidth() > 0)
    {
      showTooltip();
      return;
    }
    dj.a(this.mParentView, new dj.a()
    {
      public boolean onGlobalLayout()
      {
        if (ViberIdPasswordViewHolder.this.mTooltipAnchor == null)
          return true;
        if (ViberIdPasswordViewHolder.this.mTooltipAnchor.getWidth() > 0)
        {
          ViberIdPasswordViewHolder.this.showTooltip();
          return true;
        }
        return false;
      }
    });
  }

  public void showTooManyRequestsDialog()
  {
    ae.f().a(this.mActivity).b(this.mActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.passwordstep.ViberIdPasswordViewHolder
 * JD-Core Version:    0.6.2
 */