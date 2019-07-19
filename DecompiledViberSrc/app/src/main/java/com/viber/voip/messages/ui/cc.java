package com.viber.voip.messages.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.voip.R.id;
import com.viber.voip.messages.o;
import com.viber.voip.ui.ViberTextView;

public class cc extends k
{
  private View b;
  private ViberTextView c;
  private View d;
  private ImageView e;

  public cc(View paramView)
  {
    super(paramView);
    this.b = paramView;
    this.d = paramView.findViewById(R.id.btn_cancel);
    this.c = ((ViberTextView)paramView.findViewById(R.id.btn_confirm));
    this.e = ((ImageView)paramView.findViewById(R.id.icon));
  }

  public void a(final o paramo)
  {
    super.a(paramo);
    if (paramo != null)
    {
      if (this.d != null)
        this.d.setOnClickListener(paramo.a());
      if (this.c != null)
      {
        this.c.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (paramo.f() != null)
            {
              paramo.c().a(paramo);
              return;
            }
            paramo.b().onClick(cc.a(cc.this));
          }
        });
        if (paramo.g() != null)
          this.c.setText(paramo.g());
        if (paramo.h() > 0)
          this.e.setImageResource(paramo.h());
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.cc
 * JD-Core Version:    0.6.2
 */