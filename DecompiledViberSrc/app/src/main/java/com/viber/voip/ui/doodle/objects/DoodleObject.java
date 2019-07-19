package com.viber.voip.ui.doodle.objects;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.extras.b;
import com.viber.voip.ui.doodle.extras.d;
import com.viber.voip.ui.doodle.extras.i;
import com.viber.voip.ui.doodle.undo.Undo;
import java.util.Arrays;

public class DoodleObject extends BaseObject
{
  private static final float ARRAY_INCREASE_CAPACITY_RATIO = 0.7F;
  private static final int ARRAY_MIN_SIZE_FOR_APPROXIMATION = 50;
  public static final Parcelable.Creator<DoodleObject> CREATOR = new Parcelable.Creator()
  {
    public DoodleObject a(Parcel paramAnonymousParcel)
    {
      return new DoodleObject(paramAnonymousParcel, null);
    }

    public DoodleObject[] a(int paramAnonymousInt)
    {
      return new DoodleObject[paramAnonymousInt];
    }
  };
  private static final long DOODLE_OBJECT_CONTENT_SIZE_IN_BYTES = 0L;
  private static final float EPSILON = 5.0F;
  private static final int INITIAL_ARRAY_CAPACITY = 1000;
  private static final Logger L = ViberEnv.getLogger();
  private int mCurrentCurveCapacity = 0;
  private DoodleCurve mCurve;
  private com.viber.voip.ui.doodle.extras.b.a<DoodleCurve> mCurveCreator = new com.viber.voip.ui.doodle.extras.b.a()
  {
    public DoodleObject.DoodleCurve b(int paramAnonymousInt)
    {
      return new DoodleObject.DoodleCurve(paramAnonymousInt);
    }
  };
  private Path mDrawingPath;
  private PointF mEndPoint;
  private Paint mPaint;
  private PointF mProgressPoint;
  private PointF mStartPoint;

  static
  {
    DOODLE_OBJECT_CONTENT_SIZE_IN_BYTES = 2L * i.a + 3L * i.c;
  }

  private DoodleObject(Parcel paramParcel)
  {
    super(paramParcel);
    initPaint(paramParcel.readInt(), paramParcel.readFloat());
    this.mCurrentCurveCapacity = paramParcel.readInt();
    PointF localPointF = (PointF)paramParcel.readParcelable(PointF.class.getClassLoader());
    this.mCurve = ((DoodleCurve)paramParcel.readParcelable(DoodleCurve.class.getClassLoader()));
    float f1 = this.mCurve.getX(0);
    float f2 = this.mCurve.getY(0);
    this.mStartPoint = new PointF(f1, f2);
    this.mEndPoint = new PointF(f1, f2);
    this.mProgressPoint = new PointF(f1, f2);
    initPath(this.mStartPoint.x, this.mStartPoint.y);
    for (int i = 1; i < -1 + this.mCurve.getLength(); i++)
    {
      float f3 = this.mProgressPoint.x;
      float f4 = this.mProgressPoint.y;
      float f5 = this.mCurve.getX(i);
      float f6 = this.mCurve.getY(i);
      addDrawingValuesToPath(f5 - f3, f6 - f4);
    }
    addDrawingValuesToPath(2.0F * localPointF.x - 2.0F * this.mProgressPoint.x, 2.0F * localPointF.y - 2.0F * this.mProgressPoint.y);
  }

  public DoodleObject(com.viber.voip.ui.doodle.objects.b.a parama, d paramd)
  {
    super(parama);
    this.mStartPoint = parama.a();
    this.mEndPoint = new PointF(this.mStartPoint.x, this.mStartPoint.y);
    this.mProgressPoint = new PointF(this.mStartPoint.x, this.mStartPoint.y);
    initPaint(paramd.h(), paramd.g());
    initPath(this.mStartPoint.x, this.mStartPoint.y);
    initCurve(1000, this.mStartPoint);
  }

