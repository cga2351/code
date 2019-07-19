package com.vk.sdk.api.model;

import android.os.Parcelable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseUtils
{
  private static Object parseArrayViaReflection(JSONArray paramJSONArray, Class paramClass)
    throws JSONException
  {
    Object localObject1 = Array.newInstance(paramClass.getComponentType(), paramJSONArray.length());
    Class localClass = paramClass.getComponentType();
    int i = 0;
    while (i < paramJSONArray.length())
      try
      {
        Object localObject2 = paramJSONArray.opt(i);
        if ((VKApiModel.class.isAssignableFrom(localClass)) && ((localObject2 instanceof JSONObject)))
          localObject2 = ((VKApiModel)localClass.newInstance()).parse((JSONObject)localObject2);
        Array.set(localObject1, i, localObject2);
        i++;
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new JSONException(localInstantiationException.getMessage());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new JSONException(localIllegalAccessException.getMessage());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new JSONException(localIllegalArgumentException.getMessage());
      }
    return localObject1;
  }

  public static boolean parseBoolean(String paramString)
    throws JSONException
  {
    return new JSONObject(paramString).optInt("response", 0) == 1;
  }

  public static boolean parseBoolean(JSONObject paramJSONObject, String paramString)
  {
    return (paramJSONObject != null) && (paramJSONObject.optInt(paramString, 0) == 1);
  }

  public static int parseInt(String paramString)
    throws JSONException
  {
    if (paramString == null)
      return 0;
    return new JSONObject(paramString).optInt("response");
  }

  public static int parseInt(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      return 0;
    return paramJSONObject.optInt(paramString, 0);
  }

  public static int[] parseIntArray(JSONArray paramJSONArray)
  {
    int[] arrayOfInt = new int[paramJSONArray.length()];
    for (int i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = paramJSONArray.optInt(i);
    return arrayOfInt;
  }

  public static long parseLong(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      return 0L;
    return paramJSONObject.optLong(paramString, 0L);
  }

  public static <T> T parseViaReflection(T paramT, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("response"))
      paramJSONObject = paramJSONObject.optJSONObject("response");
    if (paramJSONObject == null)
      return paramT;
    Field[] arrayOfField = paramT.getClass().getFields();
    int i = arrayOfField.length;
    int j = 0;
    label36: Field localField;
    Class localClass1;
    Object localObject1;
    if (j < i)
    {
      localField = arrayOfField[j];
      localField.setAccessible(true);
      String str = localField.getName();
      localClass1 = localField.getType();
      localObject1 = paramJSONObject.opt(str);
      if (localObject1 != null)
        break label87;
    }
    while (true)
    {
      j++;
      break label36;
      break;
      label87: Number localNumber;
      while (true)
      {
        try
        {
          if ((!localClass1.isPrimitive()) || (!(localObject1 instanceof Number)))
            break label375;
          localNumber = (Number)localObject1;
          if (localClass1.equals(Integer.TYPE))
            localField.setInt(paramT, localNumber.intValue());
        }
        catch (InstantiationException localInstantiationException)
        {
          throw new JSONException(localInstantiationException.getMessage());
          if (localClass1.equals(Long.TYPE))
            localField.setLong(paramT, localNumber.longValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new JSONException(localIllegalAccessException.getMessage());
          if (localClass1.equals(Float.TYPE))
            localField.setFloat(paramT, localNumber.floatValue());
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          throw new JSONException(localNoSuchMethodException.getMessage());
          if (localClass1.equals(Double.TYPE))
            localField.setDouble(paramT, localNumber.doubleValue());
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new JSONException(localInvocationTargetException.getMessage());
          if (!localClass1.equals(Boolean.TYPE))
            break label325;
          if (localNumber.intValue() == 1)
          {
            bool = true;
            localField.setBoolean(paramT, bool);
          }
        }
        catch (NoSuchMethodError localNoSuchMethodError)
        {
          throw new JSONException(localNoSuchMethodError.getMessage());
        }
        boolean bool = false;
      }
      label325: if (localClass1.equals(Short.TYPE))
        localField.setShort(paramT, localNumber.shortValue());
      else if (localClass1.equals(Byte.TYPE))
        localField.setByte(paramT, localNumber.byteValue());
    }
    label375: Object localObject2 = localField.get(paramT);
    if (localObject1.getClass().equals(localClass1));
    while (true)
    {
      localField.set(paramT, localObject1);
      break;
      if ((localClass1.isArray()) && ((localObject1 instanceof JSONArray)))
      {
        localObject1 = parseArrayViaReflection((JSONArray)localObject1, localClass1);
      }
      else if ((VKPhotoSizes.class.isAssignableFrom(localClass1)) && ((localObject1 instanceof JSONArray)))
      {
        Constructor localConstructor2 = localClass1.getConstructor(new Class[] { JSONArray.class });
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = ((JSONArray)localObject1);
        localObject1 = localConstructor2.newInstance(arrayOfObject2);
      }
      else if ((VKAttachments.class.isAssignableFrom(localClass1)) && ((localObject1 instanceof JSONArray)))
      {
        Constructor localConstructor1 = localClass1.getConstructor(new Class[] { JSONArray.class });
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = ((JSONArray)localObject1);
        localObject1 = localConstructor1.newInstance(arrayOfObject1);
      }
      else if (VKList.class.equals(localClass1))
      {
        Class localClass2 = (Class)((java.lang.reflect.ParameterizedType)localField.getGenericType()).getActualTypeArguments()[0];
        if ((VKApiModel.class.isAssignableFrom(localClass2)) && (Parcelable.class.isAssignableFrom(localClass2)) && (Identifiable.class.isAssignableFrom(localClass2)))
        {
          if ((localObject1 instanceof JSONArray))
          {
            localObject1 = new VKList((JSONArray)localObject1, localClass2);
            continue;
          }
          if ((localObject1 instanceof JSONObject))
            localObject1 = new VKList((JSONObject)localObject1, localClass2);
        }
      }
      else if ((VKApiModel.class.isAssignableFrom(localClass1)) && ((localObject1 instanceof JSONObject)))
      {
        VKApiModel localVKApiModel = ((VKApiModel)localClass1.newInstance()).parse((JSONObject)localObject1);
        localObject1 = localVKApiModel;
      }
      else
      {
        localObject1 = localObject2;
      }
    }
  }

  public static JSONArray rootJSONArray(String paramString)
    throws JSONException
  {
    return new JSONObject(paramString).getJSONArray("response");
  }

  public static JSONObject rootJSONObject(String paramString)
    throws JSONException
  {
    return new JSONObject(paramString).getJSONObject("response");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.ParseUtils
 * JD-Core Version:    0.6.2
 */