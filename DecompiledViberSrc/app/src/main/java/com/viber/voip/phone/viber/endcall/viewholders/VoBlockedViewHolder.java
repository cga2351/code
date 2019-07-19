package com.viber.voip.phone.viber.endcall.viewholders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

public class VoBlockedViewHolder extends EndCallViewHolder
{
  private View mLearnMoreLink = this.mContentView.findViewById(R.id.learn_more_link);

  VoBlockedViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    super(paramLayoutInflater, paramViewGroup);
  }

  protected int getLayoutRes()
  {
    return R.layout.fragment_phone_end_vo_blocked_call;
  }

  void setCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    getAdMobCloseBtn().setOnClickListener(paramOnClickListener);
  }

  void setLearnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mLearnMoreLink.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.viewholders.VoBlockedViewHolder
 * JD-Core Version:    0.6.2
 */