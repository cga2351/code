package com.viber.voip.storage.conversation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.storage.repository.MediaFileType;
import java.util.Arrays;

public class ManageConversationStorageDeletionErrorData
  implements Parcelable
{
  public static final Parcelable.Creator<ManageConversationStorageDeletionErrorData> CREATOR = new Parcelable.Creator()
  {
    public ManageConversationStorageDeletionErrorData a(Parcel paramAnonymousParcel)
    {
      return new ManageConversationStorageDeletionErrorData(paramAnonymousParcel);
    }

    public ManageConversationStorageDeletionErrorData[] a(int paramAnonymousInt)
    {
      return new ManageConversationStorageDeletionErrorData[paramAnonymousInt];
    }
  };
  private final MediaFileType[] mSelectedTypes;

  protected ManageConversationStorageDeletionErrorData(Parcel paramParcel)
  {
    this.mSelectedTypes = ((MediaFileType[])paramParcel.createTypedArray(MediaFileType.CREATOR));
  }

  ManageConversationStorageDeletionErrorData(MediaFileType[] paramArrayOfMediaFileType)
  {
    this.mSelectedTypes = paramArrayOfMediaFileType;
  }

  public int describeContents()
  {
    return 0;
  }

  public MediaFileType[] getSelectedTypes()
  {
    return this.mSelectedTypes;
  }

  public String toString()
  {
    return "ManageConversationStorageDeletionErrorData{mSelectedTypes=" + Arrays.toString(this.mSelectedTypes) + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.mSelectedTypes, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.conversation.ManageConversationStorageDeletionErrorData
 * JD-Core Version:    0.6.2
 */