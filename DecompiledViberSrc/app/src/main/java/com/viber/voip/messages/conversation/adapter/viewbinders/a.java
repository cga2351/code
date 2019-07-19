package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.text.TextUtils;
import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;

public class a extends e<com.viber.voip.messages.conversation.adapter.a.a, i>
{
  private final TextView a;

  public a(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    super.a(parama, parami);
    String str = parama.c().D();
    if (TextUtils.isEmpty(str))
      str = parami.m();
    this.a.setText(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.a
 * JD-Core Version:    0.6.2
 */