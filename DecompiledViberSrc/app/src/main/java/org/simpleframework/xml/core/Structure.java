package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

class Structure
{
  private final Instantiator factory;
  private final Model model;
  private final boolean primitive;
  private final Label text;
  private final Label version;

  public Structure(Instantiator paramInstantiator, Model paramModel, Label paramLabel1, Label paramLabel2, boolean paramBoolean)
  {
    this.primitive = paramBoolean;
    this.factory = paramInstantiator;
    this.version = paramLabel1;
    this.model = paramModel;
    this.text = paramLabel2;
  }

  public Instantiator getInstantiator()
  {
    return this.factory;
  }

  public Version getRevision()
  {
    if (this.version != null)
      return (Version)this.version.getContact().getAnnotation(Version.class);
    return null;
  }

  public Section getSection()
  {
    return new ModelSection(this.model);
  }

  public Label getText()
  {
    return this.text;
  }

  public Label getVersion()
  {
    return this.version;
  }

  public boolean isPrimitive()
  {
    return this.primitive;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Structure
 * JD-Core Version:    0.6.2
 */