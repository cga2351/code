package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Version;

class ObjectScanner
  implements Scanner
{
  private StructureBuilder builder;
  private Detail detail;
  private ClassScanner scanner;
  private Structure structure;
  private Support support;

  public ObjectScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    this.scanner = new ClassScanner(paramDetail, paramSupport);
    this.builder = new StructureBuilder(this, paramDetail, paramSupport);
    this.support = paramSupport;
    this.detail = paramDetail;
    scan(paramDetail);
  }

  private void commit(Detail paramDetail)
    throws Exception
  {
    Class localClass = paramDetail.getType();
    if (this.structure == null)
      this.structure = this.builder.build(localClass);
    this.builder = null;
  }

  private void field(Detail paramDetail)
    throws Exception
  {
    Class localClass = paramDetail.getType();
    DefaultType localDefaultType = paramDetail.getOverride();
    Iterator localIterator = this.support.getFields(localClass, localDefaultType).iterator();
    while (localIterator.hasNext())
    {
      Contact localContact = (Contact)localIterator.next();
      Annotation localAnnotation = localContact.getAnnotation();
      if (localAnnotation != null)
        this.builder.process(localContact, localAnnotation);
    }
  }

  private void method(Detail paramDetail)
    throws Exception
  {
    Class localClass = paramDetail.getType();
    DefaultType localDefaultType = paramDetail.getOverride();
    Iterator localIterator = this.support.getMethods(localClass, localDefaultType).iterator();
    while (localIterator.hasNext())
    {
      Contact localContact = (Contact)localIterator.next();
      Annotation localAnnotation = localContact.getAnnotation();
      if (localAnnotation != null)
        this.builder.process(localContact, localAnnotation);
    }
  }

  private void order(Detail paramDetail)
    throws Exception
  {
    Class localClass = paramDetail.getType();
    this.builder.assemble(localClass);
  }

  private void scan(Detail paramDetail)
    throws Exception
  {
    order(paramDetail);
    field(paramDetail);
    method(paramDetail);
    validate(paramDetail);
    commit(paramDetail);
  }

  private void validate(Detail paramDetail)
    throws Exception
  {
    Class localClass = paramDetail.getType();
    this.builder.commit(localClass);
    this.builder.validate(localClass);
  }

  public Caller getCaller(Context paramContext)
  {
    return new Caller(this, paramContext);
  }

  public Function getCommit()
  {
    return this.scanner.getCommit();
  }

  public Function getComplete()
  {
    return this.scanner.getComplete();
  }

  public Decorator getDecorator()
  {
    return this.scanner.getDecorator();
  }

  public Instantiator getInstantiator()
  {
    return this.structure.getInstantiator();
  }

  public String getName()
  {
    return this.detail.getName();
  }

  public Order getOrder()
  {
    return this.scanner.getOrder();
  }

  public ParameterMap getParameters()
  {
    return this.scanner.getParameters();
  }

  public Function getPersist()
  {
    return this.scanner.getPersist();
  }

  public Function getReplace()
  {
    return this.scanner.getReplace();
  }

  public Function getResolve()
  {
    return this.scanner.getResolve();
  }

  public Version getRevision()
  {
    return this.structure.getRevision();
  }

  public Section getSection()
  {
    return this.structure.getSection();
  }

  public Signature getSignature()
  {
    return this.scanner.getSignature();
  }

  public List<Signature> getSignatures()
  {
    return this.scanner.getSignatures();
  }

  public Label getText()
  {
    return this.structure.getText();
  }

  public Class getType()
  {
    return this.detail.getType();
  }

  public Function getValidate()
  {
    return this.scanner.getValidate();
  }

  public Label getVersion()
  {
    return this.structure.getVersion();
  }

  public boolean isEmpty()
  {
    return this.scanner.getRoot() == null;
  }

  public boolean isPrimitive()
  {
    return this.structure.isPrimitive();
  }

  public boolean isStrict()
  {
    return this.detail.isStrict();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ObjectScanner
 * JD-Core Version:    0.6.2
 */