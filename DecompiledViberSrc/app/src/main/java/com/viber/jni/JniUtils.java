package com.viber.jni;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class JniUtils
{
  private static final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");
  private static final Logger L = ViberEnv.getLogger();

  public static String bundleToString(Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    String str1 = "";
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Object localObject = paramBundle.get(str2);
      StringBuilder localStringBuilder = new StringBuilder().append(str1);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str2;
      if (localObject != null);
      for (String str3 = localObject.toString(); ; str3 = "null")
      {
        arrayOfObject[1] = str3;
        str1 = String.format("key:%s  val:%s, ", arrayOfObject);
        break;
      }
    }
    return str1;
  }

  public static Object fromBundle(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("ClassName");
    String str2 = "com.viber.jni." + str1;
    L.b("fromBundle name:? ", new Object[] { str2 });
    while (true)
    {
      int j;
      try
      {
        Class localClass = Class.forName(str2);
        localObject = localClass.newInstance();
        Field[] arrayOfField = localClass.getDeclaredFields();
        int i = arrayOfField.length;
        j = 0;
        if (j < i)
        {
          localField = arrayOfField[j];
          str3 = localField.getName();
          str4 = localField.getType().toString();
          int k = localField.getModifiers();
          Logger localLogger1 = L;
          Object[] arrayOfObject1 = new Object[3];
          arrayOfObject1[0] = str3;
          arrayOfObject1[1] = str4;
          arrayOfObject1[2] = Integer.valueOf(k);
          localLogger1.b("fromBundle field:? type:? modif:?", arrayOfObject1);
          if ((Modifier.isFinal(k)) || (Modifier.isStatic(k)))
          {
            L.b("fromBundle field:? can't be modified", new Object[] { str2 });
          }
          else
          {
            localField.setAccessible(true);
            if (str4.contains("String"))
            {
              localField.set(localObject, paramBundle.getString(str3));
              L.b("fromBundle String:?", new Object[] { str3 });
              Logger localLogger2 = L;
              Object[] arrayOfObject2 = new Object[2];
              arrayOfObject2[0] = str3;
              arrayOfObject2[1] = localObject.toString();
              localLogger2.b("fromBundle fieldName: ? o:?", arrayOfObject2);
            }
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        L.e("class ? not found ?", new Object[] { str2, localClassNotFoundException });
        return null;
        if (str4.equals("int"))
        {
          localField.setInt(localObject, paramBundle.getInt(str3));
          L.b("fromBundle int: ?", new Object[] { str3 });
          continue;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        L.e("class ? InstantiationException ?", new Object[] { str2, localInstantiationException });
        continue;
        if (str4.contains("short"))
        {
          localField.setShort(localObject, paramBundle.getShort(str3));
          L.b("fromBundle short:?", new Object[] { str3 });
          continue;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Object localObject;
        Field localField;
        String str3;
        String str4;
        L.e("class ? IllegalAccessException ?", new Object[] { str2, localIllegalAccessException });
        continue;
        if (str4.contains("byte"))
        {
          localField.setByte(localObject, paramBundle.getByte(str3));
          L.b("fromBundle byte:?", new Object[] { str3 });
          continue;
        }
        if (str4.contains("long"))
        {
          localField.setLong(localObject, paramBundle.getLong(str3));
          L.b("fromBundle long:", new Object[0]);
          continue;
        }
        if (str4.contains("[B"))
        {
          localField.set(localObject, paramBundle.getByteArray(str3));
          L.b("fromBundle byte[]:?", new Object[] { str3 });
          continue;
        }
        if (str4.contains("PeerRatchetData"))
        {
          localField.set(localObject, fromBundle(paramBundle.getBundle(str3)));
          L.b("fromBundle PeerRatchetData:?", new Object[] { str3 });
          continue;
        }
        L.e("fromBundle Unknown field: ? t:?", new Object[] { str3, str4 });
        continue;
        Logger localLogger3 = L;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = localObject.toString();
        localLogger3.b("fromBundle ?", arrayOfObject3);
        return localObject;
      }
      j++;
    }
  }

  public static String[] getBundleKeys(Bundle paramBundle)
  {
    String[] arrayOfString = (String[])paramBundle.keySet().toArray(new String[1]);
    Logger localLogger = L;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Arrays.toString(arrayOfString);
    localLogger.b("getBundleKeys ?", arrayOfObject);
    return arrayOfString;
  }

  public static byte[] getUtf8Bytes(String paramString)
  {
    byte[] arrayOfByte = null;
    if (paramString != null)
    {
      int i = paramString.length();
      arrayOfByte = null;
      if (i > 0)
        arrayOfByte = paramString.getBytes(CHARSET_UTF_8);
    }
    return arrayOfByte;
  }

  public static void logBundle(Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      Object localObject = paramBundle.get(str1);
      Logger localLogger = L;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str1;
      if (localObject != null);
      for (String str2 = localObject.toString(); ; str2 = "null")
      {
        arrayOfObject[1] = str2;
        localLogger.b("logBundle key:?  val:?", arrayOfObject);
        break;
      }
    }
  }

  public static void logFields(Object paramObject)
  {
    L.b("logFields", new Object[0]);
    Logger localLogger1 = L;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = paramObject.getClass().getSimpleName();
    localLogger1.b("logFields class:? ", arrayOfObject1);
    Class localClass = paramObject.getClass();
    for (Field localField : localClass.getDeclaredFields())
    {
      Logger localLogger2 = L;
      Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = localClass.getSimpleName();
      arrayOfObject2[1] = localField.getName();
      arrayOfObject2[2] = localField.getType();
      arrayOfObject2[3] = Modifier.toString(localField.getModifiers());
      localLogger2.b("logFields cls:?  field:? t:? modif:?", arrayOfObject2);
    }
  }

  public static void runtimeLog(String paramString)
  {
    L.a(new RuntimeException(paramString), paramString);
  }

  public static Bundle toBundle(Object paramObject)
  {
    L.b("toBundle", new Object[0]);
    Logger localLogger1 = L;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = paramObject.getClass().getName();
    localLogger1.b("toBundle class:? ", arrayOfObject1);
    Class localClass = paramObject.getClass();
    Bundle localBundle = new Bundle();
    localBundle.putString("ClassName", paramObject.getClass().getName());
    Field[] arrayOfField = localClass.getDeclaredFields();
    int i = arrayOfField.length;
    int j = 0;
    if (j < i)
    {
      Field localField = arrayOfField[j];
      Logger localLogger2 = L;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = localField.getName();
      arrayOfObject2[1] = localField.getType();
      arrayOfObject2[2] = Modifier.toString(localField.getModifiers());
      localLogger2.b("toBundle field:? t:? modif:?", arrayOfObject2);
      String str1 = localField.getName();
      String str2 = localField.getType().toString();
      int k = localField.getModifiers();
      Logger localLogger3 = L;
      Object[] arrayOfObject3 = new Object[3];
      arrayOfObject3[0] = str1;
      arrayOfObject3[1] = str2;
      arrayOfObject3[2] = Integer.valueOf(k);
      localLogger3.b("toBundle field:? type:? modif:?", arrayOfObject3);
      if (Modifier.isStatic(k))
        L.b("toBundle field:? can't be modified", new Object[] { str1 });
      while (true)
      {
        j++;
        break;
        try
        {
          if (!str2.contains("String"))
            break label309;
          localBundle.putString(str1, (String)localField.get(paramObject));
          L.b("toBundle String:", new Object[0]);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
        continue;
        label309: if (str2.contains("int"))
        {
          localBundle.putInt(str1, localField.getInt(paramObject));
          L.b("toBundle int:", new Object[0]);
        }
        else if (str2.contains("short"))
        {
          localBundle.putShort(str1, localField.getShort(paramObject));
          L.b("toBundle short:", new Object[0]);
        }
        else if (str2.contains("long"))
        {
          localBundle.putLong(str1, localField.getLong(paramObject));
          L.b("toBundle long:", new Object[0]);
        }
        else if (str2.contains("boolean"))
        {
          localBundle.putBoolean(str1, localField.getBoolean(paramObject));
          L.b("toBundle boolean:", new Object[0]);
        }
        else
        {
          if (!str2.contains("[B"))
            break label521;
          localBundle.putByteArray(str1, (byte[])localField.get(paramObject));
          L.b("toBundle byte[]:", new Object[0]);
        }
      }
      label521: throw new RuntimeException("unknown field " + str1 + "  " + localField.getType());
    }
    return localBundle;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.JniUtils
 * JD-Core Version:    0.6.2
 */