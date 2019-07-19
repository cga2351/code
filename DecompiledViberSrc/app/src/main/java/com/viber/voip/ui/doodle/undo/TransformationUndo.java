package com.viber.voip.ui.doodle.undo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.commands.movable.TransformationCommand;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.MovableObject;

public class TransformationUndo extends Undo
{
  public static final Parcelable.Creator<TransformationUndo> CREATOR = new Parcelable.Creator()
  {
    public TransformationUndo a(Parcel paramAnonymousParcel)
    {
      return new TransformationUndo(paramAnonymousParcel, null);
    }

    public TransformationUndo[] a(int paramAnonymousInt)
    {
      return new TransformationUndo[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  private final TransformationCommand mTransformationCommand;

  public TransformationUndo(long paramLong, TransformationCommand paramTransformationCommand)
  {
    super(paramLong);
    this.mTransformationCommand = paramTransformationCommand;
  }

  private TransformationUndo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mTransformationCommand = ((TransformationCommand)paramParcel.readParcelable(TransformationCommand.class.getClassLoader()));
  }

  public void execute(com.viber.voip.ui.doodle.objects.c.a parama, com.viber.voip.ui.doodle.scene.a parama1)
  {
    BaseObject localBaseObject = parama.a(this.mObjectId);
    if (localBaseObject == null)
      throw new IllegalStateException("unable to find object with id=" + this.mObjectId);
    this.mTransformationCommand.applyTo((MovableObject)localBaseObject, parama1);
  }

  public long getSavedStateSizeInBytes()
  {
    return super.getSavedStateSizeInBytes() + this.mTransformationCommand.getSavedStateSizeInBytes();
  }

  public String toString()
  {
    return "TransformationUndo{mObjectId=" + this.mObjectId + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mTransformationCommand, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.undo.TransformationUndo
 * JD-Core Version:    0.6.2
 */