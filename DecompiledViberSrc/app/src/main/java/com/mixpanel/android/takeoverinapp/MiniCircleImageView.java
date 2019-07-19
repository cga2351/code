package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

public class MiniCircleImageView extends ImageView
{
  private Paint a;
  private int b;
  private int c;

  public MiniCircleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public MiniCircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public MiniCircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    this.a = new Paint(1);
    if (Build.VERSION.SDK_INT >= 23)
      this.a.setColor(getResources().getColor(17170443, null));
    while (true)
    {
      this.a.setStyle(Paint.Style.STROKE);
      float f = TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics());
      this.a.setStrokeWidth(f);
      return;
      this.a.setColor(getResources().getColor(17170443));
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = paramInt1;
    this.c = paramInt2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.takeoverinapp.MiniCircleImageView
 * JD-Core Version:    0.6.2
 */