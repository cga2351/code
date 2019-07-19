package com.viber.voip.phone.viber.endcall.viewholders;

import android.support.constraint.ConstraintLayout.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.viber.endcall.EndCallStateResolver;
import com.viber.voip.util.e.j;
import com.viber.voip.widget.PausableChronometer;

public class DefaultEndCallViewHolder extends EndCallViewHolder
{
  private View mChatsButton;
  private EndCallStateResolver mEndCallStateResolver;
  private View mSendMessageButton;

  DefaultEndCallViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, EndCallStateResolver paramEndCallStateResolver)
  {
    super(paramLayoutInflater, paramViewGroup);
    this.mEndCallStateResolver = paramEndCallStateResolver;
    this.mSendMessageButton = this.mContentView.findViewById(R.id.phone_send_message);
    this.mChatsButton = this.mContentView.findViewById(R.id.phone_chats);
  }

  public void adjustLayoutForAds()
  {
    if (this.mEndCallStateResolver == EndCallStateResolver.DEFAULT)
      ((ConstraintLayout.a)this.mCallStatusView.getLayoutParams()).topMargin = j.a(this.mContentView.getContext(), 0.0F);
  }

  protected int getLayoutRes()
  {
    return R.layout.fragment_phone_end_call_default;
  }

  public void setCallInfo(CallInfo paramCallInfo)
  {
    super.setCallInfo(paramCallInfo);
    View localView = this.mSendMessageButton;
    if (!paramCallInfo.isViberIn());
    for (boolean bool = true; ; bool = false)
    {
      localView.setEnabled(bool);
      return;
    }
  }

  public void setChatsClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mChatsButton.setOnClickListener(paramOnClickListener);
  }

  public void setSendMessageClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mSendMessageButton.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.viewholders.DefaultEndCallViewHolder
 * JD-Core Version:    0.6.2
 */