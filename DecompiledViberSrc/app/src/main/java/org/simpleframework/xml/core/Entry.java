package org.simpleframework.xml.core;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;

class Entry
{
  private static final String DEFAULT_NAME = "entry";
  private boolean attribute;
  private Contact contact;
  private String entry;
  private String key;
  private Class keyType;
  private ElementMap label;
  private String value;
  private Class valueType;

  public Entry(Contact paramContact, ElementMap paramElementMap)
  {
    this.attribute = paramElementMap.attribute();
    this.entry = paramElementMap.entry();
    this.value = paramElementMap.value();
    this.key = paramElementMap.key();
    this.contact = paramContact;
    this.label = paramElementMap;
  }

  private Class getDependent(int paramInt)
    throws Exception
  {
    Class[] arrayOfClass = this.contact.getDependents();
    if (arrayOfClass.length < paramInt)
      return Object.class;
    if (arrayOfClass.length == 0)
      return Object.class;
    return arrayOfClass[paramInt];
  }

  private boolean isEmpty(String paramString)
  {
    return paramString.length() == 0;
  }

  public Contact getContact()
  {
    return this.contact;
  }

  public String getEntry()
    throws Exception
  {
    if (this.entry == null)
      return this.entry;
    if (isEmpty(this.entry))
      this.entry = "entry";
    return this.entry;
  }

  public String getKey()
    throws Exception
  {
    if (this.key == null)
      return this.key;
    if (isEmpty(this.key))
      this.key = null;
    return this.key;
  }

  public Converter getKey(Context paramContext)
    throws Exception
  {
    Type localType = getKeyType();
    if (paramContext.isPrimitive(localType))
      return new PrimitiveKey(paramContext, this, localType);
    return new CompositeKey(paramContext, this, localType);
  }

  protected Type getKeyType()
    throws Exception
  {
    if (this.keyType == null)
    {
      this.keyType = this.label.keyType();
      if (this.keyType == Void.TYPE)
        this.keyType = getDependent(0);
    }
    return new ClassType(this.keyType);
  }

  public String getValue()
    throws Exception
  {
    if (this.value == null)
      return this.value;
    if (isEmpty(this.value))
      this.value = null;
    return this.value;
  }

  public Converter getValue(Context paramContext)
    throws Exception
  {
    Type localType = getValueType();
    if (paramContext.isPrimitive(localType))
      return new PrimitiveValue(paramContext, this, localType);
    return new CompositeValue(paramContext, this, localType);
  }

  protected Type getValueType()
    throws Exception
  {
    if (this.valueType == null)
    {
      this.valueType = this.label.valueType();
      if (this.valueType == Void.TYPE)
        this.valueType = getDependent(1);
    }
    return new ClassType(this.valueType);
  }

  public boolean isAttribute()
  {
    return this.attribute;
  }

  public boolean isInline()
    throws Exception
  {
    return isAttribute();
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.label;
    arrayOfObject[1] = this.contact;
    return String.format("%s on %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Entry
 * JD-Core Version:    0.6.2
 */