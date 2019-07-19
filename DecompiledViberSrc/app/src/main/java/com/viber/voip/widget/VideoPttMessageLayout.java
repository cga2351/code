package com.viber.voip.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.viber.common.dialogs.h.a;
import com.viber.common.ui.ShapeImageView;
import com.viber.common.ui.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.a;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.view.AnimatedSoundIconView;
import com.viber.voip.sound.AudioStreamManager;
import com.viber.voip.sound.NativeMediaDelegate;
import com.viber.voip.u.d.c;
import com.viber.voip.ui.dialogs.ah;
import com.viber.voip.util.bj;
import com.viber.voip.util.dc;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.upload.m;
import com.viber.voip.util.upload.s;
import org.webrtc.videoengine.ViERenderer;
import org.webrtc.videoengine.ViERenderer.ViERendererCallback;

public class VideoPttMessageLayout extends FrameLayout
{
  private static final Logger b = ViberEnv.getLogger();
  com.viber.voip.messages.d.l a;
  private com.viber.voip.u.d c;
  private AudioStreamManager d;
  private ai e;
  private e f;
  private f g;
  private IvmStatusView h;
  private com.viber.voip.widget.d.a i;
  private a j;
  private ShapeImageView k;
  private AnimatedSoundIconView l;
  private aa m;
  private int n;
  private Uri o;
  private volatile int p;
  private Handler q;
  private boolean r;
  private boolean s;
  private final PointF t = new PointF();
  private final Runnable u = new Runnable()
  {
    public void run()
    {
      VideoPttMessageLayout.b(VideoPttMessageLayout.this).a(VideoPttMessageLayout.a(VideoPttMessageLayout.this), true);
    }
  };
  private final m v = new m()
  {
    public void a(Uri paramAnonymousUri, int paramAnonymousInt)
    {
      if (paramAnonymousUri.equals(VideoPttMessageLayout.c(VideoPttMessageLayout.this)))
      {
        VideoPttMessageLayout.a(VideoPttMessageLayout.this, paramAnonymousInt);
        VideoPttMessageLayout.e(VideoPttMessageLayout.this).removeCallbacks(VideoPttMessageLayout.d(VideoPttMessageLayout.this));
        VideoPttMessageLayout.e(VideoPttMessageLayout.this).post(VideoPttMessageLayout.d(VideoPttMessageLayout.this));
      }
    }
  };
  private final a w = new a(null);
  private final b x = new b(null);

