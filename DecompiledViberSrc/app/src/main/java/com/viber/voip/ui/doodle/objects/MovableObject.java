package com.viber.voip.ui.doodle.objects;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import com.viber.voip.ui.doodle.commands.movable.TransformationCommand;
import com.viber.voip.ui.doodle.commands.movable.TransformationCommand.Transformations;
import com.viber.voip.ui.doodle.extras.a;
import com.viber.voip.ui.doodle.objects.b.c;
import com.viber.voip.ui.doodle.undo.TransformationUndo;
import com.viber.voip.ui.doodle.undo.Undo;

public abstract class MovableObject extends BaseObject
{
  private float mBoundsCenterX;
  private float mBoundsCenterY;
  TransformationCommand.Transformations mCurrentState;
  private Matrix mDrawingMatrix;
  private float[] mDrawingVertices;
  private c mMovableMetaData;
  TransformationCommand.Transformations mStartState;

  MovableObject(Parcel paramParcel)
  {
    super(paramParcel);
    this.mMovableMetaData = null;
    this.mStartState = ((TransformationCommand.Transformations)paramParcel.readParcelable(TransformationCommand.Transformations.class.getClassLoader()));
    this.mCurrentState = ((TransformationCommand.Transformations)paramParcel.readParcelable(TransformationCommand.Transformations.class.getClassLoader()));
  }

  MovableObject(c paramc)
  {
    super(paramc);
    this.mMovableMetaData = paramc;
    this.mStartState = new TransformationCommand.Transformations(0.0F, 0.0F, 1.0F, 0.0F, false);
    this.mCurrentState = new TransformationCommand.Transformations(0.0F, 0.0F, 1.0F, 0.0F, false);
  }

  private void updateDrawingMatrix()
  {
    if (this.mDrawingMatrix == null)
      this.mDrawingMatrix = new Matrix();
    this.mDrawingMatrix.reset();
    this.mDrawingMatrix.postRotate(this.mCurrentState.getRotation(), this.mBoundsCenterX, this.mBoundsCenterY);
    this.mDrawingMatrix.postScale(this.mCurrentState.getScale(), this.mCurrentState.getScale(), this.mBoundsCenterX, this.mBoundsCenterY);
    this.mDrawingMatrix.postTranslate(this.mCurrentState.getX(), this.mCurrentState.getY());
  }

  private void updateDrawingState()
  {
    if (!canBeDrawn())
      return;
    updateDrawingMatrix();
    updateDrawingVertices();
  }

  private void updateDrawingVertices()
  {
    if (this.mDrawingVertices == null)
      this.mDrawingVertices = new float[8];
    Rect localRect = getBounds();
    this.mDrawingVertices[0] = 0.0F;
    this.mDrawingVertices[1] = 0.0F;
    this.mDrawingVertices[2] = localRect.width();
    this.mDrawingVertices[3] = 0.0F;
    this.mDrawingVertices[4] = localRect.width();
    this.mDrawingVertices[5] = localRect.height();
    this.mDrawingVertices[6] = 0.0F;
    this.mDrawingVertices[7] = localRect.height();
    Matrix localMatrix = getVerticesMatrix();
    if (localMatrix != null)
      localMatrix.mapPoints(this.mDrawingVertices);
    this.mDrawingMatrix.mapPoints(this.mDrawingVertices);
  }

  public final Undo applyTransformations(TransformationCommand.Transformations paramTransformations)
  {
    if (isDestroyed())
      return Undo.None;
    this.mCurrentState.setRotation(this.mCurrentState.getRotation() + paramTransformations.getRotation());
    this.mCurrentState.setScale(this.mCurrentState.getScale() * paramTransformations.getScale());
    this.mCurrentState.setX(this.mCurrentState.getX() + paramTransformations.getX());
    this.mCurrentState.setY(this.mCurrentState.getY() + paramTransformations.getY());
    this.mCurrentState.setLastOperation(paramTransformations.isLastOperation());
    updateDrawingState();
    TransformationUndo localTransformationUndo;
    if (paramTransformations.isLastOperation())
    {
      localTransformationUndo = new TransformationUndo(getId(), TransformationCommand.createFromTransformations(new TransformationCommand.Transformations(this.mStartState.getX() - this.mCurrentState.getX(), this.mStartState.getY() - this.mCurrentState.getY(), this.mStartState.getScale() / this.mCurrentState.getScale(), this.mStartState.getRotation() - this.mCurrentState.getRotation(), true)));
      this.mStartState.setFrom(this.mCurrentState);
    }
    for (Object localObject = localTransformationUndo; ; localObject = Undo.None)
    {
      onDrawingStateChanged();
      return localObject;
    }
  }

  boolean canBeDrawn()
  {
    return getBounds() != null;
  }

  public void freeResources()
  {
    super.freeResources();
    this.mDrawingMatrix = null;
    this.mDrawingVertices = null;
  }

  protected abstract Rect getBounds();

  public long getSavedStateSizeInBytes()
  {
    return super.getSavedStateSizeInBytes() + this.mStartState.getSavedStateSizeInBytes() + this.mCurrentState.getSavedStateSizeInBytes();
  }

  protected Matrix getVerticesMatrix()
  {
    return null;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    if (this.mCurrentState != null);
    for (int j = this.mCurrentState.hashCode(); ; j = 0)
      return j + i;
  }

  public boolean hit(PointF paramPointF)
  {
    if (!canBeDrawn())
      return false;
    return a.a(paramPointF, this.mDrawingVertices);
  }

  final void onBoundsReady()
  {
    Rect localRect = getBounds();
    this.mBoundsCenterX = localRect.centerX();
    this.mBoundsCenterY = localRect.centerY();
    if (this.mMovableMetaData != null)
    {
      PointF localPointF = this.mMovableMetaData.a();
      this.mStartState.setX(localPointF.x - this.mBoundsCenterX);
      this.mStartState.setY(localPointF.y - this.mBoundsCenterY);
      this.mStartState.setScale(this.mMovableMetaData.c());
      applyTransformations(this.mStartState);
      this.mMovableMetaData = null;
      return;
    }
    updateDrawingState();
  }

  public Undo onClick()
  {
    return Undo.None;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.mStartState = null;
    this.mCurrentState = null;
  }

  public final void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.mDrawingMatrix);
    performDraw(paramCanvas);
    paramCanvas.restore();
  }

  protected void onDrawingStateChanged()
  {
  }

  protected abstract void performDraw(Canvas paramCanvas);

  public String toString()
  {
    return "MovableObject{mStartState=" + this.mStartState + ", mCurrentState=" + this.mCurrentState + ", " + super.toString() + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mStartState, paramInt);
    paramParcel.writeParcelable(this.mCurrentState, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.MovableObject
 * JD-Core Version:    0.6.2
 */