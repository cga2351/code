package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzdpm
{
  static String zza(zzdpj paramzzdpj, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ").append(paramString);
    zza(paramzzdpj, localStringBuilder, 0);
    return localStringBuilder.toString();
  }

  private static void zza(zzdpj paramzzdpj, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    TreeSet localTreeSet = new TreeSet();
    for (Method localMethod5 : paramzzdpj.getClass().getDeclaredMethods())
    {
      localHashMap2.put(localMethod5.getName(), localMethod5);
      if (localMethod5.getParameterTypes().length == 0)
      {
        localHashMap1.put(localMethod5.getName(), localMethod5);
        if (localMethod5.getName().startsWith("get"))
          localTreeSet.add(localMethod5.getName());
      }
    }
    Iterator localIterator1 = localTreeSet.iterator();
    label641: label678: label1074: 
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      String str2 = str1.replaceFirst("get", "");
      if ((str2.endsWith("List")) && (!str2.endsWith("OrBuilderList")) && (!str2.equals("List")))
      {
        String str17 = String.valueOf(str2.substring(0, 1).toLowerCase());
        String str18 = String.valueOf(str2.substring(1, -4 + str2.length()));
        if (str18.length() != 0);
        for (String str19 = str17.concat(str18); ; str19 = new String(str17))
        {
          Method localMethod4 = (Method)localHashMap1.get(str1);
          if ((localMethod4 == null) || (!localMethod4.getReturnType().equals(List.class)))
            break label318;
          zza(paramStringBuilder, paramInt, zzha(str19), zzdoa.zza(localMethod4, paramzzdpj, new Object[0]));
          break;
        }
      }
      label318: if ((str2.endsWith("Map")) && (!str2.equals("Map")))
      {
        String str14 = String.valueOf(str2.substring(0, 1).toLowerCase());
        String str15 = String.valueOf(str2.substring(1, -3 + str2.length()));
        if (str15.length() != 0);
        for (String str16 = str14.concat(str15); ; str16 = new String(str14))
        {
          Method localMethod3 = (Method)localHashMap1.get(str1);
          if ((localMethod3 == null) || (!localMethod3.getReturnType().equals(Map.class)) || (localMethod3.isAnnotationPresent(Deprecated.class)) || (!Modifier.isPublic(localMethod3.getModifiers())))
            break label478;
          zza(paramStringBuilder, paramInt, zzha(str16), zzdoa.zza(localMethod3, paramzzdpj, new Object[0]));
          break;
        }
      }
      label478: String str3 = String.valueOf(str2);
      String str4;
      label502: String str13;
      label563: String str5;
      String str7;
      label617: String str9;
      String str11;
      Method localMethod2;
      Object localObject;
      boolean bool2;
      label735: boolean bool1;
      if (str3.length() != 0)
      {
        str4 = "set".concat(str3);
        if ((Method)localHashMap2.get(str4) != null)
        {
          if (str2.endsWith("Bytes"))
          {
            String str12 = String.valueOf(str2.substring(0, -5 + str2.length()));
            if (str12.length() == 0)
              break label777;
            str13 = "get".concat(str12);
            if (localHashMap1.containsKey(str13))
              break label789;
          }
          str5 = String.valueOf(str2.substring(0, 1).toLowerCase());
          String str6 = String.valueOf(str2.substring(1));
          if (str6.length() == 0)
            break label791;
          str7 = str5.concat(str6);
          String str8 = String.valueOf(str2);
          if (str8.length() == 0)
            break label805;
          str9 = "get".concat(str8);
          Method localMethod1 = (Method)localHashMap1.get(str9);
          String str10 = String.valueOf(str2);
          if (str10.length() == 0)
            break label819;
          str11 = "has".concat(str10);
          localMethod2 = (Method)localHashMap1.get(str11);
          if (localMethod1 == null)
            continue;
          localObject = zzdoa.zza(localMethod1, paramzzdpj, new Object[0]);
          if (localMethod2 != null)
            break label1055;
          if (!(localObject instanceof Boolean))
            break label839;
          if (((Boolean)localObject).booleanValue())
            break label833;
          bool2 = true;
          if (bool2)
            break label1049;
          bool1 = true;
        }
      }
      else
      {
        while (true)
        {
          if (!bool1)
            break label1074;
          zza(paramStringBuilder, paramInt, zzha(str7), localObject);
          break;
          str4 = new String("set");
          break label502;
          break;
          str13 = new String("get");
          break label563;
          break;
          str7 = new String(str5);
          break label617;
          str9 = new String("get");
          break label641;
          label819: str11 = new String("has");
          break label678;
          label833: bool2 = false;
          break label735;
          label839: if ((localObject instanceof Integer))
          {
            if (((Integer)localObject).intValue() == 0)
            {
              bool2 = true;
              break label735;
            }
            bool2 = false;
            break label735;
          }
          if ((localObject instanceof Float))
          {
            if (((Float)localObject).floatValue() == 0.0F)
            {
              bool2 = true;
              break label735;
            }
            bool2 = false;
            break label735;
          }
          if ((localObject instanceof Double))
          {
            if (((Double)localObject).doubleValue() == 0.0D)
            {
              bool2 = true;
              break label735;
            }
            bool2 = false;
            break label735;
          }
          if ((localObject instanceof String))
          {
            bool2 = localObject.equals("");
            break label735;
          }
          if ((localObject instanceof zzdmq))
          {
            bool2 = localObject.equals(zzdmq.zzhcr);
            break label735;
          }
          if ((localObject instanceof zzdpj))
          {
            if (localObject == ((zzdpj)localObject).zzaxv())
            {
              bool2 = true;
              break label735;
            }
            bool2 = false;
            break label735;
          }
          if ((localObject instanceof Enum))
          {
            if (((Enum)localObject).ordinal() == 0)
            {
              bool2 = true;
              break label735;
            }
            bool2 = false;
            break label735;
          }
          bool2 = false;
          break label735;
          bool1 = false;
          continue;
          bool1 = ((Boolean)zzdoa.zza(localMethod2, paramzzdpj, new Object[0])).booleanValue();
        }
      }
    }
    label777: label789: label791: label805: if ((paramzzdpj instanceof zzdoa.zzc))
    {
      Iterator localIterator2 = ((zzdoa.zzc)paramzzdpj).zzhhj.iterator();
      if (localIterator2.hasNext())
      {
        ((Map.Entry)localIterator2.next()).getKey();
        throw new NoSuchMethodError();
      }
    }
    label1049: label1055: if (((zzdoa)paramzzdpj).zzhhd != null)
      ((zzdoa)paramzzdpj).zzhhd.zza(paramStringBuilder, paramInt);
  }

  static final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    int i = 0;
    if ((paramObject instanceof List))
    {
      Iterator localIterator2 = ((List)paramObject).iterator();
      while (localIterator2.hasNext())
        zza(paramStringBuilder, paramInt, paramString, localIterator2.next());
    }
    if ((paramObject instanceof Map))
    {
      Iterator localIterator1 = ((Map)paramObject).entrySet().iterator();
      while (localIterator1.hasNext())
        zza(paramStringBuilder, paramInt, paramString, (Map.Entry)localIterator1.next());
    }
    paramStringBuilder.append('\n');
    for (int j = 0; j < paramInt; j++)
      paramStringBuilder.append(' ');
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"").append(zzdqo.zzdc(zzdmq.zzgv((String)paramObject))).append('"');
      return;
    }
    if ((paramObject instanceof zzdmq))
    {
      paramStringBuilder.append(": \"").append(zzdqo.zzdc((zzdmq)paramObject)).append('"');
      return;
    }
    if ((paramObject instanceof zzdoa))
    {
      paramStringBuilder.append(" {");
      zza((zzdoa)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i++;
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramStringBuilder.append(" {");
      Map.Entry localEntry = (Map.Entry)paramObject;
      zza(paramStringBuilder, paramInt + 2, "key", localEntry.getKey());
      zza(paramStringBuilder, paramInt + 2, "value", localEntry.getValue());
      paramStringBuilder.append("\n");
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i++;
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ").append(paramObject.toString());
  }

  private static final String zzha(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString.length(); i++)
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c))
        localStringBuilder.append("_");
      localStringBuilder.append(Character.toLowerCase(c));
    }
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpm
 * JD-Core Version:    0.6.2
 */