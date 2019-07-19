package com.viber.voip.publicaccount.ui.holders.publication;

import android.annotation.SuppressLint;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;

class c
  implements b
{
  private final View a;
  private final CompoundButton b;

  @SuppressLint({"RtlHardcoded"})
  public c(View paramView, View.OnClickListener paramOnClickListener, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.a = paramView.findViewById(R.id.publish_public_account_toggle_container);
    this.a.setOnClickListener(paramOnClickListener);
    this.b = ((SwitchCompat)this.a.findViewById(R.id.checker));
    this.b.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    ((TextView)this.a.findViewById(R.id.title)).setText(R.string.publish_public_account_group_toggle_title);
    TextView localTextView = (TextView)this.a.findViewById(R.id.summary);
    localTextView.setText(R.string.publish_public_account_group_toggle_summary);
    if (com.viber.common.d.c.a())
      localTextView.setGravity(3);
  }

  public void a()
  {
    this.a.setOnClickListener(null);
    this.b.setOnCheckedChangeListener(null);
  }

  public void a(boolean paramBoolean)
  {
    this.b.setChecked(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.publication.c
 * JD-Core Version:    0.6.2
 */