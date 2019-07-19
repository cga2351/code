package com.viber.voip.ui.doodle.scene;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SceneConfig
  implements Parcelable
{
  public static final Parcelable.Creator<SceneConfig> CREATOR = new Parcelable.Creator()
  {
    public SceneConfig a(Parcel paramAnonymousParcel)
    {
      return new SceneConfig(paramAnonymousParcel, null);
    }

    public SceneConfig[] a(int paramAnonymousInt)
    {
      return new SceneConfig[paramAnonymousInt];
    }
  };
  private final float mDrawingBoundsHeight;
  private final float mDrawingBoundsWidth;
  private final CoordinateNormalizer mNormalizer;
  private final float mScaleFactor;
  private final PointF mSceneCenterPoint;

  SceneConfig(float paramFloat1, RectF paramRectF, float paramFloat2, float paramFloat3)
  {
    this.mScaleFactor = paramFloat1;
    this.mDrawingBoundsWidth = paramRectF.width();
    this.mDrawingBoundsHeight = paramRectF.height();
    this.mNormalizer = new CoordinateNormalizer(paramRectF, paramFloat2, paramFloat3);
    this.mSceneCenterPoint = new PointF(this.mNormalizer.normalizeXCoordinate(paramRectF.centerX()), this.mNormalizer.normalizeYCoordinate(paramRectF.centerY()));
  }

  private SceneConfig(Parcel paramParcel)
  {
    this.mScaleFactor = paramParcel.readFloat();
    this.mDrawingBoundsWidth = paramParcel.readFloat();
    this.mDrawingBoundsHeight = paramParcel.readFloat();
    this.mSceneCenterPoint = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.mNormalizer = ((CoordinateNormalizer)paramParcel.readParcelable(CoordinateNormalizer.class.getClassLoader()));
  }

  static SceneConfig createDefault()
  {
    return new SceneConfig(1.0F, new RectF(), 1.0F, 1.0F);
  }

  public int describeContents()
  {
    return 0;
  }

  public CoordinateNormalizer getCoordinateNormalizer()
  {
    return this.mNormalizer;
  }

  public float getDrawingHeight()
  {
    return this.mDrawingBoundsHeight;
  }

  public float getDrawingWidth()
  {
    return this.mDrawingBoundsWidth;
  }

  public float getScaleFactor()
  {
    return this.mScaleFactor;
  }

  public PointF getSceneCenterPoint()
  {
    return this.mSceneCenterPoint;
  }

  public String toString()
  {
    return "SceneConfig{mScaleFactor=" + this.mScaleFactor + "mDrawingBoundsWidth=" + this.mDrawingBoundsWidth + "mDrawingBoundsHeight=" + this.mDrawingBoundsHeight + "mSceneCenterPoint=" + this.mSceneCenterPoint + "mCoordinateNormalizer=" + this.mNormalizer + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.mScaleFactor);
    paramParcel.writeFloat(this.mDrawingBoundsWidth);
    paramParcel.writeFloat(this.mDrawingBoundsHeight);
    paramParcel.writeParcelable(this.mSceneCenterPoint, paramInt);
    paramParcel.writeParcelable(this.mNormalizer, paramInt);
  }

  public static class CoordinateNormalizer
    implements Parcelable
  {
    public static final Parcelable.Creator<CoordinateNormalizer> CREATOR = new Parcelable.Creator()
    {
      public SceneConfig.CoordinateNormalizer a(Parcel paramAnonymousParcel)
      {
        return new SceneConfig.CoordinateNormalizer(paramAnonymousParcel, null);
      }

      public SceneConfig.CoordinateNormalizer[] a(int paramAnonymousInt)
      {
        return new SceneConfig.CoordinateNormalizer[paramAnonymousInt];
      }
    };
    private final RectF mSceneDrawingBounds;
    private final float mXCoordinateNormalizer;
    private final float mYCoordinateNormalizer;

    CoordinateNormalizer(RectF paramRectF, float paramFloat1, float paramFloat2)
    {
      this.mSceneDrawingBounds = paramRectF;
      this.mXCoordinateNormalizer = paramFloat1;
      this.mYCoordinateNormalizer = paramFloat2;
    }

    private CoordinateNormalizer(Parcel paramParcel)
    {
      this.mSceneDrawingBounds = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.mXCoordinateNormalizer = paramParcel.readFloat();
      this.mYCoordinateNormalizer = paramParcel.readFloat();
    }

    public int describeContents()
    {
      return 0;
    }

    public float normalizeDeltaXCoordinate(float paramFloat)
    {
      return paramFloat * this.mXCoordinateNormalizer;
    }

    public float normalizeDeltaYCoordinate(float paramFloat)
    {
      return paramFloat * this.mYCoordinateNormalizer;
    }

    public float normalizeXCoordinate(float paramFloat)
    {
      return (paramFloat - this.mSceneDrawingBounds.left) * this.mXCoordinateNormalizer;
    }

    public float normalizeYCoordinate(float paramFloat)
    {
      return (paramFloat - this.mSceneDrawingBounds.top) * this.mYCoordinateNormalizer;
    }

    public String toString()
    {
      return "CoordinateNormalizer{mSceneDrawingBounds=" + this.mSceneDrawingBounds + ", mXCoordinateNormalizer=" + this.mXCoordinateNormalizer + ", mYCoordinateNormalizer=" + this.mYCoordinateNormalizer + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.mSceneDrawingBounds, paramInt);
      paramParcel.writeFloat(this.mXCoordinateNormalizer);
      paramParcel.writeFloat(this.mYCoordinateNormalizer);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.scene.SceneConfig
 * JD-Core Version:    0.6.2
 */