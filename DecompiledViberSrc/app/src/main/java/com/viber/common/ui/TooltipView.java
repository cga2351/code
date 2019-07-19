package com.viber.common.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import com.viber.common.R.dimen;

class TooltipView extends AppCompatTextView
{
  private static final c.a a = c.a.a;
  private static final c.d b = c.d.b;
  private Point c;
  private Point d;
  private final int[] e = new int[2];
  private final RectF f = new RectF();
  private float g;
  private float h;
  private float i;
  private boolean j;
  private c.d k;
  private c.a l;
  private Paint m;
  private Path n;
  private Path o;
  private Region p;
  private Region q;
  private Region r;
  private Matrix s;

  public TooltipView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  private void a()
  {
    getLocationOnScreen(this.e);
    this.d.x = (this.c.x - this.e[0]);
    this.d.y = (this.c.y - this.e[1]);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.m = new Paint(1);
    this.m.setStyle(Paint.Style.FILL);
    this.n = new Path();
    this.o = new Path();
    this.c = new Point();
    this.d = new Point();
    this.l = a;
    this.j = true;
    this.k = b;
    if (Build.VERSION.SDK_INT < 19)
    {
      this.p = new Region();
      this.q = new Region();
      this.r = new Region();
      this.s = new Matrix();
      this.s.setScale(1.0F, 1.0F, 0.0F, 0.0F);
    }
    Resources localResources = paramContext.getResources();
    this.g = localResources.getDimension(R.dimen.vc__tooltip_tail_height);
    this.h = localResources.getDimension(R.dimen.vc__tooltip_tail_width);
    this.i = localResources.getDimension(R.dimen.vc__tooltip_tail_delta_height);
    setTextSize(0, localResources.getDimensionPixelOffset(R.dimen.vc__tooltip_text_size));
    setGravity(8388627);
  }

  private void a(Canvas paramCanvas)
  {
    this.n.reset();
    this.o.reset();
    this.f.setEmpty();
    float f1;
    if (this.j)
    {
      f1 = this.g;
      switch (1.a[this.l.ordinal()])
      {
      default:
        this.n.moveTo(this.d.x - this.h / 2.0F, this.d.y - f1 - this.i);
        this.n.rCubicTo(4.0F + this.h / 2.0F, f1 + this.i, this.h / 2.0F - 4.0F, f1 + this.i, this.h, 0.0F);
        this.f.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight() - f1);
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      float f2 = this.f.height() / this.k.c;
      this.o.addRoundRect(this.f, f2, f2, Path.Direction.CCW);
      if (this.j)
        b();
      paramCanvas.drawPath(this.o, this.m);
      return;
      f1 = 0.0F;
      break;
      this.n.moveTo(this.d.x - f1 - this.i, this.d.y - this.h / 2.0F);
      this.n.rCubicTo(f1 + this.i, 4.0F + this.h / 2.0F, f1 + this.i, this.h / 2.0F - 4.0F, 0.0F, this.h);
      this.f.set(0.0F, 0.0F, paramCanvas.getWidth() - 2.0F * f1, paramCanvas.getHeight());
      continue;
      this.n.moveTo(f1 + this.d.x + this.i, this.d.y - this.h / 2.0F);
      this.n.rCubicTo(-(f1 + this.i), 4.0F + this.h / 2.0F, -(f1 + this.i), this.h / 2.0F - 4.0F, 0.0F, this.h);
      this.f.set(f1, 0.0F, paramCanvas.getWidth() - f1, paramCanvas.getHeight());
      continue;
      this.n.moveTo(this.d.x - this.h / 2.0F, f1 + this.d.y + this.i);
      this.n.rCubicTo(4.0F + this.h / 2.0F, -(f1 + this.i), this.h / 2.0F - 4.0F, -(f1 + this.i), this.h, 0.0F);
      this.f.set(0.0F, f1, paramCanvas.getWidth(), paramCanvas.getHeight());
    }
  }

