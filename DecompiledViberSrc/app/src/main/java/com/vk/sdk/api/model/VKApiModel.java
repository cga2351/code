package com.vk.sdk.api.model;

import android.os.Parcelable;
import android.util.SparseArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class VKApiModel
  implements Parcelable
{
  public JSONObject fields;
  private SparseArray<Object> mKeyedTags;
  private Object mTag;

  public VKApiModel()
  {
  }

  public VKApiModel(JSONObject paramJSONObject)
    throws JSONException
  {
    parse(paramJSONObject);
  }

  public Object getTag()
  {
    return this.mTag;
  }

  public Object getTag(int paramInt)
  {
    if (this.mKeyedTags != null)
      return this.mKeyedTags.get(paramInt);
    return null;
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    return (VKApiModel)ParseUtils.parseViaReflection(this, paramJSONObject);
  }

  public void setTag(int paramInt, Object paramObject)
  {
    if (this.mKeyedTags == null)
      this.mKeyedTags = new SparseArray(2);
    this.mKeyedTags.put(paramInt, paramObject);
  }

  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiModel
 * JD-Core Version:    0.6.2
 */