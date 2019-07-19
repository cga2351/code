package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiUserFull extends VKApiUser
  implements Parcelable
{
  public static final String ABOUT = "about";
  public static final String ACTIVITIES = "activities";
  public static final String ACTIVITY = "activity";
  public static final String BDATE = "bdate";
  public static final String BLACKLISTED_BY_ME = "blacklisted_by_me";
  public static final String BOOKS = "books";
  public static final String CAN_POST = "can_post";
  public static final String CAN_SEE_ALL_POSTS = "can_see_all_posts";
  public static final String CAN_WRITE_PRIVATE_MESSAGE = "can_write_private_message";
  public static final String CITY = "city";
  public static final String CONNECTIONS = "connections";
  public static final String CONTACTS = "contacts";
  public static final String COUNTERS = "counters";
  public static final String COUNTRY = "country";
  public static Parcelable.Creator<VKApiUserFull> CREATOR = new Parcelable.Creator()
  {
    public VKApiUserFull createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiUserFull(paramAnonymousParcel);
    }

    public VKApiUserFull[] newArray(int paramAnonymousInt)
    {
      return new VKApiUserFull[paramAnonymousInt];
    }
  };
  public static final String GAMES = "games";
  public static final String INTERESTS = "interests";
  public static final String LAST_SEEN = "last_seen";
  public static final String MOVIES = "movies";
  public static final String OCCUPATION = "occupation";
  public static final String PERSONAL = "personal";
  public static final String QUOTES = "quotes";
  public static final String RELATION = "relation";
  public static final String RELATIVES = "relatives";
  public static final String SCHOOLS = "schools";
  public static final String SCREEN_NAME = "screen_name";
  public static final String SEX = "sex";
  public static final String SITE = "site";
  public static final String TV = "tv";
  public static final String UNIVERSITIES = "universities";
  public static final String VERIFIED = "verified";
  public static final String WALL_DEFAULT = "wall_default";
  public String about;
  public String activities;
  public String activity;
  public int alcohol;
  public String bdate;
  public boolean blacklisted_by_me;
  public String books;
  public boolean can_post;
  public boolean can_see_all_posts;
  public boolean can_write_private_message;
  public VKApiCity city;
  public Counters counters;
  public VKApiCountry country;
  public String facebook;
  public String facebook_name;
  public String games;
  public String home_phone;
  public String inspired_by;
  public String instagram;
  public String interests;
  public boolean is_banned;
  public boolean is_deleted;
  public String[] langs;
  public long last_seen;
  public int life_main;
  public String livejournal;
  public String mobile_phone;
  public String movies;
  public String nickname;
  public Occupation occupation;
  public int people_main;
  public int political;
  public String quotes;
  public int relation;
  public VKList<Relative> relatives;
  public String religion;
  public VKList<VKApiSchool> schools;
  public String screen_name;
  public int sex;
  public String site;
  public String skype;
  public int smoking;
  public VKApiAudio status_audio;
  public String tv;
  public String twitter;
  public VKList<VKApiUniversity> universities;
  public boolean verified;
  public boolean wall_comments;
  public boolean wall_default_owner;

  public VKApiUserFull()
  {
  }

  public VKApiUserFull(Parcel paramParcel)
  {
    super(paramParcel);
    this.activity = paramParcel.readString();
    this.status_audio = ((VKApiAudio)paramParcel.readParcelable(VKApiAudio.class.getClassLoader()));
    this.bdate = paramParcel.readString();
    this.city = ((VKApiCity)paramParcel.readParcelable(VKApiCity.class.getClassLoader()));
    this.country = ((VKApiCountry)paramParcel.readParcelable(VKApiCountry.class.getClassLoader()));
    this.last_seen = paramParcel.readLong();
    this.universities = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
    this.schools = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
    this.smoking = paramParcel.readInt();
    this.alcohol = paramParcel.readInt();
    this.political = paramParcel.readInt();
    this.life_main = paramParcel.readInt();
    this.people_main = paramParcel.readInt();
    this.inspired_by = paramParcel.readString();
    this.langs = paramParcel.createStringArray();
    this.religion = paramParcel.readString();
    this.facebook = paramParcel.readString();
    this.facebook_name = paramParcel.readString();
    this.livejournal = paramParcel.readString();
    this.skype = paramParcel.readString();
    this.site = paramParcel.readString();
    this.twitter = paramParcel.readString();
    this.instagram = paramParcel.readString();
    this.mobile_phone = paramParcel.readString();
    this.home_phone = paramParcel.readString();
    this.screen_name = paramParcel.readString();
    this.activities = paramParcel.readString();
    this.interests = paramParcel.readString();
    this.movies = paramParcel.readString();
    this.tv = paramParcel.readString();
    this.books = paramParcel.readString();
    this.games = paramParcel.readString();
    this.about = paramParcel.readString();
    this.quotes = paramParcel.readString();
    boolean bool2;
    boolean bool3;
    label343: boolean bool4;
    label359: boolean bool5;
    label375: boolean bool6;
    label391: boolean bool7;
    label407: boolean bool8;
    label423: boolean bool9;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.can_post = bool2;
      if (paramParcel.readByte() == 0)
        break label529;
      bool3 = bool1;
      this.can_see_all_posts = bool3;
      if (paramParcel.readByte() == 0)
        break label535;
      bool4 = bool1;
      this.can_write_private_message = bool4;
      if (paramParcel.readByte() == 0)
        break label541;
      bool5 = bool1;
      this.wall_comments = bool5;
      if (paramParcel.readByte() == 0)
        break label547;
      bool6 = bool1;
      this.is_banned = bool6;
      if (paramParcel.readByte() == 0)
        break label553;
      bool7 = bool1;
      this.is_deleted = bool7;
      if (paramParcel.readByte() == 0)
        break label559;
      bool8 = bool1;
      this.wall_default_owner = bool8;
      if (paramParcel.readByte() == 0)
        break label565;
      bool9 = bool1;
      label439: this.verified = bool9;
      this.sex = paramParcel.readInt();
      this.counters = ((Counters)paramParcel.readParcelable(Counters.class.getClassLoader()));
      this.occupation = ((Occupation)paramParcel.readParcelable(Occupation.class.getClassLoader()));
      this.relation = paramParcel.readInt();
      this.relatives = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
      if (paramParcel.readByte() == 0)
        break label571;
    }
    while (true)
    {
      this.blacklisted_by_me = bool1;
      return;
      bool2 = false;
      break;
      label529: bool3 = false;
      break label343;
      label535: bool4 = false;
      break label359;
      label541: bool5 = false;
      break label375;
      label547: bool6 = false;
      break label391;
      label553: bool7 = false;
      break label407;
      label559: bool8 = false;
      break label423;
      label565: bool9 = false;
      break label439;
      label571: bool1 = false;
    }
  }

  public VKApiUserFull(JSONObject paramJSONObject)
    throws JSONException
  {
    parse(paramJSONObject);
  }

  public int describeContents()
  {
    return 0;
  }

  public VKApiUserFull parse(JSONObject paramJSONObject)
  {
    super.parse(paramJSONObject);
    this.last_seen = ParseUtils.parseLong(paramJSONObject.optJSONObject("last_seen"), "time");
    this.bdate = paramJSONObject.optString("bdate");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("city");
    if (localJSONObject1 != null)
      this.city = new VKApiCity().parse(localJSONObject1);
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("country");
    if (localJSONObject2 != null)
      this.country = new VKApiCountry().parse(localJSONObject2);
    this.universities = new VKList(paramJSONObject.optJSONArray("universities"), VKApiUniversity.class);
    this.schools = new VKList(paramJSONObject.optJSONArray("schools"), VKApiSchool.class);
    this.activity = paramJSONObject.optString("activity");
    JSONObject localJSONObject3 = paramJSONObject.optJSONObject("status_audio");
    if (localJSONObject3 != null)
      this.status_audio = new VKApiAudio().parse(localJSONObject3);
    JSONObject localJSONObject4 = paramJSONObject.optJSONObject("personal");
    if (localJSONObject4 != null)
    {
      this.smoking = localJSONObject4.optInt("smoking");
      this.alcohol = localJSONObject4.optInt("alcohol");
      this.political = localJSONObject4.optInt("political");
      this.life_main = localJSONObject4.optInt("life_main");
      this.people_main = localJSONObject4.optInt("people_main");
      this.inspired_by = localJSONObject4.optString("inspired_by");
      this.religion = localJSONObject4.optString("religion");
      if (localJSONObject4.has("langs"))
      {
        JSONArray localJSONArray = localJSONObject4.optJSONArray("langs");
        if (localJSONArray != null)
        {
          this.langs = new String[localJSONArray.length()];
          for (int i = 0; i < localJSONArray.length(); i++)
            this.langs[i] = localJSONArray.optString(i);
        }
      }
    }
    this.facebook = paramJSONObject.optString("facebook");
    this.facebook_name = paramJSONObject.optString("facebook_name");
    this.livejournal = paramJSONObject.optString("livejournal");
    this.site = paramJSONObject.optString("site");
    this.screen_name = paramJSONObject.optString("screen_name", "id" + this.id);
    this.skype = paramJSONObject.optString("skype");
    this.mobile_phone = paramJSONObject.optString("mobile_phone");
    this.home_phone = paramJSONObject.optString("home_phone");
    this.twitter = paramJSONObject.optString("twitter");
    this.instagram = paramJSONObject.optString("instagram");
    this.about = paramJSONObject.optString("about");
    this.activities = paramJSONObject.optString("activities");
    this.books = paramJSONObject.optString("books");
    this.games = paramJSONObject.optString("games");
    this.interests = paramJSONObject.optString("interests");
    this.movies = paramJSONObject.optString("movies");
    this.quotes = paramJSONObject.optString("quotes");
    this.tv = paramJSONObject.optString("tv");
    this.nickname = paramJSONObject.optString("nickname", null);
    this.can_post = ParseUtils.parseBoolean(paramJSONObject, "can_post");
    this.can_see_all_posts = ParseUtils.parseBoolean(paramJSONObject, "can_see_all_posts");
    this.blacklisted_by_me = ParseUtils.parseBoolean(paramJSONObject, "blacklisted_by_me");
    this.can_write_private_message = ParseUtils.parseBoolean(paramJSONObject, "can_write_private_message");
    this.wall_comments = ParseUtils.parseBoolean(paramJSONObject, "wall_default");
    String str = paramJSONObject.optString("deactivated");
    this.is_deleted = "deleted".equals(str);
    this.is_banned = "banned".equals(str);
    this.wall_default_owner = "owner".equals(paramJSONObject.optString("wall_default"));
    this.verified = ParseUtils.parseBoolean(paramJSONObject, "verified");
    this.sex = paramJSONObject.optInt("sex");
    JSONObject localJSONObject5 = paramJSONObject.optJSONObject("counters");
    if (localJSONObject5 != null)
      this.counters = new Counters(localJSONObject5);
    JSONObject localJSONObject6 = paramJSONObject.optJSONObject("occupation");
    if (localJSONObject6 != null)
      this.occupation = new Occupation(localJSONObject6);
    this.relation = paramJSONObject.optInt("relation");
    if (paramJSONObject.has("relatives"))
    {
      if (this.relatives == null)
        this.relatives = new VKList();
      this.relatives.fill(paramJSONObject.optJSONArray("relatives"), Relative.class);
    }
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.activity);
    paramParcel.writeParcelable(this.status_audio, paramInt);
    paramParcel.writeString(this.bdate);
    paramParcel.writeParcelable(this.city, paramInt);
    paramParcel.writeParcelable(this.country, paramInt);
    paramParcel.writeLong(this.last_seen);
    paramParcel.writeParcelable(this.universities, paramInt);
    paramParcel.writeParcelable(this.schools, paramInt);
    paramParcel.writeInt(this.smoking);
    paramParcel.writeInt(this.alcohol);
    paramParcel.writeInt(this.political);
    paramParcel.writeInt(this.life_main);
    paramParcel.writeInt(this.people_main);
    paramParcel.writeString(this.inspired_by);
    paramParcel.writeStringArray(this.langs);
    paramParcel.writeString(this.religion);
    paramParcel.writeString(this.facebook);
    paramParcel.writeString(this.facebook_name);
    paramParcel.writeString(this.livejournal);
    paramParcel.writeString(this.skype);
    paramParcel.writeString(this.site);
    paramParcel.writeString(this.twitter);
    paramParcel.writeString(this.instagram);
    paramParcel.writeString(this.mobile_phone);
    paramParcel.writeString(this.home_phone);
    paramParcel.writeString(this.screen_name);
    paramParcel.writeString(this.activities);
    paramParcel.writeString(this.interests);
    paramParcel.writeString(this.movies);
    paramParcel.writeString(this.tv);
    paramParcel.writeString(this.books);
    paramParcel.writeString(this.games);
    paramParcel.writeString(this.about);
    paramParcel.writeString(this.quotes);
    byte b2;
    byte b3;
    label311: byte b4;
    label327: byte b5;
    label343: byte b6;
    label359: byte b7;
    label375: byte b8;
    label391: byte b9;
    if (this.can_post)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.can_see_all_posts)
        break label475;
      b3 = b1;
      paramParcel.writeByte(b3);
      if (!this.can_write_private_message)
        break label481;
      b4 = b1;
      paramParcel.writeByte(b4);
      if (!this.wall_comments)
        break label487;
      b5 = b1;
      paramParcel.writeByte(b5);
      if (!this.is_banned)
        break label493;
      b6 = b1;
      paramParcel.writeByte(b6);
      if (!this.is_deleted)
        break label499;
      b7 = b1;
      paramParcel.writeByte(b7);
      if (!this.wall_default_owner)
        break label505;
      b8 = b1;
      paramParcel.writeByte(b8);
      if (!this.verified)
        break label511;
      b9 = b1;
      label407: paramParcel.writeByte(b9);
      paramParcel.writeInt(this.sex);
      paramParcel.writeParcelable(this.counters, paramInt);
      paramParcel.writeParcelable(this.occupation, paramInt);
      paramParcel.writeInt(this.relation);
      paramParcel.writeParcelable(this.relatives, paramInt);
      if (!this.blacklisted_by_me)
        break label517;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label475: b3 = 0;
      break label311;
      label481: b4 = 0;
      break label327;
      label487: b5 = 0;
      break label343;
      label493: b6 = 0;
      break label359;
      label499: b7 = 0;
      break label375;
      label505: b8 = 0;
      break label391;
      label511: b9 = 0;
      break label407;
      label517: b1 = 0;
    }
  }

  public static class Attitude
  {
    public static final int COMPROMISABLE = 3;
    public static final int NEGATIVE = 2;
    public static final int NEUTRAL = 4;
    public static final int POSITIVE = 5;
    public static final int VERY_NEGATIVE = 1;
  }

  public static class Counters
    implements Parcelable
  {
    public static Parcelable.Creator<Counters> CREATOR = new Parcelable.Creator()
    {
      public VKApiUserFull.Counters createFromParcel(Parcel paramAnonymousParcel)
      {
        return new VKApiUserFull.Counters(paramAnonymousParcel, null);
      }

      public VKApiUserFull.Counters[] newArray(int paramAnonymousInt)
      {
        return new VKApiUserFull.Counters[paramAnonymousInt];
      }
    };
    public static final int NO_COUNTER = -1;
    public int albums = -1;
    public int audios = -1;
    public int followers = -1;
    public int friends = -1;
    public int groups = -1;
    public int mutual_friends = -1;
    public int notes = -1;
    public int online_friends = -1;
    public int pages = -1;
    public int photos = -1;
    public int subscriptions = -1;
    public int user_videos = -1;
    public int videos = -1;

    private Counters(Parcel paramParcel)
    {
      this.albums = paramParcel.readInt();
      this.videos = paramParcel.readInt();
      this.audios = paramParcel.readInt();
      this.notes = paramParcel.readInt();
      this.friends = paramParcel.readInt();
      this.photos = paramParcel.readInt();
      this.groups = paramParcel.readInt();
      this.online_friends = paramParcel.readInt();
      this.mutual_friends = paramParcel.readInt();
      this.user_videos = paramParcel.readInt();
      this.followers = paramParcel.readInt();
      this.subscriptions = paramParcel.readInt();
      this.pages = paramParcel.readInt();
    }

    Counters(JSONObject paramJSONObject)
    {
      this.albums = paramJSONObject.optInt("albums", this.albums);
      this.audios = paramJSONObject.optInt("audios", this.audios);
      this.followers = paramJSONObject.optInt("followers", this.followers);
      this.photos = paramJSONObject.optInt("photos", this.photos);
      this.friends = paramJSONObject.optInt("friends", this.friends);
      this.groups = paramJSONObject.optInt("groups", this.groups);
      this.mutual_friends = paramJSONObject.optInt("mutual_friends", this.mutual_friends);
      this.notes = paramJSONObject.optInt("notes", this.notes);
      this.online_friends = paramJSONObject.optInt("online_friends", this.online_friends);
      this.user_videos = paramJSONObject.optInt("user_videos", this.user_videos);
      this.videos = paramJSONObject.optInt("videos", this.videos);
      this.subscriptions = paramJSONObject.optInt("subscriptions", this.subscriptions);
      this.pages = paramJSONObject.optInt("pages", this.pages);
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.albums);
      paramParcel.writeInt(this.videos);
      paramParcel.writeInt(this.audios);
      paramParcel.writeInt(this.notes);
      paramParcel.writeInt(this.friends);
      paramParcel.writeInt(this.photos);
      paramParcel.writeInt(this.groups);
      paramParcel.writeInt(this.online_friends);
      paramParcel.writeInt(this.mutual_friends);
      paramParcel.writeInt(this.user_videos);
      paramParcel.writeInt(this.followers);
      paramParcel.writeInt(this.subscriptions);
      paramParcel.writeInt(this.pages);
    }
  }

  public static class LifeMain
  {
    public static final int BEAUTY_AND_ART = 7;
    public static final int CAREER_AND_MONEY = 2;
    public static final int ENTERTAINMENT_AND_LEISURE = 3;
    public static final int FAME_AND_INFLUENCE = 8;
    public static final int FAMILY_AND_CHILDREN = 1;
    public static final int IMPROOVING_THE_WORLD = 5;
    public static final int PERSONAL_DEVELOPMENT = 6;
    public static final int SCIENCE_AND_RESEARCH = 4;
  }

  public static class Occupation
    implements Parcelable
  {
    public static Parcelable.Creator<Occupation> CREATOR = new Parcelable.Creator()
    {
      public VKApiUserFull.Occupation createFromParcel(Parcel paramAnonymousParcel)
      {
        return new VKApiUserFull.Occupation(paramAnonymousParcel, null);
      }

      public VKApiUserFull.Occupation[] newArray(int paramAnonymousInt)
      {
        return new VKApiUserFull.Occupation[paramAnonymousInt];
      }
    };
    public static final int NO_COUNTER = -1;
    public int id = -1;
    public String name;
    public String type;

    private Occupation(Parcel paramParcel)
    {
      this.type = paramParcel.readString();
      this.id = paramParcel.readInt();
      this.name = paramParcel.readString();
    }

    Occupation(JSONObject paramJSONObject)
    {
      this.type = paramJSONObject.optString("type");
      this.id = paramJSONObject.optInt("id", this.id);
      this.name = paramJSONObject.optString("name");
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.type);
      paramParcel.writeInt(this.id);
      paramParcel.writeString(this.name);
    }
  }

  public static class PeopleMain
  {
    public static final int COURAGE_AND_PERSISTENCE = 5;
    public static final int HEALTH_AND_BEAUTY = 3;
    public static final int HUMOR_AND_LOVE_FOR_LIFE = 6;
    public static final int INTELLECT_AND_CREATIVITY = 1;
    public static final int KINDNESS_AND_HONESTLY = 2;
    public static final int WEALTH_AND_POWER = 4;
  }

  public static class Political
  {
    public static final int APATHETIC = 9;
    public static final int CENTRIST = 3;
    public static final int COMMUNNIST = 1;
    public static final int CONSERVATIVE = 5;
    public static final int LIBERAL = 4;
    public static final int LIBERTARIAN = 8;
    public static final int MONARCHIST = 6;
    public static final int SOCIALIST = 2;
    public static final int ULTRACONSERVATIVE = 7;
  }

  public static class Relation
  {
    public static final int COMPLICATED = 5;
    public static final int ENGAGED = 3;
    public static final int IN_LOVE = 7;
    public static final int MARRIED = 4;
    public static final int RELATIONSHIP = 2;
    public static final int SEARCHING = 6;
    public static final int SINGLE = 1;
  }

  public static class Relative extends VKApiModel
    implements Parcelable, Identifiable
  {
    public static Parcelable.Creator<Relative> CREATOR = new Parcelable.Creator()
    {
      public VKApiUserFull.Relative createFromParcel(Parcel paramAnonymousParcel)
      {
        return new VKApiUserFull.Relative(paramAnonymousParcel, null);
      }

      public VKApiUserFull.Relative[] newArray(int paramAnonymousInt)
      {
        return new VKApiUserFull.Relative[paramAnonymousInt];
      }
    };
    public int id;
    public String name;

    private Relative(Parcel paramParcel)
    {
      this.id = paramParcel.readInt();
      this.name = paramParcel.readString();
    }

    public int describeContents()
    {
      return 0;
    }

    public int getId()
    {
      return this.id;
    }

    public Relative parse(JSONObject paramJSONObject)
    {
      this.id = paramJSONObject.optInt("id");
      this.name = paramJSONObject.optString("name");
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.id);
      paramParcel.writeString(this.name);
    }
  }

  public static class RelativeType
  {
    public static final String CHILD = "child";
    public static final String GRANDCHILD = "grandchild";
    public static final String GRANDPARENT = "grandparent";
    public static final String PARENT = "parent";
    public static final String PARTNER = "partner";
    public static final String SUBLING = "sibling";
  }

  public static class Sex
  {
    public static final int FEMALE = 1;
    public static final int MALE = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiUserFull
 * JD-Core Version:    0.6.2
 */