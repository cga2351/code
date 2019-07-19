package com.viber.voip.ui.doodle.undo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RemoveUndo extends Undo
{
  public static final Parcelable.Creator<RemoveUndo> CREATOR = new Parcelable.Creator()
  {
    public RemoveUndo a(Parcel paramAnonymousParcel)
    {
      return new RemoveUndo(paramAnonymousParcel, null);
    }

    public RemoveUndo[] a(int paramAnonymousInt)
    {
      return new RemoveUndo[paramAnonymousInt];
    }
  };

  public RemoveUndo(long paramLong)
  {
    super(paramLong);
  }

  private RemoveUndo(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public void execute(com.viber.voip.ui.doodle.objects.c.a parama, com.viber.voip.ui.doodle.scene.a parama1)
  {
    parama.b(this.mObjectId);
  }

  public String toString()
  {
    return "RemoveUndo{mObjectId=" + this.mObjectId + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.undo.RemoveUndo
 * JD-Core Version:    0.6.2
 */