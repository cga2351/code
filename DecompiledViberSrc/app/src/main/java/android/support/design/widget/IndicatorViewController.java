package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.design.R.dimen;
import android.support.design.R.id;
import android.support.design.a.a;
import android.support.design.a.b;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController
{
  private static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
  private static final int CAPTION_STATE_ERROR = 1;
  private static final int CAPTION_STATE_HELPER_TEXT = 2;
  private static final int CAPTION_STATE_NONE = 0;
  private static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
  static final int COUNTER_INDEX = 2;
  static final int ERROR_INDEX = 0;
  static final int HELPER_INDEX = 1;
  private Animator captionAnimator;
  private FrameLayout captionArea;
  private int captionDisplayed;
  private int captionToShow;
  private final float captionTranslationYPx;
  private int captionViewsAdded;
  private final Context context;
  private boolean errorEnabled;
  private CharSequence errorText;
  private int errorTextAppearance;
  private TextView errorView;
  private CharSequence helperText;
  private boolean helperTextEnabled;
  private int helperTextTextAppearance;
  private TextView helperTextView;
  private LinearLayout indicatorArea;
  private int indicatorsAdded;
  private final TextInputLayout textInputView;
  private Typeface typeface;

  public IndicatorViewController(TextInputLayout paramTextInputLayout)
  {
    this.context = paramTextInputLayout.getContext();
    this.textInputView = paramTextInputLayout;
    this.captionTranslationYPx = this.context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
  }

  private boolean canAdjustIndicatorPadding()
  {
    return (this.indicatorArea != null) && (this.textInputView.getEditText() != null);
  }

  private void createCaptionAnimators(List<Animator> paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramTextView == null) || (!paramBoolean))
      break label8;
    label8: 
    while ((paramInt1 != paramInt3) && (paramInt1 != paramInt2))
      return;
    if (paramInt3 == paramInt1);
    for (boolean bool = true; ; bool = false)
    {
      paramList.add(createCaptionOpacityAnimator(paramTextView, bool));
      if (paramInt3 != paramInt1)
        break;
      paramList.add(createCaptionTranslationYAnimator(paramTextView));
      return;
    }
  }

  private ObjectAnimator createCaptionOpacityAnimator(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean);
    for (float f = 1.0F; ; f = 0.0F)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
      localObjectAnimator.setDuration(167L);
      localObjectAnimator.setInterpolator(a.a);
      return localObjectAnimator;
    }
  }

  private ObjectAnimator createCaptionTranslationYAnimator(TextView paramTextView)
  {
    Property localProperty = View.TRANSLATION_Y;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (-this.captionTranslationYPx);
    arrayOfFloat[1] = 0.0F;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramTextView, localProperty, arrayOfFloat);
    localObjectAnimator.setDuration(217L);
    localObjectAnimator.setInterpolator(a.d);
    return localObjectAnimator;
  }

  private TextView getCaptionViewFromDisplayState(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return this.errorView;
    case 2:
    }
    return this.helperTextView;
  }

  private boolean isCaptionStateError(int paramInt)
  {
    return (paramInt == 1) && (this.errorView != null) && (!TextUtils.isEmpty(this.errorText));
  }

  private boolean isCaptionStateHelperText(int paramInt)
  {
    return (paramInt == 2) && (this.helperTextView != null) && (!TextUtils.isEmpty(this.helperText));
  }

  private void setCaptionViewVisibilities(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
      return;
    if (paramInt2 != 0)
    {
      TextView localTextView2 = getCaptionViewFromDisplayState(paramInt2);
      if (localTextView2 != null)
      {
        localTextView2.setVisibility(0);
        localTextView2.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      TextView localTextView1 = getCaptionViewFromDisplayState(paramInt1);
      if (localTextView1 != null)
      {
        localTextView1.setVisibility(4);
        if (paramInt1 == 1)
          localTextView1.setText(null);
      }
    }
    this.captionDisplayed = paramInt2;
  }

  private void setTextViewTypeface(TextView paramTextView, Typeface paramTypeface)
  {
    if (paramTextView != null)
      paramTextView.setTypeface(paramTypeface);
  }

  private void setViewGroupGoneIfEmpty(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0)
      paramViewGroup.setVisibility(8);
  }

  private boolean shouldAnimateCaptionView(TextView paramTextView, CharSequence paramCharSequence)
  {
    return (ViewCompat.isLaidOut(this.textInputView)) && (this.textInputView.isEnabled()) && ((this.captionToShow != this.captionDisplayed) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }

  private void updateCaptionViewsVisibility(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.captionAnimator = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      createCaptionAnimators(localArrayList, this.helperTextEnabled, this.helperTextView, 2, paramInt1, paramInt2);
      createCaptionAnimators(localArrayList, this.errorEnabled, this.errorView, 1, paramInt1, paramInt2);
      b.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          IndicatorViewController.access$002(IndicatorViewController.this, paramInt2);
          IndicatorViewController.access$102(IndicatorViewController.this, null);
          if (this.val$captionViewToHide != null)
          {
            this.val$captionViewToHide.setVisibility(4);
            if ((paramInt1 == 1) && (IndicatorViewController.this.errorView != null))
              IndicatorViewController.this.errorView.setText(null);
          }
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (this.val$captionViewToShow != null)
            this.val$captionViewToShow.setVisibility(0);
        }
      });
      localAnimatorSet.start();
    }
    while (true)
    {
      this.textInputView.updateEditTextBackground();
      this.textInputView.updateLabelState(paramBoolean);
      this.textInputView.updateTextInputBoxState();
      return;
      setCaptionViewVisibilities(paramInt1, paramInt2);
    }
  }

  void addIndicator(TextView paramTextView, int paramInt)
  {
    if ((this.indicatorArea == null) && (this.captionArea == null))
    {
      this.indicatorArea = new LinearLayout(this.context);
      this.indicatorArea.setOrientation(0);
      this.textInputView.addView(this.indicatorArea, -1, -2);
      this.captionArea = new FrameLayout(this.context);
      this.indicatorArea.addView(this.captionArea, -1, new FrameLayout.LayoutParams(-2, -2));
      Space localSpace = new Space(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.indicatorArea.addView(localSpace, localLayoutParams);
      if (this.textInputView.getEditText() != null)
        adjustIndicatorPadding();
    }
    if (isCaptionView(paramInt))
    {
      this.captionArea.setVisibility(0);
      this.captionArea.addView(paramTextView);
      this.captionViewsAdded = (1 + this.captionViewsAdded);
    }
    while (true)
    {
      this.indicatorArea.setVisibility(0);
      this.indicatorsAdded = (1 + this.indicatorsAdded);
      return;
      this.indicatorArea.addView(paramTextView, paramInt);
    }
  }

  void adjustIndicatorPadding()
  {
    if (canAdjustIndicatorPadding())
      ViewCompat.setPaddingRelative(this.indicatorArea, ViewCompat.getPaddingStart(this.textInputView.getEditText()), 0, ViewCompat.getPaddingEnd(this.textInputView.getEditText()), 0);
  }

  void cancelCaptionAnimator()
  {
    if (this.captionAnimator != null)
      this.captionAnimator.cancel();
  }

  boolean errorIsDisplayed()
  {
    return isCaptionStateError(this.captionDisplayed);
  }

  boolean errorShouldBeShown()
  {
    return isCaptionStateError(this.captionToShow);
  }

  CharSequence getErrorText()
  {
    return this.errorText;
  }

  int getErrorViewCurrentTextColor()
  {
    if (this.errorView != null)
      return this.errorView.getCurrentTextColor();
    return -1;
  }

  ColorStateList getErrorViewTextColors()
  {
    if (this.errorView != null)
      return this.errorView.getTextColors();
    return null;
  }

  CharSequence getHelperText()
  {
    return this.helperText;
  }

  ColorStateList getHelperTextViewColors()
  {
    if (this.helperTextView != null)
      return this.helperTextView.getTextColors();
    return null;
  }

  int getHelperTextViewCurrentTextColor()
  {
    if (this.helperTextView != null)
      return this.helperTextView.getCurrentTextColor();
    return -1;
  }

  boolean helperTextIsDisplayed()
  {
    return isCaptionStateHelperText(this.captionDisplayed);
  }

  boolean helperTextShouldBeShown()
  {
    return isCaptionStateHelperText(this.captionToShow);
  }

  void hideError()
  {
    this.errorText = null;
    cancelCaptionAnimator();
    if (this.captionDisplayed == 1)
      if ((!this.helperTextEnabled) || (TextUtils.isEmpty(this.helperText)))
        break label61;
    label61: for (this.captionToShow = 2; ; this.captionToShow = 0)
    {
      updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
      return;
    }
  }

  void hideHelperText()
  {
    cancelCaptionAnimator();
    if (this.captionDisplayed == 2)
      this.captionToShow = 0;
    updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, null));
  }

  boolean isCaptionView(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }

  boolean isErrorEnabled()
  {
    return this.errorEnabled;
  }

  boolean isHelperTextEnabled()
  {
    return this.helperTextEnabled;
  }

  void removeIndicator(TextView paramTextView, int paramInt)
  {
    if (this.indicatorArea == null)
      return;
    if ((isCaptionView(paramInt)) && (this.captionArea != null))
    {
      this.captionViewsAdded = (-1 + this.captionViewsAdded);
      setViewGroupGoneIfEmpty(this.captionArea, this.captionViewsAdded);
      this.captionArea.removeView(paramTextView);
    }
    while (true)
    {
      this.indicatorsAdded = (-1 + this.indicatorsAdded);
      setViewGroupGoneIfEmpty(this.indicatorArea, this.indicatorsAdded);
      return;
      this.indicatorArea.removeView(paramTextView);
    }
  }

  void setErrorEnabled(boolean paramBoolean)
  {
    if (this.errorEnabled == paramBoolean)
      return;
    cancelCaptionAnimator();
    if (paramBoolean)
    {
      this.errorView = new AppCompatTextView(this.context);
      this.errorView.setId(R.id.textinput_error);
      if (this.typeface != null)
        this.errorView.setTypeface(this.typeface);
      setErrorTextAppearance(this.errorTextAppearance);
      this.errorView.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(this.errorView, 1);
      addIndicator(this.errorView, 0);
    }
    while (true)
    {
      this.errorEnabled = paramBoolean;
      return;
      hideError();
      removeIndicator(this.errorView, 0);
      this.errorView = null;
      this.textInputView.updateEditTextBackground();
      this.textInputView.updateTextInputBoxState();
    }
  }

  void setErrorTextAppearance(int paramInt)
  {
    this.errorTextAppearance = paramInt;
    if (this.errorView != null)
      this.textInputView.setTextAppearanceCompatWithErrorFallback(this.errorView, paramInt);
  }

  void setErrorViewTextColor(ColorStateList paramColorStateList)
  {
    if (this.errorView != null)
      this.errorView.setTextColor(paramColorStateList);
  }

  void setHelperTextAppearance(int paramInt)
  {
    this.helperTextTextAppearance = paramInt;
    if (this.helperTextView != null)
      TextViewCompat.setTextAppearance(this.helperTextView, paramInt);
  }

  void setHelperTextEnabled(boolean paramBoolean)
  {
    if (this.helperTextEnabled == paramBoolean)
      return;
    cancelCaptionAnimator();
    if (paramBoolean)
    {
      this.helperTextView = new AppCompatTextView(this.context);
      this.helperTextView.setId(R.id.textinput_helper_text);
      if (this.typeface != null)
        this.helperTextView.setTypeface(this.typeface);
      this.helperTextView.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(this.helperTextView, 1);
      setHelperTextAppearance(this.helperTextTextAppearance);
      addIndicator(this.helperTextView, 1);
    }
    while (true)
    {
      this.helperTextEnabled = paramBoolean;
      return;
      hideHelperText();
      removeIndicator(this.helperTextView, 1);
      this.helperTextView = null;
      this.textInputView.updateEditTextBackground();
      this.textInputView.updateTextInputBoxState();
    }
  }

  void setHelperTextViewTextColor(ColorStateList paramColorStateList)
  {
    if (this.helperTextView != null)
      this.helperTextView.setTextColor(paramColorStateList);
  }

  void setTypefaces(Typeface paramTypeface)
  {
    if (paramTypeface != this.typeface)
    {
      this.typeface = paramTypeface;
      setTextViewTypeface(this.errorView, paramTypeface);
      setTextViewTypeface(this.helperTextView, paramTypeface);
    }
  }

  void showError(CharSequence paramCharSequence)
  {
    cancelCaptionAnimator();
    this.errorText = paramCharSequence;
    this.errorView.setText(paramCharSequence);
    if (this.captionDisplayed != 1)
      this.captionToShow = 1;
    updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, paramCharSequence));
  }

  void showHelper(CharSequence paramCharSequence)
  {
    cancelCaptionAnimator();
    this.helperText = paramCharSequence;
    this.helperTextView.setText(paramCharSequence);
    if (this.captionDisplayed != 2)
      this.captionToShow = 2;
    updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, paramCharSequence));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.IndicatorViewController
 * JD-Core Version:    0.6.2
 */