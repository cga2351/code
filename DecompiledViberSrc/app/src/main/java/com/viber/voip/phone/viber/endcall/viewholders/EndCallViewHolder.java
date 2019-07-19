package com.viber.voip.phone.viber.endcall.viewholders;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.a.e;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.widget.PausableChronometer;

public abstract class EndCallViewHolder
{
  protected static final e L = ViberEnv.getLogger();
  protected View mAdMobCloseBtn;
  protected View mButtonsLayout;
  protected PausableChronometer mCallStatusView;
  protected TextView mCallerNameView;
  protected View mCallerPhotoView;
  protected View mContentView;
  protected Resources mResources;
  protected View mTopControls;

  public EndCallViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.mContentView = paramLayoutInflater.inflate(getLayoutRes(), paramViewGroup, false);
    this.mResources = this.mContentView.getResources();
    this.mCallerPhotoView = this.mContentView.findViewById(R.id.l_phone_photo);
    this.mCallerNameView = ((TextView)this.mContentView.findViewById(R.id.phone_caller_name));
    this.mCallStatusView = ((PausableChronometer)this.mContentView.findViewById(R.id.phone_call_status));
    this.mAdMobCloseBtn = this.mContentView.findViewById(R.id.close_admob_btn);
    this.mButtonsLayout = this.mContentView.findViewById(R.id.bottom_btns);
    this.mTopControls = this.mContentView.findViewById(R.id.top_controls);
  }

  public void adjustLayoutForAds()
  {
  }

  public View getAdMobCloseBtn()
  {
    return this.mAdMobCloseBtn;
  }

  public View getButtonsLayout()
  {
    return this.mButtonsLayout;
  }

  public PausableChronometer getCallStatusView()
  {
    return this.mCallStatusView;
  }

  public View getContentView()
  {
    return this.mContentView;
  }

  protected abstract int getLayoutRes();

  public int getPhotoPlaceholder()
  {
    return R.drawable.call_screen_bg;
  }

  public View getPhotoView()
  {
    return this.mCallerPhotoView;
  }

  public View getTopControls()
  {
    return this.mTopControls;
  }

  public void setCallInfo(CallInfo paramCallInfo)
  {
    this.mCallerNameView.setText(paramCallInfo.getCallerInfo().getEndCallDisplayName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.viewholders.EndCallViewHolder
 * JD-Core Version:    0.6.2
 */