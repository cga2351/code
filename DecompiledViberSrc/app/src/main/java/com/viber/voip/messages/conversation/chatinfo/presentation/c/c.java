package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.b;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.l;
import com.viber.voip.util.dc;

public class c extends g<b>
{
  private final TextView a;
  private final ImageView b;
  private b c;

  public c(View paramView, l paraml)
  {
    super(paramView);
    this.itemView.setOnClickListener(new d(this, paraml));
    this.a = ((TextView)this.itemView.findViewById(R.id.addParticipantsItemText));
    this.b = ((ImageView)this.itemView.findViewById(R.id.icon));
  }

  public void a(b paramb, e parame)
  {
    this.c = paramb;
    this.a.setText(paramb.a());
    this.b.setImageResource(paramb.b());
    this.b.setColorFilter(dc.d(this.itemView.getContext(), paramb.c()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.c
 * JD-Core Version:    0.6.2
 */