package android.support.constraint;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class Barrier extends a
{
  private int f = 0;
  private int g = 0;
  private android.support.constraint.a.a.a h;

  public Barrier(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }

  public Barrier(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setVisibility(8);
  }

  public Barrier(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setVisibility(8);
  }

  protected void a(AttributeSet paramAttributeSet)
  {
    super.a(paramAttributeSet);
    this.h = new android.support.constraint.a.a.a();
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = localTypedArray.getIndexCount();
      int j = 0;
      if (j < i)
      {
        int k = localTypedArray.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_barrierDirection)
          setType(localTypedArray.getInt(k, 0));
        while (true)
        {
          j++;
          break;
          if (k == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets)
            this.h.a(localTypedArray.getBoolean(k, true));
        }
      }
    }
    this.d = this.h;
    a();
  }

  public int getType()
  {
    return this.f;
  }

  public void setType(int paramInt)
  {
    this.f = paramInt;
    this.g = paramInt;
    if (Build.VERSION.SDK_INT < 17)
      if (this.f == 5)
        this.g = 0;
    while (true)
    {
      this.h.a(this.g);
      return;
      if (this.f == 6)
      {
        this.g = 1;
        continue;
        int i;
        if (1 == getResources().getConfiguration().getLayoutDirection())
          i = 1;
        while (true)
          if (i != 0)
          {
            if (this.f == 5)
            {
              this.g = 1;
              break;
              i = 0;
              continue;
            }
            if (this.f != 6)
              break;
            this.g = 0;
            break;
          }
        if (this.f == 5)
          this.g = 0;
        else if (this.f == 6)
          this.g = 1;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.Barrier
 * JD-Core Version:    0.6.2
 */