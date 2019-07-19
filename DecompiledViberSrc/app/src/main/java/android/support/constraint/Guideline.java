package android.support.constraint;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class Guideline extends View
{
  public Guideline(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }

  public Guideline(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setVisibility(8);
  }

  public Guideline(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setVisibility(8);
  }

  public Guideline(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    super.setVisibility(8);
  }

  public void draw(Canvas paramCanvas)
  {
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }

  public void setGuidelineBegin(int paramInt)
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)getLayoutParams();
    locala.a = paramInt;
    setLayoutParams(locala);
  }

  public void setGuidelineEnd(int paramInt)
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)getLayoutParams();
    locala.b = paramInt;
    setLayoutParams(locala);
  }

  public void setGuidelinePercent(float paramFloat)
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)getLayoutParams();
    locala.c = paramFloat;
    setLayoutParams(locala);
  }

  public void setVisibility(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.Guideline
 * JD-Core Version:    0.6.2
 */