package com.viber.voip.banner.view.b;

import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.util.dj;

public class c extends e
{
  private final boolean a;

  public c(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void a(TextView paramTextView)
  {
    if (dj.a(paramTextView.getContext()));
    for (float f = 12.0F; ; f = 16.0F)
    {
      paramTextView.setTextSize(2, f);
      return;
    }
  }

  public void b(TextView paramTextView)
  {
    paramTextView.setTypeface(Typeface.create("sans-serif-light", 1));
  }

  public void c(TextView paramTextView)
  {
    paramTextView.setSingleLine(true);
    if (this.a)
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
  }

  public void e(TextView paramTextView)
  {
  }

  public void f(TextView paramTextView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramTextView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.weight = 0.0F;
    paramTextView.setLayoutParams(localLayoutParams);
  }

  public void g(TextView paramTextView)
  {
  }

  public void h(TextView paramTextView)
  {
  }

  public void i(TextView paramTextView)
  {
    paramTextView.setTextColor(-1);
  }

  public void j(TextView paramTextView)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.b.c
 * JD-Core Version:    0.6.2
 */