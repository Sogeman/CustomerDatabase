import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {

  @Output() filterSet = new EventEmitter<boolean>();
  @Output() remove = new EventEmitter();
  @Output() frontendFilter = new EventEmitter<string>();

  constructor() { }

  filterList(activationState: boolean) {
    console.log('filtered by ' + activationState);
    this.filterSet.emit(activationState);
  }

  removeFilter() {
    console.log('filter removed');
    this.remove.emit();
  }

  startFilteringFrontendOnly(searchString: string) {
    this.frontendFilter.emit(searchString);
    console.log(searchString);
  }
}
