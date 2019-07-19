package com.viber.voip.messages.ui.d.b;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.d.d;
import com.viber.voip.util.at;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;
import com.viber.voip.widget.ag.h.a;
import java.io.File;

public abstract class a<VIEW extends b>
  implements h.a
{
  protected static final Logger a = ViberEnv.getLogger();
  protected Context b;
  protected VIEW c;
  protected int d;
  protected final i e;
  protected final com.viber.voip.analytics.g f;
  protected final e g;
  private f h;
  private String i;
  private File j;
  private d k;

  public a(Context paramContext, i parami, com.viber.voip.analytics.g paramg)
  {
    this.b = paramContext;
    this.e = parami;
    this.f = paramg;
    this.g = e.a(this.b);
    this.h = f.a();
  }

  protected abstract void a();

  public void a(int paramInt)
  {
    this.d = paramInt;
    com.viber.voip.stickers.entity.a locala = this.e.g(paramInt);
    this.c.setName(locala.f());
    b localb = this.c;
    if (locala.q() > 0L);
    for (String str = at.a(locala.q()); ; str = "")
    {
      localb.setWeight(str);
      a(locala);
      this.j = new File(com.viber.voip.stickers.c.g.j(paramInt));
      this.c.a(locala.m(), locala.n());
      return;
    }
  }

  public void a(VIEW paramVIEW)
  {
    this.c = paramVIEW;
    this.c.setPresenter(this);
  }

  protected void a(com.viber.voip.stickers.entity.a parama)
  {
    this.i = com.viber.voip.stickers.c.g.b(parama.e(), parama.m());
    if (parama.m())
    {
      this.k = new d(this.i, true);
      this.k.a(new ag.h.a()
      {
        public void a()
        {
          if (a.a(a.this) != null)
            a.a(a.this).a();
        }

        public void b()
        {
        }
      });
      this.c.setThumbnail(this.k);
      return;
    }
    this.k = null;
    if (!TextUtils.isEmpty(this.i))
    {
      this.g.a(Uri.parse(this.i), this.h, this);
      return;
    }
    this.c.setThumbnail(null);
  }

  void a(boolean paramBoolean)
  {
    if ((this.j != null) && (this.j.exists()))
      ViberApplication.getInstance().getRingtonePlayer().playStickerPromo(Uri.fromFile(this.j), paramBoolean);
  }

  public void b(int paramInt)
  {
  }

  public void c(int paramInt)
  {
  }

  public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramUri.toString().equals(this.i))
      this.c.setThumbnail(new BitmapDrawable(ViberApplication.getApplication().getResources(), paramBitmap));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.b.a
 * JD-Core Version:    0.6.2
 */