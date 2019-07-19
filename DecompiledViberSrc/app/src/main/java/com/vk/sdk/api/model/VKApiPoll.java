package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiPoll extends VKAttachments.VKApiAttachment
  implements Parcelable
{
  public static Parcelable.Creator<VKApiPoll> CREATOR = new Parcelable.Creator()
  {
    public VKApiPoll createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiPoll(paramAnonymousParcel);
    }

    public VKApiPoll[] newArray(int paramAnonymousInt)
    {
      return new VKApiPoll[paramAnonymousInt];
    }
  };
  public int answer_id;
  public VKList<Answer> answers;
  public long created;
  public int id;
  public int owner_id;
  public String question;
  public int votes;

  public VKApiPoll()
  {
  }

  public VKApiPoll(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.owner_id = paramParcel.readInt();
    this.created = paramParcel.readLong();
    this.question = paramParcel.readString();
    this.votes = paramParcel.readInt();
    this.answer_id = paramParcel.readInt();
    this.answers = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
  }

  public VKApiPoll(JSONObject paramJSONObject)
    throws JSONException
  {
    parse(paramJSONObject);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getId()
  {
    return this.id;
  }

  public String getType()
  {
    return "poll";
  }

  public VKApiPoll parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.owner_id = paramJSONObject.optInt("owner_id");
    this.created = paramJSONObject.optLong("created");
    this.question = paramJSONObject.optString("question");
    this.votes = paramJSONObject.optInt("votes");
    this.answer_id = paramJSONObject.optInt("answer_id");
    this.answers = new VKList(paramJSONObject.optJSONArray("answers"), Answer.class);
    return this;
  }

  public CharSequence toAttachmentString()
  {
    return null;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.owner_id);
    paramParcel.writeLong(this.created);
    paramParcel.writeString(this.question);
    paramParcel.writeInt(this.votes);
    paramParcel.writeInt(this.answer_id);
    paramParcel.writeParcelable(this.answers, paramInt);
  }

  public static final class Answer extends VKApiModel
    implements Parcelable, Identifiable
  {
    public static Parcelable.Creator<Answer> CREATOR = new Parcelable.Creator()
    {
      public VKApiPoll.Answer createFromParcel(Parcel paramAnonymousParcel)
      {
        return new VKApiPoll.Answer(paramAnonymousParcel);
      }

      public VKApiPoll.Answer[] newArray(int paramAnonymousInt)
      {
        return new VKApiPoll.Answer[paramAnonymousInt];
      }
    };
    public int id;
    public double rate;
    public String text;
    public int votes;

    public Answer(Parcel paramParcel)
    {
      this.id = paramParcel.readInt();
      this.text = paramParcel.readString();
      this.votes = paramParcel.readInt();
      this.rate = paramParcel.readDouble();
    }

    public int describeContents()
    {
      return 0;
    }

    public int getId()
    {
      return this.id;
    }

    public Answer parse(JSONObject paramJSONObject)
    {
      this.id = paramJSONObject.optInt("id");
      this.text = paramJSONObject.optString("text");
      this.votes = paramJSONObject.optInt("votes");
      this.rate = paramJSONObject.optDouble("rate");
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.id);
      paramParcel.writeString(this.text);
      paramParcel.writeInt(this.votes);
      paramParcel.writeDouble(this.rate);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiPoll
 * JD-Core Version:    0.6.2
 */