package com.viber.voip.messages.ui;

import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.messages.o;
import com.viber.voip.widget.FocusablePinView;

public class bz extends k
{
  private View b;
  private FocusablePinView c;

  public bz(View paramView)
  {
    super(paramView);
    this.b = paramView;
    this.c = ((FocusablePinView)this.b.findViewById(R.id.focusable_pin_view));
  }

  public void a(o paramo)
  {
    super.a(paramo);
    if ((paramo != null) && (this.c != null))
      this.c.setScreenData(paramo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bz
 * JD-Core Version:    0.6.2
 */