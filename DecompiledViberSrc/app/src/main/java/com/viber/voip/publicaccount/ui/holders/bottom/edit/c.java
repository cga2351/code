package com.viber.voip.publicaccount.ui.holders.bottom.edit;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;

class c
  implements b
{
  private final View a;
  private final View b;
  private final TextView c;

  public c(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.a = paramView.findViewById(R.id.btn_leave_public_account);
    this.a.setOnClickListener(paramOnClickListener);
    this.b = paramView.findViewById(R.id.btn_save_public_account_details);
    this.b.setOnClickListener(paramOnClickListener);
    this.c = ((TextView)paramView.findViewById(R.id.btn_learn_more));
    SpannableString localSpannableString = new SpannableString(this.c.getResources().getString(R.string.learn_more));
    localSpannableString.setSpan(new UnderlineSpan(), 0, localSpannableString.length(), 17);
    this.c.setText(localSpannableString);
    this.c.setOnClickListener(paramOnClickListener);
  }

  public void a()
  {
    this.a.setOnClickListener(null);
    this.b.setOnClickListener(null);
    this.c.setOnClickListener(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.bottom.edit.c
 * JD-Core Version:    0.6.2
 */