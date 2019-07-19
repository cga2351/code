package twitter4j.internal.json;

import twitter4j.HashtagEntity;
import twitter4j.SymbolEntity;
import twitter4j.TwitterException;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class HashtagEntityJSONImpl extends EntityIndex
  implements HashtagEntity, SymbolEntity
{
  private static final long serialVersionUID = 4068992372784813200L;
  private String text;

  HashtagEntityJSONImpl()
  {
  }

  HashtagEntityJSONImpl(int paramInt1, int paramInt2, String paramString)
  {
    setStart(paramInt1);
    setEnd(paramInt2);
    this.text = paramString;
  }

  HashtagEntityJSONImpl(JSONObject paramJSONObject)
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
      if (!paramJSONObject.isNull("text"))
        this.text = paramJSONObject.getString("text");
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
    HashtagEntityJSONImpl localHashtagEntityJSONImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localHashtagEntityJSONImpl = (HashtagEntityJSONImpl)paramObject;
      if (this.text == null)
        break;
    }
    while (this.text.equals(localHashtagEntityJSONImpl.text));
    while (true)
    {
      return false;
      if (localHashtagEntityJSONImpl.text == null)
        break;
    }
  }

  public int getEnd()
  {
    return super.getEnd();
  }

  public int getStart()
  {
    return super.getStart();
  }

  public String getText()
  {
    return this.text;
  }

  public int hashCode()
  {
    if (this.text != null)
      return this.text.hashCode();
    return 0;
  }

  public String toString()
  {
    return "HashtagEntityJSONImpl{text='" + this.text + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.HashtagEntityJSONImpl
 * JD-Core Version:    0.6.2
 */