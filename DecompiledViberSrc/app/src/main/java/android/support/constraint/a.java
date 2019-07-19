package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.a.a.g;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class a extends View
{
  protected int[] a = new int[32];
  protected int b = 0;
  protected Context c;
  protected g d = null;
  protected boolean e = false;
  private String f;

  public a(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    a(null);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    a(paramAttributeSet);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    a(paramAttributeSet);
  }

  private void a(String paramString)
  {
    if (paramString == null);
    while (this.c == null)
      return;
    String str = paramString.trim();
    while (true)
    {
      int i;
      try
      {
        int k = R.id.class.getField(str).getInt(null);
        i = k;
        if (i == 0)
          i = this.c.getResources().getIdentifier(str, "id", this.c.getPackageName());
        if ((i == 0) && (isInEditMode()) && ((getParent() instanceof ConstraintLayout)))
        {
          Object localObject = ((ConstraintLayout)getParent()).a(0, str);
          if ((localObject != null) && ((localObject instanceof Integer)))
          {
            j = ((Integer)localObject).intValue();
            if (j != 0)
            {
              setTag(j, null);
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
        Log.w("ConstraintHelper", "Could not find id of \"" + str + "\"");
        return;
      }
      int j = i;
    }
  }

  private void setIds(String paramString)
  {
    if (paramString == null)
      return;
    int j;
    for (int i = 0; ; i = j + 1)
    {
      j = paramString.indexOf(',', i);
      if (j == -1)
      {
        a(paramString.substring(i));
        return;
      }
      a(paramString.substring(i, j));
    }
  }

  public void a()
  {
    if (this.d == null);
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = getLayoutParams();
    }
    while (!(localLayoutParams instanceof ConstraintLayout.a));
    ((ConstraintLayout.a)localLayoutParams).al = this.d;
  }

  public void a(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode())
      setIds(this.f);
    if (this.d == null);
    while (true)
    {
      return;
      this.d.K();
      for (int i = 0; i < this.b; i++)
      {
        View localView = paramConstraintLayout.findViewById(this.a[i]);
        if (localView != null)
          this.d.c(paramConstraintLayout.a(localView));
      }
    }
  }

  protected void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = localTypedArray.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = localTypedArray.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids)
        {
          this.f = localTypedArray.getString(k);
          setIds(this.f);
        }
      }
    }
  }

  public void b(ConstraintLayout paramConstraintLayout)
  {
  }

  public void c(ConstraintLayout paramConstraintLayout)
  {
  }

  public int[] getReferencedIds()
  {
    return Arrays.copyOf(this.a, this.b);
  }

  public void onDraw(Canvas paramCanvas)
  {
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.e)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(0, 0);
  }

  public void setReferencedIds(int[] paramArrayOfInt)
  {
    int i = 0;
    this.b = 0;
    while (i < paramArrayOfInt.length)
    {
      setTag(paramArrayOfInt[i], null);
      i++;
    }
  }

  public void setTag(int paramInt, Object paramObject)
  {
    if (1 + this.b > this.a.length)
      this.a = Arrays.copyOf(this.a, 2 * this.a.length);
    this.a[this.b] = paramInt;
    this.b = (1 + this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a
 * JD-Core Version:    0.6.2
 */