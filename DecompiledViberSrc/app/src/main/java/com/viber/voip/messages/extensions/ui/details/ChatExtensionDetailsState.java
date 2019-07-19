package com.viber.voip.messages.extensions.ui.details;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.mvp.core.State;

public class ChatExtensionDetailsState extends State
{
  public static final Parcelable.Creator<ChatExtensionDetailsState> CREATOR = new Parcelable.Creator()
  {
    public ChatExtensionDetailsState a(Parcel paramAnonymousParcel)
    {
      return new ChatExtensionDetailsState(paramAnonymousParcel);
    }

    public ChatExtensionDetailsState[] a(int paramAnonymousInt)
    {
      return new ChatExtensionDetailsState[paramAnonymousInt];
    }
  };
  private final String mSearchQuery;
  private final String mVisibleSearchQuery;

  ChatExtensionDetailsState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mVisibleSearchQuery = paramParcel.readString();
    this.mSearchQuery = paramParcel.readString();
  }

  private ChatExtensionDetailsState(String paramString1, String paramString2)
  {
    this.mSearchQuery = paramString1;
    this.mVisibleSearchQuery = paramString2;
  }

  public String getSearchQuery()
  {
    return this.mSearchQuery;
  }

  public String getVisibleSearchQuery()
  {
    return this.mVisibleSearchQuery;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mVisibleSearchQuery);
    paramParcel.writeString(this.mSearchQuery);
  }

  public static class a
  {
    private String a;
    private String b;

    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public ChatExtensionDetailsState a()
    {
      return new ChatExtensionDetailsState(this.a, this.b, null);
    }

    public a b(String paramString)
    {
      this.b = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsState
 * JD-Core Version:    0.6.2
 */