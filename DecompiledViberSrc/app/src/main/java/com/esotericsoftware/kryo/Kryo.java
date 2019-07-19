package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.factories.PseudoSerializerFactory;
import com.esotericsoftware.kryo.factories.ReflectionSerializerFactory;
import com.esotericsoftware.kryo.factories.SerializerFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.BooleanArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.ByteArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.CharArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.DoubleArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.FloatArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.IntArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.LongArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.ObjectArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.ShortArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers.StringArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.BigDecimalSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.BigIntegerSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.BooleanSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.ByteSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CalendarSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CharSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.ClassSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CollectionsEmptyListSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CollectionsEmptyMapSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CollectionsEmptySetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CollectionsSingletonListSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CollectionsSingletonMapSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CollectionsSingletonSetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.CurrencySerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.DateSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.DoubleSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.EnumSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.EnumSetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.FloatSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.IntSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.KryoSerializableSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.LocaleSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.LongSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.ShortSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.StringBufferSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.StringBuilderSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.StringSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.TimeZoneSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.TreeMapSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.TreeSetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers.VoidSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import com.esotericsoftware.kryo.util.DefaultClassResolver;
import com.esotericsoftware.kryo.util.DefaultStreamFactory;
import com.esotericsoftware.kryo.util.IdentityMap;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.MapReferenceResolver;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.ConstructorAccess;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;

public class Kryo
{
  public static final byte NOT_NULL = 1;
  private static final int NO_REF = -2;
  public static final byte NULL = 0;
  private static final int REF = -1;
  private boolean asmEnabled = false;
  private boolean autoReset = true;
  private ClassLoader classLoader = getClass().getClassLoader();
  private final ClassResolver classResolver;
  private ObjectMap context;
  private int copyDepth;
  private boolean copyReferences = true;
  private boolean copyShallow;
  private SerializerFactory defaultSerializer = new ReflectionSerializerFactory(FieldSerializer.class);
  private final ArrayList<DefaultSerializerEntry> defaultSerializers = new ArrayList(32);
  private int depth;
  private Generics genericsScope;
  private ObjectMap graphContext;
  private final int lowPriorityDefaultSerializerCount;
  private int maxDepth = 2147483647;
  private Object needsCopyReference;
  private int nextRegisterID;
  private IdentityMap originalToCopy;
  private Object readObject;
  private final IntArray readReferenceIds = new IntArray(0);
  private ReferenceResolver referenceResolver;
  private boolean references;
  private boolean registrationRequired;
  private InstantiatorStrategy strategy = new DefaultInstantiatorStrategy();
  private StreamFactory streamFactory;
  private volatile Thread thread;

  public Kryo()
  {
    this(new DefaultClassResolver(), new MapReferenceResolver(), new DefaultStreamFactory());
  }

  public Kryo(ClassResolver paramClassResolver, ReferenceResolver paramReferenceResolver)
  {
    this(paramClassResolver, paramReferenceResolver, new DefaultStreamFactory());
  }

