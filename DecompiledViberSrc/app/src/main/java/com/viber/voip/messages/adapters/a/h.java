package com.viber.voip.messages.adapters.a;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.messages.adapters.i;
import com.viber.voip.messages.adapters.o;
import com.viber.voip.messages.adapters.p;

public class h extends i
{
  TextView a;

  public h(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView);
  }

  public void a(p paramp)
  {
    o localo = (o)paramp;
    this.a.setText(localo.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.h
 * JD-Core Version:    0.6.2
 */