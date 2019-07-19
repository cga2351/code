package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.h;
import com.viber.voip.ui.g.e;

public class f extends e<a, i>
  implements View.OnClickListener
{
  private final h a;
  private View b;

  public f(View paramView, h paramh, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.b = paramView;
    this.a = paramh;
    this.b.setTag(this);
    this.b.setOnClickListener(this);
    this.b.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }

  public void a(a parama, i parami)
  {
    boolean bool1 = true;
    super.a(parama, parami);
    aa localaa = parama.c();
    View localView1 = this.b;
    boolean bool2;
    label52: View localView3;
    if (!parami.n())
    {
      bool2 = bool1;
      localView1.setClickable(bool2);
      View localView2 = this.b;
      if (parami.n())
        break label92;
      localView2.setLongClickable(bool1);
      localView3 = this.b;
      if (!localaa.aw())
        break label97;
    }
    label92: label97: for (int i = parami.c(); ; i = parami.b())
    {
      localView3.setBackgroundResource(i);
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label52;
    }
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if (locala != null)
      this.a.b(locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.f
 * JD-Core Version:    0.6.2
 */