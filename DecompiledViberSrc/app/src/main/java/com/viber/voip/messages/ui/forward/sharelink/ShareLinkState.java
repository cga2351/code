package com.viber.voip.messages.ui.forward.sharelink;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.mvp.core.State;

public class ShareLinkState extends State
{
  public static final Parcelable.Creator<ShareLinkState> CREATOR = new Parcelable.Creator()
  {
    public ShareLinkState a(Parcel paramAnonymousParcel)
    {
      return new ShareLinkState(paramAnonymousParcel);
    }

    public ShareLinkState[] a(int paramAnonymousInt)
    {
      return new ShareLinkState[paramAnonymousInt];
    }
  };
  private RegularConversationLoaderEntity[] mSelectedConversations;

  public ShareLinkState()
  {
  }

  public ShareLinkState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mSelectedConversations = ((RegularConversationLoaderEntity[])paramParcel.createTypedArray(RegularConversationLoaderEntity.CREATOR));
  }

  public RegularConversationLoaderEntity[] getSelectedConversations()
  {
    return this.mSelectedConversations;
  }

  public void setSelectedConversations(RegularConversationLoaderEntity[] paramArrayOfRegularConversationLoaderEntity)
  {
    this.mSelectedConversations = paramArrayOfRegularConversationLoaderEntity;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedArray(this.mSelectedConversations, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.sharelink.ShareLinkState
 * JD-Core Version:    0.6.2
 */