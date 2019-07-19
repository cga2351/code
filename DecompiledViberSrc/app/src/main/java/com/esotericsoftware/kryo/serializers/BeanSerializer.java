package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.MethodAccess;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BeanSerializer<T> extends Serializer<T>
{
  static final Object[] noArgs = new Object[0];
  Object access;
  private CachedProperty[] properties;

  public BeanSerializer(Kryo paramKryo, Class paramClass)
  {
    ArrayList localArrayList;
    while (true)
    {
      PropertyDescriptor localPropertyDescriptor;
      String str;
      try
      {
        BeanInfo localBeanInfo = Introspector.getBeanInfo(paramClass);
        PropertyDescriptor[] arrayOfPropertyDescriptor = localBeanInfo.getPropertyDescriptors();
        Arrays.sort(arrayOfPropertyDescriptor, new Comparator()
        {
          public int compare(PropertyDescriptor paramAnonymousPropertyDescriptor1, PropertyDescriptor paramAnonymousPropertyDescriptor2)
          {
            return paramAnonymousPropertyDescriptor1.getName().compareTo(paramAnonymousPropertyDescriptor2.getName());
          }
        });
        localArrayList = new ArrayList(arrayOfPropertyDescriptor.length);
        int j = arrayOfPropertyDescriptor.length;
        int k = 0;
        if (k >= j)
          break;
        localPropertyDescriptor = arrayOfPropertyDescriptor[k];
        str = localPropertyDescriptor.getName();
        if (str.equals("class"))
        {
          k++;
          continue;
        }
      }
      catch (IntrospectionException localIntrospectionException)
      {
        throw new KryoException("Error getting bean info.", localIntrospectionException);
      }
      Method localMethod1 = localPropertyDescriptor.getReadMethod();
      Method localMethod2 = localPropertyDescriptor.getWriteMethod();
      if ((localMethod1 != null) && (localMethod2 != null))
      {
        Class localClass = localMethod1.getReturnType();
        boolean bool = paramKryo.isFinal(localClass);
        Serializer localSerializer = null;
        if (bool)
          localSerializer = paramKryo.getRegistration(localClass).getSerializer();
        CachedProperty localCachedProperty2 = new CachedProperty();
        localCachedProperty2.name = str;
        localCachedProperty2.getMethod = localMethod1;
        localCachedProperty2.setMethod = localMethod2;
        localCachedProperty2.serializer = localSerializer;
        localCachedProperty2.setMethodType = localMethod2.getParameterTypes()[0];
        localArrayList.add(localCachedProperty2);
      }
    }
    this.properties = ((CachedProperty[])localArrayList.toArray(new CachedProperty[localArrayList.size()]));
    try
    {
      this.access = MethodAccess.get(paramClass);
      int m = this.properties.length;
      while (i < m)
      {
        CachedProperty localCachedProperty1 = this.properties[i];
        localCachedProperty1.getterAccessIndex = ((MethodAccess)this.access).getIndex(localCachedProperty1.getMethod.getName(), localCachedProperty1.getMethod.getParameterTypes());
        localCachedProperty1.setterAccessIndex = ((MethodAccess)this.access).getIndex(localCachedProperty1.setMethod.getName(), localCachedProperty1.setMethod.getParameterTypes());
        i++;
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public T copy(Kryo paramKryo, T paramT)
  {
    Object localObject = paramKryo.newInstance(paramT.getClass());
    int i = 0;
    int j = this.properties.length;
    while (i < j)
    {
      CachedProperty localCachedProperty = this.properties[i];
      try
      {
        localCachedProperty.set(localObject, localCachedProperty.get(paramT));
        i++;
      }
      catch (KryoException localKryoException2)
      {
        localKryoException2.addTrace(localCachedProperty + " (" + localObject.getClass().getName() + ")");
        throw localKryoException2;
      }
      catch (RuntimeException localRuntimeException)
      {
        KryoException localKryoException1 = new KryoException(localRuntimeException);
        localKryoException1.addTrace(localCachedProperty + " (" + localObject.getClass().getName() + ")");
        throw localKryoException1;
      }
      catch (Exception localException)
      {
        throw new KryoException("Error copying bean property: " + localCachedProperty + " (" + localObject.getClass().getName() + ")", localException);
      }
    }
    return localObject;
  }

  public T read(Kryo paramKryo, Input paramInput, Class<T> paramClass)
  {
    Object localObject1 = paramKryo.newInstance(paramClass);
    paramKryo.reference(localObject1);
    int i = this.properties.length;
    int j = 0;
    while (j < i)
    {
      CachedProperty localCachedProperty = this.properties[j];
      try
      {
        if (Log.TRACE)
          Log.trace("kryo", "Read property: " + localCachedProperty + " (" + localObject1.getClass() + ")");
        Serializer localSerializer = localCachedProperty.serializer;
        if (localSerializer != null);
        Object localObject3;
        for (Object localObject2 = paramKryo.readObjectOrNull(paramInput, localCachedProperty.setMethodType, localSerializer); ; localObject2 = localObject3)
        {
          localCachedProperty.set(localObject1, localObject2);
          j++;
          break;
          localObject3 = paramKryo.readClassAndObject(paramInput);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new KryoException("Error accessing setter method: " + localCachedProperty + " (" + localObject1.getClass().getName() + ")", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new KryoException("Error invoking setter method: " + localCachedProperty + " (" + localObject1.getClass().getName() + ")", localInvocationTargetException);
      }
      catch (KryoException localKryoException2)
      {
        localKryoException2.addTrace(localCachedProperty + " (" + localObject1.getClass().getName() + ")");
        throw localKryoException2;
      }
      catch (RuntimeException localRuntimeException)
      {
        KryoException localKryoException1 = new KryoException(localRuntimeException);
        localKryoException1.addTrace(localCachedProperty + " (" + localObject1.getClass().getName() + ")");
        throw localKryoException1;
      }
    }
    return localObject1;
  }

  public void write(Kryo paramKryo, Output paramOutput, T paramT)
  {
    Class localClass = paramT.getClass();
    int i = 0;
    int j = this.properties.length;
    while (true)
    {
      if (i < j)
      {
        CachedProperty localCachedProperty = this.properties[i];
        try
        {
          if (Log.TRACE)
            Log.trace("kryo", "Write property: " + localCachedProperty + " (" + localClass.getName() + ")");
          Object localObject = localCachedProperty.get(paramT);
          Serializer localSerializer = localCachedProperty.serializer;
          if (localSerializer != null)
            paramKryo.writeObjectOrNull(paramOutput, localObject, localSerializer);
          else
            paramKryo.writeClassAndObject(paramOutput, localObject);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new KryoException("Error accessing getter method: " + localCachedProperty + " (" + localClass.getName() + ")", localIllegalAccessException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new KryoException("Error invoking getter method: " + localCachedProperty + " (" + localClass.getName() + ")", localInvocationTargetException);
        }
        catch (KryoException localKryoException2)
        {
          localKryoException2.addTrace(localCachedProperty + " (" + localClass.getName() + ")");
          throw localKryoException2;
        }
        catch (RuntimeException localRuntimeException)
        {
          KryoException localKryoException1 = new KryoException(localRuntimeException);
          localKryoException1.addTrace(localCachedProperty + " (" + localClass.getName() + ")");
          throw localKryoException1;
        }
      }
      else
      {
        return;
      }
      i++;
    }
  }

  class CachedProperty<X>
  {
    Method getMethod;
    int getterAccessIndex;
    String name;
    Serializer serializer;
    Method setMethod;
    Class setMethodType;
    int setterAccessIndex;

    CachedProperty()
    {
    }

    Object get(Object paramObject)
      throws IllegalAccessException, InvocationTargetException
    {
      if (BeanSerializer.this.access != null)
        return ((MethodAccess)BeanSerializer.this.access).invoke(paramObject, this.getterAccessIndex, new Object[0]);
      return this.getMethod.invoke(paramObject, BeanSerializer.noArgs);
    }

    void set(Object paramObject1, Object paramObject2)
      throws IllegalAccessException, InvocationTargetException
    {
      if (BeanSerializer.this.access != null)
      {
        ((MethodAccess)BeanSerializer.this.access).invoke(paramObject1, this.setterAccessIndex, new Object[] { paramObject2 });
        return;
      }
      this.setMethod.invoke(paramObject1, new Object[] { paramObject2 });
    }

    public String toString()
    {
      return this.name;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.BeanSerializer
 * JD-Core Version:    0.6.2
 */