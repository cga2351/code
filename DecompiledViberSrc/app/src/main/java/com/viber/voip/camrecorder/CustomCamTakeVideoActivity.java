package com.viber.voip.camrecorder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.b.h;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.camera.a.a.h;
import com.viber.voip.camera.activity.ViberCcamActivity.c;
import com.viber.voip.camera.activity.ViberCcamOverlayActivity;
import com.viber.voip.camera.d.a.a;
import com.viber.voip.camera.d.a.a.a;
import com.viber.voip.camrecorder.preview.MediaPreviewActivity;
import com.viber.voip.camrecorder.preview.d;
import com.viber.voip.camrecorder.preview.d.a;
import com.viber.voip.camrecorder.preview.d.c;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.selection.l;
import com.viber.voip.gallery.selection.q.a;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.m;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner.x;
import com.viber.voip.util.at;
import com.viber.voip.util.bp;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.g;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public class CustomCamTakeVideoActivity extends ViberCcamOverlayActivity
  implements ViberCcamActivity.c, l, q.a
{
  public static final long G = (int)TimeUnit.MINUTES.toSeconds(2L);
  private static final Logger J = ViberEnv.getLogger();

  @Inject
  g H;

  @Inject
  c I;
  private String K;
  private com.viber.voip.camrecorder.b.a L;
  private com.viber.voip.camrecorder.b.a M;
  private com.viber.voip.camrecorder.b.a N;
  private com.viber.voip.camrecorder.b.a O;
  private View P;
  private View Q;
  private View R;
  private View S;
  private View T;
  private View U;
  private RecyclerView V;
  private b W;
  private d X;
  private boolean Y = true;
  private final com.viber.common.permission.b Z;
  private final Runnable aa;

  public CustomCamTakeVideoActivity()
  {
    Pair[] arrayOfPair = new Pair[3];
    arrayOfPair[0] = m.a(114);
    arrayOfPair[1] = m.a(25);
    arrayOfPair[2] = m.a(10);
    this.Z = new f(this, arrayOfPair)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt1)
        {
        default:
        case 10:
        }
        do
          return;
        while (((!DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) && (!DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString))) || (paramAnonymousInt2 == -1));
        CustomCamTakeVideoActivity.this.finish();
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        case 25:
        default:
        case 114:
        case 10:
        }
        do
        {
          return;
          CustomCamTakeVideoActivity.a(CustomCamTakeVideoActivity.this);
          return;
        }
        while ((!com.viber.voip.util.n.a(paramAnonymousArrayOfString, "android.permission.WRITE_EXTERNAL_STORAGE")) || (CustomCamTakeVideoActivity.b(CustomCamTakeVideoActivity.this) == null));
        CustomCamTakeVideoActivity.b(CustomCamTakeVideoActivity.this).a();
      }
    };
    this.aa = new Runnable()
    {
      public void run()
      {
        CustomCamTakeVideoActivity.c(CustomCamTakeVideoActivity.this);
        CustomCamTakeVideoActivity.d(CustomCamTakeVideoActivity.this).postDelayed(this, 500L);
      }
    };
  }

  private void Q()
  {
    this.S = a(R.id.ccam_x, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CustomCamTakeVideoActivity.this.finish();
      }
    }
    , null);
  }

  private void R()
  {
    if (this.P == null)
    {
      this.P = getLayoutInflater().inflate(R.layout.ccam_countdown_overlay_vertical, this.t, false);
      this.t.addView(this.P);
    }
  }

  private void S()
  {
    if (this.M == null)
    {
      this.M = new com.viber.voip.camrecorder.b.a((TextView)this.t.findViewById(R.id.video_duration_tooltip_in_vertical), null);
      return;
    }
    this.M.a();
  }

  private void T()
  {
    if (this.Q == null)
    {
      this.Q = getLayoutInflater().inflate(R.layout.ccam_countdown_overlay_horizontal_90, this.t, false);
      this.t.addView(this.Q);
    }
    if (this.R == null)
    {
      this.R = getLayoutInflater().inflate(R.layout.ccam_countdown_overlay_horizontal_270, this.t, false);
      this.t.addView(this.R);
    }
  }

  private void U()
  {
    if (this.N == null)
      this.N = new com.viber.voip.camrecorder.b.a((TextView)this.t.findViewById(R.id.video_duration_tooltip_in_horizontal_90), null);
    while (this.O == null)
    {
      this.O = new com.viber.voip.camrecorder.b.a((TextView)this.t.findViewById(R.id.video_duration_tooltip_in_horizontal_270), null);
      return;
      this.N.a();
    }
    this.O.a();
  }

  private void V()
  {
    this.T = a(R.id.ccam_open_gallery, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CustomCamTakeVideoActivity.this.O();
      }
    });
  }

  private void W()
  {
    if ((!o.b(true)) || (!o.a(true)))
      return;
    Bundle localBundle = com.viber.voip.analytics.story.n.b(null, "Camera Gallery");
    startActivityForResult(ViberActionRunner.x.b(this, P(), localBundle), 1044);
  }

  private void X()
  {
    this.V = ((RecyclerView)this.t.findViewById(R.id.recent_media_list));
    if (this.V != null)
      this.W = new b(this, this.V, this, this, this.H, this.I);
  }

  private d Y()
  {
    if (this.X == null)
      this.X = new d(new d.a(this))
      {
        protected int a()
        {
          return 43;
        }

        protected int b()
        {
          return 43;
        }

        protected int c()
        {
          return 1043;
        }
      };
    return this.X;
  }

  private void Z()
  {
    if (this.L.c())
      this.L.a(this.d.aa());
  }

  private Bundle aa()
  {
    return (Bundle)getIntent().getParcelableExtra("options");
  }

  private void c(boolean paramBoolean)
  {
    this.Y = paramBoolean;
    if ((this.W != null) && (!paramBoolean))
      this.W.b(8);
  }

  protected List<WeakReference<? extends View>> B()
  {
    List localList = super.B();
    localList.add(new WeakReference(this.S));
    localList.add(new WeakReference(this.U));
    localList.add(new WeakReference(this.T));
    localList.add(new WeakReference(this.V));
    return localList;
  }

  protected void C()
  {
  }

  protected boolean E()
  {
    return false;
  }

  protected boolean F()
  {
    return true;
  }

  protected void G()
  {
  }

  public void I()
  {
    super.I();
    ViberApplication.getInstance().getPlayerWindowManager().b();
  }

  protected void L()
  {
    this.p.setImageResource(R.drawable.ic_ccam_capture_btn_selector);
  }

  public void M()
  {
    super.M();
    this.L.b();
    this.a.post(this.aa);
  }

  public void N()
  {
    super.N();
    this.L.a();
    this.a.removeCallbacks(this.aa);
  }

  void O()
  {
    if (this.I.a(com.viber.voip.permissions.n.m))
    {
      W();
      return;
    }
    this.I.a(this, 114, com.viber.voip.permissions.n.m);
  }

  public ConversationData P()
  {
    return (ConversationData)getIntent().getParcelableExtra("com.viber.voip.conversation_data");
  }

  protected int a(View paramView, int paramInt)
  {
    int i = 8;
    if ((paramView == this.U) || (paramView == this.S))
    {
      if ((!this.D) && (this.f % 180 == 0))
        i = 0;
      return i;
    }
    if ((paramView == this.V) && (this.W != null))
    {
      if (!this.Y);
      while (true)
      {
        this.W.b(i);
        return i;
        i = paramInt;
      }
    }
    return paramInt;
  }

  public Pair<Integer, Integer> a(com.viber.voip.camera.c.b paramb, List<a.h> paramList, List<String> paramList1)
  {
    return new com.viber.voip.camrecorder.a.a().a(paramb, paramList, paramList1);
  }

  protected void a()
  {
    super.a();
    Q();
    R();
    S();
    T();
    U();
    this.L = this.M;
    this.U = g(R.id.ccam_capture_button_tip);
    V();
    X();
  }

  public void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    c(false);
  }

  protected void a(View paramView)
  {
    if (this.d == null)
      return;
    if ((this.d.Y()) && (!this.d.Z()) && (!this.I.a(com.viber.voip.permissions.n.i)))
    {
      this.I.a(this, 25, com.viber.voip.permissions.n.i);
      K();
      return;
    }
    x();
  }

  public void a(GalleryItem paramGalleryItem)
  {
    Bundle localBundle = com.viber.voip.analytics.story.n.b(null, "Camera Gallery Preview");
    localBundle.putBoolean("com.viber.voip.media_from_recent_gallery", true);
    Y().a(P(), paramGalleryItem, localBundle);
  }

  public void a(String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    c(true);
    MediaPreviewActivity.a(this, paramString, paramUri, P().canSendTimeBomb, paramBoolean2, aa());
  }

  public void a(String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean1)
      com.viber.voip.analytics.story.n.b(aa(), "Camera");
    c(true);
    getCallingActivity();
    ConversationData localConversationData = P();
    MediaPreviewActivity.a(this, localConversationData.conversationId, paramString, paramUri, localConversationData.canSendTimeBomb, paramBoolean2, true, paramInt, aa());
  }

  protected void a(boolean paramBoolean)
  {
    this.p.setImageResource(R.drawable.ic_ccam_video_capture_btn_pressed);
  }

  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(bp.c(paramContext));
  }

  public Pair<String, Drawable> b(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1146923872:
    case 1625570446:
    case -1195303778:
    }
    while (true)
      switch (i)
      {
      default:
        return null;
        if (paramString.equals("flash_off"))
        {
          i = 0;
          continue;
          if (paramString.equals("flash_on"))
          {
            i = 1;
            continue;
            if (paramString.equals("flash_auto"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    return Pair.create(null, ContextCompat.getDrawable(this, R.drawable.ic_ccam_flash_off_selector));
    return Pair.create(null, ContextCompat.getDrawable(this, R.drawable.ic_ccam_flash_on_selector));
    return Pair.create(null, ContextCompat.getDrawable(this, R.drawable.ic_ccam_flash_auto_selector));
  }

  protected a.a d()
  {
    return new a.a.a().c(false).d(false).e(false).a((int)G).a(dv.i.a(this).getPath()).b(2000000).b(true).a(false).a(35L).a();
  }

  protected void d(int paramInt)
  {
    boolean bool1 = true;
    super.d(paramInt);
    dj.c(this.U, a(this.U, 8));
    dj.c(this.S, a(this.S, 8));
    if (paramInt % 180 == 0)
    {
      dj.b(this.Q, false);
      dj.b(this.R, false);
      dj.b(this.P, bool1);
      boolean bool4 = this.L.c();
      this.L = this.M;
      this.L.a(bool4);
      this.L.a(paramInt);
      com.viber.voip.camera.e.e.b(this.U, paramInt);
      Z();
      com.viber.voip.camera.e.e.b(this.S, paramInt);
      com.viber.voip.camera.e.e.c(this.S, paramInt);
      com.viber.voip.camera.e.e.b(this.T, paramInt);
      if (this.W != null)
        this.W.a(paramInt);
      return;
    }
    dj.b(this.P, false);
    View localView1 = this.Q;
    boolean bool2;
    label181: label200: boolean bool3;
    if (90 == paramInt)
    {
      bool2 = bool1;
      dj.b(localView1, bool2);
      View localView2 = this.R;
      if (270 != paramInt)
        break label251;
      dj.b(localView2, bool1);
      bool3 = this.L.c();
      if (90 != paramInt)
        break label256;
    }
    label256: for (com.viber.voip.camrecorder.b.a locala = this.N; ; locala = this.O)
    {
      this.L = locala;
      this.L.a(bool3);
      break;
      bool2 = false;
      break label181;
      label251: bool1 = false;
      break label200;
    }
  }

  protected int f()
  {
    return R.layout.activity_viber_camera_preview;
  }

  protected void h(int paramInt)
  {
    com.viber.voip.camera.e.e.b(this.q, paramInt);
  }

  protected void i(int paramInt)
  {
    com.viber.voip.camera.e.e.b(this.r, paramInt);
    com.viber.voip.camera.e.e.d(this.r, paramInt);
  }

  public void onBackPressed()
  {
    if (this.d.Z())
    {
      x();
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    if (!com.viber.common.d.a.g())
      ViberApplication.getInstance().logToCrashlytics("CustomCamTakeVideoActivity. onCreate");
    dj.a(getWindow(), false);
    dc.a(this);
    if (!this.I.a(com.viber.voip.permissions.n.b))
      this.I.a(this, 10, com.viber.voip.permissions.n.b);
    this.K = d.ad.a.c.d();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.W != null)
      this.W.b();
  }

  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.I.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
  }

  protected void onResume()
  {
    super.onResume();
    bp.a(this, this.K);
  }

  protected void onStart()
  {
    super.onStart();
    at.e(dv.i.a(this));
    this.I.a(this.Z);
  }

  protected void onStop()
  {
    super.onStop();
    this.I.b(this.Z);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.CustomCamTakeVideoActivity
 * JD-Core Version:    0.6.2
 */