package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.messages.o;
import com.viber.voip.ui.ViberTextView;
import java.util.Locale;

public class k
{
  protected View a;
  private View b;
  private ViberTextView c;
  private ViberTextView d;
  private ViberTextView e;

  public k(View paramView)
  {
    this.b = paramView;
    this.a = paramView.findViewById(R.id.btn_close);
    this.c = ((ViberTextView)paramView.findViewById(R.id.header));
    this.d = ((ViberTextView)paramView.findViewById(R.id.description));
    this.e = ((ViberTextView)paramView.findViewById(R.id.txt_hint));
  }

  private SpannableString a(int paramInt1, int paramInt2, final View.OnClickListener paramOnClickListener)
  {
    String str1;
    SpannableString localSpannableString;
    if ((paramInt2 > 0) && (paramOnClickListener != null))
    {
      String str2 = this.b.getResources().getString(paramInt2);
      str1 = String.format(Locale.getDefault(), this.b.getResources().getString(paramInt1), new Object[] { str2 });
      localSpannableString = new SpannableString(str1);
      int i = str1.indexOf(str2);
      int j = i + str2.length();
      localSpannableString.setSpan(new ClickableSpan()
      {
        public void onClick(View paramAnonymousView)
        {
          paramOnClickListener.onClick(paramAnonymousView);
        }
      }
      , i, j, 33);
      localSpannableString.setSpan(new UnderlineSpan(), i, j, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(R.color.negative)), i, j, 33);
    }
    while (true)
    {
      if (str1.startsWith("*"))
        localSpannableString.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(R.color.hidden_chats_hint_asteriks)), 0, 1, 33);
      return localSpannableString;
      str1 = this.b.getResources().getString(paramInt1);
      localSpannableString = new SpannableString(str1);
    }
  }

  public void a(o paramo)
  {
    if (paramo != null)
    {
      if (this.a != null)
        this.a.setOnClickListener(paramo.a());
      if ((this.d != null) && (paramo.j() != 0))
      {
        this.d.setText(a(paramo.j(), paramo.k(), paramo.l()));
        this.d.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if ((this.c != null) && (paramo.i() != 0))
        this.c.setText(this.b.getContext().getResources().getString(paramo.i()));
      if ((this.e != null) && (paramo.n() != 0))
      {
        this.e.setText(a(paramo.n(), paramo.m(), paramo.o()));
        this.e.setMovementMethod(LinkMovementMethod.getInstance());
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.k
 * JD-Core Version:    0.6.2
 */