  public VideoPttMessageLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public VideoPttMessageLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public VideoPttMessageLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.VideoPttMessageLayout);
    try
    {
      Drawable localDrawable = localTypedArray.getDrawable(R.styleable.VideoPttMessageLayout_playIcon);
      localTypedArray.recycle();
      ViberApplication localViberApplication = ViberApplication.getInstance();
      this.d = new AudioStreamManager(paramContext);
      this.q = av.a(av.e.a);
      this.f = e.a(paramContext);
      this.c = localViberApplication.getMessagesManager().n();
      this.e = localViberApplication.getMessagesManager().c();
      this.g = f.a(R.drawable.ic_video_ptt_default);
      this.k = new ShapeImageView(paramContext);
      this.k.setShape(b.b.f);
      this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Resources localResources = getResources();
      this.n = localResources.getDimensionPixelSize(R.dimen.ivm_conversation_circle_border_width);
      FrameLayout.LayoutParams localLayoutParams1 = generateDefaultLayoutParams();
      localLayoutParams1.width = -1;
      localLayoutParams1.height = -1;
      int i1 = this.n;
      localLayoutParams1.setMargins(i1, i1, i1, i1);
      addView(this.k, localLayoutParams1);
      this.h = new IvmStatusView(paramContext);
      this.h.setShape(1);
      this.h.setPlayIcon(localDrawable);
      this.h.setStrokeColor(ColorStateList.valueOf(dc.d(paramContext, R.attr.conversationIVMStrokeColor)));
      this.h.setOverlayColor(ContextCompat.getColorStateList(paramContext, R.color.ivm_overlay));
      this.h.setWarningColor(ColorStateList.valueOf(dc.d(paramContext, R.attr.conversationIVMWarningColor)));
      FrameLayout.LayoutParams localLayoutParams2 = generateDefaultLayoutParams();
      int i2 = localResources.getDimensionPixelSize(R.dimen.ivm_conversation_circle_size);
      localLayoutParams2.width = i2;
      localLayoutParams2.height = i2;
      localLayoutParams2.gravity = 17;
      addView(this.h, localLayoutParams2);
      this.l = new AnimatedSoundIconView(getContext());
      FrameLayout.LayoutParams localLayoutParams3 = generateDefaultLayoutParams();
      int i3 = getResources().getDimensionPixelOffset(R.dimen.animated_sound_icon_size);
      localLayoutParams3.width = i3;
      localLayoutParams3.height = i3;
      localLayoutParams3.gravity = 85;
      localLayoutParams3.bottomMargin = getPaddingBottom();
      localLayoutParams3.rightMargin = getPaddingRight();
      addView(this.l, localLayoutParams3);
      this.k.setImageResource(R.drawable.ic_video_ptt_default);
      this.j = new a(getContext());
      this.j.setResizeMode(1);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.m == null) || (this.a == null));
    int i2;
    int i3;
    boolean bool1;
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(this.m.o()));
        for (int i1 = 1; ; i1 = 0)
        {
          i2 = this.m.f();
          i3 = this.m.z();
          this.o = dx.a(this.m);
          bool1 = s.a(this.o);
          this.p = 0;
          if (paramBoolean2)
            this.h.setShape(com.viber.voip.u.a.b(this.m.bx().getIvmInfo()));
          if (i1 == 0)
            break;
          switch (i2)
          {
          case 0:
          case 3:
          case 4:
          case 5:
          default:
            return;
          case -1:
            if (this.c.a(this.a))
            {
              this.c.e(this.a);
              this.c.c();
            }
            a(true, true);
            return;
          case 1:
          case 2:
          }
        }
        i();
      }
      while (this.c.a(this.a));
      a(this.c.c(this.a), true);
      return;
      if ((!paramBoolean1) || (av.a() == av.a.d))
        break;
      com.viber.voip.util.upload.l.a(this.v);
      if (bool1)
      {
        j();
        return;
      }
      if (i2 == -1)
      {
        a(true, true);
        return;
      }
    }
    while (i3 != 3);
    i();
    return;
    boolean bool2 = false;
    if (!bool1)
    {
      bool2 = false;
      if (i2 == -1)
        bool2 = true;
    }
    a(bool2, true);
  }

  private void d()
  {
    if (this.r)
      return;
    this.r = true;
    this.c.a(this.a, this.w);
  }

  private void e()
  {
    if (!this.r)
      return;
    this.r = false;
    com.viber.voip.util.upload.l.b(this.v);
    this.c.e(this.a);
    this.a = null;
  }

  private void f()
  {
    this.e.a(this.m.a(), this.m.C());
    com.viber.voip.util.upload.l.a(this.v);
    this.h.a(this.p, true);
  }

  private void g()
  {
    ViewGroup localViewGroup = (ViewGroup)this.i.getView().getParent();
    if (localViewGroup == this.j)
      return;
    FrameLayout.LayoutParams localLayoutParams1 = generateDefaultLayoutParams();
    localLayoutParams1.width = -1;
    localLayoutParams1.height = -1;
    int i1 = this.n;
    localLayoutParams1.setMargins(i1, i1, i1, i1);
    if (localViewGroup != null)
      localViewGroup.removeView(this.i.getView());
    int i2 = indexOfChild(this.k);
    int i3;
    if (!this.i.a())
    {
      FrameLayout.LayoutParams localLayoutParams2 = generateDefaultLayoutParams();
      localLayoutParams2.width = -1;
      localLayoutParams2.height = -1;
      localLayoutParams2.gravity = 17;
      float f1 = this.i.getAspectRatio();
      this.j.setAspectRatio(f1);
      a locala = this.j;
      if (this.i.b())
      {
        i3 = 2;
        locala.setResizeMode(i3);
        if (this.j.getParent() != null)
          removeView(this.j);
        addView(this.j, localLayoutParams2);
      }
    }
    for (Object localObject = this.j; ; localObject = this)
    {
      if (i2 != -1)
        ((FrameLayout)localObject).addView(this.i.getView(), i2, localLayoutParams1);
      while (true)
      {
        this.h.bringToFront();
        return;
        i3 = 1;
        break;
        ((FrameLayout)localObject).addView(this.i.getView(), localLayoutParams1);
      }
    }
  }

  private void h()
  {
    if (this.i == null)
      return;
    Object localObject;
    if (!this.i.a())
    {
      localObject = this.j;
      removeView(this.j);
    }
    while (true)
    {
      ((FrameLayout)localObject).removeView(this.i.getView());
      if (this.i.a())
      {
        ViERenderer.removeRenderEventSubscriber(this.x);
        ViERenderer.DestroyRemoteRenderView(this.i.getView());
      }
      this.i = null;
      return;
      localObject = this;
    }
  }

  private void i()
  {
    com.viber.voip.util.upload.l.b(this.v);
    this.q.removeCallbacks(this.u);
  }

  private void j()
  {
    Integer localInteger = com.viber.voip.util.upload.l.e(this.o);
    if (localInteger != null);
    for (this.p = localInteger.intValue(); ; this.p = 0)
    {
      this.u.run();
      return;
    }
  }

  void a()
  {
    if (this.s)
    {
      this.l.b();
      return;
    }
    this.l.a();
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    this.m = paramaa;
    com.viber.voip.messages.d.l locall = new com.viber.voip.messages.d.l(paramaa);
    boolean bool1 = locall.equals(this.a);
    boolean bool2 = false;
    Uri localUri;
    if (!bool1)
    {
      if (this.c.a(this.a))
        this.c.c();
      e();
      this.a = locall;
      if (!this.c.a(this.a))
        break label235;
      if (TextUtils.isEmpty(paramaa.o()))
        break label229;
      localUri = Uri.parse(paramaa.o());
      this.i = new com.viber.voip.widget.d.d().a(getContext()).a(localUri).a();
      if (this.i.a())
        NativeMediaDelegate.renewRemoteVideoRenderer(this.i.getView());
      a(true);
    }
    for (bool2 = true; ; bool2 = true)
    {
      this.k.setShape(com.viber.voip.u.a.a(paramaa.bx().getIvmInfo()));
      this.f.a(paramaa.bo(), this.k, this.g, null, paramaa.a(), paramaa.B(), paramaa.o(), paramaa.q(), paramaa.bx().getThumbnailEP(), paramaa.aT());
      d();
      b(paramBoolean, bool2);
      return;
      label229: localUri = null;
      break;
      label235: a(this.c.c(this.a), true);
    }
  }

  void a(boolean paramBoolean)
  {
    if (this.i == null)
      return;
    if (paramBoolean)
    {
      this.h.setStatus(1);
      this.k.setVisibility(8);
    }
    while (true)
    {
      g();
      if (!this.c.b(this.a))
        break;
      a();
      return;
      ViERenderer.addRenderEventSubscriber(this.x);
    }
  }

  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.k.setVisibility(0);
    if (paramBoolean2)
      h();
    if (paramBoolean1)
      this.h.setStatus(5);
    while (true)
    {
      b();
      invalidate();
      return;
      this.h.setStatus(0);
    }
  }

  void b()
  {
    this.l.c();
  }

  public void c()
  {
    if ((!this.r) || (this.a == null) || (this.m == null));
    do
    {
      return;
      if (this.c.a(this.a))
      {
        if (this.c.b(this.a))
        {
          this.c.b();
          return;
        }
        this.c.c();
        return;
      }
      if ((this.m.ap()) && (this.m.f() == -1))
      {
        this.e.b(this.m.a());
        return;
      }
      if (!TextUtils.isEmpty(this.m.o()))
      {
        if (bj.a(Uri.parse(this.m.o())))
        {
          this.c.d(this.a);
          return;
        }
        if (this.m.ao())
        {
          f();
          return;
        }
        ah.d().d();
        return;
      }
    }
    while (s.a(this.m.C()));
    f();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.t.set(paramInt1 / 2.0F, paramInt2 / 2.0F);
  }

  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    if (paramView == this.i.getView())
      a(false, false);
  }

  public void setInstanMediaMessageClickListener(com.viber.voip.messages.conversation.adapter.d.d paramd)
  {
    this.c.a(paramd);
  }

  public void setSoundIconType(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  private class a
    implements d.c
  {
    private boolean b;

    private a()
    {
    }

    private int a(aa paramaa)
    {
      if (paramaa == null);
      while (!paramaa.aW())
        return 3;
      return 0;
    }

    public com.viber.voip.widget.d.a a(Uri paramUri)
    {
      this.b = false;
      VideoPttMessageLayout.a(VideoPttMessageLayout.this, new com.viber.voip.widget.d.d().a(VideoPttMessageLayout.this.getContext()).a(paramUri).a());
      int i = com.viber.voip.u.a.b(VideoPttMessageLayout.f(VideoPttMessageLayout.this).bx().getIvmInfo());
      VideoPttMessageLayout.g(VideoPttMessageLayout.this).setShape(i);
      return VideoPttMessageLayout.g(VideoPttMessageLayout.this);
    }

    public void a()
    {
      int i = a(VideoPttMessageLayout.f(VideoPttMessageLayout.this));
      VideoPttMessageLayout.h(VideoPttMessageLayout.this).changeStream(i);
      VideoPttMessageLayout.this.a(true);
      VideoPttMessageLayout.this.setKeepScreenOn(true);
    }

    public void b()
    {
      VideoPttMessageLayout.this.b();
    }

    public void c()
    {
      VideoPttMessageLayout.this.a(false, false);
    }

    public void d()
    {
      if (this.b)
        VideoPttMessageLayout.this.a(true, true);
      while (true)
      {
        VideoPttMessageLayout.h(VideoPttMessageLayout.this).restoreStream();
        VideoPttMessageLayout.this.setKeepScreenOn(false);
        return;
        VideoPttMessageLayout.i(VideoPttMessageLayout.this);
      }
    }

    public void e()
    {
      this.b = true;
    }
  }

  private class b
    implements ViERenderer.ViERendererCallback
  {
    private b()
    {
    }

    public void onLocalRenderGone(SurfaceHolder paramSurfaceHolder)
    {
    }

    public void onLocalSurfaceChanged(SurfaceHolder paramSurfaceHolder)
    {
    }

    public void onLocalSurfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
    }

    public void onNewRemoteRenderer(int paramInt, SurfaceView paramSurfaceView, SurfaceHolder paramSurfaceHolder)
    {
    }

    public void onRemoteRenderGone(SurfaceHolder paramSurfaceHolder, SurfaceView paramSurfaceView)
    {
    }

    public void onRemoteSurfaceChanged(SurfaceHolder paramSurfaceHolder)
    {
      VideoPttMessageLayout.b(VideoPttMessageLayout.this).setStatus(1);
      VideoPttMessageLayout.j(VideoPttMessageLayout.this).setVisibility(8);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.VideoPttMessageLayout
 * JD-Core Version:    0.6.2
 */