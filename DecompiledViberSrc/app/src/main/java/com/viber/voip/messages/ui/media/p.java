package com.viber.voip.messages.ui.media;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.av.e;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.widget.d;
import com.viber.voip.widget.d.a;

public class p extends RelativeLayout
  implements Runnable
{
  private final int a = 60000;
  private final int b = 25;
  private final int c = 1000;
  private d d;
  private ImageButton e;
  private ViberTextView f;
  private CountDownTimer g;
  private long h;
  private a i;

  public p(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void a()
  {
    b();
  }

  private void b()
  {
    Context localContext = getContext();
    Resources localResources = localContext.getResources();
    this.e = new ImageButton(localContext);
    this.e.setImageResource(R.drawable.ic_close_wink_action_selector);
    this.e.setBackgroundResource(0);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(9);
    localLayoutParams1.addRule(15);
    int j = localResources.getDimensionPixelSize(R.dimen.wink_close_btn_margin);
    this.e.setPadding(j, j, 0, 0);
    this.e.setLayoutParams(localLayoutParams1);
    this.e.setId(R.id.wink_view_media_close_button);
    addView(this.e);
    this.d = new d(localContext);
    int k = localResources.getDimensionPixelSize(R.dimen.wink_countdown_progress_width);
    int m = localResources.getDimensionPixelSize(R.dimen.wink_countdown_progress_padding);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams2.addRule(11);
    localLayoutParams2.rightMargin = m;
    localLayoutParams2.topMargin = m;
    this.d.setLayoutParams(localLayoutParams2);
    this.d.setInvertedProgress(true);
    this.d.setId(R.id.wink_view_media_timer);
    addView(this.d);
    this.f = new ViberTextView(localContext);
    int n = localResources.getDimensionPixelOffset(R.dimen.wink_title_padding);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams3.addRule(1, R.id.wink_view_media_close_button);
    localLayoutParams3.addRule(0, R.id.wink_view_media_timer);
    localLayoutParams3.addRule(15);
    this.f.setTextColor(localResources.getColor(R.color.negative));
    this.f.setTextSize(0, localResources.getDimensionPixelSize(R.dimen.wink_media_activity_title_size));
    this.f.setPadding(n, n, n, 0);
    this.f.setSingleLine(true);
    this.f.setLayoutParams(localLayoutParams3);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    addView(this.f);
  }

  public void a(long paramLong, a parama, boolean paramBoolean)
  {
    setWinkTimerCallback(parama);
    long l1;
    if (paramLong > 60000L)
    {
      l1 = 1000L;
      if (paramLong <= 1000L)
        break label121;
    }
    label121: for (long l2 = 1000L + paramLong; ; l2 = paramLong)
    {
      this.g = new CountDownTimer(l2, l1)
      {
        public void onFinish()
        {
          p.a(p.this, 0L);
          if (p.b(p.this) != null)
            p.b(p.this).P_();
        }

        public void onTick(long paramAnonymousLong)
        {
          p.a(p.this, paramAnonymousLong);
          p.this.setBombCountDownText(p.a(p.this));
        }
      };
      this.h = paramLong;
      this.d.a((int)this.h, d.a.b);
      this.d.setMin(1);
      this.d.setTextDisplayUnit(d.a.c);
      this.d.a(paramBoolean);
      setBombCountDownText(this.h);
      this.g.start();
      return;
      l1 = 25L;
      break;
    }
  }

  public View getCloseButton()
  {
    return this.e;
  }

  public long getTimeUntilFinish()
  {
    return this.h;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    av.e.a.a().removeCallbacks(this);
    if (this.g != null)
      this.g.cancel();
  }

  public void run()
  {
    if (this.g != null)
      this.g.cancel();
    if (this.i != null)
      this.i.P_();
  }

  public void setBombCountDownText(long paramLong)
  {
    this.d.setProgress((int)paramLong);
  }

  public void setTitleText(String paramString)
  {
    this.f.setText(paramString);
  }

  public void setWinkTimerCallback(a parama)
  {
    this.i = parama;
  }

  static abstract interface a
  {
    public abstract void P_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.p
 * JD-Core Version:    0.6.2
 */