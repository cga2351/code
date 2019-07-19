package com.viber.voip.ui.doodle.undo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.MovableObject;

public class RestoreUndo extends RestorePositionUndo
{
  public static final Parcelable.Creator<RestoreUndo> CREATOR = new Parcelable.Creator()
  {
    public RestoreUndo a(Parcel paramAnonymousParcel)
    {
      return new RestoreUndo(paramAnonymousParcel, null);
    }

    public RestoreUndo[] a(int paramAnonymousInt)
    {
      return new RestoreUndo[paramAnonymousInt];
    }
  };
  private final Undo mTransformationUndo;

  public RestoreUndo(long paramLong, int paramInt, Undo paramUndo)
  {
    super(paramLong, paramInt);
    this.mTransformationUndo = paramUndo;
  }

  private RestoreUndo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mTransformationUndo = ((Undo)paramParcel.readParcelable(TransformationUndo.class.getClassLoader()));
  }

  public void execute(com.viber.voip.ui.doodle.objects.c.a parama, com.viber.voip.ui.doodle.scene.a parama1)
  {
    BaseObject localBaseObject = parama.a(this.mObjectId);
    if (localBaseObject == null)
      return;
    this.mTransformationUndo.execute(parama, parama1);
    parama1.a((MovableObject)localBaseObject, getIndex());
  }

  public long getSavedStateSizeInBytes()
  {
    return super.getSavedStateSizeInBytes() + this.mTransformationUndo.getSavedStateSizeInBytes();
  }

  public String toString()
  {
    return "RestoreUndo{mObjectId=" + this.mObjectId + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mTransformationUndo, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.undo.RestoreUndo
 * JD-Core Version:    0.6.2
 */