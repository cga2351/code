package com.viber.voip.camrecorder.b;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.camrecorder.CustomCamTakeVideoActivity;
import java.util.Locale;

public class a extends b<TextView>
{
  private static final long c = CustomCamTakeVideoActivity.G - 10L;
  private final int d;
  private final int e;

  public a(View paramView1, View paramView2)
  {
    super(paramView1, paramView2);
    this.d = ContextCompat.getColor(paramView1.getContext(), R.color.negative);
    this.e = ContextCompat.getColor(paramView1.getContext(), R.color.timer_last_seconds);
  }

  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public void a(long paramLong)
  {
    long l = (int)Math.min(CustomCamTakeVideoActivity.G, paramLong / 1000L);
    int i = (int)(l % 60L);
    int j = (int)(l / 60L % 60L);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Locale localLocale1 = Locale.US;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(j);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(String.format(localLocale1, "%02d", arrayOfObject1)).append(":");
    Locale localLocale2 = Locale.US;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Integer.valueOf(i);
    String str = String.format(localLocale2, "%02d", arrayOfObject2);
    if (!str.equals(((TextView)this.a).getText()))
      ((TextView)this.a).setText(str);
    if (l < c);
    for (int k = this.d; ; k = this.e)
    {
      if (((TextView)this.a).getCurrentTextColor() != k)
        ((TextView)this.a).setTextColor(k);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.b.a
 * JD-Core Version:    0.6.2
 */