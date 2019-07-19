package twitter4j.json;

import twitter4j.internal.logging.Logger;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public final class JSONObjectType
{
  private static final Logger logger = Logger.getLogger(JSONObjectType.class);

  public static Type determine(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.isNull("sender"))
      return Type.SENDER;
    if (!paramJSONObject.isNull("text"))
      return Type.STATUS;
    if (!paramJSONObject.isNull("direct_message"))
      return Type.DIRECT_MESSAGE;
    if (!paramJSONObject.isNull("delete"))
      return Type.DELETE;
    if (!paramJSONObject.isNull("limit"))
      return Type.LIMIT;
    if (!paramJSONObject.isNull("warning"))
      return Type.STALL_WARNING;
    if (!paramJSONObject.isNull("scrub_geo"))
      return Type.SCRUB_GEO;
    if (!paramJSONObject.isNull("friends"))
      return Type.FRIENDS;
    if (!paramJSONObject.isNull("event"))
      try
      {
        String str = paramJSONObject.getString("event");
        if ("favorite".equals(str))
          return Type.FAVORITE;
        if ("unfavorite".equals(str))
          return Type.UNFAVORITE;
        if ("follow".equals(str))
          return Type.FOLLOW;
        if ("unfollow".equals(str))
          return Type.UNFOLLOW;
        if (str.startsWith("list"))
        {
          if ("list_member_added".equals(str))
            return Type.USER_LIST_MEMBER_ADDED;
          if ("list_member_removed".equals(str))
            return Type.USER_LIST_MEMBER_DELETED;
          if ("list_user_subscribed".equals(str))
            return Type.USER_LIST_SUBSCRIBED;
          if ("list_user_unsubscribed".equals(str))
            return Type.USER_LIST_UNSUBSCRIBED;
          if ("list_created".equals(str))
            return Type.USER_LIST_CREATED;
          if ("list_updated".equals(str))
            return Type.USER_LIST_UPDATED;
          if ("list_destroyed".equals(str))
            return Type.USER_LIST_DESTROYED;
        }
        else
        {
          if ("user_update".equals(str))
            return Type.USER_UPDATE;
          if ("block".equals(str))
            return Type.BLOCK;
          if ("unblock".equals(str))
          {
            Type localType = Type.UNBLOCK;
            return localType;
          }
        }
      }
      catch (JSONException localJSONException1)
      {
      }
    try
    {
      logger.warn("Failed to get event element: ", paramJSONObject.toString(2));
      label329: 
      do
        return Type.UNKNOWN;
      while (paramJSONObject.isNull("disconnect"));
      return Type.DISCONNECTION;
    }
    catch (JSONException localJSONException2)
    {
      break label329;
    }
  }

  public static enum Type
  {
    static
    {
      DIRECT_MESSAGE = new Type("DIRECT_MESSAGE", 2);
      DELETE = new Type("DELETE", 3);
      LIMIT = new Type("LIMIT", 4);
      STALL_WARNING = new Type("STALL_WARNING", 5);
      SCRUB_GEO = new Type("SCRUB_GEO", 6);
      FRIENDS = new Type("FRIENDS", 7);
      FAVORITE = new Type("FAVORITE", 8);
      UNFAVORITE = new Type("UNFAVORITE", 9);
      FOLLOW = new Type("FOLLOW", 10);
      UNFOLLOW = new Type("UNFOLLOW", 11);
      USER_LIST_MEMBER_ADDED = new Type("USER_LIST_MEMBER_ADDED", 12);
      USER_LIST_MEMBER_DELETED = new Type("USER_LIST_MEMBER_DELETED", 13);
      USER_LIST_SUBSCRIBED = new Type("USER_LIST_SUBSCRIBED", 14);
      USER_LIST_UNSUBSCRIBED = new Type("USER_LIST_UNSUBSCRIBED", 15);
      USER_LIST_CREATED = new Type("USER_LIST_CREATED", 16);
      USER_LIST_UPDATED = new Type("USER_LIST_UPDATED", 17);
      USER_LIST_DESTROYED = new Type("USER_LIST_DESTROYED", 18);
      USER_UPDATE = new Type("USER_UPDATE", 19);
      BLOCK = new Type("BLOCK", 20);
      UNBLOCK = new Type("UNBLOCK", 21);
      DISCONNECTION = new Type("DISCONNECTION", 22);
      UNKNOWN = new Type("UNKNOWN", 23);
      Type[] arrayOfType = new Type[24];
      arrayOfType[0] = SENDER;
      arrayOfType[1] = STATUS;
      arrayOfType[2] = DIRECT_MESSAGE;
      arrayOfType[3] = DELETE;
      arrayOfType[4] = LIMIT;
      arrayOfType[5] = STALL_WARNING;
      arrayOfType[6] = SCRUB_GEO;
      arrayOfType[7] = FRIENDS;
      arrayOfType[8] = FAVORITE;
      arrayOfType[9] = UNFAVORITE;
      arrayOfType[10] = FOLLOW;
      arrayOfType[11] = UNFOLLOW;
      arrayOfType[12] = USER_LIST_MEMBER_ADDED;
      arrayOfType[13] = USER_LIST_MEMBER_DELETED;
      arrayOfType[14] = USER_LIST_SUBSCRIBED;
      arrayOfType[15] = USER_LIST_UNSUBSCRIBED;
      arrayOfType[16] = USER_LIST_CREATED;
      arrayOfType[17] = USER_LIST_UPDATED;
      arrayOfType[18] = USER_LIST_DESTROYED;
      arrayOfType[19] = USER_UPDATE;
      arrayOfType[20] = BLOCK;
      arrayOfType[21] = UNBLOCK;
      arrayOfType[22] = DISCONNECTION;
      arrayOfType[23] = UNKNOWN;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.json.JSONObjectType
 * JD-Core Version:    0.6.2
 */