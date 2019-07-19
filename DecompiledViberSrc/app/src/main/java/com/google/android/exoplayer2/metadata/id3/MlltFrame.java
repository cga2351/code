package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class MlltFrame extends Id3Frame
{
  public static final Parcelable.Creator<MlltFrame> CREATOR = new Parcelable.Creator()
  {
    public MlltFrame a(Parcel paramAnonymousParcel)
    {
      return new MlltFrame(paramAnonymousParcel);
    }

    public MlltFrame[] a(int paramAnonymousInt)
    {
      return new MlltFrame[paramAnonymousInt];
    }
  };
  public static final String ID = "MLLT";
  public final int bytesBetweenReference;
  public final int[] bytesDeviations;
  public final int millisecondsBetweenReference;
  public final int[] millisecondsDeviations;
  public final int mpegFramesBetweenReference;

  public MlltFrame(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    super("MLLT");
    this.mpegFramesBetweenReference = paramInt1;
    this.bytesBetweenReference = paramInt2;
    this.millisecondsBetweenReference = paramInt3;
    this.bytesDeviations = paramArrayOfInt1;
    this.millisecondsDeviations = paramArrayOfInt2;
  }

  MlltFrame(Parcel paramParcel)
  {
    super("MLLT");
    this.mpegFramesBetweenReference = paramParcel.readInt();
    this.bytesBetweenReference = paramParcel.readInt();
    this.millisecondsBetweenReference = paramParcel.readInt();
    this.bytesDeviations = paramParcel.createIntArray();
    this.millisecondsDeviations = paramParcel.createIntArray();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MlltFrame localMlltFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMlltFrame = (MlltFrame)paramObject;
    }
    while ((this.mpegFramesBetweenReference == localMlltFrame.mpegFramesBetweenReference) && (this.bytesBetweenReference == localMlltFrame.bytesBetweenReference) && (this.millisecondsBetweenReference == localMlltFrame.millisecondsBetweenReference) && (Arrays.equals(this.bytesDeviations, localMlltFrame.bytesDeviations)) && (Arrays.equals(this.millisecondsDeviations, localMlltFrame.millisecondsDeviations)));
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (31 * (527 + this.mpegFramesBetweenReference) + this.bytesBetweenReference) + this.millisecondsBetweenReference) + Arrays.hashCode(this.bytesDeviations)) + Arrays.hashCode(this.millisecondsDeviations);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mpegFramesBetweenReference);
    paramParcel.writeInt(this.bytesBetweenReference);
    paramParcel.writeInt(this.millisecondsBetweenReference);
    paramParcel.writeIntArray(this.bytesDeviations);
    paramParcel.writeIntArray(this.millisecondsDeviations);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.MlltFrame
 * JD-Core Version:    0.6.2
 */