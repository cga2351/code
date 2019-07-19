package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.content.res.ColorStateList;
import android.support.v4.widget.ImageViewCompat;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.d.u;
import com.viber.voip.messages.d.l;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.ui.StickerSvgContainer;
import com.viber.voip.stickers.ui.StickerSvgContainer.a;
import com.viber.voip.stickers.ui.f;
import com.viber.voip.stickers.w;
import com.viber.voip.ui.ae;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ClickGroup;
import com.viber.voip.widget.ProgressBar;

public class bc extends e<a, com.viber.voip.messages.conversation.adapter.a.c.a.i>
{
  private final ImageView a;
  private final StickerSvgContainer b;
  private final ImageView c;
  private final ProgressBar d;
  private final f e;
  private final ae f;
  private final u g;
  private final com.viber.voip.app.b h;
  private final com.viber.voip.stickers.i i;
  private final com.viber.voip.stickers.b j;
  private l k;
  private final StickerSvgContainer.a l = new StickerSvgContainer.a()
  {
    public void onPlayAnimation()
    {
      l locall = bc.a(bc.this);
      if (locall != null)
        bc.b(bc.this).g(locall);
    }

    public void onStartAnimation()
    {
      l locall = bc.a(bc.this);
      if (locall != null)
        bc.b(bc.this).e(locall);
    }

    public void onStopAnimation()
    {
      l locall = bc.a(bc.this);
      if (locall != null)
      {
        bc.b(bc.this).i(locall);
        bc.a(bc.this, bc.c(bc.this));
        bc.d(bc.this);
      }
    }
  };

  public bc(ImageView paramImageView1, StickerSvgContainer paramStickerSvgContainer, ImageView paramImageView2, ProgressBar paramProgressBar, ClickGroup paramClickGroup, com.viber.voip.stickers.b paramb, f paramf, ae paramae, com.viber.voip.stickers.i parami, u paramu, com.viber.voip.app.b paramb1, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.a = paramImageView1;
    this.b = paramStickerSvgContainer;
    this.c = paramImageView2;
    this.d = paramProgressBar;
    this.j = paramb;
    this.f = paramae;
    this.e = paramf;
    this.i = parami;
    this.g = paramu;
    this.h = paramb1;
    paramClickGroup.setOnClickListener(new bd(this));
    this.b.setAnimationCallback(this.l);
    this.b.setShowCallback(new be(this));
    this.a.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
    this.b.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
    this.c.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }

  private void a(aa paramaa)
  {
    if (paramaa == null)
      return;
    if ((paramaa.f() == -1) && ((0x10 & paramaa.E()) == 0));
    for (boolean bool = true; ; bool = false)
    {
      this.e.a(bool);
      return;
    }
  }

  private void a(Sticker paramSticker)
  {
    if (paramSticker.isOwned())
    {
      dj.c(this.c, 8);
      this.e.b(true);
      return;
    }
    dj.a(this.a, 255);
    dj.a(this.c, 255);
  }

  private void a(Sticker paramSticker, int paramInt, boolean paramBoolean)
  {
    if (paramSticker.isOwned())
    {
      dj.c(this.c, 0);
      if (this.e.a())
        this.e.a(paramSticker);
      this.e.a(true, paramBoolean, w.b, new bf(this));
      return;
    }
    dj.a(this.a, paramInt);
    dj.a(this.c, paramInt);
  }

