package com.viber.voip.messages.adapters.a.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.ui.g.e;

public class d extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
  implements View.OnClickListener
{
  private final View a;
  private final com.viber.voip.messages.adapters.c.a b;
  private OngoingConferenceCallModel c;

  public d(View paramView, com.viber.voip.messages.adapters.c.a parama)
  {
    this.a = paramView;
    this.b = parama;
    this.a.setOnClickListener(this);
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    this.c = parama.h();
  }

  public void onClick(View paramView)
  {
    if ((R.id.joinParticipant == paramView.getId()) && (this.c != null) && (this.b != null))
      this.b.a(this.c.callToken, this.c.conferenceInfo, this.c.conversationId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.d
 * JD-Core Version:    0.6.2
 */