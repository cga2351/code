package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

class ClassScanner
{
  private Function commit;
  private Function complete;
  private NamespaceDecorator decorator;
  private Order order;
  private Function persist;
  private Function replace;
  private Function resolve;
  private Root root;
  private ConstructorScanner scanner;
  private Support support;
  private Function validate;

  public ClassScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    this.scanner = new ConstructorScanner(paramDetail, paramSupport);
    this.decorator = new NamespaceDecorator();
    this.support = paramSupport;
    scan(paramDetail);
  }

  private void commit(Method paramMethod)
  {
    if (this.commit == null)
      this.commit = getFunction(paramMethod);
  }

  private void commit(Detail paramDetail)
  {
    Namespace localNamespace = paramDetail.getNamespace();
    if (localNamespace != null)
      this.decorator.set(localNamespace);
  }

  private void complete(Method paramMethod)
  {
    if (this.complete == null)
      this.complete = getFunction(paramMethod);
  }

  private void definition(Detail paramDetail)
    throws Exception
  {
    if (this.root == null)
      this.root = paramDetail.getRoot();
    if (this.order == null)
      this.order = paramDetail.getOrder();
  }

  private Function getFunction(Method paramMethod)
  {
    boolean bool = isContextual(paramMethod);
    if (!paramMethod.isAccessible())
      paramMethod.setAccessible(true);
    return new Function(paramMethod, bool);
  }

  private boolean isContextual(Method paramMethod)
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int i = arrayOfClass.length;
    boolean bool = false;
    if (i == 1)
      bool = Map.class.equals(arrayOfClass[0]);
    return bool;
  }

  private void method(Detail paramDetail)
    throws Exception
  {
    Iterator localIterator = paramDetail.getMethods().iterator();
    while (localIterator.hasNext())
      method((MethodDetail)localIterator.next());
  }

  private void method(MethodDetail paramMethodDetail)
  {
    Annotation[] arrayOfAnnotation = paramMethodDetail.getAnnotations();
    Method localMethod = paramMethodDetail.getMethod();
    int i = arrayOfAnnotation.length;
    for (int j = 0; j < i; j++)
    {
      Annotation localAnnotation = arrayOfAnnotation[j];
      if ((localAnnotation instanceof Commit))
        commit(localMethod);
      if ((localAnnotation instanceof Validate))
        validate(localMethod);
      if ((localAnnotation instanceof Persist))
        persist(localMethod);
      if ((localAnnotation instanceof Complete))
        complete(localMethod);
      if ((localAnnotation instanceof Replace))
        replace(localMethod);
      if ((localAnnotation instanceof Resolve))
        resolve(localMethod);
    }
  }

  private void namespace(Detail paramDetail)
    throws Exception
  {
    NamespaceList localNamespaceList = paramDetail.getNamespaceList();
    Namespace localNamespace1 = paramDetail.getNamespace();
    if (localNamespace1 != null)
      this.decorator.add(localNamespace1);
    if (localNamespaceList != null)
      for (Namespace localNamespace2 : localNamespaceList.value())
        this.decorator.add(localNamespace2);
  }

  private void persist(Method paramMethod)
  {
    if (this.persist == null)
      this.persist = getFunction(paramMethod);
  }

  private void replace(Method paramMethod)
  {
    if (this.replace == null)
      this.replace = getFunction(paramMethod);
  }

  private void resolve(Method paramMethod)
  {
    if (this.resolve == null)
      this.resolve = getFunction(paramMethod);
  }

  private void scan(Detail paramDetail)
    throws Exception
  {
    DefaultType localDefaultType = paramDetail.getOverride();
    Detail localDetail;
    for (Class localClass = paramDetail.getType(); localClass != null; localClass = localDetail.getSuper())
    {
      localDetail = this.support.getDetail(localClass, localDefaultType);
      namespace(localDetail);
      method(localDetail);
      definition(localDetail);
    }
    commit(paramDetail);
  }

  private void validate(Method paramMethod)
  {
    if (this.validate == null)
      this.validate = getFunction(paramMethod);
  }

  public Function getCommit()
  {
    return this.commit;
  }

  public Function getComplete()
  {
    return this.complete;
  }

  public Decorator getDecorator()
  {
    return this.decorator;
  }

  public Order getOrder()
  {
    return this.order;
  }

  public ParameterMap getParameters()
  {
    return this.scanner.getParameters();
  }

  public Function getPersist()
  {
    return this.persist;
  }

  public Function getReplace()
  {
    return this.replace;
  }

  public Function getResolve()
  {
    return this.resolve;
  }

  public Root getRoot()
  {
    return this.root;
  }

  public Signature getSignature()
  {
    return this.scanner.getSignature();
  }

  public List<Signature> getSignatures()
  {
    return this.scanner.getSignatures();
  }

  public Function getValidate()
  {
    return this.validate;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ClassScanner
 * JD-Core Version:    0.6.2
 */