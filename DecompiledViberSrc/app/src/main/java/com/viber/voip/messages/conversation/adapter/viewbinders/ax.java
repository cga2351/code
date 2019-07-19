package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.viber.voip.flatbuffers.model.msginfo.CommunityScreenshot;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.ac;
import com.viber.voip.ui.g.e;

public class ax extends e<a, i>
  implements View.OnClickListener
{
  private final TextView a;
  private final Button b;
  private final TextView c;
  private final ac d;

  public ax(TextView paramTextView1, TextView paramTextView2, Button paramButton, ac paramac)
  {
    this.a = paramTextView1;
    this.b = paramButton;
    this.b.setOnClickListener(this);
    this.d = paramac;
    this.c = paramTextView2;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    CommunityScreenshot localCommunityScreenshot = parama.c().bx().getCommunityScreenshot();
    this.c.setText(parami.b(localCommunityScreenshot.getCommunnityName()));
    this.a.setText(localCommunityScreenshot.getCommunnityName());
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    i locali = (i)e();
    if ((locala != null) && (locali != null))
      this.d.m(locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ax
 * JD-Core Version:    0.6.2
 */