  private void a(boolean paramBoolean1, Sticker paramSticker, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      a(paramSticker, paramInt, paramBoolean2);
      return;
    }
    a(paramSticker);
  }

  private boolean b()
  {
    a locala = (a)d();
    return (locala != null) && (!locala.d().equals(this.k));
  }

  private void c()
  {
    f localf = this.e;
    if (!this.h.a());
    for (boolean bool = true; ; bool = false)
    {
      localf.a(false, false, false, bool, w.b, null);
      dj.c(this.a, 0);
      dj.c(this.b, 4);
      return;
    }
  }

  private l f()
  {
    a locala = (a)d();
    if (locala != null)
      return locala.d();
    return null;
  }

  private aa g()
  {
    a locala = (a)d();
    if (locala != null)
      return locala.c();
    return null;
  }

  private void h()
  {
    aa localaa = g();
    if (localaa != null)
      this.g.k(localaa);
  }

  public void a()
  {
    a locala = (a)d();
    if (locala != null)
    {
      l locall = locala.d();
      this.j.l(locall);
    }
    super.a();
  }

  public void a(a parama, com.viber.voip.messages.conversation.adapter.a.c.a.i parami)
  {
    super.a(parama, parami);
    this.f.a(parama, parami);
    boolean bool1 = parami.o();
    aa localaa = parama.c();
    Sticker localSticker = localaa.bn();
    int m;
    l locall;
    if ((localaa.f() == -1) && ((0x10 & localaa.E()) == 0))
    {
      m = 1;
      locall = parama.d();
      if (localSticker != null)
        break label78;
    }
    label78: a locala1;
    a locala2;
    do
    {
      return;
      m = 0;
      break;
      this.j.a(locall, this.f);
      a(localaa);
      if (m != 0)
        this.j.d(locall);
      a(parami.c(localaa.y()), localSticker, parami.D(), parami.E());
      locala1 = (a)this.a.getTag();
      locala2 = new a(localSticker, bool1);
    }
    while ((!b()) && (locala2.equals(locala1)) && ((localSticker.isReady()) || (!parami.d())));
    if (b())
    {
      if (!this.b.i())
        this.j.b(this.k);
      this.b.c();
      this.b.d();
      this.b.b();
      this.b.setSticker(null);
      this.a.setImageDrawable(null);
    }
    this.e.b();
    this.e.a(localSticker);
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    localLayoutParams.width = localSticker.getConversationWidth();
    localLayoutParams.height = localSticker.getConversationHeight();
    if ((localSticker.isReady()) && (localSticker.isInDatabase()))
    {
      if ((localSticker.isAnimated()) && (bool1) && (m == 0))
      {
        this.j.k(locall);
        dj.c(this.a, 0);
        dj.c(this.b, 4);
        dj.c(this.c, 8);
        dj.c(this.d, 8);
        this.b.setSticker(localSticker);
        this.e.b(true);
        ImageViewCompat.setImageTintList(this.c, null);
        this.a.setTag(locala2);
        if ((b()) && (locall.equals(this.j.g())) && (this.j.f() != null))
        {
          this.b.setLoadedSticker(localSticker);
          this.b.setBackend(this.j.f());
          this.b.a(false, false);
          dj.c(this.a, 8);
          dj.c(this.b, 0);
        }
        this.k = locall;
        return;
      }
      f localf2 = this.e;
      boolean bool5;
      if (!bool1)
      {
        bool5 = true;
        label511: if (this.h.a())
          break label549;
      }
      label549: for (boolean bool6 = true; ; bool6 = false)
      {
        localf2.a(false, false, bool5, bool6, w.b, null);
        break;
        bool5 = false;
        break label511;
      }
    }
    this.e.b(false);
    f localf1 = this.e;
    boolean bool2;
    label576: boolean bool3;
    label589: ImageView localImageView;
    ColorStateList localColorStateList;
    if (!bool1)
    {
      bool2 = true;
      if (this.h.a())
        break label683;
      bool3 = true;
      localf1.a(false, true, bool2, bool3, w.b, null);
      dj.c(this.a, 8);
      dj.c(this.c, 0);
      dj.c(this.d, 0);
      localImageView = this.c;
      boolean bool4 = localSticker.isOwned();
      localColorStateList = null;
      if (!bool4)
        break label689;
    }
    while (true)
    {
      ImageViewCompat.setImageTintList(localImageView, localColorStateList);
      if (!parami.d())
        break;
      this.i.a(localSticker);
      break;
      bool2 = false;
      break label576;
      label683: bool3 = false;
      break label589;
      label689: localColorStateList = parami.Y();
    }
  }

  private static class a
  {
    final boolean a;
    final int b;
    final boolean c;
    final boolean d;
    final boolean e;
    final boolean f;

    a(Sticker paramSticker, boolean paramBoolean)
    {
      this.a = paramBoolean;
      this.b = paramSticker.id;
      this.c = paramSticker.isReady();
      this.d = paramSticker.isSvg();
      this.e = paramSticker.isInDatabase();
      this.f = paramSticker.hasSound();
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if (!(paramObject instanceof a))
          return false;
        locala = (a)paramObject;
      }
      while ((this.b == locala.b) && (this.c == locala.c) && (this.d == locala.d) && (this.f == locala.f) && (this.e == locala.e) && (this.a == locala.a));
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bc
 * JD-Core Version:    0.6.2
 */