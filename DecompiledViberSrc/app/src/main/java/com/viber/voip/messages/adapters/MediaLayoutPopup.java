package com.viber.voip.messages.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.common.ui.ShapeImageView;
import com.viber.common.ui.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.extras.image.c;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.w;
import com.viber.voip.stickers.x;
import com.viber.voip.util.ae;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.util.dy;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.h.a;
import com.viber.voip.util.upload.m;
import com.viber.voip.util.upload.o;
import com.viber.voip.widget.PlayableImageView;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class MediaLayoutPopup extends FrameLayout
  implements View.OnClickListener, m
{
  private static final Logger e = ViberEnv.getLogger();
  public ShapeImageView a;
  public ImageView b;
  public ImageView c;
  public ImageView d;
  private Context f;
  private com.viber.voip.stickers.f g;
  private x h;
  private e i;
  private com.viber.voip.util.e.f j;
  private com.viber.voip.util.e.f k;
  private com.viber.voip.util.e.f l;
  private com.viber.voip.util.e.f m;
  private int n;
  private int o;
  private ViewGroup p;
  private PlayableImageView q;
  private ImageView r;
  private TextView s;
  private aa t;
  private a u;
  private Map<Long, Object> v = new HashMap();

  public MediaLayoutPopup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext;
    b();
  }

  private Uri a(aa paramaa)
  {
    Uri localUri;
    if ((paramaa.ao()) || ((paramaa.ap()) && (paramaa.o() == null)))
      localUri = Uri.fromFile(o.b(paramaa.C(), paramaa.q(), this.f));
    boolean bool;
    do
    {
      return localUri;
      if (paramaa.az())
        return dv.h.a(this.f, paramaa.o(), false);
      bool = paramaa.aA();
      localUri = null;
    }
    while (!bool);
    if (paramaa.ae())
      return Uri.fromFile(dy.b(Uri.parse(paramaa.o())));
    return Uri.parse(paramaa.o());
  }

  private void a(Sticker paramSticker, w paramw)
  {
    com.viber.voip.stickers.f localf = getStickerBitmapLoader();
    if (!paramSticker.isReady());
    for (boolean bool = true; ; bool = false)
    {
      com.viber.voip.b.a.a.a.b localb = localf.a(paramSticker, bool, true, paramw);
      if (localb != null)
      {
        localb.b();
        this.a.setImageBitmap(localb.a());
      }
      return;
    }
  }

  private void b()
  {
    LayoutInflater.from(this.f).inflate(R.layout.popup_media_layout, this);
    setDuplicateParentStateEnabled(true);
    this.p = ((ViewGroup)findViewById(R.id.rl_msg_shared_media_loading));
    this.a = ((ShapeImageView)findViewById(R.id.preview));
    this.b = ((ImageView)findViewById(R.id.sticker_type_icon));
    this.c = ((ImageView)findViewById(R.id.forward_via_viber));
    this.d = ((ImageView)findViewById(R.id.share));
    this.q = ((PlayableImageView)findViewById(R.id.play_btn));
    this.r = ((ImageView)findViewById(R.id.static_play_icon));
    this.s = ((TextView)findViewById(R.id.time));
    this.i = e.a(this.f);
    this.j = new f.a().b(false).c();
    this.k = new f.a().b(false).c();
    this.l = new f.a().b(false).a(Integer.valueOf(R.drawable.bg_media_loading_generic)).b(Integer.valueOf(R.drawable.bg_media_loading_generic)).c();
    Resources localResources = getResources();
    this.m = new f.a().b(false).a(new com.viber.voip.util.e.b.b(localResources.getDimensionPixelSize(R.dimen.wink_image_blur_radius), true)).c();
    this.n = localResources.getDimensionPixelSize(R.dimen.popup_sticker_type_icon_size);
    this.o = localResources.getDimensionPixelSize(R.dimen.popup_sticker_type_icon_left_margin);
  }

  private void c()
  {
  }

  @SuppressLint({"InlinedApi"})
  public void a()
  {
    x.a(this.a, true);
    this.p.getLayoutParams().width = -2;
    this.p.getLayoutParams().height = -2;
    this.a.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    this.b.setVisibility(8);
    this.b.setImageDrawable(null);
    this.q.setVisibility(8);
    this.s.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }

  public void a(int paramInt)
  {
    a();
    final Sticker localSticker = i.a().u(paramInt);
    final boolean bool = localSticker.isReady();
    final ViewGroup localViewGroup = (ViewGroup)getParent();
    dj.a(localViewGroup, new Runnable()
    {
      public void run()
      {
        if (localViewGroup.getHeight() == 0)
          dj.a(localViewGroup, this);
        label385: label407: 
        while (true)
        {
          return;
          boolean bool;
          int i;
          int j;
          label58: String str;
          label166: label216: int k;
          if (localViewGroup.getHeight() > localSticker.getConversationHeight())
          {
            bool = true;
            if (!bool)
              break label317;
            i = localSticker.getConversationWidth();
            j = localSticker.getConversationHeight();
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
            localLayoutParams.addRule(13, -1);
            MediaLayoutPopup.this.a.setLayoutParams(localLayoutParams);
            MediaLayoutPopup.this.a.setScaleType(ImageView.ScaleType.FIT_XY);
            MediaLayoutPopup.this.a.requestLayout();
            MediaLayoutPopup.this.a.setShape(b.b.a);
            if (!localSticker.isSvg())
              break label368;
            x localx = MediaLayoutPopup.this.getStickerSvgController();
            Sticker localSticker = localSticker;
            if (bool)
              break label356;
            str = localSticker.getOrigFramePath();
            com.viber.voip.stickers.f.b localb = new com.viber.voip.stickers.f.b(localx.a(localSticker, i, j, str, true, w.b, bool), i, j);
            x.a(MediaLayoutPopup.this.a, false);
            MediaLayoutPopup.this.a.setImageDrawable(localb);
            if (!localSticker.hasSound())
              break label385;
            k = R.drawable.ic_sticker_sound;
          }
          while (true)
          {
            if (k == 0)
              break label407;
            MediaLayoutPopup.this.b.setVisibility(0);
            MediaLayoutPopup.this.b.setImageDrawable(ContextCompat.getDrawable(MediaLayoutPopup.b(MediaLayoutPopup.this), k));
            ViewGroup.LayoutParams localLayoutParams1 = MediaLayoutPopup.c(MediaLayoutPopup.this).getLayoutParams();
            localLayoutParams1.width = (i + 2 * (MediaLayoutPopup.d(MediaLayoutPopup.this) + MediaLayoutPopup.e(MediaLayoutPopup.this)));
            localLayoutParams1.height = j;
            return;
            bool = false;
            break;
            label317: i = (int)(localViewGroup.getHeight() / localSticker.getConversationHeight() * localSticker.getConversationWidth());
            j = localViewGroup.getHeight();
            break label58;
            label356: str = localSticker.getOrigPath();
            break label166;
            label368: MediaLayoutPopup.a(MediaLayoutPopup.this, localSticker, w.b);
            break label216;
            if (localSticker.isAnimated())
              k = R.drawable.ic_sticker_anim;
            else
              k = 0;
          }
        }
      }
    });
  }

  public void a(Uri paramUri, final int paramInt)
  {
    if (paramUri.equals(a(this.t)))
      av.e.a.a().post(new Runnable()
      {
        public void run()
        {
          MediaLayoutPopup.a(MediaLayoutPopup.this).a(paramInt / 100.0D);
        }
      });
  }

  public void a(Uri paramUri, int paramInt, com.viber.voip.util.e.f paramf)
  {
    if (paramf != null)
    {
      a();
      if (paramInt == 0)
        break label42;
      this.a.setImageResource(paramInt);
    }
    while (true)
    {
      this.i.a(paramUri, this.a, paramf);
      return;
      paramf = this.j;
      break;
      label42: this.a.setImageDrawable(null);
    }
  }

  public void a(View paramView)
  {
    if (this.t != null);
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    a();
    if (!paramBoolean)
    {
      this.a.setLayoutParams(new RelativeLayout.LayoutParams(c.a, c.a / 2));
      this.a.setBackgroundResource(R.drawable.bg_media_loading_location);
    }
    this.i.a(paramaa.bo(), this.a, this.j, new k(this), paramaa.a(), paramaa.B(), paramaa.o(), paramaa.q(), paramaa.bx().getThumbnailEP(), paramaa.aT());
  }

  public void a(aa paramaa, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a();
    dj.b(this.c, paramBoolean1);
    dj.b(this.d, paramBoolean1);
    dj.b(this.r, paramBoolean3);
    this.u = new a(paramaa);
    int i1 = R.drawable.bg_media_loading_generic;
    if (((paramaa.aq()) || (paramaa.ar())) && (paramaa.az()))
      i1 = R.drawable.image_for_photo_tumbnail;
    com.viber.voip.util.e.f localf;
    if ((paramaa.aK()) && (!paramBoolean2))
    {
      i1 = 0;
      localf = this.l;
      if (paramBoolean2)
        break label200;
      this.a.setLayoutParams(new RelativeLayout.LayoutParams(c.a, c.a));
      this.a.setBackgroundResource(i1);
    }
    while (true)
    {
      this.i.a(paramaa.bo(), this.a, localf, this.u, paramaa.a(), paramaa.B(), paramaa.o(), paramaa.q(), paramaa.bx().getThumbnailEP(), paramaa.aT());
      return;
      if (paramaa.aD())
      {
        localf = this.m;
        break;
      }
      localf = this.j;
      break;
      label200: if (paramaa.aD())
      {
        this.a.setLayoutParams(new RelativeLayout.LayoutParams(c.a / 2, c.a / 2));
        this.a.setBackgroundResource(i1);
      }
      else
      {
        this.a.setBackgroundResource(0);
      }
    }
  }

  public void b(Uri paramUri, int paramInt)
  {
    a(paramUri, paramInt, this.k);
  }

  public void c(Uri paramUri, int paramInt)
  {
    a(paramUri, paramInt, null);
  }

  public com.viber.voip.stickers.f getStickerBitmapLoader()
  {
    if (this.g == null)
      this.g = i.a().e();
    return this.g;
  }

  public x getStickerSvgController()
  {
    if (this.h == null)
      this.h = i.a().f();
    return this.h;
  }

  public void onClick(View paramView)
  {
    if (this.t == null);
    while (true)
    {
      return;
      if (paramView == this.c);
      while (paramView == this.q)
      {
        Log.e("AAAA", "mProgressSvgBtn clicked");
        a(paramView);
        return;
        if (paramView != this.d);
      }
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }

  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    c();
  }

  private class a
    implements h.a
  {
    private aa b;
    private boolean c;
    private long d;

    public a(aa arg2)
    {
      Object localObject;
      this.b = localObject;
      boolean bool2 = this.b.aA();
      if (bool2)
      {
        FileInfo localFileInfo = this.b.bz();
        if (localFileInfo != null)
          this.d = localFileInfo.getFileSize();
      }
      int i;
      if ((this.b.aq()) || (this.b.ar()))
      {
        i = bool1;
        if ((!bool2) || (((localObject.s() <= 999L) || (i == 0)) && ((this.d <= 0L) || (i != 0))))
          break label123;
      }
      while (true)
      {
        this.c = bool1;
        return;
        i = 0;
        break;
        label123: bool1 = false;
      }
    }

    public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
    {
      MediaLayoutPopup.a(MediaLayoutPopup.this, null);
      if (!paramBoolean)
        MediaLayoutPopup.this.a.setBackgroundResource(0);
      if ((this.b.aA()) || (this.b.aK()))
      {
        if (!this.b.aK())
          break label135;
        MediaLayoutPopup.a(MediaLayoutPopup.this).setVisibility(8);
      }
      while (this.c)
      {
        MediaLayoutPopup.f(MediaLayoutPopup.this).setVisibility(0);
        if ((this.b.o() != null) && ((this.b.aq()) || (this.b.ar())))
        {
          MediaLayoutPopup.f(MediaLayoutPopup.this).setText(ae.h(this.b.s()));
          return;
          label135: MediaLayoutPopup.a(MediaLayoutPopup.this).setVisibility(0);
        }
        else
        {
          float f = (float)this.d / 1024.0F / 1024.0F;
          TextView localTextView = MediaLayoutPopup.f(MediaLayoutPopup.this);
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Float.valueOf(f);
          localTextView.setText(String.format("%.2fM", arrayOfObject));
          return;
        }
      }
      MediaLayoutPopup.f(MediaLayoutPopup.this).setVisibility(8);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.MediaLayoutPopup
 * JD-Core Version:    0.6.2
 */