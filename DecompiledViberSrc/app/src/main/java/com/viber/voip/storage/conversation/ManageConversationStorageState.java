package com.viber.voip.storage.conversation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaFileType;
import com.viber.voip.storage.repository.MediaStorageInteractor.MediaStorageInteractorSaveState;

public class ManageConversationStorageState extends State
{
  public static final Parcelable.Creator<ManageConversationStorageState> CREATOR = new Parcelable.Creator()
  {
    public ManageConversationStorageState a(Parcel paramAnonymousParcel)
    {
      return new ManageConversationStorageState(paramAnonymousParcel);
    }

    public ManageConversationStorageState[] a(int paramAnonymousInt)
    {
      return new ManageConversationStorageState[paramAnonymousInt];
    }
  };
  private final ConversationWithMediaSizesEntity mConversation;
  private final MediaStorageInteractor.MediaStorageInteractorSaveState mInteractorSaveState;
  private final boolean mIsClearMediaRunning;
  private final MediaFileType[] mSelectedTypes;

  ManageConversationStorageState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mInteractorSaveState = ((MediaStorageInteractor.MediaStorageInteractorSaveState)paramParcel.readParcelable(MediaStorageInteractor.MediaStorageInteractorSaveState.class.getClassLoader()));
    this.mConversation = ((ConversationWithMediaSizesEntity)paramParcel.readParcelable(ConversationWithMediaSizesEntity.class.getClassLoader()));
    this.mSelectedTypes = ((MediaFileType[])paramParcel.readParcelableArray(MediaFileType.class.getClassLoader()));
    if (paramParcel.readByte() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsClearMediaRunning = bool;
      return;
    }
  }

  public ManageConversationStorageState(MediaStorageInteractor.MediaStorageInteractorSaveState paramMediaStorageInteractorSaveState, ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity, MediaFileType[] paramArrayOfMediaFileType, boolean paramBoolean)
  {
    this.mInteractorSaveState = paramMediaStorageInteractorSaveState;
    this.mConversation = paramConversationWithMediaSizesEntity;
    this.mSelectedTypes = paramArrayOfMediaFileType;
    this.mIsClearMediaRunning = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public ConversationWithMediaSizesEntity getConversation()
  {
    return this.mConversation;
  }

  MediaStorageInteractor.MediaStorageInteractorSaveState getInteractorSaveState()
  {
    return this.mInteractorSaveState;
  }

  public MediaFileType[] getSelectedTypes()
  {
    return this.mSelectedTypes;
  }

  public boolean isClearMediaRunning()
  {
    return this.mIsClearMediaRunning;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mInteractorSaveState, paramInt);
    paramParcel.writeParcelable(this.mConversation, paramInt);
    paramParcel.writeParcelableArray(this.mSelectedTypes, paramInt);
    if (this.mIsClearMediaRunning);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.conversation.ManageConversationStorageState
 * JD-Core Version:    0.6.2
 */