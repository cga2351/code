package twitter4j.internal.json;

import twitter4j.Friendship;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class FriendshipJSONImpl
  implements Friendship
{
  private static final long serialVersionUID = 7724410837770709741L;
  private boolean followedBy = false;
  private boolean following = false;
  private final long id;
  private final String name;
  private final String screenName;

  FriendshipJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    while (true)
    {
      try
      {
        this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
        this.name = paramJSONObject.getString("name");
        this.screenName = paramJSONObject.getString("screen_name");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("connections");
        if (i < localJSONArray.length())
        {
          String str = localJSONArray.getString(i);
          if ("following".equals(str))
            this.following = true;
          else if ("followed_by".equals(str))
            this.followedBy = true;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new TwitterException(localJSONException.getMessage() + ":" + paramJSONObject.toString(), localJSONException);
      }
      return;
      i++;
    }
  }

  static ResponseList<Friendship> createFriendshipList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    try
    {
      if (paramConfiguration.isJSONStoreEnabled())
        DataObjectFactoryUtil.clearThreadLocalMap();
      JSONArray localJSONArray = paramHttpResponse.asJSONArray();
      int i = localJSONArray.length();
      ResponseListImpl localResponseListImpl = new ResponseListImpl(i, paramHttpResponse);
      for (int j = 0; j < i; j++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(j);
        FriendshipJSONImpl localFriendshipJSONImpl = new FriendshipJSONImpl(localJSONObject);
        if (paramConfiguration.isJSONStoreEnabled())
          DataObjectFactoryUtil.registerJSONObject(localFriendshipJSONImpl, localJSONObject);
        localResponseListImpl.add(localFriendshipJSONImpl);
      }
      if (paramConfiguration.isJSONStoreEnabled())
        DataObjectFactoryUtil.registerJSONObject(localResponseListImpl, localJSONArray);
      return localResponseListImpl;
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
    catch (TwitterException localTwitterException)
    {
      throw localTwitterException;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FriendshipJSONImpl localFriendshipJSONImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFriendshipJSONImpl = (FriendshipJSONImpl)paramObject;
      if (this.followedBy != localFriendshipJSONImpl.followedBy)
        return false;
      if (this.following != localFriendshipJSONImpl.following)
        return false;
      if (this.id != localFriendshipJSONImpl.id)
        return false;
      if (!this.name.equals(localFriendshipJSONImpl.name))
        return false;
    }
    while (this.screenName.equals(localFriendshipJSONImpl.screenName));
    return false;
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

  public int hashCode()
  {
    int i = 1;
    int j = 31 * (int)(this.id ^ this.id >>> 32);
    int k;
    int n;
    label58: int i2;
    label78: int i3;
    if (this.name != null)
    {
      k = this.name.hashCode();
      int m = 31 * (k + j);
      if (this.screenName == null)
        break label105;
      n = this.screenName.hashCode();
      int i1 = 31 * (n + m);
      if (!this.following)
        break label111;
      i2 = i;
      i3 = 31 * (i2 + i1);
      if (!this.followedBy)
        break label117;
    }
    while (true)
    {
      return i3 + i;
      k = 0;
      break;
      label105: n = 0;
      break label58;
      label111: i2 = 0;
      break label78;
      label117: i = 0;
    }
  }

  public boolean isFollowedBy()
  {
    return this.followedBy;
  }

  public boolean isFollowing()
  {
    return this.following;
  }

  public String toString()
  {
    return "FriendshipJSONImpl{id=" + this.id + ", name='" + this.name + '\'' + ", screenName='" + this.screenName + '\'' + ", following=" + this.following + ", followedBy=" + this.followedBy + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.FriendshipJSONImpl
 * JD-Core Version:    0.6.2
 */