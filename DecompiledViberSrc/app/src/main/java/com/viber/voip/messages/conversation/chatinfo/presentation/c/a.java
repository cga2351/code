package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.links.f;

public class a extends g<com.viber.voip.messages.conversation.chatinfo.d.a>
{
  private final ImageView a = (ImageView)this.itemView.findViewById(R.id.aboutEdit);
  private final TextView b = (TextView)this.itemView.findViewById(R.id.aboutText);

  public a(View paramView, com.viber.voip.messages.conversation.chatinfo.presentation.b.a parama)
  {
    super(paramView);
    this.a.setOnClickListener(new b(parama));
  }

  public void a(com.viber.voip.messages.conversation.chatinfo.d.a parama, e parame)
  {
    dj.b(this.a, parama.c());
    this.b.setText(parama.a());
    parame.b().i().a(this.b);
    if (da.a(this.b.getText()))
    {
      this.b.setHint(parama.b());
      return;
    }
    this.b.setHint("");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.a
 * JD-Core Version:    0.6.2
 */