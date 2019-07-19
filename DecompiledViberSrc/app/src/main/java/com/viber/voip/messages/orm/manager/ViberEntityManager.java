package com.viber.voip.messages.orm.manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.annotation.ViberEntityField;
import com.viber.voip.model.entity.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViberEntityManager
{
  private static final Logger L = ViberEnv.getLogger();
  private static final Map<Class<?>, Object> defaultValues;
  private static final Map<Class<?>, EntityMapping> entitiesMapping = new HashMap();

  static
  {
    defaultValues = new HashMap(12, 1.0F);
    defaultValues.put(String.class, "");
    defaultValues.put(Integer.class, Integer.valueOf(0));
    defaultValues.put(Integer.TYPE, Integer.valueOf(0));
    defaultValues.put(Long.class, Long.valueOf(0L));
    defaultValues.put(Long.TYPE, Long.valueOf(0L));
    defaultValues.put(Boolean.class, Boolean.valueOf(false));
    defaultValues.put(Boolean.TYPE, Boolean.valueOf(false));
    defaultValues.put(Double.class, Double.valueOf(0.0D));
    defaultValues.put(Double.TYPE, Double.valueOf(0.0D));
    defaultValues.put(Float.class, Float.valueOf(0.0F));
    defaultValues.put(Float.TYPE, Float.valueOf(0.0F));
  }

  private static void findProjection(Class<?> paramClass, List<String> paramList, Set<String> paramSet)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int i = arrayOfField.length;
    for (int j = 0; j < i; j++)
    {
      ViberEntityField localViberEntityField = (ViberEntityField)arrayOfField[j].getAnnotation(ViberEntityField.class);
      if (localViberEntityField != null)
      {
        String str = localViberEntityField.projection();
        paramList.add(str);
        if (localViberEntityField.uiRelated())
          paramSet.add(str);
      }
    }
    if (paramClass == b.class);
    Class localClass;
    do
    {
      return;
      localClass = paramClass.getSuperclass();
    }
    while (localClass == null);
    findProjection(localClass, paramList, paramSet);
  }

  private static String getContentUri(String paramString1, String paramString2)
  {
    return "content://" + paramString1 + '/' + paramString2;
  }

  private static Object getDefaulfAgrument(Method paramMethod)
    throws InstantiationException, IllegalAccessException
  {
    Class localClass = paramMethod.getParameterTypes()[0];
    return defaultValues.get(localClass);
  }

  private static EntityMapping getFieldsData(Class<?> paramClass)
  {
    if (!entitiesMapping.containsKey(paramClass))
      initEntitityData(paramClass);
    if ((!entitiesMapping.containsKey(paramClass)) && (!Object.class.equals(paramClass.getSuperclass())));
    for (EntityMapping localEntityMapping = getFieldsData(paramClass.getSuperclass()); ; localEntityMapping = (EntityMapping)entitiesMapping.get(paramClass))
    {
      if (localEntityMapping == null)
        L.a(new RuntimeException("Can't create EntityMapping<" + paramClass + ">"), "");
      return localEntityMapping;
    }
  }

  private static void getFromCursor(Class<?> paramClass, ContentValues paramContentValues, Cursor paramCursor, String paramString, int paramInt)
    throws IllegalArgumentException, IllegalAccessException
  {
    int i = 1;
    if (paramClass.equals(String.class))
      paramContentValues.put(paramString, paramCursor.getString(paramInt));
    do
    {
      return;
      if ((paramClass.equals(Long.TYPE)) || (paramClass.equals(Long.class)))
      {
        paramContentValues.put(paramString, Long.valueOf(paramCursor.getLong(paramInt)));
        return;
      }
      if ((paramClass.equals(Integer.TYPE)) || (paramClass.equals(Integer.class)))
      {
        paramContentValues.put(paramString, Integer.valueOf(paramCursor.getInt(paramInt)));
        return;
      }
      if ((paramClass.equals(Boolean.TYPE)) || (paramClass.equals(Boolean.class)))
      {
        if (paramCursor.getInt(paramInt) == i);
        while (true)
        {
          paramContentValues.put(paramString, Boolean.valueOf(i));
          return;
          int j = 0;
        }
      }
      if ((paramClass.equals(Double.TYPE)) || (paramClass.equals(Double.class)))
      {
        paramContentValues.put(paramString, Double.valueOf(paramCursor.getDouble(paramInt)));
        return;
      }
      if ((paramClass.equals(Float.TYPE)) || (paramClass.equals(Float.class)))
      {
        paramContentValues.put(paramString, Float.valueOf(paramCursor.getFloat(paramInt)));
        return;
      }
    }
    while ((!paramClass.equals(Short.TYPE)) && (!paramClass.equals(Short.class)));
    paramContentValues.put(paramString, Short.valueOf(paramCursor.getShort(paramInt)));
  }

  public static int getProjectionColumn(Class<?> paramClass, String paramString)
  {
    EntityMapping localEntityMapping = getFieldsData(paramClass);
    if (localEntityMapping == null);
    for (Integer localInteger = null; ; localInteger = Integer.valueOf(localEntityMapping.getProjectionColumn(paramString)))
      return localInteger.intValue();
  }

  public static String[] getProjections(Class<?> paramClass)
  {
    EntityMapping localEntityMapping = getFieldsData(paramClass);
    if (localEntityMapping == null)
      return null;
    return localEntityMapping.projections;
  }

  public static String getTableName(Class<?> paramClass)
  {
    EntityMapping localEntityMapping = getFieldsData(paramClass);
    if (localEntityMapping == null)
      return null;
    return localEntityMapping.tableName;
  }

  // ERROR //
  public static void initEntitityData(Class<?> paramClass)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 28	com/viber/voip/messages/orm/manager/ViberEntityManager:entitiesMapping	Ljava/util/Map;
    //   8: aload_0
    //   9: invokeinterface 157 2 0
    //   14: ifeq +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: ldc_w 270
    //   28: invokevirtual 271	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   31: checkcast 270	com/viber/voip/messages/orm/annotation/ViberEntity
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +313 -> 349
    //   39: aload_3
    //   40: invokeinterface 275 1 0
    //   45: getstatic 281	com/viber/voip/messages/orm/annotation/ViberEntityType:ContentValues	Lcom/viber/voip/messages/orm/annotation/ViberEntityType;
    //   48: if_acmpne +301 -> 349
    //   51: aload_0
    //   52: invokevirtual 285	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   55: checkcast 287	com/viber/voip/model/d
    //   58: astore 11
    //   60: new 23	java/util/HashMap
    //   63: dup
    //   64: invokespecial 26	java/util/HashMap:<init>	()V
    //   67: astore 12
    //   69: aload_0
    //   70: invokevirtual 291	java/lang/Class:getDeclaredMethods	()[Ljava/lang/reflect/Method;
    //   73: astore 13
    //   75: aload 13
    //   77: arraylength
    //   78: istore 14
    //   80: iload_1
    //   81: iload 14
    //   83: if_icmpge +66 -> 149
    //   86: aload 13
    //   88: iload_1
    //   89: aaload
    //   90: astore 15
    //   92: aload 15
    //   94: invokevirtual 294	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   97: ldc_w 296
    //   100: invokevirtual 300	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   103: ifeq +34 -> 137
    //   106: aload 15
    //   108: iconst_1
    //   109: invokevirtual 304	java/lang/reflect/Method:setAccessible	(Z)V
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: astore 19
    //   118: aload 19
    //   120: iconst_0
    //   121: aload 15
    //   123: invokestatic 306	com/viber/voip/messages/orm/manager/ViberEntityManager:getDefaulfAgrument	(Ljava/lang/reflect/Method;)Ljava/lang/Object;
    //   126: aastore
    //   127: aload 15
    //   129: aload 11
    //   131: aload 19
    //   133: invokevirtual 310	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: iinc 1 1
    //   140: goto -60 -> 80
    //   143: astore_2
    //   144: ldc 2
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: aload 11
    //   151: invokeinterface 314 1 0
    //   156: invokevirtual 318	android/content/ContentValues:valueSet	()Ljava/util/Set;
    //   159: astore 21
    //   161: iconst_1
    //   162: aload 21
    //   164: invokeinterface 321 1 0
    //   169: iadd
    //   170: anewarray 35	java/lang/String
    //   173: astore 22
    //   175: aload 22
    //   177: iconst_0
    //   178: ldc_w 323
    //   181: aastore
    //   182: aload 12
    //   184: ldc_w 323
    //   187: ldc 55
    //   189: invokeinterface 43 3 0
    //   194: pop
    //   195: aload 21
    //   197: invokeinterface 327 1 0
    //   202: astore 24
    //   204: iconst_1
    //   205: istore 25
    //   207: aload 24
    //   209: invokeinterface 332 1 0
    //   214: ifeq +68 -> 282
    //   217: aload 24
    //   219: invokeinterface 335 1 0
    //   224: checkcast 337	java/util/Map$Entry
    //   227: astore 29
    //   229: iload 25
    //   231: iconst_1
    //   232: iadd
    //   233: istore 30
    //   235: aload 22
    //   237: iload 25
    //   239: aload 29
    //   241: invokeinterface 340 1 0
    //   246: checkcast 35	java/lang/String
    //   249: aastore
    //   250: aload 12
    //   252: aload 29
    //   254: invokeinterface 340 1 0
    //   259: aload 29
    //   261: invokeinterface 343 1 0
    //   266: invokevirtual 346	java/lang/Object:getClass	()Ljava/lang/Class;
    //   269: invokeinterface 43 3 0
    //   274: pop
    //   275: iload 30
    //   277: istore 25
    //   279: goto -72 -> 207
    //   282: aload_3
    //   283: invokeinterface 349 1 0
    //   288: aload_3
    //   289: invokeinterface 352 1 0
    //   294: invokestatic 354	com/viber/voip/messages/orm/manager/ViberEntityManager:getContentUri	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   297: invokestatic 360	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   300: astore 26
    //   302: ldc 2
    //   304: monitorenter
    //   305: getstatic 28	com/viber/voip/messages/orm/manager/ViberEntityManager:entitiesMapping	Ljava/util/Map;
    //   308: aload_0
    //   309: new 186	com/viber/voip/messages/orm/manager/ViberEntityManager$EntityMapping
    //   312: dup
    //   313: aload 22
    //   315: aload_3
    //   316: invokeinterface 352 1 0
    //   321: aload 26
    //   323: aload 12
    //   325: invokespecial 363	com/viber/voip/messages/orm/manager/ViberEntityManager$EntityMapping:<init>	([Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Map;)V
    //   328: invokeinterface 43 3 0
    //   333: pop
    //   334: ldc 2
    //   336: monitorexit
    //   337: return
    //   338: astore 27
    //   340: ldc 2
    //   342: monitorexit
    //   343: aload 27
    //   345: athrow
    //   346: astore 10
    //   348: return
    //   349: aload_3
    //   350: ifnull +123 -> 473
    //   353: aload_3
    //   354: invokeinterface 275 1 0
    //   359: getstatic 366	com/viber/voip/messages/orm/annotation/ViberEntityType:Standard	Lcom/viber/voip/messages/orm/annotation/ViberEntityType;
    //   362: if_acmpne +111 -> 473
    //   365: new 368	java/util/HashSet
    //   368: dup
    //   369: invokespecial 369	java/util/HashSet:<init>	()V
    //   372: astore 4
    //   374: new 371	java/util/ArrayList
    //   377: dup
    //   378: invokespecial 372	java/util/ArrayList:<init>	()V
    //   381: astore 5
    //   383: aload_0
    //   384: aload 5
    //   386: aload 4
    //   388: invokestatic 119	com/viber/voip/messages/orm/manager/ViberEntityManager:findProjection	(Ljava/lang/Class;Ljava/util/List;Ljava/util/Set;)V
    //   391: aload_3
    //   392: invokeinterface 349 1 0
    //   397: aload_3
    //   398: invokeinterface 352 1 0
    //   403: invokestatic 354	com/viber/voip/messages/orm/manager/ViberEntityManager:getContentUri	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   406: invokestatic 360	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   409: astore 6
    //   411: ldc 2
    //   413: monitorenter
    //   414: getstatic 28	com/viber/voip/messages/orm/manager/ViberEntityManager:entitiesMapping	Ljava/util/Map;
    //   417: aload_0
    //   418: new 186	com/viber/voip/messages/orm/manager/ViberEntityManager$EntityMapping
    //   421: dup
    //   422: aload 5
    //   424: aload 4
    //   426: aload_3
    //   427: invokeinterface 352 1 0
    //   432: aload 6
    //   434: invokespecial 375	com/viber/voip/messages/orm/manager/ViberEntityManager$EntityMapping:<init>	(Ljava/util/List;Ljava/util/Set;Ljava/lang/String;Landroid/net/Uri;)V
    //   437: invokeinterface 43 3 0
    //   442: pop
    //   443: ldc 2
    //   445: monitorexit
    //   446: return
    //   447: astore 7
    //   449: ldc 2
    //   451: monitorexit
    //   452: aload 7
    //   454: athrow
    //   455: astore 9
    //   457: return
    //   458: astore 18
    //   460: goto -323 -> 137
    //   463: astore 17
    //   465: goto -328 -> 137
    //   468: astore 16
    //   470: goto -333 -> 137
    //   473: return
    //
    // Exception table:
    //   from	to	target	type
    //   5	20	143	finally
    //   21	24	143	finally
    //   144	147	143	finally
    //   305	337	338	finally
    //   340	343	338	finally
    //   51	80	346	java/lang/InstantiationException
    //   86	112	346	java/lang/InstantiationException
    //   112	137	346	java/lang/InstantiationException
    //   149	204	346	java/lang/InstantiationException
    //   207	229	346	java/lang/InstantiationException
    //   235	275	346	java/lang/InstantiationException
    //   282	305	346	java/lang/InstantiationException
    //   343	346	346	java/lang/InstantiationException
    //   414	446	447	finally
    //   449	452	447	finally
    //   51	80	455	java/lang/IllegalAccessException
    //   86	112	455	java/lang/IllegalAccessException
    //   149	204	455	java/lang/IllegalAccessException
    //   207	229	455	java/lang/IllegalAccessException
    //   235	275	455	java/lang/IllegalAccessException
    //   282	305	455	java/lang/IllegalAccessException
    //   343	346	455	java/lang/IllegalAccessException
    //   112	137	458	java/lang/reflect/InvocationTargetException
    //   112	137	463	java/lang/IllegalAccessException
    //   112	137	468	java/lang/IllegalArgumentException
  }

  public static class EntityMapping
  {
    public final Uri contentUri;
    public final Map<String, Class<?>> projectionTypes;
    public final String[] projections;
    public final List<String> projectionsList;
    public final String tableName;
    public final Set<String> uiRelatedProjectionsList;

    EntityMapping(List<String> paramList, Set<String> paramSet, String paramString, Uri paramUri)
    {
      this.projections = ((String[])paramList.toArray(new String[0]));
      this.projectionTypes = null;
      this.projectionsList = paramList;
      this.uiRelatedProjectionsList = paramSet;
      this.tableName = paramString;
      this.contentUri = paramUri;
    }

    EntityMapping(String[] paramArrayOfString, String paramString, Uri paramUri, Map<String, Class<?>> paramMap)
    {
      this.projectionsList = null;
      this.uiRelatedProjectionsList = null;
      this.projections = paramArrayOfString;
      this.tableName = paramString;
      this.contentUri = paramUri;
      this.projectionTypes = paramMap;
    }

    int getProjectionColumn(String paramString)
    {
      for (int i = 0; i < this.projections.length; i++)
        if ((paramString != null) && (paramString.equals(this.projections[i])))
          return i;
      return -1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.manager.ViberEntityManager
 * JD-Core Version:    0.6.2
 */