package com.viber.voip.messages.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.clock.CyclicClock;
import com.viber.svg.jni.clock.FiniteClock;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.ui.view.g;
import com.viber.voip.messages.ui.view.g.a;
import com.viber.voip.u.a;
import com.viber.voip.ui.d.f;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class SendButton extends FrameLayout
  implements View.OnClickListener, g.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.SECONDS.toMillis(1L);
  private FiniteClock A;
  private FiniteClock B;
  private f C;
  private f D;
  private f E;
  private long F;
  private FiniteClock G;
  private FiniteClock H;
  private CyclicClock I;
  private boolean J;
  private b K;
  private float L;
  private float M;
  private float N;
  private boolean O;
  private boolean P;
  private float Q;
  private float R;
  private Handler S;
  private Runnable T;
  private final HashSet<Integer> U = new HashSet(2);
  private cx V;
  private c W;
  private ValueAnimator.AnimatorUpdateListener aa;
  private Runnable ab;
  private int ac;
  private SendButton.b.a ad = SendButton.b.a.e;
  private g ae;
  private MotionEvent af;
  private int c;
  private int d;
  private ImageView e;
  private int f;
  private ImageView g;
  private ValueAnimator h;
  private TextView i;
  private ValueAnimator j;
  private ValueAnimator k;
  private AnimatorSet l;
  private AnimatorSet m;
  private View.OnClickListener n;
  private a o;
  private int p;
  private int q;
  private int r;
  private int s;
  private View t;
  private ImageView u;
  private ImageView v;
  private float w;
  private f x;
  private f y;
  private long z;

  public SendButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public SendButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public SendButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private ValueAnimator a(boolean paramBoolean)
  {
    float f1 = 0.0F;
    if (paramBoolean);
    for (float f2 = this.R; ; f2 = 0.0F)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
      localValueAnimator.setDuration(300L);
      localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SendButton.g(SendButton.this).setTranslationX(f);
          SendButton.h(SendButton.this).setTranslationX(SendButton.i(SendButton.this) - f);
        }
      });
      return localValueAnimator;
      f1 = this.R;
    }
  }

  private void a(int paramInt, f[] paramArrayOff)
  {
    int i1 = paramArrayOff.length;
    for (int i2 = 0; i2 < i1; i2++)
      paramArrayOff[i2].a(paramInt);
  }

  private void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.send_button, this, true);
    this.e = ((ImageView)localView.findViewById(R.id.btn_send_icon_1));
    this.g = ((ImageView)localView.findViewById(R.id.btn_send_icon_2));
    this.i = ((TextView)localView.findViewById(R.id.badge_selected_media));
    this.t = localView.findViewById(R.id.send_icon_container);
    this.u = ((ImageView)localView.findViewById(R.id.record_icon_inactive));
    setClipChildren(false);
    this.c = 0;
    this.d = c(this.c);
    this.e.setImageResource(this.d);
    super.setOnClickListener(this);
    this.o = new a(null);
    Resources localResources = getResources();
    this.p = localResources.getDimensionPixelSize(R.dimen.composer_send_button_full_width);
    this.q = localResources.getDimensionPixelSize(R.dimen.composer_send_button_full_height);
    this.w = localResources.getDimensionPixelSize(R.dimen.composer_record_toggle_size);
    this.L = localResources.getDimensionPixelSize(R.dimen.composer_send_button_size);
    this.s = Math.round(0.15F * this.L);
    this.R = (this.L + localResources.getDimensionPixelSize(R.dimen.composer_record_buttons_distance));
    this.Q = localResources.getDimensionPixelSize(R.dimen.composer_record_drag_start_slop);
    this.M = (-this.Q);
    this.ac = dc.d(paramContext, R.attr.conversationComposeSendButton);
    this.J = a.c();
    if (!isInEditMode())
    {
      i.a();
      i();
    }
    this.S = av.a(av.e.a);
    this.T = new cn(this);
    this.ae = new g(this);
  }

  private void a(MotionEvent paramMotionEvent)
  {
    if (this.af != null)
      this.af.recycle();
    this.af = MotionEvent.obtain(paramMotionEvent);
  }

  private void a(Animator[] paramArrayOfAnimator)
  {
    this.m = new AnimatorSet();
    this.m.playTogether(paramArrayOfAnimator);
    this.m.start();
  }

  private CharSequence b(int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
      return "send";
    case 1:
      return "ptt";
    case 4:
      return "vptt";
    case 3:
      return "bot";
    case 5:
      return "chatex";
    case 6:
    }
    return "edit";
  }

  private void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (float f1 = 0.0F; ; f1 = 1.0F)
    {
      this.i.setScaleX(f1);
      this.i.setScaleY(f1);
      this.i.setVisibility(0);
      ValueAnimator localValueAnimator = this.j;
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = (1.0F - f1);
      localValueAnimator.setFloatValues(arrayOfFloat);
      return;
    }
  }

  private int c(int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
      return R.drawable.btn_send;
    case 1:
      return R.drawable.ic_send_ptt;
    case 4:
      return getVideoPttIcon();
    case 3:
      return R.drawable.ic_show_bot_keyboard;
    case 5:
      return R.drawable.bg_chat_ex_input_search;
    case 6:
    }
    return R.drawable.bg_edit_msg_input_v;
  }

  private int getVideoPttIcon()
  {
    if (this.J)
      return R.drawable.ic_send_video_ptt_play_heart;
    return R.drawable.ic_send_video_ptt_play_dash;
  }

  @NotNull
  private String getVideoPttScaleDownSvgPath()
  {
    if (this.J)
      return "svg/send_video_ptt_play_heart_scale_down.svg";
    return "svg/send_video_ptt_play_dash_scale_down.svg";
  }

  @NotNull
  private String getVideoPttScaleUpSvgPath()
  {
    if (this.J)
      return "svg/send_video_ptt_play_heart_scale_up.svg";
    return "svg/send_video_ptt_play_dash_scale_up.svg";
  }

  private void i()
  {
    this.j = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.j.setInterpolator(new AccelerateDecelerateInterpolator());
    this.j.addUpdateListener(new cp(this));
    this.j.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        float f;
        TextView localTextView;
        if (SendButton.a(SendButton.this) == 2)
        {
          f = 1.0F;
          SendButton.b(SendButton.this).setScaleX(f);
          SendButton.b(SendButton.this).setScaleY(f);
          localTextView = SendButton.b(SendButton.this);
          if (SendButton.a(SendButton.this) != 2)
            break label69;
        }
        label69: for (boolean bool = true; ; bool = false)
        {
          dj.b(localTextView, bool);
          return;
          f = 0.0F;
          break;
        }
      }
    });
    this.h = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.h.addUpdateListener(new cq(this));
    this.h.setDuration(300L);
    this.h.setInterpolator(new AccelerateDecelerateInterpolator());
    this.h.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ImageView localImageView = SendButton.c(SendButton.this);
        SendButton.a(SendButton.this, SendButton.d(SendButton.this));
        SendButton.b(SendButton.this, localImageView);
        int i = SendButton.e(SendButton.this);
        SendButton.a(SendButton.this, SendButton.f(SendButton.this));
        SendButton.b(SendButton.this, i);
        SendButton.c(SendButton.this).setScaleX(0.0F);
        SendButton.c(SendButton.this).setScaleY(0.0F);
        SendButton.c(SendButton.this).setVisibility(8);
        SendButton.d(SendButton.this).setScaleX(1.0F);
        SendButton.d(SendButton.this).setScaleY(1.0F);
        SendButton.d(SendButton.this).setVisibility(0);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        SendButton.c(SendButton.this).setScaleX(0.0F);
        SendButton.c(SendButton.this).setScaleY(0.0F);
        SendButton.c(SendButton.this).setVisibility(0);
      }
    });
    this.k = a(false);
    this.k.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        int i = 1;
        ImageView localImageView = SendButton.h(SendButton.this);
        SendButton localSendButton = SendButton.this;
        if (SendButton.a(SendButton.this) == i)
          i = 4;
        localImageView.setImageResource(SendButton.c(localSendButton, i));
        SendButton.j(SendButton.this);
        SendButton.g(SendButton.this).setTranslationX(0.0F);
        SendButton.b(SendButton.this, SendButton.c(SendButton.this, SendButton.a(SendButton.this)));
        SendButton.d(SendButton.this).setImageResource(SendButton.f(SendButton.this));
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        SendButton.g(SendButton.this).setTranslationX(0.0F);
        SendButton.h(SendButton.this).setAlpha(1.0F);
        SendButton.h(SendButton.this).setTranslationX(SendButton.i(SendButton.this));
        SendButton.h(SendButton.this).setVisibility(0);
      }
    });
    ValueAnimator localValueAnimator1 = a(false);
    localValueAnimator1.setStartDelay(1000L);
    localValueAnimator1.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SendButton.g(SendButton.this).setAlpha(0.45F);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        SendButton.g(SendButton.this).setTranslationX(0.0F);
        SendButton.h(SendButton.this).setAlpha(1.0F);
        SendButton.h(SendButton.this).setTranslationX(SendButton.i(SendButton.this));
        SendButton.h(SendButton.this).setVisibility(0);
      }
    });
    ValueAnimator localValueAnimator2 = a(true);
    localValueAnimator2.setStartDelay(100L);
    localValueAnimator2.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SendButton.g(SendButton.this).setAlpha(1.0F);
        SendButton.j(SendButton.this);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        SendButton.g(SendButton.this).setAlpha(1.0F);
      }
    });
    this.x = new f("svg/voice_msg_send_button_scale_up.svg");
    double d1 = this.x.b();
    this.z = (()(d1 * b));
    this.A = new FiniteClock(d1);
    this.x.a(this.A);
    this.y = new f("svg/voice_msg_send_button_scale_down.svg");
    this.B = new FiniteClock(this.y.b());
    this.y.a(this.B);
    this.C = new f(getVideoPttScaleUpSvgPath());
    double d2 = this.C.b();
    this.F = (()(d2 * b));
    this.G = new FiniteClock(d2);
    this.C.a(this.G);
    this.D = new f(getVideoPttScaleDownSvgPath());
    this.H = new FiniteClock(this.D.b());
    this.D.a(this.H);
    this.E = new f("svg/send_toggle_scale_up.svg");
    this.I = new CyclicClock(this.E.b());
    this.E.a(this.I);
    setAllSvgDrawablesMainColor(this.ac);
    this.W = new c(null);
    this.aa = new cr(this);
    this.ab = new cs(this);
  }

  private void j()
  {
    if ((d()) && (q()))
    {
      this.u.setTranslationX(this.R);
      this.u.setAlpha(0.45F);
      if (this.u.getVisibility() == 8)
      {
        dj.a(this, this.s, this.s, this.r, this.s);
        this.u.setVisibility(0);
      }
      return;
    }
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof View))
    {
      if (!d())
        break label124;
      dj.a(this, this.s, this.s, this.s, this.s);
    }
    while (true)
    {
      dj.b(this.u, false);
      return;
      label124: ((View)localViewParent).setTouchDelegate(null);
    }
  }

  private boolean k()
  {
    return this.k.isStarted();
  }

  private void l()
  {
    if ((!this.P) && (this.O))
    {
      u();
      this.P = true;
      n();
      m();
      if (this.K != null)
        this.K.f(this.c);
    }
  }

  private void m()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent().getParent();
    if ((localViewGroup != null) && (1 == this.c))
      this.ae.a(localViewGroup, this);
  }

  private void n()
  {
    dj.b(this.t, false);
    dj.b(this.u, false);
    dj.b(this.v, true);
    this.v.setAlpha(1.0F);
    this.V.c();
    dj.b(this.v, this.ab);
    this.v.setImageDrawable(o());
  }

  private f o()
  {
    if (this.c == 1)
    {
      this.A.reset();
      return this.x;
    }
    this.G.reset();
    return this.C;
  }

  private f p()
  {
    FiniteClock localFiniteClock;
    if (this.c == 1)
      localFiniteClock = this.B;
    for (f localf = this.y; ; localf = this.D)
    {
      localFiniteClock.reset();
      localf.a(localFiniteClock);
      return localf;
      localFiniteClock = this.H;
    }
  }

  private boolean q()
  {
    return this.U.size() > 1;
  }

  private void r()
  {
    int i1 = 1;
    if (this.c == i1)
      i1 = 4;
    a(i1);
    if (this.K != null)
    {
      this.K.a(this.c, 2);
      this.K.b(this.c, 2);
    }
  }

  private void s()
  {
    this.S.removeCallbacks(this.T);
    this.P = false;
    this.O = false;
  }

  private void setAllSvgDrawablesMainColor(int paramInt)
  {
    f[] arrayOff = new f[5];
    arrayOff[0] = this.x;
    arrayOff[1] = this.y;
    arrayOff[2] = this.C;
    arrayOff[3] = this.D;
    arrayOff[4] = this.E;
    a(paramInt, arrayOff);
  }

  private boolean t()
  {
    return this.i.getVisibility() == 0;
  }

  private void u()
  {
    if ((this.m != null) && (this.m.isStarted()))
      this.m.end();
  }

  public void a()
  {
    a(7);
    if (this.K != null)
      this.K.w();
  }

  public void a(float paramFloat)
  {
    f localf = p();
    long l1;
    ObjectAnimator localObjectAnimator1;
    if ((this.c == 7) || (this.c == 8))
    {
      l1 = 0L;
      this.l = new AnimatorSet();
      localObjectAnimator1 = ObjectAnimator.ofFloat(this, "translationX", new float[] { paramFloat });
      localObjectAnimator1.addUpdateListener(this.aa);
      if (paramFloat >= 0.0F)
        break label200;
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.v, "alpha", new float[] { 0.0F });
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F });
      this.l.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
      this.W.a(true);
    }
    while (true)
    {
      this.l.setInterpolator(new DecelerateInterpolator(2.0F));
      this.l.setDuration(l1);
      this.l.addListener(this.W);
      this.v.setImageDrawable(localf);
      this.l.start();
      return;
      l1 = ()(1000.0D * localf.b());
      break;
      label200: this.l.playTogether(new Animator[] { localObjectAnimator1 });
      this.W.a(false);
    }
  }

  public void a(int paramInt)
  {
    int i1 = 0;
    int i2;
    int i3;
    if (this.c != paramInt)
    {
      u();
      i2 = this.c;
      i3 = c(paramInt);
      if ((!q()) || (((paramInt != 1) || (i2 != 4)) && ((paramInt != 4) || (i2 != 1))))
        break label105;
      this.u.setImageResource(i3);
      Animator[] arrayOfAnimator6 = new Animator[1];
      arrayOfAnimator6[0] = this.k;
      a(arrayOfAnimator6);
    }
    while (true)
    {
      this.c = paramInt;
      dg.a(this, b(paramInt));
      if (i1 != 0)
        j();
      return;
      label105: if (i3 != this.d)
      {
        if (i3 != this.f)
        {
          this.f = i3;
          this.g.setImageResource(this.f);
        }
        if (paramInt == 2)
        {
          b(true);
          Animator[] arrayOfAnimator5 = new Animator[2];
          arrayOfAnimator5[0] = this.h;
          arrayOfAnimator5[1] = this.j;
          a(arrayOfAnimator5);
          i1 = 1;
        }
        else if (t())
        {
          b(false);
          Animator[] arrayOfAnimator4 = new Animator[2];
          arrayOfAnimator4[0] = this.j;
          arrayOfAnimator4[1] = this.h;
          a(arrayOfAnimator4);
          i1 = 1;
        }
        else if (7 == paramInt)
        {
          this.c = paramInt;
          setTranslationY(0.0F);
          setTranslationX(0.0F);
          this.v.setImageDrawable(this.E);
          this.e.invalidate();
          i1 = 1;
        }
        else
        {
          Animator[] arrayOfAnimator3 = new Animator[1];
          arrayOfAnimator3[0] = this.h;
          a(arrayOfAnimator3);
          i1 = 1;
        }
      }
      else if ((paramInt == 2) && (!t()))
      {
        b(true);
        Animator[] arrayOfAnimator2 = new Animator[1];
        arrayOfAnimator2[0] = this.j;
        a(arrayOfAnimator2);
        i1 = 1;
      }
      else
      {
        if ((i2 == 2) && (t()))
        {
          b(false);
          Animator[] arrayOfAnimator1 = new Animator[1];
          arrayOfAnimator1[0] = this.j;
          a(arrayOfAnimator1);
        }
        i1 = 1;
      }
    }
  }

  public void a(ImageView paramImageView)
  {
    this.v = paramImageView;
    this.v.setOnClickListener(new co(this));
    this.V = new cx(this.t, this.v);
    this.V.a(0.0F, 0.0F);
  }

  public void a(List<Integer> paramList, boolean paramBoolean)
  {
    this.U.clear();
    this.U.addAll(paramList);
    if ((paramBoolean) && (!k()))
      j();
  }

  public void b()
  {
    a(8);
    if (this.K != null)
    {
      this.K.x();
      s();
    }
  }

  public boolean c()
  {
    return this.P;
  }

  public boolean d()
  {
    return (this.c == 1) || (this.c == 4);
  }

  public void e()
  {
    if (this.O)
    {
      if (!this.P)
        break label24;
      a(0.0F);
    }
    while (true)
    {
      s();
      return;
      label24: if (this.K != null)
        this.K.b(this.c, 0);
    }
  }

  public void f()
  {
    if ((this.l != null) && (this.l.isStarted()))
      this.l.end();
    setAlpha(0.0F);
    this.v.setAlpha(1.0F);
    dj.b(this.t, true);
    dj.b(this.v, false);
    this.V.d();
    this.ae.a();
    setTranslationX(0.0F);
    animate().alpha(1.0F).setDuration(300L).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SendButton.j(SendButton.this);
        if (SendButton.n(SendButton.this) != null)
          SendButton.n(SendButton.this).b(SendButton.a(SendButton.this), 1);
      }
    });
  }

  public long getAnimationDuration()
  {
    return 300L;
  }

  public ae getBotKeyboardPanelTrigger()
  {
    return this.o;
  }

  public float getRecordToggleMaxSize()
  {
    return this.w;
  }

  public int getState()
  {
    return this.c;
  }

  public long getSvgShowAnimationDurationMillis()
  {
    if (this.c == 1)
      return this.z;
    return this.F;
  }

  public void onClick(View paramView)
  {
    if ((!this.o.b()) && (this.n != null))
      this.n.onClick(paramView);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.p, 1073741824), View.MeasureSpec.makeMeasureSpec(this.q, 1073741824));
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 1;
    if (d())
    {
      if ((!this.O) && (paramMotionEvent.getActionMasked() != 0))
        i1 = super.onTouchEvent(paramMotionEvent);
      float f1;
      float f2;
      label366: label373: 
      do
      {
        float f3;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return i1;
                    switch (paramMotionEvent.getActionMasked())
                    {
                    default:
                      return i1;
                    case 0:
                      this.O = i1;
                      a(paramMotionEvent);
                    case 1:
                    case 3:
                    case 2:
                    }
                  }
                  while (this.K == null);
                  this.K.e(this.c);
                  if (q())
                  {
                    this.S.postDelayed(this.T, 500L);
                    return i1;
                  }
                  l();
                  return i1;
                  if (!this.P);
                  int i7;
                  for (int i6 = i1; ; i7 = 0)
                  {
                    s();
                    if (i6 == 0)
                      break;
                    r();
                    return i1;
                  }
                }
                while (this.K == null);
                if (this.ad.a())
                  setTranslationY(0.0F);
                this.K.a(this.c, 0);
                this.ae.a();
                return i1;
              }
              while (this.af == null);
              f1 = paramMotionEvent.getRawX() - this.af.getRawX();
              f2 = paramMotionEvent.getRawY() - this.af.getRawY();
              if (this.P)
              {
                if ((f1 >= -10.0F) || (!this.ad.b()))
                  break label366;
                this.ae.a();
              }
              while (true)
              {
                if (((f2 > -10.0F) && (this.ad.a())) || ((f1 > -10.0F) && (this.ad.b())))
                  this.ad = SendButton.b.a.e;
                if ((f2 >= 0.0F) || (this.ad.b()) || (i1 != this.c))
                  break label471;
                if (this.P)
                  break label373;
                if (Math.abs(f1) <= this.Q)
                  break;
                s();
                r();
                return i1;
                m();
              }
              float f6;
              if (getTranslationY() > f2)
              {
                int i4 = i1;
                if (i4 == 0)
                  break label451;
                f6 = getTranslationY() - f2;
                if (i4 == 0)
                  break label463;
              }
              for (SendButton.b.a locala2 = SendButton.b.a.a; ; locala2 = SendButton.b.a.b)
              {
                this.ad = locala2;
                setTranslationY(f2);
                this.V.b();
                this.ae.a(f6, Math.abs(f2));
                return i1;
                int i5 = 0;
                break;
                f6 = f2 - getTranslationY();
                break label400;
              }
              if ((f1 >= 0.0F) || (this.ad.a()))
                break;
            }
            while ((f1 > this.M) && (f1 <= getTranslationX()));
            if (this.P)
              break;
          }
          while (Math.abs(f1) <= this.Q);
          s();
          r();
          return i1;
          if (getTranslationX() > f1)
          {
            int i2 = i1;
            if (i2 == 0)
              break label707;
            f3 = getTranslationX() - f1;
            if (i2 == 0)
              break label718;
          }
          for (SendButton.b.a locala1 = SendButton.b.a.c; ; locala1 = SendButton.b.a.d)
          {
            this.ad = locala1;
            setTranslationX(f1);
            this.V.b();
            float f4 = this.w / this.L;
            float f5 = getWidth() * (1.0F - 1.0F / f4);
            if (getX() - f5 > this.N)
              break label726;
            setTranslationX(this.N - getLeft());
            this.V.b();
            if (this.K != null)
              this.K.a(this.c, this.ad, f3);
            s();
            if (this.K == null)
              break;
            this.K.a(this.c, i1);
            return i1;
            int i3 = 0;
            break label546;
            f3 = f1 - getTranslationX();
            break label559;
          }
        }
        while (this.K == null);
        this.K.a(this.c, this.ad, f3);
        return i1;
      }
      while ((this.P) || ((f1 <= this.Q) && (f2 <= this.Q)));
      label400: label451: label463: label471: s();
      label546: label559: label707: label718: label726: r();
      return i1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.n = paramOnClickListener;
  }

  public void setRecordButtonSvgMainColor(int paramInt)
  {
    if (paramInt != this.ac)
    {
      this.ac = paramInt;
      setAllSvgDrawablesMainColor(paramInt);
    }
  }

  public void setRecordIconInactiveBackground(Drawable paramDrawable)
  {
    dj.a(this.u, paramDrawable);
  }

  public void setRecordStateListener(b paramb)
  {
    this.K = paramb;
  }

  public void setRecordStateSwitchRightExtraTouchArea(int paramInt)
  {
    this.r = paramInt;
  }

  public void setRecordToggleDragLimitPosition(float paramFloat)
  {
    this.N = paramFloat;
  }

  public void setSelectedMediaCount(int paramInt)
  {
    this.i.setText(Integer.toString(paramInt));
  }

  public void setSendButtonBackground(Drawable paramDrawable)
  {
    dj.a(this.t, paramDrawable);
  }

  public void setState(int paramInt)
  {
    TextView localTextView;
    if (this.c != paramInt)
    {
      u();
      this.c = paramInt;
      this.d = c(paramInt);
      this.e.setImageResource(this.d);
      localTextView = this.i;
      if (paramInt != 2)
        break label59;
    }
    label59: for (boolean bool = true; ; bool = false)
    {
      dj.b(localTextView, bool);
      j();
      return;
    }
  }

  private final class a
    implements ae
  {
    private boolean b = false;
    private ae.a c;

    private a()
    {
    }

    private boolean c()
    {
      return SendButton.a(SendButton.this) == 3;
    }

    public boolean a()
    {
      return (c()) && (this.b);
    }

    public boolean b()
    {
      if (c())
      {
        boolean bool1 = this.b;
        boolean bool2 = false;
        if (!bool1)
          bool2 = true;
        this.b = bool2;
        if (this.c != null)
          this.c.a(this);
        return true;
      }
      return false;
    }

    public void e_(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }

    public int getPanelId()
    {
      return R.id.bot_keyboard;
    }

    public void setTriggerClickListener(ae.a parama)
    {
      this.c = parama;
    }
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2);

    public abstract void a(int paramInt, a parama, float paramFloat);

    public abstract void b(int paramInt1, int paramInt2);

    public abstract void e(int paramInt);

    public abstract void f(int paramInt);

    public abstract void w();

    public abstract void x();

    public static enum a
    {
      static
      {
        a[] arrayOfa = new a[5];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
        arrayOfa[3] = d;
        arrayOfa[4] = e;
      }

      boolean a()
      {
        return (this == a) || (this == b);
      }

      boolean b()
      {
        return (this == c) || (this == d);
      }
    }
  }

  private class c extends AnimatorListenerAdapter
  {
    private boolean b;

    private c()
    {
    }

    void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }

    public void onAnimationEnd(Animator paramAnimator)
    {
      dj.b(SendButton.k(SendButton.this), false);
      SendButton.l(SendButton.this).d();
      SendButton.k(SendButton.this).setImageDrawable(null);
      SendButton.m(SendButton.this).a();
      dj.b(SendButton.g(SendButton.this), true);
      if (!this.b)
        SendButton.j(SendButton.this);
      if ((SendButton.n(SendButton.this) != null) && (!this.b))
        SendButton.n(SendButton.this).b(SendButton.a(SendButton.this), 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.SendButton
 * JD-Core Version:    0.6.2
 */