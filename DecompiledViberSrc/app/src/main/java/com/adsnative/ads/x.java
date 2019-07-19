package com.adsnative.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import java.lang.ref.WeakReference;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;

public class x extends FrameLayout
{
  StringBuilder a;
  Formatter b;
  private a c;
  private Context d;
  private ViewGroup e;
  private View f;
  private ProgressBar g;
  private boolean h;
  private boolean i;
  private ImageButton j;
  private Handler k = new b(this);
  private y l;
  private boolean m = false;
  private HashMap<String, Object> n;
  private View.OnClickListener o = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      x.a(x.this);
      x.this.a(3000);
    }
  };
  private View.OnClickListener p = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      x.b(x.this);
      x.this.a(3000);
    }
  };
  private SeekBar.OnSeekBarChangeListener q = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if (x.d(x.this) == null);
      while (!paramAnonymousBoolean)
        return;
      long l = x.d(x.this).getDuration() * paramAnonymousInt / 1000L;
      x.d(x.this).a((int)l);
    }

    public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      x.this.a(3600000);
      x.a(x.this, true);
      x.c(x.this).removeMessages(2);
    }

    public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      x.a(x.this, false);
      x.e(x.this);
      x.this.a(3000);
      x.c(x.this).sendEmptyMessage(2);
    }
  };

  public x(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
    this.l = new y(this.d);
    Log.i("ANMediaController", "ANMediaController");
  }

  private void a(View paramView)
  {
    this.g = ((ProgressBar)paramView.findViewById(this.l.a()));
    if (this.g != null)
    {
      if ((this.g instanceof SeekBar))
      {
        SeekBar localSeekBar = (SeekBar)this.g;
        localSeekBar.setOnSeekBarChangeListener(this.q);
        localSeekBar.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
      }
      this.g.setMax(1000);
    }
    if ((this.c == null) || (!this.c.c()))
    {
      this.j = ((ImageButton)paramView.findViewById(this.l.b()));
      if (this.j != null)
      {
        this.j.requestFocus();
        this.j.setOnClickListener(this.p);
      }
    }
    this.a = new StringBuilder();
    this.b = new Formatter(this.a, Locale.getDefault());
  }

  private void e()
  {
    if (this.c == null);
  }

  private int f()
  {
    int i1;
    if ((this.c == null) || (this.i))
      i1 = 0;
    int i2;
    do
    {
      return i1;
      i1 = this.c.getCurrentPosition();
      i2 = this.c.getDuration();
    }
    while (this.g == null);
    if (i2 > 0)
    {
      long l1 = 1000L * i1 / i2;
      this.g.setProgress((int)l1);
    }
    int i3 = this.c.getBufferPercentage();
    this.g.setSecondaryProgress(i3 * 10);
    return i1;
  }

  private void g()
  {
    if (this.c == null)
      return;
    if (this.c.b())
    {
      this.c.a();
      return;
    }
    this.c.a(false);
  }

  private void h()
  {
    if (this.c == null)
      return;
    this.c.d();
  }

  public void a(int paramInt)
  {
    if ((!this.h) && (this.e != null))
    {
      f();
      e();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
      this.e.addView(this, localLayoutParams);
      this.h = true;
    }
    this.k.sendEmptyMessage(2);
  }

  public boolean a()
  {
    return this.m;
  }

  public void b()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    removeAllViews();
    addView(c(), localLayoutParams);
    this.m = true;
  }

  protected View c()
  {
    String str = (String)this.n.get("expandButtonUrl");
    y localy = this.l;
    if (this.c != null);
    for (boolean bool = this.c.c(); ; bool = true)
    {
      this.f = localy.a(bool, str);
      a(this.f);
      return this.f;
    }
  }

  public void d()
  {
    a(3000);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.c == null);
    int i2;
    label70: 
    do
    {
      int i1;
      do
      {
        do
        {
          return true;
          i1 = paramKeyEvent.getKeyCode();
          if ((paramKeyEvent.getRepeatCount() == 0) && (paramKeyEvent.getAction() == 0));
          for (i2 = 1; ; i2 = 0)
          {
            if ((i1 != 79) && (i1 != 85) && (i1 != 62))
              break label70;
            if (i2 == 0)
              break;
            g();
            a(3000);
            return true;
          }
          if (i1 != 126)
            break;
        }
        while ((i2 == 0) || (this.c.b()));
        this.c.a(false);
        a(3000);
        return true;
        if ((i1 != 86) && (i1 != 127))
          break;
      }
      while ((i2 == 0) || (!this.c.b()));
      this.c.a();
      a(3000);
      return true;
      if ((i1 == 25) || (i1 == 24) || (i1 == 164))
        return super.dispatchKeyEvent(paramKeyEvent);
      if ((i1 != 4) && (i1 != 82))
        break;
    }
    while (i2 == 0);
    return true;
    a(3000);
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public View getAnchorView()
  {
    return this.e;
  }

  @SuppressLint({"MissingSuperCall"})
  public void onFinishInflate()
  {
    if (this.f != null)
      a(this.f);
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(x.class.getName());
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(x.class.getName());
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(3000);
    return true;
  }

  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    a(3000);
    return false;
  }

  public void setAnchorView(ViewGroup paramViewGroup)
  {
    this.e = paramViewGroup;
  }

  public void setEnabled(boolean paramBoolean)
  {
    if (this.g != null)
      this.g.setEnabled(paramBoolean);
    e();
    super.setEnabled(paramBoolean);
  }

  public void setMediaPlayer(a parama)
  {
    this.c = parama;
  }

  public void setVideoConfigs(HashMap<String, Object> paramHashMap)
  {
    this.n = paramHashMap;
    if (this.n == null)
      this.n = new HashMap();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(boolean paramBoolean);

    public abstract boolean b();

    public abstract boolean c();

    public abstract void d();

    public abstract int getBufferPercentage();

    public abstract int getCurrentPosition();

    public abstract int getDuration();
  }

  private static class b extends Handler
  {
    private final WeakReference<x> a;

    b(x paramx)
    {
      this.a = new WeakReference(paramx);
    }

    public void handleMessage(Message paramMessage)
    {
      x localx = (x)this.a.get();
      if ((localx == null) || (x.d(localx) == null));
      int i;
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 1:
        default:
          return;
        case 2:
        }
        i = x.e(localx);
      }
      while ((x.f(localx)) || (!x.g(localx)) || (!x.d(localx).b()));
      sendMessageDelayed(obtainMessage(2), 1000 - i % 1000);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.x
 * JD-Core Version:    0.6.2
 */