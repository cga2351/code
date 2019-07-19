package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.viber.common.ui.ShapeImageView;
import com.viber.common.ui.b.b;
import com.viber.voip.R.color;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.h;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.messages.orm.entity.json.GifMessage;
import com.viber.voip.messages.orm.entity.json.ImageMessage;
import com.viber.voip.messages.orm.entity.json.MediaMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.messages.orm.entity.json.QuickContactProfileImageMessage;
import com.viber.voip.messages.orm.entity.json.VideoMessage;
import com.viber.voip.util.dj;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;
import com.viber.voip.widget.GifShapeImageView;

public class k<T extends MediaMessage>
{
  protected final T a;
  protected final Context b;
  protected h.a c;
  private b.b d = b.b.b;
  private ImageView.ScaleType e;
  private int f;
  private Drawable g;
  private Drawable h;
  private a i;
  private final float j;
  private final e k;
  private final f l;
  private a m;
  private final ai n;
  private i o;

  public k(Context paramContext, T paramT, a parama, i parami, e parame, f paramf, float paramFloat)
  {
    this.o = parami;
    this.n = parami.aw();
    this.b = paramContext;
    this.a = paramT;
    this.i = parama;
    this.k = parame;
    this.l = paramf;
    this.j = paramFloat;
    h localh = parami.ag();
    this.f = localh.a(parama, paramT);
    this.g = localh.a(localh.a(this.j), this.f, false, paramT.getThumbnailWidth(), paramT.getThumbnailHeight());
    float f1 = this.j;
    int i1 = this.f;
    Context localContext = this.b;
    if (this.a.getType() == MessageType.VIDEO);
    for (int i2 = R.color.solid; ; i2 = R.color.negative)
    {
      this.h = localh.a(f1, i1, ContextCompat.getColor(localContext, i2), paramT.getThumbnailWidth(), paramT.getThumbnailHeight());
      this.e = ImageView.ScaleType.CENTER_CROP;
      return;
    }
  }

  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if ((this.a instanceof QuickContactProfileImageMessage))
      dj.a(paramImageView, null);
    do
    {
      return;
      if (!this.i.c().aL())
        break;
      dj.a(paramImageView, this.h);
    }
    while ((this.a.getType() == MessageType.GIF) || ((this.a.getThumbnailWidth() == paramBitmap.getWidth()) && (this.a.getThumbnailHeight() == paramBitmap.getHeight())));
    this.n.a(this.i.c(), paramBitmap.getWidth(), paramBitmap.getHeight());
    return;
    dj.a(paramImageView, null);
  }

  public ShapeImageView a()
  {
    if (this.a.getType() == MessageType.GIF);
    for (Object localObject = new GifShapeImageView(this.b); ; localObject = new ShapeImageView(this.b))
    {
      b((ImageView)localObject);
      ((ShapeImageView)localObject).setCornerRadius(this.j);
      ((ShapeImageView)localObject).setRoundedCornerMask(this.f);
      ((ShapeImageView)localObject).setForegroundDrawable(this.g);
      return localObject;
    }
  }

  public void a(ImageView paramImageView)
  {
    if (this.m == null)
      this.m = new l(this);
    a(paramImageView, this.m);
  }

  public void a(ImageView paramImageView, a parama)
  {
    boolean bool1 = this.o.W().a(this.i.c());
    if (!bool1);
    for (boolean bool2 = true; ; bool2 = false)
    {
      dj.b(paramImageView, bool2);
      if (!bool1)
      {
        paramImageView.setImageDrawable(null);
        paramImageView.setBackground(this.o.ag().a());
        b(paramImageView);
        parama.a(paramImageView);
      }
      return;
    }
  }

  protected final String b()
  {
    if (this.a.getType() == MessageType.IMAGE)
      return ((ImageMessage)this.a).getImageUrl();
    if (this.a.getType() == MessageType.VIDEO)
      return ((VideoMessage)this.a).getThumbnailUrl();
    if (this.a.getType() == MessageType.GIF)
      return ((GifMessage)this.a).getGifUrl();
    throw new IllegalArgumentException("Unknown media type");
  }

  protected final void b(ImageView paramImageView)
  {
    paramImageView.setScaleType(this.e);
    if ((paramImageView instanceof ShapeImageView))
    {
      ShapeImageView localShapeImageView = (ShapeImageView)paramImageView;
      localShapeImageView.setShape(this.d);
      localShapeImageView.setCornerRadius(this.j);
      localShapeImageView.setRoundedCornerMask(this.f);
      localShapeImageView.setForegroundDrawable(this.g);
    }
  }

  protected void c(ImageView paramImageView)
  {
    String str = b();
    if (TextUtils.isEmpty(str));
    for (Uri localUri = dx.a(this.a.getBucketName(), this.a.getDownloadId(), this.a.getPhotoUrl(), this.a.getImageType()); ; localUri = Uri.parse(str))
    {
      this.c = new m(this, localUri, paramImageView);
      this.k.a(localUri, paramImageView, this.l, this.c);
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a(ImageView paramImageView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.k
 * JD-Core Version:    0.6.2
 */