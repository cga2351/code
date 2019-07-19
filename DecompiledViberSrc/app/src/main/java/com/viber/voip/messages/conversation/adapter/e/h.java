package com.viber.voip.messages.conversation.adapter.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

public class h<Value> extends ValueAnimator
{
  private Value a;
  private boolean b;
  private boolean c;
  private b<Value> d;
  private a e;
  private long f;

  @SafeVarargs
  public h(b<Value> paramb, long paramLong, a parama, Value[] paramArrayOfValue)
  {
    this(paramb, paramArrayOfValue);
    this.f = paramLong;
    this.e = parama;
  }

  @SafeVarargs
  public h(b<Value> paramb, Value[] paramArrayOfValue)
  {
    this.d = paramb;
    setObjectValues(paramArrayOfValue);
  }

  private void b()
  {
    addUpdateListener(new i(this));
    addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        h.a(h.this, null);
        h.a(h.this, true);
        if (h.a(h.this) != null)
          h.a(h.this).c(h.b(h.this));
      }
    });
  }

  public boolean a()
  {
    return this.c;
  }

  public boolean a(b<Value> paramb)
  {
    if (!this.c)
    {
      if ((paramb != null) && (this.a != null))
        paramb.a(this.a);
      this.d = paramb;
      return true;
    }
    return false;
  }

  public void start()
  {
    if (!this.b)
    {
      this.b = true;
      b();
    }
    super.start();
  }

  public static abstract interface a
  {
    public abstract void c(long paramLong);
  }

  public static abstract interface b<Value>
  {
    public abstract void a(Value paramValue);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.h
 * JD-Core Version:    0.6.2
 */