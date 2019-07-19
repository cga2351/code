package com.viber.voip.messages.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ui.d.f;
import com.viber.voip.util.dc;
import com.viber.voip.widget.AccurateChronometer;
import com.viber.voip.widget.AccurateChronometer.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RecordTimerView extends LinearLayout
{
  cm a;
  AccurateChronometer b;
  ImageView c;
  Set<a> d = new HashSet();
  AccurateChronometer.a e = new AccurateChronometer.a()
  {
    public void a(AccurateChronometer paramAnonymousAccurateChronometer)
    {
      RecordTimerView.a(RecordTimerView.this);
      if (RecordTimerView.b(RecordTimerView.this) >= RecordTimerView.this.a.a)
      {
        RecordTimerView.this.b();
        RecordTimerView.c(RecordTimerView.this);
      }
    }
  };
  private int f;
  private int g;
  private f h;
  private Drawable i;
  private int j = 0;

  public RecordTimerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public RecordTimerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public RecordTimerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setOrientation(0);
    setGravity(16);
    LayoutInflater.from(paramContext).inflate(R.layout.record_timer_view, this);
    this.b = ((AccurateChronometer)findViewById(R.id.time_text));
    this.b.setOnChronometerTickListener(this.e);
    this.c = ((ImageView)findViewById(R.id.record_animation));
    this.f = dc.d(paramContext, R.attr.textPrimaryColor);
    this.g = dc.d(paramContext, R.attr.conversationPttPreviewVoiceMessagesWarningTextColor);
    this.h = new f("svg/media_record_indicator.svg");
    this.i = ContextCompat.getDrawable(paramContext, R.drawable.red_point_stroke);
  }

  private void a(cm paramcm)
  {
    if (paramcm == null)
      paramcm = new cm();
    this.a = paramcm;
    c();
  }

  private void c()
  {
    this.b.setTextColor(this.f);
    this.c.setVisibility(0);
    this.c.setImageDrawable(this.h);
  }

  private void d()
  {
    if (getCurrentTime() >= this.a.b)
      this.b.setTextColor(this.g);
    if (getCurrentTime() >= this.a.a)
      this.c.setImageDrawable(this.i);
    e();
  }

  private void e()
  {
    int k = f();
    if (this.j < k)
    {
      this.j = k;
      this.b.getLayoutParams().width = -2;
      this.b.requestLayout();
    }
  }

  private int f()
  {
    CharSequence localCharSequence = this.b.getText();
    return (int)this.b.getPaint().measureText(localCharSequence, 0, localCharSequence.length());
  }

  private void g()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).e();
  }

  private long getCurrentTime()
  {
    return getCurrentTimeInMillis() / 1000L;
  }

  public void a()
  {
    c();
    if (this.a != null)
    {
      b();
      this.b.setBase(SystemClock.elapsedRealtime());
    }
  }

  public void a(a parama)
  {
    if (parama != null)
      this.d.add(parama);
  }

  public void a(cm paramcm, a parama)
  {
    b();
    a(paramcm);
    a(parama);
    this.b.setBase(SystemClock.elapsedRealtime());
    this.b.a();
  }

  public void b()
  {
    this.b.b();
  }

  public long getCurrentTimeInMillis()
  {
    return SystemClock.elapsedRealtime() - this.b.getBase();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
    this.d.clear();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    if ((localLayoutParams.width == -2) && (!TextUtils.isEmpty(this.b.getText())))
    {
      int k = this.b.getMeasuredWidth();
      int m = this.b.getMeasuredHeight();
      localLayoutParams.width = k;
      localLayoutParams.height = m;
      this.b.setLayoutParams(localLayoutParams);
      this.j = k;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static abstract interface a
  {
    public abstract void e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.RecordTimerView
 * JD-Core Version:    0.6.2
 */