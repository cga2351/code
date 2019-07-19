package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VKList<T extends VKApiModel,  extends Parcelable,  extends Identifiable> extends VKApiModel
  implements Parcelable, List<T>
{
  public static Parcelable.Creator<VKList> CREATOR;
  private static final int NO_COUNT = -1;
  private int count = -1;
  private ArrayList<T> items = new ArrayList();

  static
  {
    if (!VKList.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      CREATOR = new Parcelable.Creator()
      {
        public VKList createFromParcel(Parcel paramAnonymousParcel)
        {
          return new VKList(paramAnonymousParcel);
        }

        public VKList[] newArray(int paramAnonymousInt)
        {
          return new VKList[paramAnonymousInt];
        }
      };
      return;
    }
  }

  public VKList()
  {
  }

  public VKList(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    for (int j = 0; j < i; j++)
      this.items.add((VKApiModel)paramParcel.readParcelable(getClass().getClassLoader()));
    this.count = paramParcel.readInt();
  }

  public VKList(List<? extends T> paramList)
  {
    assert (paramList != null);
    this.items = new ArrayList(paramList);
  }

  public VKList(JSONArray paramJSONArray, Parser<T> paramParser)
  {
    fill(paramJSONArray, paramParser);
  }

  public VKList(JSONArray paramJSONArray, Class<? extends T> paramClass)
  {
    fill(paramJSONArray, paramClass);
  }

  public VKList(JSONObject paramJSONObject, Parser<T> paramParser)
  {
    fill(paramJSONObject, paramParser);
  }

  public VKList(JSONObject paramJSONObject, Class<? extends T> paramClass)
  {
    fill(paramJSONObject, paramClass);
  }

  public void add(int paramInt, T paramT)
  {
    this.items.add(paramInt, paramT);
  }

  public boolean add(T paramT)
  {
    return this.items.add(paramT);
  }

  public void addAfter(int paramInt, T paramT)
  {
    int i = size();
    for (int j = 0; ; j++)
      if (j < i)
      {
        if ((((Identifiable)get(j)).getId() > paramInt) || (j == i - 1))
          add(j + 1, paramT);
      }
      else
        return;
  }

  public boolean addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    return this.items.addAll(paramInt, paramCollection);
  }

  public boolean addAll(Collection<? extends T> paramCollection)
  {
    return this.items.addAll(paramCollection);
  }

  public void addBefore(int paramInt, T paramT)
  {
    int i = size();
    for (int j = 0; ; j++)
      if (j < i)
      {
        if ((((Identifiable)get(j)).getId() > paramInt) || (j == i - 1))
          add(j, paramT);
      }
      else
        return;
  }

  public void clear()
  {
    this.items.clear();
  }

  public boolean contains(Object paramObject)
  {
    return this.items.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.items.containsAll(paramCollection);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    return (getClass().equals(paramObject.getClass())) && (this.items.equals(paramObject));
  }

  public void fill(JSONArray paramJSONArray, Parser<? extends T> paramParser)
  {
    int i;
    if (paramJSONArray != null)
      i = 0;
    while (true)
    {
      if (i < paramJSONArray.length());
      try
      {
        VKApiModel localVKApiModel = (VKApiModel)paramParser.parseObject(paramJSONArray.getJSONObject(i));
        if (localVKApiModel != null)
          this.items.add(localVKApiModel);
        label45: i++;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label45;
      }
    }
  }

  public void fill(JSONArray paramJSONArray, Class<? extends T> paramClass)
  {
    fill(paramJSONArray, new ReflectParser(paramClass));
  }

  public void fill(JSONObject paramJSONObject, Parser<? extends T> paramParser)
  {
    if (paramJSONObject != null)
    {
      fill(paramJSONObject.optJSONArray("items"), paramParser);
      this.count = paramJSONObject.optInt("count", this.count);
    }
  }

  public void fill(JSONObject paramJSONObject, Class<? extends T> paramClass)
  {
    if (paramJSONObject.has("response"))
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("response");
      if (localJSONArray != null)
      {
        fill(localJSONArray, paramClass);
        return;
      }
      fill(paramJSONObject.optJSONObject("response"), paramClass);
      return;
    }
    fill(paramJSONObject, new ReflectParser(paramClass));
  }

  public T get(int paramInt)
  {
    return (VKApiModel)this.items.get(paramInt);
  }

  public T getById(int paramInt)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      VKApiModel localVKApiModel = (VKApiModel)localIterator.next();
      if (((Identifiable)localVKApiModel).getId() == paramInt)
        return localVKApiModel;
    }
    return null;
  }

  public int getCount()
  {
    if (this.count != -1)
      return this.count;
    return size();
  }

  public int indexOf(Object paramObject)
  {
    return this.items.indexOf(paramObject);
  }

  public boolean isEmpty()
  {
    return this.items.isEmpty();
  }

  public Iterator<T> iterator()
  {
    return this.items.iterator();
  }

  public int lastIndexOf(Object paramObject)
  {
    return this.items.lastIndexOf(paramObject);
  }

  public ListIterator<T> listIterator()
  {
    return this.items.listIterator();
  }

  public ListIterator<T> listIterator(int paramInt)
  {
    return this.items.listIterator(paramInt);
  }

  public VKApiModel parse(JSONObject paramJSONObject)
    throws JSONException
  {
    throw new JSONException("Operation is not supported while class is generic");
  }

  public T remove(int paramInt)
  {
    return (VKApiModel)this.items.remove(paramInt);
  }

  public boolean remove(Object paramObject)
  {
    return this.items.remove(paramObject);
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.items.removeAll(paramCollection);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.items.retainAll(paramCollection);
  }

  public VKList<T> search(String paramString)
  {
    VKList localVKList = new VKList();
    Pattern localPattern = Pattern.compile("(?i).*\\b" + paramString + ".*");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      VKApiModel localVKApiModel = (VKApiModel)localIterator.next();
      if (localPattern.matcher(localVKApiModel.toString()).find())
        localVKList.add(localVKApiModel);
    }
    return localVKList;
  }

  public T set(int paramInt, T paramT)
  {
    return (VKApiModel)this.items.set(paramInt, paramT);
  }

  public int size()
  {
    return this.items.size();
  }

  public List<T> subList(int paramInt1, int paramInt2)
  {
    return this.items.subList(paramInt1, paramInt2);
  }

  public Object[] toArray()
  {
    return this.items.toArray();
  }

  public <T1> T1[] toArray(T1[] paramArrayOfT1)
  {
    return this.items.toArray(paramArrayOfT1);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.items.size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
      paramParcel.writeParcelable((VKApiModel)localIterator.next(), paramInt);
    paramParcel.writeInt(this.count);
  }

  public static abstract interface Parser<D>
  {
    public abstract D parseObject(JSONObject paramJSONObject)
      throws Exception;
  }

  public static final class ReflectParser<D extends VKApiModel>
    implements VKList.Parser<D>
  {
    private final Class<? extends D> clazz;

    public ReflectParser(Class<? extends D> paramClass)
    {
      this.clazz = paramClass;
    }

    public D parseObject(JSONObject paramJSONObject)
      throws Exception
    {
      try
      {
        Constructor localConstructor = this.clazz.getConstructor(new Class[] { JSONObject.class });
        if (localConstructor != null)
        {
          VKApiModel localVKApiModel = (VKApiModel)localConstructor.newInstance(new Object[] { paramJSONObject });
          return localVKApiModel;
        }
      }
      catch (Exception localException)
      {
      }
      return ((VKApiModel)this.clazz.newInstance()).parse(paramJSONObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKList
 * JD-Core Version:    0.6.2
 */