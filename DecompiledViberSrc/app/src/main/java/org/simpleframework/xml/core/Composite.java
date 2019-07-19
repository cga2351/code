package org.simpleframework.xml.core;

import java.util.Iterator;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

class Composite
  implements Converter
{
  private final Context context;
  private final Criteria criteria;
  private final ObjectFactory factory;
  private final Primitive primitive;
  private final Revision revision;
  private final Type type;

  public Composite(Context paramContext, Type paramType)
  {
    this(paramContext, paramType, null);
  }

  public Composite(Context paramContext, Type paramType, Class paramClass)
  {
    this.factory = new ObjectFactory(paramContext, paramType, paramClass);
    this.primitive = new Primitive(paramContext, paramType);
    this.criteria = new Collector();
    this.revision = new Revision();
    this.context = paramContext;
    this.type = paramType;
  }

  private boolean isOverridden(OutputNode paramOutputNode, Object paramObject, Type paramType)
    throws Exception
  {
    return this.factory.setOverride(paramType, paramObject, paramOutputNode);
  }

  private Object read(InputNode paramInputNode, Instance paramInstance, Class paramClass)
    throws Exception
  {
    Schema localSchema = this.context.getSchema(paramClass);
    Caller localCaller = localSchema.getCaller();
    Object localObject = read(localSchema, paramInstance).read(paramInputNode);
    localCaller.validate(localObject);
    localCaller.commit(localObject);
    paramInstance.setInstance(localObject);
    return readResolve(paramInputNode, localObject, localCaller);
  }

  private Builder read(Schema paramSchema, Instance paramInstance)
    throws Exception
  {
    if (paramSchema.getInstantiator().isDefault())
      return new Builder(this, this.criteria, paramSchema, paramInstance);
    return new Injector(this, this.criteria, paramSchema, paramInstance, null);
  }

  private void read(InputNode paramInputNode, Object paramObject, Schema paramSchema)
    throws Exception
  {
    Section localSection = paramSchema.getSection();
    readVersion(paramInputNode, paramObject, paramSchema);
    readSection(paramInputNode, paramObject, localSection);
  }

  private void readAttribute(InputNode paramInputNode, Object paramObject, Section paramSection, LabelMap paramLabelMap)
    throws Exception
  {
    String str = paramSection.getAttribute(paramInputNode.getName());
    Label localLabel = paramLabelMap.getLabel(str);
    if (localLabel == null)
    {
      Position localPosition = paramInputNode.getPosition();
      Class localClass = this.context.getType(this.type, paramObject);
      if ((paramLabelMap.isStrict(this.context)) && (this.revision.isEqual()))
        throw new AttributeException("Attribute '%s' does not have a match in %s at %s", new Object[] { str, localClass, localPosition });
    }
    else
    {
      readInstance(paramInputNode, paramObject, localLabel);
    }
  }

  private void readAttributes(InputNode paramInputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    NodeMap localNodeMap = paramInputNode.getAttributes();
    LabelMap localLabelMap = paramSection.getAttributes();
    Iterator localIterator = localNodeMap.iterator();
    while (localIterator.hasNext())
    {
      InputNode localInputNode = paramInputNode.getAttribute((String)localIterator.next());
      if (localInputNode != null)
        readAttribute(localInputNode, paramObject, paramSection, localLabelMap);
    }
    validate(paramInputNode, localLabelMap, paramObject);
  }

  private void readElement(InputNode paramInputNode, Object paramObject, Section paramSection, LabelMap paramLabelMap)
    throws Exception
  {
    String str = paramSection.getPath(paramInputNode.getName());
    Object localObject = paramLabelMap.getLabel(str);
    if (localObject == null)
      localObject = this.criteria.resolve(str);
    if (localObject == null)
    {
      Position localPosition = paramInputNode.getPosition();
      Class localClass = this.context.getType(this.type, paramObject);
      if ((paramLabelMap.isStrict(this.context)) && (this.revision.isEqual()))
        throw new ElementException("Element '%s' does not have a match in %s at %s", new Object[] { str, localClass, localPosition });
      paramInputNode.skip();
      return;
    }
    readUnion(paramInputNode, paramObject, paramLabelMap, (Label)localObject);
  }

  private void readElements(InputNode paramInputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    LabelMap localLabelMap = paramSection.getElements();
    InputNode localInputNode = paramInputNode.getNext();
    if (localInputNode != null)
    {
      Section localSection = paramSection.getSection(localInputNode.getName());
      if (localSection != null)
        readSection(localInputNode, paramObject, localSection);
      while (true)
      {
        localInputNode = paramInputNode.getNext();
        break;
        readElement(localInputNode, paramObject, paramSection, localLabelMap);
      }
    }
    validate(paramInputNode, localLabelMap, paramObject);
  }

  private Object readInstance(InputNode paramInputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    Object localObject = readVariable(paramInputNode, paramObject, paramLabel);
    if (localObject == null)
    {
      Position localPosition = paramInputNode.getPosition();
      Class localClass = this.context.getType(this.type, paramObject);
      if ((paramLabel.isRequired()) && (this.revision.isEqual()))
        throw new ValueRequiredException("Empty value for %s in %s at %s", new Object[] { paramLabel, localClass, localPosition });
    }
    else if (localObject != paramLabel.getEmpty(this.context))
    {
      this.criteria.set(paramLabel, localObject);
    }
    return localObject;
  }

  private Object readPrimitive(InputNode paramInputNode, Instance paramInstance)
    throws Exception
  {
    Class localClass = paramInstance.getType();
    Object localObject = this.primitive.read(paramInputNode, localClass);
    if (localClass != null)
      paramInstance.setInstance(localObject);
    return localObject;
  }

  private Object readResolve(InputNode paramInputNode, Object paramObject, Caller paramCaller)
    throws Exception
  {
    if (paramObject != null)
    {
      Position localPosition = paramInputNode.getPosition();
      paramObject = paramCaller.resolve(paramObject);
      Class localClass1 = this.type.getType();
      Class localClass2 = paramObject.getClass();
      if (!localClass1.isAssignableFrom(localClass2))
        throw new ElementException("Type %s does not match %s at %s", new Object[] { localClass2, localClass1, localPosition });
    }
    return paramObject;
  }

  private void readSection(InputNode paramInputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    readText(paramInputNode, paramObject, paramSection);
    readAttributes(paramInputNode, paramObject, paramSection);
    readElements(paramInputNode, paramObject, paramSection);
  }

  private void readText(InputNode paramInputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    Label localLabel = paramSection.getText();
    if (localLabel != null)
      readInstance(paramInputNode, paramObject, localLabel);
  }

  private void readUnion(InputNode paramInputNode, Object paramObject, LabelMap paramLabelMap, Label paramLabel)
    throws Exception
  {
    Object localObject = readInstance(paramInputNode, paramObject, paramLabel);
    String[] arrayOfString = paramLabel.getPaths();
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
      paramLabelMap.getLabel(arrayOfString[j]);
    if (paramLabel.isInline())
      this.criteria.set(paramLabel, localObject);
  }

  private Object readVariable(InputNode paramInputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    Converter localConverter = paramLabel.getConverter(this.context);
    if (paramLabel.isCollection())
    {
      Variable localVariable = this.criteria.get(paramLabel);
      Contact localContact = paramLabel.getContact();
      if (localVariable != null)
        return localConverter.read(paramInputNode, localVariable.getValue());
      if (paramObject != null)
      {
        Object localObject = localContact.get(paramObject);
        if (localObject != null)
          return localConverter.read(paramInputNode, localObject);
      }
    }
    return localConverter.read(paramInputNode);
  }

  private void readVersion(InputNode paramInputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    Object localObject = readInstance(paramInputNode, paramObject, paramLabel);
    Class localClass = this.type.getType();
    if (localObject != null)
    {
      Double localDouble = Double.valueOf(this.context.getVersion(localClass).revision());
      if (!localObject.equals(this.revision))
        this.revision.compare(localDouble, localObject);
    }
  }

  private void readVersion(InputNode paramInputNode, Object paramObject, Schema paramSchema)
    throws Exception
  {
    Label localLabel = paramSchema.getVersion();
    Class localClass = this.type.getType();
    if (localLabel != null)
    {
      String str = localLabel.getName();
      InputNode localInputNode = (InputNode)paramInputNode.getAttributes().remove(str);
      if (localInputNode != null)
        readVersion(localInputNode, paramObject, localLabel);
    }
    else
    {
      return;
    }
    Version localVersion = this.context.getVersion(localClass);
    Double localDouble1 = Double.valueOf(this.revision.getDefault());
    Double localDouble2 = Double.valueOf(localVersion.revision());
    this.criteria.set(localLabel, localDouble1);
    this.revision.compare(localDouble2, localDouble1);
  }

  private void validate(InputNode paramInputNode, Label paramLabel)
    throws Exception
  {
    Converter localConverter = paramLabel.getConverter(this.context);
    Position localPosition = paramInputNode.getPosition();
    Class localClass = this.type.getType();
    if (!localConverter.validate(paramInputNode))
      throw new PersistenceException("Invalid value for %s in %s at %s", new Object[] { paramLabel, localClass, localPosition });
    this.criteria.set(paramLabel, null);
  }

  private void validate(InputNode paramInputNode, LabelMap paramLabelMap)
    throws Exception
  {
    Position localPosition = paramInputNode.getPosition();
    Iterator localIterator = paramLabelMap.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      Class localClass = this.type.getType();
      if ((localLabel.isRequired()) && (this.revision.isEqual()))
        throw new ValueRequiredException("Unable to satisfy %s for %s at %s", new Object[] { localLabel, localClass, localPosition });
    }
  }

  private void validate(InputNode paramInputNode, LabelMap paramLabelMap, Object paramObject)
    throws Exception
  {
    Class localClass = this.context.getType(this.type, paramObject);
    Position localPosition = paramInputNode.getPosition();
    Iterator localIterator = paramLabelMap.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if ((localLabel.isRequired()) && (this.revision.isEqual()))
        throw new ValueRequiredException("Unable to satisfy %s for %s at %s", new Object[] { localLabel, localClass, localPosition });
      Object localObject = localLabel.getEmpty(this.context);
      if (localObject != null)
        this.criteria.set(localLabel, localObject);
    }
  }

  private boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    Schema localSchema = this.context.getSchema(paramClass);
    Section localSection = localSchema.getSection();
    validateText(paramInputNode, localSchema);
    validateSection(paramInputNode, localSection);
    return paramInputNode.isElement();
  }

  private void validateAttribute(InputNode paramInputNode, Section paramSection, LabelMap paramLabelMap)
    throws Exception
  {
    Position localPosition = paramInputNode.getPosition();
    String str = paramSection.getAttribute(paramInputNode.getName());
    Label localLabel = paramLabelMap.getLabel(str);
    if (localLabel == null)
    {
      Class localClass = this.type.getType();
      if ((paramLabelMap.isStrict(this.context)) && (this.revision.isEqual()))
        throw new AttributeException("Attribute '%s' does not exist for %s at %s", new Object[] { str, localClass, localPosition });
    }
    else
    {
      validate(paramInputNode, localLabel);
    }
  }

  private void validateAttributes(InputNode paramInputNode, Section paramSection)
    throws Exception
  {
    NodeMap localNodeMap = paramInputNode.getAttributes();
    LabelMap localLabelMap = paramSection.getAttributes();
    Iterator localIterator = localNodeMap.iterator();
    while (localIterator.hasNext())
    {
      InputNode localInputNode = paramInputNode.getAttribute((String)localIterator.next());
      if (localInputNode != null)
        validateAttribute(localInputNode, paramSection, localLabelMap);
    }
    validate(paramInputNode, localLabelMap);
  }

  private void validateElement(InputNode paramInputNode, Section paramSection, LabelMap paramLabelMap)
    throws Exception
  {
    String str = paramSection.getPath(paramInputNode.getName());
    Object localObject = paramLabelMap.getLabel(str);
    if (localObject == null)
      localObject = this.criteria.resolve(str);
    if (localObject == null)
    {
      Position localPosition = paramInputNode.getPosition();
      Class localClass = this.type.getType();
      if ((paramLabelMap.isStrict(this.context)) && (this.revision.isEqual()))
        throw new ElementException("Element '%s' does not exist for %s at %s", new Object[] { str, localClass, localPosition });
      paramInputNode.skip();
      return;
    }
    validateUnion(paramInputNode, paramLabelMap, (Label)localObject);
  }

  private void validateElements(InputNode paramInputNode, Section paramSection)
    throws Exception
  {
    LabelMap localLabelMap = paramSection.getElements();
    InputNode localInputNode = paramInputNode.getNext();
    if (localInputNode != null)
    {
      Section localSection = paramSection.getSection(localInputNode.getName());
      if (localSection != null)
        validateSection(localInputNode, localSection);
      while (true)
      {
        localInputNode = paramInputNode.getNext();
        break;
        validateElement(localInputNode, paramSection, localLabelMap);
      }
    }
    validate(paramInputNode, localLabelMap);
  }

  private void validateSection(InputNode paramInputNode, Section paramSection)
    throws Exception
  {
    validateAttributes(paramInputNode, paramSection);
    validateElements(paramInputNode, paramSection);
  }

  private void validateText(InputNode paramInputNode, Schema paramSchema)
    throws Exception
  {
    Label localLabel = paramSchema.getText();
    if (localLabel != null)
      validate(paramInputNode, localLabel);
  }

  private void validateUnion(InputNode paramInputNode, LabelMap paramLabelMap, Label paramLabel)
    throws Exception
  {
    String[] arrayOfString = paramLabel.getPaths();
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
      paramLabelMap.getLabel(arrayOfString[j]);
    if (paramLabel.isInline())
      this.criteria.set(paramLabel, null);
    validate(paramInputNode, paramLabel);
  }

  private void write(OutputNode paramOutputNode, Object paramObject, Schema paramSchema)
    throws Exception
  {
    Section localSection = paramSchema.getSection();
    writeVersion(paramOutputNode, paramObject, paramSchema);
    writeSection(paramOutputNode, paramObject, localSection);
  }

  private void writeAttribute(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    if (paramObject != null)
      paramLabel.getDecorator().decorate(paramOutputNode.setAttribute(paramLabel.getName(), this.factory.getText(paramObject)));
  }

  private void writeAttributes(OutputNode paramOutputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    Iterator localIterator = paramSection.getAttributes().iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      Object localObject = localLabel.getContact().get(paramObject);
      Class localClass = this.context.getType(this.type, paramObject);
      if (localObject == null)
        localObject = localLabel.getEmpty(this.context);
      if ((localObject == null) && (localLabel.isRequired()))
        throw new AttributeException("Value for %s is null in %s", new Object[] { localLabel, localClass });
      writeAttribute(paramOutputNode, localObject, localLabel);
    }
  }

  private void writeElement(OutputNode paramOutputNode, Object paramObject, Converter paramConverter)
    throws Exception
  {
    paramConverter.write(paramOutputNode, paramObject);
  }

  private void writeElement(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      Label localLabel = paramLabel.getLabel(localClass);
      String str = localLabel.getName();
      Type localType = paramLabel.getType(localClass);
      OutputNode localOutputNode = paramOutputNode.getChild(str);
      if (!localLabel.isInline())
        writeNamespaces(localOutputNode, localType, localLabel);
      if ((localLabel.isInline()) || (!isOverridden(localOutputNode, paramObject, localType)))
      {
        Converter localConverter = localLabel.getConverter(this.context);
        localOutputNode.setData(localLabel.isData());
        writeElement(localOutputNode, paramObject, localConverter);
      }
    }
  }

  private void writeElements(OutputNode paramOutputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    Iterator localIterator = paramSection.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Section localSection = paramSection.getSection(str);
      if (localSection != null)
      {
        writeSection(paramOutputNode.getChild(str), paramObject, localSection);
      }
      else
      {
        Label localLabel = paramSection.getElement(paramSection.getPath(str));
        Class localClass = this.context.getType(this.type, paramObject);
        if (this.criteria.get(localLabel) == null)
        {
          if (localLabel == null)
            throw new ElementException("Element '%s' not defined in %s", new Object[] { str, localClass });
          writeUnion(paramOutputNode, paramObject, paramSection, localLabel);
        }
      }
    }
  }

  private void writeNamespaces(OutputNode paramOutputNode, Type paramType, Label paramLabel)
    throws Exception
  {
    Class localClass = paramType.getType();
    Decorator localDecorator = this.context.getDecorator(localClass);
    paramLabel.getDecorator().decorate(paramOutputNode, localDecorator);
  }

  private Object writeReplace(Object paramObject)
    throws Exception
  {
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      paramObject = this.context.getCaller(localClass).replace(paramObject);
    }
    return paramObject;
  }

  private void writeSection(OutputNode paramOutputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    NamespaceMap localNamespaceMap = paramOutputNode.getNamespaces();
    String str1 = paramSection.getPrefix();
    if (str1 != null)
    {
      String str2 = localNamespaceMap.getReference(str1);
      if (str2 == null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str1;
        arrayOfObject[1] = this.type;
        throw new ElementException("Namespace prefix '%s' in %s is not in scope", arrayOfObject);
      }
      paramOutputNode.setReference(str2);
    }
    writeAttributes(paramOutputNode, paramObject, paramSection);
    writeElements(paramOutputNode, paramObject, paramSection);
    writeText(paramOutputNode, paramObject, paramSection);
  }

  private void writeText(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    if ((paramObject != null) && (!paramLabel.isTextList()))
    {
      String str = this.factory.getText(paramObject);
      paramOutputNode.setData(paramLabel.isData());
      paramOutputNode.setValue(str);
    }
  }

  private void writeText(OutputNode paramOutputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    Label localLabel = paramSection.getText();
    if (localLabel != null)
    {
      Object localObject = localLabel.getContact().get(paramObject);
      Class localClass = this.context.getType(this.type, paramObject);
      if (localObject == null)
        localObject = localLabel.getEmpty(this.context);
      if ((localObject == null) && (localLabel.isRequired()))
        throw new TextException("Value for %s is null in %s", new Object[] { localLabel, localClass });
      writeText(paramOutputNode, localObject, localLabel);
    }
  }

  private void writeUnion(OutputNode paramOutputNode, Object paramObject, Section paramSection, Label paramLabel)
    throws Exception
  {
    Object localObject1 = paramLabel.getContact().get(paramObject);
    Class localClass = this.context.getType(this.type, paramObject);
    if ((localObject1 == null) && (paramLabel.isRequired()))
      throw new ElementException("Value for %s is null in %s", new Object[] { paramLabel, localClass });
    Object localObject2 = writeReplace(localObject1);
    if (localObject2 != null)
      writeElement(paramOutputNode, localObject2, paramLabel);
    this.criteria.set(paramLabel, localObject2);
  }

  private void writeVersion(OutputNode paramOutputNode, Object paramObject, Schema paramSchema)
    throws Exception
  {
    Version localVersion = paramSchema.getRevision();
    Label localLabel = paramSchema.getVersion();
    Double localDouble2;
    if (localVersion != null)
    {
      Double localDouble1 = Double.valueOf(this.revision.getDefault());
      localDouble2 = Double.valueOf(localVersion.revision());
      if (!this.revision.compare(localDouble2, localDouble1))
        break label79;
      if (localLabel.isRequired())
        writeAttribute(paramOutputNode, localDouble2, localLabel);
    }
    return;
    label79: writeAttribute(paramOutputNode, localDouble2, localLabel);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Class localClass = localInstance.getType();
    if (localInstance.isReference())
      return localInstance.getInstance();
    if (this.context.isPrimitive(localClass))
      return readPrimitive(paramInputNode, localInstance);
    return read(paramInputNode, localInstance, localClass);
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Schema localSchema = this.context.getSchema(localClass);
    Caller localCaller = localSchema.getCaller();
    read(paramInputNode, paramObject, localSchema);
    this.criteria.commit(paramObject);
    localCaller.validate(paramObject);
    localCaller.commit(paramObject);
    return readResolve(paramInputNode, paramObject, localCaller);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (!localInstance.isReference())
    {
      localInstance.setInstance(null);
      return validate(paramInputNode, localInstance.getType());
    }
    return true;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Schema localSchema = this.context.getSchema(localClass);
    Caller localCaller = localSchema.getCaller();
    try
    {
      if (localSchema.isPrimitive())
        this.primitive.write(paramOutputNode, paramObject);
      while (true)
      {
        return;
        localCaller.persist(paramObject);
        write(paramOutputNode, paramObject, localSchema);
      }
    }
    finally
    {
      localCaller.complete(paramObject);
    }
  }

  private static class Builder
  {
    protected final Composite composite;
    protected final Criteria criteria;
    protected final Schema schema;
    protected final Instance value;

    public Builder(Composite paramComposite, Criteria paramCriteria, Schema paramSchema, Instance paramInstance)
    {
      this.composite = paramComposite;
      this.criteria = paramCriteria;
      this.schema = paramSchema;
      this.value = paramInstance;
    }

    public Object read(InputNode paramInputNode)
      throws Exception
    {
      Object localObject = this.value.getInstance();
      Section localSection = this.schema.getSection();
      this.value.setInstance(localObject);
      this.composite.readVersion(paramInputNode, localObject, this.schema);
      this.composite.readText(paramInputNode, localObject, localSection);
      this.composite.readAttributes(paramInputNode, localObject, localSection);
      this.composite.readElements(paramInputNode, localObject, localSection);
      this.criteria.commit(localObject);
      return localObject;
    }
  }

  private class Injector extends Composite.Builder
  {
    private Injector(Composite paramCriteria, Criteria paramSchema, Schema paramInstance, Instance arg5)
    {
      super(paramSchema, paramInstance, localInstance);
    }

    private Object readInject(InputNode paramInputNode)
      throws Exception
    {
      Object localObject = this.schema.getInstantiator().getInstance(this.criteria);
      this.value.setInstance(localObject);
      this.criteria.commit(localObject);
      return localObject;
    }

    public Object read(InputNode paramInputNode)
      throws Exception
    {
      Section localSection = this.schema.getSection();
      this.composite.readVersion(paramInputNode, null, this.schema);
      this.composite.readText(paramInputNode, null, localSection);
      this.composite.readAttributes(paramInputNode, null, localSection);
      this.composite.readElements(paramInputNode, null, localSection);
      return readInject(paramInputNode);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Composite
 * JD-Core Version:    0.6.2
 */