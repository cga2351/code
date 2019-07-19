package com.viber.voip.ui;

import com.viber.svg.jni.SvgViewBackend;
import com.viber.voip.app.b;
import com.viber.voip.backgrounds.m;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.d.l;
import com.viber.voip.messages.ui.view.AnimatedSoundIconView;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.ui.StickerSvgContainer;
import com.viber.voip.stickers.ui.f;
import com.viber.voip.stickers.v.c;
import com.viber.voip.stickers.w;

public class ae
  implements v.c<l>
{
  private final StickerSvgContainer a;
  private final AnimatedSoundIconView b;
  private final f c;
  private final b d;
  private boolean e;
  private boolean f;
  private a g;
  private Sticker h;

  public ae(StickerSvgContainer paramStickerSvgContainer, AnimatedSoundIconView paramAnimatedSoundIconView, f paramf, b paramb)
  {
    this.a = paramStickerSvgContainer;
    this.b = paramAnimatedSoundIconView;
    this.c = paramf;
    this.d = paramb;
  }

  public l a()
  {
    return this.g.d();
  }

  public void a(a parama, i parami)
  {
    this.g = parama;
    this.e = m.c(parami.l());
    this.f = parami.o();
    this.h = parama.c().bn();
  }

  public SvgViewBackend getBackend()
  {
    return this.a.getBackend();
  }

  public String getSoundPath()
  {
    return this.h.getOrigSoundPath();
  }

  public boolean hasSound()
  {
    return this.h.hasSound();
  }

  public boolean isAnimatedSticker()
  {
    return this.h.isAnimated();
  }

  public void loadImage(boolean paramBoolean)
  {
    f localf = this.c;
    boolean bool1;
    if (!this.f)
    {
      bool1 = true;
      if (this.d.a())
        break label48;
    }
    label48: for (boolean bool2 = true; ; bool2 = false)
    {
      localf.a(false, false, bool1, bool2, w.b, paramBoolean, null);
      return;
      bool1 = false;
      break;
    }
  }

  public boolean pauseAnimation()
  {
    this.b.a(this.e);
    return this.a.f();
  }

  public boolean resumeAnimation()
  {
    return this.a.g();
  }

  public void startAnimation()
  {
    this.a.e();
  }

  public void stopAnimation()
  {
    this.a.h();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ae
 * JD-Core Version:    0.6.2
 */