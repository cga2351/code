package org.intellij.lang.annotations;

class PrintFormatPattern
{

  @Language("RegExp")
  private static final String ARG_INDEX = "(?:\\d+\\$)?";

  @Language("RegExp")
  private static final String CONVERSION = "(?:[tT])?(?:[a-zA-Z%])";

  @Language("RegExp")
  private static final String FLAGS = "(?:[-#+ 0,(<]*)?";

  @Language("RegExp")
  private static final String PRECISION = "(?:\\.\\d+)?";

  @Language("RegExp")
  static final String PRINT_FORMAT = "(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*";

  @Language("RegExp")
  private static final String TEXT = "[^%]|%%";

  @Language("RegExp")
  private static final String WIDTH = "(?:\\d+)?";
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.intellij.lang.annotations.PrintFormatPattern
 * JD-Core Version:    0.6.2
 */