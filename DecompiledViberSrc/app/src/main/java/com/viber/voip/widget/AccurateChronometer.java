package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

public class AccurateChronometer extends TextView
{
  private static final Logger a = ViberEnv.getLogger();
  private long b;
  private long c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private String h;
  private Formatter i;
  private Locale j;
  private Object[] k = new Object[1];
  private StringBuilder l;
  private a m;
  private StringBuilder n = new StringBuilder(8);
  private boolean o;
  private boolean p;
  private final Runnable q = new Runnable()
  {
    public void run()
    {
      if (AccurateChronometer.a(AccurateChronometer.this))
        AccurateChronometer.b(AccurateChronometer.this);
    }
  };

  public AccurateChronometer(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AccurateChronometer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AccurateChronometer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AccurateChronometer, paramInt, 0);
    setFormat(localTypedArray.getString(R.styleable.AccurateChronometer_format));
    setCountDown(localTypedArray.getBoolean(R.styleable.AccurateChronometer_countDown, false));
    localTypedArray.recycle();
    d();
  }

  private void a(long paramLong)
  {
    try
    {
      this.c = paramLong;
      long l1;
      if (this.o)
        l1 = this.b - paramLong;
      while (true)
      {
        long l2 = l1 / 1000L;
        boolean bool = l2 < 0L;
        int i1 = 0;
        if (bool)
        {
          l2 = -l2;
          i1 = 1;
        }
        Object localObject2 = DateUtils.formatElapsedTime(this.n, l2);
        if (i1 != 0)
          localObject2 = String.format(Locale.US, "-%s", new Object[] { localObject2 });
        if (this.h != null)
        {
          Locale localLocale = Locale.getDefault();
          if ((this.i == null) || (!localLocale.equals(this.j)))
          {
            this.j = localLocale;
            this.i = new Formatter(this.l, localLocale);
          }
          this.l.setLength(0);
          this.k[0] = localObject2;
        }
        try
        {
          this.i.format(this.h, this.k);
          String str = this.l.toString();
          localObject2 = str;
          setText((CharSequence)localObject2);
          return;
          l1 = paramLong - this.b;
        }
        catch (IllegalFormatException localIllegalFormatException)
        {
          while (true)
            if (!this.g)
              this.g = true;
        }
      }
    }
    finally
    {
    }
  }

  private void d()
  {
    this.b = SystemClock.elapsedRealtime();
    a(this.b);
  }

  private void e()
  {
    boolean bool;
    if ((this.d) && (this.e))
    {
      bool = true;
      if (bool != this.f)
      {
        if (!bool)
          break label43;
        f();
      }
    }
    while (true)
    {
      this.f = bool;
      return;
      bool = false;
      break;
      label43: removeCallbacks(this.q);
    }
  }

  private void f()
  {
    a(SystemClock.elapsedRealtime());
    c();
    long l1 = 1000L - (this.c - this.b) % 1000L;
    postDelayed(this.q, l1);
  }

  public void a()
  {
    this.e = true;
    e();
  }

  public void b()
  {
    this.e = false;
    e();
  }

  void c()
  {
    if (this.m != null)
      this.m.a(this);
  }

  public long getBase()
  {
    return this.b;
  }

  public String getFormat()
  {
    return this.h;
  }

  public a getOnChronometerTickListener()
  {
    return this.m;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.p)
    {
      this.d = true;
      e();
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d = false;
    e();
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (!this.p)
      if (paramInt != 0)
        break label28;
    label28: for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      e();
      return;
    }
  }

  public void setBase(long paramLong)
  {
    this.b = paramLong;
    c();
    a(SystemClock.elapsedRealtime());
  }

  public void setCountDown(boolean paramBoolean)
  {
    this.o = paramBoolean;
    a(SystemClock.elapsedRealtime());
  }

  public void setFormat(String paramString)
  {
    this.h = paramString;
    if ((paramString != null) && (this.l == null))
      this.l = new StringBuilder(2 * paramString.length());
  }

  public void setOnChronometerTickListener(a parama)
  {
    this.m = parama;
  }

  public void setStarted(boolean paramBoolean)
  {
    this.e = paramBoolean;
    e();
  }

  public final void setUseLightVisibilityStrategy(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public static abstract interface a
  {
    public abstract void a(AccurateChronometer paramAccurateChronometer);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.AccurateChronometer
 * JD-Core Version:    0.6.2
 */