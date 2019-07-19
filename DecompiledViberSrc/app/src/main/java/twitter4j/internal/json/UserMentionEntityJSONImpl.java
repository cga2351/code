package twitter4j.internal.json;

import twitter4j.TwitterException;
import twitter4j.UserMentionEntity;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class UserMentionEntityJSONImpl extends EntityIndex
  implements UserMentionEntity
{
  private static final long serialVersionUID = 6580431141350059702L;
  private long id;
  private String name;
  private String screenName;

  UserMentionEntityJSONImpl()
  {
  }

  UserMentionEntityJSONImpl(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong)
  {
    setStart(paramInt1);
    setEnd(paramInt2);
    this.name = paramString1;
    this.screenName = paramString2;
    this.id = paramLong;
  }

  UserMentionEntityJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    init(paramJSONObject);
  }

  private void init(JSONObject paramJSONObject)
    throws TwitterException
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("indices");
      setStart(localJSONArray.getInt(0));
      setEnd(localJSONArray.getInt(1));
      if (!paramJSONObject.isNull("name"))
        this.name = paramJSONObject.getString("name");
      if (!paramJSONObject.isNull("screen_name"))
        this.screenName = paramJSONObject.getString("screen_name");
      this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    UserMentionEntityJSONImpl localUserMentionEntityJSONImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localUserMentionEntityJSONImpl = (UserMentionEntityJSONImpl)paramObject;
      if (this.id != localUserMentionEntityJSONImpl.id)
        return false;
      if (this.name != null)
      {
        if (this.name.equals(localUserMentionEntityJSONImpl.name));
      }
      else
        while (localUserMentionEntityJSONImpl.name != null)
          return false;
      if (this.screenName == null)
        break;
    }
    while (this.screenName.equals(localUserMentionEntityJSONImpl.screenName));
    while (true)
    {
      return false;
      if (localUserMentionEntityJSONImpl.screenName == null)
        break;
    }
  }

  public int getEnd()
  {
    return super.getEnd();
  }

  public long getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public String getScreenName()
  {
    return this.screenName;
  }

  public int getStart()
  {
    return super.getStart();
  }

  public String getText()
  {
    return this.screenName;
  }

  public int hashCode()
  {
    if (this.name != null);
    for (int i = this.name.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.screenName;
      int k = 0;
      if (str != null)
        k = this.screenName.hashCode();
      return 31 * (j + k) + (int)(this.id ^ this.id >>> 32);
    }
  }

  public String toString()
  {
    return "UserMentionEntityJSONImpl{name='" + this.name + '\'' + ", screenName='" + this.screenName + '\'' + ", id=" + this.id + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.UserMentionEntityJSONImpl
 * JD-Core Version:    0.6.2
 */