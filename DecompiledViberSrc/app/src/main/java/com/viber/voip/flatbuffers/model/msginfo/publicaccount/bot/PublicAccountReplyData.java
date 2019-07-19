package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.google.d.f;

public class PublicAccountReplyData
  implements Parcelable
{
  public static final Parcelable.Creator<PublicAccountReplyData> CREATOR = new Parcelable.Creator()
  {
    public PublicAccountReplyData a(Parcel paramAnonymousParcel)
    {
      return new PublicAccountReplyData(paramAnonymousParcel);
    }

    public PublicAccountReplyData[] a(int paramAnonymousInt)
    {
      return new PublicAccountReplyData[paramAnonymousInt];
    }
  };

  @c(a="pa_bot_selected_reply_button")
  private ReplyButton mButton;

  public PublicAccountReplyData()
  {
  }

  PublicAccountReplyData(Parcel paramParcel)
  {
    this.mButton = ((ReplyButton)paramParcel.readParcelable(ReplyButton.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public ReplyButton getButton()
  {
    return this.mButton;
  }

  public void setButton(ReplyButton paramReplyButton)
  {
    this.mButton = paramReplyButton;
  }

  public String toJson()
  {
    return new f().b(this);
  }

  public String toString()
  {
    return "PublicAccountReplyData{, button=" + this.mButton + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mButton, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.PublicAccountReplyData
 * JD-Core Version:    0.6.2
 */