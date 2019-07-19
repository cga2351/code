package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class InstantiatorBuilder
{
  private LabelMap attributes = new LabelMap();
  private Comparer comparer = new Comparer();
  private Detail detail;
  private LabelMap elements = new LabelMap();
  private Instantiator factory;
  private List<Creator> options = new ArrayList();
  private Scanner scanner;
  private LabelMap texts = new LabelMap();

  public InstantiatorBuilder(Scanner paramScanner, Detail paramDetail)
  {
    this.scanner = paramScanner;
    this.detail = paramDetail;
  }

  private Instantiator build(Detail paramDetail)
    throws Exception
  {
    if (this.factory == null)
      this.factory = create(paramDetail);
    return this.factory;
  }

  private boolean contains(String[] paramArrayOfString, String paramString)
    throws Exception
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if (str == paramString);
      while (str.equals(paramString))
        return true;
    }
    return false;
  }

  private Creator create(Signature paramSignature)
  {
    SignatureCreator localSignatureCreator = new SignatureCreator(paramSignature);
    if (paramSignature != null)
      this.options.add(localSignatureCreator);
    return localSignatureCreator;
  }

  private Instantiator create(Detail paramDetail)
    throws Exception
  {
    Signature localSignature = this.scanner.getSignature();
    ParameterMap localParameterMap = this.scanner.getParameters();
    SignatureCreator localSignatureCreator = null;
    if (localSignature != null)
      localSignatureCreator = new SignatureCreator(localSignature);
    return new ClassInstantiator(this.options, localSignatureCreator, localParameterMap, paramDetail);
  }

  private Parameter create(Parameter paramParameter)
    throws Exception
  {
    Label localLabel = resolve(paramParameter);
    if (localLabel != null)
      return new CacheParameter(paramParameter, localLabel);
    return null;
  }

  private void populate(Detail paramDetail)
    throws Exception
  {
    Iterator localIterator = this.scanner.getSignatures().iterator();
    while (localIterator.hasNext())
      populate((Signature)localIterator.next());
  }

  private void populate(Signature paramSignature)
    throws Exception
  {
    Signature localSignature = new Signature(paramSignature);
    Iterator localIterator = paramSignature.iterator();
    while (localIterator.hasNext())
    {
      Parameter localParameter = create((Parameter)localIterator.next());
      if (localParameter != null)
        localSignature.add(localParameter);
    }
    create(localSignature);
  }

  private void register(Label paramLabel, LabelMap paramLabelMap)
    throws Exception
  {
    String str1 = paramLabel.getName();
    String str2 = paramLabel.getPath();
    if (paramLabelMap.containsKey(str1))
      if (!((Label)paramLabelMap.get(str1)).getPath().equals(str1))
        paramLabelMap.remove(str1);
    while (true)
    {
      paramLabelMap.put(str2, paramLabel);
      return;
      paramLabelMap.put(str1, paramLabel);
    }
  }

  private Label resolve(Parameter paramParameter)
    throws Exception
  {
    if (paramParameter.isAttribute())
      return resolve(paramParameter, this.attributes);
    if (paramParameter.isText())
      return resolve(paramParameter, this.texts);
    return resolve(paramParameter, this.elements);
  }

  private Label resolve(Parameter paramParameter, LabelMap paramLabelMap)
    throws Exception
  {
    String str = paramParameter.getName();
    Label localLabel = (Label)paramLabelMap.get(paramParameter.getPath());
    if (localLabel == null)
      localLabel = (Label)paramLabelMap.get(str);
    return localLabel;
  }

  private void validate(Detail paramDetail)
    throws Exception
  {
    Iterator localIterator = this.scanner.getParameters().getAll().iterator();
    while (localIterator.hasNext())
    {
      Parameter localParameter = (Parameter)localIterator.next();
      Label localLabel = resolve(localParameter);
      String str = localParameter.getPath();
      if (localLabel == null)
        throw new ConstructorException("Parameter '%s' does not have a match in %s", new Object[] { str, paramDetail });
      validateParameter(localLabel, localParameter);
    }
    validateConstructors();
  }

  private void validateAnnotations(Label paramLabel, Parameter paramParameter)
    throws Exception
  {
    Annotation localAnnotation1 = paramLabel.getAnnotation();
    Annotation localAnnotation2 = paramParameter.getAnnotation();
    String str = paramParameter.getName();
    if (!this.comparer.equals(localAnnotation1, localAnnotation2))
    {
      Class localClass1 = localAnnotation1.annotationType();
      Class localClass2 = localAnnotation2.annotationType();
      if (!localClass1.equals(localClass2))
        throw new ConstructorException("Annotation %s does not match %s for '%s' in %s", new Object[] { localClass2, localClass1, str, paramParameter });
    }
  }

  private void validateConstructor(Label paramLabel, List<Creator> paramList)
    throws Exception
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Signature localSignature = ((Creator)localIterator.next()).getSignature();
      Contact localContact = paramLabel.getContact();
      Object localObject = paramLabel.getKey();
      if ((localContact.isReadOnly()) && (localSignature.get(localObject) == null))
        localIterator.remove();
    }
  }

  private void validateConstructors()
    throws Exception
  {
    List localList = this.factory.getCreators();
    if (this.factory.isDefault())
    {
      validateConstructors(this.elements);
      validateConstructors(this.attributes);
    }
    if (!localList.isEmpty())
    {
      validateConstructors(this.elements, localList);
      validateConstructors(this.attributes, localList);
    }
  }

  private void validateConstructors(LabelMap paramLabelMap)
    throws Exception
  {
    Iterator localIterator = paramLabelMap.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if ((localLabel != null) && (localLabel.getContact().isReadOnly()))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localLabel;
        arrayOfObject[1] = this.detail;
        throw new ConstructorException("Default constructor can not accept read only %s in %s", arrayOfObject);
      }
    }
  }

  private void validateConstructors(LabelMap paramLabelMap, List<Creator> paramList)
    throws Exception
  {
    Iterator localIterator = paramLabelMap.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel != null)
        validateConstructor(localLabel, paramList);
    }
    if (paramList.isEmpty())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.detail;
      throw new ConstructorException("No constructor accepts all read only values in %s", arrayOfObject);
    }
  }

  private void validateNames(Label paramLabel, Parameter paramParameter)
    throws Exception
  {
    String[] arrayOfString = paramLabel.getNames();
    String str1 = paramParameter.getName();
    if (!contains(arrayOfString, str1))
    {
      String str2 = paramLabel.getName();
      if (str1 != str2)
      {
        if ((str1 == null) || (str2 == null))
          throw new ConstructorException("Annotation does not match %s for '%s' in %s", new Object[] { paramLabel, str1, paramParameter });
        if (!str1.equals(str2))
          throw new ConstructorException("Annotation does not match %s for '%s' in %s", new Object[] { paramLabel, str1, paramParameter });
      }
    }
  }

  private void validateParameter(Label paramLabel, Parameter paramParameter)
    throws Exception
  {
    Contact localContact = paramLabel.getContact();
    String str = paramParameter.getName();
    if (!Support.isAssignable(paramParameter.getType(), localContact.getType()))
      throw new ConstructorException("Type is not compatible with %s for '%s' in %s", new Object[] { paramLabel, str, paramParameter });
    validateNames(paramLabel, paramParameter);
    validateAnnotations(paramLabel, paramParameter);
  }

  public Instantiator build()
    throws Exception
  {
    if (this.factory == null)
    {
      populate(this.detail);
      build(this.detail);
      validate(this.detail);
    }
    return this.factory;
  }

  public void register(Label paramLabel)
    throws Exception
  {
    if (paramLabel.isAttribute())
    {
      register(paramLabel, this.attributes);
      return;
    }
    if (paramLabel.isText())
    {
      register(paramLabel, this.texts);
      return;
    }
    register(paramLabel, this.elements);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.InstantiatorBuilder
 * JD-Core Version:    0.6.2
 */