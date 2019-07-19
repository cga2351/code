package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.a.a.d;
import android.util.AttributeSet;
import android.view.View;

public class Placeholder extends View
{
  private int a = -1;
  private View b = null;
  private int c = 4;

  public Placeholder(Context paramContext)
  {
    super(paramContext);
    a(null);
  }

  public Placeholder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }

  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }

  public Placeholder(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramAttributeSet);
  }

  private void a(AttributeSet paramAttributeSet)
  {
    super.setVisibility(this.c);
    this.a = -1;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_placeholder);
      int i = localTypedArray.getIndexCount();
      int j = 0;
      if (j < i)
      {
        int k = localTypedArray.getIndex(j);
        if (k == R.styleable.ConstraintLayout_placeholder_content)
          this.a = localTypedArray.getResourceId(k, this.a);
        while (true)
        {
          j++;
          break;
          if (k == R.styleable.ConstraintLayout_placeholder_emptyVisibility)
            this.c = localTypedArray.getInt(k, this.c);
        }
      }
    }
  }

  public void a(ConstraintLayout paramConstraintLayout)
  {
    if ((this.a == -1) && (!isInEditMode()))
      setVisibility(this.c);
    this.b = paramConstraintLayout.findViewById(this.a);
    if (this.b != null)
    {
      ((ConstraintLayout.a)this.b.getLayoutParams()).aa = true;
      this.b.setVisibility(0);
      setVisibility(0);
    }
  }

  public void b(ConstraintLayout paramConstraintLayout)
  {
    if (this.b == null)
      return;
    ConstraintLayout.a locala1 = (ConstraintLayout.a)getLayoutParams();
    ConstraintLayout.a locala2 = (ConstraintLayout.a)this.b.getLayoutParams();
    locala2.al.e(0);
    locala1.al.h(locala2.al.o());
    locala1.al.i(locala2.al.q());
    locala2.al.e(8);
  }

  public View getContent()
  {
    return this.b;
  }

  public int getEmptyVisibility()
  {
    return this.c;
  }

  public void onDraw(Canvas paramCanvas)
  {
    if (isInEditMode())
    {
      paramCanvas.drawRGB(223, 223, 223);
      Paint localPaint = new Paint();
      localPaint.setARGB(255, 210, 210, 210);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Rect localRect = new Rect();
      paramCanvas.getClipBounds(localRect);
      localPaint.setTextSize(localRect.height());
      int i = localRect.height();
      int j = localRect.width();
      localPaint.setTextAlign(Paint.Align.LEFT);
      localPaint.getTextBounds("?", 0, "?".length(), localRect);
      paramCanvas.drawText("?", j / 2.0F - localRect.width() / 2.0F - localRect.left, i / 2.0F + localRect.height() / 2.0F - localRect.bottom, localPaint);
    }
  }

  public void setContentId(int paramInt)
  {
    if (this.a == paramInt);
    View localView;
    do
    {
      do
      {
        return;
        if (this.b != null)
        {
          this.b.setVisibility(0);
          ((ConstraintLayout.a)this.b.getLayoutParams()).aa = false;
          this.b = null;
        }
        this.a = paramInt;
      }
      while (paramInt == -1);
      localView = ((View)getParent()).findViewById(paramInt);
    }
    while (localView == null);
    localView.setVisibility(8);
  }

  public void setEmptyVisibility(int paramInt)
  {
    this.c = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.Placeholder
 * JD-Core Version:    0.6.2
 */