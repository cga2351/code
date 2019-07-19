package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.df;

public class o extends e<a, i>
{
  private final TextView a;

  public o(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    int i = parami.X();
    if (i != 0)
      for (Drawable localDrawable : this.a.getCompoundDrawables())
        if (localDrawable != null)
          this.a.setCompoundDrawables(df.a(localDrawable, i, true), null, null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.o
 * JD-Core Version:    0.6.2
 */