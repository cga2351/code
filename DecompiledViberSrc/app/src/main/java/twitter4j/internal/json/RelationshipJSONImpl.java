package twitter4j.internal.json;

import java.io.Serializable;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class RelationshipJSONImpl extends TwitterResponseImpl
  implements Serializable, Relationship
{
  private static final long serialVersionUID = 7725021608907856360L;
  private final boolean sourceBlockingTarget;
  private final boolean sourceCanDm;
  private final boolean sourceFollowedByTarget;
  private final boolean sourceFollowingTarget;
  private final boolean sourceNotificationsEnabled;
  private final long sourceUserId;
  private final String sourceUserScreenName;
  private final long targetUserId;
  private final String targetUserScreenName;
  private boolean wantRetweets;

  RelationshipJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    this(paramHttpResponse, paramHttpResponse.asJSONObject());
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse.asJSONObject());
    }
  }

  RelationshipJSONImpl(HttpResponse paramHttpResponse, JSONObject paramJSONObject)
    throws TwitterException
  {
    super(paramHttpResponse);
    try
    {
      JSONObject localJSONObject1 = paramJSONObject.getJSONObject("relationship");
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("source");
      JSONObject localJSONObject3 = localJSONObject1.getJSONObject("target");
      this.sourceUserId = z_T4JInternalParseUtil.getLong("id", localJSONObject2);
      this.targetUserId = z_T4JInternalParseUtil.getLong("id", localJSONObject3);
      this.sourceUserScreenName = z_T4JInternalParseUtil.getUnescapedString("screen_name", localJSONObject2);
      this.targetUserScreenName = z_T4JInternalParseUtil.getUnescapedString("screen_name", localJSONObject3);
      this.sourceBlockingTarget = z_T4JInternalParseUtil.getBoolean("blocking", localJSONObject2);
      this.sourceFollowingTarget = z_T4JInternalParseUtil.getBoolean("following", localJSONObject2);
      this.sourceFollowedByTarget = z_T4JInternalParseUtil.getBoolean("followed_by", localJSONObject2);
      this.sourceCanDm = z_T4JInternalParseUtil.getBoolean("can_dm", localJSONObject2);
      this.sourceNotificationsEnabled = z_T4JInternalParseUtil.getBoolean("notifications_enabled", localJSONObject2);
      this.wantRetweets = z_T4JInternalParseUtil.getBoolean("want_retweets", localJSONObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException.getMessage() + ":" + paramJSONObject.toString(), localJSONException);
    }
  }

  RelationshipJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    this(null, paramJSONObject);
  }

  static ResponseList<Relationship> createRelationshipList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
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
        RelationshipJSONImpl localRelationshipJSONImpl = new RelationshipJSONImpl(localJSONObject);
        if (paramConfiguration.isJSONStoreEnabled())
          DataObjectFactoryUtil.registerJSONObject(localRelationshipJSONImpl, localJSONObject);
        localResponseListImpl.add(localRelationshipJSONImpl);
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

  public boolean canSourceDm()
  {
    return this.sourceCanDm;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Relationship localRelationship;
    do
    {
      return true;
      if (!(paramObject instanceof Relationship))
        return false;
      localRelationship = (Relationship)paramObject;
      if (this.sourceUserId != localRelationship.getSourceUserId())
        return false;
      if (this.targetUserId != localRelationship.getTargetUserId())
        return false;
      if (!this.sourceUserScreenName.equals(localRelationship.getSourceUserScreenName()))
        return false;
    }
    while (this.targetUserScreenName.equals(localRelationship.getTargetUserScreenName()));
    return false;
  }

  public long getSourceUserId()
  {
    return this.sourceUserId;
  }

  public String getSourceUserScreenName()
  {
    return this.sourceUserScreenName;
  }

  public long getTargetUserId()
  {
    return this.targetUserId;
  }

  public String getTargetUserScreenName()
  {
    return this.targetUserScreenName;
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * (int)(this.targetUserId ^ this.targetUserId >>> 32);
    int k;
    int n;
    label52: int i2;
    label72: int i4;
    label92: int i6;
    label112: int i7;
    if (this.targetUserScreenName != null)
    {
      k = this.targetUserScreenName.hashCode();
      int m = 31 * (k + j);
      if (!this.sourceBlockingTarget)
        break label189;
      n = i;
      int i1 = 31 * (n + m);
      if (!this.sourceNotificationsEnabled)
        break label195;
      i2 = i;
      int i3 = 31 * (i2 + i1);
      if (!this.sourceFollowingTarget)
        break label201;
      i4 = i;
      int i5 = 31 * (i4 + i3);
      if (!this.sourceFollowedByTarget)
        break label207;
      i6 = i;
      i7 = 31 * (i6 + i5);
      if (!this.sourceCanDm)
        break label213;
    }
    while (true)
    {
      int i8 = 31 * (31 * (i7 + i) + (int)(this.sourceUserId ^ this.sourceUserId >>> 32));
      String str = this.sourceUserScreenName;
      int i9 = 0;
      if (str != null)
        i9 = this.sourceUserScreenName.hashCode();
      return i8 + i9;
      k = 0;
      break;
      label189: n = 0;
      break label52;
      label195: i2 = 0;
      break label72;
      label201: i4 = 0;
      break label92;
      label207: i6 = 0;
      break label112;
      label213: i = 0;
    }
  }

  public boolean isSourceBlockingTarget()
  {
    return this.sourceBlockingTarget;
  }

  public boolean isSourceFollowedByTarget()
  {
    return this.sourceFollowedByTarget;
  }

  public boolean isSourceFollowingTarget()
  {
    return this.sourceFollowingTarget;
  }

  public boolean isSourceNotificationsEnabled()
  {
    return this.sourceNotificationsEnabled;
  }

  public boolean isSourceWantRetweets()
  {
    return this.wantRetweets;
  }

  public boolean isTargetFollowedBySource()
  {
    return this.sourceFollowingTarget;
  }

  public boolean isTargetFollowingSource()
  {
    return this.sourceFollowedByTarget;
  }

  public String toString()
  {
    return "RelationshipJSONImpl{sourceUserId=" + this.sourceUserId + ", targetUserId=" + this.targetUserId + ", sourceUserScreenName='" + this.sourceUserScreenName + '\'' + ", targetUserScreenName='" + this.targetUserScreenName + '\'' + ", sourceFollowingTarget=" + this.sourceFollowingTarget + ", sourceFollowedByTarget=" + this.sourceFollowedByTarget + ", sourceCanDm=" + this.sourceCanDm + ", sourceNotificationsEnabled=" + this.sourceNotificationsEnabled + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.RelationshipJSONImpl
 * JD-Core Version:    0.6.2
 */