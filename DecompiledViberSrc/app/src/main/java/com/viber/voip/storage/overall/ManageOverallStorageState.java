package com.viber.voip.storage.overall;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;
import com.viber.voip.storage.repository.MediaStorageInteractor.MediaStorageInteractorSaveState;

class ManageOverallStorageState extends State
{
  public static final Parcelable.Creator<ManageOverallStorageState> CREATOR = new Parcelable.Creator()
  {
    public ManageOverallStorageState a(Parcel paramAnonymousParcel)
    {
      return new ManageOverallStorageState(paramAnonymousParcel);
    }

    public ManageOverallStorageState[] a(int paramAnonymousInt)
    {
      return new ManageOverallStorageState[paramAnonymousInt];
    }
  };
  private final MediaStorageInteractor.MediaStorageInteractorSaveState mInteractorSaveState;
  private final boolean mIsClearMediaRunning;
  private final long mLocalDataSizeBytes;

  ManageOverallStorageState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mInteractorSaveState = ((MediaStorageInteractor.MediaStorageInteractorSaveState)paramParcel.readParcelable(MediaStorageInteractor.MediaStorageInteractorSaveState.class.getClassLoader()));
    this.mLocalDataSizeBytes = paramParcel.readLong();
    if (paramParcel.readByte() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsClearMediaRunning = bool;
      return;
    }
  }

  ManageOverallStorageState(MediaStorageInteractor.MediaStorageInteractorSaveState paramMediaStorageInteractorSaveState, long paramLong, boolean paramBoolean)
  {
    this.mInteractorSaveState = paramMediaStorageInteractorSaveState;
    this.mLocalDataSizeBytes = paramLong;
    this.mIsClearMediaRunning = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  MediaStorageInteractor.MediaStorageInteractorSaveState getInteractorSaveState()
  {
    return this.mInteractorSaveState;
  }

  long getLocalDataSizeBytes()
  {
    return this.mLocalDataSizeBytes;
  }

  boolean isClearMediaRunning()
  {
    return this.mIsClearMediaRunning;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mInteractorSaveState, paramInt);
    paramParcel.writeLong(this.mLocalDataSizeBytes);
    if (this.mIsClearMediaRunning);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.overall.ManageOverallStorageState
 * JD-Core Version:    0.6.2
 */