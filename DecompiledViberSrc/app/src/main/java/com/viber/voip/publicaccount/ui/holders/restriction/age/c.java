package com.viber.voip.publicaccount.ui.holders.restriction.age;

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
  private final TextView c;

  @SuppressLint({"RtlHardcoded"})
  public c(View paramView)
  {
    this.a = paramView.findViewById(R.id.adult_related_pref);
    this.b = ((SwitchCompat)this.a.findViewById(R.id.checker));
    this.b.setDuplicateParentStateEnabled(false);
    this.a.setEnabled(false);
    this.c = ((TextView)this.a.findViewById(R.id.title));
    this.c.setText(R.string.age_restricted_pref_title_for_public_account);
    TextView localTextView = (TextView)this.a.findViewById(R.id.summary);
    localTextView.setText(R.string.vibe_are_restricted_pref_summary);
    if (com.viber.common.d.c.a())
      localTextView.setGravity(3);
  }

  private void b()
  {
    this.a.setOnClickListener(null);
    this.b.setOnCheckedChangeListener(null);
  }

  public void a()
  {
    b();
  }

  public void a(View.OnClickListener paramOnClickListener, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.a.setEnabled(true);
    this.b.setEnabled(true);
    this.a.setOnClickListener(paramOnClickListener);
    this.b.setOnCheckedChangeListener(paramOnCheckedChangeListener);
  }

  public void a(boolean paramBoolean)
  {
    this.b.setChecked(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.restriction.age.c
 * JD-Core Version:    0.6.2
 */