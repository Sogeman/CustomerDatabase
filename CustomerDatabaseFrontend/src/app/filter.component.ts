import { Component, Output, EventEmitter, Input } from '@angular/core';
import { CustomerListComponent } from './customer-list.component';

export class FilterCriteria {
  filterByStatus = null;
  filterString = null;
}

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {

  @Output() filterSet = new EventEmitter<FilterCriteria>();
  @Output() remove = new EventEmitter();
  filter = new FilterCriteria;

  constructor() { }

  filterList() {
    console.log(this.filter.filterByStatus + ' ' + this.filter.filterString);
    this.filterSet.emit(this.filter);
  }

  setFilterStringNull() {
      this.filter.filterString = null;
  }

  removeFilter() {
    this.remove.emit();
    this.filter.filterByStatus = null;
    this.setFilterStringNull();
  }

}
