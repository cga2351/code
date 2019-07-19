package com.viber.voip.phone.viber.conference.ui.incall;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.viber.voip.R.dimen;

public class ConferenceViewsScrollAdjuster
{
  private final View mConferenceNameView;
  private final View mConferenceParticipantsTopShadowView;
  private final int mMaxConferenceNameTopSpace;
  private final int mMaxConferenceParticipantsTopShadowIndent;
  private final int mMaxSpeakingPersonGlowingPhotoSize;
  private final int mMaxSpeakingPersonGlowingPhotoTopSpace;
  private final int mMaxSpeakingPersonNameTextSize;
  private final int mMaxSpeakingPersonPhotoSize;
  private final int mMinConferenceNameTopSpace;
  private final int mMinConferenceParticipantsTopShadowIndent;
  private final int mMinSpeakingPersonGlowingPhotoSize;
  private final int mMinSpeakingPersonGlowingPhotoTopSpace;
  private final int mMinSpeakingPersonNameTextSize;
  private final int mMinSpeakingPersonPhotoSize;
  private final TextView mSpeakingPersonNameView;
  private final View mSpeakingPersonPhotoGlowingView;
  private final View mSpeakingPersonPhotoView;

  public ConferenceViewsScrollAdjuster(Resources paramResources, View paramView1, View paramView2, TextView paramTextView, View paramView3, View paramView4)
  {
    this.mSpeakingPersonNameView = paramTextView;
    this.mSpeakingPersonPhotoView = paramView1;
    this.mSpeakingPersonPhotoGlowingView = paramView2;
    this.mConferenceNameView = paramView3;
    this.mConferenceParticipantsTopShadowView = paramView4;
    this.mMinConferenceNameTopSpace = paramResources.getDimensionPixelOffset(R.dimen.conference_call_room_name_min_top_space);
    this.mMaxConferenceNameTopSpace = paramResources.getDimensionPixelOffset(R.dimen.conference_call_room_name_max_top_space);
    this.mMinSpeakingPersonNameTextSize = paramResources.getDimensionPixelSize(R.dimen.conference_call_speaking_name_min_text_size);
    this.mMaxSpeakingPersonNameTextSize = paramResources.getDimensionPixelSize(R.dimen.conference_call_speaking_name_max_text_size);
    this.mMinSpeakingPersonGlowingPhotoTopSpace = paramResources.getDimensionPixelOffset(R.dimen.conference_call_speaking_glowing_photo_min_top_space);
    this.mMaxSpeakingPersonGlowingPhotoTopSpace = paramResources.getDimensionPixelOffset(R.dimen.conference_call_speaking_glowing_photo_max_top_space);
    this.mMinSpeakingPersonPhotoSize = paramResources.getDimensionPixelSize(R.dimen.conference_call_speaking_photo_min_size);
    this.mMaxSpeakingPersonPhotoSize = paramResources.getDimensionPixelSize(R.dimen.conference_call_speaking_photo_max_size);
    this.mMinSpeakingPersonGlowingPhotoSize = paramResources.getDimensionPixelSize(R.dimen.conference_call_speaking_glowing_photo_min_size);
    this.mMaxSpeakingPersonGlowingPhotoSize = paramResources.getDimensionPixelSize(R.dimen.conference_call_speaking_glowing_photo_max_size);
    this.mMinConferenceParticipantsTopShadowIndent = paramResources.getDimensionPixelSize(R.dimen.conference_call_participants_top_shadow_min_indent);
    this.mMaxConferenceParticipantsTopShadowIndent = paramResources.getDimensionPixelSize(R.dimen.conference_call_participants_top_shadow_max_indent);
  }

  private void adjustConferenceName(double paramDouble)
  {
    int i = getSize(this.mMinConferenceNameTopSpace, this.mMaxConferenceNameTopSpace, paramDouble);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mConferenceNameView.getLayoutParams();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.mConferenceNameView.setLayoutParams(localMarginLayoutParams);
    }
  }

  private void adjustParticipantsTopShadow(double paramDouble)
  {
    int i = getSize(this.mMinConferenceParticipantsTopShadowIndent, this.mMaxConferenceParticipantsTopShadowIndent, paramDouble);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mConferenceParticipantsTopShadowView.getLayoutParams();
    if (i != localMarginLayoutParams.topMargin)
    {
      localMarginLayoutParams.topMargin = i;
      this.mConferenceParticipantsTopShadowView.setLayoutParams(localMarginLayoutParams);
    }
  }

  private void adjustSpeakingPersonGlowingPhoto(double paramDouble)
  {
    int i = 1;
    int j = getSize(this.mMinSpeakingPersonGlowingPhotoSize, this.mMaxSpeakingPersonGlowingPhotoSize, paramDouble);
    int k = getSize(this.mMinSpeakingPersonGlowingPhotoTopSpace, this.mMaxSpeakingPersonGlowingPhotoTopSpace, paramDouble);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mSpeakingPersonPhotoGlowingView.getLayoutParams();
    int m = localMarginLayoutParams.topMargin;
    int n = 0;
    if (k != m)
    {
      localMarginLayoutParams.topMargin = k;
      n = i;
    }
    if (j != localMarginLayoutParams.width)
    {
      localMarginLayoutParams.width = j;
      localMarginLayoutParams.height = j;
    }
    while (true)
    {
      if (i != 0)
        this.mSpeakingPersonPhotoGlowingView.setLayoutParams(localMarginLayoutParams);
      return;
      i = n;
    }
  }

  private void adjustSpeakingPersonName(double paramDouble)
  {
    int i = getSize(this.mMinSpeakingPersonNameTextSize, this.mMaxSpeakingPersonNameTextSize, paramDouble);
    if (Math.abs(this.mSpeakingPersonNameView.getTextSize() - i) > 0.5D)
      this.mSpeakingPersonNameView.setTextSize(0, i);
  }

  private void adjustSpeakingPersonPhoto(double paramDouble)
  {
    int i = getSize(this.mMinSpeakingPersonPhotoSize, this.mMaxSpeakingPersonPhotoSize, paramDouble);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mSpeakingPersonPhotoView.getLayoutParams();
    int j = localMarginLayoutParams.width;
    int k = 0;
    if (i != j)
    {
      k = 1;
      localMarginLayoutParams.width = i;
      localMarginLayoutParams.height = i;
    }
    if (k != 0)
      this.mSpeakingPersonPhotoView.setLayoutParams(localMarginLayoutParams);
  }

  private static int getSize(int paramInt1, int paramInt2, double paramDouble)
  {
    return Math.min(paramInt2, Math.max(paramInt1, paramInt1 + (int)(paramDouble * (paramInt2 - paramInt1))));
  }

  public void adjustToPercent(double paramDouble)
  {
    adjustSpeakingPersonPhoto(paramDouble);
    adjustSpeakingPersonGlowingPhoto(paramDouble);
    adjustSpeakingPersonName(paramDouble);
    adjustConferenceName(paramDouble);
    adjustParticipantsTopShadow(paramDouble);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.incall.ConferenceViewsScrollAdjuster
 * JD-Core Version:    0.6.2
 */