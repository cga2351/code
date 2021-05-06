import 'package:flutter/foundation.dart';

class Constants {
  static final String RES_SUCCESS = "success";
  static final String RES_FAILED = "failed";

  // 日期 cell index
  static final int Title_Date_StartCellIndexRow = 1;
  static final int Title_Date_StartCellIndexCol = 1;
  static final int Title_Date_EndCellIndexRow = 3;
  static final int Title_Date_EndCellIndexCol = 1;

  // 支出总计 cell index
  static final int Title_ExpenseTotal_StartCellIndexRow = 1;
  static final int Title_ExpenseTotal_StartCellIndexCol = 2;
  static final int Title_ExpenseTotal_EndCellIndexRow = 3;
  static final int Title_ExpenseTotal_EndCellIndexCol = 2;

  // 支出项目 cell index
  static final int Title_ExpenseItem_StartCellIndexRow = 1;
  static final int Title_ExpenseItem_StartCellIndexCol = 3;
  static final int Title_ExpenseItem_EndCellIndexRow = 1;
  static final int Title_ExpenseItem_EndCellIndexCol = 50;

  // 第一个支出项 cell index
  static final int Title_FirstExpenseItem_StartCellIndexRow = 2;
  static final int Title_FirstExpenseItem_StartCellIndexCol = 3;
  static final int Title_FirstExpenseItem_EndCellIndexRow = 2;
  static final int Title_FirstExpenseItem_EndCellIndexCol = 4;

  static final String expenseTypeFileName = "expenseType.txt";
  // static final String expensesRecordFileSuffix = ".txt";
  static final String expensesRecordFileName = "expenseRecord.txt";
  static final String expensesRecordBackupFileName = "expenseRecord_Bak.txt";

  static final String localDataStorageDir = "/sdcard/yl/testFlutter/dailyExpense/";
  static final String expensesRecordBackupDir = "/sdcard/yl/testFlutter/dailyExpenseBackup/";

  // local int id file
  static final String LocalIntIdFileName = "localIntID.txt";

  // 特殊支出类型，用于表示当日无支出
  static final String SpecialExpenseType_NoExpense = "无支出";

  // http server api
  static final String apiTestUrl = "http://10.34.135.103:8080";
  static final String apiRealUrl = "http://10.34.135.103:8080";
  static final String apiUrl = kDebugMode ? apiTestUrl : apiRealUrl;
  static final String apiGetExpenseItemByServerId =  apiUrl + "/api/dailyExpenseItem/getExpenseItemByServerId";
  static final String apiGetAllExpenseItems =  apiUrl + "/api/dailyExpenseItem/getAllExpenseItems";
  static final String apiAddExpenseItem =  apiUrl + "/api/dailyExpenseItem/addExpenseItem";
  static final String apiAddExpenseItemList =  apiUrl + "/api/dailyExpenseItem/addExpenseItemList";
  static final String apiUpdateExpenseItem =  apiUrl + "/api/dailyExpenseItem/updateExpenseItem";
  static final String apiUpdateExpenseItemList =  apiUrl + "/api/dailyExpenseItem/updateExpenseItemList";
  static final String apiDeleteExpenseItemList =  apiUrl + "/api/dailyExpenseItem/deleteExpenseItemList";
}