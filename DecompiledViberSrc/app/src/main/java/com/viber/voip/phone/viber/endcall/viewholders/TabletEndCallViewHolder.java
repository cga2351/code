package com.viber.voip.phone.viber.endcall.viewholders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.viber.endcall.EndCallStateResolver;
import com.viber.voip.util.dj;

public class TabletEndCallViewHolder extends EndCallViewHolder
{
  private ImageView mCallerPhotoRealView;
  private EndCallStateResolver mEndCallStateResolver;
  private View mPhoneCallOffline;
  private View mRedialButton;
  private View mSendMessageButton;
  private View mViberOutButton;

  public TabletEndCallViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, EndCallStateResolver paramEndCallStateResolver)
  {
    super(paramLayoutInflater, paramViewGroup);
    this.mEndCallStateResolver = paramEndCallStateResolver;
    this.mCallerPhotoRealView = ((ImageView)this.mContentView.findViewById(R.id.phone_photo_main));
    if (dj.c(this.mContentView.getContext()))
      this.mCallerPhotoView = this.mContentView;
    this.mSendMessageButton = this.mContentView.findViewById(R.id.phone_send_message);
    this.mViberOutButton = this.mContentView.findViewById(R.id.phone_viberout);
    this.mRedialButton = this.mContentView.findViewById(R.id.phone_redial);
    this.mPhoneCallOffline = this.mContentView.findViewById(R.id.phone_call_offline);
  }

  protected int getLayoutRes()
  {
    return R.layout.phone_end_call;
  }

  public int getPhotoPlaceholder()
  {
    if (this.mCallerPhotoRealView == null)
      return R.drawable.call_screen_bg;
    return R.drawable.phone_contact_generic;
  }

  public View getPhotoView()
  {
    if (this.mCallerPhotoRealView == null)
      return this.mCallerPhotoView;
    return this.mCallerPhotoRealView;
  }

  public void setCallInfo(CallInfo paramCallInfo)
  {
    super.setCallInfo(paramCallInfo);
    if (paramCallInfo.isConference())
    {
      dj.b(this.mViberOutButton, false);
      dj.b(this.mRedialButton, false);
      dj.b(this.mSendMessageButton, false);
      dj.b(this.mCallerPhotoRealView, false);
    }
    do
    {
      return;
      if (paramCallInfo.getCallerInfo().getContact() == null)
        this.mCallerPhotoRealView.setImageResource(getPhotoPlaceholder());
      if (paramCallInfo.isViberOut())
      {
        TextView localTextView = (TextView)this.mContentView.findViewById(R.id.phone_call_viber_out);
        localTextView.setEnabled(true);
        dj.c(localTextView, 0);
      }
      if (EndCallStateResolver.DEFAULT == this.mEndCallStateResolver)
      {
        this.mSendMessageButton.setVisibility(4);
        return;
      }
    }
    while (EndCallStateResolver.TIMEOUT != this.mEndCallStateResolver);
    this.mPhoneCallOffline.setVisibility(0);
  }

  public void setRedialClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mRedialButton != null)
      this.mRedialButton.setOnClickListener(paramOnClickListener);
  }

  public void setSendMessageClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mSendMessageButton != null)
      this.mSendMessageButton.setOnClickListener(paramOnClickListener);
  }

  public void setViberOutClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mViberOutButton != null)
      this.mViberOutButton.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.viewholders.TabletEndCallViewHolder
 * JD-Core Version:    0.6.2
 */