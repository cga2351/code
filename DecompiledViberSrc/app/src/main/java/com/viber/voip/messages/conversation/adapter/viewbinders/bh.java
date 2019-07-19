package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;

public class bh extends e<a, i>
{
  private final TextView a;

  public bh(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    TextView localTextView = this.a;
    if (localaa.aC());
    for (String str = ""; ; str = String.valueOf(localaa.bz().getLifeSpan()))
    {
      localTextView.setText(str);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bh
 * JD-Core Version:    0.6.2
 */