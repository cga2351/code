package com.viber.voip.phone.viber.endcall.viewholders;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;

public class VoEndCallViewHolder extends EndCallViewHolder
{
  private View mRedialButton;

  public VoEndCallViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    super(paramLayoutInflater, paramViewGroup);
    String str = this.mResources.getString(R.string.viber_out);
    TextView localTextView = (TextView)this.mContentView.findViewById(R.id.phone_call_viber_out);
    localTextView.setText(str);
    localTextView.setEnabled(false);
    localTextView.setOnClickListener(null);
    this.mRedialButton = this.mContentView.findViewById(R.id.phone_redial);
  }

  protected int getLayoutRes()
  {
    return R.layout.fragment_phone_end_vo_call;
  }

  public void setRedialClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mRedialButton.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.viewholders.VoEndCallViewHolder
 * JD-Core Version:    0.6.2
 */