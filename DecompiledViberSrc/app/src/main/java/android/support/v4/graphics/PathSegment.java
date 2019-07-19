package android.support.v4.graphics;

import android.graphics.PointF;
import android.support.v4.util.Preconditions;

public final class PathSegment
{
  private final PointF mEnd;
  private final float mEndFraction;
  private final PointF mStart;
  private final float mStartFraction;

  public PathSegment(PointF paramPointF1, float paramFloat1, PointF paramPointF2, float paramFloat2)
  {
    this.mStart = ((PointF)Preconditions.checkNotNull(paramPointF1, "start == null"));
    this.mStartFraction = paramFloat1;
    this.mEnd = ((PointF)Preconditions.checkNotNull(paramPointF2, "end == null"));
    this.mEndFraction = paramFloat2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PathSegment localPathSegment;
    do
    {
      return true;
      if (!(paramObject instanceof PathSegment))
        return false;
      localPathSegment = (PathSegment)paramObject;
    }
    while ((Float.compare(this.mStartFraction, localPathSegment.mStartFraction) == 0) && (Float.compare(this.mEndFraction, localPathSegment.mEndFraction) == 0) && (this.mStart.equals(localPathSegment.mStart)) && (this.mEnd.equals(localPathSegment.mEnd)));
    return false;
  }

  public PointF getEnd()
  {
    return this.mEnd;
  }

  public float getEndFraction()
  {
    return this.mEndFraction;
  }

  public PointF getStart()
  {
    return this.mStart;
  }

  public float getStartFraction()
  {
    return this.mStartFraction;
  }

  public int hashCode()
  {
    int i = 31 * this.mStart.hashCode();
    if (this.mStartFraction != 0.0F);
    for (int j = Float.floatToIntBits(this.mStartFraction); ; j = 0)
    {
      int k = 31 * (31 * (j + i) + this.mEnd.hashCode());
      boolean bool = this.mEndFraction < 0.0F;
      int m = 0;
      if (bool)
        m = Float.floatToIntBits(this.mEndFraction);
      return k + m;
    }
  }

  public String toString()
  {
    return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.PathSegment
 * JD-Core Version:    0.6.2
 */