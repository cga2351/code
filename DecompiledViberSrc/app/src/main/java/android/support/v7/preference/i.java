package android.support.v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.v14.preference.SwitchPreference;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class i
{
  private static final Class<?>[] a = { Context.class, AttributeSet.class };
  private static final HashMap<String, Constructor> b = new HashMap();
  private final Context c;
  private final Object[] d = new Object[2];
  private j e;
  private String[] f;

  public i(Context paramContext, j paramj)
  {
    this.c = paramContext;
    a(paramj);
  }

  private Preference a(String paramString, String[] paramArrayOfString, AttributeSet paramAttributeSet)
    throws ClassNotFoundException, InflateException
  {
    Constructor localConstructor = (Constructor)b.get(paramString);
    if (localConstructor == null);
    while (true)
    {
      try
      {
        localClassLoader = this.c.getClassLoader();
        if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
        {
          localObject1 = localClassLoader.loadClass(paramString);
          localConstructor = ((Class)localObject1).getConstructor(a);
          localConstructor.setAccessible(true);
          b.put(paramString, localConstructor);
          Object[] arrayOfObject = this.d;
          arrayOfObject[1] = paramAttributeSet;
          return (Preference)localConstructor.newInstance(arrayOfObject);
        }
        int i = paramArrayOfString.length;
        j = 0;
        localObject2 = null;
        if (j < i)
          str = paramArrayOfString[j];
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        Object localObject2;
        try
        {
          ClassLoader localClassLoader;
          String str;
          Class localClass = localClassLoader.loadClass(str + paramString);
          localObject1 = localClass;
          if (localObject1 != null)
            continue;
          if (localObject2 != null)
            continue;
          throw new InflateException(paramAttributeSet.getPositionDescription() + ": Error inflating class " + paramString);
          localClassNotFoundException1 = localClassNotFoundException1;
          throw localClassNotFoundException1;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          int j;
          j++;
          localObject2 = localClassNotFoundException2;
        }
        continue;
        throw localObject2;
      }
      catch (Exception localException)
      {
        InflateException localInflateException = new InflateException(paramAttributeSet.getPositionDescription() + ": Error inflating class " + paramString);
        localInflateException.initCause(localException);
        throw localInflateException;
      }
      Object localObject1 = null;
    }
  }

  private PreferenceGroup a(PreferenceGroup paramPreferenceGroup1, PreferenceGroup paramPreferenceGroup2)
  {
    if (paramPreferenceGroup1 == null)
    {
      paramPreferenceGroup2.a(this.e);
      return paramPreferenceGroup2;
    }
    return paramPreferenceGroup1;
  }

  private void a(j paramj)
  {
    this.e = paramj;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = (Preference.class.getPackage().getName() + ".");
    arrayOfString[1] = (SwitchPreference.class.getPackage().getName() + ".");
    a(arrayOfString);
  }

  private static void a(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    int j;
    do
      j = paramXmlPullParser.next();
    while ((j != 1) && ((j != 3) || (paramXmlPullParser.getDepth() > i)));
  }

  private void a(XmlPullParser paramXmlPullParser, Preference paramPreference, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    while (true)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1))
        break;
      if (j == 2)
      {
        String str = paramXmlPullParser.getName();
        if ("intent".equals(str))
        {
          try
          {
            Intent localIntent = Intent.parseIntent(a().getResources(), paramXmlPullParser, paramAttributeSet);
            paramPreference.a(localIntent);
          }
          catch (IOException localIOException2)
          {
            XmlPullParserException localXmlPullParserException2 = new XmlPullParserException("Error parsing preference");
            localXmlPullParserException2.initCause(localIOException2);
            throw localXmlPullParserException2;
          }
        }
        else if ("extra".equals(str))
        {
          a().getResources().parseBundleExtra("extra", paramAttributeSet, paramPreference.u());
          try
          {
            a(paramXmlPullParser);
          }
          catch (IOException localIOException1)
          {
            XmlPullParserException localXmlPullParserException1 = new XmlPullParserException("Error parsing preference");
            localXmlPullParserException1.initCause(localIOException1);
            throw localXmlPullParserException1;
          }
        }
        else
        {
          Preference localPreference = b(str, paramAttributeSet);
          ((PreferenceGroup)paramPreference).b(localPreference);
          a(paramXmlPullParser, localPreference, paramAttributeSet);
        }
      }
    }
  }

  private Preference b(String paramString, AttributeSet paramAttributeSet)
  {
    try
    {
      if (-1 == paramString.indexOf('.'))
        return a(paramString, paramAttributeSet);
      Preference localPreference = a(paramString, null, paramAttributeSet);
      return localPreference;
    }
    catch (InflateException localInflateException3)
    {
      throw localInflateException3;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      InflateException localInflateException2 = new InflateException(paramAttributeSet.getPositionDescription() + ": Error inflating class (not found)" + paramString);
      localInflateException2.initCause(localClassNotFoundException);
      throw localInflateException2;
    }
    catch (Exception localException)
    {
      InflateException localInflateException1 = new InflateException(paramAttributeSet.getPositionDescription() + ": Error inflating class " + paramString);
      localInflateException1.initCause(localException);
      throw localInflateException1;
    }
  }

  public Context a()
  {
    return this.c;
  }

  public Preference a(int paramInt, PreferenceGroup paramPreferenceGroup)
  {
    XmlResourceParser localXmlResourceParser = a().getResources().getXml(paramInt);
    try
    {
      Preference localPreference = a(localXmlResourceParser, paramPreferenceGroup);
      return localPreference;
    }
    finally
    {
      localXmlResourceParser.close();
    }
  }

  protected Preference a(String paramString, AttributeSet paramAttributeSet)
    throws ClassNotFoundException
  {
    return a(paramString, this.f, paramAttributeSet);
  }

  public Preference a(XmlPullParser paramXmlPullParser, PreferenceGroup paramPreferenceGroup)
  {
    AttributeSet localAttributeSet;
    synchronized (this.d)
    {
      localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
      this.d[0] = this.c;
    }
    try
    {
      int i;
      do
        i = paramXmlPullParser.next();
      while ((i != 2) && (i != 1));
      if (i != 2)
        throw new InflateException(paramXmlPullParser.getPositionDescription() + ": No start tag found!");
    }
    catch (InflateException localInflateException3)
    {
      throw localInflateException3;
      localObject = finally;
      throw localObject;
      PreferenceGroup localPreferenceGroup = a(paramPreferenceGroup, (PreferenceGroup)b(paramXmlPullParser.getName(), localAttributeSet));
      a(paramXmlPullParser, localPreferenceGroup, localAttributeSet);
      return localPreferenceGroup;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      InflateException localInflateException2 = new InflateException(localXmlPullParserException.getMessage());
      localInflateException2.initCause(localXmlPullParserException);
      throw localInflateException2;
    }
    catch (IOException localIOException)
    {
      InflateException localInflateException1 = new InflateException(paramXmlPullParser.getPositionDescription() + ": " + localIOException.getMessage());
      localInflateException1.initCause(localIOException);
      throw localInflateException1;
    }
  }

  public void a(String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.i
 * JD-Core Version:    0.6.2
 */