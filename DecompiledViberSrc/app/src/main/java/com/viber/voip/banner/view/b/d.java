package com.viber.voip.banner.view.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.util.e.j;

public class d extends e
{
  public void a(TextView paramTextView)
  {
    paramTextView.setTextSize(2, 12.0F);
  }

  public void b(TextView paramTextView)
  {
  }

  public void c(TextView paramTextView)
  {
  }

  public void d(TextView paramTextView)
  {
  }

  public void e(TextView paramTextView)
  {
  }

  public void f(TextView paramTextView)
  {
  }

  public void g(TextView paramTextView)
  {
    paramTextView.setPadding(j.a(10.0F), 0, j.a(10.0F), 0);
  }

  public void h(TextView paramTextView)
  {
    paramTextView.setGravity(17);
  }

  public void i(TextView paramTextView)
  {
    paramTextView.setTextColor(-1);
  }

  public void j(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(R.drawable.btn_inset_idle);
    paramTextView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getAction())
        {
        case 2:
        default:
        case 0:
        case 1:
        case 3:
        }
        while (true)
        {
          return false;
          paramAnonymousView.setAlpha(0.4F);
          continue;
          paramAnonymousView.setAlpha(1.0F);
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.b.d
 * JD-Core Version:    0.6.2
 */