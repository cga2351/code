package com.viber.voip.messages.conversation.ui.presenter;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.mvp.core.State;

public class SendMessagePresenterState extends State
{
  public static final Parcelable.Creator<SendMessagePresenterState> CREATOR = new Parcelable.Creator()
  {
    public SendMessagePresenterState a(Parcel paramAnonymousParcel)
    {
      return new SendMessagePresenterState(paramAnonymousParcel);
    }

    public SendMessagePresenterState[] a(int paramAnonymousInt)
    {
      return new SendMessagePresenterState[paramAnonymousInt];
    }
  };
  private ConversationData mData;
  private Uri mUserMediaUri;

  protected SendMessagePresenterState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mData = ((ConversationData)paramParcel.readParcelable(ConversationData.class.getClassLoader()));
    this.mUserMediaUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
  }

  public SendMessagePresenterState(ConversationData paramConversationData, Uri paramUri)
  {
    this.mData = paramConversationData;
    this.mUserMediaUri = paramUri;
  }

  public ConversationData getData()
  {
    return this.mData;
  }

  public Uri getUserMediaUri()
  {
    return this.mUserMediaUri;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mData, paramInt);
    paramParcel.writeParcelable(this.mUserMediaUri, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.SendMessagePresenterState
 * JD-Core Version:    0.6.2
 */