  private void addDrawingValuesToPath(float paramFloat1, float paramFloat2)
  {
    float f1 = this.mProgressPoint.x;
    float f2 = this.mProgressPoint.y;
    PointF localPointF1 = this.mProgressPoint;
    localPointF1.x = (paramFloat1 + localPointF1.x);
    PointF localPointF2 = this.mProgressPoint;
    localPointF2.y = (paramFloat2 + localPointF2.y);
    this.mEndPoint.x = ((f1 + this.mProgressPoint.x) / 2.0F);
    this.mEndPoint.y = ((f2 + this.mProgressPoint.y) / 2.0F);
    this.mDrawingPath.quadTo(f1, f2, this.mEndPoint.x, this.mEndPoint.y);
  }

  private void addPoint(float paramFloat1, float paramFloat2)
  {
    this.mCurve.addPoint(paramFloat1, paramFloat2);
    if (this.mCurrentCurveCapacity == this.mCurve.getLength())
      makeCurveApproximation();
  }

  private void initCurve(int paramInt, PointF paramPointF)
  {
    this.mCurrentCurveCapacity = paramInt;
    this.mCurve = ((DoodleCurve)this.mCurveCreator.a(this.mCurrentCurveCapacity));
    this.mCurve.addPoint(paramPointF.x, paramPointF.y);
  }

  private void initPaint(int paramInt, float paramFloat)
  {
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeJoin(Paint.Join.ROUND);
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    this.mPaint.setStrokeWidth(paramFloat);
  }

  private void initPath(float paramFloat1, float paramFloat2)
  {
    this.mDrawingPath = new Path();
    this.mDrawingPath.moveTo(paramFloat1, paramFloat2);
  }

  private void makeCurveApproximation()
  {
    if (this.mCurve.getLength() < 50)
      return;
    DoodleCurve localDoodleCurve = (DoodleCurve)com.viber.voip.ui.doodle.extras.a.a(this.mCurve, this.mCurveCreator, 5.0D);
    if (0.7F * this.mCurrentCurveCapacity < localDoodleCurve.getLength())
    {
      this.mCurrentCurveCapacity = (1000 + this.mCurrentCurveCapacity);
      this.mCurve = ((DoodleCurve)this.mCurveCreator.a(this.mCurrentCurveCapacity));
    }
    while (true)
    {
      this.mCurve.copy(localDoodleCurve, 0, 0);
      return;
      this.mCurve.clear(localDoodleCurve.getLength());
    }
  }

  public Undo applyDrawingValues(com.viber.voip.ui.doodle.commands.a.b.a parama)
  {
    if ((parama.c()) && (0.0F == parama.a()) && (0.0F == parama.b()))
      parama = new com.viber.voip.ui.doodle.commands.a.b.a(1.0F, 1.0F, true);
    addDrawingValuesToPath(parama.a(), parama.b());
    addPoint(this.mProgressPoint.x, this.mProgressPoint.y);
    if (parama.c())
      makeCurveApproximation();
    return Undo.None;
  }

  public boolean canBeDrawn()
  {
    return (this.mDrawingPath != null) && (this.mPaint != null);
  }

  public void freeResources()
  {
    super.freeResources();
    this.mStartPoint = null;
    this.mEndPoint = null;
    this.mProgressPoint = null;
    this.mCurve = null;
    this.mDrawingPath = null;
    this.mPaint = null;
  }

  public long getSavedStateSizeInBytes()
  {
    return super.getSavedStateSizeInBytes() + DOODLE_OBJECT_CONTENT_SIZE_IN_BYTES + this.mCurve.getSavedStateSizeInBytes();
  }

  public BaseObject.a getType()
  {
    return BaseObject.a.a;
  }

