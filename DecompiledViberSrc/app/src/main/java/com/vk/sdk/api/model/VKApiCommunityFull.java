package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONObject;

public class VKApiCommunityFull extends VKApiCommunity
  implements Parcelable
{
  public static final String ACTIVITY = "activity";
  public static final String BLACKLISTED = "blacklisted";
  public static final String CAN_POST = "can_post";
  public static final String CAN_SEE_ALL_POSTS = "can_see_all_posts";
  public static final String CITY = "city";
  public static final String CONTACTS = "contacts";
  public static final String COUNTERS = "counters";
  public static final String COUNTRY = "country";
  public static Parcelable.Creator<VKApiCommunityFull> CREATOR = new Parcelable.Creator()
  {
    public VKApiCommunityFull createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiCommunityFull(paramAnonymousParcel);
    }

    public VKApiCommunityFull[] newArray(int paramAnonymousInt)
    {
      return new VKApiCommunityFull[paramAnonymousInt];
    }
  };
  public static final String DESCRIPTION = "description";
  public static final String END_DATE = "end_date";
  public static final String FIXED_POST = "fixed_post";
  public static final String LINKS = "links";
  public static final String MEMBERS_COUNT = "members_count";
  public static final String PLACE = "place";
  public static final String SITE = "site";
  public static final String START_DATE = "start_date";
  public static final String STATUS = "status";
  public static final String VERIFIED = "verified";
  public static final String WIKI_PAGE = "wiki_page";
  public boolean blacklisted;
  public boolean can_post;
  public boolean can_see_all_posts;
  public VKApiCity city;
  public VKList<Contact> contacts;
  public Counters counters;
  public VKApiCountry country;
  public String description;
  public long end_date;
  public int fixed_post;
  public VKList<Link> links;
  public int members_count;
  public VKApiPlace place;
  public String site;
  public long start_date;
  public String status;
  public VKApiAudio status_audio;
  public boolean verified;
  public String wiki_page;

  public VKApiCommunityFull()
  {
  }

  public VKApiCommunityFull(Parcel paramParcel)
  {
    super(paramParcel);
    this.city = ((VKApiCity)paramParcel.readParcelable(VKApiCity.class.getClassLoader()));
    this.country = ((VKApiCountry)paramParcel.readParcelable(VKApiCountry.class.getClassLoader()));
    this.status_audio = ((VKApiAudio)paramParcel.readParcelable(VKApiAudio.class.getClassLoader()));
    this.place = ((VKApiPlace)paramParcel.readParcelable(VKApiPlace.class.getClassLoader()));
    this.description = paramParcel.readString();
    this.wiki_page = paramParcel.readString();
    this.members_count = paramParcel.readInt();
    this.counters = ((Counters)paramParcel.readParcelable(Counters.class.getClassLoader()));
    this.start_date = paramParcel.readLong();
    this.end_date = paramParcel.readLong();
    boolean bool2;
    boolean bool3;
    label151: boolean bool4;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.can_post = bool2;
      if (paramParcel.readByte() == 0)
        break label247;
      bool3 = bool1;
      this.can_see_all_posts = bool3;
      this.status = paramParcel.readString();
      this.contacts = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
      this.links = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
      this.fixed_post = paramParcel.readInt();
      if (paramParcel.readByte() == 0)
        break label253;
      bool4 = bool1;
      label215: this.verified = bool4;
      this.site = paramParcel.readString();
      if (paramParcel.readByte() == 0)
        break label259;
    }
    while (true)
    {
      this.blacklisted = bool1;
      return;
      bool2 = false;
      break;
      label247: bool3 = false;
      break label151;
      label253: bool4 = false;
      break label215;
      label259: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public VKApiCommunityFull parse(JSONObject paramJSONObject)
  {
    super.parse(paramJSONObject);
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("city");
    if (localJSONObject1 != null)
      this.city = new VKApiCity().parse(localJSONObject1);
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("country");
    if (localJSONObject2 != null)
      this.country = new VKApiCountry().parse(localJSONObject2);
    JSONObject localJSONObject3 = paramJSONObject.optJSONObject("place");
    if (localJSONObject3 != null)
      this.place = new VKApiPlace().parse(localJSONObject3);
    this.description = paramJSONObject.optString("description");
    this.wiki_page = paramJSONObject.optString("wiki_page");
    this.members_count = paramJSONObject.optInt("members_count");
    JSONObject localJSONObject4 = paramJSONObject.optJSONObject("counters");
    if (localJSONObject4 != null)
      this.counters = new Counters(localJSONObject4);
    this.start_date = paramJSONObject.optLong("start_date");
    this.end_date = paramJSONObject.optLong("end_date");
    this.can_post = ParseUtils.parseBoolean(paramJSONObject, "can_post");
    this.can_see_all_posts = ParseUtils.parseBoolean(paramJSONObject, "can_see_all_posts");
    this.status = paramJSONObject.optString("status");
    JSONObject localJSONObject5 = paramJSONObject.optJSONObject("status_audio");
    if (localJSONObject5 != null)
      this.status_audio = new VKApiAudio().parse(localJSONObject5);
    this.contacts = new VKList(paramJSONObject.optJSONArray("contacts"), Contact.class);
    this.links = new VKList(paramJSONObject.optJSONArray("links"), Link.class);
    this.fixed_post = paramJSONObject.optInt("fixed_post");
    this.verified = ParseUtils.parseBoolean(paramJSONObject, "verified");
    this.blacklisted = ParseUtils.parseBoolean(paramJSONObject, "verified");
    this.site = paramJSONObject.optString("site");
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.city, paramInt);
    paramParcel.writeParcelable(this.country, paramInt);
    paramParcel.writeParcelable(this.status_audio, paramInt);
    paramParcel.writeParcelable(this.place, paramInt);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.wiki_page);
    paramParcel.writeInt(this.members_count);
    paramParcel.writeParcelable(this.counters, paramInt);
    paramParcel.writeLong(this.start_date);
    paramParcel.writeLong(this.end_date);
    byte b2;
    byte b3;
    label119: byte b4;
    if (this.can_post)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.can_see_all_posts)
        break label202;
      b3 = b1;
      paramParcel.writeByte(b3);
      paramParcel.writeString(this.status);
      paramParcel.writeParcelable(this.contacts, paramInt);
      paramParcel.writeParcelable(this.links, paramInt);
      paramParcel.writeInt(this.fixed_post);
      if (!this.verified)
        break label208;
      b4 = b1;
      label169: paramParcel.writeByte(b4);
      paramParcel.writeString(this.site);
      if (!this.blacklisted)
        break label214;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label202: b3 = 0;
      break label119;
      label208: b4 = 0;
      break label169;
      label214: b1 = 0;
    }
  }

  public static class Contact extends VKApiModel
    implements Parcelable, Identifiable
  {
    public static Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator()
    {
      public VKApiCommunityFull.Contact createFromParcel(Parcel paramAnonymousParcel)
      {
        return new VKApiCommunityFull.Contact(paramAnonymousParcel, null);
      }

      public VKApiCommunityFull.Contact[] newArray(int paramAnonymousInt)
      {
        return new VKApiCommunityFull.Contact[paramAnonymousInt];
      }
    };
    public String desc;
    public String email;
    public VKApiUser user;
    public int user_id;

    private Contact(Parcel paramParcel)
    {
      this.user_id = paramParcel.readInt();
      this.desc = paramParcel.readString();
    }

    public Contact(JSONObject paramJSONObject)
    {
      parse(paramJSONObject);
    }

    public int describeContents()
    {
      return 0;
    }

    public int getId()
    {
      return this.user_id;
    }

    public Contact parse(JSONObject paramJSONObject)
    {
      this.user_id = paramJSONObject.optInt("user_id");
      this.desc = paramJSONObject.optString("desc");
      this.email = paramJSONObject.optString("email");
      return this;
    }

    public String toString()
    {
      if (this.user != null)
        return this.user.toString();
      if (this.email != null)
        return this.email;
      return null;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.user_id);
      paramParcel.writeString(this.desc);
    }
  }

  public static class Counters
    implements Parcelable
  {
    public static Parcelable.Creator<Counters> CREATOR = new Parcelable.Creator()
    {
      public VKApiCommunityFull.Counters createFromParcel(Parcel paramAnonymousParcel)
      {
        return new VKApiCommunityFull.Counters(paramAnonymousParcel, null);
      }

      public VKApiCommunityFull.Counters[] newArray(int paramAnonymousInt)
      {
        return new VKApiCommunityFull.Counters[paramAnonymousInt];
      }
    };
    public static final int NO_COUNTER = -1;
    public int albums = -1;
    public int audios = -1;
    public int docs = -1;
    public int photos = -1;
    public int topics = -1;
    public int videos = -1;

    private Counters(Parcel paramParcel)
    {
      this.photos = paramParcel.readInt();
      this.albums = paramParcel.readInt();
      this.audios = paramParcel.readInt();
      this.videos = paramParcel.readInt();
      this.topics = paramParcel.readInt();
      this.docs = paramParcel.readInt();
    }

    public Counters(JSONObject paramJSONObject)
    {
      this.photos = paramJSONObject.optInt("photos", this.photos);
      this.albums = paramJSONObject.optInt("albums", this.albums);
      this.audios = paramJSONObject.optInt("audios", this.audios);
      this.videos = paramJSONObject.optInt("videos", this.videos);
      this.topics = paramJSONObject.optInt("topics", this.topics);
      this.docs = paramJSONObject.optInt("docs", this.docs);
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.photos);
      paramParcel.writeInt(this.albums);
      paramParcel.writeInt(this.audios);
      paramParcel.writeInt(this.videos);
      paramParcel.writeInt(this.topics);
      paramParcel.writeInt(this.docs);
    }
  }

  public static class Link extends VKApiModel
    implements Parcelable, Identifiable
  {
    public static Parcelable.Creator<Link> CREATOR = new Parcelable.Creator()
    {
      public VKApiCommunityFull.Link createFromParcel(Parcel paramAnonymousParcel)
      {
        return new VKApiCommunityFull.Link(paramAnonymousParcel);
      }

      public VKApiCommunityFull.Link[] newArray(int paramAnonymousInt)
      {
        return new VKApiCommunityFull.Link[paramAnonymousInt];
      }
    };
    public String desc;
    public String name;
    public VKPhotoSizes photo = new VKPhotoSizes();
    public String url;

    public Link(Parcel paramParcel)
    {
      this.url = paramParcel.readString();
      this.name = paramParcel.readString();
      this.desc = paramParcel.readString();
      this.photo = ((VKPhotoSizes)paramParcel.readParcelable(null));
    }

    public Link(JSONObject paramJSONObject)
    {
      parse(paramJSONObject);
    }

    public int describeContents()
    {
      return 0;
    }

    public int getId()
    {
      return 0;
    }

    public Link parse(JSONObject paramJSONObject)
    {
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("name");
      this.desc = paramJSONObject.optString("desc");
      String str1 = paramJSONObject.optString("photo_50");
      if (!TextUtils.isEmpty(str1))
        this.photo.add(VKApiPhotoSize.create(str1, 50));
      String str2 = paramJSONObject.optString("photo_100");
      if (!TextUtils.isEmpty(str2))
        this.photo.add(VKApiPhotoSize.create(str2, 100));
      this.photo.sort();
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.desc);
      paramParcel.writeParcelable(this.photo, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiCommunityFull
 * JD-Core Version:    0.6.2
 */