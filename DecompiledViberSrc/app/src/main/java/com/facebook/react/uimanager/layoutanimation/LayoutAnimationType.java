package com.facebook.react.uimanager.layoutanimation;

 enum LayoutAnimationType
{
  static
  {
    DELETE = new LayoutAnimationType("DELETE", 2);
    LayoutAnimationType[] arrayOfLayoutAnimationType = new LayoutAnimationType[3];
    arrayOfLayoutAnimationType[0] = CREATE;
    arrayOfLayoutAnimationType[1] = UPDATE;
    arrayOfLayoutAnimationType[2] = DELETE;
  }

  public static String toString(LayoutAnimationType paramLayoutAnimationType)
  {
    switch (1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType[paramLayoutAnimationType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unsupported LayoutAnimationType: " + paramLayoutAnimationType);
    case 1:
      return "create";
    case 2:
      return "update";
    case 3:
    }
    return "delete";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.LayoutAnimationType
 * JD-Core Version:    0.6.2
 */