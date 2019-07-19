package com.viber.voip.ui.doodle.undo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.ui.doodle.extras.i;

public class RestorePositionUndo extends Undo
{
  public static final Parcelable.Creator<RestorePositionUndo> CREATOR = new Parcelable.Creator()
  {
    public RestorePositionUndo a(Parcel paramAnonymousParcel)
    {
      return new RestorePositionUndo(paramAnonymousParcel);
    }

    public RestorePositionUndo[] a(int paramAnonymousInt)
    {
      return new RestorePositionUndo[paramAnonymousInt];
    }
  };
  private static final long RESTORE_POSITION_UNDO_CONTENT_SIZE_IN_BYTES = i.a;
  private final int mIndex;

  public RestorePositionUndo(long paramLong, int paramInt)
  {
    super(paramLong);
    this.mIndex = paramInt;
  }

  RestorePositionUndo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mIndex = paramParcel.readInt();
  }

  public void execute(com.viber.voip.ui.doodle.objects.c.a parama, com.viber.voip.ui.doodle.scene.a parama1)
  {
    parama1.a(this.mObjectId, this.mIndex);
  }

  public int getIndex()
  {
    return this.mIndex;
  }

  public long getSavedStateSizeInBytes()
  {
    return super.getSavedStateSizeInBytes() + RESTORE_POSITION_UNDO_CONTENT_SIZE_IN_BYTES;
  }

  public String toString()
  {
    return "RestorePositionUndo{mObjectId=" + this.mObjectId + ", mIndex=" + this.mIndex + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mIndex);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.undo.RestorePositionUndo
 * JD-Core Version:    0.6.2
 */