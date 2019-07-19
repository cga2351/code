package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;

class StructureBuilder
{
  private ModelAssembler assembler;
  private LabelMap attributes;
  private ExpressionBuilder builder;
  private LabelMap elements;
  private Instantiator factory;
  private boolean primitive;
  private InstantiatorBuilder resolver;
  private Model root;
  private Scanner scanner;
  private Support support;
  private Label text;
  private LabelMap texts;
  private Label version;

  public StructureBuilder(Scanner paramScanner, Detail paramDetail, Support paramSupport)
    throws Exception
  {
    this.builder = new ExpressionBuilder(paramDetail, paramSupport);
    this.assembler = new ModelAssembler(this.builder, paramDetail, paramSupport);
    this.resolver = new InstantiatorBuilder(paramScanner, paramDetail);
    this.root = new TreeModel(paramScanner, paramDetail);
    this.attributes = new LabelMap(paramScanner);
    this.elements = new LabelMap(paramScanner);
    this.texts = new LabelMap(paramScanner);
    this.scanner = paramScanner;
    this.support = paramSupport;
  }

  private Model create(Expression paramExpression)
    throws Exception
  {
    Model localModel = this.root;
    while (true)
    {
      if (localModel != null)
      {
        String str1 = paramExpression.getPrefix();
        String str2 = paramExpression.getFirst();
        int i = paramExpression.getIndex();
        if (str2 != null)
          localModel = localModel.register(str2, str1, i);
        if (paramExpression.isPath());
      }
      else
      {
        return localModel;
      }
      paramExpression = paramExpression.getPath(1);
    }
  }

  private boolean isAttribute(String paramString)
    throws Exception
  {
    Expression localExpression = this.builder.build(paramString);
    Model localModel = lookup(localExpression);
    if (localModel != null)
    {
      String str = localExpression.getLast();
      if (!localExpression.isPath())
        return localModel.isAttribute(paramString);
      return localModel.isAttribute(str);
    }
    return false;
  }

  private boolean isElement(String paramString)
    throws Exception
  {
    Expression localExpression = this.builder.build(paramString);
    Model localModel = lookup(localExpression);
    if (localModel != null)
    {
      String str = localExpression.getLast();
      int i = localExpression.getIndex();
      if (localModel.isElement(str));
      do
      {
        return true;
        if (!localModel.isModel(str))
          break;
      }
      while (!localModel.lookup(str, i).isEmpty());
      return false;
    }
    return false;
  }

  private boolean isEmpty()
  {
    if (this.text != null)
      return false;
    return this.root.isEmpty();
  }

  private Model lookup(Expression paramExpression)
    throws Exception
  {
    Expression localExpression = paramExpression.getPath(0, 1);
    if (paramExpression.isPath())
      return this.root.lookup(localExpression);
    return this.root;
  }

  private void process(Contact paramContact, Annotation paramAnnotation, LabelMap paramLabelMap)
    throws Exception
  {
    Label localLabel = this.support.getLabel(paramContact, paramAnnotation);
    String str1 = localLabel.getPath();
    String str2 = localLabel.getName();
    if (paramLabelMap.get(str1) != null)
      throw new PersistenceException("Duplicate annotation of name '%s' on %s", new Object[] { str2, paramContact });
    process(paramContact, localLabel, paramLabelMap);
  }

  private void process(Contact paramContact, Label paramLabel, LabelMap paramLabelMap)
    throws Exception
  {
    Expression localExpression = paramLabel.getExpression();
    String str = paramLabel.getPath();
    Model localModel = this.root;
    if (!localExpression.isEmpty())
      localModel = register(localExpression);
    this.resolver.register(paramLabel);
    localModel.register(paramLabel);
    paramLabelMap.put(str, paramLabel);
  }

  private Model register(Expression paramExpression)
    throws Exception
  {
    Model localModel = this.root.lookup(paramExpression);
    if (localModel != null)
      return localModel;
    return create(paramExpression);
  }

  private void text(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Label localLabel = this.support.getLabel(paramContact, paramAnnotation);
    Expression localExpression = localLabel.getExpression();
    String str = localLabel.getPath();
    Model localModel = this.root;
    if (!localExpression.isEmpty())
      localModel = register(localExpression);
    if (this.texts.get(str) != null)
      throw new TextException("Multiple text annotations in %s", new Object[] { paramAnnotation });
    this.resolver.register(localLabel);
    localModel.register(localLabel);
    this.texts.put(str, localLabel);
  }

