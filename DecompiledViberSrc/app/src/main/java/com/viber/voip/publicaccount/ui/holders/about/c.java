package com.viber.voip.publicaccount.ui.holders.about;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.links.f;
import com.viber.voip.widget.TextViewWithDescription;
import com.viber.voip.widget.ae;

class c
  implements b
{
  private final TextViewWithDescription a;
  private final TextViewWithDescription b;
  private final TextViewWithDescription c;

  public c(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.a = ((TextViewWithDescription)paramView.findViewById(R.id.about));
    this.c = ((TextViewWithDescription)paramView.findViewById(R.id.website));
    this.b = ((TextViewWithDescription)paramView.findViewById(R.id.location));
    this.b.setOnClickListener(paramOnClickListener);
  }

  private void c(String paramString)
  {
    this.a.getEditText().setText(paramString);
    f.b().a(this.a.getEditText());
  }

  public void a()
  {
    this.b.setOnClickListener(null);
    this.c.setOnClickListener(null);
  }

  public void a(final String paramString)
  {
    if (da.a(paramString))
    {
      dj.b(this.a, false);
      return;
    }
    dj.b(this.a, true);
    if (paramString.length() <= 100)
    {
      c(paramString);
      return;
    }
    String str = this.a.getResources().getString(R.string.public_account_info_about_read_more);
    ClickableSpan local1 = new ClickableSpan()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a(c.this, paramString);
      }
    };
    SpannableString localSpannableString = new SpannableString(paramString.substring(0, 100) + "... " + str);
    localSpannableString.setSpan(local1, 100 + "... ".length(), 100 + "... ".length() + str.length(), 33);
    this.a.getEditText().setText(localSpannableString);
    this.a.getEditText().setMovementMethod(LinkMovementMethod.getInstance());
  }

  public void a(String paramString, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.c.setText(paramString);
    this.c.setOnClickListener(paramOnClickListener);
    this.c.setEditable(false);
    this.c.setEnabled(paramBoolean);
    dj.b(this.c, true);
  }

  public void b()
  {
    dj.b(this.c, false);
    this.c.setOnClickListener(null);
  }

  public void b(String paramString)
  {
    this.b.setText(paramString);
  }

  public void c()
  {
    TextView localTextView = this.a.getDescriptionView();
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_pa_info_age_restricted, 0);
    localTextView.setCompoundDrawablePadding(localTextView.getResources().getDimensionPixelSize(R.dimen.public_account_info_age_restricted_padding));
  }

  public void d()
  {
    TextView localTextView = this.a.getDescriptionView();
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    localTextView.setCompoundDrawablePadding(0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.about.c
 * JD-Core Version:    0.6.2
 */