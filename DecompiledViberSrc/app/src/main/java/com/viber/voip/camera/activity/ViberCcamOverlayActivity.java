package com.viber.voip.camera.activity;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.TimeAware.Clock;
import com.viber.svg.jni.clock.FiniteClock;
import com.viber.voip.camera.R.drawable;
import com.viber.voip.camera.R.id;
import com.viber.voip.camera.R.string;
import com.viber.voip.camera.a.a.h;
import com.viber.voip.camera.a.c;
import com.viber.voip.camera.c.b;
import com.viber.voip.camera.c.b.f;
import com.viber.voip.camera.e.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ViberCcamOverlayActivity extends ViberCcamActivity
  implements b.f
{
  private static final String G = com.viber.voip.camera.e.a.a(ViberCcamOverlayActivity.class);
  private static final long H = TimeUnit.SECONDS.toMicros(10L);
  protected boolean D = false;
  protected boolean E = false;
  protected int F = 0;
  private int I = 0;
  private final Rect J = new Rect();
  private float K;
  private int L;
  private int M;
  private int N;
  private float O;
  private float P;
  private int Q;
  private List<WeakReference<? extends View>> R;
  private Runnable S = new Runnable()
  {
    public void run()
    {
      if (!ViberCcamOverlayActivity.this.p.isPressed())
        return;
      ViberCcamOverlayActivity.a(ViberCcamOverlayActivity.this, 1);
      ViberCcamOverlayActivity.this.a(ViberCcamOverlayActivity.this.p, true, true);
    }
  };
  private final View.OnTouchListener T = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      int i = 1;
      if (!ViberCcamOverlayActivity.this.E);
      while (paramAnonymousMotionEvent.getPointerCount() > i)
        return false;
      ViberCcamOverlayActivity.b(ViberCcamOverlayActivity.this, paramAnonymousMotionEvent.getAction());
      ViberCcamOverlayActivity.a(ViberCcamOverlayActivity.this, paramAnonymousMotionEvent.getX());
      ViberCcamOverlayActivity.b(ViberCcamOverlayActivity.this, paramAnonymousMotionEvent.getY());
      label97: int j;
      if ((i == ViberCcamOverlayActivity.a(ViberCcamOverlayActivity.this)) || (3 == ViberCcamOverlayActivity.a(ViberCcamOverlayActivity.this)))
      {
        ViberCcamOverlayActivity.this.a.removeCallbacks(ViberCcamOverlayActivity.b(ViberCcamOverlayActivity.this));
        if ((i == ViberCcamOverlayActivity.a(ViberCcamOverlayActivity.this)) || (3 == ViberCcamOverlayActivity.a(ViberCcamOverlayActivity.this)))
          break label245;
        j = i;
        label122: if ((ViberCcamOverlayActivity.this.E()) && (!paramAnonymousView.isPressed()) && (ViberCcamOverlayActivity.a(ViberCcamOverlayActivity.this) != 0))
          break label251;
      }
      while (true)
      {
        boolean bool = j & i;
        ViberCcamOverlayActivity.this.a(paramAnonymousView, bool, false);
        if ((!ViberCcamOverlayActivity.this.F()) || (!ViberCcamOverlayActivity.this.d.Z()) || (!ViberCcamOverlayActivity.this.d.af()))
          break;
        ViberCcamOverlayActivity.c(ViberCcamOverlayActivity.this);
        return false;
        if (ViberCcamOverlayActivity.a(ViberCcamOverlayActivity.this) != 0)
          break label97;
        ViberCcamOverlayActivity.this.a.postDelayed(ViberCcamOverlayActivity.b(ViberCcamOverlayActivity.this), 300L);
        break label97;
        label245: j = 0;
        break label122;
        label251: i = 0;
      }
    }
  };
  private final Runnable U = new Runnable()
  {
    public void run()
    {
      if (2 == ViberCcamOverlayActivity.d(ViberCcamOverlayActivity.this))
      {
        if (!ViberCcamOverlayActivity.this.d.Y())
          ViberCcamOverlayActivity.this.w();
        ViberCcamOverlayActivity.this.a(ViberCcamOverlayActivity.this.p);
      }
      while (ViberCcamOverlayActivity.d(ViberCcamOverlayActivity.this) != 0)
        return;
      ViberCcamOverlayActivity.this.L();
    }
  };
  private final Runnable V = new Runnable()
  {
    public void run()
    {
      Iterator localIterator = ViberCcamOverlayActivity.e(ViberCcamOverlayActivity.this).iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)((WeakReference)localIterator.next()).get();
        e.a(localView, ViberCcamOverlayActivity.this.a(localView, 8));
      }
    }
  };
  private final Runnable W = new Runnable()
  {
    public void run()
    {
      Iterator localIterator = ViberCcamOverlayActivity.e(ViberCcamOverlayActivity.this).iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)((WeakReference)localIterator.next()).get();
        e.a(localView, ViberCcamOverlayActivity.this.a(localView, 0));
      }
    }
  };

  private void O()
  {
    this.o = a(R.id.about_app, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ViberCcamOverlayActivity.this.b(paramAnonymousView);
      }
    }
    , null);
  }

  private void P()
  {
    this.p = ((ImageView)a(R.id.take_photo, null, null, this.T));
    this.I = 0;
    C();
  }

  private void Q()
  {
    this.q = ((ImageView)a(R.id.switch_camera_side, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ViberCcamOverlayActivity.this.onSwitchCameraSide(paramAnonymousView);
      }
    }));
  }

  private void R()
  {
    this.r = a(R.id.switch_flash_mode, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ViberCcamOverlayActivity.this.onSwitchFlashMode(paramAnonymousView);
      }
    });
  }

  private void S()
  {
    this.p.getHitRect(this.J);
    boolean bool = this.P < 0.0F;
    float f = 0.0F;
    if (bool);
    while (true)
    {
      this.K = f;
      this.L = this.J.top;
      this.M = (this.L / 2 / this.d.ag());
      this.N = ((int)(this.K / this.M));
      this.d.a(this.N);
      return;
      f = -this.P;
    }
  }

  public boolean A()
  {
    AudioManager localAudioManager = (AudioManager)getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2) && (localAudioManager.getStreamVolume(2) > 0);
  }

  protected List<WeakReference<? extends View>> B()
  {
    ArrayList localArrayList = new ArrayList(5);
    localArrayList.add(new WeakReference(this.r));
    if (this.d.ad().a() > 1)
      localArrayList.add(new WeakReference(this.q));
    return localArrayList;
  }

  protected void C()
  {
    if ((this.p instanceof SvgImageView))
      ((SvgImageView)this.p).load("ic_btn_video_camera.svg", "", 0);
  }

  protected TimeAware.Clock D()
  {
    return new FiniteClock(H);
  }

  protected boolean E()
  {
    return true;
  }

  protected boolean F()
  {
    return false;
  }

  protected void G()
  {
    e.a(this.r, new Runnable()
    {
      public void run()
      {
        int i = (int)(0.5D + ViberCcamOverlayActivity.this.r.getRotation());
        e.c(ViberCcamOverlayActivity.this.r, i);
      }
    });
  }

  public void H()
  {
    K();
    a("focus_mode_continuous_video");
    if ((F()) && (this.d.af()))
      this.d.a(0);
    this.E = true;
  }

  public void I()
  {
    a(false);
  }

  public void J()
  {
    L();
  }

  protected final void K()
  {
    if ((this.d.Y()) && (!this.d.Z()))
    {
      L();
      this.I = 0;
      w();
    }
    while (this.d.Y())
      return;
    L();
    this.I = 0;
  }

  protected void L()
  {
    if ((this.p instanceof SvgImageView))
    {
      ((SvgImageView)this.p).setSvgEnabled(false);
      this.p.invalidate();
    }
  }

  public void M()
  {
    a(true);
  }

  public void N()
  {
    L();
    this.E = false;
  }

  protected int a(View paramView, int paramInt)
  {
    return paramInt;
  }

  public Pair<Integer, Integer> a(b paramb, List<a.h> paramList, List<String> paramList1)
  {
    return new com.viber.voip.camera.e.a.a.a().a(paramb, paramList, paramList1);
  }

  protected void a()
  {
    super.a();
    O();
    P();
    Q();
    R();
  }

  public void a(MotionEvent paramMotionEvent)
  {
  }

  protected void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.E);
    do
    {
      do
      {
        return;
        if ((paramBoolean1) && (1 == this.I))
        {
          this.I = 2;
          a(false);
          this.a.postDelayed(this.U, 200L);
          return;
        }
        if ((paramBoolean1) || (this.I == 0))
          break;
        this.I = 0;
        if (this.d.Z())
          a(paramView);
      }
      while (!this.d.Y());
      w();
      return;
    }
    while (paramBoolean1);
    if ((!paramBoolean2) && (e.a(this.O, this.P, this.p)))
    {
      a(paramView);
      return;
    }
    Log.i(G, "onTakeMediaButtonInteraction: skip photo action due to finger position");
  }

  protected void a(boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.p instanceof SvgImageView)))
    {
      ((SvgImageView)this.p).setSvgEnabled(true);
      ((SvgImageView)this.p).setClock(D());
    }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (!this.D))
      a("focus_mode_auto", false, false);
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
    return Pair.create(getString(R.string.flash_state_off), ContextCompat.getDrawable(this, R.drawable.ic_flash_off_selector));
    return Pair.create(getString(R.string.flash_state_on), ContextCompat.getDrawable(this, R.drawable.ic_flash_on_selector));
    return Pair.create(getString(R.string.flash_state_auto), ContextCompat.getDrawable(this, R.drawable.ic_flash_auto_selector));
  }

  protected void b(View paramView)
  {
  }

  public void b(boolean paramBoolean)
  {
    this.D = paramBoolean;
    if (!paramBoolean)
    {
      this.a.removeCallbacks(this.V);
      this.a.removeCallbacks(this.W);
      this.a.postDelayed(this.W, TimeUnit.SECONDS.toMillis(1L));
      return;
    }
    this.a.removeCallbacks(this.W);
    this.a.removeCallbacks(this.V);
    this.a.post(this.V);
  }

  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      this.E = true;
  }

  protected void d(int paramInt)
  {
    this.F = paramInt;
    e.b(this.o, paramInt);
    e.b(this.w, paramInt);
    e.b(this.v, paramInt);
    i(paramInt);
    h(paramInt);
    super.d(paramInt);
  }

  protected void h(int paramInt)
  {
    e.b(this.q, paramInt);
    e.d(this.q, paramInt);
  }

  protected void i(int paramInt)
  {
    e.b(this.r, paramInt);
    e.c(this.r, paramInt);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.R = B();
  }

  protected void onPause()
  {
    if (this.d.Z())
      a(this.p, false, true);
    this.E = false;
    super.onPause();
  }

  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a();
  }

  public void v()
  {
    super.v();
    G();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.activity.ViberCcamOverlayActivity
 * JD-Core Version:    0.6.2
 */