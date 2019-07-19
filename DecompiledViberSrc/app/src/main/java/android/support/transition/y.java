package android.support.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class y
{
  private static LayoutTransition a;
  private static Field b;
  private static boolean c;
  private static Method d;
  private static boolean e;

  // ERROR //
  private static void a(LayoutTransition paramLayoutTransition)
  {
    // Byte code:
    //   0: getstatic 22	android/support/transition/y:e	Z
    //   3: ifne +28 -> 31
    //   6: ldc 24
    //   8: ldc 26
    //   10: iconst_0
    //   11: anewarray 28	java/lang/Class
    //   14: invokevirtual 32	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   17: putstatic 34	android/support/transition/y:d	Ljava/lang/reflect/Method;
    //   20: getstatic 34	android/support/transition/y:d	Ljava/lang/reflect/Method;
    //   23: iconst_1
    //   24: invokevirtual 40	java/lang/reflect/Method:setAccessible	(Z)V
    //   27: iconst_1
    //   28: putstatic 22	android/support/transition/y:e	Z
    //   31: getstatic 34	android/support/transition/y:d	Ljava/lang/reflect/Method;
    //   34: ifnull +15 -> 49
    //   37: getstatic 34	android/support/transition/y:d	Ljava/lang/reflect/Method;
    //   40: aload_0
    //   41: iconst_0
    //   42: anewarray 4	java/lang/Object
    //   45: invokevirtual 44	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   48: pop
    //   49: return
    //   50: astore 6
    //   52: ldc 46
    //   54: ldc 48
    //   56: invokestatic 54	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   59: pop
    //   60: goto -33 -> 27
    //   63: astore_3
    //   64: ldc 46
    //   66: ldc 48
    //   68: invokestatic 54	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: return
    //   73: astore_1
    //   74: ldc 46
    //   76: ldc 56
    //   78: invokestatic 54	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: return
    //
    // Exception table:
    //   from	to	target	type
    //   6	27	50	java/lang/NoSuchMethodException
    //   37	49	63	java/lang/IllegalAccessException
    //   37	49	73	java/lang/reflect/InvocationTargetException
  }

  static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (a == null)
    {
      a = new LayoutTransition()
      {
        public boolean isChangingLayout()
        {
          return true;
        }
      };
      a.setAnimator(2, null);
      a.setAnimator(0, null);
      a.setAnimator(1, null);
      a.setAnimator(3, null);
      a.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      LayoutTransition localLayoutTransition2 = paramViewGroup.getLayoutTransition();
      if (localLayoutTransition2 != null)
      {
        if (localLayoutTransition2.isRunning())
          a(localLayoutTransition2);
        if (localLayoutTransition2 != a)
          paramViewGroup.setTag(R.id.transition_layout_save, localLayoutTransition2);
      }
      paramViewGroup.setLayoutTransition(a);
    }
    while (true)
    {
      return;
      paramViewGroup.setLayoutTransition(null);
      if (!c);
      try
      {
        b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
        b.setAccessible(true);
        c = true;
        Field localField = b;
        bool = false;
        if (localField == null);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        try
        {
          boolean bool = b.getBoolean(paramViewGroup);
          if (bool)
            b.setBoolean(paramViewGroup, false);
          if (bool)
            paramViewGroup.requestLayout();
          LayoutTransition localLayoutTransition1 = (LayoutTransition)paramViewGroup.getTag(R.id.transition_layout_save);
          if (localLayoutTransition1 == null)
            continue;
          paramViewGroup.setTag(R.id.transition_layout_save, null);
          paramViewGroup.setLayoutTransition(localLayoutTransition1);
          return;
          localNoSuchFieldException = localNoSuchFieldException;
          Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          while (true)
            Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.y
 * JD-Core Version:    0.6.2
 */