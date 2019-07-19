package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.ClassResolver;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;

public class DefaultClassResolver
  implements ClassResolver
{
  public static final byte NAME = -1;
  protected IdentityObjectIntMap<Class> classToNameId;
  protected final ObjectMap<Class, Registration> classToRegistration = new ObjectMap();
  protected final IntMap<Registration> idToRegistration = new IntMap();
  protected Kryo kryo;
  private Class memoizedClass;
  private int memoizedClassId = -1;
  private Registration memoizedClassIdValue;
  private Registration memoizedClassValue;
  protected IntMap<Class> nameIdToClass;
  protected ObjectMap<String, Class> nameToClass;
  protected int nextNameId;

  public Registration getRegistration(int paramInt)
  {
    return (Registration)this.idToRegistration.get(paramInt);
  }

  public Registration getRegistration(Class paramClass)
  {
    Registration localRegistration;
    if (paramClass == this.memoizedClass)
      localRegistration = this.memoizedClassValue;
    do
    {
      return localRegistration;
      localRegistration = (Registration)this.classToRegistration.get(paramClass);
    }
    while (localRegistration == null);
    this.memoizedClass = paramClass;
    this.memoizedClassValue = localRegistration;
    return localRegistration;
  }

  protected Class<?> getTypeByName(String paramString)
  {
    if (this.nameToClass != null)
      return (Class)this.nameToClass.get(paramString);
    return null;
  }

  public Registration readClass(Input paramInput)
  {
    int i = paramInput.readVarInt(true);
    Registration localRegistration1;
    switch (i)
    {
    default:
      if (i == this.memoizedClassId)
        localRegistration1 = this.memoizedClassIdValue;
      break;
    case 0:
      int j;
      do
      {
        boolean bool;
        do
        {
          return localRegistration1;
          if (Log.TRACE)
            break;
          bool = Log.DEBUG;
          localRegistration1 = null;
        }
        while (!bool);
        j = this.kryo.getDepth();
        localRegistration1 = null;
      }
      while (j != 1);
      Util.log("Read", null);
      return null;
    case 1:
      return readName(paramInput);
    }
    Registration localRegistration2 = (Registration)this.idToRegistration.get(i - 2);
    if (localRegistration2 == null)
      throw new KryoException("Encountered unregistered class ID: " + (i - 2));
    if (Log.TRACE)
      Log.trace("kryo", "Read class " + (i - 2) + ": " + Util.className(localRegistration2.getType()));
    this.memoizedClassId = i;
    this.memoizedClassIdValue = localRegistration2;
    return localRegistration2;
  }

  protected Registration readName(Input paramInput)
  {
    int i = paramInput.readVarInt(true);
    if (this.nameIdToClass == null)
      this.nameIdToClass = new IntMap();
    Object localObject = (Class)this.nameIdToClass.get(i);
    String str;
    if (localObject == null)
    {
      str = paramInput.readString();
      localObject = getTypeByName(str);
      if (localObject != null);
    }
    while (true)
    {
      try
      {
        Class localClass = Class.forName(str, false, this.kryo.getClassLoader());
        localObject = localClass;
        if (this.nameToClass == null)
          this.nameToClass = new ObjectMap();
        this.nameToClass.put(str, localObject);
        this.nameIdToClass.put(i, localObject);
        if (Log.TRACE)
          Log.trace("kryo", "Read class name: " + str);
        return this.kryo.getRegistration((Class)localObject);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new KryoException("Unable to find class: " + str, localClassNotFoundException);
      }
      if (Log.TRACE)
        Log.trace("kryo", "Read class name reference " + i + ": " + Util.className((Class)localObject));
    }
  }

  public Registration register(Registration paramRegistration)
  {
    if (paramRegistration == null)
      throw new IllegalArgumentException("registration cannot be null.");
    if (paramRegistration.getId() != -1)
    {
      if (Log.TRACE)
        Log.trace("kryo", "Register class ID " + paramRegistration.getId() + ": " + Util.className(paramRegistration.getType()) + " (" + paramRegistration.getSerializer().getClass().getName() + ")");
      this.idToRegistration.put(paramRegistration.getId(), paramRegistration);
    }
    while (true)
    {
      this.classToRegistration.put(paramRegistration.getType(), paramRegistration);
      if (paramRegistration.getType().isPrimitive())
        this.classToRegistration.put(Util.getWrapperClass(paramRegistration.getType()), paramRegistration);
      return paramRegistration;
      if (Log.TRACE)
        Log.trace("kryo", "Register class name: " + Util.className(paramRegistration.getType()) + " (" + paramRegistration.getSerializer().getClass().getName() + ")");
    }
  }

  public Registration registerImplicit(Class paramClass)
  {
    return register(new Registration(paramClass, this.kryo.getDefaultSerializer(paramClass), -1));
  }

  public void reset()
  {
    if (!this.kryo.isRegistrationRequired())
    {
      if (this.classToNameId != null)
        this.classToNameId.clear();
      if (this.nameIdToClass != null)
        this.nameIdToClass.clear();
      this.nextNameId = 0;
    }
  }

  public void setKryo(Kryo paramKryo)
  {
    this.kryo = paramKryo;
  }

  public Registration writeClass(Output paramOutput, Class paramClass)
  {
    if (paramClass == null)
    {
      if ((Log.TRACE) || ((Log.DEBUG) && (this.kryo.getDepth() == 1)))
        Util.log("Write", null);
      paramOutput.writeVarInt(0, true);
      return null;
    }
    Registration localRegistration = this.kryo.getRegistration(paramClass);
    if (localRegistration.getId() == -1)
    {
      writeName(paramOutput, paramClass, localRegistration);
      return localRegistration;
    }
    if (Log.TRACE)
      Log.trace("kryo", "Write class " + localRegistration.getId() + ": " + Util.className(paramClass));
    paramOutput.writeVarInt(2 + localRegistration.getId(), true);
    return localRegistration;
  }

  protected void writeName(Output paramOutput, Class paramClass, Registration paramRegistration)
  {
    paramOutput.writeVarInt(1, true);
    if (this.classToNameId != null)
    {
      int j = this.classToNameId.get(paramClass, -1);
      if (j != -1)
      {
        if (Log.TRACE)
          Log.trace("kryo", "Write class name reference " + j + ": " + Util.className(paramClass));
        paramOutput.writeVarInt(j, true);
        return;
      }
    }
    if (Log.TRACE)
      Log.trace("kryo", "Write class name: " + Util.className(paramClass));
    int i = this.nextNameId;
    this.nextNameId = (i + 1);
    if (this.classToNameId == null)
      this.classToNameId = new IdentityObjectIntMap();
    this.classToNameId.put(paramClass, i);
    paramOutput.writeVarInt(i, true);
    paramOutput.writeString(paramClass.getName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.util.DefaultClassResolver
 * JD-Core Version:    0.6.2
 */