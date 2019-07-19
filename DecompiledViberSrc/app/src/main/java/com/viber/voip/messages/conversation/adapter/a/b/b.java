package com.viber.voip.messages.conversation.adapter.a.b;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.conversation.adapter.w;

public class b extends d
{
  public b(View paramView)
  {
    super(paramView, false);
  }

  public void a(s params)
  {
    super.a(params);
    if (3L != ((w)params).i())
    {
      this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_selecttor, 0);
      return;
    }
    this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.b.b
 * JD-Core Version:    0.6.2
 */