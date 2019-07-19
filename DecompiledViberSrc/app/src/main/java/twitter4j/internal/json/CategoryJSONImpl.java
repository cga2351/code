package twitter4j.internal.json;

import java.io.Serializable;
import twitter4j.Category;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class CategoryJSONImpl
  implements Serializable, Category
{
  private static final long serialVersionUID = -6703617743623288566L;
  private String name;
  private int size;
  private String slug;

  CategoryJSONImpl(JSONObject paramJSONObject)
    throws JSONException
  {
    init(paramJSONObject);
  }

  static ResponseList<Category> createCategoriesList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    return createCategoriesList(paramHttpResponse.asJSONArray(), paramHttpResponse, paramConfiguration);
  }

  static ResponseList<Category> createCategoriesList(JSONArray paramJSONArray, HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    while (true)
    {
      int i;
      try
      {
        if (paramConfiguration.isJSONStoreEnabled())
          DataObjectFactoryUtil.clearThreadLocalMap();
        ResponseListImpl localResponseListImpl = new ResponseListImpl(paramJSONArray.length(), paramHttpResponse);
        i = 0;
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          CategoryJSONImpl localCategoryJSONImpl = new CategoryJSONImpl(localJSONObject);
          localResponseListImpl.add(localCategoryJSONImpl);
          if (paramConfiguration.isJSONStoreEnabled())
            DataObjectFactoryUtil.registerJSONObject(localCategoryJSONImpl, localJSONObject);
        }
        else
        {
          if (paramConfiguration.isJSONStoreEnabled())
            DataObjectFactoryUtil.registerJSONObject(localResponseListImpl, paramJSONArray);
          return localResponseListImpl;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new TwitterException(localJSONException);
      }
      i++;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CategoryJSONImpl localCategoryJSONImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCategoryJSONImpl = (CategoryJSONImpl)paramObject;
      if (this.size != localCategoryJSONImpl.size)
        return false;
      if (this.name != null)
      {
        if (this.name.equals(localCategoryJSONImpl.name));
      }
      else
        while (localCategoryJSONImpl.name != null)
          return false;
      if (this.slug == null)
        break;
    }
    while (this.slug.equals(localCategoryJSONImpl.slug));
    while (true)
    {
      return false;
      if (localCategoryJSONImpl.slug == null)
        break;
    }
  }

  public String getName()
  {
    return this.name;
  }

  public int getSize()
  {
    return this.size;
  }

  public String getSlug()
  {
    return this.slug;
  }

  public int hashCode()
  {
    if (this.name != null);
    for (int i = this.name.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.slug;
      int k = 0;
      if (str != null)
        k = this.slug.hashCode();
      return 31 * (j + k) + this.size;
    }
  }

  void init(JSONObject paramJSONObject)
    throws JSONException
  {
    this.name = paramJSONObject.getString("name");
    this.slug = paramJSONObject.getString("slug");
    this.size = z_T4JInternalParseUtil.getInt("size", paramJSONObject);
  }

  public String toString()
  {
    return "CategoryJSONImpl{name='" + this.name + '\'' + ", slug='" + this.slug + '\'' + ", size=" + this.size + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.CategoryJSONImpl
 * JD-Core Version:    0.6.2
 */