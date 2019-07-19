package com.viber.voip.banner.view.b;

import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class b extends e
{
  private int a;

  public b(int paramInt)
  {
    this.a = paramInt;
  }

  public void a(TextView paramTextView)
  {
    paramTextView.setTextSize(2, 15.0F);
  }

  public void b(TextView paramTextView)
  {
    paramTextView.setTypeface(Typeface.create("sans-serif-light", 0));
  }

  public void c(TextView paramTextView)
  {
    if (this.a > 0)
    {
      paramTextView.setMaxLines(this.a);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }

  public void d(TextView paramTextView)
  {
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
 * Qualified Name:     com.viber.voip.banner.view.b.b
 * JD-Core Version:    0.6.2
 */