package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.d;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater
{
  private static final String LOG_TAG = "AppCompatViewInflater";
  private static final String[] sClassPrefixList = { "android.widget.", "android.view.", "android.webkit." };
  private static final Map<String, Constructor<? extends View>> sConstructorMap = new ArrayMap();
  private static final Class<?>[] sConstructorSignature = { Context.class, AttributeSet.class };
  private static final int[] sOnClickAttrs = { 16843375 };
  private final Object[] mConstructorArgs = new Object[2];

  private void checkOnClickListener(View paramView, AttributeSet paramAttributeSet)
  {
    Context localContext = paramView.getContext();
    if ((!(localContext instanceof ContextWrapper)) || ((Build.VERSION.SDK_INT >= 15) && (!ViewCompat.hasOnClickListeners(paramView))))
      return;
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, sOnClickAttrs);
    String str = localTypedArray.getString(0);
    if (str != null)
      paramView.setOnClickListener(new a(paramView, str));
    localTypedArray.recycle();
  }

  private View createViewByPrefix(Context paramContext, String paramString1, String paramString2)
    throws ClassNotFoundException, InflateException
  {
    Constructor localConstructor = (Constructor)sConstructorMap.get(paramString1);
    if (localConstructor == null);
    try
    {
      ClassLoader localClassLoader = paramContext.getClassLoader();
      if (paramString2 != null);
      for (String str = paramString2 + paramString1; ; str = paramString1)
      {
        localConstructor = localClassLoader.loadClass(str).asSubclass(View.class).getConstructor(sConstructorSignature);
        sConstructorMap.put(paramString1, localConstructor);
        localConstructor.setAccessible(true);
        View localView = (View)localConstructor.newInstance(this.mConstructorArgs);
        return localView;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    if (paramString.equals("view"))
      paramString = paramAttributeSet.getAttributeValue(null, "class");
    try
    {
      this.mConstructorArgs[0] = paramContext;
      this.mConstructorArgs[1] = paramAttributeSet;
      if (-1 == paramString.indexOf('.'))
      {
        for (int i = 0; i < sClassPrefixList.length; i++)
        {
          View localView1 = createViewByPrefix(paramContext, paramString, sClassPrefixList[i]);
          if (localView1 != null)
            return localView1;
        }
        return null;
      }
      View localView2 = createViewByPrefix(paramContext, paramString, null);
      return localView2;
    }
    catch (Exception localException)
    {
      return null;
    }
    finally
    {
      this.mConstructorArgs[0] = null;
      this.mConstructorArgs[1] = null;
    }
  }

  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    if (paramBoolean1);
    for (int i = localTypedArray.getResourceId(R.styleable.View_android_theme, 0); ; i = 0)
    {
      if ((paramBoolean2) && (i == 0))
      {
        i = localTypedArray.getResourceId(R.styleable.View_theme, 0);
        if (i != 0)
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
      }
      int j = i;
      localTypedArray.recycle();
      if ((j != 0) && ((!(paramContext instanceof d)) || (((d)paramContext).a() != j)))
        paramContext = new d(paramContext, j);
      return paramContext;
    }
  }

  private void verifyNotNull(View paramView, String paramString)
  {
    if (paramView == null)
      throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + paramString + ">, but returned null");
  }

  protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatAutoCompleteTextView(paramContext, paramAttributeSet);
  }

  protected AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatButton(paramContext, paramAttributeSet);
  }

  protected AppCompatCheckBox createCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatCheckBox(paramContext, paramAttributeSet);
  }

  protected AppCompatCheckedTextView createCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatCheckedTextView(paramContext, paramAttributeSet);
  }

  protected AppCompatEditText createEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatEditText(paramContext, paramAttributeSet);
  }

  protected AppCompatImageButton createImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatImageButton(paramContext, paramAttributeSet);
  }

  protected AppCompatImageView createImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatImageView(paramContext, paramAttributeSet);
  }

  protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatMultiAutoCompleteTextView(paramContext, paramAttributeSet);
  }

  protected AppCompatRadioButton createRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatRadioButton(paramContext, paramAttributeSet);
  }

  protected AppCompatRatingBar createRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatRatingBar(paramContext, paramAttributeSet);
  }

  protected AppCompatSeekBar createSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatSeekBar(paramContext, paramAttributeSet);
  }

  protected AppCompatSpinner createSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatSpinner(paramContext, paramAttributeSet);
  }

  protected AppCompatTextView createTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatTextView(paramContext, paramAttributeSet);
  }

  protected View createView(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    return null;
  }

  final View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (paramView != null));
    for (Context localContext = paramView.getContext(); ; localContext = paramContext)
    {
      if ((paramBoolean2) || (paramBoolean3))
        localContext = themifyContext(localContext, paramAttributeSet, paramBoolean2, paramBoolean3);
      if (paramBoolean4)
        localContext = TintContextWrapper.wrap(localContext);
      int i = -1;
      Object localObject1;
      switch (paramString.hashCode())
      {
      default:
        switch (i)
        {
        default:
          localObject1 = createView(localContext, paramString, paramAttributeSet);
          label251: if ((localObject1 != null) || (paramContext == localContext));
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        }
        break;
      case -938935918:
      case 1125864064:
      case 2001146706:
      case 1666676343:
      case -339785223:
      case -937446323:
      case 1601505219:
      case 776382189:
      case -1455429095:
      case 1413872058:
      case -1346021293:
      case -1946472170:
      case -658531749:
      }
      for (Object localObject2 = createViewFromTag(localContext, paramString, paramAttributeSet); ; localObject2 = localObject1)
      {
        if (localObject2 != null)
          checkOnClickListener((View)localObject2, paramAttributeSet);
        return localObject2;
        if (!paramString.equals("TextView"))
          break;
        i = 0;
        break;
        if (!paramString.equals("ImageView"))
          break;
        i = 1;
        break;
        if (!paramString.equals("Button"))
          break;
        i = 2;
        break;
        if (!paramString.equals("EditText"))
          break;
        i = 3;
        break;
        if (!paramString.equals("Spinner"))
          break;
        i = 4;
        break;
        if (!paramString.equals("ImageButton"))
          break;
        i = 5;
        break;
        if (!paramString.equals("CheckBox"))
          break;
        i = 6;
        break;
        if (!paramString.equals("RadioButton"))
          break;
        i = 7;
        break;
        if (!paramString.equals("CheckedTextView"))
          break;
        i = 8;
        break;
        if (!paramString.equals("AutoCompleteTextView"))
          break;
        i = 9;
        break;
        if (!paramString.equals("MultiAutoCompleteTextView"))
          break;
        i = 10;
        break;
        if (!paramString.equals("RatingBar"))
          break;
        i = 11;
        break;
        if (!paramString.equals("SeekBar"))
          break;
        i = 12;
        break;
        localObject1 = createTextView(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createImageView(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createButton(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createEditText(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createSpinner(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createImageButton(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createCheckBox(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createRadioButton(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createCheckedTextView(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createAutoCompleteTextView(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createMultiAutoCompleteTextView(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createRatingBar(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
        localObject1 = createSeekBar(localContext, paramAttributeSet);
        verifyNotNull((View)localObject1, paramString);
        break label251;
      }
    }
  }

  private static class a
    implements View.OnClickListener
  {
    private final View a;
    private final String b;
    private Method c;
    private Context d;

    public a(View paramView, String paramString)
    {
      this.a = paramView;
      this.b = paramString;
    }

    private void a(Context paramContext, String paramString)
    {
      Context localContext = paramContext;
      while (localContext != null)
        try
        {
          if (!localContext.isRestricted())
          {
            Method localMethod = localContext.getClass().getMethod(this.b, new Class[] { View.class });
            if (localMethod != null)
            {
              this.c = localMethod;
              this.d = localContext;
              return;
            }
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          if ((localContext instanceof ContextWrapper))
            localContext = ((ContextWrapper)localContext).getBaseContext();
          else
            localContext = null;
        }
      int i = this.a.getId();
      if (i == -1);
      for (String str = ""; ; str = " with id '" + this.a.getContext().getResources().getResourceEntryName(i) + "'")
        throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.a.getClass() + str);
    }

    public void onClick(View paramView)
    {
      if (this.c == null)
        a(this.a.getContext(), this.b);
      try
      {
        this.c.invoke(this.d, new Object[] { paramView });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new IllegalStateException("Could not execute method for android:onClick", localInvocationTargetException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatViewInflater
 * JD-Core Version:    0.6.2
 */