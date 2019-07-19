package com.viber.voip.messages.conversation.adapter.viewbinders;

import com.viber.voip.backgrounds.m;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.d.l;
import com.viber.voip.messages.ui.view.AnimatedSoundIconView;
import com.viber.voip.stickers.b;
import com.viber.voip.stickers.b.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class bb extends e<a, i>
{
  private final AnimatedSoundIconView a;
  private final b b;
  private final b.b c = new b.b()
  {
    public void a(l paramAnonymousl)
    {
      a locala = (a)bb.this.d();
      if ((locala != null) && (locala.d().equals(paramAnonymousl)))
        bb.a(bb.this);
    }

    public void b(l paramAnonymousl)
    {
      a locala = (a)bb.this.d();
      if ((locala != null) && (locala.d().equals(paramAnonymousl)))
        bb.a(bb.this, true);
    }
  };

  public bb(AnimatedSoundIconView paramAnimatedSoundIconView, b paramb)
  {
    this.a = paramAnimatedSoundIconView;
    this.b = paramb;
  }

  private void a(boolean paramBoolean)
  {
    dj.b(this.a, paramBoolean);
    i locali = (i)e();
    if ((paramBoolean) && (locali != null))
    {
      boolean bool = m.c(locali.l());
      this.a.a(bool);
    }
  }

  private void b()
  {
    i locali = (i)e();
    if (locali == null)
      return;
    if (m.c(locali.l()))
    {
      this.a.b();
      return;
    }
    this.a.a();
  }

  public void a()
  {
    a locala = (a)d();
    if (locala != null)
      this.b.m(locala.d());
    super.a();
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    Sticker localSticker = parama.c().bn();
    if (localSticker == null);
    do
    {
      return;
      if ((!localSticker.isReady()) || (!localSticker.isInDatabase()))
        break;
      a(localSticker.hasSound());
    }
    while (!localSticker.hasSound());
    this.b.a(parama.d(), this.c);
    return;
    a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bb
 * JD-Core Version:    0.6.2
 */