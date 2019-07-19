package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.widget.TextView;
import com.viber.common.ui.b.b;
import com.viber.voip.R.dimen;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.j.a;
import com.viber.voip.util.e.f;

public class ak extends com.viber.voip.ui.g.e<com.viber.voip.messages.conversation.adapter.a.a, i>
{
  private final TextView a;
  private final com.viber.voip.util.e.c.a b;

  public ak(TextView paramTextView)
  {
    this.a = paramTextView;
    int i = paramTextView.getResources().getDimensionPixelSize(R.dimen.conversation_notification_photo_size);
    Rect localRect = new Rect(0, 0, i, i);
    this.b = new com.viber.voip.util.e.c.a(b.b.e, localRect, paramTextView);
  }

  private void a(aa paramaa, i parami, j.a parama)
  {
    if (parama.b)
    {
      Uri localUri = parami.a(parama, paramaa);
      com.viber.voip.util.e.c.a locala = this.b;
      if (parama.c);
      for (int i = 2; ; i = 0)
      {
        locala.c(i);
        f localf = parami.x();
        parami.T().a(localUri, this.b, localf);
        return;
      }
    }
    this.a.setCompoundDrawables(null, null, null, null);
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    a(localaa, parami, parami.b(localaa));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ak
 * JD-Core Version:    0.6.2
 */