  private void union(Contact paramContact, Annotation paramAnnotation, LabelMap paramLabelMap)
    throws Exception
  {
    Iterator localIterator = this.support.getLabels(paramContact, paramAnnotation).iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      String str1 = localLabel.getPath();
      String str2 = localLabel.getName();
      if (paramLabelMap.get(str1) != null)
        throw new PersistenceException("Duplicate annotation of name '%s' on %s", new Object[] { str2, localLabel });
      process(paramContact, localLabel, paramLabelMap);
    }
  }

  private void validateAttributes(Class paramClass, Order paramOrder)
    throws Exception
  {
    if (paramOrder != null)
      for (String str : paramOrder.attributes())
        if (!isAttribute(str))
          throw new AttributeException("Ordered attribute '%s' missing in %s", new Object[] { str, paramClass });
  }

  private void validateElements(Class paramClass, Order paramOrder)
    throws Exception
  {
    if (paramOrder != null)
      for (String str : paramOrder.elements())
        if (!isElement(str))
          throw new ElementException("Ordered element '%s' missing for %s", new Object[] { str, paramClass });
  }

  private void validateModel(Class paramClass)
    throws Exception
  {
    if (!this.root.isEmpty())
      this.root.validate(paramClass);
  }

  private void validateText(Class paramClass)
    throws Exception
  {
    Label localLabel = this.root.getText();
    if (localLabel != null)
    {
      if (!localLabel.isTextList())
      {
        if (!this.elements.isEmpty())
          throw new TextException("Elements used with %s in %s", new Object[] { localLabel, paramClass });
        if (this.root.isComposite())
          throw new TextException("Paths used with %s in %s", new Object[] { localLabel, paramClass });
      }
    }
    else if (this.scanner.isEmpty())
      this.primitive = isEmpty();
  }

  private void validateTextList(Class paramClass)
    throws Exception
  {
    Label localLabel1 = this.root.getText();
    if ((localLabel1 != null) && (localLabel1.isTextList()))
    {
      Object localObject = localLabel1.getKey();
      Iterator localIterator = this.elements.iterator();
      while (localIterator.hasNext())
      {
        Label localLabel2 = (Label)localIterator.next();
        if (!localLabel2.getKey().equals(localObject))
          throw new TextException("Elements used with %s in %s", new Object[] { localLabel1, paramClass });
        Class localClass = localLabel2.getDependent().getType();
        if (localClass == String.class)
          throw new TextException("Illegal entry of %s with text annotations on %s in %s", new Object[] { localClass, localLabel1, paramClass });
      }
      if (this.root.isComposite())
        throw new TextException("Paths used with %s in %s", new Object[] { localLabel1, paramClass });
    }
  }

  private void validateUnions(Class paramClass)
    throws Exception
  {
    Iterator localIterator = this.elements.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel1 = (Label)localIterator.next();
      String[] arrayOfString = localLabel1.getPaths();
      Contact localContact = localLabel1.getContact();
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = arrayOfString[j];
        Annotation localAnnotation = localContact.getAnnotation();
        Label localLabel2 = (Label)this.elements.get(str);
        if (localLabel1.isInline() != localLabel2.isInline())
          throw new UnionException("Inline must be consistent in %s for %s", new Object[] { localAnnotation, localContact });
        if (localLabel1.isRequired() != localLabel2.isRequired())
          throw new UnionException("Required must be consistent in %s for %s", new Object[] { localAnnotation, localContact });
      }
    }
  }

  private void version(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Label localLabel = this.support.getLabel(paramContact, paramAnnotation);
    if (this.version != null)
      throw new AttributeException("Multiple version annotations in %s", new Object[] { paramAnnotation });
    this.version = localLabel;
  }

  public void assemble(Class paramClass)
    throws Exception
  {
    Order localOrder = this.scanner.getOrder();
    if (localOrder != null)
      this.assembler.assemble(this.root, localOrder);
  }

  public Structure build(Class paramClass)
    throws Exception
  {
    return new Structure(this.factory, this.root, this.version, this.text, this.primitive);
  }

  public void commit(Class paramClass)
    throws Exception
  {
    if (this.factory == null)
      this.factory = this.resolver.build();
  }

  public void process(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    if ((paramAnnotation instanceof Attribute))
      process(paramContact, paramAnnotation, this.attributes);
    if ((paramAnnotation instanceof ElementUnion))
      union(paramContact, paramAnnotation, this.elements);
    if ((paramAnnotation instanceof ElementListUnion))
      union(paramContact, paramAnnotation, this.elements);
    if ((paramAnnotation instanceof ElementMapUnion))
      union(paramContact, paramAnnotation, this.elements);
    if ((paramAnnotation instanceof ElementList))
      process(paramContact, paramAnnotation, this.elements);
    if ((paramAnnotation instanceof ElementArray))
      process(paramContact, paramAnnotation, this.elements);
    if ((paramAnnotation instanceof ElementMap))
      process(paramContact, paramAnnotation, this.elements);
    if ((paramAnnotation instanceof Element))
      process(paramContact, paramAnnotation, this.elements);
    if ((paramAnnotation instanceof Version))
      version(paramContact, paramAnnotation);
    if ((paramAnnotation instanceof Text))
      text(paramContact, paramAnnotation);
  }

  public void validate(Class paramClass)
    throws Exception
  {
    Order localOrder = this.scanner.getOrder();
    validateUnions(paramClass);
    validateElements(paramClass, localOrder);
    validateAttributes(paramClass, localOrder);
    validateModel(paramClass);
    validateText(paramClass);
    validateTextList(paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.StructureBuilder
 * JD-Core Version:    0.6.2
 */