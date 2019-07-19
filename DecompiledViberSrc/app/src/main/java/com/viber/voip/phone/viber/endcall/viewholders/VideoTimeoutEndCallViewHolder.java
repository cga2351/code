package com.viber.voip.phone.viber.endcall.viewholders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

public class VideoTimeoutEndCallViewHolder extends EndCallViewHolder
{
  private View mRedialButton = this.mContentView.findViewById(R.id.phone_redial);
  private View mSendMessageButton = this.mContentView.findViewById(R.id.phone_send_message);
  private View mViberOutButton = this.mContentView.findViewById(R.id.phone_viberout);

  public VideoTimeoutEndCallViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    super(paramLayoutInflater, paramViewGroup);
  }

  protected int getLayoutRes()
  {
    return R.layout.fragment_phone_end_video_timeout_call;
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
 * Qualified Name:     com.viber.voip.phone.viber.endcall.viewholders.VideoTimeoutEndCallViewHolder
 * JD-Core Version:    0.6.2
 */