package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Generics;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class FieldSerializerGenericsUtil
{
  private Kryo kryo;
  private FieldSerializer serializer;

  public FieldSerializerGenericsUtil(FieldSerializer paramFieldSerializer)
  {
    this.serializer = paramFieldSerializer;
    this.kryo = paramFieldSerializer.getKryo();
  }

  public static Class[] getGenerics(Type paramType, Kryo paramKryo)
  {
    if ((paramType instanceof GenericArrayType))
    {
      Type localType3 = ((GenericArrayType)paramType).getGenericComponentType();
      if ((localType3 instanceof Class))
      {
        Class[] arrayOfClass3 = new Class[1];
        arrayOfClass3[0] = ((Class)localType3);
        return arrayOfClass3;
      }
      return getGenerics(localType3, paramKryo);
    }
    if (!(paramType instanceof ParameterizedType))
      return null;
    if (Log.TRACE)
      Log.trace("kryo", "Processing generic type " + paramType);
    Type[] arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments();
    Class[] arrayOfClass1 = new Class[arrayOfType.length];
    int i = arrayOfType.length;
    int j = 0;
    int k = 0;
    Type localType1;
    if (j < i)
    {
      localType1 = arrayOfType[j];
      if (Log.TRACE)
        Log.trace("kryo", "Processing actual type " + localType1 + " (" + localType1.getClass().getName() + ")");
      arrayOfClass1[j] = Object.class;
      if ((localType1 instanceof Class))
        arrayOfClass1[j] = ((Class)localType1);
    }
    label204: for (int m = k + 1; ; m = k)
    {
      j++;
      k = m;
      break;
      if ((localType1 instanceof ParameterizedType))
      {
        arrayOfClass1[j] = ((Class)((ParameterizedType)localType1).getRawType());
        break label204;
      }
      if ((localType1 instanceof TypeVariable))
      {
        Generics localGenerics2 = paramKryo.getGenericsScope();
        if (localGenerics2 == null)
          continue;
        Class localClass2 = localGenerics2.getConcreteClass(((TypeVariable)localType1).getName());
        if (localClass2 == null)
          continue;
        arrayOfClass1[j] = localClass2;
        break label204;
      }
      if ((localType1 instanceof GenericArrayType))
      {
        Type localType2 = ((GenericArrayType)localType1).getGenericComponentType();
        if ((localType2 instanceof Class))
        {
          arrayOfClass1[j] = Array.newInstance((Class)localType2, 0).getClass();
          break label204;
        }
        if ((localType2 instanceof TypeVariable))
        {
          Generics localGenerics1 = paramKryo.getGenericsScope();
          if (localGenerics1 == null)
            break label204;
          Class localClass1 = localGenerics1.getConcreteClass(((TypeVariable)localType2).getName());
          if (localClass1 == null)
            break label204;
          arrayOfClass1[j] = Array.newInstance(localClass1, 0).getClass();
          break label204;
        }
        Class[] arrayOfClass2 = getGenerics(localType2, paramKryo);
        if (arrayOfClass2 == null)
          break label204;
        arrayOfClass1[j] = arrayOfClass2[0];
        break label204;
        if (k == 0)
          return null;
        return arrayOfClass1;
      }
    }
  }

  private Class<?> getTypeVarConcreteClass(Class[] paramArrayOfClass, int paramInt, String paramString)
  {
    if ((paramArrayOfClass != null) && (paramArrayOfClass.length > paramInt))
      return paramArrayOfClass[paramInt];
    if (Log.TRACE)
      Log.trace("kryo", "Trying to use kryo.getGenericScope");
    Generics localGenerics = this.kryo.getGenericsScope();
    if (localGenerics != null)
      return localGenerics.getConcreteClass(paramString);
    return null;
  }

  Generics buildGenericsScope(Class paramClass, Class[] paramArrayOfClass)
  {
    int i = 0;
    TypeVariable[] arrayOfTypeVariable = null;
    for (Class localClass1 = paramClass; localClass1 != null; localClass1 = localClass1.getComponentType())
    {
      arrayOfTypeVariable = localClass1.getTypeParameters();
      if ((arrayOfTypeVariable != null) && (arrayOfTypeVariable.length != 0))
        break;
    }
    Generics localGenerics = null;
    if (arrayOfTypeVariable != null)
    {
      int j = arrayOfTypeVariable.length;
      localGenerics = null;
      if (j > 0)
      {
        Log.trace("kryo", "Class " + paramClass.getName() + " has generic type parameters");
        HashMap localHashMap = new HashMap();
        int k = arrayOfTypeVariable.length;
        for (int m = 0; m < k; m++)
        {
          TypeVariable localTypeVariable = arrayOfTypeVariable[m];
          String str = localTypeVariable.getName();
          if (Log.TRACE)
            Log.trace("kryo", "Type parameter variable: name=" + str + " type bounds=" + Arrays.toString(localTypeVariable.getBounds()));
          Class localClass2 = getTypeVarConcreteClass(paramArrayOfClass, i, str);
          if (localClass2 != null)
          {
            localHashMap.put(str, localClass2);
            if (Log.TRACE)
              Log.trace("kryo", "Concrete type used for " + str + " is: " + localClass2.getName());
          }
          i++;
        }
        localGenerics = new Generics(localHashMap);
      }
    }
    return localGenerics;
  }

  Class[] computeFieldGenerics(Type paramType, Field paramField, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    Class[] arrayOfClass3;
    if (paramType != null)
    {
      if ((!(paramType instanceof TypeVariable)) || (this.serializer.getGenericsScope() == null))
        break label126;
      TypeVariable localTypeVariable = (TypeVariable)paramType;
      Class localClass2 = this.serializer.getGenericsScope().getConcreteClass(localTypeVariable.getName());
      if (localClass2 == null)
        break label633;
      paramArrayOfClass[0] = localClass2;
      arrayOfClass3 = new Class[1];
      arrayOfClass3[0] = paramArrayOfClass[0];
      if (Log.TRACE)
        Log.trace("kryo", "Determined concrete class of '" + paramField.getName() + "' to be " + paramArrayOfClass[0].getName());
    }
    while (true)
    {
      localObject = arrayOfClass3;
      label126: 
      do
      {
        boolean bool;
        do
        {
          Type[] arrayOfType;
          do
          {
            return localObject;
            if (!(paramType instanceof ParameterizedType))
              break;
            arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments();
            localObject = null;
          }
          while (arrayOfType == null);
          Class[] arrayOfClass2 = new Class[arrayOfType.length];
          int i = 0;
          if (i < arrayOfType.length)
          {
            Type localType2 = arrayOfType[i];
            if ((localType2 instanceof Class))
              arrayOfClass2[i] = ((Class)localType2);
            while (true)
            {
              i++;
              break;
              if ((localType2 instanceof ParameterizedType))
              {
                arrayOfClass2[i] = ((Class)((ParameterizedType)localType2).getRawType());
              }
              else if (((localType2 instanceof TypeVariable)) && (this.serializer.getGenericsScope() != null))
              {
                arrayOfClass2[i] = this.serializer.getGenericsScope().getConcreteClass(((TypeVariable)localType2).getName());
              }
              else if ((localType2 instanceof WildcardType))
              {
                arrayOfClass2[i] = Object.class;
              }
              else if ((localType2 instanceof GenericArrayType))
              {
                Type localType3 = ((GenericArrayType)localType2).getGenericComponentType();
                if ((localType3 instanceof Class))
                {
                  arrayOfClass2[i] = Array.newInstance((Class)localType3, 0).getClass();
                }
                else if ((localType3 instanceof TypeVariable))
                {
                  Generics localGenerics = this.serializer.getGenericsScope();
                  if (localGenerics != null)
                  {
                    Class localClass1 = localGenerics.getConcreteClass(((TypeVariable)localType3).getName());
                    if (localClass1 != null)
                      arrayOfClass2[i] = Array.newInstance(localClass1, 0).getClass();
                  }
                }
              }
              else
              {
                arrayOfClass2[i] = null;
              }
            }
          }
          if ((Log.TRACE) && (arrayOfClass2 != null))
            Log.trace("kryo", "Determined concrete class of parametrized '" + paramField.getName() + "' to be " + paramType + " where type parameters are " + Arrays.toString(arrayOfClass2));
          return arrayOfClass2;
          bool = paramType instanceof GenericArrayType;
          localObject = null;
        }
        while (!bool);
        Type localType1 = ((GenericArrayType)paramType).getGenericComponentType();
        Class[] arrayOfClass1 = new Class[1];
        arrayOfClass1[0] = paramArrayOfClass[0];
        localObject = computeFieldGenerics(localType1, paramField, arrayOfClass1);
        if ((Log.TRACE) && (localObject != null))
        {
          Log.trace("kryo", "Determined concrete class of a generic array '" + paramField.getName() + "' to be " + paramType + " where type parameters are " + Arrays.toString((Object[])localObject));
          return localObject;
        }
      }
      while (!Log.TRACE);
      Log.trace("kryo", "Determined concrete class of '" + paramField.getName() + "' to be " + paramType);
      return localObject;
      label633: arrayOfClass3 = null;
    }
  }

  FieldSerializer.CachedField newCachedFieldOfGenericType(Field paramField, int paramInt, Class[] paramArrayOfClass, Type paramType)
  {
    if (Log.TRACE)
      Log.trace("kryo", "Field '" + paramField.getName() + "' of type " + paramArrayOfClass[0] + " of generic type " + paramType);
    if ((Log.TRACE) && (paramType != null))
      Log.trace("kryo", "Field generic type is of class " + paramType.getClass().getName());
    Class[] arrayOfClass1 = getGenerics(paramType, this.kryo);
    Generics localGenerics1 = buildGenericsScope(paramArrayOfClass[0], arrayOfClass1);
    Generics localGenerics3;
    if ((paramArrayOfClass[0] == Object.class) && ((paramType instanceof TypeVariable)) && (this.serializer.getGenericsScope() != null))
    {
      TypeVariable localTypeVariable = (TypeVariable)paramType;
      Class localClass = this.serializer.getGenericsScope().getConcreteClass(localTypeVariable.getName());
      if (localClass != null)
      {
        localGenerics3 = new Generics();
        localGenerics3.add(localTypeVariable.getName(), localClass);
      }
    }
    for (Generics localGenerics2 = localGenerics3; ; localGenerics2 = localGenerics1)
    {
      if (Log.TRACE)
        Log.trace("kryo", "Generics scope of field '" + paramField.getName() + "' of class " + paramType + " is " + localGenerics2);
      Class[] arrayOfClass2 = computeFieldGenerics(paramType, paramField, paramArrayOfClass);
      FieldSerializer.CachedField localCachedField = this.serializer.newMatchingCachedField(paramField, paramInt, paramArrayOfClass[0], paramType, arrayOfClass2);
      if ((arrayOfClass2 != null) && ((localCachedField instanceof ObjectField)) && (arrayOfClass2.length > 0) && (arrayOfClass2[0] != null))
      {
        ((ObjectField)localCachedField).generics = arrayOfClass2;
        if (Log.TRACE)
          Log.trace("kryo", "Field generics: " + Arrays.toString(arrayOfClass2));
      }
      return localCachedField;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.FieldSerializerGenericsUtil
 * JD-Core Version:    0.6.2
 */