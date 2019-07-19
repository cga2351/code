package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class c extends ViewGroup
{
  b a;

  protected a a()
  {
    return new a(-2, -2);
  }

  public a a(AttributeSet paramAttributeSet)
  {
    return new a(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.a(paramLayoutParams);
  }

  public b getConstraintSet()
  {
    if (this.a == null)
      this.a = new b();
    this.a.a(this);
    return this.a;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  public static class a extends ConstraintLayout.a
  {
    public float an = 1.0F;
    public boolean ao = false;
    public float ap = 0.0F;
    public float aq = 0.0F;
    public float ar = 0.0F;
    public float as = 0.0F;
    public float at = 1.0F;
    public float au = 1.0F;
    public float av = 0.0F;
    public float aw = 0.0F;
    public float ax = 0.0F;
    public float ay = 0.0F;
    public float az = 0.0F;

    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
      int j = localTypedArray.getIndexCount();
      if (i < j)
      {
        int k = localTypedArray.getIndex(i);
        if (k == R.styleable.ConstraintSet_android_alpha)
          this.an = localTypedArray.getFloat(k, this.an);
        while (true)
        {
          i++;
          break;
          if (k == R.styleable.ConstraintSet_android_elevation)
          {
            this.ap = localTypedArray.getFloat(k, this.ap);
            this.ao = true;
          }
          else if (k == R.styleable.ConstraintSet_android_rotationX)
          {
            this.ar = localTypedArray.getFloat(k, this.ar);
          }
          else if (k == R.styleable.ConstraintSet_android_rotationY)
          {
            this.as = localTypedArray.getFloat(k, this.as);
          }
          else if (k == R.styleable.ConstraintSet_android_rotation)
          {
            this.aq = localTypedArray.getFloat(k, this.aq);
          }
          else if (k == R.styleable.ConstraintSet_android_scaleX)
          {
            this.at = localTypedArray.getFloat(k, this.at);
          }
          else if (k == R.styleable.ConstraintSet_android_scaleY)
          {
            this.au = localTypedArray.getFloat(k, this.au);
          }
          else if (k == R.styleable.ConstraintSet_android_transformPivotX)
          {
            this.av = localTypedArray.getFloat(k, this.av);
          }
          else if (k == R.styleable.ConstraintSet_android_transformPivotY)
          {
            this.aw = localTypedArray.getFloat(k, this.aw);
          }
          else if (k == R.styleable.ConstraintSet_android_translationX)
          {
            this.ax = localTypedArray.getFloat(k, this.ax);
          }
          else if (k == R.styleable.ConstraintSet_android_translationY)
          {
            this.ay = localTypedArray.getFloat(k, this.ay);
          }
          else if (k == R.styleable.ConstraintSet_android_translationZ)
          {
            this.ax = localTypedArray.getFloat(k, this.az);
          }
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.c
 * JD-Core Version:    0.6.2
 */