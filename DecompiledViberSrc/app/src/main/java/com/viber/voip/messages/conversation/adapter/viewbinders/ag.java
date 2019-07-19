package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.ImageView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.ah;
import com.viber.voip.messages.d.l;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.ui.a.c;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dg;

public class ag extends e<a, i>
{
  private final ImageView a;
  private l b;
  private int c;
  private c d;

  public ag(ImageView paramImageView)
  {
    this.a = paramImageView;
  }

  private int a(aa paramaa, i parami)
  {
    if (paramaa.f() == 1);
    do
      do
      {
        return 1;
        if (paramaa.f() == 2)
          break label79;
        if (!parami.d())
          break;
      }
      while ((paramaa.bk()) && (System.currentTimeMillis() - paramaa.e() <= 1000L));
    while ((paramaa.b(new int[] { 10 })) && (System.currentTimeMillis() - paramaa.e() <= 3000L));
    return 0;
    label79: if (parami.av().a(paramaa))
      return 3;
    return 2;
  }

  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
    case 1:
      return "sent";
    case 2:
      return "delivered";
    case 3:
    }
    return "seen";
  }

  public void a()
  {
    super.a();
    if (this.d != null)
      this.d = null;
    this.a.setImageDrawable(null);
  }

  public void a(a parama, i parami)
  {
    boolean bool1 = true;
    super.a(parama, parami);
    l locall = parama.d();
    boolean bool2;
    aa localaa;
    int i;
    boolean bool3;
    label71: label94: c localc1;
    if (!locall.equals(this.b))
    {
      bool2 = bool1;
      this.b = locall;
      localaa = parama.c();
      i = a(localaa, parami);
      if ((bool2) || (i == this.c))
        break label149;
      bool3 = bool1;
      this.c = i;
      if (!parama.n())
        break label155;
      this.d = parami.ah();
      this.a.setImageDrawable(this.d);
      localc1 = this.d;
      if ((i == 0) || (!bool3))
        break label269;
    }
    while (true)
    {
      localc1.a(i, bool1);
      dg.a(this.a, a(i));
      return;
      bool2 = false;
      break;
      label149: bool3 = false;
      break label71;
      label155: if ((parama.o()) && (!parama.r()))
      {
        if (parama.p());
        for (c localc3 = parami.ai(); ; localc3 = parami.aj())
        {
          this.d = localc3;
          break;
        }
      }
      if (localaa.aE())
      {
        FormattedMessage localFormattedMessage = localaa.L();
        if ((localFormattedMessage != null) && (localFormattedMessage.hasLastMedia()));
        for (c localc2 = parami.aj(); ; localc2 = parami.ai())
        {
          this.d = localc2;
          break;
        }
      }
      this.d = parami.ai();
      break label94;
      label269: bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ag
 * JD-Core Version:    0.6.2
 */