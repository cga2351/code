
import 'package:dailyexpense/model/expense_item.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class ExpenseItemSelectBloc extends Bloc<ExpenseItemSelectEvent, ExpenseItemSelectState> {
  ExpenseItemSelectBloc(ExpenseItemSelectState initialState) : super(initialState);
  // ExpenseItemSelectState get initialState => ExpenseItemSelectState(ExpenseItem(0, 0, "", "", 0, ""));

  @override
  Stream<ExpenseItemSelectState> mapEventToState(ExpenseItemSelectEvent event) async* {
    if(event is ExpenseItemSelectEvent) {
      yield ExpenseItemSelectState(event.expenseItem);
    }
  }
}

// --------------------- event ---------------------
class ExpenseItemSelectEvent {
  ExpenseItem expenseItem;

  ExpenseItemSelectEvent(this.expenseItem);
}

// --------------------- state ---------------------
class ExpenseItemSelectState {

  ExpenseItem expenseItem;

  ExpenseItemSelectState(this.expenseItem);
}

