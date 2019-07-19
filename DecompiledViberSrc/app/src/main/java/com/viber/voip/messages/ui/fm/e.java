package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.viber.common.ui.ShapeImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.controller.y.a;
import com.viber.voip.messages.controller.y.d;
import com.viber.voip.messages.controller.z;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.orm.entity.json.GifMessage;
import com.viber.voip.messages.ui.media.simple.SimpleMediaViewItem;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.at;
import com.viber.voip.util.bu;
import com.viber.voip.util.dx;
import com.viber.voip.util.dx.b;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.upload.m;
import com.viber.voip.util.upload.o;
import com.viber.voip.util.upload.s;
import com.viber.voip.widget.FileIconView;
import com.viber.voip.widget.FileIconView.a;
import com.viber.voip.widget.GifShapeImageView;
import java.io.File;

public class e extends h<FrameLayout, GifMessage>
  implements y.d
{
  private static final Logger m = ViberEnv.getLogger();
  private final b A = new b(null);
  private volatile boolean B;
  private com.viber.voip.util.e.b.d C;
  private k.a D;
  private y.a E = new y.a()
  {
    public void a(ImageView paramAnonymousImageView, pl.droidsonroids.gif.b paramAnonymousb)
    {
      z.a(this, paramAnonymousImageView, paramAnonymousb);
    }

    public void a(pl.droidsonroids.gif.b paramAnonymousb, String paramAnonymousString, Uri paramAnonymousUri)
    {
      e.f(e.this).a(paramAnonymousb, paramAnonymousString);
    }

    public void b(pl.droidsonroids.gif.b paramAnonymousb, String paramAnonymousString, Uri paramAnonymousUri)
    {
      z.a(this, paramAnonymousb, paramAnonymousString, paramAnonymousUri);
    }
  };
  private final GifMessage n;
  private GifShapeImageView o;
  private FileIconView p;
  private View q;
  private final Handler r;
  private final String s;
  private final Uri t;
  private final String u;
  private Uri v;
  private final ai w;
  private final y x;
  private volatile double y;
  private final a z = new a(null);

  public e(GifMessage paramGifMessage, Context paramContext, a parama, i parami, com.viber.voip.messages.conversation.adapter.e.b paramb)
  {
    super(paramGifMessage, paramContext, parama, parami, paramb);
    this.n = paramGifMessage;
    this.w = ViberApplication.getInstance().getMessagesManager().c();
    this.r = av.a(av.e.a);
    this.t = Uri.parse(paramGifMessage.getGifUrl());
    if (dx.l(this.t));
    for (this.u = dx.m(this.t).a; ; this.u = paramGifMessage.getGifUrl())
    {
      this.s = bu.a(this.u);
      this.x = y.a();
      this.D = new f(this);
      return;
    }
  }

  private void a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()));
    while (this.B)
      return;
    this.x.a(new com.viber.voip.messages.d.l(this.c), Uri.fromFile(paramFile), this.o, this.E);
  }

  private void b(ImageView paramImageView)
  {
    boolean bool1 = true;
    File localFile = o.a(this.u, this.a);
    int i = this.c.z();
    int j;
    boolean bool2;
    FileIconView localFileIconView;
    if ((i == 3) && (at.a(localFile)))
    {
      j = bool1;
      bool2 = s.a(this.s);
      localFileIconView = this.p;
      if (j != 0)
        break label123;
    }
    label123: for (boolean bool3 = bool1; ; bool3 = false)
    {
      localFileIconView.a(bool3, this.c.a(), com.viber.voip.messages.d.j);
      if (j == 0)
        break label129;
      this.q.setVisibility(8);
      this.r.removeCallbacks(this.A);
      com.viber.voip.util.upload.l.b(this.z);
      a(localFile);
      return;
      j = 0;
      break;
    }
    label129: if (bool2)
    {
      this.q.setVisibility(0);
      com.viber.voip.util.upload.l.a(this.z);
      this.p.a(this.y);
      this.i.a(this.t, this.o, this.j);
      return;
    }
    this.i.a(this.t, this.o, this.j);
    this.q.setVisibility(0);
    int k;
    boolean bool4;
    if (this.c.f() == -1)
    {
      k = bool1;
      this.c.bx();
      bool4 = bk.a(this.a, this.c.bx().getContentLength(), this.c.aT(), this.c.Z());
      if (i != 11)
        break label294;
    }
    while (true)
    {
      if ((bool1) || (k != 0) || (!bool4))
        break label299;
      n();
      return;
      k = 0;
      break;
      label294: bool1 = false;
    }
    label299: if (k != 0)
    {
      this.p.getDownloadIcon().c();
      return;
    }
    this.p.getDownloadIcon().a();
  }

  private Uri l()
  {
    Integer localInteger;
    if (this.v == null)
    {
      this.v = dx.a(this.c);
      localInteger = com.viber.voip.util.upload.l.e(this.v);
      if (localInteger == null)
        break label50;
    }
    label50: for (double d = localInteger.intValue() / 100.0D; ; d = 0.0D)
    {
      this.y = d;
      return this.v;
    }
  }

  private void m()
  {
    this.C.a(this.n.getThumbnailWidth());
    this.C.b(this.n.getThumbnailHeight());
  }

  private void n()
  {
    this.w.a(this.c.a(), this.s);
    com.viber.voip.util.upload.l.a(this.z);
    this.p.a(this.y);
  }

  public void O_()
  {
    this.x.a(y.a(this.e), this.o.getDrawable());
  }

  public void a()
  {
    this.B = true;
    this.x.b(this);
    this.x.a(this.o);
    com.viber.voip.util.upload.l.b(this.z);
  }

  public void a(FrameLayout paramFrameLayout)
  {
    super.a(paramFrameLayout);
    this.x.a(this);
    com.viber.voip.util.upload.l.b(this.z);
    this.q = paramFrameLayout.findViewById(R.id.gif_controls);
    this.p = ((FileIconView)paramFrameLayout.findViewById(R.id.play_btn));
    this.o = ((GifShapeImageView)paramFrameLayout.findViewById(R.id.preview));
    m();
    this.l.a(this.o, this.D);
    Drawable localDrawable = this.o.getDrawable();
    if ((this.c.o() != null) && ((localDrawable instanceof pl.droidsonroids.gif.b)))
    {
      pl.droidsonroids.gif.b localb = (pl.droidsonroids.gif.b)localDrawable;
      String str = y.a(new com.viber.voip.messages.d.l(this.c));
      com.viber.voip.messages.controller.aa localaa = this.x.a(str);
      if (localaa != null)
      {
        localaa.a = localb.isPlaying();
        this.x.b(str, localaa);
      }
    }
  }

  boolean b(View paramView)
  {
    if (super.b(paramView))
      return true;
    if ((this.o.getDrawable() instanceof pl.droidsonroids.gif.b))
    {
      File localFile = o.a(this.u, this.a);
      if (localFile != null)
      {
        SimpleMediaViewItem localSimpleMediaViewItem = new SimpleMediaViewItem(Uri.fromFile(localFile).toString(), 1005, this.c.a(), this.c.e(), this.c.g(), this.c.ag(), this.n.getGifUrl());
        ViberActionRunner.bm.a(paramView.getContext(), this.c.b(), new SimpleMediaViewItem[] { localSimpleMediaViewItem });
      }
    }
    while (true)
    {
      return false;
      if (s.a(l()))
        s.a(this.s, false);
      else
        n();
    }
  }

  protected f.a d()
  {
    this.C = new com.viber.voip.util.e.b.d(this.a.getResources().getDimensionPixelSize(R.dimen.gif_image_blur_radius), 0, 0, true);
    return super.d().a(this.C);
  }

  public void g()
  {
    this.x.b(y.a(this.e), this.o.getDrawable());
  }

  public FrameLayout j()
  {
    Resources localResources = this.a.getResources();
    FrameLayout localFrameLayout = new FrameLayout(this.a);
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setId(R.id.gif_controls);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    FileIconView localFileIconView = new FileIconView(this.a);
    localFileIconView.setId(R.id.play_btn);
    localFileIconView.setClickable(false);
    ShapeImageView localShapeImageView = this.l.a();
    localShapeImageView.setId(R.id.preview);
    int i = localResources.getDimensionPixelSize(R.dimen.gif_download_control_size);
    localLinearLayout.addView(localFileIconView, new LinearLayout.LayoutParams(i, i));
    new LinearLayout.LayoutParams(-2, -2).topMargin = localResources.getDimensionPixelSize(R.dimen.gif_image_size_padding);
    localFrameLayout.addView(localShapeImageView, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.addView(localLinearLayout, new FrameLayout.LayoutParams(-2, -2, 17));
    return localFrameLayout;
  }

  public GifMessage k()
  {
    return this.n;
  }

  private class a
    implements m
  {
    private a()
    {
    }

    public void a(Uri paramUri, int paramInt)
    {
      if (paramUri.equals(e.c(e.this)))
      {
        e.a(e.this, paramInt / 100.0D);
        e.e(e.this).removeCallbacks(e.d(e.this));
        e.e(e.this).post(e.d(e.this));
      }
    }
  }

  private class b
    implements Runnable
  {
    private b()
    {
    }

    public void run()
    {
      e.b(e.this).a(e.a(e.this));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.e
 * JD-Core Version:    0.6.2
 */