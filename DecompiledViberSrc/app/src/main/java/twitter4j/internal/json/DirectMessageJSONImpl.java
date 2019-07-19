package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.DirectMessage;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.ResponseList;
import twitter4j.SymbolEntity;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class DirectMessageJSONImpl extends TwitterResponseImpl
  implements Serializable, DirectMessage
{
  private static final long serialVersionUID = -7104233663827757577L;
  private Date createdAt;
  private HashtagEntity[] hashtagEntities;
  private long id;
  private MediaEntity[] mediaEntities;
  private User recipient;
  private long recipientId;
  private String recipientScreenName;
  private User sender;
  private long senderId;
  private String senderScreenName;
  private SymbolEntity[] symbolEntities;
  private String text;
  private URLEntity[] urlEntities;
  private UserMentionEntity[] userMentionEntities;

  DirectMessageJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    super(paramHttpResponse);
    JSONObject localJSONObject = paramHttpResponse.asJSONObject();
    init(localJSONObject);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, localJSONObject);
    }
  }

  DirectMessageJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    init(paramJSONObject);
  }

  static ResponseList<DirectMessage> createDirectMessageList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    while (true)
    {
      int j;
      try
      {
        if (paramConfiguration.isJSONStoreEnabled())
          DataObjectFactoryUtil.clearThreadLocalMap();
        JSONArray localJSONArray = paramHttpResponse.asJSONArray();
        int i = localJSONArray.length();
        ResponseListImpl localResponseListImpl = new ResponseListImpl(i, paramHttpResponse);
        j = 0;
        if (j < i)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(j);
          DirectMessageJSONImpl localDirectMessageJSONImpl = new DirectMessageJSONImpl(localJSONObject);
          localResponseListImpl.add(localDirectMessageJSONImpl);
          if (paramConfiguration.isJSONStoreEnabled())
            DataObjectFactoryUtil.registerJSONObject(localDirectMessageJSONImpl, localJSONObject);
        }
        else
        {
          if (paramConfiguration.isJSONStoreEnabled())
            DataObjectFactoryUtil.registerJSONObject(localResponseListImpl, localJSONArray);
          return localResponseListImpl;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new TwitterException(localJSONException);
      }
      catch (TwitterException localTwitterException)
      {
        throw localTwitterException;
      }
      j++;
    }
  }

  private void init(JSONObject paramJSONObject)
    throws TwitterException
  {
    int i = 0;
    this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
    this.senderId = z_T4JInternalParseUtil.getLong("sender_id", paramJSONObject);
    this.recipientId = z_T4JInternalParseUtil.getLong("recipient_id", paramJSONObject);
    this.createdAt = z_T4JInternalParseUtil.getDate("created_at", paramJSONObject);
    this.senderScreenName = z_T4JInternalParseUtil.getUnescapedString("sender_screen_name", paramJSONObject);
    this.recipientScreenName = z_T4JInternalParseUtil.getUnescapedString("recipient_screen_name", paramJSONObject);
    try
    {
      this.sender = new UserJSONImpl(paramJSONObject.getJSONObject("sender"));
      this.recipient = new UserJSONImpl(paramJSONObject.getJSONObject("recipient"));
      if (!paramJSONObject.isNull("entities"))
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("entities");
        if (!localJSONObject.isNull("user_mentions"))
        {
          JSONArray localJSONArray5 = localJSONObject.getJSONArray("user_mentions");
          int i4 = localJSONArray5.length();
          this.userMentionEntities = new UserMentionEntity[i4];
          for (int i5 = 0; i5 < i4; i5++)
            this.userMentionEntities[i5] = new UserMentionEntityJSONImpl(localJSONArray5.getJSONObject(i5));
        }
        if (!localJSONObject.isNull("urls"))
        {
          JSONArray localJSONArray4 = localJSONObject.getJSONArray("urls");
          int i2 = localJSONArray4.length();
          this.urlEntities = new URLEntity[i2];
          for (int i3 = 0; i3 < i2; i3++)
            this.urlEntities[i3] = new URLEntityJSONImpl(localJSONArray4.getJSONObject(i3));
        }
        if (!localJSONObject.isNull("hashtags"))
        {
          JSONArray localJSONArray3 = localJSONObject.getJSONArray("hashtags");
          int n = localJSONArray3.length();
          this.hashtagEntities = new HashtagEntity[n];
          for (int i1 = 0; i1 < n; i1++)
            this.hashtagEntities[i1] = new HashtagEntityJSONImpl(localJSONArray3.getJSONObject(i1));
        }
        if (!localJSONObject.isNull("symbols"))
        {
          JSONArray localJSONArray2 = localJSONObject.getJSONArray("symbols");
          int k = localJSONArray2.length();
          this.symbolEntities = new SymbolEntity[k];
          for (int m = 0; m < k; m++)
            this.symbolEntities[m] = new HashtagEntityJSONImpl(localJSONArray2.getJSONObject(m));
        }
        if (!localJSONObject.isNull("media"))
        {
          JSONArray localJSONArray1 = localJSONObject.getJSONArray("media");
          int j = localJSONArray1.length();
          this.mediaEntities = new MediaEntity[j];
          while (i < j)
          {
            this.mediaEntities[i] = new MediaEntityJSONImpl(localJSONArray1.getJSONObject(i));
            i++;
          }
        }
      }
      UserMentionEntity[] arrayOfUserMentionEntity;
      URLEntity[] arrayOfURLEntity;
      label499: HashtagEntity[] arrayOfHashtagEntity;
      label518: SymbolEntity[] arrayOfSymbolEntity;
      if (this.userMentionEntities == null)
      {
        arrayOfUserMentionEntity = new UserMentionEntity[0];
        this.userMentionEntities = arrayOfUserMentionEntity;
        if (this.urlEntities != null)
          break label601;
        arrayOfURLEntity = new URLEntity[0];
        this.urlEntities = arrayOfURLEntity;
        if (this.hashtagEntities != null)
          break label610;
        arrayOfHashtagEntity = new HashtagEntity[0];
        this.hashtagEntities = arrayOfHashtagEntity;
        if (this.symbolEntities != null)
          break label619;
        arrayOfSymbolEntity = new SymbolEntity[0];
        label537: this.symbolEntities = arrayOfSymbolEntity;
        if (this.mediaEntities != null)
          break label628;
      }
      label601: label610: label619: label628: for (MediaEntity[] arrayOfMediaEntity = new MediaEntity[0]; ; arrayOfMediaEntity = this.mediaEntities)
      {
        this.mediaEntities = arrayOfMediaEntity;
        this.text = HTMLEntity.unescapeAndSlideEntityIncdices(paramJSONObject.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        return;
        arrayOfUserMentionEntity = this.userMentionEntities;
        break;
        arrayOfURLEntity = this.urlEntities;
        break label499;
        arrayOfHashtagEntity = this.hashtagEntities;
        break label518;
        arrayOfSymbolEntity = this.symbolEntities;
        break label537;
      }
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null)
      bool = false;
    while ((this == paramObject) || (((paramObject instanceof DirectMessage)) && (((DirectMessage)paramObject).getId() == this.id)))
      return bool;
    return false;
  }

  public Date getCreatedAt()
  {
    return this.createdAt;
  }

  public HashtagEntity[] getHashtagEntities()
  {
    return this.hashtagEntities;
  }

  public long getId()
  {
    return this.id;
  }

  public MediaEntity[] getMediaEntities()
  {
    return this.mediaEntities;
  }

  public User getRecipient()
  {
    return this.recipient;
  }

  public long getRecipientId()
  {
    return this.recipientId;
  }

  public String getRecipientScreenName()
  {
    return this.recipientScreenName;
  }

  public User getSender()
  {
    return this.sender;
  }

  public long getSenderId()
  {
    return this.senderId;
  }

  public String getSenderScreenName()
  {
    return this.senderScreenName;
  }

  public SymbolEntity[] getSymbolEntities()
  {
    return this.symbolEntities;
  }

  public String getText()
  {
    return this.text;
  }

  public URLEntity[] getURLEntities()
  {
    return this.urlEntities;
  }

  public UserMentionEntity[] getUserMentionEntities()
  {
    return this.userMentionEntities;
  }

  public int hashCode()
  {
    return (int)this.id;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("DirectMessageJSONImpl{id=").append(this.id).append(", text='").append(this.text).append('\'').append(", sender_id=").append(this.senderId).append(", recipient_id=").append(this.recipientId).append(", created_at=").append(this.createdAt).append(", userMentionEntities=");
    Object localObject1;
    Object localObject2;
    label114: Object localObject3;
    label138: Object localObject4;
    label225: Object localObject5;
    label250: StringBuilder localStringBuilder6;
    Object localObject6;
    if (this.userMentionEntities == null)
    {
      localObject1 = null;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(localObject1).append(", urlEntities=");
      if (this.urlEntities != null)
        break label306;
      localObject2 = null;
      StringBuilder localStringBuilder3 = localStringBuilder2.append(localObject2).append(", hashtagEntities=");
      if (this.hashtagEntities != null)
        break label318;
      localObject3 = null;
      StringBuilder localStringBuilder4 = localStringBuilder3.append(localObject3).append(", sender_screen_name='").append(this.senderScreenName).append('\'').append(", recipient_screen_name='").append(this.recipientScreenName).append('\'').append(", sender=").append(this.sender).append(", recipient=").append(this.recipient).append(", userMentionEntities=");
      if (this.userMentionEntities != null)
        break label330;
      localObject4 = null;
      StringBuilder localStringBuilder5 = localStringBuilder4.append(localObject4).append(", urlEntities=");
      if (this.urlEntities != null)
        break label342;
      localObject5 = null;
      localStringBuilder6 = localStringBuilder5.append(localObject5).append(", hashtagEntities=");
      HashtagEntity[] arrayOfHashtagEntity = this.hashtagEntities;
      localObject6 = null;
      if (arrayOfHashtagEntity != null)
        break label354;
    }
    while (true)
    {
      return localObject6 + '}';
      localObject1 = Arrays.asList(this.userMentionEntities);
      break;
      label306: localObject2 = Arrays.asList(this.urlEntities);
      break label114;
      label318: localObject3 = Arrays.asList(this.hashtagEntities);
      break label138;
      label330: localObject4 = Arrays.asList(this.userMentionEntities);
      break label225;
      label342: localObject5 = Arrays.asList(this.urlEntities);
      break label250;
      label354: localObject6 = Arrays.asList(this.hashtagEntities);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.DirectMessageJSONImpl
 * JD-Core Version:    0.6.2
 */