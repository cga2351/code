package com.viber.voip.messages.conversation.adapter.a.b;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.r;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.conversation.adapter.w;

public class d extends r
{
  protected TextView a;

  public d(View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(R.id.tx_left_text));
    if (paramBoolean)
      this.a.setPadding(0, 0, 0, 0);
  }

  public void a(s params)
  {
    super.a(params);
    this.a.setText(((w)params).a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.b.d
 * JD-Core Version:    0.6.2
 */