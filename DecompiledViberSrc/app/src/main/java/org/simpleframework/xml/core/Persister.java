package org.simpleframework.xml.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;

public class Persister
  implements Serializer
{
  private final Format format;
  private final SessionManager manager;
  private final Strategy strategy;
  private final Support support;

  public Persister()
  {
    this(new HashMap());
  }

  public Persister(Map paramMap)
  {
    this(new PlatformFilter(paramMap));
  }

  public Persister(Map paramMap, Format paramFormat)
  {
    this(new PlatformFilter(paramMap));
  }

  public Persister(Filter paramFilter)
  {
    this(new TreeStrategy(), paramFilter);
  }

  public Persister(Filter paramFilter, Format paramFormat)
  {
    this(new TreeStrategy(), paramFilter, paramFormat);
  }

  public Persister(Filter paramFilter, Matcher paramMatcher)
  {
    this(new TreeStrategy(), paramFilter, paramMatcher);
  }

  public Persister(Filter paramFilter, Matcher paramMatcher, Format paramFormat)
  {
    this(new TreeStrategy(), paramFilter, paramMatcher, paramFormat);
  }

  public Persister(Strategy paramStrategy)
  {
    this(paramStrategy, new HashMap());
  }

  public Persister(Strategy paramStrategy, Map paramMap)
  {
    this(paramStrategy, new PlatformFilter(paramMap));
  }

  public Persister(Strategy paramStrategy, Map paramMap, Format paramFormat)
  {
    this(paramStrategy, new PlatformFilter(paramMap), paramFormat);
  }

  public Persister(Strategy paramStrategy, Filter paramFilter)
  {
    this(paramStrategy, paramFilter, new Format());
  }

  public Persister(Strategy paramStrategy, Filter paramFilter, Format paramFormat)
  {
    this(paramStrategy, paramFilter, new EmptyMatcher(), paramFormat);
  }

  public Persister(Strategy paramStrategy, Filter paramFilter, Matcher paramMatcher)
  {
    this(paramStrategy, paramFilter, paramMatcher, new Format());
  }

  public Persister(Strategy paramStrategy, Filter paramFilter, Matcher paramMatcher, Format paramFormat)
  {
    this.support = new Support(paramFilter, paramMatcher, paramFormat);
    this.manager = new SessionManager();
    this.strategy = paramStrategy;
    this.format = paramFormat;
  }

  public Persister(Strategy paramStrategy, Format paramFormat)
  {
    this(paramStrategy, new HashMap(), paramFormat);
  }

  public Persister(Strategy paramStrategy, Matcher paramMatcher)
  {
    this(paramStrategy, new PlatformFilter(), paramMatcher);
  }

  public Persister(Strategy paramStrategy, Matcher paramMatcher, Format paramFormat)
  {
    this(paramStrategy, new PlatformFilter(), paramMatcher, paramFormat);
  }

  public Persister(Format paramFormat)
  {
    this(new TreeStrategy(), paramFormat);
  }

  public Persister(Matcher paramMatcher)
  {
    this(new TreeStrategy(), paramMatcher);
  }

  public Persister(Matcher paramMatcher, Format paramFormat)
  {
    this(new TreeStrategy(), paramMatcher, paramFormat);
  }

  private <T> T read(Class<? extends T> paramClass, InputNode paramInputNode, Context paramContext)
    throws Exception
  {
    return new Traverser(paramContext).read(paramInputNode, paramClass);
  }

  private <T> T read(Class<? extends T> paramClass, InputNode paramInputNode, Session paramSession)
    throws Exception
  {
    return read(paramClass, paramInputNode, new Source(this.strategy, this.support, paramSession));
  }

  private <T> T read(T paramT, InputNode paramInputNode, Context paramContext)
    throws Exception
  {
    return new Traverser(paramContext).read(paramInputNode, paramT);
  }

  private <T> T read(T paramT, InputNode paramInputNode, Session paramSession)
    throws Exception
  {
    return read(paramT, paramInputNode, new Source(this.strategy, this.support, paramSession));
  }

  private boolean validate(Class paramClass, InputNode paramInputNode, Context paramContext)
    throws Exception
  {
    return new Traverser(paramContext).validate(paramInputNode, paramClass);
  }

  private boolean validate(Class paramClass, InputNode paramInputNode, Session paramSession)
    throws Exception
  {
    return validate(paramClass, paramInputNode, new Source(this.strategy, this.support, paramSession));
  }

  private void write(Object paramObject, OutputNode paramOutputNode, Context paramContext)
    throws Exception
  {
    new Traverser(paramContext).write(paramOutputNode, paramObject);
  }

  private void write(Object paramObject, OutputNode paramOutputNode, Session paramSession)
    throws Exception
  {
    write(paramObject, paramOutputNode, new Source(this.strategy, this.support, paramSession));
  }

  public <T> T read(Class<? extends T> paramClass, File paramFile)
    throws Exception
  {
    return read(paramClass, paramFile, true);
  }

  public <T> T read(Class<? extends T> paramClass, File paramFile, boolean paramBoolean)
    throws Exception
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      Object localObject2 = read(paramClass, localFileInputStream, paramBoolean);
      return localObject2;
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public <T> T read(Class<? extends T> paramClass, InputStream paramInputStream)
    throws Exception
  {
    return read(paramClass, paramInputStream, true);
  }

  public <T> T read(Class<? extends T> paramClass, InputStream paramInputStream, boolean paramBoolean)
    throws Exception
  {
    return read(paramClass, NodeBuilder.read(paramInputStream), paramBoolean);
  }

  public <T> T read(Class<? extends T> paramClass, Reader paramReader)
    throws Exception
  {
    return read(paramClass, paramReader, true);
  }

  public <T> T read(Class<? extends T> paramClass, Reader paramReader, boolean paramBoolean)
    throws Exception
  {
    return read(paramClass, NodeBuilder.read(paramReader), paramBoolean);
  }

  public <T> T read(Class<? extends T> paramClass, String paramString)
    throws Exception
  {
    return read(paramClass, paramString, true);
  }

  public <T> T read(Class<? extends T> paramClass, String paramString, boolean paramBoolean)
    throws Exception
  {
    return read(paramClass, new StringReader(paramString), paramBoolean);
  }

  public <T> T read(Class<? extends T> paramClass, InputNode paramInputNode)
    throws Exception
  {
    return read(paramClass, paramInputNode, true);
  }

  public <T> T read(Class<? extends T> paramClass, InputNode paramInputNode, boolean paramBoolean)
    throws Exception
  {
    Session localSession = this.manager.open(paramBoolean);
    try
    {
      Object localObject2 = read(paramClass, paramInputNode, localSession);
      return localObject2;
    }
    finally
    {
      this.manager.close();
    }
  }

  public <T> T read(T paramT, File paramFile)
    throws Exception
  {
    return read(paramT, paramFile, true);
  }

  public <T> T read(T paramT, File paramFile, boolean paramBoolean)
    throws Exception
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      Object localObject2 = read(paramT, localFileInputStream, paramBoolean);
      return localObject2;
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public <T> T read(T paramT, InputStream paramInputStream)
    throws Exception
  {
    return read(paramT, paramInputStream, true);
  }

  public <T> T read(T paramT, InputStream paramInputStream, boolean paramBoolean)
    throws Exception
  {
    return read(paramT, NodeBuilder.read(paramInputStream), paramBoolean);
  }

  public <T> T read(T paramT, Reader paramReader)
    throws Exception
  {
    return read(paramT, paramReader, true);
  }

  public <T> T read(T paramT, Reader paramReader, boolean paramBoolean)
    throws Exception
  {
    return read(paramT, NodeBuilder.read(paramReader), paramBoolean);
  }

  public <T> T read(T paramT, String paramString)
    throws Exception
  {
    return read(paramT, paramString, true);
  }

  public <T> T read(T paramT, String paramString, boolean paramBoolean)
    throws Exception
  {
    return read(paramT, new StringReader(paramString), paramBoolean);
  }

  public <T> T read(T paramT, InputNode paramInputNode)
    throws Exception
  {
    return read(paramT, paramInputNode, true);
  }

  public <T> T read(T paramT, InputNode paramInputNode, boolean paramBoolean)
    throws Exception
  {
    Session localSession = this.manager.open(paramBoolean);
    try
    {
      Object localObject2 = read(paramT, paramInputNode, localSession);
      return localObject2;
    }
    finally
    {
      this.manager.close();
    }
  }

  public boolean validate(Class paramClass, File paramFile)
    throws Exception
  {
    return validate(paramClass, paramFile, true);
  }

  public boolean validate(Class paramClass, File paramFile, boolean paramBoolean)
    throws Exception
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      boolean bool = validate(paramClass, localFileInputStream, paramBoolean);
      return bool;
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public boolean validate(Class paramClass, InputStream paramInputStream)
    throws Exception
  {
    return validate(paramClass, paramInputStream, true);
  }

  public boolean validate(Class paramClass, InputStream paramInputStream, boolean paramBoolean)
    throws Exception
  {
    return validate(paramClass, NodeBuilder.read(paramInputStream), paramBoolean);
  }

  public boolean validate(Class paramClass, Reader paramReader)
    throws Exception
  {
    return validate(paramClass, paramReader, true);
  }

  public boolean validate(Class paramClass, Reader paramReader, boolean paramBoolean)
    throws Exception
  {
    return validate(paramClass, NodeBuilder.read(paramReader), paramBoolean);
  }

  public boolean validate(Class paramClass, String paramString)
    throws Exception
  {
    return validate(paramClass, paramString, true);
  }

  public boolean validate(Class paramClass, String paramString, boolean paramBoolean)
    throws Exception
  {
    return validate(paramClass, new StringReader(paramString), paramBoolean);
  }

  public boolean validate(Class paramClass, InputNode paramInputNode)
    throws Exception
  {
    return validate(paramClass, paramInputNode, true);
  }

  public boolean validate(Class paramClass, InputNode paramInputNode, boolean paramBoolean)
    throws Exception
  {
    Session localSession = this.manager.open(paramBoolean);
    try
    {
      boolean bool = validate(paramClass, paramInputNode, localSession);
      return bool;
    }
    finally
    {
      this.manager.close();
    }
  }

  public void write(Object paramObject, File paramFile)
    throws Exception
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      write(paramObject, localFileOutputStream);
      return;
    }
    finally
    {
      localFileOutputStream.close();
    }
  }

  public void write(Object paramObject, OutputStream paramOutputStream)
    throws Exception
  {
    write(paramObject, paramOutputStream, "utf-8");
  }

  public void write(Object paramObject, OutputStream paramOutputStream, String paramString)
    throws Exception
  {
    write(paramObject, new OutputStreamWriter(paramOutputStream, paramString));
  }

  public void write(Object paramObject, Writer paramWriter)
    throws Exception
  {
    write(paramObject, NodeBuilder.write(paramWriter, this.format));
  }

  public void write(Object paramObject, OutputNode paramOutputNode)
    throws Exception
  {
    Session localSession = this.manager.open();
    try
    {
      write(paramObject, paramOutputNode, localSession);
      return;
    }
    finally
    {
      this.manager.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Persister
 * JD-Core Version:    0.6.2
 */