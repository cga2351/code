package com.facebook.debug.holder;

public class PrinterHolder
{
  private static Printer sPrinter = NoopPrinter.INSTANCE;

  public static Printer getPrinter()
  {
    return sPrinter;
  }

  public static void setPrinter(Printer paramPrinter)
  {
    if (paramPrinter == null)
    {
      sPrinter = NoopPrinter.INSTANCE;
      return;
    }
    sPrinter = paramPrinter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.debug.holder.PrinterHolder
 * JD-Core Version:    0.6.2
 */