package com.facebook.model;

import com.facebook.FacebookGraphObjectException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract interface GraphObject
{
  public abstract Map<String, Object> asMap();

  public abstract <T extends GraphObject> T cast(Class<T> paramClass);

  public abstract JSONObject getInnerJSONObject();

  public abstract Object getProperty(String paramString);

  public abstract <T extends GraphObject> T getPropertyAs(String paramString, Class<T> paramClass);

  public abstract <T extends GraphObject> GraphObjectList<T> getPropertyAsList(String paramString, Class<T> paramClass);

  public abstract void removeProperty(String paramString);

  public abstract void setProperty(String paramString, Object paramObject);

  public static final class Factory
  {
    private static final SimpleDateFormat[] dateFormats = arrayOfSimpleDateFormat;
    private static final HashSet<Class<?>> verifiedGraphObjectClasses = new HashSet();

    static
    {
      SimpleDateFormat[] arrayOfSimpleDateFormat = new SimpleDateFormat[3];
      arrayOfSimpleDateFormat[0] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
      arrayOfSimpleDateFormat[1] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
      arrayOfSimpleDateFormat[2] = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    }

    static <U> U coerceValueToExpectedType(Object paramObject, Class<U> paramClass, ParameterizedType paramParameterizedType)
    {
      if (paramObject == null)
        if (Boolean.TYPE.equals(paramClass))
          paramObject = Boolean.valueOf(false);
      Class localClass1;
      do
      {
        return paramObject;
        if (Character.TYPE.equals(paramClass))
          return Character.valueOf('\000');
        if (paramClass.isPrimitive())
          return Integer.valueOf(0);
        return null;
        localClass1 = paramObject.getClass();
      }
      while ((paramClass.isAssignableFrom(localClass1)) || (paramClass.isPrimitive()));
      if (GraphObject.class.isAssignableFrom(paramClass))
      {
        if (JSONObject.class.isAssignableFrom(localClass1))
          return createGraphObjectProxy(paramClass, (JSONObject)paramObject);
        if (GraphObject.class.isAssignableFrom(localClass1))
          return ((GraphObject)paramObject).cast(paramClass);
        throw new FacebookGraphObjectException("Can't create GraphObject from " + localClass1.getName());
      }
      if ((Iterable.class.equals(paramClass)) || (Collection.class.equals(paramClass)) || (List.class.equals(paramClass)) || (GraphObjectList.class.equals(paramClass)))
      {
        if (paramParameterizedType == null)
          throw new FacebookGraphObjectException("can't infer generic type of: " + paramClass.toString());
        Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
        if ((arrayOfType == null) || (arrayOfType.length != 1) || (!(arrayOfType[0] instanceof Class)))
          throw new FacebookGraphObjectException("Expect collection properties to be of a type with exactly one generic parameter.");
        Class localClass2 = (Class)arrayOfType[0];
        if (JSONArray.class.isAssignableFrom(localClass1))
          return createList((JSONArray)paramObject, localClass2);
        throw new FacebookGraphObjectException("Can't create Collection from " + localClass1.getName());
      }
      if (String.class.equals(paramClass))
      {
        if ((Double.class.isAssignableFrom(localClass1)) || (Float.class.isAssignableFrom(localClass1)))
          return String.format("%f", new Object[] { paramObject });
        if (Number.class.isAssignableFrom(localClass1))
          return String.format("%d", new Object[] { paramObject });
      }
      else if ((Date.class.equals(paramClass)) && (String.class.isAssignableFrom(localClass1)))
      {
        SimpleDateFormat[] arrayOfSimpleDateFormat = dateFormats;
        int i = arrayOfSimpleDateFormat.length;
        int j = 0;
        while (j < i)
        {
          SimpleDateFormat localSimpleDateFormat = arrayOfSimpleDateFormat[j];
          try
          {
            Date localDate = localSimpleDateFormat.parse((String)paramObject);
            if (localDate != null)
              return localDate;
          }
          catch (ParseException localParseException)
          {
            j++;
          }
        }
      }
      throw new FacebookGraphObjectException("Can't convert type" + localClass1.getName() + " to " + paramClass.getName());
    }

    static String convertCamelCaseToLowercaseWithUnderscores(String paramString)
    {
      return paramString.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase(Locale.US);
    }

    public static GraphObject create()
    {
      return create(GraphObject.class);
    }

    public static <T extends GraphObject> T create(Class<T> paramClass)
    {
      return createGraphObjectProxy(paramClass, new JSONObject());
    }

    public static GraphObject create(JSONObject paramJSONObject)
    {
      return create(paramJSONObject, GraphObject.class);
    }

    public static <T extends GraphObject> T create(JSONObject paramJSONObject, Class<T> paramClass)
    {
      return createGraphObjectProxy(paramClass, paramJSONObject);
    }

    private static <T extends GraphObject> T createGraphObjectProxy(Class<T> paramClass, JSONObject paramJSONObject)
    {
      verifyCanProxyClass(paramClass);
      Class[] arrayOfClass = { paramClass };
      GraphObjectProxy localGraphObjectProxy = new GraphObjectProxy(paramJSONObject, paramClass);
      return (GraphObject)Proxy.newProxyInstance(GraphObject.class.getClassLoader(), arrayOfClass, localGraphObjectProxy);
    }

    private static Map<String, Object> createGraphObjectProxyForMap(JSONObject paramJSONObject)
    {
      Class[] arrayOfClass = { Map.class };
      GraphObjectProxy localGraphObjectProxy = new GraphObjectProxy(paramJSONObject, Map.class);
      return (Map)Proxy.newProxyInstance(GraphObject.class.getClassLoader(), arrayOfClass, localGraphObjectProxy);
    }

    public static <T> GraphObjectList<T> createList(Class<T> paramClass)
    {
      return createList(new JSONArray(), paramClass);
    }

    public static <T> GraphObjectList<T> createList(JSONArray paramJSONArray, Class<T> paramClass)
    {
      return new GraphObjectListImpl(paramJSONArray, paramClass);
    }

    private static Object getUnderlyingJSONObject(Object paramObject)
    {
      if (paramObject == null)
        paramObject = null;
      Class localClass;
      do
      {
        return paramObject;
        localClass = paramObject.getClass();
        if (GraphObject.class.isAssignableFrom(localClass))
          return ((GraphObject)paramObject).getInnerJSONObject();
        if (GraphObjectList.class.isAssignableFrom(localClass))
          return ((GraphObjectList)paramObject).getInnerJSONArray();
      }
      while (!Iterable.class.isAssignableFrom(localClass));
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)paramObject).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (GraphObject.class.isAssignableFrom(localObject.getClass()))
          localJSONArray.put(((GraphObject)localObject).getInnerJSONObject());
        else
          localJSONArray.put(localObject);
      }
      return localJSONArray;
    }

    private static <T extends GraphObject> boolean hasClassBeenVerified(Class<T> paramClass)
    {
      try
      {
        boolean bool = verifiedGraphObjectClasses.contains(paramClass);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public static boolean hasSameId(GraphObject paramGraphObject1, GraphObject paramGraphObject2)
    {
      if ((paramGraphObject1 == null) || (paramGraphObject2 == null) || (!paramGraphObject1.asMap().containsKey("id")) || (!paramGraphObject2.asMap().containsKey("id")));
      Object localObject1;
      Object localObject2;
      do
      {
        return false;
        if (paramGraphObject1.equals(paramGraphObject2))
          return true;
        localObject1 = paramGraphObject1.getProperty("id");
        localObject2 = paramGraphObject2.getProperty("id");
      }
      while ((localObject1 == null) || (localObject2 == null) || (!(localObject1 instanceof String)) || (!(localObject2 instanceof String)));
      return localObject1.equals(localObject2);
    }

    private static <T extends GraphObject> void recordClassHasBeenVerified(Class<T> paramClass)
    {
      try
      {
        verifiedGraphObjectClasses.add(paramClass);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    private static <T extends GraphObject> void verifyCanProxyClass(Class<T> paramClass)
    {
      if (hasClassBeenVerified(paramClass))
        return;
      if (!paramClass.isInterface())
        throw new FacebookGraphObjectException("Factory can only wrap interfaces, not class: " + paramClass.getName());
      Method[] arrayOfMethod = paramClass.getMethods();
      int i = arrayOfMethod.length;
      int j = 0;
      if (j < i)
      {
        Method localMethod = arrayOfMethod[j];
        String str = localMethod.getName();
        int k = localMethod.getParameterTypes().length;
        Class localClass = localMethod.getReturnType();
        boolean bool = localMethod.isAnnotationPresent(PropertyName.class);
        if (localMethod.getDeclaringClass().isAssignableFrom(GraphObject.class));
        while (true)
        {
          j++;
          break;
          if ((k == 1) && (localClass == Void.TYPE))
          {
            if (bool)
              if (!Utility.isNullOrEmpty(((PropertyName)localMethod.getAnnotation(PropertyName.class)).value()))
                continue;
          }
          else
            label256: 
            do
            {
              do
              {
                do
                {
                  do
                    throw new FacebookGraphObjectException("Factory can't proxy method: " + localMethod.toString());
                  while ((!str.startsWith("set")) || (str.length() <= 3));
                  break;
                }
                while ((k != 0) || (localClass == Void.TYPE));
                if (!bool)
                  break label256;
              }
              while (Utility.isNullOrEmpty(((PropertyName)localMethod.getAnnotation(PropertyName.class)).value()));
              break;
            }
            while ((!str.startsWith("get")) || (str.length() <= 3));
        }
      }
      recordClassHasBeenVerified(paramClass);
    }

    private static final class GraphObjectListImpl<T> extends AbstractList<T>
      implements GraphObjectList<T>
    {
      private final Class<?> itemType;
      private final JSONArray state;

      public GraphObjectListImpl(JSONArray paramJSONArray, Class<?> paramClass)
      {
        Validate.notNull(paramJSONArray, "state");
        Validate.notNull(paramClass, "itemType");
        this.state = paramJSONArray;
        this.itemType = paramClass;
      }

      private void checkIndex(int paramInt)
      {
        if ((paramInt < 0) || (paramInt >= this.state.length()))
          throw new IndexOutOfBoundsException();
      }

      private void put(int paramInt, T paramT)
      {
        Object localObject = GraphObject.Factory.getUnderlyingJSONObject(paramT);
        try
        {
          this.state.put(paramInt, localObject);
          return;
        }
        catch (JSONException localJSONException)
        {
          throw new IllegalArgumentException(localJSONException);
        }
      }

      public void add(int paramInt, T paramT)
      {
        if (paramInt < 0)
          throw new IndexOutOfBoundsException();
        if (paramInt < size())
          throw new UnsupportedOperationException("Only adding items at the end of the list is supported.");
        put(paramInt, paramT);
      }

      public final <U extends GraphObject> GraphObjectList<U> castToListOf(Class<U> paramClass)
      {
        if (GraphObject.class.isAssignableFrom(this.itemType))
        {
          if (paramClass.isAssignableFrom(this.itemType))
            return this;
          return GraphObject.Factory.createList(this.state, paramClass);
        }
        throw new FacebookGraphObjectException("Can't cast GraphObjectCollection of non-GraphObject type " + this.itemType);
      }

      public void clear()
      {
        throw new UnsupportedOperationException();
      }

      public boolean equals(Object paramObject)
      {
        if (paramObject == null);
        do
        {
          return false;
          if (this == paramObject)
            return true;
        }
        while (getClass() != paramObject.getClass());
        GraphObjectListImpl localGraphObjectListImpl = (GraphObjectListImpl)paramObject;
        return this.state.equals(localGraphObjectListImpl.state);
      }

      public T get(int paramInt)
      {
        checkIndex(paramInt);
        return GraphObject.Factory.coerceValueToExpectedType(this.state.opt(paramInt), this.itemType, null);
      }

      public final JSONArray getInnerJSONArray()
      {
        return this.state;
      }

      public int hashCode()
      {
        return this.state.hashCode();
      }

      public boolean remove(Object paramObject)
      {
        throw new UnsupportedOperationException();
      }

      public boolean removeAll(Collection<?> paramCollection)
      {
        throw new UnsupportedOperationException();
      }

      public boolean retainAll(Collection<?> paramCollection)
      {
        throw new UnsupportedOperationException();
      }

      public T set(int paramInt, T paramT)
      {
        checkIndex(paramInt);
        Object localObject = get(paramInt);
        put(paramInt, paramT);
        return localObject;
      }

      public int size()
      {
        return this.state.length();
      }

      public String toString()
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.itemType.getSimpleName();
        arrayOfObject[1] = this.state;
        return String.format("GraphObjectList{itemType=%s, state=%s}", arrayOfObject);
      }
    }

    private static final class GraphObjectProxy extends GraphObject.Factory.ProxyBase<JSONObject>
    {
      private static final String CASTTOMAP_METHOD = "asMap";
      private static final String CAST_METHOD = "cast";
      private static final String CLEAR_METHOD = "clear";
      private static final String CONTAINSKEY_METHOD = "containsKey";
      private static final String CONTAINSVALUE_METHOD = "containsValue";
      private static final String ENTRYSET_METHOD = "entrySet";
      private static final String GETINNERJSONOBJECT_METHOD = "getInnerJSONObject";
      private static final String GETPROPERTYASLIST_METHOD = "getPropertyAsList";
      private static final String GETPROPERTYAS_METHOD = "getPropertyAs";
      private static final String GETPROPERTY_METHOD = "getProperty";
      private static final String GET_METHOD = "get";
      private static final String ISEMPTY_METHOD = "isEmpty";
      private static final String KEYSET_METHOD = "keySet";
      private static final String PUTALL_METHOD = "putAll";
      private static final String PUT_METHOD = "put";
      private static final String REMOVEPROPERTY_METHOD = "removeProperty";
      private static final String REMOVE_METHOD = "remove";
      private static final String SETPROPERTY_METHOD = "setProperty";
      private static final String SIZE_METHOD = "size";
      private static final String VALUES_METHOD = "values";
      private final Class<?> graphObjectClass;

      public GraphObjectProxy(JSONObject paramJSONObject, Class<?> paramClass)
      {
        super();
        this.graphObjectClass = paramClass;
      }

      private Object createGraphObjectsFromParameters(CreateGraphObject paramCreateGraphObject, Object paramObject)
      {
        String str;
        if ((paramCreateGraphObject != null) && (!Utility.isNullOrEmpty(paramCreateGraphObject.value())))
        {
          str = paramCreateGraphObject.value();
          if (List.class.isAssignableFrom(paramObject.getClass()))
          {
            GraphObjectList localGraphObjectList = GraphObject.Factory.createList(GraphObject.class);
            Iterator localIterator = ((List)paramObject).iterator();
            while (localIterator.hasNext())
            {
              Object localObject = localIterator.next();
              GraphObject localGraphObject2 = GraphObject.Factory.create();
              localGraphObject2.setProperty(str, localObject);
              localGraphObjectList.add(localGraphObject2);
            }
            paramObject = localGraphObjectList;
          }
        }
        else
        {
          return paramObject;
        }
        GraphObject localGraphObject1 = GraphObject.Factory.create();
        localGraphObject1.setProperty(str, paramObject);
        return localGraphObject1;
      }

      private final Object proxyGraphObjectGettersAndSetters(Method paramMethod, Object[] paramArrayOfObject)
        throws JSONException
      {
        String str1 = paramMethod.getName();
        int i = paramMethod.getParameterTypes().length;
        PropertyName localPropertyName = (PropertyName)paramMethod.getAnnotation(PropertyName.class);
        String str2;
        Object localObject2;
        Class localClass;
        Type localType;
        if (localPropertyName != null)
        {
          str2 = localPropertyName.value();
          if (i != 0)
            break label106;
          localObject2 = ((JSONObject)this.state).opt(str2);
          localClass = paramMethod.getReturnType();
          localType = paramMethod.getGenericReturnType();
          if (!(localType instanceof ParameterizedType))
            break label156;
        }
        label156: for (ParameterizedType localParameterizedType = (ParameterizedType)localType; ; localParameterizedType = null)
        {
          return GraphObject.Factory.coerceValueToExpectedType(localObject2, localClass, localParameterizedType);
          str2 = GraphObject.Factory.convertCamelCaseToLowercaseWithUnderscores(str1.substring(3));
          break;
          label106: if (i == 1)
          {
            Object localObject1 = GraphObject.Factory.getUnderlyingJSONObject(createGraphObjectsFromParameters((CreateGraphObject)paramMethod.getAnnotation(CreateGraphObject.class), paramArrayOfObject[0]));
            ((JSONObject)this.state).putOpt(str2, localObject1);
            return null;
          }
          return throwUnexpectedMethodSignature(paramMethod);
        }
      }

      private final Object proxyGraphObjectMethods(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      {
        String str = paramMethod.getName();
        if (str.equals("cast"))
        {
          Class localClass = (Class)paramArrayOfObject[0];
          if ((localClass != null) && (localClass.isAssignableFrom(this.graphObjectClass)))
            return paramObject;
          return GraphObject.Factory.createGraphObjectProxy(localClass, (JSONObject)this.state);
        }
        if (str.equals("getInnerJSONObject"))
          return ((GraphObjectProxy)Proxy.getInvocationHandler(paramObject)).state;
        if (str.equals("asMap"))
          return GraphObject.Factory.createGraphObjectProxyForMap((JSONObject)this.state);
        if (str.equals("getProperty"))
          return ((JSONObject)this.state).opt((String)paramArrayOfObject[0]);
        if (str.equals("getPropertyAs"))
          return GraphObject.Factory.coerceValueToExpectedType(((JSONObject)this.state).opt((String)paramArrayOfObject[0]), (Class)paramArrayOfObject[1], null);
        if (str.equals("getPropertyAsList"))
          return GraphObject.Factory.coerceValueToExpectedType(((JSONObject)this.state).opt((String)paramArrayOfObject[0]), GraphObjectList.class, new ParameterizedType()
          {
            public Type[] getActualTypeArguments()
            {
              Type[] arrayOfType = new Type[1];
              arrayOfType[0] = this.val$expectedType;
              return arrayOfType;
            }

            public Type getOwnerType()
            {
              return null;
            }

            public Type getRawType()
            {
              return GraphObjectList.class;
            }
          });
        if (str.equals("setProperty"))
          return setJSONProperty(paramArrayOfObject);
        if (str.equals("removeProperty"))
        {
          ((JSONObject)this.state).remove((String)paramArrayOfObject[0]);
          return null;
        }
        return throwUnexpectedMethodSignature(paramMethod);
      }

      private final Object proxyMapMethods(Method paramMethod, Object[] paramArrayOfObject)
      {
        String str = paramMethod.getName();
        if (str.equals("clear"))
        {
          JsonUtil.jsonObjectClear((JSONObject)this.state);
          return null;
        }
        if (str.equals("containsKey"))
          return Boolean.valueOf(((JSONObject)this.state).has((String)paramArrayOfObject[0]));
        if (str.equals("containsValue"))
          return Boolean.valueOf(JsonUtil.jsonObjectContainsValue((JSONObject)this.state, paramArrayOfObject[0]));
        if (str.equals("entrySet"))
          return JsonUtil.jsonObjectEntrySet((JSONObject)this.state);
        if (str.equals("get"))
          return ((JSONObject)this.state).opt((String)paramArrayOfObject[0]);
        if (str.equals("isEmpty"))
        {
          if (((JSONObject)this.state).length() == 0);
          for (boolean bool = true; ; bool = false)
            return Boolean.valueOf(bool);
        }
        if (str.equals("keySet"))
          return JsonUtil.jsonObjectKeySet((JSONObject)this.state);
        if (str.equals("put"))
          return setJSONProperty(paramArrayOfObject);
        if (str.equals("putAll"))
        {
          if ((paramArrayOfObject[0] instanceof Map));
          for (Map localMap = (Map)paramArrayOfObject[0]; ; localMap = ((GraphObject)paramArrayOfObject[0]).asMap())
          {
            JsonUtil.jsonObjectPutAll((JSONObject)this.state, localMap);
            return null;
            if (!(paramArrayOfObject[0] instanceof GraphObject))
              break;
          }
          return null;
        }
        if (str.equals("remove"))
        {
          ((JSONObject)this.state).remove((String)paramArrayOfObject[0]);
          return null;
        }
        if (str.equals("size"))
          return Integer.valueOf(((JSONObject)this.state).length());
        if (str.equals("values"))
          return JsonUtil.jsonObjectValues((JSONObject)this.state);
        return throwUnexpectedMethodSignature(paramMethod);
      }

      private Object setJSONProperty(Object[] paramArrayOfObject)
      {
        String str = (String)paramArrayOfObject[0];
        Object localObject = GraphObject.Factory.getUnderlyingJSONObject(paramArrayOfObject[1]);
        try
        {
          ((JSONObject)this.state).putOpt(str, localObject);
          return null;
        }
        catch (JSONException localJSONException)
        {
          throw new IllegalArgumentException(localJSONException);
        }
      }

      public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
        throws Throwable
      {
        Class localClass = paramMethod.getDeclaringClass();
        if (localClass == Object.class)
          return proxyObjectMethods(paramObject, paramMethod, paramArrayOfObject);
        if (localClass == Map.class)
          return proxyMapMethods(paramMethod, paramArrayOfObject);
        if (localClass == GraphObject.class)
          return proxyGraphObjectMethods(paramObject, paramMethod, paramArrayOfObject);
        if (GraphObject.class.isAssignableFrom(localClass))
          return proxyGraphObjectGettersAndSetters(paramMethod, paramArrayOfObject);
        return throwUnexpectedMethodSignature(paramMethod);
      }

      public String toString()
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.graphObjectClass.getSimpleName();
        arrayOfObject[1] = this.state;
        return String.format("GraphObject{graphObjectClass=%s, state=%s}", arrayOfObject);
      }
    }

    private static abstract class ProxyBase<STATE>
      implements InvocationHandler
    {
      private static final String EQUALS_METHOD = "equals";
      private static final String TOSTRING_METHOD = "toString";
      protected final STATE state;

      protected ProxyBase(STATE paramSTATE)
      {
        this.state = paramSTATE;
      }

      protected final Object proxyObjectMethods(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
        throws Throwable
      {
        String str = paramMethod.getName();
        if (str.equals("equals"))
        {
          Object localObject = paramArrayOfObject[0];
          if (localObject == null)
            return Boolean.valueOf(false);
          InvocationHandler localInvocationHandler = Proxy.getInvocationHandler(localObject);
          if (!(localInvocationHandler instanceof GraphObject.Factory.GraphObjectProxy))
            return Boolean.valueOf(false);
          GraphObject.Factory.GraphObjectProxy localGraphObjectProxy = (GraphObject.Factory.GraphObjectProxy)localInvocationHandler;
          return Boolean.valueOf(this.state.equals(localGraphObjectProxy.state));
        }
        if (str.equals("toString"))
          return toString();
        return paramMethod.invoke(this.state, paramArrayOfObject);
      }

      protected final Object throwUnexpectedMethodSignature(Method paramMethod)
      {
        throw new FacebookGraphObjectException(getClass().getName() + " got an unexpected method signature: " + paramMethod.toString());
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.model.GraphObject
 * JD-Core Version:    0.6.2
 */