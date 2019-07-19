package com.viber.voip.messages.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.viber.common.b.d;
import com.viber.common.ui.ShapeImageView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.i.c.k;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.MessageComposerView.c;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.n.b;
import com.viber.voip.phone.vptt.v2.VideoPttCamera.VideoSize;
import com.viber.voip.settings.d.bl;
import com.viber.voip.u.a.f.b;
import com.viber.voip.u.g;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.h.a;
import com.viber.voip.widget.IvmStatusView;
import org.webrtc.EglBase;
import org.webrtc.videoengine.ViERenderer;
import org.webrtc.videoengine.ViERenderer.ViERendererCallback;
import org.webrtc.videoengine.ViERenderer.ViewRender;
import org.webrtc.videoengine.VideoCaptureApi;
import org.webrtc.videoengine.VideoCaptureApi.CaptureEventCallback;
import org.webrtc.videoengine.VideoCaptureDeviceInfo;
import org.webrtc.videoengine.VideoCaptureDeviceInfo.VideoCaptureEventListener;
import org.webrtc.videoengine.VideoCaptureDeviceInfoAndroid;

public class VideoPttRecordView extends FrameLayout
  implements ViERenderer.ViERendererCallback, VideoCaptureApi.CaptureEventCallback, VideoCaptureDeviceInfo.VideoCaptureEventListener
{
  private static final Logger a = ViberEnv.getLogger();
  private com.viber.voip.u.e b;
  private g c;
  private f.b d;
  private MessageComposerView.c e;
  private FrameLayout f;
  private IvmStatusView g;
  private ShapeImageView h;
  private com.viber.voip.widget.d.a i;
  private com.viber.voip.widget.a j;
  private EglBase k;
  private Handler l;
  private com.viber.voip.util.e.e m;
  private com.viber.voip.util.e.f n;
  private boolean o;
  private boolean p;
  private boolean q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private h.a y = new h.a()
  {
    public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
    {
      VideoPttRecordView.h(VideoPttRecordView.this).setVisibility(0);
      VideoPttRecordView.a(VideoPttRecordView.this, false);
    }
  };

  public VideoPttRecordView(Context paramContext)
  {
    super(paramContext);
    e();
  }

  public VideoPttRecordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }

  public VideoPttRecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }

  private void a(int paramInt)
  {
    boolean bool = dj.c(getContext());
    int i1;
    if ((ViberApplication.isTablet(getContext())) || (!bool))
    {
      i1 = this.v;
      int i2 = paramInt - i1 * 2;
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
        i2 = Math.min(i2, (int)(paramInt / 1.33F));
      if (this.u <= i2)
        break label196;
      if (this.t <= i2)
        break label185;
      this.r = i2;
    }
    while (true)
    {
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.h.getLayoutParams();
      localLayoutParams1.width = this.r;
      localLayoutParams1.height = this.r;
      this.h.setPadding(this.s, this.s, this.s, this.s);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.g.getLayoutParams();
      localLayoutParams2.width = this.r;
      localLayoutParams2.height = this.r;
      return;
      i1 = this.w;
      break;
      label185: this.r = this.t;
      continue;
      label196: this.r = this.u;
    }
  }

  private void a(final boolean paramBoolean)
  {
    if (this.b != null)
      this.b.b();
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        if ((VideoPttRecordView.b(VideoPttRecordView.this)) && (paramBoolean))
          VideoPttRecordView.c(VideoPttRecordView.this).a(true, false);
        VideoPttRecordView.e(VideoPttRecordView.this);
      }
    };
    this.p = true;
    if (paramBoolean)
    {
      this.d.b(local2);
      return;
    }
    local2.run();
  }

  private void e()
  {
    View localView = LayoutInflater.from(getContext()).inflate(R.layout.layout_video_ptt_record_inner, this, true);
    this.f = ((FrameLayout)localView.findViewById(R.id.video_ptt_record_surface_container));
    this.h = ((ShapeImageView)localView.findViewById(R.id.video_ptt_record_thumbnail));
    this.g = ((IvmStatusView)localView.findViewById(R.id.video_ptt_record_svg_overlay));
    this.x = 1;
    this.g.setShape(this.x);
    this.g.setRecordingDuration(d.bl.e.d());
    this.g.setRecordWarningDuration(-5000 + d.bl.e.d());
    this.l = av.a(av.e.a);
    this.m = com.viber.voip.util.e.e.a(getContext());
    this.n = new f.a().b(Integer.valueOf(R.drawable.ic_video_ptt_default)).c();
    Resources localResources = getResources();
    this.t = localResources.getDimensionPixelSize(R.dimen.video_ptt_record_small_size);
    this.u = localResources.getDimensionPixelSize(R.dimen.video_ptt_record_size);
    this.s = Math.round(localResources.getDimensionPixelSize(R.dimen.ivm_recorder_stroke_width) / 2.0F);
    this.v = localResources.getDimensionPixelSize(R.dimen.video_ptt_record_vertical_margin);
    this.w = localResources.getDimensionPixelSize(R.dimen.video_ptt_record_landscape_vertical_margin);
    if (c.k.b.e())
    {
      this.j = new com.viber.voip.widget.a(getContext());
      this.j.setResizeMode(1);
      FrameLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 17;
      this.f.addView(this.j, localLayoutParams);
    }
  }

  private void f()
  {
    this.b.a(new a(null));
    ViERenderer.addRenderEventSubscriber(this);
    if (VideoCaptureDeviceInfoAndroid.getInstance() != null)
      VideoCaptureDeviceInfoAndroid.getInstance().addEventListener(this);
  }

  private void g()
  {
    ViERenderer.ViewRender localViewRender;
    if (this.i == null)
    {
      if ((!this.o) && (c.k.b.e()))
        break label186;
      localViewRender = ViERenderer.newLocalRenderView(ViberApplication.getApplication(), this.x);
      if (localViewRender != null);
    }
    else
    {
      return;
    }
    this.i = localViewRender.surface;
    EglBase localEglBase2 = localViewRender.eglBase;
    VideoPttCamera.VideoSize localVideoSize = null;
    EglBase localEglBase1 = localEglBase2;
    int i2;
    FrameLayout.LayoutParams localLayoutParams2;
    if ((ViewGroup)this.i.getView().getParent() == null)
    {
      i2 = this.r - 2 * this.s;
      if (!c.k.b.e())
        break label304;
      if (localVideoSize.height >= localVideoSize.width)
        break label288;
      localLayoutParams2 = new FrameLayout.LayoutParams(-2, i2);
      label127: localLayoutParams2.gravity = 17;
      this.j.addView(this.i.getView(), localLayoutParams2);
    }
    while (true)
    {
      this.i.getView().setVisibility(0);
      if (this.b == null)
        break;
      this.b.a(this.i, localEglBase1);
      return;
      label186: localVideoSize = this.b.a();
      this.i = new com.viber.voip.widget.d.a.a(getContext().getApplicationContext(), localVideoSize.width, localVideoSize.height);
      float f1 = this.i.getAspectRatio();
      this.i.setShape(this.x);
      this.j.setAspectRatio(f1);
      com.viber.voip.widget.a locala = this.j;
      if (localVideoSize.height < localVideoSize.width);
      for (int i1 = 2; ; i1 = 1)
      {
        locala.setResizeMode(i1);
        localEglBase1 = null;
        break;
      }
      label288: localLayoutParams2 = new FrameLayout.LayoutParams(i2, -2);
      break label127;
      label304: FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(i2, i2);
      this.f.addView(this.i.getView(), localLayoutParams1);
    }
  }

  private void h()
  {
    if (this.i != null)
    {
      this.i.getView().setVisibility(4);
      ViewGroup localViewGroup = (ViewGroup)this.i.getView().getParent();
      if (localViewGroup != null)
        localViewGroup.removeView(this.i.getView());
      this.i = null;
    }
  }

  private void i()
  {
    if (this.b != null)
      this.b.b();
    h();
    this.b.a(null);
    ViERenderer.removeRenderEventSubscriber(this);
    if (VideoCaptureDeviceInfoAndroid.getInstance() != null)
      VideoCaptureDeviceInfoAndroid.getInstance().removeEventListener(this);
    this.p = false;
  }

  private void j()
  {
    ViberApplication.getInstance().getPlayerWindowManager().b();
  }

  public void a()
  {
    this.g.setStatus(2);
    this.o = false;
    this.b.e();
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    this.x = com.viber.voip.u.a.b();
    this.h.setShape(com.viber.voip.u.a.a());
    this.g.setShape(this.x);
    this.g.setStatus(-1);
    j();
    this.q = paramBoolean;
    int i1 = this.e.f();
    if (this.q)
    {
      if (this.e.h())
        i1 += this.e.g();
      this.e.a(false, false);
    }
    a(i1);
    this.d.a();
    f();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i2 = b.b();
    ViberApplication.getInstance().getEngine(true).getPhoneController().setDeviceOrientation(i2, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    try
    {
      g();
      this.b.a(paramLong, this.x);
      this.o = true;
      this.d.a(new Runnable()
      {
        public void run()
        {
          if (!VideoPttRecordView.a(VideoPttRecordView.this))
          {
            boolean bool = VideoPttRecordView.b(VideoPttRecordView.this);
            Runnable local1 = null;
            if (bool)
              local1 = new Runnable()
              {
                public void run()
                {
                  VideoPttRecordView.c(VideoPttRecordView.this).a(true, false);
                }
              };
            VideoPttRecordView.d(VideoPttRecordView.this).b(local1);
          }
        }
      });
      return;
    }
    catch (Throwable localThrowable)
    {
      this.b.c();
      a.a(localThrowable, "VPTT2 error");
    }
  }

  public void a(g paramg, f.b paramb, MessageComposerView.c paramc)
  {
    this.b = ViberApplication.getInstance().getMessagesManager().o();
    this.c = paramg;
    this.d = paramb;
    this.e = paramc;
    if (this.i != null)
      this.b.a(this.i, this.k);
  }

  public void b()
  {
    this.g.setStatus(2);
    this.o = false;
    this.b.d();
  }

  public void c()
  {
    if (this.q)
      this.e.a(true, false);
    this.g.setStatus(-1);
    this.h.setVisibility(8);
  }

  public boolean d()
  {
    return this.p;
  }

  public void onCaptureAllocated(VideoCaptureApi paramVideoCaptureApi)
  {
    if (paramVideoCaptureApi != null)
      paramVideoCaptureApi.addEventCallback(this);
    SurfaceHolder localSurfaceHolder = ViERenderer.GetLocalRenderer();
    if (localSurfaceHolder != null)
    {
      if ((localSurfaceHolder.getSurfaceFrame().width() == 0) || (localSurfaceHolder.getSurfaceFrame().height() == 0))
        break label56;
      if (paramVideoCaptureApi.registerPreviewHolder(localSurfaceHolder))
        paramVideoCaptureApi.newPreviewSessionForHolder(localSurfaceHolder);
    }
    label56: 
    while ((paramVideoCaptureApi.getWidth() <= 0) || (paramVideoCaptureApi.getHeight() <= 0))
      return;
    localSurfaceHolder.setFixedSize(paramVideoCaptureApi.getWidth(), paramVideoCaptureApi.getHeight());
  }

  public void onCaptureDeleted(VideoCaptureApi paramVideoCaptureApi)
  {
    if (paramVideoCaptureApi != null)
      paramVideoCaptureApi.removeEventCallback(this);
  }

  public void onConfigureCamera(VideoCaptureApi paramVideoCaptureApi, int paramInt1, int paramInt2)
  {
    if ((ViERenderer.GetLocalRenderer() == null) || ((paramInt1 != 0) && (paramInt2 != 0)))
      g();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    i();
  }

  public void onLocalRenderGone(SurfaceHolder paramSurfaceHolder)
  {
    VideoCaptureApi localVideoCaptureApi = VideoCaptureDeviceInfo.getInstance().getCurrentCaptureObject();
    if ((localVideoCaptureApi != null) && (paramSurfaceHolder != null))
      localVideoCaptureApi.deletePreviewSessionForHolder(paramSurfaceHolder);
  }

  public void onLocalSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    VideoCaptureApi localVideoCaptureApi = VideoCaptureDeviceInfo.getInstance().getCurrentCaptureObject();
    if ((localVideoCaptureApi != null) && (paramSurfaceHolder != null))
      localVideoCaptureApi.newPreviewSessionForHolder(paramSurfaceHolder);
  }

  public void onLocalSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    VideoCaptureApi localVideoCaptureApi = VideoCaptureDeviceInfo.getInstance().getCurrentCaptureObject();
    if ((localVideoCaptureApi != null) && (paramSurfaceHolder != null))
      localVideoCaptureApi.newPreviewSessionForHolder(paramSurfaceHolder);
  }

  public void onNewRemoteRenderer(int paramInt, SurfaceView paramSurfaceView, SurfaceHolder paramSurfaceHolder)
  {
  }

  public void onRemoteRenderGone(SurfaceHolder paramSurfaceHolder, SurfaceView paramSurfaceView)
  {
  }

  public void onRemoteSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
  }

  public void onStartCapture(VideoCaptureApi paramVideoCaptureApi)
  {
    if (paramVideoCaptureApi != null);
  }

  public void onStopCapture(VideoCaptureApi paramVideoCaptureApi)
  {
  }

  private class a
    implements g
  {
    private a()
    {
    }

    public void A()
    {
      VideoPttRecordView.f(VideoPttRecordView.this).A();
      VideoPttRecordView.g(VideoPttRecordView.this).setStatus(3);
    }

    public void B()
    {
      VideoPttRecordView.f(VideoPttRecordView.this).B();
    }

    public void C()
    {
      VideoPttRecordView.f(VideoPttRecordView.this).C();
      VideoPttRecordView.g(VideoPttRecordView.this).setStatus(2);
      VideoPttRecordView.a(VideoPttRecordView.this, true);
    }

    public void a(MessageEntity paramMessageEntity)
    {
      VideoPttRecordView.f(VideoPttRecordView.this).a(paramMessageEntity);
      if (paramMessageEntity == null)
        return;
      boolean bool = da.a(paramMessageEntity.getBody());
      Uri localUri = null;
      if (!bool)
        localUri = Uri.parse(paramMessageEntity.getBody());
      VideoPttRecordView.k(VideoPttRecordView.this).a(localUri, VideoPttRecordView.h(VideoPttRecordView.this), VideoPttRecordView.i(VideoPttRecordView.this), VideoPttRecordView.j(VideoPttRecordView.this));
    }

    public void h(int paramInt)
    {
      VideoPttRecordView.f(VideoPttRecordView.this).h(paramInt);
      VideoPttRecordView.g(VideoPttRecordView.this).setStatus(2);
      VideoPttRecordView.a(VideoPttRecordView.this, true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.VideoPttRecordView
 * JD-Core Version:    0.6.2
 */