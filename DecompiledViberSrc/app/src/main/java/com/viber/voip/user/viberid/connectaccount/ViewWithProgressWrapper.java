package com.viber.voip.user.viberid.connectaccount;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;

public class ViewWithProgressWrapper
{
  private AnimationDrawable mAnimationDrawable;
  private final boolean mIsRtl;
  private final TextView mTextView;

  public ViewWithProgressWrapper(TextView paramTextView)
  {
    this(paramTextView, false);
  }

  public ViewWithProgressWrapper(TextView paramTextView, boolean paramBoolean)
  {
    this.mTextView = paramTextView;
    if ((!paramBoolean) && (c.a()));
    for (boolean bool = true; ; bool = false)
    {
      this.mIsRtl = bool;
      return;
    }
  }

  public void hideLoadding()
  {
    if (this.mAnimationDrawable != null)
    {
      this.mAnimationDrawable.stop();
      this.mTextView.setCompoundDrawables(null, null, null, null);
    }
  }

  public void showLoading()
  {
    if (this.mAnimationDrawable == null)
    {
      int i = this.mTextView.getResources().getDimensionPixelSize(R.dimen.viber_id_edit_text_progress_size);
      int j = this.mTextView.getResources().getDimensionPixelSize(R.dimen.viber_id_edit_text_progress_padding);
      this.mAnimationDrawable = ((AnimationDrawable)ContextCompat.getDrawable(this.mTextView.getContext(), R.drawable.viber_indeterminate_progress));
      this.mAnimationDrawable.setBounds(new Rect(0, 0, i, i));
      this.mTextView.setCompoundDrawablePadding(j);
    }
    if (this.mAnimationDrawable.isRunning())
      return;
    if (this.mIsRtl)
      this.mTextView.setCompoundDrawables(this.mAnimationDrawable, null, null, null);
    while (true)
    {
      this.mAnimationDrawable.start();
      return;
      this.mTextView.setCompoundDrawables(null, null, this.mAnimationDrawable, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.ViewWithProgressWrapper
 * JD-Core Version:    0.6.2
 */