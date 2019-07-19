package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.a.c.a.i.a;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class m extends e<a, i>
{
  private final TextView a;

  public m(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  private boolean a(TextView paramTextView)
  {
    Object localObject = paramTextView.getTag(R.id.sticky_header);
    return (localObject != null) && (((Boolean)localObject).booleanValue());
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    if (parama.g())
    {
      i.a locala = parami.I();
      TextView localTextView1 = this.a;
      boolean bool = a(this.a);
      int i = 0;
      if (bool)
        i = 4;
      dj.c(localTextView1, i);
      TextView localTextView2 = this.a;
      if (locala.f);
      for (int j = parami.G(); ; j = locala.a)
      {
        localTextView2.setTextColor(j);
        this.a.setShadowLayer(locala.b, locala.c, locala.d, locala.e);
        this.a.setText(parama.c().G());
        return;
      }
    }
    dj.b(this.a, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.m
 * JD-Core Version:    0.6.2
 */