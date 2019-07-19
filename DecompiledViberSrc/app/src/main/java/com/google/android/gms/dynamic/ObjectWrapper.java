package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.reflect.Field;

@KeepForSdk
public final class ObjectWrapper<T> extends IObjectWrapper.Stub
{
  private final T zzhz;

  private ObjectWrapper(T paramT)
  {
    this.zzhz = paramT;
  }

  @KeepForSdk
  public static <T> T unwrap(IObjectWrapper paramIObjectWrapper)
  {
    int i = 0;
    if ((paramIObjectWrapper instanceof ObjectWrapper))
      return ((ObjectWrapper)paramIObjectWrapper).zzhz;
    IBinder localIBinder = paramIObjectWrapper.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    Object localObject1 = null;
    int j = arrayOfField.length;
    int k = 0;
    Object localObject3;
    if (k < j)
    {
      localObject3 = arrayOfField[k];
      if (((Field)localObject3).isSynthetic())
        break label178;
      i++;
    }
    while (true)
    {
      k++;
      localObject1 = localObject3;
      break;
      if (i == 1)
      {
        if (!localObject1.isAccessible())
        {
          localObject1.setAccessible(true);
          try
          {
            Object localObject2 = localObject1.get(localIBinder);
            return localObject2;
          }
          catch (NullPointerException localNullPointerException)
          {
            throw new IllegalArgumentException("Binder object is null.", localNullPointerException);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", localIllegalAccessException);
          }
        }
        throw new IllegalArgumentException("IObjectWrapper declared field not private!");
      }
      int m = arrayOfField.length;
      throw new IllegalArgumentException(64 + "Unexpected number of IObjectWrapper declared fields: " + m);
      label178: localObject3 = localObject1;
    }
  }

  @KeepForSdk
  public static <T> IObjectWrapper wrap(T paramT)
  {
    return new ObjectWrapper(paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.ObjectWrapper
 * JD-Core Version:    0.6.2
 */