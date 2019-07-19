package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.m;
import com.viber.voip.messages.conversation.chatinfo.e.b;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.o;
import com.viber.voip.ui.ap;

public class t extends g<m>
{
  private final SwitchCompat a = (SwitchCompat)this.itemView.findViewById(R.id.checker);
  private final TextView b = (TextView)this.itemView.findViewById(R.id.title);
  private final TextView c = (TextView)this.itemView.findViewById(R.id.summary);
  private m d;

  public t(View paramView, o paramo)
  {
    super(paramView);
    this.itemView.setOnClickListener(new u(this, paramo));
  }

  public void a(m paramm, e parame)
  {
    this.d = paramm;
    b localb = (b)parame.a().a();
    this.itemView.setEnabled(paramm.b());
    View localView = this.itemView;
    if (paramm.a());
    for (String str1 = paramm.c() + "on"; ; str1 = paramm.c() + "off")
    {
      localView.setContentDescription(str1);
      this.a.setChecked(paramm.a());
      this.b.setText(paramm.f());
      String str2 = paramm.g();
      if (paramm.h())
        str2 = c.b(str2);
      this.c.setText(str2);
      DrawableCompat.setTintList(DrawableCompat.wrap(this.a.getThumbDrawable()), localb.a());
      DrawableCompat.setTintList(DrawableCompat.wrap(this.a.getTrackDrawable()), localb.b());
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.t
 * JD-Core Version:    0.6.2
 */