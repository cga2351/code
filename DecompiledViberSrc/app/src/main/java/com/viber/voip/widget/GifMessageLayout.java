package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.controller.y.a;
import com.viber.voip.messages.controller.y.d;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.t;
import com.viber.voip.util.e.b.d;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.upload.m;

@Deprecated
public class GifMessageLayout extends RelativeLayout
  implements View.OnClickListener, y.d
{
  private static final Logger e = ViberEnv.getLogger();
  private int A;
  protected com.viber.voip.util.e.e a;
  protected f b;
  protected f c;
  y.a d;
  private aa f;
  private com.viber.voip.messages.conversation.adapter.d.j g;
  private t h;
  private com.viber.voip.messages.conversation.adapter.d.l i;
  private GifShapeImageView j;
  private FileIconView k;
  private TextView l;
  private View m;
  private ImageView n;
  private ImageView o;
  private Handler p;
  private y q;
  private Uri r;
  private volatile int s;
  private a t = new a(null);
  private b u = new b(null);
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;

  public GifMessageLayout(Context paramContext)
  {
    super(paramContext);
    this.d = new k(this);
    a(paramContext);
  }

  public GifMessageLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = new i(this);
    a(paramContext);
  }

  public GifMessageLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = new j(this);
    a(paramContext);
  }

  private f a(aa paramaa, boolean paramBoolean)
  {
    MediaInfo localMediaInfo = paramaa.bz().getMediaInfo();
    if (paramBoolean)
    {
      com.viber.voip.util.e.b.e locale = new com.viber.voip.util.e.b.e(localMediaInfo.getWidth(), localMediaInfo.getHeight());
      return this.c.f().a(locale).c();
    }
    d locald = new d(this.A, localMediaInfo.getWidth(), localMediaInfo.getHeight(), true);
    return this.b.f().a(locald).c();
  }

  private void a(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    if ((paramInt1 > this.w) || (paramInt2 > this.y))
    {
      f1 = Math.max(paramInt1 / this.w, paramInt2 / this.y);
      paramInt1 = Math.round(paramInt1 / f1);
    }
    for (paramInt2 = Math.round(paramInt2 / f1); ; paramInt2 = (int)(paramInt2 / f1))
    {
      do
      {
        ViewGroup.LayoutParams localLayoutParams = this.j.getLayoutParams();
        if ((localLayoutParams != null) && ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height)))
        {
          localLayoutParams.width = paramInt1;
          localLayoutParams.height = paramInt2;
        }
        this.j.setCornerRadius(f1 * this.z);
        return;
      }
      while ((paramInt1 >= this.v) && (paramInt2 >= this.x));
      f1 = Math.max(Math.min(paramInt1 / this.v, paramInt2 / this.x), Math.max(paramInt1 / this.w, paramInt2 / this.y));
      paramInt1 = (int)(paramInt1 / f1);
    }
  }

  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(R.layout.msg_gif, this);
    this.p = av.a(av.e.a);
    this.A = paramContext.getResources().getDimensionPixelSize(R.dimen.gif_image_blur_radius);
    this.b = new f.a().b(false).c();
    this.c = new f.a().b(false).c();
    this.a = com.viber.voip.util.e.e.a(paramContext);
    setDuplicateParentStateEnabled(true);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.j = ((GifShapeImageView)findViewById(R.id.preview));
    this.n = ((ImageView)findViewById(R.id.forward_via_viber));
    this.n.setOnClickListener(this);
    this.o = ((ImageView)findViewById(R.id.share));
    this.o.setOnClickListener(this);
    this.k = ((FileIconView)findViewById(R.id.file_type_icon));
    this.l = ((TextView)findViewById(R.id.file_size));
    this.m = findViewById(R.id.gif_controls);
    this.q = y.a();
    this.q.a(this);
    Resources localResources = paramContext.getResources();
    this.v = localResources.getDimensionPixelSize(R.dimen.gif_min_width);
    this.w = localResources.getDimensionPixelSize(R.dimen.gif_max_width);
    this.x = localResources.getDimensionPixelSize(R.dimen.gif_min_height);
    this.y = localResources.getDimensionPixelSize(R.dimen.gif_max_height);
    this.z = localResources.getDimensionPixelSize(R.dimen.media_image_corner_radius);
  }

  public void O_()
  {
    if (this.f != null)
      this.q.a(y.a(new com.viber.voip.messages.d.l(this.f)), this.j.getDrawable());
  }

  public void a(aa paramaa)
  {
    getLayoutParams().width = -1;
    MediaInfo localMediaInfo = paramaa.bz().getMediaInfo();
    a(localMediaInfo.getWidth(), localMediaInfo.getHeight());
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    this.o.setVisibility(8);
    this.a.a(paramaa.bo(), this.j, a(paramaa, true), null, paramaa.a(), paramaa.B(), paramaa.o(), paramaa.q(), paramaa.bx().getThumbnailEP(), paramaa.aT());
  }

  public void g()
  {
    if (this.f != null)
      this.q.b(y.a(new com.viber.voip.messages.d.l(this.f)), this.j.getDrawable());
  }

  public void onClick(View paramView)
  {
    if ((this.g != null) && (paramView == this.n))
      this.g.e(this.f);
    while ((this.h == null) || (paramView != this.o))
      return;
    this.h.j(this.f);
  }

  protected void onDetachedFromWindow()
  {
    this.q.b(this);
    super.onDetachedFromWindow();
  }

  public void setMessageForwardClickListener(com.viber.voip.messages.conversation.adapter.d.j paramj)
  {
    this.g = paramj;
  }

  public void setMessageGifClickListener(com.viber.voip.messages.conversation.adapter.d.l paraml)
  {
    this.i = paraml;
  }

  public void setMessageShareClickListener(t paramt)
  {
    this.h = paramt;
  }

  private class a
    implements m
  {
    private a()
    {
    }

    public void a(Uri paramUri, int paramInt)
    {
      if (paramUri.equals(GifMessageLayout.c(GifMessageLayout.this)))
      {
        GifMessageLayout.a(GifMessageLayout.this, paramInt);
        GifMessageLayout.e(GifMessageLayout.this).removeCallbacks(GifMessageLayout.d(GifMessageLayout.this));
        GifMessageLayout.e(GifMessageLayout.this).post(GifMessageLayout.d(GifMessageLayout.this));
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
      GifMessageLayout.b(GifMessageLayout.this).a(GifMessageLayout.a(GifMessageLayout.this) / 100.0D);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.GifMessageLayout
 * JD-Core Version:    0.6.2
 */