  public Kryo(ClassResolver paramClassResolver, ReferenceResolver paramReferenceResolver, StreamFactory paramStreamFactory)
  {
    if (paramClassResolver == null)
      throw new IllegalArgumentException("classResolver cannot be null.");
    this.classResolver = paramClassResolver;
    paramClassResolver.setKryo(this);
    this.streamFactory = paramStreamFactory;
    paramStreamFactory.setKryo(this);
    this.referenceResolver = paramReferenceResolver;
    if (paramReferenceResolver != null)
    {
      paramReferenceResolver.setKryo(this);
      this.references = true;
    }
    addDefaultSerializer([B.class, DefaultArraySerializers.ByteArraySerializer.class);
    addDefaultSerializer([C.class, DefaultArraySerializers.CharArraySerializer.class);
    addDefaultSerializer([S.class, DefaultArraySerializers.ShortArraySerializer.class);
    addDefaultSerializer([I.class, DefaultArraySerializers.IntArraySerializer.class);
    addDefaultSerializer([J.class, DefaultArraySerializers.LongArraySerializer.class);
    addDefaultSerializer([F.class, DefaultArraySerializers.FloatArraySerializer.class);
    addDefaultSerializer([D.class, DefaultArraySerializers.DoubleArraySerializer.class);
    addDefaultSerializer([Z.class, DefaultArraySerializers.BooleanArraySerializer.class);
    addDefaultSerializer([Ljava.lang.String.class, DefaultArraySerializers.StringArraySerializer.class);
    addDefaultSerializer([Ljava.lang.Object.class, DefaultArraySerializers.ObjectArraySerializer.class);
    addDefaultSerializer(KryoSerializable.class, DefaultSerializers.KryoSerializableSerializer.class);
    addDefaultSerializer(BigInteger.class, DefaultSerializers.BigIntegerSerializer.class);
    addDefaultSerializer(BigDecimal.class, DefaultSerializers.BigDecimalSerializer.class);
    addDefaultSerializer(Class.class, DefaultSerializers.ClassSerializer.class);
    addDefaultSerializer(Date.class, DefaultSerializers.DateSerializer.class);
    addDefaultSerializer(Enum.class, DefaultSerializers.EnumSerializer.class);
    addDefaultSerializer(EnumSet.class, DefaultSerializers.EnumSetSerializer.class);
    addDefaultSerializer(Currency.class, DefaultSerializers.CurrencySerializer.class);
    addDefaultSerializer(StringBuffer.class, DefaultSerializers.StringBufferSerializer.class);
    addDefaultSerializer(StringBuilder.class, DefaultSerializers.StringBuilderSerializer.class);
    addDefaultSerializer(Collections.EMPTY_LIST.getClass(), DefaultSerializers.CollectionsEmptyListSerializer.class);
    addDefaultSerializer(Collections.EMPTY_MAP.getClass(), DefaultSerializers.CollectionsEmptyMapSerializer.class);
    addDefaultSerializer(Collections.EMPTY_SET.getClass(), DefaultSerializers.CollectionsEmptySetSerializer.class);
    addDefaultSerializer(Collections.singletonList(null).getClass(), DefaultSerializers.CollectionsSingletonListSerializer.class);
    addDefaultSerializer(Collections.singletonMap(null, null).getClass(), DefaultSerializers.CollectionsSingletonMapSerializer.class);
    addDefaultSerializer(Collections.singleton(null).getClass(), DefaultSerializers.CollectionsSingletonSetSerializer.class);
    addDefaultSerializer(TreeSet.class, DefaultSerializers.TreeSetSerializer.class);
    addDefaultSerializer(Collection.class, CollectionSerializer.class);
    addDefaultSerializer(TreeMap.class, DefaultSerializers.TreeMapSerializer.class);
    addDefaultSerializer(Map.class, MapSerializer.class);
    addDefaultSerializer(TimeZone.class, DefaultSerializers.TimeZoneSerializer.class);
    addDefaultSerializer(Calendar.class, DefaultSerializers.CalendarSerializer.class);
    addDefaultSerializer(Locale.class, DefaultSerializers.LocaleSerializer.class);
    this.lowPriorityDefaultSerializerCount = this.defaultSerializers.size();
    register(Integer.TYPE, new DefaultSerializers.IntSerializer());
    register(String.class, new DefaultSerializers.StringSerializer());
    register(Float.TYPE, new DefaultSerializers.FloatSerializer());
    register(Boolean.TYPE, new DefaultSerializers.BooleanSerializer());
    register(Byte.TYPE, new DefaultSerializers.ByteSerializer());
    register(Character.TYPE, new DefaultSerializers.CharSerializer());
    register(Short.TYPE, new DefaultSerializers.ShortSerializer());
    register(Long.TYPE, new DefaultSerializers.LongSerializer());
    register(Double.TYPE, new DefaultSerializers.DoubleSerializer());
    register(Void.TYPE, new DefaultSerializers.VoidSerializer());
  }

  public Kryo(ReferenceResolver paramReferenceResolver)
  {
    this(new DefaultClassResolver(), paramReferenceResolver, new DefaultStreamFactory());
  }

  private void beginObject()
  {
    if (Log.DEBUG)
    {
      if (this.depth != 0)
        break label62;
      this.thread = Thread.currentThread();
    }
    while (this.depth == this.maxDepth)
    {
      throw new KryoException("Max depth exceeded: " + this.depth);
      label62: if (this.thread != Thread.currentThread())
        throw new ConcurrentModificationException("Kryo must not be accessed concurrently by multiple threads.");
    }
    this.depth = (1 + this.depth);
  }

  public void addDefaultSerializer(Class paramClass, Serializer paramSerializer)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    if (paramSerializer == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    DefaultSerializerEntry localDefaultSerializerEntry = new DefaultSerializerEntry(paramClass, new PseudoSerializerFactory(paramSerializer));
    this.defaultSerializers.add(this.defaultSerializers.size() - this.lowPriorityDefaultSerializerCount, localDefaultSerializerEntry);
  }

  public void addDefaultSerializer(Class paramClass, SerializerFactory paramSerializerFactory)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    if (paramSerializerFactory == null)
      throw new IllegalArgumentException("serializerFactory cannot be null.");
    DefaultSerializerEntry localDefaultSerializerEntry = new DefaultSerializerEntry(paramClass, paramSerializerFactory);
    this.defaultSerializers.add(this.defaultSerializers.size() - this.lowPriorityDefaultSerializerCount, localDefaultSerializerEntry);
  }

  public void addDefaultSerializer(Class paramClass, Class<? extends Serializer> paramClass1)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    if (paramClass1 == null)
      throw new IllegalArgumentException("serializerClass cannot be null.");
    DefaultSerializerEntry localDefaultSerializerEntry = new DefaultSerializerEntry(paramClass, new ReflectionSerializerFactory(paramClass1));
    this.defaultSerializers.add(this.defaultSerializers.size() - this.lowPriorityDefaultSerializerCount, localDefaultSerializerEntry);
  }

  public <T> T copy(T paramT)
  {
    if (paramT == null)
      paramT = null;
    while (true)
    {
      return paramT;
      if (this.copyShallow)
        continue;
      this.copyDepth = (1 + this.copyDepth);
      try
      {
        if (this.originalToCopy == null)
          this.originalToCopy = new IdentityMap();
        Object localObject2 = this.originalToCopy.get(paramT);
        if (localObject2 != null)
        {
          int k;
          return localObject2;
        }
        if (this.copyReferences)
          this.needsCopyReference = paramT;
        if ((paramT instanceof KryoCopyable));
        Object localObject3;
        for (paramT = ((KryoCopyable)paramT).copy(this); ; paramT = localObject3)
        {
          if (this.needsCopyReference != null)
            reference(paramT);
          if ((Log.TRACE) || ((Log.DEBUG) && (this.copyDepth == 1)))
            Util.log("Copy", paramT);
          int j;
          return paramT;
          localObject3 = getSerializer(paramT.getClass()).copy(this, paramT);
        }
      }
      finally
      {
        int i = -1 + this.copyDepth;
        this.copyDepth = i;
        if (i == 0)
          reset();
      }
    }
  }

  public <T> T copy(T paramT, Serializer paramSerializer)
  {
    if (paramT == null)
      paramT = null;
    while (true)
    {
      return paramT;
      if (this.copyShallow)
        continue;
      this.copyDepth = (1 + this.copyDepth);
      try
      {
        if (this.originalToCopy == null)
          this.originalToCopy = new IdentityMap();
        Object localObject2 = this.originalToCopy.get(paramT);
        if (localObject2 != null)
        {
          int k;
          return localObject2;
        }
        if (this.copyReferences)
          this.needsCopyReference = paramT;
        if ((paramT instanceof KryoCopyable));
        Object localObject3;
        for (paramT = ((KryoCopyable)paramT).copy(this); ; paramT = localObject3)
        {
          if (this.needsCopyReference != null)
            reference(paramT);
          if ((Log.TRACE) || ((Log.DEBUG) && (this.copyDepth == 1)))
            Util.log("Copy", paramT);
          int j;
          return paramT;
          localObject3 = paramSerializer.copy(this, paramT);
        }
      }
      finally
      {
        int i = -1 + this.copyDepth;
        this.copyDepth = i;
        if (i == 0)
          reset();
      }
    }
  }

  public <T> T copyShallow(T paramT)
  {
    Object localObject3;
    if (paramT == null)
      localObject3 = null;
    while (true)
    {
      return localObject3;
      this.copyDepth = (1 + this.copyDepth);
      this.copyShallow = true;
      try
      {
        if (this.originalToCopy == null)
          this.originalToCopy = new IdentityMap();
        Object localObject2 = this.originalToCopy.get(paramT);
        localObject3 = localObject2;
        if (localObject3 != null)
        {
          int k;
          return localObject3;
        }
        if (this.copyReferences)
          this.needsCopyReference = paramT;
        if ((paramT instanceof KryoCopyable));
        Object localObject4;
        for (localObject3 = ((KryoCopyable)paramT).copy(this); ; localObject3 = localObject4)
        {
          if (this.needsCopyReference != null)
            reference(localObject3);
          if ((Log.TRACE) || ((Log.DEBUG) && (this.copyDepth == 1)))
            Util.log("Shallow copy", localObject3);
          int j;
          return localObject3;
          localObject4 = getSerializer(paramT.getClass()).copy(this, paramT);
        }
      }
      finally
      {
        this.copyShallow = false;
        int i = -1 + this.copyDepth;
        this.copyDepth = i;
        if (i == 0)
          reset();
      }
    }
  }

  public <T> T copyShallow(T paramT, Serializer paramSerializer)
  {
    Object localObject3;
    if (paramT == null)
      localObject3 = null;
    while (true)
    {
      return localObject3;
      this.copyDepth = (1 + this.copyDepth);
      this.copyShallow = true;
      try
      {
        if (this.originalToCopy == null)
          this.originalToCopy = new IdentityMap();
        Object localObject2 = this.originalToCopy.get(paramT);
        localObject3 = localObject2;
        if (localObject3 != null)
        {
          int k;
          return localObject3;
        }
        if (this.copyReferences)
          this.needsCopyReference = paramT;
        if ((paramT instanceof KryoCopyable));
        Object localObject4;
        for (localObject3 = ((KryoCopyable)paramT).copy(this); ; localObject3 = localObject4)
        {
          if (this.needsCopyReference != null)
            reference(localObject3);
          if ((Log.TRACE) || ((Log.DEBUG) && (this.copyDepth == 1)))
            Util.log("Shallow copy", localObject3);
          int j;
          return localObject3;
          localObject4 = paramSerializer.copy(this, paramT);
        }
      }
      finally
      {
        this.copyShallow = false;
        int i = -1 + this.copyDepth;
        this.copyDepth = i;
        if (i == 0)
          reset();
      }
    }
  }

  public boolean getAsmEnabled()
  {
    return this.asmEnabled;
  }

  public ClassLoader getClassLoader()
  {
    return this.classLoader;
  }

  public ClassResolver getClassResolver()
  {
    return this.classResolver;
  }

  public ObjectMap getContext()
  {
    if (this.context == null)
      this.context = new ObjectMap();
    return this.context;
  }

  public Serializer getDefaultSerializer(Class paramClass)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    if (paramClass.isAnnotationPresent(DefaultSerializer.class))
      return ReflectionSerializerFactory.makeSerializer(this, ((DefaultSerializer)paramClass.getAnnotation(DefaultSerializer.class)).value(), paramClass);
    int i = this.defaultSerializers.size();
    for (int j = 0; j < i; j++)
    {
      DefaultSerializerEntry localDefaultSerializerEntry = (DefaultSerializerEntry)this.defaultSerializers.get(j);
      if (localDefaultSerializerEntry.type.isAssignableFrom(paramClass))
        return localDefaultSerializerEntry.serializerFactory.makeSerializer(this, paramClass);
    }
    return newDefaultSerializer(paramClass);
  }

  public int getDepth()
  {
    return this.depth;
  }

  public Generics getGenericsScope()
  {
    return this.genericsScope;
  }

  public ObjectMap getGraphContext()
  {
    if (this.graphContext == null)
      this.graphContext = new ObjectMap();
    return this.graphContext;
  }

  public InstantiatorStrategy getInstantiatorStrategy()
  {
    return this.strategy;
  }

  public int getNextRegistrationId()
  {
    while (this.nextRegisterID != -2)
    {
      if (this.classResolver.getRegistration(this.nextRegisterID) == null)
        return this.nextRegisterID;
      this.nextRegisterID = (1 + this.nextRegisterID);
    }
    throw new KryoException("No registration IDs are available.");
  }

  public IdentityMap getOriginalToCopyMap()
  {
    return this.originalToCopy;
  }

  public ReferenceResolver getReferenceResolver()
  {
    return this.referenceResolver;
  }

  public boolean getReferences()
  {
    return this.references;
  }

  public Registration getRegistration(int paramInt)
  {
    return this.classResolver.getRegistration(paramInt);
  }

  public Registration getRegistration(Class paramClass)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    Registration localRegistration = this.classResolver.getRegistration(paramClass);
    if (localRegistration == null)
    {
      if (Proxy.isProxyClass(paramClass))
        localRegistration = getRegistration(InvocationHandler.class);
      while (localRegistration == null)
        if (this.registrationRequired)
        {
          throw new IllegalArgumentException("Class is not registered: " + Util.className(paramClass) + "\nNote: To register this class use: kryo.register(" + Util.className(paramClass) + ".class);");
          if ((!paramClass.isEnum()) && (Enum.class.isAssignableFrom(paramClass)))
            localRegistration = getRegistration(paramClass.getEnclosingClass());
          else if (EnumSet.class.isAssignableFrom(paramClass))
            localRegistration = this.classResolver.getRegistration(EnumSet.class);
        }
        else
        {
          localRegistration = this.classResolver.registerImplicit(paramClass);
        }
    }
    return localRegistration;
  }

  public Serializer getSerializer(Class paramClass)
  {
    return getRegistration(paramClass).getSerializer();
  }

  public StreamFactory getStreamFactory()
  {
    return this.streamFactory;
  }

  public boolean isFinal(Class paramClass)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    if (paramClass.isArray())
      return Modifier.isFinal(Util.getElementClass(paramClass).getModifiers());
    return Modifier.isFinal(paramClass.getModifiers());
  }

  public boolean isRegistrationRequired()
  {
    return this.registrationRequired;
  }

  protected Serializer newDefaultSerializer(Class paramClass)
  {
    return this.defaultSerializer.makeSerializer(this, paramClass);
  }

  public <T> T newInstance(Class<T> paramClass)
  {
    Registration localRegistration = getRegistration(paramClass);
    ObjectInstantiator localObjectInstantiator = localRegistration.getInstantiator();
    if (localObjectInstantiator == null)
    {
      localObjectInstantiator = newInstantiator(paramClass);
      localRegistration.setInstantiator(localObjectInstantiator);
    }
    return localObjectInstantiator.newInstance();
  }

  protected ObjectInstantiator newInstantiator(Class paramClass)
  {
    return this.strategy.newInstantiatorOf(paramClass);
  }

  public void popGenericsScope()
  {
    Generics localGenerics = this.genericsScope;
    if (this.genericsScope != null)
      this.genericsScope = this.genericsScope.getParentScope();
    if (localGenerics != null)
      localGenerics.resetParentScope();
  }

  public void pushGenericsScope(Class paramClass, Generics paramGenerics)
  {
    if (Log.TRACE)
      Log.trace("kryo", "Settting a new generics scope for class " + paramClass.getName() + ": " + paramGenerics);
    Generics localGenerics = this.genericsScope;
    if (paramGenerics.getParentScope() != null)
      paramGenerics = new Generics(paramGenerics.getMappings());
    this.genericsScope = paramGenerics;
    this.genericsScope.setParentScope(localGenerics);
  }

  public Registration readClass(Input paramInput)
  {
    if (paramInput == null)
      throw new IllegalArgumentException("input cannot be null.");
    try
    {
      Registration localRegistration = this.classResolver.readClass(paramInput);
      return localRegistration;
    }
    finally
    {
      if ((this.depth == 0) && (this.autoReset))
        reset();
    }
  }

  public Object readClassAndObject(Input paramInput)
  {
    if (paramInput == null)
      throw new IllegalArgumentException("input cannot be null.");
    beginObject();
    try
    {
      Registration localRegistration = readClass(paramInput);
      Object localObject3;
      if (localRegistration == null)
      {
        int n = -1 + this.depth;
        this.depth = n;
        localObject3 = null;
        if (n == 0)
        {
          boolean bool = this.autoReset;
          localObject3 = null;
          if (bool)
            reset();
        }
        return localObject3;
      }
      Class localClass = localRegistration.getType();
      if (this.references)
      {
        localRegistration.getSerializer().setGenerics(this, null);
        int k = readReferenceOrNull(paramInput, localClass, false);
        if (k == -1)
        {
          localObject3 = this.readObject;
          int m;
          return localObject3;
        }
        localObject3 = localRegistration.getSerializer().read(this, paramInput, localClass);
        if (k == this.readReferenceIds.size)
          reference(localObject3);
      }
      while (true)
      {
        if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
          Util.log("Read", localObject3);
        int j;
        return localObject3;
        Object localObject2 = localRegistration.getSerializer().read(this, paramInput, localClass);
        localObject3 = localObject2;
      }
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  public <T> T readObject(Input paramInput, Class<T> paramClass)
  {
    if (paramInput == null)
      throw new IllegalArgumentException("input cannot be null.");
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    beginObject();
    try
    {
      Object localObject3;
      if (this.references)
      {
        int k = readReferenceOrNull(paramInput, paramClass, false);
        if (k == -1)
        {
          localObject3 = this.readObject;
          int m;
          return localObject3;
        }
        localObject3 = getRegistration(paramClass).getSerializer().read(this, paramInput, paramClass);
        if (k == this.readReferenceIds.size)
          reference(localObject3);
      }
      while (true)
      {
        if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
          Util.log("Read", localObject3);
        int j;
        return localObject3;
        Object localObject2 = getRegistration(paramClass).getSerializer().read(this, paramInput, paramClass);
        localObject3 = localObject2;
      }
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  public <T> T readObject(Input paramInput, Class<T> paramClass, Serializer paramSerializer)
  {
    if (paramInput == null)
      throw new IllegalArgumentException("input cannot be null.");
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    if (paramSerializer == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    beginObject();
    try
    {
      Object localObject3;
      if (this.references)
      {
        int k = readReferenceOrNull(paramInput, paramClass, false);
        if (k == -1)
        {
          localObject3 = this.readObject;
          int m;
          return localObject3;
        }
        localObject3 = paramSerializer.read(this, paramInput, paramClass);
        if (k == this.readReferenceIds.size)
          reference(localObject3);
      }
      while (true)
      {
        if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
          Util.log("Read", localObject3);
        int j;
        return localObject3;
        Object localObject2 = paramSerializer.read(this, paramInput, paramClass);
        localObject3 = localObject2;
      }
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  public <T> T readObjectOrNull(Input paramInput, Class<T> paramClass)
  {
    if (paramInput == null)
      throw new IllegalArgumentException("input cannot be null.");
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    beginObject();
    try
    {
      Object localObject3;
      if (this.references)
      {
        int m = readReferenceOrNull(paramInput, paramClass, true);
        if (m == -1)
        {
          localObject3 = this.readObject;
          int n;
          return localObject3;
        }
        localObject3 = getRegistration(paramClass).getSerializer().read(this, paramInput, paramClass);
        if (m == this.readReferenceIds.size)
          reference(localObject3);
      }
      while (true)
      {
        if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
          Util.log("Read", localObject3);
        int j;
        return localObject3;
        Serializer localSerializer = getRegistration(paramClass).getSerializer();
        if ((!localSerializer.getAcceptsNull()) && (paramInput.readByte() == 0))
        {
          if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
            Util.log("Read", null);
          int k = -1 + this.depth;
          this.depth = k;
          localObject3 = null;
          if (k != 0)
            break;
          boolean bool = this.autoReset;
          localObject3 = null;
          if (!bool)
            break;
          reset();
          return null;
        }
        Object localObject2 = localSerializer.read(this, paramInput, paramClass);
        localObject3 = localObject2;
      }
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  public <T> T readObjectOrNull(Input paramInput, Class<T> paramClass, Serializer paramSerializer)
  {
    if (paramInput == null)
      throw new IllegalArgumentException("input cannot be null.");
    if (paramClass == null)
      throw new IllegalArgumentException("type cannot be null.");
    if (paramSerializer == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    beginObject();
    try
    {
      Object localObject3;
      if (this.references)
      {
        int m = readReferenceOrNull(paramInput, paramClass, true);
        if (m == -1)
        {
          localObject3 = this.readObject;
          int n;
          return localObject3;
        }
        localObject3 = paramSerializer.read(this, paramInput, paramClass);
        if (m == this.readReferenceIds.size)
          reference(localObject3);
      }
      while (true)
      {
        if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
          Util.log("Read", localObject3);
        int j;
        return localObject3;
        if ((!paramSerializer.getAcceptsNull()) && (paramInput.readByte() == 0))
        {
          if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
            Util.log("Read", null);
          int k = -1 + this.depth;
          this.depth = k;
          localObject3 = null;
          if (k != 0)
            break;
          boolean bool = this.autoReset;
          localObject3 = null;
          if (!bool)
            break;
          reset();
          return null;
        }
        Object localObject2 = paramSerializer.read(this, paramInput, paramClass);
        localObject3 = localObject2;
      }
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  int readReferenceOrNull(Input paramInput, Class paramClass, boolean paramBoolean)
  {
    if (paramClass.isPrimitive())
      paramClass = Util.getWrapperClass(paramClass);
    boolean bool = this.referenceResolver.useReferences(paramClass);
    int i;
    if (paramBoolean)
    {
      i = paramInput.readVarInt(true);
      if (i == 0)
      {
        if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
          Util.log("Read", null);
        this.readObject = null;
      }
    }
    int j;
    do
    {
      return -1;
      if (!bool)
      {
        this.readReferenceIds.add(-2);
        return this.readReferenceIds.size;
        if (!bool)
        {
          this.readReferenceIds.add(-2);
          return this.readReferenceIds.size;
        }
        i = paramInput.readVarInt(true);
      }
      if (i == 1)
      {
        int k = this.referenceResolver.nextReadId(paramClass);
        if (Log.TRACE)
          Log.trace("kryo", "Read initial object reference " + k + ": " + Util.className(paramClass));
        this.readReferenceIds.add(k);
        return this.readReferenceIds.size;
      }
      j = i - 2;
      this.readObject = this.referenceResolver.getReadObject(paramClass, j);
    }
    while (!Log.DEBUG);
    Log.debug("kryo", "Read object reference " + j + ": " + Util.string(this.readObject));
    return -1;
  }

  public void reference(Object paramObject)
  {
    if (this.copyDepth > 0)
      if (this.needsCopyReference != null)
      {
        if (paramObject == null)
          throw new IllegalArgumentException("object cannot be null.");
        this.originalToCopy.put(this.needsCopyReference, paramObject);
        this.needsCopyReference = null;
      }
    int i;
    do
    {
      do
        return;
      while ((!this.references) || (paramObject == null));
      i = this.readReferenceIds.pop();
    }
    while (i == -2);
    this.referenceResolver.setReadObject(i, paramObject);
  }

  public Registration register(Registration paramRegistration)
  {
    int i = paramRegistration.getId();
    if (i < 0)
      throw new IllegalArgumentException("id must be > 0: " + i);
    Registration localRegistration = getRegistration(paramRegistration.getId());
    if ((Log.DEBUG) && (localRegistration != null) && (localRegistration.getType() != paramRegistration.getType()))
      Log.debug("An existing registration with a different type already uses ID: " + paramRegistration.getId() + "\nExisting registration: " + localRegistration + "\nUnable to set registration: " + paramRegistration);
    return this.classResolver.register(paramRegistration);
  }

  public Registration register(Class paramClass)
  {
    Registration localRegistration = this.classResolver.getRegistration(paramClass);
    if (localRegistration != null)
      return localRegistration;
    return register(paramClass, getDefaultSerializer(paramClass));
  }

  public Registration register(Class paramClass, int paramInt)
  {
    Registration localRegistration = this.classResolver.getRegistration(paramClass);
    if (localRegistration != null)
      return localRegistration;
    return register(paramClass, getDefaultSerializer(paramClass), paramInt);
  }

  public Registration register(Class paramClass, Serializer paramSerializer)
  {
    Registration localRegistration = this.classResolver.getRegistration(paramClass);
    if (localRegistration != null)
    {
      localRegistration.setSerializer(paramSerializer);
      return localRegistration;
    }
    return this.classResolver.register(new Registration(paramClass, paramSerializer, getNextRegistrationId()));
  }

  public Registration register(Class paramClass, Serializer paramSerializer, int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("id must be >= 0: " + paramInt);
    return register(new Registration(paramClass, paramSerializer, paramInt));
  }

  public void reset()
  {
    this.depth = 0;
    if (this.graphContext != null)
      this.graphContext.clear();
    this.classResolver.reset();
    if (this.references)
    {
      this.referenceResolver.reset();
      this.readObject = null;
    }
    this.copyDepth = 0;
    if (this.originalToCopy != null)
      this.originalToCopy.clear(2048);
    if (Log.TRACE)
      Log.trace("kryo", "Object graph complete.");
  }

  public void setAsmEnabled(boolean paramBoolean)
  {
    this.asmEnabled = paramBoolean;
  }

  public void setAutoReset(boolean paramBoolean)
  {
    this.autoReset = paramBoolean;
  }

  public void setClassLoader(ClassLoader paramClassLoader)
  {
    if (paramClassLoader == null)
      throw new IllegalArgumentException("classLoader cannot be null.");
    this.classLoader = paramClassLoader;
  }

  public void setCopyReferences(boolean paramBoolean)
  {
    this.copyReferences = paramBoolean;
  }

  public void setDefaultSerializer(SerializerFactory paramSerializerFactory)
  {
    if (paramSerializerFactory == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    this.defaultSerializer = paramSerializerFactory;
  }

  public void setDefaultSerializer(Class<? extends Serializer> paramClass)
  {
    if (paramClass == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    this.defaultSerializer = new ReflectionSerializerFactory(paramClass);
  }

  public void setInstantiatorStrategy(InstantiatorStrategy paramInstantiatorStrategy)
  {
    this.strategy = paramInstantiatorStrategy;
  }

  public void setMaxDepth(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("maxDepth must be > 0.");
    this.maxDepth = paramInt;
  }

  public void setReferenceResolver(ReferenceResolver paramReferenceResolver)
  {
    if (paramReferenceResolver == null)
      throw new IllegalArgumentException("referenceResolver cannot be null.");
    this.references = true;
    this.referenceResolver = paramReferenceResolver;
    if (Log.TRACE)
      Log.trace("kryo", "Reference resolver: " + paramReferenceResolver.getClass().getName());
  }

  public boolean setReferences(boolean paramBoolean)
  {
    if (paramBoolean == this.references)
      return paramBoolean;
    this.references = paramBoolean;
    if ((paramBoolean) && (this.referenceResolver == null))
      this.referenceResolver = new MapReferenceResolver();
    if (Log.TRACE)
      Log.trace("kryo", "References: " + paramBoolean);
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void setRegistrationRequired(boolean paramBoolean)
  {
    this.registrationRequired = paramBoolean;
    if (Log.TRACE)
      Log.trace("kryo", "Registration required: " + paramBoolean);
  }

  public void setStreamFactory(StreamFactory paramStreamFactory)
  {
    this.streamFactory = paramStreamFactory;
  }

  public Registration writeClass(Output paramOutput, Class paramClass)
  {
    if (paramOutput == null)
      throw new IllegalArgumentException("output cannot be null.");
    try
    {
      Registration localRegistration = this.classResolver.writeClass(paramOutput, paramClass);
      return localRegistration;
    }
    finally
    {
      if ((this.depth == 0) && (this.autoReset))
        reset();
    }
  }

  public void writeClassAndObject(Output paramOutput, Object paramObject)
  {
    if (paramOutput == null)
      throw new IllegalArgumentException("output cannot be null.");
    beginObject();
    if (paramObject == null);
    try
    {
      writeClass(paramOutput, null);
      int m;
      return;
      Registration localRegistration = writeClass(paramOutput, paramObject.getClass());
      if ((this.references) && (writeReferenceOrNull(paramOutput, paramObject, false)))
      {
        localRegistration.getSerializer().setGenerics(this, null);
        int k;
        return;
      }
      if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
        Util.log("Write", paramObject);
      localRegistration.getSerializer().write(this, paramOutput, paramObject);
      int j;
      return;
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  public void writeObject(Output paramOutput, Object paramObject)
  {
    if (paramOutput == null)
      throw new IllegalArgumentException("output cannot be null.");
    if (paramObject == null)
      throw new IllegalArgumentException("object cannot be null.");
    beginObject();
    try
    {
      if ((this.references) && (writeReferenceOrNull(paramOutput, paramObject, false)))
      {
        getRegistration(paramObject.getClass()).getSerializer().setGenerics(this, null);
        int k;
        return;
      }
      if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
        Util.log("Write", paramObject);
      getRegistration(paramObject.getClass()).getSerializer().write(this, paramOutput, paramObject);
      int j;
      return;
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  public void writeObject(Output paramOutput, Object paramObject, Serializer paramSerializer)
  {
    if (paramOutput == null)
      throw new IllegalArgumentException("output cannot be null.");
    if (paramObject == null)
      throw new IllegalArgumentException("object cannot be null.");
    if (paramSerializer == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    beginObject();
    try
    {
      if ((this.references) && (writeReferenceOrNull(paramOutput, paramObject, false)))
      {
        paramSerializer.setGenerics(this, null);
        int k;
        return;
      }
      if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
        Util.log("Write", paramObject);
      paramSerializer.write(this, paramOutput, paramObject);
      int j;
      return;
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  public void writeObjectOrNull(Output paramOutput, Object paramObject, Serializer paramSerializer)
  {
    if (paramOutput == null)
      throw new IllegalArgumentException("output cannot be null.");
    if (paramSerializer == null)
      throw new IllegalArgumentException("serializer cannot be null.");
    beginObject();
    try
    {
      int m;
      if (this.references)
      {
        if (writeReferenceOrNull(paramOutput, paramObject, true))
          paramSerializer.setGenerics(this, null);
      }
      else if (!paramSerializer.getAcceptsNull())
      {
        if (paramObject == null)
        {
          if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
            Util.log("Write", null);
          paramOutput.writeByte((byte)0);
          int j;
          return;
        }
        paramOutput.writeByte((byte)1);
      }
      if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
        Util.log("Write", paramObject);
      paramSerializer.write(this, paramOutput, paramObject);
      int k;
      return;
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  public void writeObjectOrNull(Output paramOutput, Object paramObject, Class paramClass)
  {
    if (paramOutput == null)
      throw new IllegalArgumentException("output cannot be null.");
    beginObject();
    try
    {
      Serializer localSerializer = getRegistration(paramClass).getSerializer();
      int m;
      if (this.references)
      {
        if (writeReferenceOrNull(paramOutput, paramObject, true))
          localSerializer.setGenerics(this, null);
      }
      else if (!localSerializer.getAcceptsNull())
      {
        if (paramObject == null)
        {
          if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
            Util.log("Write", paramObject);
          paramOutput.writeByte((byte)0);
          int j;
          return;
        }
        paramOutput.writeByte((byte)1);
      }
      if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
        Util.log("Write", paramObject);
      localSerializer.write(this, paramOutput, paramObject);
      int k;
      return;
    }
    finally
    {
      int i = -1 + this.depth;
      this.depth = i;
      if ((i == 0) && (this.autoReset))
        reset();
    }
  }

  boolean writeReferenceOrNull(Output paramOutput, Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null)
    {
      if ((Log.TRACE) || ((Log.DEBUG) && (this.depth == 1)))
        Util.log("Write", null);
      paramOutput.writeVarInt(0, true);
      return true;
    }
    if (!this.referenceResolver.useReferences(paramObject.getClass()))
    {
      if (paramBoolean)
        paramOutput.writeVarInt(1, true);
      return false;
    }
    int i = this.referenceResolver.getWrittenId(paramObject);
    if (i != -1)
    {
      if (Log.DEBUG)
        Log.debug("kryo", "Write object reference " + i + ": " + Util.string(paramObject));
      paramOutput.writeVarInt(i + 2, true);
      return true;
    }
    int j = this.referenceResolver.addWrittenObject(paramObject);
    paramOutput.writeVarInt(1, true);
    if (Log.TRACE)
      Log.trace("kryo", "Write initial object reference " + j + ": " + Util.string(paramObject));
    return false;
  }

  public static class DefaultInstantiatorStrategy
    implements InstantiatorStrategy
  {
    private InstantiatorStrategy fallbackStrategy;

    public InstantiatorStrategy getFallbackInstantiatorStrategy()
    {
      return this.fallbackStrategy;
    }

    public ObjectInstantiator newInstantiatorOf(final Class paramClass)
    {
      int i = 1;
      while (true)
        if ((!Util.isAndroid) && ((paramClass.getEnclosingClass() == null) || (!paramClass.isMemberClass()) || (Modifier.isStatic(paramClass.getModifiers())) || (i == 0)))
          try
          {
            ObjectInstantiator local1 = new ObjectInstantiator()
            {
              public Object newInstance()
              {
                try
                {
                  Object localObject = this.val$access.newInstance();
                  return localObject;
                }
                catch (Exception localException)
                {
                  throw new KryoException("Error constructing instance of class: " + Util.className(paramClass), localException);
                }
              }
            };
            return local1;
            i = 0;
          }
          catch (Exception localException3)
          {
          }
      try
      {
        Constructor localConstructor2 = paramClass.getConstructor((Class[])null);
        localObject = localConstructor2;
        try
        {
          ObjectInstantiator local2 = new ObjectInstantiator()
          {
            public Object newInstance()
            {
              try
              {
                Object localObject = this.val$constructor.newInstance(new Object[0]);
                return localObject;
              }
              catch (Exception localException)
              {
                throw new KryoException("Error constructing instance of class: " + Util.className(paramClass), localException);
              }
            }
          };
          return local2;
        }
        catch (Exception localException2)
        {
          if (this.fallbackStrategy != null)
            break label201;
        }
        if ((paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers())))
          throw new KryoException("Class cannot be created (non-static member class): " + Util.className(paramClass));
      }
      catch (Exception localException1)
      {
        while (true)
        {
          Constructor localConstructor1 = paramClass.getDeclaredConstructor((Class[])null);
          localConstructor1.setAccessible(true);
          Object localObject = localConstructor1;
        }
      }
      throw new KryoException("Class cannot be created (missing no-arg constructor): " + Util.className(paramClass));
      label201: return this.fallbackStrategy.newInstantiatorOf(paramClass);
    }

    public void setFallbackInstantiatorStrategy(InstantiatorStrategy paramInstantiatorStrategy)
    {
      this.fallbackStrategy = paramInstantiatorStrategy;
    }
  }

  static final class DefaultSerializerEntry
  {
    final SerializerFactory serializerFactory;
    final Class type;

    DefaultSerializerEntry(Class paramClass, SerializerFactory paramSerializerFactory)
    {
      this.type = paramClass;
      this.serializerFactory = paramSerializerFactory;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.Kryo
 * JD-Core Version:    0.6.2
 */