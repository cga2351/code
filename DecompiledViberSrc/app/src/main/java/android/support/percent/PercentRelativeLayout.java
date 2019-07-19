package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

@Deprecated
public class PercentRelativeLayout extends RelativeLayout
{
  private final a a = new a(this);

  public PercentRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }

  public PercentRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PercentRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected a a()
  {
    return new a(-1, -1);
  }

  public a a(AttributeSet paramAttributeSet)
  {
    return new a(getContext(), paramAttributeSet);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    if (this.a.b())
      super.onMeasure(paramInt1, paramInt2);
  }

  @Deprecated
  public static class a extends RelativeLayout.LayoutParams
    implements a.b
  {
    private a.a a;

    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.a = a.a(paramContext, paramAttributeSet);
    }

    public a.a a()
    {
      if (this.a == null)
        this.a = new a.a();
      return this.a;
    }

    protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      a.a(this, paramTypedArray, paramInt1, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.percent.PercentRelativeLayout
 * JD-Core Version:    0.6.2
 */