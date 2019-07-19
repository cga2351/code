package com.yandex.metrica.impl.ob;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class f
{
  public static <T extends e> String a(T paramT)
  {
    if (paramT == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      a(null, paramT, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return "Error printing proto: " + localIllegalAccessException.getMessage();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      return "Error printing proto: " + localInvocationTargetException.getMessage();
    }
  }

  private static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0)
        localStringBuffer.append(Character.toLowerCase(c));
      while (true)
      {
        i++;
        break;
        if (Character.isUpperCase(c))
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        else
          localStringBuffer.append(c);
      }
    }
    return localStringBuffer.toString();
  }

  private static void a(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException, InvocationTargetException
  {
    int i;
    Class localClass1;
    label182: label230: Method[] arrayOfMethod;
    int m;
    int n;
    if (paramObject != null)
    {
      if (!(paramObject instanceof e))
        break label398;
      i = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(a(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      localClass1 = paramObject.getClass();
      Field[] arrayOfField = localClass1.getFields();
      int j = arrayOfField.length;
      int k = 0;
      if (k < j)
      {
        Field localField = arrayOfField[k];
        int i1 = localField.getModifiers();
        String str6 = localField.getName();
        Object localObject;
        if (((i1 & 0x1) == 1) && ((i1 & 0x8) != 8) && (!str6.startsWith("_")) && (!str6.endsWith("_")))
        {
          Class localClass2 = localField.getType();
          localObject = localField.get(paramObject);
          if (!localClass2.isArray())
            break label230;
          if (localClass2.getComponentType() != Byte.TYPE)
            break label182;
          a(str6, localObject, paramStringBuffer1, paramStringBuffer2);
        }
        while (true)
        {
          k++;
          break;
          if (localObject == null);
          for (int i2 = 0; ; i2 = Array.getLength(localObject))
          {
            for (int i3 = 0; i3 < i2; i3++)
              a(str6, Array.get(localObject, i3), paramStringBuffer1, paramStringBuffer2);
            break;
          }
          a(str6, localObject, paramStringBuffer1, paramStringBuffer2);
        }
      }
      arrayOfMethod = localClass1.getMethods();
      m = arrayOfMethod.length;
      n = 0;
    }
    while (true)
    {
      String str5;
      if (n < m)
      {
        String str4 = arrayOfMethod[n].getName();
        if (str4.startsWith("set"))
          str5 = str4.substring(3);
      }
      try
      {
        Method localMethod1 = localClass1.getMethod("has".concat(String.valueOf(str5)), new Class[0]);
        if (((Boolean)localMethod1.invoke(paramObject, new Object[0])).booleanValue());
        try
        {
          Method localMethod2 = localClass1.getMethod("get".concat(String.valueOf(str5)), new Class[0]);
          a(str5, localMethod2.invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
          label370: n++;
          continue;
          if (paramString != null)
          {
            paramStringBuffer1.setLength(i);
            paramStringBuffer2.append(paramStringBuffer1).append(">\n");
          }
          return;
          label398: String str1 = a(paramString);
          paramStringBuffer2.append(paramStringBuffer1).append(str1).append(": ");
          if ((paramObject instanceof String))
          {
            String str2 = (String)paramObject;
            if ((!str2.startsWith("http")) && (str2.length() > 200))
              str2 = str2.substring(0, 200) + "[...]";
            String str3 = b(str2);
            paramStringBuffer2.append("\"").append(str3).append("\"");
          }
          while (true)
          {
            paramStringBuffer2.append("\n");
            return;
            if ((paramObject instanceof byte[]))
              a((byte[])paramObject, paramStringBuffer2);
            else
              paramStringBuffer2.append(paramObject);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label370;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        break label370;
      }
    }
  }

  private static void a(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = 0xFF & paramArrayOfByte[i];
      if ((j == 92) || (j == 34))
        paramStringBuffer.append('\\').append((char)j);
      while (true)
      {
        i++;
        break;
        if ((j >= 32) && (j < 127))
        {
          paramStringBuffer.append((char)j);
        }
        else
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(j);
          paramStringBuffer.append(String.format("\\%03o", arrayOfObject));
        }
      }
    }
    paramStringBuffer.append('"');
  }

  private static String b(String paramString)
  {
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    int j = 0;
    if (j < i)
    {
      char c = paramString.charAt(j);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\''))
        localStringBuilder.append(c);
      while (true)
      {
        j++;
        break;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(c);
        localStringBuilder.append(String.format("\\u%04x", arrayOfObject));
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.f
 * JD-Core Version:    0.6.2
 */