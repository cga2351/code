package com.viber.voip.ui.doodle.commands.movable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.ui.doodle.extras.i;
import com.viber.voip.ui.doodle.objects.MovableObject;
import com.viber.voip.ui.doodle.undo.Undo;

public class TransformationCommand
  implements Parcelable, com.viber.voip.ui.doodle.commands.a<MovableObject>
{
  public static final Parcelable.Creator<TransformationCommand> CREATOR = new Parcelable.Creator()
  {
    public TransformationCommand a(Parcel paramAnonymousParcel)
    {
      return new TransformationCommand(paramAnonymousParcel, null);
    }

    public TransformationCommand[] a(int paramAnonymousInt)
    {
      return new TransformationCommand[paramAnonymousInt];
    }
  };
  private final Transformations mTransformations;

  private TransformationCommand(Parcel paramParcel)
  {
    this.mTransformations = ((Transformations)paramParcel.readParcelable(Transformations.class.getClassLoader()));
  }

  private TransformationCommand(Transformations paramTransformations)
  {
    this.mTransformations = paramTransformations;
  }

  public static TransformationCommand createForRotation(float paramFloat, boolean paramBoolean)
  {
    return new TransformationCommand(new Transformations(0.0F, 0.0F, 1.0F, paramFloat, paramBoolean));
  }

  public static TransformationCommand createForScale(float paramFloat, boolean paramBoolean)
  {
    return new TransformationCommand(new Transformations(0.0F, 0.0F, paramFloat, 0.0F, paramBoolean));
  }

  public static TransformationCommand createForTranslation(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return new TransformationCommand(new Transformations(paramFloat1, paramFloat2, paramBoolean));
  }

  public static TransformationCommand createFromTransformations(Transformations paramTransformations)
  {
    return new TransformationCommand(paramTransformations);
  }

  public Undo applyTo(MovableObject paramMovableObject, com.viber.voip.ui.doodle.scene.a parama)
  {
    return paramMovableObject.applyTransformations(this.mTransformations);
  }

  public int describeContents()
  {
    return 0;
  }

  public long getSavedStateSizeInBytes()
  {
    return this.mTransformations.getSavedStateSizeInBytes();
  }

  public String toString()
  {
    return "TranslateCommand{mTransformations=" + this.mTransformations + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mTransformations, paramInt);
  }

  public static class Transformations
    implements Parcelable
  {
    public static final Parcelable.Creator<Transformations> CREATOR = new Parcelable.Creator()
    {
      public TransformationCommand.Transformations a(Parcel paramAnonymousParcel)
      {
        return new TransformationCommand.Transformations(paramAnonymousParcel, null);
      }

      public TransformationCommand.Transformations[] a(int paramAnonymousInt)
      {
        return new TransformationCommand.Transformations[paramAnonymousInt];
      }
    };
    private static final long TRANSFORMATIONS_CONTENT_SIZE_IN_BYTES = 1L + 4L * i.c;
    private boolean mLastOperation;
    private float mRotation;
    private float mScale;
    private float mX;
    private float mY;

    public Transformations(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
    {
      this.mX = paramFloat1;
      this.mY = paramFloat2;
      this.mScale = paramFloat3;
      this.mRotation = paramFloat4;
      this.mLastOperation = paramBoolean;
    }

    public Transformations(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      this(paramFloat1, paramFloat2, 1.0F, 0.0F, paramBoolean);
    }

    private Transformations(Parcel paramParcel)
    {
      this.mX = paramParcel.readFloat();
      this.mY = paramParcel.readFloat();
      this.mScale = paramParcel.readFloat();
      this.mRotation = paramParcel.readFloat();
      if (paramParcel.readByte() == i);
      while (true)
      {
        this.mLastOperation = i;
        return;
        i = 0;
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public float getRotation()
    {
      return this.mRotation;
    }

    public long getSavedStateSizeInBytes()
    {
      return TRANSFORMATIONS_CONTENT_SIZE_IN_BYTES;
    }

    public float getScale()
    {
      return this.mScale;
    }

    public float getX()
    {
      return this.mX;
    }

    public float getY()
    {
      return this.mY;
    }

    public int hashCode()
    {
      return 31 * (31 * (31 * (31 + Math.round(this.mX)) + Math.round(this.mY)) + Math.round(this.mScale)) + Math.round(this.mRotation);
    }

    public boolean isLastOperation()
    {
      return this.mLastOperation;
    }

    public void setFrom(Transformations paramTransformations)
    {
      this.mX = paramTransformations.getX();
      this.mY = paramTransformations.getY();
      this.mScale = paramTransformations.getScale();
      this.mRotation = paramTransformations.getRotation();
      this.mLastOperation = paramTransformations.isLastOperation();
    }

    public void setLastOperation(boolean paramBoolean)
    {
      this.mLastOperation = paramBoolean;
    }

    public void setRotation(float paramFloat)
    {
      this.mRotation = paramFloat;
    }

    public void setScale(float paramFloat)
    {
      this.mScale = paramFloat;
    }

    public void setX(float paramFloat)
    {
      this.mX = paramFloat;
    }

    public void setY(float paramFloat)
    {
      this.mY = paramFloat;
    }

    public String toString()
    {
      return "Transformations{x=" + this.mX + ", y=" + this.mY + ", scale=" + this.mScale + ", rotation=" + this.mRotation + ", last=" + this.mLastOperation + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeFloat(this.mX);
      paramParcel.writeFloat(this.mY);
      paramParcel.writeFloat(this.mScale);
      paramParcel.writeFloat(this.mRotation);
      if (this.mLastOperation);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeByte((byte)i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.commands.movable.TransformationCommand
 * JD-Core Version:    0.6.2
 */