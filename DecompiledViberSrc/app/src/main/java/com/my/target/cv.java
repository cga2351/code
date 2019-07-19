package com.my.target;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;

public final class cv extends ViewGroup
{
  private static final int a = bj.a();
  private static final int b = bj.a();
  private final TextView c;
  private final at d;
  private final int e;
  private final int f;

  public cv(Context paramContext)
  {
    super(paramContext);
    bj localbj = bj.a(paramContext);
    this.c = new TextView(paramContext);
    this.d = new at(paramContext);
    this.c.setId(a);
    this.d.setId(b);
    this.d.setLines(1);
    this.c.setTextSize(2, 18.0F);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    this.c.setMaxLines(1);
    this.c.setTextColor(-1);
    this.e = localbj.c(4);
    this.f = localbj.c(2);
    bj.a(this.c, "title_text");
    bj.a(this.d, "age_bordering");
    addView(this.c);
    addView(this.d);
  }

  public final TextView getLeftText()
  {
    return this.c;
  }

  public final at getRightBorderedView()
  {
    return this.d;
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.c.getMeasuredWidth();
    int j = this.c.getMeasuredHeight();
    int k = this.d.getMeasuredWidth();
    int m = this.d.getMeasuredHeight();
    int n = getMeasuredHeight();
    int i1 = (n - j) / 2;
    int i2 = (n - m) / 2;
    int i3 = i + this.e;
    this.c.layout(0, i1, i, j + i1);
    this.d.layout(i3, i2, i3 + k, i2 + m);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    this.d.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j - 2 * this.f, -2147483648));
    if (this.d.getMeasuredWidth() > i / 2)
      this.d.measure(View.MeasureSpec.makeMeasureSpec(i / 2, -2147483648), View.MeasureSpec.makeMeasureSpec(j - 2 * this.f, -2147483648));
    this.c.measure(View.MeasureSpec.makeMeasureSpec(i - this.d.getMeasuredWidth() - this.e, -2147483648), View.MeasureSpec.makeMeasureSpec(j - 2 * this.f, -2147483648));
    setMeasuredDimension(this.c.getMeasuredWidth() + this.d.getMeasuredWidth() + this.e, Math.max(this.c.getMeasuredHeight(), this.d.getMeasuredHeight()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cv
 * JD-Core Version:    0.6.2
 */