package com.viber.voip.phone.viber.endcall.viewholders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.util.dj;

public class TimeOutEndCallViewHolder extends EndCallViewHolder
{
  private View mPhoneCallOffline = this.mContentView.findViewById(R.id.phone_call_offline);
  private View mRedialButton = this.mContentView.findViewById(R.id.phone_redial);
  private View mSendMessageButton = this.mContentView.findViewById(R.id.phone_send_message);
  private View mViberOutButton = this.mContentView.findViewById(R.id.phone_viberout);

  public TimeOutEndCallViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    super(paramLayoutInflater, paramViewGroup);
  }

  protected int getLayoutRes()
  {
    return R.layout.fragment_phone_end_call_timeout;
  }

  public void setCallInfo(CallInfo paramCallInfo)
  {
    int i = 1;
    super.setCallInfo(paramCallInfo);
    View localView;
    if ((dj.a(this.mContentView.getContext())) || (paramCallInfo.isConference()) || ((paramCallInfo.needShowAds()) && (paramCallInfo.getAdProviderType() == i)))
    {
      int k = i;
      localView = this.mPhoneCallOffline;
      if (k != 0)
        break label81;
    }
    while (true)
    {
      dj.b(localView, i);
      if (paramCallInfo.isConference())
        dj.b(this.mButtonsLayout, false);
      return;
      int m = 0;
      break;
      label81: int j = 0;
    }
  }

  public void setRedialClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mRedialButton.setOnClickListener(paramOnClickListener);
  }

  public void setSendMessageClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mSendMessageButton.setOnClickListener(paramOnClickListener);
  }

  public void setViberOutClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mViberOutButton.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.viewholders.TimeOutEndCallViewHolder
 * JD-Core Version:    0.6.2
 */