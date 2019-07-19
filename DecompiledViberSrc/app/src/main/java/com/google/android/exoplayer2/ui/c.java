package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.aa.a;
import com.google.android.exoplayer2.ab;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.ak.a;
import com.google.android.exoplayer2.ak.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.v;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.y;
import com.google.android.exoplayer2.z;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

public class c extends FrameLayout
{
  private b A;
  private z B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private int G;
  private int H;
  private int I;
  private int J;
  private boolean K;
  private long L;
  private long[] M;
  private boolean[] N;
  private long[] O;
  private boolean[] P;
  private final a a;
  private final View b;
  private final View c;
  private final View d;
  private final View e;
  private final View f;
  private final View g;
  private final ImageView h;
  private final View i;
  private final TextView j;
  private final TextView k;
  private final g l;
  private final StringBuilder m;
  private final Formatter n;
  private final ak.a o;
  private final ak.b p;
  private final Runnable q;
  private final Runnable r;
  private final Drawable s;
  private final Drawable t;
  private final Drawable u;
  private final String v;
  private final String w;
  private final String x;
  private aa y;
  private com.google.android.exoplayer2.d z;

  static
  {
    o.a("goog.exo.ui");
  }

  public c(Context paramContext, AttributeSet paramAttributeSet1, int paramInt, AttributeSet paramAttributeSet2)
  {
    super(paramContext, paramAttributeSet1, paramInt);
    int i1 = R.layout.exo_player_control_view;
    this.G = 5000;
    this.H = 15000;
    this.I = 5000;
    this.J = 0;
    this.L = -9223372036854775807L;
    this.K = false;
    TypedArray localTypedArray;
    if (paramAttributeSet2 != null)
      localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet2, R.styleable.PlayerControlView, 0, 0);
    try
    {
      this.G = localTypedArray.getInt(R.styleable.PlayerControlView_rewind_increment, this.G);
      this.H = localTypedArray.getInt(R.styleable.PlayerControlView_fastforward_increment, this.H);
      this.I = localTypedArray.getInt(R.styleable.PlayerControlView_show_timeout, this.I);
      i1 = localTypedArray.getResourceId(R.styleable.PlayerControlView_controller_layout_id, i1);
      this.J = a(localTypedArray, this.J);
      this.K = localTypedArray.getBoolean(R.styleable.PlayerControlView_show_shuffle_button, this.K);
      localTypedArray.recycle();
      this.o = new ak.a();
      this.p = new ak.b();
      this.m = new StringBuilder();
      this.n = new Formatter(this.m, Locale.getDefault());
      this.M = new long[0];
      this.N = new boolean[0];
      this.O = new long[0];
      this.P = new boolean[0];
      this.a = new a(null);
      this.z = new com.google.android.exoplayer2.e();
      this.q = new d(this);
      this.r = new e(this);
      LayoutInflater.from(paramContext).inflate(i1, this);
      setDescendantFocusability(262144);
      this.j = ((TextView)findViewById(R.id.exo_duration));
      this.k = ((TextView)findViewById(R.id.exo_position));
      this.l = ((g)findViewById(R.id.exo_progress));
      if (this.l != null)
        this.l.a(this.a);
      this.d = findViewById(R.id.exo_play);
      if (this.d != null)
        this.d.setOnClickListener(this.a);
      this.e = findViewById(R.id.exo_pause);
      if (this.e != null)
        this.e.setOnClickListener(this.a);
      this.b = findViewById(R.id.exo_prev);
      if (this.b != null)
        this.b.setOnClickListener(this.a);
      this.c = findViewById(R.id.exo_next);
      if (this.c != null)
        this.c.setOnClickListener(this.a);
      this.g = findViewById(R.id.exo_rew);
      if (this.g != null)
        this.g.setOnClickListener(this.a);
      this.f = findViewById(R.id.exo_ffwd);
      if (this.f != null)
        this.f.setOnClickListener(this.a);
      this.h = ((ImageView)findViewById(R.id.exo_repeat_toggle));
      if (this.h != null)
        this.h.setOnClickListener(this.a);
      this.i = findViewById(R.id.exo_shuffle);
      if (this.i != null)
        this.i.setOnClickListener(this.a);
      Resources localResources = paramContext.getResources();
      this.s = localResources.getDrawable(R.drawable.exo_controls_repeat_off);
      this.t = localResources.getDrawable(R.drawable.exo_controls_repeat_one);
      this.u = localResources.getDrawable(R.drawable.exo_controls_repeat_all);
      this.v = localResources.getString(R.string.exo_controls_repeat_off_description);
      this.w = localResources.getString(R.string.exo_controls_repeat_one_description);
      this.x = localResources.getString(R.string.exo_controls_repeat_all_description);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private static int a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getInt(R.styleable.PlayerControlView_repeat_toggle_modes, paramInt);
  }

