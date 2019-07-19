package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

class DetailScanner
  implements Detail
{
  private DefaultType access;
  private NamespaceList declaration;
  private List<FieldDetail> fields = new LinkedList();
  private Annotation[] labels;
  private List<MethodDetail> methods = new LinkedList();
  private String name;
  private Namespace namespace;
  private Order order;
  private DefaultType override;
  private boolean required;
  private Root root;
  private boolean strict;
  private Class type;

  public DetailScanner(Class paramClass)
  {
    this(paramClass, null);
  }

  public DetailScanner(Class paramClass, DefaultType paramDefaultType)
  {
    this.labels = paramClass.getDeclaredAnnotations();
    this.override = paramDefaultType;
    this.strict = true;
    this.type = paramClass;
    scan(paramClass);
  }

  private void access(Annotation paramAnnotation)
  {
    if (paramAnnotation != null)
    {
      Default localDefault = (Default)paramAnnotation;
      this.required = localDefault.required();
      this.access = localDefault.value();
    }
  }

  private void extract(Class paramClass)
  {
    for (Annotation localAnnotation : this.labels)
    {
      if ((localAnnotation instanceof Namespace))
        namespace(localAnnotation);
      if ((localAnnotation instanceof NamespaceList))
        scope(localAnnotation);
      if ((localAnnotation instanceof Root))
        root(localAnnotation);
      if ((localAnnotation instanceof Order))
        order(localAnnotation);
      if ((localAnnotation instanceof Default))
        access(localAnnotation);
    }
  }

  private void fields(Class paramClass)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int i = arrayOfField.length;
    for (int j = 0; j < i; j++)
    {
      FieldDetail localFieldDetail = new FieldDetail(arrayOfField[j]);
      this.fields.add(localFieldDetail);
    }
  }

  private boolean isEmpty(String paramString)
  {
    return paramString.length() == 0;
  }

  private void methods(Class paramClass)
  {
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int i = arrayOfMethod.length;
    for (int j = 0; j < i; j++)
    {
      MethodDetail localMethodDetail = new MethodDetail(arrayOfMethod[j]);
      this.methods.add(localMethodDetail);
    }
  }

  private void namespace(Annotation paramAnnotation)
  {
    if (paramAnnotation != null)
      this.namespace = ((Namespace)paramAnnotation);
  }

  private void order(Annotation paramAnnotation)
  {
    if (paramAnnotation != null)
      this.order = ((Order)paramAnnotation);
  }

  private void root(Annotation paramAnnotation)
  {
    if (paramAnnotation != null)
    {
      Root localRoot = (Root)paramAnnotation;
      String str1 = this.type.getSimpleName();
      if (localRoot != null)
      {
        String str2 = localRoot.name();
        if (isEmpty(str2))
          str2 = Reflector.getName(str1);
        this.strict = localRoot.strict();
        this.root = localRoot;
        this.name = str2;
      }
    }
  }

  private void scan(Class paramClass)
  {
    methods(paramClass);
    fields(paramClass);
    extract(paramClass);
  }

  private void scope(Annotation paramAnnotation)
  {
    if (paramAnnotation != null)
      this.declaration = ((NamespaceList)paramAnnotation);
  }

  public DefaultType getAccess()
  {
    if (this.override != null)
      return this.override;
    return this.access;
  }

  public Annotation[] getAnnotations()
  {
    return this.labels;
  }

  public Constructor[] getConstructors()
  {
    return this.type.getDeclaredConstructors();
  }

  public List<FieldDetail> getFields()
  {
    return this.fields;
  }

  public List<MethodDetail> getMethods()
  {
    return this.methods;
  }

  public String getName()
  {
    return this.name;
  }

  public Namespace getNamespace()
  {
    return this.namespace;
  }

  public NamespaceList getNamespaceList()
  {
    return this.declaration;
  }

  public Order getOrder()
  {
    return this.order;
  }

  public DefaultType getOverride()
  {
    return this.override;
  }

  public Root getRoot()
  {
    return this.root;
  }

  public Class getSuper()
  {
    Class localClass = this.type.getSuperclass();
    if (localClass == Object.class)
      localClass = null;
    return localClass;
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isInstantiable()
  {
    if (Modifier.isStatic(this.type.getModifiers()));
    while (!this.type.isMemberClass())
      return true;
    return false;
  }

  public boolean isPrimitive()
  {
    return this.type.isPrimitive();
  }

  public boolean isRequired()
  {
    return this.required;
  }

  public boolean isStrict()
  {
    return this.strict;
  }

  public String toString()
  {
    return this.type.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.DetailScanner
 * JD-Core Version:    0.6.2
 */