  private void b()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.o.op(this.n, Path.Op.UNION);
      return;
    }
    this.r.setPath(this.o, this.p);
    this.q.setPath(this.n, this.p);
    this.r.op(this.q, Region.Op.UNION);
    this.o.reset();
    this.r.getBoundaryPath(this.o);
    this.o.close();
    this.o.transform(this.s);
  }

  public void a(int paramInt)
  {
    this.m.setColor(paramInt);
  }

  public void a(Point paramPoint)
  {
    this.c = paramPoint;
    a();
  }

  public void a(c.a parama)
  {
    this.l = parama;
  }

  public void a(c.d paramd)
  {
    if (paramd == null)
      paramd = b;
    this.k = paramd;
  }

  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    int i1 = paramCanvas.save();
    if (this.j)
      switch (1.a[this.l.ordinal()])
      {
      default:
        paramCanvas.translate(0.0F, -this.g / 2.0F);
      case 1:
      case 2:
      case 3:
      }
    while (true)
    {
      super.onDraw(paramCanvas);
      paramCanvas.restoreToCount(i1);
      return;
      paramCanvas.translate(-this.g / 2.0F, 0.0F);
      continue;
      paramCanvas.translate(this.g / 2.0F, 0.0F);
      continue;
      paramCanvas.translate(0.0F, this.g / 2.0F);
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      a();
      if (Build.VERSION.SDK_INT < 19)
        this.p.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.j)
      if ((this.l != c.a.c) && (this.l != c.a.d))
        break label95;
    label95: for (int i1 = (int)this.g; ; i1 = 0)
    {
      int i2;
      if (this.l != c.a.a)
      {
        c.a locala1 = this.l;
        c.a locala2 = c.a.b;
        i2 = 0;
        if (locala1 != locala2);
      }
      else
      {
        i2 = (int)this.g;
      }
      setMeasuredDimension(i1 + getMeasuredWidth(), i2 + getMeasuredHeight());
      return;
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.j = localSavedState.hasTail;
    this.k = localSavedState.tooltipShape;
    this.l = localSavedState.alignment;
    this.m.setColor(localSavedState.bgColor);
    this.d = localSavedState.localAnchor;
    this.c = localSavedState.globalAnchor;
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.hasTail = this.j;
    localSavedState.tooltipShape = this.k;
    localSavedState.alignment = this.l;
    localSavedState.bgColor = this.m.getColor();
    localSavedState.localAnchor = this.d;
    localSavedState.globalAnchor = this.c;
    return localSavedState;
  }

  static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public TooltipView.SavedState a(Parcel paramAnonymousParcel)
      {
        return new TooltipView.SavedState(paramAnonymousParcel);
      }

      public TooltipView.SavedState[] a(int paramAnonymousInt)
      {
        return new TooltipView.SavedState[paramAnonymousInt];
      }
    };
    c.a alignment;
    int bgColor;
    Point globalAnchor;
    boolean hasTail;
    Point localAnchor;
    c.d tooltipShape;

    public SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.hasTail = bool;
        this.tooltipShape = c.d.values()[paramParcel.readInt()];
        this.alignment = c.a.values()[paramParcel.readInt()];
        this.bgColor = paramParcel.readInt();
        this.localAnchor = ((Point)paramParcel.readParcelable(Point.class.getClassLoader()));
        this.globalAnchor = ((Point)paramParcel.readParcelable(Point.class.getClassLoader()));
        return;
      }
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.hasTail);
      for (byte b = 1; ; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.tooltipShape.ordinal());
        paramParcel.writeInt(this.alignment.ordinal());
        paramParcel.writeInt(this.bgColor);
        paramParcel.writeParcelable(this.localAnchor, paramInt);
        paramParcel.writeParcelable(this.globalAnchor, paramInt);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.TooltipView
 * JD-Core Version:    0.6.2
 */