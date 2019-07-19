package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import com.viber.dexshared.Logger;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.d.b;
import java.util.ArrayList;
import java.util.List;

public class GroupIconView extends View
{
  private static final Logger a = ViberEnv.getLogger();
  private static final SparseArray<int[]> b = new SparseArray();
  private final List<a> c = new ArrayList(4);
  private Rect d;
  private int e;
  private Drawable f;

  static
  {
    b.put(1, new int[] { 0 });
    b.put(2, new int[] { 1, 2 });
    b.put(3, new int[] { 1, 4, 6 });
    b.put(4, new int[] { 3, 4, 5, 6 });
  }

  public GroupIconView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public GroupIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public GroupIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private static Bitmap a(Drawable paramDrawable)
  {
    int i = Math.max(paramDrawable.getIntrinsicWidth(), 1);
    int j = Math.max(paramDrawable.getIntrinsicHeight(), 1);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ViberApplication.getInstance().onOutOfMemory();
    }
    return null;
  }

  private static Drawable a(Drawable paramDrawable, Context paramContext)
  {
    if (paramDrawable == null)
      paramDrawable = null;
    while (true)
    {
      return paramDrawable;
      if (!(paramDrawable instanceof b))
      {
        if ((paramDrawable instanceof com.viber.common.ui.a))
          return new b(paramContext, ((com.viber.common.ui.a)paramDrawable).b());
        if ((paramDrawable instanceof BitmapDrawable))
          return new b(paramContext, ((BitmapDrawable)paramDrawable).getBitmap());
        if (!(paramDrawable instanceof LayerDrawable))
          break;
        paramDrawable = (LayerDrawable)paramDrawable;
        int i = 0;
        int j = paramDrawable.getNumberOfLayers();
        while (i < j)
        {
          paramDrawable.setDrawableByLayerId(paramDrawable.getId(i), a(paramDrawable.getDrawable(i), paramContext));
          i++;
        }
      }
    }
    return new b(paramContext, a(paramDrawable));
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GroupIconView);
    try
    {
      setMaxIcons(localTypedArray.getInt(R.styleable.GroupIconView_maxIcons, 4));
      Drawable localDrawable1 = localTypedArray.getDrawable(R.styleable.GroupIconView_icon4);
      if (localDrawable1 != null)
        a(-4, localDrawable1);
      Drawable localDrawable2 = localTypedArray.getDrawable(R.styleable.GroupIconView_icon3);
      if (localDrawable2 != null)
        a(-3, localDrawable2);
      Drawable localDrawable3 = localTypedArray.getDrawable(R.styleable.GroupIconView_icon2);
      if (localDrawable3 != null)
        a(-2, localDrawable3);
      Drawable localDrawable4 = localTypedArray.getDrawable(R.styleable.GroupIconView_icon1);
      if (localDrawable4 != null)
        a(-1, localDrawable4);
      localTypedArray.recycle();
      this.d = new Rect();
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private void a(Canvas paramCanvas)
  {
    if (this.f == null)
      return;
    Drawable localDrawable = this.f;
    localDrawable.setBounds(0, 0, getWidth(), getHeight());
    localDrawable.draw(paramCanvas);
  }

  private int b(int paramInt)
  {
    for (int i = 0; i < this.c.size(); i++)
      if (paramInt == ((a)this.c.get(i)).a)
        return i;
    return -1;
  }

  private void c(int paramInt)
  {
    a locala = (a)this.c.remove(paramInt);
    if ((locala.b instanceof com.viber.voip.util.e.a))
    {
      AsyncTask localAsyncTask = ((com.viber.voip.util.e.a)locala.b).a();
      if (localAsyncTask != null)
        localAsyncTask.cancel(true);
    }
  }

  private static void c(int paramInt, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof b))
      ((b)paramDrawable).a(paramInt);
    while (true)
    {
      return;
      if ((paramDrawable instanceof LayerDrawable))
      {
        LayerDrawable localLayerDrawable = (LayerDrawable)paramDrawable;
        int i = 0;
        int j = localLayerDrawable.getNumberOfLayers();
        while (i < j)
        {
          c(paramInt, localLayerDrawable.getDrawable(i));
          i++;
        }
      }
    }
  }

  private void c(int paramInt, Drawable paramDrawable, boolean paramBoolean)
  {
    if (b(paramInt) != -1);
    do
    {
      return;
      if (this.c.size() == this.e)
        c(-1 + this.c.size());
      this.c.add(0, new a(paramInt, paramDrawable));
    }
    while ((!paramBoolean) || (!ViewCompat.isLaidOut(this)));
    invalidate();
  }

  private void d(int paramInt, Drawable paramDrawable, boolean paramBoolean)
  {
    int i = b(paramInt);
    if (i == -1);
    do
    {
      return;
      ((a)this.c.get(i)).b = paramDrawable;
    }
    while ((!paramBoolean) || (!ViewCompat.isLaidOut(this)));
    invalidate();
  }

  public Drawable a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    for (int i = 0; i < localArrayList.size(); i++)
    {
      a locala = (a)localArrayList.get(i);
      if (paramInt == locala.a)
        return locala.b;
    }
    return null;
  }

  public void a()
  {
    a(true);
  }

  public void a(int paramInt, Drawable paramDrawable)
  {
    a(paramInt, paramDrawable, true);
  }

  public void a(int paramInt, Drawable paramDrawable, boolean paramBoolean)
  {
    c(paramInt, a(paramDrawable, getContext()), paramBoolean);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    int i = 4;
    int j = 1;
    if (paramInt > i);
    while (true)
    {
      if (i < j);
      while (true)
      {
        if (this.e != j)
        {
          int k = this.e;
          this.e = j;
          if ((!this.c.isEmpty()) && (k > j))
          {
            while (this.c.size() > j)
              c(-1 + this.c.size());
            if ((paramBoolean) && (ViewCompat.isLaidOut(this)))
              invalidate();
          }
        }
        return;
        j = i;
      }
      i = paramInt;
    }
  }

  public void a(boolean paramBoolean)
  {
    for (int i = 0; i < this.c.size(); i++)
      c(i);
    if ((paramBoolean) && (ViewCompat.isLaidOut(this)))
      invalidate();
  }

  public void b(int paramInt, Drawable paramDrawable)
  {
    b(paramInt, paramDrawable, true);
  }

  public void b(int paramInt, Drawable paramDrawable, boolean paramBoolean)
  {
    d(paramInt, a(paramDrawable, getContext()), paramBoolean);
  }

  public int getMaxIcons()
  {
    return this.e;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.c.isEmpty());
    int[] arrayOfInt;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i5;
    Drawable localDrawable;
    while (true)
    {
      return;
      arrayOfInt = (int[])b.get(this.c.size());
      if (arrayOfInt != null)
      {
        i = this.d.width();
        j = this.d.height();
        k = getPaddingLeft();
        m = getPaddingTop();
        n = Math.round((i - 1) / 2);
        i1 = i - 1 - n;
        i2 = Math.round(j / 2);
        i3 = j - 1 - i2;
        int i4 = this.c.size();
        for (i5 = 0; i5 < i4; i5++)
        {
          localDrawable = ((a)this.c.get(i5)).b;
          if (localDrawable != null)
            break label154;
        }
      }
    }
    label154: int i6 = arrayOfInt[i5];
    c(i6, localDrawable);
    int i7;
    int i8;
    label215: int i9;
    int i11;
    int i10;
    switch (i6)
    {
    default:
      i7 = j;
      i8 = i;
      localDrawable.setBounds(0, 0, i8, i7);
      i9 = paramCanvas.save();
      switch (i6)
      {
      case 3:
      default:
        i11 = m;
        i10 = k;
      case 5:
      case 2:
      case 4:
      case 6:
      }
      break;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      paramCanvas.translate(i10, i11);
      localDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i9);
      a(paramCanvas);
      break;
      i7 = j;
      i8 = n;
      break label215;
      i7 = j;
      i8 = i1;
      break label215;
      i7 = i2;
      i8 = n;
      break label215;
      i7 = i2;
      i8 = i1;
      break label215;
      i7 = i3;
      i8 = n;
      break label215;
      i7 = i3;
      i8 = i1;
      break label215;
      i11 = m + (i2 + 1);
      i10 = k;
      continue;
      i10 = k + (n + 1);
      i11 = m;
      continue;
      i10 = k + (n + 1);
      i11 = m + (i2 + 1);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((View.MeasureSpec.getMode(paramInt1) == 1073741824) && (View.MeasureSpec.getMode(paramInt2) != 1073741824));
    super.onMeasure(paramInt1, paramInt2);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4))
      return;
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = paramInt1 - i - getPaddingRight();
    int m = paramInt2 - j - getPaddingBottom();
    this.d.set(0, 0, k, m);
  }

  public void setForeground(Drawable paramDrawable)
  {
    if (com.viber.common.d.a.j())
      super.setForeground(paramDrawable);
    do
    {
      do
        return;
      while (this.f == paramDrawable);
      this.f = paramDrawable;
    }
    while (!ViewCompat.isLaidOut(this));
    invalidate();
  }

  public void setMaxIcons(int paramInt)
  {
    a(paramInt, true);
  }

  static class a
  {
    final int a;
    Drawable b;

    a(int paramInt, Drawable paramDrawable)
    {
      this.a = paramInt;
      this.b = paramDrawable;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.GroupIconView
 * JD-Core Version:    0.6.2
 */