package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.e.a;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class e extends g<com.viber.voip.messages.conversation.chatinfo.d.c>
{
  private final TextView a;
  private final TextView b;
  private final ImageView c;

  public e(View paramView, com.viber.voip.messages.conversation.chatinfo.presentation.b.c paramc)
  {
    super(paramView);
    this.itemView.setOnClickListener(new f(paramc));
    this.a = ((TextView)this.itemView.findViewById(R.id.title));
    this.b = ((TextView)this.itemView.findViewById(R.id.subtitle));
    this.c = ((ImageView)this.itemView.findViewById(R.id.image));
  }

  public void a(com.viber.voip.messages.conversation.chatinfo.d.c paramc, com.viber.voip.messages.conversation.chatinfo.e.e parame)
  {
    a locala = parame.b();
    this.a.setText(paramc.a());
    this.b.setText(paramc.b());
    String str = paramc.c();
    if (da.a(str))
    {
      dj.b(this.c, false);
      return;
    }
    dj.b(this.c, true);
    locala.a().a(Uri.parse(str), this.c, locala.d());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.e
 * JD-Core Version:    0.6.2
 */