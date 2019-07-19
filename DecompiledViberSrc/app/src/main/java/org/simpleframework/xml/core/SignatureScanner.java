package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
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
import org.simpleframework.xml.Text;

class SignatureScanner
{
  private final SignatureBuilder builder;
  private final Constructor constructor;
  private final ParameterFactory factory;
  private final ParameterMap registry;
  private final Class type;

  public SignatureScanner(Constructor paramConstructor, ParameterMap paramParameterMap, Support paramSupport)
    throws Exception
  {
    this.builder = new SignatureBuilder(paramConstructor);
    this.factory = new ParameterFactory(paramSupport);
    this.type = paramConstructor.getDeclaringClass();
    this.constructor = paramConstructor;
    this.registry = paramParameterMap;
    scan(this.type);
  }

  private List<Parameter> create(Annotation paramAnnotation, int paramInt)
    throws Exception
  {
    Parameter localParameter = this.factory.getInstance(this.constructor, paramAnnotation, paramInt);
    if (localParameter != null)
      register(localParameter);
    return Collections.singletonList(localParameter);
  }

  private Annotation[] extract(Annotation paramAnnotation)
    throws Exception
  {
    Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
    if (arrayOfMethod.length != 1)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramAnnotation;
      arrayOfObject[1] = this.type;
      throw new UnionException("Annotation '%s' is not a valid union for %s", arrayOfObject);
    }
    return (Annotation[])arrayOfMethod[0].invoke(paramAnnotation, new Object[0]);
  }

  private List<Parameter> process(Annotation paramAnnotation, int paramInt)
    throws Exception
  {
    if ((paramAnnotation instanceof Attribute))
      return create(paramAnnotation, paramInt);
    if ((paramAnnotation instanceof Element))
      return create(paramAnnotation, paramInt);
    if ((paramAnnotation instanceof ElementList))
      return create(paramAnnotation, paramInt);
    if ((paramAnnotation instanceof ElementArray))
      return create(paramAnnotation, paramInt);
    if ((paramAnnotation instanceof ElementMap))
      return create(paramAnnotation, paramInt);
    if ((paramAnnotation instanceof ElementListUnion))
      return union(paramAnnotation, paramInt);
    if ((paramAnnotation instanceof ElementMapUnion))
      return union(paramAnnotation, paramInt);
    if ((paramAnnotation instanceof ElementUnion))
      return union(paramAnnotation, paramInt);
    if ((paramAnnotation instanceof Text))
      return create(paramAnnotation, paramInt);
    return Collections.emptyList();
  }

  private void register(Parameter paramParameter)
    throws Exception
  {
    String str = paramParameter.getPath();
    Object localObject = paramParameter.getKey();
    if (this.registry.containsKey(localObject))
      validate(paramParameter, localObject);
    if (this.registry.containsKey(str))
      validate(paramParameter, str);
    this.registry.put(str, paramParameter);
    this.registry.put(localObject, paramParameter);
  }

  private void scan(Class paramClass)
    throws Exception
  {
    Class[] arrayOfClass = this.constructor.getParameterTypes();
    for (int i = 0; i < arrayOfClass.length; i++)
      scan(arrayOfClass[i], i);
  }

  private void scan(Class paramClass, int paramInt)
    throws Exception
  {
    Annotation[][] arrayOfAnnotation = this.constructor.getParameterAnnotations();
    for (int i = 0; i < arrayOfAnnotation[paramInt].length; i++)
    {
      Iterator localIterator = process(arrayOfAnnotation[paramInt][i], paramInt).iterator();
      while (localIterator.hasNext())
      {
        Parameter localParameter = (Parameter)localIterator.next();
        this.builder.insert(localParameter, paramInt);
      }
    }
  }

  private List<Parameter> union(Annotation paramAnnotation, int paramInt)
    throws Exception
  {
    Signature localSignature = new Signature(this.constructor);
    for (Annotation localAnnotation : extract(paramAnnotation))
    {
      Parameter localParameter = this.factory.getInstance(this.constructor, paramAnnotation, localAnnotation, paramInt);
      String str = localParameter.getPath();
      if (localSignature.contains(str))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str;
        arrayOfObject[1] = paramAnnotation;
        arrayOfObject[2] = this.type;
        throw new UnionException("Annotation name '%s' used more than once in %s for %s", arrayOfObject);
      }
      localSignature.set(str, localParameter);
      register(localParameter);
    }
    return localSignature.getAll();
  }

  private void validate(Parameter paramParameter, Object paramObject)
    throws Exception
  {
    Parameter localParameter = (Parameter)this.registry.get(paramObject);
    if (paramParameter.isText() != localParameter.isText())
    {
      Annotation localAnnotation1 = paramParameter.getAnnotation();
      Annotation localAnnotation2 = localParameter.getAnnotation();
      String str = paramParameter.getPath();
      if (!localAnnotation1.equals(localAnnotation2))
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = str;
        arrayOfObject2[1] = this.type;
        throw new ConstructorException("Annotations do not match for '%s' in %s", arrayOfObject2);
      }
      if (localParameter.getType() != paramParameter.getType())
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = str;
        arrayOfObject1[1] = this.type;
        throw new ConstructorException("Parameter types do not match for '%s' in %s", arrayOfObject1);
      }
    }
  }

  public List<Signature> getSignatures()
    throws Exception
  {
    return this.builder.build();
  }

  public boolean isValid()
  {
    return this.builder.isValid();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SignatureScanner
 * JD-Core Version:    0.6.2
 */