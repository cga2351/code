package com.google.android.gms.internal.measurement;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzyj
{
  private static void zza(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException, InvocationTargetException
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof zzyi))
        break label466;
      int n = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(zzgg(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      Class localClass1 = paramObject.getClass();
      for (Field localField : localClass1.getFields())
      {
        int i5 = localField.getModifiers();
        String str10 = localField.getName();
        if ((!"cachedSize".equals(str10)) && ((i5 & 0x1) == 1) && ((i5 & 0x8) != 8) && (!str10.startsWith("_")) && (!str10.endsWith("_")))
        {
          Class localClass2 = localField.getType();
          Object localObject = localField.get(paramObject);
          if ((localClass2.isArray()) && (localClass2.getComponentType() != Byte.TYPE))
          {
            if (localObject == null);
            for (int i6 = 0; ; i6 = Array.getLength(localObject))
              for (int i7 = 0; i7 < i6; i7++)
                zza(str10, Array.get(localObject, i7), paramStringBuffer1, paramStringBuffer2);
          }
          zza(str10, localObject, paramStringBuffer1, paramStringBuffer2);
        }
      }
      Method[] arrayOfMethod = localClass1.getMethods();
      int i3 = arrayOfMethod.length;
      int i4 = 0;
      while (true)
        if (i4 < i3)
        {
          String str4 = arrayOfMethod[i4].getName();
          String str5;
          if (str4.startsWith("set"))
            str5 = str4.substring(3);
          try
          {
            String str6 = String.valueOf(str5);
            if (str6.length() != 0)
            {
              str7 = "has".concat(str6);
              label314: Method localMethod1 = localClass1.getMethod(str7, new Class[0]);
              if (!((Boolean)localMethod1.invoke(paramObject, new Object[0])).booleanValue());
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            try
            {
              String str7;
              String str8 = String.valueOf(str5);
              if (str8.length() != 0);
              for (String str9 = "get".concat(str8); ; str9 = new String("get"))
              {
                Method localMethod2 = localClass1.getMethod(str9, new Class[0]);
                zza(str5, localMethod2.invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
                while (true)
                {
                  label400: i4++;
                  break;
                  str7 = new String("has");
                  break label314;
                  localNoSuchMethodException1 = localNoSuchMethodException1;
                }
              }
            }
            catch (NoSuchMethodException localNoSuchMethodException2)
            {
              break label400;
            }
          }
        }
      if (paramString != null)
      {
        paramStringBuffer1.setLength(n);
        paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      }
    }
    return;
    label466: String str1 = zzgg(paramString);
    paramStringBuffer2.append(paramStringBuffer1).append(str1).append(": ");
    if ((paramObject instanceof String))
    {
      String str2 = (String)paramObject;
      if ((!str2.startsWith("http")) && (str2.length() > 200))
        str2 = String.valueOf(str2.substring(0, 200)).concat("[...]");
      int k = str2.length();
      StringBuilder localStringBuilder = new StringBuilder(k);
      int m = 0;
      if (m < k)
      {
        char c = str2.charAt(m);
        if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\''))
          localStringBuilder.append(c);
        while (true)
        {
          m++;
          break;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(c);
          localStringBuilder.append(String.format("\\u%04x", arrayOfObject2));
        }
      }
      String str3 = localStringBuilder.toString();
      paramStringBuffer2.append("\"").append(str3).append("\"");
    }
    while (true)
    {
      paramStringBuffer2.append("\n");
      return;
      if ((paramObject instanceof byte[]))
      {
        byte[] arrayOfByte = (byte[])paramObject;
        if (arrayOfByte == null)
        {
          paramStringBuffer2.append("\"\"");
        }
        else
        {
          paramStringBuffer2.append('"');
          int i = 0;
          if (i < arrayOfByte.length)
          {
            int j = 0xFF & arrayOfByte[i];
            if ((j == 92) || (j == 34))
              paramStringBuffer2.append('\\').append((char)j);
            while (true)
            {
              i++;
              break;
              if ((j >= 32) && (j < 127))
              {
                paramStringBuffer2.append((char)j);
              }
              else
              {
                Object[] arrayOfObject1 = new Object[1];
                arrayOfObject1[0] = Integer.valueOf(j);
                paramStringBuffer2.append(String.format("\\%03o", arrayOfObject1));
              }
            }
          }
          paramStringBuffer2.append('"');
        }
      }
      else
      {
        paramStringBuffer2.append(paramObject);
      }
    }
  }

  public static <T extends zzyi> String zzc(T paramT)
  {
    if (paramT == null)
      return "";
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      zza(null, paramT, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      String str2 = String.valueOf(localIllegalAccessException.getMessage());
      if (str2.length() != 0)
        return "Error printing proto: ".concat(str2);
      return new String("Error printing proto: ");
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      String str1 = String.valueOf(localInvocationTargetException.getMessage());
      if (str1.length() != 0)
        return "Error printing proto: ".concat(str1);
    }
    return new String("Error printing proto: ");
  }

  private static String zzgg(String paramString)
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyj
 * JD-Core Version:    0.6.2
 */