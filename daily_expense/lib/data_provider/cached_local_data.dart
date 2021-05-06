import 'package:dailyexpense/utils/local_data_storage.dart';

class CachedLocalData {
  static final CachedLocalData _instance = CachedLocalData._internal();
  CachedLocalData._internal(){}
  static CachedLocalData get instance => _instance;

  List<String>? _expenseTypes;

  List<String> get expenseTypes {
    if (null == _expenseTypes) {
      _expenseTypes = LocalDataStorage.instance.readExpenseType();
    }
    return _expenseTypes!;
  }

  void updateExpenseType(List<String> newExpenseType) {
    _expenseTypes = newExpenseType;
  }
}