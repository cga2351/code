package com.viber.voip.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.common.dialogs.h.a;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av.e;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.v.b;
import com.viber.voip.messages.conversation.adapter.d.v.c;
import com.viber.voip.messages.d.l;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.view.AudioPttVolumeBarsView;
import com.viber.voip.messages.ui.view.AudioPttVolumeBarsView.a;
import com.viber.voip.q.a;
import com.viber.voip.q.a.a;
import com.viber.voip.sound.ptt.PttUtils.AudioBarsInfo;
import com.viber.voip.ui.dialogs.ah;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.util.ae;
import com.viber.voip.util.dj;

@Deprecated
public class PttLayout extends RelativeLayout
  implements v.b, v.c, AudioPttVolumeBarsView.a
{
  private ImageView a;
  private AudioPttVolumeBarsView b;
  private View c;
  private AudioPttControlView d;
  private TextView e;
  private a f;
  private b g;
  private a h;
  private l i;

  public PttLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public PttLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    dj.c(this.a, paramBoolean);
    dj.c(this.e, paramBoolean);
    this.a.setImageResource(paramInt);
  }

  private void a(Context paramContext)
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(paramContext).inflate(R.layout.msg_ptt, this);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.a = ((ImageView)localViewGroup.findViewById(R.id.media_voice_control));
    this.e = ((TextView)localViewGroup.findViewById(R.id.media_voice_duration));
    this.d = ((AudioPttControlView)localViewGroup.findViewById(R.id.media_voice_progressbar));
    this.b = ((AudioPttVolumeBarsView)localViewGroup.findViewById(R.id.media_voice_volume_view));
    this.c = localViewGroup.findViewById(R.id.volume_bars_view_delegate);
    this.c.setTag(R.id.no_intercept_touch, Boolean.valueOf(true));
    this.h = new a();
    k localk = ViberApplication.getInstance().getMessagesManager();
    this.g = new b();
    this.f = new a(localk.c(), localk.m(), av.e.a.a(), z.a);
  }

  public void a()
  {
    this.f.a(this.g);
    this.b.setProgressChangeListener(this);
  }

  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
      this.f.a(paramFloat1, paramFloat2, paramBoolean2);
  }

  public void a(View paramView)
  {
    if (this.c != paramView)
      return;
    this.b.a(paramView);
  }

  public void a(View paramView, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.c != paramView)
      return;
    this.b.a(paramView, paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }

  public void a(aa paramaa, i parami)
  {
    l locall = new l(paramaa);
    if (!locall.equals(this.i));
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
        b();
      this.i = locall;
      a();
      this.f.a(paramaa, bool);
      return;
    }
  }

  public void b()
  {
    this.f.a();
    this.b.setProgressChangeListener(null);
    a.a(this.h);
    this.b.b();
    this.b.d();
  }

  public void b(View paramView)
  {
    if (this.c != paramView)
      return;
    this.b.b(paramView);
  }

  public void c(View paramView)
  {
    this.f.b();
  }

  public View getVolumeBarsView()
  {
    return this.c;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 8)
      b();
    while (paramInt != 0)
      return;
    a();
  }

  class a
  {
    private AnimatorSet b;

    a()
    {
    }

    private AnimatorSet a()
    {
      if (this.b == null)
      {
        this.b = new AnimatorSet();
        this.b.setDuration(400L);
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            PttLayout.a(PttLayout.this).setImageAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
        AnimatorSet localAnimatorSet = this.b;
        Animator[] arrayOfAnimator = new Animator[3];
        arrayOfAnimator[0] = localValueAnimator;
        arrayOfAnimator[1] = ObjectAnimator.ofFloat(PttLayout.b(PttLayout.this), View.ALPHA, new float[] { 0.4F, 1.0F });
        arrayOfAnimator[2] = ObjectAnimator.ofFloat(PttLayout.c(PttLayout.this), View.ALPHA, new float[] { 0.0F, 1.0F });
        localAnimatorSet.playTogether(arrayOfAnimator);
      }
      return this.b;
    }

    private void b()
    {
      if (d())
        a().cancel();
      PttLayout.a(PttLayout.this).setImageAlpha(0);
      PttLayout.b(PttLayout.this).setAlpha(0.4F);
      PttLayout.c(PttLayout.this).setAlpha(0.0F);
      a().start();
    }

    private void c()
    {
      if (d())
        a().cancel();
      PttLayout.a(PttLayout.this).setImageAlpha(255);
      PttLayout.c(PttLayout.this).setAlpha(1.0F);
      PttLayout.b(PttLayout.this).setAlpha(1.0F);
    }

    private boolean d()
    {
      return (this.b != null) && (this.b.isStarted());
    }
  }

  class b
    implements a.a
  {
    b()
    {
    }

    public void a()
    {
      PttLayout.a(PttLayout.this, R.drawable.voice_msg_control_pause, true);
      PttLayout.b(PttLayout.this).a(false);
      PttLayout.d(PttLayout.this).setUnreadState(false);
    }

    public void a(float paramFloat)
    {
      PttLayout.d(PttLayout.this).setProgress(paramFloat);
    }

    public void a(int paramInt)
    {
      PttLayout.b(PttLayout.this).a(paramInt / 100.0D);
    }

    public void a(long paramLong)
    {
      PttLayout.c(PttLayout.this).setVisibility(0);
      PttLayout.c(PttLayout.this).setText(ae.f(paramLong));
    }

    public void a(long paramLong, boolean paramBoolean)
    {
      if ((paramBoolean) && (PttLayout.d(PttLayout.this).e()))
        return;
      PttLayout.d(PttLayout.this).a(paramLong);
    }

    public void a(PttUtils.AudioBarsInfo paramAudioBarsInfo)
    {
      PttLayout.d(PttLayout.this).setAudioBarsInfo(paramAudioBarsInfo);
    }

    public void a(boolean paramBoolean)
    {
      PttLayout localPttLayout = PttLayout.this;
      if (paramBoolean);
      for (int i = R.drawable.voice_msg_control_play_unread; ; i = R.drawable.voice_msg_control_play)
      {
        PttLayout.a(localPttLayout, i, true);
        PttLayout.b(PttLayout.this).a(paramBoolean);
        PttLayout.d(PttLayout.this).setUnreadState(paramBoolean);
        return;
      }
    }

    public void b()
    {
      if (PttLayout.a.b(PttLayout.e(PttLayout.this)))
        return;
      PttLayout.a.c(PttLayout.e(PttLayout.this));
    }

    public void b(boolean paramBoolean)
    {
      PttLayout.a(PttLayout.this, 0, false);
      PttLayout.b(PttLayout.this).a(0.0D);
      PttLayout.d(PttLayout.this).setUnreadState(paramBoolean);
    }

    public void c()
    {
      if (PttLayout.d(PttLayout.this).c())
        return;
      PttLayout.d(PttLayout.this).a();
    }

    public void d()
    {
      PttLayout.d(PttLayout.this).d();
    }

    public void e()
    {
      ViberApplication.getInstance().showToast(R.string.file_not_found);
    }

    public void f()
    {
      p.b(2).d();
    }

    public void g()
    {
      ah.d().d();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PttLayout
 * JD-Core Version:    0.6.2
 */