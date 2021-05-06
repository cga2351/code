import 'package:dailyexpense/model/expense_item.dart';
import 'package:dailyexpense/utils/local_data_storage.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class ExpenseListBloc extends Bloc<ExpenseListEvent, ExpenseListState> {
  ExpenseListBloc(ExpenseListState initialState) : super(initialState);
  // ExpenseListState get initialState => ExpenseListStateInit();

  @override
  Stream<ExpenseListState> mapEventToState(ExpenseListEvent event) async* {
    if (event is ExpenseListEventInit) {
      print("DailyExpenseListBloc.mapEventToState(), DailyExpenseListEventInit");
      yield ExpenseListStateInit();
    } else if (event is ExpenseListEventUpdateList) {
      print("DailyExpenseListBloc.mapEventToState(), DailyExpenseListEventUpdateList");
      List<ExpenseItem> allExpenseItem = LocalDataStorage.instance.getAllExpenseRecord();
      yield ExpenseListStateUpdateList(allExpenseItem);
    } else if (event is ExpenseListEventNormal) {
      print("DailyExpenseListBloc.mapEventToState(), DailyExpenseListEventNormal");
      yield ExpenseListStateNormal();
    } else {
      print("DailyExpenseListBloc.mapEventToState(), default event");
      yield ExpenseListStateNormal();
    }
  }


}

// --------------------- event ---------------------
abstract class ExpenseListEvent {}

class ExpenseListEventInit extends ExpenseListEvent {

}
class ExpenseListEventUpdateList extends ExpenseListEvent {
  List<ExpenseItem> allExpenseItem;

  ExpenseListEventUpdateList(this.allExpenseItem);
}
class ExpenseListEventNormal extends ExpenseListEvent {

}
// --------------------- state ---------------------
abstract class ExpenseListState {}

class ExpenseListStateInit extends ExpenseListState {

}
class ExpenseListStateUpdateList extends ExpenseListState {
  List<ExpenseItem> allExpenseItem;

  ExpenseListStateUpdateList(this.allExpenseItem);
}
class ExpenseListStateNormal extends ExpenseListState {

}