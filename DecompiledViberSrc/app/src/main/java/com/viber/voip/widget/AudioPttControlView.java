package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;

public class AudioPttControlView extends ag
{
  private static Logger c = ViberEnv.getLogger();
  private final ag.g d = new ag.g("svg/audio_ptt_circle_black.svg");
  private final ag.g e = new ag.g("svg/audio_ptt_circle_purple.svg");
  private final ag.g f = new ag.g("svg/audio_ptt_loader.svg");

  public AudioPttControlView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public AudioPttControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public AudioPttControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AudioPttControlView);
    this.d.a(localTypedArray.getColor(R.styleable.AudioPttControlView_circleColor, ContextCompat.getColor(paramContext, R.color.voice_msg_progress_default_color)));
    this.e.a(localTypedArray.getColor(R.styleable.AudioPttControlView_unreadCircleColor, ContextCompat.getColor(paramContext, R.color.voice_msg_progress_unread_color)));
    this.f.a(localTypedArray.getColor(R.styleable.AudioPttControlView_loaderColor, ContextCompat.getColor(paramContext, R.color.voice_msg_progress_download_color)));
    localTypedArray.recycle();
  }

  public void a(double paramDouble)
  {
    if (this.a[0] != this.f)
    {
      this.a[0] = this.f;
      this.f.setClock(new ag.d(this.f.a()));
    }
    ((ag.d)this.f.b()).b(paramDouble);
    invalidate();
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (ag.g localg = this.e; ; localg = this.d)
    {
      if (this.a[0] != localg)
      {
        this.a[0] = localg;
        invalidate();
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.AudioPttControlView
 * JD-Core Version:    0.6.2
 */