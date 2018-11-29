import { Component, OnInit, Output, EventEmitter } from '@angular/core';

export class FilterCriteria {
  activated: boolean;
  name: boolean;
  filterText: string;
}

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  @Output() filterSet = new EventEmitter<FilterCriteria>();
  filterCriteria: FilterCriteria;

  constructor() { }

  ngOnInit() {
    this.filterCriteria = new FilterCriteria();
  }

  filterList() {
    this.filterSet.emit(this.filterCriteria);
    this.filterCriteria = null;
  }

}
