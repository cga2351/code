package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
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
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class LabelExtractor
{
  private final Cache<LabelGroup> cache = new ConcurrentCache();
  private final Format format;

  public LabelExtractor(Format paramFormat)
  {
    this.format = paramFormat;
  }

  private Annotation[] getAnnotations(Annotation paramAnnotation)
    throws Exception
  {
    Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
    if (arrayOfMethod.length > 0)
      return (Annotation[])arrayOfMethod[0].invoke(paramAnnotation, new Object[0]);
    return new Annotation[0];
  }

  private LabelBuilder getBuilder(Annotation paramAnnotation)
    throws Exception
  {
    if ((paramAnnotation instanceof Element))
      return new LabelBuilder(ElementLabel.class, Element.class);
    if ((paramAnnotation instanceof ElementList))
      return new LabelBuilder(ElementListLabel.class, ElementList.class);
    if ((paramAnnotation instanceof ElementArray))
      return new LabelBuilder(ElementArrayLabel.class, ElementArray.class);
    if ((paramAnnotation instanceof ElementMap))
      return new LabelBuilder(ElementMapLabel.class, ElementMap.class);
    if ((paramAnnotation instanceof ElementUnion))
      return new LabelBuilder(ElementUnionLabel.class, ElementUnion.class, Element.class);
    if ((paramAnnotation instanceof ElementListUnion))
      return new LabelBuilder(ElementListUnionLabel.class, ElementListUnion.class, ElementList.class);
    if ((paramAnnotation instanceof ElementMapUnion))
      return new LabelBuilder(ElementMapUnionLabel.class, ElementMapUnion.class, ElementMap.class);
    if ((paramAnnotation instanceof Attribute))
      return new LabelBuilder(AttributeLabel.class, Attribute.class);
    if ((paramAnnotation instanceof Version))
      return new LabelBuilder(VersionLabel.class, Version.class);
    if ((paramAnnotation instanceof Text))
      return new LabelBuilder(TextLabel.class, Text.class);
    throw new PersistenceException("Annotation %s not supported", new Object[] { paramAnnotation });
  }

  private Constructor getConstructor(Annotation paramAnnotation)
    throws Exception
  {
    Constructor localConstructor = getBuilder(paramAnnotation).getConstructor();
    if (!localConstructor.isAccessible())
      localConstructor.setAccessible(true);
    return localConstructor;
  }

  private LabelGroup getGroup(Contact paramContact, Annotation paramAnnotation, Object paramObject)
    throws Exception
  {
    LabelGroup localLabelGroup = (LabelGroup)this.cache.fetch(paramObject);
    if (localLabelGroup == null)
    {
      localLabelGroup = getLabels(paramContact, paramAnnotation);
      if (localLabelGroup != null)
        this.cache.cache(paramObject, localLabelGroup);
    }
    return localLabelGroup;
  }

  private Object getKey(Contact paramContact, Annotation paramAnnotation)
  {
    return new LabelKey(paramContact, paramAnnotation);
  }

  private Label getLabel(Contact paramContact, Annotation paramAnnotation1, Annotation paramAnnotation2)
    throws Exception
  {
    Constructor localConstructor = getConstructor(paramAnnotation1);
    if (paramAnnotation2 != null)
    {
      Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = paramContact;
      arrayOfObject2[1] = paramAnnotation1;
      arrayOfObject2[2] = paramAnnotation2;
      arrayOfObject2[3] = this.format;
      return (Label)localConstructor.newInstance(arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = paramContact;
    arrayOfObject1[1] = paramAnnotation1;
    arrayOfObject1[2] = this.format;
    return (Label)localConstructor.newInstance(arrayOfObject1);
  }

  private LabelGroup getLabels(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    if ((paramAnnotation instanceof ElementUnion))
      return getUnion(paramContact, paramAnnotation);
    if ((paramAnnotation instanceof ElementListUnion))
      return getUnion(paramContact, paramAnnotation);
    if ((paramAnnotation instanceof ElementMapUnion))
      return getUnion(paramContact, paramAnnotation);
    return getSingle(paramContact, paramAnnotation);
  }

  private LabelGroup getSingle(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Label localLabel = getLabel(paramContact, paramAnnotation, null);
    if (localLabel != null);
    for (Object localObject = new CacheLabel(localLabel); ; localObject = localLabel)
      return new LabelGroup((Label)localObject);
  }

  private LabelGroup getUnion(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Annotation[] arrayOfAnnotation = getAnnotations(paramAnnotation);
    LinkedList localLinkedList;
    int j;
    Label localLabel;
    if (arrayOfAnnotation.length > 0)
    {
      localLinkedList = new LinkedList();
      int i = arrayOfAnnotation.length;
      j = 0;
      if (j < i)
      {
        localLabel = getLabel(paramContact, paramAnnotation, arrayOfAnnotation[j]);
        if (localLabel == null)
          break label90;
      }
    }
    label90: for (Object localObject = new CacheLabel(localLabel); ; localObject = localLabel)
    {
      localLinkedList.add(localObject);
      j++;
      break;
      return new LabelGroup(localLinkedList);
      return null;
    }
  }

  public Label getLabel(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    LabelGroup localLabelGroup = getGroup(paramContact, paramAnnotation, getKey(paramContact, paramAnnotation));
    if (localLabelGroup != null)
      return localLabelGroup.getPrimary();
    return null;
  }

  public List<Label> getList(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    LabelGroup localLabelGroup = getGroup(paramContact, paramAnnotation, getKey(paramContact, paramAnnotation));
    if (localLabelGroup != null)
      return localLabelGroup.getList();
    return Collections.emptyList();
  }

  private static class LabelBuilder
  {
    private final Class entry;
    private final Class label;
    private final Class type;

    public LabelBuilder(Class paramClass1, Class paramClass2)
    {
      this(paramClass1, paramClass2, null);
    }

    public LabelBuilder(Class paramClass1, Class paramClass2, Class paramClass3)
    {
      this.entry = paramClass3;
      this.label = paramClass2;
      this.type = paramClass1;
    }

    private Constructor getConstructor(Class paramClass)
      throws Exception
    {
      return this.type.getConstructor(new Class[] { Contact.class, paramClass, Format.class });
    }

    private Constructor getConstructor(Class paramClass1, Class paramClass2)
      throws Exception
    {
      return this.type.getConstructor(new Class[] { Contact.class, paramClass1, paramClass2, Format.class });
    }

    public Constructor getConstructor()
      throws Exception
    {
      if (this.entry != null)
        return getConstructor(this.label, this.entry);
      return getConstructor(this.label);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.LabelExtractor
 * JD-Core Version:    0.6.2
 */