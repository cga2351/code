package com.viber.voip.phone.viber.incoming;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.viber.voip.R.id;

class TabletViewHolder extends ViewHolder
  implements View.OnClickListener
{
  private Listener mListener;

  TabletViewHolder(View paramView, Listener paramListener, boolean paramBoolean, String paramString)
  {
    super(paramView, paramBoolean, paramString);
    this.mListener = paramListener;
    ((ImageButton)paramView.findViewById(R.id.phone_call_accept)).setOnClickListener(this);
    ((ImageButton)paramView.findViewById(R.id.phone_call_reject)).setOnClickListener(this);
  }

  public void onClick(View paramView)
  {
    if (R.id.phone_call_accept == paramView.getId())
      this.mListener.onAcceptButtonClicked();
    while (R.id.phone_call_reject != paramView.getId())
      return;
    this.mListener.onRejectButtonClicked();
  }

  public static abstract interface Listener
  {
    public abstract void onAcceptButtonClicked();

    public abstract void onRejectButtonClicked();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incoming.TabletViewHolder
 * JD-Core Version:    0.6.2
 */