package com.viber.voip.camrecorder.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Pair;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.array;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.f;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.permissions.e;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.r;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.aq;
import com.viber.voip.util.cz;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;
import com.viber.voip.widget.SaveMediaView;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;

public abstract class f extends aq
  implements View.OnClickListener, l.a
{
  private static final Logger a = ViberEnv.getLogger();
  protected boolean b = false;
  protected boolean c = false;
  protected Uri d;
  protected Uri e;
  protected ViewGroup f;
  protected EditText g;
  protected DoodleActivity.a h = DoodleActivity.a.a;
  private a i;
  private boolean j;
  private View k;
  private View l;
  private SaveMediaView m;
  private ImageView n;
  private ObjectAnimator o;
  private ObjectAnimator p;
  private ObjectAnimator q;
  private ObjectAnimator r;
  private AnimatorSet s;
  private AnimatorSet t;
  private Runnable u;
  private l v;
  private b w;
  private boolean x;
  private com.viber.common.permission.c y;
  private com.viber.common.permission.b z;

  public f()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = m.a(116);
    arrayOfPair[1] = m.a(101);
    this.z = new e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 116:
        case 101:
        }
        do
        {
          return;
          f.a(f.this);
          return;
        }
        while (!(paramAnonymousObject instanceof Bundle));
        Bundle localBundle = (Bundle)paramAnonymousObject;
        f.a(f.this, localBundle.getBoolean("to_gallery"), (f.b)localBundle.getSerializable("time_bomb_state"));
      }
    };
  }

  private void a(Animator paramAnimator)
  {
    dj.b(this.l, true);
    paramAnimator.setDuration(220L).start();
  }

  private void a(Animator paramAnimator1, Animator paramAnimator2, Runnable paramRunnable, boolean paramBoolean)
  {
    int i1;
    if ((!paramAnimator2.isStarted()) || (paramAnimator2.isRunning()))
    {
      i1 = 1;
      if (paramAnimator2.isStarted())
        paramAnimator2.cancel();
      this.u = null;
      if (i1 == 0)
        break label88;
      this.u = paramRunnable;
      b();
      if (!paramBoolean)
        break label82;
      l1 = 80L;
      paramAnimator1.setStartDelay(l1);
      paramAnimator1.setDuration(220L);
      paramAnimator1.start();
    }
    label82: label88: 
    while (paramRunnable == null)
      while (true)
      {
        return;
        i1 = 0;
        break;
        long l1 = 0L;
      }
    paramRunnable.run();
  }

  private void a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    paramLayoutInflater.inflate(R.layout.activity_customcam_preview_screenshot_controls, this.f, true);
    this.k = this.f.findViewById(R.id.btn_send);
    this.k.setOnClickListener(this);
    this.l = this.k;
  }

  private void a(b paramb)
  {
    this.n.setImageResource(paramb.h);
  }

  private void a(boolean paramBoolean, b paramb)
  {
    if (this.y.a(n.m))
    {
      b(paramBoolean, paramb);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("to_gallery", paramBoolean);
    localBundle.putSerializable("time_bomb_state", paramb);
    this.y.a(this, 101, n.m, localBundle);
  }

  private void b(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    paramLayoutInflater.inflate(R.layout.activity_customcam_preview_bottom_panel, this.f, true);
    this.k = this.f.findViewById(R.id.btn_send);
    this.k.setOnClickListener(this);
    this.g = ((EditText)this.f.findViewById(R.id.custom_cam_preview_media_description));
    this.g.setHorizontallyScrolling(false);
    this.g.setMaxLines(4);
    cz localcz = new cz(this.g, getResources().getInteger(R.integer.media_description_lines_limit));
    this.g.addTextChangedListener(localcz);
    this.g.setOnKeyListener(localcz);
    e();
    this.l = this.f.findViewById(R.id.custom_cam_preview_description_container);
    this.m = ((SaveMediaView)this.f.findViewById(R.id.btn_save_media));
    this.m.setOnClickListener(this);
    b(false);
    this.n = ((ImageView)this.f.findViewById(R.id.btn_time_bomb));
    if ((this.x) && (!ao.f()))
    {
      dj.b(this.n, true);
      this.n.setOnClickListener(this);
      a(this.w);
      this.v = new l(getContext(), this, R.array.bomb_picker_values, R.array.bomb_picker_values_int, R.array.bomb_picker_units, b.a.i, getLayoutInflater());
      return;
    }
    dj.b(this.n, false);
  }

  private void b(boolean paramBoolean)
  {
    if (this.b)
    {
      this.m.setEnabled(false);
      this.m.b(paramBoolean);
      return;
    }
    this.m.setEnabled(true);
    this.m.a(paramBoolean);
  }

  private void b(boolean paramBoolean, b paramb)
  {
    if (this.b);
    label157: label167: 
    while (true)
    {
      return;
      boolean bool1 = h();
      Uri localUri2;
      if (this.h.equals(DoodleActivity.a.b))
      {
        localUri2 = a(this.d);
        boolean bool3 = false;
        if (localUri2 != null)
          bool3 = true;
        this.b = bool3;
        if (!this.b)
          break label157;
        this.c = paramBoolean;
        this.e = localUri2;
        if (paramBoolean)
        {
          b(true);
          if (bool1)
          {
            this.j = true;
            this.d = localUri2;
          }
        }
      }
      for (String str = getString(R.string.custom_cam_media_saved_to_gallery); ; str = getString(R.string.custom_cam_media_cannot_save_to_gallery))
      {
        if (!paramBoolean)
          break label167;
        ViberApplication.getInstance().showToast(str);
        i();
        return;
        Uri localUri1 = this.d;
        if (paramb != b.a);
        for (boolean bool2 = true; ; bool2 = false)
        {
          localUri2 = a(localUri1, bool2, paramBoolean);
          break;
        }
      }
    }
  }

  private void e()
  {
    final GestureDetectorCompat localGestureDetectorCompat = new GestureDetectorCompat(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return true;
      }
    });
    this.g.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return localGestureDetectorCompat.onTouchEvent(paramAnonymousMotionEvent);
      }
    });
  }

  private void p()
  {
    this.q = ObjectAnimator.ofFloat(this.l, "alpha", new float[] { 0.0F, 1.0F });
    this.q.setDuration(220L);
    this.q.addListener(new a()
    {
      public void a(Animator paramAnonymousAnimator)
      {
        dj.b(f.b(f.this), true);
      }

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        f.b(f.this).setAlpha(1.0F);
      }
    });
    this.o = ObjectAnimator.ofFloat(this.i.b(), "alpha", new float[] { 0.0F, 1.0F });
    this.o.setDuration(220L);
    this.o.addListener(new a()
    {
      public void a(Animator paramAnonymousAnimator)
      {
        dj.b(f.c(f.this).b(), true);
      }

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        f.c(f.this).b().setAlpha(1.0F);
      }
    });
    this.s = new AnimatorSet();
    this.s.playTogether(c());
    this.s.setDuration(220L);
    this.s.addListener(new a()
    {
      public void a(Animator paramAnonymousAnimator)
      {
        f.d(f.this);
      }
    });
    this.r = ObjectAnimator.ofFloat(this.l, "alpha", new float[] { 1.0F, 0.0F });
    this.r.setDuration(220L);
    this.r.addListener(new a()
    {
      public void a(Animator paramAnonymousAnimator)
      {
        dj.b(f.b(f.this), false);
      }

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        f.b(f.this).setAlpha(1.0F);
      }
    });
    this.p = ObjectAnimator.ofFloat(this.i.b(), "alpha", new float[] { 1.0F, 0.0F });
    this.p.setDuration(220L);
    this.p.addListener(new a()
    {
      public void a(Animator paramAnonymousAnimator)
      {
        dj.b(f.c(f.this).b(), false);
      }

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        f.c(f.this).b().setAlpha(1.0F);
      }
    });
    this.t = new AnimatorSet();
    this.t.playTogether(d());
    this.t.setDuration(220L);
    this.t.addListener(new a()
    {
      public void a(Animator paramAnonymousAnimator)
      {
        f.d(f.this);
      }
    });
  }

  private void q()
  {
    if (this.u != null)
    {
      this.u.run();
      this.u = null;
    }
  }

  private void r()
  {
    if (this.b);
    String str;
    do
    {
      return;
      str = getArguments().getString("com.viber.voip.custom_cam_media_preview_file_path");
    }
    while (str == null);
    new File(str).getAbsoluteFile().delete();
  }

  private void s()
  {
    if (f() == 3)
    {
      if (this.w == b.a);
      for (b localb = b.g; ; localb = b.a)
      {
        this.w = localb;
        a(this.w);
        return;
      }
    }
    this.v.a(this.f);
  }

  private void t()
  {
    if (this.y.a(n.m))
    {
      u();
      return;
    }
    this.y.a(this, 116, n.m);
  }

  private void u()
  {
    if (this.g != null);
    for (String str1 = this.g.getText().toString(); this.d == null; str1 = "")
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
        localFragmentActivity.onBackPressed();
      return;
    }
    DoodleDataContainer localDoodleDataContainer = a();
    b(false, this.w);
    if (this.e != null)
      this.d = this.e;
    b(this.w.i);
    if (this.w != b.a)
    {
      d.r.k.a(false);
      if (com.viber.voip.messages.l.f(f()));
      for (String str2 = "image/*"; ; str2 = "video/*")
      {
        this.i.a(this.d, f(), str1, WinkDescription.from(this.w.i, str2), localDoodleDataContainer);
        return;
      }
    }
    this.i.a(this.d, f(), str1, null, localDoodleDataContainer);
  }

  protected abstract Bitmap a(Context paramContext);

  protected abstract Uri a(Uri paramUri);

  protected abstract Uri a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2);

  protected abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle);

  protected DoodleDataContainer a()
  {
    boolean bool1 = true;
    com.viber.voip.ui.doodle.scene.c localc = j();
    DoodleDataContainer localDoodleDataContainer = null;
    boolean bool2;
    long l1;
    boolean bool3;
    label49: int i1;
    boolean bool4;
    int i2;
    int i3;
    if (localc != null)
    {
      if (localc.a() <= 0)
        break label123;
      bool2 = bool1;
      l1 = localc.d() + localc.e() + localc.f();
      if (localc.c() <= 0)
        break label129;
      bool3 = bool1;
      i1 = this.w.i;
      bool4 = this.c;
      i2 = localc.b();
      i3 = localc.g();
      if (i.a().a(getActivity().getClass().getName()) <= 0)
        break label135;
    }
    while (true)
    {
      localDoodleDataContainer = new DoodleDataContainer(bool2, l1, bool3, i1, bool4, i2, i3, "None", bool1);
      return localDoodleDataContainer;
      label123: bool2 = false;
      break;
      label129: bool3 = false;
      break label49;
      label135: bool1 = false;
    }
  }

  protected abstract void a(Bitmap paramBitmap);

  void a(Uri paramUri, String paramString, boolean paramBoolean1, boolean paramBoolean2, DoodleActivity.a parama)
  {
    Bundle localBundle = new Bundle(4);
    localBundle.putParcelable("com.viber.voip.current_file_url", paramUri);
    localBundle.putString("com.viber.voip.custom_cam_media_preview_file_path", paramString);
    localBundle.putBoolean("com.viber.voip.show_time_bomb", paramBoolean1);
    localBundle.putBoolean("com.viber.voip.custom_cam_media_preview_from_camera", paramBoolean2);
    localBundle.putInt("com.viber.voip.custom_cam_media_preview_view_mode", parama.ordinal());
    setArguments(localBundle);
  }

  protected void a(boolean paramBoolean)
  {
    EditText localEditText = this.g;
    if (paramBoolean);
    for (int i1 = 0; ; i1 = 4)
    {
      dj.c(localEditText, i1);
      return;
    }
  }

  protected void a(boolean paramBoolean, Runnable paramRunnable)
  {
    a(this.s, this.t, paramRunnable, paramBoolean);
  }

  protected void b()
  {
    dj.b(this.l, true);
    dj.b(this.i.b(), true);
  }

  protected abstract void b(int paramInt);

  protected void b(boolean paramBoolean, Runnable paramRunnable)
  {
    a(this.t, this.s, paramRunnable, paramBoolean);
  }

  public void c(int paramInt)
  {
    this.w = b.a(paramInt);
    a(this.w);
  }

  protected Animator[] c()
  {
    Animator[] arrayOfAnimator = new Animator[2];
    arrayOfAnimator[0] = this.q;
    arrayOfAnimator[1] = this.o;
    return arrayOfAnimator;
  }

  protected Animator[] d()
  {
    Animator[] arrayOfAnimator = new Animator[2];
    arrayOfAnimator[0] = this.r;
    arrayOfAnimator[1] = this.p;
    return arrayOfAnimator;
  }

  protected abstract int f();

  protected boolean g()
  {
    if (h())
      return this.j;
    if (this.d != null)
      return dv.a(this.d.getEncodedPath(), dv.g, getActivity());
    return false;
  }

  protected boolean h()
  {
    return true;
  }

  protected void i()
  {
  }

  protected abstract com.viber.voip.ui.doodle.scene.c j();

  protected void k()
  {
    av.f.b.execute(new g(this));
  }

  protected void l()
  {
    boolean bool = g();
    if ((this.b) && (this.e != null))
      this.e = this.d;
    if (this.b != bool)
    {
      this.b = bool;
      if (this.h.equals(DoodleActivity.a.a))
        b(true);
    }
  }

  protected void m()
  {
    a(this.q);
  }

  protected void n()
  {
    a(this.r);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    k();
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.i = ((a)paramActivity);
  }

  public boolean onBackPressed()
  {
    if ((this.v != null) && (this.v.b()))
    {
      this.v.a();
      return true;
    }
    r();
    return false;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.k)
      t();
    do
    {
      return;
      if (paramView == this.m)
      {
        a(true, b.a);
        return;
      }
    }
    while (paramView != this.n);
    s();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    this.y = com.viber.common.permission.c.a(getActivity());
    if (paramBundle != null)
    {
      this.d = ((Uri)paramBundle.getParcelable("com.viber.voip.current_file_url"));
      this.e = ((Uri)paramBundle.getParcelable("com.viber.voip.latest_saved_file_url"));
      this.b = paramBundle.getBoolean("com.viber.voip.is_media_saved", false);
      this.c = paramBundle.getBoolean("com.viber.voip.is_save_btn_clicked", false);
      this.j = paramBundle.getBoolean("com.viber.voip.is_original_media_saved", false);
      this.w = ((b)paramBundle.getSerializable("com.viber.voip.time_bomb_state"));
      this.x = paramBundle.getBoolean("com.viber.voip.show_time_bomb");
      this.h = DoodleActivity.a.values()[paramBundle.getInt("com.viber.voip.view_mode", DoodleActivity.a.a.ordinal())];
      return;
    }
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.h = DoodleActivity.a.values()[localBundle.getInt("com.viber.voip.custom_cam_media_preview_view_mode", DoodleActivity.a.a.ordinal())];
      this.d = ((Uri)localBundle.getParcelable("com.viber.voip.current_file_url"));
      this.x = localBundle.getBoolean("com.viber.voip.show_time_bomb");
      localBundle.getString("com.viber.voip.custom_cam_media_preview_file_path");
      if ((!dv.a(this.d, dv.j)) && (!dv.a(this.d, dv.k)))
        break label261;
      this.b = true;
      this.j = true;
      this.e = this.d;
    }
    while (true)
    {
      this.w = b.a;
      return;
      this.h = DoodleActivity.a.a;
      break;
      label261: if (!dv.a(this.d, dv.g, getActivity()))
      {
        this.b = true;
        this.j = true;
        this.e = this.d;
      }
      else if (this.h.equals(DoodleActivity.a.b))
      {
        this.j = true;
        this.b = true;
      }
    }
  }

  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.f = ((ViewGroup)a(paramLayoutInflater, paramViewGroup, paramBundle));
    switch (2.a[this.h.ordinal()])
    {
    default:
      b(paramLayoutInflater, paramBundle);
    case 1:
    }
    while (true)
    {
      p();
      return this.f;
      a(paramLayoutInflater, paramBundle);
    }
  }

  public void onDestroyView()
  {
    this.s.cancel();
    this.t.cancel();
    super.onDestroyView();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("com.viber.voip.current_file_url", this.d);
    paramBundle.putParcelable("com.viber.voip.latest_saved_file_url", this.e);
    paramBundle.putBoolean("com.viber.voip.is_media_saved", this.b);
    paramBundle.putBoolean("com.viber.voip.is_save_btn_clicked", this.c);
    paramBundle.putBoolean("com.viber.voip.is_original_media_saved", this.j);
    paramBundle.putSerializable("com.viber.voip.time_bomb_state", this.w);
    paramBundle.putBoolean("com.viber.voip.show_time_bomb", this.x);
    paramBundle.putInt("com.viber.voip.view_mode", this.h.ordinal());
    super.onSaveInstanceState(paramBundle);
  }

  public void onStart()
  {
    super.onStart();
    this.y.a(this.z);
  }

  public void onStop()
  {
    super.onStop();
    this.y.b(this.z);
  }

  static abstract interface a
  {
    public abstract void a(Uri paramUri, int paramInt, String paramString, WinkDescription paramWinkDescription, DoodleDataContainer paramDoodleDataContainer);

    public abstract View b();
  }

  private static enum b
  {
    final int h;
    final int i;

    static
    {
      b[] arrayOfb = new b[7];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
    }

    private b(int paramInt1, int paramInt2)
    {
      this.h = paramInt2;
      this.i = paramInt1;
    }

    public static b a(int paramInt)
    {
      for (b localb : values())
        if (localb.i == paramInt)
          return localb;
      return a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.f
 * JD-Core Version:    0.6.2
 */