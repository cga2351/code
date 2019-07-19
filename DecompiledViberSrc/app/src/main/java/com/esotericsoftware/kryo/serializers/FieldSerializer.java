package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Generics;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.NotNull;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.FieldAccess;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class FieldSerializer<T> extends Serializer<T>
  implements Comparator<CachedField>
{
  static CachedFieldFactory asmFieldFactory;
  static CachedFieldFactory objectFieldFactory;
  static Method sortFieldsByOffsetMethod;
  static boolean unsafeAvailable;
  static CachedFieldFactory unsafeFieldFactory;
  static Class<?> unsafeUtilClass;
  Object access;
  private FieldSerializerAnnotationsUtil annotationsUtil;
  private boolean copyTransient = true;
  private CachedField[] fields = new CachedField[0];
  private boolean fieldsCanBeNull = true;
  private boolean fixedFieldTypes;
  private Class[] generics;
  private Generics genericsScope;
  private FieldSerializerGenericsUtil genericsUtil;
  private boolean hasObjectFields = false;
  private boolean ignoreSyntheticFields = true;
  final Kryo kryo;
  protected HashSet<CachedField> removedFields = new HashSet();
  private final boolean serializeTransient = false;
  private boolean setFieldsAsAccessible = true;
  private CachedField[] transientFields = new CachedField[0];
  final Class type;
  private final TypeVariable[] typeParameters;
  private FieldSerializerUnsafeUtil unsafeUtil;
  private boolean useAsmEnabled;
  private boolean useMemRegions = false;
  private boolean varIntsEnabled;

  static
  {
    try
    {
      unsafeUtilClass = FieldSerializer.class.getClassLoader().loadClass("com.esotericsoftware.kryo.util.UnsafeUtil");
      Method localMethod = unsafeUtilClass.getMethod("unsafe", new Class[0]);
      sortFieldsByOffsetMethod = unsafeUtilClass.getMethod("sortFieldsByOffset", new Class[] { List.class });
      if (localMethod.invoke(null, new Object[0]) != null)
        unsafeAvailable = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!Log.TRACE);
      Log.trace("kryo", "sun.misc.Unsafe is unavailable.");
    }
  }

  public FieldSerializer(Kryo paramKryo, Class paramClass)
  {
    boolean bool1 = unsafeAvailable;
    boolean bool2 = false;
    if (!bool1)
      bool2 = true;
    this.useAsmEnabled = bool2;
    this.varIntsEnabled = true;
    if (Log.TRACE)
      Log.trace("kryo", "Optimize ints: " + this.varIntsEnabled);
    this.kryo = paramKryo;
    this.type = paramClass;
    this.typeParameters = paramClass.getTypeParameters();
    this.useAsmEnabled = paramKryo.getAsmEnabled();
    if ((!this.useAsmEnabled) && (!unsafeAvailable))
    {
      this.useAsmEnabled = true;
      if (Log.TRACE)
        Log.trace("kryo", "sun.misc.Unsafe is unavailable, using ASM.");
    }
    this.genericsUtil = new FieldSerializerGenericsUtil(this);
    this.unsafeUtil = FieldSerializerUnsafeUtil.Factory.getInstance(this);
    this.annotationsUtil = new FieldSerializerAnnotationsUtil(this);
    rebuildCachedFields();
  }

  public FieldSerializer(Kryo paramKryo, Class paramClass, Class[] paramArrayOfClass)
  {
    boolean bool1 = unsafeAvailable;
    boolean bool2 = false;
    if (!bool1)
      bool2 = true;
    this.useAsmEnabled = bool2;
    this.varIntsEnabled = true;
    if (Log.TRACE)
      Log.trace("kryo", "Optimize ints: " + this.varIntsEnabled);
    this.kryo = paramKryo;
    this.type = paramClass;
    this.generics = paramArrayOfClass;
    this.typeParameters = paramClass.getTypeParameters();
    this.useAsmEnabled = paramKryo.getAsmEnabled();
    if ((!this.useAsmEnabled) && (!unsafeAvailable))
    {
      this.useAsmEnabled = true;
      if (Log.TRACE)
        Log.trace("kryo", "sun.misc.Unsafe is unavailable, using ASM.");
    }
    this.genericsUtil = new FieldSerializerGenericsUtil(this);
    this.unsafeUtil = FieldSerializerUnsafeUtil.Factory.getInstance(this);
    this.annotationsUtil = new FieldSerializerAnnotationsUtil(this);
    rebuildCachedFields();
  }

  private List<Field> buildValidFields(boolean paramBoolean, List<Field> paramList, ObjectMap paramObjectMap, IntArray paramIntArray)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = paramList.size();
    int j = 0;
    if (j < i)
    {
      Field localField = (Field)paramList.get(j);
      int k = localField.getModifiers();
      if (Modifier.isTransient(k) != paramBoolean);
      while (true)
      {
        j++;
        break;
        if ((!Modifier.isStatic(k)) && ((!localField.isSynthetic()) || (!this.ignoreSyntheticFields)) && ((localField.isAccessible()) || (this.setFieldsAsAccessible)))
          try
          {
            localField.setAccessible(true);
            Optional localOptional = (Optional)localField.getAnnotation(Optional.class);
            if ((localOptional == null) || (paramObjectMap.containsKey(localOptional.value())))
            {
              localArrayList.add(localField);
              if ((!Modifier.isFinal(k)) && (Modifier.isPublic(k)) && (Modifier.isPublic(localField.getType().getModifiers())));
              for (int m = 1; ; m = 0)
              {
                paramIntArray.add(m);
                break;
              }
            }
          }
          catch (AccessControlException localAccessControlException)
          {
          }
      }
    }
    return localArrayList;
  }

  private List<Field> buildValidFieldsFromCachedFields(CachedField[] paramArrayOfCachedField, IntArray paramIntArray)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfCachedField.length);
    int i = paramArrayOfCachedField.length;
    int j = 0;
    if (j < i)
    {
      CachedField localCachedField = paramArrayOfCachedField[j];
      localArrayList.add(localCachedField.field);
      if (localCachedField.accessIndex > -1);
      for (int k = 1; ; k = 0)
      {
        paramIntArray.add(k);
        j++;
        break;
      }
    }
    return localArrayList;
  }

  private void createCachedFields(IntArray paramIntArray, List<Field> paramList, List<CachedField> paramList1, int paramInt)
  {
    int i;
    int j;
    if ((this.useAsmEnabled) || (!this.useMemRegions))
    {
      i = paramList.size();
      j = 0;
    }
    while (j < i)
    {
      Field localField = (Field)paramList.get(j);
      int k = -1;
      if ((this.access != null) && (paramIntArray.get(paramInt + j) == 1))
        k = ((FieldAccess)this.access).getIndex(localField.getName());
      paramList1.add(newCachedField(localField, paramList1.size(), k));
      j++;
      continue;
      this.unsafeUtil.createUnsafeCacheFieldsAndRegions(paramList, paramList1, paramInt, paramIntArray);
    }
  }

  private CachedFieldFactory getAsmFieldFactory()
  {
    if (asmFieldFactory == null)
      asmFieldFactory = new AsmCachedFieldFactory();
    return asmFieldFactory;
  }

  private CachedFieldFactory getObjectFieldFactory()
  {
    if (objectFieldFactory == null)
      objectFieldFactory = new ObjectCachedFieldFactory();
    return objectFieldFactory;
  }

  private CachedFieldFactory getUnsafeFieldFactory()
  {
    if (unsafeFieldFactory == null);
    try
    {
      unsafeFieldFactory = (CachedFieldFactory)getClass().getClassLoader().loadClass("com.esotericsoftware.kryo.serializers.UnsafeCachedFieldFactory").newInstance();
      return unsafeFieldFactory;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Cannot create UnsafeFieldFactory", localException);
    }
  }

  public int compare(CachedField paramCachedField1, CachedField paramCachedField2)
  {
    return paramCachedField1.field.getName().compareTo(paramCachedField2.field.getName());
  }

  public T copy(Kryo paramKryo, T paramT)
  {
    int i = 0;
    Object localObject = createCopy(paramKryo, paramT);
    paramKryo.reference(localObject);
    if (this.copyTransient)
    {
      int k = this.transientFields.length;
      for (int m = 0; m < k; m++)
        this.transientFields[m].copy(paramT, localObject);
    }
    int j = this.fields.length;
    while (i < j)
    {
      this.fields[i].copy(paramT, localObject);
      i++;
    }
    return localObject;
  }

  protected T create(Kryo paramKryo, Input paramInput, Class<T> paramClass)
  {
    return paramKryo.newInstance(paramClass);
  }

  protected T createCopy(Kryo paramKryo, T paramT)
  {
    return paramKryo.newInstance(paramT.getClass());
  }

  public boolean getCopyTransient()
  {
    return this.copyTransient;
  }

  public CachedField getField(String paramString)
  {
    for (CachedField localCachedField : this.fields)
      if (localCachedField.field.getName().equals(paramString))
        return localCachedField;
    throw new IllegalArgumentException("Field \"" + paramString + "\" not found on class: " + this.type.getName());
  }

  public CachedField[] getFields()
  {
    return this.fields;
  }

  public Class[] getGenerics()
  {
    return this.generics;
  }

  public final Generics getGenericsScope()
  {
    return this.genericsScope;
  }

  public Kryo getKryo()
  {
    return this.kryo;
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean getUseAsmEnabled()
  {
    return this.useAsmEnabled;
  }

  public boolean getUseMemRegions()
  {
    return this.useMemRegions;
  }

  protected void initializeCachedFields()
  {
  }

  CachedField newCachedField(Field paramField, int paramInt1, int paramInt2)
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = paramField.getType();
    Type localType = paramField.getGenericType();
    CachedField localCachedField;
    if (localType == arrayOfClass[0])
    {
      if (Log.TRACE)
        Log.trace("kryo", "Field " + paramField.getName() + ": " + arrayOfClass[0]);
      localCachedField = newMatchingCachedField(paramField, paramInt2, arrayOfClass[0], localType, null);
      if ((localCachedField instanceof ObjectField))
        this.hasObjectFields = true;
      localCachedField.field = paramField;
      localCachedField.varIntsEnabled = this.varIntsEnabled;
      if (!this.useAsmEnabled)
        localCachedField.offset = this.unsafeUtil.getObjectFieldOffset(paramField);
      localCachedField.access = ((FieldAccess)this.access);
      localCachedField.accessIndex = paramInt2;
      if ((!this.fieldsCanBeNull) || (arrayOfClass[0].isPrimitive()) || (paramField.isAnnotationPresent(NotNull.class)))
        break label247;
    }
    label247: for (boolean bool = true; ; bool = false)
    {
      localCachedField.canBeNull = bool;
      if ((this.kryo.isFinal(arrayOfClass[0])) || (this.fixedFieldTypes))
        localCachedField.valueClass = arrayOfClass[0];
      return localCachedField;
      localCachedField = this.genericsUtil.newCachedFieldOfGenericType(paramField, paramInt2, arrayOfClass, localType);
      break;
    }
  }

  CachedField newMatchingCachedField(Field paramField, int paramInt, Class paramClass, Type paramType, Class[] paramArrayOfClass)
  {
    CachedField localCachedField;
    if (paramInt != -1)
      localCachedField = getAsmFieldFactory().createCachedField(paramClass, paramField, this);
    Class[] arrayOfClass;
    do
    {
      return localCachedField;
      if (!this.useAsmEnabled)
        return getUnsafeFieldFactory().createCachedField(paramClass, paramField, this);
      localCachedField = getObjectFieldFactory().createCachedField(paramClass, paramField, this);
      if (paramArrayOfClass != null)
      {
        ((ObjectField)localCachedField).generics = paramArrayOfClass;
        return localCachedField;
      }
      arrayOfClass = FieldSerializerGenericsUtil.getGenerics(paramType, this.kryo);
      ((ObjectField)localCachedField).generics = arrayOfClass;
    }
    while (!Log.TRACE);
    Log.trace("kryo", "Field generics: " + Arrays.toString(arrayOfClass));
    return localCachedField;
  }

  public T read(Kryo paramKryo, Input paramInput, Class<T> paramClass)
  {
    try
    {
      if ((this.typeParameters != null) && (this.generics != null))
        rebuildCachedFields();
      if (this.genericsScope != null)
        paramKryo.pushGenericsScope(paramClass, this.genericsScope);
      Object localObject2 = create(paramKryo, paramInput, paramClass);
      paramKryo.reference(localObject2);
      CachedField[] arrayOfCachedField = this.fields;
      int i = 0;
      int j = arrayOfCachedField.length;
      while (i < j)
      {
        arrayOfCachedField[i].read(paramInput, localObject2);
        i++;
      }
      return localObject2;
    }
    finally
    {
      if ((this.genericsScope != null) && (paramKryo.getGenericsScope() != null))
        paramKryo.popGenericsScope();
    }
  }

  protected void rebuildCachedFields()
  {
    rebuildCachedFields(false);
  }

  // ERROR //
  protected void rebuildCachedFields(boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 98	com/esotericsoftware/minlog/Log:TRACE	Z
    //   3: ifeq +41 -> 44
    //   6: aload_0
    //   7: getfield 198	com/esotericsoftware/kryo/serializers/FieldSerializer:generics	[Ljava/lang/Class;
    //   10: ifnull +34 -> 44
    //   13: ldc 99
    //   15: new 140	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 493
    //   25: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 198	com/esotericsoftware/kryo/serializers/FieldSerializer:generics	[Ljava/lang/Class;
    //   32: invokestatic 474	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 105	com/esotericsoftware/minlog/Log:trace	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 158	com/esotericsoftware/kryo/serializers/FieldSerializer:type	Ljava/lang/Class;
    //   48: invokevirtual 496	java/lang/Class:isInterface	()Z
    //   51: ifeq +12 -> 63
    //   54: aload_0
    //   55: iconst_0
    //   56: anewarray 111	com/esotericsoftware/kryo/serializers/FieldSerializer$CachedField
    //   59: putfield 113	com/esotericsoftware/kryo/serializers/FieldSerializer:fields	[Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;
    //   62: return
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 134	com/esotericsoftware/kryo/serializers/FieldSerializer:hasObjectFields	Z
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 179	com/esotericsoftware/kryo/serializers/FieldSerializer:genericsUtil	Lcom/esotericsoftware/kryo/serializers/FieldSerializerGenericsUtil;
    //   73: aload_0
    //   74: getfield 158	com/esotericsoftware/kryo/serializers/FieldSerializer:type	Ljava/lang/Class;
    //   77: aload_0
    //   78: getfield 198	com/esotericsoftware/kryo/serializers/FieldSerializer:generics	[Ljava/lang/Class;
    //   81: invokevirtual 500	com/esotericsoftware/kryo/serializers/FieldSerializerGenericsUtil:buildGenericsScope	(Ljava/lang/Class;[Ljava/lang/Class;)Lcom/esotericsoftware/kryo/Generics;
    //   84: putfield 396	com/esotericsoftware/kryo/serializers/FieldSerializer:genericsScope	Lcom/esotericsoftware/kryo/Generics;
    //   87: aload_0
    //   88: getfield 396	com/esotericsoftware/kryo/serializers/FieldSerializer:genericsScope	Lcom/esotericsoftware/kryo/Generics;
    //   91: ifnull +18 -> 109
    //   94: aload_0
    //   95: getfield 156	com/esotericsoftware/kryo/serializers/FieldSerializer:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   98: aload_0
    //   99: getfield 158	com/esotericsoftware/kryo/serializers/FieldSerializer:type	Ljava/lang/Class;
    //   102: aload_0
    //   103: getfield 396	com/esotericsoftware/kryo/serializers/FieldSerializer:genericsScope	Lcom/esotericsoftware/kryo/Generics;
    //   106: invokevirtual 479	com/esotericsoftware/kryo/Kryo:pushGenericsScope	(Ljava/lang/Class;Lcom/esotericsoftware/kryo/Generics;)V
    //   109: new 270	com/esotericsoftware/kryo/util/IntArray
    //   112: dup
    //   113: invokespecial 501	com/esotericsoftware/kryo/util/IntArray:<init>	()V
    //   116: astore_2
    //   117: iload_1
    //   118: ifne +413 -> 531
    //   121: new 204	java/util/ArrayList
    //   124: dup
    //   125: invokespecial 502	java/util/ArrayList:<init>	()V
    //   128: astore_3
    //   129: aload_0
    //   130: getfield 158	com/esotericsoftware/kryo/serializers/FieldSerializer:type	Ljava/lang/Class;
    //   133: astore 4
    //   135: aload 4
    //   137: ldc 85
    //   139: if_acmpeq +76 -> 215
    //   142: aload 4
    //   144: invokevirtual 506	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   147: astore 15
    //   149: aload 15
    //   151: ifnull +54 -> 205
    //   154: aload 15
    //   156: arraylength
    //   157: istore 16
    //   159: iconst_0
    //   160: istore 17
    //   162: iload 17
    //   164: iload 16
    //   166: if_icmpge +39 -> 205
    //   169: aload 15
    //   171: iload 17
    //   173: aaload
    //   174: astore 18
    //   176: aload 18
    //   178: invokevirtual 220	java/lang/reflect/Field:getModifiers	()I
    //   181: invokestatic 229	java/lang/reflect/Modifier:isStatic	(I)Z
    //   184: ifeq +9 -> 193
    //   187: iinc 17 1
    //   190: goto -28 -> 162
    //   193: aload_3
    //   194: aload 18
    //   196: invokeinterface 257 2 0
    //   201: pop
    //   202: goto -15 -> 187
    //   205: aload 4
    //   207: invokevirtual 509	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   210: astore 4
    //   212: goto -77 -> 135
    //   215: aload_0
    //   216: getfield 156	com/esotericsoftware/kryo/serializers/FieldSerializer:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   219: invokevirtual 513	com/esotericsoftware/kryo/Kryo:getContext	()Lcom/esotericsoftware/kryo/util/ObjectMap;
    //   222: astore 5
    //   224: aload_0
    //   225: getfield 128	com/esotericsoftware/kryo/serializers/FieldSerializer:useMemRegions	Z
    //   228: ifeq +342 -> 570
    //   231: aload_0
    //   232: getfield 136	com/esotericsoftware/kryo/serializers/FieldSerializer:useAsmEnabled	Z
    //   235: ifne +335 -> 570
    //   238: getstatic 93	com/esotericsoftware/kryo/serializers/FieldSerializer:unsafeAvailable	Z
    //   241: ifeq +329 -> 570
    //   244: getstatic 83	com/esotericsoftware/kryo/serializers/FieldSerializer:sortFieldsByOffsetMethod	Ljava/lang/reflect/Method;
    //   247: aconst_null
    //   248: iconst_1
    //   249: anewarray 85	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_3
    //   255: aastore
    //   256: invokevirtual 91	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   259: checkcast 515	[Ljava/lang/reflect/Field;
    //   262: checkcast 515	[Ljava/lang/reflect/Field;
    //   265: invokestatic 519	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   268: astore 14
    //   270: aload 14
    //   272: astore 6
    //   274: aload_0
    //   275: iconst_0
    //   276: aload 6
    //   278: aload 5
    //   280: aload_2
    //   281: invokespecial 521	com/esotericsoftware/kryo/serializers/FieldSerializer:buildValidFields	(ZLjava/util/List;Lcom/esotericsoftware/kryo/util/ObjectMap;Lcom/esotericsoftware/kryo/util/IntArray;)Ljava/util/List;
    //   284: astore 7
    //   286: aload_0
    //   287: iconst_1
    //   288: aload 6
    //   290: aload 5
    //   292: aload_2
    //   293: invokespecial 521	com/esotericsoftware/kryo/serializers/FieldSerializer:buildValidFields	(ZLjava/util/List;Lcom/esotericsoftware/kryo/util/ObjectMap;Lcom/esotericsoftware/kryo/util/IntArray;)Ljava/util/List;
    //   296: astore 8
    //   298: aload_0
    //   299: getfield 136	com/esotericsoftware/kryo/serializers/FieldSerializer:useAsmEnabled	Z
    //   302: ifeq +42 -> 344
    //   305: getstatic 526	com/esotericsoftware/kryo/util/Util:isAndroid	Z
    //   308: ifne +36 -> 344
    //   311: aload_0
    //   312: getfield 158	com/esotericsoftware/kryo/serializers/FieldSerializer:type	Ljava/lang/Class;
    //   315: invokevirtual 268	java/lang/Class:getModifiers	()I
    //   318: invokestatic 263	java/lang/reflect/Modifier:isPublic	(I)Z
    //   321: ifeq +23 -> 344
    //   324: aload_2
    //   325: iconst_1
    //   326: invokevirtual 529	com/esotericsoftware/kryo/util/IntArray:indexOf	(I)I
    //   329: iconst_m1
    //   330: if_icmpeq +14 -> 344
    //   333: aload_0
    //   334: aload_0
    //   335: getfield 158	com/esotericsoftware/kryo/serializers/FieldSerializer:type	Ljava/lang/Class;
    //   338: invokestatic 532	com/esotericsoftware/reflectasm/FieldAccess:get	(Ljava/lang/Class;)Lcom/esotericsoftware/reflectasm/FieldAccess;
    //   341: putfield 287	com/esotericsoftware/kryo/serializers/FieldSerializer:access	Ljava/lang/Object;
    //   344: new 204	java/util/ArrayList
    //   347: dup
    //   348: aload 7
    //   350: invokeinterface 208 1 0
    //   355: invokespecial 211	java/util/ArrayList:<init>	(I)V
    //   358: astore 9
    //   360: new 204	java/util/ArrayList
    //   363: dup
    //   364: aload 8
    //   366: invokeinterface 208 1 0
    //   371: invokespecial 211	java/util/ArrayList:<init>	(I)V
    //   374: astore 10
    //   376: aload_0
    //   377: aload_2
    //   378: aload 7
    //   380: aload 9
    //   382: iconst_0
    //   383: invokespecial 534	com/esotericsoftware/kryo/serializers/FieldSerializer:createCachedFields	(Lcom/esotericsoftware/kryo/util/IntArray;Ljava/util/List;Ljava/util/List;I)V
    //   386: aload_0
    //   387: aload_2
    //   388: aload 8
    //   390: aload 10
    //   392: aload 7
    //   394: invokeinterface 208 1 0
    //   399: invokespecial 534	com/esotericsoftware/kryo/serializers/FieldSerializer:createCachedFields	(Lcom/esotericsoftware/kryo/util/IntArray;Ljava/util/List;Ljava/util/List;I)V
    //   402: aload 9
    //   404: aload_0
    //   405: invokestatic 540	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   408: aload_0
    //   409: aload 9
    //   411: aload 9
    //   413: invokeinterface 208 1 0
    //   418: anewarray 111	com/esotericsoftware/kryo/serializers/FieldSerializer$CachedField
    //   421: invokeinterface 544 2 0
    //   426: checkcast 545	[Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;
    //   429: putfield 113	com/esotericsoftware/kryo/serializers/FieldSerializer:fields	[Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;
    //   432: aload 10
    //   434: aload_0
    //   435: invokestatic 540	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   438: aload_0
    //   439: aload 10
    //   441: aload 10
    //   443: invokeinterface 208 1 0
    //   448: anewarray 111	com/esotericsoftware/kryo/serializers/FieldSerializer$CachedField
    //   451: invokeinterface 544 2 0
    //   456: checkcast 545	[Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;
    //   459: putfield 115	com/esotericsoftware/kryo/serializers/FieldSerializer:transientFields	[Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;
    //   462: aload_0
    //   463: invokevirtual 547	com/esotericsoftware/kryo/serializers/FieldSerializer:initializeCachedFields	()V
    //   466: aload_0
    //   467: getfield 396	com/esotericsoftware/kryo/serializers/FieldSerializer:genericsScope	Lcom/esotericsoftware/kryo/Generics;
    //   470: ifnull +10 -> 480
    //   473: aload_0
    //   474: getfield 156	com/esotericsoftware/kryo/serializers/FieldSerializer:kryo	Lcom/esotericsoftware/kryo/Kryo;
    //   477: invokevirtual 489	com/esotericsoftware/kryo/Kryo:popGenericsScope	()V
    //   480: aload_0
    //   481: getfield 120	com/esotericsoftware/kryo/serializers/FieldSerializer:removedFields	Ljava/util/HashSet;
    //   484: invokevirtual 551	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   487: astore 11
    //   489: aload 11
    //   491: invokeinterface 556 1 0
    //   496: ifeq +60 -> 556
    //   499: aload_0
    //   500: aload 11
    //   502: invokeinterface 559 1 0
    //   507: checkcast 111	com/esotericsoftware/kryo/serializers/FieldSerializer$CachedField
    //   510: invokevirtual 563	com/esotericsoftware/kryo/serializers/FieldSerializer:removeField	(Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;)V
    //   513: goto -24 -> 489
    //   516: astore 13
    //   518: new 340	java/lang/RuntimeException
    //   521: dup
    //   522: ldc_w 565
    //   525: aload 13
    //   527: invokespecial 345	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   530: athrow
    //   531: aload_0
    //   532: aload_0
    //   533: getfield 113	com/esotericsoftware/kryo/serializers/FieldSerializer:fields	[Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;
    //   536: aload_2
    //   537: invokespecial 567	com/esotericsoftware/kryo/serializers/FieldSerializer:buildValidFieldsFromCachedFields	([Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;Lcom/esotericsoftware/kryo/util/IntArray;)Ljava/util/List;
    //   540: astore 7
    //   542: aload_0
    //   543: aload_0
    //   544: getfield 115	com/esotericsoftware/kryo/serializers/FieldSerializer:transientFields	[Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;
    //   547: aload_2
    //   548: invokespecial 567	com/esotericsoftware/kryo/serializers/FieldSerializer:buildValidFieldsFromCachedFields	([Lcom/esotericsoftware/kryo/serializers/FieldSerializer$CachedField;Lcom/esotericsoftware/kryo/util/IntArray;)Ljava/util/List;
    //   551: astore 8
    //   553: goto -209 -> 344
    //   556: aload_0
    //   557: getfield 192	com/esotericsoftware/kryo/serializers/FieldSerializer:annotationsUtil	Lcom/esotericsoftware/kryo/serializers/FieldSerializerAnnotationsUtil;
    //   560: aload_0
    //   561: invokevirtual 570	com/esotericsoftware/kryo/serializers/FieldSerializerAnnotationsUtil:processAnnotatedFields	(Lcom/esotericsoftware/kryo/serializers/FieldSerializer;)V
    //   564: return
    //   565: astore 12
    //   567: goto -223 -> 344
    //   570: aload_3
    //   571: astore 6
    //   573: goto -299 -> 274
    //
    // Exception table:
    //   from	to	target	type
    //   244	270	516	java/lang/Exception
    //   333	344	565	java/lang/RuntimeException
  }

  public void removeField(CachedField paramCachedField)
  {
    for (int i = 0; i < this.fields.length; i++)
    {
      CachedField localCachedField = this.fields[i];
      if (localCachedField == paramCachedField)
      {
        CachedField[] arrayOfCachedField = new CachedField[-1 + this.fields.length];
        System.arraycopy(this.fields, 0, arrayOfCachedField, 0, i);
        System.arraycopy(this.fields, i + 1, arrayOfCachedField, i, arrayOfCachedField.length - i);
        this.fields = arrayOfCachedField;
        this.removedFields.add(localCachedField);
        return;
      }
    }
    throw new IllegalArgumentException("Field \"" + paramCachedField + "\" not found on class: " + this.type.getName());
  }

  public void removeField(String paramString)
  {
    for (int i = 0; i < this.fields.length; i++)
    {
      CachedField localCachedField = this.fields[i];
      if (localCachedField.field.getName().equals(paramString))
      {
        CachedField[] arrayOfCachedField = new CachedField[-1 + this.fields.length];
        System.arraycopy(this.fields, 0, arrayOfCachedField, 0, i);
        System.arraycopy(this.fields, i + 1, arrayOfCachedField, i, arrayOfCachedField.length - i);
        this.fields = arrayOfCachedField;
        this.removedFields.add(localCachedField);
        return;
      }
    }
    throw new IllegalArgumentException("Field \"" + paramString + "\" not found on class: " + this.type.getName());
  }

  public void setCopyTransient(boolean paramBoolean)
  {
    this.copyTransient = paramBoolean;
  }

  public void setFieldsAsAccessible(boolean paramBoolean)
  {
    this.setFieldsAsAccessible = paramBoolean;
    if (Log.TRACE)
      Log.trace("kryo", "setFieldsAsAccessible: " + paramBoolean);
    rebuildCachedFields();
  }

  public void setFieldsCanBeNull(boolean paramBoolean)
  {
    this.fieldsCanBeNull = paramBoolean;
    if (Log.TRACE)
      Log.trace("kryo", "setFieldsCanBeNull: " + paramBoolean);
    rebuildCachedFields();
  }

  public void setFixedFieldTypes(boolean paramBoolean)
  {
    this.fixedFieldTypes = paramBoolean;
    if (Log.TRACE)
      Log.trace("kryo", "setFixedFieldTypes: " + paramBoolean);
    rebuildCachedFields();
  }

  public void setGenerics(Kryo paramKryo, Class[] paramArrayOfClass)
  {
    this.generics = paramArrayOfClass;
    if ((this.typeParameters != null) && (this.typeParameters.length > 0))
      rebuildCachedFields(true);
  }

  public void setIgnoreSyntheticFields(boolean paramBoolean)
  {
    this.ignoreSyntheticFields = paramBoolean;
    if (Log.TRACE)
      Log.trace("kryo", "setIgnoreSyntheticFields: " + paramBoolean);
    rebuildCachedFields();
  }

  public void setUseAsm(boolean paramBoolean)
  {
    this.useAsmEnabled = paramBoolean;
    if ((!this.useAsmEnabled) && (!unsafeAvailable))
    {
      this.useAsmEnabled = true;
      if (Log.TRACE)
        Log.trace("kryo", "sun.misc.Unsafe is unavailable, using ASM.");
    }
    if (Log.TRACE)
      Log.trace("kryo", "setUseAsm: " + paramBoolean);
    rebuildCachedFields();
  }

  public void write(Kryo paramKryo, Output paramOutput, T paramT)
  {
    if (Log.TRACE)
      Log.trace("kryo", "FieldSerializer.write fields of class: " + paramT.getClass().getName());
    if ((this.typeParameters != null) && (this.generics != null))
      rebuildCachedFields();
    if (this.genericsScope != null)
      paramKryo.pushGenericsScope(this.type, this.genericsScope);
    CachedField[] arrayOfCachedField = this.fields;
    int i = 0;
    int j = arrayOfCachedField.length;
    while (i < j)
    {
      arrayOfCachedField[i].write(paramOutput, paramT);
      i++;
    }
    if (this.genericsScope != null)
      paramKryo.popGenericsScope();
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface Bind
  {
    public abstract Class<? extends Serializer> value();
  }

  public static abstract class CachedField<X>
  {
    FieldAccess access;
    int accessIndex = -1;
    boolean canBeNull;
    Field field;
    long offset = -1L;
    Serializer serializer;
    Class valueClass;
    boolean varIntsEnabled = true;

    public abstract void copy(Object paramObject1, Object paramObject2);

    public Field getField()
    {
      return this.field;
    }

    public Serializer getSerializer()
    {
      return this.serializer;
    }

    public abstract void read(Input paramInput, Object paramObject);

    public void setCanBeNull(boolean paramBoolean)
    {
      this.canBeNull = paramBoolean;
    }

    public void setClass(Class paramClass)
    {
      this.valueClass = paramClass;
      this.serializer = null;
    }

    public void setClass(Class paramClass, Serializer paramSerializer)
    {
      this.valueClass = paramClass;
      this.serializer = paramSerializer;
    }

    public void setSerializer(Serializer paramSerializer)
    {
      this.serializer = paramSerializer;
    }

    public String toString()
    {
      return this.field.getName();
    }

    public abstract void write(Output paramOutput, Object paramObject);
  }

  public static abstract interface CachedFieldFactory
  {
    public abstract FieldSerializer.CachedField createCachedField(Class paramClass, Field paramField, FieldSerializer paramFieldSerializer);
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface Optional
  {
    public abstract String value();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.serializers.FieldSerializer
 * JD-Core Version:    0.6.2
 */