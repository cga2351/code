package com.yandex.mobile.ads.nativeads.template;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.Layout;
import android.widget.TextView;
import com.yandex.mobile.ads.impl.dh;

final class g extends TextView
{
  private Rect a = new Rect();
  private Paint b = new Paint();
  private int c = dh.a(getContext(), 1.0F);
  private int d = dh.a(getContext(), 4.0F);

  public g(Context paramContext)
  {
    super(paramContext);
  }

  protected final void onDraw(Canvas paramCanvas)
  {
    int i = dh.a(getCurrentTextColor(), 85.0F);
    Paint localPaint = this.b;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.c);
    localPaint.setColor(i);
    int j = getLineCount();
    Layout localLayout = getLayout();
    for (int k = 0; k < j; k++)
    {
      int m = getLineBounds(k, this.a);
      int n = localLayout.getLineStart(k);
      int i1 = localLayout.getLineEnd(k);
      float f1 = localLayout.getPrimaryHorizontal(n);
      float f2 = localLayout.getPrimaryHorizontal(n + 1) - f1 + localLayout.getPrimaryHorizontal(i1 - 1);
      paramCanvas.drawLine(f1, m + this.d, f2, m + this.d, localPaint);
    }
    super.onDraw(paramCanvas);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.g
 * JD-Core Version:    0.6.2
 */