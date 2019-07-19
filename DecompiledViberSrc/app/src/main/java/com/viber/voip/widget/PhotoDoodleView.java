package com.viber.voip.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnTouchListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.extras.image.imagezoom.ImageViewTouch;
import com.viber.voip.messages.extras.image.imagezoom.b.a;
import com.viber.voip.util.dq;
import com.viber.voip.util.e.j;
import java.io.IOException;

public class PhotoDoodleView extends ImageViewTouch
{
  private static final Logger w = ViberEnv.getLogger();
  private static float x = 10.0F;
  private b A;
  private Bitmap B;
  private Canvas C;
  private Path D;
  private Path E;
  private Paint F;
  private Paint G;
  private Paint H;
  private Paint I;
  private final RectF J = new RectF();
  private float K;
  private float L;
  private Bitmap M;
  private float N;
  private float O;
  private boolean P;
  private a Q;
  private boolean y;
  private boolean z;

  public PhotoDoodleView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public PhotoDoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private static Bitmap a(Context paramContext, String paramString)
  {
    AssetManager localAssetManager = paramContext.getAssets();
    try
    {
      Bitmap localBitmap = dq.a(localAssetManager.open(paramString));
      return localBitmap;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  private void a(Context paramContext)
  {
    this.A = b.a;
    this.D = new Path();
    this.E = new Path();
    this.H = m();
    this.I = m();
    this.F = new Paint(6);
    f();
  }

  private static void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      paramBitmap.recycle();
  }

  private void a(boolean paramBoolean)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null)
      return;
    if ((this.B == null) || (this.B.isRecycled()) || (paramBoolean))
    {
      a(this.B);
      this.B = null;
      Rect localRect = localDrawable.getBounds();
      this.B = b(localRect.width(), localRect.height());
    }
    if (this.B != null)
      this.C = new Canvas(this.B);
    l();
  }

  private Bitmap b(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap1 = localBitmap2;
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a locala;
      do
      {
        ViberApplication.getInstance().onOutOfMemory();
        locala = this.Q;
        Bitmap localBitmap1 = null;
      }
      while (locala == null);
      this.Q.c();
    }
    return null;
  }

  private void f(float paramFloat1, float paramFloat2)
  {
    switch (1.a[this.A.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      this.P = true;
      this.N = paramFloat1;
      this.O = paramFloat2;
      return;
      this.D.reset();
      this.E.reset();
      Matrix localMatrix = getImageViewMatrix();
      float f1 = a(localMatrix, 2);
      float f2 = a(localMatrix, 5);
      this.D.moveTo(paramFloat1, paramFloat2);
      this.E.moveTo((paramFloat1 - f1) / this.L, (paramFloat2 - f2) / this.L);
      continue;
      h(paramFloat1, paramFloat2);
    }
  }

  private void g(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.abs(paramFloat1 - this.N);
    float f2 = Math.abs(paramFloat2 - this.O);
    float f3;
    float f4;
    float f5;
    float f6;
    if ((f1 >= x) || (f2 >= x))
    {
      Matrix localMatrix = getImageViewMatrix();
      f3 = a(localMatrix, 2);
      f4 = a(localMatrix, 5);
      f5 = (this.N - f3) / this.L;
      f6 = (this.O - f4) / this.L;
      this.P = false;
      switch (1.a[this.A.ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      this.N = paramFloat1;
      this.O = paramFloat2;
      return;
      this.D.quadTo(this.N, this.O, (paramFloat1 + this.N) / 2.0F, (paramFloat2 + this.O) / 2.0F);
      this.E.quadTo(f5, f6, (f5 + (paramFloat1 - f3) / this.L) / 2.0F, (f6 + (paramFloat2 - f4) / this.L) / 2.0F);
      continue;
      this.E.quadTo(f5, f6, (f5 + (paramFloat1 - f3) / this.L) / 2.0F, (f6 + (paramFloat2 - f4) / this.L) / 2.0F);
      this.C.drawPath(this.E, this.I);
      continue;
      if ((f1 >= 1.5D * x) || (f2 >= 1.5D * x))
      {
        Path localPath = new Path();
        localPath.moveTo(this.N, this.O);
        localPath.quadTo(this.N, this.O, paramFloat1, paramFloat2);
        PathMeasure localPathMeasure = new PathMeasure(localPath, false);
        float f7 = 0.0F;
        float f8 = localPathMeasure.getLength();
        while (f7 < f8)
        {
          float[] arrayOfFloat = { 0.0F, 0.0F };
          localPathMeasure.getPosTan(f7, arrayOfFloat, null);
          float f9 = arrayOfFloat[0];
          float f10 = arrayOfFloat[1];
          float f11 = Math.abs(f9 - this.N);
          float f12 = Math.abs(f10 - this.O);
          if ((f11 >= x) || (f12 >= x))
          {
            h(f9, f10);
            this.N = f9;
            this.O = f10;
          }
          f7 += 1.0F;
        }
        paramFloat1 = this.N;
        paramFloat2 = this.O;
      }
      else
      {
        h(paramFloat1, paramFloat2);
      }
    }
  }

  private void h()
  {
    if (this.P)
      i();
    while (true)
    {
      this.D.reset();
      this.E.reset();
      return;
      j();
    }
  }

  private void h(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageViewMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    this.C.drawBitmap(this.M, (paramFloat1 - f1) / this.L - this.M.getWidth() / 2, (paramFloat2 - f2) / this.L - this.M.getHeight() / 2, this.G);
  }

  private void i()
  {
    Matrix localMatrix = getImageViewMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    switch (1.a[this.A.ordinal()])
    {
    default:
      return;
    case 1:
    case 2:
    }
    this.D.lineTo(1.0F + this.N, this.O);
    this.E.lineTo((1.0F + this.N - f1) / this.L, (this.O - f2) / this.L);
    this.C.drawPath(this.E, this.I);
  }

  private void j()
  {
    Matrix localMatrix = getImageViewMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    switch (1.a[this.A.ordinal()])
    {
    default:
      return;
    case 1:
    }
    this.D.lineTo(this.N, this.O);
    this.E.lineTo((this.N - f1) / this.L, (this.O - f2) / this.L);
    this.C.drawPath(this.E, this.I);
  }

  private void k()
  {
    if (!this.y)
      f();
    if (this.Q != null)
    {
      if (this.y)
        this.Q.a();
    }
    else
      return;
    this.Q.b();
  }

  private void l()
  {
    if (this.B == null)
      return;
    this.J.set(0.0F, 0.0F, this.B.getWidth(), this.B.getHeight());
    getImageViewMatrix().mapRect(this.J);
    this.L = (this.J.width() / this.B.getWidth());
    setPaintSize(this.K);
  }

  private static Paint m()
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeJoin(Paint.Join.ROUND);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    return localPaint;
  }

  private void setPaintSize(float paramFloat)
  {
    this.K = paramFloat;
    float f = this.K * this.L;
    this.H.setStrokeWidth(f);
    this.I.setStrokeWidth(this.K);
    x = 10.0F;
  }

  public void a(int paramInt)
  {
    g();
    this.A = b.b;
    this.H.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setPaintSize(paramInt);
  }

  public void a(int paramInt1, int paramInt2)
  {
    g();
    this.A = b.a;
    this.H.setXfermode(null);
    this.I.setXfermode(null);
    this.H.setMaskFilter(null);
    this.I.setMaskFilter(null);
    setPaintColor(paramInt2);
    setPaintSize(paramInt1);
  }

  public void a(int paramInt1, String paramString, int paramInt2)
  {
    g();
    this.A = b.c;
    a(this.M);
    this.M = null;
    LightingColorFilter localLightingColorFilter = new LightingColorFilter(paramInt1, 1);
    this.M = j.a(a(getContext(), paramString), paramInt2, 1, true);
    this.G = new Paint(paramInt1);
    this.G.setColorFilter(localLightingColorFilter);
    x = paramInt2 / 4.0F;
  }

  protected void a(Bitmap paramBitmap, int paramInt)
  {
    super.a(paramBitmap, paramInt);
    a(false);
  }

  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this.B = paramBitmap1;
    a(paramBitmap2, true);
  }

  protected void a(b.a parama, Matrix paramMatrix)
  {
    super.a(parama, paramMatrix);
    l();
  }

  public void d()
  {
    this.Q = null;
    this.C = null;
    a(this.B);
    a(this.M);
    this.B = null;
    this.M = null;
  }

  public boolean e()
  {
    return this.y;
  }

  public void f()
  {
    this.z = true;
  }

  public void g()
  {
    this.z = false;
  }

  public Bitmap getDoodle()
  {
    return this.B;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Drawable localDrawable = getDrawable();
    if ((this.B != null) && (localDrawable != null))
    {
      paramCanvas.drawBitmap(this.B, getImageMatrix(), this.F);
      if (this.A != b.b)
        paramCanvas.drawPath(this.D, this.H);
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    this.M = localSavedState.mBrushBitmap;
    this.z = localSavedState.mCanvasLocked;
    this.A = localSavedState.mPaintType;
    this.K = localSavedState.mPaintSize;
    super.onRestoreInstanceState(localSavedState.getSuperState());
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.mBrushBitmap = this.M;
    localSavedState.mCanvasLocked = this.z;
    localSavedState.mPaintType = this.A;
    localSavedState.mPaintSize = this.K;
    return localSavedState;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.z)
      return super.onTouchEvent(paramMotionEvent);
    if (this.k != null)
      this.k.onTouch((View)getParent(), paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (!this.y)
    {
      this.y = true;
      k();
    }
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    while (true)
    {
      return true;
      f(f1, f2);
      invalidate();
      continue;
      g(f1, f2);
      invalidate();
      continue;
      h();
      invalidate();
    }
  }

  public void setCanvasDirty(boolean paramBoolean)
  {
    if (this.y != paramBoolean)
    {
      this.y = paramBoolean;
      k();
    }
  }

  public void setDoodleListener(a parama)
  {
    this.Q = parama;
  }

  public void setPaintColor(int paramInt)
  {
    this.H.setColor(paramInt);
    this.I.setColor(paramInt);
  }

  static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public PhotoDoodleView.SavedState a(Parcel paramAnonymousParcel)
      {
        return new PhotoDoodleView.SavedState(paramAnonymousParcel);
      }

      public PhotoDoodleView.SavedState[] a(int paramAnonymousInt)
      {
        return new PhotoDoodleView.SavedState[paramAnonymousInt];
      }
    };
    Bitmap mBrushBitmap;
    boolean mCanvasDirty;
    boolean mCanvasLocked;
    Bitmap mDrawingBitmap;
    float mPaintSize;
    PhotoDoodleView.b mPaintType;

    SavedState(Parcel paramParcel)
    {
      super();
      this.mBrushBitmap = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
      this.mDrawingBitmap = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
      boolean bool2;
      if (paramParcel.readInt() != 0)
      {
        bool2 = bool1;
        this.mCanvasLocked = bool2;
        if (paramParcel.readInt() == 0)
          break label101;
      }
      while (true)
      {
        this.mCanvasDirty = bool1;
        this.mPaintSize = paramParcel.readFloat();
        int i = paramParcel.readInt();
        if (i > -1)
          this.mPaintType = PhotoDoodleView.b.values()[i];
        return;
        bool2 = false;
        break;
        label101: bool1 = false;
      }
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.mBrushBitmap, paramInt);
      paramParcel.writeParcelable(this.mDrawingBitmap, paramInt);
      int j;
      if (this.mCanvasLocked)
      {
        j = i;
        paramParcel.writeInt(j);
        if (!this.mCanvasDirty)
          break label91;
        label49: paramParcel.writeInt(i);
        paramParcel.writeFloat(this.mPaintSize);
        if (this.mPaintType == null)
          break label96;
      }
      label91: label96: for (int k = this.mPaintType.ordinal(); ; k = -1)
      {
        paramParcel.writeInt(k);
        return;
        j = 0;
        break;
        i = 0;
        break label49;
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();

    public abstract void c();
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PhotoDoodleView
 * JD-Core Version:    0.6.2
 */