  public boolean hit(PointF paramPointF)
  {
    return false;
  }

  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.mDrawingPath, this.mPaint);
  }

  public void setPreparationCallback(BaseObject.b paramb)
  {
    paramb.a(this);
  }

  public String toString()
  {
    return "DoodleObject{" + super.toString() + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mPaint.getColor());
    paramParcel.writeFloat(this.mPaint.getStrokeWidth());
    paramParcel.writeInt(this.mCurrentCurveCapacity);
    paramParcel.writeParcelable(this.mEndPoint, paramInt);
    paramParcel.writeParcelable(this.mCurve, paramInt);
  }

  static class DoodleCurve
    implements Parcelable, b
  {
    private static final long CONSTANT_CONTENT_SIZE_IN_BYTES = 48L + 2L * i.a;
    public static final Parcelable.Creator<DoodleCurve> CREATOR = new Parcelable.Creator()
    {
      public DoodleObject.DoodleCurve a(Parcel paramAnonymousParcel)
      {
        return new DoodleObject.DoodleCurve(paramAnonymousParcel);
      }

      public DoodleObject.DoodleCurve[] a(int paramAnonymousInt)
      {
        return new DoodleObject.DoodleCurve[paramAnonymousInt];
      }
    };
    private int mCurrentSize;
    private float[] mXCoordinates;
    private float[] mYCoordinates;

    DoodleCurve(int paramInt)
    {
      this.mXCoordinates = new float[paramInt];
      this.mYCoordinates = new float[paramInt];
    }

    DoodleCurve(Parcel paramParcel)
    {
      int i = paramParcel.readInt();
      this.mCurrentSize = paramParcel.readInt();
      this.mXCoordinates = new float[i];
      this.mYCoordinates = new float[i];
      for (int j = 0; j < this.mCurrentSize; j++)
      {
        this.mXCoordinates[j] = paramParcel.readFloat();
        this.mYCoordinates[j] = paramParcel.readFloat();
      }
    }

    public void addPoint(float paramFloat1, float paramFloat2)
    {
      if (this.mCurrentSize == this.mXCoordinates.length)
        return;
      this.mXCoordinates[this.mCurrentSize] = paramFloat1;
      this.mYCoordinates[this.mCurrentSize] = paramFloat2;
      this.mCurrentSize = (1 + this.mCurrentSize);
    }

    public void clear(int paramInt)
    {
      for (int i = paramInt; i < this.mXCoordinates.length; i++)
      {
        this.mXCoordinates[i] = 0.0F;
        this.mYCoordinates[i] = 0.0F;
      }
      this.mCurrentSize = paramInt;
    }

    public void copy(DoodleCurve paramDoodleCurve, int paramInt1, int paramInt2)
    {
      if (paramDoodleCurve.getLength() - paramInt1 > this.mXCoordinates.length - paramInt2);
      int i;
      do
      {
        return;
        System.arraycopy(paramDoodleCurve.mXCoordinates, paramInt1, this.mXCoordinates, paramInt2, paramDoodleCurve.getLength());
        System.arraycopy(paramDoodleCurve.mYCoordinates, paramInt1, this.mYCoordinates, paramInt2, paramDoodleCurve.getLength());
        i = paramInt2 + paramDoodleCurve.getLength() - paramInt1;
      }
      while (i <= this.mCurrentSize);
      this.mCurrentSize = i;
    }

    public int describeContents()
    {
      return 0;
    }

    public int getLength()
    {
      return this.mCurrentSize;
    }

    public long getSavedStateSizeInBytes()
    {
      return CONSTANT_CONTENT_SIZE_IN_BYTES + 2 * this.mXCoordinates.length * i.c;
    }

    public float getX(int paramInt)
    {
      return this.mXCoordinates[paramInt];
    }

    public float getY(int paramInt)
    {
      return this.mYCoordinates[paramInt];
    }

    public String toString()
    {
      return "DoodleCurve{mXCoordinates=" + Arrays.toString(this.mXCoordinates) + ", mYCoordinates=" + Arrays.toString(this.mYCoordinates) + ", mCurrentSize=" + this.mCurrentSize + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mXCoordinates.length);
      paramParcel.writeInt(this.mCurrentSize);
      for (int i = 0; i < this.mCurrentSize; i++)
      {
        paramParcel.writeFloat(this.mXCoordinates[i]);
        paramParcel.writeFloat(this.mYCoordinates[i]);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.DoodleObject
 * JD-Core Version:    0.6.2
 */