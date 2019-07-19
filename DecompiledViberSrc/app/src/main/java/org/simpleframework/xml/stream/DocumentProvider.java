package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;

class DocumentProvider
  implements Provider
{
  private final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

  public DocumentProvider()
  {
    this.factory.setNamespaceAware(true);
  }

  private EventReader provide(InputSource paramInputSource)
    throws Exception
  {
    return new DocumentReader(this.factory.newDocumentBuilder().parse(paramInputSource));
  }

  public EventReader provide(InputStream paramInputStream)
    throws Exception
  {
    return provide(new InputSource(paramInputStream));
  }

  public EventReader provide(Reader paramReader)
    throws Exception
  {
    return provide(new InputSource(paramReader));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.DocumentProvider
 * JD-Core Version:    0.6.2
 */