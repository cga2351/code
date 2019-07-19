package com.viber.voip.phone;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.viber.voip.R.styleable;
import com.viber.voip.widget.PausableChronometer;

public class VideoCallTitleName extends PausableChronometer
{
  private int mRotation;

  public VideoCallTitleName(Context paramContext)
  {
    this(paramContext, null);
  }

  public VideoCallTitleName(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.VideoCall);
    this.mRotation = localTypedArray.getInt(R.styleable.VideoCall_rotation, 0);
    localTypedArray.recycle();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mRotation == 90) || (this.mRotation == 270))
    {
      TextPaint localTextPaint = getPaint();
      localTextPaint.setColor(getCurrentTextColor());
      localTextPaint.drawableState = getDrawableState();
      paramCanvas.save();
      if (this.mRotation == 90)
      {
        paramCanvas.translate(getWidth(), 0.0F);
        paramCanvas.rotate(90.0F);
      }
    }
    try
    {
      while (true)
      {
        paramCanvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop());
        label84: Layout localLayout = getLayout();
        if (localLayout != null)
          localLayout.draw(paramCanvas);
        paramCanvas.restore();
        return;
        if (this.mRotation == 270)
        {
          paramCanvas.translate(0.0F, getHeight());
          paramCanvas.rotate(270.0F);
        }
      }
      super.onDraw(paramCanvas);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label84;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mRotation == 90) || (this.mRotation == 270))
    {
      super.onMeasure(paramInt2, paramInt1);
      setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.VideoCallTitleName
 * JD-Core Version:    0.6.2
 */