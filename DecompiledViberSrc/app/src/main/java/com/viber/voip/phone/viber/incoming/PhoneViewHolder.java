package com.viber.voip.phone.viber.incoming;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.array;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.ui.call.WavesView;
import com.viber.voip.ui.call.WavesView.a;
import com.viber.voip.util.dj;
import com.viber.voip.widget.l;
import com.viber.voip.widget.l.a;

class PhoneViewHolder extends ViewHolder
  implements WavesView.a
{
  private static final l.a ANIMATED_COLOR_SPAN_FLOAT_PROPERTY = new l.a();
  private static final int CALL_LEFT = 0;
  private static final int CALL_RIGHT = 2;
  private static final int CALL_UP = 1;
  private WavesView mAnswerControls;
  private boolean mIsGroupCall;
  private boolean mIsViberIn;
  private Listener mListener;
  private ObjectAnimator mObjectAnimator;

  PhoneViewHolder(View paramView, Listener paramListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super(paramView, paramBoolean1, paramString);
    this.mIsViberIn = paramBoolean3;
    this.mListener = paramListener;
    this.mIsGroupCall = paramBoolean2;
    this.mAnswerControls = ((WavesView)paramView.findViewById(R.id.phone_answer));
    this.mAnswerControls.setTargetListener(this);
    if (this.mIsViberIn)
    {
      this.mAnswerControls.setTargetDrawables(R.array.incoming_audio_call_widget_2way_targets);
      return;
    }
    if (this.mIsVideoCall)
    {
      Resources localResources = paramView.getContext().getResources();
      this.mCallerName.setTextColor(localResources.getColor(R.color.main_background));
      this.mCallStatus.setTextColor(localResources.getColor(R.color.main_background));
      this.mAnswerControls.setTargetDrawables(R.array.incoming_video_call_widget_3way_targets);
      return;
    }
    if (this.mIsGroupCall)
    {
      this.mCallerName.setGravity(1);
      this.mCallStatus.setGravity(1);
      View localView = paramView.findViewById(R.id.title_bar);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.addRule(3, R.id.phone_incoming_photo_container);
      localLayoutParams.addRule(8, 0);
      localView.setBackground(null);
      this.mAnswerControls.setTargetDrawables(R.array.incoming_group_call_widget_3way_targets);
      return;
    }
    this.mAnswerControls.setTargetDrawables(R.array.incoming_audio_call_widget_3way_targets);
  }

  public void onTarget(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    do
    {
      return;
      this.mListener.onRejectButtonClicked();
      return;
      if (this.mIsVideoCall)
      {
        this.mListener.onAcceptVideoButtonClicked();
        return;
      }
      this.mListener.onAcceptVoiceButtonClicked();
      return;
      if (this.mIsVideoCall)
      {
        this.mListener.onAcceptVoiceButtonClicked();
        return;
      }
    }
    while (this.mIsViberIn);
    this.mListener.onMessageButtonClicked();
  }

  public void pauseCallStatusAnimation()
  {
    if (this.mIsGroupCall);
    while (this.mObjectAnimator == null)
      return;
    this.mObjectAnimator.cancel();
    this.mObjectAnimator.removeAllUpdateListeners();
    this.mObjectAnimator.removeAllListeners();
    this.mObjectAnimator = null;
  }

  public void resumeCallStatusAnimation()
  {
    if (this.mIsGroupCall)
      return;
    String str = this.mCallStatus.getText().toString();
    float f = this.mCallStatus.getPaint().measureText(str);
    SpannableString localSpannableString = new SpannableString(str);
    l locall = new l(f, new int[] { -7829368, -7829368, -1, -7829368, -7829368 });
    localSpannableString.setSpan(locall, 0, str.length(), 0);
    this.mObjectAnimator = ObjectAnimator.ofFloat(locall, ANIMATED_COLOR_SPAN_FLOAT_PROPERTY, new float[] { 0.0F, 100.0F });
    this.mObjectAnimator.setEvaluator(new FloatEvaluator());
    this.mObjectAnimator.addUpdateListener(new PhoneViewHolder..Lambda.0(this, localSpannableString));
    this.mObjectAnimator.setInterpolator(new LinearInterpolator());
    this.mObjectAnimator.setDuration(()(f * 240.0F));
    this.mObjectAnimator.setRepeatCount(-1);
    this.mObjectAnimator.start();
  }

  public void updateCallControlsVisibility(boolean paramBoolean)
  {
    dj.c(this.mAnswerControls, paramBoolean);
  }

  public static abstract interface Listener
  {
    public abstract void onAcceptVideoButtonClicked();

    public abstract void onAcceptVoiceButtonClicked();

    public abstract void onMessageButtonClicked();

    public abstract void onRejectButtonClicked();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incoming.PhoneViewHolder
 * JD-Core Version:    0.6.2
 */