  private void a(int paramInt, long paramLong)
  {
    if (!this.z.a(this.y, paramInt, paramLong))
      l();
  }

  private void a(long paramLong)
  {
    a(this.y.r(), paramLong);
  }

  private void a(boolean paramBoolean, View paramView)
  {
    if (paramView == null)
      return;
    paramView.setEnabled(paramBoolean);
    if (paramBoolean);
    for (float f1 = 1.0F; ; f1 = 0.3F)
    {
      paramView.setAlpha(f1);
      paramView.setVisibility(0);
      return;
    }
  }

  @SuppressLint({"InlinedApi"})
  private static boolean a(int paramInt)
  {
    return (paramInt == 90) || (paramInt == 89) || (paramInt == 85) || (paramInt == 126) || (paramInt == 127) || (paramInt == 87) || (paramInt == 88);
  }

  private static boolean a(ak paramak, ak.b paramb)
  {
    if (paramak.b() > 100)
      return false;
    int i1 = paramak.b();
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        break label45;
      if (paramak.a(i2, paramb).i == -9223372036854775807L)
        break;
    }
    label45: return true;
  }

  private void b(long paramLong)
  {
    ak localak = this.y.C();
    int i2;
    int i1;
    long l1;
    if ((this.E) && (!localak.a()))
    {
      i2 = localak.b();
      i1 = 0;
      l1 = localak.a(i1, this.p).c();
      if (paramLong >= l1);
    }
    while (true)
    {
      a(i1, paramLong);
      return;
      if (i1 == i2 - 1)
      {
        paramLong = l1;
      }
      else
      {
        paramLong -= l1;
        i1++;
        break;
        i1 = this.y.r();
      }
    }
  }

  private void e()
  {
    removeCallbacks(this.r);
    if (this.I > 0)
    {
      this.L = (SystemClock.uptimeMillis() + this.I);
      if (this.C)
        postDelayed(this.r, this.I);
      return;
    }
    this.L = -9223372036854775807L;
  }

  private void f()
  {
    g();
    h();
    i();
    j();
    l();
  }

  private void g()
  {
    int i1 = 8;
    int i2 = 1;
    if ((!c()) || (!this.C))
      return;
    boolean bool = r();
    int i4;
    label49: int i5;
    int i6;
    if (this.d != null)
      if ((bool) && (this.d.isFocused()))
      {
        i4 = i2;
        i5 = 0x0 | i4;
        View localView2 = this.d;
        if (!bool)
          break label138;
        i6 = i1;
        label68: localView2.setVisibility(i6);
      }
    for (int i3 = i5; ; i3 = 0)
    {
      label100: View localView1;
      if (this.e != null)
      {
        if ((bool) || (!this.e.isFocused()))
          break label144;
        i3 |= i2;
        localView1 = this.e;
        if (bool)
          break label149;
      }
      while (true)
      {
        localView1.setVisibility(i1);
        if (i3 == 0)
          break;
        m();
        return;
        i4 = 0;
        break label49;
        label138: i6 = 0;
        break label68;
        label144: i2 = 0;
        break label100;
        label149: i1 = 0;
      }
    }
  }

  private void h()
  {
    boolean bool1 = true;
    if ((!c()) || (!this.C))
      return;
    ak localak;
    label34: boolean bool2;
    label47: boolean bool5;
    boolean bool3;
    label120: boolean bool4;
    if (this.y != null)
    {
      localak = this.y.C();
      if ((localak == null) || (localak.a()))
        break label235;
      bool2 = bool1;
      if ((!bool2) || (this.y.v()))
        break label263;
      localak.a(this.y.r(), this.p);
      bool5 = this.p.d;
      if ((!bool5) && (this.p.e) && (!this.y.a()))
        break label240;
      bool3 = bool1;
      if ((!this.p.e) && (!this.y.b()))
        break label246;
      bool4 = bool1;
    }
    while (true)
    {
      label145: a(bool3, this.b);
      a(bool4, this.c);
      boolean bool6;
      if ((this.H > 0) && (bool5))
      {
        bool6 = bool1;
        label180: a(bool6, this.f);
        if ((this.G <= 0) || (!bool5))
          break label258;
      }
      while (true)
      {
        a(bool1, this.g);
        if (this.l == null)
          break;
        this.l.setEnabled(bool5);
        return;
        localak = null;
        break label34;
        label235: bool2 = false;
        break label47;
        label240: bool3 = false;
        break label120;
        label246: bool4 = false;
        break label145;
        bool6 = false;
        break label180;
        label258: bool1 = false;
      }
      label263: bool3 = false;
      bool4 = false;
      bool5 = false;
    }
  }

  private void i()
  {
    if ((!c()) || (!this.C) || (this.h == null))
      return;
    if (this.J == 0)
    {
      this.h.setVisibility(8);
      return;
    }
    if (this.y == null)
    {
      a(false, this.h);
      return;
    }
    a(true, this.h);
    switch (this.y.m())
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      this.h.setVisibility(0);
      return;
      this.h.setImageDrawable(this.s);
      this.h.setContentDescription(this.v);
      continue;
      this.h.setImageDrawable(this.t);
      this.h.setContentDescription(this.w);
      continue;
      this.h.setImageDrawable(this.u);
      this.h.setContentDescription(this.x);
    }
  }

  private void j()
  {
    if ((!c()) || (!this.C) || (this.i == null))
      return;
    if (!this.K)
    {
      this.i.setVisibility(8);
      return;
    }
    if (this.y == null)
    {
      a(false, this.i);
      return;
    }
    View localView = this.i;
    if (this.y.n());
    for (float f1 = 1.0F; ; f1 = 0.3F)
    {
      localView.setAlpha(f1);
      this.i.setEnabled(true);
      this.i.setVisibility(0);
      return;
    }
  }

  private void k()
  {
    if (this.y == null)
      return;
    if ((this.D) && (a(this.y.C(), this.p)));
    for (boolean bool = true; ; bool = false)
    {
      this.E = bool;
      return;
    }
  }

  private void l()
  {
    if ((!c()) || (!this.C))
      return;
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    int i2;
    ak localak;
    int i5;
    int i6;
    label72: int i7;
    label88: int i8;
    long l10;
    long l7;
    label98: boolean bool;
    label155: long l6;
    if (this.y != null)
    {
      i2 = 0;
      localak = this.y.C();
      if (localak.a())
        break label884;
      i5 = this.y.r();
      if (!this.E)
        break label500;
      i6 = 0;
      if (!this.E)
        break label507;
      i7 = -1 + localak.b();
      i8 = i6;
      l10 = 0L;
      l7 = 0L;
      if (i8 > i7)
        break label877;
      if (i8 == i5)
        l7 = com.google.android.exoplayer2.c.a(l10);
      localak.a(i8, this.p);
      if (this.p.i != -9223372036854775807L)
        break label520;
      if (this.E)
        break label514;
      bool = true;
      a.b(bool);
      l6 = l10;
    }
    while (true)
    {
      l3 = com.google.android.exoplayer2.c.a(l6);
      long l8 = l7 + this.y.y();
      long l9 = l7 + this.y.z();
      if (this.l != null)
      {
        int i3 = this.O.length;
        int i4 = i2 + i3;
        if (i4 > this.M.length)
        {
          this.M = Arrays.copyOf(this.M, i4);
          this.N = Arrays.copyOf(this.N, i4);
        }
        System.arraycopy(this.O, 0, this.M, i2, i3);
        System.arraycopy(this.P, 0, this.N, i2, i3);
        this.l.a(this.M, this.N, i4);
      }
      l2 = l9;
      l1 = l8;
      if (this.j != null)
        this.j.setText(ag.a(this.m, this.n, l3));
      if ((this.k != null) && (!this.F))
        this.k.setText(ag.a(this.m, this.n, l1));
      if (this.l != null)
      {
        this.l.setPosition(l1);
        this.l.setBufferedPosition(l2);
        this.l.setDuration(l3);
      }
      removeCallbacks(this.q);
      int i1;
      label430: float f1;
      long l4;
      if (this.y == null)
      {
        i1 = 1;
        if ((i1 == 1) || (i1 == 4))
          break label785;
        if ((!this.y.l()) || (i1 != 3))
          break label869;
        f1 = this.y.o().b;
        if (f1 > 0.1F)
          break label787;
        l4 = 1000L;
      }
      while (true)
      {
        postDelayed(this.q, l4);
        return;
        label500: i6 = i5;
        break label72;
        label507: i7 = i5;
        break label88;
        label514: bool = false;
        break label155;
        label520: for (int i9 = this.p.f; i9 <= this.p.g; i9++)
        {
          localak.a(i9, this.o);
          int i10 = this.o.d();
          int i11 = 0;
          if (i11 < i10)
          {
            long l11 = this.o.a(i11);
            if (l11 == -9223372036854775808L)
              if (this.o.d != -9223372036854775807L);
            long l12;
            do
            {
              i11++;
              break;
              l11 = this.o.d;
              l12 = l11 + this.o.c();
            }
            while ((l12 < 0L) || (l12 > this.p.i));
            if (i2 == this.M.length)
              if (this.M.length != 0)
                break label737;
            label737: for (int i12 = 1; ; i12 = 2 * this.M.length)
            {
              this.M = Arrays.copyOf(this.M, i12);
              this.N = Arrays.copyOf(this.N, i12);
              this.M[i2] = com.google.android.exoplayer2.c.a(l12 + l10);
              this.N[i2] = this.o.c(i11);
              i2++;
              break;
            }
          }
        }
        l10 += this.p.i;
        i8++;
        break label98;
        i1 = this.y.j();
        break label430;
        label785: break;
        label787: if (f1 <= 5.0F)
        {
          long l5 = 1000 / Math.max(1, Math.round(1.0F / f1));
          l4 = l5 - l1 % l5;
          if (l4 < l5 / 5L)
            l4 += l5;
          if (f1 != 1.0F)
            l4 = ()((float)l4 / f1);
        }
        else
        {
          l4 = 200L;
          continue;
          label869: l4 = 1000L;
        }
      }
      label877: l6 = l10;
      continue;
      label884: l6 = 0L;
      l7 = 0L;
      i2 = 0;
    }
  }

  private void m()
  {
    boolean bool = r();
    if ((!bool) && (this.d != null))
      this.d.requestFocus();
    while ((!bool) || (this.e == null))
      return;
    this.e.requestFocus();
  }

  private void n()
  {
    ak localak = this.y.C();
    if ((localak.a()) || (this.y.v()))
      return;
    localak.a(this.y.r(), this.p);
    int i1 = this.y.e();
    if ((i1 != -1) && ((this.y.t() <= 3000L) || ((this.p.e) && (!this.p.d))))
    {
      a(i1, -9223372036854775807L);
      return;
    }
    a(0L);
  }

  private void o()
  {
    ak localak = this.y.C();
    if ((localak.a()) || (this.y.v()));
    int i1;
    do
    {
      return;
      i1 = this.y.r();
      int i2 = this.y.d();
      if (i2 != -1)
      {
        a(i2, -9223372036854775807L);
        return;
      }
    }
    while (!localak.a(i1, this.p).e);
    a(i1, -9223372036854775807L);
  }

  private void p()
  {
    if (this.G <= 0)
      return;
    a(Math.max(this.y.t() - this.G, 0L));
  }

  private void q()
  {
    if (this.H <= 0)
      return;
    long l1 = this.y.s();
    long l2 = this.y.t() + this.H;
    if (l1 != -9223372036854775807L)
      l2 = Math.min(l2, l1);
    a(l2);
  }

  private boolean r()
  {
    return (this.y != null) && (this.y.j() != 4) && (this.y.j() != 1) && (this.y.l());
  }

  public void a()
  {
    if (!c())
    {
      setVisibility(0);
      if (this.A != null)
        this.A.a(getVisibility());
      f();
      m();
    }
    e();
  }

  public boolean a(KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    int i1 = paramKeyEvent.getKeyCode();
    if ((this.y == null) || (!a(i1)))
      bool1 = false;
    do
    {
      do
        return bool1;
      while (paramKeyEvent.getAction() != 0);
      if (i1 == 90)
      {
        q();
        return bool1;
      }
      if (i1 == 89)
      {
        p();
        return bool1;
      }
    }
    while (paramKeyEvent.getRepeatCount() != 0);
    switch (i1)
    {
    default:
      return bool1;
    case 85:
      com.google.android.exoplayer2.d locald = this.z;
      aa localaa = this.y;
      boolean bool2 = this.y.l();
      boolean bool3 = false;
      if (!bool2)
        bool3 = bool1;
      locald.a(localaa, bool3);
      return bool1;
    case 126:
      this.z.a(this.y, bool1);
      return bool1;
    case 127:
      this.z.a(this.y, false);
      return bool1;
    case 87:
      o();
      return bool1;
    case 88:
    }
    n();
    return bool1;
  }

  public void b()
  {
    if (c())
    {
      setVisibility(8);
      if (this.A != null)
        this.A.a(getVisibility());
      removeCallbacks(this.q);
      removeCallbacks(this.r);
      this.L = -9223372036854775807L;
    }
  }

  public boolean c()
  {
    return getVisibility() == 0;
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }

  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
      removeCallbacks(this.r);
    while (true)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 1)
        e();
    }
  }

  public aa getPlayer()
  {
    return this.y;
  }

  public int getRepeatToggleModes()
  {
    return this.J;
  }

  public boolean getShowShuffleButton()
  {
    return this.K;
  }

  public int getShowTimeoutMs()
  {
    return this.I;
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.C = true;
    long l1;
    if (this.L != -9223372036854775807L)
    {
      l1 = this.L - SystemClock.uptimeMillis();
      if (l1 <= 0L)
        b();
    }
    while (true)
    {
      f();
      return;
      postDelayed(this.r, l1);
      continue;
      if (c())
        e();
    }
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.C = false;
    removeCallbacks(this.q);
    removeCallbacks(this.r);
  }

  public void setControlDispatcher(com.google.android.exoplayer2.d paramd)
  {
    if (paramd == null)
      paramd = new com.google.android.exoplayer2.e();
    this.z = paramd;
  }

  public void setFastForwardIncrementMs(int paramInt)
  {
    this.H = paramInt;
    h();
  }

  public void setPlaybackPreparer(z paramz)
  {
    this.B = paramz;
  }

  public void setPlayer(aa paramaa)
  {
    if (Looper.myLooper() == Looper.getMainLooper());
    for (boolean bool1 = true; ; bool1 = false)
    {
      a.b(bool1);
      boolean bool2;
      if (paramaa != null)
      {
        Looper localLooper1 = paramaa.i();
        Looper localLooper2 = Looper.getMainLooper();
        bool2 = false;
        if (localLooper1 != localLooper2);
      }
      else
      {
        bool2 = true;
      }
      a.a(bool2);
      if (this.y != paramaa)
        break;
      return;
    }
    if (this.y != null)
      this.y.b(this.a);
    this.y = paramaa;
    if (paramaa != null)
      paramaa.a(this.a);
    f();
  }

  public void setRepeatToggleModes(int paramInt)
  {
    this.J = paramInt;
    int i1;
    if (this.y != null)
    {
      i1 = this.y.m();
      if ((paramInt != 0) || (i1 == 0))
        break label50;
      this.z.a(this.y, 0);
    }
    while (true)
    {
      i();
      return;
      label50: if ((paramInt == 1) && (i1 == 2))
        this.z.a(this.y, 1);
      else if ((paramInt == 2) && (i1 == 1))
        this.z.a(this.y, 2);
    }
  }

  public void setRewindIncrementMs(int paramInt)
  {
    this.G = paramInt;
    h();
  }

  public void setShowMultiWindowTimeBar(boolean paramBoolean)
  {
    this.D = paramBoolean;
    k();
  }

  public void setShowShuffleButton(boolean paramBoolean)
  {
    this.K = paramBoolean;
    j();
  }

  public void setShowTimeoutMs(int paramInt)
  {
    this.I = paramInt;
    if (c())
      e();
  }

  public void setVisibilityListener(b paramb)
  {
    this.A = paramb;
  }

  private final class a
    implements View.OnClickListener, aa.a, g.a
  {
    private a()
    {
    }

    public void a(g paramg, long paramLong)
    {
      c.a(c.this, true);
    }

    public void a(g paramg, long paramLong, boolean paramBoolean)
    {
      c.a(c.this, false);
      if ((!paramBoolean) && (c.d(c.this) != null))
        c.a(c.this, paramLong);
    }

    public void b(g paramg, long paramLong)
    {
      if (c.a(c.this) != null)
        c.a(c.this).setText(ag.a(c.b(c.this), c.c(c.this), paramLong));
    }

    public void onClick(View paramView)
    {
      int i = 1;
      if (c.d(c.this) != null)
      {
        if (c.k(c.this) != paramView)
          break label31;
        c.l(c.this);
      }
      label31: 
      do
      {
        return;
        if (c.m(c.this) == paramView)
        {
          c.n(c.this);
          return;
        }
        if (c.o(c.this) == paramView)
        {
          c.p(c.this);
          return;
        }
        if (c.q(c.this) == paramView)
        {
          c.r(c.this);
          return;
        }
        if (c.s(c.this) == paramView)
        {
          if (c.d(c.this).j() == i)
            if (c.t(c.this) != null)
              c.t(c.this).a();
          while (true)
          {
            c.u(c.this).a(c.d(c.this), i);
            return;
            if (c.d(c.this).j() == 4)
              c.u(c.this).a(c.d(c.this), c.d(c.this).r(), -9223372036854775807L);
          }
        }
        if (c.v(c.this) == paramView)
        {
          c.u(c.this).a(c.d(c.this), false);
          return;
        }
        if (c.w(c.this) == paramView)
        {
          c.u(c.this).a(c.d(c.this), v.a(c.d(c.this).m(), c.x(c.this)));
          return;
        }
      }
      while (c.y(c.this) != paramView);
      com.google.android.exoplayer2.d locald = c.u(c.this);
      aa localaa = c.d(c.this);
      if (!c.d(c.this).n());
      while (true)
      {
        locald.b(localaa, i);
        return;
        int j = 0;
      }
    }

    public void onLoadingChanged(boolean paramBoolean)
    {
      ab.a(this, paramBoolean);
    }

    public void onPlaybackParametersChanged(y paramy)
    {
      ab.a(this, paramy);
    }

    public void onPlayerError(i parami)
    {
      ab.a(this, parami);
    }

    public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
    {
      c.e(c.this);
      c.f(c.this);
    }

    public void onPositionDiscontinuity(int paramInt)
    {
      c.h(c.this);
      c.f(c.this);
    }

    public void onRepeatModeChanged(int paramInt)
    {
      c.g(c.this);
      c.h(c.this);
    }

    public void onSeekProcessed()
    {
      ab.a(this);
    }

    public void onShuffleModeEnabledChanged(boolean paramBoolean)
    {
      c.i(c.this);
      c.h(c.this);
    }

    public void onTimelineChanged(ak paramak, Object paramObject, int paramInt)
    {
      c.h(c.this);
      c.j(c.this);
      c.f(c.this);
    }

    public void onTracksChanged(TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.g paramg)
    {
      ab.a(this, paramTrackGroupArray, paramg);
    }
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.c
 * JD-Core Version:    0.6.2
 */