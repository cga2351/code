package com.viber.voip.storage.manage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;
import com.viber.voip.storage.repository.MediaStorageInteractor.MediaStorageInteractorSaveState;

class ManageStorageState extends State
{
  public static final Parcelable.Creator<ManageStorageState> CREATOR = new Parcelable.Creator()
  {
    public ManageStorageState a(Parcel paramAnonymousParcel)
    {
      return new ManageStorageState(paramAnonymousParcel);
    }

    public ManageStorageState[] a(int paramAnonymousInt)
    {
      return new ManageStorageState[paramAnonymousInt];
    }
  };
  private final MediaStorageInteractor.MediaStorageInteractorSaveState mInteractorSaveState;
  private final String mSearchQuery;

  protected ManageStorageState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mInteractorSaveState = ((MediaStorageInteractor.MediaStorageInteractorSaveState)paramParcel.readParcelable(MediaStorageInteractor.MediaStorageInteractorSaveState.class.getClassLoader()));
    this.mSearchQuery = paramParcel.readString();
  }

  public ManageStorageState(MediaStorageInteractor.MediaStorageInteractorSaveState paramMediaStorageInteractorSaveState, String paramString)
  {
    this.mInteractorSaveState = paramMediaStorageInteractorSaveState;
    this.mSearchQuery = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public MediaStorageInteractor.MediaStorageInteractorSaveState getInteractorSaveState()
  {
    return this.mInteractorSaveState;
  }

  public String getSearchQuery()
  {
    return this.mSearchQuery;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mInteractorSaveState, paramInt);
    paramParcel.writeString(this.mSearchQuery);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.ManageStorageState
 * JD-Core Version:    0.6.2
 */