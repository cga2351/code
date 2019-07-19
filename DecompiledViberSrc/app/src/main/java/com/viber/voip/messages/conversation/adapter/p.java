package com.viber.voip.messages.conversation.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;

public class p extends r
{
  private ImageView a;
  private TextView b;

  p(View paramView)
  {
    super(paramView);
    this.a = ((ImageView)paramView.findViewById(R.id.icon));
    this.b = ((TextView)paramView.findViewById(R.id.addParticipantsItemText));
  }

  public void a(s params)
  {
    super.a(params);
    o localo = (o)params;
    this.a.setImageResource(localo.a());
    this.b.setText(localo.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.p
 * JD-Core Version:    0.6.2
 */