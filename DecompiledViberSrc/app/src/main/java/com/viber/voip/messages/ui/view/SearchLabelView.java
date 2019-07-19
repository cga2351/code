package com.viber.voip.messages.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.dc;

public class SearchLabelView extends ViberTextView
{
  private Paint a;
  private boolean b;

  public SearchLabelView(Context paramContext)
  {
    super(paramContext);
  }

  public SearchLabelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SearchLabelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    this.a = new Paint();
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setColor(dc.d(getContext(), R.attr.listItemDivider));
    this.a.setStrokeWidth(getResources().getDimensionPixelOffset(R.dimen.formatted_separator_divider_height));
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b)
      paramCanvas.drawLine(0.0F, getHeight() - this.a.getStrokeWidth(), getWidth(), getHeight() - this.a.getStrokeWidth(), this.a);
  }

  public void setShowBottomLine(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      if ((this.b) && (this.a == null))
        a();
      invalidate();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.SearchLabelView
 * JD-Core Version:    0.6.2
 */